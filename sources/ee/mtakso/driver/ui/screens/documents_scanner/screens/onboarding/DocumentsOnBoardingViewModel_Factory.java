package ee.mtakso.driver.ui.screens.documents_scanner.screens.onboarding;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DocumentsOnBoardingViewModel_Factory implements Factory<DocumentsOnBoardingViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DocumentsOnBoardingStepsResolver> f28463a;

    public DocumentsOnBoardingViewModel_Factory(Provider<DocumentsOnBoardingStepsResolver> provider) {
        this.f28463a = provider;
    }

    public static DocumentsOnBoardingViewModel_Factory a(Provider<DocumentsOnBoardingStepsResolver> provider) {
        return new DocumentsOnBoardingViewModel_Factory(provider);
    }

    public static DocumentsOnBoardingViewModel c(DocumentsOnBoardingStepsResolver documentsOnBoardingStepsResolver) {
        return new DocumentsOnBoardingViewModel(documentsOnBoardingStepsResolver);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DocumentsOnBoardingViewModel get() {
        return c(this.f28463a.get());
    }
}
