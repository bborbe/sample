package example;

import org.junit.Test;

public class SayIntegrationTest {

	@Test
	public void testRun() throws Exception {
		final Say say = new Say();
		say.run();
	}
}
