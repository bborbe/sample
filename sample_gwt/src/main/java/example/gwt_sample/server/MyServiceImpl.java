package example.gwt_sample.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import example.gwt_sample.client.model.MyService;

public class MyServiceImpl extends RemoteServiceServlet implements MyService {

	private static final long serialVersionUID = 9184447162140601834L;

	public String upperCase(final String s) {
		return s.toUpperCase();
	}

}
