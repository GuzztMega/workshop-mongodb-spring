package com.guzzmega.workshopmongodb.resources;

import com.guzzmega.workshopmongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        User mary = new User("1", "Mary Brown", "mary@hotmail.com");
        User alex = new User("2", "Alex Gray", "alex@yahoo.com");

        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(mary,alex));
        return ResponseEntity.ok().body(list);
    }
}
