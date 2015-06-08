package com.covisint.servicebroker.dynatrace;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.Assert;

import java.net.URI;

/**
 * Class: DashboardClient.java
 * Description: DashboardClient will be holding service , secret and redircetURL  
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */

final class DashboardClient {

    private final Service service;

    private final Object monitor = new Object();

    private volatile String id;

    private volatile String secret;

    private volatile URI redirectUri;
    /**
     * 
     * @param service
     */
    
    DashboardClient(Service service) {
        this.service = service;
    }
    /**
     * 
     * @return id
     */
    String getId() {
        synchronized (this.monitor) {
            Assert.notNull(this.id, "Dashboard Clients must specify an id");
            return this.id;
        }
    }
    /**
     * 
     * @return secret
     */
    String getSecret() {
        synchronized (this.monitor) {
            Assert.notNull(this.secret, "Dashboard Clients must specify a secret");
            return this.secret;
        }
    }
    /**
     * 
     * @return redirectUri
     */
    @JsonProperty("redirect_uri")
    URI getRedirectUri() {
        synchronized (this.monitor) {
            Assert.notNull(this.redirectUri, "Dashboard Clients must specify a redirect URI");
            return this.redirectUri;
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
    DashboardClient id(String id) {
        synchronized (this.monitor) {
            this.id = id;
            return this;
        }
    }
    /**
     * 
     * @param secret
     * 
     */
    DashboardClient secret(String secret) {
        synchronized (this.monitor) {
            this.secret = secret;
            return this;
        }
    }
    /**
     * 
     * @param redirectUri
     * 
     */
    DashboardClient redirectUri(URI redirectUri) {
        synchronized (this.monitor) {
            this.redirectUri = redirectUri;
            return this;
        }
    }

}
