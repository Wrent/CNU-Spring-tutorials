package dk.cngroup.springtraining;

import org.springframework.stereotype.Component;

public class CheapCoffeeMachine implements CoffeeMachine {
    @Override
    public void serveCoffee(Student student) {
        System.out.println("Sorry, it's broken!");
    }
}
