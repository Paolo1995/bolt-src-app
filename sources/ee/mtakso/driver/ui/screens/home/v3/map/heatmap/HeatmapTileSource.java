package ee.mtakso.driver.ui.screens.home.v3.map.heatmap;

import ee.mtakso.driver.network.client.tile.TileVariant;
import ee.mtakso.driver.service.modules.map.TileIndex;
import ee.mtakso.driver.service.modules.map.TilePosition;
import ee.mtakso.driver.service.modules.map.TileRequestMerger;
import ee.mtakso.driver.ui.screens.home.v3.map.surge.MvtToRasterConverter;
import eu.bolt.android.maps.core.plugin.driver.Tile;
import eu.bolt.android.maps.core.plugin.driver.TileSource;
import eu.bolt.driver.core.time.SystemUptimeSource;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import j$.util.Spliterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeatmapTileSource.kt */
/* loaded from: classes3.dex */
public final class HeatmapTileSource implements TileSource {

    /* renamed from: e  reason: collision with root package name */
    private static final Companion f30213e = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final TileRequestMerger f30214a;

    /* renamed from: b  reason: collision with root package name */
    private final MvtToRasterConverter f30215b;

    /* renamed from: c  reason: collision with root package name */
    private final SystemUptimeSource f30216c;

    /* renamed from: d  reason: collision with root package name */
    private final HeatmapTileSourceArgs f30217d;

    /* compiled from: HeatmapTileSource.kt */
    /* loaded from: classes3.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public HeatmapTileSource(TileRequestMerger tileRequestMerger, MvtToRasterConverter mvtToRasterConverter, SystemUptimeSource timeSource, HeatmapTileSourceArgs args) {
        Intrinsics.f(tileRequestMerger, "tileRequestMerger");
        Intrinsics.f(mvtToRasterConverter, "mvtToRasterConverter");
        Intrinsics.f(timeSource, "timeSource");
        Intrinsics.f(args, "args");
        this.f30214a = tileRequestMerger;
        this.f30215b = mvtToRasterConverter;
        this.f30216c = timeSource;
        this.f30217d = args;
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.TileSource
    public Tile getTile(int i8, int i9, int i10) {
        try {
            long a8 = this.f30216c.a();
            TileVariant d8 = this.f30214a.h(new TileIndex(this.f30217d.a(), new TilePosition(i8, i9, i10))).d();
            long a9 = this.f30216c.a() - a8;
            Kalev kalev = Kalev.f41674e;
            FastLog g8 = kalev.g();
            if (g8 != null) {
                FastLog.DefaultImpls.a(g8, "Tile(" + i8 + ";" + i9 + " " + i10 + ") data loaded " + a9, null, 2, null);
            }
            if (d8 instanceof TileVariant.Raster) {
                byte[] a10 = ((TileVariant.Raster) d8).a();
                if (a10 == null) {
                    return null;
                }
                return new Tile(Spliterator.NONNULL, Spliterator.NONNULL, a10);
            } else if (d8 instanceof TileVariant.Mvt) {
                long a11 = this.f30216c.a();
                byte[] d9 = this.f30215b.d(((TileVariant.Mvt) d8).a(), this.f30217d.b(), this.f30217d.b());
                long a12 = this.f30216c.a() - a11;
                FastLog g9 = kalev.g();
                if (g9 != null) {
                    FastLog.DefaultImpls.a(g9, "Tile(" + i8 + ";" + i9 + " " + i10 + ") rendered " + a12, null, 2, null);
                }
                return new Tile(this.f30217d.b(), this.f30217d.b(), d9);
            } else if (d8 instanceof TileVariant.Empty) {
                return null;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } catch (Exception e8) {
            Kalev.e(e8, "Failed to load tile");
            return null;
        }
    }
}
