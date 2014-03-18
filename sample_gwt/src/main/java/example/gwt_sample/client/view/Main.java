package example.gwt_sample.client.view;

import example.gwt_sample.client.model.MyService;
import example.gwt_sample.client.model.MyServiceAsync;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Main extends Composite {

    public Main() {
        VerticalPanel panel = new VerticalPanel();
        initWidget(panel);
        Label inputLabel = new Label("Eingabe:");
        final TextBox input = new TextBox();
        Label textAreaLabel = new Label("Ergebnis:");
        final TextArea textArea = new TextArea();
        textArea.setReadOnly(true);

        Button button = new Button("Submit", new ClickHandler() {

            public void onClick(ClickEvent event) {

                MyServiceAsync service = MyService.Util.getInstance();

                service.upperCase(input.getValue(), new AsyncCallback<String>() {

                    // what to do if it works
                    public void onSuccess(String result) {
                        textArea.setValue(result);
                    }

                    // what to do if it fails
                    public void onFailure(final Throwable caught) {
                        Window.alert("failure: " + caught);
                    }
                });

            }
        });

        panel.setStyleName("main-panel");
        panel.add(new HTML("<h1>UpperCase Server Sample!</h1>"));
        panel.add(inputLabel);
        panel.add(input);
        panel.add(textAreaLabel);
        panel.add(textArea);
        panel.add(button);

    }
}
