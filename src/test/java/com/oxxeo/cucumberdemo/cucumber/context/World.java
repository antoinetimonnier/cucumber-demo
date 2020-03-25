package com.oxxeo.cucumberdemo.cucumber.context;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;

/**
 * La classe world contient tout le contexte de nos scénarios de test (les éléments transverses aux test)
 * @author an.timonnier
 *
 */
public class World {

	private Optional<HttpStatus> httpStatusResponse;
	private String messageResponse;
	private Map<String, Object> pathParam = new HashMap<>();

	public Optional<HttpStatus> getHttpStatusResponse() {
		return httpStatusResponse;
	}

	public void setHttpStatusResponse(Optional<HttpStatus> httpStatusResponse) {
		this.httpStatusResponse = httpStatusResponse;
	}

	public String getMessageResponse() {
		return messageResponse;
	}

	public void setMessageResponse(String messageResponse) {
		this.messageResponse = messageResponse;
	}

	public Map<String, Object> getPathParam() {
		return pathParam;
	}

	public void setPathParam(Map<String, Object> pathParam) {
		this.pathParam = pathParam;
	}

}
