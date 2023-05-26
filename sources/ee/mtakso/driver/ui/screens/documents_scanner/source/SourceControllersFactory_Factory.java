package ee.mtakso.driver.ui.screens.documents_scanner.source;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.screens.documents_scanner.utils.FilesUriProvider;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class SourceControllersFactory_Factory implements Factory<SourceControllersFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<FilesUriProvider> f28469a;

    public SourceControllersFactory_Factory(Provider<FilesUriProvider> provider) {
        this.f28469a = provider;
    }

    public static SourceControllersFactory_Factory a(Provider<FilesUriProvider> provider) {
        return new SourceControllersFactory_Factory(provider);
    }

    public static SourceControllersFactory c(FilesUriProvider filesUriProvider) {
        return new SourceControllersFactory(filesUriProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public SourceControllersFactory get() {
        return c(this.f28469a.get());
    }
}
