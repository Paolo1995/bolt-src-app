package ee.mtakso.driver.service.modules.status;

import ee.mtakso.driver.network.client.driver.PricingData;
import ee.mtakso.driver.network.client.driver.PricingRequireData;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoOnlineIssue.kt */
/* loaded from: classes3.dex */
public abstract class GoOnlineIssue {

    /* compiled from: GoOnlineIssue.kt */
    /* loaded from: classes3.dex */
    public static final class LocationRequired extends GoOnlineIssue {

        /* renamed from: a  reason: collision with root package name */
        public static final LocationRequired f25266a = new LocationRequired();

        private LocationRequired() {
            super(null);
        }
    }

    /* compiled from: GoOnlineIssue.kt */
    /* loaded from: classes3.dex */
    public static final class PricingConfirmation extends GoOnlineIssue {

        /* renamed from: a  reason: collision with root package name */
        private final PricingRequireData f25267a;

        /* renamed from: b  reason: collision with root package name */
        private final PricingData f25268b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PricingConfirmation(PricingRequireData confirmationData, PricingData pricingData) {
            super(null);
            Intrinsics.f(confirmationData, "confirmationData");
            Intrinsics.f(pricingData, "pricingData");
            this.f25267a = confirmationData;
            this.f25268b = pricingData;
        }

        public final PricingRequireData a() {
            return this.f25267a;
        }

        public final PricingData b() {
            return this.f25268b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PricingConfirmation) {
                PricingConfirmation pricingConfirmation = (PricingConfirmation) obj;
                return Intrinsics.a(this.f25267a, pricingConfirmation.f25267a) && Intrinsics.a(this.f25268b, pricingConfirmation.f25268b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f25267a.hashCode() * 31) + this.f25268b.hashCode();
        }

        public String toString() {
            PricingRequireData pricingRequireData = this.f25267a;
            PricingData pricingData = this.f25268b;
            return "PricingConfirmation(confirmationData=" + pricingRequireData + ", pricingData=" + pricingData + ")";
        }
    }

    /* compiled from: GoOnlineIssue.kt */
    /* loaded from: classes3.dex */
    public static final class PricingNotChosen extends GoOnlineIssue {

        /* renamed from: a  reason: collision with root package name */
        private final PricingRequireData f25269a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PricingNotChosen(PricingRequireData data) {
            super(null);
            Intrinsics.f(data, "data");
            this.f25269a = data;
        }

        public final PricingRequireData a() {
            return this.f25269a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PricingNotChosen) && Intrinsics.a(this.f25269a, ((PricingNotChosen) obj).f25269a);
        }

        public int hashCode() {
            return this.f25269a.hashCode();
        }

        public String toString() {
            PricingRequireData pricingRequireData = this.f25269a;
            return "PricingNotChosen(data=" + pricingRequireData + ")";
        }
    }

    private GoOnlineIssue() {
    }

    public /* synthetic */ GoOnlineIssue(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
