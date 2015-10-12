package ezain.poc.jgohw.rest;

import ezain.poc.jgohw.dao.impl.HelloDaoImpl;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import ezain.poc.jgohw.domain.Hello;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;

public class HelloResourceTest {

    private static LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
    private static HelloResource helloResource = spy(new HelloResource(new HelloDaoImpl()));

    @Before
    public void setUp() throws Exception {
        helper.setUp();
    }

    @After
    public void tearDown() throws Exception {
        helper.tearDown();
    }

    @Test
    public void shouldGenerateIdAtCreation () {
        Hello hello = new Hello();
        hello.setName("test");

        helloResource.saveItem(hello);

        assertThat(hello.getId()).isNotNull();
    }

}
