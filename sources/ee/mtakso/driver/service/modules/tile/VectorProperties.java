package ee.mtakso.driver.service.modules.tile;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VectorProperties.kt */
/* loaded from: classes3.dex */
public abstract class VectorProperties {

    /* compiled from: VectorProperties.kt */
    /* loaded from: classes3.dex */
    public static final class Empty extends VectorProperties {

        /* renamed from: a  reason: collision with root package name */
        public static final Empty f25353a = new Empty();

        private Empty() {
            super(null);
        }
    }

    /* compiled from: VectorProperties.kt */
    /* loaded from: classes3.dex */
    public static final class Label extends VectorProperties {

        /* renamed from: a  reason: collision with root package name */
        private final String f25354a;

        /* renamed from: b  reason: collision with root package name */
        private final String f25355b;

        /* renamed from: c  reason: collision with root package name */
        private final String f25356c;

        /* renamed from: d  reason: collision with root package name */
        private final Integer f25357d;

        /* renamed from: e  reason: collision with root package name */
        private final Integer f25358e;

        /* renamed from: f  reason: collision with root package name */
        private final String f25359f;

        /* renamed from: g  reason: collision with root package name */
        private final List<Object> f25360g;

        public Label(String str, String str2, String str3, Integer num, Integer num2, String str4, List<? extends Object> list) {
            super(null);
            this.f25354a = str;
            this.f25355b = str2;
            this.f25356c = str3;
            this.f25357d = num;
            this.f25358e = num2;
            this.f25359f = str4;
            this.f25360g = list;
        }

        public final String a() {
            return this.f25355b;
        }

        public final String b() {
            return this.f25356c;
        }

        public final List<Object> c() {
            return this.f25360g;
        }

        public final String d() {
            return this.f25359f;
        }

        public final Integer e() {
            return this.f25357d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Label) {
                Label label = (Label) obj;
                return Intrinsics.a(this.f25354a, label.f25354a) && Intrinsics.a(this.f25355b, label.f25355b) && Intrinsics.a(this.f25356c, label.f25356c) && Intrinsics.a(this.f25357d, label.f25357d) && Intrinsics.a(this.f25358e, label.f25358e) && Intrinsics.a(this.f25359f, label.f25359f) && Intrinsics.a(this.f25360g, label.f25360g);
            }
            return false;
        }

        public final Integer f() {
            return this.f25358e;
        }

        public final String g() {
            return this.f25354a;
        }

