package com.example.personaldatamanagement.service.query;


import com.example.personaldatamanagement.dao.entity.Person;
import com.example.personaldatamanagement.dao.entity.PersonRepository;
import com.example.personaldatamanagement.service.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    //in refactoring mode: check OPTIONAL option instead traditional
    public Person findById(Long id){
        Person person = personRepository.findOne(id);

        if(person == null){
            throw new PersonNotFoundException();
        }
        return person;
    }
}
