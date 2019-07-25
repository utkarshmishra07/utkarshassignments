package mavinproject.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages="mavinproject.qanda.beans")
public class AppConfig {
	/*public Car getCar() {
	return new Car();
	}*/
}
