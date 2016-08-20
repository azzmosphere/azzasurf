package org.azzasurf.views.surfforecastviewmapper;

import java.util.List;

/**
 * Created by aaron.spiteri on 20/08/2016.
 */
public class SurfforecastGroup {
    private String displayDate;
    private List<SurfForecastViewMapper> attributes;

    public String getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(String displayDate) {
        this.displayDate = displayDate;
    }

    public List<SurfForecastViewMapper> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<SurfForecastViewMapper> attributes) {
        this.attributes = attributes;
    }
}
