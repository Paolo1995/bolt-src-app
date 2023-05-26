package ee.mtakso.driver.ui.screens.time_limit;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes5.dex */
public final class WorkTimeFragment_Factory implements Factory<WorkTimeFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f33479a;

    public WorkTimeFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f33479a = provider;
    }

    public static WorkTimeFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new WorkTimeFragment_Factory(provider);
    }

    public static WorkTimeFragment c(BaseUiDependencies baseUiDependencies) {
        return new WorkTimeFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WorkTimeFragment get() {
        return c(this.f33479a.get());
    }
}
