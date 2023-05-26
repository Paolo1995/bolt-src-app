package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsets$Builder;
import android.view.WindowInsets$Type;
import androidx.annotation.NonNull;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: classes.dex */
public class WindowInsetsCompat {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public static final WindowInsetsCompat f5991b;

    /* renamed from: a  reason: collision with root package name */
    private final Impl f5992a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"SoonBlockedPrivateApi"})
    /* loaded from: classes.dex */
    public static class Api21ReflectionHolder {

        /* renamed from: a  reason: collision with root package name */
        private static Field f5993a;

        /* renamed from: b  reason: collision with root package name */
        private static Field f5994b;

        /* renamed from: c  reason: collision with root package name */
        private static Field f5995c;

        /* renamed from: d  reason: collision with root package name */
        private static boolean f5996d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f5993a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f5994b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f5995c = declaredField3;
                declaredField3.setAccessible(true);
                f5996d = true;
            } catch (ReflectiveOperationException e8) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e8.getMessage(), e8);
            }
        }

        private Api21ReflectionHolder() {
        }

        public static WindowInsetsCompat a(@NonNull View view) {
            if (f5996d && view.isAttachedToWindow()) {
                try {
                    Object obj = f5993a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f5994b.get(obj);
                        Rect rect2 = (Rect) f5995c.get(obj);
                        if (rect != null && rect2 != null) {
                            WindowInsetsCompat a8 = new Builder().b(Insets.c(rect)).c(Insets.c(rect2)).a();
                            a8.s(a8);
                            a8.d(view.getRootView());
                            return a8;
                        }
                    }
                } catch (IllegalAccessException e8) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e8.getMessage(), e8);
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class BuilderImpl {

        /* renamed from: a  reason: collision with root package name */
        private final WindowInsetsCompat f5998a;

        /* renamed from: b  reason: collision with root package name */
        Insets[] f5999b;

        BuilderImpl() {
            this(new WindowInsetsCompat((WindowInsetsCompat) null));
        }

        protected final void a() {
            Insets[] insetsArr = this.f5999b;
            if (insetsArr != null) {
                Insets insets = insetsArr[Type.a(1)];
                Insets insets2 = this.f5999b[Type.a(2)];
                if (insets2 == null) {
                    insets2 = this.f5998a.f(2);
                }
                if (insets == null) {
                    insets = this.f5998a.f(1);
                }
                f(Insets.a(insets, insets2));
                Insets insets3 = this.f5999b[Type.a(16)];
                if (insets3 != null) {
                    e(insets3);
                }
                Insets insets4 = this.f5999b[Type.a(32)];
                if (insets4 != null) {
                    c(insets4);
                }
                Insets insets5 = this.f5999b[Type.a(64)];
                if (insets5 != null) {
                    g(insets5);
                }
            }
        }

        @NonNull
        WindowInsetsCompat b() {
            a();
            return this.f5998a;
        }

        void c(@NonNull Insets insets) {
        }

        void d(@NonNull Insets insets) {
        }

        void e(@NonNull Insets insets) {
        }

        void f(@NonNull Insets insets) {
        }

        void g(@NonNull Insets insets) {
        }

        BuilderImpl(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.f5998a = windowInsetsCompat;
        }
    }

    /* loaded from: classes.dex */
    private static class BuilderImpl30 extends BuilderImpl29 {
        BuilderImpl30() {
        }

        BuilderImpl30(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Impl {
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        static final WindowInsetsCompat f6007b = new Builder().a().a().b().c();

        /* renamed from: a  reason: collision with root package name */
        final WindowInsetsCompat f6008a;

        Impl(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.f6008a = windowInsetsCompat;
        }

        @NonNull
        WindowInsetsCompat a() {
            return this.f6008a;
        }

        @NonNull
        WindowInsetsCompat b() {
            return this.f6008a;
        }

        @NonNull
        WindowInsetsCompat c() {
            return this.f6008a;
        }

        void d(@NonNull View view) {
        }

        void e(@NonNull WindowInsetsCompat windowInsetsCompat) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl)) {
                return false;
            }
            Impl impl = (Impl) obj;
            if (o() == impl.o() && n() == impl.n() && ObjectsCompat.a(k(), impl.k()) && ObjectsCompat.a(i(), impl.i()) && ObjectsCompat.a(f(), impl.f())) {
                return true;
            }
            return false;
        }

        DisplayCutoutCompat f() {
            return null;
        }

        @NonNull
        Insets g(int i8) {
            return Insets.f5736e;
        }

        @NonNull
        Insets h() {
            return k();
        }

        public int hashCode() {
            return ObjectsCompat.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        @NonNull
        Insets i() {
            return Insets.f5736e;
        }

        @NonNull
        Insets j() {
            return k();
        }

        @NonNull
        Insets k() {
            return Insets.f5736e;
        }

        @NonNull
        Insets l() {
            return k();
        }

        @NonNull
        WindowInsetsCompat m(int i8, int i9, int i10, int i11) {
            return f6007b;
        }

        boolean n() {
            return false;
        }

        boolean o() {
            return false;
        }

        public void p(Insets[] insetsArr) {
        }

        void q(@NonNull Insets insets) {
        }

        void r(WindowInsetsCompat windowInsetsCompat) {
        }

        public void s(Insets insets) {
        }
    }

    /* loaded from: classes.dex */
    private static class Impl28 extends Impl21 {
        Impl28(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        WindowInsetsCompat a() {
            WindowInsets consumeDisplayCutout;
            consumeDisplayCutout = this.f6014c.consumeDisplayCutout();
            return WindowInsetsCompat.v(consumeDisplayCutout);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl28)) {
                return false;
            }
            Impl28 impl28 = (Impl28) obj;
            if (Objects.equals(this.f6014c, impl28.f6014c) && Objects.equals(this.f6018g, impl28.f6018g)) {
                return true;
            }
            return false;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        DisplayCutoutCompat f() {
            DisplayCutout displayCutout;
            displayCutout = this.f6014c.getDisplayCutout();
            return DisplayCutoutCompat.e(displayCutout);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public int hashCode() {
            return this.f6014c.hashCode();
        }

        Impl28(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl28 impl28) {
            super(windowInsetsCompat, impl28);
        }
    }

    /* loaded from: classes.dex */
    private static class Impl30 extends Impl29 {
        @NonNull

        /* renamed from: q  reason: collision with root package name */
        static final WindowInsetsCompat f6023q = WindowInsetsCompat.v(WindowInsets.CONSUMED);

        Impl30(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        final void d(@NonNull View view) {
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets g(int i8) {
            android.graphics.Insets insets;
            insets = this.f6014c.getInsets(TypeImpl30.a(i8));
            return Insets.d(insets);
        }

        Impl30(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl30 impl30) {
            super(windowInsetsCompat, impl30);
        }
    }

    /* loaded from: classes.dex */
    public static final class Type {
        private Type() {
        }

        static int a(int i8) {
            if (i8 != 1) {
                if (i8 == 2) {
                    return 1;
                }
                if (i8 == 4) {
                    return 2;
                }
                if (i8 != 8) {
                    if (i8 == 16) {
                        return 4;
                    }
                    if (i8 != 32) {
                        if (i8 != 64) {
                            if (i8 != 128) {
                                if (i8 == 256) {
                                    return 8;
                                }
                                throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i8);
                            }
                            return 7;
                        }
                        return 6;
                    }
                    return 5;
                }
                return 3;
            }
            return 0;
        }

        public static int b() {
            return 32;
        }

        public static int c() {
            return 7;
        }
    }

    /* loaded from: classes.dex */
    private static final class TypeImpl30 {
        private TypeImpl30() {
        }

        static int a(int i8) {
            int statusBars;
            int i9 = 0;
            for (int i10 = 1; i10 <= 256; i10 <<= 1) {
                if ((i8 & i10) != 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            if (i10 != 4) {
                                if (i10 != 8) {
                                    if (i10 != 16) {
                                        if (i10 != 32) {
                                            if (i10 != 64) {
                                                if (i10 == 128) {
                                                    statusBars = WindowInsets$Type.displayCutout();
                                                }
                                            } else {
                                                statusBars = WindowInsets$Type.tappableElement();
                                            }
                                        } else {
                                            statusBars = WindowInsets$Type.mandatorySystemGestures();
                                        }
                                    } else {
                                        statusBars = WindowInsets$Type.systemGestures();
                                    }
                                } else {
                                    statusBars = WindowInsets$Type.ime();
                                }
                            } else {
                                statusBars = WindowInsets$Type.captionBar();
                            }
                        } else {
                            statusBars = WindowInsets$Type.navigationBars();
                        }
                    } else {
                        statusBars = WindowInsets$Type.statusBars();
                    }
                    i9 |= statusBars;
                }
            }
            return i9;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f5991b = Impl30.f6023q;
        } else {
            f5991b = Impl.f6007b;
        }
    }

    private WindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 30) {
            this.f5992a = new Impl30(this, windowInsets);
        } else if (i8 >= 29) {
            this.f5992a = new Impl29(this, windowInsets);
        } else if (i8 >= 28) {
            this.f5992a = new Impl28(this, windowInsets);
        } else {
            this.f5992a = new Impl21(this, windowInsets);
        }
    }

    static Insets n(@NonNull Insets insets, int i8, int i9, int i10, int i11) {
        int max = Math.max(0, insets.f5737a - i8);
        int max2 = Math.max(0, insets.f5738b - i9);
        int max3 = Math.max(0, insets.f5739c - i10);
        int max4 = Math.max(0, insets.f5740d - i11);
        if (max == i8 && max2 == i9 && max3 == i10 && max4 == i11) {
            return insets;
        }
        return Insets.b(max, max2, max3, max4);
    }

    @NonNull
    public static WindowInsetsCompat v(@NonNull WindowInsets windowInsets) {
        return w(windowInsets, null);
    }

    @NonNull
    public static WindowInsetsCompat w(@NonNull WindowInsets windowInsets, View view) {
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat((WindowInsets) Preconditions.g(windowInsets));
        if (view != null && ViewCompat.V(view)) {
            windowInsetsCompat.s(ViewCompat.K(view));
            windowInsetsCompat.d(view.getRootView());
        }
        return windowInsetsCompat;
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat a() {
        return this.f5992a.a();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat b() {
        return this.f5992a.b();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat c() {
        return this.f5992a.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(@NonNull View view) {
        this.f5992a.d(view);
    }

    public DisplayCutoutCompat e() {
        return this.f5992a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowInsetsCompat)) {
            return false;
        }
        return ObjectsCompat.a(this.f5992a, ((WindowInsetsCompat) obj).f5992a);
    }

    @NonNull
    public Insets f(int i8) {
        return this.f5992a.g(i8);
    }

    @NonNull
    @Deprecated
    public Insets g() {
        return this.f5992a.i();
    }

    @NonNull
    @Deprecated
    public Insets h() {
        return this.f5992a.j();
    }

    public int hashCode() {
        Impl impl = this.f5992a;
        if (impl == null) {
            return 0;
        }
        return impl.hashCode();
    }

    @Deprecated
    public int i() {
        return this.f5992a.k().f5740d;
    }

    @Deprecated
    public int j() {
        return this.f5992a.k().f5737a;
    }

    @Deprecated
    public int k() {
        return this.f5992a.k().f5739c;
    }

    @Deprecated
    public int l() {
        return this.f5992a.k().f5738b;
    }

    @NonNull
    public WindowInsetsCompat m(int i8, int i9, int i10, int i11) {
        return this.f5992a.m(i8, i9, i10, i11);
    }

    public boolean o() {
        return this.f5992a.n();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat p(int i8, int i9, int i10, int i11) {
        return new Builder(this).c(Insets.b(i8, i9, i10, i11)).a();
    }

    void q(Insets[] insetsArr) {
        this.f5992a.p(insetsArr);
    }

    void r(@NonNull Insets insets) {
        this.f5992a.q(insets);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(WindowInsetsCompat windowInsetsCompat) {
        this.f5992a.r(windowInsetsCompat);
    }

    void t(Insets insets) {
        this.f5992a.s(insets);
    }

    public WindowInsets u() {
        Impl impl = this.f5992a;
        if (impl instanceof Impl20) {
            return ((Impl20) impl).f6014c;
        }
        return null;
    }

    /* loaded from: classes.dex */
    private static class BuilderImpl20 extends BuilderImpl {

        /* renamed from: e  reason: collision with root package name */
        private static Field f6000e = null;

        /* renamed from: f  reason: collision with root package name */
        private static boolean f6001f = false;

        /* renamed from: g  reason: collision with root package name */
        private static Constructor<WindowInsets> f6002g = null;

        /* renamed from: h  reason: collision with root package name */
        private static boolean f6003h = false;

        /* renamed from: c  reason: collision with root package name */
        private WindowInsets f6004c;

        /* renamed from: d  reason: collision with root package name */
        private Insets f6005d;

        BuilderImpl20() {
            this.f6004c = h();
        }

        private static WindowInsets h() {
            if (!f6001f) {
                try {
                    f6000e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e8) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e8);
                }
                f6001f = true;
            }
            Field field = f6000e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e9) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e9);
                }
            }
            if (!f6003h) {
                try {
                    f6002g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e10) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e10);
                }
                f6003h = true;
            }
            Constructor<WindowInsets> constructor = f6002g;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e11) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e11);
                }
            }
            return null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        @NonNull
        WindowInsetsCompat b() {
            a();
            WindowInsetsCompat v7 = WindowInsetsCompat.v(this.f6004c);
            v7.q(this.f5999b);
            v7.t(this.f6005d);
            return v7;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void d(Insets insets) {
            this.f6005d = insets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void f(@NonNull Insets insets) {
            WindowInsets windowInsets = this.f6004c;
            if (windowInsets != null) {
                this.f6004c = windowInsets.replaceSystemWindowInsets(insets.f5737a, insets.f5738b, insets.f5739c, insets.f5740d);
            }
        }

        BuilderImpl20(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            this.f6004c = windowInsetsCompat.u();
        }
    }

    /* loaded from: classes.dex */
    private static class BuilderImpl29 extends BuilderImpl {

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets$Builder f6006c;

        BuilderImpl29() {
            this.f6006c = new WindowInsets$Builder();
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        @NonNull
        WindowInsetsCompat b() {
            a();
            WindowInsetsCompat v7 = WindowInsetsCompat.v(this.f6006c.build());
            v7.q(this.f5999b);
            return v7;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void c(@NonNull Insets insets) {
            this.f6006c.setMandatorySystemGestureInsets(insets.e());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void d(@NonNull Insets insets) {
            this.f6006c.setStableInsets(insets.e());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void e(@NonNull Insets insets) {
            this.f6006c.setSystemGestureInsets(insets.e());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void f(@NonNull Insets insets) {
            this.f6006c.setSystemWindowInsets(insets.e());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void g(@NonNull Insets insets) {
            this.f6006c.setTappableElementInsets(insets.e());
        }

        BuilderImpl29(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            WindowInsets$Builder windowInsets$Builder;
            WindowInsets u7 = windowInsetsCompat.u();
            if (u7 != null) {
                windowInsets$Builder = new WindowInsets$Builder(u7);
            } else {
                windowInsets$Builder = new WindowInsets$Builder();
            }
            this.f6006c = windowInsets$Builder;
        }
    }

    /* loaded from: classes.dex */
    private static class Impl21 extends Impl20 {

        /* renamed from: m  reason: collision with root package name */
        private Insets f6019m;

        Impl21(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.f6019m = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        WindowInsetsCompat b() {
            return WindowInsetsCompat.v(this.f6014c.consumeStableInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        WindowInsetsCompat c() {
            return WindowInsetsCompat.v(this.f6014c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        final Insets i() {
            if (this.f6019m == null) {
                this.f6019m = Insets.b(this.f6014c.getStableInsetLeft(), this.f6014c.getStableInsetTop(), this.f6014c.getStableInsetRight(), this.f6014c.getStableInsetBottom());
            }
            return this.f6019m;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        boolean n() {
            return this.f6014c.isConsumed();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void s(Insets insets) {
            this.f6019m = insets;
        }

        Impl21(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl21 impl21) {
            super(windowInsetsCompat, impl21);
            this.f6019m = null;
            this.f6019m = impl21.f6019m;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Impl20 extends Impl {

        /* renamed from: h  reason: collision with root package name */
        private static boolean f6009h = false;

        /* renamed from: i  reason: collision with root package name */
        private static Method f6010i;

        /* renamed from: j  reason: collision with root package name */
        private static Class<?> f6011j;

        /* renamed from: k  reason: collision with root package name */
        private static Field f6012k;

        /* renamed from: l  reason: collision with root package name */
        private static Field f6013l;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets f6014c;

        /* renamed from: d  reason: collision with root package name */
        private Insets[] f6015d;

        /* renamed from: e  reason: collision with root package name */
        private Insets f6016e;

        /* renamed from: f  reason: collision with root package name */
        private WindowInsetsCompat f6017f;

        /* renamed from: g  reason: collision with root package name */
        Insets f6018g;

        Impl20(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.f6016e = null;
            this.f6014c = windowInsets;
        }

        @NonNull
        @SuppressLint({"WrongConstant"})
        private Insets t(int i8, boolean z7) {
            Insets insets = Insets.f5736e;
            for (int i9 = 1; i9 <= 256; i9 <<= 1) {
                if ((i8 & i9) != 0) {
                    insets = Insets.a(insets, u(i9, z7));
                }
            }
            return insets;
        }

        private Insets v() {
            WindowInsetsCompat windowInsetsCompat = this.f6017f;
            if (windowInsetsCompat != null) {
                return windowInsetsCompat.g();
            }
            return Insets.f5736e;
        }

        private Insets w(@NonNull View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!f6009h) {
                    x();
                }
                Method method = f6010i;
                if (method != null && f6011j != null && f6012k != null) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke == null) {
                            Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return null;
                        }
                        Rect rect = (Rect) f6012k.get(f6013l.get(invoke));
                        if (rect == null) {
                            return null;
                        }
                        return Insets.c(rect);
                    } catch (ReflectiveOperationException e8) {
                        Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e8.getMessage(), e8);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @SuppressLint({"PrivateApi"})
        private static void x() {
            try {
                f6010i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f6011j = cls;
                f6012k = cls.getDeclaredField("mVisibleInsets");
                f6013l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f6012k.setAccessible(true);
                f6013l.setAccessible(true);
            } catch (ReflectiveOperationException e8) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e8.getMessage(), e8);
            }
            f6009h = true;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        void d(@NonNull View view) {
            Insets w7 = w(view);
            if (w7 == null) {
                w7 = Insets.f5736e;
            }
            q(w7);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        void e(@NonNull WindowInsetsCompat windowInsetsCompat) {
            windowInsetsCompat.s(this.f6017f);
            windowInsetsCompat.r(this.f6018g);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.f6018g, ((Impl20) obj).f6018g);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets g(int i8) {
            return t(i8, false);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        final Insets k() {
            if (this.f6016e == null) {
                this.f6016e = Insets.b(this.f6014c.getSystemWindowInsetLeft(), this.f6014c.getSystemWindowInsetTop(), this.f6014c.getSystemWindowInsetRight(), this.f6014c.getSystemWindowInsetBottom());
            }
            return this.f6016e;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        WindowInsetsCompat m(int i8, int i9, int i10, int i11) {
            Builder builder = new Builder(WindowInsetsCompat.v(this.f6014c));
            builder.c(WindowInsetsCompat.n(k(), i8, i9, i10, i11));
            builder.b(WindowInsetsCompat.n(i(), i8, i9, i10, i11));
            return builder.a();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        boolean o() {
            return this.f6014c.isRound();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void p(Insets[] insetsArr) {
            this.f6015d = insetsArr;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        void q(@NonNull Insets insets) {
            this.f6018g = insets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        void r(WindowInsetsCompat windowInsetsCompat) {
            this.f6017f = windowInsetsCompat;
        }

        @NonNull
        protected Insets u(int i8, boolean z7) {
            int i9;
            DisplayCutoutCompat f8;
            if (i8 != 1) {
                Insets insets = null;
                if (i8 != 2) {
                    if (i8 != 8) {
                        if (i8 != 16) {
                            if (i8 != 32) {
                                if (i8 != 64) {
                                    if (i8 != 128) {
                                        return Insets.f5736e;
                                    }
                                    WindowInsetsCompat windowInsetsCompat = this.f6017f;
                                    if (windowInsetsCompat != null) {
                                        f8 = windowInsetsCompat.e();
                                    } else {
                                        f8 = f();
                                    }
                                    if (f8 != null) {
                                        return Insets.b(f8.b(), f8.d(), f8.c(), f8.a());
                                    }
                                    return Insets.f5736e;
                                }
                                return l();
                            }
                            return h();
                        }
                        return j();
                    }
                    Insets[] insetsArr = this.f6015d;
                    if (insetsArr != null) {
                        insets = insetsArr[Type.a(8)];
                    }
                    if (insets != null) {
                        return insets;
                    }
                    Insets k8 = k();
                    Insets v7 = v();
                    int i10 = k8.f5740d;
                    if (i10 > v7.f5740d) {
                        return Insets.b(0, 0, 0, i10);
                    }
                    Insets insets2 = this.f6018g;
                    if (insets2 != null && !insets2.equals(Insets.f5736e) && (i9 = this.f6018g.f5740d) > v7.f5740d) {
                        return Insets.b(0, 0, 0, i9);
                    }
                    return Insets.f5736e;
                } else if (z7) {
                    Insets v8 = v();
                    Insets i11 = i();
                    return Insets.b(Math.max(v8.f5737a, i11.f5737a), 0, Math.max(v8.f5739c, i11.f5739c), Math.max(v8.f5740d, i11.f5740d));
                } else {
                    Insets k9 = k();
                    WindowInsetsCompat windowInsetsCompat2 = this.f6017f;
                    if (windowInsetsCompat2 != null) {
                        insets = windowInsetsCompat2.g();
                    }
                    int i12 = k9.f5740d;
                    if (insets != null) {
                        i12 = Math.min(i12, insets.f5740d);
                    }
                    return Insets.b(k9.f5737a, 0, k9.f5739c, i12);
                }
            } else if (z7) {
                return Insets.b(0, Math.max(v().f5738b, k().f5738b), 0, 0);
            } else {
                return Insets.b(0, k().f5738b, 0, 0);
            }
        }

        Impl20(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl20 impl20) {
            this(windowInsetsCompat, new WindowInsets(impl20.f6014c));
        }
    }

    /* loaded from: classes.dex */
    private static class Impl29 extends Impl28 {

        /* renamed from: n  reason: collision with root package name */
        private Insets f6020n;

        /* renamed from: o  reason: collision with root package name */
        private Insets f6021o;

        /* renamed from: p  reason: collision with root package name */
        private Insets f6022p;

        Impl29(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.f6020n = null;
            this.f6021o = null;
            this.f6022p = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        Insets h() {
            android.graphics.Insets mandatorySystemGestureInsets;
            if (this.f6021o == null) {
                mandatorySystemGestureInsets = this.f6014c.getMandatorySystemGestureInsets();
                this.f6021o = Insets.d(mandatorySystemGestureInsets);
            }
            return this.f6021o;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        Insets j() {
            android.graphics.Insets systemGestureInsets;
            if (this.f6020n == null) {
                systemGestureInsets = this.f6014c.getSystemGestureInsets();
                this.f6020n = Insets.d(systemGestureInsets);
            }
            return this.f6020n;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        Insets l() {
            android.graphics.Insets tappableElementInsets;
            if (this.f6022p == null) {
                tappableElementInsets = this.f6014c.getTappableElementInsets();
                this.f6022p = Insets.d(tappableElementInsets);
            }
            return this.f6022p;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        WindowInsetsCompat m(int i8, int i9, int i10, int i11) {
            WindowInsets inset;
            inset = this.f6014c.inset(i8, i9, i10, i11);
            return WindowInsetsCompat.v(inset);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl21, androidx.core.view.WindowInsetsCompat.Impl
        public void s(Insets insets) {
        }

        Impl29(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl29 impl29) {
            super(windowInsetsCompat, impl29);
            this.f6020n = null;
            this.f6021o = null;
            this.f6022p = null;
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final BuilderImpl f5997a;

        public Builder() {
            int i8 = Build.VERSION.SDK_INT;
            if (i8 >= 30) {
                this.f5997a = new BuilderImpl30();
            } else if (i8 >= 29) {
                this.f5997a = new BuilderImpl29();
            } else {
                this.f5997a = new BuilderImpl20();
            }
        }

        @NonNull
        public WindowInsetsCompat a() {
            return this.f5997a.b();
        }

        @NonNull
        @Deprecated
        public Builder b(@NonNull Insets insets) {
            this.f5997a.d(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder c(@NonNull Insets insets) {
            this.f5997a.f(insets);
            return this;
        }

        public Builder(@NonNull WindowInsetsCompat windowInsetsCompat) {
            int i8 = Build.VERSION.SDK_INT;
            if (i8 >= 30) {
                this.f5997a = new BuilderImpl30(windowInsetsCompat);
            } else if (i8 >= 29) {
                this.f5997a = new BuilderImpl29(windowInsetsCompat);
            } else {
                this.f5997a = new BuilderImpl20(windowInsetsCompat);
            }
        }
    }

    public WindowInsetsCompat(WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            Impl impl = windowInsetsCompat.f5992a;
            int i8 = Build.VERSION.SDK_INT;
            if (i8 >= 30 && (impl instanceof Impl30)) {
                this.f5992a = new Impl30(this, (Impl30) impl);
            } else if (i8 >= 29 && (impl instanceof Impl29)) {
                this.f5992a = new Impl29(this, (Impl29) impl);
            } else if (i8 >= 28 && (impl instanceof Impl28)) {
                this.f5992a = new Impl28(this, (Impl28) impl);
            } else if (impl instanceof Impl21) {
                this.f5992a = new Impl21(this, (Impl21) impl);
            } else if (impl instanceof Impl20) {
                this.f5992a = new Impl20(this, (Impl20) impl);
            } else {
                this.f5992a = new Impl(this);
            }
            impl.e(this);
            return;
        }
        this.f5992a = new Impl(this);
    }
}
