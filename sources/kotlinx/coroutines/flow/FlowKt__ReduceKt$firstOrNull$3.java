package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Reduce.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {183}, m = "firstOrNull")
/* loaded from: classes5.dex */
public final class FlowKt__ReduceKt$firstOrNull$3<T> extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f51587f;

    /* renamed from: g  reason: collision with root package name */
    Object f51588g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f51589h;

    /* renamed from: i  reason: collision with root package name */
    int f51590i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__ReduceKt$firstOrNull$3(Continuation<? super FlowKt__ReduceKt$firstOrNull$3> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51589h = obj;
        this.f51590i |= Integer.MIN_VALUE;
        return FlowKt.q(null, null, this);
    }
}
