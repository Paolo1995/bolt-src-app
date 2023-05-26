package ee.mtakso.driver.service.modules.tile;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeatureProperties.kt */
/* loaded from: classes3.dex */
public abstract class FeatureProperties {

    /* compiled from: FeatureProperties.kt */
    /* loaded from: classes3.dex */
    public static final class Empty extends FeatureProperties {

        /* renamed from: a  reason: collision with root package name */
        public static final Empty f25324a = new Empty();

        /* renamed from: b  reason: collision with root package name */
        private static final String f25325b = "Empty";

        private Empty() {
            super(null);
        }

        @Override // ee.mtakso.driver.service.modules.tile.FeatureProperties
        public String a() {
            return f25325b;
        }
    }

    /* compiled from: FeatureProperties.kt */
    /* loaded from: classes3.dex */
    public static final class Label extends FeatureProperties {

        /* renamed from: a  reason: collision with root package name */
        private final String f25326a;

        /* renamed from: b  reason: collision with root package name */
        private final String f25327b;

        /* renamed from: c  reason: collision with root package name */
        private final String f25328c;

        /* renamed from: d  reason: collision with root package name */
        private final String f25329d;

        /* renamed from: e  reason: collision with root package name */
        private final String f25330e;

        /* renamed from: f  reason: collision with root package name */
        private final String f25331f;

        /* renamed from: g  reason: collision with root package name */
        private final LabelL10nContext f25332g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Label(String type, String str, String str2, String str3, String str4, String str5, LabelL10nContext labelL10nContext) {
            super(null);
            Intrinsics.f(type, "type");
            this.f25326a = type;
            this.f25327b = str;
            this.f25328c = str2;
            this.f25329d = str3;
            this.f25330e = str4;
            this.f25331f = str5;
            this.f25332g = labelL10nContext;
        }

        @Override // ee.mtakso.driver.service.modules.tile.FeatureProperties
        public String a() {
            return this.f25326a;
        }

        public final String b() {
            return this.f25330e;
        }

        public final LabelL10nContext c() {
            return this.f25332g;
        }

        public final String d() {
            return this.f25331f;
        }

        public final String e() {
            return this.f25328c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Label) {
                Label label = (Label) obj;
                return Intrinsics.a(a(), label.a()) && Intrinsics.a(this.f25327b, label.f25327b) && Intrinsics.a(this.f25328c, label.f25328c) && Intrinsics.a(this.f25329d, label.f25329d) && Intrinsics.a(this.f25330e, label.f25330e) && Intrinsics.a(this.f25331f, label.f25331f) && Intrinsics.a(this.f25332g, label.f25332g);
            }
            return false;
        }

        public final String f() {
            return this.f25329d;
        }

        public final String g() {
            return this.f25327b;
        }

        public int hashCode() {
            int hashCode = a().hashCode() * 31;
            String str = this.f25327b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f25328c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f25329d;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f25330e;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.f25331f;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            LabelL10nContext labelL10nContext = this.f25332g;
            return hashCode6 + (labelL10nContext != null ? labelL10nContext.hashCode() : 0);
        }

