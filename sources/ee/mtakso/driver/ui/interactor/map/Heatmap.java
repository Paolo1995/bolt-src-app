package ee.mtakso.driver.ui.interactor.map;

import ee.mtakso.driver.network.client.driver.map.TileCollectionConfig;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Heatmap.kt */
/* loaded from: classes3.dex */
public abstract class Heatmap {

    /* compiled from: Heatmap.kt */
    /* loaded from: classes3.dex */
    public static final class Empty extends Heatmap {

        /* renamed from: a  reason: collision with root package name */
        public static final Empty f26634a = new Empty();

        private Empty() {
            super(null);
        }
    }

    /* compiled from: Heatmap.kt */
    /* loaded from: classes3.dex */
    public static final class Tile extends Heatmap {

        /* renamed from: a  reason: collision with root package name */
        private final String f26635a;

        /* renamed from: b  reason: collision with root package name */
        private final TileCollectionConfig f26636b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Tile(String collectionId, TileCollectionConfig tileCollectionConfig) {
            super(null);
            Intrinsics.f(collectionId, "collectionId");
            this.f26635a = collectionId;
            this.f26636b = tileCollectionConfig;
        }

        public final String a() {
            return this.f26635a;
        }

        public final TileCollectionConfig b() {
            return this.f26636b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Tile) {
                Tile tile = (Tile) obj;
                return Intrinsics.a(this.f26635a, tile.f26635a) && Intrinsics.a(this.f26636b, tile.f26636b);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f26635a.hashCode() * 31;
            TileCollectionConfig tileCollectionConfig = this.f26636b;
            return hashCode + (tileCollectionConfig == null ? 0 : tileCollectionConfig.hashCode());
        }

        public String toString() {
            String str = this.f26635a;
            TileCollectionConfig tileCollectionConfig = this.f26636b;
            return "Tile(collectionId=" + str + ", config=" + tileCollectionConfig + ")";
        }
    }

    private Heatmap() {
    }

    public /* synthetic */ Heatmap(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
