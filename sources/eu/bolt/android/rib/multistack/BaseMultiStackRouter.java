package eu.bolt.android.rib.multistack;

import android.view.View;
import com.jakewharton.rxrelay2.PublishRelay;
import eu.bolt.android.rib.AbstractStackRouter;
import eu.bolt.android.rib.AttachInfo;
import eu.bolt.android.rib.Bundle;
import eu.bolt.android.rib.RibExtensionsKt;
import eu.bolt.android.rib.RibLifecycleSubject;
import eu.bolt.android.rib.RibLogger;
import eu.bolt.android.rib.Router;
import eu.bolt.android.rib.RouterNavigator$AttachParams;
import eu.bolt.android.rib.RouterNavigator$AttachTransition;
import eu.bolt.android.rib.RouterNavigator$DetachCallback;
import eu.bolt.android.rib.RouterNavigator$DetachParams;
import eu.bolt.android.rib.RouterNavigator$DetachTransition;
import eu.bolt.android.rib.RouterNavigator$RouterAndState;
import eu.bolt.android.rib.RouterNavigatorState;
import eu.bolt.android.rib.SerializableRouterNavigatorState;
import eu.bolt.android.rib.StateInfo;
import eu.bolt.android.rib.ViewRouter;
import eu.bolt.android.rib.multistack.MultiStackRouterChildEventDelegate;
import eu.bolt.android.rib.multistack.StackUpdateEvent;
import eu.bolt.logger.Logger;
import eu.bolt.logger.LoggersConfig;
import eu.bolt.logger.exception.DiagnosisException;
import eu.bolt.logger.ext.LoggingExtensionKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__IndentKt;

/* compiled from: BaseMultiStackRouter.kt */
/* loaded from: classes5.dex */
public class BaseMultiStackRouter<V extends View, StateT extends SerializableRouterNavigatorState> extends AbstractStackRouter<V, StateT> {

    /* renamed from: n */
    private final HashMap<String, BaseMultiStackRouter<V, StateT>.NavigationStack> f37166n;

    /* renamed from: o */
    private final ArrayList<RouterNavigator$RouterAndState<StateT>> f37167o;

    /* renamed from: p */
    private final Bundle f37168p;

    /* renamed from: q */
    private final MultiStackRouterEventsRepository f37169q;

    /* renamed from: r */
    private final MultiStackRouterFocusDelegate f37170r;

    /* renamed from: s */
    private final MultiStackRouterChildEventDelegate.Factory f37171s;

    /* renamed from: t */
    private final HashMap<String, Disposable> f37172t;

    /* renamed from: u */
    private final Logger f37173u;

    /* renamed from: v */
    private boolean f37174v;

    /* renamed from: w */
    private boolean f37175w;

    /* renamed from: x */
    private boolean f37176x;

    /* renamed from: y */
    private InTransactionDebugParams f37177y;

    /* renamed from: z */
    private BaseMultiStackRouter<V, StateT>.BackStackSavedState f37178z;

    /* compiled from: BaseMultiStackRouter.kt */
    /* loaded from: classes5.dex */
    public final class BackStackSavedState {

        /* renamed from: a */
        private final Map<String, BaseMultiStackRouter<V, StateT>.NavigationStack> f37179a;

        /* renamed from: b */
        private final List<RouterNavigator$RouterAndState<StateT>> f37180b;

        /* renamed from: c */
        private final List<StackUpdateEvent> f37181c;

        /* renamed from: d */
        private final Bundle f37182d;

        /* renamed from: e */
        final /* synthetic */ BaseMultiStackRouter<V, StateT> f37183e;

        /* JADX WARN: Multi-variable type inference failed */
        public BackStackSavedState(BaseMultiStackRouter baseMultiStackRouter, Map<String, BaseMultiStackRouter<V, StateT>.NavigationStack> navStackMap, List<? extends RouterNavigator$RouterAndState<StateT>> noBackStackRibs, List<? extends StackUpdateEvent> stackEvents, Bundle backStackRibStates) {
            Intrinsics.f(navStackMap, "navStackMap");
            Intrinsics.f(noBackStackRibs, "noBackStackRibs");
            Intrinsics.f(stackEvents, "stackEvents");
            Intrinsics.f(backStackRibStates, "backStackRibStates");
            this.f37183e = baseMultiStackRouter;
            this.f37179a = navStackMap;
            this.f37180b = noBackStackRibs;
            this.f37181c = stackEvents;
            this.f37182d = backStackRibStates;
        }

        public final Bundle a() {
            return this.f37182d;
        }

        public final Map<String, BaseMultiStackRouter<V, StateT>.NavigationStack> b() {
            return this.f37179a;
        }

        public final List<RouterNavigator$RouterAndState<StateT>> c() {
            return this.f37180b;
        }

        public final List<StackUpdateEvent> d() {
            return this.f37181c;
        }

        public String toString() {
            int hashCode = hashCode();
            Map<String, BaseMultiStackRouter<V, StateT>.NavigationStack> map = this.f37179a;
            List<RouterNavigator$RouterAndState<StateT>> list = this.f37180b;
            List<StackUpdateEvent> list2 = this.f37181c;
            Bundle bundle = this.f37182d;
            return "BackStackSavedState:" + hashCode + "\tnavStackMap=" + map + "\tnoBackStackRibs=" + list + "\tstackEvents=" + list2 + "\tbackStackRibStates=" + bundle;
        }
    }

    /* compiled from: BaseMultiStackRouter.kt */
    /* loaded from: classes5.dex */
    public static final class InTransactionDebugParams {

        /* renamed from: a */
        private final String f37184a;

        /* renamed from: b */
        private final String f37185b;

        /* renamed from: c */
        private final String f37186c;

        public InTransactionDebugParams(String str, String str2, String action) {
            Intrinsics.f(action, "action");
            this.f37184a = str;
            this.f37185b = str2;
            this.f37186c = action;
        }

        public final String a() {
            return this.f37186c;
        }

        public final String b() {
            return this.f37184a;
        }

        public final String c() {
            return this.f37185b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof InTransactionDebugParams) {
                InTransactionDebugParams inTransactionDebugParams = (InTransactionDebugParams) obj;
                return Intrinsics.a(this.f37184a, inTransactionDebugParams.f37184a) && Intrinsics.a(this.f37185b, inTransactionDebugParams.f37185b) && Intrinsics.a(this.f37186c, inTransactionDebugParams.f37186c);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f37184a;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.f37185b;
            return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f37186c.hashCode();
        }

        public String toString() {
            String str = this.f37184a;
            String str2 = this.f37185b;
            String str3 = this.f37186c;
            return "InTransactionDebugParams(fromState=" + str + ", toState=" + str2 + ", action=" + str3 + ")";
        }
    }

    /* compiled from: BaseMultiStackRouter.kt */
    /* loaded from: classes5.dex */
    public final class NavigationStack {

        /* renamed from: a */
        private int f37187a;

        /* renamed from: b */
        private final ArrayDeque<RouterNavigator$RouterAndState<StateT>> f37188b = new ArrayDeque<>();

        /* renamed from: c */
        private RouterNavigator$RouterAndState<StateT> f37189c;

        public NavigationStack() {
            BaseMultiStackRouter.this = r1;
        }

        public final BaseMultiStackRouter<V, StateT>.NavigationStack a() {
            BaseMultiStackRouter<V, StateT>.NavigationStack navigationStack = new NavigationStack();
            navigationStack.f37187a = this.f37187a;
            navigationStack.f37189c = this.f37189c;
            navigationStack.f37188b.addAll(this.f37188b);
            return navigationStack;
        }

