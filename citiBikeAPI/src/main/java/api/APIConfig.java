package api;

import ingester.Service.CitibikeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "api")
public class APIConfig {

    @Bean
    public CitibikeService citibikeService(){
        return new CitibikeService();
    }
}