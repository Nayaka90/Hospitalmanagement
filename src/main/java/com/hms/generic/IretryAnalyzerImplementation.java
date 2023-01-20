package com.hms.generic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IretryAnalyzerImplementation implements IRetryAnalyzer {
	int  upperLimit=3;
	int count=0;
	public boolean retry(ITestResult result) {
		if(count<upperLimit) {
			count++;
			return true;
		}
		return false;
	}
}
