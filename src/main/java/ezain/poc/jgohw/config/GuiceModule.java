package ezain.poc.jgohw.config;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.servlet.RequestScoped;
import com.googlecode.objectify.ObjectifyFilter;
import ezain.poc.jgohw.dao.HelloDao;
import ezain.poc.jgohw.dao.impl.HelloDaoImpl;

public class GuiceModule extends AbstractModule {
    public GuiceModule() { }

    @Override
    public void configure() {
        bind(ObjectifyFilter.class).in(Singleton.class);
        bind(HelloDao.class).to(HelloDaoImpl.class).in(RequestScoped.class);
    }
}
