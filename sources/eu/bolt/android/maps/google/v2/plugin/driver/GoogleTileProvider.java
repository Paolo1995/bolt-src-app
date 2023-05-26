package eu.bolt.android.maps.google.v2.plugin.driver;

import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;
import eu.bolt.android.maps.core.plugin.driver.TileSource;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoogleTileProvider.kt */
/* loaded from: classes5.dex */
public final class GoogleTileProvider implements TileProvider {

    /* renamed from: a  reason: collision with root package name */
    private final TileSource f37002a;

    public GoogleTileProvider(TileSource impl) {
        Intrinsics.f(impl, "impl");
        this.f37002a = impl;
    }

    @Override // com.google.android.gms.maps.model.TileProvider
    public Tile getTile(int i8, int i9, int i10) {
        eu.bolt.android.maps.core.plugin.driver.Tile tile = this.f37002a.getTile(i8, i9, i10);
        if (tile == null) {
            Tile tile2 = TileProvider.NO_TILE;
            Intrinsics.e(tile2, "{\n            TileProvider.NO_TILE\n        }");
            return tile2;
        }
        return new Tile(tile.c(), tile.b(), tile.a());
    }
}
