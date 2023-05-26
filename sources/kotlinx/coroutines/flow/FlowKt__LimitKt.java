package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Limit.kt */
/* loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__LimitKt {
    public static final <T, R> Flow<R> a(Flow<? extends T> flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Boolean>, ? extends Object> function3) {
        return FlowKt.y(new FlowKt__LimitKt$transformWhile$1(flow, function3, null));
    }
}
