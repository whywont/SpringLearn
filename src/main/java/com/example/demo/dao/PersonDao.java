package com.example.demo.dao;
//contract to use
import com.example.demo.model.Person;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
public interface PersonDao {

    //insert a person

    //Allows us to gernerate UUIDs ourself

    int insertPerson(UUID id, Person person);
    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAllPeople();
}
