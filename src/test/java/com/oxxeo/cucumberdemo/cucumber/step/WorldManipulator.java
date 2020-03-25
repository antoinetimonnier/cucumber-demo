package com.oxxeo.cucumberdemo.cucumber.step;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.oxxeo.cucumberdemo.cucumber.context.ExceptionDto;
import com.oxxeo.cucumberdemo.cucumber.context.World;

import gherkin.deps.com.google.gson.Gson;

/**
 * Classe contenant contenant le world et permettant de faire les appel REST
 * @author an.timonnier
 *
 */
@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class WorldManipulator {

	/**
	 * Le world contient tous les éléments transverses aux tests cucumber
	 */
	private World world;

	/**
	 * Template d'appel REST (non mocké)
	 */
	private final RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private Environment environment;

	/**
	 * Méthode d'appel rest GET pour une URL et pour un type de retour particulier
	 * @param <T> classe de retour
	 * @param url url à appeler
	 * @param clazz classe de retour
	 * @return retour du get
	 */
	public <T> T appelerGet(final String url, final Class<T> clazz) {
		this.setWorld(new World());
		try {
			final HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			final HttpEntity<?> entity = new HttpEntity<>(headers);
			final ResponseEntity<T> responsesDtos = restTemplate.exchange(url, HttpMethod.GET, entity, clazz);
			this.getWorld().setHttpStatusResponse(Optional.ofNullable(responsesDtos.getStatusCode()));
			return responsesDtos.getBody();
		} catch (final HttpStatusCodeException exception) {
			this.getWorld().setHttpStatusResponse(Optional.ofNullable(exception.getStatusCode()));
			Gson g = new Gson();
			ExceptionDto exceptionDto = g.fromJson(exception.getResponseBodyAsString(), ExceptionDto.class);
			this.getWorld().setExceptionDto(exceptionDto);
			return null;
		}
	}

	/**
	 * Méthode d'appel rest POST pour une URL , pour un body et pour un type de retour particulier
	 *
	 * @param url URL à appeler
	 * @param bodyDto DTO à passer à l'API
	 * @param clazz Classe du retour
	 * @param <T> Type du retour
	 * @return retour du post
	 */
	public <T> T appelerPost(final String url, final Object bodyDto, final Class<T> clazz) {
		this.setWorld(new World());
		try {
			final HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			final HttpEntity<?> entity = new HttpEntity<>(bodyDto, headers);
			final ResponseEntity<T> responsesDtos = restTemplate.exchange(url, HttpMethod.POST, entity, clazz);
			this.getWorld().setHttpStatusResponse(Optional.ofNullable(responsesDtos.getStatusCode()));
			return responsesDtos.getBody();
		} catch (final HttpClientErrorException exception) {
			this.getWorld().setHttpStatusResponse(Optional.ofNullable(exception.getStatusCode()));
			Gson g = new Gson();
			ExceptionDto exceptionDto = g.fromJson(exception.getResponseBodyAsString(), ExceptionDto.class);
			this.getWorld().setExceptionDto(exceptionDto);
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

	public void setWorld(World world) {
		this.world = world;
	}

}
