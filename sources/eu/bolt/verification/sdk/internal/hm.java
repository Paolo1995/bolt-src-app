package eu.bolt.verification.sdk.internal;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class hm {
    @SerializedName("event_name")

    /* renamed from: a  reason: collision with root package name */
    private final String f43417a;
    @SerializedName("parameters")

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f43418b;

    public final String a() {
        return this.f43417a;
    }

    public final Map<String, String> b() {
        return this.f43418b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof hm) {
            hm hmVar = (hm) obj;
            return Intrinsics.a(this.f43417a, hmVar.f43417a) && Intrinsics.a(this.f43418b, hmVar.f43418b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f43417a.hashCode() * 31) + this.f43418b.hashCode();
    }

    public String toString() {
        String str = this.f43417a;
        Map<String, String> map = this.f43418b;
        return "VerificationActionAnalyticsNetworkModel(eventName=" + str + ", parameters=" + map + ")";
    }
}
