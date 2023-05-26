package ee.mtakso.driver.ui.screens.order.ordermenudialog;

import androidx.fragment.app.FragmentFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.modules.order.v2.OrderTracker;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverInfoBlockMapper;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OrderMenuDialogFragment_Factory implements Factory<OrderMenuDialogFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f31571a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<FragmentFactory> f31572b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<OrderMenuDialogMapper> f31573c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<OrderTracker> f31574d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<DriverInfoBlockMapper> f31575e;

    public OrderMenuDialogFragment_Factory(Provider<DriverProvider> provider, Provider<FragmentFactory> provider2, Provider<OrderMenuDialogMapper> provider3, Provider<OrderTracker> provider4, Provider<DriverInfoBlockMapper> provider5) {
        this.f31571a = provider;
        this.f31572b = provider2;
        this.f31573c = provider3;
        this.f31574d = provider4;
        this.f31575e = provider5;
    }

    public static OrderMenuDialogFragment_Factory a(Provider<DriverProvider> provider, Provider<FragmentFactory> provider2, Provider<OrderMenuDialogMapper> provider3, Provider<OrderTracker> provider4, Provider<DriverInfoBlockMapper> provider5) {
        return new OrderMenuDialogFragment_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static OrderMenuDialogFragment c(DriverProvider driverProvider, FragmentFactory fragmentFactory, OrderMenuDialogMapper orderMenuDialogMapper, OrderTracker orderTracker, DriverInfoBlockMapper driverInfoBlockMapper) {
        return new OrderMenuDialogFragment(driverProvider, fragmentFactory, orderMenuDialogMapper, orderTracker, driverInfoBlockMapper);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderMenuDialogFragment get() {
        return c(this.f31571a.get(), this.f31572b.get(), this.f31573c.get(), this.f31574d.get(), this.f31575e.get());
    }
}
