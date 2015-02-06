package example;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class MyGuiceServletConfigTest {

	@org.junit.Test
	public void testGetInjector() throws Exception {
		final MyGuiceServletConfig myGuiceServletConfig = new MyGuiceServletConfig();
		assertThat(myGuiceServletConfig.getInjector(), is(notNullValue()));
	}
}
