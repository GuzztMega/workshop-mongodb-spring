package com.guzzmega.workshopmongodb.config;

import com.guzzmega.workshopmongodb.domain.User;
import com.guzzmega.workshopmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        User mary = new User( null, "Mary Brown", "mary@hotmail.com");
        User alex = new User(null, "Alex Gray", "alex@yahoo.com");
        User bob = new User( null, "Bob White", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(mary, alex, bob));
    }
}
