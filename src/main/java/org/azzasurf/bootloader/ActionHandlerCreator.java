package org.azzasurf.bootloader;

import org.azzasurf.model.actions.GenerateSurfForecastCollection;
import org.azzasurf.model.actions.GenerateSurfVideoCollection;
import org.azzasurf.model.implementations.GenerateSurfForecastCollectionMSW;
import org.azzasurf.model.implementations.GenerateSurfVideoCollectionJSON;
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

    @Bean
    public GenerateSurfForecastCollection getSurfForecast() {
        return new GenerateSurfForecastCollectionMSW();
    }

}
