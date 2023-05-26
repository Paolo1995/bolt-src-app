package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Merge.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2", f = "Merge.kt", l = {66}, m = "emit")
/* loaded from: classes5.dex */
public final class ChannelFlowMerge$collectTo$2$emit$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f51687f;

    /* renamed from: g  reason: collision with root package name */
    Object f51688g;

    /* renamed from: h  reason: collision with root package name */
    /* synthetic */ Object f51689h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ ChannelFlowMerge$collectTo$2<T> f51690i;

    /* renamed from: j  reason: collision with root package name */
    int f51691j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowMerge$collectTo$2$emit$1(ChannelFlowMerge$collectTo$2<? super T> channelFlowMerge$collectTo$2, Continuation<? super ChannelFlowMerge$collectTo$2$emit$1> continuation) {
        super(continuation);
        this.f51690i = channelFlowMerge$collectTo$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51689h = obj;
        this.f51691j |= Integer.MIN_VALUE;
        return this.f51690i.b(null, this);
    }
}
