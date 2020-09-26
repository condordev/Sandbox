package de.sgrad.dependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Customer {
    private UUID id;
    private String name;

    @Autowired
    private Capability cap;

    public Capability getCap() {
        return cap;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display(){
        System.out.println("Customer object");
        cap.display();
    }

}
