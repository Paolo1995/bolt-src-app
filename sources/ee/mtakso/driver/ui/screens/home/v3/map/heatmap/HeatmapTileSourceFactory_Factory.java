package ee.mtakso.driver.ui.screens.home.v3.map.heatmap;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.modules.map.TileRequestMerger;
import ee.mtakso.driver.ui.screens.home.v3.map.surge.MvtToRasterConverter;
import eu.bolt.driver.core.time.SystemUptimeSource;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class HeatmapTileSourceFactory_Factory implements Factory<HeatmapTileSourceFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TileRequestMerger> f30225a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MvtToRasterConverter> f30226b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SystemUptimeSource> f30227c;

    public HeatmapTileSourceFactory_Factory(Provider<TileRequestMerger> provider, Provider<MvtToRasterConverter> provider2, Provider<SystemUptimeSource> provider3) {
        this.f30225a = provider;
        this.f30226b = provider2;
        this.f30227c = provider3;
    }

    public static HeatmapTileSourceFactory_Factory a(Provider<TileRequestMerger> provider, Provider<MvtToRasterConverter> provider2, Provider<SystemUptimeSource> provider3) {
        return new HeatmapTileSourceFactory_Factory(provider, provider2, provider3);
    }

    public static HeatmapTileSourceFactory c(TileRequestMerger tileRequestMerger, MvtToRasterConverter mvtToRasterConverter, SystemUptimeSource systemUptimeSource) {
        return new HeatmapTileSourceFactory(tileRequestMerger, mvtToRasterConverter, systemUptimeSource);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public HeatmapTileSourceFactory get() {
        return c(this.f30225a.get(), this.f30226b.get(), this.f30227c.get());
    }
}
