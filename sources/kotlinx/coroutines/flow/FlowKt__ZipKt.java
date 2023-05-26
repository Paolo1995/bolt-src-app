package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Zip.kt */
/* loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__ZipKt {
    public static final <T1, T2, R> Flow<R> b(Flow<? extends T1> flow, Flow<? extends T2> flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt.z(flow, flow2, function3);
    }

    public static final <T1, T2, R> Flow<R> c(final Flow<? extends T1> flow, final Flow<? extends T2> flow2, final Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return new Flow<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
                Function0 d8;
                Object d9;
                Flow[] flowArr = {Flow.this, flow2};
                d8 = FlowKt__ZipKt.d();
                Object a8 = CombineKt.a(flowCollector, flowArr, d8, new FlowKt__ZipKt$combine$1$1(function3, null), continuation);
                d9 = IntrinsicsKt__IntrinsicsKt.d();
                if (a8 == d9) {
                    return a8;
                }
                return Unit.f50853a;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Function0<T[]> d() {
        return new Function0() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$nullArrayFactory$1
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Void invoke() {
                return null;
            }
        };
    }
}
