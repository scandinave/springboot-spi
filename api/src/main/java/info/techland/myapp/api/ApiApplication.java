package info.techland.myapp.api;

import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import info.techland.myapp.services.spi.pluginProvider.Plugin;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	public ServiceLoaderFactoryBean pluginServiceListFactoryBean() {
		ServiceLoaderFactoryBean factoryBean = new ServiceLoaderFactoryBean();
		factoryBean.setServiceType(Plugin.class);
		return factoryBean;
	}

}
