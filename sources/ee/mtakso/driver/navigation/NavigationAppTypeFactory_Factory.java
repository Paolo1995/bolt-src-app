package ee.mtakso.driver.navigation;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.navigation.navigators.Navigator;
import java.util.Map;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class NavigationAppTypeFactory_Factory implements Factory<NavigationAppTypeFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Map<Navigator.Type, Navigator>> f21201a;

    public NavigationAppTypeFactory_Factory(Provider<Map<Navigator.Type, Navigator>> provider) {
        this.f21201a = provider;
    }

    public static NavigationAppTypeFactory_Factory a(Provider<Map<Navigator.Type, Navigator>> provider) {
        return new NavigationAppTypeFactory_Factory(provider);
    }

    public static NavigationAppTypeFactory c(Map<Navigator.Type, Navigator> map) {
        return new NavigationAppTypeFactory(map);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public NavigationAppTypeFactory get() {
        return c(this.f21201a.get());
    }
}
