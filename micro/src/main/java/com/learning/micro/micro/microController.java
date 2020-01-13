package com.learning.micro.micro;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class microController {


	@PostMapping("/validator")
	public String validator(@Valid @RequestBody Request request )
	{
		return "Acceso validator";
	}
	
	@PostMapping("/validator2")
	public Response validator()
	{
		return new Response(00, "Prueba", "Micro", "se ha entrado al fallback del orquestador");
	}
	
	
}
