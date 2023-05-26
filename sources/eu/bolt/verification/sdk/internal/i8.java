package eu.bolt.verification.sdk.internal;

import eu.bolt.android.rib.BaseRibInteractor;
import eu.bolt.android.rib.Bundle;
import eu.bolt.android.rib.dynamic.controller.DynamicStateController1Arg;
import eu.bolt.coroutines.base.BaseScopeOwner;
import eu.bolt.verification.sdk.internal.g8;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
public final class i8 extends BaseRibInteractor<k8> {

    /* renamed from: n  reason: collision with root package name */
    private final g8 f43506n;

    /* renamed from: o  reason: collision with root package name */
    private final h8 f43507o;

    /* renamed from: p  reason: collision with root package name */
    private final y6 f43508p;

    /* renamed from: q  reason: collision with root package name */
    private final ib f43509q;

    /* renamed from: r  reason: collision with root package name */
    private final String f43510r;

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.client.ribsshared.error.fullscreen.FullScreenErrorRibInteractor$observeUiEvents$1", f = "FullScreenErrorRibInteractor.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f43511g;

        /* JADX INFO: Access modifiers changed from: package-private */
        @DebugMetadata(c = "eu.bolt.client.ribsshared.error.fullscreen.FullScreenErrorRibInteractor$observeUiEvents$1$1", f = "FullScreenErrorRibInteractor.kt", l = {}, m = "invokeSuspend")
        /* renamed from: eu.bolt.verification.sdk.internal.i8$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0061a extends SuspendLambda implements Function2<g8.b, Continuation<? super Unit>, Object> {

            /* renamed from: g  reason: collision with root package name */
            int f43513g;

            /* renamed from: h  reason: collision with root package name */
            /* synthetic */ Object f43514h;

            /* renamed from: i  reason: collision with root package name */
            final /* synthetic */ i8 f43515i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0061a(i8 i8Var, Continuation<? super C0061a> continuation) {
                super(2, continuation);
                this.f43515i = i8Var;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C0061a c0061a = new C0061a(this.f43515i, continuation);
                c0061a.f43514h = obj;
                return c0061a;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: h */
            public final Object s(g8.b bVar, Continuation<? super Unit> continuation) {
                return ((C0061a) create(bVar, continuation)).invokeSuspend(Unit.f50853a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt__IntrinsicsKt.d();
                if (this.f43513g == 0) {
                    ResultKt.b(obj);
                    if (Intrinsics.a((g8.b) this.f43514h, g8.b.a.f43131a)) {
                        this.f43515i.f43508p.m(this.f43515i.f43507o.a().b());
                    }
                    return Unit.f50853a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f43511g == 0) {
                ResultKt.b(obj);
                i8 i8Var = i8.this;
                BaseScopeOwner.H(i8Var, i8Var.f43506n.p(), new C0061a(i8.this, null), null, null, null, false, 30, null);
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Inject
    public i8(g8 presenter, h8 ribArgs, y6 controller, ib keyboardMana) {
        Intrinsics.f(presenter, "presenter");
        Intrinsics.f(ribArgs, "ribArgs");
        Intrinsics.f(controller, "controller");
        Intrinsics.f(keyboardMana, "keyboardMana");
        this.f43506n = presenter;
        this.f43507o = ribArgs;
        this.f43508p = controller;
        this.f43509q = keyboardMana;
        this.f43510r = "FullScreenError";
    }

    private final void a() {
        BaseScopeOwner.F(this, null, null, new a(null), 3, null);
    }

    @Override // eu.bolt.coroutines.base.BaseScopeOwner
    public String D() {
        return this.f43510r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor
    public void K(Bundle bundle) {
        super.K(bundle);
        this.f43506n.u(this.f43507o.b());
        a();
    }

    @Override // eu.bolt.android.rib.RibInteractor, eu.bolt.android.rib.RibLifecycleSubject
    public void s() {
        super.s();
        ib.f(this.f43509q, null, false, 3, null);
        DynamicStateController1Arg.k(((k8) L()).f1(), this.f43507o.a(), false, 2, null);
    }

    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor, eu.bolt.android.rib.RibLifecycleSubject
    public boolean z(boolean z7) {
        this.f43508p.m(this.f43507o.a().b());
        this.f43508p.q(this.f43507o.a().b());
        return true;
    }
}
