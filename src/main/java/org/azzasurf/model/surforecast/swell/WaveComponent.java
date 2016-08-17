package org.azzasurf.model.surforecast.swell;

/**
 * Created by aaron.spiteri on 17/08/2016.
 */
public class WaveComponent {
    private  int height;
    private int period;
    private double direction;
    private String compassDirection;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public String getCompassDirection() {
        return compassDirection;
    }

    public void setCompassDirection(String compassDirection) {
        this.compassDirection = compassDirection;
    }
}
