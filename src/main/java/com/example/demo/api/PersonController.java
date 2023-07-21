package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;

import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.Optional;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import javax.validation.Valid;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }


    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping(path= "{id}")

    public Person getPersonById(@PathVariable("id") UUID id) {


        //return personService.getPersonById(id).orElse( null);
        try {
            return personService.getPersonById(id).orElseThrow(
                    () -> new NoSuchElementException("No person with this UUID found in the database"));
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
    @DeleteMapping(path = "{id}")
    public void deletePersonId(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person personToUpdate) {
        personService.updatePerson(id, personToUpdate);
    }



}