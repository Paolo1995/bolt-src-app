package ee.mtakso.driver.ui.screens.score;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.network.client.score.DriverScoreClient;
import ee.mtakso.driver.service.analytics.event.facade.DriverScoreAnalytics;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DriverScoreViewModel_Factory implements Factory<DriverScoreViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DriverScoreClient> f32960a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<DriverScoreMapper> f32961b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<DriverScoreTooltipFactory> f32962c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<DriverScoreAnalytics> f32963d;

    public DriverScoreViewModel_Factory(Provider<DriverScoreClient> provider, Provider<DriverScoreMapper> provider2, Provider<DriverScoreTooltipFactory> provider3, Provider<DriverScoreAnalytics> provider4) {
        this.f32960a = provider;
        this.f32961b = provider2;
        this.f32962c = provider3;
        this.f32963d = provider4;
    }

    public static DriverScoreViewModel_Factory a(Provider<DriverScoreClient> provider, Provider<DriverScoreMapper> provider2, Provider<DriverScoreTooltipFactory> provider3, Provider<DriverScoreAnalytics> provider4) {
        return new DriverScoreViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static DriverScoreViewModel c(DriverScoreClient driverScoreClient, DriverScoreMapper driverScoreMapper, DriverScoreTooltipFactory driverScoreTooltipFactory, DriverScoreAnalytics driverScoreAnalytics) {
        return new DriverScoreViewModel(driverScoreClient, driverScoreMapper, driverScoreTooltipFactory, driverScoreAnalytics);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DriverScoreViewModel get() {
        return c(this.f32960a.get(), this.f32961b.get(), this.f32962c.get(), this.f32963d.get());
    }
}
