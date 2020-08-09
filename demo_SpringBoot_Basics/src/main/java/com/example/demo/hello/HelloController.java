package com.example.demo.hello;
import org.springframework.web.bind.annotation.*;
@RestController
public class HelloController {
	@RequestMapping("/hello")
	  public String sayHi() {
		  return "Hi";
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
