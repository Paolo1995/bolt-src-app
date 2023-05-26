package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.graphics.ColorUtils;

/* loaded from: classes.dex */
public final class AppCompatDrawableManager {

    /* renamed from: b  reason: collision with root package name */
    private static final PorterDuff.Mode f1842b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    private static AppCompatDrawableManager f1843c;

    /* renamed from: a  reason: collision with root package name */
    private ResourceManagerInternal f1844a;

    public static synchronized AppCompatDrawableManager b() {
        AppCompatDrawableManager appCompatDrawableManager;
        synchronized (AppCompatDrawableManager.class) {
            if (f1843c == null) {
                h();
            }
            appCompatDrawableManager = f1843c;
        }
        return appCompatDrawableManager;
    }

    public static synchronized PorterDuffColorFilter e(int i8, PorterDuff.Mode mode) {
        PorterDuffColorFilter l8;
        synchronized (AppCompatDrawableManager.class) {
            l8 = ResourceManagerInternal.l(i8, mode);
        }
        return l8;
    }

    public static synchronized void h() {
        synchronized (AppCompatDrawableManager.class) {
            if (f1843c == null) {
                AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
                f1843c = appCompatDrawableManager;
                appCompatDrawableManager.f1844a = ResourceManagerInternal.h();
                f1843c.f1844a.u(new ResourceManagerInternal.ResourceManagerHooks() { // from class: androidx.appcompat.widget.AppCompatDrawableManager.1

                    /* renamed from: a  reason: collision with root package name */
                    private final int[] f1845a = {R$drawable.R, R$drawable.P, R$drawable.f865a};

                    /* renamed from: b  reason: collision with root package name */
                    private final int[] f1846b = {R$drawable.f879o, R$drawable.B, R$drawable.f884t, R$drawable.f880p, R$drawable.f881q, R$drawable.f883s, R$drawable.f882r};

                    /* renamed from: c  reason: collision with root package name */
                    private final int[] f1847c = {R$drawable.O, R$drawable.Q, R$drawable.f875k, R$drawable.K, R$drawable.L, R$drawable.M, R$drawable.N};

                    /* renamed from: d  reason: collision with root package name */
                    private final int[] f1848d = {R$drawable.f887w, R$drawable.f873i, R$drawable.f886v};

                    /* renamed from: e  reason: collision with root package name */
                    private final int[] f1849e = {R$drawable.J, R$drawable.S};

                    /* renamed from: f  reason: collision with root package name */
                    private final int[] f1850f = {R$drawable.f867c, R$drawable.f871g, R$drawable.f868d, R$drawable.f872h};

                    private boolean f(int[] iArr, int i8) {
                        for (int i9 : iArr) {
                            if (i9 == i8) {
                                return true;
                            }
                        }
                        return false;
                    }

                    private ColorStateList g(@NonNull Context context) {
                        return h(context, 0);
                    }

                    private ColorStateList h(@NonNull Context context, int i8) {
                        int c8 = ThemeUtils.c(context, R$attr.f837w);
                        return new ColorStateList(new int[][]{ThemeUtils.f2189b, ThemeUtils.f2192e, ThemeUtils.f2190c, ThemeUtils.f2196i}, new int[]{ThemeUtils.b(context, R$attr.f835u), ColorUtils.f(c8, i8), ColorUtils.f(c8, i8), i8});
                    }

                    private ColorStateList i(@NonNull Context context) {
                        return h(context, ThemeUtils.c(context, R$attr.f834t));
                    }

                    private ColorStateList j(@NonNull Context context) {
                        return h(context, ThemeUtils.c(context, R$attr.f835u));
                    }

                    private ColorStateList k(Context context) {
                        int[][] iArr = new int[3];
                        int[] iArr2 = new int[3];
                        int i8 = R$attr.f839y;
                        ColorStateList e8 = ThemeUtils.e(context, i8);
                        if (e8 != null && e8.isStateful()) {
                            int[] iArr3 = ThemeUtils.f2189b;
                            iArr[0] = iArr3;
                            iArr2[0] = e8.getColorForState(iArr3, 0);
                            iArr[1] = ThemeUtils.f2193f;
                            iArr2[1] = ThemeUtils.c(context, R$attr.f836v);
                            iArr[2] = ThemeUtils.f2196i;
                            iArr2[2] = e8.getDefaultColor();
                        } else {
                            iArr[0] = ThemeUtils.f2189b;
                            iArr2[0] = ThemeUtils.b(context, i8);
                            iArr[1] = ThemeUtils.f2193f;
                            iArr2[1] = ThemeUtils.c(context, R$attr.f836v);
                            iArr[2] = ThemeUtils.f2196i;
                            iArr2[2] = ThemeUtils.c(context, i8);
                        }
                        return new ColorStateList(iArr, iArr2);
                    }

                    private LayerDrawable l(@NonNull ResourceManagerInternal resourceManagerInternal, @NonNull Context context, int i8) {
                        BitmapDrawable bitmapDrawable;
                        BitmapDrawable bitmapDrawable2;
                        BitmapDrawable bitmapDrawable3;
                        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i8);
                        Drawable j8 = resourceManagerInternal.j(context, R$drawable.F);
                        Drawable j9 = resourceManagerInternal.j(context, R$drawable.G);
                        if ((j8 instanceof BitmapDrawable) && j8.getIntrinsicWidth() == dimensionPixelSize && j8.getIntrinsicHeight() == dimensionPixelSize) {
                            bitmapDrawable = (BitmapDrawable) j8;
                            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
                        } else {
                            Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap);
                            j8.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                            j8.draw(canvas);
                            bitmapDrawable = new BitmapDrawable(createBitmap);
                            bitmapDrawable2 = new BitmapDrawable(createBitmap);
                        }
                        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
                        if ((j9 instanceof BitmapDrawable) && j9.getIntrinsicWidth() == dimensionPixelSize && j9.getIntrinsicHeight() == dimensionPixelSize) {
                            bitmapDrawable3 = (BitmapDrawable) j9;
                        } else {
                            Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                            Canvas canvas2 = new Canvas(createBitmap2);
                            j9.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                            j9.draw(canvas2);
                            bitmapDrawable3 = new BitmapDrawable(createBitmap2);
                        }
                        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
                        layerDrawable.setId(0, 16908288);
                        layerDrawable.setId(1, 16908303);
                        layerDrawable.setId(2, 16908301);
                        return layerDrawable;
                    }

                    private void m(Drawable drawable, int i8, PorterDuff.Mode mode) {
                        if (DrawableUtils.a(drawable)) {
                            drawable = drawable.mutate();
                        }
                        if (mode == null) {
                            mode = AppCompatDrawableManager.f1842b;
                        }
                        drawable.setColorFilter(AppCompatDrawableManager.e(i8, mode));
                    }

                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public Drawable a(@NonNull ResourceManagerInternal resourceManagerInternal, @NonNull Context context, int i8) {
                        if (i8 == R$drawable.f874j) {
                            return new LayerDrawable(new Drawable[]{resourceManagerInternal.j(context, R$drawable.f873i), resourceManagerInternal.j(context, R$drawable.f875k)});
                        }
                        if (i8 == R$drawable.f889y) {
                            return l(resourceManagerInternal, context, R$dimen.f858i);
                        }
                        if (i8 == R$drawable.f888x) {
                            return l(resourceManagerInternal, context, R$dimen.f859j);
                        }
                        if (i8 == R$drawable.f890z) {
                            return l(resourceManagerInternal, context, R$dimen.f860k);
                        }
                        return null;
                    }

                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public ColorStateList b(@NonNull Context context, int i8) {
                        if (i8 == R$drawable.f877m) {
                            return AppCompatResources.a(context, R$color.f846e);
                        }
                        if (i8 == R$drawable.I) {
                            return AppCompatResources.a(context, R$color.f849h);
                        }
                        if (i8 == R$drawable.H) {
                            return k(context);
                        }
                        if (i8 == R$drawable.f870f) {
                            return j(context);
                        }
                        if (i8 == R$drawable.f866b) {
                            return g(context);
                        }
                        if (i8 == R$drawable.f869e) {
                            return i(context);
                        }
                        if (i8 != R$drawable.D && i8 != R$drawable.E) {
                            if (f(this.f1846b, i8)) {
                                return ThemeUtils.e(context, R$attr.f838x);
                            }
                            if (f(this.f1849e, i8)) {
                                return AppCompatResources.a(context, R$color.f845d);
                            }
                            if (f(this.f1850f, i8)) {
                                return AppCompatResources.a(context, R$color.f844c);
                            }
                            if (i8 == R$drawable.A) {
                                return AppCompatResources.a(context, R$color.f847f);
                            }
                            return null;
                        }
                        return AppCompatResources.a(context, R$color.f848g);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
                    /* JADX WARN: Removed duplicated region for block: B:28:0x0061 A[RETURN] */
                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public boolean c(@androidx.annotation.NonNull android.content.Context r7, int r8, @androidx.annotation.NonNull android.graphics.drawable.Drawable r9) {
                        /*
                            r6 = this;
                            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.AppCompatDrawableManager.a()
                            int[] r1 = r6.f1845a
                            boolean r1 = r6.f(r1, r8)
                            r2 = 16842801(0x1010031, float:2.3693695E-38)
                            r3 = -1
                            r4 = 0
                            r5 = 1
                            if (r1 == 0) goto L17
                            int r2 = androidx.appcompat.R$attr.f838x
                        L14:
                            r8 = -1
                        L15:
                            r1 = 1
                            goto L44
                        L17:
                            int[] r1 = r6.f1847c
                            boolean r1 = r6.f(r1, r8)
                            if (r1 == 0) goto L22
                            int r2 = androidx.appcompat.R$attr.f836v
                            goto L14
                        L22:
                            int[] r1 = r6.f1848d
                            boolean r1 = r6.f(r1, r8)
                            if (r1 == 0) goto L2d
                            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                            goto L14
                        L2d:
                            int r1 = androidx.appcompat.R$drawable.f885u
                            if (r8 != r1) goto L3c
                            r2 = 16842800(0x1010030, float:2.3693693E-38)
                            r8 = 1109603123(0x42233333, float:40.8)
                            int r8 = java.lang.Math.round(r8)
                            goto L15
                        L3c:
                            int r1 = androidx.appcompat.R$drawable.f876l
                            if (r8 != r1) goto L41
                            goto L14
                        L41:
                            r8 = -1
                            r1 = 0
                            r2 = 0
                        L44:
                            if (r1 == 0) goto L61
                            boolean r1 = androidx.appcompat.widget.DrawableUtils.a(r9)
                            if (r1 == 0) goto L50
                            android.graphics.drawable.Drawable r9 = r9.mutate()
                        L50:
                            int r7 = androidx.appcompat.widget.ThemeUtils.c(r7, r2)
                            android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.AppCompatDrawableManager.e(r7, r0)
                            r9.setColorFilter(r7)
                            if (r8 == r3) goto L60
                            r9.setAlpha(r8)
                        L60:
                            return r5
                        L61:
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatDrawableManager.AnonymousClass1.c(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
                    }

                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public PorterDuff.Mode d(int i8) {
                        if (i8 == R$drawable.H) {
                            return PorterDuff.Mode.MULTIPLY;
                        }
                        return null;
                    }

                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public boolean e(@NonNull Context context, int i8, @NonNull Drawable drawable) {
                        if (i8 == R$drawable.C) {
                            LayerDrawable layerDrawable = (LayerDrawable) drawable;
                            Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908288);
                            int i9 = R$attr.f838x;
                            m(findDrawableByLayerId, ThemeUtils.c(context, i9), AppCompatDrawableManager.f1842b);
                            m(layerDrawable.findDrawableByLayerId(16908303), ThemeUtils.c(context, i9), AppCompatDrawableManager.f1842b);
                            m(layerDrawable.findDrawableByLayerId(16908301), ThemeUtils.c(context, R$attr.f836v), AppCompatDrawableManager.f1842b);
                            return true;
                        } else if (i8 != R$drawable.f889y && i8 != R$drawable.f888x && i8 != R$drawable.f890z) {
                            return false;
                        } else {
                            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                            m(layerDrawable2.findDrawableByLayerId(16908288), ThemeUtils.b(context, R$attr.f838x), AppCompatDrawableManager.f1842b);
                            Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(16908303);
                            int i10 = R$attr.f836v;
                            m(findDrawableByLayerId2, ThemeUtils.c(context, i10), AppCompatDrawableManager.f1842b);
                            m(layerDrawable2.findDrawableByLayerId(16908301), ThemeUtils.c(context, i10), AppCompatDrawableManager.f1842b);
                            return true;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        ResourceManagerInternal.w(drawable, tintInfo, iArr);
    }

    public synchronized Drawable c(@NonNull Context context, int i8) {
        return this.f1844a.j(context, i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable d(@NonNull Context context, int i8, boolean z7) {
        return this.f1844a.k(context, i8, z7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList f(@NonNull Context context, int i8) {
        return this.f1844a.m(context, i8);
    }

    public synchronized void g(@NonNull Context context) {
        this.f1844a.s(context);
    }
}
