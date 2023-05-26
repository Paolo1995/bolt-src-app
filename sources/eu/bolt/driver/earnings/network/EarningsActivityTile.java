package eu.bolt.driver.earnings.network;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsActivityTile.kt */
@JsonAdapter(EarningsActivityTileDeserializer.class)
/* loaded from: classes5.dex */
public abstract class EarningsActivityTile {

    /* compiled from: EarningsActivityTile.kt */
    /* loaded from: classes5.dex */
    public static final class Chart extends EarningsActivityTile {
        @SerializedName("title")

        /* renamed from: a  reason: collision with root package name */
        private final String f41451a;
        @SerializedName("bars")

        /* renamed from: b  reason: collision with root package name */
        private final List<ChartBar> f41452b;
        @SerializedName(ImagesContract.URL)

        /* renamed from: c  reason: collision with root package name */
        private final String f41453c;

        public final List<ChartBar> a() {
            return this.f41452b;
        }

        public final String b() {
            return this.f41451a;
        }

        public final String c() {
            return this.f41453c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Chart) {
                Chart chart = (Chart) obj;
                return Intrinsics.a(this.f41451a, chart.f41451a) && Intrinsics.a(this.f41452b, chart.f41452b) && Intrinsics.a(this.f41453c, chart.f41453c);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((this.f41451a.hashCode() * 31) + this.f41452b.hashCode()) * 31;
            String str = this.f41453c;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            String str = this.f41451a;
            List<ChartBar> list = this.f41452b;
            String str2 = this.f41453c;
            return "Chart(title=" + str + ", bars=" + list + ", url=" + str2 + ")";
        }
    }

    /* compiled from: EarningsActivityTile.kt */
    /* loaded from: classes5.dex */
    public static final class ChartBar {
        @SerializedName(AppMeasurementSdk.ConditionalUserProperty.VALUE)

        /* renamed from: a  reason: collision with root package name */
        private final double f41454a;
        @SerializedName("legend")

        /* renamed from: b  reason: collision with root package name */
        private final String f41455b;

        public final String a() {
            return this.f41455b;
        }

        public final double b() {
            return this.f41454a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ChartBar) {
                ChartBar chartBar = (ChartBar) obj;
                return Double.compare(this.f41454a, chartBar.f41454a) == 0 && Intrinsics.a(this.f41455b, chartBar.f41455b);
            }
            return false;
        }

        public int hashCode() {
            return (q1.a.a(this.f41454a) * 31) + this.f41455b.hashCode();
        }

