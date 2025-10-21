package br.com.mercadinho.mercadinhosystem.Dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDTO {

    private String name;

    @Email(message = "Formato de email inválido")
    private String email;
}
