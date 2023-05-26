package ee.mtakso.driver.ui.screens.order.arrived.raterider;

import ee.mtakso.driver.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RiderRatingReasons.kt */
/* loaded from: classes3.dex */
public enum RiderRatingReasons {
    RIDER_DID_NOT_PAY("client_did_not_pay", R.string.rate_rider_reason_did_not_pay),
    RIDER_VIOLENT("client_violent", R.string.rate_rider_reason_misbehaving),
    RIDER_DAMAGED_CAR("client_damaged_car", R.string.rate_rider_reason_messed_up_car);
    

    /* renamed from: h  reason: collision with root package name */
    public static final Companion f31218h = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final String f31223f;

    /* renamed from: g  reason: collision with root package name */
    private final int f31224g;

    /* compiled from: RiderRatingReasons.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RiderRatingReasons a(String str) {
            RiderRatingReasons[] values;
            if (str == null) {
                return null;
            }
            for (RiderRatingReasons riderRatingReasons : RiderRatingReasons.values()) {
                if (Intrinsics.a(riderRatingReasons.getId(), str)) {
                    return riderRatingReasons;
                }
            }
            return null;
        }
    }

    RiderRatingReasons(String str, int i8) {
        this.f31223f = str;
        this.f31224g = i8;
    }

    public final int c() {
        return this.f31224g;
    }

    public final String getId() {
        return this.f31223f;
    }
}
