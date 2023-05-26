package com.jakewharton.rxrelay2;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/* loaded from: classes3.dex */
public abstract class Relay<T> extends Observable<T> implements Consumer<T> {
    public abstract void accept(T t7);

    public final Relay<T> c() {
        if (this instanceof SerializedRelay) {
            return this;
        }
        return new SerializedRelay(this);
    }
}
