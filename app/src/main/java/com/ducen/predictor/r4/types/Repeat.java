package com.ducen.predictor.r4.types;

import java.util.List;

//get from R4 datatypes
public class Repeat {

    private String boundsDuration;
    private Range boundsRange;
    private Period boundsPeriod;
    private String count;
    private String countMax;
    private String duration;
    private String durationMax;
    private String durationUnit;
    private String frequency;
    private String frequencyMax;
    private String period;
    private String periodMax;
    private String periodUnit;
    private List<String> dayOfWeek;
    private List<String> timeOfDay;
    private List<String> when;
    private String offset;

    public String getBoundsDuration() {
        return boundsDuration;
    }

    public void setBoundsDuration(String boundsDuration) {
        this.boundsDuration = boundsDuration;
    }

    public Range getBoundsRange() {
        return boundsRange;
    }

    public void setBoundsRange(Range boundsRange) {
        this.boundsRange = boundsRange;
    }

    public Period getBoundsPeriod() {
        return boundsPeriod;
    }

    public void setBoundsPeriod(Period boundsPeriod) {
        this.boundsPeriod = boundsPeriod;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCountMax() {
        return countMax;
    }

    public void setCountMax(String countMax) {
        this.countMax = countMax;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDurationMax() {
        return durationMax;
    }

    public void setDurationMax(String durationMax) {
        this.durationMax = durationMax;
    }

    public String getDurationUnit() {
        return durationUnit;
    }

    public void setDurationUnit(String durationUnit) {
        this.durationUnit = durationUnit;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getFrequencyMax() {
        return frequencyMax;
    }

    public void setFrequencyMax(String frequencyMax) {
        this.frequencyMax = frequencyMax;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPeriodMax() {
        return periodMax;
    }

    public void setPeriodMax(String periodMax) {
        this.periodMax = periodMax;
    }

    public String getPeriodUnit() {
        return periodUnit;
    }

    public void setPeriodUnit(String periodUnit) {
        this.periodUnit = periodUnit;
    }

    public List<String> getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(List<String> dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public List<String> getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(List<String> timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public List<String> getWhen() {
        return when;
    }

    public void setWhen(List<String> when) {
        this.when = when;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public Repeat(){

    }

    public Repeat(String boundsDuration, Range boundsRange, Period boundsPeriod, String count, String countMax, String duration, String durationMax, String durationUnit, String frequency, String frequencyMax, String period, String periodMax, String periodUnit, List<String> dayOfWeek, List<String> timeOfDay, List<String> when, String offset) {
        this.boundsDuration = boundsDuration;
        this.boundsRange = boundsRange;
        this.boundsPeriod = boundsPeriod;
        this.count = count;
        this.countMax = countMax;
        this.duration = duration;
        this.durationMax = durationMax;
        this.durationUnit = durationUnit;
        this.frequency = frequency;
        this.frequencyMax = frequencyMax;
        this.period = period;
        this.periodMax = periodMax;
        this.periodUnit = periodUnit;
        this.dayOfWeek = dayOfWeek;
        this.timeOfDay = timeOfDay;
        this.when = when;
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "Repeat{" +
                "boundsDuration='" + boundsDuration + '\'' +
                ", boundsRange=" + boundsRange +
                ", boundsPeriod=" + boundsPeriod +
                ", count='" + count + '\'' +
                ", countMax='" + countMax + '\'' +
                ", duration='" + duration + '\'' +
                ", durationMax='" + durationMax + '\'' +
                ", durationUnit='" + durationUnit + '\'' +
                ", frequency='" + frequency + '\'' +
                ", frequencyMax='" + frequencyMax + '\'' +
                ", period='" + period + '\'' +
                ", periodMax='" + periodMax + '\'' +
                ", periodUnit='" + periodUnit + '\'' +
                ", dayOfWeek=" + dayOfWeek +
                ", timeOfDay=" + timeOfDay +
                ", when=" + when +
                ", offset='" + offset + '\'' +
                '}';
    }
}


