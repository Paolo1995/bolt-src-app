package ee.mtakso.driver.ui.screens.priority;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.screens.home.v3.delegate.DeeplinkDelegate;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"ee.mtakso.driver.di.qualifiers.Authorised"})
/* loaded from: classes3.dex */
public final class DriverPriorityFragment_Factory implements Factory<DriverPriorityFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<BaseUiDependencies> f32514a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DeeplinkDelegate> f32515b;

    public DriverPriorityFragment_Factory(Provider<BaseUiDependencies> provider, Provider<DeeplinkDelegate> provider2) {
        this.f32514a = provider;
        this.f32515b = provider2;
    }

    public static DriverPriorityFragment_Factory a(Provider<BaseUiDependencies> provider, Provider<DeeplinkDelegate> provider2) {
        return new DriverPriorityFragment_Factory(provider, provider2);
    }

    public static DriverPriorityFragment c(BaseUiDependencies baseUiDependencies, DeeplinkDelegate deeplinkDelegate) {
        return new DriverPriorityFragment(baseUiDependencies, deeplinkDelegate);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverPriorityFragment get() {
        return c(this.f32514a.get(), this.f32515b.get());
    }
}
