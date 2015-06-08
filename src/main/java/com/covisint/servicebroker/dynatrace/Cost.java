package com.covisint.servicebroker.dynatrace;

import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Class: Cost.java
 * Description: Cost class hold planMetadata, amount and unit values if this service going to be non-free mode 
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */

final class Cost {

    private final PlanMetadata planMetadata;

    private final Object monitor = new Object();

    private volatile Map<String, Double> amount;

    private volatile String unit;

    /**
     * 
     * @param planMetadata
     */
    Cost(PlanMetadata planMetadata) {
        this.planMetadata = planMetadata;
    }
    /**
     * 
     * @return amount
     */
   
    Map<String, Double> getAmount() {
        synchronized (this.monitor) {
            Assert.notEmpty(this.amount, "Costs must specify at least one amount");
            return this.amount;
        }
    }
    /**
     * 
     * @return unit which is of String type
     */
    String getUnit() {
        synchronized (this.monitor) {
            Assert.notNull(this.unit, "Costs must specify a unit");
            return this.unit;
        }
    }
    /**
     * 
     * @return planMetdata
     */
    PlanMetadata and() {
        synchronized (this.monitor) {
            return this.planMetadata;
        }
    }
    /**
     * 
     * @param  currency
     * @param  value
     * 
     */
    Cost amount(String currency, Double value) {
        synchronized (this.monitor) {
            if (this.amount == null) {
                this.amount = new HashMap<>();
            }

            this.amount.put(currency, value);
            return this;
        }
    }
    /**
     * 
     * @param  unit
     * 
     */
    Cost unit(String unit) {
        synchronized (this.monitor) {
            this.unit = unit;
            return this;
        }
    }

}
