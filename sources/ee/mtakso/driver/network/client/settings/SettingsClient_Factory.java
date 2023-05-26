package ee.mtakso.driver.network.client.settings;

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
public final class SettingsClient_Factory implements Factory<SettingsClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ShardApiProvider> f22822a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ResponseErrorProcessor> f22823b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<CompositeResponseTransformer> f22824c;

    public SettingsClient_Factory(Provider<ShardApiProvider> provider, Provider<ResponseErrorProcessor> provider2, Provider<CompositeResponseTransformer> provider3) {
        this.f22822a = provider;
        this.f22823b = provider2;
        this.f22824c = provider3;
    }

    public static SettingsClient_Factory a(Provider<ShardApiProvider> provider, Provider<ResponseErrorProcessor> provider2, Provider<CompositeResponseTransformer> provider3) {
        return new SettingsClient_Factory(provider, provider2, provider3);
    }

    public static SettingsClient c(ShardApiProvider shardApiProvider, ResponseErrorProcessor responseErrorProcessor, CompositeResponseTransformer compositeResponseTransformer) {
        return new SettingsClient(shardApiProvider, responseErrorProcessor, compositeResponseTransformer);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SettingsClient get() {
        return c(this.f22822a.get(), this.f22823b.get(), this.f22824c.get());
    }
}
