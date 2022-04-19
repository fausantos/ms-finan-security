package br.com.mv.entites;

public class Token {
	
    private String grantType;
    private String role;
    
    
    public Token() {
    	
    }
    
	public Token(String grantType, String role) {
		this.grantType = grantType;
		this.role = role;
	}
	public String getGrantType() {
		return grantType;
	}
	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
    

}
