package kotlinx.coroutines;

import kotlinx.coroutines.internal.Symbol;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes5.dex */
public final class EventLoop_commonKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Symbol f51281a = new Symbol("REMOVED_TASK");

    /* renamed from: b  reason: collision with root package name */
    private static final Symbol f51282b = new Symbol("CLOSED_EMPTY");

    public static final long c(long j8) {
        if (j8 <= 0) {
            return 0L;
        }
        if (j8 >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j8;
    }
}
