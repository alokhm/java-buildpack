package com.covisint.servicebroker.dynatrace;

import com.covisint.servicebroker.dynatrace.AbstractDeserializationTest;
import com.covisint.servicebroker.dynatrace.BindingRequest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Class: BindingRequestTest.java
 * Description: Test class for BindingRequest.
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */

public final class BindingRequestTest extends AbstractDeserializationTest<BindingRequest> {

    
	public BindingRequestTest() {
        super(BindingRequest.class);
    }
    
    @Override
    protected void assertContents(BindingRequest instance) {
        assertEquals("test-service-id", instance.getServiceId());
        assertEquals("test-plan-id", instance.getPlanId());
        assertEquals("test-app-guid", instance.getAppGuid());
    }

    @Override
    protected Map getMap() {
        Map<String, String> m = new HashMap<>();
        m.put("service_id", "test-service-id");
        m.put("plan_id", "test-plan-id");
        m.put("app_guid", "test-app-guid");

        return m;
    }

}
