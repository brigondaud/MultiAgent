package test;

import event.EventManager;
import event.MessageEvent;

public class TestEventManager {
	public static void main(String[] args) throws InterruptedException {

		EventManager manager = new EventManager();

		// PING all the two steps
		for (int i = 2; i <= 10; i += 2) {
			manager.addEvent(new MessageEvent(i, " [ PING ] "));
		}

		// PONG all the three steps
		for (int i = 3; i <= 9; i += 3) {
			manager.addEvent(new MessageEvent(i, " [ PONG ] "));
		}

		while (!manager.isFinished()) {
			manager.next();
			Thread.sleep(1000);
		}

	}

}
