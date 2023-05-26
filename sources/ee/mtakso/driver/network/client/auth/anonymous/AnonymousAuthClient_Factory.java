package ee.mtakso.driver.network.client.auth.anonymous;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.model.DeviceInfo;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import ee.mtakso.driver.platform.network.store_integrity.StoreIntegrityVerificationResultToRequestMapper;
import eu.bolt.driver.core.time.SystemUptimeSource;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AnonymousAuthClient_Factory implements Factory<AnonymousAuthClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DeviceInfo> f21448a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AnonymousAuthApi> f21449b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<CompositeResponseTransformer> f21450c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<SystemUptimeSource> f21451d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<DriverAuthAnonymousApi> f21452e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<StoreIntegrityVerificationResultToRequestMapper> f21453f;

    public AnonymousAuthClient_Factory(Provider<DeviceInfo> provider, Provider<AnonymousAuthApi> provider2, Provider<CompositeResponseTransformer> provider3, Provider<SystemUptimeSource> provider4, Provider<DriverAuthAnonymousApi> provider5, Provider<StoreIntegrityVerificationResultToRequestMapper> provider6) {
        this.f21448a = provider;
        this.f21449b = provider2;
        this.f21450c = provider3;
        this.f21451d = provider4;
        this.f21452e = provider5;
        this.f21453f = provider6;
    }

    public static AnonymousAuthClient_Factory a(Provider<DeviceInfo> provider, Provider<AnonymousAuthApi> provider2, Provider<CompositeResponseTransformer> provider3, Provider<SystemUptimeSource> provider4, Provider<DriverAuthAnonymousApi> provider5, Provider<StoreIntegrityVerificationResultToRequestMapper> provider6) {
        return new AnonymousAuthClient_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static AnonymousAuthClient c(DeviceInfo deviceInfo, Lazy<AnonymousAuthApi> lazy, CompositeResponseTransformer compositeResponseTransformer, SystemUptimeSource systemUptimeSource, DriverAuthAnonymousApi driverAuthAnonymousApi, StoreIntegrityVerificationResultToRequestMapper storeIntegrityVerificationResultToRequestMapper) {
        return new AnonymousAuthClient(deviceInfo, lazy, compositeResponseTransformer, systemUptimeSource, driverAuthAnonymousApi, storeIntegrityVerificationResultToRequestMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AnonymousAuthClient get() {
        return c(this.f21448a.get(), DoubleCheck.lazy(this.f21449b), this.f21450c.get(), this.f21451d.get(), this.f21452e.get(), this.f21453f.get());
    }
}
