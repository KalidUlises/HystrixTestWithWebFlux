package ka.ApiTransparente.ApiTransparente.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ka.ApiTransparente.ApiTransparente.models.RequestBod;
import ka.ApiTransparente.ApiTransparente.models.Response;
import ka.ApiTransparente.ApiTransparente.service.ApiTransparente;
import ka.ApiTransparente.ApiTransparente.service.ApiTransparenteImp;

@RestController
public class ApiTransparenteController {
	
	 ApiTransparente Api = new ApiTransparenteImp();
	 
	 @PostMapping(value = "/Getone/{id}")
	 public Response GetOne (@Valid @PathVariable int id) {
		 return Api.GetOneId(id);
	 }
	 
	 @PostMapping(value = "/Getonedefault/{id}")
	 public Response GetDefault (@Valid @PathVariable int id) {
		 return Api.GetOneId(1);
	 }
	 
	 @PostMapping(value = "/Getone/name/{name}")
	 public String GetTwo (@Valid @PathVariable String name) {
		 return "the name you entered is: "+name;
	 }
	 
	 @GetMapping(value = "/GetAll")
	 public List<Response> GetAll(){
		 return Api.GetAllId();
	 }
	 
	 @PostMapping(value = "/Change")
	 public String changeOne (@Valid @RequestBody RequestBod requestBod) {
		 return Api.ModifyOneId(requestBod);
	 }
	
	

}
