package ee.mtakso.driver.ui.screens.earnings.v3.landing;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.screens.home.v3.delegate.DeeplinkDelegate;
import ee.mtakso.driver.ui.screens.modal.ModalDelegate;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class EarningsLandingFragment_Factory implements Factory<EarningsLandingFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f29326a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DeeplinkDelegate> f29327b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<EarningsLandingMapper> f29328c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverFeatures> f29329d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<ModalDelegate> f29330e;

    public EarningsLandingFragment_Factory(Provider<BaseUiDependencies> provider, Provider<DeeplinkDelegate> provider2, Provider<EarningsLandingMapper> provider3, Provider<DriverFeatures> provider4, Provider<ModalDelegate> provider5) {
        this.f29326a = provider;
        this.f29327b = provider2;
        this.f29328c = provider3;
        this.f29329d = provider4;
        this.f29330e = provider5;
    }

    public static EarningsLandingFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<DeeplinkDelegate> provider2, Provider<EarningsLandingMapper> provider3, Provider<DriverFeatures> provider4, Provider<ModalDelegate> provider5) {
        return new EarningsLandingFragment_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static EarningsLandingFragment c(BaseUiDependencies baseUiDependencies, DeeplinkDelegate deeplinkDelegate, EarningsLandingMapper earningsLandingMapper, DriverFeatures driverFeatures, ModalDelegate modalDelegate) {
        return new EarningsLandingFragment(baseUiDependencies, deeplinkDelegate, earningsLandingMapper, driverFeatures, modalDelegate);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsLandingFragment get() {
        return c(this.f29326a.get(), this.f29327b.get(), this.f29328c.get(), this.f29329d.get(), this.f29330e.get());
    }
}
