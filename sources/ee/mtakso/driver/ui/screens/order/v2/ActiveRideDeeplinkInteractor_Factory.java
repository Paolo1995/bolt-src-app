package ee.mtakso.driver.ui.screens.order.v2;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.deeplink.DeepLinkManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ActiveRideDeeplinkInteractor_Factory implements Factory<ActiveRideDeeplinkInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DeepLinkManager> f31897a;

    public ActiveRideDeeplinkInteractor_Factory(Provider<DeepLinkManager> provider) {
        this.f31897a = provider;
    }

    public static ActiveRideDeeplinkInteractor_Factory a(Provider<DeepLinkManager> provider) {
        return new ActiveRideDeeplinkInteractor_Factory(provider);
    }

    public static ActiveRideDeeplinkInteractor c(DeepLinkManager deepLinkManager) {
        return new ActiveRideDeeplinkInteractor(deepLinkManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ActiveRideDeeplinkInteractor get() {
        return c(this.f31897a.get());
    }
}
