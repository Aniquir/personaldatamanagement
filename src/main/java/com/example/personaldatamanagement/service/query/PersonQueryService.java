package com.example.personaldatamanagement.service.query;

import com.example.personaldatamanagement.dao.entity.Person;
import com.example.personaldatamanagement.dao.entity.PersonRepository;
import com.example.personaldatamanagement.service.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonQueryService {

    private PersonRepository personRepository;

    @Autowired
    public PersonQueryService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Iterable<Person> findAll(){
        return personRepository.findAll();
    }

//    in refactoring mode: check OPTIONAL option instead traditional
    public Optional<Person> findById(Long id){

        return personRepository.findById(id);
    }
}