package br.gov.serpro.dojo003.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SMSSender {

	private List<SMS> messagesSent = new ArrayList<SMS>();
	private Map<String, Integer> messageCounter = new HashMap<String, Integer>();
	private Long debit = 0L;

	public void send(String number, String message, Network network) throws NetworkException {
		debit(network);
		log(number);
		checkAvailability(network);
		archiveMessage(number, message);
		incrementMessageCounterFor(number);
	}

	private void archiveMessage(String number, String message) throws NetworkException {
		messagesSent.add(new SMS(number, message));
	}

	private void incrementMessageCounterFor(String number) throws NetworkException {
		Integer messagesSent = messageCounter.get(number) == null ? 1 : messageCounter.get(number);
		if (messagesSent > 3)
			throw new NetworkException(MessageFormat.format("[INFO] You had already sent 3 messages for number {0}",
					number));

		messageCounter.put(number, messagesSent + 1);
	}

	private void debit(Network network) throws NetworkException {
		debit += network.getSMSTax();
	}

	private void checkAvailability(Network network) throws NetworkException {
		if (isNotAvailable(network))
			throw new NetworkException(MessageFormat.format("[INFO] Could not send message through network {0}.",
					network.toString()));
	}

	public Long getDebit() {
		return debit;
	}

	public List<SMS> getMessagesSent() {
		return messagesSent;
	}

	private boolean isNotAvailable(Network network) {
		return messagesSent.size() != 0 && messagesSent.size() % network.getAvailability() == 0;
	}

	private void log(String number) {
		System.out.println(MessageFormat.format("*** Sending SMS to {0} ***", number));
		System.out.println(MessageFormat.format("*** Your current debit is {0} ***", debit));
	}

}
