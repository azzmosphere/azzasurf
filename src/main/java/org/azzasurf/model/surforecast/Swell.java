package org.azzasurf.model.surforecast;

import org.azzasurf.model.surforecast.swell.Components;

/**
 * Created by aaron.spiteri on 17/08/2016.
 */
public class Swell {
    private double minBreakingHeight;
    private double absMinBreakingHeight;
    private double maxBreakingHeight;
    private double absMaxBreakingHeight;
    private char unit;
    private Components components;

    public double getMinBreakingHeight() {
        return minBreakingHeight;
    }

    public void setMinBreakingHeight(double minBreakingHeight) {
        this.minBreakingHeight = minBreakingHeight;
    }

    public double getAbsMinBreakingHeight() {
        return absMinBreakingHeight;
    }

    public void setAbsMinBreakingHeight(double absMinBreakingHeight) {
        this.absMinBreakingHeight = absMinBreakingHeight;
    }

    public double getMaxBreakingHeight() {
        return maxBreakingHeight;
    }

    public void setMaxBreakingHeight(double maxBreakingHeight) {
        this.maxBreakingHeight = maxBreakingHeight;
    }

    public double getAbsMaxBreakingHeight() {
        return absMaxBreakingHeight;
    }

    public void setAbsMaxBreakingHeight(double absMaxBreakingHeight) {
        this.absMaxBreakingHeight = absMaxBreakingHeight;
    }

    public char getUnit() {
        return unit;
    }

    public void setUnit(char unit) {
        this.unit = unit;
    }

    public Components getComponents() {
        return components;
    }

    public void setComponents(Components components) {
        this.components = components;
    }
}
