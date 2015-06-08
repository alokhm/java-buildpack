package com.covisint.servicebroker.dynatrace;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: Catalog.java
 * Description: Catalog holding list of services . 
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */

final class Catalog {

    private volatile List<Service> services;

    private final Object monitor = new Object();

    /**
     * 
     * @return List of services
     */
    List<Service> getServices() {
        synchronized (this.monitor) {
            return this.services;
        }
    }
/**
 * 
 * @return service
 */
    Service service() {
        synchronized (this.monitor) {
            if (this.services == null) {
                this.services = new ArrayList<>();
            }

            Service service = new Service(this);
            this.services.add(service);
            return service;
        }
    }

}
