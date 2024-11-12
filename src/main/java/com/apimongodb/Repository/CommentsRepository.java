//package com.apimongodb.Repository;
//
//import com.apimongodb.Model.Comments;
//import org.springframework.data.mongodb.repository.MongoRepository;
//
//public interface CommentsRepository extends MongoRepository<Comments, String> {
//
//}
package com.apimongodb.Repository;

import com.apimongodb.Model.Comments;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends MongoRepository<Comments, String> {
    List<Comments> findByCpf(String cpf);
}

