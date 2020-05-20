package com.guzzmega.workshopmongodb.config;

import com.guzzmega.workshopmongodb.domain.Post;
import com.guzzmega.workshopmongodb.domain.User;
import com.guzzmega.workshopmongodb.dto.AuthorDTO;
import com.guzzmega.workshopmongodb.dto.CommentDTO;
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
        User ayron = new User( null, "Ayron Silver", "ayron@gmail.com");

        userRepository.saveAll(Arrays.asList(mary, alex, ayron));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Lets ride!!!", "Heading to the beach...", new AuthorDTO(mary));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Moooorning!", "What a beautiful day", new AuthorDTO(mary));

        CommentDTO c1 = new CommentDTO("Nice trip, bro!", sdf.parse("21/03/2018"), new AuthorDTO(ayron));
        CommentDTO c2 = new CommentDTO("Enjoooy", sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO c3 = new CommentDTO("Have a nice day!", sdf.parse("23/03/2018"), new AuthorDTO(ayron));

        post1.getComments().addAll(Arrays.asList(c1,c2));
        post2.getComments().addAll(Arrays.asList(c3));
        postRepository.saveAll(Arrays.asList(post1, post2));

        mary.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(mary);

    }
}
