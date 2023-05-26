package ee.mtakso.driver.log.strategy;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CompositeWatcher_Factory implements Factory<CompositeWatcher> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f21134a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DidNotRespondStrategy> f21135b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OrderStateStrategy> f21136c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverWrongStateStrategy> f21137d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<OrderWrongStateStrategy> f21138e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<LocationStrategy> f21139f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<ActivityLifecycleStrategy> f21140g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<DriverOfflineDetectionStrategy> f21141h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<WebViewStrategy> f21142i;

    public CompositeWatcher_Factory(Provider<DriverProvider> provider, Provider<DidNotRespondStrategy> provider2, Provider<OrderStateStrategy> provider3, Provider<DriverWrongStateStrategy> provider4, Provider<OrderWrongStateStrategy> provider5, Provider<LocationStrategy> provider6, Provider<ActivityLifecycleStrategy> provider7, Provider<DriverOfflineDetectionStrategy> provider8, Provider<WebViewStrategy> provider9) {
        this.f21134a = provider;
        this.f21135b = provider2;
        this.f21136c = provider3;
        this.f21137d = provider4;
        this.f21138e = provider5;
        this.f21139f = provider6;
        this.f21140g = provider7;
        this.f21141h = provider8;
        this.f21142i = provider9;
    }

    public static CompositeWatcher_Factory a(Provider<DriverProvider> provider, Provider<DidNotRespondStrategy> provider2, Provider<OrderStateStrategy> provider3, Provider<DriverWrongStateStrategy> provider4, Provider<OrderWrongStateStrategy> provider5, Provider<LocationStrategy> provider6, Provider<ActivityLifecycleStrategy> provider7, Provider<DriverOfflineDetectionStrategy> provider8, Provider<WebViewStrategy> provider9) {
        return new CompositeWatcher_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static CompositeWatcher c(DriverProvider driverProvider, DidNotRespondStrategy didNotRespondStrategy, OrderStateStrategy orderStateStrategy, DriverWrongStateStrategy driverWrongStateStrategy, OrderWrongStateStrategy orderWrongStateStrategy, LocationStrategy locationStrategy, ActivityLifecycleStrategy activityLifecycleStrategy, DriverOfflineDetectionStrategy driverOfflineDetectionStrategy, WebViewStrategy webViewStrategy) {
        return new CompositeWatcher(driverProvider, didNotRespondStrategy, orderStateStrategy, driverWrongStateStrategy, orderWrongStateStrategy, locationStrategy, activityLifecycleStrategy, driverOfflineDetectionStrategy, webViewStrategy);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CompositeWatcher get() {
        return c(this.f21134a.get(), this.f21135b.get(), this.f21136c.get(), this.f21137d.get(), this.f21138e.get(), this.f21139f.get(), this.f21140g.get(), this.f21141h.get(), this.f21142i.get());
    }
}
