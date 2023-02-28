package info.techland.myapp.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import info.techland.myapp.services.spi.PluginService;

@Configuration
public class SpiConfiguration {

    @Bean
    public PluginService getPluginService() {
        return PluginService.getInstance();
    }
}
