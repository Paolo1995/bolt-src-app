package io.reactivex.internal.fuseable;

import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public interface ScalarCallable<T> extends Callable<T> {
    @Override // java.util.concurrent.Callable
    T call();
}