package eu.bolt.driver.core.network.client.driver;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverFeaturesConfig.kt */
/* loaded from: classes5.dex */
public final class DriverFeaturesConfig {
    @SerializedName("circle_k_loyalty_campaign_status")

    /* renamed from: a  reason: collision with root package name */
    private final CircleKLoyaltyCampaignStatus f40850a;
    @SerializedName("client_ratings_allowed")

    /* renamed from: b  reason: collision with root package name */
    private final boolean f40851b;
    @SerializedName("is_panic_button_enabled")

    /* renamed from: c  reason: collision with root package name */
    private final boolean f40852c;
    @SerializedName("is_earnings_view_enabled")

    /* renamed from: d  reason: collision with root package name */
    private final boolean f40853d;
    @SerializedName("is_mock_detection_enabled")

    /* renamed from: e  reason: collision with root package name */
    private final boolean f40854e;
    @SerializedName("is_waybill_enabled")

    /* renamed from: f  reason: collision with root package name */
    private final boolean f40855f;
    @SerializedName("is_driver_destination_enabled")

    /* renamed from: g  reason: collision with root package name */
    private final boolean f40856g;
    @SerializedName("is_order_destination_change_enabled")

    /* renamed from: h  reason: collision with root package name */
    private final boolean f40857h;
    @SerializedName("working_time_calculation_type")

    /* renamed from: i  reason: collision with root package name */
    private final WorkingTimeMode f40858i;
    @SerializedName("is_behaviour_quality_enabled")

    /* renamed from: j  reason: collision with root package name */
    private final boolean f40859j;
    @SerializedName("is_scheduled_rides_enabled")

    /* renamed from: k  reason: collision with root package name */
    private final boolean f40860k;
    @SerializedName("is_blocked_for_in_app_training")

    /* renamed from: l  reason: collision with root package name */
    private final boolean f40861l;
    @SerializedName("is_loyalty_platform_enabled")

    /* renamed from: m  reason: collision with root package name */
    private final boolean f40862m;
    @SerializedName("is_trip_audio_recording_enabled")

    /* renamed from: n  reason: collision with root package name */
    private final boolean f40863n;
    @SerializedName("app_parameters")

    /* renamed from: o  reason: collision with root package name */
    private final Map<String, Object> f40864o;

    /* compiled from: DriverFeaturesConfig.kt */
    /* loaded from: classes5.dex */
    public enum CircleKLoyaltyCampaignStatus {
        COMPLETED,
        AVAILABLE,
        NOT_AVAILABLE
    }

    /* compiled from: DriverFeaturesConfig.kt */
    /* loaded from: classes5.dex */
    public enum WorkingTimeMode {
        ACCUMULATING,
        ROLLING,
        DISABLED
    }

    public final boolean a() {
        return this.f40859j;
    }

    public final CircleKLoyaltyCampaignStatus b() {
        return this.f40850a;
    }

    public final boolean c() {
        return this.f40851b;
    }

    public final boolean d() {
        return this.f40857h;
    }

