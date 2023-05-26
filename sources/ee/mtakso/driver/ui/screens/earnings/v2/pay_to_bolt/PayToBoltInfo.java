package ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayToBoltInfo.kt */
/* loaded from: classes3.dex */
public final class PayToBoltInfo {

    /* renamed from: a  reason: collision with root package name */
    private final String f28631a;

    /* renamed from: b  reason: collision with root package name */
    private final String f28632b;

    /* renamed from: c  reason: collision with root package name */
    private final DebtInfo f28633c;

    public PayToBoltInfo(String str, String str2, DebtInfo debtInfo) {
        this.f28631a = str;
        this.f28632b = str2;
        this.f28633c = debtInfo;
    }

    public final DebtInfo a() {
        return this.f28633c;
    }

    public final String b() {
        return this.f28631a;
    }

    public final String c() {
        return this.f28632b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PayToBoltInfo) {
            PayToBoltInfo payToBoltInfo = (PayToBoltInfo) obj;
            return Intrinsics.a(this.f28631a, payToBoltInfo.f28631a) && Intrinsics.a(this.f28632b, payToBoltInfo.f28632b) && Intrinsics.a(this.f28633c, payToBoltInfo.f28633c);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f28631a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f28632b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        DebtInfo debtInfo = this.f28633c;
        return hashCode2 + (debtInfo != null ? debtInfo.hashCode() : 0);
    }

    public String toString() {
        String str = this.f28631a;
        String str2 = this.f28632b;
        DebtInfo debtInfo = this.f28633c;
        return "PayToBoltInfo(paymentLinkUrl=" + str + ", pendingMessage=" + str2 + ", debtInfo=" + debtInfo + ")";
    }
}
