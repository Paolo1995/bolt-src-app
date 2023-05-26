package ee.mtakso.driver.ui.screens.documents_scanner.screens.processing;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DocumentsProcessingFragment_Factory implements Factory<DocumentsProcessingFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f28466a;

    public DocumentsProcessingFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f28466a = provider;
    }

    public static DocumentsProcessingFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new DocumentsProcessingFragment_Factory(provider);
    }

    public static DocumentsProcessingFragment c(BaseUiDependencies baseUiDependencies) {
        return new DocumentsProcessingFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DocumentsProcessingFragment get() {
        return c(this.f28466a.get());
    }
}
