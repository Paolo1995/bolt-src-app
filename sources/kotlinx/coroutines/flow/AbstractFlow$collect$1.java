package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Flow.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", l = {230}, m = "collect")
/* loaded from: classes5.dex */
public final class AbstractFlow$collect$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f51426f;

    /* renamed from: g  reason: collision with root package name */
    /* synthetic */ Object f51427g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ AbstractFlow<T> f51428h;

    /* renamed from: i  reason: collision with root package name */
    int f51429i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractFlow$collect$1(AbstractFlow<T> abstractFlow, Continuation<? super AbstractFlow$collect$1> continuation) {
        super(continuation);
        this.f51428h = abstractFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51427g = obj;
        this.f51429i |= Integer.MIN_VALUE;
        return this.f51428h.a(null, this);
    }
}
