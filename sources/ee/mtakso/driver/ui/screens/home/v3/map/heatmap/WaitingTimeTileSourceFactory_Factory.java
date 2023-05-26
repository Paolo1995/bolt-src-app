package ee.mtakso.driver.ui.screens.home.v3.map.heatmap;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class WaitingTimeTileSourceFactory_Factory implements Factory<WaitingTimeTileSourceFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<WaitingTimeMarkerProvider> f30256a;

    public WaitingTimeTileSourceFactory_Factory(Provider<WaitingTimeMarkerProvider> provider) {
        this.f30256a = provider;
    }

    public static WaitingTimeTileSourceFactory_Factory a(Provider<WaitingTimeMarkerProvider> provider) {
        return new WaitingTimeTileSourceFactory_Factory(provider);
    }

    public static WaitingTimeTileSourceFactory c(WaitingTimeMarkerProvider waitingTimeMarkerProvider) {
        return new WaitingTimeTileSourceFactory(waitingTimeMarkerProvider);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WaitingTimeTileSourceFactory get() {
        return c(this.f30256a.get());
    }
}
