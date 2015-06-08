package com.covisint.servicebroker.dynatrace;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class: CredentialsFactory.java
 * Description: A factory class for creating credential 
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */

@Configuration
public class CredentialsFactory {

    /**
     * 
     * @param server
     * @param profile
     * @return object of Credentials
     */
	@Bean
    Credentials credentials(@Value("${server}") String server , @Value("${profile}") String profile) {
        return new Credentials(server, profile);
    }

}
