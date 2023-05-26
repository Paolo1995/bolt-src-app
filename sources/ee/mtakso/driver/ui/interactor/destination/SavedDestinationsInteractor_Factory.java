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
public final class SavedDestinationsInteractor_Factory implements Factory<SavedDestinationsInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverDestinationsManager> f26436a;

    public SavedDestinationsInteractor_Factory(Provider<DriverDestinationsManager> provider) {
        this.f26436a = provider;
    }

    public static SavedDestinationsInteractor_Factory a(Provider<DriverDestinationsManager> provider) {
        return new SavedDestinationsInteractor_Factory(provider);
    }

    public static SavedDestinationsInteractor c(DriverDestinationsManager driverDestinationsManager) {
        return new SavedDestinationsInteractor(driverDestinationsManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SavedDestinationsInteractor get() {
        return c(this.f26436a.get());
    }
}
