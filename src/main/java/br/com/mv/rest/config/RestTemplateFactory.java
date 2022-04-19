package br.com.mv.rest.config;

import org.apache.http.HttpHost;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.client.RestTemplate;

public class RestTemplateFactory implements FactoryBean<RestTemplate>, InitializingBean {
	private RestTemplate restTemplate;

	public RestTemplate getObject() {
		return restTemplate;
	}

	public Class<RestTemplate> getObjectType() {
		return RestTemplate.class;
	}

	public boolean isSingleton() {
		return true;
	}

	public void afterPropertiesSet() {
		HttpHost host = new HttpHost("api.pixservices.app/mv/oauth2/token", -1, "http");
//		restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactoryBasicAuth(host));	
		restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactoryBasicAuth(host));
	}

}
