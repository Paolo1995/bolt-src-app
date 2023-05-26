package ee.mtakso.driver.ui.screens.order.scheduled;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ScheduledOrderButtonAppearanceMapper_Factory implements Factory<ScheduledOrderButtonAppearanceMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final ScheduledOrderButtonAppearanceMapper_Factory f31653a = new ScheduledOrderButtonAppearanceMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static ScheduledOrderButtonAppearanceMapper_Factory a() {
        return InstanceHolder.f31653a;
    }

    public static ScheduledOrderButtonAppearanceMapper c() {
        return new ScheduledOrderButtonAppearanceMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ScheduledOrderButtonAppearanceMapper get() {
        return c();
    }
}
