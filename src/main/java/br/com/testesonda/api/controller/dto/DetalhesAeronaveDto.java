package br.com.testesonda.api.controller.dto;

import java.time.LocalDateTime;

import br.com.testesonda.api.model.Aeronave;

public class DetalhesAeronaveDto {
	
	private Long id;
	private String nome;
	private String marca;
	private int ano;
	private String descricao;
	private Boolean vendido ;
	private LocalDateTime created;
	private LocalDateTime updated ;
	

	public DetalhesAeronaveDto(Aeronave aeronave) {
		
		this.id = aeronave.getId();
		this.nome = aeronave.getNome();
		this.marca = aeronave.getMarca();
		this.ano = aeronave.getAno();
		this.descricao = aeronave.getDescricao();
		this.vendido = aeronave.getVendido();
		this.created = aeronave.getCreated();
		this.updated = aeronave.getUpdated();
	
	}


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public String getMarca() {
		return marca;
	}


	public int getAno() {
		return ano;
	}


	public String getDescricao() {
		return descricao;
	}


	public Boolean getVendido() {
		return vendido;
	}


	public LocalDateTime getCreated() {
		return created;
	}


	public LocalDateTime getUpdated() {
		return updated;
	}
	
	
	
	

}
