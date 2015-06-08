package com.covisint.servicebroker.dynatrace;

import java.net.URI;

/**
 * Class: ServiceMetadata.java
 * Description: ServiceMetadata class will be responsible for holding service, imageUrl, longDescription, 
 * 			    documentationUrl and  supportUrl
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */

final class ServiceMetadata {

    private final Service service;

    private final Object monitor = new Object();

    private volatile String displayName;

    private volatile URI imageUrl;

    private volatile String longDescription;

    private volatile String providerDisplayName;

    private volatile URI documentationUrl;

    private volatile URI supportUrl;

    /**
     * 
     * @param service
     */
    ServiceMetadata(Service service) {
        this.service = service;
    }
    /**
     * 
     * @return displayName
     */
    String getDisplayName() {
        synchronized (this.monitor) {
            return this.displayName;
        }
    }
    /**
     * 
     * @return imageUrl
     */
    URI getImageUrl() {
        synchronized (this.monitor) {
            return this.imageUrl;
        }
    }
    /**
     * 
     * @return longDescription
     */
    String getLongDescription() {
        synchronized (this.monitor) {
            return this.longDescription;
        }
    }

    /**
     * 
     * @return providerDisplayName
     */
    String getProviderDisplayName() {
        synchronized (this.monitor) {
            return this.providerDisplayName;
        }
    }
    /**
     * 
     * @return documentationUrl
     */
    URI getDocumentationUrl() {
        synchronized (this.monitor) {
            return this.documentationUrl;
        }
    }
    /**
     * 
     * @return supportUrl
     */
    URI getSupportUrl() {
        synchronized (this.monitor) {
            return this.supportUrl;
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
     * @param  displayName
     * 
     */
    ServiceMetadata displayName(String displayName) {
        synchronized (this.monitor) {
            this.displayName = displayName;
            return this;
        }
    }
    /**
     * 
     * @param  imageUrl
     * 
     */
    ServiceMetadata imageUrl(URI imageUrl) {
        synchronized (this.monitor) {
            this.imageUrl = imageUrl;
            return this;
        }
    }
    /**
     * 
     * @param longDescription
     * 
     */
    ServiceMetadata longDescription(String longDescription) {
        synchronized (this.monitor) {
            this.longDescription = longDescription;
            return this;
        }
    }
    /**
     * 
     * @param providerDisplayName
     * 
     */
    ServiceMetadata providerDisplayName(String providerDisplayName) {
        synchronized (this.monitor) {
            this.providerDisplayName = providerDisplayName;
            return this;
        }
    }
    /**
     * 
     * @param documentationUrl
     * 
     */
    ServiceMetadata documentationUrl(URI documentationUrl) {
        synchronized (this.monitor) {
            this.documentationUrl = documentationUrl;
            return this;
        }
    }
    /**
     * 
     * @param supportUrl
     * 
     */
    ServiceMetadata supportUrl(URI supportUrl) {
        synchronized (this.monitor) {
            this.supportUrl = supportUrl;
            return this;
        }
    }

}
