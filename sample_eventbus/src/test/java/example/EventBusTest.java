package example;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class EventBusTest {

    @Test
    public void testMatchingEvent() throws Exception {
        final EventBus eventBus = new EventBus();
        final Counter counter = new Counter();

        eventBus.post(new EventA());
        assertThat(counter.getCounter(), is(0));
        eventBus.register(new Object() {

            @Subscribe
            public void count(final EventA event) {
                counter.increase();
            }

        });
        assertThat(counter.getCounter(), is(0));
        eventBus.post(new EventA());
        assertThat(counter.getCounter(), is(1));
    }

    @Test
    public void testMissMatchingEvent() throws Exception {
        final EventBus eventBus = new EventBus();
        final Counter counter = new Counter();

        eventBus.post(new EventA());
        assertThat(counter.getCounter(), is(0));
        eventBus.register(new Object() {

            @Subscribe
            public void count(final EventB event) {
                counter.increase();
            }

        });
        assertThat(counter.getCounter(), is(0));
        eventBus.post(new EventA());
        assertThat(counter.getCounter(), is(0));
    }
}
