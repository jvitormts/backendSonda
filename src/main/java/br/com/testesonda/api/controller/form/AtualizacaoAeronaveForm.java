package br.com.testesonda.api.controller.form;

import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import br.com.testesonda.api.model.Aeronave;
import br.com.testesonda.api.repository.AeronaveRepository;

public class AtualizacaoAeronaveForm {
	

	private String nome;
	private String marca;
	private int ano;
	private String descricao;
	private Boolean vendido;
	

	
	private LocalDateTime updated  = LocalDateTime.now();
	
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Boolean getVendido() {
		return vendido;
	}
	public void setVendido(Boolean vendido) {
		this.vendido = vendido;
	}
	public LocalDateTime getUpdated() {
		return updated;
	}
	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}
	public Aeronave atualizar(Long id, AeronaveRepository aeronaveRepository) {

		Aeronave aeronave = aeronaveRepository.getOne(id);
		
		aeronave.setNome(this.nome);
		aeronave.setMarca(this.marca);
		aeronave.setAno(this.ano);
		aeronave.setDescricao(this.descricao);
		aeronave.setVendido(this.vendido);
		aeronave.setUpdated(this.updated);
		return aeronave;
	}
	
	

}
