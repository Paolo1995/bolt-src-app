package ee.mtakso.driver.network.client.driver.map;

import com.google.gson.annotations.SerializedName;
import eu.bolt.driver.earnings.network.DriverImage;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TileCollectionConfig.kt */
/* loaded from: classes3.dex */
public final class TileCollectionConfig {
    @SerializedName("tiles_collection_id")

    /* renamed from: a  reason: collision with root package name */
    private final String f22046a;
    @SerializedName("tiles_collection_id_per_category")

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f22047b;
    @SerializedName("default_properties")

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, DriverMapProperties> f22048c;
    @SerializedName("icons")

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, DriverImage> f22049d;

    public final Map<String, DriverMapProperties> a() {
        return this.f22048c;
    }

    public final Map<String, DriverImage> b() {
        return this.f22049d;
    }

    public final String c() {
        return this.f22046a;
    }

    public final Map<String, String> d() {
        return this.f22047b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TileCollectionConfig) {
            TileCollectionConfig tileCollectionConfig = (TileCollectionConfig) obj;
            return Intrinsics.a(this.f22046a, tileCollectionConfig.f22046a) && Intrinsics.a(this.f22047b, tileCollectionConfig.f22047b) && Intrinsics.a(this.f22048c, tileCollectionConfig.f22048c) && Intrinsics.a(this.f22049d, tileCollectionConfig.f22049d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22046a.hashCode() * 31;
        Map<String, String> map = this.f22047b;
        return ((((hashCode + (map == null ? 0 : map.hashCode())) * 31) + this.f22048c.hashCode()) * 31) + this.f22049d.hashCode();
    }

    public String toString() {
        String str = this.f22046a;
        Map<String, String> map = this.f22047b;
        Map<String, DriverMapProperties> map2 = this.f22048c;
        Map<String, DriverImage> map3 = this.f22049d;
        return "TileCollectionConfig(tilesCollectionId=" + str + ", tilesCollectionIdPerCategory=" + map + ", defaultProperties=" + map2 + ", icons=" + map3 + ")";
    }
}
