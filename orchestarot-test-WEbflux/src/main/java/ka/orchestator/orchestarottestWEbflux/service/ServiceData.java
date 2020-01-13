package ka.orchestator.orchestarottestWEbflux.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import ka.orchestator.orchestarottestWEbflux.models.Response;
import reactor.core.publisher.Mono;

@Service
public class ServiceData {
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceData.class);
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	private WebClient.Builder webClientBuilder2;
	
	//@HystrixCommand(fallbackMethod = "Getone_fallback")
	public Mono<Response> returnData(int id){
		logger.info("Metodo asignado al endpoint");
		return webClientBuilder.baseUrl("http://Transparent-API").build().post()
				.uri("/Getone/{id}",id)
				.retrieve()
				.bodyToMono(Response.class);
	}

	public Mono<Response> Getone_fallback( int id){
		logger.info("Metodo asignado al fallback");
		return webClientBuilder2.baseUrl("http://micro").build().post()
				.uri("/validator2")
				.retrieve()
				.bodyToMono(Response.class);
	}
	
	
}
