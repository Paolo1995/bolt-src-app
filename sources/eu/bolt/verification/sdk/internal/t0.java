package eu.bolt.verification.sdk.internal;

import eu.bolt.android.rib.BaseRibInteractor;
import eu.bolt.android.rib.Bundle;
import eu.bolt.coroutines.base.BaseScopeOwner;
import eu.bolt.verification.sdk.internal.c4;
import eu.bolt.verification.sdk.internal.ha;
import eu.bolt.verification.sdk.internal.q0;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
public final class t0 extends BaseRibInteractor<w0> {

    /* renamed from: n  reason: collision with root package name */
    private final q0 f45068n;

    /* renamed from: o  reason: collision with root package name */
    private final ga f45069o;

    /* renamed from: p  reason: collision with root package name */
    private final v0 f45070p;

    /* renamed from: q  reason: collision with root package name */
    private final String f45071q;

    @DebugMetadata(c = "eu.bolt.client.ribsshared.information.bottomsheet.BottomSheetInformationRibInteractor$didBecomeActive$1", f = "BottomSheetInformationRibInteractor.kt", l = {34}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f45072g;

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
            Object d8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f45072g;
            if (i8 == 0) {
                ResultKt.b(obj);
                q0 q0Var = t0.this.f45068n;
                this.f45072g = 1;
                if (q0Var.b(this) == d8) {
                    return d8;
                }
            } else if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.b(obj);
            }
            return Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b extends Lambda implements Function1<q0.a, Unit> {
        b() {
            super(1);
        }

        public final void b(q0.a event) {
            Intrinsics.f(event, "event");
            if (!(event instanceof q0.a.C0083a)) {
                throw new NoWhenBranchMatchedException();
            }
            t0.this.W(((q0.a.C0083a) event).a());
            Unit unit = Unit.f50853a;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(q0.a aVar) {
            b(aVar);
            return Unit.f50853a;
        }
    }

    @Inject
    public t0(q0 presenter, ga informationRibArgs, v0 ribListener) {
        Intrinsics.f(presenter, "presenter");
        Intrinsics.f(informationRibArgs, "informationRibArgs");
        Intrinsics.f(ribListener, "ribListener");
        this.f45068n = presenter;
        this.f45069o = informationRibArgs;
        this.f45070p = ribListener;
        this.f45071q = "BottomSheetInformation";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(ha.a.AbstractC0058a abstractC0058a) {
        if (abstractC0058a instanceof ha.a.AbstractC0058a.c) {
            ((w0) L()).C(((ha.a.AbstractC0058a.c) abstractC0058a).a());
        } else if (abstractC0058a instanceof ha.a.AbstractC0058a.b) {
            ((w0) L()).B(((ha.a.AbstractC0058a.b) abstractC0058a).a());
        } else if (abstractC0058a instanceof ha.a.AbstractC0058a.C0059a) {
            this.f45070p.d(((ha.a.AbstractC0058a.C0059a) abstractC0058a).a());
        }
    }

    private final void a() {
        BaseRibInteractor.S(this, ug.r(this.f45068n.h(), new b(), null, null, null, null, 30, null), null, 1, null);
    }

    @Override // eu.bolt.coroutines.base.BaseScopeOwner
    public String D() {
        return this.f45071q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor
    public void K(Bundle bundle) {
        super.K(bundle);
        a();
        this.f45068n.e(this.f45069o.a() ? wd.HIDE : wd.NO);
        this.f45068n.d(this.f45069o.b());
        this.f45068n.a(this.f45069o.c());
        BaseScopeOwner.F(this, null, null, new a(null), 3, null);
        c4.a.a(this.f45068n, false, 1, null);
    }

    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor, eu.bolt.android.rib.RibLifecycleSubject
    public boolean z(boolean z7) {
        c4.a.b(this.f45068n, false, 1, null);
        return true;
    }
}
