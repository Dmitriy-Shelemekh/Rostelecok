package ru.refactoing;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class People {
    @Value("${people.pensia.age}")
    private int pensiaAge;

    private int age;
    private String firstName;
    private String lastName;
}
