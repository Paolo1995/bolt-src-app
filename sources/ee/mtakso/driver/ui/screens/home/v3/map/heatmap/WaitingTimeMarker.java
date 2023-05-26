package ee.mtakso.driver.ui.screens.home.v3.map.heatmap;

import ee.mtakso.driver.service.modules.tile.VectorProperties;
import eu.bolt.android.maps.core.plugin.driver.MapStyle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WaitingTimeMarker.kt */
/* loaded from: classes3.dex */
public final class WaitingTimeMarker {

    /* renamed from: a  reason: collision with root package name */
    private final MapStyle f30230a;

    /* renamed from: b  reason: collision with root package name */
    private final VectorProperties.Label f30231b;

    public WaitingTimeMarker(MapStyle style, VectorProperties.Label properties) {
        Intrinsics.f(style, "style");
        Intrinsics.f(properties, "properties");
        this.f30230a = style;
        this.f30231b = properties;
    }

    public final VectorProperties.Label a() {
        return this.f30231b;
    }

    public final MapStyle b() {
        return this.f30230a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WaitingTimeMarker) {
            WaitingTimeMarker waitingTimeMarker = (WaitingTimeMarker) obj;
            return this.f30230a == waitingTimeMarker.f30230a && Intrinsics.a(this.f30231b, waitingTimeMarker.f30231b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f30230a.hashCode() * 31) + this.f30231b.hashCode();
    }

    public String toString() {
        MapStyle mapStyle = this.f30230a;
        VectorProperties.Label label = this.f30231b;
        return "WaitingTimeMarker(style=" + mapStyle + ", properties=" + label + ")";
    }
}
