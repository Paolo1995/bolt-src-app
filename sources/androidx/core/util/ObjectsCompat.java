package androidx.core.util;

import androidx.annotation.NonNull;
import java.util.Objects;

/* loaded from: classes.dex */
public class ObjectsCompat {

    /* loaded from: classes.dex */
    static class Api19Impl {
        private Api19Impl() {
        }

        static boolean a(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }

        static int b(Object... objArr) {
            return Objects.hash(objArr);
        }
    }

    private ObjectsCompat() {
    }

    public static boolean a(Object obj, Object obj2) {
        return Api19Impl.a(obj, obj2);
    }

    public static int b(Object... objArr) {
        return Api19Impl.b(objArr);
    }

    @NonNull
    public static <T> T c(T t7) {
        t7.getClass();
        return t7;
    }

    @NonNull
    public static <T> T d(T t7, @NonNull String str) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(str);
    }

    public static String e(Object obj, String str) {
        if (obj != null) {
            return obj.toString();
        }
        return str;
    }
}
