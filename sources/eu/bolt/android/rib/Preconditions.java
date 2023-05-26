package eu.bolt.android.rib;

import android.os.Looper;
import eu.bolt.logger.StaticLogger;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Preconditions.kt */
/* loaded from: classes5.dex */
public final class Preconditions {

    /* renamed from: a  reason: collision with root package name */
    public static final Preconditions f37048a = new Preconditions();

    private Preconditions() {
    }

    public static final <T> T a(T t7) {
        t7.getClass();
        return t7;
    }

    public static final void b() {
        if (!Intrinsics.a(Looper.myLooper(), Looper.getMainLooper())) {
            String name = Thread.currentThread().getName();
            StaticLogger.f41686a.h(new RuntimeException("The method can be called only from the main thread, was called on " + name));
        }
    }
}
