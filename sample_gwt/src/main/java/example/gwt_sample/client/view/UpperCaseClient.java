package example.gwt_sample.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class UpperCaseClient extends Composite {

	public UpperCaseClient() {
		VerticalPanel panel = new VerticalPanel();
		initWidget(panel);
		Label inputLabel = new Label("Eingabe:");
		final TextBox input = new TextBox();
		Label textAreaLabel = new Label("Ergebnis:");
		final TextArea textArea = new TextArea();
		textArea.setReadOnly(true);

		Button button = new Button("Submit", new ClickHandler() {
			public void onClick(ClickEvent event) {
				// Window.alert("UC: " + );
				textArea.setValue(input.getValue().toUpperCase());
			}
		});

		panel.setStyleName("main-panel");
		panel.add(new HTML("<h1>UpperCase Client Sample!</h1>"));
		panel.add(inputLabel);
		panel.add(input);
		panel.add(textAreaLabel);
		panel.add(textArea);
		panel.add(button);
	}
}
