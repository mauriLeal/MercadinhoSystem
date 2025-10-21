package br.com.mercadinho.mercadinhosystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    private String name;

    @Column
    @Email
    private String email;

    @Column
    private String password;

    //Na sua classe de modelo (ex: Product), adicione anotações nos campos:
    // @NotBlank (para strings),
    // @NotNull (para objetos),
    // @Min(0) (para números),
    // @Email (para email).
}
