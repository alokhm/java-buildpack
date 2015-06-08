package com.covisint.servicebroker.dynatrace;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.Assert;

/**
 * Class: BindingRequest.java
 * Description: BindingRequest holding service_id , plan_id , app_guid. 
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */

final class BindingRequest {

    private final String serviceId;

    private final String planId;

    private final String appGuid;

   /**
    * 
    * @param serviceId
    * @param planId
    * @param appGuid
    */
    @JsonCreator
    BindingRequest(@JsonProperty("service_id") String serviceId, @JsonProperty("plan_id") String planId,
                   @JsonProperty("app_guid") String appGuid) {
        Assert.notNull(serviceId);
        Assert.notNull(planId);
        Assert.notNull(appGuid);

        this.serviceId = serviceId;
        this.planId = planId;
        this.appGuid = appGuid;
    }

    String getServiceId() {
        return this.serviceId;
    }

    String getPlanId() {
        return this.planId;
    }

    String getAppGuid() {
        return this.appGuid;
    }
 
    @Override
    public String toString() {
        return String.format("service_id: %s, plan_id: %s, app_guid: %s", this.serviceId, this.planId, this.appGuid);
    }
}
