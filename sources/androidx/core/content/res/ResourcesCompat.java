package androidx.core.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class ResourcesCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f5709a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> f5710b = new WeakHashMap<>(0);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f5711c = new Object();

    /* loaded from: classes.dex */
    static class Api21Impl {
        private Api21Impl() {
        }

        static Drawable a(Resources resources, int i8, Resources.Theme theme) {
            return resources.getDrawable(i8, theme);
        }

        static Drawable b(Resources resources, int i8, int i9, Resources.Theme theme) {
            return resources.getDrawableForDensity(i8, i9, theme);
        }
    }

    /* loaded from: classes.dex */
    static class Api23Impl {
        private Api23Impl() {
        }

        static int a(Resources resources, int i8, Resources.Theme theme) {
            int color;
            color = resources.getColor(i8, theme);
            return color;
        }

        @NonNull
        static ColorStateList b(@NonNull Resources resources, int i8, Resources.Theme theme) {
            ColorStateList colorStateList;
            colorStateList = resources.getColorStateList(i8, theme);
            return colorStateList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ColorStateListCacheEntry {

        /* renamed from: a  reason: collision with root package name */
        final ColorStateList f5712a;

        /* renamed from: b  reason: collision with root package name */
        final Configuration f5713b;

        /* renamed from: c  reason: collision with root package name */
        final int f5714c;

        ColorStateListCacheEntry(@NonNull ColorStateList colorStateList, @NonNull Configuration configuration, Resources.Theme theme) {
            int hashCode;
            this.f5712a = colorStateList;
            this.f5713b = configuration;
            if (theme == null) {
                hashCode = 0;
            } else {
                hashCode = theme.hashCode();
            }
            this.f5714c = hashCode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class ColorStateListCacheKey {

        /* renamed from: a  reason: collision with root package name */
        final Resources f5715a;

        /* renamed from: b  reason: collision with root package name */
        final Resources.Theme f5716b;

        ColorStateListCacheKey(@NonNull Resources resources, Resources.Theme theme) {
            this.f5715a = resources;
            this.f5716b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ColorStateListCacheKey.class != obj.getClass()) {
                return false;
            }
            ColorStateListCacheKey colorStateListCacheKey = (ColorStateListCacheKey) obj;
            if (this.f5715a.equals(colorStateListCacheKey.f5715a) && ObjectsCompat.a(this.f5716b, colorStateListCacheKey.f5716b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.b(this.f5715a, this.f5716b);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class FontCallback {
        @NonNull
        public static Handler e(Handler handler) {
            if (handler == null) {
                return new Handler(Looper.getMainLooper());
            }
            return handler;
        }

        public final void c(final int i8, Handler handler) {
            e(handler).post(new Runnable() { // from class: androidx.core.content.res.d
                @Override // java.lang.Runnable
                public final void run() {
                    ResourcesCompat.FontCallback.this.f(i8);
                }
            });
        }

        public final void d(@NonNull final Typeface typeface, Handler handler) {
            e(handler).post(new Runnable() { // from class: androidx.core.content.res.c
                @Override // java.lang.Runnable
                public final void run() {
                    ResourcesCompat.FontCallback.this.g(typeface);
                }
            });
        }

        /* renamed from: h */
        public abstract void f(int i8);

        /* renamed from: i */
        public abstract void g(@NonNull Typeface typeface);
    }

    /* loaded from: classes.dex */
    public static final class ThemeCompat {

        /* loaded from: classes.dex */
        static class Api23Impl {

            /* renamed from: a  reason: collision with root package name */
            private static final Object f5717a = new Object();

            /* renamed from: b  reason: collision with root package name */
            private static Method f5718b;

            /* renamed from: c  reason: collision with root package name */
            private static boolean f5719c;

            private Api23Impl() {
            }

            @SuppressLint({"BanUncheckedReflection"})
            static void a(@NonNull Resources.Theme theme) {
                synchronized (f5717a) {
                    if (!f5719c) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            f5718b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e8) {
                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e8);
                        }
                        f5719c = true;
                    }
                    Method method = f5718b;
                    if (method != null) {
                        try {
                            method.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException e9) {
                            Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e9);
                            f5718b = null;
                        }
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        static class Api29Impl {
            private Api29Impl() {
            }

            static void a(@NonNull Resources.Theme theme) {
                theme.rebase();
            }
        }

        private ThemeCompat() {
        }

        public static void a(@NonNull Resources.Theme theme) {
            int i8 = Build.VERSION.SDK_INT;
            if (i8 >= 29) {
                Api29Impl.a(theme);
            } else if (i8 >= 23) {
                Api23Impl.a(theme);
            }
        }
    }

    private ResourcesCompat() {
    }

    private static void a(@NonNull ColorStateListCacheKey colorStateListCacheKey, int i8, @NonNull ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f5711c) {
            WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> weakHashMap = f5710b;
            SparseArray<ColorStateListCacheEntry> sparseArray = weakHashMap.get(colorStateListCacheKey);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(colorStateListCacheKey, sparseArray);
            }
            sparseArray.append(i8, new ColorStateListCacheEntry(colorStateList, colorStateListCacheKey.f5715a.getConfiguration(), theme));
        }
    }

    private static ColorStateList b(@NonNull ColorStateListCacheKey colorStateListCacheKey, int i8) {
        ColorStateListCacheEntry colorStateListCacheEntry;
        Resources.Theme theme;
        synchronized (f5711c) {
            SparseArray<ColorStateListCacheEntry> sparseArray = f5710b.get(colorStateListCacheKey);
            if (sparseArray != null && sparseArray.size() > 0 && (colorStateListCacheEntry = sparseArray.get(i8)) != null) {
                if (colorStateListCacheEntry.f5713b.equals(colorStateListCacheKey.f5715a.getConfiguration()) && (((theme = colorStateListCacheKey.f5716b) == null && colorStateListCacheEntry.f5714c == 0) || (theme != null && colorStateListCacheEntry.f5714c == theme.hashCode()))) {
                    return colorStateListCacheEntry.f5712a;
                }
                sparseArray.remove(i8);
            }
            return null;
        }
    }

    public static Typeface c(@NonNull Context context, int i8) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i8, new TypedValue(), 0, null, null, false, true);
    }

    public static int d(@NonNull Resources resources, int i8, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.a(resources, i8, theme);
        }
        return resources.getColor(i8);
    }

    public static ColorStateList e(@NonNull Resources resources, int i8, Resources.Theme theme) throws Resources.NotFoundException {
        ColorStateListCacheKey colorStateListCacheKey = new ColorStateListCacheKey(resources, theme);
        ColorStateList b8 = b(colorStateListCacheKey, i8);
        if (b8 != null) {
            return b8;
        }
        ColorStateList l8 = l(resources, i8, theme);
        if (l8 != null) {
            a(colorStateListCacheKey, i8, l8, theme);
            return l8;
        } else if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.b(resources, i8, theme);
        } else {
            return resources.getColorStateList(i8);
        }
    }

    public static Drawable f(@NonNull Resources resources, int i8, Resources.Theme theme) throws Resources.NotFoundException {
        return Api21Impl.a(resources, i8, theme);
    }

    public static Drawable g(@NonNull Resources resources, int i8, int i9, Resources.Theme theme) throws Resources.NotFoundException {
        return Api21Impl.b(resources, i8, i9, theme);
    }

    public static Typeface h(@NonNull Context context, int i8) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i8, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface i(@NonNull Context context, int i8, @NonNull TypedValue typedValue, int i9, FontCallback fontCallback) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i8, typedValue, i9, fontCallback, null, true, false);
    }

    public static void j(@NonNull Context context, int i8, @NonNull FontCallback fontCallback, Handler handler) throws Resources.NotFoundException {
        Preconditions.g(fontCallback);
        if (context.isRestricted()) {
            fontCallback.c(-4, handler);
        } else {
            n(context, i8, new TypedValue(), 0, fontCallback, handler, false, false);
        }
    }

    @NonNull
    private static TypedValue k() {
        ThreadLocal<TypedValue> threadLocal = f5709a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    private static ColorStateList l(Resources resources, int i8, Resources.Theme theme) {
        if (m(resources, i8)) {
            return null;
        }
        try {
            return ColorStateListInflaterCompat.a(resources, resources.getXml(i8), theme);
        } catch (Exception e8) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e8);
            return null;
        }
    }

    private static boolean m(@NonNull Resources resources, int i8) {
        TypedValue k8 = k();
        resources.getValue(i8, k8, true);
        int i9 = k8.type;
        if (i9 >= 28 && i9 <= 31) {
            return true;
        }
        return false;
    }

    private static Typeface n(@NonNull Context context, int i8, @NonNull TypedValue typedValue, int i9, FontCallback fontCallback, Handler handler, boolean z7, boolean z8) {
        Resources resources = context.getResources();
        resources.getValue(i8, typedValue, true);
        Typeface o8 = o(context, resources, typedValue, i8, i9, fontCallback, handler, z7, z8);
        if (o8 == null && fontCallback == null && !z8) {
            throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i8) + " could not be retrieved.");
        }
        return o8;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Typeface o(@androidx.annotation.NonNull android.content.Context r17, android.content.res.Resources r18, @androidx.annotation.NonNull android.util.TypedValue r19, int r20, int r21, androidx.core.content.res.ResourcesCompat.FontCallback r22, android.os.Handler r23, boolean r24, boolean r25) {
        /*
            r0 = r18
            r1 = r19
            r4 = r20
            r11 = r22
            r12 = r23
            java.lang.String r13 = "ResourcesCompat"
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto Lbb
            java.lang.String r14 = r2.toString()
            java.lang.String r2 = "res/"
            boolean r2 = r14.startsWith(r2)
            r15 = -3
            r16 = 0
            if (r2 != 0) goto L25
            if (r11 == 0) goto L24
            r11.c(r15, r12)
        L24:
            return r16
        L25:
            int r2 = r1.assetCookie
            r7 = r21
            android.graphics.Typeface r2 = androidx.core.graphics.TypefaceCompat.f(r0, r4, r14, r2, r7)
            if (r2 == 0) goto L35
            if (r11 == 0) goto L34
            r11.d(r2, r12)
        L34:
            return r2
        L35:
            if (r25 == 0) goto L38
            return r16
        L38:
            java.lang.String r2 = r14.toLowerCase()     // Catch: java.io.IOException -> L8a org.xmlpull.v1.XmlPullParserException -> La0
            java.lang.String r3 = ".xml"
            boolean r2 = r2.endsWith(r3)     // Catch: java.io.IOException -> L8a org.xmlpull.v1.XmlPullParserException -> La0
            if (r2 == 0) goto L6f
            android.content.res.XmlResourceParser r2 = r0.getXml(r4)     // Catch: java.io.IOException -> L8a org.xmlpull.v1.XmlPullParserException -> La0
            androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry r2 = androidx.core.content.res.FontResourcesParserCompat.b(r2, r0)     // Catch: java.io.IOException -> L8a org.xmlpull.v1.XmlPullParserException -> La0
            if (r2 != 0) goto L59
            java.lang.String r0 = "Failed to find font-family tag"
            android.util.Log.e(r13, r0)     // Catch: java.io.IOException -> L8a org.xmlpull.v1.XmlPullParserException -> La0
            if (r11 == 0) goto L58
            r11.c(r15, r12)     // Catch: java.io.IOException -> L8a org.xmlpull.v1.XmlPullParserException -> La0
        L58:
            return r16
        L59:
            int r6 = r1.assetCookie     // Catch: java.io.IOException -> L8a org.xmlpull.v1.XmlPullParserException -> La0
            r1 = r17
            r3 = r18
            r4 = r20
            r5 = r14
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            android.graphics.Typeface r0 = androidx.core.graphics.TypefaceCompat.c(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.io.IOException -> L8a org.xmlpull.v1.XmlPullParserException -> La0
            return r0
        L6f:
            int r5 = r1.assetCookie     // Catch: java.io.IOException -> L8a org.xmlpull.v1.XmlPullParserException -> La0
            r1 = r17
            r2 = r18
            r3 = r20
            r4 = r14
            r6 = r21
            android.graphics.Typeface r0 = androidx.core.graphics.TypefaceCompat.d(r1, r2, r3, r4, r5, r6)     // Catch: java.io.IOException -> L8a org.xmlpull.v1.XmlPullParserException -> La0
            if (r11 == 0) goto L89
            if (r0 == 0) goto L86
            r11.d(r0, r12)     // Catch: java.io.IOException -> L8a org.xmlpull.v1.XmlPullParserException -> La0
            goto L89
        L86:
            r11.c(r15, r12)     // Catch: java.io.IOException -> L8a org.xmlpull.v1.XmlPullParserException -> La0
        L89:
            return r0
        L8a:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to read xml resource "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r13, r1, r0)
            goto Lb5
        La0:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to parse xml resource "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r13, r1, r0)
        Lb5:
            if (r11 == 0) goto Lba
            r11.c(r15, r12)
        Lba:
            return r16
        Lbb:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Resource \""
            r3.append(r5)
            java.lang.String r0 = r0.getResourceName(r4)
            r3.append(r0)
            java.lang.String r0 = "\" ("
            r3.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r20)
            r3.append(r0)
            java.lang.String r0 = ") is not a Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.o(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.res.ResourcesCompat$FontCallback, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
