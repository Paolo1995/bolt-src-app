package ee.mtakso.driver.ui.interactor.destination;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.driverdestinations.DriverDestinationsManager;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DeleteDestinationInteractor_Factory implements Factory<DeleteDestinationInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverDestinationsManager> f26431a;

    public DeleteDestinationInteractor_Factory(Provider<DriverDestinationsManager> provider) {
        this.f26431a = provider;
    }

    public static DeleteDestinationInteractor_Factory a(Provider<DriverDestinationsManager> provider) {
        return new DeleteDestinationInteractor_Factory(provider);
    }

    public static DeleteDestinationInteractor c(DriverDestinationsManager driverDestinationsManager) {
        return new DeleteDestinationInteractor(driverDestinationsManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DeleteDestinationInteractor get() {
        return c(this.f26431a.get());
    }
}
