package ee.mtakso.driver.ui.screens.home.v3.delegate;

import android.app.Activity;
import ee.mtakso.driver.navigation.NavigationAppTypeFactory;
import ee.mtakso.driver.navigation.navigators.ExternalNavigator;
import ee.mtakso.driver.navigation.navigators.Navigator;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigatorChooserFragment;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigatorChooserDelegate.kt */
/* loaded from: classes3.dex */
public final class NavigatorChooserDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f29877a;

    /* renamed from: b  reason: collision with root package name */
    private final NavigationAppTypeFactory f29878b;

    @Inject
    public NavigatorChooserDelegate(DriverProvider driverProvider, NavigationAppTypeFactory navigationAppTypeFactory) {
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(navigationAppTypeFactory, "navigationAppTypeFactory");
        this.f29877a = driverProvider;
        this.f29878b = navigationAppTypeFactory;
    }

    private final boolean a(Navigator.Type type) {
        ExternalNavigator b8;
        if (type == null || (b8 = this.f29878b.b(type)) == null || !b8.b()) {
            return false;
        }
        return true;
    }

    public final void b(Activity activity) {
        Intrinsics.f(activity, "activity");
        if (a(this.f29877a.t().y())) {
            NavigatorChooserFragment.f30914t.b(activity, 754);
        }
    }
}
