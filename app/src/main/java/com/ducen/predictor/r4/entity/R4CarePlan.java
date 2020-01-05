package com.ducen.predictor.r4.entity;

import com.ducen.predictor.r4.types.Activity;
import com.ducen.predictor.r4.types.Annotation;
import com.ducen.predictor.r4.types.CodeableConcept;
import com.ducen.predictor.r4.types.Identifier;
import com.ducen.predictor.r4.types.Meta;
import com.ducen.predictor.r4.types.Period;
import com.ducen.predictor.r4.types.Reference;

import java.util.List;

public class R4CarePlan {

    private Meta meta;
    private List<Identifier> identifier;
    private List<String> instantiatesCanonical;
    private List<String> instantiatesURI;
    private List<Reference> basedOn;
    private List<Reference> replaces;
    private List<Reference> partOf;
    private String code;
    private String intent;
    private List<CodeableConcept> category;
    private String title;
    private String description;
    private Reference subject;
    private Reference encounter;
    private Period period;
    private String created;
    private Reference author;
    private List<Reference> contributor;
    private List<Reference> careTeam;
    private List<Reference> addresses;
    private List<Reference> supportingInfo;
    private List<String> goal;
    private List<Activity> activity;
    private List<Annotation> note;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Identifier> getIdentifier() {
        return identifier;
    }

    public void setIdentifier(List<Identifier> identifier) {
        this.identifier = identifier;
    }

    public List<String> getInstantiatesCanonical() {
        return instantiatesCanonical;
    }

    public void setInstantiatesCanonical(List<String> instantiatesCanonical) {
        this.instantiatesCanonical = instantiatesCanonical;
    }

    public List<String> getInstantiatesURI() {
        return instantiatesURI;
    }

    public void setInstantiatesURI(List<String> instantiatesURI) {
        this.instantiatesURI = instantiatesURI;
    }

    public List<Reference> getBasedOn() {
        return basedOn;
    }

    public void setBasedOn(List<Reference> basedOn) {
        this.basedOn = basedOn;
    }

    public List<Reference> getReplaces() {
        return replaces;
    }

    public void setReplaces(List<Reference> replaces) {
        this.replaces = replaces;
    }

    public List<Reference> getPartOf() {
        return partOf;
    }

    public void setPartOf(List<Reference> partOf) {
        this.partOf = partOf;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public List<CodeableConcept> getCategory() {
        return category;
    }

    public void setCategory(List<CodeableConcept> category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Reference getSubject() {
        return subject;
    }

    public void setSubject(Reference subject) {
        this.subject = subject;
    }

    public Reference getEncounter() {
        return encounter;
    }

    public void setEncounter(Reference encounter) {
        this.encounter = encounter;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Reference getAuthor() {
        return author;
    }

    public void setAuthor(Reference author) {
        this.author = author;
    }

    public List<Reference> getContributor() {
        return contributor;
    }

    public void setContributor(List<Reference> contributor) {
        this.contributor = contributor;
    }

    public List<Reference> getCareTeam() {
        return careTeam;
    }

    public void setCareTeam(List<Reference> careTeam) {
        this.careTeam = careTeam;
    }

    public List<Reference> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Reference> addresses) {
        this.addresses = addresses;
    }

    public List<Reference> getSupportingInfo() {
        return supportingInfo;
    }

    public void setSupportingInfo(List<Reference> supportingInfo) {
        this.supportingInfo = supportingInfo;
    }

    public List<String> getGoal() {
        return goal;
    }

    public void setGoal(List<String> goal) {
        this.goal = goal;
    }

    public List<Activity> getActivity() {
        return activity;
    }

    public void setActivity(List<Activity> activity) {
        this.activity = activity;
    }

    public List<Annotation> getNote() {
        return note;
    }

    public void setNote(List<Annotation> note) {
        this.note = note;
    }

    public R4CarePlan() {

    }

    public R4CarePlan(Meta meta, List<Identifier> identifier, List<String> instantiatesCanonical, List<String> instantiatesURI, List<Reference> basedOn, List<Reference> replaces, List<Reference> partOf, String code, String intent, List<CodeableConcept> category, String title, String description, Reference subject, Reference encounter, Period period, String created, Reference author, List<Reference> contributor, List<Reference> careTeam, List<Reference> addresses, List<Reference> supportingInfo, List<String> goal, List<Activity> activity, List<Annotation> note) {
        this.meta = meta;
        this.identifier = identifier;
        this.instantiatesCanonical = instantiatesCanonical;
        this.instantiatesURI = instantiatesURI;
        this.basedOn = basedOn;
        this.replaces = replaces;
        this.partOf = partOf;
        this.code = code;
        this.intent = intent;
        this.category = category;
        this.title = title;
        this.description = description;
        this.subject = subject;
        this.encounter = encounter;
        this.period = period;
        this.created = created;
        this.author = author;
        this.contributor = contributor;
        this.careTeam = careTeam;
        this.addresses = addresses;
        this.supportingInfo = supportingInfo;
        this.goal = goal;
        this.activity = activity;
        this.note = note;
    }

    @Override
    public String toString() {
        return "R4CarePlan{" +
                "meta=" + meta +
                ", identifier=" + identifier +
                ", instantiatesCanonical=" + instantiatesCanonical +
                ", instantiatesURI=" + instantiatesURI +
                ", basedOn=" + basedOn +
                ", replaces=" + replaces +
                ", partOf=" + partOf +
                ", code='" + code + '\'' +
                ", intent='" + intent + '\'' +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", subject=" + subject +
                ", encounter=" + encounter +
                ", period=" + period +
                ", created='" + created + '\'' +
                ", author=" + author +
                ", contributor=" + contributor +
                ", careTeam=" + careTeam +
                ", addresses=" + addresses +
                ", supportingInfo=" + supportingInfo +
                ", goal=" + goal +
                ", note=" + note +
                '}';
    }
}
