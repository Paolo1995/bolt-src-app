package ee.mtakso.driver.service.modules.polling;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.auth.AuthManager;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class InactivePollingErrorHandler_Factory implements Factory<InactivePollingErrorHandler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<AuthManager> f25098a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RoutingManager> f25099b;

    public InactivePollingErrorHandler_Factory(Provider<AuthManager> provider, Provider<RoutingManager> provider2) {
        this.f25098a = provider;
        this.f25099b = provider2;
    }

    public static InactivePollingErrorHandler_Factory a(Provider<AuthManager> provider, Provider<RoutingManager> provider2) {
        return new InactivePollingErrorHandler_Factory(provider, provider2);
    }

    public static InactivePollingErrorHandler c(AuthManager authManager, RoutingManager routingManager) {
        return new InactivePollingErrorHandler(authManager, routingManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public InactivePollingErrorHandler get() {
        return c(this.f25098a.get(), this.f25099b.get());
    }
}
