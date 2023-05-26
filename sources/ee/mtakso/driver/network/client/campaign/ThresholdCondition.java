package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignV2.kt */
/* loaded from: classes3.dex */
public final class ThresholdCondition {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f21735a;
    @SerializedName("overview")

    /* renamed from: b  reason: collision with root package name */
    private final String f21736b;
    @SerializedName("terms_explanation")

    /* renamed from: c  reason: collision with root package name */
    private final String f21737c;
    @SerializedName("status_current")

    /* renamed from: d  reason: collision with root package name */
    private final String f21738d;
    @SerializedName("status_threshold")

    /* renamed from: e  reason: collision with root package name */
    private final String f21739e;
    @SerializedName("status_success")

    /* renamed from: f  reason: collision with root package name */
    private final boolean f21740f;

    public final String a() {
        return this.f21736b;
    }

    public final String b() {
        return this.f21738d;
    }

    public final boolean c() {
        return this.f21740f;
    }

    public final String d() {
        return this.f21739e;
    }

    public final String e() {
        return this.f21737c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ThresholdCondition) {
            ThresholdCondition thresholdCondition = (ThresholdCondition) obj;
            return Intrinsics.a(this.f21735a, thresholdCondition.f21735a) && Intrinsics.a(this.f21736b, thresholdCondition.f21736b) && Intrinsics.a(this.f21737c, thresholdCondition.f21737c) && Intrinsics.a(this.f21738d, thresholdCondition.f21738d) && Intrinsics.a(this.f21739e, thresholdCondition.f21739e) && this.f21740f == thresholdCondition.f21740f;
        }
        return false;
    }

    public final String f() {
        return this.f21735a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f21735a.hashCode() * 31) + this.f21736b.hashCode()) * 31;
        String str = this.f21737c;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f21738d.hashCode()) * 31) + this.f21739e.hashCode()) * 31;
        boolean z7 = this.f21740f;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode2 + i8;
    }

    public String toString() {
        String str = this.f21735a;
        String str2 = this.f21736b;
        String str3 = this.f21737c;
        String str4 = this.f21738d;
        String str5 = this.f21739e;
        boolean z7 = this.f21740f;
        return "ThresholdCondition(title=" + str + ", overview=" + str2 + ", termsExplanation=" + str3 + ", statusCurrent=" + str4 + ", statusThreshold=" + str5 + ", statusSuccess=" + z7 + ")";
    }
}
