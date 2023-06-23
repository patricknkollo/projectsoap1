

package com.soap.projet1.services;

import com.baeldung.springsoap.client.gen.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Component
public class PersonService {

    private Logger logger = LoggerFactory.getLogger(PersonService.class);
    @Autowired
    private PersonRepository repository;

    public List<Person> findAllEmployees(){
        List<Person> personList = new ArrayList<>();
        repository.findAll().forEach(person -> personList.add(person));
        return personList;
    }

    public Person findPersonByID(Long personid){
        Optional<Person> optionalPerson =  repository.findById(personid);
        if (optionalPerson.isPresent()){
            logger.info("the person with the id {} exists in the database!", personid);
            return optionalPerson.get();
        }
        else {
            logger.warn("the person with the id {} doesn't exist in the database! please check if the given id is right", personid);
            return new Person();
        }
    }

    public void deletePersonByID (Long id){
        Optional<Person> optionalPerson=  repository.findById(id);
        if (optionalPerson.isPresent()){
            logger.info("the person with the id {} exists in the database!", id);
            repository.deleteById(id);
        }
        else {
            logger.warn("the person with the id {} doesn't exist in the database! please check if the given id is right", id);
        }
    }

    public void deletePerson (Person person){
        repository.delete(person);
        logger.info("the person with the name {},{} has been deleted from the database!", person.getPrenom(), person.getNom());
    }
}


