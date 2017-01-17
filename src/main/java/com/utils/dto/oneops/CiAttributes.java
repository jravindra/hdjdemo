
package com.utils.dto.oneops;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additional_search_domains",
    "allow_loopback",
    "allow_rules",
    "availability_zone",
    "cores",
    "deny_rules",
    "dhclient",
    "dns_record",
    "drop_policy",
    "host_id",
    "hostname",
    "hosts",
    "hypervisor",
    "image_id",
    "instance_id",
    "instance_name",
    "instance_state",
    "iptables_enabled",
    "limits",
    "metadata",
    "nat_rules",
    "osname",
    "ostype",
    "pam_groupdn",
    "private_dns",
    "private_ip",
    "proxy_map",
    "public_dns",
    "public_ip",
    "ram",
    "repo_list",
    "require_public_ip",
    "server_image_id",
    "server_image_name",
    "size",
    "sshd_config",
    "sysctl",
    "tags",
    "task_state",
    "timezone",
    "vm_state"
})
public class CiAttributes implements Serializable
{

    @JsonProperty("additional_search_domains")
    private String additionalSearchDomains;
    @JsonProperty("allow_loopback")
    private String allowLoopback;
    @JsonProperty("allow_rules")
    private String allowRules;
    @JsonProperty("availability_zone")
    private String availabilityZone;
    @JsonProperty("cores")
    private String cores;
    @JsonProperty("deny_rules")
    private String denyRules;
    @JsonProperty("dhclient")
    private String dhclient;
    @JsonProperty("dns_record")
    private String dnsRecord;
    @JsonProperty("drop_policy")
    private String dropPolicy;
    @JsonProperty("host_id")
    private String hostId;
    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("hosts")
    private String hosts;
    @JsonProperty("hypervisor")
    private String hypervisor;
    @JsonProperty("image_id")
    private String imageId;
    @JsonProperty("instance_id")
    private String instanceId;
    @JsonProperty("instance_name")
    private String instanceName;
    @JsonProperty("instance_state")
    private String instanceState;
    @JsonProperty("iptables_enabled")
    private String iptablesEnabled;
    @JsonProperty("limits")
    private String limits;
    @JsonProperty("metadata")
    private String metadata;
    @JsonProperty("nat_rules")
    private String natRules;
    @JsonProperty("osname")
    private String osname;
    @JsonProperty("ostype")
    private String ostype;
    @JsonProperty("pam_groupdn")
    private String pamGroupdn;
    @JsonProperty("private_dns")
    private Object privateDns;
    @JsonProperty("private_ip")
    private String privateIp;
    @JsonProperty("proxy_map")
    private String proxyMap;
    @JsonProperty("public_dns")
    private Object publicDns;
    @JsonProperty("public_ip")
    private String publicIp;
    @JsonProperty("ram")
    private String ram;
    @JsonProperty("repo_list")
    private String repoList;
    @JsonProperty("require_public_ip")
    private String requirePublicIp;
    @JsonProperty("server_image_id")
    private String serverImageId;
    @JsonProperty("server_image_name")
    private String serverImageName;
    @JsonProperty("size")
    private String size;
    @JsonProperty("sshd_config")
    private String sshdConfig;
    @JsonProperty("sysctl")
    private String sysctl;
    @JsonProperty("tags")
    private String tags;
    @JsonProperty("task_state")
    private Object taskState;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("vm_state")
    private String vmState;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7842391704738903050L;

    @JsonProperty("additional_search_domains")
    public String getAdditionalSearchDomains() {
        return additionalSearchDomains;
    }

    @JsonProperty("additional_search_domains")
    public void setAdditionalSearchDomains(String additionalSearchDomains) {
        this.additionalSearchDomains = additionalSearchDomains;
    }

    @JsonProperty("allow_loopback")
    public String getAllowLoopback() {
        return allowLoopback;
    }

    @JsonProperty("allow_loopback")
    public void setAllowLoopback(String allowLoopback) {
        this.allowLoopback = allowLoopback;
    }

    @JsonProperty("allow_rules")
    public String getAllowRules() {
        return allowRules;
    }

    @JsonProperty("allow_rules")
    public void setAllowRules(String allowRules) {
        this.allowRules = allowRules;
    }

    @JsonProperty("availability_zone")
    public String getAvailabilityZone() {
        return availabilityZone;
    }

