package ee.mtakso.driver.ui.screens.destination.active.state;

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
public final class DriverDestinationActiveStateFragment_Factory implements Factory<DriverDestinationActiveStateFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f28180a;

    public DriverDestinationActiveStateFragment_Factory(Provider<BaseUiDependencies> provider) {
        this.f28180a = provider;
    }

    public static DriverDestinationActiveStateFragment_Factory a(Provider<BaseUiDependencies> provider) {
        return new DriverDestinationActiveStateFragment_Factory(provider);
    }

    public static DriverDestinationActiveStateFragment c(BaseUiDependencies baseUiDependencies) {
        return new DriverDestinationActiveStateFragment(baseUiDependencies);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverDestinationActiveStateFragment get() {
        return c(this.f28180a.get());
    }
}
