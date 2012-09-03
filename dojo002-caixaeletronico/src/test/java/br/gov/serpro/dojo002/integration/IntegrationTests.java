package br.gov.serpro.dojo002.integration;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"pretty", "html:target/cucumber"}, monochrome=true)
public class IntegrationTests {
}