

package com.soap.projet1.services;


import com.baeldung.springsoap.client.gen.GetPersonRequest;
import com.baeldung.springsoap.client.gen.GetPersonResponse;
import com.baeldung.springsoap.client.gen.Person;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import java.util.List;

@Endpoint
public class PersonController {

    @Autowired
    private PersonService service;

    private static final String NAMESPACE_URI = "http://localhost:8080/myspringsoap/gen";

    private PersonRepository repository;

    @Autowired
    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonRequest")
    @ResponsePayload
    public GetPersonResponse getPerson(@RequestPayload @NotNull GetPersonRequest request) {
        GetPersonResponse response = new GetPersonResponse();
        response.setPerson(service.findPersonByID(1L));

        return response;
    }

    public List<Person> getAllPersons(){
        return service.findAllEmployees();
    }
}


