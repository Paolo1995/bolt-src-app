package io.netty.util;

/* loaded from: classes5.dex */
public interface ResourceLeakTracker<T> {
    boolean close(T t7);

    void record();

    void record(Object obj);
}
