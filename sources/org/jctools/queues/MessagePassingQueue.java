package org.jctools.queues;

/* loaded from: classes5.dex */
public interface MessagePassingQueue<T> {
    public static final int UNBOUNDED_CAPACITY = -1;

    /* loaded from: classes5.dex */
    public interface Consumer<T> {
        void accept(T t7);
    }

    /* loaded from: classes5.dex */
    public interface ExitCondition {
        boolean keepRunning();
    }

    /* loaded from: classes5.dex */
    public interface Supplier<T> {
        T get();
    }

    /* loaded from: classes5.dex */
    public interface WaitStrategy {
        int idle(int i8);
    }

    int capacity();

    void clear();

    int drain(Consumer<T> consumer);

    int drain(Consumer<T> consumer, int i8);

    void drain(Consumer<T> consumer, WaitStrategy waitStrategy, ExitCondition exitCondition);

    int fill(Supplier<T> supplier);

    int fill(Supplier<T> supplier, int i8);

    void fill(Supplier<T> supplier, WaitStrategy waitStrategy, ExitCondition exitCondition);

    boolean isEmpty();

    boolean offer(T t7);

    T peek();

    T poll();

    boolean relaxedOffer(T t7);

    T relaxedPeek();

    T relaxedPoll();

    int size();
}
