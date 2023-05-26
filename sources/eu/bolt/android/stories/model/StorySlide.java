package eu.bolt.android.stories.model;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: StorySlide.kt */
/* loaded from: classes5.dex */
public final class StorySlide {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final String f37568a;
    @SerializedName("layout")

    /* renamed from: b  reason: collision with root package name */
    private final String f37569b;
    @SerializedName("background_color")

    /* renamed from: c  reason: collision with root package name */
    private final String f37570c;
    @SerializedName("text_highlight_color")

    /* renamed from: d  reason: collision with root package name */
    private final String f37571d;
    @SerializedName("title")

    /* renamed from: e  reason: collision with root package name */
    private final String f37572e;
    @SerializedName("description")

    /* renamed from: f  reason: collision with root package name */
    private final String f37573f;
    @SerializedName("asset")

    /* renamed from: g  reason: collision with root package name */
    private final StorySlideAsset f37574g;
    @SerializedName("button")

    /* renamed from: h  reason: collision with root package name */
    private final StorySlideButtonContent f37575h;
    @SerializedName("auto_switch_time_ms")

    /* renamed from: i  reason: collision with root package name */
    private final Long f37576i;
    @SerializedName("footer_html")

    /* renamed from: j  reason: collision with root package name */
    private final String f37577j;
    @SerializedName("content")

    /* renamed from: k  reason: collision with root package name */
    private final StoryContent f37578k;
    @SerializedName("title_html")

    /* renamed from: l  reason: collision with root package name */
    private final String f37579l;
    @SerializedName("description_html")

    /* renamed from: m  reason: collision with root package name */
    private final String f37580m;

    /* compiled from: StorySlide.kt */
    /* loaded from: classes5.dex */
    public static final class ShareParams {
        @SerializedName("text")

        /* renamed from: a  reason: collision with root package name */
        private final String f37581a;
        @SerializedName("file_name")

        /* renamed from: b  reason: collision with root package name */
        private final String f37582b;

        public final String a() {
            return this.f37582b;
        }

        public final String b() {
            return this.f37581a;
        }
    }

    /* compiled from: StorySlide.kt */
    /* loaded from: classes5.dex */
    public static final class StoryContent {
        @SerializedName("background_color")

        /* renamed from: a  reason: collision with root package name */
        private final String f37583a;
        @SerializedName("padding")

        /* renamed from: b  reason: collision with root package name */
        private final StoryContentPadding f37584b;
        @SerializedName("items_spacing")

        /* renamed from: c  reason: collision with root package name */
        private final int f37585c;
        @SerializedName("items")

        /* renamed from: d  reason: collision with root package name */
        private final List<StorySlideContentItem> f37586d;

        public final String a() {
            return this.f37583a;
        }

        public final List<StorySlideContentItem> b() {
            return this.f37586d;
        }

        public final int c() {
            return this.f37585c;
        }

