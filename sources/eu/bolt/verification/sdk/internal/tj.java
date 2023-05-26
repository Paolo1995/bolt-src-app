package eu.bolt.verification.sdk.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class tj {

    /* renamed from: a  reason: collision with root package name */
    private final String f45204a;

    /* renamed from: b  reason: collision with root package name */
    private final oi f45205b;

    /* loaded from: classes5.dex */
    public static final class a extends tj {

        /* renamed from: c  reason: collision with root package name */
        private final String f45206c;

        /* renamed from: d  reason: collision with root package name */
        private final oi f45207d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String url, oi oiVar) {
            super(url, oiVar, null);
            Intrinsics.f(url, "url");
            this.f45206c = url;
            this.f45207d = oiVar;
        }

        @Override // eu.bolt.verification.sdk.internal.tj
        public oi a() {
            return this.f45207d;
        }

        @Override // eu.bolt.verification.sdk.internal.tj
        public String b() {
            return this.f45206c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(b(), aVar.b()) && Intrinsics.a(a(), aVar.a());
            }
            return false;
        }

        public int hashCode() {
            return (b().hashCode() * 31) + (a() == null ? 0 : a().hashCode());
        }

        public String toString() {
            String b8 = b();
            oi a8 = a();
            return "Drawable(url=" + b8 + ", dimensions=" + a8 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends tj {

        /* renamed from: c  reason: collision with root package name */
        private final String f45208c;

        /* renamed from: d  reason: collision with root package name */
        private final oi f45209d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String url, oi oiVar) {
            super(url, oiVar, null);
            Intrinsics.f(url, "url");
            this.f45208c = url;
            this.f45209d = oiVar;
        }

        @Override // eu.bolt.verification.sdk.internal.tj
        public oi a() {
            return this.f45209d;
        }

        @Override // eu.bolt.verification.sdk.internal.tj
        public String b() {
            return this.f45208c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return Intrinsics.a(b(), bVar.b()) && Intrinsics.a(a(), bVar.a());
            }
            return false;
        }

        public int hashCode() {
            return (b().hashCode() * 31) + (a() == null ? 0 : a().hashCode());
        }

        public String toString() {
            String b8 = b();
            oi a8 = a();
            return "Lottie(url=" + b8 + ", dimensions=" + a8 + ")";
        }
    }

    private tj(String str, oi oiVar) {
        this.f45204a = str;
        this.f45205b = oiVar;
    }

    public /* synthetic */ tj(String str, oi oiVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, oiVar);
    }

    public oi a() {
        return this.f45205b;
    }

    public String b() {
        return this.f45204a;
    }
}
