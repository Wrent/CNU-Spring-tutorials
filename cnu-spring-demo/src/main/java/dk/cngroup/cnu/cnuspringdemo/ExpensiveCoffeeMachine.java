package dk.cngroup.cnu.cnuspringdemo;

import org.springframework.stereotype.Component;

@Component
public class ExpensiveCoffeeMachine implements CoffeeMachine {
    @Override
    public void serveCoffee(Student student) {
        System.out.println("Serving student " + student.getFirstName() + " with expensive coffee.");
        student.makeHappy();
    }
}
