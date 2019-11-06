package br.com.valdemir.estoque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto {
	@Id
	@NotNull
	@Size(min=0, max = 15)
	@Column(name = "sku", length = 15, nullable = false)
	private String sku;

	@NotNull
	@Size(min=0, max = 50)
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;

	@Size(min=0, max = 100)
	@Column(name = "descricao", length = 100)
	private String descricao;

	@NotNull
	@Positive
	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;

	@Positive
	@Column(name = "preco", precision = 10, scale = 2)
	private Double preco;

	/**
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * @param sku the sku to set
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return the preco
	 */
	public Double getPreco() {
		return preco;
	}

	/**
	 * @param preco the preco to set
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [sku=" + sku + ", nome=" + nome + ", descricao=" + descricao + ", quantidade=" + quantidade
				+ ", preco=" + preco + "]";
	}

}
