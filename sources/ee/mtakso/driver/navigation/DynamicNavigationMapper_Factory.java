package ee.mtakso.driver.navigation;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DynamicNavigationMapper_Factory implements Factory<DynamicNavigationMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final DynamicNavigationMapper_Factory f21195a = new DynamicNavigationMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static DynamicNavigationMapper_Factory a() {
        return InstanceHolder.f21195a;
    }

    public static DynamicNavigationMapper c() {
        return new DynamicNavigationMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DynamicNavigationMapper get() {
        return c();
    }
}
