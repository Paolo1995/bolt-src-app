package eu.bolt.verification.sdk.internal;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import eu.bolt.verification.core.network.adapter.VerificationLayoutElementContentAdapter;
import eu.bolt.verification.core.network.adapter.VerificationMediaPreviewOverlayAdapter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

@JsonAdapter(VerificationLayoutElementContentAdapter.class)
/* loaded from: classes5.dex */
public abstract class ro {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final String f44871a = "";

    /* loaded from: classes5.dex */
    public static final class a extends ro {
        @SerializedName("content")

        /* renamed from: b  reason: collision with root package name */
        private final C0086a f44872b;

        /* renamed from: eu.bolt.verification.sdk.internal.ro$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0086a {
            @SerializedName("text")

            /* renamed from: a  reason: collision with root package name */
            private final String f44873a;
            @SerializedName("ui_type")

            /* renamed from: b  reason: collision with root package name */
            private final String f44874b;
            @SerializedName("actions")

            /* renamed from: c  reason: collision with root package name */
            private final List<sm> f44875c;

            public final List<sm> a() {
                return this.f44875c;
            }

            public final String b() {
                return this.f44873a;
            }

            public final String c() {
                return this.f44874b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof C0086a) {
                    C0086a c0086a = (C0086a) obj;
                    return Intrinsics.a(this.f44873a, c0086a.f44873a) && Intrinsics.a(this.f44874b, c0086a.f44874b) && Intrinsics.a(this.f44875c, c0086a.f44875c);
                }
                return false;
            }

            public int hashCode() {
                return (((this.f44873a.hashCode() * 31) + this.f44874b.hashCode()) * 31) + this.f44875c.hashCode();
            }

