package io.netty.util.concurrent;

/* loaded from: classes5.dex */
public interface EventExecutorChooserFactory {

    /* loaded from: classes5.dex */
    public interface EventExecutorChooser {
        EventExecutor next();
    }

    EventExecutorChooser newChooser(EventExecutor[] eventExecutorArr);
}
