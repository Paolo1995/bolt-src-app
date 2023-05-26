package ee.mtakso.driver.ui.interactor.modaldialog;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.modal.ModalClient;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class BackendModalDialogActionReporterInteractor_Factory implements Factory<BackendModalDialogActionReporterInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ModalClient> f26657a;

    public BackendModalDialogActionReporterInteractor_Factory(Provider<ModalClient> provider) {
        this.f26657a = provider;
    }

    public static BackendModalDialogActionReporterInteractor_Factory a(Provider<ModalClient> provider) {
        return new BackendModalDialogActionReporterInteractor_Factory(provider);
    }

    public static BackendModalDialogActionReporterInteractor c(ModalClient modalClient) {
        return new BackendModalDialogActionReporterInteractor(modalClient);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public BackendModalDialogActionReporterInteractor get() {
        return c(this.f26657a.get());
    }
}