    @JsonProperty("availability_zone")
    public void setAvailabilityZone(String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    @JsonProperty("cores")
    public String getCores() {
        return cores;
    }

    @JsonProperty("cores")
    public void setCores(String cores) {
        this.cores = cores;
    }

    @JsonProperty("deny_rules")
    public String getDenyRules() {
        return denyRules;
    }

    @JsonProperty("deny_rules")
    public void setDenyRules(String denyRules) {
        this.denyRules = denyRules;
    }

    @JsonProperty("dhclient")
    public String getDhclient() {
        return dhclient;
    }

    @JsonProperty("dhclient")
    public void setDhclient(String dhclient) {
        this.dhclient = dhclient;
    }

    @JsonProperty("dns_record")
    public String getDnsRecord() {
        return dnsRecord;
    }

    @JsonProperty("dns_record")
    public void setDnsRecord(String dnsRecord) {
        this.dnsRecord = dnsRecord;
    }

    @JsonProperty("drop_policy")
    public String getDropPolicy() {
        return dropPolicy;
    }

    @JsonProperty("drop_policy")
    public void setDropPolicy(String dropPolicy) {
        this.dropPolicy = dropPolicy;
    }

    @JsonProperty("host_id")
    public String getHostId() {
        return hostId;
    }

    @JsonProperty("host_id")
    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    @JsonProperty("hosts")
    public String getHosts() {
        return hosts;
    }

    @JsonProperty("hosts")
    public void setHosts(String hosts) {
        this.hosts = hosts;
    }

    @JsonProperty("hypervisor")
    public String getHypervisor() {
        return hypervisor;
    }

    @JsonProperty("hypervisor")
    public void setHypervisor(String hypervisor) {
        this.hypervisor = hypervisor;
    }

    @JsonProperty("image_id")
    public String getImageId() {
        return imageId;
    }

    @JsonProperty("image_id")
    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    @JsonProperty("instance_id")
    public String getInstanceId() {
        return instanceId;
    }

    @JsonProperty("instance_id")
    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    @JsonProperty("instance_name")
    public String getInstanceName() {
        return instanceName;
    }

    @JsonProperty("instance_name")
    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    @JsonProperty("instance_state")
    public String getInstanceState() {
        return instanceState;
    }

    @JsonProperty("instance_state")
    public void setInstanceState(String instanceState) {
        this.instanceState = instanceState;
    }

    @JsonProperty("iptables_enabled")
    public String getIptablesEnabled() {
        return iptablesEnabled;
    }

    @JsonProperty("iptables_enabled")
    public void setIptablesEnabled(String iptablesEnabled) {
        this.iptablesEnabled = iptablesEnabled;
    }

    @JsonProperty("limits")
    public String getLimits() {
        return limits;
    }

    @JsonProperty("limits")
    public void setLimits(String limits) {
        this.limits = limits;
    }

    @JsonProperty("metadata")
    public String getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("nat_rules")
    public String getNatRules() {
        return natRules;
    }

    @JsonProperty("nat_rules")
    public void setNatRules(String natRules) {
        this.natRules = natRules;
    }

    @JsonProperty("osname")
    public String getOsname() {
        return osname;
    }

    @JsonProperty("osname")
    public void setOsname(String osname) {
        this.osname = osname;
    }

    @JsonProperty("ostype")
    public String getOstype() {
        return ostype;
    }

    @JsonProperty("ostype")
    public void setOstype(String ostype) {
        this.ostype = ostype;
    }

    @JsonProperty("pam_groupdn")
    public String getPamGroupdn() {
        return pamGroupdn;
    }

    @JsonProperty("pam_groupdn")
    public void setPamGroupdn(String pamGroupdn) {
        this.pamGroupdn = pamGroupdn;
    }

    @JsonProperty("private_dns")
    public Object getPrivateDns() {
        return privateDns;
    }

    @JsonProperty("private_dns")
    public void setPrivateDns(Object privateDns) {
        this.privateDns = privateDns;
    }

    @JsonProperty("private_ip")
    public String getPrivateIp() {
        return privateIp;
    }

    @JsonProperty("private_ip")
    public void setPrivateIp(String privateIp) {
        this.privateIp = privateIp;
    }

    @JsonProperty("proxy_map")
    public String getProxyMap() {
        return proxyMap;
    }

    @JsonProperty("proxy_map")
    public void setProxyMap(String proxyMap) {
        this.proxyMap = proxyMap;
    }

    @JsonProperty("public_dns")
    public Object getPublicDns() {
        return publicDns;
    }

    @JsonProperty("public_dns")
    public void setPublicDns(Object publicDns) {
        this.publicDns = publicDns;
    }

    @JsonProperty("public_ip")
    public String getPublicIp() {
        return publicIp;
    }

    @JsonProperty("public_ip")
    public void setPublicIp(String publicIp) {
        this.publicIp = publicIp;
    }

    @JsonProperty("ram")
    public String getRam() {
        return ram;
    }

    @JsonProperty("ram")
    public void setRam(String ram) {
        this.ram = ram;
    }

    @JsonProperty("repo_list")
    public String getRepoList() {
        return repoList;
    }

    @JsonProperty("repo_list")
    public void setRepoList(String repoList) {
        this.repoList = repoList;
    }

    @JsonProperty("require_public_ip")
    public String getRequirePublicIp() {
        return requirePublicIp;
    }

    @JsonProperty("require_public_ip")
    public void setRequirePublicIp(String requirePublicIp) {
        this.requirePublicIp = requirePublicIp;
    }

    @JsonProperty("server_image_id")
    public String getServerImageId() {
        return serverImageId;
    }

    @JsonProperty("server_image_id")
    public void setServerImageId(String serverImageId) {
        this.serverImageId = serverImageId;
    }

    @JsonProperty("server_image_name")
    public String getServerImageName() {
        return serverImageName;
    }

    @JsonProperty("server_image_name")
    public void setServerImageName(String serverImageName) {
        this.serverImageName = serverImageName;
    }

    @JsonProperty("size")
    public String getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(String size) {
        this.size = size;
    }

    @JsonProperty("sshd_config")
    public String getSshdConfig() {
        return sshdConfig;
    }

    @JsonProperty("sshd_config")
    public void setSshdConfig(String sshdConfig) {
        this.sshdConfig = sshdConfig;
    }

    @JsonProperty("sysctl")
    public String getSysctl() {
        return sysctl;
    }

    @JsonProperty("sysctl")
    public void setSysctl(String sysctl) {
        this.sysctl = sysctl;
    }

    @JsonProperty("tags")
    public String getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(String tags) {
        this.tags = tags;
    }

    @JsonProperty("task_state")
    public Object getTaskState() {
        return taskState;
    }

    @JsonProperty("task_state")
    public void setTaskState(Object taskState) {
        this.taskState = taskState;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("vm_state")
    public String getVmState() {
        return vmState;
    }

    @JsonProperty("vm_state")
    public void setVmState(String vmState) {
        this.vmState = vmState;
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
