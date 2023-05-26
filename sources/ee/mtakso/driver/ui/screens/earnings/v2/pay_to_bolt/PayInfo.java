package ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt;

import ee.mtakso.driver.network.client.earnings.Balance;
import ee.mtakso.driver.network.client.earnings.PaymentButton;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PaymentInfo.kt */
/* loaded from: classes3.dex */
public abstract class PayInfo {

    /* compiled from: PaymentInfo.kt */
    /* loaded from: classes3.dex */
    public static final class HowTo extends PayInfo {

        /* renamed from: a  reason: collision with root package name */
        private final PaymentButton f28594a;

        /* renamed from: b  reason: collision with root package name */
        private final Balance f28595b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f28596c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f28597d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f28598e;

        /* renamed from: f  reason: collision with root package name */
        private final String f28599f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HowTo(PaymentButton button, Balance balance, boolean z7, boolean z8, boolean z9, String content) {
            super(null);
            Intrinsics.f(button, "button");
            Intrinsics.f(balance, "balance");
            Intrinsics.f(content, "content");
            this.f28594a = button;
            this.f28595b = balance;
            this.f28596c = z7;
            this.f28597d = z8;
            this.f28598e = z9;
            this.f28599f = content;
        }

        @Override // ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfo
        public Balance a() {
            return this.f28595b;
        }

        @Override // ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfo
        public PaymentButton b() {
            return this.f28594a;
        }

        @Override // ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfo
        public boolean c() {
            return this.f28597d;
        }

        @Override // ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfo
        public boolean d() {
            return this.f28598e;
        }

        @Override // ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfo
        public boolean e() {
            return this.f28596c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof HowTo) {
                HowTo howTo = (HowTo) obj;
                return b() == howTo.b() && Intrinsics.a(a(), howTo.a()) && e() == howTo.e() && c() == howTo.c() && d() == howTo.d() && Intrinsics.a(this.f28599f, howTo.f28599f);
            }
            return false;
        }

        public final String f() {
            return this.f28599f;
        }

        public int hashCode() {
            int hashCode = ((b().hashCode() * 31) + a().hashCode()) * 31;
            boolean e8 = e();
            int i8 = e8;
            if (e8) {
                i8 = 1;
            }
            int i9 = (hashCode + i8) * 31;
            boolean c8 = c();
            int i10 = c8;
            if (c8) {
                i10 = 1;
            }
            int i11 = (i9 + i10) * 31;
            boolean d8 = d();
            return ((i11 + (d8 ? 1 : d8)) * 31) + this.f28599f.hashCode();
        }

