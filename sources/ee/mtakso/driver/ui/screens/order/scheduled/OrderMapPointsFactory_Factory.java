package ee.mtakso.driver.ui.screens.order.scheduled;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OrderMapPointsFactory_Factory implements Factory<OrderMapPointsFactory> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final OrderMapPointsFactory_Factory f31642a = new OrderMapPointsFactory_Factory();

        private InstanceHolder() {
        }
    }

    public static OrderMapPointsFactory_Factory a() {
        return InstanceHolder.f31642a;
    }

    public static OrderMapPointsFactory c() {
        return new OrderMapPointsFactory();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderMapPointsFactory get() {
        return c();
    }
}
