package eu.bolt.verification.sdk.internal;

import eu.bolt.android.rib.BaseRibInteractor;
import eu.bolt.android.rib.Bundle;
import eu.bolt.android.rib.RxActivityEvents;
import eu.bolt.android.rib.lifecycle.ActivityLifecycleEvent;
import eu.bolt.coroutines.base.BaseScopeOwner;
import eu.bolt.verification.sdk.internal.mg;
import eu.bolt.verification.sdk.internal.u;
import eu.bolt.verification.sdk.internal.yh;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.rx2.RxConvertKt;

/* loaded from: classes5.dex */
public final class ei extends BaseRibInteractor<ii> {

    /* renamed from: n  reason: collision with root package name */
    private final di f42771n;

    /* renamed from: o  reason: collision with root package name */
    private final yh f42772o;

    /* renamed from: p  reason: collision with root package name */
    private final RxActivityEvents f42773p;

    /* renamed from: q  reason: collision with root package name */
    private final mg f42774q;

    /* renamed from: r  reason: collision with root package name */
    private final gi f42775r;

    /* renamed from: s  reason: collision with root package name */
    private final bg f42776s;

    /* renamed from: t  reason: collision with root package name */
    private final String f42777t;

    /* renamed from: u  reason: collision with root package name */
    private String f42778u;

    /* renamed from: v  reason: collision with root package name */
    private mg.a f42779v;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<ActivityLifecycleEvent, Unit> {
        a() {
            super(1);
        }

        public final void b(ActivityLifecycleEvent it) {
            Intrinsics.f(it, "it");
            ei.this.f42774q.i(true);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ActivityLifecycleEvent activityLifecycleEvent) {
            b(activityLifecycleEvent);
            return Unit.f50853a;
        }
    }

    @DebugMetadata(c = "eu.bolt.client.stories.rib.storyset.StoriesRibInteractor$didBecomeActive$2", f = "StoriesRibInteractor.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    static final class b extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f42781g;

        /* renamed from: h  reason: collision with root package name */
        /* synthetic */ int f42782h;

        b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = new b(continuation);
            bVar.f42782h = ((Number) obj).intValue();
            return bVar;
        }

