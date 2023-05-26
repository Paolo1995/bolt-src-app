package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.EdgeToEdgeUtils;
import com.google.android.material.shape.MaterialShapeDrawable;

/* loaded from: classes.dex */
public class BottomSheetDialog extends AppCompatDialog {

    /* renamed from: j  reason: collision with root package name */
    private BottomSheetBehavior<FrameLayout> f13042j;

    /* renamed from: k  reason: collision with root package name */
    private FrameLayout f13043k;

    /* renamed from: l  reason: collision with root package name */
    private CoordinatorLayout f13044l;

    /* renamed from: m  reason: collision with root package name */
    private FrameLayout f13045m;

    /* renamed from: n  reason: collision with root package name */
    boolean f13046n;

    /* renamed from: o  reason: collision with root package name */
    boolean f13047o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f13048p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f13049q;

    /* renamed from: r  reason: collision with root package name */
    private EdgeToEdgeCallback f13050r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f13051s;
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    private BottomSheetBehavior.BottomSheetCallback f13052t;

    /* loaded from: classes.dex */
    private static class EdgeToEdgeCallback extends BottomSheetBehavior.BottomSheetCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Boolean f13058a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final WindowInsetsCompat f13059b;

        /* renamed from: c  reason: collision with root package name */
        private Window f13060c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f13061d;

        private void d(View view) {
            boolean booleanValue;
            if (view.getTop() < this.f13059b.l()) {
                Window window = this.f13060c;
                if (window != null) {
                    Boolean bool = this.f13058a;
                    if (bool == null) {
                        booleanValue = this.f13061d;
                    } else {
                        booleanValue = bool.booleanValue();
                    }
                    EdgeToEdgeUtils.f(window, booleanValue);
                }
                view.setPadding(view.getPaddingLeft(), this.f13059b.l() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            } else if (view.getTop() != 0) {
                Window window2 = this.f13060c;
                if (window2 != null) {
                    EdgeToEdgeUtils.f(window2, this.f13061d);
                }
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        void a(@NonNull View view) {
            d(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void b(@NonNull View view, float f8) {
            d(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void c(@NonNull View view, int i8) {
            d(view);
        }

        void e(Window window) {
            if (this.f13060c == window) {
                return;
            }
            this.f13060c = window;
            if (window != null) {
                this.f13061d = WindowCompat.a(window, window.getDecorView()).b();
            }
        }

        private EdgeToEdgeCallback(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            ColorStateList u7;
            this.f13059b = windowInsetsCompat;
            MaterialShapeDrawable n02 = BottomSheetBehavior.k0(view).n0();
            if (n02 != null) {
                u7 = n02.x();
            } else {
                u7 = ViewCompat.u(view);
            }
            if (u7 != null) {
                this.f13058a = Boolean.valueOf(MaterialColors.h(u7.getDefaultColor()));
            } else if (view.getBackground() instanceof ColorDrawable) {
                this.f13058a = Boolean.valueOf(MaterialColors.h(((ColorDrawable) view.getBackground()).getColor()));
            } else {
                this.f13058a = null;
            }
        }
    }

    public BottomSheetDialog(@NonNull Context context, int i8) {
        super(context, f(context, i8));
        this.f13047o = true;
        this.f13048p = true;
        this.f13052t = new BottomSheetBehavior.BottomSheetCallback() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.5
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void b(@NonNull View view, float f8) {
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void c(@NonNull View view, int i9) {
                if (i9 == 5) {
                    BottomSheetDialog.this.cancel();
                }
            }
        };
        h(1);
        this.f13051s = getContext().getTheme().obtainStyledAttributes(new int[]{R$attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    private static int f(@NonNull Context context, int i8) {
        if (i8 == 0) {
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(R$attr.bottomSheetDialogTheme, typedValue, true)) {
                return typedValue.resourceId;
            }
            return R$style.Theme_Design_Light_BottomSheetDialog;
        }
        return i8;
    }

    private FrameLayout m() {
        if (this.f13043k == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R$layout.design_bottom_sheet_dialog, null);
            this.f13043k = frameLayout;
            this.f13044l = (CoordinatorLayout) frameLayout.findViewById(R$id.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.f13043k.findViewById(R$id.f12491f);
            this.f13045m = frameLayout2;
            BottomSheetBehavior<FrameLayout> k02 = BottomSheetBehavior.k0(frameLayout2);
            this.f13042j = k02;
            k02.Y(this.f13052t);
            this.f13042j.I0(this.f13047o);
        }
        return this.f13043k;
    }

    private View r(int i8, View view, ViewGroup.LayoutParams layoutParams) {
        m();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f13043k.findViewById(R$id.coordinator);
        if (i8 != 0 && view == null) {
            view = getLayoutInflater().inflate(i8, (ViewGroup) coordinatorLayout, false);
        }
        if (this.f13051s) {
            ViewCompat.G0(this.f13045m, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.1
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public WindowInsetsCompat a(View view2, WindowInsetsCompat windowInsetsCompat) {
                    if (BottomSheetDialog.this.f13050r != null) {
                        BottomSheetDialog.this.f13042j.y0(BottomSheetDialog.this.f13050r);
                    }
                    if (windowInsetsCompat != null) {
                        BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                        bottomSheetDialog.f13050r = new EdgeToEdgeCallback(bottomSheetDialog.f13045m, windowInsetsCompat);
                        BottomSheetDialog.this.f13050r.e(BottomSheetDialog.this.getWindow());
                        BottomSheetDialog.this.f13042j.Y(BottomSheetDialog.this.f13050r);
                    }
                    return windowInsetsCompat;
                }
            });
        }
        this.f13045m.removeAllViews();
        if (layoutParams == null) {
            this.f13045m.addView(view);
        } else {
            this.f13045m.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R$id.touch_outside).setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                if (bottomSheetDialog.f13047o && bottomSheetDialog.isShowing() && BottomSheetDialog.this.q()) {
                    BottomSheetDialog.this.cancel();
                }
            }
        });
        ViewCompat.s0(this.f13045m, new AccessibilityDelegateCompat() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.3
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void g(View view2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view2, accessibilityNodeInfoCompat);
                if (BottomSheetDialog.this.f13047o) {
                    accessibilityNodeInfoCompat.a(1048576);
                    accessibilityNodeInfoCompat.d0(true);
                    return;
                }
                accessibilityNodeInfoCompat.d0(false);
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public boolean j(View view2, int i9, Bundle bundle) {
                if (i9 == 1048576) {
                    BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                    if (bottomSheetDialog.f13047o) {
                        bottomSheetDialog.cancel();
                        return true;
                    }
                }
                return super.j(view2, i9, bundle);
            }
        });
        this.f13045m.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.bottomsheet.BottomSheetDialog.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return true;
            }
        });
        return this.f13043k;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> n8 = n();
        if (this.f13046n && n8.p0() != 5) {
            n8.Q0(5);
        } else {
            super.cancel();
        }
    }