        public final boolean b(String stateName) {
            String str;
            boolean z7;
            StateT d8;
            Intrinsics.f(stateName, "stateName");
            RouterNavigator$RouterAndState<StateT> routerNavigator$RouterAndState = this.f37189c;
            if (routerNavigator$RouterAndState != null && (d8 = routerNavigator$RouterAndState.d()) != null) {
                str = d8.name();
            } else {
                str = null;
            }
            if (Intrinsics.a(str, stateName)) {
                return true;
            }
            ArrayDeque<RouterNavigator$RouterAndState<StateT>> arrayDeque = this.f37188b;
            if (!(arrayDeque instanceof Collection) || !arrayDeque.isEmpty()) {
                Iterator<T> it = arrayDeque.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.a(((SerializableRouterNavigatorState) ((RouterNavigator$RouterAndState) it.next()).d()).name(), stateName)) {
                        z7 = true;
                        break;
                    }
                }
            }
            z7 = false;
            if (z7) {
                return true;
            }
            return false;
        }

        public final RouterNavigator$RouterAndState<StateT> c() {
            return this.f37189c;
        }

        public final int d() {
            return this.f37187a;
        }

        public final Sequence<RouterNavigator$RouterAndState<StateT>> e() {
            Sequence j8;
            Sequence O;
            Sequence y7;
            Sequence<RouterNavigator$RouterAndState<StateT>> p8;
            j8 = SequencesKt__SequencesKt.j(this.f37189c);
            O = CollectionsKt___CollectionsKt.O(this.f37188b);
            y7 = SequencesKt___SequencesKt.y(j8, O);
            p8 = SequencesKt___SequencesKt.p(y7);
            return p8;
        }

        public final ArrayDeque<RouterNavigator$RouterAndState<StateT>> f() {
            return this.f37188b;
        }

        public final RouterNavigator$RouterAndState<StateT> g() {
            RouterNavigator$RouterAndState<StateT> routerNavigator$RouterAndState = this.f37189c;
            if (routerNavigator$RouterAndState == null) {
                if (!this.f37188b.isEmpty()) {
                    return this.f37188b.getFirst();
                }
                return null;
            }
            return routerNavigator$RouterAndState;
        }

        public final RouterNavigator$RouterAndState<StateT> h() {
            RouterNavigator$RouterAndState<StateT> routerNavigator$RouterAndState = this.f37189c;
            if (routerNavigator$RouterAndState != null) {
                this.f37189c = null;
                return routerNavigator$RouterAndState;
            } else if (!(!this.f37188b.isEmpty())) {
                return null;
            } else {
                return this.f37188b.pop();
            }
        }

        public final void i(RouterNavigator$RouterAndState<StateT> state, boolean z7) {
            Intrinsics.f(state, "state");
            if (z7) {
                this.f37189c = state;
                return;
            }
            this.f37189c = null;
            this.f37188b.push(state);
        }

        public final void j(List<? extends RouterNavigator$RouterAndState<StateT>> states) {
            Intrinsics.f(states, "states");
            this.f37188b.clear();
            this.f37188b.addAll(states);
        }

        public final int k() {
            int i8;
            int size = this.f37188b.size();
            if (this.f37189c != null) {
                i8 = 1;
            } else {
                i8 = 0;
            }
            return size + i8;
        }

        public String toString() {
            String f02;
            String str;
            StateT d8;
            f02 = CollectionsKt___CollectionsKt.f0(this.f37188b, null, null, null, 0, null, new Function1<RouterNavigator$RouterAndState<StateT>, CharSequence>() { // from class: eu.bolt.android.rib.multistack.BaseMultiStackRouter$NavigationStack$toString$stack$1
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final CharSequence invoke(RouterNavigator$RouterAndState<StateT> routerNavigator$RouterAndState) {
                    return ((SerializableRouterNavigatorState) routerNavigator$RouterAndState.d()).name();
                }
            }, 31, null);
            RouterNavigator$RouterAndState<StateT> routerNavigator$RouterAndState = this.f37189c;
            if (routerNavigator$RouterAndState != null && (d8 = routerNavigator$RouterAndState.d()) != null) {
                str = d8.name();
            } else {
                str = null;
            }
            return "NavStack[[" + f02 + "], discardOnPush=" + str + "]";
        }
    }

    /* compiled from: BaseMultiStackRouter.kt */
    /* loaded from: classes5.dex */
    public static final class SerializableNavStack<StateT extends SerializableRouterNavigatorState> implements Serializable {

        /* renamed from: f */
        private final List<StateT> f37192f;

        /* renamed from: g */
        private final StateT f37193g;

        /* renamed from: h */
        private final AbstractStackRouter.StackRouterTags f37194h;

        /* JADX WARN: Multi-variable type inference failed */
        public SerializableNavStack(List<? extends StateT> navigationStack, StateT statet, AbstractStackRouter.StackRouterTags tags) {
            Intrinsics.f(navigationStack, "navigationStack");
            Intrinsics.f(tags, "tags");
            this.f37192f = navigationStack;
            this.f37193g = statet;
            this.f37194h = tags;
        }

        public final StateT a() {
            return this.f37193g;
        }

        public final List<StateT> b() {
            return this.f37192f;
        }

        public final AbstractStackRouter.StackRouterTags c() {
            return this.f37194h;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SerializableNavStack) {
                SerializableNavStack serializableNavStack = (SerializableNavStack) obj;
                return Intrinsics.a(this.f37192f, serializableNavStack.f37192f) && Intrinsics.a(this.f37193g, serializableNavStack.f37193g) && Intrinsics.a(this.f37194h, serializableNavStack.f37194h);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f37192f.hashCode() * 31;
            StateT statet = this.f37193g;
            return ((hashCode + (statet == null ? 0 : statet.hashCode())) * 31) + this.f37194h.hashCode();
        }

        public String toString() {
            List<StateT> list = this.f37192f;
            StateT statet = this.f37193g;
            AbstractStackRouter.StackRouterTags stackRouterTags = this.f37194h;
            return "SerializableNavStack(navigationStack=" + list + ", discardOnNextPushState=" + statet + ", tags=" + stackRouterTags + ")";
        }
    }

    /* compiled from: BaseMultiStackRouter.kt */
    /* loaded from: classes5.dex */
    public static final class SerializableNavigationState<StateT extends SerializableRouterNavigatorState> implements Serializable {

        /* renamed from: f */
        private final HashMap<String, SerializableNavStack<StateT>> f37195f;

        /* renamed from: g */
        private final ArrayList<StateWithTag<StateT>> f37196g;

        /* renamed from: h */
        private final ArrayList<StackUpdateEvent> f37197h;

        public SerializableNavigationState(HashMap<String, SerializableNavStack<StateT>> navigationMap, ArrayList<StateWithTag<StateT>> noBackStackRib, ArrayList<StackUpdateEvent> stackEvents) {
            Intrinsics.f(navigationMap, "navigationMap");
            Intrinsics.f(noBackStackRib, "noBackStackRib");
            Intrinsics.f(stackEvents, "stackEvents");
            this.f37195f = navigationMap;
            this.f37196g = noBackStackRib;
            this.f37197h = stackEvents;
        }

        public final HashMap<String, SerializableNavStack<StateT>> a() {
            return this.f37195f;
        }

        public final ArrayList<StateWithTag<StateT>> b() {
            return this.f37196g;
        }

        public final ArrayList<StackUpdateEvent> c() {
            return this.f37197h;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SerializableNavigationState) {
                SerializableNavigationState serializableNavigationState = (SerializableNavigationState) obj;
                return Intrinsics.a(this.f37195f, serializableNavigationState.f37195f) && Intrinsics.a(this.f37196g, serializableNavigationState.f37196g) && Intrinsics.a(this.f37197h, serializableNavigationState.f37197h);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f37195f.hashCode() * 31) + this.f37196g.hashCode()) * 31) + this.f37197h.hashCode();
        }

        public String toString() {
            HashMap<String, SerializableNavStack<StateT>> hashMap = this.f37195f;
            ArrayList<StateWithTag<StateT>> arrayList = this.f37196g;
            ArrayList<StackUpdateEvent> arrayList2 = this.f37197h;
            return "SerializableNavigationState(navigationMap=" + hashMap + ", noBackStackRib=" + arrayList + ", stackEvents=" + arrayList2 + ")";
        }
    }

    /* compiled from: BaseMultiStackRouter.kt */
    /* loaded from: classes5.dex */
    public static final class StateWithTag<StateT extends SerializableRouterNavigatorState> implements Serializable {

        /* renamed from: f */
        private final StateT f37198f;

        /* renamed from: g */
        private final String f37199g;

        public StateWithTag(StateT state, String tag) {
            Intrinsics.f(state, "state");
            Intrinsics.f(tag, "tag");
            this.f37198f = state;
            this.f37199g = tag;
        }

        public final StateT a() {
            return this.f37198f;
        }

        public final String b() {
            return this.f37199g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StateWithTag) {
                StateWithTag stateWithTag = (StateWithTag) obj;
                return Intrinsics.a(this.f37198f, stateWithTag.f37198f) && Intrinsics.a(this.f37199g, stateWithTag.f37199g);
            }
            return false;
        }

        public int hashCode() {
            return (this.f37198f.hashCode() * 31) + this.f37199g.hashCode();
        }

        public String toString() {
            StateT statet = this.f37198f;
            String str = this.f37199g;
            return "StateWithTag(state=" + statet + ", tag=" + str + ")";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMultiStackRouter(V view, RibLifecycleSubject interactor, StateInfo stateInfo) {
        super(view, interactor, stateInfo);
        Intrinsics.f(view, "view");
        Intrinsics.f(interactor, "interactor");
        this.f37166n = new HashMap<>();
        this.f37167o = new ArrayList<>();
        this.f37168p = Bundle.a();
        MultiStackRouterEventsRepository multiStackRouterEventsRepository = new MultiStackRouterEventsRepository();
        this.f37169q = multiStackRouterEventsRepository;
        MultiStackRouterFocusDelegate multiStackRouterFocusDelegate = new MultiStackRouterFocusDelegate(this, multiStackRouterEventsRepository);
        this.f37170r = multiStackRouterFocusDelegate;
        this.f37171s = new MultiStackRouterChildEventDelegate.Factory(multiStackRouterEventsRepository, multiStackRouterFocusDelegate, E());
        this.f37172t = new HashMap<>();
        this.f37173u = LoggersConfig.f41683a.a().a("RibRouter");
        this.f37175w = true;
    }

    private final void A0(BaseMultiStackRouter<V, StateT>.BackStackSavedState backStackSavedState) {
        this.f37174v = true;
        this.f37169q.u(true);
        for (RouterNavigator$RouterAndState routerNavigator$RouterAndState : backStackSavedState.c()) {
            routerNavigator$RouterAndState.a().c(routerNavigator$RouterAndState.c(), new RouterNavigator$AttachParams(null, routerNavigator$RouterAndState.d(), false, true, false, null));
            Router c8 = routerNavigator$RouterAndState.c();
            Intrinsics.e(c8, "it.router");
            c(c8, routerNavigator$RouterAndState.c().r());
        }
        for (Map.Entry<String, BaseMultiStackRouter<V, StateT>.NavigationStack> entry : backStackSavedState.b().entrySet()) {
            RouterNavigator$RouterAndState<StateT> g8 = entry.getValue().g();
            if (g8 != 0) {
                Router activeRouter = g8.c();
                g8.a().c(activeRouter, new RouterNavigator$AttachParams(null, g8.d(), false, true, false, null));
                if (activeRouter instanceof AbstractStackRouter) {
                    m0(activeRouter.r(), entry.getKey(), ((AbstractStackRouter) activeRouter).F());
                }
                Intrinsics.e(activeRouter, "activeRouter");
                c(activeRouter, activeRouter.r());
            }
        }
        this.f37166n.clear();
        this.f37166n.putAll(backStackSavedState.b());
        this.f37167o.addAll(backStackSavedState.c());
        this.f37169q.t(backStackSavedState.d());
        this.f37169q.u(false);
        this.f37168p.j(backStackSavedState.a());
        E().accept(AbstractStackRouter.RouterEvent.StateRestoredOnReturnFromBackStack.f37035a);
        this.f37174v = false;
    }

    private final void B0(Bundle bundle) {
        Bundle c8 = bundle.c(Router.m());
        for (Map.Entry<String, BaseMultiStackRouter<V, StateT>.NavigationStack> entry : this.f37166n.entrySet()) {
            Iterator it = entry.getValue().f().iterator();
            while (it.hasNext()) {
                RouterNavigator$RouterAndState routerNavigator$RouterAndState = (RouterNavigator$RouterAndState) it.next();
                if (!q().contains(routerNavigator$RouterAndState.c())) {
                    Router c9 = routerNavigator$RouterAndState.c();
                    Intrinsics.e(c9, "router.router");
                    String l02 = l0(c9);
                    Bundle c10 = this.f37168p.c(l02);
                    if (c8 != null) {
                        c8.g(l02, c10);
                    }
                }
            }
        }
    }

    private final void C0(Bundle bundle) {
        int b8;
        StateT statet;
        HashMap<String, BaseMultiStackRouter<V, StateT>.NavigationStack> hashMap = this.f37166n;
        b8 = MapsKt__MapsJVMKt.b(hashMap.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(b8);
        Iterator<T> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            ArrayDeque<RouterNavigator$RouterAndState<StateT>> f8 = ((NavigationStack) entry.getValue()).f();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it2 = f8.iterator();
            while (it2.hasNext()) {
                arrayList.add((SerializableRouterNavigatorState) ((RouterNavigator$RouterAndState) it2.next()).d());
            }
            RouterNavigator$RouterAndState<StateT> c8 = ((NavigationStack) entry.getValue()).c();
            if (c8 != null) {
                statet = c8.d();
            } else {
                statet = null;
            }
            linkedHashMap.put(key, new SerializableNavStack(arrayList, statet, a0((NavigationStack) entry.getValue())));
        }
        HashMap hashMap2 = new HashMap(linkedHashMap);
        ArrayList<RouterNavigator$RouterAndState<StateT>> arrayList2 = this.f37167o;
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            RouterNavigator$RouterAndState routerNavigator$RouterAndState = (RouterNavigator$RouterAndState) it3.next();
            arrayList3.add(new StateWithTag((SerializableRouterNavigatorState) routerNavigator$RouterAndState.d(), routerNavigator$RouterAndState.c().r()));
        }
        SerializableNavigationState serializableNavigationState = new SerializableNavigationState(hashMap2, arrayList3, new ArrayList(this.f37169q.c()));
        bundle.h(j0(), serializableNavigationState);
        Logger logger = this.f37173u;
        String c9 = LoggingExtensionKt.c(this);
        logger.b("[" + c9 + "] saved state " + serializableNavigationState);
    }

    private final void D0(String str, AbstractStackRouter<V, StateT>.InternalNavState internalNavState, boolean z7) {
        Object W;
        List<? extends RouterNavigator$RouterAndState<StateT>> R;
        List R2;
        BaseMultiStackRouter<V, StateT>.NavigationStack h02 = h0(str);
        W = CollectionsKt___CollectionsKt.W(internalNavState.b());
        RouterNavigator$RouterAndState routerNavigator$RouterAndState = (RouterNavigator$RouterAndState) W;
        R = CollectionsKt___CollectionsKt.R(internalNavState.b(), 1);
        K(str, R);
        v0(this, str, routerNavigator$RouterAndState, z7, false, null, 16, null);
        AbstractCollection f8 = h02.f();
        R2 = CollectionsKt___CollectionsKt.R(internalNavState.b(), 1);
        f8.addAll(R2);
    }

    private final void E0(String str, AbstractStackRouter<V, StateT>.InternalNavState internalNavState, boolean z7) {
        BaseMultiStackRouter<V, StateT>.NavigationStack h02 = h0(str);
        y0(str, h02);
        K(str, internalNavState.b());
        w0(h02);
        h02.j(internalNavState.b());
        t0(z7, str);
    }

    private final void F0(String str, AbstractStackRouter<V, StateT>.InternalNavState internalNavState, RouterNavigator$RouterAndState<StateT> routerNavigator$RouterAndState, boolean z7) {
        BaseMultiStackRouter<V, StateT>.NavigationStack h02 = h0(str);
        y0(str, h02);
        K(str, internalNavState.b());
        v0(this, str, routerNavigator$RouterAndState, z7, true, null, 16, null);
        w0(h02);
        h02.j(internalNavState.b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void G0(String str, AbstractStackRouter<V, StateT>.InternalNavState internalNavState, boolean z7) {
        SerializableRouterNavigatorState serializableRouterNavigatorState;
        NavigationStack h02 = h0(str);
        V(str);
        RouterNavigator$RouterAndState routerNavigator$RouterAndState = (RouterNavigator$RouterAndState) CollectionsKt___CollectionsKt.Y(internalNavState.b());
        if (routerNavigator$RouterAndState != null) {
            serializableRouterNavigatorState = (SerializableRouterNavigatorState) routerNavigator$RouterAndState.d();
        } else {
            serializableRouterNavigatorState = null;
        }
        boolean n02 = n0(serializableRouterNavigatorState, str);
        Collection<? extends RouterNavigator$RouterAndState<StateT>> b8 = internalNavState.b();
        if (n02) {
            b8 = CollectionsKt___CollectionsKt.R(b8, 1);
        }
        h02.f().addAll(b8);
        K(str, b8);
        if (n02) {
            RouterNavigator$RouterAndState<StateT> g8 = h02.g();
            if (g8 != null) {
                this.f37169q.g(str, g8.c().r());
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        t0(z7, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean I0(BaseMultiStackRouter baseMultiStackRouter, List list, SerializableRouterNavigatorState serializableRouterNavigatorState, boolean z7, String str, int i8, Object obj) {
        if (obj == null) {
            if ((i8 & 1) != 0) {
                list = CollectionsKt__CollectionsKt.k();
            }
            if ((i8 & 2) != 0) {
                serializableRouterNavigatorState = null;
            }
            if ((i8 & 4) != 0) {
                z7 = false;
            }
            if ((i8 & 8) != 0) {
                str = "default_stack";
            }
            return baseMultiStackRouter.H0(list, serializableRouterNavigatorState, z7, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setNavigationStackState");
    }

    private final boolean J0(List<? extends StateT> list, StateT statet, boolean z7, String str, AbstractStackRouter.StackRouterTags stackRouterTags) {
        AbstractStackRouter<V, StateT>.InternalNavState C = C(list, statet, stackRouterTags);
        if (C == null) {
            return false;
        }
        String j8 = this.f37170r.j();
        BaseMultiStackRouter<V, StateT>.NavigationStack h02 = h0(str);
        if (C.a() != null) {
            F0(str, C, C.a(), z7);
        } else if (h02.c() != null) {
            E0(str, C, z7);
        } else if (!h02.f().isEmpty()) {
            G0(str, C, z7);
        } else if (!C.b().isEmpty()) {
            D0(str, C, z7);
        }
        this.f37170r.f(str, j8);
        return true;
    }

    private final void K(String str, List<? extends RouterNavigator$RouterAndState<StateT>> list) {
        List<RouterNavigator$RouterAndState> r02;
        r02 = CollectionsKt___CollectionsKt.r0(list);
        for (RouterNavigator$RouterAndState routerNavigator$RouterAndState : r02) {
            Router c8 = routerNavigator$RouterAndState.c();
            Intrinsics.e(c8, "routerAndState.router");
            String l02 = l0(c8);
            routerNavigator$RouterAndState.c().w(l02);
            PublishRelay<AbstractStackRouter.RouterEvent> E = E();
            RouterNavigatorState d8 = routerNavigator$RouterAndState.d();
            Intrinsics.e(d8, "routerAndState.state");
            E.accept(new AbstractStackRouter.RouterEvent.AddChild((SerializableRouterNavigatorState) d8));
            this.f37169q.n(str, l02);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ boolean K0(BaseMultiStackRouter baseMultiStackRouter, List list, SerializableRouterNavigatorState serializableRouterNavigatorState, boolean z7, String str, AbstractStackRouter.StackRouterTags stackRouterTags, int i8, Object obj) {
        StateT statet;
        boolean z8;
        List k8;
        if (obj == null) {
            List list2 = list;
            if ((i8 & 1) != 0) {
                k8 = CollectionsKt__CollectionsKt.k();
                list2 = k8;
            }
            AbstractStackRouter.StackRouterTags stackRouterTags2 = null;
            if ((i8 & 2) != 0) {
                statet = null;
            } else {
                statet = serializableRouterNavigatorState;
            }
            if ((i8 & 4) != 0) {
                z8 = false;
            } else {
                z8 = z7;
            }
            if ((i8 & 8) != 0) {
                str = "default_stack";
            }
            String str2 = str;
            if ((i8 & 16) == 0) {
                stackRouterTags2 = stackRouterTags;
            }
            return baseMultiStackRouter.J0(list2, statet, z8, str2, stackRouterTags2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setNavigationStackStateInternal");
    }

    private final boolean L() {
        int d8;
        Collection<BaseMultiStackRouter<V, StateT>.NavigationStack> values = this.f37166n.values();
        Intrinsics.e(values, "navStackMap.values");
        Iterator<T> it = values.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            NavigationStack navigationStack = (NavigationStack) it.next();
            d8 = RangesKt___RangesKt.d(navigationStack.k() - navigationStack.d(), 0);
            i8 += d8;
        }
        if (i8 != 0) {
            return false;
        }
        return true;
    }

    private final boolean M(StateT statet, StateT statet2) {
        if (statet == null && statet2 == null) {
            return true;
        }
        if (statet == null || statet2 == null || statet.a() != statet2.a()) {
            return false;
        }
        if (statet.a()) {
            return Intrinsics.a(statet, statet2);
        }
        return Intrinsics.a(statet.name(), statet2.name());
    }

    private final void M0() {
        String f8;
        String c8;
        if (this.f37176x) {
            Logger logger = this.f37173u;
            DiagnosisException diagnosisException = new DiagnosisException("RibRouterMisuse", false, null, 6, null);
            InTransactionDebugParams inTransactionDebugParams = this.f37177y;
            String str = (inTransactionDebugParams == null || (str = inTransactionDebugParams.a()) == null) ? "attach/detach" : "attach/detach";
            InTransactionDebugParams inTransactionDebugParams2 = this.f37177y;
            String str2 = "Unknown";
            String str3 = (inTransactionDebugParams2 == null || (str3 = inTransactionDebugParams2.b()) == null) ? "Unknown" : "Unknown";
            InTransactionDebugParams inTransactionDebugParams3 = this.f37177y;
            if (inTransactionDebugParams3 != null && (c8 = inTransactionDebugParams3.c()) != null) {
                str2 = c8;
            }
            f8 = StringsKt__IndentKt.f("\n                Router is performing " + str + " of a child and can't be used,\n                as it's in a transitionary state.\n                This method can't provide a reliable information now and should be called later, as an option try moving\n                this operation to view.post { } or set state of the router immediately using setNavigationStackState\n                instead of, for example, invoking clearBackStack when some RIB is attached. \n                From state: " + str3 + " to state " + str2 + "\n                ");
            logger.g(diagnosisException, f8);
        }
    }

    private final void N0() {
        String f8;
        Logger logger = this.f37173u;
        MultiStackRouterEventsRepository multiStackRouterEventsRepository = this.f37169q;
        HashMap<String, Disposable> hashMap = this.f37172t;
        f8 = StringsKt__IndentKt.f("\n            state not cleared correctly " + multiStackRouterEventsRepository + ", " + hashMap + ". This is most probably \n            caused by stackEventRepository mismanagement. Try to check whether it contains events only for RIBs \n            that were actually restored when re-attaching a RIB from backstack or restoring state from bundle.\n            ");
        logger.i(f8);
    }

    public static /* synthetic */ boolean O(BaseMultiStackRouter baseMultiStackRouter, SerializableRouterNavigatorState serializableRouterNavigatorState, boolean z7, String str, int i8, Object obj) {
        if (obj == null) {
            if ((i8 & 2) != 0) {
                z7 = false;
            }
            if ((i8 & 4) != 0) {
                str = null;
            }
            return baseMultiStackRouter.N(serializableRouterNavigatorState, z7, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachNoBackStackRibForState");
    }

    private final void O0() {
        this.f37173u.i("there was a PushToStack event in stackEventRepository, but there were no children. This is most probably \ncaused by stackEventRepository mismanagement. Try to check whether it contains events only for RIBs \nthat were actually restored when re-attaching a RIB from backstack or restoring state from bundle.");
    }

    private final boolean P0(BaseMultiStackRouter<V, StateT>.BackStackSavedState backStackSavedState, Bundle bundle) {
        RibLogger ribLogger = RibLogger.f37068a;
        StringBuilder sb = new StringBuilder();
        sb.append("tryRestore !shouldRestoreRouterState() = ");
        sb.append(!L0());
        ribLogger.a(sb.toString());
        if (!L0()) {
            if (backStackSavedState != null || bundle != null) {
                E().accept(new AbstractStackRouter.RouterEvent.StateRestorationCancelled(""));
            }
            return false;
        } else if (backStackSavedState != null) {
            A0(backStackSavedState);
            return true;
        } else if (bundle == null) {
            return false;
        } else {
            z0(bundle);
            return true;
        }
    }

    private final boolean Q(AttachInfo<StateT> attachInfo, String str, String str2) {
        Boolean c8 = G().c(attachInfo, str, str2);
        if (c8 != null) {
            return c8.booleanValue();
        }
        return false;
    }

    static /* synthetic */ boolean R(BaseMultiStackRouter baseMultiStackRouter, AttachInfo attachInfo, String str, String str2, int i8, Object obj) {
        if (obj == null) {
            if ((i8 & 4) != 0) {
                str2 = null;
            }
            return baseMultiStackRouter.Q(attachInfo, str, str2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachRibInternal");
    }

    private final void S(RouterNavigator$RouterAndState<StateT> routerNavigator$RouterAndState, boolean z7, String str) {
        this.f37167o.add(routerNavigator$RouterAndState);
        U(this, null, routerNavigator$RouterAndState, true, z7, true, null, str, 32, null);
    }

    private final void T(RouterNavigator$RouterAndState<StateT> routerNavigator$RouterAndState, RouterNavigator$RouterAndState<StateT> routerNavigator$RouterAndState2, boolean z7, boolean z8, boolean z9, String str, String str2) {
        String str3;
        String str4;
        Router router;
        ViewRouter viewRouter;
        Class<?> cls;
        String str5;
        View A;
        StateT d8;
        if (routerNavigator$RouterAndState != null && (d8 = routerNavigator$RouterAndState.d()) != null) {
            str3 = d8.name();
        } else {
            str3 = null;
        }
        StateT d9 = routerNavigator$RouterAndState2.d();
        if (d9 != null) {
            str4 = d9.name();
        } else {
            str4 = null;
        }
        M0();
        this.f37177y = new InTransactionDebugParams(str3, str4, "attach");
        this.f37176x = true;
        if (routerNavigator$RouterAndState != null) {
            router = routerNavigator$RouterAndState.c();
        } else {
            router = null;
        }
        if (router instanceof ViewRouter) {
            viewRouter = (ViewRouter) router;
        } else {
            viewRouter = null;
        }
        if (viewRouter != null && (A = viewRouter.A()) != null) {
            cls = A.getClass();
        } else {
            cls = null;
        }
        routerNavigator$RouterAndState2.a().c(routerNavigator$RouterAndState2.c(), new RouterNavigator$AttachParams(routerNavigator$RouterAndState, routerNavigator$RouterAndState2.d(), z9, z7, z8, cls));
        Router router2 = routerNavigator$RouterAndState2.c();
        if (str2 == null) {
            Intrinsics.e(router2, "router");
            str5 = l0(router2);
        } else {
            str5 = str2;
        }
        if (str != null) {
            if (z9) {
                this.f37169q.n(str, str5);
            }
            if (router2 instanceof AbstractStackRouter) {
                m0(str5, str, ((AbstractStackRouter) router2).F());
            }
        }
        Router c8 = routerNavigator$RouterAndState2.c();
        Intrinsics.e(c8, "toRouterState.router");
        c(c8, str5);
        if (str == null || z9) {
            PublishRelay<AbstractStackRouter.RouterEvent> E = E();
            StateT d10 = routerNavigator$RouterAndState2.d();
            Intrinsics.e(d10, "toRouterState.state");
            E.accept(new AbstractStackRouter.RouterEvent.AddChild(d10));
        }
        this.f37173u.b("[" + LoggingExtensionKt.c(this) + "] attached " + routerNavigator$RouterAndState2.d().name() + " with stackKey=" + str);
        Unit unit = Unit.f50853a;
        this.f37176x = false;
        this.f37177y = null;
    }

    static /* synthetic */ void U(BaseMultiStackRouter baseMultiStackRouter, RouterNavigator$RouterAndState routerNavigator$RouterAndState, RouterNavigator$RouterAndState routerNavigator$RouterAndState2, boolean z7, boolean z8, boolean z9, String str, String str2, int i8, Object obj) {
        String str3;
        String str4;
        if (obj == null) {
            if ((i8 & 32) != 0) {
                str3 = null;
            } else {
                str3 = str;
            }
            if ((i8 & 64) != 0) {
                str4 = null;
            } else {
                str4 = str2;
            }
            baseMultiStackRouter.T(routerNavigator$RouterAndState, routerNavigator$RouterAndState2, z7, z8, z9, str3, str4);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachRouterInternal");
    }

    private final void W(boolean z7) {
        this.f37170r.a();
        for (String stackKey : this.f37166n.keySet()) {
            Intrinsics.e(stackKey, "stackKey");
            K0(this, null, null, z7, stackKey, null, 19, null);
        }
        b0(z7);
        if (this.f37169q.f() || (!this.f37172t.isEmpty())) {
            N0();
            Collection<Disposable> values = this.f37172t.values();
            Intrinsics.e(values, "childRouterTagToEvents.values");
            for (Disposable disposable : values) {
                disposable.dispose();
            }
            this.f37172t.clear();
            this.f37169q.b();
        }
    }

    private final BaseMultiStackRouter<V, StateT>.BackStackSavedState Z() {
        int b8;
        List H0;
        List H02;
        HashMap<String, BaseMultiStackRouter<V, StateT>.NavigationStack> hashMap = this.f37166n;
        b8 = MapsKt__MapsJVMKt.b(hashMap.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(b8);
        Iterator<T> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), ((NavigationStack) entry.getValue()).a());
        }
        H0 = CollectionsKt___CollectionsKt.H0(this.f37167o);
        H02 = CollectionsKt___CollectionsKt.H0(this.f37169q.c());
        Bundle backStackRibSavedStates = this.f37168p;
        Intrinsics.e(backStackRibSavedStates, "backStackRibSavedStates");
        return new BackStackSavedState(this, linkedHashMap, H0, H02, backStackRibSavedStates);
    }

    private final AbstractStackRouter.StackRouterTags a0(BaseMultiStackRouter<V, StateT>.NavigationStack navigationStack) {
        String str;
        Router c8;
        RouterNavigator$RouterAndState<StateT> c9 = navigationStack.c();
        if (c9 != 0 && (c8 = c9.c()) != null) {
            str = c8.r();
        } else {
            str = null;
        }
        AbstractCollection<RouterNavigator$RouterAndState> f8 = navigationStack.f();
        ArrayList arrayList = new ArrayList();
        for (RouterNavigator$RouterAndState routerNavigator$RouterAndState : f8) {
            Router c10 = routerNavigator$RouterAndState.c();
            Intrinsics.e(c10, "it.router");
            arrayList.add(l0(c10));
        }
        return new AbstractStackRouter.StackRouterTags(arrayList, str);
    }

    private final boolean e0(RouterNavigator$RouterAndState<StateT> routerNavigator$RouterAndState, RouterNavigator$RouterAndState<StateT> routerNavigator$RouterAndState2, boolean z7, boolean z8, String str) {
        String str2;
        StateT statet;
        StateT d8;
        String name = routerNavigator$RouterAndState.d().name();
        if (routerNavigator$RouterAndState2 != null && (d8 = routerNavigator$RouterAndState2.d()) != null) {
            str2 = d8.name();
        } else {
            str2 = null;
        }
        M0();
        this.f37177y = new InTransactionDebugParams(name, str2, "detach");
        boolean z9 = true;
        this.f37176x = true;
        RouterNavigator$DetachCallback b8 = routerNavigator$RouterAndState.b();
        Router router = routerNavigator$RouterAndState.c();
        if (str != null) {
            if (!z8) {
                this.f37168p.g(router.r(), null);
                this.f37169q.m(str, router.r());
            }
            Disposable remove = this.f37172t.remove(router.r());
            if (remove != null) {
                remove.dispose();
            }
        }
        if (b8 != null) {
            z9 = b8.b(router, new RouterNavigator$DetachParams(routerNavigator$RouterAndState.d(), routerNavigator$RouterAndState2, z8, z7));
        }
        Intrinsics.e(router, "router");
        f(router, z7);
        if (b8 != null) {
            if (routerNavigator$RouterAndState2 != null) {
                statet = routerNavigator$RouterAndState2.d();
            } else {
                statet = null;
            }
            b8.a(router, statet, z8);
        }
        if (str != null) {
            if (!z8) {
                PublishRelay<AbstractStackRouter.RouterEvent> E = E();
                StateT d9 = routerNavigator$RouterAndState.d();
                Intrinsics.e(d9, "fromRouterState.state");
                E.accept(new AbstractStackRouter.RouterEvent.CloseChild(d9));
                if (L() && this.f37175w) {
                    E().accept(new AbstractStackRouter.RouterEvent.CloseAllChildren(z9));
                }
            }
        } else {
            PublishRelay<AbstractStackRouter.RouterEvent> E2 = E();
            StateT d10 = routerNavigator$RouterAndState.d();
            Intrinsics.e(d10, "fromRouterState.state");
            E2.accept(new AbstractStackRouter.RouterEvent.CloseChild(d10));
        }
        this.f37173u.b("[" + LoggingExtensionKt.c(this) + "] detached " + routerNavigator$RouterAndState.d().name() + " with stackKey=" + str);
        this.f37176x = false;
        this.f37177y = null;
        return z9;
    }

    static /* synthetic */ boolean f0(BaseMultiStackRouter baseMultiStackRouter, RouterNavigator$RouterAndState routerNavigator$RouterAndState, RouterNavigator$RouterAndState routerNavigator$RouterAndState2, boolean z7, boolean z8, String str, int i8, Object obj) {
        if (obj == null) {
            if ((i8 & 16) != 0) {
                str = null;
            }
            return baseMultiStackRouter.e0(routerNavigator$RouterAndState, routerNavigator$RouterAndState2, z7, z8, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: detachRouterInternal");
    }

    private final void g0() {
        if (i0() > 0) {
            this.f37173u.i("A router can't be used before a call to onRouterFirstAttach/onRouterReattached/onRouterAttached of a RibInteractor.\nTry moving any calls that attach RIBs to one of these methods. \nonRouterFirstAttach is invoked when interactor is initialised for the first time.\nonRouterReattached is invoked when interactor is brought from backstack or was restored from Bundle.\nonRouterAttached is always invoked.");
        }
    }

    private final BaseMultiStackRouter<V, StateT>.NavigationStack h0(String str) {
        BaseMultiStackRouter<V, StateT>.NavigationStack navigationStack = this.f37166n.get(str);
        if (navigationStack == null) {
            BaseMultiStackRouter<V, StateT>.NavigationStack navigationStack2 = new NavigationStack();
            this.f37166n.put(str, navigationStack2);
            return navigationStack2;
        }
        return navigationStack;
    }

    private final String j0() {
        String r7 = r();
        return r7 + "_stack";
    }

    private final String l0(Router router) {
        return router.r();
    }

    private final void m0(String str, String str2, Observable<AbstractStackRouter.RouterEvent> observable) {
        this.f37172t.put(str, this.f37171s.a(str2, str).k(observable));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean n0(StateT statet, String str) {
        SerializableRouterNavigatorState serializableRouterNavigatorState;
        boolean z7;
        if (str == null) {
            if (statet != null) {
                ArrayList<RouterNavigator$RouterAndState<StateT>> arrayList = this.f37167o;
                if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                    Iterator<T> it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (M((SerializableRouterNavigatorState) ((RouterNavigator$RouterAndState) it.next()).d(), statet)) {
                            z7 = true;
                            break;
                        }
                    }
                }
                z7 = false;
                if (z7) {
                    return true;
                }
            }
            return false;
        }
        RouterNavigator$RouterAndState p02 = p0(str);
        if (p02 != null) {
            serializableRouterNavigatorState = (SerializableRouterNavigatorState) p02.d();
        } else {
            serializableRouterNavigatorState = null;
        }
        return M(serializableRouterNavigatorState, statet);
    }

    private final RouterNavigator$RouterAndState<StateT> p0(String str) {
        BaseMultiStackRouter<V, StateT>.NavigationStack navigationStack = this.f37166n.get(str);
        if (navigationStack != null) {
            return (RouterNavigator$RouterAndState<StateT>) navigationStack.g();
        }
        return null;
    }

    public static /* synthetic */ boolean s0(BaseMultiStackRouter baseMultiStackRouter, boolean z7, String str, int i8, Object obj) {
        if (obj == null) {
            if ((i8 & 1) != 0) {
                z7 = false;
            }
            if ((i8 & 2) != 0) {
                str = "default_stack";
            }
            return baseMultiStackRouter.r0(z7, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popState");
    }

    private final boolean t0(boolean z7, String str) {
        M0();
        BaseMultiStackRouter<V, StateT>.NavigationStack h02 = h0(str);
        RouterNavigator$RouterAndState<StateT> h8 = h02.h();
        if (h8 != null) {
            RouterNavigator$RouterAndState<StateT> g8 = h02.g();
            boolean e02 = e0(h8, g8, z7, false, str);
            if (g8 != null) {
                U(this, h8, g8, e02, z7, false, str, null, 64, null);
                return true;
            }
            return true;
        }
        return false;
    }

    private final void u0(String str, RouterNavigator$RouterAndState<StateT> routerNavigator$RouterAndState, boolean z7, boolean z8, String str2) {
        boolean z9;
        boolean z10;
        BaseMultiStackRouter<V, StateT>.NavigationStack h02 = h0(str);
        RouterNavigator$RouterAndState<StateT> g8 = h02.g();
        Logger logger = this.f37173u;
        String c8 = LoggingExtensionKt.c(this);
        String name = routerNavigator$RouterAndState.d().name();
        logger.b("[" + c8 + "] push " + name + " to " + str + ": " + h02 + ", discardOnNextPush=" + z8);
        if (g8 != null) {
            Bundle savedState = Bundle.a();
            Router c9 = g8.c();
            Intrinsics.e(savedState, "savedState");
            c9.v(savedState);
            this.f37168p.g(c9.r(), savedState);
            if (h02.c() == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            z9 = e0(g8, routerNavigator$RouterAndState, z7, z10, str);
        } else {
            z9 = true;
        }
        h02.i(routerNavigator$RouterAndState, z8);
        T(g8, routerNavigator$RouterAndState, z9, z7, true, str, str2);
    }

    static /* synthetic */ void v0(BaseMultiStackRouter baseMultiStackRouter, String str, RouterNavigator$RouterAndState routerNavigator$RouterAndState, boolean z7, boolean z8, String str2, int i8, Object obj) {
        if (obj == null) {
            if ((i8 & 16) != 0) {
                str2 = null;
            }
            baseMultiStackRouter.u0(str, routerNavigator$RouterAndState, z7, z8, str2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pushToNavigationStack");
    }

    private final void w0(BaseMultiStackRouter<V, StateT>.NavigationStack navigationStack) {
        for (RouterNavigator$RouterAndState routerNavigator$RouterAndState : navigationStack.f()) {
            this.f37168p.g(routerNavigator$RouterAndState.c().r(), null);
        }
    }

    private final List<StateT> x0(BaseMultiStackRouter<V, StateT>.NavigationStack navigationStack, Function1<? super RouterNavigator$RouterAndState<StateT>, Boolean> function1) {
        M0();
        Iterator it = navigationStack.f().iterator();
        Intrinsics.e(it, "navStack.stack.iterator()");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            RouterNavigator$RouterAndState next = (RouterNavigator$RouterAndState) it.next();
            Intrinsics.e(next, "next");
            if (function1.invoke(next).booleanValue()) {
                Logger logger = this.f37173u;
                String c8 = LoggingExtensionKt.c(this);
                String name = ((SerializableRouterNavigatorState) next.d()).name();
                logger.b("[" + c8 + "] removed from back stack " + name);
                it.remove();
                RouterNavigatorState d8 = next.d();
                Intrinsics.e(d8, "next.state");
                arrayList.add(d8);
                String r7 = next.c().r();
                if (r7 != null) {
                    this.f37168p.g(r7, null);
                    linkedHashSet.add(r7);
                } else {
                    Logger logger2 = this.f37173u;
                    Router c9 = next.c();
                    logger2.i("Router tag is null for " + c9 + " from " + this);
                }
            }
        }
        this.f37169q.o(linkedHashSet);
        return arrayList;
    }

    private final void y0(String str, BaseMultiStackRouter<V, StateT>.NavigationStack navigationStack) {
        Set L0;
        L0 = CollectionsKt___CollectionsKt.L0(this.f37169q.h(str));
        Iterator it = navigationStack.e().iterator();
        while (it.hasNext()) {
            RouterNavigator$RouterAndState routerNavigator$RouterAndState = (RouterNavigator$RouterAndState) it.next();
            if (L0.contains(routerNavigator$RouterAndState.c().r())) {
                PublishRelay<AbstractStackRouter.RouterEvent> E = E();
                RouterNavigatorState d8 = routerNavigator$RouterAndState.d();
                Intrinsics.e(d8, "it.state");
                E.accept(new AbstractStackRouter.RouterEvent.CloseChild((SerializableRouterNavigatorState) d8));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z0(Bundle bundle) {
        SerializableNavigationState serializableNavigationState = (SerializableNavigationState) RibExtensionsKt.b(bundle, j0());
        if (serializableNavigationState == null) {
            Logger logger = this.f37173u;
            logger.h(new IllegalStateException("saved state not found " + bundle));
            return;
        }
        if (i0() > 0) {
            this.f37175w = false;
            W(true);
            this.f37175w = true;
        }
        this.f37169q.u(true);
        this.f37174v = true;
        Logger logger2 = this.f37173u;
        String c8 = LoggingExtensionKt.c(this);
        logger2.b("[" + c8 + "] restoring state: " + serializableNavigationState);
        Iterator<T> it = serializableNavigationState.b().iterator();
        while (it.hasNext()) {
            StateWithTag stateWithTag = (StateWithTag) it.next();
            N(stateWithTag.a(), true, stateWithTag.b());
        }
        for (Map.Entry<String, SerializableNavStack<StateT>> entry : serializableNavigationState.a().entrySet()) {
            String key = entry.getKey();
            List<StateT> b8 = entry.getValue().b();
            StateT a8 = entry.getValue().a();
            AbstractStackRouter.StackRouterTags c9 = entry.getValue().c();
            Intrinsics.e(key, "key");
            J0(b8, a8, true, key, c9);
        }
        this.f37169q.t(serializableNavigationState.c());
        this.f37169q.u(false);
        Logger logger3 = this.f37173u;
        String c10 = LoggingExtensionKt.c(this);
        HashMap<String, BaseMultiStackRouter<V, StateT>.NavigationStack> hashMap = this.f37166n;
        MultiStackRouterEventsRepository multiStackRouterEventsRepository = this.f37169q;
        logger3.b("[" + c10 + "] restored state: map=" + hashMap + ", events=" + multiStackRouterEventsRepository);
    }

    public final boolean H0(List<? extends StateT> stack, StateT statet, boolean z7, String stackKey) {
        Intrinsics.f(stack, "stack");
        Intrinsics.f(stackKey, "stackKey");
        return K0(this, stack, statet, z7, stackKey, null, 16, null);
    }

    protected boolean L0() {
        return true;
    }

    public final boolean N(StateT state, boolean z7, String str) {
        Intrinsics.f(state, "state");
        return Q(new AttachInfo<>(state, false, z7), null, str);
    }

    public final boolean P(StateT state, boolean z7, boolean z8, String stackKey) {
        Intrinsics.f(state, "state");
        Intrinsics.f(stackKey, "stackKey");
        return R(this, new AttachInfo(state, z7, z8), stackKey, null, 4, null);
    }

    public final void V(String stackKey) {
        Intrinsics.f(stackKey, "stackKey");
        BaseMultiStackRouter<V, StateT>.NavigationStack h02 = h0(stackKey);
        if (h02.c() != null) {
            x0(h02, new Function1<RouterNavigator$RouterAndState<StateT>, Boolean>() { // from class: eu.bolt.android.rib.multistack.BaseMultiStackRouter$clearBackStack$1
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final Boolean invoke(RouterNavigator$RouterAndState<StateT> it) {
                    Intrinsics.f(it, "it");
                    return Boolean.TRUE;
                }
            });
        } else {
            final RouterNavigator$RouterAndState routerNavigator$RouterAndState = (RouterNavigator$RouterAndState) h02.f().peekFirst();
            x0(h02, new Function1<RouterNavigator$RouterAndState<StateT>, Boolean>() { // from class: eu.bolt.android.rib.multistack.BaseMultiStackRouter$clearBackStack$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final Boolean invoke(RouterNavigator$RouterAndState<StateT> it) {
                    boolean z7;
                    Intrinsics.f(it, "it");
                    if (it != routerNavigator$RouterAndState) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    return Boolean.valueOf(z7);
                }
            });
        }
        E().accept(AbstractStackRouter.RouterEvent.BackStackCleared.f37026a);
    }

    public final boolean X(String stateName) {
        boolean z7;
        Intrinsics.f(stateName, "stateName");
        Collection<BaseMultiStackRouter<V, StateT>.NavigationStack> values = this.f37166n.values();
        Intrinsics.e(values, "navStackMap.values");
        if (!values.isEmpty()) {
            Iterator<T> it = values.iterator();
            while (it.hasNext()) {
                if (((NavigationStack) it.next()).b(stateName)) {
                    z7 = true;
                    break;
                }
            }
        }
        z7 = false;
        if (z7 || Y(stateName)) {
            return true;
        }
        return false;
    }

    public final boolean Y(String stateName) {
        Intrinsics.f(stateName, "stateName");
        ArrayList<RouterNavigator$RouterAndState<StateT>> arrayList = this.f37167o;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return false;
        }
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            if (Intrinsics.a(((SerializableRouterNavigatorState) ((RouterNavigator$RouterAndState) it.next()).d()).name(), stateName)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [eu.bolt.android.rib.Router] */
    @Override // eu.bolt.android.rib.RibNavigator.NavigationDelegate
    public <R extends Router> R a(StateT newState, RouterNavigator$AttachTransition<R, StateT> attachTransition, RouterNavigator$DetachTransition<R, StateT> routerNavigator$DetachTransition, boolean z7, boolean z8, String str, String str2) {
        Intrinsics.f(newState, "newState");
        Intrinsics.f(attachTransition, "attachTransition");
        R r7 = null;
        if (n0(newState, str)) {
            Logger logger = this.f37173u;
            String c8 = LoggingExtensionKt.c(this);
            String name = newState.name();
            logger.b("[" + c8 + "] skipped attaching rib for " + name + ", rib already attached");
            return null;
        }
        RouterNavigator$RouterAndState<StateT> routerNavigator$RouterAndState = new RouterNavigator$RouterAndState<>(attachTransition.a(), newState, attachTransition, routerNavigator$DetachTransition);
        if (str != null) {
            String j8 = this.f37170r.j();
            u0(str, routerNavigator$RouterAndState, z8, z7, str2);
            this.f37170r.e(str, j8);
        } else {
            S(routerNavigator$RouterAndState, z8, str2);
        }
        ?? c9 = routerNavigator$RouterAndState.c();
        if (c9 instanceof Router) {
            r7 = c9;
        }
        if (r7 != null) {
            return r7;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void b0(boolean z7) {
        int m8;
        for (m8 = CollectionsKt__CollectionsKt.m(this.f37167o); -1 < m8; m8--) {
            c0(this.f37167o.get(m8).d().name(), z7);
        }
    }

    public final boolean c0(String name, boolean z7) {
        Intrinsics.f(name, "name");
        Iterator<RouterNavigator$RouterAndState<StateT>> it = this.f37167o.iterator();
        int i8 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.a(it.next().d().name(), name)) {
                    break;
                }
                i8++;
            } else {
                i8 = -1;
                break;
            }
        }
        if (i8 < 0) {
            return false;
        }
        RouterNavigator$RouterAndState<StateT> remove = this.f37167o.remove(i8);
        Intrinsics.e(remove, "noBackStackRibs.removeAt(attachedRouterIndex)");
        f0(this, remove, null, z7, false, null, 16, null);
        return true;
    }

    public final boolean d0(final String stateName, boolean z7, String stackKey) {
        String str;
        SerializableRouterNavigatorState serializableRouterNavigatorState;
        Intrinsics.f(stateName, "stateName");
        Intrinsics.f(stackKey, "stackKey");
        BaseMultiStackRouter<V, StateT>.NavigationStack h02 = h0(stackKey);
        final RouterNavigator$RouterAndState<StateT> g8 = h02.g();
        List<StateT> x02 = x0(h02, new Function1<RouterNavigator$RouterAndState<StateT>, Boolean>() { // from class: eu.bolt.android.rib.multistack.BaseMultiStackRouter$detachRibFromStack$detachedFromBackStack$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(RouterNavigator$RouterAndState<StateT> it) {
                boolean z8;
                Intrinsics.f(it, "it");
                if (it != g8 && Intrinsics.a(((SerializableRouterNavigatorState) it.d()).name(), stateName)) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                return Boolean.valueOf(z8);
            }
        });
        for (StateT statet : x02) {
            E().accept(new AbstractStackRouter.RouterEvent.CloseChild(statet));
        }
        if (g8 != 0 && (serializableRouterNavigatorState = (SerializableRouterNavigatorState) g8.d()) != null) {
            str = serializableRouterNavigatorState.name();
        } else {
            str = null;
        }
        boolean a8 = Intrinsics.a(str, stateName);
        if (a8) {
            r0(z7, stackKey);
        }
        if (a8 || (!x02.isEmpty())) {
            return true;
        }
        return false;
    }

    @Override // eu.bolt.android.rib.Router
    public void e(Bundle savedState, String tag) {
        Intrinsics.f(savedState, "savedState");
        Intrinsics.f(tag, "tag");
        if (this.f37174v) {
            super.e(savedState, tag);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.rib.AbstractStackRouter, eu.bolt.android.rib.Router
    public void i(Bundle bundle, String str) {
        super.i(bundle, str);
        g0();
        RibLogger ribLogger = RibLogger.f37068a;
        BaseMultiStackRouter<V, StateT>.BackStackSavedState backStackSavedState = this.f37178z;
        ribLogger.a("Pre tryRestore " + str + "\nstateBeforeDetach=" + backStackSavedState + "\nsavedInstanceState=" + bundle);
        boolean P0 = P0(this.f37178z, bundle);
        BaseMultiStackRouter<V, StateT>.BackStackSavedState backStackSavedState2 = this.f37178z;
        ribLogger.a("Post tryRestore " + str + " hasRestoredState=" + P0 + "\nstateBeforeDetach=" + backStackSavedState2 + "\nsavedInstanceState=" + bundle);
        this.f37174v = true;
        if (P0) {
            p().k();
        } else {
            p().s();
        }
        p().y();
    }

    public final int i0() {
        return k0() + this.f37167o.size();
    }

    @Override // eu.bolt.android.rib.Router
    public void j(boolean z7) {
        p().h();
        z();
        this.f37178z = Z();
        W(z7);
        for (Router router : q()) {
            f(router, z7);
        }
        this.f37174v = false;
    }

    @Override // eu.bolt.android.rib.Router
    public void k() {
        this.f37170r.h();
    }

    public final int k0() {
        Collection<BaseMultiStackRouter<V, StateT>.NavigationStack> values = this.f37166n.values();
        Intrinsics.e(values, "navStackMap.values");
        Iterator<T> it = values.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            i8 += ((NavigationStack) it.next()).k();
        }
        return i8;
    }

    @Override // eu.bolt.android.rib.Router
    public void l() {
        this.f37170r.i();
    }

    @Override // eu.bolt.android.rib.Router
    public Bundle n(Bundle bundle, String tag) {
        Intrinsics.f(tag, "tag");
        if (this.f37174v) {
            Bundle n8 = super.n(bundle, tag);
            if (n8 == null) {
                return this.f37168p.c(tag);
            }
            return n8;
        }
        return null;
    }

    public final Router o0(String stackKey) {
        Intrinsics.f(stackKey, "stackKey");
        RouterNavigator$RouterAndState<StateT> p02 = p0(stackKey);
        if (p02 != null) {
            return p02.c();
        }
        return null;
    }

    protected boolean q0(StackUpdateEvent lastStackEvent) {
        Intrinsics.f(lastStackEvent, "lastStackEvent");
        if (p().z(t())) {
            return true;
        }
        if ((!s0(this, false, lastStackEvent.a(), 1, null)) && (lastStackEvent instanceof StackUpdateEvent.PushedToStack)) {
            O0();
            this.f37169q.r();
        }
        if (!L() || I()) {
            return true;
        }
        return false;
    }

    public final boolean r0(boolean z7, String stackKey) {
        Intrinsics.f(stackKey, "stackKey");
        String j8 = this.f37170r.j();
        boolean t02 = t0(z7, stackKey);
        this.f37170r.d(stackKey, j8);
        return t02;
    }

    @Override // eu.bolt.android.rib.Router
    public boolean s() {
        Router router;
        while (this.f37169q.f()) {
            StackUpdateEvent d8 = this.f37169q.d();
            BaseMultiStackRouter<V, StateT>.NavigationStack h02 = h0(d8.a());
            RouterNavigator$RouterAndState<StateT> g8 = h02.g();
            if (g8 != 0) {
                router = g8.c();
            } else {
                router = null;
            }
            boolean z7 = false;
            if (router != null && router.s()) {
                z7 = true;
            }
            if ((d8 instanceof StackUpdateEvent.NestedChildAdded) && !z7) {
                this.f37169q.q(d8);
            } else if (z7) {
                return true;
            } else {
                if (h02.k() > h02.d()) {
                    return q0(d8);
                }
                this.f37169q.q(d8);
            }
        }
        return p().z(t());
    }

    @Override // eu.bolt.android.rib.Router
    public void v(Bundle outState) {
        Intrinsics.f(outState, "outState");
        super.v(outState);
        B0(outState);
        C0(outState);
    }

    @Override // eu.bolt.android.rib.Router
    protected boolean x() {
        return false;
    }
}
