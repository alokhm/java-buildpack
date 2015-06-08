package com.covisint.servicebroker.dynatrace;

import com.covisint.servicebroker.dynatrace.Credentials;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * Class: BindingController.java
 * Description: Binding controller which will do PUT and DELETE operation for all service_bindings. 
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */

@RestController
final class BindingController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Credentials credentials;

    
    @Autowired
    BindingController(Credentials credentials) {
        this.credentials = credentials;
    }
    
    /**
     * PUT method
     *
     * @param bindingRequest which is json request from RequestBody
     * @return object of BindingResponse class
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/v2/service_instances/*/service_bindings/*")
    BindingResponse create(@RequestBody BindingRequest bindingRequest) {
        this.logger.info("Binding Request Received: {}", bindingRequest);
        return new BindingResponse(this.credentials, null);
    }
    
    /**
     * DELETE method
     *
     * @param  serviceId 
     * @param  planId 
     * @return Map 
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/v2/service_instances/*/service_bindings/*")
    Map<?, ?> delete(@RequestParam("service_id") String serviceId, @RequestParam("plan_id") String planId) {
        this.logger.info("Un-binding Request Received: service_id: {}, plan_id: {}", serviceId, planId);
        return Collections.emptyMap();
    }

}
