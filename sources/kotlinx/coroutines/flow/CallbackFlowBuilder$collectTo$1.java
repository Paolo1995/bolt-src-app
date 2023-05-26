package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.CallbackFlowBuilder", f = "Builders.kt", l = {336}, m = "collectTo")
/* loaded from: classes5.dex */
public final class CallbackFlowBuilder$collectTo$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f51431f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ Object f51432g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ CallbackFlowBuilder<T> f51433h;

    /* renamed from: i  reason: collision with root package name */
    int f51434i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallbackFlowBuilder$collectTo$1(CallbackFlowBuilder<T> callbackFlowBuilder, Continuation<? super CallbackFlowBuilder$collectTo$1> continuation) {
        super(continuation);
        this.f51433h = callbackFlowBuilder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51432g = obj;
        this.f51434i |= Integer.MIN_VALUE;
        return this.f51433h.h(null, this);
    }
}
