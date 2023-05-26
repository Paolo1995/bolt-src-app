package ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayToBoltInfo.kt */
/* loaded from: classes3.dex */
public final class DebtInfo {

    /* renamed from: a  reason: collision with root package name */
    private final String f28592a;

    /* renamed from: b  reason: collision with root package name */
    private final String f28593b;

    public DebtInfo(String label, String value) {
        Intrinsics.f(label, "label");
        Intrinsics.f(value, "value");
        this.f28592a = label;
        this.f28593b = value;
    }

    public final String a() {
        return this.f28592a;
    }

    public final String b() {
        return this.f28593b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DebtInfo) {
            DebtInfo debtInfo = (DebtInfo) obj;
            return Intrinsics.a(this.f28592a, debtInfo.f28592a) && Intrinsics.a(this.f28593b, debtInfo.f28593b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f28592a.hashCode() * 31) + this.f28593b.hashCode();
    }

    public String toString() {
        String str = this.f28592a;
        String str2 = this.f28593b;
        return "DebtInfo(label=" + str + ", value=" + str2 + ")";
    }
}
