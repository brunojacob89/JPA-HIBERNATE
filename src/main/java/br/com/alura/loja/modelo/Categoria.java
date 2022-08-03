package br.com.alura.loja.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
	
//	@Id 
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id;
//	private String nome;
//	private String tipo;
	@EmbeddedId
	private CategotiaId id;
	
	
	public Categoria() {
	}

	public Categoria(String nome) {
		this.id = new CategotiaId(nome, "XPTO");
	}

	public String getNome() {
		return this.id.getNome();
	}

	public void setNome(String nome) {
		this.id.setNome(nome);
	
	}
}
