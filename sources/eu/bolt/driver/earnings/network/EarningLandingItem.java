package eu.bolt.driver.earnings.network;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningLandingItem.kt */
@JsonAdapter(EarningLandingItemDeserializer.class)
/* loaded from: classes5.dex */
public abstract class EarningLandingItem {

    /* compiled from: EarningLandingItem.kt */
    /* loaded from: classes5.dex */
    public static final class ActivityItem extends EarningLandingItem {
        @SerializedName("title")

        /* renamed from: a  reason: collision with root package name */
        private final String f41428a;
        @SerializedName("tiles")

        /* renamed from: b  reason: collision with root package name */
        private final List<EarningsActivityTile> f41429b;

        public final List<EarningsActivityTile> a() {
            return this.f41429b;
        }

        public final String b() {
            return this.f41428a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ActivityItem) {
                ActivityItem activityItem = (ActivityItem) obj;
                return Intrinsics.a(this.f41428a, activityItem.f41428a) && Intrinsics.a(this.f41429b, activityItem.f41429b);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f41428a;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.f41429b.hashCode();
        }

        public String toString() {
            String str = this.f41428a;
            List<EarningsActivityTile> list = this.f41429b;
            return "ActivityItem(title=" + str + ", tiles=" + list + ")";
        }
    }

    /* compiled from: EarningLandingItem.kt */
    /* loaded from: classes5.dex */
    public static final class BalanceItem extends EarningLandingItem {
        @SerializedName("balance_state")

        /* renamed from: a  reason: collision with root package name */
        private final EarningsBalanceStateType f41430a;
        @SerializedName("icon")

        /* renamed from: b  reason: collision with root package name */
        private final DriverImage f41431b;
        @SerializedName("title")

        /* renamed from: c  reason: collision with root package name */
        private final String f41432c;
        @SerializedName("title_chip")

        /* renamed from: d  reason: collision with root package name */
        private final DriverChip f41433d;
        @SerializedName("subtitle")

        /* renamed from: e  reason: collision with root package name */
        private final String f41434e;
        @SerializedName("warning")

        /* renamed from: f  reason: collision with root package name */
        private final String f41435f;
        @SerializedName(ImagesContract.URL)

        /* renamed from: g  reason: collision with root package name */
        private final String f41436g;

        public final EarningsBalanceStateType a() {
            return this.f41430a;
        }

        public final DriverImage b() {
            return this.f41431b;
        }

        public final String c() {
            return this.f41434e;
        }

        public final String d() {
            return this.f41432c;
        }

        public final DriverChip e() {
            return this.f41433d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BalanceItem) {
                BalanceItem balanceItem = (BalanceItem) obj;
                return this.f41430a == balanceItem.f41430a && Intrinsics.a(this.f41431b, balanceItem.f41431b) && Intrinsics.a(this.f41432c, balanceItem.f41432c) && Intrinsics.a(this.f41433d, balanceItem.f41433d) && Intrinsics.a(this.f41434e, balanceItem.f41434e) && Intrinsics.a(this.f41435f, balanceItem.f41435f) && Intrinsics.a(this.f41436g, balanceItem.f41436g);
            }
            return false;
        }

        public final String f() {
            return this.f41436g;
        }

        public final String g() {
            return this.f41435f;
        }

        public int hashCode() {
            int hashCode = ((((this.f41430a.hashCode() * 31) + this.f41431b.hashCode()) * 31) + this.f41432c.hashCode()) * 31;
            DriverChip driverChip = this.f41433d;
            int hashCode2 = (hashCode + (driverChip == null ? 0 : driverChip.hashCode())) * 31;
            String str = this.f41434e;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f41435f;
            return ((hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f41436g.hashCode();
        }

        public String toString() {
            EarningsBalanceStateType earningsBalanceStateType = this.f41430a;
            DriverImage driverImage = this.f41431b;
            String str = this.f41432c;
            DriverChip driverChip = this.f41433d;
            String str2 = this.f41434e;
            String str3 = this.f41435f;
            String str4 = this.f41436g;
            return "BalanceItem(balanceState=" + earningsBalanceStateType + ", icon=" + driverImage + ", title=" + str + ", titleChip=" + driverChip + ", subtitle=" + str2 + ", warning=" + str3 + ", url=" + str4 + ")";
        }
    }

    /* compiled from: EarningLandingItem.kt */
    /* loaded from: classes5.dex */
    public static final class Empty extends EarningLandingItem {

        /* renamed from: a  reason: collision with root package name */
        public static final Empty f41437a = new Empty();

        private Empty() {
            super(null);
        }
    }

    /* compiled from: EarningLandingItem.kt */
    /* loaded from: classes5.dex */
    public static final class PieChart extends EarningLandingItem {
        @SerializedName("title")

        /* renamed from: a  reason: collision with root package name */
        private final String f41438a;
        @SerializedName("subtitle")

        /* renamed from: b  reason: collision with root package name */
        private final String f41439b;
        @SerializedName("link")

        /* renamed from: c  reason: collision with root package name */
        private final DriverLink f41440c;
        @SerializedName("items")

        /* renamed from: d  reason: collision with root package name */
        private final List<EarningPieChartItem> f41441d;

        public final List<EarningPieChartItem> a() {
            return this.f41441d;
        }

        public final DriverLink b() {
            return this.f41440c;
        }

        public final String c() {
            return this.f41439b;
        }

        public final String d() {
            return this.f41438a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PieChart) {
                PieChart pieChart = (PieChart) obj;
                return Intrinsics.a(this.f41438a, pieChart.f41438a) && Intrinsics.a(this.f41439b, pieChart.f41439b) && Intrinsics.a(this.f41440c, pieChart.f41440c) && Intrinsics.a(this.f41441d, pieChart.f41441d);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f41438a;
            return ((((((str == null ? 0 : str.hashCode()) * 31) + this.f41439b.hashCode()) * 31) + this.f41440c.hashCode()) * 31) + this.f41441d.hashCode();
        }

        public String toString() {
            String str = this.f41438a;
            String str2 = this.f41439b;
            DriverLink driverLink = this.f41440c;
            List<EarningPieChartItem> list = this.f41441d;
            return "PieChart(title=" + str + ", subtitle=" + str2 + ", link=" + driverLink + ", items=" + list + ")";
        }
    }

    /* compiled from: EarningLandingItem.kt */
    /* loaded from: classes5.dex */
    public enum Type {
        BALANCE,
        PIE_CHART,
        ACTIVITY,
        UNKNOWN
    }

    private EarningLandingItem() {
    }

    public /* synthetic */ EarningLandingItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
