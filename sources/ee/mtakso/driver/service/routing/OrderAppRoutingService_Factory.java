package ee.mtakso.driver.service.routing;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.utils.BackgroundManager;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OrderAppRoutingService_Factory implements Factory<OrderAppRoutingService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BackgroundManager> f25899a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<OrderProvider> f25900b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Context> f25901c;

    public OrderAppRoutingService_Factory(Provider<BackgroundManager> provider, Provider<OrderProvider> provider2, Provider<Context> provider3) {
        this.f25899a = provider;
        this.f25900b = provider2;
        this.f25901c = provider3;
    }

    public static OrderAppRoutingService_Factory a(Provider<BackgroundManager> provider, Provider<OrderProvider> provider2, Provider<Context> provider3) {
        return new OrderAppRoutingService_Factory(provider, provider2, provider3);
    }

    public static OrderAppRoutingService c(BackgroundManager backgroundManager, OrderProvider orderProvider, Context context) {
        return new OrderAppRoutingService(backgroundManager, orderProvider, context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderAppRoutingService get() {
        return c(this.f25899a.get(), this.f25900b.get(), this.f25901c.get());
    }
}
