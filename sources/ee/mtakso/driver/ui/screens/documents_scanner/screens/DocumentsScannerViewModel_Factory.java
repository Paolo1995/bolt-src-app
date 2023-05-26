package ee.mtakso.driver.ui.screens.documents_scanner.screens;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.screens.documents_scanner.source.SourceControllersFactory;
import ee.mtakso.driver.ui.screens.documents_scanner.utils.FilesUriProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DocumentsScannerViewModel_Factory implements Factory<DocumentsScannerViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<SourceControllersFactory> f28431a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<FilesUriProvider> f28432b;

    public DocumentsScannerViewModel_Factory(Provider<SourceControllersFactory> provider, Provider<FilesUriProvider> provider2) {
        this.f28431a = provider;
        this.f28432b = provider2;
    }

    public static DocumentsScannerViewModel_Factory a(Provider<SourceControllersFactory> provider, Provider<FilesUriProvider> provider2) {
        return new DocumentsScannerViewModel_Factory(provider, provider2);
    }

    public static DocumentsScannerViewModel c(SourceControllersFactory sourceControllersFactory, FilesUriProvider filesUriProvider) {
        return new DocumentsScannerViewModel(sourceControllersFactory, filesUriProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DocumentsScannerViewModel get() {
        return c(this.f28431a.get(), this.f28432b.get());
    }
}
