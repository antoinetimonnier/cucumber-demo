package com.oxxeo.cucumberdemo.cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * Classe point d'entrée pour jouer les test cucumber
 * @author an.timonnier
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		// Définition du directory ou trouver les scénarios de test
		features = { "classpath:features/" },
		// Définition du package ou trouver les StepDefinitions
		glue = { "com.oxxeo.cucumberdemo.cucumber.step" },
		// Plugin Junit pour le lancement des test
		plugin = { "pretty", "junit:target/resultat_tests_cucumber.xml" },
		// Strict mode (en echec si des test sont à undefined ou pending)
		strict = true)
public class CucumberTest {

}
