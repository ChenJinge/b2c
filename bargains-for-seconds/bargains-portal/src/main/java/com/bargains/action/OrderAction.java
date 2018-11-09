package com.bargains.action;

import com.bargains.enity.BargainsEntity;
import com.bargains.enity.MerchantEntity;
import com.bargains.enity.OrderEntity;
import com.bargains.enity.UserEntity;
import com.bargains.service.BargainsService;
import com.bargains.service.OrderService;
import com.bargains.service.pay.UnionPay;
import com.bargains.service.pay.WeChatPay;
import com.bargains.service.pay.AliPay;
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
@RequestMapping("orderAction")
public class OrderAction {

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

    @RequestMapping("payorder")
    public String payorder(HttpServletRequest req, CustomOrder msorder) {
        String returnurl = "redirect:/pagehomeAction/tohome";
        HttpSession sess = req.getSession();
        UserEntity userEntity = (UserEntity) sess.getAttribute("userEntity");
        if (userEntity != null) {
            Map<String, Object> resultmap = orderRedisService.seckill(userEntity.getId(), msorder.getProductId(), msorder);
            boolean issuccess = (Boolean) resultmap.get("success");
            if (issuccess) {
                System.out.println("��ɱ�ɹ�");
                Map<String, String> datamap = (Map<String, String>) resultmap.get("datamap");
                String merchantid = datamap.get("merchantid");
                String payamount = datamap.get("payamount");
                String tradeserialnumber = datamap.get("tradeserialnumber");
                String productid = datamap.get("productid");
                String userid = datamap.get("userid");

                returnurl = "redirect:topaywithorder?userid=" + userid + "&&productid=" + productid + "&&tradeserialnumber=" + tradeserialnumber + "&&payamount=" + payamount + "&&merchantid=" + merchantid;
            } else {
                System.out.println("��ɱʧ��");
            }
        } else {
            req.setAttribute("error", "δ��¼");
            returnurl = "user/tologin";
        }
        return returnurl;

    }


    @RequestMapping("topayorder")
    public String topayorder(HttpServletRequest req, int id, int num) {
        BargainsEntity bargainsEntity = bargainsRedisService.queryBargainsById(id);
        req.setAttribute("bargainsEntity", bargainsEntity);
        req.setAttribute("productnum", num);
        BigDecimal payamount = bargainsEntity.getBargainsPrice().multiply(BigDecimal.valueOf(num));
        req.setAttribute("payamount", payamount);
        HttpSession sess = req.getSession();
        UserEntity userEntity = (UserEntity) sess.getAttribute("userEntity");
        if (userEntity != null) {
            req.setAttribute("msuserid", userEntity.getId());
        } else {
            req.setAttribute("error", "δ��¼");
            return "user/tologin";
        }
        return "order/payorder";

    }

    @RequestMapping("queryorderbyuserid")
    public String queryorderbyuserid(HttpServletRequest req) {
        String returnurl = "order/listOrder";
        HttpSession sess = req.getSession();
        UserEntity userEntity = (UserEntity) sess.getAttribute("userEntity");
        if (userEntity != null) {
            List<OrderEntity> list = orderRedisService.queryorderbyuserid(userEntity.getId());
            req.setAttribute("list", list);
        } else {
            req.setAttribute("error", "δ��½");
            returnurl = "user/tologin";
        }

        return returnurl;

    }


    @RequestMapping("queryorderbyMsmerchanid")
    public String queryorderbyMsmerchanid(HttpServletRequest req) {
        String returnurl = "order/listOrderwithmerchat";
        HttpSession sess = req.getSession();
        MerchantEntity merchantEntity = (MerchantEntity) sess.getAttribute("merchantEntity");
        if (merchantEntity != null) {
            List<OrderEntity> list = orderService.queryOrderByMerchantId(merchantEntity.getId());
            req.setAttribute("list", list);
        } else {
            req.setAttribute("error", "δ��½");
            returnurl = "merchantEntity/tologin";
        }

        return returnurl;

    }

    @RequestMapping("topaywithorder")
    public String topaywithorder(HttpServletRequest req, int userid, int productid, int merchantid, String tradeserialnumber, int payamount) {
        req.setAttribute("userid", userid);
        req.setAttribute("productid", productid);
        req.setAttribute("merchantid", merchantid);
        req.setAttribute("tradeserialnumber", tradeserialnumber);
        req.setAttribute("payamount", payamount);
        return "order/payreal";

    }

    @RequestMapping(value = "paywithorder", method = RequestMethod.POST)
    public String paywithorder(HttpServletRequest req, int paytype, int userid, int productid, int merchantid, String tradeserialnumber, int payamount) {
        int paystatus = 2;
        if (paytype == 1) {//1����֧����
            paystatus = aliPay.payWithOrder(tradeserialnumber, payamount);
        } else if (paytype == 2) {//2����΢��
            paystatus = weChatPay.payWithOrder(tradeserialnumber, payamount);
        } else if (paytype == 3) {//3�Ǵ�������
            paystatus = unionPay.payWithOrder(tradeserialnumber, payamount);
        }
        if (paystatus == 1) {
            boolean issuccess = orderRedisService.payorder(paytype, userid, productid, merchantid, tradeserialnumber, payamount);
            if (issuccess) {
                System.out.println("֧���ɹ�");
            } else {
                System.out.println("����ʧ��");
            }
        }
        return "redirect:queryOrderByUserId";

    }

    @RequestMapping("applyrefund")
    public String applyrefund(HttpServletRequest req, int orderid, int paytype) {
        String returnurl = "redirect:queryOrderByUserId";
        HttpSession sess = req.getSession();
        UserEntity userEntity = (UserEntity) sess.getAttribute("userEntity");
        if (userEntity != null) {
            orderService.updateOrderPayStatusById(4, orderid, paytype);
        } else {
            req.setAttribute("error", "δ��½");
            returnurl = "user/tologin";
        }

        return returnurl;
    }

    @RequestMapping("auditrefund")
    public String auditrefund(HttpServletRequest req, String tradeserialnumber, int payamount, int orderid, int paytype, int paystatus) {
        String returnurl = "redirect:queryorderbyMsmerchanid";
        HttpSession sess = req.getSession();
        MerchantEntity merchantEntity = (MerchantEntity) sess.getAttribute("merchantEntity");
        if (merchantEntity != null) {
            if (paystatus == 3) {
                int paystatustemp = 2;
                if (paytype == 1) {//1����֧����
                    paystatustemp = aliPay.refundWithOrder(tradeserialnumber, payamount);
                } else if (paytype == 2) {//2����΢��
                    paystatustemp = weChatPay.refundWithOrder(tradeserialnumber, payamount);
                } else if (paytype == 3) {//3�Ǵ�������
                    paystatustemp = unionPay.refundWithOrder(tradeserialnumber, payamount);
                }
                if (paystatustemp == 1) {
                    orderService.updateOrderPayStatusById(paystatus, orderid, paytype);
                }

            } else if (paystatus == 5) {
                orderService.updateOrderPayStatusById(paystatus, orderid, paytype);
            }
        } else {
            req.setAttribute("error", "δ��½");
            returnurl = "merchantEntity/tologin";
        }

        return returnurl;
    }
}
