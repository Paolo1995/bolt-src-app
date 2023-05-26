package ee.mtakso.driver.ui.interactor.map;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapSettings.kt */
/* loaded from: classes3.dex */
public final class MapSettings {

    /* renamed from: a  reason: collision with root package name */
    private final List<MapSettingsHeatmap> f26642a;

    public MapSettings() {
        this(null, 1, null);
    }

    public MapSettings(List<MapSettingsHeatmap> heatmaps) {
        Intrinsics.f(heatmaps, "heatmaps");
        this.f26642a = heatmaps;
    }

    public final List<MapSettingsHeatmap> a() {
        return this.f26642a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MapSettings) && Intrinsics.a(this.f26642a, ((MapSettings) obj).f26642a);
    }

    public int hashCode() {
        return this.f26642a.hashCode();
    }

    public String toString() {
        List<MapSettingsHeatmap> list = this.f26642a;
        return "MapSettings(heatmaps=" + list + ")";
    }

    public /* synthetic */ MapSettings(List list, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? CollectionsKt__CollectionsKt.k() : list);
    }
}
