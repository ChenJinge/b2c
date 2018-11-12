package com.bargains.controller;

import com.bargains.entity.BargainsEntity;
import com.bargains.entity.ProductEntity;
import com.bargains.entity.UserEntity;
import com.bargains.service.BargainsService;
import com.bargains.service.redis.ProductRedisService;
import com.bargains.service.redis.BargainsRedisService;
import com.bargains.vo.bargains.BargainsVo;
import com.bargains.vo.bargains.CustomBargains;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("pageHome")
public class PageHomeController {

    @Autowired
    private BargainsService bargainsService;

    @Autowired
    private BargainsRedisService bargainsRedisService;

    @Autowired
    private ProductRedisService productRedisService;

    @RequestMapping("toHome")
    public String toHome(HttpServletRequest req) {
        BargainsVo bargainsVo = new BargainsVo();
        CustomBargains customBargains = new CustomBargains();
        Date now = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowstring = dateFormat.format(now);
        customBargains.setStartEndTime(nowstring);
        customBargains.setAuditStatus(2);
        bargainsVo.setCustomBargains(customBargains);
        bargainsVo.setCustomBargains(customBargains);
        List<BargainsEntity> list = bargainsService.listProduct(bargainsVo);
        req.setAttribute("list", list);
        return "home_page/home_page";
    }

    @RequestMapping("viewProduct")
    public String viewProduct(HttpServletRequest req, int id) {
        BargainsEntity msproduct = bargainsRedisService.queryBargainsById(id);
        ProductEntity productEntity = productRedisService.queryProductById(id);
        req.setAttribute("bargains", msproduct);
        req.setAttribute("product", productEntity);
        return "order/sell_detail";
    }

    @RequestMapping("producehtml")
    public void producehtml(HttpServletRequest req) {
        String htmlPath = req.getRealPath("/WEB-INF/html/");
        String contextpath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
        contextpath = contextpath + "/pagehomeAction/tohome";

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(contextpath);
        CloseableHttpResponse response = null;

        try {
            response = client.execute(httpGet);

            System.out.println(response.getStatusLine().getStatusCode());
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String html = EntityUtils.toString(entity);
                File file = new File(htmlPath + "/index.html");//�浽Ӧ�õ�htmlPathĿ¼��
                Writer writer = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(file), "utf-8"));
                writer.write(html);
                writer.flush();
                writer.close();
            }
            EntityUtils.consume(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("producejs")
    public void producejs(HttpServletRequest req) {
        String jsPath = req.getRealPath("/WEB-INF/classes/js");
        String jscontent = "function remaintime(){" + "\n" +
                "var starttime = $(\"#starttime\").html();" + "\n" +
                "var s1 = new Date(starttime.replace(\"/-/g\",\"/\"));" + "\n" +
                "var s2 = new Date();" + "\n" +
                "var date3 = s1.getTime() - s2.getTime();//����һ�����ʱ���" + "\n" +
                "if(date3 > 2){" + "\n" +
                "$(\"#sellbnt\").attr({\"disabled\":\"disabled\"});" + "\n" +
                "var days = Math.floor(date3/(24*3600*1000));" + "\n" +
                "var leave = date3%(24*3600*1000)" + "\n" +
                "var hours = Math.floor(leave/(3600*1000));" + "\n" +
                "var leave1 = leave%(3600*1000)" + "\n" +
                "var minutes = Math.floor(leave1/(60*1000));" + "\n" +
                "var leave2 = leave1%(60*1000)" + "\n" +
                "var seconds = Math.floor(leave2/1000)" + "\n" +
                "$(\"#remainnoties\").html(\"��� \"+days+\" ��\"+ hours + \" Сʱ\" + minutes + \" ����\"+seconds+\"��\");" + "\n" +
                "}else{" + "\n" +
                "$(\"#remainnoties\").html(\"\");" + "\n" +
                "$(\"#sellbnt\").removeAttr(\"disabled\");" + "\n" +
                "$(\"#sellbnt\").parent().attr(\"controller\",\"/YF_MS_WEB/orderAction/topayorder\");" + "\n" +
                "}" + "\n" +
                "}" + "\n" +
                "// test js new " + "\n" +
                "setInterval('remaintime()',500);";
        File file = new File(jsPath + "/remain.js");//�浽Ӧ�õ�htmlPathĿ¼��
        Writer writer = null;
        try {
            writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(file), "utf-8"));
            writer.write(jscontent);
            writer.flush();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (writer != null)
                try {
                    writer.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }

    }

    @RequestMapping("getUser")
    @ResponseBody
    public String getUser(HttpServletRequest req) {
        HttpSession sess = req.getSession();
        UserEntity user = (UserEntity) sess.getAttribute("user");
        String account = "";
        if (user != null) {
            account = user.getAccount();
        }
        return account;

    }


}
