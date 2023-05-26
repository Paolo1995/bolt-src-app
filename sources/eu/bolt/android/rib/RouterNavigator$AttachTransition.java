package eu.bolt.android.rib;

import androidx.annotation.NonNull;
import eu.bolt.android.rib.Router;
import eu.bolt.android.rib.RouterNavigatorState;

/* loaded from: classes5.dex */
public interface RouterNavigator$AttachTransition<RouterT extends Router, StateT extends RouterNavigatorState> {
    RouterT a();

    void c(@NonNull RouterT routert, @NonNull RouterNavigator$AttachParams<StateT> routerNavigator$AttachParams);
}
