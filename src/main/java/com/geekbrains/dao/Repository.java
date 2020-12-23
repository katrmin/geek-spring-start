package com.geekbrains.dao;

import com.geekbrains.entity.Product;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Component
public class Repository {
    private static Long IdGenerator = 0L;
    List<Product> products;

    @PostConstruct
    public void init(){
        products = new ArrayList<>();
    }

    public Product getProductByID(Long id){
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow(RuntimeException::new);
    }

    public List<Product> getALLProducts(){
        return Collections.unmodifiableList(products);
    }

    public Long addProduct(Product product){
        Long id = IdGenerator++;
        products.add(new Product(id, product.getTitle(), product.getCost()));
        return id;
    }

}
