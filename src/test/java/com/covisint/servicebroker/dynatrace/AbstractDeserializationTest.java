package com.covisint.servicebroker.dynatrace;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

/**
 * Class: AbstractDeserializationTest.java
 * Description: Test class for AbstractDeserialization.
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */
public abstract class AbstractDeserializationTest<T> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final Class<T> type;

    /**
     * 
     * @param type
     */
    protected AbstractDeserializationTest(Class<T> type) {
        this.type = type;
    }
    /**
     * 
     * @throws IOException
     */
    @Test
    public final void deSerialization() throws IOException {
        assertContents(roundTrip(getMap()));
    }
    /**
     * 
     * @param m
     * @return objectMapper
     * @throws IOException
     */
    protected final T roundTrip(Map m) throws IOException {
        String s = this.objectMapper.writeValueAsString(m);
        return this.objectMapper.readValue(s, this.type);
    }
    /**
     * 
     * @param instance
     */
    protected abstract void assertContents(T instance);

    protected abstract Map getMap();

}
