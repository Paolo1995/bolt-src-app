package ee.mtakso.driver.ui.screens.earnings.v3.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CurrencyValueFormat_Factory implements Factory<CurrencyValueFormat> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final CurrencyValueFormat_Factory f29018a = new CurrencyValueFormat_Factory();

        private InstanceHolder() {
        }
    }

    public static CurrencyValueFormat_Factory a() {
        return InstanceHolder.f29018a;
    }

    public static CurrencyValueFormat c() {
        return new CurrencyValueFormat();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CurrencyValueFormat get() {
        return c();
    }
}
