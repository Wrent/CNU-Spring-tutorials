package dk.cngroup.cnu.cnuspringdemo;

import org.springframework.stereotype.Component;

@Component
public class CheapCoffeeMachine implements CoffeeMachine {
    @Override
    public void serveCoffee(Student student) {
        System.out.println("Sorry, it's broken");
    }
}
