package io.netty.util.internal;

import java.lang.reflect.AccessibleObject;

/* loaded from: classes5.dex */
public final class ReflectionUtil {
    private ReflectionUtil() {
    }

    private static RuntimeException handleInaccessibleObjectException(RuntimeException runtimeException) {
        if ("java.lang.reflect.InaccessibleObjectException".equals(runtimeException.getClass().getName())) {
            return runtimeException;
        }
        throw runtimeException;
    }

    public static Throwable trySetAccessible(AccessibleObject accessibleObject, boolean z7) {
        if (z7 && !PlatformDependent0.isExplicitTryReflectionSetAccessible()) {
            return new UnsupportedOperationException("Reflective setAccessible(true) disabled");
        }
        try {
            accessibleObject.setAccessible(true);
            return null;
        } catch (SecurityException e8) {
            return e8;
        } catch (RuntimeException e9) {
            return handleInaccessibleObjectException(e9);
        }
    }
}
