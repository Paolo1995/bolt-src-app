package ee.mtakso.driver.ui.screens.work;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class DashboardMapper_Factory implements Factory<DashboardMapper> {

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final DashboardMapper_Factory f33637a = new DashboardMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static DashboardMapper_Factory a() {
        return InstanceHolder.f33637a;
    }

    public static DashboardMapper c() {
        return new DashboardMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DashboardMapper get() {
        return c();
    }
}
