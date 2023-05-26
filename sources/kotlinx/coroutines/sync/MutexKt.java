package kotlinx.coroutines.sync;

import kotlinx.coroutines.internal.Symbol;

/* compiled from: Mutex.kt */
/* loaded from: classes5.dex */
public final class MutexKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Symbol f52009a = new Symbol("LOCK_FAIL");

    /* renamed from: b  reason: collision with root package name */
    private static final Symbol f52010b = new Symbol("UNLOCK_FAIL");

    /* renamed from: c  reason: collision with root package name */
    private static final Symbol f52011c;

    /* renamed from: d  reason: collision with root package name */
    private static final Symbol f52012d;

    /* renamed from: e  reason: collision with root package name */
    private static final Empty f52013e;

    /* renamed from: f  reason: collision with root package name */
    private static final Empty f52014f;

    static {
        Symbol symbol = new Symbol("LOCKED");
        f52011c = symbol;
        Symbol symbol2 = new Symbol("UNLOCKED");
        f52012d = symbol2;
        f52013e = new Empty(symbol);
        f52014f = new Empty(symbol2);
    }

    public static final Mutex a(boolean z7) {
        return new MutexImpl(z7);
    }

    public static /* synthetic */ Mutex b(boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = false;
        }
        return a(z7);
    }
}
