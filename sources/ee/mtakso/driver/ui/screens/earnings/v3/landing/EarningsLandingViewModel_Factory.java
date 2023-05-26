package ee.mtakso.driver.ui.screens.earnings.v3.landing;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.earnings.EarningsManager;
import ee.mtakso.driver.ui.interactor.modaldialog.BackendModalDialogActionReporterInteractor;
import ee.mtakso.driver.ui.interactor.modaldialog.SingleModalDialogInteractor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class EarningsLandingViewModel_Factory implements Factory<EarningsLandingViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EarningsManager> f29359a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SingleModalDialogInteractor> f29360b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<BackendModalDialogActionReporterInteractor> f29361c;

    public EarningsLandingViewModel_Factory(Provider<EarningsManager> provider, Provider<SingleModalDialogInteractor> provider2, Provider<BackendModalDialogActionReporterInteractor> provider3) {
        this.f29359a = provider;
        this.f29360b = provider2;
        this.f29361c = provider3;
    }

    public static EarningsLandingViewModel_Factory a(Provider<EarningsManager> provider, Provider<SingleModalDialogInteractor> provider2, Provider<BackendModalDialogActionReporterInteractor> provider3) {
        return new EarningsLandingViewModel_Factory(provider, provider2, provider3);
    }

    public static EarningsLandingViewModel c(EarningsManager earningsManager, SingleModalDialogInteractor singleModalDialogInteractor, BackendModalDialogActionReporterInteractor backendModalDialogActionReporterInteractor) {
        return new EarningsLandingViewModel(earningsManager, singleModalDialogInteractor, backendModalDialogActionReporterInteractor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public EarningsLandingViewModel get() {
        return c(this.f29359a.get(), this.f29360b.get(), this.f29361c.get());
    }
}
