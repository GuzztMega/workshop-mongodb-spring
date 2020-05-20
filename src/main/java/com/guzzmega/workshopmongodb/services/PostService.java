package com.guzzmega.workshopmongodb.services;

import com.guzzmega.workshopmongodb.domain.Post;
import com.guzzmega.workshopmongodb.repositories.PostRepository;
import com.guzzmega.workshopmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Optional<Post> post = repo.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }
}
