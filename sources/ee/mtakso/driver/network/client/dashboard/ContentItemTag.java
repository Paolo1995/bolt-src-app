package ee.mtakso.driver.network.client.dashboard;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DashboardContentItem.kt */
/* loaded from: classes3.dex */
public final class ContentItemTag {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f21816a;
    @SerializedName("severity")

    /* renamed from: b  reason: collision with root package name */
    private final TagSeverity f21817b;

    public final TagSeverity a() {
        return this.f21817b;
    }

    public final String b() {
        return this.f21816a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ContentItemTag) {
            ContentItemTag contentItemTag = (ContentItemTag) obj;
            return Intrinsics.a(this.f21816a, contentItemTag.f21816a) && this.f21817b == contentItemTag.f21817b;
        }
        return false;
    }

    public int hashCode() {
        return (this.f21816a.hashCode() * 31) + this.f21817b.hashCode();
    }

    public String toString() {
        String str = this.f21816a;
        TagSeverity tagSeverity = this.f21817b;
        return "ContentItemTag(title=" + str + ", severity=" + tagSeverity + ")";
    }
}
