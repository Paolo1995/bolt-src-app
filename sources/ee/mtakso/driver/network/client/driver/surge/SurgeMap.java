package ee.mtakso.driver.network.client.driver.surge;

import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SurgeMap.kt */
/* loaded from: classes3.dex */
public final class SurgeMap {
    @SerializedName("hide_heatmap_selection")

    /* renamed from: a  reason: collision with root package name */
    private final Boolean f22081a;
    @SerializedName("tiles_collection_id")

    /* renamed from: b  reason: collision with root package name */
    private final String f22082b;
    @SerializedName("tiles_collection_id_per_category")

    /* renamed from: c  reason: collision with root package name */
    private final LinkedHashMap<String, String> f22083c;
    @SerializedName("label_per_category")

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, String> f22084d;

    public final LinkedHashMap<String, String> a() {
        return this.f22083c;
    }

    public final Boolean b() {
        return this.f22081a;
    }

    public final Map<String, String> c() {
        return this.f22084d;
    }

    public final String d() {
        return this.f22082b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SurgeMap) {
            SurgeMap surgeMap = (SurgeMap) obj;
            return Intrinsics.a(this.f22081a, surgeMap.f22081a) && Intrinsics.a(this.f22082b, surgeMap.f22082b) && Intrinsics.a(this.f22083c, surgeMap.f22083c) && Intrinsics.a(this.f22084d, surgeMap.f22084d);
        }
        return false;
    }

    public int hashCode() {
        Boolean bool = this.f22081a;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.f22082b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        LinkedHashMap<String, String> linkedHashMap = this.f22083c;
        int hashCode3 = (hashCode2 + (linkedHashMap == null ? 0 : linkedHashMap.hashCode())) * 31;
        Map<String, String> map = this.f22084d;
        return hashCode3 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        Boolean bool = this.f22081a;
        String str = this.f22082b;
        LinkedHashMap<String, String> linkedHashMap = this.f22083c;
        Map<String, String> map = this.f22084d;
        return "SurgeMap(hideHeatmapSelection=" + bool + ", tileCollectionId=" + str + ", categorisedTileCollectionId=" + linkedHashMap + ", labelPerCategory=" + map + ")";
    }
}
