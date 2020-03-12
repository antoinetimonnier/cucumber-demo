package com.oxxeo.cucumberdemo.cucumber.configuration;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

/**
 * Classe de configuration pour les appels à l'api
 * @author an.timonnier
 *
 */
@TestConfiguration
@Profile("test-cucumber")
public class TestCucumberConfig {
	
	/**
	 * RestTemplate pour les appels à l'API.
	 * Ce RestTemplate est utilisé par les tests pour faire de 'vrais' appels à l'API.
	 * Il ne doit pas s'agir d'un Mock.
	 * @return RestTemplate
	 */
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public RestTemplate restTemplateAppelApi() {
		return new RestTemplate();
	}

}
