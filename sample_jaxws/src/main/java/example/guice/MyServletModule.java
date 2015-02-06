package example.guice;

import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class MyServletModule extends ServletModule {

	@Override
	protected void configureServlets() {
		final ResourceConfig rc = new PackagesResourceConfig("example.rest");
		rc.getClasses().forEach(this::bind);

		serve("/rest/*").with(GuiceContainer.class);
	}

}
