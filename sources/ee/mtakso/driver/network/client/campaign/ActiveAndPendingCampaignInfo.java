package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.Coordinates;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActiveAndPendingCampaignInfo.kt */
/* loaded from: classes3.dex */
public final class ActiveAndPendingCampaignInfo {
    @SerializedName("number_of_active_campaigns")

    /* renamed from: a  reason: collision with root package name */
    private final int f21575a;
    @SerializedName("is_any_active_campaign_fulfilled")

    /* renamed from: b  reason: collision with root package name */
    private final boolean f21576b;
    @SerializedName("geo_campaigns")

    /* renamed from: c  reason: collision with root package name */
    private final List<GeoCampaign> f21577c;

    /* compiled from: ActiveAndPendingCampaignInfo.kt */
    /* loaded from: classes3.dex */
    public static final class GeoCampaign {
        @SerializedName("title")

        /* renamed from: a  reason: collision with root package name */
        private final String f21578a;
        @SerializedName("subtitle")

        /* renamed from: b  reason: collision with root package name */
        private final String f21579b;
        @SerializedName("icon_url")

        /* renamed from: c  reason: collision with root package name */
        private final Image f21580c;
        @SerializedName("polygon")

        /* renamed from: d  reason: collision with root package name */
        private final List<Coordinates> f21581d;

        public final Image a() {
            return this.f21580c;
        }

        public final List<Coordinates> b() {
            return this.f21581d;
        }

        public final String c() {
            return this.f21579b;
        }

        public final String d() {
            return this.f21578a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof GeoCampaign) {
                GeoCampaign geoCampaign = (GeoCampaign) obj;
                return Intrinsics.a(this.f21578a, geoCampaign.f21578a) && Intrinsics.a(this.f21579b, geoCampaign.f21579b) && Intrinsics.a(this.f21580c, geoCampaign.f21580c) && Intrinsics.a(this.f21581d, geoCampaign.f21581d);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f21578a.hashCode() * 31) + this.f21579b.hashCode()) * 31) + this.f21580c.hashCode()) * 31) + this.f21581d.hashCode();
        }

        public String toString() {
            String str = this.f21578a;
            String str2 = this.f21579b;
            Image image = this.f21580c;
            List<Coordinates> list = this.f21581d;
            return "GeoCampaign(title=" + str + ", subtitle=" + str2 + ", iconURL=" + image + ", polygon=" + list + ")";
        }
    }

    public final List<GeoCampaign> a() {
        return this.f21577c;
    }

    public final int b() {
        return this.f21575a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActiveAndPendingCampaignInfo) {
            ActiveAndPendingCampaignInfo activeAndPendingCampaignInfo = (ActiveAndPendingCampaignInfo) obj;
            return this.f21575a == activeAndPendingCampaignInfo.f21575a && this.f21576b == activeAndPendingCampaignInfo.f21576b && Intrinsics.a(this.f21577c, activeAndPendingCampaignInfo.f21577c);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i8 = this.f21575a * 31;
        boolean z7 = this.f21576b;
        int i9 = z7;
        if (z7 != 0) {
            i9 = 1;
        }
        int i10 = (i8 + i9) * 31;
        List<GeoCampaign> list = this.f21577c;
        return i10 + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        int i8 = this.f21575a;
        boolean z7 = this.f21576b;
        List<GeoCampaign> list = this.f21577c;
        return "ActiveAndPendingCampaignInfo(numberOfActiveCampaigns=" + i8 + ", isAnyActiveCampaignFulfilled=" + z7 + ", geoCampaigns=" + list + ")";
    }
}
