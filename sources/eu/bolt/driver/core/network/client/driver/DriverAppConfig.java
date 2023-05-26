package eu.bolt.driver.core.network.client.driver;

import com.google.gson.annotations.SerializedName;
import i0.a;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: DriverAppConfig.kt */
/* loaded from: classes5.dex */
public final class DriverAppConfig {
    @SerializedName("app_version_state")

    /* renamed from: a  reason: collision with root package name */
    private final String f40823a;
    @SerializedName("utc_time")

    /* renamed from: b  reason: collision with root package name */
    private final long f40824b;
    @SerializedName("default_max_client_distance")

    /* renamed from: c  reason: collision with root package name */
    private final double f40825c;
    @SerializedName("max_client_distances_list")

    /* renamed from: d  reason: collision with root package name */
    private final List<MaxClientDistance> f40826d;
    @SerializedName("route_refresh_interval")

    /* renamed from: e  reason: collision with root package name */
    private final long f40827e;
    @SerializedName("system_of_measurement")

    /* renamed from: f  reason: collision with root package name */
    private final String f40828f;
    @SerializedName("driver_is_busy_check_interval")

    /* renamed from: g  reason: collision with root package name */
    private final int f40829g;
    @SerializedName("active_referral_campaign")

    /* renamed from: h  reason: collision with root package name */
    private final Referral f40830h;
    @SerializedName("activity_config")

    /* renamed from: i  reason: collision with root package name */
    private final Activity f40831i;
    @SerializedName("order_server_config")

    /* renamed from: j  reason: collision with root package name */
    private final Shard f40832j;
    @SerializedName("tracking_config")

    /* renamed from: k  reason: collision with root package name */
    private final Tracking f40833k;

    /* compiled from: DriverAppConfig.kt */
    /* loaded from: classes5.dex */
    public static final class Activity {
        @SerializedName("is_hours_enabled")

        /* renamed from: a  reason: collision with root package name */
        private final boolean f40834a;
        @SerializedName("is_rides_enabled")

        /* renamed from: b  reason: collision with root package name */
        private boolean f40835b;
        @SerializedName("is_cancels_enabled")

        /* renamed from: c  reason: collision with root package name */
        private boolean f40836c;

        public final boolean a() {
            return this.f40836c;
        }

        public final boolean b() {
            return this.f40834a;
        }

        public final boolean c() {
            return this.f40835b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                return this.f40834a == activity.f40834a && this.f40835b == activity.f40835b && this.f40836c == activity.f40836c;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        public int hashCode() {
            boolean z7 = this.f40834a;
            ?? r02 = z7;
            if (z7) {
                r02 = 1;
            }
            int i8 = r02 * 31;
            ?? r22 = this.f40835b;
            int i9 = r22;
            if (r22 != 0) {
                i9 = 1;
            }
            int i10 = (i8 + i9) * 31;
            boolean z8 = this.f40836c;
            return i10 + (z8 ? 1 : z8 ? 1 : 0);
        }

        public String toString() {
            boolean z7 = this.f40834a;
            boolean z8 = this.f40835b;
            boolean z9 = this.f40836c;
            return "Activity(isHoursEnabled=" + z7 + ", isRidesEnabled=" + z8 + ", isCancelsEnabled=" + z9 + ")";
        }
    }

    /* compiled from: DriverAppConfig.kt */
    /* loaded from: classes5.dex */
    public static final class MaxClientDistance {
        @SerializedName("distance_in_meters")

        /* renamed from: a  reason: collision with root package name */
        private final int f40837a;
        @SerializedName("distance_with_unit")

        /* renamed from: b  reason: collision with root package name */
        private final String f40838b;

        public MaxClientDistance(int i8, String distanceWithUnit) {
            Intrinsics.f(distanceWithUnit, "distanceWithUnit");
            this.f40837a = i8;
            this.f40838b = distanceWithUnit;
        }

        public final int a() {
            return this.f40837a;
        }

        public final String b() {
            return this.f40838b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MaxClientDistance) {
                MaxClientDistance maxClientDistance = (MaxClientDistance) obj;
                return this.f40837a == maxClientDistance.f40837a && Intrinsics.a(this.f40838b, maxClientDistance.f40838b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f40837a * 31) + this.f40838b.hashCode();
        }

        public String toString() {
            int i8 = this.f40837a;
            String str = this.f40838b;
            return "MaxClientDistance(distanceInMeters=" + i8 + ", distanceWithUnit=" + str + ")";
        }
    }

    /* compiled from: DriverAppConfig.kt */
    /* loaded from: classes5.dex */
    public static final class Referral {
        @SerializedName(Name.MARK)

        /* renamed from: a  reason: collision with root package name */
        private final long f40839a;
        @SerializedName("earned_amount_str")

        /* renamed from: b  reason: collision with root package name */
        private final String f40840b;

        public final String a() {
            return this.f40840b;
        }

        public final long b() {
            return this.f40839a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Referral) {
                Referral referral = (Referral) obj;
                return this.f40839a == referral.f40839a && Intrinsics.a(this.f40840b, referral.f40840b);
            }
            return false;
        }

        public int hashCode() {
            return (a.a(this.f40839a) * 31) + this.f40840b.hashCode();
        }

