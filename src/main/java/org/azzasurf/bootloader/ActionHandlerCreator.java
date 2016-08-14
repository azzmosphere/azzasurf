package org.azzasurf.bootloader;

import org.azzasurf.controller.actions.GenerateSurfVideoCollection;
import org.azzasurf.controller.implementations.GenerateSurfVideoCollectionJSON;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * Creates the concrete action handlers.
 *
 * Created by aaron.spiteri on 13/08/2016.
 */

@Configuration
public class ActionHandlerCreator {
    @Bean
    public GenerateSurfVideoCollection getSurfVideoCollection() {
        return new GenerateSurfVideoCollectionJSON();
    }

}
