package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignV2.kt */
/* loaded from: classes3.dex */
public final class ThresholdData {
    @SerializedName("before")

    /* renamed from: a  reason: collision with root package name */
    private final String f21741a;
    @SerializedName("after")

    /* renamed from: b  reason: collision with root package name */
    private final String f21742b;
    @SerializedName("bonus")

    /* renamed from: c  reason: collision with root package name */
    private final String f21743c;
    @SerializedName("threshold_value")

    /* renamed from: d  reason: collision with root package name */
    private final int f21744d;

    public final String a() {
        return this.f21742b;
    }

    public final String b() {
        return this.f21741a;
    }

    public final String c() {
        return this.f21743c;
    }

    public final int d() {
        return this.f21744d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ThresholdData) {
            ThresholdData thresholdData = (ThresholdData) obj;
            return Intrinsics.a(this.f21741a, thresholdData.f21741a) && Intrinsics.a(this.f21742b, thresholdData.f21742b) && Intrinsics.a(this.f21743c, thresholdData.f21743c) && this.f21744d == thresholdData.f21744d;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f21741a.hashCode() * 31) + this.f21742b.hashCode()) * 31) + this.f21743c.hashCode()) * 31) + this.f21744d;
    }

    public String toString() {
        String str = this.f21741a;
        String str2 = this.f21742b;
        String str3 = this.f21743c;
        int i8 = this.f21744d;
        return "ThresholdData(before=" + str + ", after=" + str2 + ", bonus=" + str3 + ", thresholdValue=" + i8 + ")";
    }
}
