package capstone.openjob.oauth2;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 *The @EnableResourceServer annotation adds a filter of type OAuth2AuthenticationProcessingFilter automatically
 *to the Spring Security filter chain.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
//                .cors().disable()
            .headers()
                .frameOptions()
                .disable()
                .and()
            .authorizeRequests()
                .antMatchers("/","/home","/register","/login"
                        ,"/swagger-ui**","/v2/api-docs", "/webjars/**"
                        ,"/swagger-resources/**","/configuration/**"
                        ,"/linkedin/**"
                        ,"/v1/account-mananagement/account"
                        ,"/v1/paypal/pay/**","/pay/**").permitAll()
                .anyRequest().authenticated()
                .and().cors();
//                .and().csrf();
    }
}
