package ee.mtakso.driver.ui.common.internet;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.connectivity.NetworkService;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class InternetDataDelegate_Factory implements Factory<InternetDataDelegate> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<NetworkService> f26371a;

    public InternetDataDelegate_Factory(Provider<NetworkService> provider) {
        this.f26371a = provider;
    }

    public static InternetDataDelegate_Factory a(Provider<NetworkService> provider) {
        return new InternetDataDelegate_Factory(provider);
    }

    public static InternetDataDelegate c(NetworkService networkService) {
        return new InternetDataDelegate(networkService);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public InternetDataDelegate get() {
        return c(this.f26371a.get());
    }
}
