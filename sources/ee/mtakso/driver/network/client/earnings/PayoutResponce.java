package ee.mtakso.driver.network.client.earnings;

import com.google.gson.annotations.SerializedName;
import i0.a;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: PayoutResponce.kt */
/* loaded from: classes3.dex */
public final class PayoutResponce {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final long f22151a;
    @SerializedName("state")

    /* renamed from: b  reason: collision with root package name */
    private final PayoutState f22152b;
    @SerializedName("amount")

    /* renamed from: c  reason: collision with root package name */
    private final String f22153c;
    @SerializedName("amount_comment")

    /* renamed from: d  reason: collision with root package name */
    private final String f22154d;
    @SerializedName("receipt")

    /* renamed from: e  reason: collision with root package name */
    private final String f22155e;
    @SerializedName("review_payment_details")

    /* renamed from: f  reason: collision with root package name */
    private final String f22156f;
    @SerializedName("rejection_help")

    /* renamed from: g  reason: collision with root package name */
    private final String f22157g;
    @SerializedName("details")

    /* renamed from: h  reason: collision with root package name */
    private final DetailsSection f22158h;
    @SerializedName("progress")

    /* renamed from: i  reason: collision with root package name */
    private final ProgressSection f22159i;

    public final String a() {
        return this.f22153c;
    }

    public final String b() {
        return this.f22154d;
    }

    public final DetailsSection c() {
        return this.f22158h;
    }

    public final ProgressSection d() {
        return this.f22159i;
    }

    public final String e() {
        return this.f22155e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PayoutResponce) {
            PayoutResponce payoutResponce = (PayoutResponce) obj;
            return this.f22151a == payoutResponce.f22151a && this.f22152b == payoutResponce.f22152b && Intrinsics.a(this.f22153c, payoutResponce.f22153c) && Intrinsics.a(this.f22154d, payoutResponce.f22154d) && Intrinsics.a(this.f22155e, payoutResponce.f22155e) && Intrinsics.a(this.f22156f, payoutResponce.f22156f) && Intrinsics.a(this.f22157g, payoutResponce.f22157g) && Intrinsics.a(this.f22158h, payoutResponce.f22158h) && Intrinsics.a(this.f22159i, payoutResponce.f22159i);
        }
        return false;
    }

    public final String f() {
        return this.f22157g;
    }

    public final String g() {
        return this.f22156f;
    }

    public final PayoutState h() {
        return this.f22152b;
    }

    public int hashCode() {
        int a8 = ((((a.a(this.f22151a) * 31) + this.f22152b.hashCode()) * 31) + this.f22153c.hashCode()) * 31;
        String str = this.f22154d;
        int hashCode = (a8 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f22155e;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f22156f;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f22157g;
        int hashCode4 = (((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.f22158h.hashCode()) * 31;
        ProgressSection progressSection = this.f22159i;
        return hashCode4 + (progressSection != null ? progressSection.hashCode() : 0);
    }

    public String toString() {
        long j8 = this.f22151a;
        PayoutState payoutState = this.f22152b;
        String str = this.f22153c;
        String str2 = this.f22154d;
        String str3 = this.f22155e;
        String str4 = this.f22156f;
        String str5 = this.f22157g;
        DetailsSection detailsSection = this.f22158h;
        ProgressSection progressSection = this.f22159i;
        return "PayoutResponce(id=" + j8 + ", state=" + payoutState + ", amount=" + str + ", amountComment=" + str2 + ", receipt=" + str3 + ", reviewDetailsLink=" + str4 + ", rejectionHelpLink=" + str5 + ", details=" + detailsSection + ", progress=" + progressSection + ")";
    }
}
