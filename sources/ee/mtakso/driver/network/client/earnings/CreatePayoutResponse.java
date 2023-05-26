package ee.mtakso.driver.network.client.earnings;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CreatePayoutResponse.kt */
/* loaded from: classes3.dex */
public final class CreatePayoutResponse {
    @SerializedName("text")

    /* renamed from: a  reason: collision with root package name */
    private final String f22090a;
    @SerializedName("comment")

    /* renamed from: b  reason: collision with root package name */
    private final String f22091b;

    public final String a() {
        return this.f22091b;
    }

    public final String b() {
        return this.f22090a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CreatePayoutResponse) {
            CreatePayoutResponse createPayoutResponse = (CreatePayoutResponse) obj;
            return Intrinsics.a(this.f22090a, createPayoutResponse.f22090a) && Intrinsics.a(this.f22091b, createPayoutResponse.f22091b);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22090a.hashCode() * 31;
        String str = this.f22091b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.f22090a;
        String str2 = this.f22091b;
        return "CreatePayoutResponse(text=" + str + ", comment=" + str2 + ")";
    }
}
