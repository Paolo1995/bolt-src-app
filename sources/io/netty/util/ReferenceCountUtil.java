package io.netty.util;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* loaded from: classes5.dex */
public final class ReferenceCountUtil {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ReferenceCountUtil.class);

    static {
        ResourceLeakDetector.addExclusions(ReferenceCountUtil.class, "touch");
    }

    private ReferenceCountUtil() {
    }

    public static boolean release(Object obj) {
        if (obj instanceof ReferenceCounted) {
            return ((ReferenceCounted) obj).release();
        }
        return false;
    }

    public static <T> T retain(T t7) {
        if (t7 instanceof ReferenceCounted) {
            return (T) ((ReferenceCounted) t7).retain();
        }
        return t7;
    }

    public static void safeRelease(Object obj) {
        try {
            release(obj);
        } catch (Throwable th) {
            logger.warn("Failed to release a message: {}", obj, th);
        }
    }

    public static <T> T touch(T t7, Object obj) {
        if (t7 instanceof ReferenceCounted) {
            return (T) ((ReferenceCounted) t7).touch(obj);
        }
        return t7;
    }
}
