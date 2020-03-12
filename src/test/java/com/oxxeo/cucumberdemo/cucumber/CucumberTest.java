package com.oxxeo.cucumberdemo.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
/**
 * Classe pour jouer les test cucumber
 * @author an.timonnier
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		// Définition du directory ou trouver les scénarios de test
		features = { "classpath:features/" },
		// Définition du package ou trouver les StepDefinitions
		glue = { "com.oxxeo.cucumberdemo.cucumber.step" },
		// Strict mode (en echec si des test sont à undefined ou pending)
		strict = true)
public class CucumberTest {

}
