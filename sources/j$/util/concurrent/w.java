package j$.util.concurrent;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
abstract class w {

    /* renamed from: a  reason: collision with root package name */
    private static final Unsafe f50251a;

    static {
        Field b8 = b();
        b8.setAccessible(true);
        try {
            f50251a = (Unsafe) b8.get(null);
        } catch (IllegalAccessException e8) {
            throw new Error("Couldn't get the Unsafe", e8);
        }
    }

    public static final int a(Unsafe unsafe, Object obj, long j8) {
        int intVolatile;
        do {
            intVolatile = unsafe.getIntVolatile(obj, j8);
        } while (!unsafe.compareAndSwapInt(obj, j8, intVolatile, intVolatile - 4));
        return intVolatile;
    }

    private static Field b() {
        Field[] declaredFields;
        try {
            return Unsafe.class.getDeclaredField("theUnsafe");
        } catch (NoSuchFieldException e8) {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) && Unsafe.class.isAssignableFrom(field.getType())) {
                    return field;
                }
            }
            throw new Error("Couldn't find the Unsafe", e8);
        }
    }

    public static Unsafe c() {
        return f50251a;
    }
}
