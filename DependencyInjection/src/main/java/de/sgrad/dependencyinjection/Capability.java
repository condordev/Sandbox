package de.sgrad.dependencyinjection;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Capability {
    // JAVA 8
    List<String> list = Stream.of("one", "two", "three").collect(Collectors.toList());

    // JAVA 9
    // creates immutable lists, so you can't modify such list
    List<String> immutableList = List.of("one", "two", "three");

    // if we want mutable list we can copy content of immutable list to mutable one for instance via copy-constructor (which creates shallow copy)
    List<String> mutableList = new ArrayList<>(List.of("one", "two", "three"));

    public void display(){
        list.forEach(l -> System.out.println(l));
    }
}