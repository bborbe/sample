package example;

import com.google.common.eventbus.Subscribe;

public class BlaAb {

    @Subscribe
    public void methodA(final EventA e) {
        System.out.println("methodA");
    }

    @Subscribe
    public void methodB(final EventB e) {
        System.out.println("methodB");
    }

}
