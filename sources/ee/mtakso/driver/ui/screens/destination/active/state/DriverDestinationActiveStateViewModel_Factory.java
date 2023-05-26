package ee.mtakso.driver.ui.screens.destination.active.state;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.interactor.destination.DeactivateDestinationInteractor;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverDestinationActiveStateViewModel_Factory implements Factory<DriverDestinationActiveStateViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DeactivateDestinationInteractor> f28187a;

    public DriverDestinationActiveStateViewModel_Factory(Provider<DeactivateDestinationInteractor> provider) {
        this.f28187a = provider;
    }

    public static DriverDestinationActiveStateViewModel_Factory a(Provider<DeactivateDestinationInteractor> provider) {
        return new DriverDestinationActiveStateViewModel_Factory(provider);
    }

    public static DriverDestinationActiveStateViewModel c(DeactivateDestinationInteractor deactivateDestinationInteractor) {
        return new DriverDestinationActiveStateViewModel(deactivateDestinationInteractor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverDestinationActiveStateViewModel get() {
        return c(this.f28187a.get());
    }
}
