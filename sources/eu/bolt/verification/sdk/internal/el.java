package eu.bolt.verification.sdk.internal;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import j$.util.Spliterator;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes5.dex */
public class el extends RuntimeException {

    /* renamed from: f  reason: collision with root package name */
    private final b f42803f;

    /* renamed from: g  reason: collision with root package name */
    private String f42804g;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: h  reason: collision with root package name */
        public static final C0050a f42805h = new C0050a(null);
        @SerializedName("text")

        /* renamed from: a  reason: collision with root package name */
        private final String f42806a;
        @SerializedName("title")

        /* renamed from: b  reason: collision with root package name */
        private final String f42807b;
        @SerializedName("image")

        /* renamed from: c  reason: collision with root package name */
        private final q9 f42808c;
        @SerializedName("static_modal")

        /* renamed from: d  reason: collision with root package name */
        private final mh f42809d;
        @SerializedName("primary_action")

        /* renamed from: e  reason: collision with root package name */
        private final i6 f42810e;
        @SerializedName("secondary_action")

        /* renamed from: f  reason: collision with root package name */
        private final i6 f42811f;
        @SerializedName("ui_type")

        /* renamed from: g  reason: collision with root package name */
        private final String f42812g;

        /* renamed from: eu.bolt.verification.sdk.internal.el$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0050a {
            private C0050a() {
            }

            public /* synthetic */ C0050a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public a() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public a(String str, String str2, q9 q9Var, mh mhVar, i6 i6Var, i6 i6Var2, String str3) {
            this.f42806a = str;
            this.f42807b = str2;
            this.f42808c = q9Var;
            this.f42809d = mhVar;
            this.f42810e = i6Var;
            this.f42811f = i6Var2;
            this.f42812g = str3;
        }

        public /* synthetic */ a(String str, String str2, q9 q9Var, mh mhVar, i6 i6Var, i6 i6Var2, String str3, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? null : str, (i8 & 2) != 0 ? null : str2, (i8 & 4) != 0 ? null : q9Var, (i8 & 8) != 0 ? null : mhVar, (i8 & 16) != 0 ? null : i6Var, (i8 & 32) != 0 ? null : i6Var2, (i8 & 64) != 0 ? null : str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(this.f42806a, aVar.f42806a) && Intrinsics.a(this.f42807b, aVar.f42807b) && Intrinsics.a(this.f42808c, aVar.f42808c) && Intrinsics.a(this.f42809d, aVar.f42809d) && Intrinsics.a(this.f42810e, aVar.f42810e) && Intrinsics.a(this.f42811f, aVar.f42811f) && Intrinsics.a(this.f42812g, aVar.f42812g);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f42806a;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.f42807b;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            q9 q9Var = this.f42808c;
            int hashCode3 = (hashCode2 + (q9Var == null ? 0 : q9Var.hashCode())) * 31;
            mh mhVar = this.f42809d;
            int hashCode4 = (hashCode3 + (mhVar == null ? 0 : mhVar.hashCode())) * 31;
            i6 i6Var = this.f42810e;
            int hashCode5 = (hashCode4 + (i6Var == null ? 0 : i6Var.hashCode())) * 31;
            i6 i6Var2 = this.f42811f;
            int hashCode6 = (hashCode5 + (i6Var2 == null ? 0 : i6Var2.hashCode())) * 31;
            String str3 = this.f42812g;
            return hashCode6 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            String str = this.f42806a;
            String str2 = this.f42807b;
            q9 q9Var = this.f42808c;
            mh mhVar = this.f42809d;
            i6 i6Var = this.f42810e;
            i6 i6Var2 = this.f42811f;
            String str3 = this.f42812g;
            return "ErrorInfo(displayErrorMessage=" + str + ", displayErrorTitle=" + str2 + ", displayErrorImage=" + q9Var + ", errorStaticModalParams=" + mhVar + ", firstAction=" + i6Var + ", secondAction=" + i6Var2 + ", uiType=" + str3 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        @SerializedName("code")

        /* renamed from: a  reason: collision with root package name */
        private final int f42813a;
        @SerializedName("message")

        /* renamed from: b  reason: collision with root package name */
        private final String f42814b;
        @SerializedName("error_data")

        /* renamed from: c  reason: collision with root package name */
        private final a f42815c;
        @SerializedName("data")

        /* renamed from: d  reason: collision with root package name */
        private final JsonObject f42816d;
        @SerializedName("validation_errors")

        /* renamed from: e  reason: collision with root package name */
        private final List<Object> f42817e;

        /* renamed from: f  reason: collision with root package name */
        private transient JsonObject f42818f;

        public b() {
            this(0, null, null, null, null, 31, null);
        }

        public b(int i8, String str, a aVar, JsonObject jsonObject, List<Object> list) {
            this.f42813a = i8;
            this.f42814b = str;
            this.f42815c = aVar;
            this.f42816d = jsonObject;
            this.f42817e = list;
        }

        public /* synthetic */ b(int i8, String str, a aVar, JsonObject jsonObject, List list, int i9, DefaultConstructorMarker defaultConstructorMarker) {
            this((i9 & 1) != 0 ? -1 : i8, (i9 & 2) != 0 ? null : str, (i9 & 4) != 0 ? null : aVar, (i9 & 8) != 0 ? null : jsonObject, (i9 & 16) == 0 ? list : null);
        }

        public final int a() {
            return this.f42813a;
        }

        public final void b(JsonObject jsonObject) {
            this.f42818f = jsonObject;
        }

        public final String c() {
            return this.f42814b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.f42813a == bVar.f42813a && Intrinsics.a(this.f42814b, bVar.f42814b) && Intrinsics.a(this.f42815c, bVar.f42815c) && Intrinsics.a(this.f42816d, bVar.f42816d) && Intrinsics.a(this.f42817e, bVar.f42817e);
            }
            return false;
        }

