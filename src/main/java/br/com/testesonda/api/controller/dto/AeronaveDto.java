package br.com.testesonda.api.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.testesonda.api.model.Aeronave;

public class AeronaveDto {
	


	private Long id;
	private String nome;
	private String marca;
	private int ano;
	private String descricao;
	private Boolean vendido ;
	
	public AeronaveDto(Aeronave aeronave) {
		
		this.id = aeronave.getId();
		this.nome = aeronave.getNome();
		this.marca = aeronave.getMarca();
		this.ano = aeronave.getAno();
		this.descricao = aeronave.getDescricao();
		this.vendido = aeronave.getVendido();
	
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




	public static List<AeronaveDto> converter(List<Aeronave> aeronaves) {
		// TODO Auto-generated method stub
		return aeronaves.stream().map(AeronaveDto::new).collect(Collectors.toList());
	}
	
	
	
	

}



