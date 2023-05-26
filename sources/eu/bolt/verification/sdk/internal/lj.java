package eu.bolt.verification.sdk.internal;

import eu.bolt.android.rib.BaseRibInteractor;
import eu.bolt.android.rib.Bundle;
import eu.bolt.android.rib.RxActivityEvents;
import eu.bolt.android.rib.lifecycle.ActivityLifecycleEvent;
import eu.bolt.coroutines.base.BaseScopeOwner;
import eu.bolt.verification.R$color;
import eu.bolt.verification.sdk.internal.fj;
import eu.bolt.verification.sdk.internal.mg;
import eu.bolt.verification.sdk.internal.q;
import eu.bolt.verification.sdk.internal.u;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes5.dex */
public final class lj extends BaseRibInteractor<pj> {

    /* renamed from: n  reason: collision with root package name */
    private final kj f44056n;

    /* renamed from: o  reason: collision with root package name */
    private final fj f44057o;

    /* renamed from: p  reason: collision with root package name */
    private final RxActivityEvents f44058p;

    /* renamed from: q  reason: collision with root package name */
    private final nj f44059q;

    /* renamed from: r  reason: collision with root package name */
    private final mg f44060r;

    /* renamed from: s  reason: collision with root package name */
    private final xf f44061s;

    /* renamed from: t  reason: collision with root package name */
    private final bg f44062t;

    /* renamed from: u  reason: collision with root package name */
    private final l5 f44063u;

    /* renamed from: v  reason: collision with root package name */
    private final String f44064v;

    /* renamed from: w  reason: collision with root package name */
    private mg.a f44065w;

    /* renamed from: x  reason: collision with root package name */
    private final MutableStateFlow<String> f44066x;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<ActivityLifecycleEvent, Unit> {
        a() {
            super(1);
        }

        public final void b(ActivityLifecycleEvent it) {
            Intrinsics.f(it, "it");
            lj.this.f44060r.i(true);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ActivityLifecycleEvent activityLifecycleEvent) {
            b(activityLifecycleEvent);
            return Unit.f50853a;
        }
    }

    @DebugMetadata(c = "eu.bolt.client.stories.rib.singlestory.StoryRibInteractor$didBecomeActive$2", f = "StoryRibInteractor.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    static final class b extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f44068g;

        /* renamed from: h  reason: collision with root package name */
        /* synthetic */ int f44069h;

        b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = new b(continuation);
            bVar.f44069h = ((Number) obj).intValue();
            return bVar;
        }

