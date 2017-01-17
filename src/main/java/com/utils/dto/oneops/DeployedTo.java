
package com.utils.dto.oneops;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attrProps",
    "ciAttributes",
    "ciClassName",
    "ciGoid",
    "ciId",
    "ciName",
    "ciState",
    "comments",
    "created",
    "createdBy",
    "impl",
    "lastAppliedRfcId",
    "nsId",
    "nsPath",
    "updated",
    "updatedBy"
})
public class DeployedTo implements Serializable
{

    @JsonProperty("attrProps")
    private AttrProps__ attrProps;
    @JsonProperty("ciAttributes")
    private CiAttributes__ ciAttributes;
    @JsonProperty("ciClassName")
    private String ciClassName;
    @JsonProperty("ciGoid")
    private String ciGoid;
    @JsonProperty("ciId")
    private Integer ciId;
    @JsonProperty("ciName")
    private String ciName;
    @JsonProperty("ciState")
    private String ciState;
    @JsonProperty("comments")
    private String comments;
    @JsonProperty("created")
    private Date created;
    @JsonProperty("createdBy")
    private String createdBy;
    @JsonProperty("impl")
    private String impl;
    @JsonProperty("lastAppliedRfcId")
    private Integer lastAppliedRfcId;
    @JsonProperty("nsId")
    private Integer nsId;
    @JsonProperty("nsPath")
    private String nsPath;
    @JsonProperty("updated")
    private Date updated;
    @JsonProperty("updatedBy")
    private Object updatedBy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7306964200754918980L;

    @JsonProperty("attrProps")
    public AttrProps__ getAttrProps() {
        return attrProps;
    }

    @JsonProperty("attrProps")
    public void setAttrProps(AttrProps__ attrProps) {
        this.attrProps = attrProps;
    }

    @JsonProperty("ciAttributes")
    public CiAttributes__ getCiAttributes() {
        return ciAttributes;
    }

    @JsonProperty("ciAttributes")
    public void setCiAttributes(CiAttributes__ ciAttributes) {
        this.ciAttributes = ciAttributes;
    }

    @JsonProperty("ciClassName")
    public String getCiClassName() {
        return ciClassName;
    }

    @JsonProperty("ciClassName")
    public void setCiClassName(String ciClassName) {
        this.ciClassName = ciClassName;
    }

    @JsonProperty("ciGoid")
    public String getCiGoid() {
        return ciGoid;
    }

    @JsonProperty("ciGoid")
    public void setCiGoid(String ciGoid) {
        this.ciGoid = ciGoid;
    }

    @JsonProperty("ciId")
    public Integer getCiId() {
        return ciId;
    }

    @JsonProperty("ciId")
    public void setCiId(Integer ciId) {
        this.ciId = ciId;
    }

    @JsonProperty("ciName")
    public String getCiName() {
        return ciName;
    }

    @JsonProperty("ciName")
    public void setCiName(String ciName) {
        this.ciName = ciName;
    }

    @JsonProperty("ciState")
    public String getCiState() {
        return ciState;
    }

    @JsonProperty("ciState")
    public void setCiState(String ciState) {
        this.ciState = ciState;
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
    public String getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("createdBy")
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @JsonProperty("impl")
    public String getImpl() {
        return impl;
    }

    @JsonProperty("impl")
    public void setImpl(String impl) {
        this.impl = impl;
    }

    @JsonProperty("lastAppliedRfcId")
    public Integer getLastAppliedRfcId() {
        return lastAppliedRfcId;
    }

    @JsonProperty("lastAppliedRfcId")
    public void setLastAppliedRfcId(Integer lastAppliedRfcId) {
        this.lastAppliedRfcId = lastAppliedRfcId;
    }

    @JsonProperty("nsId")
    public Integer getNsId() {
        return nsId;
    }

    @JsonProperty("nsId")
    public void setNsId(Integer nsId) {
        this.nsId = nsId;
    }

    @JsonProperty("nsPath")
    public String getNsPath() {
        return nsPath;
    }

    @JsonProperty("nsPath")
    public void setNsPath(String nsPath) {
        this.nsPath = nsPath;
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