        public final Object h(int i8, Continuation<? super Unit> continuation) {
            return ((b) create(Integer.valueOf(i8), continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f42781g == 0) {
                ResultKt.b(obj);
                ei.this.f42772o.d(this.f42782h);
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object s(Integer num, Continuation<? super Unit> continuation) {
            return h(num.intValue(), continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends Lambda implements Function1<ActivityLifecycleEvent, Unit> {
        c() {
            super(1);
        }

        public final void b(ActivityLifecycleEvent it) {
            Intrinsics.f(it, "it");
            if (it.d() == ActivityLifecycleEvent.Type.RESUME) {
                ei.this.f42772o.e();
            } else if (it.d() == ActivityLifecycleEvent.Type.PAUSE) {
                ei.this.f42772o.g();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ActivityLifecycleEvent activityLifecycleEvent) {
            b(activityLifecycleEvent);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d implements Flow<Object> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Flow f42785f;

        /* loaded from: classes5.dex */
        public static final class a<T> implements FlowCollector {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ FlowCollector f42786f;

            @DebugMetadata(c = "eu.bolt.client.stories.rib.storyset.StoriesRibInteractor$observeStoryShownForAnalytics$$inlined$filterIsInstance$1$2", f = "StoriesRibInteractor.kt", l = {224}, m = "emit")
            /* renamed from: eu.bolt.verification.sdk.internal.ei$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0048a extends ContinuationImpl {

                /* renamed from: f  reason: collision with root package name */
                /* synthetic */ Object f42787f;

                /* renamed from: g  reason: collision with root package name */
                int f42788g;

                public C0048a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f42787f = obj;
                    this.f42788g |= Integer.MIN_VALUE;
                    return a.this.b(null, this);
                }
            }

            public a(FlowCollector flowCollector) {
                this.f42786f = flowCollector;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object b(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof eu.bolt.verification.sdk.internal.ei.d.a.C0048a
                    if (r0 == 0) goto L13
                    r0 = r6
                    eu.bolt.verification.sdk.internal.ei$d$a$a r0 = (eu.bolt.verification.sdk.internal.ei.d.a.C0048a) r0
                    int r1 = r0.f42788g
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f42788g = r1
                    goto L18
                L13:
                    eu.bolt.verification.sdk.internal.ei$d$a$a r0 = new eu.bolt.verification.sdk.internal.ei$d$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f42787f
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                    int r2 = r0.f42788g
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.ResultKt.b(r6)
                    goto L43
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    kotlin.ResultKt.b(r6)
                    kotlinx.coroutines.flow.FlowCollector r6 = r4.f42786f
                    boolean r2 = r5 instanceof eu.bolt.verification.sdk.internal.yh.a.c
                    if (r2 == 0) goto L43
                    r0.f42788g = r3
                    java.lang.Object r5 = r6.b(r5, r0)
                    if (r5 != r1) goto L43
                    return r1
                L43:
                    kotlin.Unit r5 = kotlin.Unit.f50853a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.ei.d.a.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public d(Flow flow) {
            this.f42785f = flow;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object a(FlowCollector<? super Object> flowCollector, Continuation continuation) {
            Object d8;
            Object a8 = this.f42785f.a(new a(flowCollector), continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            return a8 == d8 ? a8 : Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class e implements Flow<String> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Flow f42790f;

        /* loaded from: classes5.dex */
        public static final class a<T> implements FlowCollector {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ FlowCollector f42791f;

            @DebugMetadata(c = "eu.bolt.client.stories.rib.storyset.StoriesRibInteractor$observeStoryShownForAnalytics$$inlined$map$1$2", f = "StoriesRibInteractor.kt", l = {223}, m = "emit")
            /* renamed from: eu.bolt.verification.sdk.internal.ei$e$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0049a extends ContinuationImpl {

                /* renamed from: f  reason: collision with root package name */
                /* synthetic */ Object f42792f;

                /* renamed from: g  reason: collision with root package name */
                int f42793g;

                public C0049a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f42792f = obj;
                    this.f42793g |= Integer.MIN_VALUE;
                    return a.this.b(null, this);
                }
            }

            public a(FlowCollector flowCollector) {
                this.f42791f = flowCollector;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object b(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof eu.bolt.verification.sdk.internal.ei.e.a.C0049a
                    if (r0 == 0) goto L13
                    r0 = r6
                    eu.bolt.verification.sdk.internal.ei$e$a$a r0 = (eu.bolt.verification.sdk.internal.ei.e.a.C0049a) r0
                    int r1 = r0.f42793g
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f42793g = r1
                    goto L18
                L13:
                    eu.bolt.verification.sdk.internal.ei$e$a$a r0 = new eu.bolt.verification.sdk.internal.ei$e$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f42792f
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                    int r2 = r0.f42793g
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.ResultKt.b(r6)
                    goto L45
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    kotlin.ResultKt.b(r6)
                    kotlinx.coroutines.flow.FlowCollector r6 = r4.f42791f
                    eu.bolt.verification.sdk.internal.yh$a$c r5 = (eu.bolt.verification.sdk.internal.yh.a.c) r5
                    java.lang.String r5 = r5.a()
                    r0.f42793g = r3
                    java.lang.Object r5 = r6.b(r5, r0)
                    if (r5 != r1) goto L45
                    return r1
                L45:
                    kotlin.Unit r5 = kotlin.Unit.f50853a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.ei.e.a.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public e(Flow flow) {
            this.f42790f = flow;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object a(FlowCollector<? super String> flowCollector, Continuation continuation) {
            Object d8;
            Object a8 = this.f42790f.a(new a(flowCollector), continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            return a8 == d8 ? a8 : Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.client.stories.rib.storyset.StoriesRibInteractor$observeStoryShownForAnalytics$2", f = "StoriesRibInteractor.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class f extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f42795g;

        /* renamed from: h  reason: collision with root package name */
        /* synthetic */ Object f42796h;

        f(Continuation<? super f> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            f fVar = new f(continuation);
            fVar.f42796h = obj;
            return fVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(String str, Continuation<? super Unit> continuation) {
            return ((f) create(str, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f42795g == 0) {
                ResultKt.b(obj);
                ei.this.f42776s.e(new u.b((String) this.f42796h));
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class g extends Lambda implements Function1<yh.a, Unit> {
        g() {
            super(1);
        }

        public final void b(yh.a event) {
            Intrinsics.f(event, "event");
            if (event instanceof yh.a.C0100a) {
                ei.this.f42775r.c();
            } else if (event instanceof yh.a.b) {
                ei.this.f42775r.a();
            } else if (event instanceof yh.a.c) {
                ei.this.f42775r.c(((yh.a.c) event).a());
            } else if (event instanceof yh.a.d) {
                ei.this.f42775r.b();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(yh.a aVar) {
            b(aVar);
            return Unit.f50853a;
        }
    }

    @Inject
    public ei(di args, yh presenter, RxActivityEvents rxActivityEvents, mg ribWindowController, gi listener, bg ribAnalyticsManager) {
        Intrinsics.f(args, "args");
        Intrinsics.f(presenter, "presenter");
        Intrinsics.f(rxActivityEvents, "rxActivityEvents");
        Intrinsics.f(ribWindowController, "ribWindowController");
        Intrinsics.f(listener, "listener");
        Intrinsics.f(ribAnalyticsManager, "ribAnalyticsManager");
        this.f42771n = args;
        this.f42772o = presenter;
        this.f42773p = rxActivityEvents;
        this.f42774q = ribWindowController;
        this.f42775r = listener;
        this.f42776s = ribAnalyticsManager;
        this.f42777t = "Stories";
    }

    private final void a() {
        BaseRibInteractor.S(this, ug.r(this.f42773p.f(), new c(), null, null, null, null, 30, null), null, 1, null);
    }

    private final void b() {
        BaseScopeOwner.H(this, FlowKt.j(new e(new d(RxConvertKt.b(this.f42772o.h())))), new f(null), null, null, null, false, 30, null);
    }

    private final void c() {
        Q(ug.r(this.f42772o.h(), new g(), null, null, null, null, 30, null));
    }

    @Override // eu.bolt.coroutines.base.BaseScopeOwner
    public String D() {
        return this.f42777t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor
    public void K(Bundle bundle) {
        String d8;
        super.K(bundle);
        this.f42776s.e(new u.b(this.f42771n.a().get(this.f42771n.b())));
        b();
        this.f42779v = this.f42774q.b();
        BaseRibInteractor.S(this, ug.r(this.f42773p.o(), new a(), null, null, null, null, 30, null), null, 1, null);
        BaseScopeOwner.H(this, this.f42774q.c(), new b(null), null, null, null, false, 30, null);
        this.f42772o.f(this.f42771n.a(), this.f42771n.b());
        if (bundle != null && (d8 = bundle.d(U())) != null) {
            this.f42772o.i(d8);
        }
        c();
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor
    public void P() {
        super.P();
        mg.a aVar = this.f42779v;
        if (aVar != null) {
            this.f42774q.g(aVar);
        }
    }

    @Override // eu.bolt.android.rib.RibInteractor, eu.bolt.android.rib.RibLifecycleSubject
    public void x(Bundle outState) {
        Intrinsics.f(outState, "outState");
        outState.i(U(), this.f42778u);
    }

    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor, eu.bolt.android.rib.RibLifecycleSubject
    public boolean z(boolean z7) {
        this.f42775r.c();
        return true;
    }
}
