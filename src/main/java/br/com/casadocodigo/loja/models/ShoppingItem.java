package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;
import java.util.Arrays;

public class ShoppingItem {

	private Product product;
	private BookType bookType;
	private Integer productId;
	
	public static ShoppingItem zeroed(){
		Product product = new Product();
		Price price = new Price();
		BookType combo = BookType.COMBO;
		price.setBookType(combo);
		price.setValue(BigDecimal.ZERO);
		product.setPrices(Arrays.asList(price));
		return new ShoppingItem(product, combo);
	}

	public ShoppingItem(Product product, BookType bookType) {
		this.product = product;
		this.bookType = bookType;
		this.productId = product.getId();
	}
	
	public Product getProduct() {
		return product;
	}
	
	public BookType getBookType() {
		return bookType;
	}
	
	public BigDecimal getPrice(){
		return product.priceFor(bookType);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bookType == null) ? 0 : bookType.hashCode());
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
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
		ShoppingItem other = (ShoppingItem) obj;
		if (bookType != other.bookType)
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}

	public BigDecimal getTotal(Integer quantity) {
		return getPrice().multiply(new BigDecimal(quantity));
	}

	
	

}
