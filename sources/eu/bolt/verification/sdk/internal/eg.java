package eu.bolt.verification.sdk.internal;

import android.view.ViewGroup;
import eu.bolt.android.rib.RouterNavigator$AttachParams;
import eu.bolt.android.rib.RouterNavigator$DetachParams;
import eu.bolt.android.rib.RouterNavigator$RibTransition;
import eu.bolt.android.rib.RouterNavigatorState;
import eu.bolt.android.rib.ViewRouter;
import eu.bolt.verification.sdk.internal.q4;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Predicate;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public class eg<State extends RouterNavigatorState> implements RouterNavigator$RibTransition<ViewRouter<? extends e4>, State> {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f42761a;

    /* renamed from: b  reason: collision with root package name */
    private final Function0<ViewRouter<? extends e4>> f42762b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<State, Unit> f42763c;

    /* renamed from: d  reason: collision with root package name */
    private CompositeDisposable f42764d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a extends Lambda implements Function1<ae, Boolean> {

        /* renamed from: f  reason: collision with root package name */
        public static final a f42765f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final Boolean invoke(ae it) {
            Intrinsics.f(it, "it");
            return Boolean.valueOf(it == ae.HIDDEN);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b extends Lambda implements Function0<Unit> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ eg<State> f42766f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ RouterNavigator$AttachParams<State> f42767g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(eg<State> egVar, RouterNavigator$AttachParams<State> routerNavigator$AttachParams) {
            super(0);
            this.f42766f = egVar;
            this.f42767g = routerNavigator$AttachParams;
        }

        public final void b() {
            Function1 function1 = ((eg) this.f42766f).f42763c;
            State state = this.f42767g.f37085b;
            Intrinsics.e(state, "params.newState");
            function1.invoke(state);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            b();
            return Unit.f50853a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public eg(ViewGroup container, Function0<? extends ViewRouter<? extends e4>> routerFactory, Function1<? super State, Unit> closeListener) {
        Intrinsics.f(container, "container");
        Intrinsics.f(routerFactory, "routerFactory");
        Intrinsics.f(closeListener, "closeListener");
        this.f42761a = container;
        this.f42762b = routerFactory;
        this.f42763c = closeListener;
        this.f42764d = new CompositeDisposable();
    }

    private final void i(ViewRouter<? extends e4> viewRouter) {
        this.f42761a.removeView(viewRouter.A());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(eg this$0, ViewRouter router, boolean z7) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(router, "$router");
        this$0.f42764d.d();
        this$0.f42761a.removeView(router.A());
        q4.a.a((q4) router.A(), z7, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    @Override // eu.bolt.android.rib.RouterNavigator$AttachTransition
    /* renamed from: f */
    public ViewRouter<? extends e4> a() {
        return this.f42762b.invoke();
    }

    public final Completable g(e4 bottomSheetPanel) {
        Intrinsics.f(bottomSheetPanel, "bottomSheetPanel");
        Observable<ae> panelStateUpdates = bottomSheetPanel.getPanelStateUpdates();
        final a aVar = a.f42765f;
        Completable ignoreElements = panelStateUpdates.filter(new Predicate() { // from class: eu.bolt.verification.sdk.internal.js
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean m8;
                m8 = eg.m(Function1.this, obj);
                return m8;
            }
        }).take(1L).ignoreElements();
        Intrinsics.e(ignoreElements, "bottomSheetPanel.getPane…        .ignoreElements()");
        return ignoreElements;
    }

    @Override // eu.bolt.android.rib.RouterNavigator$AttachTransition
    /* renamed from: j */
    public void c(ViewRouter<? extends e4> router, RouterNavigator$AttachParams<State> params) {
        Intrinsics.f(router, "router");
        Intrinsics.f(params, "params");
        this.f42764d.d();
        this.f42761a.addView(router.A());
        ug.u(ug.p(g(router.A()), new b(this, params), null, null, 6, null), this.f42764d);
    }

    @Override // eu.bolt.android.rib.RouterNavigator$DetachTransition
    /* renamed from: l */
    public boolean b(ViewRouter<? extends e4> router, RouterNavigator$DetachParams<State> params) {
        Intrinsics.f(router, "router");
        Intrinsics.f(params, "params");
        this.f42764d.d();
        if (router.A().getPanelState() == ae.HIDDEN) {
            i(router);
            return false;
        }
        n(router);
        return false;
    }

    protected void n(final ViewRouter<? extends e4> router) {
        Intrinsics.f(router, "router");
        final boolean R0 = router.A().R0();
        q4.a.a(router.A(), false, false, 2, null);
        router.A().M0();
        Completable m8 = g(router.A()).m(new Action() { // from class: eu.bolt.verification.sdk.internal.is
            @Override // io.reactivex.functions.Action
            public final void run() {
                eg.k(eg.this, router, R0);
            }
        });
        Intrinsics.e(m8, "panelClosedCompletable(r…e(oldValue)\n            }");
        ug.u(ug.p(m8, null, null, null, 7, null), this.f42764d);
    }
}
