package ee.mtakso.driver.ui.screens.home.v3.map.heatmap;

import ee.mtakso.driver.service.modules.map.TileRequestMerger;
import ee.mtakso.driver.ui.screens.home.v3.map.surge.MvtToRasterConverter;
import eu.bolt.android.maps.core.plugin.driver.TileSource;
import eu.bolt.driver.core.time.SystemUptimeSource;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeatmapTileSourceFactory.kt */
/* loaded from: classes3.dex */
public final class HeatmapTileSourceFactory {

    /* renamed from: a  reason: collision with root package name */
    private final TileRequestMerger f30222a;

    /* renamed from: b  reason: collision with root package name */
    private final MvtToRasterConverter f30223b;

    /* renamed from: c  reason: collision with root package name */
    private final SystemUptimeSource f30224c;

    @Inject
    public HeatmapTileSourceFactory(TileRequestMerger tileRequestMerger, MvtToRasterConverter mvtToRasterConverter, SystemUptimeSource timeSource) {
        Intrinsics.f(tileRequestMerger, "tileRequestMerger");
        Intrinsics.f(mvtToRasterConverter, "mvtToRasterConverter");
        Intrinsics.f(timeSource, "timeSource");
        this.f30222a = tileRequestMerger;
        this.f30223b = mvtToRasterConverter;
        this.f30224c = timeSource;
    }

    public final TileSource a(HeatmapTileSourceArgs args) {
        Intrinsics.f(args, "args");
        return new HeatmapTileSource(this.f30222a, this.f30223b, this.f30224c, args);
    }
}
