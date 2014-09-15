package example.gwt_sample.client.model;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

@RemoteServiceRelativePath("MyService")
public interface MyService extends RemoteService {

	public String upperCase(String s);

	public static class Util {

		private static MyServiceAsync instance;

		public static MyServiceAsync getInstance() {
			if (instance == null) {
				instance = (MyServiceAsync) GWT.create(MyService.class);
				final ServiceDefTarget target = (ServiceDefTarget) instance;
				target.setServiceEntryPoint(GWT.getModuleBaseURL() + "MyService");
			}
			return instance;
		}
	}
}
