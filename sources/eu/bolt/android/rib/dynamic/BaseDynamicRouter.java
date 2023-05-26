package eu.bolt.android.rib.dynamic;

import android.view.View;
import android.view.ViewGroup;
import eu.bolt.android.rib.RibLifecycleSubject;
import eu.bolt.android.rib.RibNavigator;
import eu.bolt.android.rib.Router;
import eu.bolt.android.rib.RouterNavigator$RibTransition;
import eu.bolt.android.rib.SerializableRouterNavigatorStateWithName;
import eu.bolt.android.rib.StateInfo;
import eu.bolt.android.rib.dynamic.BaseDynamicRouter;
import eu.bolt.android.rib.dynamic.controller.DynamicStateController;
import eu.bolt.android.rib.dynamic.controller.DynamicStateController1Arg;
import eu.bolt.android.rib.dynamic.controller.DynamicStateControllerNoArgs;
import eu.bolt.android.rib.multistack.BaseMultiStackRouter;
import eu.bolt.android.rib.transition.RibImmediateTransition;
import eu.bolt.logger.StaticLogger;
import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArraysKt__ArraysJVMKt;
import kotlin.collections.ArraysKt__ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseDynamicRouter.kt */
/* loaded from: classes5.dex */
public class BaseDynamicRouter<V extends View> extends BaseMultiStackRouter<V, DynamicState> {
    private final Map<String, DynamicStateController> A;

