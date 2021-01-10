package com.geekbrains.factory;

import org.hibernate.SessionFactory;

public interface GlobalFactory {
    public SessionFactory getFactory();
}
