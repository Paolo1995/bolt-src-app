package eu.bolt.verification.sdk.internal;

import eu.bolt.android.rib.BaseRibInteractor;
import eu.bolt.android.rib.Bundle;
import eu.bolt.android.rib.RxActivityEvents;
import eu.bolt.android.rib.lifecycle.ActivityLifecycleEvent;
import eu.bolt.coroutines.base.BaseScopeOwner;
import eu.bolt.verification.R$string;
import eu.bolt.verification.sdk.internal.ll;
import eu.bolt.verification.sdk.internal.p6;
import eu.bolt.verification.sdk.internal.q;
import eu.bolt.verification.sdk.internal.x6;
import java.util.List;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.rx2.RxConvertKt;

/* loaded from: classes5.dex */
public final class t6 extends BaseRibInteractor<v6> {

    /* renamed from: v  reason: collision with root package name */
    public static final a f45122v = new a(null);

    /* renamed from: w  reason: collision with root package name */
    private static final List<Integer> f45123w;

    /* renamed from: n  reason: collision with root package name */
    private final p6 f45124n;

    /* renamed from: o  reason: collision with root package name */
    private final s6 f45125o;

    /* renamed from: p  reason: collision with root package name */
    private final RxActivityEvents f45126p;

    /* renamed from: q  reason: collision with root package name */
    private final bg f45127q;

    /* renamed from: r  reason: collision with root package name */
    private final ml f45128r;

    /* renamed from: s  reason: collision with root package name */
    private final y6 f45129s;

    /* renamed from: t  reason: collision with root package name */
    private final bg f45130t;

    /* renamed from: u  reason: collision with root package name */
    private final String f45131u;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.client.ribsshared.error.content.ErrorContentRibInteractor$observeFirstActionButtonState$1", f = "ErrorContentRibInteractor.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f45132g;

        /* JADX INFO: Access modifiers changed from: package-private */
        @DebugMetadata(c = "eu.bolt.client.ribsshared.error.content.ErrorContentRibInteractor$observeFirstActionButtonState$1$1", f = "ErrorContentRibInteractor.kt", l = {}, m = "invokeSuspend")
        /* loaded from: classes5.dex */
        public static final class a extends SuspendLambda implements Function2<k6, Continuation<? super Unit>, Object> {

            /* renamed from: g  reason: collision with root package name */
            int f45134g;

            /* renamed from: h  reason: collision with root package name */
            /* synthetic */ Object f45135h;

