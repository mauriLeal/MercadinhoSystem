package br.com.mercadinho.mercadinhosystem.Service;


import br.com.mercadinho.mercadinhosystem.Model.Product;
import br.com.mercadinho.mercadinhosystem.Repository.ProductRepository;
import br.com.mercadinho.mercadinhosystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o id: " + id ));
        if (newProduct.getProductName() != null){
            existingProduct.setProductName(newProduct.getProductName());
        }
        if (newProduct.getProductAmount() != null){
            existingProduct.setProductAmount(newProduct.getProductAmount());
        }

        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id){
        Product deleteProduct = findProductById(id);
        productRepository.delete(deleteProduct);
    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }
}

