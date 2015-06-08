package com.covisint.servicebroker.dynatrace.testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.covisint.servicebroker.dynatrace.BindingRequestTest;
import com.covisint.servicebroker.dynatrace.BindingResponseTest;
import com.covisint.servicebroker.dynatrace.CatalogTest;
import com.covisint.servicebroker.dynatrace.CostTest;
import com.covisint.servicebroker.dynatrace.CredentialsTest;
import com.covisint.servicebroker.dynatrace.DashboardClientTest;
import com.covisint.servicebroker.dynatrace.PlanMetadataTest;
import com.covisint.servicebroker.dynatrace.PlanTest;
import com.covisint.servicebroker.dynatrace.ProvisioningRequestTest;
import com.covisint.servicebroker.dynatrace.ProvisioningResponseTest;
import com.covisint.servicebroker.dynatrace.ServiceMetadataTest;
import com.covisint.servicebroker.dynatrace.ServiceTest;

/**
 * Class: DynaTraceServerJunitTestSuite.java
 * Description: Suit class for DynaTraceServerJunitTestSuite purpose.
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CredentialsTest.class,
	BindingRequestTest.class,
	BindingResponseTest.class,
	CatalogTest.class,
	CostTest.class,
	DashboardClientTest.class,
	PlanMetadataTest.class,
	PlanTest.class,
	ServiceMetadataTest.class,
	ServiceTest.class,
	ProvisioningRequestTest.class,
	ProvisioningResponseTest.class
	
})
public class DynaTraceServerJunitTestSuite {   
}