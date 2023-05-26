package eu.bolt.driver.earnings.network;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverColor.kt */
/* loaded from: classes5.dex */
public final class DriverColor {
    @SerializedName("light")
    @JsonAdapter(HexColorStringDeserializer.class)

    /* renamed from: a  reason: collision with root package name */
    private final int f41365a;
    @SerializedName("dark")
    @JsonAdapter(HexColorStringDeserializer.class)

    /* renamed from: b  reason: collision with root package name */
    private final Integer f41366b;

    public final Integer a() {
        return this.f41366b;
    }

    public final int b() {
        return this.f41365a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverColor) {
            DriverColor driverColor = (DriverColor) obj;
            return this.f41365a == driverColor.f41365a && Intrinsics.a(this.f41366b, driverColor.f41366b);
        }
        return false;
    }

    public int hashCode() {
        int i8 = this.f41365a * 31;
        Integer num = this.f41366b;
        return i8 + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        int i8 = this.f41365a;
        Integer num = this.f41366b;
        return "DriverColor(light=" + i8 + ", dark=" + num + ")";
    }
}
