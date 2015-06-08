package com.covisint.servicebroker.dynatrace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class: CatalogController.java
 * Description: CatalogController responsible for returning all the catalogs for /v2/catalog request mapping . 
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */

@RestController
final class CatalogController {

    private final Catalog catalog;

    /**
     * 
     * @param catalog
     */
    @Autowired
    CatalogController(Catalog catalog) {
        this.catalog = catalog;
    }
    /**
     * GET method
     * @return catalog
     */
    @RequestMapping(method = RequestMethod.GET, value = "/v2/catalog")
    Catalog catalog() {
        return this.catalog;
    }

}
