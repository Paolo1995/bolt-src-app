package kotlinx.coroutines.internal;

import kotlinx.coroutines.internal.Segment;

/* compiled from: ConcurrentLinkedList.kt */
/* loaded from: classes5.dex */
public final class SegmentOrClosed<S extends Segment<S>> {
    public static <S extends Segment<S>> Object a(Object obj) {
        return obj;
    }

    public static final S b(Object obj) {
        Symbol symbol;
        symbol = ConcurrentLinkedListKt.f51778a;
        if (obj != symbol) {
            if (obj != null) {
                return (S) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        }
        throw new IllegalStateException("Does not contain segment".toString());
    }

    public static final boolean c(Object obj) {
        Symbol symbol;
        symbol = ConcurrentLinkedListKt.f51778a;
        if (obj == symbol) {
            return true;
        }
        return false;
    }
}
