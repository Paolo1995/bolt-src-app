package eu.bolt.verification.sdk.internal;

import eu.bolt.android.rib.BaseViewRibPresenter;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes5.dex */
public interface n7 extends BaseViewRibPresenter<b> {

    /* loaded from: classes5.dex */
    public static final class a {
        public static Flow<b> a(n7 n7Var) {
            return BaseViewRibPresenter.DefaultImpls.b(n7Var);
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class b {

        /* loaded from: classes5.dex */
        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final a f44294a = new a();

            private a() {
                super(null);
            }
        }

        /* renamed from: eu.bolt.verification.sdk.internal.n7$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0075b extends b {

            /* renamed from: a  reason: collision with root package name */
            private final b1 f44295a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0075b(b1 payload) {
                super(null);
                Intrinsics.f(payload, "payload");
                this.f44295a = payload;
            }

            public final b1 a() {
                return this.f44295a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0075b) && Intrinsics.a(this.f44295a, ((C0075b) obj).f44295a);
            }

            public int hashCode() {
                return this.f44295a.hashCode();
            }

            public String toString() {
                b1 b1Var = this.f44295a;
                return "ButtonClicks(payload=" + b1Var + ")";
            }
        }

        /* loaded from: classes5.dex */
        public static final class c extends b {

            /* renamed from: a  reason: collision with root package name */
            private final ud f44296a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(ud payload) {
                super(null);
                Intrinsics.f(payload, "payload");
                this.f44296a = payload;
            }

            public final ud a() {
                return this.f44296a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof c) && Intrinsics.a(this.f44296a, ((c) obj).f44296a);
            }

            public int hashCode() {
                return this.f44296a.hashCode();
            }

            public String toString() {
                ud udVar = this.f44296a;
                return "CheckBoxOptionClicks(payload=" + udVar + ")";
            }
        }

        /* loaded from: classes5.dex */
        public static final class d extends b {

            /* renamed from: a  reason: collision with root package name */
            private final k2 f44297a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(k2 payload) {
                super(null);
                Intrinsics.f(payload, "payload");
                this.f44297a = payload;
            }

            public final k2 a() {
                return this.f44297a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof d) && Intrinsics.a(this.f44297a, ((d) obj).f44297a);
            }

            public int hashCode() {
                return this.f44297a.hashCode();
            }

            public String toString() {
                k2 k2Var = this.f44297a;
                return "CountryPickerClicks(payload=" + k2Var + ")";
            }
        }

        /* loaded from: classes5.dex */
        public static final class e extends b {

            /* renamed from: a  reason: collision with root package name */
            private final String f44298a;

            /* renamed from: b  reason: collision with root package name */
            private final Date f44299b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(String fieldId, Date date) {
                super(null);
                Intrinsics.f(fieldId, "fieldId");
                this.f44298a = fieldId;
                this.f44299b = date;
            }

            public final String a() {
                return this.f44298a;
            }

            public final Date b() {
                return this.f44299b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof e) {
                    e eVar = (e) obj;
                    return Intrinsics.a(this.f44298a, eVar.f44298a) && Intrinsics.a(this.f44299b, eVar.f44299b);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = this.f44298a.hashCode() * 31;
                Date date = this.f44299b;
                return hashCode + (date == null ? 0 : date.hashCode());
            }

            public String toString() {
                String str = this.f44298a;
                Date date = this.f44299b;
                return "DateInput(fieldId=" + str + ", payload=" + date + ")";
            }
        }

        /* loaded from: classes5.dex */
        public static final class f extends b {

            /* renamed from: a  reason: collision with root package name */
            private final String f44300a;

            /* renamed from: b  reason: collision with root package name */
            private final List<cm> f44301b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(String url, List<cm> urlIntercepts) {
                super(null);
                Intrinsics.f(url, "url");
                Intrinsics.f(urlIntercepts, "urlIntercepts");
                this.f44300a = url;
                this.f44301b = urlIntercepts;
            }

            public final String a() {
                return this.f44300a;
            }

            public final List<cm> b() {
                return this.f44301b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof f) {
                    f fVar = (f) obj;
                    return Intrinsics.a(this.f44300a, fVar.f44300a) && Intrinsics.a(this.f44301b, fVar.f44301b);
                }
                return false;
            }

            public int hashCode() {
                return (this.f44300a.hashCode() * 31) + this.f44301b.hashCode();
            }

            public String toString() {
                String str = this.f44300a;
                List<cm> list = this.f44301b;
                return "ParagraphUrlClick(url=" + str + ", urlIntercepts=" + list + ")";
            }
        }

        /* loaded from: classes5.dex */
        public static final class g extends b {

            /* renamed from: a  reason: collision with root package name */
            private final String f44302a;

            /* renamed from: b  reason: collision with root package name */
            private final String f44303b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public g(String fieldId, String newValue) {
                super(null);
                Intrinsics.f(fieldId, "fieldId");
                Intrinsics.f(newValue, "newValue");
                this.f44302a = fieldId;
                this.f44303b = newValue;
            }

            public final String a() {
                return this.f44302a;
            }

            public final String b() {
                return this.f44303b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof g) {
                    g gVar = (g) obj;
                    return Intrinsics.a(this.f44302a, gVar.f44302a) && Intrinsics.a(this.f44303b, gVar.f44303b);
                }
                return false;
            }

            public int hashCode() {
                return (this.f44302a.hashCode() * 31) + this.f44303b.hashCode();
            }

            public String toString() {
                String str = this.f44302a;
                String str2 = this.f44303b;
                return "TextInput(fieldId=" + str + ", newValue=" + str2 + ")";
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    void v(b8 b8Var);

    void w(String str, boolean z7);
}
