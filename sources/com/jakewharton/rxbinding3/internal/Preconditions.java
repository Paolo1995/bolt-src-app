package com.jakewharton.rxbinding3.internal;

import android.os.Looper;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposables;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: mainThread.kt */
/* loaded from: classes3.dex */
public final class Preconditions {
    public static final boolean a(Observer<?> observer) {
        Intrinsics.g(observer, "observer");
        if (!(!Intrinsics.a(Looper.myLooper(), Looper.getMainLooper()))) {
            return true;
        }
        observer.onSubscribe(Disposables.b());
        StringBuilder sb = new StringBuilder();
        sb.append("Expected to be called on the main thread but was ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.b(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        observer.onError(new IllegalStateException(sb.toString()));
        return false;
    }
}
