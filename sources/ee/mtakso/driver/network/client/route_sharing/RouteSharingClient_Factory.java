package ee.mtakso.driver.network.client.route_sharing;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class RouteSharingClient_Factory implements Factory<RouteSharingClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<RouteSharingApi> f22705a;

    public RouteSharingClient_Factory(Provider<RouteSharingApi> provider) {
        this.f22705a = provider;
    }

    public static RouteSharingClient_Factory a(Provider<RouteSharingApi> provider) {
        return new RouteSharingClient_Factory(provider);
    }

    public static RouteSharingClient c(RouteSharingApi routeSharingApi) {
        return new RouteSharingClient(routeSharingApi);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RouteSharingClient get() {
        return c(this.f22705a.get());
    }
}
