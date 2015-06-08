package com.covisint.servicebroker.dynatrace.testsuites;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Class: DynaTraceServiceTestSuiteRunner.java
 * Description: DynaTraceServiceTestSuiteRunner will be used for running all unit testing and integration testing.
 *
 *@version 1.0, 2015-06-01
 *@author Lingeshm
 *
 */

public class DynaTraceServiceTestSuiteRunner {

	public static void main(String[] args) {

		Result junitresult = JUnitCore
				.runClasses(DynaTraceServerJunitTestSuite.class);
		for (Failure fail : junitresult.getFailures()) {
			System.out.println(fail.toString());
		}
		if (junitresult.wasSuccessful()) {
			System.out.println("All unit tests finished successfully...");
		}

		Result itresult = JUnitCore
				.runClasses(DynaTraceServerIntegrationTestSuite.class);
		for (Failure fail : itresult.getFailures()) {
			System.out.println(fail.toString());
		}
		if (itresult.wasSuccessful()) {
			System.out
					.println("All integration tests finished successfully...");
		}
	}
}