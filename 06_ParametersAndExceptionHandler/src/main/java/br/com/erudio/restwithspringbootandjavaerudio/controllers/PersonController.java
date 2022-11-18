package br.com.erudio.restwithspringbootandjavaerudio.controllers;

import br.com.erudio.restwithspringbootandjavaerudio.model.Person;
import br.com.erudio.restwithspringbootandjavaerudio.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final AtomicLong counter = new AtomicLong();

    @Autowired      // cuida da instanciação do objeto de forma dinâmica em tempo de execução, para usar o Autowired, la na classe tem que ter o @Service, como em PersonServices
    private PersonService service;
    // private PersonServices service = new PersonServices(); não preicsa fazer isso por causa do Autowired
    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> findById(@PathVariable(value = "id") Long id) {
        Person person = service.findById(id);
        return ResponseEntity.ok().body(person);
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        List<Person> people = service.findAll();
        System.out.println(people);
        return ResponseEntity.ok().body(people);
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person){
        Person entity = service.create(person);
        return ResponseEntity.ok().body(entity);
    }

    @PutMapping
    public ResponseEntity<Person> update(@RequestBody Person person){
        Person entity = service.update(person);
        return ResponseEntity.ok().body(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Person> delete(@PathVariable(value = "id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }




}
