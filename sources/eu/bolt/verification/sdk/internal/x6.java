package eu.bolt.verification.sdk.internal;

import androidx.fragment.app.FragmentTransaction;
import j$.util.Spliterator;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class x6 implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final aa f45611f;

    /* renamed from: g  reason: collision with root package name */
    private final cc f45612g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f45613h;

    /* renamed from: i  reason: collision with root package name */
    private final ll f45614i;

    /* renamed from: j  reason: collision with root package name */
    private final u4 f45615j;

    /* renamed from: k  reason: collision with root package name */
    private final ll f45616k;

    /* renamed from: l  reason: collision with root package name */
    private final Integer f45617l;

    /* renamed from: m  reason: collision with root package name */
    private final u4 f45618m;

    /* renamed from: n  reason: collision with root package name */
    private final j6 f45619n;

    /* renamed from: o  reason: collision with root package name */
    private final j6 f45620o;

    /* renamed from: p  reason: collision with root package name */
    private final Integer f45621p;

    /* renamed from: q  reason: collision with root package name */
    private final a f45622q;

    /* renamed from: r  reason: collision with root package name */
    private final z6 f45623r;

    /* renamed from: s  reason: collision with root package name */
    private final a7 f45624s;

    /* loaded from: classes5.dex */
    public static abstract class a implements Serializable {

        /* renamed from: eu.bolt.verification.sdk.internal.x6$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0098a extends a {

            /* renamed from: f  reason: collision with root package name */
            public static final C0098a f45625f = new C0098a();

            private C0098a() {
                super(null);
            }
        }

        /* loaded from: classes5.dex */
        public static final class b extends a {

            /* renamed from: f  reason: collision with root package name */
            private final String f45626f;

            public final String a() {
                return this.f45626f;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && Intrinsics.a(this.f45626f, ((b) obj).f45626f);
            }

            public int hashCode() {
                return this.f45626f.hashCode();
            }

            public String toString() {
                String str = this.f45626f;
                return "Text(message=" + str + ")";
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public x6(aa aaVar, cc ccVar, boolean z7, ll llVar, u4 u4Var, ll llVar2, Integer num, u4 u4Var2, j6 j6Var, j6 j6Var2, Integer num2, a messageForAnalytics, z6 errorTag, a7 a7Var) {
        Intrinsics.f(messageForAnalytics, "messageForAnalytics");
        Intrinsics.f(errorTag, "errorTag");
        this.f45611f = aaVar;
        this.f45612g = ccVar;
        this.f45613h = z7;
        this.f45614i = llVar;
        this.f45615j = u4Var;
        this.f45616k = llVar2;
        this.f45617l = num;
        this.f45618m = u4Var2;
        this.f45619n = j6Var;
        this.f45620o = j6Var2;
        this.f45621p = num2;
        this.f45622q = messageForAnalytics;
        this.f45623r = errorTag;
        this.f45624s = a7Var;
    }

    public /* synthetic */ x6(aa aaVar, cc ccVar, boolean z7, ll llVar, u4 u4Var, ll llVar2, Integer num, u4 u4Var2, j6 j6Var, j6 j6Var2, Integer num2, a aVar, z6 z6Var, a7 a7Var, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? null : aaVar, (i8 & 2) != 0 ? null : ccVar, (i8 & 4) != 0 ? true : z7, (i8 & 8) != 0 ? null : llVar, (i8 & 16) != 0 ? null : u4Var, llVar2, (i8 & 64) != 0 ? null : num, (i8 & 128) != 0 ? null : u4Var2, j6Var, (i8 & 512) != 0 ? null : j6Var2, (i8 & Spliterator.IMMUTABLE) != 0 ? null : num2, (i8 & 2048) != 0 ? a.C0098a.f45625f : aVar, z6Var, (i8 & FragmentTransaction.TRANSIT_EXIT_MASK) != 0 ? null : a7Var);
    }

    public final Integer a() {
        return this.f45621p;
    }

    public final z6 b() {
        return this.f45623r;
    }

    public final j6 c() {
        return this.f45619n;
    }

    public final aa d() {
        return this.f45611f;
    }

    public final cc e() {
        return this.f45612g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x6) {
            x6 x6Var = (x6) obj;
            return Intrinsics.a(this.f45611f, x6Var.f45611f) && Intrinsics.a(this.f45612g, x6Var.f45612g) && this.f45613h == x6Var.f45613h && Intrinsics.a(this.f45614i, x6Var.f45614i) && this.f45615j == x6Var.f45615j && Intrinsics.a(this.f45616k, x6Var.f45616k) && Intrinsics.a(this.f45617l, x6Var.f45617l) && this.f45618m == x6Var.f45618m && Intrinsics.a(this.f45619n, x6Var.f45619n) && Intrinsics.a(this.f45620o, x6Var.f45620o) && Intrinsics.a(this.f45621p, x6Var.f45621p) && Intrinsics.a(this.f45622q, x6Var.f45622q) && Intrinsics.a(this.f45623r, x6Var.f45623r) && this.f45624s == x6Var.f45624s;
        }
        return false;
    }

    public final ll f() {
        return this.f45616k;
    }

    public final u4 g() {
        return this.f45618m;
    }

    public final a h() {
        return this.f45622q;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        aa aaVar = this.f45611f;
        int hashCode = (aaVar == null ? 0 : aaVar.hashCode()) * 31;
        cc ccVar = this.f45612g;
        int hashCode2 = (hashCode + (ccVar == null ? 0 : ccVar.hashCode())) * 31;
        boolean z7 = this.f45613h;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode2 + i8) * 31;
        ll llVar = this.f45614i;
        int hashCode3 = (i9 + (llVar == null ? 0 : llVar.hashCode())) * 31;
        u4 u4Var = this.f45615j;
        int hashCode4 = (hashCode3 + (u4Var == null ? 0 : u4Var.hashCode())) * 31;
        ll llVar2 = this.f45616k;
        int hashCode5 = (hashCode4 + (llVar2 == null ? 0 : llVar2.hashCode())) * 31;
        Integer num = this.f45617l;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        u4 u4Var2 = this.f45618m;
        int hashCode7 = (hashCode6 + (u4Var2 == null ? 0 : u4Var2.hashCode())) * 31;
        j6 j6Var = this.f45619n;
        int hashCode8 = (hashCode7 + (j6Var == null ? 0 : j6Var.hashCode())) * 31;
        j6 j6Var2 = this.f45620o;
        int hashCode9 = (hashCode8 + (j6Var2 == null ? 0 : j6Var2.hashCode())) * 31;
        Integer num2 = this.f45621p;
        int hashCode10 = (((((hashCode9 + (num2 == null ? 0 : num2.hashCode())) * 31) + this.f45622q.hashCode()) * 31) + this.f45623r.hashCode()) * 31;
        a7 a7Var = this.f45624s;
        return hashCode10 + (a7Var != null ? a7Var.hashCode() : 0);
    }

    public final Integer i() {
        return this.f45617l;
    }

    public final j6 j() {
        return this.f45620o;
    }

    public final ll k() {
        return this.f45614i;
    }

    public final u4 l() {
        return this.f45615j;
    }

    public final boolean m() {
        return this.f45613h;
    }

    public String toString() {
        aa aaVar = this.f45611f;
        cc ccVar = this.f45612g;
        boolean z7 = this.f45613h;
        ll llVar = this.f45614i;
        u4 u4Var = this.f45615j;
        ll llVar2 = this.f45616k;
        Integer num = this.f45617l;
        u4 u4Var2 = this.f45618m;
        j6 j6Var = this.f45619n;
        j6 j6Var2 = this.f45620o;
        Integer num2 = this.f45621p;
        a aVar = this.f45622q;
        z6 z6Var = this.f45623r;
        a7 a7Var = this.f45624s;
        return "ErrorMessageModel(image=" + aaVar + ", imageMargins=" + ccVar + ", useDefaultImage=" + z7 + ", title=" + llVar + ", titleFontStyle=" + u4Var + ", message=" + llVar2 + ", messageTextColor=" + num + ", messageFontStyle=" + u4Var2 + ", firstActionButton=" + j6Var + ", secondActionButton=" + j6Var2 + ", errorCode=" + num2 + ", messageForAnalytics=" + aVar + ", errorTag=" + z6Var + ", uiType=" + a7Var + ")";
    }
}
