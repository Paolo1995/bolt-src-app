package ee.mtakso.driver.network.client.earnings;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PaymentSettingsResponse.kt */
/* loaded from: classes3.dex */
public final class PaymentSettingsResponse {
    @SerializedName("enabled")

    /* renamed from: a  reason: collision with root package name */
    private final boolean f22135a;
    @SerializedName("content")

    /* renamed from: b  reason: collision with root package name */
    private final PaymentSettingsContent f22136b;

    public final boolean a() {
        return this.f22135a;
    }

    public final PaymentSettingsContent b() {
        return this.f22136b;
    }

    public final PaymentSettingsContent c() {
        return this.f22136b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PaymentSettingsResponse) {
            PaymentSettingsResponse paymentSettingsResponse = (PaymentSettingsResponse) obj;
            return this.f22135a == paymentSettingsResponse.f22135a && Intrinsics.a(this.f22136b, paymentSettingsResponse.f22136b);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z7 = this.f22135a;
        ?? r02 = z7;
        if (z7) {
            r02 = 1;
        }
        return (r02 * 31) + this.f22136b.hashCode();
    }

    public String toString() {
        boolean z7 = this.f22135a;
        PaymentSettingsContent paymentSettingsContent = this.f22136b;
        return "PaymentSettingsResponse(enabled=" + z7 + ", content=" + paymentSettingsContent + ")";
    }
}
