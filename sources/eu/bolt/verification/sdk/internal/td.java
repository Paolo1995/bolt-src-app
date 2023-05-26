package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class td implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final String f45162f;

    /* loaded from: classes5.dex */
    public static final class a extends td {

        /* renamed from: g  reason: collision with root package name */
        private final String f45163g;

        /* renamed from: h  reason: collision with root package name */
        private final String f45164h;

        /* renamed from: i  reason: collision with root package name */
        private final Map<String, String> f45165i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String url, String str, Map<String, String> headers) {
            super(url, null);
            Intrinsics.f(url, "url");
            Intrinsics.f(headers, "headers");
            this.f45163g = url;
            this.f45164h = str;
            this.f45165i = headers;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ a b(a aVar, String str, String str2, Map map, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                str = aVar.a();
            }
            if ((i8 & 2) != 0) {
                str2 = aVar.f45164h;
            }
            if ((i8 & 4) != 0) {
                map = aVar.f45165i;
            }
            return aVar.c(str, str2, map);
        }

        @Override // eu.bolt.verification.sdk.internal.td
        public String a() {
            return this.f45163g;
        }

        public final a c(String url, String str, Map<String, String> headers) {
            Intrinsics.f(url, "url");
            Intrinsics.f(headers, "headers");
            return new a(url, str, headers);
        }

        public final Map<String, String> d() {
            return this.f45165i;
        }

        public final String e() {
            return this.f45164h;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(a(), aVar.a()) && Intrinsics.a(this.f45164h, aVar.f45164h) && Intrinsics.a(this.f45165i, aVar.f45165i);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = a().hashCode() * 31;
            String str = this.f45164h;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f45165i.hashCode();
        }

        public String toString() {
            String a8 = a();
            String str = this.f45164h;
            Map<String, String> map = this.f45165i;
            return "AuthWebLink(url=" + a8 + ", title=" + str + ", headers=" + map + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends td {

        /* renamed from: g  reason: collision with root package name */
        private final String f45166g;

        /* renamed from: h  reason: collision with root package name */
        private final String f45167h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String url, String str) {
            super(url, null);
            Intrinsics.f(url, "url");
            this.f45166g = url;
            this.f45167h = str;
        }

        public /* synthetic */ b(String str, String str2, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i8 & 2) != 0 ? null : str2);
        }

        public static /* synthetic */ b b(b bVar, String str, String str2, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                str = bVar.a();
            }
            if ((i8 & 2) != 0) {
                str2 = bVar.f45167h;
            }
            return bVar.c(str, str2);
        }

        @Override // eu.bolt.verification.sdk.internal.td
        public String a() {
            return this.f45166g;
        }

        public final b c(String url, String str) {
            Intrinsics.f(url, "url");
            return new b(url, str);
        }

        public final String d() {
            return this.f45167h;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return Intrinsics.a(a(), bVar.a()) && Intrinsics.a(this.f45167h, bVar.f45167h);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = a().hashCode() * 31;
            String str = this.f45167h;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            String a8 = a();
            String str = this.f45167h;
            return "NoAuthWebLink(url=" + a8 + ", title=" + str + ")";
        }
    }

    private td(String str) {
        this.f45162f = str;
    }

    public /* synthetic */ td(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public String a() {
        return this.f45162f;
    }
}
