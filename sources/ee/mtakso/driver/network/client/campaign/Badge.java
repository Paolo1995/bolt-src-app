package ee.mtakso.driver.network.client.campaign;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignV2.kt */
/* loaded from: classes3.dex */
public final class Badge {
    @SerializedName("icon_url")

    /* renamed from: a  reason: collision with root package name */
    private final Image f21586a;
    @SerializedName("text")

    /* renamed from: b  reason: collision with root package name */
    private final String f21587b;
    @SerializedName("type")

    /* renamed from: c  reason: collision with root package name */
    private final BadgeType f21588c;

    public final Image a() {
        return this.f21586a;
    }

    public final String b() {
        return this.f21587b;
    }

    public final BadgeType c() {
        return this.f21588c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Badge) {
            Badge badge = (Badge) obj;
            return Intrinsics.a(this.f21586a, badge.f21586a) && Intrinsics.a(this.f21587b, badge.f21587b) && this.f21588c == badge.f21588c;
        }
        return false;
    }

    public int hashCode() {
        Image image = this.f21586a;
        int hashCode = (image == null ? 0 : image.hashCode()) * 31;
        String str = this.f21587b;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f21588c.hashCode();
    }

    public String toString() {
        Image image = this.f21586a;
        String str = this.f21587b;
        BadgeType badgeType = this.f21588c;
        return "Badge(iconUrl=" + image + ", text=" + str + ", type=" + badgeType + ")";
    }
}
