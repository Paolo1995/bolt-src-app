package kotlinx.coroutines.internal;

/* compiled from: LimitedDispatcher.kt */
/* loaded from: classes5.dex */
public final class LimitedDispatcherKt {
    public static final void a(int i8) {
        boolean z7 = true;
        if (i8 < 1) {
            z7 = false;
        }
        if (z7) {
            return;
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but got " + i8).toString());
    }
}
