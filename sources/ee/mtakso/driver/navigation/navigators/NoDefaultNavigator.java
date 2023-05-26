package ee.mtakso.driver.navigation.navigators;

import android.content.Context;
import ee.mtakso.driver.R;
import ee.mtakso.driver.navigation.navigators.Navigator;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NoDefaultNavigator.kt */
@Singleton
/* loaded from: classes3.dex */
public final class NoDefaultNavigator implements Navigator {

    /* renamed from: b  reason: collision with root package name */
    private final boolean f21252b;

    /* renamed from: a  reason: collision with root package name */
    private final Navigator.Type f21251a = Navigator.Type.NO_NAVIGATION_SELECTED;

    /* renamed from: c  reason: collision with root package name */
    private final int f21253c = R.drawable.ic_active_order_default_nav;

    @Override // ee.mtakso.driver.navigation.navigators.Navigator
    public String a(Context context) {
        Intrinsics.f(context, "context");
        String string = context.getString(R.string.no_default_navigation);
        Intrinsics.e(string, "context.getString(R.string.no_default_navigation)");
        return string;
    }

    @Override // ee.mtakso.driver.navigation.navigators.Navigator
    public boolean b() {
        return this.f21252b;
    }

    @Override // ee.mtakso.driver.navigation.navigators.Navigator
    public int c() {
        return this.f21253c;
    }

    @Override // ee.mtakso.driver.navigation.navigators.Navigator
    public Navigator.Type getType() {
        return this.f21251a;
    }
}
