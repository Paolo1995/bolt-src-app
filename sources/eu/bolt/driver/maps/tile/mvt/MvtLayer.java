package eu.bolt.driver.maps.tile.mvt;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import vector_tile.VectorTile$Tile;

/* compiled from: MvtLayer.kt */
/* loaded from: classes5.dex */
public final class MvtLayer {

    /* renamed from: a  reason: collision with root package name */
    private final VectorTile$Tile.Layer f41529a;

    /* renamed from: b  reason: collision with root package name */
    private final int f41530b;

    /* renamed from: c  reason: collision with root package name */
    private final Iterable<MvtFeature> f41531c;

    /* compiled from: MvtLayer.kt */
    /* loaded from: classes5.dex */
    private final class FeatureIterable implements Iterable<MvtFeature>, KMappedMarker {
        public FeatureIterable() {
        }

        @Override // java.lang.Iterable
        public Iterator<MvtFeature> iterator() {
            return new FeatureIterator();
        }
    }

    /* compiled from: MvtLayer.kt */
    /* loaded from: classes5.dex */
    private final class FeatureIterator implements Iterator<MvtFeature>, KMappedMarker, j$.util.Iterator {

        /* renamed from: f  reason: collision with root package name */
        private int f41533f;

        public FeatureIterator() {
        }

        @Override // java.util.Iterator, j$.util.Iterator
        /* renamed from: b */
        public MvtFeature next() {
            VectorTile$Tile.Layer c8 = MvtLayer.this.c();
            int i8 = this.f41533f;
            this.f41533f = i8 + 1;
            VectorTile$Tile.Feature feature = c8.getFeatures(i8);
            VectorTile$Tile.Layer c9 = MvtLayer.this.c();
            Intrinsics.e(feature, "feature");
            return new MvtFeature(c9, feature);
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super MvtFeature> consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (this.f41533f < MvtLayer.this.c().getFeaturesCount()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public MvtLayer(VectorTile$Tile.Layer layer) {
        Intrinsics.f(layer, "layer");
        this.f41529a = layer;
        this.f41530b = layer.getExtent();
        this.f41531c = new FeatureIterable();
    }

    public final int a() {
        return this.f41530b;
    }

    public final Iterable<MvtFeature> b() {
        return this.f41531c;
    }

    public final VectorTile$Tile.Layer c() {
        return this.f41529a;
    }
}
