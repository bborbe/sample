package example;

import com.google.common.eventbus.EventBus;

public class Main {

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
