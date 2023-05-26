package ee.mtakso.driver.ui.screens.home.v3.map.heatmap;

import android.os.Handler;
import ee.mtakso.driver.service.modules.map.TileIndex;
import ee.mtakso.driver.service.modules.map.TilePosition;
import ee.mtakso.driver.ui.screens.home.v3.map.heatmap.WaitingTimeTileSource;
import ee.mtakso.driver.ui.screens.home.v3.map.marker.MapTile;
import ee.mtakso.driver.ui.screens.home.v3.map.marker.MapTileMarker;
import eu.bolt.android.maps.core.plugin.driver.Tile;
import eu.bolt.android.maps.core.plugin.driver.TileSource;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WaitingTimeTileSource.kt */
/* loaded from: classes3.dex */
public final class WaitingTimeTileSource implements TileSource {

    /* renamed from: a  reason: collision with root package name */
    private final WaitingTimeMarkerProvider f30248a;

    /* renamed from: b  reason: collision with root package name */
    private final WaitingTimeTileSourceArgs f30249b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f30250c;

    /* renamed from: d  reason: collision with root package name */
    private final Function1<MapTile<WaitingTimeMarker>, Unit> f30251d;

    /* JADX WARN: Multi-variable type inference failed */
    public WaitingTimeTileSource(WaitingTimeMarkerProvider markerProvider, WaitingTimeTileSourceArgs args, Handler handler, Function1<? super MapTile<WaitingTimeMarker>, Unit> receiver) {
        Intrinsics.f(markerProvider, "markerProvider");
        Intrinsics.f(args, "args");
        Intrinsics.f(handler, "handler");
        Intrinsics.f(receiver, "receiver");
        this.f30248a = markerProvider;
        this.f30249b = args;
        this.f30250c = handler;
        this.f30251d = receiver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(WaitingTimeTileSource this$0, TilePosition position, List markers) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(position, "$position");
        Intrinsics.f(markers, "$markers");
        this$0.f30251d.invoke(new MapTile<>(this$0.f30249b.a(), position, markers));
    }

    @Override // eu.bolt.android.maps.core.plugin.driver.TileSource
    public Tile getTile(int i8, int i9, int i10) {
        final TilePosition tilePosition = new TilePosition(i8, i9, i10);
        final List<MapTileMarker<WaitingTimeMarker>> a8 = this.f30248a.a(new TileIndex(this.f30249b.a(), new TilePosition(i8, i9, i10)), this.f30249b.b(), this.f30249b.c());
        this.f30250c.post(new Runnable() { // from class: b4.a
            @Override // java.lang.Runnable
            public final void run() {
                WaitingTimeTileSource.b(WaitingTimeTileSource.this, tilePosition, a8);
            }
        });
        return null;
    }
}
