package eu.bolt.coroutines.flows;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: SafeEmissionFlow.kt */
/* loaded from: classes5.dex */
public abstract class SafeEmissionFlow<T> implements SharedFlow<T> {

    /* renamed from: f  reason: collision with root package name */
    private final MutableSharedFlow<T> f40381f;

    private SafeEmissionFlow(int i8, int i9) {
        this.f40381f = SharedFlowKt.a(i8, i9, BufferOverflow.SUSPEND);
    }

    public /* synthetic */ SafeEmissionFlow(int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(i8, i9);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlinx.coroutines.flow.FlowCollector<? super T> r5, kotlin.coroutines.Continuation<?> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof eu.bolt.coroutines.flows.SafeEmissionFlow$collect$1
            if (r0 == 0) goto L13
            r0 = r6
            eu.bolt.coroutines.flows.SafeEmissionFlow$collect$1 r0 = (eu.bolt.coroutines.flows.SafeEmissionFlow$collect$1) r0
            int r1 = r0.f40384h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f40384h = r1
            goto L18
        L13:
            eu.bolt.coroutines.flows.SafeEmissionFlow$collect$1 r0 = new eu.bolt.coroutines.flows.SafeEmissionFlow$collect$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f40382f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f40384h
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2d:
            kotlin.ResultKt.b(r6)
            goto L3f
        L31:
            kotlin.ResultKt.b(r6)
            kotlinx.coroutines.flow.MutableSharedFlow<T> r6 = r4.f40381f
            r0.f40384h = r3
            java.lang.Object r5 = r6.a(r5, r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.coroutines.flows.SafeEmissionFlow.a(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MutableSharedFlow<T> c() {
        return this.f40381f;
    }

    public final void f(T t7) {
        if (this.f40381f.d(t7)) {
            return;
        }
        BuildersKt.d(EmissionScopeKt.a(), null, CoroutineStart.UNDISPATCHED, new SafeEmissionFlow$publish$1(this, t7, null), 1, null);
    }
}
