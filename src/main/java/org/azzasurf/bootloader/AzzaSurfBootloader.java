package org.azzasurf.bootloader;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;

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
@SpringBootApplication
public class AzzaSurfBootloader {
    private static final String URL = "http://localhost:8080/";
    private static final String OS  = System.getProperty("os.name").toLowerCase();


    /**
     *  The template resolver for JSP.
     *
     * @return
     */
//    @Bean
//    public TemplateResolver templateResolver() {
//
//    }

    /**
     * Create the view resolver.
     *
     * @return ThymeleafViewResolver
     */
//    @Bean
//    public ViewResolver getViewResolver() {
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//
//        return viewResolver;
//    }
//
//    /**
//     *
//     * CREATE
//     *
//     * @return
//     */
//    @Bean
//    public InternalResourceViewResolver jspViewResolver() {
//        InternalResourceViewResolver resolver  = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/JSP/");
//        resolver.setSuffix(".jsp");
//        resolver.setViewClass(JstlView.class);
//        return resolver;
//
//    }

    public static void main(String[] args) throws Exception {

        ApplicationContext ctx = SpringApplication.run(AzzaSurfBootloader.class, args);
        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        Runtime rt = Runtime.getRuntime();

        if (OS.contains("mac")) {

            rt.exec( "open " + URL);
        }
        else {
            throw new Exception("Unsupported operating system");
        }
    }
}
