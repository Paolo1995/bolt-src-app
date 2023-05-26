package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper;

/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a  reason: collision with root package name */
    ViewDragHelper f12917a;

    /* renamed from: b  reason: collision with root package name */
    OnDismissListener f12918b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12919c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12920d;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12922f;

    /* renamed from: e  reason: collision with root package name */
    private float f12921e = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    int f12923g = 2;

    /* renamed from: h  reason: collision with root package name */
    float f12924h = 0.5f;

    /* renamed from: i  reason: collision with root package name */
    float f12925i = 0.0f;

    /* renamed from: j  reason: collision with root package name */
    float f12926j = 0.5f;

    /* renamed from: k  reason: collision with root package name */
    private final ViewDragHelper.Callback f12927k = new ViewDragHelper.Callback() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.1

        /* renamed from: a  reason: collision with root package name */
        private int f12928a;

        /* renamed from: b  reason: collision with root package name */
        private int f12929b = -1;

        private boolean n(@NonNull View view, float f8) {
            boolean z7;
            int i8 = (f8 > 0.0f ? 1 : (f8 == 0.0f ? 0 : -1));
            if (i8 != 0) {
                if (ViewCompat.E(view) == 1) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                int i9 = SwipeDismissBehavior.this.f12923g;
                if (i9 == 2) {
                    return true;
                }
                if (i9 == 0) {
                    if (z7) {
                        if (f8 >= 0.0f) {
                            return false;
                        }
                    } else if (i8 <= 0) {
                        return false;
                    }
                    return true;
                } else if (i9 != 1) {
                    return false;
                } else {
                    if (z7) {
                        if (i8 <= 0) {
                            return false;
                        }
                    } else if (f8 >= 0.0f) {
                        return false;
                    }
                    return true;
                }
            }
            int left = view.getLeft() - this.f12928a;
            if (Math.abs(left) < Math.round(view.getWidth() * SwipeDismissBehavior.this.f12924h)) {
                return false;
            }
            return true;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int a(@NonNull View view, int i8, int i9) {
            boolean z7;
            int width;
            int width2;
            int width3;
            if (ViewCompat.E(view) == 1) {
                z7 = true;
            } else {
                z7 = false;
            }
            int i10 = SwipeDismissBehavior.this.f12923g;
            if (i10 == 0) {
                if (z7) {
                    width = this.f12928a - view.getWidth();
                    width2 = this.f12928a;
                } else {
                    width = this.f12928a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i10 == 1) {
                if (z7) {
                    width = this.f12928a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                } else {
                    width = this.f12928a - view.getWidth();
                    width2 = this.f12928a;
                }
            } else {
                width = this.f12928a - view.getWidth();
                width2 = view.getWidth() + this.f12928a;
            }
            return SwipeDismissBehavior.H(width, i8, width2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int b(@NonNull View view, int i8, int i9) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int d(@NonNull View view) {
            return view.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void i(@NonNull View view, int i8) {
            this.f12929b = i8;
            this.f12928a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                SwipeDismissBehavior.this.f12920d = true;
                parent.requestDisallowInterceptTouchEvent(true);
                SwipeDismissBehavior.this.f12920d = false;
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void j(int i8) {
            OnDismissListener onDismissListener = SwipeDismissBehavior.this.f12918b;
            if (onDismissListener != null) {
                onDismissListener.b(i8);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void k(@NonNull View view, int i8, int i9, int i10, int i11) {
            float width = view.getWidth() * SwipeDismissBehavior.this.f12925i;
            float width2 = view.getWidth() * SwipeDismissBehavior.this.f12926j;
            float abs = Math.abs(i8 - this.f12928a);
            if (abs <= width) {
                view.setAlpha(1.0f);
            } else if (abs >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.G(0.0f, 1.0f - SwipeDismissBehavior.J(width, width2, abs), 1.0f));
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void l(@NonNull View view, float f8, float f9) {
            int i8;
            boolean z7;
            OnDismissListener onDismissListener;
            this.f12929b = -1;
            int width = view.getWidth();
            if (n(view, f8)) {
                if (f8 >= 0.0f) {
                    int left = view.getLeft();
                    int i9 = this.f12928a;
                    if (left >= i9) {
                        i8 = i9 + width;
                        z7 = true;
                    }
                }
                i8 = this.f12928a - width;
                z7 = true;
            } else {
                i8 = this.f12928a;
                z7 = false;
            }
            if (SwipeDismissBehavior.this.f12917a.M(i8, view.getTop())) {
                ViewCompat.k0(view, new SettleRunnable(view, z7));
            } else if (z7 && (onDismissListener = SwipeDismissBehavior.this.f12918b) != null) {
                onDismissListener.a(view);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean m(View view, int i8) {
            int i9 = this.f12929b;
            if ((i9 == -1 || i9 == i8) && SwipeDismissBehavior.this.F(view)) {
                return true;
            }
            return false;
        }
    };

    /* loaded from: classes.dex */
    public interface OnDismissListener {
        void a(View view);

        void b(int i8);
    }

    /* loaded from: classes.dex */
    private class SettleRunnable implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final View f12932f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f12933g;

        SettleRunnable(View view, boolean z7) {
            this.f12932f = view;
            this.f12933g = z7;
        }

        @Override // java.lang.Runnable
        public void run() {
            OnDismissListener onDismissListener;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.f12917a;
            if (viewDragHelper != null && viewDragHelper.m(true)) {
                ViewCompat.k0(this.f12932f, this);
            } else if (this.f12933g && (onDismissListener = SwipeDismissBehavior.this.f12918b) != null) {
                onDismissListener.a(this.f12932f);
            }
        }
    }

    static float G(float f8, float f9, float f10) {
        return Math.min(Math.max(f8, f9), f10);
    }

    static int H(int i8, int i9, int i10) {
        return Math.min(Math.max(i8, i9), i10);
    }

    private void I(ViewGroup viewGroup) {
        ViewDragHelper o8;
        if (this.f12917a == null) {
            if (this.f12922f) {
                o8 = ViewDragHelper.n(viewGroup, this.f12921e, this.f12927k);
            } else {
                o8 = ViewDragHelper.o(viewGroup, this.f12927k);
            }
            this.f12917a = o8;
        }
    }

    static float J(float f8, float f9, float f10) {
        return (f10 - f8) / (f9 - f8);
    }

    private void O(View view) {
        ViewCompat.m0(view, 1048576);
        if (F(view)) {
            ViewCompat.o0(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6061y, null, new AccessibilityViewCommand() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.2
                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public boolean a(@NonNull View view2, AccessibilityViewCommand.CommandArguments commandArguments) {
                    boolean z7;
                    boolean z8 = false;
                    if (!SwipeDismissBehavior.this.F(view2)) {
                        return false;
                    }
                    if (ViewCompat.E(view2) == 1) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    int i8 = SwipeDismissBehavior.this.f12923g;
                    if ((i8 == 0 && z7) || (i8 == 1 && !z7)) {
                        z8 = true;
                    }
                    int width = view2.getWidth();
                    if (z8) {
                        width = -width;
                    }
                    ViewCompat.c0(view2, width);
                    view2.setAlpha(0.0f);
                    OnDismissListener onDismissListener = SwipeDismissBehavior.this.f12918b;
                    if (onDismissListener != null) {
                        onDismissListener.a(view2);
                    }
                    return true;
                }
            });
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean D(CoordinatorLayout coordinatorLayout, V v7, MotionEvent motionEvent) {
        if (this.f12917a != null) {
            if (!this.f12920d || motionEvent.getActionMasked() != 3) {
                this.f12917a.F(motionEvent);
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean F(@NonNull View view) {
        return true;
    }

    public void K(float f8) {
        this.f12926j = G(0.0f, f8, 1.0f);
    }

    public void L(OnDismissListener onDismissListener) {
        this.f12918b = onDismissListener;
    }

    public void M(float f8) {
        this.f12925i = G(0.0f, f8, 1.0f);
    }

    public void N(int i8) {
        this.f12923g = i8;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull MotionEvent motionEvent) {
        boolean z7 = this.f12919c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                this.f12919c = false;
            }
        } else {
            z7 = coordinatorLayout.C(v7, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f12919c = z7;
        }
        if (!z7) {
            return false;
        }
        I(coordinatorLayout);
        if (!this.f12920d && this.f12917a.N(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, int i8) {
        boolean l8 = super.l(coordinatorLayout, v7, i8);
        if (ViewCompat.C(v7) == 0) {
            ViewCompat.D0(v7, 1);
            O(v7);
        }
        return l8;
    }
}
