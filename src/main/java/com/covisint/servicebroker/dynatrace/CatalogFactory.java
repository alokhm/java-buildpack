package com.covisint.servicebroker.dynatrace;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.util.UUID;

/**
 * Class: CatalogFactory.java
 * Description: CatalogFactory responsible for creating Catalog object which will give static information about dynatrace . 
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */

@Configuration
public class CatalogFactory {

    /**
     * 
     * @param serviceId
     * @param planId
     * @return object of Catalog
     */
	@Bean
    Catalog catalog(@Value("${serviceBroker.serviceId}") String serviceId,
                    @Value("${serviceBroker.planId}") String planId) {
        // @formatter:off
        return new Catalog()
            .service()
                .id(UUID.fromString(serviceId))
                .name("dynatrace")
                .description("Manage and monitor your apps")
                .bindable(true)
                .tags("dynatrace", "management", "monitoring", "apm")
                .metadata()
                    .displayName("DynaTrace")
                    .imageUrl(URI.create("https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTiBIZfa-LBmUTk_w78c3n-RHFRfTeLDVd-Mog1xh6cVGbxxud6gQ"))
                    .longDescription("DynaTracce is the all-in-one web app performance tool that lets you see " +
                                     "performance from the end user experience, through servers, and down to the " +
                                     "line of code.")
                    .providerDisplayName("DYNATRACE LLC.")
                    .documentationUrl(URI.create("http://www.dynatrace.com/en/resources/webinars.html"))
                    .supportUrl(URI.create("https://support.dynatrace.com/"))
                    .and()
                .plan()
                    .id(UUID.fromString(planId))
                    .name("standard")
                    .description("Broker for static Dynatrace credentials")
                    .metadata()
                        .bullets("JVM Performance analyzer", "Database call response time & throughput",
                                 "Performance data API access")
                        .displayName("Standard")
                        .and()
                    .free(true)
                    .and()
                .and();
        // @formatter:on
    }

}
