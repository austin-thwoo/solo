package com.noah.solo.domain.person;

import com.noah.solo.domain.person.domain.Person;
import com.noah.solo.domain.person.respository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DefaultDataPopulator implements ApplicationRunner {

    @Autowired
    PersonRepository personRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Person person = new Person();
        person.setAge(28);
        person.setCreatedAt(LocalDateTime.now());
        personRepository.save(person);

        personRepository.findAll().forEach(p -> {
            System.out.println("================");
            System.out.println(p.getAge());

        });


    }

}
