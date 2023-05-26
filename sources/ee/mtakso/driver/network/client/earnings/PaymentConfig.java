package ee.mtakso.driver.network.client.earnings;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PaymentSettingsResponse.kt */
/* loaded from: classes3.dex */
public abstract class PaymentConfig {

    /* compiled from: PaymentSettingsResponse.kt */
    /* loaded from: classes3.dex */
    public static final class HowTo extends PaymentConfig {
        @SerializedName("enabled")

        /* renamed from: a  reason: collision with root package name */
        private final boolean f22123a;
        @SerializedName("content")

        /* renamed from: b  reason: collision with root package name */
        private final String f22124b;

        public final String a() {
            return this.f22124b;
        }

        public boolean b() {
            return this.f22123a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof HowTo) {
                HowTo howTo = (HowTo) obj;
                return b() == howTo.b() && Intrinsics.a(this.f22124b, howTo.f22124b);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean b8 = b();
            ?? r02 = b8;
            if (b8) {
                r02 = 1;
            }
            return (r02 * 31) + this.f22124b.hashCode();
        }

        public String toString() {
            boolean b8 = b();
            String str = this.f22124b;
            return "HowTo(enabled=" + b8 + ", content=" + str + ")";
        }
    }

    /* compiled from: PaymentSettingsResponse.kt */
    /* loaded from: classes3.dex */
    public static final class Payout extends PaymentConfig {
        @SerializedName("enabled")

        /* renamed from: a  reason: collision with root package name */
        private final boolean f22125a;
        @SerializedName("comment")

        /* renamed from: b  reason: collision with root package name */
        private final String f22126b;

        public final String a() {
            return this.f22126b;
        }

        public boolean b() {
            return this.f22125a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Payout) {
                Payout payout = (Payout) obj;
                return b() == payout.b() && Intrinsics.a(this.f22126b, payout.f22126b);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean b8 = b();
            ?? r02 = b8;
            if (b8) {
                r02 = 1;
            }
            int i8 = r02 * 31;
            String str = this.f22126b;
            return i8 + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            boolean b8 = b();
            String str = this.f22126b;
            return "Payout(enabled=" + b8 + ", comment=" + str + ")";
        }
    }

    /* compiled from: PaymentSettingsResponse.kt */
    /* loaded from: classes3.dex */
    public static final class ToBolt extends PaymentConfig {
        @SerializedName("enabled")

        /* renamed from: a  reason: collision with root package name */
        private final boolean f22127a;
        @SerializedName("comment")

        /* renamed from: b  reason: collision with root package name */
        private final String f22128b;

        public final String a() {
            return this.f22128b;
        }

        public boolean b() {
            return this.f22127a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ToBolt) {
                ToBolt toBolt = (ToBolt) obj;
                return b() == toBolt.b() && Intrinsics.a(this.f22128b, toBolt.f22128b);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean b8 = b();
            ?? r02 = b8;
            if (b8) {
                r02 = 1;
            }
            int i8 = r02 * 31;
            String str = this.f22128b;
            return i8 + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            boolean b8 = b();
            String str = this.f22128b;
            return "ToBolt(enabled=" + b8 + ", comment=" + str + ")";
        }
    }

    private PaymentConfig() {
    }
}
