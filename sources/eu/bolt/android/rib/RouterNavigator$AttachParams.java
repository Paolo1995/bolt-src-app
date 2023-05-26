package eu.bolt.android.rib;

import android.view.View;
import androidx.annotation.NonNull;
import eu.bolt.android.rib.RouterNavigatorState;

/* loaded from: classes5.dex */
public class RouterNavigator$AttachParams<StateT extends RouterNavigatorState> {

    /* renamed from: a  reason: collision with root package name */
    public final RouterNavigator$RouterAndState<StateT> f37084a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final StateT f37085b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f37086c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f37087d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f37088e;

    /* renamed from: f  reason: collision with root package name */
    public final Class<? extends View> f37089f;

    public RouterNavigator$AttachParams(RouterNavigator$RouterAndState<StateT> routerNavigator$RouterAndState, @NonNull StateT statet, boolean z7, boolean z8, boolean z9, Class<? extends View> cls) {
        this.f37084a = routerNavigator$RouterAndState;
        this.f37085b = statet;
        this.f37086c = z7;
        this.f37087d = z8;
        this.f37088e = z9;
        this.f37089f = cls;
    }
}
