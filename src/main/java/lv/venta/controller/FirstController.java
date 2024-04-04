package lv.venta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class FirstController {
	
	@GetMapping("/hello")//localhost:8080/hello
	public String getHello() {
		System.out.println("First controller!");
		return "hello-page"; //Parāda lapu.
	}
	
	
}