        public final Object h(int i8, Continuation<? super Unit> continuation) {
            return ((b) create(Integer.valueOf(i8), continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f44068g == 0) {
                ResultKt.b(obj);
                lj.this.f44057o.d(this.f44069h);
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object s(Integer num, Continuation<? super Unit> continuation) {
            return h(num.intValue(), continuation);
        }
    }

    /* loaded from: classes5.dex */
    static final class c extends Lambda implements Function1<ActivityLifecycleEvent, Unit> {
        c() {
            super(1);
        }

        public final void b(ActivityLifecycleEvent it) {
            Intrinsics.f(it, "it");
            lj.this.f44057o.b();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ActivityLifecycleEvent activityLifecycleEvent) {
            b(activityLifecycleEvent);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class d extends Lambda implements Function1<ActivityLifecycleEvent, Unit> {
        d() {
            super(1);
        }

        public final void b(ActivityLifecycleEvent it) {
            Intrinsics.f(it, "it");
            lj.this.f44057o.a();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ActivityLifecycleEvent activityLifecycleEvent) {
            b(activityLifecycleEvent);
            return Unit.f50853a;
        }
    }

    @DebugMetadata(c = "eu.bolt.client.stories.rib.singlestory.StoryRibInteractor$observeScreenshotAnalyticEvents$$inlined$flatMapLatest$1", f = "StoryRibInteractor.kt", l = {190}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class e extends SuspendLambda implements Function3<FlowCollector<? super q.e>, String, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f44073g;

        /* renamed from: h  reason: collision with root package name */
        private /* synthetic */ Object f44074h;

        /* renamed from: i  reason: collision with root package name */
        /* synthetic */ Object f44075i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ lj f44076j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Continuation continuation, lj ljVar) {
            super(3, continuation);
            this.f44076j = ljVar;
        }

        @Override // kotlin.jvm.functions.Function3
        /* renamed from: h */
        public final Object l(FlowCollector<? super q.e> flowCollector, String str, Continuation<? super Unit> continuation) {
            e eVar = new e(continuation, this.f44076j);
            eVar.f44074h = flowCollector;
            eVar.f44075i = str;
            return eVar.invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d8;
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            int i8 = this.f44073g;
            if (i8 == 0) {
                ResultKt.b(obj);
                g gVar = new g(this.f44076j.f44063u.a(), this.f44076j, (String) this.f44075i);
                this.f44073g = 1;
                if (FlowKt.l((FlowCollector) this.f44074h, gVar, this) == d8) {
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
    @DebugMetadata(c = "eu.bolt.client.stories.rib.singlestory.StoryRibInteractor$observeScreenshotAnalyticEvents$2", f = "StoryRibInteractor.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class f extends SuspendLambda implements Function2<q.e, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f44077g;

        /* renamed from: h  reason: collision with root package name */
        /* synthetic */ Object f44078h;

        f(Continuation<? super f> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            f fVar = new f(continuation);
            fVar.f44078h = obj;
            return fVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(q.e eVar, Continuation<? super Unit> continuation) {
            return ((f) create(eVar, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f44077g == 0) {
                ResultKt.b(obj);
                lj.this.f44062t.d((q.e) this.f44078h);
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* loaded from: classes5.dex */
    public static final class g implements Flow<q.e> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Flow f44080f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ lj f44081g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f44082h;

        /* loaded from: classes5.dex */
        public static final class a<T> implements FlowCollector {

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ FlowCollector f44083f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ lj f44084g;

            /* renamed from: h  reason: collision with root package name */
            final /* synthetic */ String f44085h;

            @DebugMetadata(c = "eu.bolt.client.stories.rib.singlestory.StoryRibInteractor$observeScreenshotAnalyticEvents$lambda$2$$inlined$map$1$2", f = "StoryRibInteractor.kt", l = {223}, m = "emit")
            /* renamed from: eu.bolt.verification.sdk.internal.lj$g$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0073a extends ContinuationImpl {

                /* renamed from: f  reason: collision with root package name */
                /* synthetic */ Object f44086f;

                /* renamed from: g  reason: collision with root package name */
                int f44087g;

                public C0073a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f44086f = obj;
                    this.f44087g |= Integer.MIN_VALUE;
                    return a.this.b(null, this);
                }
            }

            public a(FlowCollector flowCollector, lj ljVar, String str) {
                this.f44083f = flowCollector;
                this.f44084g = ljVar;
                this.f44085h = str;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object b(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof eu.bolt.verification.sdk.internal.lj.g.a.C0073a
                    if (r0 == 0) goto L13
                    r0 = r7
                    eu.bolt.verification.sdk.internal.lj$g$a$a r0 = (eu.bolt.verification.sdk.internal.lj.g.a.C0073a) r0
                    int r1 = r0.f44087g
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f44087g = r1
                    goto L18
                L13:
                    eu.bolt.verification.sdk.internal.lj$g$a$a r0 = new eu.bolt.verification.sdk.internal.lj$g$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.f44086f
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
                    int r2 = r0.f44087g
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.ResultKt.b(r7)
                    goto L52
                L29:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L31:
                    kotlin.ResultKt.b(r7)
                    kotlinx.coroutines.flow.FlowCollector r7 = r5.f44083f
                    java.io.File r6 = (java.io.File) r6
                    eu.bolt.verification.sdk.internal.q$e r6 = new eu.bolt.verification.sdk.internal.q$e
                    eu.bolt.verification.sdk.internal.lj r2 = r5.f44084g
                    eu.bolt.verification.sdk.internal.kj r2 = r2.V()
                    java.lang.String r2 = r2.b()
                    java.lang.String r4 = r5.f44085h
                    r6.<init>(r2, r4)
                    r0.f44087g = r3
                    java.lang.Object r6 = r7.b(r6, r0)
                    if (r6 != r1) goto L52
                    return r1
                L52:
                    kotlin.Unit r6 = kotlin.Unit.f50853a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.lj.g.a.b(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public g(Flow flow, lj ljVar, String str) {
            this.f44080f = flow;
            this.f44081g = ljVar;
            this.f44082h = str;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object a(FlowCollector<? super q.e> flowCollector, Continuation continuation) {
            Object d8;
            Object a8 = this.f44080f.a(new a(flowCollector, this.f44081g, this.f44082h), continuation);
            d8 = IntrinsicsKt__IntrinsicsKt.d();
            return a8 == d8 ? a8 : Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class h extends Lambda implements Function1<fj.a, Unit> {
        h() {
            super(1);
        }

        public final void b(fj.a event) {
            Object value;
            Intrinsics.f(event, "event");
            if (event instanceof fj.a.C0054a ? true : event instanceof fj.a.c ? true : event instanceof fj.a.f) {
                lj.this.f44059q.g();
            } else if (event instanceof fj.a.d) {
                lj.this.X((fj.a.d) event);
            } else if ((event instanceof fj.a.e) || !(event instanceof fj.a.b)) {
            } else {
                MutableStateFlow mutableStateFlow = lj.this.f44066x;
                do {
                    value = mutableStateFlow.getValue();
                    String str = (String) value;
                } while (!mutableStateFlow.g(value, ((fj.a.b) event).a()));
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(fj.a aVar) {
            b(aVar);
            return Unit.f50853a;
        }
    }

    @Inject
    public lj(kj args, fj presenter, RxActivityEvents rxActivityEvents, nj ribListener, mg ribWindowController, xf resourcesProvider, bg ribAnalyticsManager, l5 detectScreenshotsInteractor) {
        Intrinsics.f(args, "args");
        Intrinsics.f(presenter, "presenter");
        Intrinsics.f(rxActivityEvents, "rxActivityEvents");
        Intrinsics.f(ribListener, "ribListener");
        Intrinsics.f(ribWindowController, "ribWindowController");
        Intrinsics.f(resourcesProvider, "resourcesProvider");
        Intrinsics.f(ribAnalyticsManager, "ribAnalyticsManager");
        Intrinsics.f(detectScreenshotsInteractor, "detectScreenshotsInteractor");
        this.f44056n = args;
        this.f44057o = presenter;
        this.f44058p = rxActivityEvents;
        this.f44059q = ribListener;
        this.f44060r = ribWindowController;
        this.f44061s = resourcesProvider;
        this.f44062t = ribAnalyticsManager;
        this.f44063u = detectScreenshotsInteractor;
        this.f44064v = "StoryRibInteractor";
        this.f44066x = StateFlowKt.a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(fj.a.d dVar) {
        Throwable a8 = dVar.a();
        if (a8 == null || !(a8 instanceof xl)) {
            return;
        }
        this.f44059q.e();
    }

    private final void b() {
        BaseScopeOwner.H(this, FlowKt.I(FlowKt.o(this.f44066x), new e(null, this)), new f(null), null, null, null, false, 30, null);
    }

    private final void c() {
        BaseRibInteractor.S(this, ug.r(this.f44057o.h(), new h(), null, null, null, null, 30, null), null, 1, null);
    }

    @Override // eu.bolt.coroutines.base.BaseScopeOwner
    public String D() {
        return this.f44064v;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor
    public void K(Bundle bundle) {
        super.K(bundle);
        this.f44062t.b(this, new u.b(this.f44056n.b()));
        if (this.f44056n.a()) {
            this.f44065w = this.f44060r.b();
            BaseRibInteractor.S(this, ug.r(this.f44058p.o(), new a(), null, null, null, null, 30, null), null, 1, null);
            this.f44060r.h(this.f44061s.d(R$color.A), true);
            BaseScopeOwner.H(this, this.f44060r.c(), new b(null), null, null, null, false, 30, null);
        }
        b();
        c();
        BaseRibInteractor.S(this, ug.r(this.f44058p.A(), new c(), null, null, null, null, 30, null), null, 1, null);
        BaseRibInteractor.S(this, ug.r(this.f44058p.C(), new d(), null, null, null, null, 30, null), null, 1, null);
        this.f44057o.e(this.f44056n.b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor
    public void P() {
        super.P();
        mg.a aVar = this.f44065w;
        if (aVar != null) {
            this.f44060r.g(aVar);
        }
        this.f44057o.close();
    }

    public final kj V() {
        return this.f44056n;
    }

    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor, eu.bolt.android.rib.RibLifecycleSubject
    public boolean z(boolean z7) {
        this.f44059q.g();
        return true;
    }
}
