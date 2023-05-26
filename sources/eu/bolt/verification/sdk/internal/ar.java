package eu.bolt.verification.sdk.internal;

import eu.bolt.android.rib.BaseRibInteractor;
import eu.bolt.android.rib.Bundle;
import eu.bolt.coroutines.base.BaseScopeOwner;
import eu.bolt.logger.Logger;
import eu.bolt.verification.R$color;
import eu.bolt.verification.R$string;
import eu.bolt.verification.sdk.internal.ac;
import eu.bolt.verification.sdk.internal.dr;
import eu.bolt.verification.sdk.internal.jc;
import eu.bolt.verification.sdk.internal.q;
import eu.bolt.verification.sdk.internal.td;
import eu.bolt.verification.sdk.internal.u;
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
public final class ar extends BaseRibInteractor<gr> implements ir {

    /* renamed from: n  reason: collision with root package name */
    private final dr f42223n;

    /* renamed from: o  reason: collision with root package name */
    private final td f42224o;

    /* renamed from: p  reason: collision with root package name */
    private final cr f42225p;

    /* renamed from: q  reason: collision with root package name */
    private final pd f42226q;

    /* renamed from: r  reason: collision with root package name */
    private final bg f42227r;

    /* renamed from: s  reason: collision with root package name */
    private final jc f42228s;

    /* renamed from: t  reason: collision with root package name */
    private final xf f42229t;

    /* renamed from: u  reason: collision with root package name */
    private final String f42230u;

    /* renamed from: v  reason: collision with root package name */
    private final Logger f42231v;

    /* renamed from: w  reason: collision with root package name */
    private jc.a f42232w;

    /* JADX INFO: Access modifiers changed from: package-private */
    @DebugMetadata(c = "eu.bolt.android.webview.WebPageRibInteractor$observeUiEvents$1", f = "WebPageRibInteractor.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f42233g;

        /* JADX INFO: Access modifiers changed from: package-private */
        @DebugMetadata(c = "eu.bolt.android.webview.WebPageRibInteractor$observeUiEvents$1$1", f = "WebPageRibInteractor.kt", l = {}, m = "invokeSuspend")
        /* renamed from: eu.bolt.verification.sdk.internal.ar$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0034a extends SuspendLambda implements Function2<dr.b, Continuation<? super Unit>, Object> {

            /* renamed from: g  reason: collision with root package name */
            int f42235g;

            /* renamed from: h  reason: collision with root package name */
            /* synthetic */ Object f42236h;

            /* renamed from: i  reason: collision with root package name */
            final /* synthetic */ ar f42237i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0034a(ar arVar, Continuation<? super C0034a> continuation) {
                super(2, continuation);
                this.f42237i = arVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C0034a c0034a = new C0034a(this.f42237i, continuation);
                c0034a.f42236h = obj;
                return c0034a;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: h */
            public final Object s(dr.b bVar, Continuation<? super Unit> continuation) {
                return ((C0034a) create(bVar, continuation)).invokeSuspend(Unit.f50853a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                bg bgVar;
                q jVar;
                IntrinsicsKt__IntrinsicsKt.d();
                if (this.f42235g == 0) {
                    ResultKt.b(obj);
                    dr.b bVar = (dr.b) this.f42236h;
                    if ((bVar instanceof dr.b.a) || (bVar instanceof dr.b.C0046b)) {
                        this.f42237i.f42225p.a();
                    } else if (bVar instanceof dr.b.g) {
                        this.f42237i.i(((dr.b.g) bVar).a());
                    } else if (bVar instanceof dr.b.c) {
                        dr.b.c cVar = (dr.b.c) bVar;
                        this.f42237i.f42226q.b(cVar.a(), cVar.b());
                    } else if (bVar instanceof dr.b.e) {
                        dr.b.e eVar = (dr.b.e) bVar;
                        this.f42237i.f42227r.d(new q.k(eVar.a()));
                        this.f42237i.f42225p.j(eVar.a());
                    } else {
                        if (bVar instanceof dr.b.f) {
                            bgVar = this.f42237i.f42227r;
                            dr.b.f fVar = (dr.b.f) bVar;
                            jVar = new q.l(fVar.b(), fVar.a());
                        } else if (bVar instanceof dr.b.d) {
                            bgVar = this.f42237i.f42227r;
                            dr.b.d dVar = (dr.b.d) bVar;
                            jVar = new q.j(dVar.c(), dVar.b(), dVar.a());
                        }
                        bgVar.d(jVar);
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
            if (this.f42233g == 0) {
                ResultKt.b(obj);
                ar arVar = ar.this;
                BaseScopeOwner.H(arVar, arVar.f42223n.p(), new C0034a(ar.this, null), null, null, null, false, 30, null);
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Inject
    public ar(dr presenter, td model, cr listener, pd openFileChooserDelegate, bg ribAnalyticsManager, jc navigationBarController, xf resourcesProvider) {
        Intrinsics.f(presenter, "presenter");
        Intrinsics.f(model, "model");
        Intrinsics.f(listener, "listener");
        Intrinsics.f(openFileChooserDelegate, "openFileChooserDelegate");
        Intrinsics.f(ribAnalyticsManager, "ribAnalyticsManager");
        Intrinsics.f(navigationBarController, "navigationBarController");
        Intrinsics.f(resourcesProvider, "resourcesProvider");
        this.f42223n = presenter;
        this.f42224o = model;
        this.f42225p = listener;
        this.f42226q = openFileChooserDelegate;
        this.f42227r = ribAnalyticsManager;
        this.f42228s = navigationBarController;
        this.f42229t = resourcesProvider;
        this.f42230u = "WebPageRibView";
        this.f42231v = ac.b.f42045b.e();
    }

    private final void a() {
        if (this.f42223n.c()) {
            this.f42223n.e();
        } else {
            this.f42225p.a();
        }
    }

    private final void b() {
        BaseScopeOwner.F(this, null, null, new a(null), 3, null);
    }

    private final void c() {
        td tdVar = this.f42224o;
        if (tdVar instanceof td.a) {
            this.f42223n.r(tdVar.a(), ((td.a) this.f42224o).e(), ((td.a) this.f42224o).d());
        } else if (tdVar instanceof td.b) {
            this.f42223n.s(tdVar.a(), ((td.b) this.f42224o).d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(String str) {
        Logger logger = this.f42231v;
        logger.c(new IllegalArgumentException("unsupported deep link " + str));
        this.f42223n.d(R$string.web_page_action_not_supported);
    }

    @Override // eu.bolt.coroutines.base.BaseScopeOwner
    public String D() {
        return this.f42230u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor
    public void K(Bundle bundle) {
        super.K(bundle);
        this.f42227r.b(this, new u.e(this.f42224o.a()));
        b();
        this.f42232w = this.f42228s.d();
        this.f42228s.h(this.f42229t.d(R$color.F), true);
        c();
        BaseScopeOwner.H(this, this.f42226q.g(), null, null, null, null, false, 31, null);
        this.f42223n.q(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor
    public void P() {
        super.P();
        this.f42226q.a();
        jc.a aVar = this.f42232w;
        if (aVar != null) {
            this.f42228s.i(aVar);
        }
    }

    @Override // eu.bolt.verification.sdk.internal.ir
    public boolean c(String url) {
        Intrinsics.f(url, "url");
        return this.f42225p.c(url);
    }

    @Override // eu.bolt.android.rib.BaseRibInteractor, eu.bolt.android.rib.RibInteractor, eu.bolt.android.rib.RibLifecycleSubject
    public boolean z(boolean z7) {
        a();
        return true;
    }
}
