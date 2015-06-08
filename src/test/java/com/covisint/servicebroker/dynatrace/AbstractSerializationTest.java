package com.covisint.servicebroker.dynatrace;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

/**
 * Class: AbstractSerializationTest.java
 * Description: Test class for AbstractSerialization.
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */
public abstract class AbstractSerializationTest<T> {

    private final ObjectMapper objectMapper = new ObjectMapper()
            .setVisibility(PropertyAccessor.GETTER, Visibility.ANY)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    /**
     * 
     * @throws IOException
     */
    @Test
    public final void serialization() throws IOException {
        assertContents((Map) roundTrip(getInstance()));
    }
    /**
     * 
     * @param o
     * @return objectMapper
     * @throws IOException
     */
    protected final Object roundTrip(Object o) throws IOException {
        String s = this.objectMapper.writeValueAsString(o);

        if (o instanceof List) {
            return this.objectMapper.readValue(s, List.class);
        } else {
            return this.objectMapper.readValue(s, Map.class);
        }
    }
    /**
     * 
     * @param m
     * @throws IOException
     */
    protected abstract void assertContents(Map m) throws IOException;

    protected abstract T getInstance();

}
