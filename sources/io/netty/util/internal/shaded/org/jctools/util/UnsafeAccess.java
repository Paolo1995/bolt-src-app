package io.netty.util.internal.shaded.org.jctools.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* loaded from: classes5.dex */
public class UnsafeAccess {
    public static final Unsafe UNSAFE = getUnsafe();
    public static final boolean SUPPORTS_GET_AND_SET_REF = hasGetAndSetSupport();
    public static final boolean SUPPORTS_GET_AND_ADD_LONG = hasGetAndAddLongSupport();

    public static long fieldOffset(Class cls, String str) throws RuntimeException {
        try {
            return UNSAFE.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e8) {
            throw new RuntimeException(e8);
        }
    }

    private static Unsafe getUnsafe() {
        try {
            try {
                Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
                declaredField.setAccessible(true);
                return (Unsafe) declaredField.get(null);
            } catch (Exception unused) {
                Constructor declaredConstructor = Unsafe.class.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                return (Unsafe) declaredConstructor.newInstance(new Object[0]);
            }
        } catch (Exception e8) {
            throw new RuntimeException(e8);
        }
    }

    private static boolean hasGetAndAddLongSupport() {
        try {
            Class cls = Long.TYPE;
            Unsafe.class.getMethod("getAndAddLong", Object.class, cls, cls);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean hasGetAndSetSupport() {
        try {
            Unsafe.class.getMethod("getAndSetObject", Object.class, Long.TYPE, Object.class);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
