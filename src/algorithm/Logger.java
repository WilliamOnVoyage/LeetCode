package algorithm;

import java.util.HashMap;

public class Logger {
	/** Initialize your data structure here. */
	private HashMap<String, Integer> log;
	private int interval = 10;

	public Logger() {
		log = new HashMap<>();
	}

	/**
	 * Returns true if the message should be printed in the given timestamp,
	 * otherwise returns false. If this method returns false, the message will
	 * not be printed. The timestamp is in seconds granularity.
	 */
	public boolean shouldPrintMessage(int timestamp, String message) {
		boolean res = false;
		if ((log.containsKey(message) && timestamp - log.get(message) >= interval) || !log.containsKey(message)) {
			res = true;
			log.put(message, timestamp);
		}
		return res;
	}
}
