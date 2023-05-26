package ee.mtakso.driver.network.client.campaign;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignV2.kt */
/* loaded from: classes3.dex */
public final class BonusTrips {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f21594a;
    @SerializedName("description")

    /* renamed from: b  reason: collision with root package name */
    private final String f21595b;
    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.VALUE)

    /* renamed from: c  reason: collision with root package name */
    private final String f21596c;
    @SerializedName("progress")

    /* renamed from: d  reason: collision with root package name */
    private final Double f21597d;
    @SerializedName("status_brief")

    /* renamed from: e  reason: collision with root package name */
    private final String f21598e;
    @SerializedName("completed")

    /* renamed from: f  reason: collision with root package name */
    private final boolean f21599f;
    @SerializedName("finished")

    /* renamed from: g  reason: collision with root package name */
    private final boolean f21600g;

    public final String a() {
        return this.f21594a;
    }

    public final String b() {
        return this.f21596c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BonusTrips) {
            BonusTrips bonusTrips = (BonusTrips) obj;
            return Intrinsics.a(this.f21594a, bonusTrips.f21594a) && Intrinsics.a(this.f21595b, bonusTrips.f21595b) && Intrinsics.a(this.f21596c, bonusTrips.f21596c) && Intrinsics.a(this.f21597d, bonusTrips.f21597d) && Intrinsics.a(this.f21598e, bonusTrips.f21598e) && this.f21599f == bonusTrips.f21599f && this.f21600g == bonusTrips.f21600g;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f21594a.hashCode() * 31;
        String str = this.f21595b;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f21596c.hashCode()) * 31;
        Double d8 = this.f21597d;
        int hashCode3 = (hashCode2 + (d8 == null ? 0 : d8.hashCode())) * 31;
        String str2 = this.f21598e;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z7 = this.f21599f;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode4 + i8) * 31;
        boolean z8 = this.f21600g;
        return i9 + (z8 ? 1 : z8 ? 1 : 0);
    }

    public String toString() {
        String str = this.f21594a;
        String str2 = this.f21595b;
        String str3 = this.f21596c;
        Double d8 = this.f21597d;
        String str4 = this.f21598e;
        boolean z7 = this.f21599f;
        boolean z8 = this.f21600g;
        return "BonusTrips(title=" + str + ", description=" + str2 + ", value=" + str3 + ", progress=" + d8 + ", statusBrief=" + str4 + ", completed=" + z7 + ", finished=" + z8 + ")";
    }
}
