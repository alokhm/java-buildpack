package com.covisint.servicebroker.dynatrace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * Class: ProvisioningController.java
 * Description: ProvisioningController class will be responsible request mapping (PUT , DELETE) of all service_instances.
 * 			    documentationUrl and  supportUrl
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */

@RestController
final class ProvisioningController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * create method
     *
     * @param provisioningRequest json request from RequestBody
     * @return ProvisioningResponse 
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/v2/service_instances/*")
    ProvisioningResponse create(@RequestBody ProvisioningRequest provisioningRequest) {
        this.logger.info("Provisioning Request Received: {}", provisioningRequest);
        return new ProvisioningResponse(null);
    }

    /**
     * delete method
     *
     * @param serviceId
     * @param planId
     * @return Map 
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/v2/service_instances/*")
    Map<?, ?> delete(@RequestParam("service_id") String serviceId, @RequestParam("plan_id") String planId) {
        this.logger.info("De-provisioning Request Received: service_id: {}, plan_id: {}", serviceId, planId);
        return Collections.emptyMap();
    }

}
