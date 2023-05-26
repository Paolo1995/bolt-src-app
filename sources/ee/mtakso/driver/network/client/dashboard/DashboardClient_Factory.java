package ee.mtakso.driver.network.client.dashboard;

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
public final class DashboardClient_Factory implements Factory<DashboardClient> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ShardApiProvider> f21822a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ResponseErrorProcessor> f21823b;

    public DashboardClient_Factory(Provider<ShardApiProvider> provider, Provider<ResponseErrorProcessor> provider2) {
        this.f21822a = provider;
        this.f21823b = provider2;
    }

    public static DashboardClient_Factory a(Provider<ShardApiProvider> provider, Provider<ResponseErrorProcessor> provider2) {
        return new DashboardClient_Factory(provider, provider2);
    }

    public static DashboardClient c(ShardApiProvider shardApiProvider, ResponseErrorProcessor responseErrorProcessor) {
        return new DashboardClient(shardApiProvider, responseErrorProcessor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DashboardClient get() {
        return c(this.f21822a.get(), this.f21823b.get());
    }
}
