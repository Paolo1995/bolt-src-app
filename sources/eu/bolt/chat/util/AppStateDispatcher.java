package eu.bolt.chat.util;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppStateDispatcher.kt */
/* loaded from: classes5.dex */
public final class AppStateDispatcher {

    /* renamed from: a  reason: collision with root package name */
    private boolean f39673a;

    /* renamed from: b  reason: collision with root package name */
    private ForegroundStateListener f39674b;

    /* renamed from: c  reason: collision with root package name */
    private final ReentrantLock f39675c = new ReentrantLock();

    private final void a(boolean z7, ForegroundStateListener foregroundStateListener) {
        if (z7) {
            foregroundStateListener.b();
        } else {
            foregroundStateListener.a();
        }
    }

    public final void b(boolean z7) {
        ReentrantLock reentrantLock = this.f39675c;
        reentrantLock.lock();
        try {
            if (this.f39673a != z7) {
                this.f39673a = z7;
                ForegroundStateListener foregroundStateListener = this.f39674b;
                if (foregroundStateListener != null) {
                    a(z7, foregroundStateListener);
                }
            }
            Unit unit = Unit.f50853a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void c(ForegroundStateListener listener) {
        Intrinsics.f(listener, "listener");
        ReentrantLock reentrantLock = this.f39675c;
        reentrantLock.lock();
        try {
            a(this.f39673a, listener);
            this.f39674b = listener;
            Unit unit = Unit.f50853a;
        } finally {
            reentrantLock.unlock();
        }
    }
}
