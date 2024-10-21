package com.apimongodb.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Year;

@Document(collection = "Comment")
@ToString
@Getter
@Setter
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotBlank(message = "O comentário não pode ser vazio")
    @Size(min = 5, message = "O comentário deve ter pelo menos 5 caracteres")
    private String comment;

    @Min(value = 1, message = "Avaliação deve ser pelo menos 1")
    @Max(value = 5, message = "Avaliação não pode ser maior que 5")
    private double avaliation;

    @Min(value = 1, message = "O ano deve ser maior que 1")
    private int year;
}

