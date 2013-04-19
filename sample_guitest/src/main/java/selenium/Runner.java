package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {

	private static final Logger logger = LoggerFactory.getLogger(Runner.class);

	public static void main(String[] args) {
		Runner runner = new Runner();
		runner.run();
	}

	public Runner() {
	}

	public void run() {
		WebDriver driver = null;
		try {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("http://www.heise.de");
		} catch (Exception e) {
			logger.error("Exception", e);
		} finally {
			if (driver != null)
				driver.close();
		}
	}
}
