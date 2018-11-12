package com.bargains.controller;

import com.bargains.entity.BargainsEntity;
import com.bargains.entity.MerchantEntity;
import com.bargains.entity.OrderEntity;
import com.bargains.entity.UserEntity;
import com.bargains.service.BargainsService;
import com.bargains.service.OrderService;
import com.bargains.service.pay.AliPay;
import com.bargains.service.pay.UnionPay;
import com.bargains.service.pay.WeChatPay;
import com.bargains.service.redis.BargainsRedisService;
import com.bargains.service.redis.OrderRedisService;
import com.bargains.vo.order.CustomOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    BargainsService bargainsService;

    @Autowired
    WeChatPay weChatPay;

    @Autowired
    UnionPay unionPay;

    @Autowired
    AliPay aliPay;

    @Autowired
    private BargainsRedisService bargainsRedisService;

    @Autowired
    private OrderRedisService orderRedisService;

    @RequestMapping("payOrder")
    public String payOrder(HttpServletRequest req, CustomOrder msorder) {
        String returnurl = "redirect:/pageHome/toHome";
        HttpSession sess = req.getSession();
        UserEntity userEntity = (UserEntity) sess.getAttribute("user");
        if (userEntity != null) {
            Map<String, Object> resultmap = orderRedisService.snatchBargains(userEntity.getId(), msorder.getProductId(), msorder);
            boolean issuccess = (Boolean) resultmap.get("success");
            if (issuccess) {
                System.out.println("pay order succeed");
                Map<String, String> datamap = (Map<String, String>) resultmap.get("datamap");
                String merchantid = datamap.get("merchantId");
                String payamount = datamap.get("payAmount");
                String tradeserialnumber = datamap.get("tradeSerialNumber");
                String productid = datamap.get("productId");
                String userid = datamap.get("userId");

                returnurl = "redirect:toPayWithOrder?userId=" + userid + "&&productId=" + productid + "&&tradeSerialNumber=" + tradeserialnumber + "&&payAmount=" + payamount + "&&merchantId=" + merchantid;
            } else {
                System.out.println("pay order failed");
            }
        } else {
            req.setAttribute("error", "login status invalid");
            returnurl = "user/to_login";
        }
        return returnurl;

    }


    @RequestMapping("toPayOrder")
    public String toPayOrder(HttpServletRequest req, int id, int num) {
        BargainsEntity bargainsEntity = bargainsRedisService.queryBargainsById(id);
        req.setAttribute("bargains", bargainsEntity);
        req.setAttribute("productNum", num);
        BigDecimal payamount = bargainsEntity.getBargainsPrice().multiply(BigDecimal.valueOf(num));
        req.setAttribute("payAmount", payamount);
        HttpSession sess = req.getSession();
        UserEntity userEntity = (UserEntity) sess.getAttribute("user");
        if (userEntity != null) {
            req.setAttribute("userId", userEntity.getId());
        } else {
            req.setAttribute("error", "user info invalid");
            return "user/to_login";
        }
        return "order/pay_order";

    }

    @RequestMapping("queryOrderByUserId")
    public String queryOrderByUserId(HttpServletRequest req) {
        String returnUrl = "order/list_order";
        HttpSession session = req.getSession();
        UserEntity userEntity = (UserEntity) session.getAttribute("user");
        if (userEntity != null) {
            List<OrderEntity> list = orderRedisService.queryOrderByUserId(userEntity.getId());
            req.setAttribute("list", list);
        } else {
            req.setAttribute("error", "user info invalid");
            returnUrl = "user/to_login";
        }

        return returnUrl;

    }


    @RequestMapping("queryOrderByMerchanId")
    public String queryOrderByMerchanId(HttpServletRequest req) {
        String returnurl = "order/list_order_with_merchat";
        HttpSession sess = req.getSession();
        MerchantEntity merchantEntity = (MerchantEntity) sess.getAttribute("merchantEntity");
        if (merchantEntity != null) {
            List<OrderEntity> list = orderService.queryOrderByMerchantId(merchantEntity.getId());
            req.setAttribute("list", list);
        } else {
            req.setAttribute("error", "merchant info invalid");
            returnurl = "merchant/to_login";
        }

        return returnurl;

    }

    @RequestMapping("toPayWithOrder")
    public String topaywithorder(HttpServletRequest req, int userid, int productid, int merchantid, String tradeserialnumber, int payamount) {
        req.setAttribute("userId", userid);
        req.setAttribute("productId", productid);
        req.setAttribute("merchantId", merchantid);
        req.setAttribute("tradeSerialNumber", tradeserialnumber);
        req.setAttribute("payAmount", payamount);
        return "order/pay_real";

    }

    @RequestMapping(value = "payWithOrder", method = RequestMethod.POST)
    public String payWithOrder(HttpServletRequest req, int paytype, int userid, int productid, int merchantid, String tradeserialnumber, int payamount) {
        int payStatus = 2;
        if (paytype == 1) {
            payStatus = aliPay.payWithOrder(tradeserialnumber, payamount);
        } else if (paytype == 2) {
            payStatus = weChatPay.payWithOrder(tradeserialnumber, payamount);
        } else if (paytype == 3) {
            payStatus = unionPay.payWithOrder(tradeserialnumber, payamount);
        }
        if (payStatus == 1) {
            boolean isSuccess = orderRedisService.payOrder(paytype, userid, productid, merchantid, tradeserialnumber, payamount);
            if (isSuccess) {
                System.out.println("pay with order succeed");
            } else {
                System.out.println("pay with order failed");
            }
        }
        return "redirect:queryOrderByUserId";

    }

    @RequestMapping("applyRefund")
    public String applyRefund(HttpServletRequest req, int orderid, int paytype) {
        String returnurl = "redirect:queryOrderByUserId";
        HttpSession sess = req.getSession();
        UserEntity userEntity = (UserEntity) sess.getAttribute("userEntity");
        if (userEntity != null) {
            orderService.updateOrderPayStatusById(4, orderid, paytype);
        } else {
            req.setAttribute("error", "user info invalid");
            returnurl = "user/to_login";
        }

        return returnurl;
    }

    @RequestMapping("auditRefund")
    public String auditRefund(HttpServletRequest req, String tradeserialnumber, int payamount, int orderid, int paytype, int paystatus) {
        String returnUrl = "redirect:queryOrderByMerchantId";
        HttpSession session = req.getSession();
        MerchantEntity merchantEntity = (MerchantEntity) session.getAttribute("merchantEntity");
        if (merchantEntity != null) {
            if (paystatus == 3) {
                int paystatustemp = 2;
                if (paytype == 1) {
                    paystatustemp = aliPay.refundWithOrder(tradeserialnumber, payamount);
                } else if (paytype == 2) {
                    paystatustemp = weChatPay.refundWithOrder(tradeserialnumber, payamount);
                } else if (paytype == 3) {
                    paystatustemp = unionPay.refundWithOrder(tradeserialnumber, payamount);
                }
                if (paystatustemp == 1) {
                    orderService.updateOrderPayStatusById(paystatus, orderid, paytype);
                }

            } else if (paystatus == 5) {
                orderService.updateOrderPayStatusById(paystatus, orderid, paytype);
            }
        } else {
            req.setAttribute("error", "audit refund faild : merchant info invalid");
            returnUrl = "merchant/to_login";
        }

        return returnUrl;
    }
}
