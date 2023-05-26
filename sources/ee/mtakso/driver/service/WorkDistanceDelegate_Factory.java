package ee.mtakso.driver.service;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class WorkDistanceDelegate_Factory implements Factory<WorkDistanceDelegate> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f23423a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PollerSource> f23424b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverClient> f23425c;

    public WorkDistanceDelegate_Factory(Provider<DriverProvider> provider, Provider<PollerSource> provider2, Provider<DriverClient> provider3) {
        this.f23423a = provider;
        this.f23424b = provider2;
        this.f23425c = provider3;
    }

    public static WorkDistanceDelegate_Factory a(Provider<DriverProvider> provider, Provider<PollerSource> provider2, Provider<DriverClient> provider3) {
        return new WorkDistanceDelegate_Factory(provider, provider2, provider3);
    }

    public static WorkDistanceDelegate c(DriverProvider driverProvider, PollerSource pollerSource, DriverClient driverClient) {
        return new WorkDistanceDelegate(driverProvider, pollerSource, driverClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WorkDistanceDelegate get() {
        return c(this.f23423a.get(), this.f23424b.get(), this.f23425c.get());
    }
}
