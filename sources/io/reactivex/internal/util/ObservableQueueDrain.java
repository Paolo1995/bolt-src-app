package io.reactivex.internal.util;

import io.reactivex.Observer;

/* loaded from: classes5.dex */
public interface ObservableQueueDrain<T, U> {
    void a(Observer<? super U> observer, T t7);

    int b(int i8);

    boolean c();

    boolean d();

    Throwable i();
}
