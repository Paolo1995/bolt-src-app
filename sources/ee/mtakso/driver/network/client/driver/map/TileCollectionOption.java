package ee.mtakso.driver.network.client.driver.map;

import com.google.gson.annotations.SerializedName;
import eu.bolt.driver.earnings.network.DriverImage;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TileCollectionOption.kt */
/* loaded from: classes3.dex */
public final class TileCollectionOption {
    @SerializedName("tile_collection")

    /* renamed from: a  reason: collision with root package name */
    private final String f22050a;
    @SerializedName("picker_option_icon")

    /* renamed from: b  reason: collision with root package name */
    private final DriverImage f22051b;
    @SerializedName("badge_icon")

    /* renamed from: c  reason: collision with root package name */
    private final DriverImage f22052c;
    @SerializedName("title")

    /* renamed from: d  reason: collision with root package name */
    private final String f22053d;
    @SerializedName("description")

    /* renamed from: e  reason: collision with root package name */
    private final String f22054e;
    @SerializedName("is_default")

    /* renamed from: f  reason: collision with root package name */
    private final Boolean f22055f;

    public final DriverImage a() {
        return this.f22052c;
    }

    public final String b() {
        return this.f22054e;
    }

    public final DriverImage c() {
        return this.f22051b;
    }

    public final String d() {
        return this.f22050a;
    }

    public final String e() {
        return this.f22053d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TileCollectionOption) {
            TileCollectionOption tileCollectionOption = (TileCollectionOption) obj;
            return Intrinsics.a(this.f22050a, tileCollectionOption.f22050a) && Intrinsics.a(this.f22051b, tileCollectionOption.f22051b) && Intrinsics.a(this.f22052c, tileCollectionOption.f22052c) && Intrinsics.a(this.f22053d, tileCollectionOption.f22053d) && Intrinsics.a(this.f22054e, tileCollectionOption.f22054e) && Intrinsics.a(this.f22055f, tileCollectionOption.f22055f);
        }
        return false;
    }

    public final Boolean f() {
        return this.f22055f;
    }

    public int hashCode() {
        int hashCode = ((this.f22050a.hashCode() * 31) + this.f22051b.hashCode()) * 31;
        DriverImage driverImage = this.f22052c;
        int hashCode2 = (((((hashCode + (driverImage == null ? 0 : driverImage.hashCode())) * 31) + this.f22053d.hashCode()) * 31) + this.f22054e.hashCode()) * 31;
        Boolean bool = this.f22055f;
        return hashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        String str = this.f22050a;
        DriverImage driverImage = this.f22051b;
        DriverImage driverImage2 = this.f22052c;
        String str2 = this.f22053d;
        String str3 = this.f22054e;
        Boolean bool = this.f22055f;
        return "TileCollectionOption(tileCollection=" + str + ", pickerOptionIcon=" + driverImage + ", badgeIcon=" + driverImage2 + ", title=" + str2 + ", description=" + str3 + ", isDefault=" + bool + ")";
    }
}
