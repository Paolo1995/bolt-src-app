package eu.bolt.android.rib;

import android.view.View;
import com.jakewharton.rxrelay2.PublishRelay;
import eu.bolt.android.rib.RibNavigator;
import eu.bolt.android.rib.SerializableRouterNavigatorState;
import eu.bolt.logger.StaticLogger;
import io.reactivex.Observable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;

/* compiled from: AbstractStackRouter.kt */
/* loaded from: classes5.dex */
public abstract class AbstractStackRouter<V extends View, StateT extends SerializableRouterNavigatorState> extends ViewRouter<V> implements RibNavigator.NavigationDelegate<StateT> {

    /* renamed from: m  reason: collision with root package name */
    private static final Companion f37019m = new Companion(null);

    /* renamed from: k  reason: collision with root package name */
    private final RibNavigator<StateT> f37020k;

    /* renamed from: l  reason: collision with root package name */
    private final PublishRelay<RouterEvent> f37021l;

    /* compiled from: AbstractStackRouter.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AbstractStackRouter.kt */
    /* loaded from: classes5.dex */
    public final class InternalNavState {

        /* renamed from: a  reason: collision with root package name */
        private final List<RouterNavigator$RouterAndState<StateT>> f37022a;

        /* renamed from: b  reason: collision with root package name */
        private final RouterNavigator$RouterAndState<StateT> f37023b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AbstractStackRouter<V, StateT> f37024c;

        /* JADX WARN: Multi-variable type inference failed */
        public InternalNavState(AbstractStackRouter abstractStackRouter, List<? extends RouterNavigator$RouterAndState<StateT>> stack, RouterNavigator$RouterAndState<StateT> routerNavigator$RouterAndState) {
            Intrinsics.f(stack, "stack");
            this.f37024c = abstractStackRouter;
            this.f37022a = stack;
            this.f37023b = routerNavigator$RouterAndState;
        }

        public final RouterNavigator$RouterAndState<StateT> a() {
            return this.f37023b;
        }

        public final List<RouterNavigator$RouterAndState<StateT>> b() {
            return this.f37022a;
        }
    }

    /* compiled from: AbstractStackRouter.kt */
    /* loaded from: classes5.dex */
    public static abstract class RouterEvent {

        /* compiled from: AbstractStackRouter.kt */
        /* loaded from: classes5.dex */
        public static final class AddChild extends RouterEvent {

            /* renamed from: a  reason: collision with root package name */
            private final SerializableRouterNavigatorState f37025a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AddChild(SerializableRouterNavigatorState state) {
                super(null);
                Intrinsics.f(state, "state");
                this.f37025a = state;
            }

            public final SerializableRouterNavigatorState a() {
                return this.f37025a;
            }
        }

        /* compiled from: AbstractStackRouter.kt */
        /* loaded from: classes5.dex */
        public static final class BackStackCleared extends RouterEvent {

            /* renamed from: a  reason: collision with root package name */
            public static final BackStackCleared f37026a = new BackStackCleared();

            private BackStackCleared() {
                super(null);
            }
        }

        /* compiled from: AbstractStackRouter.kt */
        /* loaded from: classes5.dex */
        public static final class CloseAllChildren extends RouterEvent {

            /* renamed from: a  reason: collision with root package name */
            private final boolean f37027a;

            public CloseAllChildren(boolean z7) {
                super(null);
                this.f37027a = z7;
            }
        }

        /* compiled from: AbstractStackRouter.kt */
        /* loaded from: classes5.dex */
        public static final class CloseChild extends RouterEvent {

            /* renamed from: a  reason: collision with root package name */
            private final SerializableRouterNavigatorState f37028a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CloseChild(SerializableRouterNavigatorState state) {
                super(null);
                Intrinsics.f(state, "state");
                this.f37028a = state;
            }

            public final SerializableRouterNavigatorState a() {
                return this.f37028a;
            }
        }

        /* compiled from: AbstractStackRouter.kt */
        /* loaded from: classes5.dex */
        public static final class NestedAddChild extends RouterEvent {

            /* renamed from: a  reason: collision with root package name */
            private final String f37029a;

