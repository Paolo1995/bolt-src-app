package com.google.firebase.inject;

import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public interface Deferred<T> {

    /* loaded from: classes3.dex */
    public interface DeferredHandler<T> {
        void a(Provider<T> provider);
    }

    void a(@NonNull DeferredHandler<T> deferredHandler);
}
