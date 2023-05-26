package ee.mtakso.driver.ui.interactor.modaldialog;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.fifo.FifoQueueManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class FifoModalInteractor_Factory implements Factory<FifoModalInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<FifoQueueManager> f26665a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SingleModalDialogInteractor> f26666b;

    public FifoModalInteractor_Factory(Provider<FifoQueueManager> provider, Provider<SingleModalDialogInteractor> provider2) {
        this.f26665a = provider;
        this.f26666b = provider2;
    }

    public static FifoModalInteractor_Factory a(Provider<FifoQueueManager> provider, Provider<SingleModalDialogInteractor> provider2) {
        return new FifoModalInteractor_Factory(provider, provider2);
    }

    public static FifoModalInteractor c(FifoQueueManager fifoQueueManager, SingleModalDialogInteractor singleModalDialogInteractor) {
        return new FifoModalInteractor(fifoQueueManager, singleModalDialogInteractor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public FifoModalInteractor get() {
        return c(this.f26665a.get(), this.f26666b.get());
    }
}
