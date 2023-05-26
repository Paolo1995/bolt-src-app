package eu.bolt.driver.core.util;

import eu.bolt.kalev.Kalev;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReflectionUtils.kt */
/* loaded from: classes5.dex */
public final class ReflectionUtilsKt {
    public static final Field a(Class<?> clazz, String fieldName) {
        Intrinsics.f(clazz, "clazz");
        Intrinsics.f(fieldName, "fieldName");
        try {
            Field declaredField = clazz.getDeclaredField(fieldName);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    public static final Method b(Class<?> clazz, String methodName) {
        Intrinsics.f(clazz, "clazz");
        Intrinsics.f(methodName, "methodName");
        Method[] methods = clazz.getMethods();
        Intrinsics.e(methods, "methods");
        for (Method method : methods) {
            if (Intrinsics.a(method.getName(), methodName)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    public static final Object c(Field field, Object obj) {
        Intrinsics.f(field, "field");
        try {
            return field.get(obj);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public static final void d(Object obj, Method method, Object... args) {
        Intrinsics.f(args, "args");
        if (method == null) {
            return;
        }
        try {
            method.invoke(obj, Arrays.copyOf(args, args.length));
        } catch (IllegalAccessException e8) {
            Kalev.e(e8, "Can't invoke method using reflection");
        } catch (InvocationTargetException e9) {
            Kalev.e(e9, "Can't invoke method using reflection");
        }
    }

    public static final void e(Field field, Object obj, Object obj2) {
        Intrinsics.f(field, "field");
        try {
            field.set(obj, obj2);
        } catch (IllegalAccessException unused) {
        }
    }
}
