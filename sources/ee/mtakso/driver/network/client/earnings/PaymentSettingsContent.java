package ee.mtakso.driver.network.client.earnings;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.earnings.PaymentConfig;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PaymentSettingsResponse.kt */
/* loaded from: classes3.dex */
public final class PaymentSettingsContent {
    @SerializedName("button")

    /* renamed from: a  reason: collision with root package name */
    private final PaymentButton f22129a;
    @SerializedName("balance")

    /* renamed from: b  reason: collision with root package name */
    private final Balance f22130b;
    @SerializedName("payout_history_enabled")

    /* renamed from: c  reason: collision with root package name */
    private final boolean f22131c;
    @SerializedName("pay_to_bolt_config")

    /* renamed from: d  reason: collision with root package name */
    private final PaymentConfig.ToBolt f22132d;
    @SerializedName("request_payout_config")

    /* renamed from: e  reason: collision with root package name */
    private final PaymentConfig.Payout f22133e;
    @SerializedName("how_to_request_payout_config")

    /* renamed from: f  reason: collision with root package name */
    private final PaymentConfig.HowTo f22134f;

    public final Balance a() {
        return this.f22130b;
    }

    public final PaymentButton b() {
        return this.f22129a;
    }

    public final boolean c() {
        return this.f22131c;
    }

    public final PaymentConfig.HowTo d() {
        return this.f22134f;
    }

    public final PaymentConfig.ToBolt e() {
        return this.f22132d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PaymentSettingsContent) {
            PaymentSettingsContent paymentSettingsContent = (PaymentSettingsContent) obj;
            return this.f22129a == paymentSettingsContent.f22129a && Intrinsics.a(this.f22130b, paymentSettingsContent.f22130b) && this.f22131c == paymentSettingsContent.f22131c && Intrinsics.a(this.f22132d, paymentSettingsContent.f22132d) && Intrinsics.a(this.f22133e, paymentSettingsContent.f22133e) && Intrinsics.a(this.f22134f, paymentSettingsContent.f22134f);
        }
        return false;
    }

    public final PaymentConfig.Payout f() {
        return this.f22133e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f22129a.hashCode() * 31) + this.f22130b.hashCode()) * 31;
        boolean z7 = this.f22131c;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode + i8) * 31;
        PaymentConfig.ToBolt toBolt = this.f22132d;
        int hashCode2 = (i9 + (toBolt == null ? 0 : toBolt.hashCode())) * 31;
        PaymentConfig.Payout payout = this.f22133e;
        int hashCode3 = (hashCode2 + (payout == null ? 0 : payout.hashCode())) * 31;
        PaymentConfig.HowTo howTo = this.f22134f;
        return hashCode3 + (howTo != null ? howTo.hashCode() : 0);
    }

    public String toString() {
        PaymentButton paymentButton = this.f22129a;
        Balance balance = this.f22130b;
        boolean z7 = this.f22131c;
        PaymentConfig.ToBolt toBolt = this.f22132d;
        PaymentConfig.Payout payout = this.f22133e;
        PaymentConfig.HowTo howTo = this.f22134f;
        return "PaymentSettingsContent(button=" + paymentButton + ", balance=" + balance + ", historyEnabled=" + z7 + ", optionalPayToBoltConfig=" + toBolt + ", optionalRequestPayoutConfig=" + payout + ", optionalHowToConfig=" + howTo + ")";
    }
}
