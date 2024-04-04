package lv.venta.controller;


import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lv.venta.model.Product;


@Controller

public class FirstController {
	
	@GetMapping("/hello")//localhost:8080/hello
	public String getHello() {
		System.out.println("First controller!");
		return "hello-page"; //Parāda lapu.
	}
	@GetMapping("/hello/msg")//localhost:8080/hello/msg
	public String getHelloMsg(Model model) {
		System.out.println("Asg controller is called.");
		model.addAttribute("mydata", "Ziņa no Java spring.");
		return "hello-msg-page";
	}
	@GetMapping("/product/test")//localhost:8080/product/test
	public String getProductTest(Model model) {
		Product tempProduct = new Product("Abols", "Zaļš", 0.99f, 5);
		model.addAttribute("mydata",tempProduct );
		return "product-one-show-page";		
	}
	@GetMapping("/product/all")//localhost:8080/product/all
	public String getProductAll(Model model) {
		Product tempProduct1 = new Product("Abols", "Zaļš", 0.99f, 5);
		Product tempProduct2 = new Product("Abols", "Sarkans", 1.99f, 50);
		Product tempProduct3 = new Product("Abols", "Dzeltens", 3.99f, 500);
		Product tempProduct4 = new Product("Abols", "Brūns", 9.99f, 23);
		ArrayList<Product> allProducts = new ArrayList<>(Arrays.asList(tempProduct1, tempProduct2, tempProduct3, tempProduct4));

			model.addAttribute("mydata", allProducts);
			return "show-product-all-page"; //tiek parādīta show-product-all-page.html lapa
	}

	
	
}