    public final boolean e() {
        return this.f40853d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverFeaturesConfig) {
            DriverFeaturesConfig driverFeaturesConfig = (DriverFeaturesConfig) obj;
            return this.f40850a == driverFeaturesConfig.f40850a && this.f40851b == driverFeaturesConfig.f40851b && this.f40852c == driverFeaturesConfig.f40852c && this.f40853d == driverFeaturesConfig.f40853d && this.f40854e == driverFeaturesConfig.f40854e && this.f40855f == driverFeaturesConfig.f40855f && this.f40856g == driverFeaturesConfig.f40856g && this.f40857h == driverFeaturesConfig.f40857h && this.f40858i == driverFeaturesConfig.f40858i && this.f40859j == driverFeaturesConfig.f40859j && this.f40860k == driverFeaturesConfig.f40860k && this.f40861l == driverFeaturesConfig.f40861l && this.f40862m == driverFeaturesConfig.f40862m && this.f40863n == driverFeaturesConfig.f40863n && Intrinsics.a(this.f40864o, driverFeaturesConfig.f40864o);
        }
        return false;
    }

    public final boolean f() {
        return this.f40862m;
    }

    public final boolean g() {
        return this.f40854e;
    }

    public final boolean h() {
        return this.f40852c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f40850a.hashCode() * 31;
        boolean z7 = this.f40851b;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode + i8) * 31;
        boolean z8 = this.f40852c;
        int i10 = z8;
        if (z8 != 0) {
            i10 = 1;
        }
        int i11 = (i9 + i10) * 31;
        boolean z9 = this.f40853d;
        int i12 = z9;
        if (z9 != 0) {
            i12 = 1;
        }
        int i13 = (i11 + i12) * 31;
        boolean z10 = this.f40854e;
        int i14 = z10;
        if (z10 != 0) {
            i14 = 1;
        }
        int i15 = (i13 + i14) * 31;
        boolean z11 = this.f40855f;
        int i16 = z11;
        if (z11 != 0) {
            i16 = 1;
        }
        int i17 = (i15 + i16) * 31;
        boolean z12 = this.f40856g;
        int i18 = z12;
        if (z12 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        boolean z13 = this.f40857h;
        int i20 = z13;
        if (z13 != 0) {
            i20 = 1;
        }
        int hashCode2 = (((i19 + i20) * 31) + this.f40858i.hashCode()) * 31;
        boolean z14 = this.f40859j;
        int i21 = z14;
        if (z14 != 0) {
            i21 = 1;
        }
        int i22 = (hashCode2 + i21) * 31;
        boolean z15 = this.f40860k;
        int i23 = z15;
        if (z15 != 0) {
            i23 = 1;
        }
        int i24 = (i22 + i23) * 31;
        boolean z16 = this.f40861l;
        int i25 = z16;
        if (z16 != 0) {
            i25 = 1;
        }
        int i26 = (i24 + i25) * 31;
        boolean z17 = this.f40862m;
        int i27 = z17;
        if (z17 != 0) {
            i27 = 1;
        }
        int i28 = (i26 + i27) * 31;
        boolean z18 = this.f40863n;
        return ((i28 + (z18 ? 1 : z18 ? 1 : 0)) * 31) + this.f40864o.hashCode();
    }

    public final boolean i() {
        return this.f40860k;
    }

    public final Map<String, Object> j() {
        return this.f40864o;
    }

    public final WorkingTimeMode k() {
        return this.f40858i;
    }

    public final boolean l() {
        return this.f40861l;
    }

    public final boolean m() {
        return this.f40856g;
    }

    public final boolean n() {
        return this.f40863n;
    }

    public final boolean o() {
        return this.f40855f;
    }

    public String toString() {
        CircleKLoyaltyCampaignStatus circleKLoyaltyCampaignStatus = this.f40850a;
        boolean z7 = this.f40851b;
        boolean z8 = this.f40852c;
        boolean z9 = this.f40853d;
        boolean z10 = this.f40854e;
        boolean z11 = this.f40855f;
        boolean z12 = this.f40856g;
        boolean z13 = this.f40857h;
        WorkingTimeMode workingTimeMode = this.f40858i;
        boolean z14 = this.f40859j;
        boolean z15 = this.f40860k;
        boolean z16 = this.f40861l;
        boolean z17 = this.f40862m;
        boolean z18 = this.f40863n;
        Map<String, Object> map = this.f40864o;
        return "DriverFeaturesConfig(circleKState=" + circleKLoyaltyCampaignStatus + ", clientRatingAllowed=" + z7 + ", panicButtonEnabled=" + z8 + ", earningsViewEnabled=" + z9 + ", mockDetectionEnabled=" + z10 + ", isWaybillEnabled=" + z11 + ", isDriverDestinationEnabled=" + z12 + ", destinationChangeEnabled=" + z13 + ", workingTimeMode=" + workingTimeMode + ", behaviourQualityEnabled=" + z14 + ", scheduledRidesEnabled=" + z15 + ", isBlockedByTraining=" + z16 + ", loyaltyPlatformEnabled=" + z17 + ", isTripAudioRecordingEnabled=" + z18 + ", targetingFeatures=" + map + ")";
    }
}
