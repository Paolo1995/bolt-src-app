package ee.mtakso.driver.ui.interactor.modaldialog;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.network.client.modal.ModalClient;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class SingleModalDialogInteractor_Factory implements Factory<SingleModalDialogInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ModalClient> f26675a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Features> f26676b;

    public SingleModalDialogInteractor_Factory(Provider<ModalClient> provider, Provider<Features> provider2) {
        this.f26675a = provider;
        this.f26676b = provider2;
    }

    public static SingleModalDialogInteractor_Factory a(Provider<ModalClient> provider, Provider<Features> provider2) {
        return new SingleModalDialogInteractor_Factory(provider, provider2);
    }

    public static SingleModalDialogInteractor c(ModalClient modalClient, Features features) {
        return new SingleModalDialogInteractor(modalClient, features);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SingleModalDialogInteractor get() {
        return c(this.f26675a.get(), this.f26676b.get());
    }
}