        public int hashCode() {
            String str = this.f25354a;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.f25355b;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f25356c;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Integer num = this.f25357d;
            int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.f25358e;
            int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str4 = this.f25359f;
            int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            List<Object> list = this.f25360g;
            return hashCode6 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            String str = this.f25354a;
            String str2 = this.f25355b;
            String str3 = this.f25356c;
            Integer num = this.f25357d;
            Integer num2 = this.f25358e;
            String str4 = this.f25359f;
            List<Object> list = this.f25360g;
            return "Label(titleHtml=" + str + ", icon=" + str2 + ", iconDark=" + str3 + ", titleBackground=" + num + ", titleBackgroundDark=" + num2 + ", localizedTitleHtmlKey=" + str4 + ", l10nContext=" + list + ")";
        }
    }

    /* compiled from: VectorProperties.kt */
    /* loaded from: classes3.dex */
    public static final class LocationAwareLine extends VectorProperties {

        /* renamed from: a  reason: collision with root package name */
        private final Integer f25361a;

        /* renamed from: b  reason: collision with root package name */
        private final Integer f25362b;

        /* renamed from: c  reason: collision with root package name */
        private final Integer f25363c;

        /* renamed from: d  reason: collision with root package name */
        private final Integer f25364d;

        public LocationAwareLine(Integer num, Integer num2, Integer num3, Integer num4) {
            super(null);
            this.f25361a = num;
            this.f25362b = num2;
            this.f25363c = num3;
            this.f25364d = num4;
        }

        public final Integer a() {
            return this.f25363c;
        }

        public final Integer b() {
            return this.f25364d;
        }

        public final Integer c() {
            return this.f25361a;
        }

        public final Integer d() {
            return this.f25362b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LocationAwareLine) {
                LocationAwareLine locationAwareLine = (LocationAwareLine) obj;
                return Intrinsics.a(this.f25361a, locationAwareLine.f25361a) && Intrinsics.a(this.f25362b, locationAwareLine.f25362b) && Intrinsics.a(this.f25363c, locationAwareLine.f25363c) && Intrinsics.a(this.f25364d, locationAwareLine.f25364d);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.f25361a;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.f25362b;
            int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.f25363c;
            int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.f25364d;
            return hashCode3 + (num4 != null ? num4.hashCode() : 0);
        }

        public String toString() {
            Integer num = this.f25361a;
            Integer num2 = this.f25362b;
            Integer num3 = this.f25363c;
            Integer num4 = this.f25364d;
            return "LocationAwareLine(stroke=" + num + ", strokeDark=" + num2 + ", outsideStroke=" + num3 + ", outsideStrokeDark=" + num4 + ")";
        }
    }

    /* compiled from: VectorProperties.kt */
    /* loaded from: classes3.dex */
    public static final class LocationAwarePolygon extends VectorProperties {

        /* renamed from: a  reason: collision with root package name */
        private final Integer f25365a;

        /* renamed from: b  reason: collision with root package name */
        private final Integer f25366b;

        /* renamed from: c  reason: collision with root package name */
        private final Integer f25367c;

        /* renamed from: d  reason: collision with root package name */
        private final Integer f25368d;

        public LocationAwarePolygon(Integer num, Integer num2, Integer num3, Integer num4) {
            super(null);
            this.f25365a = num;
            this.f25366b = num2;
            this.f25367c = num3;
            this.f25368d = num4;
        }

        public final Integer a() {
            return this.f25365a;
        }

        public final Integer b() {
            return this.f25366b;
        }

        public final Integer c() {
            return this.f25367c;
        }

        public final Integer d() {
            return this.f25368d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LocationAwarePolygon) {
                LocationAwarePolygon locationAwarePolygon = (LocationAwarePolygon) obj;
                return Intrinsics.a(this.f25365a, locationAwarePolygon.f25365a) && Intrinsics.a(this.f25366b, locationAwarePolygon.f25366b) && Intrinsics.a(this.f25367c, locationAwarePolygon.f25367c) && Intrinsics.a(this.f25368d, locationAwarePolygon.f25368d);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.f25365a;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.f25366b;
            int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.f25367c;
            int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.f25368d;
            return hashCode3 + (num4 != null ? num4.hashCode() : 0);
        }

        public String toString() {
            Integer num = this.f25365a;
            Integer num2 = this.f25366b;
            Integer num3 = this.f25367c;
            Integer num4 = this.f25368d;
            return "LocationAwarePolygon(fill=" + num + ", fillDark=" + num2 + ", outsideFill=" + num3 + ", outsideFillDark=" + num4 + ")";
        }
    }

    /* compiled from: VectorProperties.kt */
    /* loaded from: classes3.dex */
    public static final class Polygon extends VectorProperties {

        /* renamed from: a  reason: collision with root package name */
        private final Integer f25369a;

        /* renamed from: b  reason: collision with root package name */
        private final Integer f25370b;

        /* renamed from: c  reason: collision with root package name */
        private final Integer f25371c;

        /* renamed from: d  reason: collision with root package name */
        private final Integer f25372d;

        public Polygon(Integer num, Integer num2, Integer num3, Integer num4) {
            super(null);
            this.f25369a = num;
            this.f25370b = num2;
            this.f25371c = num3;
            this.f25372d = num4;
        }

        public final Integer a() {
            return this.f25369a;
        }

        public final Integer b() {
            return this.f25370b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Polygon) {
                Polygon polygon = (Polygon) obj;
                return Intrinsics.a(this.f25369a, polygon.f25369a) && Intrinsics.a(this.f25370b, polygon.f25370b) && Intrinsics.a(this.f25371c, polygon.f25371c) && Intrinsics.a(this.f25372d, polygon.f25372d);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.f25369a;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.f25370b;
            int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.f25371c;
            int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.f25372d;
            return hashCode3 + (num4 != null ? num4.hashCode() : 0);
        }

        public String toString() {
            Integer num = this.f25369a;
            Integer num2 = this.f25370b;
            Integer num3 = this.f25371c;
            Integer num4 = this.f25372d;
            return "Polygon(fill=" + num + ", fillDark=" + num2 + ", stroke=" + num3 + ", strokeDark=" + num4 + ")";
        }
    }

    private VectorProperties() {
    }

    public /* synthetic */ VectorProperties(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
