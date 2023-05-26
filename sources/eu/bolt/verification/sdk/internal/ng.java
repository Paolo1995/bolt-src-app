package eu.bolt.verification.sdk.internal;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentTransaction;
import eu.bolt.verification.R$color;
import eu.bolt.verification.R$drawable;
import eu.bolt.verification.sdk.internal.mg;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes5.dex */
public final class ng implements mg {

    /* renamed from: d  reason: collision with root package name */
    public static final a f44326d = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final Activity f44327a;

    /* renamed from: b  reason: collision with root package name */
    private final jc f44328b;

    /* renamed from: c  reason: collision with root package name */
    private mg.a f44329c;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public ng(Activity activity, jc navigationBarController) {
        Intrinsics.f(activity, "activity");
        Intrinsics.f(navigationBarController, "navigationBarController");
        this.f44327a = activity;
        this.f44328b = navigationBarController;
        this.f44329c = new mg.a(false, -16777216, false, false, activity.getWindow().getAttributes().softInputMode, null, navigationBarController.d());
    }

    private final void j(int i8) {
        this.f44327a.getWindow().setSoftInputMode(i8);
        this.f44329c = mg.a.a(this.f44329c, false, 0, false, false, i8, null, null, 111, null);
    }

    private final void k(Window window, int i8, boolean z7) {
        int systemUiVisibility;
        View decorView = window.getDecorView();
        Intrinsics.e(decorView, "window.decorView");
        if (z7) {
            systemUiVisibility = i8 | decorView.getSystemUiVisibility();
        } else {
            systemUiVisibility = (~i8) & decorView.getSystemUiVisibility();
        }
        decorView.setSystemUiVisibility(systemUiVisibility);
    }

    private final void l(boolean z7, boolean z8) {
        Window window = this.f44327a.getWindow();
        int i8 = 5380;
        if (z8) {
            Intrinsics.e(window, "window");
        } else {
            Intrinsics.e(window, "window");
            if (!z7) {
                k(window, 5380, false);
                window.setStatusBarColor(m(z7));
                this.f44329c = mg.a.a(this.f44329c, z7, 0, false, z8, 0, null, null, 118, null);
                View decorView = window.getDecorView();
                Intrinsics.e(decorView, "window.decorView");
                uq.b0(decorView);
            }
            k(window, FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_OPEN, false);
            i8 = 1280;
        }
        k(window, i8, true);
        window.setStatusBarColor(m(z7));
        this.f44329c = mg.a.a(this.f44329c, z7, 0, false, z8, 0, null, null, 118, null);
        View decorView2 = window.getDecorView();
        Intrinsics.e(decorView2, "window.decorView");
        uq.b0(decorView2);
    }

    private final int m(boolean z7) {
        if (!z7 || Build.VERSION.SDK_INT >= 23) {
            return z7 ? f2.b(this.f44327a, R$color.A) : this.f44329c.f();
        }
        return 1711276032;
    }

    @Override // eu.bolt.verification.sdk.internal.mg
    public void a() {
        this.f44328b.a();
    }

    @Override // eu.bolt.verification.sdk.internal.mg
    public mg.a b() {
        return mg.a.a(this.f44329c, false, 0, false, false, 0, null, this.f44328b.d(), 63, null);
    }

    @Override // eu.bolt.verification.sdk.internal.mg
    public Flow<Integer> c() {
        return this.f44328b.b();
    }

    @Override // eu.bolt.verification.sdk.internal.mg
    public void c(boolean z7) {
        Window window = this.f44327a.getWindow();
        if (Build.VERSION.SDK_INT >= 23) {
            Intrinsics.e(window, "window");
            k(window, FragmentTransaction.TRANSIT_EXIT_MASK, z7);
        }
        this.f44329c = mg.a.a(this.f44329c, false, 0, z7, false, 0, null, null, 123, null);
    }

    @Override // eu.bolt.verification.sdk.internal.mg
    public void d(Integer num) {
        Window window = this.f44327a.getWindow();
        if (num == null) {
            window.setBackgroundDrawableResource(R$drawable.background_window_splash);
        } else {
            window.setBackgroundDrawable(new ColorDrawable(num.intValue()));
        }
        this.f44329c = mg.a.a(this.f44329c, false, 0, false, false, 0, num, null, 95, null);
    }

    @Override // eu.bolt.verification.sdk.internal.mg
    public void e(mg.c softInputMode) {
        Intrinsics.f(softInputMode, "softInputMode");
        j(softInputMode.c());
    }

    @Override // eu.bolt.verification.sdk.internal.mg
    public void f(boolean z7) {
        l(z7, this.f44329c.i());
    }

    @Override // eu.bolt.verification.sdk.internal.mg
    public void g(mg.a config) {
        Intrinsics.f(config, "config");
        c(config.c());
        j(config.e());
        d(config.g());
        l(config.h(), config.i());
        this.f44328b.i(config.d());
    }

    @Override // eu.bolt.verification.sdk.internal.mg
    public void h(int i8, boolean z7) {
        this.f44328b.h(i8, z7);
    }

    @Override // eu.bolt.verification.sdk.internal.mg
    public void i(boolean z7) {
        l(this.f44329c.h(), z7);
    }
}
