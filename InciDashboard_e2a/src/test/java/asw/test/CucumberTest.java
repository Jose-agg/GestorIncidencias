package asw.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@SpringBootTest(classes = Application.class)
//@WebAppConfiguration
@CucumberOptions(features = "src/main/resources/features")
public class CucumberTest{

}