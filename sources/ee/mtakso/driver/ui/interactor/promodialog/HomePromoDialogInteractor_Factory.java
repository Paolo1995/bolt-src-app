package ee.mtakso.driver.ui.interactor.promodialog;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.training.TrainingClient;
import ee.mtakso.driver.onboarding.OnBoardingManager;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverSettingsInMemory;
import ee.mtakso.driver.service.contact.ContactOptionsService;
import ee.mtakso.driver.service.settings.DispatchSettingsManager;
import ee.mtakso.driver.ui.interactor.modaldialog.SingleModalDialogInteractor;
import ee.mtakso.driver.ui.interactor.score.DriverScoreManager;
import eu.bolt.driver.core.permission.PermissionManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class HomePromoDialogInteractor_Factory implements Factory<HomePromoDialogInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f26810a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SingleModalDialogInteractor> f26811b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DispatchSettingsManager> f26812c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<OnBoardingManager> f26813d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<ContactOptionsService> f26814e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<PermissionManager> f26815f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<DriverSettingsInMemory> f26816g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<DriverScoreManager> f26817h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<TrainingClient> f26818i;

    public HomePromoDialogInteractor_Factory(Provider<DriverProvider> provider, Provider<SingleModalDialogInteractor> provider2, Provider<DispatchSettingsManager> provider3, Provider<OnBoardingManager> provider4, Provider<ContactOptionsService> provider5, Provider<PermissionManager> provider6, Provider<DriverSettingsInMemory> provider7, Provider<DriverScoreManager> provider8, Provider<TrainingClient> provider9) {
        this.f26810a = provider;
        this.f26811b = provider2;
        this.f26812c = provider3;
        this.f26813d = provider4;
        this.f26814e = provider5;
        this.f26815f = provider6;
        this.f26816g = provider7;
        this.f26817h = provider8;
        this.f26818i = provider9;
    }

    public static HomePromoDialogInteractor_Factory a(Provider<DriverProvider> provider, Provider<SingleModalDialogInteractor> provider2, Provider<DispatchSettingsManager> provider3, Provider<OnBoardingManager> provider4, Provider<ContactOptionsService> provider5, Provider<PermissionManager> provider6, Provider<DriverSettingsInMemory> provider7, Provider<DriverScoreManager> provider8, Provider<TrainingClient> provider9) {
        return new HomePromoDialogInteractor_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static HomePromoDialogInteractor c(DriverProvider driverProvider, SingleModalDialogInteractor singleModalDialogInteractor, DispatchSettingsManager dispatchSettingsManager, OnBoardingManager onBoardingManager, ContactOptionsService contactOptionsService, PermissionManager permissionManager, DriverSettingsInMemory driverSettingsInMemory, DriverScoreManager driverScoreManager, TrainingClient trainingClient) {
        return new HomePromoDialogInteractor(driverProvider, singleModalDialogInteractor, dispatchSettingsManager, onBoardingManager, contactOptionsService, permissionManager, driverSettingsInMemory, driverScoreManager, trainingClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public HomePromoDialogInteractor get() {
        return c(this.f26810a.get(), this.f26811b.get(), this.f26812c.get(), this.f26813d.get(), this.f26814e.get(), this.f26815f.get(), this.f26816g.get(), this.f26817h.get(), this.f26818i.get());
    }
}