        public final StoryContentPadding d() {
            return this.f37584b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StoryContent) {
                StoryContent storyContent = (StoryContent) obj;
                return Intrinsics.a(this.f37583a, storyContent.f37583a) && Intrinsics.a(this.f37584b, storyContent.f37584b) && this.f37585c == storyContent.f37585c && Intrinsics.a(this.f37586d, storyContent.f37586d);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f37583a.hashCode() * 31) + this.f37584b.hashCode()) * 31) + this.f37585c) * 31) + this.f37586d.hashCode();
        }

        public String toString() {
            String str = this.f37583a;
            StoryContentPadding storyContentPadding = this.f37584b;
            int i8 = this.f37585c;
            List<StorySlideContentItem> list = this.f37586d;
            return "StoryContent(backgroundColor=" + str + ", padding=" + storyContentPadding + ", itemsSpacing=" + i8 + ", items=" + list + ")";
        }
    }

    /* compiled from: StorySlide.kt */
    /* loaded from: classes5.dex */
    public static final class StoryContentPadding {
        @SerializedName("top")

        /* renamed from: a  reason: collision with root package name */
        private final int f37587a;
        @SerializedName("left")

        /* renamed from: b  reason: collision with root package name */
        private final int f37588b;
        @SerializedName("bottom")

        /* renamed from: c  reason: collision with root package name */
        private final int f37589c;
        @SerializedName("right")

        /* renamed from: d  reason: collision with root package name */
        private final int f37590d;

        public final int a() {
            return this.f37589c;
        }

        public final int b() {
            return this.f37588b;
        }

        public final int c() {
            return this.f37590d;
        }

        public final int d() {
            return this.f37587a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StoryContentPadding) {
                StoryContentPadding storyContentPadding = (StoryContentPadding) obj;
                return this.f37587a == storyContentPadding.f37587a && this.f37588b == storyContentPadding.f37588b && this.f37589c == storyContentPadding.f37589c && this.f37590d == storyContentPadding.f37590d;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f37587a * 31) + this.f37588b) * 31) + this.f37589c) * 31) + this.f37590d;
        }

        public String toString() {
            int i8 = this.f37587a;
            int i9 = this.f37588b;
            int i10 = this.f37589c;
            int i11 = this.f37590d;
            return "StoryContentPadding(top=" + i8 + ", left=" + i9 + ", bottom=" + i10 + ", right=" + i11 + ")";
        }
    }

    /* compiled from: StorySlide.kt */
    /* loaded from: classes5.dex */
    public static final class StoryDimensionFixedParams {
        @SerializedName("width")

        /* renamed from: a  reason: collision with root package name */
        private final int f37591a;
        @SerializedName("height")

        /* renamed from: b  reason: collision with root package name */
        private final int f37592b;

        public final int a() {
            return this.f37592b;
        }

        public final int b() {
            return this.f37591a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StoryDimensionFixedParams) {
                StoryDimensionFixedParams storyDimensionFixedParams = (StoryDimensionFixedParams) obj;
                return this.f37591a == storyDimensionFixedParams.f37591a && this.f37592b == storyDimensionFixedParams.f37592b;
            }
            return false;
        }

        public int hashCode() {
            return (this.f37591a * 31) + this.f37592b;
        }

        public String toString() {
            int i8 = this.f37591a;
            int i9 = this.f37592b;
            return "StoryDimensionFixedParams(width=" + i8 + ", height=" + i9 + ")";
        }
    }

    /* compiled from: StorySlide.kt */
    /* loaded from: classes5.dex */
    public static final class StorySlideAsset {

        /* renamed from: d  reason: collision with root package name */
        public static final Companion f37593d = new Companion(null);
        @SerializedName("type")

        /* renamed from: a  reason: collision with root package name */
        private final String f37594a;
        @SerializedName(ImagesContract.URL)

        /* renamed from: b  reason: collision with root package name */
        private final String f37595b;
        @SerializedName("dimensions")

        /* renamed from: c  reason: collision with root package name */
        private final StorySlideDimensions f37596c;

        /* compiled from: StorySlide.kt */
        /* loaded from: classes5.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final StorySlideDimensions a() {
            return this.f37596c;
        }

        public final String b() {
            return this.f37594a;
        }

        public final String c() {
            return this.f37595b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StorySlideAsset) {
                StorySlideAsset storySlideAsset = (StorySlideAsset) obj;
                return Intrinsics.a(this.f37594a, storySlideAsset.f37594a) && Intrinsics.a(this.f37595b, storySlideAsset.f37595b) && Intrinsics.a(this.f37596c, storySlideAsset.f37596c);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((this.f37594a.hashCode() * 31) + this.f37595b.hashCode()) * 31;
            StorySlideDimensions storySlideDimensions = this.f37596c;
            return hashCode + (storySlideDimensions == null ? 0 : storySlideDimensions.hashCode());
        }

        public String toString() {
            String str = this.f37594a;
            String str2 = this.f37595b;
            StorySlideDimensions storySlideDimensions = this.f37596c;
            return "StorySlideAsset(type=" + str + ", url=" + str2 + ", dimensions=" + storySlideDimensions + ")";
        }
    }

    /* compiled from: StorySlide.kt */
    /* loaded from: classes5.dex */
    public static final class StorySlideButtonContent {

        /* renamed from: f  reason: collision with root package name */
        public static final Companion f37597f = new Companion(null);
        @SerializedName("text")

        /* renamed from: a  reason: collision with root package name */
        private final String f37598a;
        @SerializedName("link")

        /* renamed from: b  reason: collision with root package name */
        private final String f37599b;
        @SerializedName("share_params")

        /* renamed from: c  reason: collision with root package name */
        private final ShareParams f37600c;
        @SerializedName("type")

        /* renamed from: d  reason: collision with root package name */
        private final String f37601d;
        @SerializedName("ui_type")

        /* renamed from: e  reason: collision with root package name */
        private final String f37602e;

        /* compiled from: StorySlide.kt */
        /* loaded from: classes5.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final String a() {
            return this.f37599b;
        }

        public final String b() {
            return this.f37598a;
        }

        public final ShareParams c() {
            return this.f37600c;
        }

        public final String d() {
            return this.f37601d;
        }

        public final String e() {
            return this.f37602e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StorySlideButtonContent) {
                StorySlideButtonContent storySlideButtonContent = (StorySlideButtonContent) obj;
                return Intrinsics.a(this.f37598a, storySlideButtonContent.f37598a) && Intrinsics.a(this.f37599b, storySlideButtonContent.f37599b) && Intrinsics.a(this.f37600c, storySlideButtonContent.f37600c) && Intrinsics.a(this.f37601d, storySlideButtonContent.f37601d) && Intrinsics.a(this.f37602e, storySlideButtonContent.f37602e);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f37598a.hashCode() * 31;
            String str = this.f37599b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            ShareParams shareParams = this.f37600c;
            int hashCode3 = (((hashCode2 + (shareParams == null ? 0 : shareParams.hashCode())) * 31) + this.f37601d.hashCode()) * 31;
            String str2 = this.f37602e;
            return hashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            String str = this.f37598a;
            String str2 = this.f37599b;
            ShareParams shareParams = this.f37600c;
            String str3 = this.f37601d;
            String str4 = this.f37602e;
            return "StorySlideButtonContent(buttonText=" + str + ", buttonLink=" + str2 + ", shareParams=" + shareParams + ", type=" + str3 + ", uiType=" + str4 + ")";
        }
    }

    /* compiled from: StorySlide.kt */
    /* loaded from: classes5.dex */
    public static final class StorySlideContentItem {

        /* renamed from: f  reason: collision with root package name */
        public static final Companion f37603f = new Companion(null);
        @SerializedName("type")

        /* renamed from: a  reason: collision with root package name */
        private final String f37604a;
        @SerializedName("text")

        /* renamed from: b  reason: collision with root package name */
        private final String f37605b;
        @SerializedName("asset")

        /* renamed from: c  reason: collision with root package name */
        private final StorySlideAsset f37606c;
        @SerializedName("align")

        /* renamed from: d  reason: collision with root package name */
        private final String f37607d;
        @SerializedName("paragraph_icon_url")

        /* renamed from: e  reason: collision with root package name */
        private final String f37608e;

        /* compiled from: StorySlide.kt */
        /* loaded from: classes5.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final String a() {
            return this.f37607d;
        }

        public final StorySlideAsset b() {
            return this.f37606c;
        }

        public final String c() {
            return this.f37608e;
        }

        public final String d() {
            return this.f37605b;
        }

        public final String e() {
            return this.f37604a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StorySlideContentItem) {
                StorySlideContentItem storySlideContentItem = (StorySlideContentItem) obj;
                return Intrinsics.a(this.f37604a, storySlideContentItem.f37604a) && Intrinsics.a(this.f37605b, storySlideContentItem.f37605b) && Intrinsics.a(this.f37606c, storySlideContentItem.f37606c) && Intrinsics.a(this.f37607d, storySlideContentItem.f37607d) && Intrinsics.a(this.f37608e, storySlideContentItem.f37608e);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f37604a.hashCode() * 31;
            String str = this.f37605b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            StorySlideAsset storySlideAsset = this.f37606c;
            int hashCode3 = (hashCode2 + (storySlideAsset == null ? 0 : storySlideAsset.hashCode())) * 31;
            String str2 = this.f37607d;
            int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f37608e;
            return hashCode4 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            String str = this.f37604a;
            String str2 = this.f37605b;
            StorySlideAsset storySlideAsset = this.f37606c;
            String str3 = this.f37607d;
            String str4 = this.f37608e;
            return "StorySlideContentItem(type=" + str + ", text=" + str2 + ", asset=" + storySlideAsset + ", align=" + str3 + ", iconUrl=" + str4 + ")";
        }
    }

    /* compiled from: StorySlide.kt */
    /* loaded from: classes5.dex */
    public static final class StorySlideDimensions {

        /* renamed from: c  reason: collision with root package name */
        public static final Companion f37609c = new Companion(null);
        @SerializedName("type")

        /* renamed from: a  reason: collision with root package name */
        private final String f37610a;
        @SerializedName("fixed_params")

        /* renamed from: b  reason: collision with root package name */
        private final StoryDimensionFixedParams f37611b;

        /* compiled from: StorySlide.kt */
        /* loaded from: classes5.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final StoryDimensionFixedParams a() {
            return this.f37611b;
        }

        public final String b() {
            return this.f37610a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StorySlideDimensions) {
                StorySlideDimensions storySlideDimensions = (StorySlideDimensions) obj;
                return Intrinsics.a(this.f37610a, storySlideDimensions.f37610a) && Intrinsics.a(this.f37611b, storySlideDimensions.f37611b);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f37610a.hashCode() * 31;
            StoryDimensionFixedParams storyDimensionFixedParams = this.f37611b;
            return hashCode + (storyDimensionFixedParams == null ? 0 : storyDimensionFixedParams.hashCode());
        }

        public String toString() {
            String str = this.f37610a;
            StoryDimensionFixedParams storyDimensionFixedParams = this.f37611b;
            return "StorySlideDimensions(type=" + str + ", fixedParams=" + storyDimensionFixedParams + ")";
        }
    }

    public final Long a() {
        return this.f37576i;
    }

    public final String b() {
        return this.f37570c;
    }

    public final StoryContent c() {
        return this.f37578k;
    }

    public final String d() {
        return this.f37573f;
    }

    public final String e() {
        return this.f37580m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StorySlide) {
            StorySlide storySlide = (StorySlide) obj;
            return Intrinsics.a(this.f37568a, storySlide.f37568a) && Intrinsics.a(this.f37569b, storySlide.f37569b) && Intrinsics.a(this.f37570c, storySlide.f37570c) && Intrinsics.a(this.f37571d, storySlide.f37571d) && Intrinsics.a(this.f37572e, storySlide.f37572e) && Intrinsics.a(this.f37573f, storySlide.f37573f) && Intrinsics.a(this.f37574g, storySlide.f37574g) && Intrinsics.a(this.f37575h, storySlide.f37575h) && Intrinsics.a(this.f37576i, storySlide.f37576i) && Intrinsics.a(this.f37577j, storySlide.f37577j) && Intrinsics.a(this.f37578k, storySlide.f37578k) && Intrinsics.a(this.f37579l, storySlide.f37579l) && Intrinsics.a(this.f37580m, storySlide.f37580m);
        }
        return false;
    }

    public final String f() {
        return this.f37577j;
    }

    public final String g() {
        return this.f37568a;
    }

    public final String h() {
        return this.f37569b;
    }

    public int hashCode() {
        int hashCode = ((((this.f37568a.hashCode() * 31) + this.f37569b.hashCode()) * 31) + this.f37570c.hashCode()) * 31;
        String str = this.f37571d;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f37572e;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f37573f;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        StorySlideAsset storySlideAsset = this.f37574g;
        int hashCode5 = (hashCode4 + (storySlideAsset == null ? 0 : storySlideAsset.hashCode())) * 31;
        StorySlideButtonContent storySlideButtonContent = this.f37575h;
        int hashCode6 = (hashCode5 + (storySlideButtonContent == null ? 0 : storySlideButtonContent.hashCode())) * 31;
        Long l8 = this.f37576i;
        int hashCode7 = (hashCode6 + (l8 == null ? 0 : l8.hashCode())) * 31;
        String str4 = this.f37577j;
        int hashCode8 = (hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        StoryContent storyContent = this.f37578k;
        int hashCode9 = (hashCode8 + (storyContent == null ? 0 : storyContent.hashCode())) * 31;
        String str5 = this.f37579l;
        int hashCode10 = (hashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f37580m;
        return hashCode10 + (str6 != null ? str6.hashCode() : 0);
    }

    public final StorySlideAsset i() {
        return this.f37574g;
    }

    public final StorySlideButtonContent j() {
        return this.f37575h;
    }

    public final String k() {
        return this.f37571d;
    }

    public final String l() {
        return this.f37572e;
    }

    public final String m() {
        return this.f37579l;
    }

    public String toString() {
        String str = this.f37568a;
        String str2 = this.f37569b;
        String str3 = this.f37570c;
        String str4 = this.f37571d;
        String str5 = this.f37572e;
        String str6 = this.f37573f;
        StorySlideAsset storySlideAsset = this.f37574g;
        StorySlideButtonContent storySlideButtonContent = this.f37575h;
        Long l8 = this.f37576i;
        String str7 = this.f37577j;
        StoryContent storyContent = this.f37578k;
        String str8 = this.f37579l;
        String str9 = this.f37580m;
        return "StorySlide(id=" + str + ", layout=" + str2 + ", backgroundColor=" + str3 + ", textHighlightColor=" + str4 + ", title=" + str5 + ", description=" + str6 + ", slideAsset=" + storySlideAsset + ", slideButton=" + storySlideButtonContent + ", autoSwitchTimeMs=" + l8 + ", footerHtml=" + str7 + ", content=" + storyContent + ", titleHtml=" + str8 + ", descriptionHtml=" + str9 + ")";
    }
}
