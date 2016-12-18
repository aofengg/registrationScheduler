package registrationScheduler.util;

public class Logger {

	public static enum DebugLevel {
		AVERAGE, CONTENTS, RESULTS, THREAD, CONSTRUCTOR
	};

	private static DebugLevel debugLevel;

	public static void setDebugValue(int levelIn) {
		switch (levelIn) {
		case 0:
			debugLevel = DebugLevel.AVERAGE;
			break;
		case 1:
			debugLevel = DebugLevel.CONTENTS;
			break;
		case 2:
			debugLevel = DebugLevel.RESULTS;
			break;
		case 3:
			debugLevel = DebugLevel.THREAD;
			break;
		case 4:
			debugLevel = DebugLevel.CONSTRUCTOR;
			break;
		}
	}

	public static void setDebugValue(DebugLevel levelIn) {
		debugLevel = levelIn;
	}

	// @return None
	public static void writeMessage(String message, DebugLevel levelIn) {
		if (levelIn == debugLevel)
			System.out.println(message);
	}

	public String toString() {
		return "Debug Level is " + debugLevel;
	}
}
