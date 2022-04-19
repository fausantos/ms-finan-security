package br.com.mv.entites;

import com.fasterxml.jackson.annotation.JsonGetter;

public class CobrancaSaida {
	
	private String id;
	private String kid;
	private String description;
	private Number amount;
	private String payerName;
	private String payerCpfCnpj;
	private String status;
	
	
	public CobrancaSaida() {
		
	}
	
	
	
	public CobrancaSaida(String id, String kid, String description, Number amount, String payerName,
			String payerCpfCnpj, String status) {
		super();
		this.id = id;
		this.kid = kid;
		this.description = description;
		this.amount = amount;
		this.payerName = payerName;
		this.payerCpfCnpj = payerCpfCnpj;
		this.status = status;
	}


	@JsonGetter("id")
	public String getId() {
		return id;
	}


	@JsonGetter("kid")
	public String getKid() {
		return kid;
	}


	@JsonGetter("description")
	public String getDescription() {
		return description;
	}


	@JsonGetter("amount")
	public Number getAmount() {
		return amount;
	}


	@JsonGetter("payerName")
	public String getPayerName() {
		return payerName;
	}


	@JsonGetter("payerCpfCnpj")
	public String getPayerCpfCnpj() {
		return payerCpfCnpj;
	}


	@JsonGetter("status")
	public String getStatus() {
		return status;
	}
	
	
	





	
	
	
	
	

}
