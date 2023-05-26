package ee.mtakso.driver.ui.screens.earnings.v3.breakdown;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EarningsBreakdownStubFactory_Factory implements Factory<EarningsBreakdownStubFactory> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final EarningsBreakdownStubFactory_Factory f28945a = new EarningsBreakdownStubFactory_Factory();

        private InstanceHolder() {
        }
    }

    public static EarningsBreakdownStubFactory_Factory a() {
        return InstanceHolder.f28945a;
    }

    public static EarningsBreakdownStubFactory c() {
        return new EarningsBreakdownStubFactory();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsBreakdownStubFactory get() {
        return c();
    }
}
