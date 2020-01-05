package com.ducen.predictor.r4.types;


import java.util.List;

public class Batch {

    private String lotNumber;
    private String expirationDate;

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }


    public Batch() {

    }

    public Batch(String lotNumber, String expirationDate) {
        this.lotNumber = lotNumber;
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "lotNumber='" + lotNumber + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }
}
