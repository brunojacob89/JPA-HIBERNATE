package br.com.alura.loja.modelo;

import javax.persistence.Embeddable;

@Embeddable //Indica que a classe é imbutida em um entidade
public class DadosPessoais {

	private String nome;
	private String cpf;
	
	public DadosPessoais() {
		
	}
	
	public DadosPessoais(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}


	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}
	
	

}
