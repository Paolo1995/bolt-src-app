package ee.mtakso.driver.network.client.device;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceFingerprint.kt */
/* loaded from: classes3.dex */
public final class DeviceFingerprint {
    @SerializedName("json_data")

    /* renamed from: a  reason: collision with root package name */
    private final JsonObject f21869a;

    public DeviceFingerprint(JsonObject params) {
        Intrinsics.f(params, "params");
        this.f21869a = params;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DeviceFingerprint) && Intrinsics.a(this.f21869a, ((DeviceFingerprint) obj).f21869a);
    }

    public int hashCode() {
        return this.f21869a.hashCode();
    }

    public String toString() {
        JsonObject jsonObject = this.f21869a;
        return "DeviceFingerprint(params=" + jsonObject + ")";
    }
}
