package com.poc.jgohw.config;

import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.googlecode.objectify.ObjectifyFilter;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import java.util.Map;

import static org.glassfish.jersey.servlet.ServletProperties.JAXRS_APPLICATION_CLASS;

/**
 * MyApplication listener. <p/>
 * Intercept /api requests and sends them to MyApplication. <p/>
 * Use GuiceModule for dependency injection. <p/>
 */
public class MyGuiceServletContextListener extends GuiceServletContextListener {

    protected Injector getInjector() {

        final Map<String, String> params = Maps.newHashMap();
        params.put(JAXRS_APPLICATION_CLASS, MyApplication.class.getCanonicalName());

        return Guice.createInjector(
                new GuiceModule(),
                new ServletModule() {
                    @Override
                    protected void configureServlets() {
                        filter("/api/*").through(ObjectifyFilter.class);
                        serve("/api/*").with(GuiceContainer.class, params);
                    }
                });
    }
}
