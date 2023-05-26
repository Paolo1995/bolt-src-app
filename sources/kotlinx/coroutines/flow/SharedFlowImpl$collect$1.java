package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SharedFlow.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", l = {373, 380, 383}, m = "collect$suspendImpl")
/* loaded from: classes5.dex */
public final class SharedFlowImpl$collect$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f51631f;

    /* renamed from: g  reason: collision with root package name */
    Object f51632g;

    /* renamed from: h  reason: collision with root package name */
    Object f51633h;

    /* renamed from: i  reason: collision with root package name */
    Object f51634i;

    /* renamed from: j  reason: collision with root package name */
    /* synthetic */ Object f51635j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ SharedFlowImpl<T> f51636k;

    /* renamed from: l  reason: collision with root package name */
    int f51637l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedFlowImpl$collect$1(SharedFlowImpl<T> sharedFlowImpl, Continuation<? super SharedFlowImpl$collect$1> continuation) {
        super(continuation);
        this.f51636k = sharedFlowImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51635j = obj;
        this.f51637l |= Integer.MIN_VALUE;
        return SharedFlowImpl.A(this.f51636k, null, this);
    }
}
