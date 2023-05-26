package ee.mtakso.driver.navigation;

import ee.mtakso.driver.navigation.navigators.ExternalNavigator;
import ee.mtakso.driver.navigation.navigators.Navigator;
import java.util.Collection;
import java.util.Map;
import javax.inject.Inject;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavigationAppTypeFactory.kt */
/* loaded from: classes3.dex */
public final class NavigationAppTypeFactory {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Navigator.Type, Navigator> f21200a;

    @Inject
    public NavigationAppTypeFactory(Map<Navigator.Type, Navigator> navigators) {
        Intrinsics.f(navigators, "navigators");
        this.f21200a = navigators;
    }

    public final Collection<Navigator> a() {
        return this.f21200a.values();
    }

    public final ExternalNavigator b(Navigator.Type type) {
        Object g8;
        Intrinsics.f(type, "type");
        g8 = MapsKt__MapsKt.g(this.f21200a, type);
        Navigator navigator = (Navigator) g8;
        if (navigator instanceof ExternalNavigator) {
            return (ExternalNavigator) navigator;
        }
        return null;
    }

    public final Navigator c(Navigator.Type type) {
        Object g8;
        Intrinsics.f(type, "type");
        g8 = MapsKt__MapsKt.g(this.f21200a, type);
        return (Navigator) g8;
    }
}
