package eu.bolt.verification.sdk.internal;

/* loaded from: classes5.dex */
public interface c4 extends j0 {

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ void a(c4 c4Var, boolean z7, int i8, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expand");
            }
            if ((i8 & 1) != 0) {
                z7 = false;
            }
            c4Var.f(z7);
        }

        public static /* synthetic */ void b(c4 c4Var, boolean z7, int i8, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hide");
            }
            if ((i8 & 1) != 0) {
                z7 = false;
            }
            c4Var.c(z7);
        }
    }

    /* loaded from: classes5.dex */
    public enum b {
        WRAP_CONTENT,
        FULL_SCREEN,
        MATCH_PARENT
    }

    void c(boolean z7);

    void d(f7 f7Var);

    void e(wd wdVar);

    void f(boolean z7);
}
