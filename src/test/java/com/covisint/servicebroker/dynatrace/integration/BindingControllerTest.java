package com.covisint.servicebroker.dynatrace.integration;

import com.covisint.servicebroker.dynatrace.integration.AbstractControllerTest;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.junit.Test;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Class: BindingControllerTest.java
 * Description: Test class for BindingController.
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */
public final class BindingControllerTest extends AbstractControllerTest {

	 
    /**
     * test class for create method
     *
     * @throws Exception 
     */
	
    @Test
    public void create() throws Exception {
        this.mockMvc.perform(put("/v2/service_instances/0/service_bindings/1").content(payload()).contentType(MediaType
                .APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.credentials.server").exists())
                .andExpect(jsonPath("$.credentials.profile").exists());
    }

    /**
     * test class for create method
     *
     * @throws Exception 
     */
    @Test
    public void testDelete() throws Exception {
        this.mockMvc.perform(delete("/v2/service_instances/0/service_bindings/1")
                .param("service_id", "test-service-id").param("plan_id", "test-plan-id"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }
    /**
     * 
     * @return objectMapper
     * @throws JsonProcessingException
     */
    private String payload() throws JsonProcessingException {
        Map<String, String> m = new HashMap<>();
        m.put("service_id", "test-service-id");
        m.put("plan_id", "test-plan-id");
        m.put("app_guid", "test-app-guid");

        return this.objectMapper.writeValueAsString(m);
    }

}
