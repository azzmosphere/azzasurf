package org.azzasurf.bootloader;

import org.azzasurf.model.implementations.GenerateSurfForecastCollectionMSW;
import org.azzasurf.model.implementations.GenerateSurfVideoCollectionJSON;
import org.azzasurf.model.actions.GenerateSurfVideoCollection;
import org.azzasurf.model.actions.GenerateSurfForecastCollection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 *
 * Creates the concrete action handlers.
 *
 * Created by aaron.spiteri on 13/08/2016.
 */

@ComponentScan("org.azzasurf")
@Configuration
public class ActionHandlerCreator {

    //TODO Move this to the concrete class
    @Value("${msw.url}")
    private String MSW_URL;

    @Value("${msw.key}")
    private String MSW_KEY;

    @Value("${msw.secret}")
    private String MSW_SECRET;

    @Value("${msw.spotrequest}")
    private String MSW_SPOTREQUEST;

    @Bean
    public GenerateSurfVideoCollection getSurfVideoCollection() {
        return new GenerateSurfVideoCollectionJSON();
    }

    @Bean
    public GenerateSurfForecastCollection getSurfForecast() {
        GenerateSurfForecastCollectionMSW generateSurfForecastCollection = new GenerateSurfForecastCollectionMSW();

        generateSurfForecastCollection.setMsw_key(MSW_KEY);
        generateSurfForecastCollection.setMsw_secret(MSW_SECRET);
        generateSurfForecastCollection.setMsw_spotrequest(MSW_SPOTREQUEST);
        generateSurfForecastCollection.setMsw_url(MSW_URL);

        return generateSurfForecastCollection;
    }

}
