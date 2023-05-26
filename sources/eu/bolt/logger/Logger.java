package eu.bolt.logger;

/* compiled from: Logger.kt */
/* loaded from: classes5.dex */
public interface Logger {

    /* compiled from: Logger.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void a(Logger logger, Throwable th, String str, int i8, Object obj) {
            if (obj == null) {
                if ((i8 & 2) != 0) {
                    str = null;
                }
                logger.f(th, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: w");
        }
    }

    void a(Throwable th, String str);

    void b(String str);

    void c(Throwable th);

    void d(String str);

    void e(String str);

    void f(Throwable th, String str);

    void g(Throwable th, String str);

    void h(Throwable th);

    void i(String str);
}
