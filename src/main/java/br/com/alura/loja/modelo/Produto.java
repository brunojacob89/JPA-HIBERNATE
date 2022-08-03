package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "produtos") // nome da tabela no banco de dados
@NamedQuery(name = "Produto.produtosPorCategoria", query = "SELECT p FROM Produto p WHERE p.categoria.id.nome = :nome") //Opcional deixa as query prontas na classe modelo
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Informa que usa como herença e estrategia uma tabela unica;
public class Produto {

	@Id // especifica qual atributo é a chave primary
	@GeneratedValue(strategy = GenerationType.IDENTITY) // gera chaves automatica;
	private Long id;
	private String nome;
	// @Column(name = "desc") se o nome do atributo for diferente da coluna usa para mapear qual coluna referencia
	private String descricao;
	private BigDecimal preco;
	private LocalDate dataCadastro = LocalDate.now();
	//@Enumerated(EnumType.STRING) // Cadastra pelo nome e não pela numeracao em ordem;
	@ManyToOne(fetch = FetchType.LAZY) // muitos pra um (muitos produtos estao vinculados a categoria)
	//@JoinColumn(name = "id_categoria") para personalizar o nome da coluna da chave estrageira;
	private Categoria categoria;
	
	

	public Produto() {} // JPA exige um construtor padrão.

	public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco
				+ ", dataCadastro=" + dataCadastro + ", categoria=" + categoria + "]";
	}

	
}
