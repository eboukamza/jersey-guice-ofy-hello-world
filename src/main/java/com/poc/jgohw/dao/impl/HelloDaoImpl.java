package com.poc.jgohw.dao.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.poc.jgohw.dao.HelloDao;
import com.poc.jgohw.domain.Hello;

@Singleton
public class HelloDaoImpl extends GenericDao<Hello> implements HelloDao {
    @Inject
    public HelloDaoImpl() {
        super(Hello.class);
    }
}
