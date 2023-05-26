package eu.bolt.driver.core.ui.routing;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class RoutingManager_Factory implements Factory<RoutingManager> {

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final RoutingManager_Factory f41159a = new RoutingManager_Factory();

        private InstanceHolder() {
        }
    }

    public static RoutingManager_Factory a() {
        return InstanceHolder.f41159a;
    }

    public static RoutingManager c() {
        return new RoutingManager();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RoutingManager get() {
        return c();
    }
}
