package ee.mtakso.driver.ui.interactor.driver;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.WorkDistanceDelegate;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import ee.mtakso.driver.service.modules.fifo.FifoQueueManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class WorkRadiusInteractor_Factory implements Factory<WorkRadiusInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverProvider> f26526a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<WorkDistanceDelegate> f26527b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverDestinationsManager> f26528c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<FifoQueueManager> f26529d;

    public WorkRadiusInteractor_Factory(Provider<DriverProvider> provider, Provider<WorkDistanceDelegate> provider2, Provider<DriverDestinationsManager> provider3, Provider<FifoQueueManager> provider4) {
        this.f26526a = provider;
        this.f26527b = provider2;
        this.f26528c = provider3;
        this.f26529d = provider4;
    }

    public static WorkRadiusInteractor_Factory a(Provider<DriverProvider> provider, Provider<WorkDistanceDelegate> provider2, Provider<DriverDestinationsManager> provider3, Provider<FifoQueueManager> provider4) {
        return new WorkRadiusInteractor_Factory(provider, provider2, provider3, provider4);
    }

    public static WorkRadiusInteractor c(DriverProvider driverProvider, WorkDistanceDelegate workDistanceDelegate, DriverDestinationsManager driverDestinationsManager, FifoQueueManager fifoQueueManager) {
        return new WorkRadiusInteractor(driverProvider, workDistanceDelegate, driverDestinationsManager, fifoQueueManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WorkRadiusInteractor get() {
        return c(this.f26526a.get(), this.f26527b.get(), this.f26528c.get(), this.f26529d.get());
    }
}
