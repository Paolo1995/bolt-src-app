package eu.bolt.driver.maps.tile.mvt;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import vector_tile.VectorTile$Tile;

/* compiled from: MvtTile.kt */
/* loaded from: classes5.dex */
public final class MvtTile {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f41536c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final VectorTile$Tile f41537a;

    /* renamed from: b  reason: collision with root package name */
    private final Iterable<MvtLayer> f41538b;

    /* compiled from: MvtTile.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MvtTile a(byte[] bytes) {
            Intrinsics.f(bytes, "bytes");
            VectorTile$Tile parseFrom = VectorTile$Tile.parseFrom(bytes);
            Intrinsics.e(parseFrom, "parseFrom(bytes)");
            return new MvtTile(parseFrom);
        }
    }

    /* compiled from: MvtTile.kt */
    /* loaded from: classes5.dex */
    private final class LayerIterable implements Iterable<MvtLayer>, KMappedMarker {
        public LayerIterable() {
        }

        @Override // java.lang.Iterable
        public Iterator<MvtLayer> iterator() {
            return new LayerIterator();
        }
    }

    /* compiled from: MvtTile.kt */
    /* loaded from: classes5.dex */
    private final class LayerIterator implements Iterator<MvtLayer>, KMappedMarker, j$.util.Iterator {

        /* renamed from: f  reason: collision with root package name */
        private int f41540f;

        public LayerIterator() {
        }

        @Override // java.util.Iterator, j$.util.Iterator
        /* renamed from: b */
        public MvtLayer next() {
            VectorTile$Tile b8 = MvtTile.this.b();
            int i8 = this.f41540f;
            this.f41540f = i8 + 1;
            VectorTile$Tile.Layer layers = b8.getLayers(i8);
            Intrinsics.e(layers, "tile.getLayers(index++)");
            return new MvtLayer(layers);
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super MvtLayer> consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (this.f41540f < MvtTile.this.b().getLayersCount()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public MvtTile(VectorTile$Tile tile) {
        Intrinsics.f(tile, "tile");
        this.f41537a = tile;
        this.f41538b = new LayerIterable();
    }

    public final Iterable<MvtLayer> a() {
        return this.f41538b;
    }

    public final VectorTile$Tile b() {
        return this.f41537a;
    }
}