            public String toString() {
                String str = this.f44873a;
                String str2 = this.f44874b;
                List<sm> list = this.f44875c;
                return "Content(text=" + str + ", uiType=" + str2 + ", actions=" + list + ")";
            }
        }

        public final C0086a b() {
            return this.f44872b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.a(this.f44872b, ((a) obj).f44872b);
        }

        public int hashCode() {
            return this.f44872b.hashCode();
        }

        public String toString() {
            C0086a c0086a = this.f44872b;
            return "Button(content=" + c0086a + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends ro {
        @SerializedName("content")

        /* renamed from: b  reason: collision with root package name */
        private final a f44876b;

        /* loaded from: classes5.dex */
        public static final class a {
            @SerializedName("multiselection")

            /* renamed from: a  reason: collision with root package name */
            private final boolean f44877a;
            @SerializedName("options")

            /* renamed from: b  reason: collision with root package name */
            private final List<C0087b> f44878b;

            public final boolean a() {
                return this.f44877a;
            }

            public final List<C0087b> b() {
                return this.f44878b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return this.f44877a == aVar.f44877a && Intrinsics.a(this.f44878b, aVar.f44878b);
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            public int hashCode() {
                boolean z7 = this.f44877a;
                ?? r02 = z7;
                if (z7) {
                    r02 = 1;
                }
                return (r02 * 31) + this.f44878b.hashCode();
            }

            public String toString() {
                boolean z7 = this.f44877a;
                List<C0087b> list = this.f44878b;
                return "Content(multiSelection=" + z7 + ", options=" + list + ")";
            }
        }

        /* renamed from: eu.bolt.verification.sdk.internal.ro$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0087b {
            @SerializedName(Name.MARK)

            /* renamed from: a  reason: collision with root package name */
            private final String f44879a;
            @SerializedName("text")

            /* renamed from: b  reason: collision with root package name */
            private final String f44880b;
            @SerializedName("subtext")

            /* renamed from: c  reason: collision with root package name */
            private final String f44881c;
            @SerializedName(ImagesContract.URL)

            /* renamed from: d  reason: collision with root package name */
            private final String f44882d;

            public final String a() {
                return this.f44882d;
            }

            public final String b() {
                return this.f44879a;
            }

            public final String c() {
                return this.f44881c;
            }

            public final String d() {
                return this.f44880b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof C0087b) {
                    C0087b c0087b = (C0087b) obj;
                    return Intrinsics.a(this.f44879a, c0087b.f44879a) && Intrinsics.a(this.f44880b, c0087b.f44880b) && Intrinsics.a(this.f44881c, c0087b.f44881c) && Intrinsics.a(this.f44882d, c0087b.f44882d);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = ((this.f44879a.hashCode() * 31) + this.f44880b.hashCode()) * 31;
                String str = this.f44881c;
                return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f44882d.hashCode();
            }

            public String toString() {
                String str = this.f44879a;
                String str2 = this.f44880b;
                String str3 = this.f44881c;
                String str4 = this.f44882d;
                return "Option(id=" + str + ", text=" + str2 + ", subtext=" + str3 + ", iconUrl=" + str4 + ")";
            }
        }

        public final a b() {
            return this.f44876b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.a(this.f44876b, ((b) obj).f44876b);
        }

        public int hashCode() {
            return this.f44876b.hashCode();
        }

        public String toString() {
            a aVar = this.f44876b;
            return "CheckBoxGroup(content=" + aVar + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends ro {
        @SerializedName("content")

        /* renamed from: b  reason: collision with root package name */
        private final a f44883b;

        /* loaded from: classes5.dex */
        public static final class a {
            @SerializedName("default_country_id")

            /* renamed from: a  reason: collision with root package name */
            private final String f44884a;
            @SerializedName("available_countries")

            /* renamed from: b  reason: collision with root package name */
            private final List<b> f44885b;

            public final List<b> a() {
                return this.f44885b;
            }

            public final String b() {
                return this.f44884a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return Intrinsics.a(this.f44884a, aVar.f44884a) && Intrinsics.a(this.f44885b, aVar.f44885b);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = this.f44884a.hashCode() * 31;
                List<b> list = this.f44885b;
                return hashCode + (list == null ? 0 : list.hashCode());
            }

            public String toString() {
                String str = this.f44884a;
                List<b> list = this.f44885b;
                return "Content(defaultCountryId=" + str + ", countries=" + list + ")";
            }
        }

        /* loaded from: classes5.dex */
        public static final class b {
            @SerializedName(Name.MARK)

            /* renamed from: a  reason: collision with root package name */
            private final String f44886a;
            @SerializedName("name")

            /* renamed from: b  reason: collision with root package name */
            private final String f44887b;
            @SerializedName(ImagesContract.URL)

            /* renamed from: c  reason: collision with root package name */
            private final String f44888c;

            public final String a() {
                return this.f44886a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    return Intrinsics.a(this.f44886a, bVar.f44886a) && Intrinsics.a(this.f44887b, bVar.f44887b) && Intrinsics.a(this.f44888c, bVar.f44888c);
                }
                return false;
            }

            public int hashCode() {
                return (((this.f44886a.hashCode() * 31) + this.f44887b.hashCode()) * 31) + this.f44888c.hashCode();
            }

            public String toString() {
                String str = this.f44886a;
                String str2 = this.f44887b;
                String str3 = this.f44888c;
                return "Country(id=" + str + ", name=" + str2 + ", url=" + str3 + ")";
            }
        }

        public final a b() {
            return this.f44883b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Intrinsics.a(this.f44883b, ((c) obj).f44883b);
        }

        public int hashCode() {
            return this.f44883b.hashCode();
        }

        public String toString() {
            a aVar = this.f44883b;
            return "CountrySelector(content=" + aVar + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends ro {
        @SerializedName("content")

        /* renamed from: b  reason: collision with root package name */
        private final a f44889b;

        /* loaded from: classes5.dex */
        public static final class a {
            @SerializedName("hint_date")

            /* renamed from: a  reason: collision with root package name */
            private final Long f44890a;

            public final Long a() {
                return this.f44890a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && Intrinsics.a(this.f44890a, ((a) obj).f44890a);
            }

            public int hashCode() {
                Long l8 = this.f44890a;
                if (l8 == null) {
                    return 0;
                }
                return l8.hashCode();
            }

            public String toString() {
                Long l8 = this.f44890a;
                return "Content(hintDate=" + l8 + ")";
            }
        }

        public final a b() {
            return this.f44889b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && Intrinsics.a(this.f44889b, ((d) obj).f44889b);
        }

        public int hashCode() {
            return this.f44889b.hashCode();
        }

        public String toString() {
            a aVar = this.f44889b;
            return "DatePicker(content=" + aVar + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends ro {
        @SerializedName("content")

        /* renamed from: b  reason: collision with root package name */
        private final a f44891b;

        /* loaded from: classes5.dex */
        public static final class a {
            @SerializedName(ImagesContract.URL)

            /* renamed from: a  reason: collision with root package name */
            private final String f44892a;
            @SerializedName("alignment")

            /* renamed from: b  reason: collision with root package name */
            private final String f44893b;

            public final String a() {
                return this.f44893b;
            }

            public final String b() {
                return this.f44892a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return Intrinsics.a(this.f44892a, aVar.f44892a) && Intrinsics.a(this.f44893b, aVar.f44893b);
                }
                return false;
            }

            public int hashCode() {
                return (this.f44892a.hashCode() * 31) + this.f44893b.hashCode();
            }

            public String toString() {
                String str = this.f44892a;
                String str2 = this.f44893b;
                return "Content(url=" + str + ", alignment=" + str2 + ")";
            }
        }

        public final a b() {
            return this.f44891b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && Intrinsics.a(this.f44891b, ((e) obj).f44891b);
        }

        public int hashCode() {
            return this.f44891b.hashCode();
        }

        public String toString() {
            a aVar = this.f44891b;
            return "Image(content=" + aVar + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class f extends ro {
        @SerializedName("content")

        /* renamed from: b  reason: collision with root package name */
        private final a f44894b;

        /* loaded from: classes5.dex */
        public static final class a {
            @SerializedName("source_step_id")

            /* renamed from: a  reason: collision with root package name */
            private final String f44895a;
            @SerializedName("alignment")

            /* renamed from: b  reason: collision with root package name */
            private final String f44896b;
            @SerializedName("overlay")

            /* renamed from: c  reason: collision with root package name */
            private final b f44897c;

            public final String a() {
                return this.f44896b;
            }

            public final b b() {
                return this.f44897c;
            }

            public final String c() {
                return this.f44895a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return Intrinsics.a(this.f44895a, aVar.f44895a) && Intrinsics.a(this.f44896b, aVar.f44896b) && Intrinsics.a(this.f44897c, aVar.f44897c);
                }
                return false;
            }

            public int hashCode() {
                return (((this.f44895a.hashCode() * 31) + this.f44896b.hashCode()) * 31) + this.f44897c.hashCode();
            }

            public String toString() {
                String str = this.f44895a;
                String str2 = this.f44896b;
                b bVar = this.f44897c;
                return "Content(sourceStepId=" + str + ", alignment=" + str2 + ", overlay=" + bVar + ")";
            }
        }

        @JsonAdapter(VerificationMediaPreviewOverlayAdapter.class)
        /* loaded from: classes5.dex */
        public static abstract class b {

            /* loaded from: classes5.dex */
            public static final class a extends b {
                @SerializedName("shape_config")

                /* renamed from: a  reason: collision with root package name */
                private final C0088a f44898a;

                /* renamed from: eu.bolt.verification.sdk.internal.ro$f$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes5.dex */
                public static final class C0088a {
                    @SerializedName("ratio_width")

                    /* renamed from: a  reason: collision with root package name */
                    private final int f44899a;
                    @SerializedName("ratio_height")

                    /* renamed from: b  reason: collision with root package name */
                    private final int f44900b;

                    public final int a() {
                        return this.f44900b;
                    }

                    public final int b() {
                        return this.f44899a;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof C0088a) {
                            C0088a c0088a = (C0088a) obj;
                            return this.f44899a == c0088a.f44899a && this.f44900b == c0088a.f44900b;
                        }
                        return false;
                    }

                    public int hashCode() {
                        return (this.f44899a * 31) + this.f44900b;
                    }

                    public String toString() {
                        int i8 = this.f44899a;
                        int i9 = this.f44900b;
                        return "ShapeConfig(ratioWidth=" + i8 + ", ratioHeight=" + i9 + ")";
                    }
                }

                public final C0088a a() {
                    return this.f44898a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof a) && Intrinsics.a(this.f44898a, ((a) obj).f44898a);
                }

                public int hashCode() {
                    return this.f44898a.hashCode();
                }

                public String toString() {
                    C0088a c0088a = this.f44898a;
                    return "Oval(shapeConfig=" + c0088a + ")";
                }
            }

            /* renamed from: eu.bolt.verification.sdk.internal.ro$f$b$b  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0089b extends b {
                @SerializedName("shape_config")

                /* renamed from: a  reason: collision with root package name */
                private final a f44901a;

                /* renamed from: eu.bolt.verification.sdk.internal.ro$f$b$b$a */
                /* loaded from: classes5.dex */
                public static final class a {
                    @SerializedName("ratio_width")

                    /* renamed from: a  reason: collision with root package name */
                    private final int f44902a;
                    @SerializedName("ratio_height")

                    /* renamed from: b  reason: collision with root package name */
                    private final int f44903b;

                    public final int a() {
                        return this.f44903b;
                    }

                    public final int b() {
                        return this.f44902a;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj instanceof a) {
                            a aVar = (a) obj;
                            return this.f44902a == aVar.f44902a && this.f44903b == aVar.f44903b;
                        }
                        return false;
                    }

                    public int hashCode() {
                        return (this.f44902a * 31) + this.f44903b;
                    }

                    public String toString() {
                        int i8 = this.f44902a;
                        int i9 = this.f44903b;
                        return "ShapeConfig(ratioWidth=" + i8 + ", ratioHeight=" + i9 + ")";
                    }
                }

                public final a a() {
                    return this.f44901a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof C0089b) && Intrinsics.a(this.f44901a, ((C0089b) obj).f44901a);
                }

                public int hashCode() {
                    return this.f44901a.hashCode();
                }

                public String toString() {
                    a aVar = this.f44901a;
                    return "Rectangle(shapeConfig=" + aVar + ")";
                }
            }

            private b() {
            }
        }

        public final a b() {
            return this.f44894b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof f) && Intrinsics.a(this.f44894b, ((f) obj).f44894b);
        }

        public int hashCode() {
            return this.f44894b.hashCode();
        }

        public String toString() {
            a aVar = this.f44894b;
            return "MediaPreview(content=" + aVar + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class g extends ro {
        @SerializedName("content")

        /* renamed from: b  reason: collision with root package name */
        private final a f44904b;

        /* loaded from: classes5.dex */
        public static final class a {
            @SerializedName("text_html")

            /* renamed from: a  reason: collision with root package name */
            private final String f44905a;
            @SerializedName("icon_url")

            /* renamed from: b  reason: collision with root package name */
            private final String f44906b;
            @SerializedName("text_alignment")

            /* renamed from: c  reason: collision with root package name */
            private final String f44907c;
            @SerializedName("url_intercepts")

            /* renamed from: d  reason: collision with root package name */
            private final List<b> f44908d;
            @SerializedName("distance_between_icon_and_text_dp")

            /* renamed from: e  reason: collision with root package name */
            private final Integer f44909e;

            public final Integer a() {
                return this.f44909e;
            }

            public final String b() {
                return this.f44906b;
            }

            public final String c() {
                return this.f44907c;
            }

            public final String d() {
                return this.f44905a;
            }

            public final List<b> e() {
                return this.f44908d;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return Intrinsics.a(this.f44905a, aVar.f44905a) && Intrinsics.a(this.f44906b, aVar.f44906b) && Intrinsics.a(this.f44907c, aVar.f44907c) && Intrinsics.a(this.f44908d, aVar.f44908d) && Intrinsics.a(this.f44909e, aVar.f44909e);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = this.f44905a.hashCode() * 31;
                String str = this.f44906b;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.f44907c;
                int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                List<b> list = this.f44908d;
                int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
                Integer num = this.f44909e;
                return hashCode4 + (num != null ? num.hashCode() : 0);
            }

            public String toString() {
                String str = this.f44905a;
                String str2 = this.f44906b;
                String str3 = this.f44907c;
                List<b> list = this.f44908d;
                Integer num = this.f44909e;
                return "Content(textHtml=" + str + ", iconUrl=" + str2 + ", textAlignment=" + str3 + ", urlIntercepts=" + list + ", distanceBetweenTextAndIconDp=" + num + ")";
            }
        }

        /* loaded from: classes5.dex */
        public static final class b {
            @SerializedName(ImagesContract.URL)

            /* renamed from: a  reason: collision with root package name */
            private final String f44910a;
            @SerializedName("actions")

            /* renamed from: b  reason: collision with root package name */
            private final List<sm> f44911b;

            public final List<sm> a() {
                return this.f44911b;
            }

            public final String b() {
                return this.f44910a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    return Intrinsics.a(this.f44910a, bVar.f44910a) && Intrinsics.a(this.f44911b, bVar.f44911b);
                }
                return false;
            }

            public int hashCode() {
                return (this.f44910a.hashCode() * 31) + this.f44911b.hashCode();
            }

            public String toString() {
                String str = this.f44910a;
                List<sm> list = this.f44911b;
                return "UrlIntercept(url=" + str + ", actions=" + list + ")";
            }
        }

        public final a b() {
            return this.f44904b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof g) && Intrinsics.a(this.f44904b, ((g) obj).f44904b);
        }

        public int hashCode() {
            return this.f44904b.hashCode();
        }

        public String toString() {
            a aVar = this.f44904b;
            return "Paragraph(content=" + aVar + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class h extends ro {
        @SerializedName("content")

        /* renamed from: b  reason: collision with root package name */
        private final a f44912b;

        /* loaded from: classes5.dex */
        public static final class a {
            @SerializedName("hint")

            /* renamed from: a  reason: collision with root package name */
            private final String f44913a;
            @SerializedName("input_type")

            /* renamed from: b  reason: collision with root package name */
            private final String f44914b;

            public final String a() {
                return this.f44913a;
            }

            public final String b() {
                return this.f44914b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return Intrinsics.a(this.f44913a, aVar.f44913a) && Intrinsics.a(this.f44914b, aVar.f44914b);
                }
                return false;
            }

            public int hashCode() {
                String str = this.f44913a;
                return ((str == null ? 0 : str.hashCode()) * 31) + this.f44914b.hashCode();
            }

            public String toString() {
                String str = this.f44913a;
                String str2 = this.f44914b;
                return "Content(hint=" + str + ", inputType=" + str2 + ")";
            }
        }

        public final a b() {
            return this.f44912b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof h) && Intrinsics.a(this.f44912b, ((h) obj).f44912b);
        }

        public int hashCode() {
            return this.f44912b.hashCode();
        }

        public String toString() {
            a aVar = this.f44912b;
            return "TextInput(content=" + aVar + ")";
        }
    }

    private ro() {
    }

    public final String a() {
        return this.f44871a;
    }
}
