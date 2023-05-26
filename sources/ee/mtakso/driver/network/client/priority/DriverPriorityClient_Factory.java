package ee.mtakso.driver.network.client.priority;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ShardApiProvider;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverPriorityClient_Factory implements Factory<DriverPriorityClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ShardApiProvider> f22674a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ResponseErrorProcessor> f22675b;

    public DriverPriorityClient_Factory(Provider<ShardApiProvider> provider, Provider<ResponseErrorProcessor> provider2) {
        this.f22674a = provider;
        this.f22675b = provider2;
    }

    public static DriverPriorityClient_Factory a(Provider<ShardApiProvider> provider, Provider<ResponseErrorProcessor> provider2) {
        return new DriverPriorityClient_Factory(provider, provider2);
    }

    public static DriverPriorityClient c(ShardApiProvider shardApiProvider, ResponseErrorProcessor responseErrorProcessor) {
        return new DriverPriorityClient(shardApiProvider, responseErrorProcessor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverPriorityClient get() {
        return c(this.f22674a.get(), this.f22675b.get());
    }
}
