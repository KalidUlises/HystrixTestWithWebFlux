package ka.orchestator.orchestarottestWEbflux.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ka.orchestator.orchestarottestWEbflux.models.Response;
import ka.orchestator.orchestarottestWEbflux.service.ServiceData;
import ka.orchestator.orchestarottestWEbflux.service.ServiceData2;
import ka.orchestator.orchestarottestWEbflux.service.ServiceData3;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RestController
public class OrchestarottestWEbfluxController {
	
	@Autowired
	ServiceData serviceData; 
	@Autowired
	ServiceData2 serviceDAta2;
	@Autowired
	ServiceData3 serviceData3;
	
	@GetMapping(value = "/Get/{id}")
	public Mono<Response> Getone(@Valid @PathVariable int id) {
		return serviceData.returnData(id); 
	}
	
	@GetMapping(value = "/Getall")
	public Flux<Response> GetAll(){
		return serviceDAta2.GetData();
	
	}

	@GetMapping(value = "/Get2/{id}")
	public Mono<String> Getone2(@Valid @PathVariable int id){
		return serviceData3.Getone_fallback(id);
	
	}


	
}