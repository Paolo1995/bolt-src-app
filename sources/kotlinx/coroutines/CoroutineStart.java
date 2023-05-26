package kotlinx.coroutines;

import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* compiled from: CoroutineStart.kt */
/* loaded from: classes5.dex */
public enum CoroutineStart {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    /* compiled from: CoroutineStart.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f51253a;

        static {
            int[] iArr = new int[CoroutineStart.values().length];
            iArr[CoroutineStart.DEFAULT.ordinal()] = 1;
            iArr[CoroutineStart.ATOMIC.ordinal()] = 2;
            iArr[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            iArr[CoroutineStart.LAZY.ordinal()] = 4;
            f51253a = iArr;
        }
    }

    public final <R, T> void c(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r7, Continuation<? super T> continuation) {
        int i8 = WhenMappings.f51253a[ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return;
                }
                UndispatchedKt.a(function2, r7, continuation);
                return;
            }
            ContinuationKt.a(function2, r7, continuation);
            return;
        }
        CancellableKt.e(function2, r7, continuation, null, 4, null);
    }

    public final boolean e() {
        if (this == LAZY) {
            return true;
        }
        return false;
    }
}
