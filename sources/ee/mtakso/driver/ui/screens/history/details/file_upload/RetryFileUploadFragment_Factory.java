package ee.mtakso.driver.ui.screens.history.details.file_upload;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class RetryFileUploadFragment_Factory implements Factory<RetryFileUploadFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f29557a;

    public RetryFileUploadFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f29557a = provider;
    }

    public static RetryFileUploadFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new RetryFileUploadFragment_Factory(provider);
    }

    public static RetryFileUploadFragment c(BaseUiDependencies baseUiDependencies) {
        return new RetryFileUploadFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public RetryFileUploadFragment get() {
        return c(this.f29557a.get());
    }
}
