package ru.alex.spring.database.service;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alex.spring.database.model.Person;
import ru.alex.spring.database.repositorys.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @Transactional
    public void save(Person person){
        personRepository.save(person);
    }
    @Transactional
    public void delete(Integer id){
        personRepository.deleteById(id);
    }

    public List<Person> index(){
        return personRepository.findAll();
    }

    public Person find(Integer id){
       Person person = personRepository.findById(id).orElse(null);
        return person;
    }

    @Transactional
    public void update(Integer id, Person person){
        person.setId(id);
        personRepository.save(person);
    }

    public Optional<Person> getPersonByFullName(String fullName){
        return personRepository.findByFullName(fullName);
    }

}