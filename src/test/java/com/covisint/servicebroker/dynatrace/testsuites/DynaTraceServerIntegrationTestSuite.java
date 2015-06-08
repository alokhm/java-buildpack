package com.covisint.servicebroker.dynatrace.testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.covisint.servicebroker.dynatrace.integration.BindingControllerTest;
import com.covisint.servicebroker.dynatrace.integration.CatalogControllerTest;
import com.covisint.servicebroker.dynatrace.integration.ProvisioningControllerTest;

/**
 * Class: DynaTraceServerIntegrationTestSuite.java
 * Description: Suit class for DynaTraceServerIntegrationTest purpose.
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
	BindingControllerTest.class,
	CatalogControllerTest.class,
	ProvisioningControllerTest.class,
})
public class DynaTraceServerIntegrationTestSuite {   
}