package eu.bolt.android.rib.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import eu.bolt.android.rib.Router;
import eu.bolt.android.rib.RouterNavigator$AttachParams;
import eu.bolt.android.rib.RouterNavigator$AttachTransition;
import eu.bolt.android.rib.RouterNavigator$DetachParams;
import eu.bolt.android.rib.RouterNavigator$RibTransition;
import eu.bolt.android.rib.RouterNavigator$RouterAndState;
import eu.bolt.android.rib.RouterNavigatorState;
import eu.bolt.android.rib.ViewRouter;
import eu.bolt.android.rib.transition.RibGenericTransition;
import eu.bolt.android.ribs.R$id;
import eu.bolt.logger.Logger;
import eu.bolt.logger.StaticLogger;
import eu.bolt.logger.exception.DiagnosisException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RibGenericTransition.kt */
/* loaded from: classes5.dex */
public class RibGenericTransition<State extends RouterNavigatorState> implements RouterNavigator$RibTransition<ViewRouter<?>, State> {

    /* renamed from: t */
    public static final Companion f37256t = new Companion(null);
    @SuppressLint({"ClickableViewAccessibility"})

    /* renamed from: u */
    private static final View.OnTouchListener f37257u = new View.OnTouchListener() { // from class: eu.bolt.android.rib.transition.a
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            boolean e8;
            e8 = RibGenericTransition.e(view, motionEvent);
            return e8;
        }
    };

    /* renamed from: a */
    private final ViewGroup f37258a;

    /* renamed from: b */
    private final Function0<ViewRouter<?>> f37259b;

    /* renamed from: c */
    private RibAttachAnimationFactory<State> f37260c;

    /* renamed from: d */
    private RibTransitionAnimation f37261d;

    /* renamed from: e */
    private RibTransitionAnimation f37262e;

    /* renamed from: f */
    private boolean f37263f;

    /* renamed from: g */
    private RibDetachAnimationFactory<State> f37264g;

    /* renamed from: h */
    private RibTransitionAnimation f37265h;

    /* renamed from: i */
    private RibTransitionAnimation f37266i;

    /* renamed from: j */
    private boolean f37267j;

    /* renamed from: k */
    private Function3<? super ViewRouter<?>, ? super RouterNavigator$AttachParams<State>, ? super ViewGroup, Unit> f37268k;

    /* renamed from: l */
    private Function3<? super ViewRouter<?>, ? super RouterNavigator$AttachParams<State>, ? super ViewGroup, Unit> f37269l;

    /* renamed from: m */
    private Function3<? super ViewRouter<?>, ? super RouterNavigator$AttachParams<State>, ? super ViewGroup, Unit> f37270m;

    /* renamed from: n */
    private Function3<? super ViewRouter<?>, ? super RouterNavigator$DetachParams<State>, ? super ViewGroup, Unit> f37271n;

    /* renamed from: o */
    private Function3<? super ViewRouter<?>, ? super RouterNavigator$DetachParams<State>, ? super ViewGroup, Unit> f37272o;

    /* renamed from: p */
    private Function0<? extends ViewGroup.LayoutParams> f37273p;

    /* renamed from: q */
    private Function3<? super ViewRouter<?>, ? super RouterNavigator$AttachParams<State>, ? super ViewGroup, Unit> f37274q;

    /* renamed from: r */
    private Function3<? super ViewRouter<?>, ? super RouterNavigator$DetachParams<State>, ? super ViewGroup, Unit> f37275r;

    /* renamed from: s */
    private Function1<? super ViewGroup, Integer> f37276s;

    /* compiled from: RibGenericTransition.kt */
    /* loaded from: classes5.dex */
    public final class CancellablePreDrawAction implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: f */
        private final View f37285f;

        /* renamed from: g */
        private final boolean f37286g;

        /* renamed from: h */
        private final Function0<Unit> f37287h;

        /* renamed from: i */
        private boolean f37288i;

        /* renamed from: j */
        private Function0<Unit> f37289j;

        /* renamed from: k */
        final /* synthetic */ RibGenericTransition<State> f37290k;

        public CancellablePreDrawAction(RibGenericTransition ribGenericTransition, View container, boolean z7, Function0<Unit> action) {
            Intrinsics.f(container, "container");
            Intrinsics.f(action, "action");
            this.f37290k = ribGenericTransition;
            this.f37285f = container;
            this.f37286g = z7;
            this.f37287h = action;
        }

        private final void c() {
            Activity activity;
            View view;
            if (this.f37285f.isAttachedToWindow()) {
                this.f37285f.getViewTreeObserver().removeOnPreDrawListener(this);
                return;
            }
            Context context = this.f37285f.getContext();
            ViewTreeObserver viewTreeObserver = null;
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null) {
                view = activity.findViewById(16908290);
            } else {
                view = null;
            }
            if (view != null) {
                viewTreeObserver = view.getViewTreeObserver();
            }
            boolean z7 = true;
            if ((viewTreeObserver == null || !viewTreeObserver.isAlive()) ? false : false) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
        }

        public final void a() {
            this.f37288i = true;
            c();
            Function0<Unit> function0 = this.f37289j;
            if (function0 != null) {
                function0.invoke();
            }
        }

        public final void b(Function0<Unit> function0) {
            this.f37289j = function0;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!this.f37288i) {
                this.f37287h.invoke();
            }
            c();
            return !this.f37286g;
        }
    }

    /* compiled from: RibGenericTransition.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: RibGenericTransition.kt */
    /* loaded from: classes5.dex */
    public static final class DisableTouchForAnimationListener extends AnimatorListenerAdapter {

        /* renamed from: a */
        private final View f37291a;

        /* renamed from: b */
        private final boolean f37292b;

        /* renamed from: c */
        private final ViewGroup f37293c;

        /* renamed from: d */
        private final View f37294d;

        /* renamed from: e */
        private final List<TouchableViewController> f37295e;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: RibGenericTransition.kt */
        /* loaded from: classes5.dex */
        public static final class TouchableViewController {

            /* renamed from: a */
            private final View f37296a;

            /* renamed from: b */
            private final boolean f37297b;

            /* renamed from: c */
            private final boolean f37298c;

            public TouchableViewController(View view) {
                Intrinsics.f(view, "view");
                this.f37296a = view;
                this.f37297b = view.isClickable();
                this.f37298c = view.isLongClickable();
            }

            public final void a() {
                this.f37296a.setClickable(false);
                this.f37296a.setLongClickable(false);
            }

            public final void b() {
                this.f37296a.setClickable(this.f37297b);
                this.f37296a.setLongClickable(this.f37298c);
            }
        }

        public DisableTouchForAnimationListener(View view, boolean z7) {
            ViewGroup viewGroup;
            View view2;
            ArrayList<View> touchables;
            int v7;
            Intrinsics.f(view, "view");
            this.f37291a = view;
            this.f37292b = z7;
            ArrayList arrayList = null;
            if (view instanceof ViewGroup) {
                viewGroup = (ViewGroup) view;
            } else {
                viewGroup = null;
            }
            this.f37293c = viewGroup;
            if (viewGroup != null) {
                view2 = viewGroup.findFocus();
            } else {
                view2 = null;
            }
            this.f37294d = view2;
            if (viewGroup != null && (touchables = viewGroup.getTouchables()) != null) {
                v7 = CollectionsKt__IterablesKt.v(touchables, 10);
                arrayList = new ArrayList(v7);
                for (View it : touchables) {
                    Intrinsics.e(it, "it");
                    arrayList.add(new TouchableViewController(it));
                }
            }
            this.f37295e = arrayList;
        }

        private final void a() {
            View view;
            if (this.f37292b) {
                ViewGroup viewGroup = this.f37293c;
                if (viewGroup != null) {
                    view = viewGroup.findFocus();
                } else {
                    view = null;
                }
                if (view instanceof EditText) {
                    c(view);
                }
            }
        }

        private final void b(boolean z7) {
            if (z7) {
                ViewGroup viewGroup = this.f37293c;
                if (viewGroup != null) {
                    viewGroup.setDescendantFocusability(131072);
                }
                if (this.f37292b) {
                    View view = this.f37294d;
                    if (view == null) {
                        ViewGroup viewGroup2 = this.f37293c;
                        if (viewGroup2 != null) {
                            viewGroup2.requestFocus(130);
                            return;
                        }
                        return;
                    }
                    view.requestFocus();
                    return;
                }
                return;
            }
            ViewGroup viewGroup3 = this.f37293c;
            if (viewGroup3 != null) {
                viewGroup3.setDescendantFocusability(393216);
            }
            View view2 = this.f37294d;
            if (view2 != null) {
                view2.clearFocus();
            }
        }

        private final void c(View view) {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(this.f37291a.getContext(), InputMethodManager.class);
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(view, 1);
                }
            } catch (Throwable th) {
                Logger.DefaultImpls.a(StaticLogger.f41686a, th, null, 2, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.f(animation, "animation");
            b(true);
            List<TouchableViewController> list = this.f37295e;
            if (list != null) {
                for (TouchableViewController touchableViewController : list) {
                    touchableViewController.b();
                }
            }
            this.f37291a.setOnTouchListener(null);
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.f(animation, "animation");
            b(false);
            List<TouchableViewController> list = this.f37295e;
            if (list != null) {
                for (TouchableViewController touchableViewController : list) {
                    touchableViewController.a();
                }
            }
            this.f37291a.setOnTouchListener(RibGenericTransition.f37257u);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RibGenericTransition(ViewGroup container, Function0<? extends ViewRouter<?>> routerFactory) {
        Intrinsics.f(container, "container");
        Intrinsics.f(routerFactory, "routerFactory");
        this.f37258a = container;
        this.f37259b = routerFactory;
        this.f37263f = true;
        this.f37267j = true;
        this.f37273p = new Function0<ViewGroup.LayoutParams>(this) { // from class: eu.bolt.android.rib.transition.RibGenericTransition$attachLayoutParamsFactory$1

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ RibGenericTransition<State> f37300f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.f37300f = this;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ViewGroup.LayoutParams invoke() {
                ViewGroup.LayoutParams s7;
                s7 = this.f37300f.s();
                return s7;
            }
        };
        this.f37274q = new Function3<ViewRouter<?>, RouterNavigator$AttachParams<State>, ViewGroup, Unit>(this) { // from class: eu.bolt.android.rib.transition.RibGenericTransition$attachAction$1

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ RibGenericTransition<State> f37299f;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
                this.f37299f = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v6, types: [android.view.View] */
            /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View] */
            public final void b(ViewRouter<?> viewRouter, RouterNavigator$AttachParams<State> params, ViewGroup viewGroup) {
                Function1 function1;
                ViewGroup viewGroup2;
                int w7;
                Function0 function0;
                ViewGroup viewGroup3;
                Intrinsics.f(viewRouter, "viewRouter");
                Intrinsics.f(params, "params");
                Intrinsics.f(viewGroup, "viewGroup");
                function1 = ((RibGenericTransition) this.f37299f).f37276s;
                if (function1 != null) {
                    viewGroup3 = ((RibGenericTransition) this.f37299f).f37258a;
                    w7 = ((Number) function1.invoke(viewGroup3)).intValue();
                } else {
                    RibGenericTransition<State> ribGenericTransition = this.f37299f;
                    viewGroup2 = ((RibGenericTransition) ribGenericTransition).f37258a;
                    w7 = ribGenericTransition.w(viewGroup2, params);
                }
                if (viewRouter.A().getParent() == null && !Intrinsics.a(viewGroup, viewRouter.A())) {
                    ?? A = viewRouter.A();
                    function0 = ((RibGenericTransition) this.f37299f).f37273p;
                    viewGroup.addView((View) A, w7, (ViewGroup.LayoutParams) function0.invoke());
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(ViewRouter<?> viewRouter, Object obj, ViewGroup viewGroup) {
                b(viewRouter, (RouterNavigator$AttachParams) obj, viewGroup);
                return Unit.f50853a;
            }
        };
        this.f37275r = new Function3<ViewRouter<?>, RouterNavigator$DetachParams<State>, ViewGroup, Unit>() { // from class: eu.bolt.android.rib.transition.RibGenericTransition$detachAction$1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View] */
            public final void b(ViewRouter<?> viewRouter, RouterNavigator$DetachParams<State> routerNavigator$DetachParams, ViewGroup container2) {
                Intrinsics.f(viewRouter, "viewRouter");
                Intrinsics.f(routerNavigator$DetachParams, "<anonymous parameter 1>");
                Intrinsics.f(container2, "container");
                container2.removeView(viewRouter.A());
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(ViewRouter<?> viewRouter, Object obj, ViewGroup viewGroup) {
                b(viewRouter, (RouterNavigator$DetachParams) obj, viewGroup);
                return Unit.f50853a;
            }
        };
    }

    private final RibTransitionAnimation A(State state, State state2, boolean z7) {
        boolean z8;
        RibAttachAnimationFactory<State> ribAttachAnimationFactory = this.f37260c;
        if (ribAttachAnimationFactory != null) {
            return ribAttachAnimationFactory.a(!z7, state, state2);
        }
        boolean z9 = false;
        if (state == null && this.f37263f) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            return null;
        }
        if ((z7 || this.f37262e == null) ? true : true) {
            return this.f37261d;
        }
        return this.f37262e;
    }

    private final RibTransitionAnimation B(State state, State state2, boolean z7) {
        boolean z8;
        RibDetachAnimationFactory<State> ribDetachAnimationFactory = this.f37264g;
        if (ribDetachAnimationFactory != null) {
            return ribDetachAnimationFactory.a(z7, state, state2);
        }
        boolean z9 = false;
        if (state2 == null && this.f37267j) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            return null;
        }
        if ((!z7 || this.f37266i == null) ? true : true) {
            return this.f37265h;
        }
        return this.f37266i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.view.View] */
    public final void C(final RibTransitionAnimation ribTransitionAnimation, final ViewRouter<?> viewRouter, final RouterNavigator$DetachParams<State> routerNavigator$DetachParams) {
        final ?? A = viewRouter.A();
        Animator c8 = ribTransitionAnimation.c(A);
        c8.addListener(new DisableTouchForAnimationListener(A, false));
        c8.addListener(new Animator.AnimatorListener() { // from class: eu.bolt.android.rib.transition.RibGenericTransition$runDetachAnimation$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.f(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.f(animator, "animator");
                RibGenericTransition.this.y(ribTransitionAnimation, viewRouter, routerNavigator$DetachParams);
                A.setTag(R$id.key_rib_animation, null);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.f(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.f(animator, "animator");
            }
        });
        A.setTag(R$id.key_rib_animation, c8);
        c8.start();
    }

    public static /* synthetic */ RibGenericTransition G(RibGenericTransition ribGenericTransition, RibTransitionAnimation ribTransitionAnimation, boolean z7, int i8, Object obj) {
        if (obj == null) {
            if ((i8 & 2) != 0) {
                z7 = false;
            }
            return ribGenericTransition.F(ribTransitionAnimation, z7);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withAttachAnimation");
    }

    public static /* synthetic */ RibGenericTransition K(RibGenericTransition ribGenericTransition, RibTransitionAnimation ribTransitionAnimation, boolean z7, int i8, Object obj) {
        if (obj == null) {
            if ((i8 & 2) != 0) {
                z7 = false;
            }
            return ribGenericTransition.J(ribTransitionAnimation, z7);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withDetachAnimation");
    }

    public static final boolean e(View view, MotionEvent motionEvent) {
        return true;
    }

    private final void r(View view) {
        int i8 = R$id.key_rib_animation;
        Object tag = view.getTag(i8);
        if (tag instanceof Animator) {
            Animator animator = (Animator) tag;
            if (animator.isRunning()) {
                animator.cancel();
                view.setTag(i8, null);
            }
        }
        if (tag instanceof CancellablePreDrawAction) {
            ((CancellablePreDrawAction) tag).a();
        }
        view.setTag(i8, null);
    }

    public final ViewGroup.LayoutParams s() {
        return new ViewGroup.LayoutParams(-1, -1);
    }

    public final void t(RibTransitionAnimation ribTransitionAnimation, ViewRouter<?> viewRouter, RouterNavigator$DetachParams<State> routerNavigator$DetachParams) {
        ribTransitionAnimation.e(viewRouter.A());
        z(viewRouter, routerNavigator$DetachParams);
    }

    private final RibGenericTransition<State>.CancellablePreDrawAction u(View view, boolean z7, Function0<Unit> function0) {
        RibGenericTransition<State>.CancellablePreDrawAction cancellablePreDrawAction = new CancellablePreDrawAction(this, this.f37258a, z7, function0);
        this.f37258a.getViewTreeObserver().addOnPreDrawListener(cancellablePreDrawAction);
        view.setTag(R$id.key_rib_animation, cancellablePreDrawAction);
        return cancellablePreDrawAction;
    }

    public final void v(ViewRouter<?> viewRouter, RouterNavigator$AttachParams<State> routerNavigator$AttachParams) {
        Function3<? super ViewRouter<?>, ? super RouterNavigator$AttachParams<State>, ? super ViewGroup, Unit> function3 = this.f37270m;
        if (function3 != null) {
            function3.l(viewRouter, routerNavigator$AttachParams, this.f37258a);
        }
        Function3<? super ViewRouter<?>, ? super RouterNavigator$AttachParams<State>, ? super ViewGroup, Unit> function32 = this.f37269l;
        if (function32 != null) {
            function32.l(viewRouter, routerNavigator$AttachParams, this.f37258a);
        }
    }

    public final int w(ViewGroup viewGroup, RouterNavigator$AttachParams<?> routerNavigator$AttachParams) {
        boolean z7;
        if (routerNavigator$AttachParams.f37089f != null && !routerNavigator$AttachParams.f37086c) {
            Integer num = null;
            View view = null;
            for (View view2 : ViewGroupKt.a(viewGroup)) {
                if (Intrinsics.a(view2.getClass(), routerNavigator$AttachParams.f37089f)) {
                    view = view2;
                }
            }
            Integer valueOf = Integer.valueOf(viewGroup.indexOfChild(view));
            if (valueOf.intValue() > -1) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                num = valueOf;
            }
            if (num != null) {
                return num.intValue();
            }
            return viewGroup.getChildCount();
        }
        return viewGroup.getChildCount();
    }

    private final boolean x(View view) {
        Object tag = view.getTag(R$id.key_rib_animation);
        if (!(tag instanceof Animator) && !(tag instanceof CancellablePreDrawAction)) {
            return false;
        }
        return true;
    }

    public final void y(final RibTransitionAnimation ribTransitionAnimation, final ViewRouter<?> viewRouter, final RouterNavigator$DetachParams<State> routerNavigator$DetachParams) {
        RouterNavigator$AttachTransition routerNavigator$AttachTransition;
        RibGenericTransition ribGenericTransition;
        ViewRouter viewRouter2;
        RouterNavigator$RouterAndState<State> routerNavigator$RouterAndState = routerNavigator$DetachParams.f37092b;
        Unit unit = null;
        View view = null;
        if (routerNavigator$RouterAndState != null) {
            routerNavigator$AttachTransition = routerNavigator$RouterAndState.a();
        } else {
            routerNavigator$AttachTransition = null;
        }
        if (routerNavigator$AttachTransition instanceof RibGenericTransition) {
            ribGenericTransition = (RibGenericTransition) routerNavigator$AttachTransition;
        } else {
            ribGenericTransition = null;
        }
        if (ribGenericTransition != null) {
            Router c8 = routerNavigator$RouterAndState.c();
            if (c8 instanceof ViewRouter) {
                viewRouter2 = (ViewRouter) c8;
            } else {
                viewRouter2 = null;
            }
            if (viewRouter2 != null) {
                view = viewRouter2.A();
            }
            if (view != null && ribGenericTransition.x(view)) {
                ribGenericTransition.f37270m = new Function3<ViewRouter<?>, RouterNavigator$AttachParams<RouterNavigatorState>, ViewGroup, Unit>(this) { // from class: eu.bolt.android.rib.transition.RibGenericTransition$postActionAfterDetachAnimation$1$1

                    /* renamed from: f  reason: collision with root package name */
                    final /* synthetic */ RibGenericTransition<State> f37302f;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                        this.f37302f = this;
                    }

                    public final void b(ViewRouter<?> viewRouter3, RouterNavigator$AttachParams<RouterNavigatorState> routerNavigator$AttachParams, ViewGroup viewGroup) {
                        Intrinsics.f(viewRouter3, "<anonymous parameter 0>");
                        Intrinsics.f(routerNavigator$AttachParams, "<anonymous parameter 1>");
                        Intrinsics.f(viewGroup, "<anonymous parameter 2>");
                        this.f37302f.t(ribTransitionAnimation, viewRouter, routerNavigator$DetachParams);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit l(ViewRouter<?> viewRouter3, RouterNavigator$AttachParams<RouterNavigatorState> routerNavigator$AttachParams, ViewGroup viewGroup) {
                        b(viewRouter3, routerNavigator$AttachParams, viewGroup);
                        return Unit.f50853a;
                    }
                };
            } else {
                t(ribTransitionAnimation, viewRouter, routerNavigator$DetachParams);
            }
            unit = Unit.f50853a;
        }
        if (unit == null) {
            t(ribTransitionAnimation, viewRouter, routerNavigator$DetachParams);
        }
    }

    public final void z(final ViewRouter<?> viewRouter, RouterNavigator$DetachParams<State> routerNavigator$DetachParams) {
        try {
            this.f37275r.l(viewRouter, routerNavigator$DetachParams, this.f37258a);
        } catch (NullPointerException unused) {
            StaticLogger.f41686a.h(new DiagnosisException("CLIENTAPP-13153", false, new Function1<Map<String, Object>, Unit>(this) { // from class: eu.bolt.android.rib.transition.RibGenericTransition$removeViewFromContainer$exception$1

                /* renamed from: f  reason: collision with root package name */
                final /* synthetic */ RibGenericTransition<State> f37306f;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.f37306f = this;
                }

                public final void b(Map<String, Object> $receiver) {
                    ViewGroup viewGroup;
                    List H0;
                    String f02;
                    ViewGroup viewGroup2;
                    Intrinsics.f($receiver, "$this$$receiver");
                    viewGroup = ((RibGenericTransition) this.f37306f).f37258a;
                    $receiver.put("container", viewGroup);
                    $receiver.put("viewRouter", viewRouter);
                    H0 = CollectionsKt___CollectionsKt.H0(viewRouter.o());
                    f02 = CollectionsKt___CollectionsKt.f0(H0, null, null, null, 0, null, new Function1<Router, CharSequence>() { // from class: eu.bolt.android.rib.transition.RibGenericTransition$removeViewFromContainer$exception$1.1
                        @Override // kotlin.jvm.functions.Function1
                        /* renamed from: b */
                        public final CharSequence invoke(Router it) {
                            Intrinsics.f(it, "it");
                            return it.r();
                        }
                    }, 31, null);
                    $receiver.put("children", f02);
                    $receiver.put("view", viewRouter.A());
                    viewGroup2 = ((RibGenericTransition) this.f37306f).f37258a;
                    $receiver.put("isContainerAttachedToWindow", Boolean.valueOf(viewGroup2.isAttachedToWindow()));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Map<String, Object> map) {
                    b(map);
                    return Unit.f50853a;
                }
            }, 2, null));
        }
        Function3<? super ViewRouter<?>, ? super RouterNavigator$DetachParams<State>, ? super ViewGroup, Unit> function3 = this.f37272o;
        if (function3 != null) {
            function3.l(viewRouter, routerNavigator$DetachParams, this.f37258a);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.view.View] */
    @Override // eu.bolt.android.rib.RouterNavigator$AttachTransition
    /* renamed from: D */
    public void c(final ViewRouter<?> router, final RouterNavigator$AttachParams<State> params) {
        State state;
        Intrinsics.f(router, "router");
        Intrinsics.f(params, "params");
        r(router.A());
        Function3<? super ViewRouter<?>, ? super RouterNavigator$AttachParams<State>, ? super ViewGroup, Unit> function3 = this.f37268k;
        if (function3 != null) {
            function3.l(router, params, this.f37258a);
        }
        this.f37274q.l(router, params, this.f37258a);
        RouterNavigator$RouterAndState<State> routerNavigator$RouterAndState = params.f37084a;
        if (routerNavigator$RouterAndState != null) {
            state = routerNavigator$RouterAndState.d();
        } else {
            state = null;
        }
        State state2 = params.f37085b;
        Intrinsics.e(state2, "params.newState");
        final RibTransitionAnimation A = A(state, state2, params.f37086c);
        if (A != null && !params.f37088e) {
            u(router.A(), true, new Function0<Unit>() { // from class: eu.bolt.android.rib.transition.RibGenericTransition$willAttachToHost$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r1v3, types: [android.view.View] */
                /* JADX WARN: Type inference failed for: r2v2, types: [android.view.View] */
                public final void b() {
                    Animator c8 = RibTransitionAnimation.this.c(router.A());
                    router.A().setTag(R$id.key_rib_animation, c8);
                    c8.addListener(new RibGenericTransition.DisableTouchForAnimationListener(router.A(), true));
                    final RibGenericTransition<State> ribGenericTransition = this;
                    final ViewRouter<?> viewRouter = router;
                    final RouterNavigator$AttachParams<State> routerNavigator$AttachParams = params;
                    c8.addListener(new Animator.AnimatorListener() { // from class: eu.bolt.android.rib.transition.RibGenericTransition$willAttachToHost$1$invoke$$inlined$doOnEnd$1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            Intrinsics.f(animator, "animator");
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            Intrinsics.f(animator, "animator");
                            RibGenericTransition.this.v(viewRouter, routerNavigator$AttachParams);
                            viewRouter.A().setTag(R$id.key_rib_animation, null);
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                            Intrinsics.f(animator, "animator");
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            Intrinsics.f(animator, "animator");
                        }
                    });
                    c8.start();
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    b();
                    return Unit.f50853a;
                }
            });
        } else {
            v(router, params);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.view.View] */
    @Override // eu.bolt.android.rib.RouterNavigator$DetachTransition
    /* renamed from: E */
    public boolean b(final ViewRouter<?> router, final RouterNavigator$DetachParams<State> params) {
        State state;
        Intrinsics.f(router, "router");
        Intrinsics.f(params, "params");
        r(router.A());
        if (router.A().getParent() == null) {
            return true;
        }
        State state2 = params.f37091a;
        Intrinsics.e(state2, "params.previousState");
        RouterNavigator$RouterAndState<State> routerNavigator$RouterAndState = params.f37092b;
        if (routerNavigator$RouterAndState != null) {
            state = routerNavigator$RouterAndState.d();
        } else {
            state = null;
        }
        final RibTransitionAnimation B = B(state2, state, params.f37093c);
        Function3<? super ViewRouter<?>, ? super RouterNavigator$DetachParams<State>, ? super ViewGroup, Unit> function3 = this.f37271n;
        if (function3 != null) {
            function3.l(router, params, this.f37258a);
        }
        if (B != null && !params.f37094d) {
            if (ViewCompat.W(router.A())) {
                C(B, router, params);
            } else {
                u(router.A(), false, new Function0<Unit>(this) { // from class: eu.bolt.android.rib.transition.RibGenericTransition$willDetachFromHost$cancellableListener$1

                    /* renamed from: f  reason: collision with root package name */
                    final /* synthetic */ RibGenericTransition<State> f37316f;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.f37316f = this;
                    }

                    public final void b() {
                        this.f37316f.C(B, router, params);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        b();
                        return Unit.f50853a;
                    }
                }).b(new Function0<Unit>(this) { // from class: eu.bolt.android.rib.transition.RibGenericTransition$willDetachFromHost$1

                    /* renamed from: f  reason: collision with root package name */
                    final /* synthetic */ RibGenericTransition<State> f37313f;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.f37313f = this;
                    }

                    public final void b() {
                        this.f37313f.z(router, params);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        b();
                        return Unit.f50853a;
                    }
                });
            }
            return false;
        }
        z(router, params);
        return true;
    }

    public final RibGenericTransition<State> F(RibTransitionAnimation anim, boolean z7) {
        Intrinsics.f(anim, "anim");
        this.f37261d = anim;
        this.f37263f = z7;
        return this;
    }

    public final RibGenericTransition<State> H(RibAttachAnimationFactory<State> factory) {
        Intrinsics.f(factory, "factory");
        this.f37260c = factory;
        return this;
    }

    public final RibGenericTransition<State> I(Function1<? super ViewGroup, Integer> provider) {
        Intrinsics.f(provider, "provider");
        this.f37276s = provider;
        return this;
    }

    public final RibGenericTransition<State> J(RibTransitionAnimation anim, boolean z7) {
        Intrinsics.f(anim, "anim");
        this.f37265h = anim;
        this.f37267j = z7;
        return this;
    }

    public final RibGenericTransition<State> L(RibDetachAnimationFactory<State> factory) {
        Intrinsics.f(factory, "factory");
        this.f37264g = factory;
        return this;
    }

    public final RibGenericTransition<State> M(Function0<? extends ViewGroup.LayoutParams> paramsFactory) {
        Intrinsics.f(paramsFactory, "paramsFactory");
        this.f37273p = paramsFactory;
        return this;
    }

    public final RibGenericTransition<State> N(Function3<? super ViewRouter<?>, ? super RouterNavigator$AttachParams<State>, ? super ViewGroup, Unit> action) {
        Intrinsics.f(action, "action");
        this.f37268k = action;
        return this;
    }

    @Override // eu.bolt.android.rib.RouterNavigator$AttachTransition
    /* renamed from: q */
    public ViewRouter<?> a() {
        return this.f37259b.invoke();
    }
}
