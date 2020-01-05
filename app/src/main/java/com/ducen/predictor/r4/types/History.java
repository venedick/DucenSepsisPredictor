package com.ducen.predictor.r4.types;


public class History {

    private String status;
    private Period period;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public History(){

    }

    public History(String status, Period period) {
        this.status = status;
        this.period = period;
    }

    @Override
    public String toString() {
        return "R4StatusHistory{" +
                "status='" + status + '\'' +
                ", period=" + period +
                '}';
    }
}
