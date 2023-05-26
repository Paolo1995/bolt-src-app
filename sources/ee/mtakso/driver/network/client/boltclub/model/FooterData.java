package ee.mtakso.driver.network.client.boltclub.model;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FooterData.kt */
/* loaded from: classes3.dex */
public final class FooterData {
    @SerializedName("html_body")

    /* renamed from: a  reason: collision with root package name */
    private final String f21552a;

    public final String a() {
        return this.f21552a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FooterData) && Intrinsics.a(this.f21552a, ((FooterData) obj).f21552a);
    }

    public int hashCode() {
        return this.f21552a.hashCode();
    }

    public String toString() {
        String str = this.f21552a;
        return "FooterData(htmlBody=" + str + ")";
    }
}
