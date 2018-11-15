package com.bargains.task;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Controller;

@Controller
public class ProduceHtmlTask {

    public void produceHtml() {
//        String url = "http://127.0.0.1:8080/pageHome/produceHtml";
//
//        CloseableHttpClient client = HttpClients.createDefault();
//        HttpGet httpGet = new HttpGet(url);
//        CloseableHttpResponse response = null;
//
//        try {
//            response = client.execute(httpGet);
//            System.out.println("produce html task ==" + response.getStatusLine().getStatusCode());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        System.out.println("produce html succeed !");
    }
}
