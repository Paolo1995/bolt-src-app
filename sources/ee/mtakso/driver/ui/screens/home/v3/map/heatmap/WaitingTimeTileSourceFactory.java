package ee.mtakso.driver.ui.screens.home.v3.map.heatmap;

import android.os.Handler;
import ee.mtakso.driver.ui.screens.home.v3.map.marker.MapTile;
import eu.bolt.android.maps.core.plugin.driver.TileSource;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WaitingTimeTileSourceFactory.kt */
/* loaded from: classes3.dex */
public final class WaitingTimeTileSourceFactory {

    /* renamed from: a  reason: collision with root package name */
    private final WaitingTimeMarkerProvider f30255a;

    @Inject
    public WaitingTimeTileSourceFactory(WaitingTimeMarkerProvider markerProvider) {
        Intrinsics.f(markerProvider, "markerProvider");
        this.f30255a = markerProvider;
    }

    public final TileSource a(WaitingTimeTileSourceArgs args, Handler handler, Function1<? super MapTile<WaitingTimeMarker>, Unit> receiver) {
        Intrinsics.f(args, "args");
        Intrinsics.f(handler, "handler");
        Intrinsics.f(receiver, "receiver");
        return new WaitingTimeTileSource(this.f30255a, args, handler, receiver);
    }
}
