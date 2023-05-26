package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;

/* loaded from: classes.dex */
public class DrawableContainerCompat extends Drawable implements Drawable.Callback {

    /* renamed from: f  reason: collision with root package name */
    private DrawableContainerState f1355f;

    /* renamed from: g  reason: collision with root package name */
    private Rect f1356g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f1357h;

    /* renamed from: i  reason: collision with root package name */
    private Drawable f1358i;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1360k;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1362m;

    /* renamed from: n  reason: collision with root package name */
    private Runnable f1363n;

    /* renamed from: o  reason: collision with root package name */
    private long f1364o;

    /* renamed from: p  reason: collision with root package name */
    private long f1365p;

    /* renamed from: q  reason: collision with root package name */
    private BlockInvalidateCallback f1366q;

    /* renamed from: j  reason: collision with root package name */
    private int f1359j = 255;

    /* renamed from: l  reason: collision with root package name */
    private int f1361l = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static boolean a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void b(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources c(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class BlockInvalidateCallback implements Drawable.Callback {

        /* renamed from: f  reason: collision with root package name */
        private Drawable.Callback f1368f;

        BlockInvalidateCallback() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f1368f;
            this.f1368f = null;
            return callback;
        }

        public BlockInvalidateCallback b(Drawable.Callback callback) {
            this.f1368f = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j8) {
            Drawable.Callback callback = this.f1368f;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j8);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
            Drawable.Callback callback = this.f1368f;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class DrawableContainerState extends Drawable.ConstantState {
        int A;
        int B;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        PorterDuff.Mode G;
        boolean H;
        boolean I;

        /* renamed from: a  reason: collision with root package name */
        final DrawableContainerCompat f1369a;

        /* renamed from: b  reason: collision with root package name */
        Resources f1370b;

        /* renamed from: c  reason: collision with root package name */
        int f1371c;

        /* renamed from: d  reason: collision with root package name */
        int f1372d;

        /* renamed from: e  reason: collision with root package name */
        int f1373e;

        /* renamed from: f  reason: collision with root package name */
        SparseArray<Drawable.ConstantState> f1374f;

        /* renamed from: g  reason: collision with root package name */
        Drawable[] f1375g;

        /* renamed from: h  reason: collision with root package name */
        int f1376h;

        /* renamed from: i  reason: collision with root package name */
        boolean f1377i;

        /* renamed from: j  reason: collision with root package name */
        boolean f1378j;

        /* renamed from: k  reason: collision with root package name */
        Rect f1379k;

        /* renamed from: l  reason: collision with root package name */
        boolean f1380l;

        /* renamed from: m  reason: collision with root package name */
        boolean f1381m;

        /* renamed from: n  reason: collision with root package name */
        int f1382n;

        /* renamed from: o  reason: collision with root package name */
        int f1383o;

        /* renamed from: p  reason: collision with root package name */
        int f1384p;

        /* renamed from: q  reason: collision with root package name */
        int f1385q;

        /* renamed from: r  reason: collision with root package name */
        boolean f1386r;

        /* renamed from: s  reason: collision with root package name */
        int f1387s;

        /* renamed from: t  reason: collision with root package name */
        boolean f1388t;

        /* renamed from: u  reason: collision with root package name */
        boolean f1389u;

        /* renamed from: v  reason: collision with root package name */
        boolean f1390v;

        /* renamed from: w  reason: collision with root package name */
        boolean f1391w;

        /* renamed from: x  reason: collision with root package name */
        boolean f1392x;

        /* renamed from: y  reason: collision with root package name */
        boolean f1393y;

        /* renamed from: z  reason: collision with root package name */
        int f1394z;

        /* JADX INFO: Access modifiers changed from: package-private */
        public DrawableContainerState(DrawableContainerState drawableContainerState, DrawableContainerCompat drawableContainerCompat, Resources resources) {
            Resources resources2;
            int i8;
            this.f1377i = false;
            this.f1380l = false;
            this.f1392x = true;
            this.A = 0;
            this.B = 0;
            this.f1369a = drawableContainerCompat;
            if (resources != null) {
                resources2 = resources;
            } else if (drawableContainerState != null) {
                resources2 = drawableContainerState.f1370b;
            } else {
                resources2 = null;
            }
            this.f1370b = resources2;
            if (drawableContainerState != null) {
                i8 = drawableContainerState.f1371c;
            } else {
                i8 = 0;
            }
            int f8 = DrawableContainerCompat.f(resources, i8);
            this.f1371c = f8;
            if (drawableContainerState != null) {
                this.f1372d = drawableContainerState.f1372d;
                this.f1373e = drawableContainerState.f1373e;
                this.f1390v = true;
                this.f1391w = true;
                this.f1377i = drawableContainerState.f1377i;
                this.f1380l = drawableContainerState.f1380l;
                this.f1392x = drawableContainerState.f1392x;
                this.f1393y = drawableContainerState.f1393y;
                this.f1394z = drawableContainerState.f1394z;
                this.A = drawableContainerState.A;
                this.B = drawableContainerState.B;
                this.C = drawableContainerState.C;
                this.D = drawableContainerState.D;
                this.E = drawableContainerState.E;
                this.F = drawableContainerState.F;
                this.G = drawableContainerState.G;
                this.H = drawableContainerState.H;
                this.I = drawableContainerState.I;
                if (drawableContainerState.f1371c == f8) {
                    if (drawableContainerState.f1378j) {
                        this.f1379k = drawableContainerState.f1379k != null ? new Rect(drawableContainerState.f1379k) : null;
                        this.f1378j = true;
                    }
                    if (drawableContainerState.f1381m) {
                        this.f1382n = drawableContainerState.f1382n;
                        this.f1383o = drawableContainerState.f1383o;
                        this.f1384p = drawableContainerState.f1384p;
                        this.f1385q = drawableContainerState.f1385q;
                        this.f1381m = true;
                    }
                }
                if (drawableContainerState.f1386r) {
                    this.f1387s = drawableContainerState.f1387s;
                    this.f1386r = true;
                }
                if (drawableContainerState.f1388t) {
                    this.f1389u = drawableContainerState.f1389u;
                    this.f1388t = true;
                }
                Drawable[] drawableArr = drawableContainerState.f1375g;
                this.f1375g = new Drawable[drawableArr.length];
                this.f1376h = drawableContainerState.f1376h;
                SparseArray<Drawable.ConstantState> sparseArray = drawableContainerState.f1374f;
                if (sparseArray != null) {
                    this.f1374f = sparseArray.clone();
                } else {
                    this.f1374f = new SparseArray<>(this.f1376h);
                }
                int i9 = this.f1376h;
                for (int i10 = 0; i10 < i9; i10++) {
                    Drawable drawable = drawableArr[i10];
                    if (drawable != null) {
                        Drawable.ConstantState constantState = drawable.getConstantState();
                        if (constantState != null) {
                            this.f1374f.put(i10, constantState);
                        } else {
                            this.f1375g[i10] = drawableArr[i10];
                        }
                    }
                }
                return;
            }
            this.f1375g = new Drawable[10];
            this.f1376h = 0;
        }

        private void e() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f1374f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i8 = 0; i8 < size; i8++) {
                    this.f1375g[this.f1374f.keyAt(i8)] = t(this.f1374f.valueAt(i8).newDrawable(this.f1370b));
                }
                this.f1374f = null;
            }
        }

