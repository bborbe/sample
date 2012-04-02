package sample;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	@Override
	public void start(final BundleContext context) throws Exception {
		System.err.println("sample bundle started");
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		System.err.println("sample bundle stopped");
	}

}
