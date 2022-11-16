package br.com.erudio.restwithspringbootandjavaerudio.services;

import br.com.erudio.restwithspringbootandjavaerudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){
        logger.info("Finding one person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Caio");
        person.setLastName("Lobo");
        person.setAddress("Vitória da Conquista - Bahia - Brasil");
        person.setGender("Male");
        return person;
    }

    public List<Person> findAll(){
        List<Person> people = new ArrayList<>();
        for(int i = 0; i < 8; i++){;
            Person person = mockPerson(i);
            people.add(person);
        }
        return people;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAddress("Address " + i);
        person.setGender("Male");
        return person;
    }


}
