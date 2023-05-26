package ee.mtakso.driver.ui.interactor.driver;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import ee.mtakso.driver.service.modules.surge.SurgeManager;
import ee.mtakso.driver.service.rating.app.AppRatingManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class MakeDriverInactiveInteractor_Factory implements Factory<MakeDriverInactiveInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverStatusProvider> f26495a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverManager> f26496b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverProvider> f26497c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverDestinationsManager> f26498d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<SurgeManager> f26499e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<AppRatingManager> f26500f;

    public MakeDriverInactiveInteractor_Factory(Provider<DriverStatusProvider> provider, Provider<DriverManager> provider2, Provider<DriverProvider> provider3, Provider<DriverDestinationsManager> provider4, Provider<SurgeManager> provider5, Provider<AppRatingManager> provider6) {
        this.f26495a = provider;
        this.f26496b = provider2;
        this.f26497c = provider3;
        this.f26498d = provider4;
        this.f26499e = provider5;
        this.f26500f = provider6;
    }

    public static MakeDriverInactiveInteractor_Factory a(Provider<DriverStatusProvider> provider, Provider<DriverManager> provider2, Provider<DriverProvider> provider3, Provider<DriverDestinationsManager> provider4, Provider<SurgeManager> provider5, Provider<AppRatingManager> provider6) {
        return new MakeDriverInactiveInteractor_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static MakeDriverInactiveInteractor c(DriverStatusProvider driverStatusProvider, DriverManager driverManager, DriverProvider driverProvider, DriverDestinationsManager driverDestinationsManager, SurgeManager surgeManager, AppRatingManager appRatingManager) {
        return new MakeDriverInactiveInteractor(driverStatusProvider, driverManager, driverProvider, driverDestinationsManager, surgeManager, appRatingManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public MakeDriverInactiveInteractor get() {
        return c(this.f26495a.get(), this.f26496b.get(), this.f26497c.get(), this.f26498d.get(), this.f26499e.get(), this.f26500f.get());
    }
}
