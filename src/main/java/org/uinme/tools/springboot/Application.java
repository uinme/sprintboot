package org.uinme.tools.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.uinme.tools.springboot.service.CsvEtlService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Application {
    @Autowired
    private CsvEtlService csvEtlService;
    
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        Application app = ctx.getBean(Application.class);
        app.run(args);
    }
    
    public void run(String... args) {
        csvEtlService.run(args);
    }
}
