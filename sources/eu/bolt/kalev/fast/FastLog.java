package eu.bolt.kalev.fast;

/* compiled from: FastLog.kt */
/* loaded from: classes5.dex */
public interface FastLog {

    /* compiled from: FastLog.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void a(FastLog fastLog, String str, String str2, int i8, Object obj) {
            if (obj == null) {
                if ((i8 & 2) != 0) {
                    str2 = null;
                }
                fastLog.d(str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: d");
        }

        public static /* synthetic */ void b(FastLog fastLog, String str, String str2, int i8, Object obj) {
            if (obj == null) {
                if ((i8 & 2) != 0) {
                    str2 = null;
                }
                fastLog.i(str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: i");
        }

        public static /* synthetic */ void c(FastLog fastLog, String str, String str2, int i8, Object obj) {
            if (obj == null) {
                if ((i8 & 2) != 0) {
                    str2 = null;
                }
                fastLog.v(str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: v");
        }
    }

    void d(String str, String str2);

    void i(String str, String str2);

    void v(String str, String str2);
}
