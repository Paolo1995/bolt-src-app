package ee.mtakso.driver.network.client.contact;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AvailableContactOptions.kt */
/* loaded from: classes3.dex */
public final class ChatDetailsData {
    @SerializedName("date")

    /* renamed from: a  reason: collision with root package name */
    private final long f21766a;
    @SerializedName("title")

    /* renamed from: b  reason: collision with root package name */
    private final String f21767b;
    @SerializedName("description")

    /* renamed from: c  reason: collision with root package name */
    private final String f21768c;

    public final long a() {
        return this.f21766a;
    }

    public final String b() {
        return this.f21768c;
    }

    public final String c() {
        return this.f21767b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatDetailsData) {
            ChatDetailsData chatDetailsData = (ChatDetailsData) obj;
            return this.f21766a == chatDetailsData.f21766a && Intrinsics.a(this.f21767b, chatDetailsData.f21767b) && Intrinsics.a(this.f21768c, chatDetailsData.f21768c);
        }
        return false;
    }

    public int hashCode() {
        return (((i0.a.a(this.f21766a) * 31) + this.f21767b.hashCode()) * 31) + this.f21768c.hashCode();
    }

    public String toString() {
        long j8 = this.f21766a;
        String str = this.f21767b;
        String str2 = this.f21768c;
        return "ChatDetailsData(date=" + j8 + ", title=" + str + ", description=" + str2 + ")";
    }
}