        private Drawable t(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                DrawableCompat.m(drawable, this.f1394z);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f1369a);
            return mutate;
        }

        public final int a(Drawable drawable) {
            int i8 = this.f1376h;
            if (i8 >= this.f1375g.length) {
                o(i8, i8 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f1369a);
            this.f1375g[i8] = drawable;
            this.f1376h++;
            this.f1373e = drawable.getChangingConfigurations() | this.f1373e;
            p();
            this.f1379k = null;
            this.f1378j = false;
            this.f1381m = false;
            this.f1390v = false;
            return i8;
        }

        final void b(Resources.Theme theme) {
            if (theme != null) {
                e();
                int i8 = this.f1376h;
                Drawable[] drawableArr = this.f1375g;
                for (int i9 = 0; i9 < i8; i9++) {
                    Drawable drawable = drawableArr[i9];
                    if (drawable != null && DrawableCompat.b(drawable)) {
                        DrawableCompat.a(drawableArr[i9], theme);
                        this.f1373e |= drawableArr[i9].getChangingConfigurations();
                    }
                }
                z(Api21Impl.c(theme));
            }
        }

        public boolean c() {
            if (this.f1390v) {
                return this.f1391w;
            }
            e();
            this.f1390v = true;
            int i8 = this.f1376h;
            Drawable[] drawableArr = this.f1375g;
            for (int i9 = 0; i9 < i8; i9++) {
                if (drawableArr[i9].getConstantState() == null) {
                    this.f1391w = false;
                    return false;
                }
            }
            this.f1391w = true;
            return true;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i8 = this.f1376h;
            Drawable[] drawableArr = this.f1375g;
            for (int i9 = 0; i9 < i8; i9++) {
                Drawable drawable = drawableArr[i9];
                if (drawable != null) {
                    if (DrawableCompat.b(drawable)) {
                        return true;
                    }
                } else {
                    Drawable.ConstantState constantState = this.f1374f.get(i9);
                    if (constantState != null && Api21Impl.a(constantState)) {
                        return true;
                    }
                }
            }
            return false;
        }

        protected void d() {
            this.f1381m = true;
            e();
            int i8 = this.f1376h;
            Drawable[] drawableArr = this.f1375g;
            this.f1383o = -1;
            this.f1382n = -1;
            this.f1385q = 0;
            this.f1384p = 0;
            for (int i9 = 0; i9 < i8; i9++) {
                Drawable drawable = drawableArr[i9];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f1382n) {
                    this.f1382n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f1383o) {
                    this.f1383o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f1384p) {
                    this.f1384p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f1385q) {
                    this.f1385q = minimumHeight;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int f() {
            return this.f1375g.length;
        }

        public final Drawable g(int i8) {
            int indexOfKey;
            Drawable drawable = this.f1375g[i8];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f1374f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i8)) < 0) {
                return null;
            }
            Drawable t7 = t(this.f1374f.valueAt(indexOfKey).newDrawable(this.f1370b));
            this.f1375g[i8] = t7;
            this.f1374f.removeAt(indexOfKey);
            if (this.f1374f.size() == 0) {
                this.f1374f = null;
            }
            return t7;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1372d | this.f1373e;
        }

        public final int h() {
            return this.f1376h;
        }

        public final int i() {
            if (!this.f1381m) {
                d();
            }
            return this.f1383o;
        }

        public final int j() {
            if (!this.f1381m) {
                d();
            }
            return this.f1385q;
        }

        public final int k() {
            if (!this.f1381m) {
                d();
            }
            return this.f1384p;
        }

        public final Rect l() {
            Rect rect = null;
            if (this.f1377i) {
                return null;
            }
            Rect rect2 = this.f1379k;
            if (rect2 == null && !this.f1378j) {
                e();
                Rect rect3 = new Rect();
                int i8 = this.f1376h;
                Drawable[] drawableArr = this.f1375g;
                for (int i9 = 0; i9 < i8; i9++) {
                    if (drawableArr[i9].getPadding(rect3)) {
                        if (rect == null) {
                            rect = new Rect(0, 0, 0, 0);
                        }
                        int i10 = rect3.left;
                        if (i10 > rect.left) {
                            rect.left = i10;
                        }
                        int i11 = rect3.top;
                        if (i11 > rect.top) {
                            rect.top = i11;
                        }
                        int i12 = rect3.right;
                        if (i12 > rect.right) {
                            rect.right = i12;
                        }
                        int i13 = rect3.bottom;
                        if (i13 > rect.bottom) {
                            rect.bottom = i13;
                        }
                    }
                }
                this.f1378j = true;
                this.f1379k = rect;
                return rect;
            }
            return rect2;
        }

        public final int m() {
            if (!this.f1381m) {
                d();
            }
            return this.f1382n;
        }

        public final int n() {
            int i8;
            if (this.f1386r) {
                return this.f1387s;
            }
            e();
            int i9 = this.f1376h;
            Drawable[] drawableArr = this.f1375g;
            if (i9 > 0) {
                i8 = drawableArr[0].getOpacity();
            } else {
                i8 = -2;
            }
            for (int i10 = 1; i10 < i9; i10++) {
                i8 = Drawable.resolveOpacity(i8, drawableArr[i10].getOpacity());
            }
            this.f1387s = i8;
            this.f1386r = true;
            return i8;
        }

        public void o(int i8, int i9) {
            Drawable[] drawableArr = new Drawable[i9];
            Drawable[] drawableArr2 = this.f1375g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i8);
            }
            this.f1375g = drawableArr;
        }

        void p() {
            this.f1386r = false;
            this.f1388t = false;
        }

        public final boolean q() {
            return this.f1380l;
        }

        public final boolean r() {
            if (this.f1388t) {
                return this.f1389u;
            }
            e();
            int i8 = this.f1376h;
            Drawable[] drawableArr = this.f1375g;
            boolean z7 = false;
            int i9 = 0;
            while (true) {
                if (i9 >= i8) {
                    break;
                } else if (drawableArr[i9].isStateful()) {
                    z7 = true;
                    break;
                } else {
                    i9++;
                }
            }
            this.f1389u = z7;
            this.f1388t = true;
            return z7;
        }

        abstract void s();

        public final void u(boolean z7) {
            this.f1380l = z7;
        }

        public final void v(int i8) {
            this.A = i8;
        }

        public final void w(int i8) {
            this.B = i8;
        }

        final boolean x(int i8, int i9) {
            boolean z7;
            int i10 = this.f1376h;
            Drawable[] drawableArr = this.f1375g;
            boolean z8 = false;
            for (int i11 = 0; i11 < i10; i11++) {
                Drawable drawable = drawableArr[i11];
                if (drawable != null) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        z7 = DrawableCompat.m(drawable, i8);
                    } else {
                        z7 = false;
                    }
                    if (i11 == i9) {
                        z8 = z7;
                    }
                }
            }
            this.f1394z = i8;
            return z8;
        }

        public final void y(boolean z7) {
            this.f1377i = z7;
        }

        final void z(Resources resources) {
            if (resources != null) {
                this.f1370b = resources;
                int f8 = DrawableContainerCompat.f(resources, this.f1371c);
                int i8 = this.f1371c;
                this.f1371c = f8;
                if (i8 != f8) {
                    this.f1381m = false;
                    this.f1378j = false;
                }
            }
        }
    }

    private void d(Drawable drawable) {
        if (this.f1366q == null) {
            this.f1366q = new BlockInvalidateCallback();
        }
        drawable.setCallback(this.f1366q.b(drawable.getCallback()));
        try {
            if (this.f1355f.A <= 0 && this.f1360k) {
                drawable.setAlpha(this.f1359j);
            }
            DrawableContainerState drawableContainerState = this.f1355f;
            if (drawableContainerState.E) {
                drawable.setColorFilter(drawableContainerState.D);
            } else {
                if (drawableContainerState.H) {
                    DrawableCompat.o(drawable, drawableContainerState.F);
                }
                DrawableContainerState drawableContainerState2 = this.f1355f;
                if (drawableContainerState2.I) {
                    DrawableCompat.p(drawable, drawableContainerState2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f1355f.f1392x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                DrawableCompat.m(drawable, DrawableCompat.f(this));
            }
            DrawableCompat.j(drawable, this.f1355f.C);
            Rect rect = this.f1356g;
            if (rect != null) {
                DrawableCompat.l(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f1366q.a());
        }
    }

    private boolean e() {
        if (isAutoMirrored() && DrawableCompat.f(this) == 1) {
            return true;
        }
        return false;
    }

    static int f(Resources resources, int i8) {
        if (resources != null) {
            i8 = resources.getDisplayMetrics().densityDpi;
        }
        if (i8 == 0) {
            return 160;
        }
        return i8;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f1360k = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f1357h
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L38
            long r9 = r13.f1364o
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L3a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.f1359j
            r3.setAlpha(r9)
            r13.f1364o = r7
            goto L3a
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r9 = r13.f1355f
            int r9 = r9.A
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.f1359j
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L3b
        L38:
            r13.f1364o = r7
        L3a:
            r3 = 0
        L3b:
            android.graphics.drawable.Drawable r9 = r13.f1358i
            if (r9 == 0) goto L65
            long r10 = r13.f1365p
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L67
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L52
            r9.setVisible(r6, r6)
            r0 = 0
            r13.f1358i = r0
            r13.f1365p = r7
            goto L67
        L52:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r4 = r13.f1355f
            int r4 = r4.B
            int r3 = r3 / r4
            int r4 = r13.f1359j
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L68
        L65:
            r13.f1365p = r7
        L67:
            r0 = r3
        L68:
            if (r14 == 0) goto L74
            if (r0 == 0) goto L74
            java.lang.Runnable r14 = r13.f1363n
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainerCompat.a(boolean):void");
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(@NonNull Resources.Theme theme) {
        this.f1355f.b(theme);
    }

    DrawableContainerState b() {
        return this.f1355f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f1361l;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f1355f.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Drawable drawable = this.f1357h;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f1358i;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean g(int r10) {
        /*
            r9 = this;
            int r0 = r9.f1361l
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r0 = r9.f1355f
            int r0 = r0.B
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.f1358i
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.f1357h
            if (r0 == 0) goto L29
            r9.f1358i = r0
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r0 = r9.f1355f
            int r0 = r0.B
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.f1365p = r0
            goto L35
        L29:
            r9.f1358i = r4
            r9.f1365p = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.f1357h
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r0 = r9.f1355f
            int r1 = r0.f1376h
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.g(r10)
            r9.f1357h = r0
            r9.f1361l = r10
            if (r0 == 0) goto L5a
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r10 = r9.f1355f
            int r10 = r10.A
            if (r10 <= 0) goto L51
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f1364o = r2
        L51:
            r9.d(r0)
            goto L5a
        L55:
            r9.f1357h = r4
            r10 = -1
            r9.f1361l = r10
        L5a:
            long r0 = r9.f1364o
            r10 = 1
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L67
            long r0 = r9.f1365p
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 == 0) goto L79
        L67:
            java.lang.Runnable r0 = r9.f1363n
            if (r0 != 0) goto L73
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$1 r0 = new androidx.appcompat.graphics.drawable.DrawableContainerCompat$1
            r0.<init>()
            r9.f1363n = r0
            goto L76
        L73:
            r9.unscheduleSelf(r0)
        L76:
            r9.a(r10)
        L79:
            r9.invalidateSelf()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainerCompat.g(int):boolean");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1359j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f1355f.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f1355f.c()) {
            this.f1355f.f1372d = getChangingConfigurations();
            return this.f1355f;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable getCurrent() {
        return this.f1357h;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(@NonNull Rect rect) {
        Rect rect2 = this.f1356g;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f1355f.q()) {
            return this.f1355f.i();
        }
        Drawable drawable = this.f1357h;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f1355f.q()) {
            return this.f1355f.m();
        }
        Drawable drawable = this.f1357h;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f1355f.q()) {
            return this.f1355f.j();
        }
        Drawable drawable = this.f1357h;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f1355f.q()) {
            return this.f1355f.k();
        }
        Drawable drawable = this.f1357h;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f1357h;
        if (drawable != null && drawable.isVisible()) {
            return this.f1355f.n();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(@NonNull Outline outline) {
        Drawable drawable = this.f1357h;
        if (drawable != null) {
            Api21Impl.b(drawable, outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        boolean padding;
        Rect l8 = this.f1355f.l();
        if (l8 != null) {
            rect.set(l8);
            if ((l8.right | l8.left | l8.top | l8.bottom) != 0) {
                padding = true;
            } else {
                padding = false;
            }
        } else {
            Drawable drawable = this.f1357h;
            if (drawable != null) {
                padding = drawable.getPadding(rect);
            } else {
                padding = super.getPadding(rect);
            }
        }
        if (e()) {
            int i8 = rect.left;
            rect.left = rect.right;
            rect.right = i8;
        }
        return padding;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(DrawableContainerState drawableContainerState) {
        this.f1355f = drawableContainerState;
        int i8 = this.f1361l;
        if (i8 >= 0) {
            Drawable g8 = drawableContainerState.g(i8);
            this.f1357h = g8;
            if (g8 != null) {
                d(g8);
            }
        }
        this.f1358i = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i(Resources resources) {
        this.f1355f.z(resources);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        DrawableContainerState drawableContainerState = this.f1355f;
        if (drawableContainerState != null) {
            drawableContainerState.p();
        }
        if (drawable == this.f1357h && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f1355f.C;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f1355f.r();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z7;
        Drawable drawable = this.f1358i;
        boolean z8 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f1358i = null;
            z7 = true;
        } else {
            z7 = false;
        }
        Drawable drawable2 = this.f1357h;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f1360k) {
                this.f1357h.setAlpha(this.f1359j);
            }
        }
        if (this.f1365p != 0) {
            this.f1365p = 0L;
            z7 = true;
        }
        if (this.f1364o != 0) {
            this.f1364o = 0L;
        } else {
            z8 = z7;
        }
        if (z8) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f1362m && super.mutate() == this) {
            DrawableContainerState b8 = b();
            b8.s();
            h(b8);
            this.f1362m = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1358i;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f1357h;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i8) {
        return this.f1355f.x(i8, c());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i8) {
        Drawable drawable = this.f1358i;
        if (drawable != null) {
            return drawable.setLevel(i8);
        }
        Drawable drawable2 = this.f1357h;
        if (drawable2 != null) {
            return drawable2.setLevel(i8);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(@NonNull int[] iArr) {
        Drawable drawable = this.f1358i;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f1357h;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j8) {
        if (drawable == this.f1357h && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j8);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        if (!this.f1360k || this.f1359j != i8) {
            this.f1360k = true;
            this.f1359j = i8;
            Drawable drawable = this.f1357h;
            if (drawable != null) {
                if (this.f1364o == 0) {
                    drawable.setAlpha(i8);
                } else {
                    a(false);
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z7) {
        DrawableContainerState drawableContainerState = this.f1355f;
        if (drawableContainerState.C != z7) {
            drawableContainerState.C = z7;
            Drawable drawable = this.f1357h;
            if (drawable != null) {
                DrawableCompat.j(drawable, z7);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        DrawableContainerState drawableContainerState = this.f1355f;
        drawableContainerState.E = true;
        if (drawableContainerState.D != colorFilter) {
            drawableContainerState.D = colorFilter;
            Drawable drawable = this.f1357h;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z7) {
        DrawableContainerState drawableContainerState = this.f1355f;
        if (drawableContainerState.f1392x != z7) {
            drawableContainerState.f1392x = z7;
            Drawable drawable = this.f1357h;
            if (drawable != null) {
                drawable.setDither(z7);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f8, float f9) {
        Drawable drawable = this.f1357h;
        if (drawable != null) {
            DrawableCompat.k(drawable, f8, f9);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i8, int i9, int i10, int i11) {
        Rect rect = this.f1356g;
        if (rect == null) {
            this.f1356g = new Rect(i8, i9, i10, i11);
        } else {
            rect.set(i8, i9, i10, i11);
        }
        Drawable drawable = this.f1357h;
        if (drawable != null) {
            DrawableCompat.l(drawable, i8, i9, i10, i11);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i8) {
        setTintList(ColorStateList.valueOf(i8));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        DrawableContainerState drawableContainerState = this.f1355f;
        drawableContainerState.H = true;
        if (drawableContainerState.F != colorStateList) {
            drawableContainerState.F = colorStateList;
            DrawableCompat.o(this.f1357h, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        DrawableContainerState drawableContainerState = this.f1355f;
        drawableContainerState.I = true;
        if (drawableContainerState.G != mode) {
            drawableContainerState.G = mode;
            DrawableCompat.p(this.f1357h, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z7, boolean z8) {
        boolean visible = super.setVisible(z7, z8);
        Drawable drawable = this.f1358i;
        if (drawable != null) {
            drawable.setVisible(z7, z8);
        }
        Drawable drawable2 = this.f1357h;
        if (drawable2 != null) {
            drawable2.setVisible(z7, z8);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        if (drawable == this.f1357h && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }
}