            /* renamed from: b  reason: collision with root package name */
            private final String f37030b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NestedAddChild(String stateName, String routerTagPath) {
                super(null);
                Intrinsics.f(stateName, "stateName");
                Intrinsics.f(routerTagPath, "routerTagPath");
                this.f37029a = stateName;
                this.f37030b = routerTagPath;
            }

            public final String a() {
                return this.f37030b;
            }

            public final String b() {
                return this.f37029a;
            }
        }

        /* compiled from: AbstractStackRouter.kt */
        /* loaded from: classes5.dex */
        public static final class NestedBackStackCleared extends RouterEvent {

            /* renamed from: a  reason: collision with root package name */
            private final String f37031a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NestedBackStackCleared(String routerTagPath) {
                super(null);
                Intrinsics.f(routerTagPath, "routerTagPath");
                this.f37031a = routerTagPath;
            }

            public final String a() {
                return this.f37031a;
            }
        }

        /* compiled from: AbstractStackRouter.kt */
        /* loaded from: classes5.dex */
        public static final class NestedCloseChild extends RouterEvent {

            /* renamed from: a  reason: collision with root package name */
            private final String f37032a;

            /* renamed from: b  reason: collision with root package name */
            private final String f37033b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NestedCloseChild(String stateName, String routerTagPath) {
                super(null);
                Intrinsics.f(stateName, "stateName");
                Intrinsics.f(routerTagPath, "routerTagPath");
                this.f37032a = stateName;
                this.f37033b = routerTagPath;
            }

            public final String a() {
                return this.f37033b;
            }

            public final String b() {
                return this.f37032a;
            }
        }

        /* compiled from: AbstractStackRouter.kt */
        /* loaded from: classes5.dex */
        public static final class StateRestorationCancelled extends RouterEvent {

            /* renamed from: a  reason: collision with root package name */
            private final String f37034a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StateRestorationCancelled(String routerTagPath) {
                super(null);
                Intrinsics.f(routerTagPath, "routerTagPath");
                this.f37034a = routerTagPath;
            }

            public final String a() {
                return this.f37034a;
            }
        }

        /* compiled from: AbstractStackRouter.kt */
        /* loaded from: classes5.dex */
        public static final class StateRestoredOnReturnFromBackStack extends RouterEvent {

            /* renamed from: a  reason: collision with root package name */
            public static final StateRestoredOnReturnFromBackStack f37035a = new StateRestoredOnReturnFromBackStack();

            private StateRestoredOnReturnFromBackStack() {
                super(null);
            }
        }

        private RouterEvent() {
        }

        public /* synthetic */ RouterEvent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AbstractStackRouter.kt */
    /* loaded from: classes5.dex */
    public static final class StackRouterTags implements Serializable {

        /* renamed from: f  reason: collision with root package name */
        private final ArrayList<String> f37036f;

        /* renamed from: g  reason: collision with root package name */
        private final String f37037g;

        public StackRouterTags(ArrayList<String> stackTags, String str) {
            Intrinsics.f(stackTags, "stackTags");
            this.f37036f = stackTags;
            this.f37037g = str;
        }

        public final String a() {
            return this.f37037g;
        }

