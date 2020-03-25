package model.entities;

import java.io.Serializable;

public class ItensDaVenda implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idvenda;
	private Integer id_livro;
	private Integer quantidade;
	private Double subtotal;
	
	private Livro livro;
	
	public ItensDaVenda() {
	}
	public ItensDaVenda(Integer idvenda, Integer quantidade, Double subtotal, Livro livro, Integer id_livro) {
		this.idvenda = idvenda;
		this.quantidade = quantidade;
		this.subtotal = subtotal;
		this.livro = livro;
		this.id_livro = id_livro;
	}
	
	public ItensDaVenda(Integer idvenda, Integer id_livro, Integer quantidade, Double subtotal) {
		this.idvenda = idvenda;
		this.id_livro = id_livro;
		this.quantidade = quantidade;
		this.subtotal = subtotal;
	}
	public Integer getIdvenda() {
		return idvenda;
	}
	public void setIdvenda(Integer idvenda) {
		this.idvenda = idvenda;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public Integer getId_livro() {
		return id_livro;
	}
	public void setId_livro(Integer id_livro) {
		this.id_livro = id_livro;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idvenda == null) ? 0 : idvenda.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItensDaVenda other = (ItensDaVenda) obj;
		if (idvenda == null) {
			if (other.idvenda != null)
				return false;
		} else if (!idvenda.equals(other.idvenda))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ItensDaVenda [idvenda=" + idvenda + ", id_livro=" + id_livro + ", quantidade=" + quantidade
				+ ", subtotal=" + subtotal + ", livro=" + livro + "]";
	}
	
	
	
}
