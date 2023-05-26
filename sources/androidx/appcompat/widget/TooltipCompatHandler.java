package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class TooltipCompatHandler implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: p  reason: collision with root package name */
    private static TooltipCompatHandler f2265p;

    /* renamed from: q  reason: collision with root package name */
    private static TooltipCompatHandler f2266q;

    /* renamed from: f  reason: collision with root package name */
    private final View f2267f;

    /* renamed from: g  reason: collision with root package name */
    private final CharSequence f2268g;

    /* renamed from: h  reason: collision with root package name */
    private final int f2269h;

    /* renamed from: i  reason: collision with root package name */
    private final Runnable f2270i = new Runnable() { // from class: androidx.appcompat.widget.p0
        @Override // java.lang.Runnable
        public final void run() {
            TooltipCompatHandler.this.e();
        }
    };

    /* renamed from: j  reason: collision with root package name */
    private final Runnable f2271j = new Runnable() { // from class: androidx.appcompat.widget.q0
        @Override // java.lang.Runnable
        public final void run() {
            TooltipCompatHandler.this.d();
        }
    };

    /* renamed from: k  reason: collision with root package name */
    private int f2272k;

    /* renamed from: l  reason: collision with root package name */
    private int f2273l;

    /* renamed from: m  reason: collision with root package name */
    private TooltipPopup f2274m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f2275n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f2276o;

    private TooltipCompatHandler(View view, CharSequence charSequence) {
        this.f2267f = view;
        this.f2268g = charSequence;
        this.f2269h = ViewConfigurationCompat.c(ViewConfiguration.get(view.getContext()));
        c();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void b() {
        this.f2267f.removeCallbacks(this.f2270i);
    }

    private void c() {
        this.f2276o = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        i(false);
    }

    private void f() {
        this.f2267f.postDelayed(this.f2270i, ViewConfiguration.getLongPressTimeout());
    }

    private static void g(TooltipCompatHandler tooltipCompatHandler) {
        TooltipCompatHandler tooltipCompatHandler2 = f2265p;
        if (tooltipCompatHandler2 != null) {
            tooltipCompatHandler2.b();
        }
        f2265p = tooltipCompatHandler;
        if (tooltipCompatHandler != null) {
            tooltipCompatHandler.f();
        }
    }

    public static void h(View view, CharSequence charSequence) {
        TooltipCompatHandler tooltipCompatHandler = f2265p;
        if (tooltipCompatHandler != null && tooltipCompatHandler.f2267f == view) {
            g(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            TooltipCompatHandler tooltipCompatHandler2 = f2266q;
            if (tooltipCompatHandler2 != null && tooltipCompatHandler2.f2267f == view) {
                tooltipCompatHandler2.d();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new TooltipCompatHandler(view, charSequence);
    }

    private boolean j(MotionEvent motionEvent) {
        int x7 = (int) motionEvent.getX();
        int y7 = (int) motionEvent.getY();
        if (!this.f2276o && Math.abs(x7 - this.f2272k) <= this.f2269h && Math.abs(y7 - this.f2273l) <= this.f2269h) {
            return false;
        }
        this.f2272k = x7;
        this.f2273l = y7;
        this.f2276o = false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (f2266q == this) {
            f2266q = null;
            TooltipPopup tooltipPopup = this.f2274m;
            if (tooltipPopup != null) {
                tooltipPopup.c();
                this.f2274m = null;
                c();
                this.f2267f.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f2265p == this) {
            g(null);
        }
        this.f2267f.removeCallbacks(this.f2271j);
    }

    void i(boolean z7) {
        long j8;
        int longPressTimeout;
        long j9;
        if (!ViewCompat.V(this.f2267f)) {
            return;
        }
        g(null);
        TooltipCompatHandler tooltipCompatHandler = f2266q;
        if (tooltipCompatHandler != null) {
            tooltipCompatHandler.d();
        }
        f2266q = this;
        this.f2275n = z7;
        TooltipPopup tooltipPopup = new TooltipPopup(this.f2267f.getContext());
        this.f2274m = tooltipPopup;
        tooltipPopup.e(this.f2267f, this.f2272k, this.f2273l, this.f2275n, this.f2268g);
        this.f2267f.addOnAttachStateChangeListener(this);
        if (this.f2275n) {
            j9 = 2500;
        } else {
            if ((ViewCompat.O(this.f2267f) & 1) == 1) {
                j8 = 3000;
                longPressTimeout = ViewConfiguration.getLongPressTimeout();
            } else {
                j8 = 15000;
                longPressTimeout = ViewConfiguration.getLongPressTimeout();
            }
            j9 = j8 - longPressTimeout;
        }
        this.f2267f.removeCallbacks(this.f2271j);
        this.f2267f.postDelayed(this.f2271j, j9);
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f2274m != null && this.f2275n) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f2267f.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                d();
            }
        } else if (this.f2267f.isEnabled() && this.f2274m == null && j(motionEvent)) {
            g(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f2272k = view.getWidth() / 2;
        this.f2273l = view.getHeight() / 2;
        i(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        d();
    }
}
