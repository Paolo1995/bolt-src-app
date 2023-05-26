package eu.bolt.android.rib;

import androidx.annotation.NonNull;
import eu.bolt.android.rib.Router;
import eu.bolt.android.rib.RouterNavigatorState;

/* loaded from: classes5.dex */
public abstract class RouterNavigator$DetachCallback<RouterT extends Router, StateT extends RouterNavigatorState> implements RouterNavigator$DetachTransition<RouterT, StateT> {
    public void a(RouterT routert, StateT statet, boolean z7) {
    }

    @Override // eu.bolt.android.rib.RouterNavigator$DetachTransition
    public boolean b(@NonNull RouterT routert, @NonNull RouterNavigator$DetachParams<StateT> routerNavigator$DetachParams) {
        return false;
    }
}
