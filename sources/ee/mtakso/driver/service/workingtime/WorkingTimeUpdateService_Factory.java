package ee.mtakso.driver.service.workingtime;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.status.DriverStatusProvider;
import javax.inject.Provider;

@ScopeMetadata("ee.mtakso.driver.di.authorised.AuthorisedScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class WorkingTimeUpdateService_Factory implements Factory<WorkingTimeUpdateService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverStatusProvider> f26210a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<WorkingTimeManager> f26211b;

    public WorkingTimeUpdateService_Factory(Provider<DriverStatusProvider> provider, Provider<WorkingTimeManager> provider2) {
        this.f26210a = provider;
        this.f26211b = provider2;
    }

    public static WorkingTimeUpdateService_Factory a(Provider<DriverStatusProvider> provider, Provider<WorkingTimeManager> provider2) {
        return new WorkingTimeUpdateService_Factory(provider, provider2);
    }

    public static WorkingTimeUpdateService c(DriverStatusProvider driverStatusProvider, WorkingTimeManager workingTimeManager) {
        return new WorkingTimeUpdateService(driverStatusProvider, workingTimeManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WorkingTimeUpdateService get() {
        return c(this.f26210a.get(), this.f26211b.get());
    }
}
