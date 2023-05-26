package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: classes.dex */
class ResourcesFlusher {

    /* renamed from: a  reason: collision with root package name */
    private static Field f1269a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f1270b;

    /* renamed from: c  reason: collision with root package name */
    private static Class<?> f1271c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f1272d;

    /* renamed from: e  reason: collision with root package name */
    private static Field f1273e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f1274f;

    /* renamed from: g  reason: collision with root package name */
    private static Field f1275g;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f1276h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api16Impl {
        private Api16Impl() {
        }

        static void a(LongSparseArray longSparseArray) {
            longSparseArray.clear();
        }
    }

    private ResourcesFlusher() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull Resources resources) {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 28) {
            return;
        }
        if (i8 >= 24) {
            d(resources);
        } else if (i8 >= 23) {
            c(resources);
        } else {
            b(resources);
        }
    }

    private static void b(@NonNull Resources resources) {
        if (!f1270b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f1269a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e8) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e8);
            }
            f1270b = true;
        }
        Field field = f1269a;
        if (field != null) {
            Map map = null;
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e9) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e9);
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    private static void c(@NonNull Resources resources) {
        if (!f1270b) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f1269a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e8) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e8);
            }
            f1270b = true;
        }
        Object obj = null;
        Field field = f1269a;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e9) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e9);
            }
        }
        if (obj == null) {
            return;
        }
        e(obj);
    }

    private static void d(@NonNull Resources resources) {
        Object obj;
        if (!f1276h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f1275g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e8) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e8);
            }
            f1276h = true;
        }
        Field field = f1275g;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e9) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e9);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f1270b) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                f1269a = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException e10) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e10);
            }
            f1270b = true;
        }
        Field field2 = f1269a;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e11) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e11);
            }
        }
        if (obj2 != null) {
            e(obj2);
        }
    }

    private static void e(@NonNull Object obj) {
        if (!f1272d) {
            try {
                f1271c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e8) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e8);
            }
            f1272d = true;
        }
        Class<?> cls = f1271c;
        if (cls == null) {
            return;
        }
        if (!f1274f) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f1273e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e9) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e9);
            }
            f1274f = true;
        }
        Field field = f1273e;
        if (field == null) {
            return;
        }
        LongSparseArray longSparseArray = null;
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e10) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e10);
        }
        if (longSparseArray != null) {
            Api16Impl.a(longSparseArray);
        }
    }
}
