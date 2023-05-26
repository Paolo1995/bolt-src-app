package ee.mtakso.driver.ui.screens.earnings.v3.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EarningsBalanceStateTypeMapper_Factory implements Factory<EarningsBalanceStateTypeMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final EarningsBalanceStateTypeMapper_Factory f29051a = new EarningsBalanceStateTypeMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static EarningsBalanceStateTypeMapper_Factory a() {
        return InstanceHolder.f29051a;
    }

    public static EarningsBalanceStateTypeMapper c() {
        return new EarningsBalanceStateTypeMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsBalanceStateTypeMapper get() {
        return c();
    }
}
