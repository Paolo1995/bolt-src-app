package ee.mtakso.driver.service.order.details;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class OrderTryAgainManager_Factory implements Factory<OrderTryAgainManager> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final OrderTryAgainManager_Factory f25472a = new OrderTryAgainManager_Factory();

        private InstanceHolder() {
        }
    }

    public static OrderTryAgainManager_Factory a() {
        return InstanceHolder.f25472a;
    }

    public static OrderTryAgainManager c() {
        return new OrderTryAgainManager();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OrderTryAgainManager get() {
        return c();
    }
}
