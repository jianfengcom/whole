package cn.wolfcode.website.test;

import cn.wolfcode.website.util.RandomUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.junit.Test;

import java.io.IOException;

public class ApiTest {

    @Test
    public void testUnReport() {
        String nonce = RandomUtil.getRandomString();

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:9991/api/v1/app/unreport.do");
        httpPost.setHeader("Content-Type", "application/json; charset=utf-8");
        long current = System.currentTimeMillis() / 1000;
        httpPost.setHeader("timestamp", current + "");
        httpPost.setHeader("nonce", nonce);

        String body = "{\"sign\":\"4868392b58f154f98851735e9aa034799f5c485fbfc7725ddce9d66f66e0cdcb65f9da580525ba95ed729d1e8e8c7e140d3209d3057ce05aa3fa7a22a2fbc2d6d6f47a235725f8b51732934a45dcc0417f015cf0f02a8f111d4a1a94c610bc0f3c9b08e1181ee1f157ddc55e31db9bc4bcd5b980cf63f27eee7c9d8d6221db2b93374aaa80d35f171006bf5803ef60c2a59b1548424a4dc65bc5c7763a5ec49108b59a9b38009a13e49ad4c35b5fb271bfa4b5ca362e916ebc155592627688a77c0ada2331145a86e3038af99ef2a796cdb2dd46b72d20501803d52722d7467b9da5956a76fb1155ee55ed60d5ecd6b8599875ddb739fd0801aebf554abc2c3c\",\"payload\":\"[{\\\"identifier\\\":\\\"jp.gungho.pad\\\",\\\"appName\\\":\\\"智龙迷城\\\",\\\"appDownloadUrl\\\":\\\"http://localhost\\\",\\\"discoveryTime\\\":\\\"2020-05-12 10:10:40\\\"}]\"}";
        httpPost.setEntity(new StringEntity(body, "UTF-8"));

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String ret = EntityUtils.toString(entity, "UTF-8");
            System.out.println("##ret=");
            System.out.println(ret);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