        public String toString() {
            PaymentButton b8 = b();
            Balance a8 = a();
            boolean e8 = e();
            boolean c8 = c();
            boolean d8 = d();
            String str = this.f28599f;
            return "HowTo(button=" + b8 + ", balance=" + a8 + ", historyEnabled=" + e8 + ", buttonEnabled=" + c8 + ", enabled=" + d8 + ", content=" + str + ")";
        }
    }

    /* compiled from: PaymentInfo.kt */
    /* loaded from: classes3.dex */
    public static final class OnlyBalance extends PayInfo {

        /* renamed from: a  reason: collision with root package name */
        private final Balance f28600a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f28601b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f28602c;

        /* renamed from: d  reason: collision with root package name */
        private final PaymentButton f28603d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f28604e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnlyBalance(Balance balance, boolean z7, boolean z8) {
            super(null);
            Intrinsics.f(balance, "balance");
            this.f28600a = balance;
            this.f28601b = z7;
            this.f28602c = z8;
        }

        @Override // ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfo
        public Balance a() {
            return this.f28600a;
        }

        @Override // ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfo
        public PaymentButton b() {
            return this.f28603d;
        }

        @Override // ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfo
        public boolean c() {
            return this.f28604e;
        }

        @Override // ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfo
        public boolean d() {
            return this.f28602c;
        }

        @Override // ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfo
        public boolean e() {
            return this.f28601b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof OnlyBalance) {
                OnlyBalance onlyBalance = (OnlyBalance) obj;
                return Intrinsics.a(a(), onlyBalance.a()) && e() == onlyBalance.e() && d() == onlyBalance.d();
            }
            return false;
        }

        public int hashCode() {
            int hashCode = a().hashCode() * 31;
            boolean e8 = e();
            int i8 = e8;
            if (e8) {
                i8 = 1;
            }
            int i9 = (hashCode + i8) * 31;
            boolean d8 = d();
            return i9 + (d8 ? 1 : d8);
        }

        public String toString() {
            Balance a8 = a();
            boolean e8 = e();
            boolean d8 = d();
            return "OnlyBalance(balance=" + a8 + ", historyEnabled=" + e8 + ", enabled=" + d8 + ")";
        }
    }

    /* compiled from: PaymentInfo.kt */
    /* loaded from: classes3.dex */
    public static final class Payout extends PayInfo {

        /* renamed from: a  reason: collision with root package name */
        private final PaymentButton f28605a;

        /* renamed from: b  reason: collision with root package name */
        private final Balance f28606b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f28607c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f28608d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f28609e;

        /* renamed from: f  reason: collision with root package name */
        private final String f28610f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Payout(PaymentButton button, Balance balance, boolean z7, boolean z8, boolean z9, String str) {
            super(null);
            Intrinsics.f(button, "button");
            Intrinsics.f(balance, "balance");
            this.f28605a = button;
            this.f28606b = balance;
            this.f28607c = z7;
            this.f28608d = z8;
            this.f28609e = z9;
            this.f28610f = str;
        }

        @Override // ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfo
        public Balance a() {
            return this.f28606b;
        }

        @Override // ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfo
        public PaymentButton b() {
            return this.f28605a;
        }

        @Override // ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfo
        public boolean c() {
            return this.f28609e;
        }

        @Override // ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfo
        public boolean d() {
            return this.f28608d;
        }

        @Override // ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfo
        public boolean e() {
            return this.f28607c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Payout) {
                Payout payout = (Payout) obj;
                return b() == payout.b() && Intrinsics.a(a(), payout.a()) && e() == payout.e() && d() == payout.d() && c() == payout.c() && Intrinsics.a(this.f28610f, payout.f28610f);
            }
            return false;
        }

        public final String f() {
            return this.f28610f;
        }

        public int hashCode() {
            int hashCode = ((b().hashCode() * 31) + a().hashCode()) * 31;
            boolean e8 = e();
            int i8 = e8;
            if (e8) {
                i8 = 1;
            }
            int i9 = (hashCode + i8) * 31;
            boolean d8 = d();
            int i10 = d8;
            if (d8) {
                i10 = 1;
            }
            int i11 = (i9 + i10) * 31;
            boolean c8 = c();
            int i12 = (i11 + (c8 ? 1 : c8)) * 31;
            String str = this.f28610f;
            return i12 + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            PaymentButton b8 = b();
            Balance a8 = a();
            boolean e8 = e();
            boolean d8 = d();
            boolean c8 = c();
            String str = this.f28610f;
            return "Payout(button=" + b8 + ", balance=" + a8 + ", historyEnabled=" + e8 + ", enabled=" + d8 + ", buttonEnabled=" + c8 + ", comment=" + str + ")";
        }
    }

    /* compiled from: PaymentInfo.kt */
    /* loaded from: classes3.dex */
    public static final class ToBolt extends PayInfo {

        /* renamed from: a  reason: collision with root package name */
        private final PaymentButton f28611a;

        /* renamed from: b  reason: collision with root package name */
        private final Balance f28612b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f28613c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f28614d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f28615e;

        /* renamed from: f  reason: collision with root package name */
        private final String f28616f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ToBolt(PaymentButton button, Balance balance, boolean z7, boolean z8, boolean z9, String str) {
            super(null);
            Intrinsics.f(button, "button");
            Intrinsics.f(balance, "balance");
            this.f28611a = button;
            this.f28612b = balance;
            this.f28613c = z7;
            this.f28614d = z8;
            this.f28615e = z9;
            this.f28616f = str;
        }

        @Override // ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfo
        public Balance a() {
            return this.f28612b;
        }

        @Override // ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfo
        public PaymentButton b() {
            return this.f28611a;
        }

        @Override // ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfo
        public boolean c() {
            return this.f28615e;
        }

        @Override // ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfo
        public boolean d() {
            return this.f28614d;
        }

        @Override // ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfo
        public boolean e() {
            return this.f28613c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ToBolt) {
                ToBolt toBolt = (ToBolt) obj;
                return b() == toBolt.b() && Intrinsics.a(a(), toBolt.a()) && e() == toBolt.e() && d() == toBolt.d() && c() == toBolt.c() && Intrinsics.a(this.f28616f, toBolt.f28616f);
            }
            return false;
        }

        public final String f() {
            return this.f28616f;
        }

        public int hashCode() {
            int hashCode = ((b().hashCode() * 31) + a().hashCode()) * 31;
            boolean e8 = e();
            int i8 = e8;
            if (e8) {
                i8 = 1;
            }
            int i9 = (hashCode + i8) * 31;
            boolean d8 = d();
            int i10 = d8;
            if (d8) {
                i10 = 1;
            }
            int i11 = (i9 + i10) * 31;
            boolean c8 = c();
            int i12 = (i11 + (c8 ? 1 : c8)) * 31;
            String str = this.f28616f;
            return i12 + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            PaymentButton b8 = b();
            Balance a8 = a();
            boolean e8 = e();
            boolean d8 = d();
            boolean c8 = c();
            String str = this.f28616f;
            return "ToBolt(button=" + b8 + ", balance=" + a8 + ", historyEnabled=" + e8 + ", enabled=" + d8 + ", buttonEnabled=" + c8 + ", comment=" + str + ")";
        }
    }

    private PayInfo() {
    }

    public /* synthetic */ PayInfo(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Balance a();

    public abstract PaymentButton b();

    public abstract boolean c();

    public abstract boolean d();

    public abstract boolean e();
}
