package ee.mtakso.driver.ui.screens.settings.pricing;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class PriceFormat_Factory implements Factory<PriceFormat> {

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final PriceFormat_Factory f33246a = new PriceFormat_Factory();

        private InstanceHolder() {
        }
    }

    public static PriceFormat_Factory a() {
        return InstanceHolder.f33246a;
    }

    public static PriceFormat c() {
        return new PriceFormat();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PriceFormat get() {
        return c();
    }
}
