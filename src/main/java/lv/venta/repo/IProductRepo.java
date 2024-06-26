package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import lv.venta.model.Product;

public interface IProductRepo extends CrudRepository<Product, Integer>{

	Product findByTitleAndDescriptionAndPrice(String title, String description, float price);
	ArrayList<Product> findByPriceLessThan(float threshold);
	ArrayList<Product> findByQuantityLessThan(int threshold);
	ArrayList<Product> findByTitleOrDescriptionContaining(String text, String text2);

	@Query(nativeQuery = true, value = "SELECT SUM(PRICE * QUANTITY) FROM PRODUCT_TABLE;")
	float calculateToTotalValueFromDB();
	
}
