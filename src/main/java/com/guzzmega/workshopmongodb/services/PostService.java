package com.guzzmega.workshopmongodb.services;

import com.guzzmega.workshopmongodb.domain.Post;
import com.guzzmega.workshopmongodb.repositories.PostRepository;
import com.guzzmega.workshopmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Optional<Post> post = repo.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime());
        return repo.fullSearch(text, minDate, maxDate);
    }
}
