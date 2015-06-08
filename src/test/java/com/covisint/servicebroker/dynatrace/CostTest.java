package com.covisint.servicebroker.dynatrace;

import com.covisint.servicebroker.dynatrace.AbstractSerializationTest;
import com.covisint.servicebroker.dynatrace.Cost;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Class: CostTest.java
 * Description: Test class for CostTest.
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */
public final class CostTest extends AbstractSerializationTest<Cost> {

    
	@Override
    protected void assertContents(Map m) {
        assertEquals(getAmount(), m.get("amount"));
        assertEquals(m.get("unit"), "TEST-UNIT");
    }

    @Override
    protected Cost getInstance() {
        return new Cost(null)
                .amount("currency-1", 1.0)
                .amount("currency-2", 2.0)
                .unit("TEST-UNIT");
    }
    /**
     * 
     * @return amount 
     */
    private Map<String, Double> getAmount() {
        Map<String, Double> amount = new HashMap<>();
        amount.put("currency-1", 1.0);
        amount.put("currency-2", 2.0);

        return amount;
    }

}
