package capstone.openjob.oauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://open-job-fe.s3-website-ap-southeast-1.amazonaws.com","http://openjob-fe.s3-website-ap-southeast-1.amazonaws.com/", "http://localhost:4200")
                        .allowedMethods("GET", "POST", "OPTIONS", "PUT")
                .allowCredentials(true);
            }
        };
    }
}
