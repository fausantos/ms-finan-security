package br.com.mv.entites;

import com.fasterxml.jackson.annotation.JsonGetter;

public class RequestToken {
	
    
	
	private String accessToken;
	private String expiresIn;
	private String tokenType;
	
	public RequestToken() {
		
	}
	
	public RequestToken(String accessToken, String expiresIn, String tokenType) {
		super();
		this.accessToken = accessToken;
		this.expiresIn = expiresIn;
		this.tokenType = tokenType;
	}
	@JsonGetter("access_token")
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	@JsonGetter("expires_in")
	public String getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}
	@JsonGetter("token_type")
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	
	
//	 "access_token": "eyJraWQiOiJKVGlUdEZnTnFrbUFuemMrXC9vNXRvSkhDdVVcL1ZUZWZ0bEVYWlJhZlY2RTQ9IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiI2ZG1na2NhbWc5NGEzMmZiZDR1NXZkaXVmZiIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiYXBpLWFjY2Vzc1wvY29tcGFueS5hZG1pbiIsImF1dGhfdGltZSI6MTY0ODEzMjkwMSwiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLnVzLWVhc3QtMS5hbWF6b25hd3MuY29tXC91cy1lYXN0LTFfcHFURGdtbE1qIiwiZXhwIjoxNjQ4MTM2NTAxLCJpYXQiOjE2NDgxMzI5MDEsInZlcnNpb24iOjIsImp0aSI6ImUzNDgzYzczLTkwNTAtNGIzYi05ZDkxLWQxZGI0Y2Y2ZGYyNiIsImNsaWVudF9pZCI6IjZkbWdrY2FtZzk0YTMyZmJkNHU1dmRpdWZmIn0.Li_AfAq7ZJBK9inrSFsbZwtffqVOQeUZcFp3vtyBDhMSx7pVGhNnnJBHgGv2W-wjDJHpA-daJr4mXSPXHAzONg4jeIzJUyXWcuq8CkcxTKtlL4xMejTrxpejLxRcTI7puJtC60ZKx53G6UiIxDJoZXI1AmmZlGfTABDs7BZEAeu37fzJRjuGgXimM8j-k1aIIVGUOmPzNEJLHlFA0RTU-g7GYDw1H17FtqVYVJvTbE-gZ0NIZf9DMUZcCkq5cJYV_ndPtkpupq6a__PAb6ZT0xEibPqnlgbuJTYJK1mh968Z8psOVeuc8W4h5VANz6HokH7oZCQG7KiR2s8eCy0O9g",
//	    "expires_in": 3600,
//	    "token_type": "Bearer"

}
