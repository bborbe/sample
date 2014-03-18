package example.gwt_sample.client;

import example.gwt_sample.client.view.HelloWorld;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class GwtSampleEntryPoint implements EntryPoint {

    public void onModuleLoad() {
        final HelloWorld mainView = new HelloWorld();
        RootPanel.get().add(mainView);
    }
}
