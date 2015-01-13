package example;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Result implements Serializable {

	private static final long serialVersionUID = -3987399108209276676L;

	private Boolean success;

	private String name;

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Boolean isSuccess() {
		return success;
	}

	public void setSuccess(final Boolean success) {
		this.success = success;
	}
}
