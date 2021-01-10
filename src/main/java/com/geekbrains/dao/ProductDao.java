package com.geekbrains.dao;

import com.geekbrains.entity.Product;

import com.geekbrains.factory.GlobalFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDao {

    private GlobalFactory factory;

    @Autowired
    public ProductDao(GlobalFactory factory) {
        this.factory = factory;
    }

    public Optional<Product> findById(Long id){
        Optional<Product> result;
        try (Session session = factory.getFactory().getCurrentSession()){
            result = Optional.ofNullable(session.get(Product.class, id));
        }
        return  result;
    }

    public List<Product> findAll(){
        List<Product> result;
        try (Session session = factory.getFactory().getCurrentSession()){
            result =  session.createQuery("SELECT a FROM Product a", Product.class).getResultList();
        }
        return  result;
    }

    public void deleteById(Long id){
        try (Session session = factory.getFactory().getCurrentSession()){
            session.beginTransaction();
            Query query = session.createQuery("delete Product where id = :ID", Product.class);
            query.setParameter("ID", id);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    public Product saveOrUpdate(Product product){

        try (Session session = factory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
        return  product;
    }
}
