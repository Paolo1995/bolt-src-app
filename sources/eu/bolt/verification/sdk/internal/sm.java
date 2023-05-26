package eu.bolt.verification.sdk.internal;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import eu.bolt.verification.core.network.adapter.VerificationButtonActionAdapter;
import eu.bolt.verification.sdk.internal.ro;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonAdapter(VerificationButtonActionAdapter.class)
/* loaded from: classes5.dex */
public abstract class sm {
    @SerializedName("condition")

    /* renamed from: a  reason: collision with root package name */
    private final pm f45015a;
    @SerializedName("analytics")

    /* renamed from: b  reason: collision with root package name */
    private final hm f45016b;

    /* loaded from: classes5.dex */
    public static final class a extends sm {

        /* renamed from: c  reason: collision with root package name */
        public static final a f45017c = new a();

        private a() {
            super(null);
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends sm {

        /* renamed from: c  reason: collision with root package name */
        public static final b f45018c = new b();

        private b() {
            super(null);
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends sm {
        @SerializedName("payload")

        /* renamed from: c  reason: collision with root package name */
        private final a f45019c;

        /* loaded from: classes5.dex */
        public static final class a {
            @SerializedName("step_id")

            /* renamed from: a  reason: collision with root package name */
            private final String f45020a;

            public final String a() {
                return this.f45020a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && Intrinsics.a(this.f45020a, ((a) obj).f45020a);
            }

            public int hashCode() {
                return this.f45020a.hashCode();
            }

            public String toString() {
                String str = this.f45020a;
                return "Payload(stepId=" + str + ")";
            }
        }

        public final a c() {
            return this.f45019c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Intrinsics.a(this.f45019c, ((c) obj).f45019c);
        }

        public int hashCode() {
            return this.f45019c.hashCode();
        }

        public String toString() {
            a aVar = this.f45019c;
            return "GoToNextStep(payload=" + aVar + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends sm {
        @SerializedName("payload")

        /* renamed from: c  reason: collision with root package name */
        private final a f45021c;

        /* loaded from: classes5.dex */
        public static final class a {
            @SerializedName("title")

            /* renamed from: a  reason: collision with root package name */
            private final String f45022a;
            @SerializedName("content_html")

            /* renamed from: b  reason: collision with root package name */
            private final String f45023b;
            @SerializedName("buttons")

            /* renamed from: c  reason: collision with root package name */
            private final List<ro.a> f45024c;

            public final List<ro.a> a() {
                return this.f45024c;
            }

            public final String b() {
                return this.f45023b;
            }

            public final String c() {
                return this.f45022a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return Intrinsics.a(this.f45022a, aVar.f45022a) && Intrinsics.a(this.f45023b, aVar.f45023b) && Intrinsics.a(this.f45024c, aVar.f45024c);
                }
                return false;
            }

            public int hashCode() {
                return (((this.f45022a.hashCode() * 31) + this.f45023b.hashCode()) * 31) + this.f45024c.hashCode();
            }

            public String toString() {
                String str = this.f45022a;
                String str2 = this.f45023b;
                List<ro.a> list = this.f45024c;
                return "Payload(title=" + str + ", contentHtml=" + str2 + ", buttons=" + list + ")";
            }
        }

        public final a c() {
            return this.f45021c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && Intrinsics.a(this.f45021c, ((d) obj).f45021c);
        }

        public int hashCode() {
            return this.f45021c.hashCode();
        }

        public String toString() {
            a aVar = this.f45021c;
            return "OpenBottomSheet(payload=" + aVar + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends sm {
        @SerializedName("payload")

        /* renamed from: c  reason: collision with root package name */
        private final a f45025c;

        /* loaded from: classes5.dex */
        public static final class a {
            @SerializedName(ImagesContract.URL)

            /* renamed from: a  reason: collision with root package name */
            private final String f45026a;

            public final String a() {
                return this.f45026a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && Intrinsics.a(this.f45026a, ((a) obj).f45026a);
            }

            public int hashCode() {
                return this.f45026a.hashCode();
            }

            public String toString() {
                String str = this.f45026a;
                return "Payload(url=" + str + ")";
            }
        }

        public final a c() {
            return this.f45025c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && Intrinsics.a(this.f45025c, ((e) obj).f45025c);
        }

        public int hashCode() {
            return this.f45025c.hashCode();
        }

        public String toString() {
            a aVar = this.f45025c;
            return "OpenWebView(payload=" + aVar + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class f extends sm {
        @SerializedName("payload")

        /* renamed from: c  reason: collision with root package name */
        private final a f45027c;

        /* loaded from: classes5.dex */
        public static final class a {
            @SerializedName("path")

            /* renamed from: a  reason: collision with root package name */
            private final String f45028a;
            @SerializedName("params")

            /* renamed from: b  reason: collision with root package name */
            private final Map<String, String> f45029b;

            public final Map<String, String> a() {
                return this.f45029b;
            }

            public final String b() {
                return this.f45028a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return Intrinsics.a(this.f45028a, aVar.f45028a) && Intrinsics.a(this.f45029b, aVar.f45029b);
                }
                return false;
            }

            public int hashCode() {
                return (this.f45028a.hashCode() * 31) + this.f45029b.hashCode();
            }

            public String toString() {
                String str = this.f45028a;
                Map<String, String> map = this.f45029b;
                return "Payload(path=" + str + ", params=" + map + ")";
            }
        }

        public final a c() {
            return this.f45027c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof f) && Intrinsics.a(this.f45027c, ((f) obj).f45027c);
        }

        public int hashCode() {
            return this.f45027c.hashCode();
        }

        public String toString() {
            a aVar = this.f45027c;
            return "SendPostRequest(payload=" + aVar + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class g extends sm {
        @SerializedName("payload")

        /* renamed from: c  reason: collision with root package name */
        private final a f45030c;

        /* loaded from: classes5.dex */
        public static final class a {
            @SerializedName("data")

            /* renamed from: a  reason: collision with root package name */
            private final List<b> f45031a;

            public final List<b> a() {
                return this.f45031a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && Intrinsics.a(this.f45031a, ((a) obj).f45031a);
            }

            public int hashCode() {
                return this.f45031a.hashCode();
            }

            public String toString() {
                List<b> list = this.f45031a;
                return "Payload(userInputs=" + list + ")";
            }
        }

        /* loaded from: classes5.dex */
        public static final class b {
            @SerializedName("field_id")

            /* renamed from: a  reason: collision with root package name */
            private final String f45032a;
            @SerializedName("values")

            /* renamed from: b  reason: collision with root package name */
            private final Set<String> f45033b;

            public final String a() {
                return this.f45032a;
            }

            public final Set<String> b() {
                return this.f45033b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    return Intrinsics.a(this.f45032a, bVar.f45032a) && Intrinsics.a(this.f45033b, bVar.f45033b);
                }
                return false;
            }

            public int hashCode() {
                return (this.f45032a.hashCode() * 31) + this.f45033b.hashCode();
            }

            public String toString() {
                String str = this.f45032a;
                Set<String> set = this.f45033b;
                return "UserInput(fieldId=" + str + ", values=" + set + ")";
            }
        }

        public final a c() {
            return this.f45030c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof g) && Intrinsics.a(this.f45030c, ((g) obj).f45030c);
        }

        public int hashCode() {
            return this.f45030c.hashCode();
        }

        public String toString() {
            a aVar = this.f45030c;
            return "SubmitPredefinedData(payload=" + aVar + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class h extends sm {
        @SerializedName("payload")

        /* renamed from: c  reason: collision with root package name */
        private final a f45034c;

        /* loaded from: classes5.dex */
        public static final class a {
            @SerializedName("step_id")

            /* renamed from: a  reason: collision with root package name */
            private final String f45035a;

            public final String a() {
                return this.f45035a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && Intrinsics.a(this.f45035a, ((a) obj).f45035a);
            }

            public int hashCode() {
                return this.f45035a.hashCode();
            }

            public String toString() {
                String str = this.f45035a;
                return "Payload(stepId=" + str + ")";
            }
        }

        public final a c() {
            return this.f45034c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof h) && Intrinsics.a(this.f45034c, ((h) obj).f45034c);
        }

        public int hashCode() {
            return this.f45034c.hashCode();
        }

        public String toString() {
            a aVar = this.f45034c;
            return "SubmitUserData(payload=" + aVar + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class i extends sm {
        @SerializedName("payload")

        /* renamed from: c  reason: collision with root package name */
        private final a f45036c;

        /* loaded from: classes5.dex */
        public static final class a {
            @SerializedName("step_id")

            /* renamed from: a  reason: collision with root package name */
            private final String f45037a;

            public final String a() {
                return this.f45037a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && Intrinsics.a(this.f45037a, ((a) obj).f45037a);
            }

            public int hashCode() {
                return this.f45037a.hashCode();
            }

            public String toString() {
                String str = this.f45037a;
                return "Payload(stepId=" + str + ")";
            }
        }

        public final a c() {
            return this.f45036c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof i) && Intrinsics.a(this.f45036c, ((i) obj).f45036c);
        }

        public int hashCode() {
            return this.f45036c.hashCode();
        }

        public String toString() {
            a aVar = this.f45036c;
            return "SubmitUserDataAndClose(payload=" + aVar + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class j extends sm {
        @SerializedName("payload")

        /* renamed from: c  reason: collision with root package name */
        private final c f45038c;

        /* loaded from: classes5.dex */
        public static final class a {
            @SerializedName(ImagesContract.URL)

            /* renamed from: a  reason: collision with root package name */
            private final String f45039a;
            @SerializedName("delay_ms")

            /* renamed from: b  reason: collision with root package name */
            private final Long f45040b;

            public final Long a() {
                return this.f45040b;
            }

            public final String b() {
                return this.f45039a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return Intrinsics.a(this.f45039a, aVar.f45039a) && Intrinsics.a(this.f45040b, aVar.f45040b);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = this.f45039a.hashCode() * 31;
                Long l8 = this.f45040b;
                return hashCode + (l8 == null ? 0 : l8.hashCode());
            }

            public String toString() {
                String str = this.f45039a;
                Long l8 = this.f45040b;
                return "CloseWebviewUrl(url=" + str + ", delayMs=" + l8 + ")";
            }
        }

        /* loaded from: classes5.dex */
        public static final class b {
            @SerializedName("report_sdk_event_request")

            /* renamed from: a  reason: collision with root package name */
            private final String f45041a;
            @SerializedName("close_sdk")

            /* renamed from: b  reason: collision with root package name */
            private final Boolean f45042b;

            public final Boolean a() {
                return this.f45042b;
            }

            public final String b() {
                return this.f45041a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    return Intrinsics.a(this.f45041a, bVar.f45041a) && Intrinsics.a(this.f45042b, bVar.f45042b);
                }
                return false;
            }

            public int hashCode() {
                String str = this.f45041a;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                Boolean bool = this.f45042b;
                return hashCode + (bool != null ? bool.hashCode() : 0);
            }

            public String toString() {
                String str = this.f45041a;
                Boolean bool = this.f45042b;
                return "OnUserCloseWebview(reportSdkEventRequest=" + str + ", closeSdk=" + bool + ")";
            }
        }

        /* loaded from: classes5.dex */
        public static final class c {
            @SerializedName(ImagesContract.URL)

            /* renamed from: a  reason: collision with root package name */
            private final String f45043a;
            @SerializedName("url_type")

            /* renamed from: b  reason: collision with root package name */
            private final String f45044b;
            @SerializedName("include_auth_header")

            /* renamed from: c  reason: collision with root package name */
            private final boolean f45045c;
            @SerializedName("headers")

            /* renamed from: d  reason: collision with root package name */
            private final Map<String, String> f45046d;
            @SerializedName("on_user_close_webview")

            /* renamed from: e  reason: collision with root package name */
            private final b f45047e;
            @SerializedName("close_webview_urls")

            /* renamed from: f  reason: collision with root package name */
            private final List<a> f45048f;
            @SerializedName("title")

            /* renamed from: g  reason: collision with root package name */
            private final String f45049g;

            public final List<a> a() {
                return this.f45048f;
            }

            public final Map<String, String> b() {
                return this.f45046d;
            }

            public final boolean c() {
                return this.f45045c;
            }

            public final b d() {
                return this.f45047e;
            }

            public final String e() {
                return this.f45049g;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof c) {
                    c cVar = (c) obj;
                    return Intrinsics.a(this.f45043a, cVar.f45043a) && Intrinsics.a(this.f45044b, cVar.f45044b) && this.f45045c == cVar.f45045c && Intrinsics.a(this.f45046d, cVar.f45046d) && Intrinsics.a(this.f45047e, cVar.f45047e) && Intrinsics.a(this.f45048f, cVar.f45048f) && Intrinsics.a(this.f45049g, cVar.f45049g);
                }
                return false;
            }

            public final String f() {
                return this.f45043a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int hashCode = ((this.f45043a.hashCode() * 31) + this.f45044b.hashCode()) * 31;
                boolean z7 = this.f45045c;
                int i8 = z7;
                if (z7 != 0) {
                    i8 = 1;
                }
                int hashCode2 = (((hashCode + i8) * 31) + this.f45046d.hashCode()) * 31;
                b bVar = this.f45047e;
                int hashCode3 = (hashCode2 + (bVar == null ? 0 : bVar.hashCode())) * 31;
                List<a> list = this.f45048f;
                int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
                String str = this.f45049g;
                return hashCode4 + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                String str = this.f45043a;
                String str2 = this.f45044b;
                boolean z7 = this.f45045c;
                Map<String, String> map = this.f45046d;
                b bVar = this.f45047e;
                List<a> list = this.f45048f;
                String str3 = this.f45049g;
                return "Payload(url=" + str + ", urlType=" + str2 + ", includeAuthHeader=" + z7 + ", headers=" + map + ", onUserCloseWebview=" + bVar + ", closeWebviewUrls=" + list + ", title=" + str3 + ")";
            }
        }

        public final c c() {
            return this.f45038c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof j) && Intrinsics.a(this.f45038c, ((j) obj).f45038c);
        }

        public int hashCode() {
            return this.f45038c.hashCode();
        }

        public String toString() {
            c cVar = this.f45038c;
            return "SupportWebView(payload=" + cVar + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class k extends sm {

        /* renamed from: c  reason: collision with root package name */
        public static final k f45050c = new k();

        private k() {
            super(null);
        }
    }

    /* loaded from: classes5.dex */
    public static final class l extends sm {
        @SerializedName("payload")

        /* renamed from: c  reason: collision with root package name */
        private final a f45051c;

        /* loaded from: classes5.dex */
        public static final class a {
            @SerializedName("step_id")

            /* renamed from: a  reason: collision with root package name */
            private final String f45052a;

            public final String a() {
                return this.f45052a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && Intrinsics.a(this.f45052a, ((a) obj).f45052a);
            }

            public int hashCode() {
                return this.f45052a.hashCode();
            }

            public String toString() {
                String str = this.f45052a;
                return "Payload(stepId=" + str + ")";
            }
        }

        public final a c() {
            return this.f45051c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof l) && Intrinsics.a(this.f45051c, ((l) obj).f45051c);
        }

        public int hashCode() {
            return this.f45051c.hashCode();
        }

        public String toString() {
            a aVar = this.f45051c;
            return "UploadMultifromRequest(payload=" + aVar + ")";
        }
    }

    private sm() {
    }

    public /* synthetic */ sm(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final hm a() {
        return this.f45016b;
    }

    public final pm b() {
        return this.f45015a;
    }
}
