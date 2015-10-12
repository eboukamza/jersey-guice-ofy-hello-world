package ezain.poc.jgohw.dao.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import ezain.poc.jgohw.dao.HelloDao;
import ezain.poc.jgohw.domain.Hello;

@Singleton
public class HelloDaoImpl extends GenericDao<Hello> implements HelloDao {
    @Inject
    public HelloDaoImpl() {
        super(Hello.class);
    }
}