        public String toString() {
            String a8 = a();
            String str = this.f25327b;
            String str2 = this.f25328c;
            String str3 = this.f25329d;
            String str4 = this.f25330e;
            String str5 = this.f25331f;
            LabelL10nContext labelL10nContext = this.f25332g;
            return "Label(type=" + a8 + ", titleHtml=" + str + ", titleBackground=" + str2 + ", titleBackgroundDark=" + str3 + ", icon=" + str4 + ", localizedTitleHtmlKey=" + str5 + ", l10nContext=" + labelL10nContext + ")";
        }
    }

    /* compiled from: FeatureProperties.kt */
    /* loaded from: classes3.dex */
    public static final class LocationAwareLine extends FeatureProperties {

        /* renamed from: a  reason: collision with root package name */
        private final String f25333a;

        /* renamed from: b  reason: collision with root package name */
        private final String f25334b;

        /* renamed from: c  reason: collision with root package name */
        private final String f25335c;

        /* renamed from: d  reason: collision with root package name */
        private final String f25336d;

        /* renamed from: e  reason: collision with root package name */
        private final String f25337e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LocationAwareLine(String type, String str, String str2, String str3, String str4) {
            super(null);
            Intrinsics.f(type, "type");
            this.f25333a = type;
            this.f25334b = str;
            this.f25335c = str2;
            this.f25336d = str3;
            this.f25337e = str4;
        }

        @Override // ee.mtakso.driver.service.modules.tile.FeatureProperties
        public String a() {
            return this.f25333a;
        }

        public final String b() {
            return this.f25336d;
        }

        public final String c() {
            return this.f25337e;
        }

        public final String d() {
            return this.f25334b;
        }

        public final String e() {
            return this.f25335c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LocationAwareLine) {
                LocationAwareLine locationAwareLine = (LocationAwareLine) obj;
                return Intrinsics.a(a(), locationAwareLine.a()) && Intrinsics.a(this.f25334b, locationAwareLine.f25334b) && Intrinsics.a(this.f25335c, locationAwareLine.f25335c) && Intrinsics.a(this.f25336d, locationAwareLine.f25336d) && Intrinsics.a(this.f25337e, locationAwareLine.f25337e);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = a().hashCode() * 31;
            String str = this.f25334b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f25335c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f25336d;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f25337e;
            return hashCode4 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            String a8 = a();
            String str = this.f25334b;
            String str2 = this.f25335c;
            String str3 = this.f25336d;
            String str4 = this.f25337e;
            return "LocationAwareLine(type=" + a8 + ", stroke=" + str + ", strokeDark=" + str2 + ", outsideStroke=" + str3 + ", outsideStrokeDark=" + str4 + ")";
        }
    }

    /* compiled from: FeatureProperties.kt */
    /* loaded from: classes3.dex */
    public static final class LocationAwarePolygon extends FeatureProperties {

        /* renamed from: a  reason: collision with root package name */
        private final String f25338a;

        /* renamed from: b  reason: collision with root package name */
        private final String f25339b;

        /* renamed from: c  reason: collision with root package name */
        private final String f25340c;

        /* renamed from: d  reason: collision with root package name */
        private final String f25341d;

        /* renamed from: e  reason: collision with root package name */
        private final String f25342e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LocationAwarePolygon(String type, String str, String str2, String str3, String str4) {
            super(null);
            Intrinsics.f(type, "type");
            this.f25338a = type;
            this.f25339b = str;
            this.f25340c = str2;
            this.f25341d = str3;
            this.f25342e = str4;
        }

        @Override // ee.mtakso.driver.service.modules.tile.FeatureProperties
        public String a() {
            return this.f25338a;
        }

        public final String b() {
            return this.f25339b;
        }

        public final String c() {
            return this.f25340c;
        }

        public final String d() {
            return this.f25341d;
        }

        public final String e() {
            return this.f25342e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LocationAwarePolygon) {
                LocationAwarePolygon locationAwarePolygon = (LocationAwarePolygon) obj;
                return Intrinsics.a(a(), locationAwarePolygon.a()) && Intrinsics.a(this.f25339b, locationAwarePolygon.f25339b) && Intrinsics.a(this.f25340c, locationAwarePolygon.f25340c) && Intrinsics.a(this.f25341d, locationAwarePolygon.f25341d) && Intrinsics.a(this.f25342e, locationAwarePolygon.f25342e);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = a().hashCode() * 31;
            String str = this.f25339b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f25340c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f25341d;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f25342e;
            return hashCode4 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            String a8 = a();
            String str = this.f25339b;
            String str2 = this.f25340c;
            String str3 = this.f25341d;
            String str4 = this.f25342e;
            return "LocationAwarePolygon(type=" + a8 + ", fill=" + str + ", fillDark=" + str2 + ", outsideFill=" + str3 + ", outsideFillDark=" + str4 + ")";
        }
    }

    /* compiled from: FeatureProperties.kt */
    /* loaded from: classes3.dex */
    public static final class Polygon extends FeatureProperties {

        /* renamed from: a  reason: collision with root package name */
        private final String f25343a;

        /* renamed from: b  reason: collision with root package name */
        private final String f25344b;

        /* renamed from: c  reason: collision with root package name */
        private final String f25345c;

        /* renamed from: d  reason: collision with root package name */
        private final String f25346d;

        /* renamed from: e  reason: collision with root package name */
        private final String f25347e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Polygon(String type, String str, String str2, String str3, String str4) {
            super(null);
            Intrinsics.f(type, "type");
            this.f25343a = type;
            this.f25344b = str;
            this.f25345c = str2;
            this.f25346d = str3;
            this.f25347e = str4;
        }

        @Override // ee.mtakso.driver.service.modules.tile.FeatureProperties
        public String a() {
            return this.f25343a;
        }

        public final String b() {
            return this.f25344b;
        }

        public final String c() {
            return this.f25345c;
        }

        public final String d() {
            return this.f25346d;
        }

        public final String e() {
            return this.f25347e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Polygon) {
                Polygon polygon = (Polygon) obj;
                return Intrinsics.a(a(), polygon.a()) && Intrinsics.a(this.f25344b, polygon.f25344b) && Intrinsics.a(this.f25345c, polygon.f25345c) && Intrinsics.a(this.f25346d, polygon.f25346d) && Intrinsics.a(this.f25347e, polygon.f25347e);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = a().hashCode() * 31;
            String str = this.f25344b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f25345c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f25346d;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f25347e;
            return hashCode4 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            String a8 = a();
            String str = this.f25344b;
            String str2 = this.f25345c;
            String str3 = this.f25346d;
            String str4 = this.f25347e;
            return "Polygon(type=" + a8 + ", fill=" + str + ", fillDark=" + str2 + ", stroke=" + str3 + ", strokeDark=" + str4 + ")";
        }
    }

    private FeatureProperties() {
    }

    public /* synthetic */ FeatureProperties(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String a();
}
