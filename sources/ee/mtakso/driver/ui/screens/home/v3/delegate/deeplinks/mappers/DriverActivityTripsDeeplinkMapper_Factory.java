package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverActivityTripsDeeplinkMapper_Factory implements Factory<DriverActivityTripsDeeplinkMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final DriverActivityTripsDeeplinkMapper_Factory f29978a = new DriverActivityTripsDeeplinkMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static DriverActivityTripsDeeplinkMapper_Factory a() {
        return InstanceHolder.f29978a;
    }

    public static DriverActivityTripsDeeplinkMapper c() {
        return new DriverActivityTripsDeeplinkMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverActivityTripsDeeplinkMapper get() {
        return c();
    }
}
