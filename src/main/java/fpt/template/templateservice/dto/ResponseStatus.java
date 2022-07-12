package fpt.template.templateservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	@JsonProperty("message")
	private String message;
	@JsonProperty("displayMessage")
	private String displayMessage;

	public ResponseStatus(String code) {
		setCode(code);
	}

	/**
	 * Set the code
	 *
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
		this.displayMessage = this.message;
	}

	public String getCode() {
		return code;
	}
}