        public String toString() {
            long j8 = this.f40839a;
            String str = this.f40840b;
            return "Referral(id=" + j8 + ", earnedAmount=" + str + ")";
        }
    }

    /* compiled from: DriverAppConfig.kt */
    /* loaded from: classes5.dex */
    public static final class Shard {
        @SerializedName("order_server_url")

        /* renamed from: a  reason: collision with root package name */
        private final String f40841a;
        @SerializedName("order_shard_id")

        /* renamed from: b  reason: collision with root package name */
        private final String f40842b;

        public final String a() {
            return this.f40841a;
        }

        public final String b() {
            return this.f40842b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Shard) {
                Shard shard = (Shard) obj;
                return Intrinsics.a(this.f40841a, shard.f40841a) && Intrinsics.a(this.f40842b, shard.f40842b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f40841a.hashCode() * 31) + this.f40842b.hashCode();
        }

        public String toString() {
            String str = this.f40841a;
            String str2 = this.f40842b;
            return "Shard(orderServerUrl=" + str + ", orderShardId=" + str2 + ")";
        }
    }

    /* compiled from: DriverAppConfig.kt */
    /* loaded from: classes5.dex */
    public static final class Tracking {
        @SerializedName("tracking_collect_interval_s")

        /* renamed from: a  reason: collision with root package name */
        private final int f40843a;
        @SerializedName("tracking_send_interval_s")

        /* renamed from: b  reason: collision with root package name */
        private final int f40844b;
        @SerializedName("tracking_send_batch")

        /* renamed from: c  reason: collision with root package name */
        private final int f40845c;

        public final int a() {
            return this.f40843a;
        }

        public final int b() {
            return this.f40845c;
        }

        public final int c() {
            return this.f40844b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Tracking) {
                Tracking tracking = (Tracking) obj;
                return this.f40843a == tracking.f40843a && this.f40844b == tracking.f40844b && this.f40845c == tracking.f40845c;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f40843a * 31) + this.f40844b) * 31) + this.f40845c;
        }

        public String toString() {
            int i8 = this.f40843a;
            int i9 = this.f40844b;
            int i10 = this.f40845c;
            return "Tracking(trackingCollectInterval=" + i8 + ", trackingSendInterval=" + i9 + ", trackingSendBatch=" + i10 + ")";
        }
    }

    public final Activity a() {
        return this.f40831i;
    }

    public final String b() {
        return this.f40823a;
    }

    public final double c() {
        return this.f40825c;
    }

    public final int d() {
        return this.f40829g;
    }

    public final List<MaxClientDistance> e() {
        return this.f40826d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverAppConfig) {
            DriverAppConfig driverAppConfig = (DriverAppConfig) obj;
            return Intrinsics.a(this.f40823a, driverAppConfig.f40823a) && this.f40824b == driverAppConfig.f40824b && Double.compare(this.f40825c, driverAppConfig.f40825c) == 0 && Intrinsics.a(this.f40826d, driverAppConfig.f40826d) && this.f40827e == driverAppConfig.f40827e && Intrinsics.a(this.f40828f, driverAppConfig.f40828f) && this.f40829g == driverAppConfig.f40829g && Intrinsics.a(this.f40830h, driverAppConfig.f40830h) && Intrinsics.a(this.f40831i, driverAppConfig.f40831i) && Intrinsics.a(this.f40832j, driverAppConfig.f40832j) && Intrinsics.a(this.f40833k, driverAppConfig.f40833k);
        }
        return false;
    }

    public final Referral f() {
        return this.f40830h;
    }

    public final long g() {
        return this.f40827e;
    }

    public final Shard h() {
        return this.f40832j;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.f40823a.hashCode() * 31) + a.a(this.f40824b)) * 31) + q1.a.a(this.f40825c)) * 31) + this.f40826d.hashCode()) * 31) + a.a(this.f40827e)) * 31) + this.f40828f.hashCode()) * 31) + this.f40829g) * 31;
        Referral referral = this.f40830h;
        return ((((((hashCode + (referral == null ? 0 : referral.hashCode())) * 31) + this.f40831i.hashCode()) * 31) + this.f40832j.hashCode()) * 31) + this.f40833k.hashCode();
    }

    public final String i() {
        return this.f40828f;
    }

    public final long j() {
        return this.f40824b;
    }

    public final Tracking k() {
        return this.f40833k;
    }

    public String toString() {
        String str = this.f40823a;
        long j8 = this.f40824b;
        double d8 = this.f40825c;
        List<MaxClientDistance> list = this.f40826d;
        long j9 = this.f40827e;
        String str2 = this.f40828f;
        int i8 = this.f40829g;
        Referral referral = this.f40830h;
        Activity activity = this.f40831i;
        Shard shard = this.f40832j;
        Tracking tracking = this.f40833k;
        return "DriverAppConfig(appState=" + str + ", time=" + j8 + ", defaultMaxClientDistance=" + d8 + ", maxClientDistances=" + list + ", routeRefreshInterval=" + j9 + ", systemOfMeasurement=" + str2 + ", driverBusyPollingTimeout=" + i8 + ", referral=" + referral + ", activity=" + activity + ", shard=" + shard + ", tracking=" + tracking + ")";
    }
}
