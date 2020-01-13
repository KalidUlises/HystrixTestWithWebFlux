package ka.orchestator.orchestarottestWEbflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import ka.orchestator.orchestarottestWEbflux.models.Response;
import reactor.core.publisher.Flux;

@Service
public class ServiceData2 {
	
	@Autowired
	WebClient.Builder webClientBuilder;
	
	public Flux<Response> GetData (){
		return webClientBuilder.build().get()
				.uri("/GetAll")
				.retrieve()
				.bodyToFlux(Response.class);
	}

}
