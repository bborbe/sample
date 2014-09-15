package example.gwt_sample.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import example.gwt_sample.client.model.MyService;
import example.gwt_sample.client.model.MyServiceAsync;

public class Main extends Composite {

	public Main() {
		final VerticalPanel verticalPanel = new VerticalPanel();
		final Label inputLabel = new Label("Eingabe:");
		final TextBox input = new TextBox();
		final Label textAreaLabel = new Label("Ergebnis:");
		final TextArea textArea = new TextArea();
		textArea.setReadOnly(true);

		final Button button = new Button("Submit", new ClickHandler() {

			public void onClick(final ClickEvent event) {

				final MyServiceAsync service = MyService.Util.getInstance();

				service.upperCase(input.getValue(), new AsyncCallback<String>() {

					// what to do if it works
					public void onSuccess(final String result) {
						textArea.setValue(result);
					}

					// what to do if it fails
					public void onFailure(final Throwable caught) {
						Window.alert("failure: " + caught);
					}
				});

			}
		});

		verticalPanel.setStyleName("main-verticalPanel");
		verticalPanel.add(new HTML("<h1>UpperCase Server Sample!</h1>"));
		verticalPanel.add(inputLabel);
		verticalPanel.add(input);
		verticalPanel.add(textAreaLabel);
		verticalPanel.add(textArea);
		verticalPanel.add(button);

		final SimplePanel simplePanel = new SimplePanel();
		simplePanel.add(verticalPanel);
		initWidget(verticalPanel);
	}
}
