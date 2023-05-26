package ee.mtakso.driver.ui.screens.order.arrived.raterider;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class RateRiderFragment_Factory implements Factory<RateRiderFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f31206a;

    public RateRiderFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f31206a = provider;
    }

    public static RateRiderFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new RateRiderFragment_Factory(provider);
    }

    public static RateRiderFragment c(BaseUiDependencies baseUiDependencies) {
        return new RateRiderFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RateRiderFragment get() {
        return c(this.f31206a.get());
    }
}
