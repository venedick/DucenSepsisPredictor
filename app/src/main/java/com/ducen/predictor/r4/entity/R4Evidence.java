package com.ducen.predictor.r4.entity;


import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Reference;

import java.util.List;

public class R4Evidence {

    List<CodeableConcept> code;
    List<Reference> detail;

    public List<CodeableConcept> getCode() {
        return code;
    }

    public void setCode(List<CodeableConcept> code) {
        this.code = code;
    }

    public List<Reference> getDetail() {
        return detail;
    }

    public void setDetail(List<Reference> detail) {
        this.detail = detail;
    }

    public R4Evidence() {

    }

    public R4Evidence(List<CodeableConcept> code, List<Reference> detail) {
        this.code = code;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "R4Evidence{" +
                "code=" + code +
                ", detail=" + detail +
                '}';
    }
}
