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
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	private String title;
	@Lob
	@NotBlank
	private String description;
	@Min(30)
	private int pages;
	@ElementCollection
	private List<Price> prices = new ArrayList<Price>();

	// motivar que eu quero fazer uma configuração global suportando este estilo
	// primeiro motiva que podemos criar um converter para isso.
	// @DateTimeFormat(iso=ISO.DATE)
	@DateTimeFormat
	private Calendar releaseDate;
	private String summaryPath;

	public String getSummaryPath() {
		return summaryPath;
	}

	public void setSummaryPath(String summaryPath) {
		this.summaryPath = summaryPath;
	}

	public Calendar getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Calendar releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getId() {
		return id;
	}

	public List<Price> getPrices() {
		return prices;
	}

	public void setPrices(List<Price> valores) {
		this.prices = valores;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String titulo) {
		this.title = titulo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descricao) {
		this.description = descricao;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int numeroPaginas) {
		this.pages = numeroPaginas;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", titulo=" + title + ", descricao="
				+ description + ", numeroPaginas=" + pages + ", valores="
				+ prices + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
