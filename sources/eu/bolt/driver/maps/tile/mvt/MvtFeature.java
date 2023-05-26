package eu.bolt.driver.maps.tile.mvt;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import vector_tile.VectorTile$Tile;

/* compiled from: MvtFeature.kt */
/* loaded from: classes5.dex */
public final class MvtFeature {

    /* renamed from: a  reason: collision with root package name */
    private final VectorTile$Tile.Layer f41516a;

    /* renamed from: b  reason: collision with root package name */
    private final VectorTile$Tile.Feature f41517b;

    /* renamed from: c  reason: collision with root package name */
    private final String f41518c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Object> f41519d;

    /* renamed from: e  reason: collision with root package name */
    private final VectorTile$Tile.GeomType f41520e;

    /* renamed from: f  reason: collision with root package name */
    private final Iterable<MvtCommand> f41521f;

    /* compiled from: MvtFeature.kt */
    /* loaded from: classes5.dex */
    private final class CommandIterable implements Iterable<MvtCommand>, KMappedMarker {
        public CommandIterable() {
        }

        @Override // java.lang.Iterable
        public Iterator<MvtCommand> iterator() {
            return new CommandIterator();
        }
    }

    /* compiled from: MvtFeature.kt */
    /* loaded from: classes5.dex */
    private final class CommandIterator implements Iterator<MvtCommand>, KMappedMarker, j$.util.Iterator {

        /* renamed from: f  reason: collision with root package name */
        private int f41523f;

        /* renamed from: g  reason: collision with root package name */
        private int f41524g;

        /* renamed from: h  reason: collision with root package name */
        private int f41525h;

        /* renamed from: i  reason: collision with root package name */
        private int f41526i;

        /* renamed from: j  reason: collision with root package name */
        private int f41527j;

        public CommandIterator() {
        }

        public final void b() {
            while (this.f41527j == 0 && this.f41523f < MvtFeature.this.b().getGeometryCount()) {
                VectorTile$Tile.Feature b8 = MvtFeature.this.b();
                int i8 = this.f41523f;
                this.f41523f = i8 + 1;
                int geometry = b8.getGeometry(i8);
                MvtProtocol mvtProtocol = MvtProtocol.f41535a;
                this.f41526i = mvtProtocol.b(geometry);
                this.f41527j = mvtProtocol.a(geometry);
                int d8 = mvtProtocol.d(this.f41526i);
                int geometryCount = MvtFeature.this.b().getGeometryCount() - this.f41523f;
                if (geometryCount < d8 * this.f41527j) {
                    int i9 = this.f41526i;
                    int i10 = this.f41527j;
                    throw new IllegalArgumentException("Illegal command " + i9 + " count " + i10 + ", only " + geometryCount + " geometry left");
                }
            }
        }

        @Override // java.util.Iterator, j$.util.Iterator
        /* renamed from: c */
        public MvtCommand next() {
            b();
            int i8 = this.f41526i;
            if (i8 != 1 && i8 != 2) {
                if (i8 != 7) {
                    this.f41527j--;
                } else {
                    this.f41527j--;
                }
            } else {
                int i9 = this.f41524g;
                MvtProtocol mvtProtocol = MvtProtocol.f41535a;
                VectorTile$Tile.Feature b8 = MvtFeature.this.b();
                int i10 = this.f41523f;
                this.f41523f = i10 + 1;
                this.f41524g = i9 + mvtProtocol.f(b8.getGeometry(i10));
                int i11 = this.f41525h;
                VectorTile$Tile.Feature b9 = MvtFeature.this.b();
                int i12 = this.f41523f;
                this.f41523f = i12 + 1;
                this.f41525h = i11 + mvtProtocol.f(b9.getGeometry(i12));
                this.f41527j--;
            }
            return new MvtCommand(this.f41526i, this.f41524g, this.f41525h);
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super MvtCommand> consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            b();
            if (this.f41527j > 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public MvtFeature(VectorTile$Tile.Layer layer, VectorTile$Tile.Feature feature) {
        Intrinsics.f(layer, "layer");
        Intrinsics.f(feature, "feature");
        this.f41516a = layer;
        this.f41517b = feature;
        this.f41518c = String.valueOf(feature.getId());
        this.f41519d = MvtProtocol.f41535a.e(layer, feature);
        VectorTile$Tile.GeomType type = feature.getType();
        Intrinsics.e(type, "feature.type");
        this.f41520e = type;
        this.f41521f = new CommandIterable();
    }

    public final Iterable<MvtCommand> a() {
        return this.f41521f;
    }

    public final VectorTile$Tile.Feature b() {
        return this.f41517b;
    }

    public final String c() {
        return this.f41518c;
    }

    public final Map<String, Object> d() {
        return this.f41519d;
    }

    public final VectorTile$Tile.GeomType e() {
        return this.f41520e;
    }
}
