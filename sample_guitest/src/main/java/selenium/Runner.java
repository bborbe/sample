package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {

	private static final Logger logger = LoggerFactory.getLogger(Runner.class);

	public static void main(final String[] args) {
		final Runner runner = new Runner();
		runner.run();
	}

	public Runner() {
	}

	public void run() {
		WebDriver driver = null;
		try {
			driver = new FirefoxDriver();

			// http://docs.seleniumhq.org/docs/04_webdriver_advanced.jsp
			// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("http://www.heise.de");

			logger.debug("title: " + driver.getTitle());
			logger.debug("currentUrl: " + driver.getCurrentUrl());
			logger.debug("pageSource.length: " + driver.getPageSource().length());
			logger.debug("windowHandle: " + driver.getWindowHandle());
			logger.debug("windowHandles: " + driver.getWindowHandles());

			driver.findElement(By.xpath("//*[@id=\"themen_aktuell\"]/ol/li[4]/a")).click();

			logger.debug("text: " + driver.findElement(By.xpath("//*[@id=\"mitte_uebersicht\"]/div[1]/h1")).getText());

			logger.debug("title: " + driver.getTitle());
			logger.debug("currentUrl: " + driver.getCurrentUrl());
			logger.debug("pageSource.length: " + driver.getPageSource().length());
			logger.debug("windowHandle: " + driver.getWindowHandle());
			logger.debug("windowHandles: " + driver.getWindowHandles());

		} catch (final Exception e) {
			logger.error("Exception", e);
		} finally {
			if (driver != null)
				driver.close();
		}
	}
}
