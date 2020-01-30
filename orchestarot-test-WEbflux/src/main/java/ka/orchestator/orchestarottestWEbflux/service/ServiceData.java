package ka.orchestator.orchestarottestWEbflux.service;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.HystrixCommands;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.netflix.hystrix.HystrixCommandProperties;

import ka.orchestator.orchestarottestWEbflux.Error.ClientServerException;
import ka.orchestator.orchestarottestWEbflux.Error.ErrorHandler;
import ka.orchestator.orchestarottestWEbflux.models.Response;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.retry.Retry;

@Service
public class ServiceData {
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceData.class);
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	private WebClient.Builder webClientBuilder2;
	
	@Autowired
	private ErrorHandler errorHandler;
	
	public Retry<Object> fixedRestry = Retry.anyOf(ClientServerException.class) //anyof, to pass any type of exception
			.fixedBackoff(Duration.ofSeconds(2)) //whiting every attempt ill sleep # seconds and then try again
			.retryMax(30) //how many times
			.doOnRetry((exception) ->{
				logger.info("Exception in {} .", exception);
				System.out.println("Se ha reintentado conectar con el servicio");
			}
			);
	
	//@HystrixCommand(fallbackMethod = "GetoneFallback", 	commandKey = "doSomethingKey")
	public Mono<Response> returnData(int id){
		System.out.println("###########################################  metodo asignado al endpoitn");
		
		Mono<Response> MonoResponse =  webClientBuilder.baseUrl("http://Transparent-API").build().post()
				.uri("/Getone/{id}",id)
				.retrieve()
				.onStatus(org.springframework.http.HttpStatus::is4xxClientError,clientResponse -> errorHandler.handler4xxError(clientResponse))
				.onStatus(org.springframework.http.HttpStatus::is5xxServerError,clientResponse -> errorHandler.handler5xxServer(clientResponse))
				.bodyToMono(Response.class)
				.subscribeOn(Schedulers.elastic())
				.retryWhen(fixedRestry);
	
		return HystrixCommands.from(MonoResponse)
			.fallback(GetoneFallback(id))
			.commandName("returnData")
			.commandProperties(HystrixCommandProperties.defaultSetter()
					.withCircuitBreakerEnabled(true) //This property determines whether a circuit breaker will be used to track health and to short-circuit requests if it trips.
					.withCircuitBreakerRequestVolumeThreshold(5) //This property sets the minimum number of requests in a rolling window that will trip the circuit.
					.withCircuitBreakerSleepWindowInMilliseconds(10) //time after the CB will redirection to the normal method instead of the fallback method
					.withCircuitBreakerErrorThresholdPercentage(100) //percentage of the error requests
					.withExecutionTimeoutInMilliseconds(60000)//time out to return a fallback response (if you have retry method maybe some will not be executed)
					).toMono().subscribeOn(Schedulers.elastic());
	}
	




	public Mono<Response> GetoneFallback( int id){
		logger.info("Metodo asignado al fallback");
		System.out.println("=========================================== metodo asignado al fallback");
		return webClientBuilder2.baseUrl("http://micro").build().post()
				.uri("/validator2")
				.retrieve()
				.bodyToMono(Response.class);
	}
	
	
}
