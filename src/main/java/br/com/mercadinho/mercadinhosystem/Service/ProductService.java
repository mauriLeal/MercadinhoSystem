package br.com.mercadinho.mercadinhosystem.Service;


import br.com.mercadinho.mercadinhosystem.Model.Product;
import br.com.mercadinho.mercadinhosystem.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product findProductById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o id: "+id));
    }

    public Product updateProduct(Long id, Product newProduct){
        Product existingProduct = productRepository.findById(id);
        if (newProduct.getProductName() != null){

        }
    }

    public Product deleteProduct(Long id){
        return productRepository.delete(findProductById(id));
    }
}

