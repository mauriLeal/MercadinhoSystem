    package br.com.mercadinho.mercadinhosystem.Model;
    
    import jakarta.persistence.*;
    import jakarta.validation.constraints.Min;
    import jakarta.validation.constraints.NotBlank;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;
    
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name = "products")
    public class Product {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
        @Column
        @NotBlank
        private String productName;
    
        @Column
        @Min(0)
        private Integer productAmount;
    
        //Na sua classe de modelo (ex: Product), adicione anotações nos campos:
        // @NotBlank (para strings),
        // @NotNull (para objetos),
        // @Min(0) (para números),
        // @Email (para email).

}