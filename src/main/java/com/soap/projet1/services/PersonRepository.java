

package com.soap.projet1.services;


import com.baeldung.springsoap.client.gen.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
@Component
public interface PersonRepository extends CrudRepository<Person, Long> {
}


