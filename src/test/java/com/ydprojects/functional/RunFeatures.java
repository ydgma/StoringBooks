package com.ydprojects.functional;


import com.ydprojects.config.AppConfig;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", glue="")
@ContextConfiguration(classes= AppConfig.class)
public class RunFeatures {

}
