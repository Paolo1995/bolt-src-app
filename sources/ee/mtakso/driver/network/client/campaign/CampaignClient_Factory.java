package ee.mtakso.driver.network.client.campaign;

import dagger.Lazy;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.ShardApiProvider;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CampaignClient_Factory implements Factory<CampaignClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<CampaignApi> f21611a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ShardApiProvider> f21612b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<CompositeResponseTransformer> f21613c;

    public CampaignClient_Factory(Provider<CampaignApi> provider, Provider<ShardApiProvider> provider2, Provider<CompositeResponseTransformer> provider3) {
        this.f21611a = provider;
        this.f21612b = provider2;
        this.f21613c = provider3;
    }

    public static CampaignClient_Factory a(Provider<CampaignApi> provider, Provider<ShardApiProvider> provider2, Provider<CompositeResponseTransformer> provider3) {
        return new CampaignClient_Factory(provider, provider2, provider3);
    }

    public static CampaignClient c(Lazy<CampaignApi> lazy, ShardApiProvider shardApiProvider, CompositeResponseTransformer compositeResponseTransformer) {
        return new CampaignClient(lazy, shardApiProvider, compositeResponseTransformer);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CampaignClient get() {
        return c(DoubleCheck.lazy(this.f21611a), this.f21612b.get(), this.f21613c.get());
    }
}
