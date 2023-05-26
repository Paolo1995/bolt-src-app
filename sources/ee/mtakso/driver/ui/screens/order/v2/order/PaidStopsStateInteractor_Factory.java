package ee.mtakso.driver.ui.screens.order.v2.order;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.service.modules.distance.UpcomingStopDistanceService;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PaidStopsStateInteractor_Factory implements Factory<PaidStopsStateInteractor> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<UpcomingStopDistanceService> f32313a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Features> f32314b;

    public PaidStopsStateInteractor_Factory(Provider<UpcomingStopDistanceService> provider, Provider<Features> provider2) {
        this.f32313a = provider;
        this.f32314b = provider2;
    }

    public static PaidStopsStateInteractor_Factory a(Provider<UpcomingStopDistanceService> provider, Provider<Features> provider2) {
        return new PaidStopsStateInteractor_Factory(provider, provider2);
    }

    public static PaidStopsStateInteractor c(UpcomingStopDistanceService upcomingStopDistanceService, Features features) {
        return new PaidStopsStateInteractor(upcomingStopDistanceService, features);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PaidStopsStateInteractor get() {
        return c(this.f32313a.get(), this.f32314b.get());
    }
}
