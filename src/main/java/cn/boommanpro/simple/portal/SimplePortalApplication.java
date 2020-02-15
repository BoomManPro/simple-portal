package cn.boommanpro.simple.portal;

import java.net.InetAddress;
import java.net.UnknownHostException;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangqimeng
 */
@Slf4j
@SpringBootApplication
@MapperScan(basePackages = "cn.boommanpro.simple.portal.dao")
public class SimplePortalApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplication(SimplePortalApplication.class).run();
        try {
            String host = InetAddress.getLocalHost().getHostAddress();
            TomcatServletWebServerFactory tomcatServletWebServerFactory = (TomcatServletWebServerFactory) context.getBean("tomcatServletWebServerFactory");
            int port = tomcatServletWebServerFactory.getPort();
            String contextPath = tomcatServletWebServerFactory.getContextPath();
            log.info("<------------------------------------------ http://{}:{}{}/ ------------------------------------------>", host, port, contextPath);
        } catch (UnknownHostException e) {
            log.error("项目启动异常", e);
        }
        log.info("{}系统启动成功", SimplePortalApplication.class.getSimpleName());

    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
