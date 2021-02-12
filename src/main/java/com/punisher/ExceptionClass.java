package com.punisher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionClass {
	@GetMapping("except")
	public void get_exception() throws Throwable{
		System.out.println("SONIC Exception initiated");
		throw new Exception("SONIC ERROR");
	}
}
