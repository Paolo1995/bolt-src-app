package ee.mtakso.driver.ui.screens.time_limit;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.ui.interactor.WorkTimeInteractor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class WorkTimeViewModel_Factory implements Factory<WorkTimeViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<WorkTimeInteractor> f33487a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverProvider> f33488b;

    public WorkTimeViewModel_Factory(Provider<WorkTimeInteractor> provider, Provider<DriverProvider> provider2) {
        this.f33487a = provider;
        this.f33488b = provider2;
    }

    public static WorkTimeViewModel_Factory a(Provider<WorkTimeInteractor> provider, Provider<DriverProvider> provider2) {
        return new WorkTimeViewModel_Factory(provider, provider2);
    }

    public static WorkTimeViewModel c(WorkTimeInteractor workTimeInteractor, DriverProvider driverProvider) {
        return new WorkTimeViewModel(workTimeInteractor, driverProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WorkTimeViewModel get() {
        return c(this.f33487a.get(), this.f33488b.get());
    }
}
