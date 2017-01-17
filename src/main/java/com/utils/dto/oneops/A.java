
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
        "cloud",
        "comments",
        "created",
        "createdBy",
        "deployedTo",
        "impl",
        "lastAppliedRfcId",
        "nsId",
        "nsPath",
        "opsState",
        "updated",
        "updatedBy"
})
public class A implements Serializable {

    @JsonProperty("attrProps")
    private AttrProps attrProps;
    @JsonProperty("ciAttributes")
    private CiAttributes ciAttributes;
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
    @JsonProperty("cloud")
    private Cloud cloud;
    @JsonProperty("comments")
    private Object comments;
    @JsonProperty("created")
    private Date created;
    @JsonProperty("createdBy")
    private String createdBy;
    @JsonProperty("deployedTo")
    private DeployedTo deployedTo;
    @JsonProperty("impl")
    private String impl;
    @JsonProperty("lastAppliedRfcId")
    private Integer lastAppliedRfcId;
    @JsonProperty("nsId")
    private Integer nsId;
    @JsonProperty("nsPath")
    private String nsPath;
    @JsonProperty("opsState")
    private String opsState;
    @JsonProperty("updated")
    private Date updated;
    @JsonProperty("updatedBy")
    private String updatedBy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 8201252871272830884L;

    @JsonProperty("attrProps")
    public AttrProps getAttrProps() {
        return attrProps;
    }

    @JsonProperty("attrProps")
    public void setAttrProps(AttrProps attrProps) {
        this.attrProps = attrProps;
    }

    @JsonProperty("ciAttributes")
    public CiAttributes getCiAttributes() {
        return ciAttributes;
    }

    @JsonProperty("ciAttributes")
    public void setCiAttributes(CiAttributes ciAttributes) {
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

    @JsonProperty("cloud")
    public Cloud getCloud() {
        return cloud;
    }

    @JsonProperty("cloud")
    public void setCloud(Cloud cloud) {
        this.cloud = cloud;
    }

    @JsonProperty("comments")
    public Object getComments() {
        return comments;
    }

    @JsonProperty("comments")
    public void setComments(Object comments) {
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

    @JsonProperty("deployedTo")
    public DeployedTo getDeployedTo() {
        return deployedTo;
    }

    @JsonProperty("deployedTo")
    public void setDeployedTo(DeployedTo deployedTo) {
        this.deployedTo = deployedTo;
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

    @JsonProperty("opsState")
    public String getOpsState() {
        return opsState;
    }

    @JsonProperty("opsState")
    public void setOpsState(String opsState) {
        this.opsState = opsState;
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
    public String getUpdatedBy() {
        return updatedBy;
    }

    @JsonProperty("updatedBy")
    public void setUpdatedBy(String updatedBy) {
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
