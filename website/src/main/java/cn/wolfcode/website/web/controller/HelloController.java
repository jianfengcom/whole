package cn.wolfcode.website.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    public static void main(String[] args) { // 1593758180147 1593758215945
        System.out.println(System.currentTimeMillis()/1000);
//        System.out.println(1593758215945L / 1000);
        /*System.out.println(1593758215945L - 1593758180147L);
        System.out.println(35798 * 2 * 5);*/
    }
}
