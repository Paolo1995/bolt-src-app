package eu.bolt.android.rib;

import androidx.annotation.NonNull;
import eu.bolt.android.rib.Router;
import eu.bolt.android.rib.RouterNavigatorState;

/* loaded from: classes5.dex */
public interface RouterNavigator$DetachTransition<RouterT extends Router, StateT extends RouterNavigatorState> {
    boolean b(@NonNull RouterT routert, @NonNull RouterNavigator$DetachParams<StateT> routerNavigator$DetachParams);
}
