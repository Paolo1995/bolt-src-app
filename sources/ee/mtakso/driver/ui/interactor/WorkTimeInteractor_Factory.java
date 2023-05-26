package ee.mtakso.driver.ui.interactor;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.workingtime.WorkingTimeManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class WorkTimeInteractor_Factory implements Factory<WorkTimeInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<WorkingTimeManager> f26413a;

    public WorkTimeInteractor_Factory(Provider<WorkingTimeManager> provider) {
        this.f26413a = provider;
    }

    public static WorkTimeInteractor_Factory a(Provider<WorkingTimeManager> provider) {
        return new WorkTimeInteractor_Factory(provider);
    }

    public static WorkTimeInteractor c(WorkingTimeManager workingTimeManager) {
        return new WorkTimeInteractor(workingTimeManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WorkTimeInteractor get() {
        return c(this.f26413a.get());
    }
}