            /* renamed from: i  reason: collision with root package name */
            final /* synthetic */ t6 f45136i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(t6 t6Var, Continuation<? super a> continuation) {
                super(2, continuation);
                this.f45136i = t6Var;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                a aVar = new a(this.f45136i, continuation);
                aVar.f45135h = obj;
                return aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: h */
            public final Object s(k6 k6Var, Continuation<? super Unit> continuation) {
                return ((a) create(k6Var, continuation)).invokeSuspend(Unit.f50853a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt__IntrinsicsKt.d();
                if (this.f45134g == 0) {
                    ResultKt.b(obj);
                    this.f45136i.f45124n.o((k6) this.f45135h);
                    return Unit.f50853a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f45132g == 0) {
                ResultKt.b(obj);
                Flow<k6> r7 = t6.this.f45129s.r(t6.this.f45125o.c().b());
                if (r7 != null) {
                    t6 t6Var = t6.this;
                    BaseScopeOwner.H(t6Var, r7, new a(t6Var, null), null, null, null, false, 30, null);
                }
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.client.ribsshared.error.content.ErrorContentRibInteractor$observeSecondActionButtonState$1$1", f = "ErrorContentRibInteractor.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f45137g;

        /* JADX INFO: Access modifiers changed from: package-private */
        @DebugMetadata(c = "eu.bolt.client.ribsshared.error.content.ErrorContentRibInteractor$observeSecondActionButtonState$1$1$1", f = "ErrorContentRibInteractor.kt", l = {}, m = "invokeSuspend")
        /* loaded from: classes5.dex */
        public static final class a extends SuspendLambda implements Function2<k6, Continuation<? super Unit>, Object> {

            /* renamed from: g  reason: collision with root package name */
            int f45139g;

            /* renamed from: h  reason: collision with root package name */
            /* synthetic */ Object f45140h;

            /* renamed from: i  reason: collision with root package name */
            final /* synthetic */ t6 f45141i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(t6 t6Var, Continuation<? super a> continuation) {
                super(2, continuation);
                this.f45141i = t6Var;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                a aVar = new a(this.f45141i, continuation);
                aVar.f45140h = obj;
                return aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: h */
            public final Object s(k6 k6Var, Continuation<? super Unit> continuation) {
                return ((a) create(k6Var, continuation)).invokeSuspend(Unit.f50853a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt__IntrinsicsKt.d();
                if (this.f45139g == 0) {
                    ResultKt.b(obj);
                    this.f45141i.f45124n.m((k6) this.f45140h);
                    return Unit.f50853a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f45137g == 0) {
                ResultKt.b(obj);
                Flow<k6> p8 = t6.this.f45129s.p(t6.this.f45125o.c().b());
                if (p8 != null) {
                    t6 t6Var = t6.this;
                    BaseScopeOwner.H(t6Var, p8, new a(t6Var, null), null, null, null, false, 30, null);
                }
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.client.ribsshared.error.content.ErrorContentRibInteractor$observeUiEvents$1", f = "ErrorContentRibInteractor.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f45142g;

        /* JADX INFO: Access modifiers changed from: package-private */
        @DebugMetadata(c = "eu.bolt.client.ribsshared.error.content.ErrorContentRibInteractor$observeUiEvents$1$1", f = "ErrorContentRibInteractor.kt", l = {}, m = "invokeSuspend")
        /* loaded from: classes5.dex */
        public static final class a extends SuspendLambda implements Function2<p6.b, Continuation<? super Unit>, Object> {

            /* renamed from: g  reason: collision with root package name */
            int f45144g;

            /* renamed from: h  reason: collision with root package name */
            /* synthetic */ Object f45145h;

            /* renamed from: i  reason: collision with root package name */
            final /* synthetic */ t6 f45146i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(t6 t6Var, Continuation<? super a> continuation) {
                super(2, continuation);
                this.f45146i = t6Var;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                a aVar = new a(this.f45146i, continuation);
                aVar.f45145h = obj;
                return aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: h */
            public final Object s(p6.b bVar, Continuation<? super Unit> continuation) {
                return ((a) create(bVar, continuation)).invokeSuspend(Unit.f50853a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt__IntrinsicsKt.d();
                if (this.f45144g == 0) {
                    ResultKt.b(obj);
                    this.f45146i.W((p6.b) this.f45145h);
                    return Unit.f50853a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f45142g == 0) {
                ResultKt.b(obj);
                t6 t6Var = t6.this;
                BaseScopeOwner.H(t6Var, t6Var.f45124n.p(), new a(t6.this, null), null, null, null, false, 30, null);
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.client.ribsshared.error.content.ErrorContentRibInteractor$sendAnalyticsEvents$1", f = "ErrorContentRibInteractor.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f45147g;

        /* JADX INFO: Access modifiers changed from: package-private */
        @DebugMetadata(c = "eu.bolt.client.ribsshared.error.content.ErrorContentRibInteractor$sendAnalyticsEvents$1$1", f = "ErrorContentRibInteractor.kt", l = {}, m = "invokeSuspend")
        /* loaded from: classes5.dex */
        public static final class a extends SuspendLambda implements Function2<ActivityLifecycleEvent, Continuation<? super Unit>, Object> {

            /* renamed from: g  reason: collision with root package name */
            int f45149g;

            /* renamed from: h  reason: collision with root package name */
            final /* synthetic */ t6 f45150h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(t6 t6Var, Continuation<? super a> continuation) {
                super(2, continuation);
                this.f45150h = t6Var;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.f45150h, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: h */
            public final Object s(ActivityLifecycleEvent activityLifecycleEvent, Continuation<? super Unit> continuation) {
                return ((a) create(activityLifecycleEvent, continuation)).invokeSuspend(Unit.f50853a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt__IntrinsicsKt.d();
                if (this.f45149g == 0) {
                    ResultKt.b(obj);
                    x6 c8 = this.f45150h.f45125o.c();
                    x6.a h8 = c8.h();
                    if (h8 instanceof x6.a.b) {
                        this.f45150h.e0(c8, ((x6.a.b) c8.h()).a());
                    } else if (h8 instanceof x6.a.C0098a) {
                        this.f45150h.a0(c8, c8.b().a());
                    }
                    return Unit.f50853a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        e(Continuation<? super e> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new e(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f45147g == 0) {
                ResultKt.b(obj);
                t6 t6Var = t6.this;
                BaseScopeOwner.H(t6Var, RxConvertKt.b(t6Var.f45126p.o()), new a(t6.this, null), null, null, null, false, 30, null);
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        List<Integer> n8;
        n8 = CollectionsKt__CollectionsKt.n(Integer.valueOf(R$string.something_went_wrong), Integer.valueOf(R$string.generic_error_title), Integer.valueOf(R$string.generic_error_message), Integer.valueOf(R$string.unknown_error_title), Integer.valueOf(R$string.unkown_error), Integer.valueOf(R$string.scooters_categories_loading_failed_title), Integer.valueOf(R$string.scooters_categories_loading_failed_message));
        f45123w = n8;
    }

    @Inject
    public t6(p6 presenter, s6 ribArgs, RxActivityEvents rxActivityEvents, bg ribAnalyticsManager, ml textModelToStringMapper, y6 controller, bg analyticsManager) {
        Intrinsics.f(presenter, "presenter");
        Intrinsics.f(ribArgs, "ribArgs");
        Intrinsics.f(rxActivityEvents, "rxActivityEvents");
        Intrinsics.f(ribAnalyticsManager, "ribAnalyticsManager");
        Intrinsics.f(textModelToStringMapper, "textModelToStringMapper");
        Intrinsics.f(controller, "controller");
        Intrinsics.f(analyticsManager, "analyticsManager");
        this.f45124n = presenter;
        this.f45125o = ribArgs;
        this.f45126p = rxActivityEvents;
        this.f45127q = ribAnalyticsManager;
        this.f45128r = textModelToStringMapper;
        this.f45129s = controller;
        this.f45130t = analyticsManager;
        this.f45131u = "ErrorContent";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(p6.b bVar) {
        if (bVar instanceof p6.b.e) {
            c();
            ((v6) L()).B(((p6.b.e) bVar).a());
        } else if (bVar instanceof p6.b.d) {
            ((v6) L()).C(((p6.b.d) bVar).a());
        } else if (bVar instanceof p6.b.c) {
            this.f45129s.A(this.f45125o.c().b());
        } else if (bVar instanceof p6.b.f) {
            this.f45129s.u(this.f45125o.c().b());
        } else if (bVar instanceof p6.b.a) {
            c();
        } else if (bVar instanceof p6.b.C0082b) {
            this.f45129s.o(((p6.b.C0082b) bVar).a());
        }
        this.f45129s.t(this.f45125o.c().b());
    }

    private final void Z(x6 x6Var) {
        if (x6Var.j() != null) {
            BaseScopeOwner.F(this, null, null, new c(null), 3, null);
        }
    }

    private final void a() {
        BaseScopeOwner.F(this, null, null, new b(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(x6 x6Var, String str) {
        this.f45127q.d(new q.a(str, this.f45128r.a(x6Var.f()).toString(), b0(x6Var.k()) || b0(x6Var.f())));
    }

    private final void b() {
        BaseScopeOwner.F(this, null, null, new d(null), 3, null);
    }

    private final boolean b0(ll llVar) {
        if (llVar instanceof ll.c) {
            return f45123w.contains(Integer.valueOf(((ll.c) llVar).b()));
        }
        return false;
    }

    private final void c() {
        this.f45129s.m(this.f45125o.c().b());
    }

    private final void e() {
        BaseScopeOwner.F(this, null, null, new e(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(x6 x6Var, String str) {
        this.f45127q.d(new q.c(x6Var.a(), str, this.f45128r.a(x6Var.f()).toString()));
    }

    @Override // eu.bolt.coroutines.base.BaseScopeOwner
    public String D() {
        return this.f45131u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor
    public void K(Bundle bundle) {
        super.K(bundle);
        this.f45124n.y(this.f45125o.c());
        this.f45124n.n(this.f45125o.e());
        u a8 = this.f45125o.a();
        if (a8 != null) {
            this.f45130t.b(this, a8);
        }
        q d8 = this.f45125o.d();
        if (d8 != null) {
            this.f45130t.d(d8);
        }
    }

    @Override // eu.bolt.android.rib.RibInteractor, eu.bolt.android.rib.RibLifecycleSubject
    public void y() {
        super.y();
        a();
        Z(this.f45125o.c());
        b();
        e();
    }
}
