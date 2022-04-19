package br.com.mv.entites;

import com.fasterxml.jackson.annotation.JsonGetter;


public class Cobranca {

    private String accountId;
    private String payerCpfCnpj;
    private String payerName;
    private Number amount;
    private String description;
    private String acceptAfterExpiration;
    
    public Cobranca() {
    	
    }
    
    public Cobranca(String accountId, String payerCpfCnpj, String payerName, Number amount, String description,
			String acceptAfterExpiration) {
		super();
		this.accountId = accountId;
		this.payerCpfCnpj = payerCpfCnpj;
		this.payerName = payerName;
		this.amount = amount;
		this.description = description;
		this.acceptAfterExpiration = acceptAfterExpiration;
	}




	@JsonGetter("accountId")
    public String getAccountId() {
        return accountId;
    }
    @JsonGetter("payerCpfCnpj")
    public String getPayerCpfCnpj() {
        return payerCpfCnpj;
    }
    @JsonGetter("payerName")
    public String getPayerName() {
        return payerName;
    }
    @JsonGetter("amount")
    public Number getAmount() {
        return amount;
    }
    @JsonGetter("description")
    public String getDescription() {
        return description;
    }
    @JsonGetter("acceptAfterExpiration")
    public String getAcceptAfterExpiration() {
        return acceptAfterExpiration;
    }
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public void setPayerCpfCnpj(String payerCpfCnpj) {
		this.payerCpfCnpj = payerCpfCnpj;
	}
	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}
	public void setAmount(Number amount) {
		this.amount = amount;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setAcceptAfterExpiration(String acceptAfterExpiration) {
		this.acceptAfterExpiration = acceptAfterExpiration;
	}
    
    
    
}
