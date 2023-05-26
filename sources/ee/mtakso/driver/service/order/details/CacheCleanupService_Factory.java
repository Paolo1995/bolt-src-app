package ee.mtakso.driver.service.order.details;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CacheCleanupService_Factory implements Factory<CacheCleanupService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OrdersCache> f25414a;

    public CacheCleanupService_Factory(Provider<OrdersCache> provider) {
        this.f25414a = provider;
    }

    public static CacheCleanupService_Factory a(Provider<OrdersCache> provider) {
        return new CacheCleanupService_Factory(provider);
    }

    public static CacheCleanupService c(OrdersCache ordersCache) {
        return new CacheCleanupService(ordersCache);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CacheCleanupService get() {
        return c(this.f25414a.get());
    }
}
