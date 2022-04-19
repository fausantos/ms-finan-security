package br.com.mv.rest.config;

import java.net.URI;
import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHost;
import org.apache.http.client.AuthCache;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

public class HttpComponentsClientHttpRequestFactoryBasicAuth extends HttpComponentsClientHttpRequestFactory {

	HttpHost host;

	public HttpComponentsClientHttpRequestFactoryBasicAuth(HttpHost host) {
		super();
		this.host = host;
	}

	protected HttpContext createHttpContext(HttpMethod httpMethod, URI uri) {
		return createHttpContext();
	}

	private HttpContext createHttpContext() {
		AuthCache authCache = new BasicAuthCache();

		BasicScheme basicAuth = new BasicScheme();
		authCache.put(host, basicAuth);

		BasicHttpContext localcontext = new BasicHttpContext();
		localcontext.setAttribute(HttpClientContext.AUTH_CACHE, authCache);
		return localcontext;
	}

	public HttpHeaders createHeaders(String username, String password) {
		return new HttpHeaders() {
			{
				String auth = username + ":" + password;
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				set("Authorization", authHeader);
			}
		};
	}

}
