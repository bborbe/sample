package example;

import com.google.common.eventbus.Subscribe;

public class BlaC {

    @Subscribe
    public void methodC(final EventC e) {
        System.out.println("methodC");
    }

}
