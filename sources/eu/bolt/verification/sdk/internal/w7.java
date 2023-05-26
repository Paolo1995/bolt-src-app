package eu.bolt.verification.sdk.internal;

import android.widget.ImageView;
import eu.bolt.client.design.button.DesignButton;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class w7 {

    /* renamed from: a  reason: collision with root package name */
    public static final b f45492a = new b(null);

    /* loaded from: classes5.dex */
    public static final class a extends w7 {

        /* renamed from: b  reason: collision with root package name */
        private final String f45493b;

        /* renamed from: c  reason: collision with root package name */
        private final ll f45494c;

        /* renamed from: d  reason: collision with root package name */
        private final ll f45495d;

        /* renamed from: e  reason: collision with root package name */
        private final aa f45496e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f45497f;

        /* renamed from: g  reason: collision with root package name */
        private final ud f45498g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String id, ll text, ll llVar, aa aaVar, boolean z7, ud payload) {
            super(null);
            Intrinsics.f(id, "id");
            Intrinsics.f(text, "text");
            Intrinsics.f(payload, "payload");
            this.f45493b = id;
            this.f45494c = text;
            this.f45495d = llVar;
            this.f45496e = aaVar;
            this.f45497f = z7;
            this.f45498g = payload;
        }

        @Override // eu.bolt.verification.sdk.internal.w7
        public String a() {
            return this.f45493b;
        }

        public final aa c() {
            return this.f45496e;
        }

        public final ud d() {
            return this.f45498g;
        }

        public final boolean e() {
            return this.f45497f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(a(), aVar.a()) && Intrinsics.a(this.f45494c, aVar.f45494c) && Intrinsics.a(this.f45495d, aVar.f45495d) && Intrinsics.a(this.f45496e, aVar.f45496e) && this.f45497f == aVar.f45497f && Intrinsics.a(this.f45498g, aVar.f45498g);
            }
            return false;
        }

        public final ll f() {
            return this.f45495d;
        }

        public final ll g() {
            return this.f45494c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((a().hashCode() * 31) + this.f45494c.hashCode()) * 31;
            ll llVar = this.f45495d;
            int hashCode2 = (hashCode + (llVar == null ? 0 : llVar.hashCode())) * 31;
            aa aaVar = this.f45496e;
            int hashCode3 = (hashCode2 + (aaVar != null ? aaVar.hashCode() : 0)) * 31;
            boolean z7 = this.f45497f;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return ((hashCode3 + i8) * 31) + this.f45498g.hashCode();
        }

        public String toString() {
            String a8 = a();
            ll llVar = this.f45494c;
            ll llVar2 = this.f45495d;
            aa aaVar = this.f45496e;
            boolean z7 = this.f45497f;
            ud udVar = this.f45498g;
            return "CheckBoxOption(id=" + a8 + ", text=" + llVar + ", subtitle=" + llVar2 + ", icon=" + aaVar + ", selected=" + z7 + ", payload=" + udVar + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends w7 {

        /* renamed from: b  reason: collision with root package name */
        private final String f45499b;

        /* renamed from: c  reason: collision with root package name */
        private final aa f45500c;

        /* renamed from: d  reason: collision with root package name */
        private final ll f45501d;

        /* renamed from: e  reason: collision with root package name */
        private final k2 f45502e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String id, aa aaVar, ll title, k2 payload) {
            super(null);
            Intrinsics.f(id, "id");
            Intrinsics.f(title, "title");
            Intrinsics.f(payload, "payload");
            this.f45499b = id;
            this.f45500c = aaVar;
            this.f45501d = title;
            this.f45502e = payload;
        }

        @Override // eu.bolt.verification.sdk.internal.w7
        public String a() {
            return this.f45499b;
        }

        public final aa c() {
            return this.f45500c;
        }

        public final k2 d() {
            return this.f45502e;
        }

        public final ll e() {
            return this.f45501d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return Intrinsics.a(a(), cVar.a()) && Intrinsics.a(this.f45500c, cVar.f45500c) && Intrinsics.a(this.f45501d, cVar.f45501d) && Intrinsics.a(this.f45502e, cVar.f45502e);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = a().hashCode() * 31;
            aa aaVar = this.f45500c;
            return ((((hashCode + (aaVar == null ? 0 : aaVar.hashCode())) * 31) + this.f45501d.hashCode()) * 31) + this.f45502e.hashCode();
        }

        public String toString() {
            String a8 = a();
            aa aaVar = this.f45500c;
            ll llVar = this.f45501d;
            k2 k2Var = this.f45502e;
            return "CountryPickerUiModel(id=" + a8 + ", flagIcon=" + aaVar + ", title=" + llVar + ", payload=" + k2Var + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends w7 {

        /* renamed from: b  reason: collision with root package name */
        private final String f45503b;

        /* renamed from: c  reason: collision with root package name */
        private final Long f45504c;

        /* renamed from: d  reason: collision with root package name */
        private final Long f45505d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String id, Long l8, Long l9) {
            super(null);
            Intrinsics.f(id, "id");
            this.f45503b = id;
            this.f45504c = l8;
            this.f45505d = l9;
        }

        @Override // eu.bolt.verification.sdk.internal.w7
        public String a() {
            return this.f45503b;
        }

        @Override // eu.bolt.verification.sdk.internal.w7
        public boolean b(w7 other) {
            Intrinsics.f(other, "other");
            return (other instanceof d) && Intrinsics.a(other.a(), a()) && Intrinsics.a(((d) other).f45504c, this.f45504c);
        }

        public final Long c() {
            return this.f45504c;
        }

        public final Long d() {
            return this.f45505d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof d) {
                d dVar = (d) obj;
                return Intrinsics.a(a(), dVar.a()) && Intrinsics.a(this.f45504c, dVar.f45504c) && Intrinsics.a(this.f45505d, dVar.f45505d);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = a().hashCode() * 31;
            Long l8 = this.f45504c;
            int hashCode2 = (hashCode + (l8 == null ? 0 : l8.hashCode())) * 31;
            Long l9 = this.f45505d;
            return hashCode2 + (l9 != null ? l9.hashCode() : 0);
        }

        public String toString() {
            String a8 = a();
            Long l8 = this.f45504c;
            Long l9 = this.f45505d;
            return "DateInput(id=" + a8 + ", hintDate=" + l8 + ", value=" + l9 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends w7 {

        /* renamed from: b  reason: collision with root package name */
        private final String f45506b;

        /* renamed from: c  reason: collision with root package name */
        private final ll f45507c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f45508d;

        /* renamed from: e  reason: collision with root package name */
        private final DesignButton.b f45509e;

        /* renamed from: f  reason: collision with root package name */
        private final b1 f45510f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String id, ll text, boolean z7, DesignButton.b style, b1 payload) {
            super(null);
            Intrinsics.f(id, "id");
            Intrinsics.f(text, "text");
            Intrinsics.f(style, "style");
            Intrinsics.f(payload, "payload");
            this.f45506b = id;
            this.f45507c = text;
            this.f45508d = z7;
            this.f45509e = style;
            this.f45510f = payload;
        }

        @Override // eu.bolt.verification.sdk.internal.w7
        public String a() {
            return this.f45506b;
        }

        public final b1 c() {
            return this.f45510f;
        }

        public final DesignButton.b d() {
            return this.f45509e;
        }

        public final ll e() {
            return this.f45507c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof e) {
                e eVar = (e) obj;
                return Intrinsics.a(a(), eVar.a()) && Intrinsics.a(this.f45507c, eVar.f45507c) && this.f45508d == eVar.f45508d && this.f45509e == eVar.f45509e && Intrinsics.a(this.f45510f, eVar.f45510f);
            }
            return false;
        }

        public final boolean f() {
            return this.f45508d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((a().hashCode() * 31) + this.f45507c.hashCode()) * 31;
            boolean z7 = this.f45508d;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return ((((hashCode + i8) * 31) + this.f45509e.hashCode()) * 31) + this.f45510f.hashCode();
        }

        public String toString() {
            String a8 = a();
            ll llVar = this.f45507c;
            boolean z7 = this.f45508d;
            DesignButton.b bVar = this.f45509e;
            b1 b1Var = this.f45510f;
            return "FormButtonUiModel(id=" + a8 + ", text=" + llVar + ", isEnabled=" + z7 + ", style=" + bVar + ", payload=" + b1Var + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class f extends w7 {

        /* renamed from: b  reason: collision with root package name */
        private final String f45511b;

        /* renamed from: c  reason: collision with root package name */
        private final aa f45512c;

        /* renamed from: d  reason: collision with root package name */
        private final ImageView.ScaleType f45513d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String id, aa source, ImageView.ScaleType scaleType) {
            super(null);
            Intrinsics.f(id, "id");
            Intrinsics.f(source, "source");
            Intrinsics.f(scaleType, "scaleType");
            this.f45511b = id;
            this.f45512c = source;
            this.f45513d = scaleType;
        }

        @Override // eu.bolt.verification.sdk.internal.w7
        public String a() {
            return this.f45511b;
        }

        public final aa c() {
            return this.f45512c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof f) {
                f fVar = (f) obj;
                return Intrinsics.a(a(), fVar.a()) && Intrinsics.a(this.f45512c, fVar.f45512c) && this.f45513d == fVar.f45513d;
            }
            return false;
        }

        public int hashCode() {
            return (((a().hashCode() * 31) + this.f45512c.hashCode()) * 31) + this.f45513d.hashCode();
        }

        public String toString() {
            String a8 = a();
            aa aaVar = this.f45512c;
            ImageView.ScaleType scaleType = this.f45513d;
            return "Image(id=" + a8 + ", source=" + aaVar + ", scaleType=" + scaleType + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class g extends w7 {

        /* renamed from: b  reason: collision with root package name */
        private final String f45514b;

        /* renamed from: c  reason: collision with root package name */
        private final aa f45515c;

        /* renamed from: d  reason: collision with root package name */
        private final ImageView.ScaleType f45516d;

        /* renamed from: e  reason: collision with root package name */
        private final ec f45517e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String id, aa source, ImageView.ScaleType scaleType, ec overlay) {
            super(null);
            Intrinsics.f(id, "id");
            Intrinsics.f(source, "source");
            Intrinsics.f(scaleType, "scaleType");
            Intrinsics.f(overlay, "overlay");
            this.f45514b = id;
            this.f45515c = source;
            this.f45516d = scaleType;
            this.f45517e = overlay;
        }

        @Override // eu.bolt.verification.sdk.internal.w7
        public String a() {
            return this.f45514b;
        }

        public final ec c() {
            return this.f45517e;
        }

        public final aa d() {
            return this.f45515c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof g) {
                g gVar = (g) obj;
                return Intrinsics.a(a(), gVar.a()) && Intrinsics.a(this.f45515c, gVar.f45515c) && this.f45516d == gVar.f45516d && Intrinsics.a(this.f45517e, gVar.f45517e);
            }
            return false;
        }

        public int hashCode() {
            return (((((a().hashCode() * 31) + this.f45515c.hashCode()) * 31) + this.f45516d.hashCode()) * 31) + this.f45517e.hashCode();
        }

        public String toString() {
            String a8 = a();
            aa aaVar = this.f45515c;
            ImageView.ScaleType scaleType = this.f45516d;
            ec ecVar = this.f45517e;
            return "MediaPreview(id=" + a8 + ", source=" + aaVar + ", scaleType=" + scaleType + ", overlay=" + ecVar + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class h extends w7 {

        /* renamed from: b  reason: collision with root package name */
        private final String f45518b;

        /* renamed from: c  reason: collision with root package name */
        private final ll f45519c;

        /* renamed from: d  reason: collision with root package name */
        private final aa f45520d;

        /* renamed from: e  reason: collision with root package name */
        private final i f45521e;

        /* renamed from: f  reason: collision with root package name */
        private final List<cm> f45522f;

        /* renamed from: g  reason: collision with root package name */
        private final int f45523g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String id, ll text, aa aaVar, i textAlignment, List<cm> urlIntercepts, int i8) {
            super(null);
            Intrinsics.f(id, "id");
            Intrinsics.f(text, "text");
            Intrinsics.f(textAlignment, "textAlignment");
            Intrinsics.f(urlIntercepts, "urlIntercepts");
            this.f45518b = id;
            this.f45519c = text;
            this.f45520d = aaVar;
            this.f45521e = textAlignment;
            this.f45522f = urlIntercepts;
            this.f45523g = i8;
        }

        @Override // eu.bolt.verification.sdk.internal.w7
        public String a() {
            return this.f45518b;
        }

        public final int c() {
            return this.f45523g;
        }

        public final aa d() {
            return this.f45520d;
        }

        public final ll e() {
            return this.f45519c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof h) {
                h hVar = (h) obj;
                return Intrinsics.a(a(), hVar.a()) && Intrinsics.a(this.f45519c, hVar.f45519c) && Intrinsics.a(this.f45520d, hVar.f45520d) && this.f45521e == hVar.f45521e && Intrinsics.a(this.f45522f, hVar.f45522f) && this.f45523g == hVar.f45523g;
            }
            return false;
        }

        public final i f() {
            return this.f45521e;
        }

        public final List<cm> g() {
            return this.f45522f;
        }

        public int hashCode() {
            int hashCode = ((a().hashCode() * 31) + this.f45519c.hashCode()) * 31;
            aa aaVar = this.f45520d;
            return ((((((hashCode + (aaVar == null ? 0 : aaVar.hashCode())) * 31) + this.f45521e.hashCode()) * 31) + this.f45522f.hashCode()) * 31) + this.f45523g;
        }

        public String toString() {
            String a8 = a();
            ll llVar = this.f45519c;
            aa aaVar = this.f45520d;
            i iVar = this.f45521e;
            List<cm> list = this.f45522f;
            int i8 = this.f45523g;
            return "Paragraph(id=" + a8 + ", text=" + llVar + ", icon=" + aaVar + ", textAlignment=" + iVar + ", urlIntercepts=" + list + ", distanceToIconDP=" + i8 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public enum i {
        START,
        CENTER
    }

    /* loaded from: classes5.dex */
    public static final class j extends w7 {

        /* renamed from: b  reason: collision with root package name */
        private final String f45527b;

        /* renamed from: c  reason: collision with root package name */
        private final String f45528c;

        /* renamed from: d  reason: collision with root package name */
        private final a f45529d;

        /* renamed from: e  reason: collision with root package name */
        private final String f45530e;

        /* loaded from: classes5.dex */
        public enum a {
            TEXT,
            NUMBERS
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String id, String str, a inputType, String str2) {
            super(null);
            Intrinsics.f(id, "id");
            Intrinsics.f(inputType, "inputType");
            this.f45527b = id;
            this.f45528c = str;
            this.f45529d = inputType;
            this.f45530e = str2;
        }

        @Override // eu.bolt.verification.sdk.internal.w7
        public String a() {
            return this.f45527b;
        }

        @Override // eu.bolt.verification.sdk.internal.w7
        public boolean b(w7 other) {
            Intrinsics.f(other, "other");
            if ((other instanceof j) && Intrinsics.a(other.a(), a())) {
                j jVar = (j) other;
                if (Intrinsics.a(jVar.f45528c, this.f45528c) && jVar.f45529d == this.f45529d) {
                    return true;
                }
            }
            return false;
        }

        public final String c() {
            return this.f45528c;
        }

        public final a d() {
            return this.f45529d;
        }

        public final String e() {
            return this.f45530e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof j) {
                j jVar = (j) obj;
                return Intrinsics.a(a(), jVar.a()) && Intrinsics.a(this.f45528c, jVar.f45528c) && this.f45529d == jVar.f45529d && Intrinsics.a(this.f45530e, jVar.f45530e);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = a().hashCode() * 31;
            String str = this.f45528c;
            int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f45529d.hashCode()) * 31;
            String str2 = this.f45530e;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            String a8 = a();
            String str = this.f45528c;
            a aVar = this.f45529d;
            String str2 = this.f45530e;
            return "TextInput(id=" + a8 + ", hint=" + str + ", inputType=" + aVar + ", value=" + str2 + ")";
        }
    }

    private w7() {
    }

    public /* synthetic */ w7(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String a();

    public boolean b(w7 other) {
        Intrinsics.f(other, "other");
        return Intrinsics.a(this, other);
    }
}
