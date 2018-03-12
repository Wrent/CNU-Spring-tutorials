package dk.cngroup.springtraining;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class UniversityConfig {

    @Bean
    @Primary
    public CoffeeMachine expensive() {
        return new ExpensiveCoffeeMachine();
    }

    @Bean
    public CoffeeMachine cheap() {
        return new CheapCoffeeMachine();
    }

}
