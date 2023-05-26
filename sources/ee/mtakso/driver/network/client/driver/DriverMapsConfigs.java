package ee.mtakso.driver.network.client.driver;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.driver.map.TileCollectionConfig;
import ee.mtakso.driver.network.client.driver.map.TileCollectionsPickerUi;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverMapsConfigs.kt */
/* loaded from: classes3.dex */
public final class DriverMapsConfigs {
    @SerializedName("poll_interval_sec")

    /* renamed from: a  reason: collision with root package name */
    private final Long f21928a;
    @SerializedName("tile_collections")

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, TileCollectionConfig> f21929b;
    @SerializedName("tile_collections_picker_ui")

    /* renamed from: c  reason: collision with root package name */
    private final TileCollectionsPickerUi f21930c;

    public final Long a() {
        return this.f21928a;
    }

    public final Map<String, TileCollectionConfig> b() {
        return this.f21929b;
    }

    public final TileCollectionsPickerUi c() {
        return this.f21930c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverMapsConfigs) {
            DriverMapsConfigs driverMapsConfigs = (DriverMapsConfigs) obj;
            return Intrinsics.a(this.f21928a, driverMapsConfigs.f21928a) && Intrinsics.a(this.f21929b, driverMapsConfigs.f21929b) && Intrinsics.a(this.f21930c, driverMapsConfigs.f21930c);
        }
        return false;
    }

    public int hashCode() {
        Long l8 = this.f21928a;
        int hashCode = (((l8 == null ? 0 : l8.hashCode()) * 31) + this.f21929b.hashCode()) * 31;
        TileCollectionsPickerUi tileCollectionsPickerUi = this.f21930c;
        return hashCode + (tileCollectionsPickerUi != null ? tileCollectionsPickerUi.hashCode() : 0);
    }

    public String toString() {
        Long l8 = this.f21928a;
        Map<String, TileCollectionConfig> map = this.f21929b;
        TileCollectionsPickerUi tileCollectionsPickerUi = this.f21930c;
        return "DriverMapsConfigs(pollIntervalSec=" + l8 + ", tileCollections=" + map + ", tileCollectionsPickerUi=" + tileCollectionsPickerUi + ")";
    }
}
