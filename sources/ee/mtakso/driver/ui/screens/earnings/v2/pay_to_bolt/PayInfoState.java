package ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt;

import ee.mtakso.driver.utils.Optional;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayInfoState.kt */
/* loaded from: classes3.dex */
public final class PayInfoState {

    /* renamed from: a  reason: collision with root package name */
    private final Optional<PayInfo> f28617a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f28618b;

    public PayInfoState(Optional<PayInfo> payInfo, boolean z7) {
        Intrinsics.f(payInfo, "payInfo");
        this.f28617a = payInfo;
        this.f28618b = z7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PayInfoState b(PayInfoState payInfoState, Optional optional, boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            optional = payInfoState.f28617a;
        }
        if ((i8 & 2) != 0) {
            z7 = payInfoState.f28618b;
        }
        return payInfoState.a(optional, z7);
    }

    public final PayInfoState a(Optional<PayInfo> payInfo, boolean z7) {
        Intrinsics.f(payInfo, "payInfo");
        return new PayInfoState(payInfo, z7);
    }

    public final Optional<PayInfo> c() {
        return this.f28617a;
    }

    public final boolean d() {
        return this.f28618b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PayInfoState) {
            PayInfoState payInfoState = (PayInfoState) obj;
            return Intrinsics.a(this.f28617a, payInfoState.f28617a) && this.f28618b == payInfoState.f28618b;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f28617a.hashCode() * 31;
        boolean z7 = this.f28618b;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String toString() {
        Optional<PayInfo> optional = this.f28617a;
        boolean z7 = this.f28618b;
        return "PayInfoState(payInfo=" + optional + ", isLoading=" + z7 + ")";
    }
}
