package eu.bolt.verification.sdk.internal;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import eu.bolt.verification.core.network.adapter.VerificationStepAdapter;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

@JsonAdapter(VerificationStepAdapter.class)
/* loaded from: classes5.dex */
public abstract class yp {
    @SerializedName(Name.MARK)

    /* renamed from: a  reason: collision with root package name */
    private final String f45774a = "";
    @SerializedName("title")

    /* renamed from: b  reason: collision with root package name */
    private final d f45775b = new d("");
    @SerializedName("back_navigation")

    /* renamed from: c  reason: collision with root package name */
    private final String f45776c = "";
    @SerializedName("text_alignment")

    /* renamed from: d  reason: collision with root package name */
    private final String f45777d;
    @SerializedName("analytics")

    /* renamed from: e  reason: collision with root package name */
    private final c f45778e;
    @SerializedName("back_navigation_analytics")

    /* renamed from: f  reason: collision with root package name */
    private final hm f45779f;

    /* loaded from: classes5.dex */
    public static final class a extends yp {
        @SerializedName("main_content")

        /* renamed from: g  reason: collision with root package name */
        private final an f45780g;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.a(this.f45780g, ((a) obj).f45780g);
        }

        public final an g() {
            return this.f45780g;
        }

        public int hashCode() {
            return this.f45780g.hashCode();
        }

        public String toString() {
            an anVar = this.f45780g;
            return "Camera(mainContent=" + anVar + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends yp {
        @SerializedName("main_content")

        /* renamed from: g  reason: collision with root package name */
        private final ho f45781g;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.a(this.f45781g, ((b) obj).f45781g);
        }

        public final ho g() {
            return this.f45781g;
        }

        public int hashCode() {
            return this.f45781g.hashCode();
        }

        public String toString() {
            ho hoVar = this.f45781g;
            return "Form(mainContent=" + hoVar + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class c {
        @SerializedName("screen_name")

        /* renamed from: a  reason: collision with root package name */
        private final String f45782a;
        @SerializedName("parameters")

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, String> f45783b;

        public final Map<String, String> a() {
            return this.f45783b;
        }

        public final String b() {
            return this.f45782a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return Intrinsics.a(this.f45782a, cVar.f45782a) && Intrinsics.a(this.f45783b, cVar.f45783b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f45782a.hashCode() * 31) + this.f45783b.hashCode();
        }

        public String toString() {
            String str = this.f45782a;
            Map<String, String> map = this.f45783b;
            return "StepAnalytics(screenName=" + str + ", parameters=" + map + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class d {
        @SerializedName("text")

        /* renamed from: a  reason: collision with root package name */
        private final String f45784a;

        public d(String text) {
            Intrinsics.f(text, "text");
            this.f45784a = text;
        }

        public final String a() {
            return this.f45784a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && Intrinsics.a(this.f45784a, ((d) obj).f45784a);
        }

        public int hashCode() {
            return this.f45784a.hashCode();
        }

        public String toString() {
            String str = this.f45784a;
            return "Title(text=" + str + ")";
        }
    }

    private yp() {
    }

    public final c a() {
        return this.f45778e;
    }

    public final String b() {
        return this.f45776c;
    }

    public final hm c() {
        return this.f45779f;
    }

    public final String d() {
        return this.f45774a;
    }

    public final String e() {
        return this.f45777d;
    }

    public final d f() {
        return this.f45775b;
    }
}
