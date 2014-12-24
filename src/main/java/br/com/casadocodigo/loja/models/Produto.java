package br.com.casadocodigo.loja.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	private String titulo;
	@Lob
	@NotBlank
	private String descricao;
	private int numeroPaginas;
	@ElementCollection
	private List<ValorPorTipo> valores = new ArrayList<ValorPorTipo>();
	
	//motivar que eu quero fazer uma configuração global suportando este estilo
	//primeiro motiva que podemos criar um converter para isso.
//	@DateTimeFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat
	private Calendar releaseDate;
	
	
	
	public Calendar getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Calendar releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getId() {
		return id;
	}

	public List<ValorPorTipo> getValores() {
		return valores;
	}

	public void setValores(List<ValorPorTipo> valores) {
		this.valores = valores;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", titulo=" + titulo + ", descricao="
				+ descricao + ", numeroPaginas=" + numeroPaginas + ", valores="
				+ valores + "]";
	}

}
