package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/persons")
    public List<Person> list() {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Jan", 21));
        persons.add(new Person("Michael", 21));
        persons.add(new Person("Bob", 21));
        return persons;
    }

    @PostMapping("/persons")
    Person post(@RequestBody PostPerson data ) {
        Person person = new Person(data.name(), 2024 - data.birthDate().getYear());
        return person;
    }

    @GetMapping("/studentnames")
    public List<StudentName> studentnames() {
        return studentRepository.getDistinctBy();
    }

}

record Person(String name, int age) {}
record PostPerson(String name, LocalDate birthDate) {}
