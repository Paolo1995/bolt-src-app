package ee.mtakso.driver.ui.screens.destination.search;

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
public final class DriverDestinationSearchFragment_Factory implements Factory<DriverDestinationSearchFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f28221a;

    public DriverDestinationSearchFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f28221a = provider;
    }

    public static DriverDestinationSearchFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new DriverDestinationSearchFragment_Factory(provider);
    }

    public static DriverDestinationSearchFragment c(BaseUiDependencies baseUiDependencies) {
        return new DriverDestinationSearchFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverDestinationSearchFragment get() {
        return c(this.f28221a.get());
    }
}
