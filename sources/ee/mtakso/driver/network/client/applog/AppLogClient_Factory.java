package ee.mtakso.driver.network.client.applog;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AppLogClient_Factory implements Factory<AppLogClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverAppLogAnonymousApi> f21358a;

    public AppLogClient_Factory(Provider<DriverAppLogAnonymousApi> provider) {
        this.f21358a = provider;
    }

    public static AppLogClient_Factory a(Provider<DriverAppLogAnonymousApi> provider) {
        return new AppLogClient_Factory(provider);
    }

    public static AppLogClient c(Lazy<DriverAppLogAnonymousApi> lazy) {
        return new AppLogClient(lazy);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AppLogClient get() {
        return c(DoubleCheck.lazy(this.f21358a));
    }
}
