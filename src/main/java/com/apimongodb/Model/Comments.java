package com.apimongodb.Model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Comment")
@ToString
@Getter
@Setter
public class Comments {

    @NotBlank(message = "O CPF não pode ser vazio")
    @CPF(groups= CPF.class)
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "O CPF deve estar no formato 000.000.000-00")
    private String cpf;

    @NotBlank(message = "O comentário não pode ser vazio")
    @Size(min = 5, message = "O comentário deve ter pelo menos 5 caracteres")
    private String comment;

    @Min(value = 1, message = "Avaliação deve ser pelo menos 1")
    @Max(value = 5, message = "Avaliação não pode ser maior que 5")
    private double avaliation;

    @Min(value = 1, message = "O ano deve ser maior que 1")
    private int year;
}



