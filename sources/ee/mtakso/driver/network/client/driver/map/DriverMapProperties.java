package ee.mtakso.driver.network.client.driver.map;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverMapProperties.kt */
@JsonAdapter(DriverMapPropertiesDeserializer.class)
/* loaded from: classes3.dex */
public abstract class DriverMapProperties {

    /* compiled from: DriverMapProperties.kt */
    /* loaded from: classes3.dex */
    public static final class Label extends DriverMapProperties {
        @SerializedName("title_html")

        /* renamed from: a  reason: collision with root package name */
        private final String f22027a;
        @SerializedName("icon")

        /* renamed from: b  reason: collision with root package name */
        private final String f22028b;
        @SerializedName("title_background")

        /* renamed from: c  reason: collision with root package name */
        private final String f22029c;
        @SerializedName("title_background_dark")

        /* renamed from: d  reason: collision with root package name */
        private final String f22030d;
        @SerializedName("localized_title_html_key")

        /* renamed from: e  reason: collision with root package name */
        private final String f22031e;

        public final String a() {
            return this.f22028b;
        }

        public final String b() {
            return this.f22031e;
        }

        public final String c() {
            return this.f22029c;
        }

        public final String d() {
            return this.f22030d;
        }

        public final String e() {
            return this.f22027a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Label) {
                Label label = (Label) obj;
                return Intrinsics.a(this.f22027a, label.f22027a) && Intrinsics.a(this.f22028b, label.f22028b) && Intrinsics.a(this.f22029c, label.f22029c) && Intrinsics.a(this.f22030d, label.f22030d) && Intrinsics.a(this.f22031e, label.f22031e);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f22027a;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.f22028b;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f22029c;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f22030d;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.f22031e;
            return hashCode4 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            String str = this.f22027a;
            String str2 = this.f22028b;
            String str3 = this.f22029c;
            String str4 = this.f22030d;
            String str5 = this.f22031e;
            return "Label(titleHtml=" + str + ", icon=" + str2 + ", titleBackground=" + str3 + ", titleBackgroundDark=" + str4 + ", localizedTitleHtmlKey=" + str5 + ")";
        }
    }

    /* compiled from: DriverMapProperties.kt */
    /* loaded from: classes3.dex */
    public static final class LocationAwareLine extends DriverMapProperties {
        @SerializedName("stroke")

        /* renamed from: a  reason: collision with root package name */
        private final String f22032a;
        @SerializedName("stroke_dark")

        /* renamed from: b  reason: collision with root package name */
        private final String f22033b;
        @SerializedName("outside_stroke")

        /* renamed from: c  reason: collision with root package name */
        private final String f22034c;
        @SerializedName("outside_stroke_dark")

        /* renamed from: d  reason: collision with root package name */
        private final String f22035d;

        public final String a() {
            return this.f22034c;
        }

        public final String b() {
            return this.f22035d;
        }

        public final String c() {
            return this.f22032a;
        }

        public final String d() {
            return this.f22033b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LocationAwareLine) {
                LocationAwareLine locationAwareLine = (LocationAwareLine) obj;
                return Intrinsics.a(this.f22032a, locationAwareLine.f22032a) && Intrinsics.a(this.f22033b, locationAwareLine.f22033b) && Intrinsics.a(this.f22034c, locationAwareLine.f22034c) && Intrinsics.a(this.f22035d, locationAwareLine.f22035d);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f22032a;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.f22033b;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f22034c;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f22035d;
            return hashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            String str = this.f22032a;
            String str2 = this.f22033b;
            String str3 = this.f22034c;
            String str4 = this.f22035d;
            return "LocationAwareLine(stroke=" + str + ", strokeDark=" + str2 + ", outsideStroke=" + str3 + ", outsideStrokeDark=" + str4 + ")";
        }
    }

    /* compiled from: DriverMapProperties.kt */
    /* loaded from: classes3.dex */
    public static final class LocationAwarePolygon extends DriverMapProperties {
        @SerializedName("fill")

        /* renamed from: a  reason: collision with root package name */
        private final String f22036a;
        @SerializedName("fill_dark")

        /* renamed from: b  reason: collision with root package name */
        private final String f22037b;
        @SerializedName("outside_fill")

        /* renamed from: c  reason: collision with root package name */
        private final String f22038c;
        @SerializedName("outside_fill_dark")

        /* renamed from: d  reason: collision with root package name */
        private final String f22039d;

        public final String a() {
            return this.f22036a;
        }

        public final String b() {
            return this.f22037b;
        }

        public final String c() {
            return this.f22038c;
        }

        public final String d() {
            return this.f22039d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LocationAwarePolygon) {
                LocationAwarePolygon locationAwarePolygon = (LocationAwarePolygon) obj;
                return Intrinsics.a(this.f22036a, locationAwarePolygon.f22036a) && Intrinsics.a(this.f22037b, locationAwarePolygon.f22037b) && Intrinsics.a(this.f22038c, locationAwarePolygon.f22038c) && Intrinsics.a(this.f22039d, locationAwarePolygon.f22039d);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f22036a;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.f22037b;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f22038c;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f22039d;
            return hashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            String str = this.f22036a;
            String str2 = this.f22037b;
            String str3 = this.f22038c;
            String str4 = this.f22039d;
            return "LocationAwarePolygon(fill=" + str + ", fillDark=" + str2 + ", outsideFill=" + str3 + ", outsideFillDark=" + str4 + ")";
        }
    }

    /* compiled from: DriverMapProperties.kt */
    /* loaded from: classes3.dex */
    public static final class Polygon extends DriverMapProperties {
        @SerializedName("fill")

        /* renamed from: a  reason: collision with root package name */
        private final String f22040a;
        @SerializedName("fill_dark")

        /* renamed from: b  reason: collision with root package name */
        private final String f22041b;
        @SerializedName("stroke")

        /* renamed from: c  reason: collision with root package name */
        private final String f22042c;
        @SerializedName("stroke_dark")

        /* renamed from: d  reason: collision with root package name */
        private final String f22043d;

        public final String a() {
            return this.f22040a;
        }

        public final String b() {
            return this.f22041b;
        }

        public final String c() {
            return this.f22042c;
        }

        public final String d() {
            return this.f22043d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Polygon) {
                Polygon polygon = (Polygon) obj;
                return Intrinsics.a(this.f22040a, polygon.f22040a) && Intrinsics.a(this.f22041b, polygon.f22041b) && Intrinsics.a(this.f22042c, polygon.f22042c) && Intrinsics.a(this.f22043d, polygon.f22043d);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f22040a;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.f22041b;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f22042c;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f22043d;
            return hashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            String str = this.f22040a;
            String str2 = this.f22041b;
            String str3 = this.f22042c;
            String str4 = this.f22043d;
            return "Polygon(fill=" + str + ", fillDark=" + str2 + ", stroke=" + str3 + ", strokeDark=" + str4 + ")";
        }
    }

    /* compiled from: DriverMapProperties.kt */
    /* loaded from: classes3.dex */
    public static final class Unknown extends DriverMapProperties {

        /* renamed from: a  reason: collision with root package name */
        public static final Unknown f22044a = new Unknown();

        private Unknown() {
            super(null);
        }
    }

    private DriverMapProperties() {
    }

    public /* synthetic */ DriverMapProperties(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
