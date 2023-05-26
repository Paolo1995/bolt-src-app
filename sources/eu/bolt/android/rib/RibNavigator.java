package eu.bolt.android.rib;

import eu.bolt.android.rib.SerializableRouterNavigatorState;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RibNavigator.kt */
/* loaded from: classes5.dex */
public final class RibNavigator<StateT extends SerializableRouterNavigatorState> {

    /* renamed from: a  reason: collision with root package name */
    private final NavigationDelegate<StateT> f37070a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Function1<StateT, TransitionBundle<StateT>>> f37071b;

    /* renamed from: c  reason: collision with root package name */
    private Function1<? super StateT, TransitionBundle<StateT>> f37072c;

    /* compiled from: RibNavigator.kt */
    /* loaded from: classes5.dex */
    public interface NavigationDelegate<StateT extends SerializableRouterNavigatorState> {
        <R extends Router> R a(StateT statet, RouterNavigator$AttachTransition<R, StateT> routerNavigator$AttachTransition, RouterNavigator$DetachTransition<R, StateT> routerNavigator$DetachTransition, boolean z7, boolean z8, String str, String str2);
    }

    /* compiled from: RibNavigator.kt */
    /* loaded from: classes5.dex */
    public static final class TransitionBundle<StateT extends SerializableRouterNavigatorState> {

        /* renamed from: a  reason: collision with root package name */
        private final RouterNavigator$AttachTransition<?, StateT> f37073a;

        /* renamed from: b  reason: collision with root package name */
        private final RouterNavigator$DetachTransition<?, StateT> f37074b;

        public TransitionBundle(RouterNavigator$AttachTransition<?, StateT> attachTransition, RouterNavigator$DetachTransition<?, StateT> routerNavigator$DetachTransition) {
            Intrinsics.f(attachTransition, "attachTransition");
            this.f37073a = attachTransition;
            this.f37074b = routerNavigator$DetachTransition;
        }

        public final RouterNavigator$AttachTransition<?, StateT> a() {
            return this.f37073a;
        }

        public final RouterNavigator$DetachTransition<?, StateT> b() {
            return this.f37074b;
        }
    }

    public RibNavigator(NavigationDelegate<StateT> router) {
        Intrinsics.f(router, "router");
        this.f37070a = router;
        this.f37071b = new LinkedHashMap();
    }

    private final <R extends Router> boolean b(AttachInfo<StateT> attachInfo, TransitionBundle<StateT> transitionBundle, String str, String str2) {
        RouterNavigator$DetachTransition<R, StateT> routerNavigator$DetachTransition;
        NavigationDelegate<StateT> navigationDelegate = this.f37070a;
        StateT b8 = attachInfo.b();
        RouterNavigator$AttachTransition<?, StateT> a8 = transitionBundle.a();
        if (!(a8 instanceof RouterNavigator$AttachTransition)) {
            a8 = null;
        }
        if (a8 != null) {
            RouterNavigator$DetachTransition<?, StateT> b9 = transitionBundle.b();
            if (b9 instanceof RouterNavigator$DetachTransition) {
                routerNavigator$DetachTransition = b9;
            } else {
                routerNavigator$DetachTransition = null;
            }
            if (navigationDelegate.a(b8, a8, routerNavigator$DetachTransition, attachInfo.a(), attachInfo.c(), str, str2) != null) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final TransitionBundle<StateT> a(StateT state) {
        TransitionBundle<StateT> invoke;
        Intrinsics.f(state, "state");
        Function1<StateT, TransitionBundle<StateT>> function1 = this.f37071b.get(state.name());
        if (function1 == null || (invoke = function1.invoke(state)) == null) {
            Function1<? super StateT, TransitionBundle<StateT>> function12 = this.f37072c;
            if (function12 != null) {
                return function12.invoke(state);
            }
            return null;
        }
        return invoke;
    }

    public final Boolean c(AttachInfo<StateT> attachInfo, String str, String str2) {
        Intrinsics.f(attachInfo, "attachInfo");
        TransitionBundle<StateT> a8 = a(attachInfo.b());
        if (a8 != null) {
            return Boolean.valueOf(b(attachInfo, a8, str, str2));
        }
        return null;
    }

    public final void d(Function1<? super StateT, TransitionBundle<StateT>> factory) {
        Intrinsics.f(factory, "factory");
        this.f37072c = factory;
    }
}
