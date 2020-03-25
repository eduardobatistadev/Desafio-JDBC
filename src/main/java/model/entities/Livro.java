package model.entities;

import java.io.Serializable;

public class Livro implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idlivro;
	private String titulo;
	private Double preco;
	private Integer estoque;
	
	private Genero genero;
	
	public Livro() {
	}
	
	public Livro(Integer idlivro, String titulo, Double preco, Integer estoque, Genero genero) {
		this.idlivro = idlivro;
		this.titulo = titulo;
		this.preco = preco;
		this.estoque = estoque;
		this.genero = genero;
	}

	public Integer getIdlivro() {
		return idlivro;
	}

	public void setIdlivro(Integer idlivro) {
		this.idlivro = idlivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	
	public Genero getGenero() {
		return genero;
	}
	
	public void SetGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idlivro == null) ? 0 : idlivro.hashCode());
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
		Livro other = (Livro) obj;
		if (idlivro == null) {
			if (other.idlivro != null)
				return false;
		} else if (!idlivro.equals(other.idlivro))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Livro [idlivro=" + idlivro + ", titulo=" + titulo + ", preco=" + preco + ", estoque=" + estoque
				+ ", genero=" + genero + "]";
	}
}
