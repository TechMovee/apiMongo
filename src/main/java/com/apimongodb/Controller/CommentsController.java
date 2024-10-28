package com.apimongodb.Controller;

import com.apimongodb.Model.Comments;
import com.apimongodb.Service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    // Método para listar todos os comentários
    @GetMapping("/list")
    public ResponseEntity<List<Comments>> getAllComments() {
        List<Comments> commentsList = commentsService.findAll();
        return new ResponseEntity<>(commentsList, HttpStatus.OK);
    }

    // Método para criar um novo comentário
    @PostMapping("/add")
    public ResponseEntity<Object> createComment(
            @Valid @RequestBody Comments comment,
            BindingResult bindingResult) {

        // Verificar se há erros de validação
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }

        Comments savedComment = commentsService.save(comment);
        return new ResponseEntity<>(savedComment, HttpStatus.OK);
    }
}
