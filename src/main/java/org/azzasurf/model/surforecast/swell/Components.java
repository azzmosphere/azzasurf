package org.azzasurf.model.surforecast.swell;

/**
 * Created by aaron.spiteri on 17/08/2016.
 */
public class Components {
    private WaveComponent combined;
    private WaveComponent primary;
    private WaveComponent secondary;
    private WaveComponent tertiary;

    public WaveComponent getCombined() {
        return combined;
    }

    public void setCombined(WaveComponent combined) {
        this.combined = combined;
    }

    public WaveComponent getPrimary() {
        return primary;
    }

    public void setPrimary(WaveComponent primary) {
        this.primary = primary;
    }

    public WaveComponent getSecondary() {
        return secondary;
    }

    public void setSecondary(WaveComponent secondary) {
        this.secondary = secondary;
    }

    public WaveComponent getTertiary() {
        return tertiary;
    }

    public void setTertiary(WaveComponent tertiary) {
        this.tertiary = tertiary;
    }
}
