package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class r1 extends ob {

    /* renamed from: f  reason: collision with root package name */
    private final String f44705f;

    /* renamed from: g  reason: collision with root package name */
    private final List<a> f44706g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f44707h;

    /* renamed from: i  reason: collision with root package name */
    private final List<String> f44708i;

    /* loaded from: classes5.dex */
    public static final class a implements Serializable {

        /* renamed from: f  reason: collision with root package name */
        private final String f44709f;

        /* renamed from: g  reason: collision with root package name */
        private final String f44710g;

        /* renamed from: h  reason: collision with root package name */
        private final String f44711h;

        /* renamed from: i  reason: collision with root package name */
        private final String f44712i;

        public a(String id, String text, String str, String str2) {
            Intrinsics.f(id, "id");
            Intrinsics.f(text, "text");
            this.f44709f = id;
            this.f44710g = text;
            this.f44711h = str;
            this.f44712i = str2;
        }

        public final String a() {
            return this.f44712i;
        }

        public final String b() {
            return this.f44709f;
        }

        public final String c() {
            return this.f44711h;
        }

        public final String d() {
            return this.f44710g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(this.f44709f, aVar.f44709f) && Intrinsics.a(this.f44710g, aVar.f44710g) && Intrinsics.a(this.f44711h, aVar.f44711h) && Intrinsics.a(this.f44712i, aVar.f44712i);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((this.f44709f.hashCode() * 31) + this.f44710g.hashCode()) * 31;
            String str = this.f44711h;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f44712i;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            String str = this.f44709f;
            String str2 = this.f44710g;
            String str3 = this.f44711h;
            String str4 = this.f44712i;
            return "Option(id=" + str + ", text=" + str2 + ", subtitle=" + str3 + ", iconUrl=" + str4 + ")";
        }
    }

    public r1(String id, List<a> options, boolean z7, List<String> list) {
        Intrinsics.f(id, "id");
        Intrinsics.f(options, "options");
        this.f44705f = id;
        this.f44706g = options;
        this.f44707h = z7;
        this.f44708i = list;
    }

    @Override // eu.bolt.verification.sdk.internal.ob
    public String a() {
        return this.f44705f;
    }

    public final List<String> b() {
        return this.f44708i;
    }

    public final boolean c() {
        return this.f44707h;
    }

    public final List<a> d() {
        return this.f44706g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r1) {
            r1 r1Var = (r1) obj;
            return Intrinsics.a(a(), r1Var.a()) && Intrinsics.a(this.f44706g, r1Var.f44706g) && this.f44707h == r1Var.f44707h && Intrinsics.a(this.f44708i, r1Var.f44708i);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((a().hashCode() * 31) + this.f44706g.hashCode()) * 31;
        boolean z7 = this.f44707h;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode + i8) * 31;
        List<String> list = this.f44708i;
        return i9 + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        String a8 = a();
        List<a> list = this.f44706g;
        boolean z7 = this.f44707h;
        List<String> list2 = this.f44708i;
        return "CheckBoxGroup(id=" + a8 + ", options=" + list + ", multiselection=" + z7 + ", defaultValuesIds=" + list2 + ")";
    }
}
