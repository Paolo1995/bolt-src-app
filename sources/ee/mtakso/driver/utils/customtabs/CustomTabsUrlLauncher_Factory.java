package ee.mtakso.driver.utils.customtabs;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class CustomTabsUrlLauncher_Factory implements Factory<CustomTabsUrlLauncher> {

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final CustomTabsUrlLauncher_Factory f36400a = new CustomTabsUrlLauncher_Factory();

        private InstanceHolder() {
        }
    }

    public static CustomTabsUrlLauncher_Factory a() {
        return InstanceHolder.f36400a;
    }

    public static CustomTabsUrlLauncher c() {
        return new CustomTabsUrlLauncher();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CustomTabsUrlLauncher get() {
        return c();
    }
}
