package com.noah.solo.domain.person.respository;

import com.noah.solo.domain.person.domain.Person;
import org.springframework.data.repository.CrudRepository;


public interface PersonRepository extends CrudRepository<Person,String> {
}
