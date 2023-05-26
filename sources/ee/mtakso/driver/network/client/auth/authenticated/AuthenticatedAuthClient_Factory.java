package ee.mtakso.driver.network.client.auth.authenticated;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.model.DeviceInfo;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import ee.mtakso.driver.param.DeviceSettings;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AuthenticatedAuthClient_Factory implements Factory<AuthenticatedAuthClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DeviceInfo> f21527a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DeviceSettings> f21528b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AuthenticatedAuthApi> f21529c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<CompositeResponseTransformer> f21530d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<ResponseErrorProcessor> f21531e;

    public AuthenticatedAuthClient_Factory(Provider<DeviceInfo> provider, Provider<DeviceSettings> provider2, Provider<AuthenticatedAuthApi> provider3, Provider<CompositeResponseTransformer> provider4, Provider<ResponseErrorProcessor> provider5) {
        this.f21527a = provider;
        this.f21528b = provider2;
        this.f21529c = provider3;
        this.f21530d = provider4;
        this.f21531e = provider5;
    }

    public static AuthenticatedAuthClient_Factory a(Provider<DeviceInfo> provider, Provider<DeviceSettings> provider2, Provider<AuthenticatedAuthApi> provider3, Provider<CompositeResponseTransformer> provider4, Provider<ResponseErrorProcessor> provider5) {
        return new AuthenticatedAuthClient_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AuthenticatedAuthClient c(DeviceInfo deviceInfo, DeviceSettings deviceSettings, Lazy<AuthenticatedAuthApi> lazy, CompositeResponseTransformer compositeResponseTransformer, ResponseErrorProcessor responseErrorProcessor) {
        return new AuthenticatedAuthClient(deviceInfo, deviceSettings, lazy, compositeResponseTransformer, responseErrorProcessor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public AuthenticatedAuthClient get() {
        return c(this.f21527a.get(), this.f21528b.get(), DoubleCheck.lazy(this.f21529c), this.f21530d.get(), this.f21531e.get());
    }
}
