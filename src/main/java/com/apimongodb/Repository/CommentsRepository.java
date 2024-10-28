package com.apimongodb.Repository;

import com.apimongodb.Model.Comments;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentsRepository extends MongoRepository<Comments, String> {
}
