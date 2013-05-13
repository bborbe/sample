package example;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class EventBusSample {

	public static void main(String[] args) {
		EventBus eventBus = new EventBus();

		System.out.println("register");
		eventBus.register(new EventBusChangeRecorder());

		System.out.println("post a");
		eventBus.post(new EventA());

		System.out.println("post b");
		eventBus.post(new EventB());

		System.out.println("post c");
		eventBus.post(new EventC());

	}

}

class EventBusChangeRecorder {

	@Subscribe
	public void methodA(EventA e) {
		System.out.println("methodA");
	}

	@Subscribe
	public void methodB(EventB e) {
		System.out.println("methodB");
	}

}

class EventA {

}

class EventB {

}

class EventC {

}