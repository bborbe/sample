package example;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.StringReader;

public class Jdom2Sample {

	public static void main(final String[] args) {
		try {
			final String myxml = "<root><child>kid</child></root>";
			final SAXBuilder sb = new SAXBuilder();
			final Document doc = sb.build(new StringReader(myxml));
			System.out.println("child-size: " + doc.getRootElement().getChildren().size());
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
