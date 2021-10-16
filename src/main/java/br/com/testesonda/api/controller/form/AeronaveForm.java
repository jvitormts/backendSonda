package br.com.testesonda.api.controller.form;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import br.com.testesonda.api.model.Aeronave;

public class AeronaveForm {

	//Setando quais clientes irão ser salvos
	@NotNull @NotEmpty @Length(min = 3, max = 50)
	private String nome;
	
	@NotNull @NotEmpty @Length(min = 3, max = 50)
	private String marca;
	
	@NotNull @Range(min = 0l) @Min(value = 1906)
	private int ano;
	
	private Boolean vendido;
	


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public int getAno() {
		return ano;
	}


	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public Boolean getVendido() {
		return vendido;
	}


	public void setVendido(Boolean vendido) {
		this.vendido = vendido;
	}



	public Aeronave converter(){
		return new Aeronave(nome, marca, ano, vendido);
	}

	
}