    @NonNull
    public BottomSheetBehavior<FrameLayout> n() {
        if (this.f13042j == null) {
            m();
        }
        return this.f13042j;
    }

    public boolean o() {
        return this.f13046n;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        boolean z7;
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            if (this.f13051s && Color.alpha(window.getNavigationBarColor()) < 255) {
                z7 = true;
            } else {
                z7 = false;
            }
            FrameLayout frameLayout = this.f13043k;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z7);
            }
            CoordinatorLayout coordinatorLayout = this.f13044l;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z7);
            }
            WindowCompat.b(window, !z7);
            EdgeToEdgeCallback edgeToEdgeCallback = this.f13050r;
            if (edgeToEdgeCallback != null) {
                edgeToEdgeCallback.e(window);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            int i8 = Build.VERSION.SDK_INT;
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            if (i8 < 23) {
                window.addFlags(67108864);
            }
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        EdgeToEdgeCallback edgeToEdgeCallback = this.f13050r;
        if (edgeToEdgeCallback != null) {
            edgeToEdgeCallback.e(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f13042j;
        if (bottomSheetBehavior != null && bottomSheetBehavior.p0() == 5) {
            this.f13042j.Q0(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        this.f13042j.y0(this.f13052t);
    }

    boolean q() {
        if (!this.f13049q) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
            this.f13048p = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.f13049q = true;
        }
        return this.f13048p;
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z7) {
        super.setCancelable(z7);
        if (this.f13047o != z7) {
            this.f13047o = z7;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f13042j;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.I0(z7);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z7) {
        super.setCanceledOnTouchOutside(z7);
        if (z7 && !this.f13047o) {
            this.f13047o = true;
        }
        this.f13048p = z7;
        this.f13049q = true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int i8) {
        super.setContentView(r(i8, null, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(r(0, view, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(r(0, view, layoutParams));
    }
}
