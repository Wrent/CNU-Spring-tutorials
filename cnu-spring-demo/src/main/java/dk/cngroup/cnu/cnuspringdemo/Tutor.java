package dk.cngroup.cnu.cnuspringdemo;

import org.springframework.stereotype.Component;

public class Tutor {
    private final String knowledge;

    public Tutor(String knowledge) {
        this.knowledge = knowledge;
    }

    public String getKnowledge() {
        return knowledge;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "knowledge='" + knowledge + '\'' +
                '}';
    }
}
