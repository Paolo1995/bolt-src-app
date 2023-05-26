package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverActivityCancelsDeeplinkMapper_Factory implements Factory<DriverActivityCancelsDeeplinkMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final DriverActivityCancelsDeeplinkMapper_Factory f29973a = new DriverActivityCancelsDeeplinkMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static DriverActivityCancelsDeeplinkMapper_Factory a() {
        return InstanceHolder.f29973a;
    }

    public static DriverActivityCancelsDeeplinkMapper c() {
        return new DriverActivityCancelsDeeplinkMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverActivityCancelsDeeplinkMapper get() {
        return c();
    }
}
