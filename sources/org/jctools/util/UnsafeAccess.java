package org.jctools.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* loaded from: classes5.dex */
public class UnsafeAccess {
    public static final boolean SUPPORTS_GET_AND_SET;
    public static final Unsafe UNSAFE;

    static {
        Unsafe unsafe;
        boolean z7 = true;
        try {
            try {
                Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
                declaredField.setAccessible(true);
                unsafe = (Unsafe) declaredField.get(null);
            } catch (Exception e8) {
                SUPPORTS_GET_AND_SET = false;
                throw new RuntimeException(e8);
            }
        } catch (Exception unused) {
            Constructor declaredConstructor = Unsafe.class.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            unsafe = (Unsafe) declaredConstructor.newInstance(new Object[0]);
        }
        try {
            Unsafe.class.getMethod("getAndSetObject", Object.class, Long.TYPE, Object.class);
        } catch (Exception unused2) {
            z7 = false;
        }
        UNSAFE = unsafe;
        SUPPORTS_GET_AND_SET = z7;
    }

    public static long fieldOffset(Class cls, String str) throws RuntimeException {
        try {
            return UNSAFE.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e8) {
            throw new RuntimeException(e8);
        }
    }
}
