
package com.utils.dto.oneops;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ciRelationId",
    "comments",
    "created",
    "createdBy",
    "fromCi",
    "fromCiId",
    "lastAppliedRfcId",
    "nsPath",
    "relationAttributes",
    "relationGoid",
    "relationName",
    "relationState",
    "toCi",
    "toCiId",
    "updated",
    "updatedBy"
})
public class Cloud implements Serializable
{

    @JsonProperty("ciRelationId")
    private Integer ciRelationId;
    @JsonProperty("comments")
    private String comments;
    @JsonProperty("created")
    private Date created;
    @JsonProperty("createdBy")
    private Object createdBy;
    @JsonProperty("fromCi")
    private Object fromCi;
    @JsonProperty("fromCiId")
    private Integer fromCiId;
    @JsonProperty("lastAppliedRfcId")
    private Integer lastAppliedRfcId;
    @JsonProperty("nsPath")
    private String nsPath;
    @JsonProperty("relationAttributes")
    private RelationAttributes relationAttributes;
    @JsonProperty("relationGoid")
    private String relationGoid;
    @JsonProperty("relationName")
    private String relationName;
    @JsonProperty("relationState")
    private String relationState;
    @JsonProperty("toCi")
    private ToCi toCi;
    @JsonProperty("toCiId")
    private Integer toCiId;
    @JsonProperty("updated")
    private Date updated;
    @JsonProperty("updatedBy")
    private Object updatedBy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6895263381454864138L;

    @JsonProperty("ciRelationId")
    public Integer getCiRelationId() {
        return ciRelationId;
    }

    @JsonProperty("ciRelationId")
    public void setCiRelationId(Integer ciRelationId) {
        this.ciRelationId = ciRelationId;
    }

    @JsonProperty("comments")
    public String getComments() {
        return comments;
    }

    @JsonProperty("comments")
    public void setComments(String comments) {
        this.comments = comments;
    }

    @JsonProperty("created")
    public Date getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(Date created) {
        this.created = created;
    }

    @JsonProperty("createdBy")
    public Object getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("createdBy")
    public void setCreatedBy(Object createdBy) {
        this.createdBy = createdBy;
    }

    @JsonProperty("fromCi")
    public Object getFromCi() {
        return fromCi;
    }

    @JsonProperty("fromCi")
    public void setFromCi(Object fromCi) {
        this.fromCi = fromCi;
    }

    @JsonProperty("fromCiId")
    public Integer getFromCiId() {
        return fromCiId;
    }

    @JsonProperty("fromCiId")
    public void setFromCiId(Integer fromCiId) {
        this.fromCiId = fromCiId;
    }

    @JsonProperty("lastAppliedRfcId")
    public Integer getLastAppliedRfcId() {
        return lastAppliedRfcId;
    }

    @JsonProperty("lastAppliedRfcId")
    public void setLastAppliedRfcId(Integer lastAppliedRfcId) {
        this.lastAppliedRfcId = lastAppliedRfcId;
    }

    @JsonProperty("nsPath")
    public String getNsPath() {
        return nsPath;
    }

    @JsonProperty("nsPath")
    public void setNsPath(String nsPath) {
        this.nsPath = nsPath;
    }

    @JsonProperty("relationAttributes")
    public RelationAttributes getRelationAttributes() {
        return relationAttributes;
    }

    @JsonProperty("relationAttributes")
    public void setRelationAttributes(RelationAttributes relationAttributes) {
        this.relationAttributes = relationAttributes;
    }

    @JsonProperty("relationGoid")
    public String getRelationGoid() {
        return relationGoid;
    }

    @JsonProperty("relationGoid")
    public void setRelationGoid(String relationGoid) {
        this.relationGoid = relationGoid;
    }

    @JsonProperty("relationName")
    public String getRelationName() {
        return relationName;
    }

    @JsonProperty("relationName")
    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

    @JsonProperty("relationState")
    public String getRelationState() {
        return relationState;
    }

    @JsonProperty("relationState")
    public void setRelationState(String relationState) {
        this.relationState = relationState;
    }

    @JsonProperty("toCi")
    public ToCi getToCi() {
        return toCi;
    }

    @JsonProperty("toCi")
    public void setToCi(ToCi toCi) {
        this.toCi = toCi;
    }

    @JsonProperty("toCiId")
    public Integer getToCiId() {
        return toCiId;
    }

    @JsonProperty("toCiId")
    public void setToCiId(Integer toCiId) {
        this.toCiId = toCiId;
    }

    @JsonProperty("updated")
    public Date getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @JsonProperty("updatedBy")
    public Object getUpdatedBy() {
        return updatedBy;
    }

    @JsonProperty("updatedBy")
    public void setUpdatedBy(Object updatedBy) {
        this.updatedBy = updatedBy;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
