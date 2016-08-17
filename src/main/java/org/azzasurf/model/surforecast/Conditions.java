package org.azzasurf.model.surforecast;

/**
 * Created by aaron.spiteri on 17/08/2016.
 */
public class Conditions {
    private int pressure;
    private int temperature;
    private int weather;
    private String unitPressure;
    private char unit;

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getWeather() {
        return weather;
    }

    public void setWeather(int weather) {
        this.weather = weather;
    }

    public String getUnitPressure() {
        return unitPressure;
    }

    public void setUnitPressure(String unitPressure) {
        this.unitPressure = unitPressure;
    }

    public char getUnit() {
        return unit;
    }

    public void setUnit(char unit) {
        this.unit = unit;
    }
}
