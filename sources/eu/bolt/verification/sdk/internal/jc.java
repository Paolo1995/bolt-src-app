package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes5.dex */
public interface jc {

    /* loaded from: classes5.dex */
    public static final class a implements Serializable {

        /* renamed from: f  reason: collision with root package name */
        private final boolean f43685f;

        /* renamed from: g  reason: collision with root package name */
        private final int f43686g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f43687h;

        /* renamed from: i  reason: collision with root package name */
        private final int f43688i;

        public a(boolean z7, int i8, boolean z8, int i9) {
            this.f43685f = z7;
            this.f43686g = i8;
            this.f43687h = z8;
            this.f43688i = i9;
        }

        public static /* synthetic */ a a(a aVar, boolean z7, int i8, boolean z8, int i9, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z7 = aVar.f43685f;
            }
            if ((i10 & 2) != 0) {
                i8 = aVar.f43686g;
            }
            if ((i10 & 4) != 0) {
                z8 = aVar.f43687h;
            }
            if ((i10 & 8) != 0) {
                i9 = aVar.f43688i;
            }
            return aVar.b(z7, i8, z8, i9);
        }

        public final a b(boolean z7, int i8, boolean z8, int i9) {
            return new a(z7, i8, z8, i9);
        }

        public final boolean c() {
            return this.f43687h;
        }

        public final int d() {
            return this.f43686g;
        }

        public final int e() {
            return this.f43688i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f43685f == aVar.f43685f && this.f43686g == aVar.f43686g && this.f43687h == aVar.f43687h && this.f43688i == aVar.f43688i;
            }
            return false;
        }

        public final boolean f() {
            return this.f43685f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public int hashCode() {
            boolean z7 = this.f43685f;
            ?? r02 = z7;
            if (z7) {
                r02 = 1;
            }
            int i8 = ((r02 * 31) + this.f43686g) * 31;
            boolean z8 = this.f43687h;
            return ((i8 + (z8 ? 1 : z8 ? 1 : 0)) * 31) + this.f43688i;
        }

        public String toString() {
            boolean z7 = this.f43685f;
            int i8 = this.f43686g;
            boolean z8 = this.f43687h;
            int i9 = this.f43688i;
            return "Config(isTransparentNavigationBar=" + z7 + ", navigationBarColor=" + i8 + ", areIconsDark=" + z8 + ", navigationBarHeight=" + i9 + ")";
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        c a();
    }

    /* loaded from: classes5.dex */
    public interface c {
    }

    void a();

    Flow<Integer> b();

    int c();

    a d();

    int e();

    boolean g();

    void h(int i8, boolean z7);

    void i(a aVar);
}
