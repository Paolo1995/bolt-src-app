package ee.mtakso.driver.network.client.score;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.generic.InformationMessage;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScore.kt */
/* loaded from: classes3.dex */
public final class ScoreDetails {
    @SerializedName("score_value")

    /* renamed from: a  reason: collision with root package name */
    private final String f22743a;
    @SerializedName("score_unit")

    /* renamed from: b  reason: collision with root package name */
    private final String f22744b;
    @SerializedName("score")

    /* renamed from: c  reason: collision with root package name */
    private final double f22745c;
    @SerializedName("calculation_explanation")

    /* renamed from: d  reason: collision with root package name */
    private final String f22746d;
    @SerializedName("find_out_more_text")

    /* renamed from: e  reason: collision with root package name */
    private final String f22747e;
    @SerializedName("threshold_info")

    /* renamed from: f  reason: collision with root package name */
    private final ThresholdInfo f22748f;
    @SerializedName("information_message")

    /* renamed from: g  reason: collision with root package name */
    private final InformationMessage f22749g;

    public final String a() {
        return this.f22746d;
    }

    public final String b() {
        return this.f22747e;
    }

    public final InformationMessage c() {
        return this.f22749g;
    }

    public final double d() {
        return this.f22745c;
    }

    public final String e() {
        return this.f22744b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ScoreDetails) {
            ScoreDetails scoreDetails = (ScoreDetails) obj;
            return Intrinsics.a(this.f22743a, scoreDetails.f22743a) && Intrinsics.a(this.f22744b, scoreDetails.f22744b) && Double.compare(this.f22745c, scoreDetails.f22745c) == 0 && Intrinsics.a(this.f22746d, scoreDetails.f22746d) && Intrinsics.a(this.f22747e, scoreDetails.f22747e) && Intrinsics.a(this.f22748f, scoreDetails.f22748f) && Intrinsics.a(this.f22749g, scoreDetails.f22749g);
        }
        return false;
    }

    public final String f() {
        return this.f22743a;
    }

    public final ThresholdInfo g() {
        return this.f22748f;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.f22743a.hashCode() * 31) + this.f22744b.hashCode()) * 31) + q1.a.a(this.f22745c)) * 31) + this.f22746d.hashCode()) * 31) + this.f22747e.hashCode()) * 31) + this.f22748f.hashCode()) * 31;
        InformationMessage informationMessage = this.f22749g;
        return hashCode + (informationMessage == null ? 0 : informationMessage.hashCode());
    }

    public String toString() {
        String str = this.f22743a;
        String str2 = this.f22744b;
        double d8 = this.f22745c;
        String str3 = this.f22746d;
        String str4 = this.f22747e;
        ThresholdInfo thresholdInfo = this.f22748f;
        InformationMessage informationMessage = this.f22749g;
        return "ScoreDetails(scoreValue=" + str + ", scoreUnit=" + str2 + ", score=" + d8 + ", calculationExplanation=" + str3 + ", findOutMoreText=" + str4 + ", thresholdInfo=" + thresholdInfo + ", informationMessage=" + informationMessage + ")";
    }
}
