package ezain.poc.jgohw.config;

import com.google.common.collect.Sets;
import com.google.inject.Singleton;
import ezain.poc.jgohw.rest.HelloResource;
import ezain.poc.jgohw.utils.GsonMessageBodyHandler;

import javax.ws.rs.core.Application;
import java.util.Set;

@Singleton
public class MyApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = Sets.newHashSet();
        s.add(GsonMessageBodyHandler.class);
        s.add(HelloResource.class);
        return s;
    }
}
