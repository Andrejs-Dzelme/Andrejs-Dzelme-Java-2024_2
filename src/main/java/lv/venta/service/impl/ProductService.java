package lv.venta.service.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import lv.venta.model.Product;
import lv.venta.service.ICRUDProductService;
import lv.venta.service.IFilterProductService;

	@Service
	public class ProductService implements ICRUDProductService, IFilterProductService{
		private Product tempProduct1 = new Product("Abols", "Zaļš", 0.99f, 5);
		private Product tempProduct2 = new Product("Abols", "Sarkans", 1.99f, 50);
		private Product tempProduct3 = new Product("Abols", "Dzeltens", 3.99f, 500);
		private Product tempProduct4 = new Product("Abols", "Brūns", 9.99f, 23);
		ArrayList<Product> allProducts = new ArrayList<>(Arrays.asList(tempProduct1, tempProduct2, tempProduct3, tempProduct4));
		
		@Override
		public ArrayList<Product> filterByPriceLessThanThreshold(float threshold) throws Exception {
			if(threshold <= 0 || threshold > 10000) throw new Exception("The limit of price overreached.");
			ArrayList<Product> result = new ArrayList<>();
			for(Product tempP: allProducts) {
				if(tempP.getPrice() < threshold) {
					result.add(tempP);
				}
			}
			return result;
		}

		@Override
		public ArrayList<Product> filterByQuantityLessThanThreshold(float threshold) throws Exception {
			if(threshold <= 0 || threshold > 100) throw new Exception("The limit of quantity overreached.");
			ArrayList<Product> result = new ArrayList<>();
			for(Product tempP: allProducts) {
				if(tempP.getQuantity() < threshold) {
					result.add(tempP);
				}
			}
			return result;
		}

		@Override
		public ArrayList<Product> filterByTitleOrDescription(String text) throws Exception {
			if(text == null) throw new Exception("Search text cannot be null.");
			ArrayList<Product> result = new ArrayList<>();
			for(Product tempP: allProducts) {
				if(tempP.getTitle() == text) {
					result.add(tempP);
				}
			}
			return result;
		}

		@Override
		public float calculateProductsTotalValue() throws Exception {
			if (allProducts.isEmpty())
				throw new Exception("Product list is empty");
			
			
			float result = 0;
			for(Product tempP: allProducts) {
				result += tempP.getPrice()*tempP.getQuantity();
			}
			
			return result;
		}

		@Override
		public Product create(String title, String description, float price, int quantity) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Product> retrieveAll() throws Exception{
			if(allProducts.isEmpty()) throw new Exception("Product list is empty.");
			return allProducts;
		}

		@Override
		public Product retrieveById(int id) throws Exception {
			if(id > 0) {
				for(Product tempP: allProducts) {
					if(tempP.getId() == id) {
						return tempP;
					}
				}
				throw new Exception("ID should be positive.");
			}
			return null;
		}

		@Override
		public void updateById(int id, String title, String description, float price, int quantity) throws Exception {
			Product updateProduct = retrieveById(id);
			if(title != null) updateProduct.setTitle(title);
			if(description != null) updateProduct.setDescription(description);
			if(price >= 0 && price <= 10000) updateProduct.setPrice(price);
			if(quantity >= 0 && quantity <= 100) updateProduct.setQuantity(quantity);
		}

		@Override
		public void deleteById(int id) throws Exception {
			Product deleteProduct = retrieveById(id);
			allProducts.remove(deleteProduct);		
		}
		
	
	}
	

