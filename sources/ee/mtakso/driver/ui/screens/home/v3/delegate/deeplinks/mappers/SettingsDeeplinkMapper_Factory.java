package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class SettingsDeeplinkMapper_Factory implements Factory<SettingsDeeplinkMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final SettingsDeeplinkMapper_Factory f29996a = new SettingsDeeplinkMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static SettingsDeeplinkMapper_Factory a() {
        return InstanceHolder.f29996a;
    }

    public static SettingsDeeplinkMapper c() {
        return new SettingsDeeplinkMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SettingsDeeplinkMapper get() {
        return c();
    }
}
