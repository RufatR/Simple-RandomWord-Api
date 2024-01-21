package az.div.springdemo.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RandomWordConfig {



    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
