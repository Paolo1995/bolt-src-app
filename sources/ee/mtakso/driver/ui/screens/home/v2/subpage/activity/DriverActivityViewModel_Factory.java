package ee.mtakso.driver.ui.screens.home.v2.subpage.activity;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.ui.interactor.activity.DriverActivityInteractor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverActivityViewModel_Factory implements Factory<DriverActivityViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverActivityInteractor> f29651a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f29652b;

    public DriverActivityViewModel_Factory(Provider<DriverActivityInteractor> provider, Provider<DriverProvider> provider2) {
        this.f29651a = provider;
        this.f29652b = provider2;
    }

    public static DriverActivityViewModel_Factory a(Provider<DriverActivityInteractor> provider, Provider<DriverProvider> provider2) {
        return new DriverActivityViewModel_Factory(provider, provider2);
    }

    public static DriverActivityViewModel c(DriverActivityInteractor driverActivityInteractor, DriverProvider driverProvider) {
        return new DriverActivityViewModel(driverActivityInteractor, driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverActivityViewModel get() {
        return c(this.f29651a.get(), this.f29652b.get());
    }
}
