package ee.mtakso.driver.ui.screens.home.v3.map.heatmap;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.map.TileRequestMerger;
import ee.mtakso.driver.service.modules.tile.VectorPropertiesFactory;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class WaitingTimeMarkerProvider_Factory implements Factory<WaitingTimeMarkerProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TileRequestMerger> f30234a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<VectorPropertiesFactory> f30235b;

    public WaitingTimeMarkerProvider_Factory(Provider<TileRequestMerger> provider, Provider<VectorPropertiesFactory> provider2) {
        this.f30234a = provider;
        this.f30235b = provider2;
    }

    public static WaitingTimeMarkerProvider_Factory a(Provider<TileRequestMerger> provider, Provider<VectorPropertiesFactory> provider2) {
        return new WaitingTimeMarkerProvider_Factory(provider, provider2);
    }

    public static WaitingTimeMarkerProvider c(TileRequestMerger tileRequestMerger, VectorPropertiesFactory vectorPropertiesFactory) {
        return new WaitingTimeMarkerProvider(tileRequestMerger, vectorPropertiesFactory);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public WaitingTimeMarkerProvider get() {
        return c(this.f30234a.get(), this.f30235b.get());
    }
}
