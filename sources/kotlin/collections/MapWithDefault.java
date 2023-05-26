package kotlin.collections;

import java.util.Map;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: MapWithDefault.kt */
/* loaded from: classes5.dex */
interface MapWithDefault<K, V> extends Map<K, V>, KMappedMarker {
    V f(K k8);
}
