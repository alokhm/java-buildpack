package com.covisint.servicebroker.dynatrace;

import com.covisint.servicebroker.dynatrace.Credentials;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;

/**
 * Class: BindingResponse.java
 * Description: BindingResponse holding credentials , syslogDrainUrl. 
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */

final class BindingResponse {

    private final Credentials credentials;

    private final URI syslogDrainUrl;
    
    /**
     * 
     * @param credentials
     * @param syslogDrainUrl
     */

    BindingResponse(Credentials credentials, URI syslogDrainUrl) {
        this.credentials = credentials;
        this.syslogDrainUrl = syslogDrainUrl;
    }
    /**
     * 
     * @return credentials
     */
    Credentials getCredentials() {
        return this.credentials;
    }
    /**
     * 
     * @return syslogDrainUrl
     */
    @JsonProperty("syslog_drain_url")
    URI getSyslogDrainUrl() {
        return this.syslogDrainUrl;
    }

}
