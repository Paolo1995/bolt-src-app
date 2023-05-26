package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Campaign.kt */
/* loaded from: classes3.dex */
public final class DriverCampaignThresholdCondition implements DriverCampaignCondition {
    @SerializedName("type")

    /* renamed from: a  reason: collision with root package name */
    private final DriverCampaignConditionType f21654a;
    @SerializedName("title")

    /* renamed from: b  reason: collision with root package name */
    private final String f21655b;
    @SerializedName("overview")

    /* renamed from: c  reason: collision with root package name */
    private final String f21656c;
    @SerializedName("terms_explanation")

    /* renamed from: d  reason: collision with root package name */
    private final String f21657d;
    @SerializedName("status_success")

    /* renamed from: e  reason: collision with root package name */
    private final boolean f21658e;
    @SerializedName("status_current")

    /* renamed from: f  reason: collision with root package name */
    private final String f21659f;
    @SerializedName("status_threshold")

    /* renamed from: g  reason: collision with root package name */
    private final String f21660g;

    @Override // ee.mtakso.driver.network.client.campaign.DriverCampaignCondition
    public boolean a() {
        return this.f21658e;
    }

    @Override // ee.mtakso.driver.network.client.campaign.DriverCampaignCondition
    public String b() {
        return this.f21656c;
    }

    @Override // ee.mtakso.driver.network.client.campaign.DriverCampaignCondition
    public String c() {
        return this.f21657d;
    }

    public final String d() {
        return this.f21659f;
    }

    public final String e() {
        return this.f21660g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverCampaignThresholdCondition) {
            DriverCampaignThresholdCondition driverCampaignThresholdCondition = (DriverCampaignThresholdCondition) obj;
            return f() == driverCampaignThresholdCondition.f() && Intrinsics.a(getTitle(), driverCampaignThresholdCondition.getTitle()) && Intrinsics.a(b(), driverCampaignThresholdCondition.b()) && Intrinsics.a(c(), driverCampaignThresholdCondition.c()) && a() == driverCampaignThresholdCondition.a() && Intrinsics.a(this.f21659f, driverCampaignThresholdCondition.f21659f) && Intrinsics.a(this.f21660g, driverCampaignThresholdCondition.f21660g);
        }
        return false;
    }

    public DriverCampaignConditionType f() {
        return this.f21654a;
    }

    @Override // ee.mtakso.driver.network.client.campaign.DriverCampaignCondition
    public String getTitle() {
        return this.f21655b;
    }

    public int hashCode() {
        int hashCode = ((((((f().hashCode() * 31) + getTitle().hashCode()) * 31) + b().hashCode()) * 31) + (c() == null ? 0 : c().hashCode())) * 31;
        boolean a8 = a();
        int i8 = a8;
        if (a8) {
            i8 = 1;
        }
        return ((((hashCode + i8) * 31) + this.f21659f.hashCode()) * 31) + this.f21660g.hashCode();
    }

    public String toString() {
        DriverCampaignConditionType f8 = f();
        String title = getTitle();
        String b8 = b();
        String c8 = c();
        boolean a8 = a();
        String str = this.f21659f;
        String str2 = this.f21660g;
        return "DriverCampaignThresholdCondition(type=" + f8 + ", title=" + title + ", overview=" + b8 + ", termsExplanation=" + c8 + ", statusSuccess=" + a8 + ", statusCurrent=" + str + ", statusThreshold=" + str2 + ")";
    }
}
