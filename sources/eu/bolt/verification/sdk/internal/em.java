package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class em implements Serializable {

    /* loaded from: classes5.dex */
    public static final class a extends em {

        /* renamed from: f  reason: collision with root package name */
        private final List<String> f42819f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(List<String> optionIds) {
            super(null);
            Intrinsics.f(optionIds, "optionIds");
            this.f42819f = optionIds;
        }

        public final a a(List<String> optionIds) {
            Intrinsics.f(optionIds, "optionIds");
            return new a(optionIds);
        }

        public final List<String> b() {
            return this.f42819f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.a(this.f42819f, ((a) obj).f42819f);
        }

        public int hashCode() {
            return this.f42819f.hashCode();
        }

        public String toString() {
            List<String> list = this.f42819f;
            return "CheckBoxOption(optionIds=" + list + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends em {

        /* renamed from: f  reason: collision with root package name */
        private final String f42820f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String code) {
            super(null);
            Intrinsics.f(code, "code");
            this.f42820f = code;
        }

        public final String a() {
            return this.f42820f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.a(this.f42820f, ((b) obj).f42820f);
        }

        public int hashCode() {
            return this.f42820f.hashCode();
        }

        public String toString() {
            String str = this.f42820f;
            return "Country(code=" + str + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends em {

        /* renamed from: f  reason: collision with root package name */
        private final long f42821f;

        public c(long j8) {
            super(null);
            this.f42821f = j8;
        }

        public final long a() {
            return this.f42821f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && this.f42821f == ((c) obj).f42821f;
        }

        public int hashCode() {
            return i0.a.a(this.f42821f);
        }

        public String toString() {
            long j8 = this.f42821f;
            return "Date(value=" + j8 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends em {

        /* renamed from: f  reason: collision with root package name */
        private final int f42822f;

        public final int a() {
            return this.f42822f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && this.f42822f == ((d) obj).f42822f;
        }

        public int hashCode() {
            return this.f42822f;
        }

        public String toString() {
            int i8 = this.f42822f;
            return "Number(value=" + i8 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends em {

        /* renamed from: f  reason: collision with root package name */
        private final String f42823f;

        /* renamed from: g  reason: collision with root package name */
        private final Set<String> f42824g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String fieldId, Set<String> values) {
            super(null);
            Intrinsics.f(fieldId, "fieldId");
            Intrinsics.f(values, "values");
            this.f42823f = fieldId;
            this.f42824g = values;
        }

        public final String a() {
            return this.f42823f;
        }

        public final Set<String> b() {
            return this.f42824g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof e) {
                e eVar = (e) obj;
                return Intrinsics.a(this.f42823f, eVar.f42823f) && Intrinsics.a(this.f42824g, eVar.f42824g);
            }
            return false;
        }

        public int hashCode() {
            return (this.f42823f.hashCode() * 31) + this.f42824g.hashCode();
        }

        public String toString() {
            String str = this.f42823f;
            Set<String> set = this.f42824g;
            return "PredefinedValue(fieldId=" + str + ", values=" + set + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class f extends em {

        /* renamed from: f  reason: collision with root package name */
        private final String f42825f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String value) {
            super(null);
            Intrinsics.f(value, "value");
            this.f42825f = value;
        }

        public final String a() {
            return this.f42825f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof f) && Intrinsics.a(this.f42825f, ((f) obj).f42825f);
        }

        public int hashCode() {
            return this.f42825f.hashCode();
        }

        public String toString() {
            String str = this.f42825f;
            return "Text(value=" + str + ")";
        }
    }

    private em() {
    }

    public /* synthetic */ em(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
