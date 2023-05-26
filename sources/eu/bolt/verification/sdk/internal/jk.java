package eu.bolt.verification.sdk.internal;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import eu.bolt.client.network.model.common.RGBAColorResponse;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes5.dex */
public final class jk {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final String f43709a;
    @SerializedName("layout")

    /* renamed from: b  reason: collision with root package name */
    private final String f43710b;
    @SerializedName("background_color")

    /* renamed from: c  reason: collision with root package name */
    private final RGBAColorResponse f43711c;
    @SerializedName("text_highlight_color")

    /* renamed from: d  reason: collision with root package name */
    private final RGBAColorResponse f43712d;
    @SerializedName("title")

    /* renamed from: e  reason: collision with root package name */
    private final String f43713e;
    @SerializedName("title_html")

    /* renamed from: f  reason: collision with root package name */
    private final String f43714f;
    @SerializedName("description")

    /* renamed from: g  reason: collision with root package name */
    private final String f43715g;
    @SerializedName("description_html")

    /* renamed from: h  reason: collision with root package name */
    private final String f43716h;
    @SerializedName("asset")

    /* renamed from: i  reason: collision with root package name */
    private final e f43717i;
    @SerializedName("button")

    /* renamed from: j  reason: collision with root package name */
    private final f f43718j;
    @SerializedName("auto_switch_time_ms")

    /* renamed from: k  reason: collision with root package name */
    private final Long f43719k;
    @SerializedName("footer_html")

    /* renamed from: l  reason: collision with root package name */
    private final String f43720l;
    @SerializedName("content")

    /* renamed from: m  reason: collision with root package name */
    private final b f43721m;

    /* loaded from: classes5.dex */
    public static final class a {
        @SerializedName("text")

        /* renamed from: a  reason: collision with root package name */
        private final String f43722a;
        @SerializedName("file_name")

        /* renamed from: b  reason: collision with root package name */
        private final String f43723b;

        public final String a() {
            return this.f43723b;
        }

