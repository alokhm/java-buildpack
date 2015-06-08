package com.covisint.servicebroker.dynatrace;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.Assert;

import java.util.UUID;

/**
 * Class: Plan.java
 * Description: Plan class will be used for service plan related details like name , description , planMetadata and free.  
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */

final class Plan {

    private final Service service;

    private final Object monitor = new Object();

    private volatile UUID id;

    private volatile String name;

    private volatile String description;

    private volatile PlanMetadata planMetadata;

    private volatile Boolean free;

    /**
     * 
     * @param service
     */
    Plan(Service service) {
        this.service = service;
    }
    /**
     * 
     * @return id
     */
    UUID getId() {
        synchronized (this.monitor) {
            Assert.notNull(this.id, "Plans must specify an id");
            return this.id;
        }
    }
    /**
     * 
     * @return name
     */
    String getName() {
        synchronized (this.monitor) {
            Assert.notNull(this.id, "Plans must specify a name");
            return this.name;
        }
    }
    /**
     * 
     * @return description
     */
    String getDescription() {
        synchronized (this.monitor) {
            Assert.notNull(this.id, "Plans must specify a description");
            return this.description;
        }
    }
    /**
     * 
     * @return planMetadata
     */
    @JsonProperty("metadata")
    PlanMetadata getPlanMetadata() {
        synchronized (this.monitor) {
            return this.planMetadata;
        }
    }
    /**
     * 
     * @return free
     */
    Boolean getFree() {
        synchronized (this.monitor) {
            return this.free;
        }
    }
    /**
     * 
     * @return service
     */
    Service and() {
        synchronized (this.monitor) {
            return this.service;
        }
    }
    /**
     * 
     * @param id
     * 
     */
    Plan id(UUID id) {
        synchronized (this.monitor) {
            this.id = id;
            return this;
        }
    }
    /**
     * 
     * @param name
     * 
     */
    Plan name(String name) {
        synchronized (this.monitor) {
            this.name = name;
            return this;
        }
    }
    /**
     * 
     * @param description
     * 
     */
    Plan description(String description) {
        synchronized (this.monitor) {
            this.description = description;
            return this;
        }
    }
    /**
     * 
     * @return planMetadata
     */
    PlanMetadata metadata() {
        synchronized (this.monitor) {
            if (this.planMetadata == null) {
                this.planMetadata = new PlanMetadata(this);
            }

            return this.planMetadata;
        }
    }
    /**
     * 
     * @param free
     * 
     */
    Plan free(Boolean free) {
        synchronized (this.monitor) {
            this.free = free;
            return this;
        }
    }

}
