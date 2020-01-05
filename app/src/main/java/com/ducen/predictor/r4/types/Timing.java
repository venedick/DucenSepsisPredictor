package com.ducen.predictor.r4.types;

import java.util.List;

//get from R4 datatypes
public class Timing {

    private List<String >event;
    private Repeat repeat;
    private CodeableConcept code;

    public List<String> getEvent() {
        return event;
    }

    public void setEvent(List<String> event) {
        this.event = event;
    }

    public Repeat getRepeat() {
        return repeat;
    }

    public void setRepeat(Repeat repeat) {
        this.repeat = repeat;
    }

    public CodeableConcept getCode() {
        return code;
    }

    public void setCode(CodeableConcept code) {
        this.code = code;
    }

    public Timing(){

    }

    public Timing(List<String> event, Repeat repeat, CodeableConcept code) {
        this.event = event;
        this.repeat = repeat;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Timing{" +
                "event='" + event + '\'' +
                ", repeat=" + repeat +
                ", code=" + code +
                '}';
    }
}
