package eu.bolt.driver.core.network.client.driver;

import com.google.gson.annotations.SerializedName;
import i0.a;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: DriverProfileConfig.kt */
/* loaded from: classes5.dex */
public final class DriverProfileConfig {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final long f40865a;
    @SerializedName("partner_id")

    /* renamed from: b  reason: collision with root package name */
    private final long f40866b;
    @SerializedName("city_name")

    /* renamed from: c  reason: collision with root package name */
    private final String f40867c;
    @SerializedName("company_id")

    /* renamed from: d  reason: collision with root package name */
    private final long f40868d;
    @SerializedName("country")

    /* renamed from: e  reason: collision with root package name */
    private final String f40869e;
    @SerializedName("docs_expire_in_days")

    /* renamed from: f  reason: collision with root package name */
    private final Integer f40870f;
    @SerializedName("driver_language")

    /* renamed from: g  reason: collision with root package name */
    private final String f40871g;
    @SerializedName("driver_operator_name")

    /* renamed from: h  reason: collision with root package name */
    private final String f40872h;
    @SerializedName("emergency_phone_number")

    /* renamed from: i  reason: collision with root package name */
    private final String f40873i;
    @SerializedName("name")

    /* renamed from: j  reason: collision with root package name */
    private final String f40874j;
    @SerializedName("phone")

    /* renamed from: k  reason: collision with root package name */
    private final String f40875k;
    @SerializedName("referral_code")

    /* renamed from: l  reason: collision with root package name */
    private final String f40876l;
    @SerializedName("analytics_id")

    /* renamed from: m  reason: collision with root package name */
    private final String f40877m;

    public final String a() {
        return this.f40877m;
    }

    public final String b() {
        return this.f40867c;
    }

    public final long c() {
        return this.f40868d;
    }

    public final String d() {
        return this.f40869e;
    }

    public final Integer e() {
        return this.f40870f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverProfileConfig) {
            DriverProfileConfig driverProfileConfig = (DriverProfileConfig) obj;
            return this.f40865a == driverProfileConfig.f40865a && this.f40866b == driverProfileConfig.f40866b && Intrinsics.a(this.f40867c, driverProfileConfig.f40867c) && this.f40868d == driverProfileConfig.f40868d && Intrinsics.a(this.f40869e, driverProfileConfig.f40869e) && Intrinsics.a(this.f40870f, driverProfileConfig.f40870f) && Intrinsics.a(this.f40871g, driverProfileConfig.f40871g) && Intrinsics.a(this.f40872h, driverProfileConfig.f40872h) && Intrinsics.a(this.f40873i, driverProfileConfig.f40873i) && Intrinsics.a(this.f40874j, driverProfileConfig.f40874j) && Intrinsics.a(this.f40875k, driverProfileConfig.f40875k) && Intrinsics.a(this.f40876l, driverProfileConfig.f40876l) && Intrinsics.a(this.f40877m, driverProfileConfig.f40877m);
        }
        return false;
    }

    public final String f() {
        return this.f40871g;
    }

    public final String g() {
        return this.f40872h;
    }

    public final String h() {
        return this.f40873i;
    }

    public int hashCode() {
        int a8 = ((((((((a.a(this.f40865a) * 31) + a.a(this.f40866b)) * 31) + this.f40867c.hashCode()) * 31) + a.a(this.f40868d)) * 31) + this.f40869e.hashCode()) * 31;
        Integer num = this.f40870f;
        int hashCode = (a8 + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.f40871g;
        int hashCode2 = (((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f40872h.hashCode()) * 31) + this.f40873i.hashCode()) * 31) + this.f40874j.hashCode()) * 31) + this.f40875k.hashCode()) * 31;
        String str2 = this.f40876l;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f40877m;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final long i() {
        return this.f40865a;
    }

    public final String j() {
        return this.f40874j;
    }

    public final long k() {
        return this.f40866b;
    }

    public final String l() {
        return this.f40875k;
    }

    public final String m() {
        return this.f40876l;
    }

    public String toString() {
        long j8 = this.f40865a;
        long j9 = this.f40866b;
        String str = this.f40867c;
        long j10 = this.f40868d;
        String str2 = this.f40869e;
        Integer num = this.f40870f;
        String str3 = this.f40871g;
        String str4 = this.f40872h;
        String str5 = this.f40873i;
        String str6 = this.f40874j;
        String str7 = this.f40875k;
        String str8 = this.f40876l;
        String str9 = this.f40877m;
        return "DriverProfileConfig(id=" + j8 + ", partnerId=" + j9 + ", cityName=" + str + ", companyId=" + j10 + ", country=" + str2 + ", docsExpireInDays=" + num + ", driverLanguage=" + str3 + ", driverOperatorName=" + str4 + ", emergencyPhoneNumber=" + str5 + ", name=" + str6 + ", phone=" + str7 + ", referralCode=" + str8 + ", analyticsId=" + str9 + ")";
    }
}
