package io.reactivex.internal.functions;

import io.reactivex.functions.BiPredicate;

/* loaded from: classes5.dex */
public final class ObjectHelper {

    /* renamed from: a  reason: collision with root package name */
    static final BiPredicate<Object, Object> f47659a = new BiObjectPredicate();

    /* loaded from: classes5.dex */
    static final class BiObjectPredicate implements BiPredicate<Object, Object> {
        BiObjectPredicate() {
        }

        @Override // io.reactivex.functions.BiPredicate
        public boolean test(Object obj, Object obj2) {
            return ObjectHelper.c(obj, obj2);
        }
    }

    private ObjectHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static int a(int i8, int i9) {
        if (i8 < i9) {
            return -1;
        }
        return i8 > i9 ? 1 : 0;
    }

    public static int b(long j8, long j9) {
        int i8 = (j8 > j9 ? 1 : (j8 == j9 ? 0 : -1));
        if (i8 < 0) {
            return -1;
        }
        return i8 > 0 ? 1 : 0;
    }

    public static boolean c(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public static <T> BiPredicate<T, T> d() {
        return (BiPredicate<T, T>) f47659a;
    }

    public static <T> T e(T t7, String str) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(str);
    }

    public static int f(int i8, String str) {
        if (i8 > 0) {
            return i8;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i8);
    }

    public static long g(long j8, String str) {
        if (j8 > 0) {
            return j8;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + j8);
    }
}
