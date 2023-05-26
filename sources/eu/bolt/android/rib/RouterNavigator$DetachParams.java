package eu.bolt.android.rib;

import androidx.annotation.NonNull;
import eu.bolt.android.rib.RouterNavigatorState;

/* loaded from: classes5.dex */
public class RouterNavigator$DetachParams<StateT extends RouterNavigatorState> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final StateT f37091a;

    /* renamed from: b  reason: collision with root package name */
    public final RouterNavigator$RouterAndState<StateT> f37092b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f37093c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f37094d;

    public RouterNavigator$DetachParams(@NonNull StateT statet, RouterNavigator$RouterAndState<StateT> routerNavigator$RouterAndState, boolean z7, boolean z8) {
        this.f37091a = statet;
        this.f37092b = routerNavigator$RouterAndState;
        this.f37093c = z7;
        this.f37094d = z8;
    }
}
