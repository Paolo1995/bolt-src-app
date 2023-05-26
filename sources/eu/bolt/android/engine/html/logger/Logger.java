package eu.bolt.android.engine.html.logger;

/* compiled from: Logger.kt */
/* loaded from: classes5.dex */
public interface Logger {

    /* compiled from: Logger.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void a(Logger logger, String str, Throwable th, int i8, Object obj) {
            if (obj == null) {
                if ((i8 & 2) != 0) {
                    th = null;
                }
                logger.a(str, th);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: e");
        }
    }

    void a(String str, Throwable th);
}
