package ee.mtakso.driver.network.client.order;

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
public final class OrderClient_Factory implements Factory<OrderClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ShardApiProvider> f22418a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<CompositeResponseTransformer> f22419b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ResponseErrorProcessor> f22420c;

    public OrderClient_Factory(Provider<ShardApiProvider> provider, Provider<CompositeResponseTransformer> provider2, Provider<ResponseErrorProcessor> provider3) {
        this.f22418a = provider;
        this.f22419b = provider2;
        this.f22420c = provider3;
    }

    public static OrderClient_Factory a(Provider<ShardApiProvider> provider, Provider<CompositeResponseTransformer> provider2, Provider<ResponseErrorProcessor> provider3) {
        return new OrderClient_Factory(provider, provider2, provider3);
    }

    public static OrderClient c(ShardApiProvider shardApiProvider, CompositeResponseTransformer compositeResponseTransformer, ResponseErrorProcessor responseErrorProcessor) {
        return new OrderClient(shardApiProvider, compositeResponseTransformer, responseErrorProcessor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderClient get() {
        return c(this.f22418a.get(), this.f22419b.get(), this.f22420c.get());
    }
}
