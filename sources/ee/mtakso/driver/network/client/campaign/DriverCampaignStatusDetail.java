package ee.mtakso.driver.network.client.campaign;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Campaign.kt */
/* loaded from: classes3.dex */
public final class DriverCampaignStatusDetail {
    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.VALUE)

    /* renamed from: a  reason: collision with root package name */
    private final DriverCampaignStatus f21650a;
    @SerializedName("long_explanation")

    /* renamed from: b  reason: collision with root package name */
    private final String f21651b;
    @SerializedName("short_explanation")

    /* renamed from: c  reason: collision with root package name */
    private final String f21652c;
    @SerializedName("earned")

    /* renamed from: d  reason: collision with root package name */
    private final String f21653d;

    public final String a() {
        return this.f21653d;
    }

    public final String b() {
        return this.f21652c;
    }

    public final DriverCampaignStatus c() {
        return this.f21650a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverCampaignStatusDetail) {
            DriverCampaignStatusDetail driverCampaignStatusDetail = (DriverCampaignStatusDetail) obj;
            return this.f21650a == driverCampaignStatusDetail.f21650a && Intrinsics.a(this.f21651b, driverCampaignStatusDetail.f21651b) && Intrinsics.a(this.f21652c, driverCampaignStatusDetail.f21652c) && Intrinsics.a(this.f21653d, driverCampaignStatusDetail.f21653d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f21650a.hashCode() * 31;
        String str = this.f21651b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f21652c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f21653d;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        DriverCampaignStatus driverCampaignStatus = this.f21650a;
        String str = this.f21651b;
        String str2 = this.f21652c;
        String str3 = this.f21653d;
        return "DriverCampaignStatusDetail(value=" + driverCampaignStatus + ", longExplanation=" + str + ", shortExplanation=" + str2 + ", earned=" + str3 + ")";
    }
}