        public final ArrayList<String> b() {
            return this.f37036f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StackRouterTags) {
                StackRouterTags stackRouterTags = (StackRouterTags) obj;
                return Intrinsics.a(this.f37036f, stackRouterTags.f37036f) && Intrinsics.a(this.f37037g, stackRouterTags.f37037g);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f37036f.hashCode() * 31;
            String str = this.f37037g;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            ArrayList<String> arrayList = this.f37036f;
            String str = this.f37037g;
            return "StackRouterTags(stackTags=" + arrayList + ", discardOnNextPushStateTag=" + str + ")";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractStackRouter(V view, RibLifecycleSubject interactor, StateInfo stateInfo) {
        super(view, interactor);
        Intrinsics.f(view, "view");
        Intrinsics.f(interactor, "interactor");
        this.f37020k = new RibNavigator<>(this);
        PublishRelay<RouterEvent> e8 = PublishRelay.e();
        Intrinsics.e(e8, "create<RouterEvent>()");
        this.f37021l = e8;
    }

    private final boolean B(List<? extends StateT> list, StateT statet, StackRouterTags stackRouterTags) {
        if (stackRouterTags != null && statet != null && stackRouterTags.a() == null) {
            StaticLogger.f41686a.i("tags provided without discardOnNextPushStateTag");
            return true;
        } else if (stackRouterTags != null && stackRouterTags.b().size() != list.size()) {
            StaticLogger staticLogger = StaticLogger.f41686a;
            int size = stackRouterTags.b().size();
            int size2 = list.size();
            staticLogger.i("tags size (" + size + ") != stack.size for " + size2);
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [eu.bolt.android.rib.Router] */
    private final RouterNavigator$RouterAndState<StateT> D(StateT statet, RibNavigator.TransitionBundle<StateT> transitionBundle) {
        return new RouterNavigator$RouterAndState<>(transitionBundle.a().a(), statet, transitionBundle.a(), transitionBundle.b());
    }

    private final void J(List<? extends StateT> list) {
        String f8;
        StaticLogger staticLogger = StaticLogger.f41686a;
        f8 = StringsKt__IndentKt.f("\n            make sure all the states are registered in initNavigator method, \n            couldn't create transitions for one of states in " + list + ".\n            ");
        staticLogger.i(f8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public final AbstractStackRouter<V, StateT>.InternalNavState C(List<? extends StateT> stack, StateT statet, StackRouterTags stackRouterTags) {
        RibNavigator.TransitionBundle<StateT> transitionBundle;
        RouterNavigator$RouterAndState routerNavigator$RouterAndState;
        int v7;
        String str;
        ArrayList<String> b8;
        String str2;
        List e8;
        Intrinsics.f(stack, "stack");
        RibNavigator<StateT> ribNavigator = this.f37020k;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = stack.iterator();
        while (it.hasNext()) {
            RibNavigator.TransitionBundle a8 = ribNavigator.a((SerializableRouterNavigatorState) it.next());
            if (a8 != null) {
                arrayList.add(a8);
            }
        }
        if (arrayList.size() != stack.size()) {
            J(stack);
            return null;
        }
        if (statet != null) {
            transitionBundle = this.f37020k.a(statet);
        } else {
            transitionBundle = null;
        }
        if (statet != null && transitionBundle == null) {
            e8 = CollectionsKt__CollectionsJVMKt.e(statet);
            J(e8);
            return null;
        } else if (B(stack, statet, stackRouterTags)) {
            return null;
        } else {
            if (statet != null) {
                if (transitionBundle != null) {
                    routerNavigator$RouterAndState = D(statet, transitionBundle);
                    Router c8 = routerNavigator$RouterAndState.c();
                    if (stackRouterTags != null) {
                        str2 = stackRouterTags.a();
                    } else {
                        str2 = null;
                    }
                    c8.w(str2);
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else {
                routerNavigator$RouterAndState = null;
            }
            v7 = CollectionsKt__IterablesKt.v(stack, 10);
            ArrayList arrayList2 = new ArrayList(v7);
            int i8 = 0;
            for (Object obj : stack) {
                int i9 = i8 + 1;
                if (i8 < 0) {
                    CollectionsKt__CollectionsKt.u();
                }
                RouterNavigator$RouterAndState D = D((SerializableRouterNavigatorState) obj, (RibNavigator.TransitionBundle) arrayList.get(i8));
                Router c9 = D.c();
                if (stackRouterTags != null && (b8 = stackRouterTags.b()) != null) {
                    str = b8.get(i8);
                } else {
                    str = null;
                }
                c9.w(str);
                arrayList2.add(D);
                i8 = i9;
            }
            return new InternalNavState(this, arrayList2, routerNavigator$RouterAndState);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final PublishRelay<RouterEvent> E() {
        return this.f37021l;
    }

    public final Observable<RouterEvent> F() {
        Observable<RouterEvent> hide = this.f37021l.hide();
        Intrinsics.e(hide, "events.hide()");
        return hide;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RibNavigator<StateT> G() {
        return this.f37020k;
    }

    public void H(RibNavigator<StateT> navigator) {
        Intrinsics.f(navigator, "navigator");
    }

    public boolean I() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.Router
    public void i(Bundle bundle, String str) {
        H(this.f37020k);
        super.i(bundle, str);
    }
}
