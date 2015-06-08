package com.covisint.servicebroker.dynatrace;

import com.covisint.servicebroker.dynatrace.AbstractDeserializationTest;
import com.covisint.servicebroker.dynatrace.ProvisioningRequest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Class: ProvisioningRequestTest.java
 * Description: Test class for ProvisioningRequest.
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */
public final class ProvisioningRequestTest extends AbstractDeserializationTest<ProvisioningRequest> {

    
	public ProvisioningRequestTest() {
        super(ProvisioningRequest.class);
    }

    
	@Override
    protected void assertContents(ProvisioningRequest instance) {
        assertEquals("test-service-id", instance.getServiceId());
        assertEquals("test-plan-id", instance.getPlanId());
        assertEquals("test-organization-guid", instance.getOrganizationGuid());
        assertEquals("test-space-guid", instance.getSpaceGuid());
    }

    @Override
    protected Map getMap() {
        Map<String, String> m = new HashMap<>();
        m.put("service_id", "test-service-id");
        m.put("plan_id", "test-plan-id");
        m.put("organization_guid", "test-organization-guid");
        m.put("space_guid", "test-space-guid");

        return m;
    }

}
