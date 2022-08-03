package br.com.alura.loja.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CategotiaId implements Serializable {
	
	private String nome;
	private String tipo;
	
	public CategotiaId(String nome, String tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}
	
	public CategotiaId() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

}
