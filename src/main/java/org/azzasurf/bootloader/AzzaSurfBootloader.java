package org.azzasurf.bootloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.thymeleaf.spring3.templateresolver.SpringResourceTemplateResolver;

import java.util.Arrays;

import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;


/**
 * Creates the bootloader for the project.
 *
 * Currently using the system default web browser which means we have to know which system we are on, this is
 * really bad practice.
 *
 * TODO: This should move to the application class
 *
 * Created by aaron.spiteri on 28/07/2016.
 */

@ComponentScan("org.azzasurf")
@Configuration
@SpringBootApplication
public class AzzaSurfBootloader {
    private static final String OS  = System.getProperty("os.name").toLowerCase();

    @Value("${bootloader.url}")
    private String URL;
    private static final boolean LAUNCH_BROWSER = false;
    private static final Logger logger = LoggerFactory.getLogger(AzzaSurfBootloader.class);

    @Value("${templateresolver.prefix}")
    private String tmplResolverPrefix;

    @Bean
    public ITemplateResolver getTemplateResolver() {
        SpringResourceTemplateResolver templateResolver =  new SpringResourceTemplateResolver();

        templateResolver.setPrefix(tmplResolverPrefix);
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");

        return templateResolver;
    }

    @Autowired
    @Bean
    public SpringTemplateEngine getSpringTemplateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(templateResolver);
        return springTemplateEngine;
    }


    @Autowired
    @Bean
    public ViewResolver getViewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);

        return viewResolver;
    }

    public static void main(String[] args) throws Exception {

        ApplicationContext ctx = SpringApplication.run(AzzaSurfBootloader.class, args);
        logger.info("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            logger.info(beanName);
        }

        logger.info("RESOURCES:");
        Resource[] resources = ctx.getResources("**");
        for (Resource resource : resources) {
            logger.info(resource.getURL() + ":" + resource.getFilename());
        }

        logger.info("ENVIRONMENT");

//        Resource resource = ctx.getResource("url:http://localhost:8080/json/videos.json");
//        logger.info("videos.json = " + resource.getURI());

        //logger.info("spring.view.prefix = ", env.getProperty("spring.view.prefix"));
//
//        Runtime rt = Runtime.getRuntime();
//
//        if (OS.contains("mac") && LAUNCH_BROWSER == true) {
//
//            rt.exec( "open " + URL);
//        }
    }
}