        public String toString() {
            double d8 = this.f41454a;
            String str = this.f41455b;
            return "ChartBar(value=" + d8 + ", legend=" + str + ")";
        }
    }

    /* compiled from: EarningsActivityTile.kt */
    /* loaded from: classes5.dex */
    public static final class Empty extends EarningsActivityTile {

        /* renamed from: a  reason: collision with root package name */
        public static final Empty f41456a = new Empty();

        private Empty() {
            super(null);
        }
    }

    /* compiled from: EarningsActivityTile.kt */
    /* loaded from: classes5.dex */
    public static final class Progress extends EarningsActivityTile {
        @SerializedName("title")

        /* renamed from: a  reason: collision with root package name */
        private final String f41457a;
        @SerializedName(AppMeasurementSdk.ConditionalUserProperty.VALUE)

        /* renamed from: b  reason: collision with root package name */
        private final String f41458b;
        @SerializedName("text")

        /* renamed from: c  reason: collision with root package name */
        private final String f41459c;
        @SerializedName("progress")

        /* renamed from: d  reason: collision with root package name */
        private final float f41460d;
        @SerializedName(ImagesContract.URL)

        /* renamed from: e  reason: collision with root package name */
        private final String f41461e;

        public final float a() {
            return this.f41460d;
        }

        public final String b() {
            return this.f41459c;
        }

        public final String c() {
            return this.f41457a;
        }

        public final String d() {
            return this.f41461e;
        }

        public final String e() {
            return this.f41458b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Progress) {
                Progress progress = (Progress) obj;
                return Intrinsics.a(this.f41457a, progress.f41457a) && Intrinsics.a(this.f41458b, progress.f41458b) && Intrinsics.a(this.f41459c, progress.f41459c) && Float.compare(this.f41460d, progress.f41460d) == 0 && Intrinsics.a(this.f41461e, progress.f41461e);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((((this.f41457a.hashCode() * 31) + this.f41458b.hashCode()) * 31) + this.f41459c.hashCode()) * 31) + Float.floatToIntBits(this.f41460d)) * 31;
            String str = this.f41461e;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            String str = this.f41457a;
            String str2 = this.f41458b;
            String str3 = this.f41459c;
            float f8 = this.f41460d;
            String str4 = this.f41461e;
            return "Progress(title=" + str + ", value=" + str2 + ", text=" + str3 + ", progress=" + f8 + ", url=" + str4 + ")";
        }
    }

    /* compiled from: EarningsActivityTile.kt */
    /* loaded from: classes5.dex */
    public static final class Text extends EarningsActivityTile {
        @SerializedName("title")

        /* renamed from: a  reason: collision with root package name */
        private final String f41462a;
        @SerializedName(AppMeasurementSdk.ConditionalUserProperty.VALUE)

        /* renamed from: b  reason: collision with root package name */
        private final String f41463b;
        @SerializedName("text")

        /* renamed from: c  reason: collision with root package name */
        private final String f41464c;
        @SerializedName(ImagesContract.URL)

        /* renamed from: d  reason: collision with root package name */
        private final String f41465d;

        public final String a() {
            return this.f41464c;
        }

        public final String b() {
            return this.f41462a;
        }

        public final String c() {
            return this.f41465d;
        }

        public final String d() {
            return this.f41463b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Text) {
                Text text = (Text) obj;
                return Intrinsics.a(this.f41462a, text.f41462a) && Intrinsics.a(this.f41463b, text.f41463b) && Intrinsics.a(this.f41464c, text.f41464c) && Intrinsics.a(this.f41465d, text.f41465d);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((this.f41462a.hashCode() * 31) + this.f41463b.hashCode()) * 31) + this.f41464c.hashCode()) * 31;
            String str = this.f41465d;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            String str = this.f41462a;
            String str2 = this.f41463b;
            String str3 = this.f41464c;
            String str4 = this.f41465d;
            return "Text(title=" + str + ", value=" + str2 + ", text=" + str3 + ", url=" + str4 + ")";
        }
    }

    /* compiled from: EarningsActivityTile.kt */
    /* loaded from: classes5.dex */
    public static final class TextWithIcon extends EarningsActivityTile {
        @SerializedName("title")

        /* renamed from: a  reason: collision with root package name */
        private final String f41466a;
        @SerializedName("text")

        /* renamed from: b  reason: collision with root package name */
        private final String f41467b;
        @SerializedName("icon")

        /* renamed from: c  reason: collision with root package name */
        private final DriverImage f41468c;
        @SerializedName(ImagesContract.URL)

        /* renamed from: d  reason: collision with root package name */
        private final String f41469d;

        public final DriverImage a() {
            return this.f41468c;
        }

        public final String b() {
            return this.f41467b;
        }

        public final String c() {
            return this.f41466a;
        }

        public final String d() {
            return this.f41469d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TextWithIcon) {
                TextWithIcon textWithIcon = (TextWithIcon) obj;
                return Intrinsics.a(this.f41466a, textWithIcon.f41466a) && Intrinsics.a(this.f41467b, textWithIcon.f41467b) && Intrinsics.a(this.f41468c, textWithIcon.f41468c) && Intrinsics.a(this.f41469d, textWithIcon.f41469d);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((this.f41466a.hashCode() * 31) + this.f41467b.hashCode()) * 31) + this.f41468c.hashCode()) * 31;
            String str = this.f41469d;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            String str = this.f41466a;
            String str2 = this.f41467b;
            DriverImage driverImage = this.f41468c;
            String str3 = this.f41469d;
            return "TextWithIcon(title=" + str + ", text=" + str2 + ", icon=" + driverImage + ", url=" + str3 + ")";
        }
    }

    /* compiled from: EarningsActivityTile.kt */
    /* loaded from: classes5.dex */
    public enum Type {
        CHART,
        TEXT,
        TEXT_WITH_ICON,
        PROGRESS,
        UNKNOWN
    }

    private EarningsActivityTile() {
    }

    public /* synthetic */ EarningsActivityTile(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
