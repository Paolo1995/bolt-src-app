package ee.mtakso.driver.network.client.driver;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ShardApiProvider;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import ee.mtakso.driver.network.response.ResponseErrorProcessor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverClient_Factory implements Factory<DriverClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ShardApiProvider> f21906a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CompositeResponseTransformer> f21907b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ResponseErrorProcessor> f21908c;

    public DriverClient_Factory(Provider<ShardApiProvider> provider, Provider<CompositeResponseTransformer> provider2, Provider<ResponseErrorProcessor> provider3) {
        this.f21906a = provider;
        this.f21907b = provider2;
        this.f21908c = provider3;
    }

    public static DriverClient_Factory a(Provider<ShardApiProvider> provider, Provider<CompositeResponseTransformer> provider2, Provider<ResponseErrorProcessor> provider3) {
        return new DriverClient_Factory(provider, provider2, provider3);
    }

    public static DriverClient c(ShardApiProvider shardApiProvider, CompositeResponseTransformer compositeResponseTransformer, ResponseErrorProcessor responseErrorProcessor) {
        return new DriverClient(shardApiProvider, compositeResponseTransformer, responseErrorProcessor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverClient get() {
        return c(this.f21906a.get(), this.f21907b.get(), this.f21908c.get());
    }
}
