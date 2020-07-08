package cn.wolfcode.website.config;

import cn.wolfcode.website.bean.DogBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.io.File;

@Configuration
public class TomcatConfig {
    // @Value(“${xxxx}”)注解从配置文件读取值
    @Value("${server.tomcat.prg-root}")
    private String prgRoot;

    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                if (factory instanceof TomcatServletWebServerFactory) {
                    TomcatServletWebServerFactory tomcat = (TomcatServletWebServerFactory) factory;
                    if (!StringUtils.isEmpty(prgRoot)) {
                        File root = new File(prgRoot);
                        tomcat.setDocumentRoot(root);
                    }
                }
            }
        };
    }

    // Bean在执行SpringApplication.run.refreshContext 方法的时候创建的
    @Bean
    public DogBean wangcai() {
        DogBean dogBean = new DogBean(9527L, "小美");
        System.out.println(dogBean);
        return dogBean;
    }
}
