package dk.cngroup.springtraining;

import org.springframework.stereotype.Component;

public class ExpensiveCoffeeMachine implements CoffeeMachine {
    @Override
    public void serveCoffee(Student student) {
        System.out.println("Serving coffee to "+ student.getName());
        student.makeHappy();
    }
}
