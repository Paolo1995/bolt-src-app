package eu.bolt.android.rib;

import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.Relay;
import com.uber.autodispose.lifecycle.CorrespondingEventsFunction;
import com.uber.autodispose.lifecycle.LifecycleEndedException;
import eu.bolt.android.rib.Router;
import eu.bolt.android.rib.lifecycle.InteractorEvent;
import eu.bolt.coroutines.base.BaseScopeOwner;
import eu.bolt.coroutines.flows.BehaviorFlow;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RibInteractor.kt */
/* loaded from: classes5.dex */
public abstract class RibInteractor<R extends Router> extends BaseScopeOwner implements RibLifecycleSubject {

    /* renamed from: h  reason: collision with root package name */
    public static final Companion f37061h = new Companion(null);

    /* renamed from: i  reason: collision with root package name */
    private static final CorrespondingEventsFunction<InteractorEvent> f37062i = new CorrespondingEventsFunction() { // from class: eu.bolt.android.rib.j
        @Override // io.reactivex.functions.Function
        public final Object apply(Object obj) {
            InteractorEvent J;
            J = RibInteractor.J((InteractorEvent) obj);
            return J;
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final BehaviorRelay<InteractorEvent> f37063c;

    /* renamed from: d  reason: collision with root package name */
    private final Relay<InteractorEvent> f37064d;

    /* renamed from: e  reason: collision with root package name */
    private final BehaviorFlow<InteractorEvent> f37065e;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayList<Function1<R, Unit>> f37066f;

    /* renamed from: g  reason: collision with root package name */
    private R f37067g;

    /* compiled from: RibInteractor.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RibInteractor() {
        BehaviorRelay<InteractorEvent> e8 = BehaviorRelay.e();
        Intrinsics.e(e8, "create<InteractorEvent?>()");
        this.f37063c = e8;
        Relay<InteractorEvent> c8 = e8.c();
        Intrinsics.e(c8, "behaviorRelay.toSerialized()");
        this.f37064d = c8;
        this.f37065e = new BehaviorFlow<>();
        this.f37066f = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InteractorEvent J(InteractorEvent interactorEvent) {
        InteractorEvent interactorEvent2 = InteractorEvent.INACTIVE;
        if (interactorEvent != interactorEvent2) {
            return interactorEvent2;
        }
        throw new LifecycleEndedException();
    }

    private final void N(InteractorEvent interactorEvent) {
        this.f37064d.accept(interactorEvent);
        this.f37065e.f(interactorEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K(Bundle bundle) {
    }

    public final R L() {
        R r7 = this.f37067g;
        if (r7 != null) {
            return r7;
        }
        throw new IllegalStateException("Attempting to get interactor's router before it's set.".toString());
    }

    public Observable<InteractorEvent> M() {
        Observable<InteractorEvent> hide = this.f37064d.hide();
        Intrinsics.e(hide, "lifecycleRelay.hide()");
        return hide;
    }

    public final void O(R router) {
        Intrinsics.f(router, "router");
        if (this.f37067g == null) {
            this.f37067g = router;
            return;
        }
        throw new IllegalStateException("Attempting to set interactor's router after it has been set.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P() {
    }

    @Override // eu.bolt.android.rib.RibLifecycleSubject
    public void h() {
        P();
        N(InteractorEvent.INACTIVE);
    }

    @Override // eu.bolt.android.rib.RibLifecycleSubject
    public void k() {
    }

    @Override // eu.bolt.android.rib.RibLifecycleSubject
    public void l(Bundle bundle) {
        N(InteractorEvent.ACTIVE);
        Iterator<Function1<R, Unit>> it = this.f37066f.iterator();
        while (it.hasNext()) {
            it.next().invoke(this.f37067g);
        }
        K(bundle);
    }

    @Override // eu.bolt.android.rib.RibLifecycleSubject
    public void s() {
    }

    @Override // eu.bolt.android.rib.RibLifecycleSubject
    public void v() {
        N(InteractorEvent.STACK_FOCUS_LOST);
    }

    @Override // eu.bolt.android.rib.RibLifecycleSubject
    public void w() {
        N(InteractorEvent.STACK_FOCUS_RECEIVED);
    }

    @Override // eu.bolt.android.rib.RibLifecycleSubject
    public void x(Bundle outState) {
        Intrinsics.f(outState, "outState");
    }

    @Override // eu.bolt.android.rib.RibLifecycleSubject
    public void y() {
    }

    public boolean z(boolean z7) {
        return false;
    }
}
