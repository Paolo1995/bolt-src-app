package eu.bolt.driver.maps.tile.mvt;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import vector_tile.VectorTile$Tile;

/* compiled from: MvtProtocol.kt */
/* loaded from: classes5.dex */
public final class MvtProtocol {

    /* renamed from: a  reason: collision with root package name */
    public static final MvtProtocol f41535a = new MvtProtocol();

    private MvtProtocol() {
    }

    private final Object c(VectorTile$Tile.Value value) {
        if (value.hasStringValue()) {
            return value.getStringValue();
        }
        if (value.hasFloatValue()) {
            return Float.valueOf(value.getFloatValue());
        }
        if (value.hasDoubleValue()) {
            return Double.valueOf(value.getDoubleValue());
        }
        if (value.hasIntValue()) {
            return Long.valueOf(value.getIntValue());
        }
        if (value.hasUintValue()) {
            return Long.valueOf(value.getUintValue());
        }
        if (value.hasSintValue()) {
            return Long.valueOf(value.getSintValue());
        }
        if (value.hasBoolValue()) {
            return Boolean.valueOf(value.getBoolValue());
        }
        return null;
    }

    public final int a(int i8) {
        return i8 >> 3;
    }

    public final int b(int i8) {
        return i8 & 7;
    }

    public final int d(int i8) {
        return (i8 == 1 || i8 == 2) ? 2 : 0;
    }

    public final Map<String, Object> e(VectorTile$Tile.Layer layer, VectorTile$Tile.Feature feature) {
        IntRange o8;
        IntProgression n8;
        Intrinsics.f(layer, "layer");
        Intrinsics.f(feature, "feature");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        o8 = RangesKt___RangesKt.o(0, feature.getTagsCount());
        n8 = RangesKt___RangesKt.n(o8, 2);
        int g8 = n8.g();
        int i8 = n8.i();
        int k8 = n8.k();
        if ((k8 > 0 && g8 <= i8) || (k8 < 0 && i8 <= g8)) {
            while (true) {
                String key = layer.getKeys(feature.getTags(g8));
                VectorTile$Tile.Value value = layer.getValues(feature.getTags(g8 + 1));
                if (linkedHashMap.get(key) == null) {
                    Intrinsics.e(key, "key");
                    Intrinsics.e(value, "value");
                    linkedHashMap.put(key, c(value));
                    if (g8 == i8) {
                        break;
                    }
                    g8 += k8;
                } else {
                    throw new IllegalArgumentException("Duplicates key " + key + "!");
                }
            }
        }
        return linkedHashMap;
    }

    public final int f(int i8) {
        return (-(i8 & 1)) ^ (i8 >> 1);
    }
}
