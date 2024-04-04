package lv.venta.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Product {
	@Setter(value = AccessLevel.NONE)//ID nebūs autom.
	private int id;
	private String title;
	private String description;
	private float price;
	private int quantity;
	
	private static int counter = 1;
	
	public void setId() {
		this.id = counter++;
	}
	
	public Product(String title, String description, float price, int quantity) {
		setId();
		setTitle(title);
		setDescription(description);
		setPrice(price);
		setQuantity(quantity);	
	}
	
}