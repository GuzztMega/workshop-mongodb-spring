package com.guzzmega.workshopmongodb.config;

import com.guzzmega.workshopmongodb.domain.Post;
import com.guzzmega.workshopmongodb.domain.User;
import com.guzzmega.workshopmongodb.repositories.PostRepository;
import com.guzzmega.workshopmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User mary = new User( null, "Mary Brown", "mary@hotmail.com");
        User alex = new User(null, "Alex Gray", "alex@yahoo.com");
        User bob = new User( null, "Bob White", "bob@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Lets ride!!!", "Heading to the beach...", mary);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Moooorning!", "What a beautiful day", mary);

        userRepository.saveAll(Arrays.asList(mary, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
