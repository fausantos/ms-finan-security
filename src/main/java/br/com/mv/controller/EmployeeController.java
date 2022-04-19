package br.com.mv.controller;

import java.nio.charset.Charset;
import java.util.Base64;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.mv.entites.Cobranca;
import br.com.mv.entites.CobrancaSaida;
import br.com.mv.entites.RequestToken;
import br.com.mv.entites.Token;

@RestController
@RequestMapping(value = "/mv")
public class EmployeeController {

//	@PostMapping(path = "/token1", produces = "application/json")
//	public void getEmployees1(@RequestBody Token token) throws UnirestException {
//		Unirest.setTimeouts(0, 0);
//		com.mashape.unirest.http.HttpResponse<String> response = Unirest
//				.post("https://api.pixservices.app/mv/oauth2/token")
//				.header("Authorization",
//						"Basic NmRtZ2tjYW1nOTRhMzJmYmQ0dTV2ZGl1ZmY6YmZxbTJucTBwZTFpcGR0bmJ2MmJ0ZGM5aDE1YW1yZ29yZ3YwY3R2cmI3cW1ndXJ1OTdh")
//				.header("Content-Type", "application/json")
//				.body("{\r\n\t\"grant_type\":\"client_credentials\",\r\n\t\"role\": \"company\"\r\n}").asString();
//
//		System.out.println("Response: " + response.getBody());
//
//	}

	@PostMapping(path = "/token", produces = "application/json")
	public ResponseEntity<String> postToken(@RequestBody Cobranca requestCobranca) {

		try {

			String username = "6dmgkcamg94a32fbd4u5vdiuff";
			String password = "bfqm2nq0pe1ipdtnbv2btdc9h15amrgorgv0ctvrb7qmguru97a";
			// request url
			String url = "https://api.pixservices.app/mv/oauth2/token";

			ObjectMapper objectMapper = new ObjectMapper();

			// create auth credentials
			String authStr = username + ":" + password;
			String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());

			// create request body
			JSONObject requestJson = new JSONObject();
			requestJson.put("grant_type", "client_credentials");
			requestJson.put("role", "company");

			// create headers
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Basic " + base64Creds);
			headers.add("Content-Type", "application/json");

			// create request
			HttpEntity request = new HttpEntity(requestJson.toString(), headers);

			// make a request
			ResponseEntity<RequestToken> response = new RestTemplate().exchange(url, HttpMethod.POST, request,
					RequestToken.class);

			// get JSON response
			String json = response.getBody().getAccessToken();

			ResponseEntity<CobrancaSaida> cobranca = criarCobranca(response.getBody().getAccessToken(),
					requestCobranca);
			
			ResponseEntity<String> qrCode = criarQrCode(cobranca.getBody().getId(), "Basic " + base64Creds);

			System.out.println("response: " + json);
			System.out.println("qrCode: "+ qrCode);
			
			return qrCode;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}

	public ResponseEntity<CobrancaSaida> criarCobranca(String auth, @RequestBody Cobranca cobranca) {

		// create headers
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer  " + auth);
		headers.add("Content-Type", "application/json");
		// create request
		HttpEntity request = new HttpEntity(cobranca, headers);

		return new RestTemplate().exchange("https://api.pixservices.app/mv/sandbox/pix/dynamic", HttpMethod.POST,
				request, CobrancaSaida.class);

	}

	public ResponseEntity<String> criarQrCode(String id, String auth) {
		// create headers
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer  " + auth);
		headers.add("Content-Type", "application/json");
		// create request
		HttpEntity request = new HttpEntity(null, headers);
		
		return new RestTemplate().exchange("https://api.pixservices.app/mv/sandbox/qr/"+id, HttpMethod.GET,
				request, String.class);

	}

//	@PostMapping(path="/token", produces = "application/json")
//    public ResponseEntity getEmployees(@RequestBody Token token) 
//    {
//    	
//		
//		
//    	
//        RestTemplateFactory restTemplateFactory = new RestTemplateFactory();
//        RestTemplate restTemplate = new RestTemplate();
//        RequestToken requestToken = new RequestToken();
////        
//    	String stringUrl = "https://api.pixservices.app/mv/oauth2/token";
////    	
//    	String username = "6dmgkcamg94a32fbd4u5vdiuff";
//		String password = "bfqm2nq0pe1ipdtnbv2btdc9h15amrgorgv0ctvrb7qmguru97a";
////		
////		restTemplate.exchange(stringUrl, HttpMethod.POST, new org.springframework.http.HttpEntity<>(createHeaders(username, password)), Token.class);    	 
////		
////		restTemplate.getInterceptors().add( new BasicAuthorizationInterceptor("6dmgkcamg94a32fbd4u5vdiuff", "bfqm2nq0pe1ipdtnbv2btdc9h15amrgorgv0ctvrb7qmguru97a"));
////		restTemplate.exchange(
////				  stringUrl, 
////				  HttpMethod.POST, null, RequestToken.class);
////    	
//    	
//    	//  restTemplate.postForObject("https://api.pixservices.app/mv/oauth2/token", token , RequestToken.class);
////    	  restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(username, password));
////    	  restTemplate.exchange(stringUrl, HttpMethod.POST, null,RequestToken.class);
////    
////		 
////    	  RequestEntity<Token> request = RequestEntity
////    			     .post(stringUrl)
////    			     .header(createHeaders(username, password).toString())
////    			     .accept(MediaType.APPLICATION_JSON)
////    			     .body(body);
////    	  
////    	  
////    	  
////    	  ResponseEntity<RequestToken> responseEntity = restTemplate.exchange(request, RequestToken.class);
////    	   
//		
//		
//		 
//		    // create auth credentials
//		    String authStr = username+":"+password;
//		    String base64Creds = java.util.Base64.getEncoder().encodeToString(authStr.getBytes());
//
//		    // create headers
//		    HttpHeaders headers = new HttpHeaders();
//		    headers.add("Authorization", "Basic " + base64Creds);
//	    
//
//		    // create request
//		    token.setGrantType("client_credentials");
//		    HttpEntity request1 = new HttpEntity<Token>(token,headers);
//		    // make a request
//		//    ResponseEntity<String> response1 = new RestTemplate().exchange(stringUrl, HttpMethod.POST, request1, String.class);
//		    
//		    
//	
//		    
//	    	  RequestEntity<Token> request = RequestEntity
//		     .post(stringUrl)
//		     .header("Authorization", "Basic " + base64Creds)
//		     .header("Content-Type", "application/json")
//		     .accept(MediaType.APPLICATION_JSON)
//		     .body(token);
//
//		    // make a request
//	//	    ResponseEntity<RequestToken> response = new RestTemplate().exchange(stringUrl, HttpMethod.POST, request, RequestToken.class);
//
//		    // get JSON response
//		//    RequestToken json = response.getBody();
//
//		  //  System.out.println("RequestToken: "+json); 	
//		
//		
//    	   return response1;
//    	
//        
//    	
//    	
//    }

//	public HttpHeaders createHeaders(String username, String password) {
//
//		return new HttpHeaders() {
//			{
//				String auth = username + ":" + password;
//				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("UTF-8")));
//				String authHeader = "Basic " + new String(encodedAuth);
//				set("Authorization", authHeader);
//			}
//		};
//	}

}
