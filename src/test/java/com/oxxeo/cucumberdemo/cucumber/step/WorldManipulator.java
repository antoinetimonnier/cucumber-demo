package com.oxxeo.cucumberdemo.cucumber.step;

import java.util.Optional;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.oxxeo.cucumberdemo.CucumberDemoApplication;
import com.oxxeo.cucumberdemo.cucumber.configuration.TestCucumberConfig;
import com.oxxeo.cucumberdemo.cucumber.context.World;
import com.oxxeo.cucumberdemo.dao.repository.ICocktailRepository;

/**
 * Classe contenant contenant le world et permettant l'utilisation du contexte spring
 * @author an.timonnier
 *
 */
@ContextConfiguration(classes = { CucumberDemoApplication.class, TestCucumberConfig.class })
@SpringBootTest(classes = { CucumberDemoApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test-cucumber")
public class WorldManipulator {
	/**
	 * Le world contient tous les éléments transverses aux test cucumber
	 */
	private World world;
	
	/**
	 * Template d'appel REST (non mocké)
	 */
	@Autowired
	private RestTemplate restTemplateAppelApi;
	
	@Autowired
	private ICocktailRepository cocktailRepository;
	
	@Before
	public void before() {
		cocktailRepository.deleteAll();
		this.world = new World();
	}
	
	/**
	 * Méthode d'appel rest GET pour une URL et pour un type de retour particulier
	 * @param <T> classe de retour
	 * @param url url à appeler
	 * @param clazz classe de retour
	 * @return retour du get
	 */
	public <T> T appelerGet(final String url, final Class<T> clazz) {
		this.getWorld().setMessageResponse(null);
		try {
			final HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			final HttpEntity<?> entity = new HttpEntity<>(headers);
			final ResponseEntity<T> responsesDtos = restTemplateAppelApi.exchange(url, HttpMethod.GET, entity, clazz);
			this.getWorld().setHttpStatusResponse(Optional.ofNullable(responsesDtos.getStatusCode()));
			return responsesDtos.getBody();
		} catch (final HttpStatusCodeException exception) {
			this.getWorld().setMessageResponse(exception.getResponseBodyAsString());
			this.getWorld().setHttpStatusResponse(Optional.ofNullable(exception.getStatusCode()));
			return null;
		}
	}

	/**
	 * Méthode d'appel rest POST pour une URL et pour un type de retour particulier
	 * @param <T> classe de retour
	 * @param url url à appeler
	 * @param clazz classe de retour
	 * @return retour du POST
	 */
	public <T> T appelerPost(final String url, final Class<T> clazz) {
		try {
			final HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			final HttpEntity<?> entity = new HttpEntity<>(headers);
			final ResponseEntity<T> responsesDtos = restTemplateAppelApi.exchange(url, HttpMethod.POST, entity, clazz);
			this.getWorld().setHttpStatusResponse(Optional.ofNullable(responsesDtos.getStatusCode()));
			this.getWorld().setMessageResponse(responsesDtos.getBody() != null ? responsesDtos.getBody().toString() : "");
			return responsesDtos.getBody();
		} catch (RestClientResponseException e) {
			this.getWorld().setHttpStatusResponse(Optional.ofNullable(HttpStatus.valueOf(e.getRawStatusCode())));
			this.getWorld().setMessageResponse(e.getResponseBodyAsString());
			return null;
		}
	}
	
	private World getWorld() {
		return world;
	}

}
