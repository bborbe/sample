package example.gwt_sample.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class HelloWorld extends Composite {

	public HelloWorld() {
		VerticalPanel panel = new VerticalPanel();
		initWidget(panel);
		Widget text = new HTML("<h1>Hello GWT-World Super!</h1>");
		panel.add(text);

	}
}
