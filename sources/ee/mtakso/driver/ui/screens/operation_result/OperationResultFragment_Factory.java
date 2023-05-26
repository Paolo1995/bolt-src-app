package ee.mtakso.driver.ui.screens.operation_result;

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
public final class OperationResultFragment_Factory implements Factory<OperationResultFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f30970a;

    public OperationResultFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f30970a = provider;
    }

    public static OperationResultFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new OperationResultFragment_Factory(provider);
    }

    public static OperationResultFragment c(BaseUiDependencies baseUiDependencies) {
        return new OperationResultFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public OperationResultFragment get() {
        return c(this.f30970a.get());
    }
}
