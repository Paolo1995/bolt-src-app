package ee.mtakso.driver.ui.screens.documents_scanner.screens.onboarding;

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
public final class DocumentsOnBoardingStepFragment_Factory implements Factory<DocumentsOnBoardingStepFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f28455a;

    public DocumentsOnBoardingStepFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f28455a = provider;
    }

    public static DocumentsOnBoardingStepFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new DocumentsOnBoardingStepFragment_Factory(provider);
    }

    public static DocumentsOnBoardingStepFragment c(BaseUiDependencies baseUiDependencies) {
        return new DocumentsOnBoardingStepFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DocumentsOnBoardingStepFragment get() {
        return c(this.f28455a.get());
    }
}
