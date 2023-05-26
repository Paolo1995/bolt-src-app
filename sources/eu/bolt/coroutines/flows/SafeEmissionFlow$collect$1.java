package eu.bolt.coroutines.flows;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SafeEmissionFlow.kt */
@DebugMetadata(c = "eu.bolt.coroutines.flows.SafeEmissionFlow", f = "SafeEmissionFlow.kt", l = {32}, m = "collect")
/* loaded from: classes5.dex */
public final class SafeEmissionFlow$collect$1 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    /* synthetic */ Object f40382f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ SafeEmissionFlow<T> f40383g;

    /* renamed from: h  reason: collision with root package name */
    int f40384h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeEmissionFlow$collect$1(SafeEmissionFlow<T> safeEmissionFlow, Continuation<? super SafeEmissionFlow$collect$1> continuation) {
        super(continuation);
        this.f40383g = safeEmissionFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f40382f = obj;
        this.f40384h |= Integer.MIN_VALUE;
        return this.f40383g.a(null, this);
    }
}
