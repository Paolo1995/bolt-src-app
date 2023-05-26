package ee.mtakso.driver.network.client.device;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DeviceInfoClient_Factory implements Factory<DeviceInfoClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DeviceInfoApi> f21872a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ResponseErrorProcessor> f21873b;

    public DeviceInfoClient_Factory(Provider<DeviceInfoApi> provider, Provider<ResponseErrorProcessor> provider2) {
        this.f21872a = provider;
        this.f21873b = provider2;
    }

    public static DeviceInfoClient_Factory a(Provider<DeviceInfoApi> provider, Provider<ResponseErrorProcessor> provider2) {
        return new DeviceInfoClient_Factory(provider, provider2);
    }

    public static DeviceInfoClient c(Lazy<DeviceInfoApi> lazy, ResponseErrorProcessor responseErrorProcessor) {
        return new DeviceInfoClient(lazy, responseErrorProcessor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DeviceInfoClient get() {
        return c(DoubleCheck.lazy(this.f21872a), this.f21873b.get());
    }
}
