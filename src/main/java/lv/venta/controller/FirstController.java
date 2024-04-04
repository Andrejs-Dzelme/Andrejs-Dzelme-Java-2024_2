package lv.venta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


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

}
