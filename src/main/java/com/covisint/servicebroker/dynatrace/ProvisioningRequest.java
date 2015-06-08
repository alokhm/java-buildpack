package com.covisint.servicebroker.dynatrace;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.Assert;

/**
 * Class: ProvisioningRequest.java
 * Description: ProvisioningRequest class will be responsible having serviceId, planId,org-guid and spaceGuid.
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */

final class ProvisioningRequest {

    private final String serviceId;

    private final String planId;

    private final String organizationGuid;

    private final String spaceGuid;
    /**
     * 
     * @param serviceId
     * @param planId
     * @param organizationGuid
     * @param spaceGuid
     */
    
    @JsonCreator
    ProvisioningRequest(@JsonProperty("service_id") String serviceId, @JsonProperty("plan_id") String planId,
                        @JsonProperty("organization_guid") String organizationGuid,
                        @JsonProperty("space_guid") String spaceGuid) {
        Assert.notNull(serviceId);
        Assert.notNull(planId);
        Assert.notNull(organizationGuid);
        Assert.notNull(spaceGuid);

        this.serviceId = serviceId;
        this.planId = planId;
        this.organizationGuid = organizationGuid;
        this.spaceGuid = spaceGuid;
    }
    /**
     * 
     * @return serviceId
     */
    String getServiceId() {
        return this.serviceId;
    }
    /**
     * 
     * @return planId
     */
    String getPlanId() {
        return this.planId;
    }
    /**
     * 
     * @return organizationGuid
     */
    String getOrganizationGuid() {
        return this.organizationGuid;
    }
    /**
     * 
     * @return spaceGuid
     */
    String getSpaceGuid() {
        return this.spaceGuid;
    }
    
    /**
     * 
     * @return String
     */
    @Override
    public String toString() {
        return String.format("service_id: %s, plan_id: %s, organization_guid: %s, space_guid: %s", this.serviceId,
                this.planId, this.organizationGuid, this.spaceGuid);
    }
}
