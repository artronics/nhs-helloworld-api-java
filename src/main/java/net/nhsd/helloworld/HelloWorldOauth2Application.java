package net.nhsd.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloWorldOauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldOauth2Application.class, args);
    }
}

@RestController
class WebController {

    @RequestMapping("/secured")
    public String securedPage() {
        return "secured content";
    }
}

@Configuration
class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**").authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
    }
}

