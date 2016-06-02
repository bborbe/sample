package example;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.openmbean.CompositeData;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;

public class Main {

	public static void main(final String[] args) {
		if (args.length != 4) {
			System.err.println("usage: host port user password");
			System.exit(1);
		}
		try {
			System.out.println(exec(args[0], Integer.parseInt(args[1]), args[2], args[3]));
		} catch (final Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static Object exec(final String host, final int port, final String user, final String password) throws IOException, MalformedObjectNameException, AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException {
		final HashMap map = new HashMap();
		final String[] credentials = new String[2];
		credentials[0] = user;
		credentials[1] = password;
		map.put("jmx.remote.credentials", credentials);
		final JMXConnector c = JMXConnectorFactory.newJMXConnector(createConnectionURL(host, port), map);
		c.connect();
		final Object o = c.getMBeanServerConnection().getAttribute(new ObjectName("java.lang:type=Memory"), "HeapMemoryUsage");
		final CompositeData cd = (CompositeData) o;
		return cd.get("committed");
	}

	private static JMXServiceURL createConnectionURL(final String host, final int port) throws MalformedURLException {
		return new JMXServiceURL("rmi", "", 0, "/jndi/rmi://" + host + ":" + port + "/jmxrmi");
	}

}