        public final String b() {
            return this.f43722a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        @SerializedName("background_color")

        /* renamed from: a  reason: collision with root package name */
        private final RGBAColorResponse f43724a;
        @SerializedName("padding")

        /* renamed from: b  reason: collision with root package name */
        private final c f43725b;
        @SerializedName("items_spacing")

        /* renamed from: c  reason: collision with root package name */
        private final int f43726c;
        @SerializedName("items")

        /* renamed from: d  reason: collision with root package name */
        private final List<g> f43727d;

        public final RGBAColorResponse a() {
            return this.f43724a;
        }

        public final List<g> b() {
            return this.f43727d;
        }

        public final int c() {
            return this.f43726c;
        }

        public final c d() {
            return this.f43725b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return Intrinsics.a(this.f43724a, bVar.f43724a) && Intrinsics.a(this.f43725b, bVar.f43725b) && this.f43726c == bVar.f43726c && Intrinsics.a(this.f43727d, bVar.f43727d);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f43724a.hashCode() * 31) + this.f43725b.hashCode()) * 31) + this.f43726c) * 31) + this.f43727d.hashCode();
        }

        public String toString() {
            RGBAColorResponse rGBAColorResponse = this.f43724a;
            c cVar = this.f43725b;
            int i8 = this.f43726c;
            List<g> list = this.f43727d;
            return "StoryContent(backgroundColor=" + rGBAColorResponse + ", padding=" + cVar + ", itemsSpacing=" + i8 + ", items=" + list + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class c {
        @SerializedName("top")

        /* renamed from: a  reason: collision with root package name */
        private final int f43728a;
        @SerializedName("left")

        /* renamed from: b  reason: collision with root package name */
        private final int f43729b;
        @SerializedName("bottom")

        /* renamed from: c  reason: collision with root package name */
        private final int f43730c;
        @SerializedName("right")

        /* renamed from: d  reason: collision with root package name */
        private final int f43731d;

        public final int a() {
            return this.f43730c;
        }

        public final int b() {
            return this.f43729b;
        }

        public final int c() {
            return this.f43731d;
        }

        public final int d() {
            return this.f43728a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.f43728a == cVar.f43728a && this.f43729b == cVar.f43729b && this.f43730c == cVar.f43730c && this.f43731d == cVar.f43731d;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f43728a * 31) + this.f43729b) * 31) + this.f43730c) * 31) + this.f43731d;
        }

        public String toString() {
            int i8 = this.f43728a;
            int i9 = this.f43729b;
            int i10 = this.f43730c;
            int i11 = this.f43731d;
            return "StoryContentPadding(top=" + i8 + ", left=" + i9 + ", bottom=" + i10 + ", right=" + i11 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class d {
        @SerializedName("width")

        /* renamed from: a  reason: collision with root package name */
        private final int f43732a;
        @SerializedName("height")

        /* renamed from: b  reason: collision with root package name */
        private final int f43733b;

        public final int a() {
            return this.f43733b;
        }

        public final int b() {
            return this.f43732a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof d) {
                d dVar = (d) obj;
                return this.f43732a == dVar.f43732a && this.f43733b == dVar.f43733b;
            }
            return false;
        }

        public int hashCode() {
            return (this.f43732a * 31) + this.f43733b;
        }

        public String toString() {
            int i8 = this.f43732a;
            int i9 = this.f43733b;
            return "StoryDimensionFixedParams(width=" + i8 + ", height=" + i9 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class e {

        /* renamed from: d  reason: collision with root package name */
        public static final a f43734d = new a(null);
        @SerializedName("type")

        /* renamed from: a  reason: collision with root package name */
        private final String f43735a;
        @SerializedName(ImagesContract.URL)

        /* renamed from: b  reason: collision with root package name */
        private final String f43736b;
        @SerializedName("dimensions")

        /* renamed from: c  reason: collision with root package name */
        private final h f43737c;

        /* loaded from: classes5.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final h a() {
            return this.f43737c;
        }

        public final String b() {
            return this.f43735a;
        }

        public final String c() {
            return this.f43736b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof e) {
                e eVar = (e) obj;
                return Intrinsics.a(this.f43735a, eVar.f43735a) && Intrinsics.a(this.f43736b, eVar.f43736b) && Intrinsics.a(this.f43737c, eVar.f43737c);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((this.f43735a.hashCode() * 31) + this.f43736b.hashCode()) * 31;
            h hVar = this.f43737c;
            return hashCode + (hVar == null ? 0 : hVar.hashCode());
        }

        public String toString() {
            String str = this.f43735a;
            String str2 = this.f43736b;
            h hVar = this.f43737c;
            return "StorySlideAsset(type=" + str + ", url=" + str2 + ", dimensions=" + hVar + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class f {

        /* renamed from: f  reason: collision with root package name */
        public static final a f43738f = new a(null);
        @SerializedName("text")

        /* renamed from: a  reason: collision with root package name */
        private final String f43739a;
        @SerializedName("link")

        /* renamed from: b  reason: collision with root package name */
        private final String f43740b;
        @SerializedName("share_params")

        /* renamed from: c  reason: collision with root package name */
        private final a f43741c;
        @SerializedName("type")

        /* renamed from: d  reason: collision with root package name */
        private final String f43742d;
        @SerializedName("ui_type")

        /* renamed from: e  reason: collision with root package name */
        private final String f43743e;

        /* loaded from: classes5.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final String a() {
            return this.f43740b;
        }

        public final String b() {
            return this.f43739a;
        }

        public final a c() {
            return this.f43741c;
        }

        public final String d() {
            return this.f43742d;
        }

        public final String e() {
            return this.f43743e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof f) {
                f fVar = (f) obj;
                return Intrinsics.a(this.f43739a, fVar.f43739a) && Intrinsics.a(this.f43740b, fVar.f43740b) && Intrinsics.a(this.f43741c, fVar.f43741c) && Intrinsics.a(this.f43742d, fVar.f43742d) && Intrinsics.a(this.f43743e, fVar.f43743e);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f43739a.hashCode() * 31;
            String str = this.f43740b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            a aVar = this.f43741c;
            int hashCode3 = (((hashCode2 + (aVar == null ? 0 : aVar.hashCode())) * 31) + this.f43742d.hashCode()) * 31;
            String str2 = this.f43743e;
            return hashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            String str = this.f43739a;
            String str2 = this.f43740b;
            a aVar = this.f43741c;
            String str3 = this.f43742d;
            String str4 = this.f43743e;
            return "StorySlideButtonContent(buttonText=" + str + ", buttonLink=" + str2 + ", shareParams=" + aVar + ", type=" + str3 + ", uiType=" + str4 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class g {

        /* renamed from: f  reason: collision with root package name */
        public static final a f43744f = new a(null);
        @SerializedName("type")

        /* renamed from: a  reason: collision with root package name */
        private final String f43745a;
        @SerializedName("text")

        /* renamed from: b  reason: collision with root package name */
        private final String f43746b;
        @SerializedName("asset")

        /* renamed from: c  reason: collision with root package name */
        private final e f43747c;
        @SerializedName("align")

        /* renamed from: d  reason: collision with root package name */
        private final String f43748d;
        @SerializedName("paragraph_icon_url")

        /* renamed from: e  reason: collision with root package name */
        private final String f43749e;

        /* loaded from: classes5.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final String a() {
            return this.f43748d;
        }

        public final e b() {
            return this.f43747c;
        }

        public final String c() {
            return this.f43749e;
        }

        public final String d() {
            return this.f43746b;
        }

        public final String e() {
            return this.f43745a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof g) {
                g gVar = (g) obj;
                return Intrinsics.a(this.f43745a, gVar.f43745a) && Intrinsics.a(this.f43746b, gVar.f43746b) && Intrinsics.a(this.f43747c, gVar.f43747c) && Intrinsics.a(this.f43748d, gVar.f43748d) && Intrinsics.a(this.f43749e, gVar.f43749e);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f43745a.hashCode() * 31;
            String str = this.f43746b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            e eVar = this.f43747c;
            int hashCode3 = (hashCode2 + (eVar == null ? 0 : eVar.hashCode())) * 31;
            String str2 = this.f43748d;
            int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f43749e;
            return hashCode4 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            String str = this.f43745a;
            String str2 = this.f43746b;
            e eVar = this.f43747c;
            String str3 = this.f43748d;
            String str4 = this.f43749e;
            return "StorySlideContentItem(type=" + str + ", text=" + str2 + ", asset=" + eVar + ", align=" + str3 + ", iconUrl=" + str4 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class h {

        /* renamed from: c  reason: collision with root package name */
        public static final a f43750c = new a(null);
        @SerializedName("type")

        /* renamed from: a  reason: collision with root package name */
        private final String f43751a;
        @SerializedName("fixed_params")

        /* renamed from: b  reason: collision with root package name */
        private final d f43752b;

        /* loaded from: classes5.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final d a() {
            return this.f43752b;
        }

        public final String b() {
            return this.f43751a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof h) {
                h hVar = (h) obj;
                return Intrinsics.a(this.f43751a, hVar.f43751a) && Intrinsics.a(this.f43752b, hVar.f43752b);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f43751a.hashCode() * 31;
            d dVar = this.f43752b;
            return hashCode + (dVar == null ? 0 : dVar.hashCode());
        }

        public String toString() {
            String str = this.f43751a;
            d dVar = this.f43752b;
            return "StorySlideDimensions(type=" + str + ", fixedParams=" + dVar + ")";
        }
    }

    public final Long a() {
        return this.f43719k;
    }

    public final RGBAColorResponse b() {
        return this.f43711c;
    }

    public final b c() {
        return this.f43721m;
    }

    public final String d() {
        return this.f43715g;
    }

    public final String e() {
        return this.f43716h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof jk) {
            jk jkVar = (jk) obj;
            return Intrinsics.a(this.f43709a, jkVar.f43709a) && Intrinsics.a(this.f43710b, jkVar.f43710b) && Intrinsics.a(this.f43711c, jkVar.f43711c) && Intrinsics.a(this.f43712d, jkVar.f43712d) && Intrinsics.a(this.f43713e, jkVar.f43713e) && Intrinsics.a(this.f43714f, jkVar.f43714f) && Intrinsics.a(this.f43715g, jkVar.f43715g) && Intrinsics.a(this.f43716h, jkVar.f43716h) && Intrinsics.a(this.f43717i, jkVar.f43717i) && Intrinsics.a(this.f43718j, jkVar.f43718j) && Intrinsics.a(this.f43719k, jkVar.f43719k) && Intrinsics.a(this.f43720l, jkVar.f43720l) && Intrinsics.a(this.f43721m, jkVar.f43721m);
        }
        return false;
    }

    public final String f() {
        return this.f43720l;
    }

    public final String g() {
        return this.f43709a;
    }

    public final String h() {
        return this.f43710b;
    }

    public int hashCode() {
        int hashCode = ((((this.f43709a.hashCode() * 31) + this.f43710b.hashCode()) * 31) + this.f43711c.hashCode()) * 31;
        RGBAColorResponse rGBAColorResponse = this.f43712d;
        int hashCode2 = (hashCode + (rGBAColorResponse == null ? 0 : rGBAColorResponse.hashCode())) * 31;
        String str = this.f43713e;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f43714f;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f43715g;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f43716h;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        e eVar = this.f43717i;
        int hashCode7 = (hashCode6 + (eVar == null ? 0 : eVar.hashCode())) * 31;
        f fVar = this.f43718j;
        int hashCode8 = (hashCode7 + (fVar == null ? 0 : fVar.hashCode())) * 31;
        Long l8 = this.f43719k;
        int hashCode9 = (hashCode8 + (l8 == null ? 0 : l8.hashCode())) * 31;
        String str5 = this.f43720l;
        int hashCode10 = (hashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        b bVar = this.f43721m;
        return hashCode10 + (bVar != null ? bVar.hashCode() : 0);
    }

    public final e i() {
        return this.f43717i;
    }

    public final f j() {
        return this.f43718j;
    }

    public final RGBAColorResponse k() {
        return this.f43712d;
    }

    public final String l() {
        return this.f43713e;
    }

    public final String m() {
        return this.f43714f;
    }

    public String toString() {
        String str = this.f43709a;
        String str2 = this.f43710b;
        RGBAColorResponse rGBAColorResponse = this.f43711c;
        RGBAColorResponse rGBAColorResponse2 = this.f43712d;
        String str3 = this.f43713e;
        String str4 = this.f43714f;
        String str5 = this.f43715g;
        String str6 = this.f43716h;
        e eVar = this.f43717i;
        f fVar = this.f43718j;
        Long l8 = this.f43719k;
        String str7 = this.f43720l;
        b bVar = this.f43721m;
        return "StorySlideResponse(id=" + str + ", layout=" + str2 + ", backgroundColor=" + rGBAColorResponse + ", textHighlightColor=" + rGBAColorResponse2 + ", title=" + str3 + ", titleHtml=" + str4 + ", description=" + str5 + ", descriptionHtml=" + str6 + ", slideAsset=" + eVar + ", slideButton=" + fVar + ", autoSwitchTimeMs=" + l8 + ", footerHtml=" + str7 + ", content=" + bVar + ")";
    }
}