    public /* synthetic */ BaseDynamicRouter(View view, RibLifecycleSubject ribLifecycleSubject, StateInfo stateInfo, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, ribLifecycleSubject, (i8 & 4) != 0 ? null : stateInfo);
    }

    public static /* synthetic */ DynamicAttachConfig S0(BaseDynamicRouter baseDynamicRouter, String str, boolean z7, boolean z8, int i8, Object obj) {
        if (obj == null) {
            if ((i8 & 1) != 0) {
                str = "default_stack";
            }
            if ((i8 & 2) != 0) {
                z7 = false;
            }
            if ((i8 & 4) != 0) {
                z8 = false;
            }
            return baseDynamicRouter.R0(str, z7, z8);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachConfig");
    }

    public final RibNavigator.TransitionBundle<DynamicState> T0(DynamicState dynamicState) {
        String f02;
        DynamicStateController Y0 = Y0(dynamicState);
        if (Y0 == null) {
            StaticLogger staticLogger = StaticLogger.f41686a;
            String r7 = r();
            f02 = CollectionsKt___CollectionsKt.f0(this.A.keySet(), ", ", null, null, 0, null, null, 62, null);
            staticLogger.i("Dynamic state controller not found for state name " + dynamicState + " in router " + r7 + ".\nPlease make sure that you're using a correctly registered name and check for typos.\nAvailable states are: " + f02);
            return null;
        }
        RouterNavigator$RibTransition<?, DynamicState> e8 = Y0.e(dynamicState.c());
        return new RibNavigator.TransitionBundle<>(e8, e8);
    }

    public static /* synthetic */ DynamicStateController1Arg W0(BaseDynamicRouter baseDynamicRouter, String str, Function2 function2, Function1 function1, DynamicAttachConfig dynamicAttachConfig, ViewGroup viewGroup, boolean z7, boolean z8, int i8, Object obj) {
        Function1<DynamicTransitionFactoryArgs, RouterNavigator$RibTransition<?, DynamicState>> function12;
        DynamicAttachConfig dynamicAttachConfig2;
        ViewGroup viewGroup2;
        boolean z9;
        boolean z10;
        if (obj == null) {
            if ((i8 & 4) != 0) {
                function12 = baseDynamicRouter.b1();
            } else {
                function12 = function1;
            }
            if ((i8 & 8) != 0) {
                dynamicAttachConfig2 = baseDynamicRouter.Z0();
            } else {
                dynamicAttachConfig2 = dynamicAttachConfig;
            }
            if ((i8 & 16) != 0) {
                viewGroup2 = baseDynamicRouter.a1();
            } else {
                viewGroup2 = viewGroup;
            }
            if ((i8 & 32) != 0) {
                z9 = false;
            } else {
                z9 = z7;
            }
            if ((i8 & 64) != 0) {
                z10 = false;
            } else {
                z10 = z8;
            }
            return baseDynamicRouter.U0(str, function2, function12, dynamicAttachConfig2, viewGroup2, z9, z10);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dynamicState");
    }

    public static /* synthetic */ DynamicStateControllerNoArgs X0(BaseDynamicRouter baseDynamicRouter, String str, Function1 function1, Function1 function12, DynamicAttachConfig dynamicAttachConfig, ViewGroup viewGroup, boolean z7, int i8, Object obj) {
        boolean z8;
        if (obj == null) {
            Function1<DynamicTransitionFactoryArgs, RouterNavigator$RibTransition<?, DynamicState>> function13 = function12;
            if ((i8 & 4) != 0) {
                function13 = baseDynamicRouter.b1();
            }
            Function1 function14 = function13;
            if ((i8 & 8) != 0) {
                dynamicAttachConfig = baseDynamicRouter.Z0();
            }
            DynamicAttachConfig dynamicAttachConfig2 = dynamicAttachConfig;
            if ((i8 & 16) != 0) {
                viewGroup = baseDynamicRouter.a1();
            }
            ViewGroup viewGroup2 = viewGroup;
            if ((i8 & 32) != 0) {
                z8 = false;
            } else {
                z8 = z7;
            }
            return baseDynamicRouter.V0(str, function1, function14, dynamicAttachConfig2, viewGroup2, z8);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dynamicState");
    }

    private final Function1<DynamicTransitionFactoryArgs, RouterNavigator$RibTransition<?, DynamicState>> c1(final Function1<? super RibImmediateTransition<DynamicState>, Unit> function1) {
        return new Function1<DynamicTransitionFactoryArgs, RibImmediateTransition<DynamicState>>() { // from class: eu.bolt.android.rib.dynamic.BaseDynamicRouter$immediateTransition$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final RibImmediateTransition<BaseDynamicRouter.DynamicState> invoke(DynamicTransitionFactoryArgs it) {
                Intrinsics.f(it, "it");
                RibImmediateTransition<BaseDynamicRouter.DynamicState> ribImmediateTransition = new RibImmediateTransition<>(it.b(), it.c(), null, null, 12, null);
                function1.invoke(ribImmediateTransition);
                return ribImmediateTransition;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Function1 d1(BaseDynamicRouter baseDynamicRouter, Function1 function1, int i8, Object obj) {
        if (obj == null) {
            if ((i8 & 1) != 0) {
                function1 = new Function1<RibImmediateTransition<DynamicState>, Unit>() { // from class: eu.bolt.android.rib.dynamic.BaseDynamicRouter$immediateTransition$1
                    public final void b(RibImmediateTransition<BaseDynamicRouter.DynamicState> ribImmediateTransition) {
                        Intrinsics.f(ribImmediateTransition, "$this$null");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(RibImmediateTransition<BaseDynamicRouter.DynamicState> ribImmediateTransition) {
                        b(ribImmediateTransition);
                        return Unit.f50853a;
                    }
                };
            }
            return baseDynamicRouter.c1(function1);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: immediateTransition");
    }

    private final void e1(String str, DynamicStateController dynamicStateController, boolean z7) {
        if (!z7 && this.A.containsKey(str)) {
            StaticLogger staticLogger = StaticLogger.f41686a;
            staticLogger.i("A dynamic state with stateName = " + str + " is already registered for this router. Check your state declarations.");
            return;
        }
        this.A.put(str, dynamicStateController);
    }

    @Override // eu.bolt.android.rib.AbstractStackRouter
    public void H(RibNavigator<DynamicState> navigator) {
        Intrinsics.f(navigator, "navigator");
        super.H(navigator);
        navigator.d(new BaseDynamicRouter$initNavigator$1(this));
    }

    public final DynamicAttachConfig R0(String str, boolean z7, boolean z8) {
        return new DynamicAttachConfig(str, z7, z8);
    }

    public final <T extends Serializable> DynamicStateController1Arg<T> U0(String stateName, Function2<? super ViewGroup, ? super T, ? extends Router> routerFactory, Function1<? super DynamicTransitionFactoryArgs, ? extends RouterNavigator$RibTransition<?, DynamicState>> transition, DynamicAttachConfig config, ViewGroup container, boolean z7, boolean z8) {
        Intrinsics.f(stateName, "stateName");
        Intrinsics.f(routerFactory, "routerFactory");
        Intrinsics.f(transition, "transition");
        Intrinsics.f(config, "config");
        Intrinsics.f(container, "container");
        DynamicStateController1Arg<T> dynamicStateController1Arg = new DynamicStateController1Arg<>(routerFactory, this, new DynamicStateInfo(stateName, container, transition, config, z7));
        e1(stateName, dynamicStateController1Arg, z8);
        return dynamicStateController1Arg;
    }

    public final DynamicStateControllerNoArgs V0(String stateName, Function1<? super ViewGroup, ? extends Router> routerFactory, Function1<? super DynamicTransitionFactoryArgs, ? extends RouterNavigator$RibTransition<?, DynamicState>> transition, DynamicAttachConfig config, ViewGroup container, boolean z7) {
        Intrinsics.f(stateName, "stateName");
        Intrinsics.f(routerFactory, "routerFactory");
        Intrinsics.f(transition, "transition");
        Intrinsics.f(config, "config");
        Intrinsics.f(container, "container");
        DynamicStateControllerNoArgs dynamicStateControllerNoArgs = new DynamicStateControllerNoArgs(routerFactory, this, new DynamicStateInfo(stateName, container, transition, config, false));
        e1(stateName, dynamicStateControllerNoArgs, z7);
        return dynamicStateControllerNoArgs;
    }

    protected final DynamicStateController Y0(DynamicState dynamicState) {
        String name;
        if (dynamicState != null && (name = dynamicState.name()) != null) {
            return this.A.get(name);
        }
        return null;
    }

    public DynamicAttachConfig Z0() {
        return S0(this, null, false, false, 7, null);
    }

    public ViewGroup a1() {
        V A = A();
        Intrinsics.d(A, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) A;
    }

    public Function1<DynamicTransitionFactoryArgs, RouterNavigator$RibTransition<?, DynamicState>> b1() {
        return d1(this, null, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseDynamicRouter(V view, RibLifecycleSubject interactor, StateInfo stateInfo) {
        super(view, interactor, stateInfo);
        Intrinsics.f(view, "view");
        Intrinsics.f(interactor, "interactor");
        this.A = new LinkedHashMap();
    }

    /* compiled from: BaseDynamicRouter.kt */
    /* loaded from: classes5.dex */
    public static final class DynamicState extends SerializableRouterNavigatorStateWithName {

        /* renamed from: g */
        private final boolean f37105g;

        /* renamed from: h */
        private final Serializable[] f37106h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DynamicState(String name, boolean z7, Serializable[] args) {
            super(name);
            Intrinsics.f(name, "name");
            Intrinsics.f(args, "args");
            this.f37105g = z7;
            this.f37106h = args;
        }

        @Override // eu.bolt.android.rib.RouterNavigatorState
        public boolean a() {
            return this.f37105g;
        }

        public final Serializable[] c() {
            return this.f37106h;
        }

        public boolean equals(Object obj) {
            DynamicState dynamicState;
            boolean d8;
            if (obj instanceof DynamicState) {
                dynamicState = (DynamicState) obj;
            } else {
                dynamicState = null;
            }
            if (dynamicState == null) {
                return false;
            }
            if (this.f37105g) {
                if (!Intrinsics.a(b(), dynamicState.name())) {
                    return false;
                }
                d8 = ArraysKt__ArraysKt.d(this.f37106h, dynamicState.f37106h);
                if (!d8) {
                    return false;
                }
                return true;
            }
            return Intrinsics.a(b(), dynamicState.name());
        }

        public int hashCode() {
            int b8;
            if (this.f37105g) {
                b8 = ArraysKt__ArraysJVMKt.b(this.f37106h);
                return (b().hashCode() * 31) + b8;
            }
            return b().hashCode();
        }

        public String toString() {
            String b8 = b();
            boolean z7 = this.f37105g;
            String arrays = Arrays.toString(this.f37106h);
            Intrinsics.e(arrays, "toString(this)");
            return "DynamicState(name=" + b8 + ", shouldCompareContent=" + z7 + ", args=" + arrays + ")";
        }

        public /* synthetic */ DynamicState(String str, boolean z7, Serializable[] serializableArr, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, z7, (i8 & 4) != 0 ? new Serializable[0] : serializableArr);
        }
    }
}
