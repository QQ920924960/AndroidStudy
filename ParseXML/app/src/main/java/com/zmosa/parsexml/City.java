package com.zmosa.parsexml;

/**
 * Created by xmc06 on 16/7/28.
 */
public class City {
    private String name;
    private String temp;
    private String pm;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", temp='" + temp + '\'' +
                ", pm='" + pm + '\'' +
                '}';
    }
}
