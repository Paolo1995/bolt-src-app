package ee.mtakso.driver.service.order;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ScheduledOrderProvider_Factory implements Factory<ScheduledOrderProvider> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final ScheduledOrderProvider_Factory f25391a = new ScheduledOrderProvider_Factory();

        private InstanceHolder() {
        }
    }

    public static ScheduledOrderProvider_Factory a() {
        return InstanceHolder.f25391a;
    }

    public static ScheduledOrderProvider c() {
        return new ScheduledOrderProvider();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ScheduledOrderProvider get() {
        return c();
    }
}
