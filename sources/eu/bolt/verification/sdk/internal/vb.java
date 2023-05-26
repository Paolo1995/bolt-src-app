package eu.bolt.verification.sdk.internal;

/* loaded from: classes5.dex */
public interface vb {

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f45442a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f45443b;

        public a(boolean z7, boolean z8) {
            this.f45442a = z7;
            this.f45443b = z8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f45442a == aVar.f45442a && this.f45443b == aVar.f45443b;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z7 = this.f45442a;
            ?? r02 = z7;
            if (z7) {
                r02 = 1;
            }
            int i8 = r02 * 31;
            boolean z8 = this.f45443b;
            return i8 + (z8 ? 1 : z8 ? 1 : 0);
        }

        public String toString() {
            boolean z7 = this.f45442a;
            boolean z8 = this.f45443b;
            return "PermissionState(isGranted=" + z7 + ", isPrecisionGranted=" + z8 + ")";
        }
    }

    void a();

    void f(boolean z7);
}
