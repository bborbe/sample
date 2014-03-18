package example.gwt_sample.client.model;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MyServiceAsync {

    public void upperCase(String s, AsyncCallback<String> callback);
}
