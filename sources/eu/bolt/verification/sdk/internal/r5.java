package eu.bolt.verification.sdk.internal;

import eu.bolt.android.rib.BaseRibInteractor;
import eu.bolt.android.rib.Bundle;
import eu.bolt.android.rib.dynamic.controller.DynamicStateController1Arg;
import eu.bolt.coroutines.base.BaseScopeOwner;
import eu.bolt.verification.sdk.internal.k6;
import eu.bolt.verification.sdk.internal.s6;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes5.dex */
public final class r5 extends BaseRibInteractor<t5> {

    /* renamed from: n  reason: collision with root package name */
    private final q5 f44721n;

    /* renamed from: o  reason: collision with root package name */
    private final y6 f44722o;

    /* renamed from: p  reason: collision with root package name */
    private final ib f44723p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f44724q;

    /* renamed from: r  reason: collision with root package name */
    private final String f44725r;

    @DebugMetadata(c = "eu.bolt.client.ribsshared.error.dialog.DialogErrorRibInteractor$didBecomeActive$1", f = "DialogErrorRibInteractor.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    static final class a extends SuspendLambda implements Function2<k6, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f44726g;

        /* renamed from: h  reason: collision with root package name */
        /* synthetic */ Object f44727h;

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(continuation);
            aVar.f44727h = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(k6 k6Var, Continuation<? super Unit> continuation) {
            return ((a) create(k6Var, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z7;
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f44726g == 0) {
                ResultKt.b(obj);
                k6 k6Var = (k6) this.f44727h;
                r5 r5Var = r5.this;
                if (Intrinsics.a(k6Var, k6.a.f43821a)) {
                    z7 = false;
                } else if (!Intrinsics.a(k6Var, k6.b.f43822a)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    z7 = true;
                }
                r5Var.f44724q = z7;
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Inject
    public r5(q5 ribArgs, y6 controller, ib keyboardManager) {
        Intrinsics.f(ribArgs, "ribArgs");
        Intrinsics.f(controller, "controller");
        Intrinsics.f(keyboardManager, "keyboardManager");
        this.f44721n = ribArgs;
        this.f44722o = controller;
        this.f44723p = keyboardManager;
        this.f44725r = "DialogError";
    }

    @Override // eu.bolt.coroutines.base.BaseScopeOwner
    public String D() {
        return this.f44725r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor
    public void K(Bundle bundle) {
        super.K(bundle);
        Flow<k6> r7 = this.f44722o.r(this.f44721n.b().b());
        if (r7 == null || BaseScopeOwner.H(this, r7, new a(null), null, null, null, false, 30, null) == null) {
            this.f44724q = false;
        }
    }

    @Override // eu.bolt.android.rib.RibInteractor, eu.bolt.android.rib.RibLifecycleSubject
    public void s() {
        super.s();
        ib.f(this.f44723p, null, false, 3, null);
        DynamicStateController1Arg.k(((t5) L()).f1(), new s6(this.f44721n.b(), s6.a.Small, null, this.f44721n.a(), this.f44721n.c(), 4, null), false, 2, null);
    }

    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor, eu.bolt.android.rib.RibLifecycleSubject
    public boolean z(boolean z7) {
        if (this.f44724q) {
            return false;
        }
        this.f44722o.m(this.f44721n.b().b());
        this.f44722o.q(this.f44721n.b().b());
        return true;
    }
}
