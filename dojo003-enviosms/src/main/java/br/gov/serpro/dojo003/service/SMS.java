package br.gov.serpro.dojo003.service;

import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;

public class SMS {

	private String number;
	private String message;

	public SMS() {
	}

	public SMS(String number, String message) throws NetworkException {
		setNumber(number);
		setMessage(message);
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) throws NetworkException {
		if (!StringUtils.isNumeric(number) || number.length() != 8)
			throw new NetworkException(MessageFormat.format("[INFO] Invalid number: {0}", number));
		this.number = number;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) throws NetworkException {
		if (message.length() > 140)
			throw new NetworkException("[INFO] Your message could not pass 140 characters.");
		this.message = message;
	}

}
