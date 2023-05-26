package io.netty.util.internal.shaded.org.jctools.queues;

/* loaded from: classes5.dex */
public interface MessagePassingQueue<T> {

    /* loaded from: classes5.dex */
    public interface Supplier<T> {
        T get();
    }

    T poll();
}
