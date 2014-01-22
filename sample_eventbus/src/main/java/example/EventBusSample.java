package example;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class EventBusSample {

	public static void main(final String[] args) {
		final EventBus eventBus = new EventBus();

		System.out.println("register AB");
		eventBus.register(new BlaAb());
		System.out.println("register C");
		eventBus.register(new BlaC());

		System.out.println("post a");
		eventBus.post(new EventA());

		System.out.println("post b");
		eventBus.post(new EventB());

		System.out.println("post c");
		eventBus.post(new EventC());

	}

}

class BlaAb {

	@Subscribe
	public void methodA(final EventA e) {
		System.out.println("methodA");
	}

	@Subscribe
	public void methodB(final EventB e) {
		System.out.println("methodB");
	}

}

class BlaC {

	@Subscribe
	public void methodC(final EventC e) {
		System.out.println("methodC");
	}

}

class EventA {

}

class EventB {

}

class EventC {

}