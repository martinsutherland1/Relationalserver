package dataEndPoint.dataEndPoint.controllers;

import dataEndPoint.dataEndPoint.models.Person;
import dataEndPoint.dataEndPoint.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    // INDEX
    @GetMapping(value = "/data")
    public ResponseEntity<List<Person>> getObjects() {
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    // GET
    @GetMapping(value = "/data/{id}")
    public ResponseEntity getObject(@PathVariable Long id) {
        return new ResponseEntity<>(personRepository.findById(id), HttpStatus.OK);
    }

    // POST
    @PostMapping(value = "/data")
    public ResponseEntity<Person> postObject(@RequestBody Person person) {
        personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    // UPDATE
    @PatchMapping(value = "/data/{id}")
    public ResponseEntity<Person> updateObject(@PathVariable Person person) {
        personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping(value = "/data/{id}")
    public ResponseEntity<Person> deleteObject(@PathVariable Long id) {
        Person found = personRepository.getById(id);
        personRepository.delete(found);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
