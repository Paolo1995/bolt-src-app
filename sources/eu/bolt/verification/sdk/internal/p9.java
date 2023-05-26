package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class p9 implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final String f44515f;

    /* loaded from: classes5.dex */
    public static final class a extends p9 {

        /* renamed from: g  reason: collision with root package name */
        private final String f44516g;

        /* renamed from: h  reason: collision with root package name */
        private final Integer f44517h;

        /* renamed from: i  reason: collision with root package name */
        private final Integer f44518i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f44519j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String url, Integer num, Integer num2, c cVar, boolean z7) {
            super(url, null);
            Intrinsics.f(url, "url");
            this.f44516g = url;
            this.f44517h = num;
            this.f44518i = num2;
            this.f44519j = z7;
        }

        public /* synthetic */ a(String str, Integer num, Integer num2, c cVar, boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i8 & 2) != 0 ? null : num, (i8 & 4) != 0 ? null : num2, (i8 & 8) != 0 ? null : cVar, (i8 & 16) != 0 ? false : z7);
        }

        public final boolean a() {
            return this.f44519j;
        }

        public final c b() {
            return null;
        }

        public String c() {
            return this.f44516g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(c(), aVar.c()) && Intrinsics.a(this.f44517h, aVar.f44517h) && Intrinsics.a(this.f44518i, aVar.f44518i) && Intrinsics.a(null, null) && this.f44519j == aVar.f44519j;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = c().hashCode() * 31;
            Integer num = this.f44517h;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.f44518i;
            int hashCode3 = (((hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31) + 0) * 31;
            boolean z7 = this.f44519j;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return hashCode3 + i8;
        }

        public String toString() {
            String c8 = c();
            Integer num = this.f44517h;
            Integer num2 = this.f44518i;
            boolean z7 = this.f44519j;
            return "Drawable(url=" + c8 + ", placeholderRes=" + num + ", errorRes=" + num2 + ", size=" + ((Object) null) + ", roundDrawable=" + z7 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends p9 {

        /* renamed from: g  reason: collision with root package name */
        private final String f44520g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f44521h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f44522i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String url, c cVar, boolean z7, boolean z8) {
            super(url, null);
            Intrinsics.f(url, "url");
            this.f44520g = url;
            this.f44521h = z7;
            this.f44522i = z8;
        }

        public /* synthetic */ b(String str, c cVar, boolean z7, boolean z8, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i8 & 2) != 0 ? null : cVar, (i8 & 4) != 0 ? false : z7, (i8 & 8) != 0 ? false : z8);
        }

        public final boolean a() {
            return this.f44522i;
        }

        public final boolean b() {
            return this.f44521h;
        }

        public final c c() {
            return null;
        }

        public String d() {
            return this.f44520g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return Intrinsics.a(d(), bVar.d()) && Intrinsics.a(null, null) && this.f44521h == bVar.f44521h && this.f44522i == bVar.f44522i;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((d().hashCode() * 31) + 0) * 31;
            boolean z7 = this.f44521h;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            int i9 = (hashCode + i8) * 31;
            boolean z8 = this.f44522i;
            return i9 + (z8 ? 1 : z8 ? 1 : 0);
        }

        public String toString() {
            String d8 = d();
            boolean z7 = this.f44521h;
            boolean z8 = this.f44522i;
            return "Lottie(url=" + d8 + ", size=" + ((Object) null) + ", repeat=" + z7 + ", playAnimation=" + z8 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements Serializable {
    }

    private p9(String str) {
        this.f44515f = str;
    }

    public /* synthetic */ p9(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}
