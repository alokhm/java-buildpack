package com.covisint.servicebroker.dynatrace.integration;


import com.covisint.servicebroker.dynatrace.Application;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Class: AbstractControllerTest.java
 * Description: Test class for AbstractController.
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public abstract class AbstractControllerTest {


	@Autowired
    protected volatile ObjectMapper objectMapper;

    protected volatile MockMvc mockMvc;
    /**
     * 
     * @param webApplicationContext
     */
    @Autowired
    final void setWebApplicationContext(WebApplicationContext webApplicationContext) {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

}
