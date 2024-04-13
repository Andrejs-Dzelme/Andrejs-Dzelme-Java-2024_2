package lv.venta.controller;


import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import lv.venta.model.Product;
import lv.venta.service.ICRUDProductService;
import lv.venta.service.IFilterProductService;

@Controller
public class FirstController {
	
	@Autowired
	private ICRUDProductService crudService;
	
	@Autowired
	private IFilterProductService filterService;
	
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
		try {
			model.addAttribute("mydata", crudService.retrieveById(1));
			return "product-one-show-page";// tiek parādīta product-one-show-page.html lapa
		} catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";// tiek parādīta error-page.html lapa
		}
					
	}
	@GetMapping("/product/all")//localhost:8080/product/all
	public String getProductAll(Model model) {
		try {
			model.addAttribute("mydata", crudService.retrieveAll());
			return "show-product-all-page";// tiek parādīta show-product-all-page.html lapa
		}
		catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";// tiek parādīta error-page.html lapa
		}
	}

	@GetMapping("/product/one")//localhost:8080/product/one?id=5
	public String getProductOneId(@RequestParam("id")int id, Model model) {
		try
		{
			model.addAttribute("mydata", crudService.retrieveById(id));
			return "product-one-show-page";// tiek parādīta product-one-show-page.html lapa
		}
		catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";// tiek parādīta error-page.html lapa
		}
	}
	
	@GetMapping("/product/all/{id}") //localhost:8080/product/all/2
	public String getProductAllId(@PathVariable("id") int id, Model model) {
		try
		{
			model.addAttribute("mydata", crudService.retrieveById(id));
			return "product-one-show-page";// tiek parādīta product-one-show-page.html lapa
		}
		catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";// tiek parādīta error-page.html lapa
		}
	}	
	
}
