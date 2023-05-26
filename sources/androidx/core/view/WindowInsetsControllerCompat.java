package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.FragmentTransaction;

/* loaded from: classes.dex */
public final class WindowInsetsControllerCompat {

    /* renamed from: a  reason: collision with root package name */
    private final Impl f6024a;

    /* loaded from: classes.dex */
    private static class Impl {
        Impl() {
        }

        public boolean a() {
            return false;
        }

        public boolean b() {
            return false;
        }

        public void c(boolean z7) {
        }

        public void d(boolean z7) {
        }
    }

    /* loaded from: classes.dex */
    private static class Impl20 extends Impl {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        protected final Window f6025a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final View f6026b;

        Impl20(@NonNull Window window, @NonNull View view) {
            this.f6025a = window;
            this.f6026b = view;
        }

        protected void e(int i8) {
            View decorView = this.f6025a.getDecorView();
            decorView.setSystemUiVisibility(i8 | decorView.getSystemUiVisibility());
        }

        protected void f(int i8) {
            this.f6025a.addFlags(i8);
        }

        protected void g(int i8) {
            View decorView = this.f6025a.getDecorView();
            decorView.setSystemUiVisibility((~i8) & decorView.getSystemUiVisibility());
        }

        protected void h(int i8) {
            this.f6025a.clearFlags(i8);
        }
    }

    /* loaded from: classes.dex */
    private static class Impl23 extends Impl20 {
        Impl23(@NonNull Window window, View view) {
            super(window, view);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean b() {
            if ((this.f6025a.getDecorView().getSystemUiVisibility() & FragmentTransaction.TRANSIT_EXIT_MASK) != 0) {
                return true;
            }
            return false;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void d(boolean z7) {
            if (z7) {
                h(67108864);
                f(Integer.MIN_VALUE);
                e(FragmentTransaction.TRANSIT_EXIT_MASK);
                return;
            }
            g(FragmentTransaction.TRANSIT_EXIT_MASK);
        }
    }

    /* loaded from: classes.dex */
    private static class Impl26 extends Impl23 {
        Impl26(@NonNull Window window, View view) {
            super(window, view);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean a() {
            if ((this.f6025a.getDecorView().getSystemUiVisibility() & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void c(boolean z7) {
            if (z7) {
                h(134217728);
                f(Integer.MIN_VALUE);
                e(16);
                return;
            }
            g(16);
        }
    }

    public WindowInsetsControllerCompat(@NonNull Window window, @NonNull View view) {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 30) {
            this.f6024a = new Impl30(window, this);
        } else if (i8 >= 26) {
            this.f6024a = new Impl26(window, view);
        } else if (i8 >= 23) {
            this.f6024a = new Impl23(window, view);
        } else {
            this.f6024a = new Impl20(window, view);
        }
    }

    public boolean a() {
        return this.f6024a.a();
    }

    public boolean b() {
        return this.f6024a.b();
    }

    public void c(boolean z7) {
        this.f6024a.c(z7);
    }

    public void d(boolean z7) {
        this.f6024a.d(z7);
    }

    /* loaded from: classes.dex */
    private static class Impl30 extends Impl {

        /* renamed from: a  reason: collision with root package name */
        final WindowInsetsControllerCompat f6027a;

        /* renamed from: b  reason: collision with root package name */
        final WindowInsetsController f6028b;

        /* renamed from: c  reason: collision with root package name */
        private final SimpleArrayMap<Object, WindowInsetsController.OnControllableInsetsChangedListener> f6029c;

        /* renamed from: d  reason: collision with root package name */
        protected Window f6030d;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        Impl30(@androidx.annotation.NonNull android.view.Window r2, @androidx.annotation.NonNull androidx.core.view.WindowInsetsControllerCompat r3) {
            /*
                r1 = this;
                android.view.WindowInsetsController r0 = androidx.core.view.u1.a(r2)
                r1.<init>(r0, r3)
                r1.f6030d = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.WindowInsetsControllerCompat.Impl30.<init>(android.view.Window, androidx.core.view.WindowInsetsControllerCompat):void");
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean a() {
            if ((this.f6028b.getSystemBarsAppearance() & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean b() {
            if ((this.f6028b.getSystemBarsAppearance() & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void c(boolean z7) {
            if (z7) {
                if (this.f6030d != null) {
                    e(16);
                }
                this.f6028b.setSystemBarsAppearance(16, 16);
                return;
            }
            if (this.f6030d != null) {
                f(16);
            }
            this.f6028b.setSystemBarsAppearance(0, 16);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void d(boolean z7) {
            if (z7) {
                if (this.f6030d != null) {
                    e(FragmentTransaction.TRANSIT_EXIT_MASK);
                }
                this.f6028b.setSystemBarsAppearance(8, 8);
                return;
            }
            if (this.f6030d != null) {
                f(FragmentTransaction.TRANSIT_EXIT_MASK);
            }
            this.f6028b.setSystemBarsAppearance(0, 8);
        }

        protected void e(int i8) {
            View decorView = this.f6030d.getDecorView();
            decorView.setSystemUiVisibility(i8 | decorView.getSystemUiVisibility());
        }

        protected void f(int i8) {
            View decorView = this.f6030d.getDecorView();
            decorView.setSystemUiVisibility((~i8) & decorView.getSystemUiVisibility());
        }

        Impl30(@NonNull WindowInsetsController windowInsetsController, @NonNull WindowInsetsControllerCompat windowInsetsControllerCompat) {
            this.f6029c = new SimpleArrayMap<>();
            this.f6028b = windowInsetsController;
            this.f6027a = windowInsetsControllerCompat;
        }
    }
}
