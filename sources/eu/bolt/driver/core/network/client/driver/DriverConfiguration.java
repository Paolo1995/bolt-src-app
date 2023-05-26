package eu.bolt.driver.core.network.client.driver;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverConfiguration.kt */
/* loaded from: classes5.dex */
public final class DriverConfiguration {
    @SerializedName("user")

    /* renamed from: a  reason: collision with root package name */
    private final DriverProfileConfig f40846a;
    @SerializedName("car")

    /* renamed from: b  reason: collision with root package name */
    private final CarConfig f40847b;
    @SerializedName("app")

    /* renamed from: c  reason: collision with root package name */
    private final DriverAppConfig f40848c;
    @SerializedName("features")

    /* renamed from: d  reason: collision with root package name */
    private final DriverFeaturesConfig f40849d;

    public final DriverAppConfig a() {
        return this.f40848c;
    }

    public final CarConfig b() {
        return this.f40847b;
    }

    public final DriverFeaturesConfig c() {
        return this.f40849d;
    }

    public final DriverProfileConfig d() {
        return this.f40846a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverConfiguration) {
            DriverConfiguration driverConfiguration = (DriverConfiguration) obj;
            return Intrinsics.a(this.f40846a, driverConfiguration.f40846a) && Intrinsics.a(this.f40847b, driverConfiguration.f40847b) && Intrinsics.a(this.f40848c, driverConfiguration.f40848c) && Intrinsics.a(this.f40849d, driverConfiguration.f40849d);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f40846a.hashCode() * 31) + this.f40847b.hashCode()) * 31) + this.f40848c.hashCode()) * 31) + this.f40849d.hashCode();
    }

    public String toString() {
        DriverProfileConfig driverProfileConfig = this.f40846a;
        CarConfig carConfig = this.f40847b;
        DriverAppConfig driverAppConfig = this.f40848c;
        DriverFeaturesConfig driverFeaturesConfig = this.f40849d;
        return "DriverConfiguration(profile=" + driverProfileConfig + ", car=" + carConfig + ", app=" + driverAppConfig + ", features=" + driverFeaturesConfig + ")";
    }
}
