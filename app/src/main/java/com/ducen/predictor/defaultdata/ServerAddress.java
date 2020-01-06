package com.ducen.predictor.defaultdata;

public enum ServerAddress {

    R2_BASE_URL{
        public String toString() {
            return "http://test.fhir.org/r2/";
        }
    },

    R3_BASE_URL{
        public String toString() {
            return "https://r3.smarthealthit.org/";
        }
    },

    R4_BASE_URL{
        public String toString() {
            return "http://hapi.fhir.org/baseR4/";
        }
    }

}
