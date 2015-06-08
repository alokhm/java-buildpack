package com.covisint.servicebroker.dynatrace;

import com.covisint.servicebroker.dynatrace.AbstractSerializationTest;
import com.covisint.servicebroker.dynatrace.Plan;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Class: PlanTest.java
 * Description: Test class for PlanTest.
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */
public final class PlanTest extends AbstractSerializationTest<Plan> {

   
	@Override
    protected void assertContents(Map m) throws IOException {
        assertEquals(getId().toString(), m.get("id"));
        assertEquals("test-name", m.get("name"));
        assertEquals("test-description", m.get("description"));
        assertNull(m.get("metadata"));
        assertTrue((Boolean) m.get("free"));
    }

    @Override
    protected Plan getInstance() {
        return new Plan(null)
                .id(getId())
                .name("test-name")
                .description("test-description")
                .free(true);
    }
    /**
     * 
     * @return UUID
     */
    public UUID getId() {
        return UUID.nameUUIDFromBytes(new byte[0]);
    }

}
