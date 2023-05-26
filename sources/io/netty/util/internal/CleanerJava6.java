package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class CleanerJava6 implements Cleaner {
    private static final Field CLEANER_FIELD;
    private static final long CLEANER_FIELD_OFFSET;
    private static final Method CLEAN_METHOD;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(CleanerJava6.class);

    static {
        Field field;
        Method method;
        Object doPrivileged;
        Object obj;
        long j8;
        final ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1);
        long j9 = -1;
        Throwable th = null;
        try {
            doPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.util.internal.CleanerJava6.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        Field declaredField = allocateDirect.getClass().getDeclaredField("cleaner");
                        if (!PlatformDependent.hasUnsafe()) {
                            declaredField.setAccessible(true);
                        }
                        return declaredField;
                    } catch (Throwable th2) {
                        return th2;
                    }
                }
            });
        } catch (Throwable th2) {
            field = null;
            method = null;
            th = th2;
        }
        if (!(doPrivileged instanceof Throwable)) {
            field = (Field) doPrivileged;
            if (PlatformDependent.hasUnsafe()) {
                j8 = PlatformDependent0.objectFieldOffset(field);
                obj = PlatformDependent0.getObject(allocateDirect, j8);
            } else {
                obj = field.get(allocateDirect);
                j8 = -1;
            }
            method = obj.getClass().getDeclaredMethod("clean", new Class[0]);
            method.invoke(obj, new Object[0]);
            j9 = j8;
            if (th == null) {
                logger.debug("java.nio.ByteBuffer.cleaner(): available");
            } else {
                logger.debug("java.nio.ByteBuffer.cleaner(): unavailable", th);
            }
            CLEANER_FIELD = field;
            CLEANER_FIELD_OFFSET = j9;
            CLEAN_METHOD = method;
            return;
        }
        throw ((Throwable) doPrivileged);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void freeDirectBuffer0(ByteBuffer byteBuffer) throws Exception {
        Object object;
        long j8 = CLEANER_FIELD_OFFSET;
        if (j8 == -1) {
            object = CLEANER_FIELD.get(byteBuffer);
        } else {
            object = PlatformDependent0.getObject(byteBuffer, j8);
        }
        if (object != null) {
            CLEAN_METHOD.invoke(object, new Object[0]);
        }
    }

    private static void freeDirectBufferPrivileged(final ByteBuffer byteBuffer) {
        Throwable th = (Throwable) AccessController.doPrivileged(new PrivilegedAction<Throwable>() { // from class: io.netty.util.internal.CleanerJava6.2
            @Override // java.security.PrivilegedAction
            public Throwable run() {
                try {
                    CleanerJava6.freeDirectBuffer0(byteBuffer);
                    return null;
                } catch (Throwable th2) {
                    return th2;
                }
            }
        });
        if (th != null) {
            PlatformDependent0.throwException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSupported() {
        if (CLEANER_FIELD_OFFSET == -1 && CLEANER_FIELD == null) {
            return false;
        }
        return true;
    }

    @Override // io.netty.util.internal.Cleaner
    public void freeDirectBuffer(ByteBuffer byteBuffer) {
        if (!byteBuffer.isDirect()) {
            return;
        }
        if (System.getSecurityManager() == null) {
            try {
                freeDirectBuffer0(byteBuffer);
                return;
            } catch (Throwable th) {
                PlatformDependent0.throwException(th);
                return;
            }
        }
        freeDirectBufferPrivileged(byteBuffer);
    }
}
