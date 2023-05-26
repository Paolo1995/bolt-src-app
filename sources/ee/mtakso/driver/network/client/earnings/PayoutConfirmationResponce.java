package ee.mtakso.driver.network.client.earnings;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.generic.GenericSection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayoutConfirmationResponce.kt */
/* loaded from: classes3.dex */
public final class PayoutConfirmationResponce {
    @SerializedName("sections")

    /* renamed from: a  reason: collision with root package name */
    private final List<GenericSection> f22141a;
    @SerializedName("comment")

    /* renamed from: b  reason: collision with root package name */
    private final String f22142b;
    @SerializedName("info")

    /* renamed from: c  reason: collision with root package name */
    private final String f22143c;
    @SerializedName("confirmation_id")

    /* renamed from: d  reason: collision with root package name */
    private final String f22144d;

    public final String a() {
        return this.f22142b;
    }

    public final String b() {
        return this.f22144d;
    }

    public final String c() {
        return this.f22143c;
    }

    public final List<GenericSection> d() {
        return this.f22141a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PayoutConfirmationResponce) {
            PayoutConfirmationResponce payoutConfirmationResponce = (PayoutConfirmationResponce) obj;
            return Intrinsics.a(this.f22141a, payoutConfirmationResponce.f22141a) && Intrinsics.a(this.f22142b, payoutConfirmationResponce.f22142b) && Intrinsics.a(this.f22143c, payoutConfirmationResponce.f22143c) && Intrinsics.a(this.f22144d, payoutConfirmationResponce.f22144d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22141a.hashCode() * 31;
        String str = this.f22142b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f22143c;
        return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f22144d.hashCode();
    }

    public String toString() {
        List<GenericSection> list = this.f22141a;
        String str = this.f22142b;
        String str2 = this.f22143c;
        String str3 = this.f22144d;
        return "PayoutConfirmationResponce(sections=" + list + ", comment=" + str + ", info=" + str2 + ", confirmationId=" + str3 + ")";
    }
}
