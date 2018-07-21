package com.example.personaldatamanagement.service.command;

import com.example.personaldatamanagement.dao.entity.Person;
import com.example.personaldatamanagement.dao.entity.PersonRepository;
import com.example.personaldatamanagement.service.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonCommandService {

    private PersonRepository personRepository;

    @Autowired
    public PersonCommandService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void create(Person person) {
        personRepository.save(person);
    }

    public void update(Person person, Long id) {
        Person dbPerson = personRepository.getOne(id);

        if (dbPerson == null) {
            throw new PersonNotFoundException();
        } else {
            dbPerson.setFirstName(person.getFirstName());
            dbPerson.setSecondName(person.getSecondName());
            dbPerson.setPhoneNumber(person.getPhoneNumber());
            dbPerson.setPosition(person.getPosition());
            dbPerson.setDateOfBirth(person.getDateOfBirth());
        }
        personRepository.save(dbPerson);
    }

    public void delete(Long id) {
        Person personToDelete = personRepository.getOne(id);

        personRepository.delete(personToDelete);

    }
}
