package ee.mtakso.driver.ui.interactor.driver;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.fifo.FifoQueueManager;
import ee.mtakso.driver.service.modules.map.MapsConfigsService;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class FifoQueueMapInteractor_Factory implements Factory<FifoQueueMapInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MapsConfigsService> f26480a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<FifoQueueManager> f26481b;

    public FifoQueueMapInteractor_Factory(Provider<MapsConfigsService> provider, Provider<FifoQueueManager> provider2) {
        this.f26480a = provider;
        this.f26481b = provider2;
    }

    public static FifoQueueMapInteractor_Factory a(Provider<MapsConfigsService> provider, Provider<FifoQueueManager> provider2) {
        return new FifoQueueMapInteractor_Factory(provider, provider2);
    }

    public static FifoQueueMapInteractor c(MapsConfigsService mapsConfigsService, FifoQueueManager fifoQueueManager) {
        return new FifoQueueMapInteractor(mapsConfigsService, fifoQueueManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public FifoQueueMapInteractor get() {
        return c(this.f26480a.get(), this.f26481b.get());
    }
}
