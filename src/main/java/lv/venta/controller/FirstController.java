package lv.venta.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lv.venta.model.Product;
import lv.venta.service.ICRUDProductService;
import lv.venta.service.IFilterProductService;

//TODO izveidot divas jaunas kontrolieru klases
//un visus, ka saistīts ar CRUD kontrolieru funkcijām, ielikt vienā klase
//un viu, aks saistīts ar Filter kontrolieru funkcija, ieliekt otrajā klasē

@Controller
public class FirstController {



	@Autowired
	private IFilterProductService filterService;

	@GetMapping("/hello") // localhost:8080/hello
	public String getHello() {
		System.out.println("First Controller!!!");
		return "hello-page"; // tiek parādīta hello-page.html lapa

	}

	@GetMapping("/hello/msg") // localhost:8080/hello/msg
	public String getHelloMsg(Model model) {
		System.out.println("Msg controller is called");
		model.addAttribute("mydata", "Ziņa no JAVA Spring!!!!");
		return "hello-msg-page";// tiek parādīta hello-msg-page.html lapa
	}	
	
	@GetMapping("/error")//localhost:8080/error
	public String getError() {
		return "error-page";
	}
	
	@GetMapping("/product/filter/price/{threshold}")//localhost:8080/product/filter/price/1.5
	public String getProductFilterByPrice(@PathVariable("threshold") float threshold,
			Model model) {
		
		try
		{
			ArrayList<Product> filterProducts 
			= filterService.filterByPriceLessThanThreshold(threshold);
			model.addAttribute("mydata", filterProducts);
			model.addAttribute("msg", "Products filtered by price: " + threshold + " eur");
			return "product-all-show-page";// tiek parādīta product-all-show-page.html lapa

		}
		catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";// tiek parādīta error-page.html lapa
		}
	
	}
	
	
	
	//TODO uztaisām kontrolierus visām pārējām filterService funkcijām un notetsējam
	@GetMapping("/product/filter/quantity/{threshold}")//localhost:8080/product/filter/quantity/20
	public String getProductFilterByQuantity(@PathVariable("threshold") int threshold,
			Model model) {
		
		try
		{
			ArrayList<Product> filterProducts 
			= filterService.filterByQuantityLessThanThreshold(threshold);
			model.addAttribute("mydata", filterProducts);
			model.addAttribute("msg", "Products filtered by quantity: " + threshold );
			return "product-all-show-page";// tiek parādīta product-all-show-page.html lapa

		}
		catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";// tiek parādīta error-page.html lapa
		}
	
	}
	
	@GetMapping("/product/filter/text/{text}")//localhost:8080/product/filter/text/Sarkans
	public String getProductFilterByText(@PathVariable("text") String text,
			Model model) {
		
		try
		{
			ArrayList<Product> filterProducts 
			= filterService.filterByTitleOrDescription(text);
			model.addAttribute("mydata", filterProducts);
			model.addAttribute("msg", "Products filtered by text: " + text );
			return "product-all-show-page";// tiek parādīta product-all-show-page.html lapa

		}
		catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";// tiek parādīta error-page.html lapa
		}
	
	}
	
	
	@GetMapping("/product/calculate/total")//localhost:8080/product/calculate/total
	public String getProductCaluclateTotal(Model model) {
		try {
			float result = filterService.calculateProductsTotalValue();
			model.addAttribute("mydata", "Total value of all products is " + result + " eur");
			return "hello-msg-page";// tiek parādīta hello-msg-page.html lapa
		} catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";// tiek parādīta error-page.html lapa
		}
	}
	
	
	
}