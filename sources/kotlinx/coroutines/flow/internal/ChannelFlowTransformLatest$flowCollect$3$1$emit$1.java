package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Merge.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1", f = "Merge.kt", l = {30}, m = "emit")
/* loaded from: classes5.dex */
public final class ChannelFlowTransformLatest$flowCollect$3$1$emit$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f51709f;

    /* renamed from: g  reason: collision with root package name */
    Object f51710g;

    /* renamed from: h  reason: collision with root package name */
    Object f51711h;

    /* renamed from: i  reason: collision with root package name */
    /* synthetic */ Object f51712i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1<T> f51713j;

    /* renamed from: k  reason: collision with root package name */
    int f51714k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest$flowCollect$3$1$emit$1(ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1<? super T> anonymousClass1, Continuation<? super ChannelFlowTransformLatest$flowCollect$3$1$emit$1> continuation) {
        super(continuation);
        this.f51713j = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51712i = obj;
        this.f51714k |= Integer.MIN_VALUE;
        return this.f51713j.b(null, this);
    }
}
