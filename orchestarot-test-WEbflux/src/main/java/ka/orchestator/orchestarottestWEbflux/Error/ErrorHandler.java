package ka.orchestator.orchestarottestWEbflux.Error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;

import reactor.core.publisher.Mono;

@Service
public class ErrorHandler {
	
	public ErrorHandler() {
		
	}
	
	Logger logger = LoggerFactory.getLogger(ErrorHandler.class);
	

	public Mono<? extends Throwable > handler4xxError(ClientResponse clientResponse) {
		Mono<String> errorMessage = clientResponse.bodyToMono(String.class);
		return errorMessage.flatMap((message)->{
			logger.info("Error Response is {} ." , message + "and the code is " + clientResponse.rawStatusCode());
			throw new ClientDataException(message);
			});
	}

	public Mono<? extends Throwable > handler5xxServer(ClientResponse clientResponse) {
		Mono<String> errorMessage = clientResponse.bodyToMono(String.class);
		return errorMessage.flatMap((message)->{
			logger.info("Error Response is {} ." , message + "and the code is " + clientResponse.rawStatusCode());
			throw new ClientServerException(message);
			});
	}

}
