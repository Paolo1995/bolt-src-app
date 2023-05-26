package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.api.Api;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {

    /* renamed from: d  reason: collision with root package name */
    private Runnable f12820d;

    /* renamed from: e  reason: collision with root package name */
    OverScroller f12821e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12822f;

    /* renamed from: g  reason: collision with root package name */
    private int f12823g;

    /* renamed from: h  reason: collision with root package name */
    private int f12824h;

    /* renamed from: i  reason: collision with root package name */
    private int f12825i;

    /* renamed from: j  reason: collision with root package name */
    private VelocityTracker f12826j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class FlingRunnable implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        private final CoordinatorLayout f12827f;

        /* renamed from: g  reason: collision with root package name */
        private final V f12828g;

        FlingRunnable(CoordinatorLayout coordinatorLayout, V v7) {
            this.f12827f = coordinatorLayout;
            this.f12828g = v7;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f12828g != null && (overScroller = HeaderBehavior.this.f12821e) != null) {
                if (overScroller.computeScrollOffset()) {
                    HeaderBehavior headerBehavior = HeaderBehavior.this;
                    headerBehavior.P(this.f12827f, this.f12828g, headerBehavior.f12821e.getCurrY());
                    ViewCompat.k0(this.f12828g, this);
                    return;
                }
                HeaderBehavior.this.N(this.f12827f, this.f12828g);
            }
        }
    }

    public HeaderBehavior() {
        this.f12823g = -1;
        this.f12825i = -1;
    }

    private void I() {
        if (this.f12826j == null) {
            this.f12826j = VelocityTracker.obtain();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean D(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r12, @androidx.annotation.NonNull V r13, @androidx.annotation.NonNull android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r14.getActionMasked()
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L4e
            r4 = 2
            if (r0 == r4) goto L2d
            r12 = 3
            if (r0 == r12) goto L72
            r12 = 6
            if (r0 == r12) goto L13
            goto L4c
        L13:
            int r12 = r14.getActionIndex()
            if (r12 != 0) goto L1b
            r12 = 1
            goto L1c
        L1b:
            r12 = 0
        L1c:
            int r13 = r14.getPointerId(r12)
            r11.f12823g = r13
            float r12 = r14.getY(r12)
            r13 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r13
            int r12 = (int) r12
            r11.f12824h = r12
            goto L4c
        L2d:
            int r0 = r11.f12823g
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r1) goto L36
            return r3
        L36:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r1 = r11.f12824h
            int r7 = r1 - r0
            r11.f12824h = r0
            int r8 = r11.K(r13)
            r9 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r4.O(r5, r6, r7, r8, r9)
        L4c:
            r12 = 0
            goto L81
        L4e:
            android.view.VelocityTracker r0 = r11.f12826j
            if (r0 == 0) goto L72
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.f12826j
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.f12826j
            int r4 = r11.f12823g
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.L(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.J(r6, r7, r8, r9, r10)
            r12 = 1
            goto L73
        L72:
            r12 = 0
        L73:
            r11.f12822f = r3
            r11.f12823g = r1
            android.view.VelocityTracker r13 = r11.f12826j
            if (r13 == 0) goto L81
            r13.recycle()
            r13 = 0
            r11.f12826j = r13
        L81:
            android.view.VelocityTracker r13 = r11.f12826j
            if (r13 == 0) goto L88
            r13.addMovement(r14)
        L88:
            boolean r13 = r11.f12822f
            if (r13 != 0) goto L90
            if (r12 == 0) goto L8f
            goto L90
        L8f:
            r2 = 0
        L90:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.D(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    boolean H(V v7) {
        return false;
    }

    final boolean J(CoordinatorLayout coordinatorLayout, @NonNull V v7, int i8, int i9, float f8) {
        Runnable runnable = this.f12820d;
        if (runnable != null) {
            v7.removeCallbacks(runnable);
            this.f12820d = null;
        }
        if (this.f12821e == null) {
            this.f12821e = new OverScroller(v7.getContext());
        }
        this.f12821e.fling(0, E(), 0, Math.round(f8), 0, 0, i8, i9);
        if (this.f12821e.computeScrollOffset()) {
            FlingRunnable flingRunnable = new FlingRunnable(coordinatorLayout, v7);
            this.f12820d = flingRunnable;
            ViewCompat.k0(v7, flingRunnable);
            return true;
        }
        N(coordinatorLayout, v7);
        return false;
    }

    int K(@NonNull V v7) {
        return -v7.getHeight();
    }

    int L(@NonNull V v7) {
        return v7.getHeight();
    }

    int M() {
        return E();
    }

    void N(CoordinatorLayout coordinatorLayout, V v7) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int O(CoordinatorLayout coordinatorLayout, V v7, int i8, int i9, int i10) {
        return Q(coordinatorLayout, v7, M() - i8, i9, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int P(CoordinatorLayout coordinatorLayout, V v7, int i8) {
        return Q(coordinatorLayout, v7, i8, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    int Q(CoordinatorLayout coordinatorLayout, V v7, int i8, int i9, int i10) {
        int b8;
        int E = E();
        if (i9 != 0 && E >= i9 && E <= i10 && E != (b8 = MathUtils.b(i8, i9, i10))) {
            G(b8);
            return E - b8;
        }
        return 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v7, @NonNull MotionEvent motionEvent) {
        boolean z7;
        int findPointerIndex;
        if (this.f12825i < 0) {
            this.f12825i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f12822f) {
            int i8 = this.f12823g;
            if (i8 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i8)) == -1) {
                return false;
            }
            int y7 = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y7 - this.f12824h) > this.f12825i) {
                this.f12824h = y7;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f12823g = -1;
            int x7 = (int) motionEvent.getX();
            int y8 = (int) motionEvent.getY();
            if (H(v7) && coordinatorLayout.C(v7, x7, y8)) {
                z7 = true;
            } else {
                z7 = false;
            }
            this.f12822f = z7;
            if (z7) {
                this.f12824h = y8;
                this.f12823g = motionEvent.getPointerId(0);
                I();
                OverScroller overScroller = this.f12821e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f12821e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f12826j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12823g = -1;
        this.f12825i = -1;
    }
}
