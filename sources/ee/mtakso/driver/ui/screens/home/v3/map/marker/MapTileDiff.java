package ee.mtakso.driver.ui.screens.home.v3.map.marker;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapTileDiff.kt */
/* loaded from: classes3.dex */
public final class MapTileDiff {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, RenderedMarkerDiff> f30267a;

    public MapTileDiff(Map<String, RenderedMarkerDiff> diff) {
        Intrinsics.f(diff, "diff");
        this.f30267a = diff;
    }

    public final Map<String, RenderedMarkerDiff> a() {
        return this.f30267a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MapTileDiff) && Intrinsics.a(this.f30267a, ((MapTileDiff) obj).f30267a);
    }

    public int hashCode() {
        return this.f30267a.hashCode();
    }

    public String toString() {
        Map<String, RenderedMarkerDiff> map = this.f30267a;
        return "MapTileDiff(diff=" + map + ")";
    }
}
