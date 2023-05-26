package ee.mtakso.driver.ui.screens.priority;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.priority.DriverPriorityClient;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverPriorityViewModel_Factory implements Factory<DriverPriorityViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverPriorityClient> f32533a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverPriorityMapper> f32534b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<CompositeUrlLauncher> f32535c;

    public DriverPriorityViewModel_Factory(Provider<DriverPriorityClient> provider, Provider<DriverPriorityMapper> provider2, Provider<CompositeUrlLauncher> provider3) {
        this.f32533a = provider;
        this.f32534b = provider2;
        this.f32535c = provider3;
    }

    public static DriverPriorityViewModel_Factory a(Provider<DriverPriorityClient> provider, Provider<DriverPriorityMapper> provider2, Provider<CompositeUrlLauncher> provider3) {
        return new DriverPriorityViewModel_Factory(provider, provider2, provider3);
    }

    public static DriverPriorityViewModel c(DriverPriorityClient driverPriorityClient, DriverPriorityMapper driverPriorityMapper, CompositeUrlLauncher compositeUrlLauncher) {
        return new DriverPriorityViewModel(driverPriorityClient, driverPriorityMapper, compositeUrlLauncher);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverPriorityViewModel get() {
        return c(this.f32533a.get(), this.f32534b.get(), this.f32535c.get());
    }
}
