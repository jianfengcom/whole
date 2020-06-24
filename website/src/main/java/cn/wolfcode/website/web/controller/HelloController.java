package cn.wolfcode.website.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @Value("${test.hot.deploy}")
    private String restart;

    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("restart")
    @ResponseBody
    public String restart() {
        System.out.println("热部署2");
        return restart;
    }
}
