package org.azzasurf.view;

import org.springframework.stereotype.Component;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;
import org.thymeleaf.spring3.SpringTemplateEngine;

@Component
/**
 * Created by aaron.spiteri on 30/07/2016.
 */
public class StandaloneMvcViewResolver extends ThymeleafViewResolver {

    public StandaloneMvcViewResolver() {
        super();
        setTemplateEngine(new SpringTemplateEngine());
        
    }
}
