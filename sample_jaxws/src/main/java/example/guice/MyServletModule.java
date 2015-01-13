package example.guice;

import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class MyServletModule extends ServletModule {

	@Override
	protected void configureServlets() {
		ResourceConfig rc = new PackagesResourceConfig("example.rest");
		for (Class<?> resource : rc.getClasses()) {
			bind(resource);
		}

		serve("/rest/*").with(GuiceContainer.class);
	}

}
