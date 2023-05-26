package ee.mtakso.driver.network.client.tile;

import eu.bolt.driver.maps.tile.mvt.MvtTile;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TileVariant.kt */
/* loaded from: classes3.dex */
public abstract class TileVariant {

    /* compiled from: TileVariant.kt */
    /* loaded from: classes3.dex */
    public static final class Empty extends TileVariant {

        /* renamed from: a  reason: collision with root package name */
        public static final Empty f22870a = new Empty();

        private Empty() {
            super(null);
        }
    }

    /* compiled from: TileVariant.kt */
    /* loaded from: classes3.dex */
    public static final class Mvt extends TileVariant {

        /* renamed from: a  reason: collision with root package name */
        private final MvtTile f22871a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Mvt(MvtTile tile) {
            super(null);
            Intrinsics.f(tile, "tile");
            this.f22871a = tile;
        }

        public final MvtTile a() {
            return this.f22871a;
        }
    }

    /* compiled from: TileVariant.kt */
    /* loaded from: classes3.dex */
    public static final class Raster extends TileVariant {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f22872a;

        public Raster(byte[] bArr) {
            super(null);
            this.f22872a = bArr;
        }

        public final byte[] a() {
            return this.f22872a;
        }
    }

    private TileVariant() {
    }

    public /* synthetic */ TileVariant(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
