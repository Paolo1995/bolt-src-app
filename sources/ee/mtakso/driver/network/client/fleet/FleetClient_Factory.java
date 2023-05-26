package ee.mtakso.driver.network.client.fleet;

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
public final class FleetClient_Factory implements Factory<FleetClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ShardApiProvider> f22215a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ResponseErrorProcessor> f22216b;

    public FleetClient_Factory(Provider<ShardApiProvider> provider, Provider<ResponseErrorProcessor> provider2) {
        this.f22215a = provider;
        this.f22216b = provider2;
    }

    public static FleetClient_Factory a(Provider<ShardApiProvider> provider, Provider<ResponseErrorProcessor> provider2) {
        return new FleetClient_Factory(provider, provider2);
    }

    public static FleetClient c(ShardApiProvider shardApiProvider, ResponseErrorProcessor responseErrorProcessor) {
        return new FleetClient(shardApiProvider, responseErrorProcessor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public FleetClient get() {
        return c(this.f22215a.get(), this.f22216b.get());
    }
}
