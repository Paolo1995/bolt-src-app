package ee.mtakso.driver.ui.screens.login.v2;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class RouterFragmentCoordinator_Factory implements Factory<RouterFragmentCoordinator> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final RouterFragmentCoordinator_Factory f30458a = new RouterFragmentCoordinator_Factory();

        private InstanceHolder() {
        }
    }

    public static RouterFragmentCoordinator_Factory a() {
        return InstanceHolder.f30458a;
    }

    public static RouterFragmentCoordinator c() {
        return new RouterFragmentCoordinator();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RouterFragmentCoordinator get() {
        return c();
    }
}
