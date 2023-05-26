package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;

/* compiled from: Delay.kt */
/* loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__DelayKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Flow<T> a(Flow<? extends T> flow, final long j8) {
        boolean z7;
        int i8 = (j8 > 0L ? 1 : (j8 == 0L ? 0 : -1));
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (i8 == 0) {
                return flow;
            }
            return b(flow, new Function1<T, Long>() { // from class: kotlinx.coroutines.flow.FlowKt__DelayKt$debounce$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final Long invoke(T t7) {
                    return Long.valueOf(j8);
                }
            });
        }
        throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
    }

    private static final <T> Flow<T> b(Flow<? extends T> flow, Function1<? super T, Long> function1) {
        return FlowCoroutineKt.b(new FlowKt__DelayKt$debounceInternal$1(function1, flow, null));
    }

    public static final ReceiveChannel<Unit> c(CoroutineScope coroutineScope, long j8, long j9) {
        boolean z7;
        boolean z8 = true;
        if (j8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (j9 < 0) {
                z8 = false;
            }
            if (z8) {
                return ProduceKt.d(coroutineScope, null, 0, new FlowKt__DelayKt$fixedPeriodTicker$3(j9, j8, null), 1, null);
            }
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j9 + " ms").toString());
        }
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + j8 + " ms").toString());
    }

    public static /* synthetic */ ReceiveChannel d(CoroutineScope coroutineScope, long j8, long j9, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            j9 = j8;
        }
        return FlowKt.r(coroutineScope, j8, j9);
    }

    public static final <T> Flow<T> e(Flow<? extends T> flow, long j8) {
        boolean z7;
        if (j8 > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return FlowCoroutineKt.b(new FlowKt__DelayKt$sample$2(j8, flow, null));
        }
        throw new IllegalArgumentException("Sample period should be positive".toString());
    }
}
