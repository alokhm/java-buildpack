package com.covisint.servicebroker.dynatrace;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

import com.covisint.servicebroker.dynatrace.AbstractSerializationTest;
import com.covisint.servicebroker.dynatrace.BindingResponse;
import com.covisint.servicebroker.dynatrace.Credentials;
/**
 * Class: BindingResponseTest.java
 * Description: Test class for BindingResponse.
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */
public final class BindingResponseTest extends AbstractSerializationTest<BindingResponse> {

    @Override
    protected void assertContents(Map m) throws IOException {
        assertEquals(roundTrip(getCredentials()), m.get("credentials"));
        assertEquals("http://test.syslog.drain.url", m.get("syslog_drain_url"));
    }

    @Override
    protected BindingResponse getInstance() {
        return new BindingResponse(getCredentials(), URI.create("http://test.syslog.drain.url"));
    }
    /**
     * 
     * @return object of Credentials which contains server and profile name
     */
    private Credentials getCredentials() {
        return new Credentials("54.200.253.18:9998", "hm-dyna-agent");
    }

}
