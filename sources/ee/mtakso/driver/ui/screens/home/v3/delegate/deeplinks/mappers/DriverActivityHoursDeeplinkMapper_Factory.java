package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverActivityHoursDeeplinkMapper_Factory implements Factory<DriverActivityHoursDeeplinkMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final DriverActivityHoursDeeplinkMapper_Factory f29976a = new DriverActivityHoursDeeplinkMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static DriverActivityHoursDeeplinkMapper_Factory a() {
        return InstanceHolder.f29976a;
    }

    public static DriverActivityHoursDeeplinkMapper c() {
        return new DriverActivityHoursDeeplinkMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverActivityHoursDeeplinkMapper get() {
        return c();
    }
}
