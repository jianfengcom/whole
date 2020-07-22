package cn.wolfcode.website.web.controller;

import cn.wolfcode.website.util.SkipHttpsUtil;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HelloController {
    @Value("${test.hot.deploy}")
    private String restart;

    @RequestMapping("hello")
    public String hello() {
//        return "hello";
        return "redirect:rd";
    }

    // forward: 该关键字表示不再经过视图解析器
    @RequestMapping("forwardView")
    public String forwardView() {
        return "forward:/WEB-INF/jsp/forwardView.jsp";
    }

    @RequestMapping("request")
    public void request(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 当使用请求转发时，新的servlet的requset和resp是来自于上一个的servlet的requset和resp
        request.setAttribute("msg", "今天也要加油鸭");
        request.getRequestDispatcher("/WEB-INF/jsp/forwardView.jsp").forward(request, response);
    }

    @RequestMapping("rd")
    public String rd() {
        return "redirect";
    }

    @RequestMapping("restart")
    @ResponseBody
    public String restart() {
        System.out.println("热部署0");
        return restart;
    }

    public static void main(String[] args) throws IOException {
//        String hello = "[{\"identifier\":\"com.example.app1\",\"appName\":\"我爱学习\",\"appDownloadUrl\":\"http://appdist/img/woaixuexi.png\",\"discoveryTime\":\"2020-01-10\"}]";
//        String he = "{\"sign\":\"4868392b58f154f98851735e9aa034799f5c485fbfc7725ddce9d66f66e0cdcb65f9da580525ba95ed729d1e8e8c7e140d3209d3057ce05aa3fa7a22a2fbc2d6d6f47a235725f8b51732934a45dcc0417f015cf0f02a8f111d4a1a94c610bc0f3c9b08e1181ee1f157ddc55e31db9bc4bcd5b980cf63f27eee7c9d8d6221db2b93374aaa80d35f171006bf5803ef60c2a59b1548424a4dc65bc5c7763a5ec49108b59a9b38009a13e49ad4c35b5fb271bfa4b5ca362e916ebc155592627688a77c0ada2331145a86e3038af99ef2a796cdb2dd46b72d20501803d52722d7467b9da5956a76fb1155ee55ed60d5ecd6b8599875ddb739fd0801aebf554abc2c3c\",\"payload\":\"[{\\\"identifier\\\":\\\"jp.gungho.pad\\\",\\\"appName\\\":\\\"智龙迷城\\\",\\\"appDownloadUrl\\\":\\\"http://localhost\\\",\\\"discoveryTime\\\":\\\"2020-05-12 10:10:40\\\"}]\"}";
        System.out.println(System.currentTimeMillis()/1000);
//        System.out.println(1593758215945L / 1000);
        /*System.out.println(1593758215945L - 1593758180147L);
        System.out.println(35798 * 2 * 5);*/

        /*CloseableHttpClient httpClient = (CloseableHttpClient) SkipHttpsUtil.wrapClient();
        HttpPost httpPost = new HttpPost("https://111.205.235.130/test8/api/v1/app/unreport-feedback");
        httpClient.execute(httpPost);*/

    }
}
