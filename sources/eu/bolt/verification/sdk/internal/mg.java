package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.jc;
import j$.util.Spliterator;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes5.dex */
public interface mg {

    /* loaded from: classes5.dex */
    public static final class a implements Serializable {

        /* renamed from: f  reason: collision with root package name */
        private final boolean f44180f;

        /* renamed from: g  reason: collision with root package name */
        private final int f44181g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f44182h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f44183i;

        /* renamed from: j  reason: collision with root package name */
        private final int f44184j;

        /* renamed from: k  reason: collision with root package name */
        private final Integer f44185k;

        /* renamed from: l  reason: collision with root package name */
        private final jc.a f44186l;

        public a(boolean z7, int i8, boolean z8, boolean z9, int i9, Integer num, jc.a navigationBarConfig) {
            Intrinsics.f(navigationBarConfig, "navigationBarConfig");
            this.f44180f = z7;
            this.f44181g = i8;
            this.f44182h = z8;
            this.f44183i = z9;
            this.f44184j = i9;
            this.f44185k = num;
            this.f44186l = navigationBarConfig;
        }

        public static /* synthetic */ a a(a aVar, boolean z7, int i8, boolean z8, boolean z9, int i9, Integer num, jc.a aVar2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z7 = aVar.f44180f;
            }
            if ((i10 & 2) != 0) {
                i8 = aVar.f44181g;
            }
            int i11 = i8;
            if ((i10 & 4) != 0) {
                z8 = aVar.f44182h;
            }
            boolean z10 = z8;
            if ((i10 & 8) != 0) {
                z9 = aVar.f44183i;
            }
            boolean z11 = z9;
            if ((i10 & 16) != 0) {
                i9 = aVar.f44184j;
            }
            int i12 = i9;
            if ((i10 & 32) != 0) {
                num = aVar.f44185k;
            }
            Integer num2 = num;
            if ((i10 & 64) != 0) {
                aVar2 = aVar.f44186l;
            }
            return aVar.b(z7, i11, z10, z11, i12, num2, aVar2);
        }

        public final a b(boolean z7, int i8, boolean z8, boolean z9, int i9, Integer num, jc.a navigationBarConfig) {
            Intrinsics.f(navigationBarConfig, "navigationBarConfig");
            return new a(z7, i8, z8, z9, i9, num, navigationBarConfig);
        }

        public final boolean c() {
            return this.f44182h;
        }

        public final jc.a d() {
            return this.f44186l;
        }

        public final int e() {
            return this.f44184j;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f44180f == aVar.f44180f && this.f44181g == aVar.f44181g && this.f44182h == aVar.f44182h && this.f44183i == aVar.f44183i && this.f44184j == aVar.f44184j && Intrinsics.a(this.f44185k, aVar.f44185k) && Intrinsics.a(this.f44186l, aVar.f44186l);
            }
            return false;
        }

        public final int f() {
            return this.f44181g;
        }

        public final Integer g() {
            return this.f44185k;
        }

        public final boolean h() {
            return this.f44180f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v15 */
        /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
        public int hashCode() {
            boolean z7 = this.f44180f;
            ?? r02 = z7;
            if (z7) {
                r02 = 1;
            }
            int i8 = ((r02 * 31) + this.f44181g) * 31;
            ?? r22 = this.f44182h;
            int i9 = r22;
            if (r22 != 0) {
                i9 = 1;
            }
            int i10 = (i8 + i9) * 31;
            boolean z8 = this.f44183i;
            int i11 = (((i10 + (z8 ? 1 : z8 ? 1 : 0)) * 31) + this.f44184j) * 31;
            Integer num = this.f44185k;
            return ((i11 + (num == null ? 0 : num.hashCode())) * 31) + this.f44186l.hashCode();
        }

        public final boolean i() {
            return this.f44183i;
        }

        public String toString() {
            boolean z7 = this.f44180f;
            int i8 = this.f44181g;
            boolean z8 = this.f44182h;
            boolean z9 = this.f44183i;
            int i9 = this.f44184j;
            Integer num = this.f44185k;
            jc.a aVar = this.f44186l;
            return "Config(isDrawBehindStatusBar=" + z7 + ", statusBarColor=" + i8 + ", areStatusBarIconsDark=" + z8 + ", isImmersiveStatusBar=" + z9 + ", softInputMode=" + i9 + ", windowBackgroundColor=" + num + ", navigationBarConfig=" + aVar + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        public static /* synthetic */ void a(mg mgVar, int i8, boolean z7, int i9, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setNavigationBarColor");
            }
            if ((i9 & 2) != 0) {
                z7 = !z1.b(i8);
            }
            mgVar.h(i8, z7);
        }
    }

    /* loaded from: classes5.dex */
    public enum c {
        SOFT_INPUT_STATE_UNSPECIFIED(0),
        SOFT_INPUT_STATE_UNCHANGED(1),
        SOFT_INPUT_STATE_HIDDEN(2),
        SOFT_INPUT_STATE_ALWAYS_HIDDEN(3),
        SOFT_INPUT_STATE_VISIBLE(4),
        SOFT_INPUT_STATE_ALWAYS_VISIBLE(5),
        SOFT_INPUT_ADJUST_UNSPECIFIED(0),
        SOFT_INPUT_ADJUST_RESIZE(16),
        SOFT_INPUT_ADJUST_PAN(32),
        SOFT_INPUT_ADJUST_NOTHING(48),
        SOFT_INPUT_IS_FORWARD_NAVIGATION(Spliterator.NONNULL);
        

        /* renamed from: g  reason: collision with root package name */
        public static final a f44187g = new a(null);

        /* renamed from: f  reason: collision with root package name */
        private final int f44200f;

        /* loaded from: classes5.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        c(int i8) {
            this.f44200f = i8;
        }

        public final int c() {
            return this.f44200f;
        }
    }

    void a();

    a b();

    Flow<Integer> c();

    void c(boolean z7);

    void d(Integer num);

    void e(c cVar);

    void f(boolean z7);

    void g(a aVar);

    void h(int i8, boolean z7);

    void i(boolean z7);
}
