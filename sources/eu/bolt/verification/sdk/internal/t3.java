package eu.bolt.verification.sdk.internal;

import eu.bolt.logger.Logger;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class t3 {
    public static final void a(String message) {
        Intrinsics.f(message, "message");
        c(message, null, 2, null);
    }

    public static final void b(String message, Logger logger) {
        Intrinsics.f(message, "message");
        Intrinsics.f(logger, "logger");
        logger.c(new RuntimeException(message));
    }

    public static /* synthetic */ void c(String str, Logger logger, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            logger = new zb(null, 1, null);
        }
        b(str, logger);
    }

    public static final void d(Throwable error, String message) {
        Intrinsics.f(error, "error");
        Intrinsics.f(message, "message");
        f(error, message, null, 4, null);
    }

    public static final void e(Throwable error, String message, Logger logger) {
        Intrinsics.f(error, "error");
        Intrinsics.f(message, "message");
        Intrinsics.f(logger, "logger");
        logger.c(error);
    }

    public static /* synthetic */ void f(Throwable th, String str, Logger logger, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str = "";
        }
        if ((i8 & 4) != 0) {
            logger = new zb(null, 1, null);
        }
        e(th, str, logger);
    }
}
