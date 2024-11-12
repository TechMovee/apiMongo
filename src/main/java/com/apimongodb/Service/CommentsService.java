package com.apimongodb.Service;

import com.apimongodb.Model.Comments;
import com.apimongodb.Repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CommentsService {

    private final CommentsRepository repository;

    public CommentsService(CommentsRepository repository) {
        this.repository = repository;
    }

    public List<Comments> findAll() {
        return repository.findAll();
    }

    public Comments save(Comments comment) {
        return repository.save(comment);
    }

}
