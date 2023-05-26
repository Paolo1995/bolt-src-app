package ee.mtakso.driver.network.client.dashboard;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DashboardContentItem.kt */
/* loaded from: classes3.dex */
public final class ContentItemBadge {
    @SerializedName("text")

    /* renamed from: a  reason: collision with root package name */
    private final String f21812a;
    @SerializedName("tintable_icon_url")

    /* renamed from: b  reason: collision with root package name */
    private final String f21813b;

    public final String a() {
        return this.f21813b;
    }

    public final String b() {
        return this.f21812a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ContentItemBadge) {
            ContentItemBadge contentItemBadge = (ContentItemBadge) obj;
            return Intrinsics.a(this.f21812a, contentItemBadge.f21812a) && Intrinsics.a(this.f21813b, contentItemBadge.f21813b);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f21812a.hashCode() * 31;
        String str = this.f21813b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.f21812a;
        String str2 = this.f21813b;
        return "ContentItemBadge(text=" + str + ", iconUrl=" + str2 + ")";
    }
}
