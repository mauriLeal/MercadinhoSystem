package br.com.mercadinho.mercadinhosystem.Dto;

import br.com.mercadinho.mercadinhosystem.Model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;

    public UserResponseDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}

