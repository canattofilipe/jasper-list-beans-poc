package com.wfc.jasperlistbeans;

import static org.springframework.boot.SpringApplication.exit;

import javax.annotation.PostConstruct;

import com.wfc.jasperlistbeans.service.BeanListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JasperListBeansApplication {


    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(JasperListBeansApplication.class, args);
        BeanListService beanListService = (BeanListService) ctx.getBean("bean");
        beanListService.testBuildPdf();
        SpringApplication.exit(ctx);
    }


}
