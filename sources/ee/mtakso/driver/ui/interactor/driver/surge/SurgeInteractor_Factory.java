package ee.mtakso.driver.ui.interactor.driver.surge;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.service.modules.surge.SurgeManager;
import ee.mtakso.driver.service.settings.DispatchSettingsManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class SurgeInteractor_Factory implements Factory<SurgeInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<SurgeManager> f26553a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DispatchSettingsManager> f26554b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverFeatures> f26555c;

    public SurgeInteractor_Factory(Provider<SurgeManager> provider, Provider<DispatchSettingsManager> provider2, Provider<DriverFeatures> provider3) {
        this.f26553a = provider;
        this.f26554b = provider2;
        this.f26555c = provider3;
    }

    public static SurgeInteractor_Factory a(Provider<SurgeManager> provider, Provider<DispatchSettingsManager> provider2, Provider<DriverFeatures> provider3) {
        return new SurgeInteractor_Factory(provider, provider2, provider3);
    }

    public static SurgeInteractor c(SurgeManager surgeManager, DispatchSettingsManager dispatchSettingsManager, DriverFeatures driverFeatures) {
        return new SurgeInteractor(surgeManager, dispatchSettingsManager, driverFeatures);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SurgeInteractor get() {
        return c(this.f26553a.get(), this.f26554b.get(), this.f26555c.get());
    }
}
