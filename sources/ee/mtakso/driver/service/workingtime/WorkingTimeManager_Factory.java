package ee.mtakso.driver.service.workingtime;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.work_time.DriverWorkTimeApi;
import ee.mtakso.driver.param.DriverProvider;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class WorkingTimeManager_Factory implements Factory<WorkingTimeManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f26203a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverWorkTimeApi> f26204b;

    public WorkingTimeManager_Factory(Provider<DriverProvider> provider, Provider<DriverWorkTimeApi> provider2) {
        this.f26203a = provider;
        this.f26204b = provider2;
    }

    public static WorkingTimeManager_Factory a(Provider<DriverProvider> provider, Provider<DriverWorkTimeApi> provider2) {
        return new WorkingTimeManager_Factory(provider, provider2);
    }

    public static WorkingTimeManager c(DriverProvider driverProvider, DriverWorkTimeApi driverWorkTimeApi) {
        return new WorkingTimeManager(driverProvider, driverWorkTimeApi);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WorkingTimeManager get() {
        return c(this.f26203a.get(), this.f26204b.get());
    }
}
