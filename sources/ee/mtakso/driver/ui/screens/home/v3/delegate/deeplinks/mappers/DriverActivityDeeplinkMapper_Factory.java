package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverActivityDeeplinkMapper_Factory implements Factory<DriverActivityDeeplinkMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final DriverActivityDeeplinkMapper_Factory f29974a = new DriverActivityDeeplinkMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static DriverActivityDeeplinkMapper_Factory a() {
        return InstanceHolder.f29974a;
    }

    public static DriverActivityDeeplinkMapper c() {
        return new DriverActivityDeeplinkMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverActivityDeeplinkMapper get() {
        return c();
    }
}
