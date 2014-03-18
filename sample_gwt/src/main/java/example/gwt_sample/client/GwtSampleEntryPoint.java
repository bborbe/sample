package example.gwt_sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import example.gwt_sample.client.view.Main;

public class GwtSampleEntryPoint implements EntryPoint {

    public void onModuleLoad() {
        final Main mainView = new Main();
        RootPanel.get().add(mainView);
    }
}
