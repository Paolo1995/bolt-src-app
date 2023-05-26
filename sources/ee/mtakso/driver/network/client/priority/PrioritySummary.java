package ee.mtakso.driver.network.client.priority;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverPriorityResponse.kt */
/* loaded from: classes3.dex */
public final class PrioritySummary {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f22692a;
    @SerializedName("image_url")

    /* renamed from: b  reason: collision with root package name */
    private final String f22693b;
    @SerializedName("subtitles")

    /* renamed from: c  reason: collision with root package name */
    private final List<ContentItem> f22694c;

    public final String a() {
        return this.f22693b;
    }

    public final List<ContentItem> b() {
        return this.f22694c;
    }

    public final String c() {
        return this.f22692a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PrioritySummary) {
            PrioritySummary prioritySummary = (PrioritySummary) obj;
            return Intrinsics.a(this.f22692a, prioritySummary.f22692a) && Intrinsics.a(this.f22693b, prioritySummary.f22693b) && Intrinsics.a(this.f22694c, prioritySummary.f22694c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f22692a.hashCode() * 31) + this.f22693b.hashCode()) * 31) + this.f22694c.hashCode();
    }

    public String toString() {
        String str = this.f22692a;
        String str2 = this.f22693b;
        List<ContentItem> list = this.f22694c;
        return "PrioritySummary(title=" + str + ", imageUrl=" + str2 + ", subtitles=" + list + ")";
    }
}
