package eu.bolt.driver.core.network.client.driver;

import com.google.gson.annotations.SerializedName;
import i0.a;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CarConfig.kt */
/* loaded from: classes5.dex */
public final class CarConfig {
    @SerializedName("selected_car_id")

    /* renamed from: a  reason: collision with root package name */
    private final long f40821a;
    @SerializedName("selected_car_name")

    /* renamed from: b  reason: collision with root package name */
    private final String f40822b;

    public final long a() {
        return this.f40821a;
    }

    public final String b() {
        return this.f40822b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CarConfig) {
            CarConfig carConfig = (CarConfig) obj;
            return this.f40821a == carConfig.f40821a && Intrinsics.a(this.f40822b, carConfig.f40822b);
        }
        return false;
    }

    public int hashCode() {
        return (a.a(this.f40821a) * 31) + this.f40822b.hashCode();
    }

    public String toString() {
        long j8 = this.f40821a;
        String str = this.f40822b;
        return "CarConfig(id=" + j8 + ", title=" + str + ")";
    }
}
