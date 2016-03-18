package example;

import org.junit.Test;

import java.io.IOException;

public class MainTest {

	@Test(expected = IOException.class)
	public void testExec() throws Exception {
		Main.exec("localhost", 1234, "user", "pass");
	}
}
