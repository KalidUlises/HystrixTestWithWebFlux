package ka.orchestator.orchestarottestWEbflux.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class ServiceData3 {
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceData3.class);
	
	
	@Autowired
	WebClient.Builder webClientBuilder3;
	
	
	public Mono<String> Getone_fallback( int id){
		logger.info("Metodo asignado al fallback");
		return webClientBuilder3.baseUrl("http://micro").build().post()
				.uri("/validator2")
				.retrieve()
				.bodyToMono(String.class);
	}

}
