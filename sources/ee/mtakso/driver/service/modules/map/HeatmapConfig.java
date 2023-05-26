package ee.mtakso.driver.service.modules.map;

import ee.mtakso.driver.network.client.driver.map.TileCollectionConfig;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeatmapConfig.kt */
/* loaded from: classes3.dex */
public final class HeatmapConfig {

    /* renamed from: a  reason: collision with root package name */
    private final String f24815a;

    /* renamed from: b  reason: collision with root package name */
    private final TileCollectionConfig f24816b;

    public HeatmapConfig(String str, TileCollectionConfig tileCollectionConfig) {
        this.f24815a = str;
        this.f24816b = tileCollectionConfig;
    }

    public final String a() {
        return this.f24815a;
    }

    public final TileCollectionConfig b() {
        return this.f24816b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HeatmapConfig) {
            HeatmapConfig heatmapConfig = (HeatmapConfig) obj;
            return Intrinsics.a(this.f24815a, heatmapConfig.f24815a) && Intrinsics.a(this.f24816b, heatmapConfig.f24816b);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f24815a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        TileCollectionConfig tileCollectionConfig = this.f24816b;
        return hashCode + (tileCollectionConfig != null ? tileCollectionConfig.hashCode() : 0);
    }

    public String toString() {
        String str = this.f24815a;
        TileCollectionConfig tileCollectionConfig = this.f24816b;
        return "HeatmapConfig(collectionId=" + str + ", config=" + tileCollectionConfig + ")";
    }
}
