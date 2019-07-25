package mavinproject.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import mavinproject.beans.Car;

@Configuration
@ComponentScan(basePackages="mavinproject.beans")
public class AppConfig {
	/*public Car getCar() {
	return new Car();
	}*/
}
