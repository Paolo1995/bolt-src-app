package ee.mtakso.driver.ui.screens.order.arrived;

import ee.mtakso.driver.network.client.price.PriceReviewReason;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrivePriceScreenData.kt */
/* loaded from: classes3.dex */
public abstract class PriceScreenState {

    /* compiled from: DrivePriceScreenData.kt */
    /* loaded from: classes3.dex */
    public static final class Initial extends PriceScreenState {

        /* renamed from: a  reason: collision with root package name */
        public static final Initial f31069a = new Initial();

        private Initial() {
            super(null);
        }
    }

    /* compiled from: DrivePriceScreenData.kt */
    /* loaded from: classes3.dex */
    public static final class PricePreviewScreen extends PriceScreenState {

        /* renamed from: a  reason: collision with root package name */
        public static final PricePreviewScreen f31070a = new PricePreviewScreen();

        private PricePreviewScreen() {
            super(null);
        }
    }

    /* compiled from: DrivePriceScreenData.kt */
    /* loaded from: classes3.dex */
    public static final class ProblemWithPrice extends PriceScreenState {

        /* renamed from: a  reason: collision with root package name */
        private final PriceReviewReason f31071a;

        /* renamed from: b  reason: collision with root package name */
        private final DrivePriceScreenData f31072b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProblemWithPrice(PriceReviewReason priceReviewReason, DrivePriceScreenData driverPriceScreenData) {
            super(null);
            Intrinsics.f(priceReviewReason, "priceReviewReason");
            Intrinsics.f(driverPriceScreenData, "driverPriceScreenData");
            this.f31071a = priceReviewReason;
            this.f31072b = driverPriceScreenData;
        }

        public final DrivePriceScreenData a() {
            return this.f31072b;
        }

        public final PriceReviewReason b() {
            return this.f31071a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ProblemWithPrice) {
                ProblemWithPrice problemWithPrice = (ProblemWithPrice) obj;
                return Intrinsics.a(this.f31071a, problemWithPrice.f31071a) && Intrinsics.a(this.f31072b, problemWithPrice.f31072b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f31071a.hashCode() * 31) + this.f31072b.hashCode();
        }

        public String toString() {
            PriceReviewReason priceReviewReason = this.f31071a;
            DrivePriceScreenData drivePriceScreenData = this.f31072b;
            return "ProblemWithPrice(priceReviewReason=" + priceReviewReason + ", driverPriceScreenData=" + drivePriceScreenData + ")";
        }
    }

    /* compiled from: DrivePriceScreenData.kt */
    /* loaded from: classes3.dex */
    public static final class RateRider extends PriceScreenState {

        /* renamed from: a  reason: collision with root package name */
        public static final RateRider f31073a = new RateRider();

        private RateRider() {
            super(null);
        }
    }

    /* compiled from: DrivePriceScreenData.kt */
    /* loaded from: classes3.dex */
    public static final class SetPriceScreen extends PriceScreenState {

        /* renamed from: a  reason: collision with root package name */
        public static final SetPriceScreen f31074a = new SetPriceScreen();

        private SetPriceScreen() {
            super(null);
        }
    }

    private PriceScreenState() {
    }

    public /* synthetic */ PriceScreenState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
