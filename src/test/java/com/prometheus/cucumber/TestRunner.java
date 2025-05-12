package com.prometheus.cucumber;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber") // Engine needed to run tests
@SelectClasspathResource("features") // folder in src/test/resources with feature files
@ConfigurationParameter(key = "cucumber.glue", value = "com.prometheus.cucumber") // Search here for all cucumber-related files
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty") // Plugin for outputting results in pretty format
public class TestRunner {

}
