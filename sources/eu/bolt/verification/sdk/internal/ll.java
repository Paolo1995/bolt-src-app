package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class ll implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    public static final a f44093f = new a(null);

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ c b(a aVar, int i8, String str, int i9, Object obj) {
            if ((i9 & 2) != 0) {
                str = null;
            }
            return aVar.a(i8, str);
        }

        public final c a(int i8, String str) {
            return new c(i8, str);
        }

        public final d c(String text) {
            Intrinsics.f(text, "text");
            return new d(text);
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends ll {

        /* renamed from: g  reason: collision with root package name */
        private final String f44094g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String text) {
            super(null);
            Intrinsics.f(text, "text");
            this.f44094g = text;
        }

        public final String a() {
            return this.f44094g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.a(this.f44094g, ((b) obj).f44094g);
        }

        public int hashCode() {
            return this.f44094g.hashCode();
        }

        public String toString() {
            String str = this.f44094g;
            return "FromHtml(text=" + str + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends ll {

        /* renamed from: g  reason: collision with root package name */
        private final int f44095g;

        /* renamed from: h  reason: collision with root package name */
        private final String f44096h;

        public c(int i8, String str) {
            super(null);
            this.f44095g = i8;
            this.f44096h = str;
        }

        public final String a() {
            return this.f44096h;
        }

        public final int b() {
            return this.f44095g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.f44095g == cVar.f44095g && Intrinsics.a(this.f44096h, cVar.f44096h);
            }
            return false;
        }

        public int hashCode() {
            int i8 = this.f44095g * 31;
            String str = this.f44096h;
            return i8 + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            int i8 = this.f44095g;
            String str = this.f44096h;
            return "FromResource(resId=" + i8 + ", formatArg=" + str + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends ll {

        /* renamed from: g  reason: collision with root package name */
        private final String f44097g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String text) {
            super(null);
            Intrinsics.f(text, "text");
            this.f44097g = text;
        }

        public final String a() {
            return this.f44097g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && Intrinsics.a(this.f44097g, ((d) obj).f44097g);
        }

        public int hashCode() {
            return this.f44097g.hashCode();
        }

        public String toString() {
            String str = this.f44097g;
            return "FromString(text=" + str + ")";
        }
    }

    private ll() {
    }

    public /* synthetic */ ll(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
