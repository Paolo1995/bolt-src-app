package j$.util;

import j$.util.function.Consumer;
import j$.util.function.Predicate;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/* loaded from: classes2.dex */
public class DesugarCollections {

    /* renamed from: a  reason: collision with root package name */
    public static final Class f50137a;

    /* renamed from: b  reason: collision with root package name */
    static final Class f50138b;

    /* renamed from: c  reason: collision with root package name */
    private static final Field f50139c;

    /* renamed from: d  reason: collision with root package name */
    private static final Field f50140d;

    /* renamed from: e  reason: collision with root package name */
    private static final Constructor f50141e;

    /* renamed from: f  reason: collision with root package name */
    private static final Constructor f50142f;

    static {
        Field field;
        Field field2;
        Constructor<?> constructor;
        Class<?> cls = Collections.synchronizedCollection(new ArrayList()).getClass();
        f50137a = cls;
        f50138b = Collections.synchronizedList(new LinkedList()).getClass();
        Constructor<?> constructor2 = null;
        try {
            field = cls.getDeclaredField("mutex");
        } catch (NoSuchFieldException unused) {
            field = null;
        }
        f50139c = field;
        if (field != null) {
            field.setAccessible(true);
        }
        try {
            field2 = cls.getDeclaredField("c");
        } catch (NoSuchFieldException unused2) {
            field2 = null;
        }
        f50140d = field2;
        if (field2 != null) {
            field2.setAccessible(true);
        }
        try {
            constructor = Collections.synchronizedSet(new HashSet()).getClass().getDeclaredConstructor(Set.class, Object.class);
        } catch (NoSuchMethodException unused3) {
            constructor = null;
        }
        f50142f = constructor;
        if (constructor != null) {
            constructor.setAccessible(true);
        }
        try {
            constructor2 = cls.getDeclaredConstructor(Collection.class, Object.class);
        } catch (NoSuchMethodException unused4) {
        }
        f50141e = constructor2;
        if (constructor2 != null) {
            constructor2.setAccessible(true);
        }
    }

    public static void c(Iterable iterable, Consumer consumer) {
        Field field = f50139c;
        if (field == null) {
            try {
                Collection$EL.a((Collection) f50140d.get(iterable), consumer);
                return;
            } catch (IllegalAccessException e8) {
                throw new Error("Runtime illegal access in synchronized collection forEach fall-back.", e8);
            }
        }
        try {
            synchronized (field.get(iterable)) {
                Collection$EL.a((Collection) f50140d.get(iterable), consumer);
            }
        } catch (IllegalAccessException e9) {
            throw new Error("Runtime illegal access in synchronized collection forEach.", e9);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(Collection collection, Predicate predicate) {
        boolean removeIf;
        Field field = f50139c;
        if (field == null) {
            try {
                return Collection$EL.removeIf((Collection) f50140d.get(collection), predicate);
            } catch (IllegalAccessException e8) {
                throw new Error("Runtime illegal access in synchronized collection removeIf fall-back.", e8);
            }
        }
        try {
            synchronized (field.get(collection)) {
                removeIf = Collection$EL.removeIf((Collection) f50140d.get(collection), predicate);
            }
            return removeIf;
        } catch (IllegalAccessException e9) {
            throw new Error("Runtime illegal access in synchronized collection removeIf.", e9);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(java.util.List list, java.util.Comparator comparator) {
        Field field = f50139c;
        if (field == null) {
            try {
                AbstractC0156n.m((java.util.List) f50140d.get(list), comparator);
                return;
            } catch (IllegalAccessException e8) {
                throw new Error("Runtime illegal access in synchronized collection sort fall-back.", e8);
            }
        }
        try {
            synchronized (field.get(list)) {
                AbstractC0156n.m((java.util.List) f50140d.get(list), comparator);
            }
        } catch (IllegalAccessException e9) {
            throw new Error("Runtime illegal access in synchronized list sort.", e9);
        }
    }

    public static <K, V> java.util.Map<K, V> synchronizedMap(java.util.Map<K, V> map) {
        return new C0112e(map);
    }
}
