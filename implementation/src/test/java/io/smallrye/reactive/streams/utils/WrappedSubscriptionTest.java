package io.smallrye.reactive.streams.utils;

import org.junit.Test;
import org.reactivestreams.Subscription;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;

public class WrappedSubscriptionTest {


    @Test
    public void testWrappedSubscription() {
        Subscription subscription = new Subscription() {
            @Override
            public void request(long n) {

            }

            @Override
            public void cancel() {

            }
        };

        WrappedSubscription wrapped = new WrappedSubscription(subscription, null);
        assertThat(wrapped).isNotNull();
        wrapped.request(10);
        wrapped.cancel();
    }

    @Test
    public void testWrappedSubscriptionWithCompletionCallback() {
        Subscription subscription = new Subscription() {
            @Override
            public void request(long n) {

            }

            @Override
            public void cancel() {

            }
        };
        AtomicBoolean called = new AtomicBoolean();
        WrappedSubscription wrapped = new WrappedSubscription(subscription, () -> called.set(true));
        assertThat(wrapped).isNotNull();
        wrapped.request(10);
        wrapped.cancel();
        assertThat(called).isTrue();
    }

}