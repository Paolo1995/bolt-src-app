package eu.bolt.android.rib;

import androidx.annotation.NonNull;
import eu.bolt.android.rib.RouterNavigatorState;

/* loaded from: classes5.dex */
public class RouterNavigator$RouterAndState<StateT extends RouterNavigatorState> {

    /* renamed from: a  reason: collision with root package name */
    private Router f37095a;

    /* renamed from: b  reason: collision with root package name */
    private StateT f37096b;

    /* renamed from: c  reason: collision with root package name */
    private RouterNavigator$AttachTransition f37097c;

    /* renamed from: d  reason: collision with root package name */
    private RouterNavigator$DetachCallback f37098d;

    public RouterNavigator$RouterAndState(Router router, StateT statet, RouterNavigator$AttachTransition routerNavigator$AttachTransition, final RouterNavigator$DetachTransition routerNavigator$DetachTransition) {
        this.f37095a = router;
        this.f37096b = statet;
        this.f37097c = routerNavigator$AttachTransition;
        if (routerNavigator$DetachTransition != null) {
            if (routerNavigator$DetachTransition instanceof RouterNavigator$DetachCallback) {
                this.f37098d = (RouterNavigator$DetachCallback) routerNavigator$DetachTransition;
                return;
            } else {
                this.f37098d = new RouterNavigator$DetachCallback<RouterT, StateT>(routerNavigator$DetachTransition) { // from class: eu.bolt.android.rib.RouterNavigator$DetachCallbackWrapper

                    /* renamed from: a  reason: collision with root package name */
                    private RouterNavigator$DetachTransition<RouterT, StateT> f37090a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f37090a = routerNavigator$DetachTransition;
                    }

                    @Override // eu.bolt.android.rib.RouterNavigator$DetachCallback, eu.bolt.android.rib.RouterNavigator$DetachTransition
                    public boolean b(@NonNull RouterT routert, @NonNull RouterNavigator$DetachParams<StateT> routerNavigator$DetachParams) {
                        return this.f37090a.b(routert, routerNavigator$DetachParams);
                    }
                };
                return;
            }
        }
        this.f37098d = null;
    }

    public RouterNavigator$AttachTransition a() {
        return this.f37097c;
    }

    public RouterNavigator$DetachCallback b() {
        return this.f37098d;
    }

    public Router c() {
        return this.f37095a;
    }

    public StateT d() {
        return this.f37096b;
    }

    public String toString() {
        return "RouterAndState{router=" + this.f37095a + ", state=" + this.f37096b + ", attachTransition=" + this.f37097c + ", detachCallback=" + this.f37098d + '}';
    }
}
