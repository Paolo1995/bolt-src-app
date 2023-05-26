package eu.bolt.android.rib.transition;

import android.view.ViewGroup;
import eu.bolt.android.rib.Router;
import eu.bolt.android.rib.RouterNavigator$AttachParams;
import eu.bolt.android.rib.RouterNavigator$DetachParams;
import eu.bolt.android.rib.RouterNavigator$RibTransition;
import eu.bolt.android.rib.RouterNavigatorState;
import eu.bolt.android.rib.ViewRouter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RibImmediateTransition.kt */
/* loaded from: classes5.dex */
public class RibImmediateTransition<State extends RouterNavigatorState> implements RouterNavigator$RibTransition<Router, State> {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f37320a;

    /* renamed from: b  reason: collision with root package name */
    private final Function0<Router> f37321b;

    /* renamed from: c  reason: collision with root package name */
    private final Function2<ViewGroup, ViewRouter<?>, Unit> f37322c;

    /* renamed from: d  reason: collision with root package name */
    private final Function2<ViewGroup, ViewRouter<?>, Unit> f37323d;

    /* renamed from: e  reason: collision with root package name */
    private Function2<? super Router, ? super RouterNavigator$DetachParams<State>, Unit> f37324e;

    /* renamed from: f  reason: collision with root package name */
    private Function3<? super Router, ? super RouterNavigator$DetachParams<State>, ? super ViewGroup, Unit> f37325f;

    /* renamed from: g  reason: collision with root package name */
    private Function3<? super Router, ? super RouterNavigator$AttachParams<State>, ? super ViewGroup, Unit> f37326g;

    /* renamed from: h  reason: collision with root package name */
    private Function3<? super Router, ? super RouterNavigator$AttachParams<State>, ? super ViewGroup, Unit> f37327h;

    /* JADX WARN: Multi-variable type inference failed */
    public RibImmediateTransition(ViewGroup container, Function0<? extends Router> routerFactory, Function2<? super ViewGroup, ? super ViewRouter<?>, Unit> attachAction, Function2<? super ViewGroup, ? super ViewRouter<?>, Unit> detachAction) {
        Intrinsics.f(container, "container");
        Intrinsics.f(routerFactory, "routerFactory");
        Intrinsics.f(attachAction, "attachAction");
        Intrinsics.f(detachAction, "detachAction");
        this.f37320a = container;
        this.f37321b = routerFactory;
        this.f37322c = attachAction;
        this.f37323d = detachAction;
    }

    @Override // eu.bolt.android.rib.RouterNavigator$AttachTransition
    public Router a() {
        return this.f37321b.invoke();
    }

    @Override // eu.bolt.android.rib.RouterNavigator$DetachTransition
    public boolean b(Router router, RouterNavigator$DetachParams<State> params) {
        Intrinsics.f(router, "router");
        Intrinsics.f(params, "params");
        Function2<? super Router, ? super RouterNavigator$DetachParams<State>, Unit> function2 = this.f37324e;
        if (function2 != null) {
            function2.s(router, params);
        }
        if (router instanceof ViewRouter) {
            this.f37323d.s(this.f37320a, router);
        }
        Function3<? super Router, ? super RouterNavigator$DetachParams<State>, ? super ViewGroup, Unit> function3 = this.f37325f;
        if (function3 != null) {
            function3.l(router, params, this.f37320a);
            return true;
        }
        return true;
    }

    @Override // eu.bolt.android.rib.RouterNavigator$AttachTransition
    public void c(Router router, RouterNavigator$AttachParams<State> params) {
        Intrinsics.f(router, "router");
        Intrinsics.f(params, "params");
        Function3<? super Router, ? super RouterNavigator$AttachParams<State>, ? super ViewGroup, Unit> function3 = this.f37327h;
        if (function3 != null) {
            function3.l(router, params, this.f37320a);
        }
        if (router instanceof ViewRouter) {
            this.f37322c.s(this.f37320a, router);
        }
        Function3<? super Router, ? super RouterNavigator$AttachParams<State>, ? super ViewGroup, Unit> function32 = this.f37326g;
        if (function32 != null) {
            function32.l(router, params, this.f37320a);
        }
    }

    public /* synthetic */ RibImmediateTransition(ViewGroup viewGroup, Function0 function0, Function2 function2, Function2 function22, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, function0, (i8 & 4) != 0 ? new Function2<ViewGroup, ViewRouter<?>, Unit>() { // from class: eu.bolt.android.rib.transition.RibImmediateTransition.1
            /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View] */
            public final void b(ViewGroup parent, ViewRouter<?> router) {
                Intrinsics.f(parent, "parent");
                Intrinsics.f(router, "router");
                if (router.A().getParent() == null && !Intrinsics.a(parent, router.A())) {
                    parent.addView(router.A());
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(ViewGroup viewGroup2, ViewRouter<?> viewRouter) {
                b(viewGroup2, viewRouter);
                return Unit.f50853a;
            }
        } : function2, (i8 & 8) != 0 ? new Function2<ViewGroup, ViewRouter<?>, Unit>() { // from class: eu.bolt.android.rib.transition.RibImmediateTransition.2
            public final void b(ViewGroup parent, ViewRouter<?> router) {
                Intrinsics.f(parent, "parent");
                Intrinsics.f(router, "router");
                parent.removeView(router.A());
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(ViewGroup viewGroup2, ViewRouter<?> viewRouter) {
                b(viewGroup2, viewRouter);
                return Unit.f50853a;
            }
        } : function22);
    }
}
