package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class nh implements Serializable {

    /* loaded from: classes5.dex */
    public static final class a extends nh {

        /* renamed from: f  reason: collision with root package name */
        private final String f44330f;

        /* renamed from: g  reason: collision with root package name */
        private final String f44331g;

        /* renamed from: h  reason: collision with root package name */
        private final x6 f44332h;

        /* renamed from: i  reason: collision with root package name */
        private final l1 f44333i;

        /* renamed from: j  reason: collision with root package name */
        private final p9 f44334j;

        /* renamed from: k  reason: collision with root package name */
        private final q1 f44335k;

        /* renamed from: l  reason: collision with root package name */
        private final n1 f44336l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String nextStepId, String str, x6 x6Var, l1 overlay, p9 p9Var, q1 cameraType, n1 theme) {
            super(null);
            Intrinsics.f(nextStepId, "nextStepId");
            Intrinsics.f(overlay, "overlay");
            Intrinsics.f(cameraType, "cameraType");
            Intrinsics.f(theme, "theme");
            this.f44330f = nextStepId;
            this.f44331g = str;
            this.f44332h = x6Var;
            this.f44333i = overlay;
            this.f44334j = p9Var;
            this.f44335k = cameraType;
            this.f44336l = theme;
        }

        public /* synthetic */ a(String str, String str2, x6 x6Var, l1 l1Var, p9 p9Var, q1 q1Var, n1 n1Var, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i8 & 2) != 0 ? null : str2, (i8 & 4) != 0 ? null : x6Var, l1Var, (i8 & 16) != 0 ? null : p9Var, q1Var, n1Var);
        }

        public final q1 a() {
            return this.f44335k;
        }

        public final String b() {
            return this.f44331g;
        }

        public final String c() {
            return this.f44330f;
        }

        public final l1 d() {
            return this.f44333i;
        }

        public final p9 e() {
            return this.f44334j;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(this.f44330f, aVar.f44330f) && Intrinsics.a(this.f44331g, aVar.f44331g) && Intrinsics.a(this.f44332h, aVar.f44332h) && Intrinsics.a(this.f44333i, aVar.f44333i) && Intrinsics.a(this.f44334j, aVar.f44334j) && this.f44335k == aVar.f44335k && this.f44336l == aVar.f44336l;
            }
            return false;
        }

        public final x6 f() {
            return this.f44332h;
        }

        public final n1 g() {
            return this.f44336l;
        }

        public int hashCode() {
            int hashCode = this.f44330f.hashCode() * 31;
            String str = this.f44331g;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            x6 x6Var = this.f44332h;
            int hashCode3 = (((hashCode2 + (x6Var == null ? 0 : x6Var.hashCode())) * 31) + this.f44333i.hashCode()) * 31;
            p9 p9Var = this.f44334j;
            return ((((hashCode3 + (p9Var != null ? p9Var.hashCode() : 0)) * 31) + this.f44335k.hashCode()) * 31) + this.f44336l.hashCode();
        }

        public String toString() {
            String str = this.f44330f;
            String str2 = this.f44331g;
            x6 x6Var = this.f44332h;
            l1 l1Var = this.f44333i;
            p9 p9Var = this.f44334j;
            q1 q1Var = this.f44335k;
            n1 n1Var = this.f44336l;
            return "CameraLayout(nextStepId=" + str + ", descriptionHtml=" + str2 + ", permissionErrorModel=" + x6Var + ", overlay=" + l1Var + ", overlayImage=" + p9Var + ", cameraType=" + q1Var + ", theme=" + n1Var + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends nh {

        /* renamed from: f  reason: collision with root package name */
        private final a f44337f;

        /* renamed from: g  reason: collision with root package name */
        private final List<ob> f44338g;

        /* renamed from: h  reason: collision with root package name */
        private final List<ob> f44339h;

        /* loaded from: classes5.dex */
        public enum a {
            CENTER,
            TOP,
            BOTTOM,
            FILL
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(a alignment, List<? extends ob> mainElements, List<? extends ob> bottomElements) {
            super(null);
            Intrinsics.f(alignment, "alignment");
            Intrinsics.f(mainElements, "mainElements");
            Intrinsics.f(bottomElements, "bottomElements");
            this.f44337f = alignment;
            this.f44338g = mainElements;
            this.f44339h = bottomElements;
        }

        public final a a() {
            return this.f44337f;
        }

        public final List<ob> b() {
            return this.f44339h;
        }

        public final List<ob> c() {
            return this.f44338g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.f44337f == bVar.f44337f && Intrinsics.a(this.f44338g, bVar.f44338g) && Intrinsics.a(this.f44339h, bVar.f44339h);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f44337f.hashCode() * 31) + this.f44338g.hashCode()) * 31) + this.f44339h.hashCode();
        }

        public String toString() {
            a aVar = this.f44337f;
            List<ob> list = this.f44338g;
            List<ob> list2 = this.f44339h;
            return "FormLayout(alignment=" + aVar + ", mainElements=" + list + ", bottomElements=" + list2 + ")";
        }
    }

    private nh() {
    }

    public /* synthetic */ nh(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
