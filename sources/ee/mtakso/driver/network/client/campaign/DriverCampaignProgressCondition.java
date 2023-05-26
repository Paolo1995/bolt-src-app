package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Campaign.kt */
/* loaded from: classes3.dex */
public final class DriverCampaignProgressCondition implements DriverCampaignCondition {
    @SerializedName("type")

    /* renamed from: a  reason: collision with root package name */
    private final DriverCampaignConditionType f21643a;
    @SerializedName("title")

    /* renamed from: b  reason: collision with root package name */
    private final String f21644b;
    @SerializedName("overview")

    /* renamed from: c  reason: collision with root package name */
    private final String f21645c;
    @SerializedName("terms_explanation")

    /* renamed from: d  reason: collision with root package name */
    private final String f21646d;
    @SerializedName("status_success")

    /* renamed from: e  reason: collision with root package name */
    private final boolean f21647e;
    @SerializedName("status_description")

    /* renamed from: f  reason: collision with root package name */
    private final String f21648f;
    @SerializedName("status_value")

    /* renamed from: g  reason: collision with root package name */
    private final float f21649g;

    @Override // ee.mtakso.driver.network.client.campaign.DriverCampaignCondition
    public boolean a() {
        return this.f21647e;
    }

    @Override // ee.mtakso.driver.network.client.campaign.DriverCampaignCondition
    public String b() {
        return this.f21645c;
    }

    @Override // ee.mtakso.driver.network.client.campaign.DriverCampaignCondition
    public String c() {
        return this.f21646d;
    }

    public final String d() {
        return this.f21648f;
    }

    public final float e() {
        return this.f21649g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverCampaignProgressCondition) {
            DriverCampaignProgressCondition driverCampaignProgressCondition = (DriverCampaignProgressCondition) obj;
            return f() == driverCampaignProgressCondition.f() && Intrinsics.a(getTitle(), driverCampaignProgressCondition.getTitle()) && Intrinsics.a(b(), driverCampaignProgressCondition.b()) && Intrinsics.a(c(), driverCampaignProgressCondition.c()) && a() == driverCampaignProgressCondition.a() && Intrinsics.a(this.f21648f, driverCampaignProgressCondition.f21648f) && Float.compare(this.f21649g, driverCampaignProgressCondition.f21649g) == 0;
        }
        return false;
    }

    public DriverCampaignConditionType f() {
        return this.f21643a;
    }

    @Override // ee.mtakso.driver.network.client.campaign.DriverCampaignCondition
    public String getTitle() {
        return this.f21644b;
    }

    public int hashCode() {
        int hashCode = ((((((f().hashCode() * 31) + getTitle().hashCode()) * 31) + b().hashCode()) * 31) + (c() == null ? 0 : c().hashCode())) * 31;
        boolean a8 = a();
        int i8 = a8;
        if (a8) {
            i8 = 1;
        }
        return ((((hashCode + i8) * 31) + this.f21648f.hashCode()) * 31) + Float.floatToIntBits(this.f21649g);
    }

    public String toString() {
        DriverCampaignConditionType f8 = f();
        String title = getTitle();
        String b8 = b();
        String c8 = c();
        boolean a8 = a();
        String str = this.f21648f;
        float f9 = this.f21649g;
        return "DriverCampaignProgressCondition(type=" + f8 + ", title=" + title + ", overview=" + b8 + ", termsExplanation=" + c8 + ", statusSuccess=" + a8 + ", statusDescription=" + str + ", statusValue=" + f9 + ")";
    }
}
