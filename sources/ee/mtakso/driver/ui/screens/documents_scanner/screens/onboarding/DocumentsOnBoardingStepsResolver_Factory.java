package ee.mtakso.driver.ui.screens.documents_scanner.screens.onboarding;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DocumentsOnBoardingStepsResolver_Factory implements Factory<DocumentsOnBoardingStepsResolver> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final DocumentsOnBoardingStepsResolver_Factory f28458a = new DocumentsOnBoardingStepsResolver_Factory();

        private InstanceHolder() {
        }
    }

    public static DocumentsOnBoardingStepsResolver_Factory a() {
        return InstanceHolder.f28458a;
    }

    public static DocumentsOnBoardingStepsResolver c() {
        return new DocumentsOnBoardingStepsResolver();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DocumentsOnBoardingStepsResolver get() {
        return c();
    }
}
