package com.oxxeo.cucumberdemo.cucumber.step;

import java.util.Optional;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.oxxeo.cucumberdemo.CucumberDemoApplication;
import com.oxxeo.cucumberdemo.cucumber.configuration.TestDatabaseConfig;
import com.oxxeo.cucumberdemo.cucumber.configuration.TestRestConfig;
import com.oxxeo.cucumberdemo.cucumber.context.World;

/**
 * Classe contenant contenant le world et permettant l'utilisation du contexte spring
 * @author an.timonnier
 *
 */
@ContextConfiguration(classes = { CucumberDemoApplication.class, TestRestConfig.class, TestDatabaseConfig.class})
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
	private Environment environment;
	
	@Before
	public void before() {
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
	 * Appeler l'API (POST)
	 *
	 * @param url URL à appeler
	 * @param bodyDto DTO à passer à l'API
	 * @param clazz Classe du retour
	 * @param <T> Type du retour
	 * @return Valeur postée
	 */
	public <T> T appelerPost(final String url, final Object bodyDto, final Class<T> clazz) {
		try {
			final HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			final HttpEntity<?> entity = new HttpEntity<>(bodyDto, headers);
			final ResponseEntity<T> responsesDtos = restTemplateAppelApi.exchange(url, HttpMethod.POST, entity, clazz);
			this.getWorld().setHttpStatusResponse(Optional.ofNullable(responsesDtos.getStatusCode()));
			return responsesDtos.getBody();
		} catch (final HttpClientErrorException exception) {
			this.getWorld().setHttpStatusResponse(Optional.ofNullable(exception.getStatusCode()));
			this.getWorld().setMessageResponse(exception.getResponseBodyAsString());
			return null;
		}
	}
	
	/**
	 * Retourne l'URL d'accès à la ressource.
	 *
	 * @param resource Nom de la ressource 
	 * @return URL pour l'accès à la ressource
	 */
	public String buildUrl(final String resource) {
		final UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance().scheme("http").host("127.0.0.1")
				.port(environment.getProperty("local.server.port")).path("api/" + resource);
		return String.format(uriBuilder.build().toUriString());
	}
	
	public World getWorld() {
		return world;
	}

}
