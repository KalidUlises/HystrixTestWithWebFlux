package ka.ApiTransparente.ApiTransparente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import ka.ApiTransparente.ApiTransparente.FakeJPA.FakeJPA;


@SpringBootApplication
@EnableEurekaClient
public class ApiTransparenteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTransparenteApplication.class, args);
		FakeJPA.createdTheList();
	}

}
