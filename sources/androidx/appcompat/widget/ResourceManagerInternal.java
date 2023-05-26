package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.resources.Compatibility$Api21Impl;
import androidx.appcompat.resources.R$drawable;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class ResourceManagerInternal {

    /* renamed from: i  reason: collision with root package name */
    private static ResourceManagerInternal f2058i;

    /* renamed from: a  reason: collision with root package name */
    private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> f2060a;

    /* renamed from: b  reason: collision with root package name */
    private SimpleArrayMap<String, InflateDelegate> f2061b;

    /* renamed from: c  reason: collision with root package name */
    private SparseArrayCompat<String> f2062c;

    /* renamed from: d  reason: collision with root package name */
    private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> f2063d = new WeakHashMap<>(0);

    /* renamed from: e  reason: collision with root package name */
    private TypedValue f2064e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2065f;

    /* renamed from: g  reason: collision with root package name */
    private ResourceManagerHooks f2066g;

    /* renamed from: h  reason: collision with root package name */
    private static final PorterDuff.Mode f2057h = PorterDuff.Mode.SRC_IN;

    /* renamed from: j  reason: collision with root package name */
    private static final ColorFilterLruCache f2059j = new ColorFilterLruCache(6);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AsldcInflateDelegate implements InflateDelegate {
        AsldcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedStateListDrawableCompat.m(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e8) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e8);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class AvdcInflateDelegate implements InflateDelegate {
        AvdcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedVectorDrawableCompat.b(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e8) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e8);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int i8) {
            super(i8);
        }

        private static int a(int i8, PorterDuff.Mode mode) {
            return ((i8 + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter b(int i8, PorterDuff.Mode mode) {
            return get(Integer.valueOf(a(i8, mode)));
        }

        PorterDuffColorFilter c(int i8, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return put(Integer.valueOf(a(i8, mode)), porterDuffColorFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class DrawableDelegate implements InflateDelegate {
        DrawableDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) DrawableDelegate.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Compatibility$Api21Impl.c(drawable, context.getResources(), xmlPullParser, attributeSet, theme);
                    return drawable;
                } catch (Exception e8) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e8);
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface InflateDelegate {
        Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, Resources.Theme theme);
    }

    /* loaded from: classes.dex */
    public interface ResourceManagerHooks {
        Drawable a(@NonNull ResourceManagerInternal resourceManagerInternal, @NonNull Context context, int i8);

        ColorStateList b(@NonNull Context context, int i8);

        boolean c(@NonNull Context context, int i8, @NonNull Drawable drawable);

        PorterDuff.Mode d(int i8);

        boolean e(@NonNull Context context, int i8, @NonNull Drawable drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class VdcInflateDelegate implements InflateDelegate {
        VdcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return VectorDrawableCompat.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e8) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e8);
                return null;
            }
        }
    }

    private void a(@NonNull String str, @NonNull InflateDelegate inflateDelegate) {
        if (this.f2061b == null) {
            this.f2061b = new SimpleArrayMap<>();
        }
        this.f2061b.put(str, inflateDelegate);
    }

    private synchronized boolean b(@NonNull Context context, long j8, @NonNull Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.f2063d.get(context);
            if (longSparseArray == null) {
                longSparseArray = new LongSparseArray<>();
                this.f2063d.put(context, longSparseArray);
            }
            longSparseArray.l(j8, new WeakReference<>(constantState));
            return true;
        }
        return false;
    }

    private void c(@NonNull Context context, int i8, @NonNull ColorStateList colorStateList) {
        if (this.f2060a == null) {
            this.f2060a = new WeakHashMap<>();
        }
        SparseArrayCompat<ColorStateList> sparseArrayCompat = this.f2060a.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat = new SparseArrayCompat<>();
            this.f2060a.put(context, sparseArrayCompat);
        }
        sparseArrayCompat.a(i8, colorStateList);
    }

    private void d(@NonNull Context context) {
        if (this.f2065f) {
            return;
        }
        this.f2065f = true;
        Drawable j8 = j(context, R$drawable.f1411a);
        if (j8 != null && q(j8)) {
            return;
        }
        this.f2065f = false;
        throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
    }

    private static long e(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private Drawable f(@NonNull Context context, int i8) {
        Drawable a8;
        if (this.f2064e == null) {
            this.f2064e = new TypedValue();
        }
        TypedValue typedValue = this.f2064e;
        context.getResources().getValue(i8, typedValue, true);
        long e8 = e(typedValue);
        Drawable i9 = i(context, e8);
        if (i9 != null) {
            return i9;
        }
        ResourceManagerHooks resourceManagerHooks = this.f2066g;
        if (resourceManagerHooks == null) {
            a8 = null;
        } else {
            a8 = resourceManagerHooks.a(this, context, i8);
        }
        if (a8 != null) {
            a8.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, e8, a8);
        }
        return a8;
    }

    private static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList != null && mode != null) {
            return l(colorStateList.getColorForState(iArr, 0), mode);
        }
        return null;
    }

    public static synchronized ResourceManagerInternal h() {
        ResourceManagerInternal resourceManagerInternal;
        synchronized (ResourceManagerInternal.class) {
            if (f2058i == null) {
                ResourceManagerInternal resourceManagerInternal2 = new ResourceManagerInternal();
                f2058i = resourceManagerInternal2;
                p(resourceManagerInternal2);
            }
            resourceManagerInternal = f2058i;
        }
        return resourceManagerInternal;
    }

    private synchronized Drawable i(@NonNull Context context, long j8) {
        LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.f2063d.get(context);
        if (longSparseArray == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> f8 = longSparseArray.f(j8);
        if (f8 != null) {
            Drawable.ConstantState constantState = f8.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            longSparseArray.m(j8);
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter l(int i8, PorterDuff.Mode mode) {
        PorterDuffColorFilter b8;
        synchronized (ResourceManagerInternal.class) {
            ColorFilterLruCache colorFilterLruCache = f2059j;
            b8 = colorFilterLruCache.b(i8, mode);
            if (b8 == null) {
                b8 = new PorterDuffColorFilter(i8, mode);
                colorFilterLruCache.c(i8, mode, b8);
            }
        }
        return b8;
    }

    private ColorStateList n(@NonNull Context context, int i8) {
        SparseArrayCompat<ColorStateList> sparseArrayCompat;
        WeakHashMap<Context, SparseArrayCompat<ColorStateList>> weakHashMap = this.f2060a;
        if (weakHashMap == null || (sparseArrayCompat = weakHashMap.get(context)) == null) {
            return null;
        }
        return sparseArrayCompat.e(i8);
    }

    private static void p(@NonNull ResourceManagerInternal resourceManagerInternal) {
        if (Build.VERSION.SDK_INT < 24) {
            resourceManagerInternal.a("vector", new VdcInflateDelegate());
            resourceManagerInternal.a("animated-vector", new AvdcInflateDelegate());
            resourceManagerInternal.a("animated-selector", new AsldcInflateDelegate());
            resourceManagerInternal.a("drawable", new DrawableDelegate());
        }
    }

    private static boolean q(@NonNull Drawable drawable) {
        if (!(drawable instanceof VectorDrawableCompat) && !"android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            return false;
        }
        return true;
    }

    private Drawable r(@NonNull Context context, int i8) {
        int next;
        SimpleArrayMap<String, InflateDelegate> simpleArrayMap = this.f2061b;
        if (simpleArrayMap == null || simpleArrayMap.isEmpty()) {
            return null;
        }
        SparseArrayCompat<String> sparseArrayCompat = this.f2062c;
        if (sparseArrayCompat != null) {
            String e8 = sparseArrayCompat.e(i8);
            if ("appcompat_skip_skip".equals(e8) || (e8 != null && this.f2061b.get(e8) == null)) {
                return null;
            }
        } else {
            this.f2062c = new SparseArrayCompat<>();
        }
        if (this.f2064e == null) {
            this.f2064e = new TypedValue();
        }
        TypedValue typedValue = this.f2064e;
        Resources resources = context.getResources();
        resources.getValue(i8, typedValue, true);
        long e9 = e(typedValue);
        Drawable i9 = i(context, e9);
        if (i9 != null) {
            return i9;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i8);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                while (true) {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                }
                if (next == 2) {
                    String name = xml.getName();
                    this.f2062c.a(i8, name);
                    InflateDelegate inflateDelegate = this.f2061b.get(name);
                    if (inflateDelegate != null) {
                        i9 = inflateDelegate.a(context, xml, asAttributeSet, context.getTheme());
                    }
                    if (i9 != null) {
                        i9.setChangingConfigurations(typedValue.changingConfigurations);
                        b(context, e9, i9);
                    }
                } else {
                    throw new XmlPullParserException("No start tag found");
                }
            } catch (Exception e10) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e10);
            }
        }
        if (i9 == null) {
            this.f2062c.a(i8, "appcompat_skip_skip");
        }
        return i9;
    }

    private Drawable v(@NonNull Context context, int i8, boolean z7, @NonNull Drawable drawable) {
        ColorStateList m8 = m(context, i8);
        if (m8 != null) {
            if (DrawableUtils.a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable r7 = DrawableCompat.r(drawable);
            DrawableCompat.o(r7, m8);
            PorterDuff.Mode o8 = o(i8);
            if (o8 != null) {
                DrawableCompat.p(r7, o8);
                return r7;
            }
            return r7;
        }
        ResourceManagerHooks resourceManagerHooks = this.f2066g;
        if ((resourceManagerHooks == null || !resourceManagerHooks.e(context, i8, drawable)) && !x(context, i8, drawable) && z7) {
            return null;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void w(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        ColorStateList colorStateList;
        PorterDuff.Mode mode;
        boolean z7;
        int[] state = drawable.getState();
        if (DrawableUtils.a(drawable)) {
            if (drawable.mutate() == drawable) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
                return;
            }
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z8 = tintInfo.f2205d;
        if (!z8 && !tintInfo.f2204c) {
            drawable.clearColorFilter();
        } else {
            if (z8) {
                colorStateList = tintInfo.f2202a;
            } else {
                colorStateList = null;
            }
            if (tintInfo.f2204c) {
                mode = tintInfo.f2203b;
            } else {
                mode = f2057h;
            }
            drawable.setColorFilter(g(colorStateList, mode, iArr));
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public synchronized Drawable j(@NonNull Context context, int i8) {
        return k(context, i8, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable k(@NonNull Context context, int i8, boolean z7) {
        Drawable r7;
        d(context);
        r7 = r(context, i8);
        if (r7 == null) {
            r7 = f(context, i8);
        }
        if (r7 == null) {
            r7 = ContextCompat.getDrawable(context, i8);
        }
        if (r7 != null) {
            r7 = v(context, i8, z7, r7);
        }
        if (r7 != null) {
            DrawableUtils.b(r7);
        }
        return r7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList m(@NonNull Context context, int i8) {
        ColorStateList n8;
        n8 = n(context, i8);
        if (n8 == null) {
            ResourceManagerHooks resourceManagerHooks = this.f2066g;
            if (resourceManagerHooks == null) {
                n8 = null;
            } else {
                n8 = resourceManagerHooks.b(context, i8);
            }
            if (n8 != null) {
                c(context, i8, n8);
            }
        }
        return n8;
    }

    PorterDuff.Mode o(int i8) {
        ResourceManagerHooks resourceManagerHooks = this.f2066g;
        if (resourceManagerHooks == null) {
            return null;
        }
        return resourceManagerHooks.d(i8);
    }

    public synchronized void s(@NonNull Context context) {
        LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.f2063d.get(context);
        if (longSparseArray != null) {
            longSparseArray.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable t(@NonNull Context context, @NonNull VectorEnabledTintResources vectorEnabledTintResources, int i8) {
        Drawable r7 = r(context, i8);
        if (r7 == null) {
            r7 = vectorEnabledTintResources.a(i8);
        }
        if (r7 != null) {
            return v(context, i8, false, r7);
        }
        return null;
    }

    public synchronized void u(ResourceManagerHooks resourceManagerHooks) {
        this.f2066g = resourceManagerHooks;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x(@NonNull Context context, int i8, @NonNull Drawable drawable) {
        ResourceManagerHooks resourceManagerHooks = this.f2066g;
        if (resourceManagerHooks != null && resourceManagerHooks.c(context, i8, drawable)) {
            return true;
        }
        return false;
    }
}
