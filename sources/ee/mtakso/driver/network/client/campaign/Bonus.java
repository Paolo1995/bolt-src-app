package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignV2.kt */
/* loaded from: classes3.dex */
public final class Bonus {
    @SerializedName("icon_url")

    /* renamed from: a  reason: collision with root package name */
    private final Image f21589a;
    @SerializedName("title")

    /* renamed from: b  reason: collision with root package name */
    private final String f21590b;
    @SerializedName("subtitle")

    /* renamed from: c  reason: collision with root package name */
    private final String f21591c;
    @SerializedName("description")

    /* renamed from: d  reason: collision with root package name */
    private final InfoBlock f21592d;
    @SerializedName("threshold")

    /* renamed from: e  reason: collision with root package name */
    private final ThresholdData f21593e;

    public final InfoBlock a() {
        return this.f21592d;
    }

    public final Image b() {
        return this.f21589a;
    }

    public final String c() {
        return this.f21591c;
    }

    public final ThresholdData d() {
        return this.f21593e;
    }

    public final String e() {
        return this.f21590b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Bonus) {
            Bonus bonus = (Bonus) obj;
            return Intrinsics.a(this.f21589a, bonus.f21589a) && Intrinsics.a(this.f21590b, bonus.f21590b) && Intrinsics.a(this.f21591c, bonus.f21591c) && Intrinsics.a(this.f21592d, bonus.f21592d) && Intrinsics.a(this.f21593e, bonus.f21593e);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f21589a.hashCode() * 31) + this.f21590b.hashCode()) * 31;
        String str = this.f21591c;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        InfoBlock infoBlock = this.f21592d;
        int hashCode3 = (hashCode2 + (infoBlock == null ? 0 : infoBlock.hashCode())) * 31;
        ThresholdData thresholdData = this.f21593e;
        return hashCode3 + (thresholdData != null ? thresholdData.hashCode() : 0);
    }

    public String toString() {
        Image image = this.f21589a;
        String str = this.f21590b;
        String str2 = this.f21591c;
        InfoBlock infoBlock = this.f21592d;
        ThresholdData thresholdData = this.f21593e;
        return "Bonus(icon=" + image + ", title=" + str + ", subtitle=" + str2 + ", description=" + infoBlock + ", threshold=" + thresholdData + ")";
    }
}