        public int hashCode() {
            int i8 = this.f42813a * 31;
            String str = this.f42814b;
            int hashCode = (i8 + (str == null ? 0 : str.hashCode())) * 31;
            a aVar = this.f42815c;
            int hashCode2 = (hashCode + (aVar == null ? 0 : aVar.hashCode())) * 31;
            JsonObject jsonObject = this.f42816d;
            int hashCode3 = (hashCode2 + (jsonObject == null ? 0 : jsonObject.hashCode())) * 31;
            List<Object> list = this.f42817e;
            return hashCode3 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            int i8 = this.f42813a;
            String str = this.f42814b;
            return i8 + ": " + str;
        }
    }

    public el() {
        this(0, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public el(int i8, String str, String str2, String str3, i6 i6Var, i6 i6Var2, JsonObject jsonObject, q9 q9Var, mh mhVar, JsonObject jsonObject2, List<Object> list) {
        this(new b(i8, str, new a(str3, str2, q9Var, mhVar, i6Var, i6Var2, null, 64, null), jsonObject2, list));
        this.f42803f.b(jsonObject);
    }

    public /* synthetic */ el(int i8, String str, String str2, String str3, i6 i6Var, i6 i6Var2, JsonObject jsonObject, q9 q9Var, mh mhVar, JsonObject jsonObject2, List list, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this((i9 & 1) != 0 ? -1 : i8, (i9 & 2) != 0 ? null : str, (i9 & 4) != 0 ? null : str2, (i9 & 8) != 0 ? null : str3, (i9 & 16) != 0 ? null : i6Var, (i9 & 32) != 0 ? null : i6Var2, (i9 & 64) != 0 ? null : jsonObject, (i9 & 128) != 0 ? null : q9Var, (i9 & Spliterator.NONNULL) != 0 ? null : mhVar, (i9 & 512) != 0 ? null : jsonObject2, (i9 & Spliterator.IMMUTABLE) == 0 ? list : null);
    }

    public el(b response) {
        Intrinsics.f(response, "response");
        this.f42803f = response;
        setStackTrace(b());
    }

    private final StackTraceElement a(String str, Object obj) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String format = String.format(Locale.US, "%s = %s", Arrays.copyOf(new Object[]{str, obj}, 2));
        Intrinsics.e(format, "format(locale, format, *args)");
        return new StackTraceElement("exception", format, getClass().getSimpleName(), 0);
    }

    private final StackTraceElement[] b() {
        String c8 = c();
        return new StackTraceElement[]{new StackTraceElement(c8, "exception", c8, 0), a("endpoint", this.f42804g), a("errorCode", Integer.valueOf(this.f42803f.a())), a("errorMessage", this.f42803f.c())};
    }

    private final String c() {
        boolean L;
        boolean v7;
        String valueOf = String.valueOf(this.f42804g);
        L = StringsKt__StringsJVMKt.L(valueOf, "/", false, 2, null);
        if (L) {
            valueOf = valueOf.substring(1);
            Intrinsics.e(valueOf, "this as java.lang.String).substring(startIndex)");
        }
        v7 = StringsKt__StringsJVMKt.v(valueOf, "/", false, 2, null);
        if (v7) {
            valueOf = valueOf.substring(0, valueOf.length() - 1);
            Intrinsics.e(valueOf, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        String g8 = new Regex("/").g(valueOf, "_");
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String format = String.format(Locale.US, "Network_%s_%s", Arrays.copyOf(new Object[]{g8, this.f42803f.c()}, 2));
        Intrinsics.e(format, "format(locale, format, *args)");
        return format;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.a(getClass(), obj != null ? obj.getClass() : null)) {
            Intrinsics.d(obj, "null cannot be cast to non-null type eu.bolt.client.network.exceptions.TaxifyException");
            el elVar = (el) obj;
            return Intrinsics.a(this.f42803f, elVar.f42803f) && Intrinsics.a(this.f42804g, elVar.f42804g);
        }
        return false;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return toString();
    }

    public int hashCode() {
        int hashCode = this.f42803f.hashCode() * 31;
        String str = this.f42804g;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        b bVar = this.f42803f;
        return "TaxifyException [" + bVar + "]";
    }
}
