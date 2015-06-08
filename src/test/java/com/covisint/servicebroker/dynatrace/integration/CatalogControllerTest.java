package com.covisint.servicebroker.dynatrace.integration;

import com.covisint.servicebroker.dynatrace.integration.AbstractControllerTest;

import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Class: CatalogControllerTest.java
 * Description: Test class for CatalogController.
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */

public final class CatalogControllerTest extends AbstractControllerTest {

    /**
     * 
     * @throws Exception
     */
	@Test
    public void catalog() throws Exception {
        this.mockMvc.perform(get("/v2/catalog"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.services").exists());
    }

}
