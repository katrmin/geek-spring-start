package com.geekbrains.factory;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
@Getter
public class GlobalFactoryImpl implements GlobalFactory {

    private SessionFactory factory;

    @PostConstruct
    private void init() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    @PreDestroy
    public void shutdown() {
        factory.close();
    }
}
