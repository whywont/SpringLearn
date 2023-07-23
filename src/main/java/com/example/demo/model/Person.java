package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;
import javax.validation.constraints.NotBlank;
import java.util.UUID;
public class Person {
    private final UUID id;
    @NotBlank
    private final String firstName;

    private final String lastName;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("firstName") String firstName,
                    @JsonProperty("lastName") String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() { return lastName; }

    @Override
    public String toString() {
        return "Person{" +
                "Id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName +
                '}';
    }
}
