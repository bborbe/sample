package example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class GuiceTest {

    @Test
    public void testModule() throws Exception {
        final Injector injector = Guice.createInjector(new MyModule());
        final Foo instance = injector.getInstance(Foo.class);
        assertThat(instance, is(notNullValue()));
    }
}