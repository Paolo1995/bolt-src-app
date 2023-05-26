package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ViewDragHelper {

    /* renamed from: x  reason: collision with root package name */
    private static final Interpolator f6185x = new Interpolator() { // from class: androidx.customview.widget.ViewDragHelper.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f8) {
            float f9 = f8 - 1.0f;
            return (f9 * f9 * f9 * f9 * f9) + 1.0f;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f6186a;

    /* renamed from: b  reason: collision with root package name */
    private int f6187b;

    /* renamed from: d  reason: collision with root package name */
    private float[] f6189d;

    /* renamed from: e  reason: collision with root package name */
    private float[] f6190e;

    /* renamed from: f  reason: collision with root package name */
    private float[] f6191f;

    /* renamed from: g  reason: collision with root package name */
    private float[] f6192g;

    /* renamed from: h  reason: collision with root package name */
    private int[] f6193h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f6194i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f6195j;

    /* renamed from: k  reason: collision with root package name */
    private int f6196k;

    /* renamed from: l  reason: collision with root package name */
    private VelocityTracker f6197l;

    /* renamed from: m  reason: collision with root package name */
    private float f6198m;

    /* renamed from: n  reason: collision with root package name */
    private float f6199n;

    /* renamed from: o  reason: collision with root package name */
    private int f6200o;

    /* renamed from: p  reason: collision with root package name */
    private final int f6201p;

    /* renamed from: q  reason: collision with root package name */
    private int f6202q;

    /* renamed from: r  reason: collision with root package name */
    private OverScroller f6203r;

    /* renamed from: s  reason: collision with root package name */
    private final Callback f6204s;

    /* renamed from: t  reason: collision with root package name */
    private View f6205t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f6206u;

    /* renamed from: v  reason: collision with root package name */
    private final ViewGroup f6207v;

    /* renamed from: c  reason: collision with root package name */
    private int f6188c = -1;

    /* renamed from: w  reason: collision with root package name */
    private final Runnable f6208w = new Runnable() { // from class: androidx.customview.widget.ViewDragHelper.2
        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper.this.K(0);
        }
    };

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public int a(@NonNull View view, int i8, int i9) {
            return 0;
        }

        public int b(@NonNull View view, int i8, int i9) {
            return 0;
        }

        public int c(int i8) {
            return i8;
        }

        public int d(@NonNull View view) {
            return 0;
        }

        public int e(@NonNull View view) {
            return 0;
        }

        public void f(int i8, int i9) {
        }

        public boolean g(int i8) {
            return false;
        }

        public void h(int i8, int i9) {
        }

        public void i(@NonNull View view, int i8) {
        }

        public void j(int i8) {
        }

        public void k(@NonNull View view, int i8, int i9, int i10, int i11) {
        }

        public void l(@NonNull View view, float f8, float f9) {
        }

        public abstract boolean m(@NonNull View view, int i8);
    }

    private ViewDragHelper(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        if (viewGroup != null) {
            if (callback != null) {
                this.f6207v = viewGroup;
                this.f6204s = callback;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int i8 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
                this.f6201p = i8;
                this.f6200o = i8;
                this.f6187b = viewConfiguration.getScaledTouchSlop();
                this.f6198m = viewConfiguration.getScaledMaximumFlingVelocity();
                this.f6199n = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f6203r = new OverScroller(context, f6185x);
                return;
            }
            throw new IllegalArgumentException("Callback may not be null");
        }
        throw new IllegalArgumentException("Parent view may not be null");
    }

    private boolean D(int i8) {
        if (!C(i8)) {
            Log.e("ViewDragHelper", "Ignoring pointerId=" + i8 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
            return false;
        }
        return true;
    }

    private void G() {
        this.f6197l.computeCurrentVelocity(1000, this.f6198m);
        p(g(this.f6197l.getXVelocity(this.f6188c), this.f6199n, this.f6198m), g(this.f6197l.getYVelocity(this.f6188c), this.f6199n, this.f6198m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.customview.widget.ViewDragHelper$Callback] */
    private void H(float f8, float f9, int i8) {
        boolean c8 = c(f8, f9, i8, 1);
        boolean z7 = c8;
        if (c(f9, f8, i8, 4)) {
            z7 = c8 | true;
        }
        boolean z8 = z7;
        if (c(f8, f9, i8, 2)) {
            z8 = (z7 ? 1 : 0) | true;
        }
        ?? r02 = z8;
        if (c(f9, f8, i8, 8)) {
            r02 = (z8 ? 1 : 0) | true;
        }
        if (r02 != 0) {
            int[] iArr = this.f6194i;
            iArr[i8] = iArr[i8] | r02;
            this.f6204s.f(r02, i8);
        }
    }

    private void I(float f8, float f9, int i8) {
        s(i8);
        float[] fArr = this.f6189d;
        this.f6191f[i8] = f8;
        fArr[i8] = f8;
        float[] fArr2 = this.f6190e;
        this.f6192g[i8] = f9;
        fArr2[i8] = f9;
        this.f6193h[i8] = y((int) f8, (int) f9);
        this.f6196k |= 1 << i8;
    }

    private void J(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i8 = 0; i8 < pointerCount; i8++) {
            int pointerId = motionEvent.getPointerId(i8);
            if (D(pointerId)) {
                float x7 = motionEvent.getX(i8);
                float y7 = motionEvent.getY(i8);
                this.f6191f[pointerId] = x7;
                this.f6192g[pointerId] = y7;
            }
        }
    }

    private boolean c(float f8, float f9, int i8, int i9) {
        float abs = Math.abs(f8);
        float abs2 = Math.abs(f9);
        if ((this.f6193h[i8] & i9) != i9 || (this.f6202q & i9) == 0 || (this.f6195j[i8] & i9) == i9 || (this.f6194i[i8] & i9) == i9) {
            return false;
        }
        int i10 = this.f6187b;
        if (abs <= i10 && abs2 <= i10) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f6204s.g(i9)) {
            int[] iArr = this.f6195j;
            iArr[i8] = iArr[i8] | i9;
            return false;
        } else if ((this.f6194i[i8] & i9) != 0 || abs <= this.f6187b) {
            return false;
        } else {
            return true;
        }
    }

    private boolean f(View view, float f8, float f9) {
        boolean z7;
        boolean z8;
        if (view == null) {
            return false;
        }
        if (this.f6204s.d(view) > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (this.f6204s.e(view) > 0) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 && z8) {
            int i8 = this.f6187b;
            if ((f8 * f8) + (f9 * f9) <= i8 * i8) {
                return false;
            }
            return true;
        } else if (z7) {
            if (Math.abs(f8) <= this.f6187b) {
                return false;
            }
            return true;
        } else if (!z8 || Math.abs(f9) <= this.f6187b) {
            return false;
        } else {
            return true;
        }
    }

    private float g(float f8, float f9, float f10) {
        float abs = Math.abs(f8);
        if (abs < f9) {
            return 0.0f;
        }
        if (abs > f10) {
            if (f8 <= 0.0f) {
                return -f10;
            }
            return f10;
        }
        return f8;
    }

    private int h(int i8, int i9, int i10) {
        int abs = Math.abs(i8);
        if (abs < i9) {
            return 0;
        }
        if (abs > i10) {
            if (i8 <= 0) {
                return -i10;
            }
            return i10;
        }
        return i8;
    }

    private void i() {
        float[] fArr = this.f6189d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f6190e, 0.0f);
        Arrays.fill(this.f6191f, 0.0f);
        Arrays.fill(this.f6192g, 0.0f);
        Arrays.fill(this.f6193h, 0);
        Arrays.fill(this.f6194i, 0);
        Arrays.fill(this.f6195j, 0);
        this.f6196k = 0;
    }

    private void j(int i8) {
        if (this.f6189d != null && C(i8)) {
            this.f6189d[i8] = 0.0f;
            this.f6190e[i8] = 0.0f;
            this.f6191f[i8] = 0.0f;
            this.f6192g[i8] = 0.0f;
            this.f6193h[i8] = 0;
            this.f6194i[i8] = 0;
            this.f6195j[i8] = 0;
            this.f6196k = (~(1 << i8)) & this.f6196k;
        }
    }

    private int k(int i8, int i9, int i10) {
        int abs;
        if (i8 == 0) {
            return 0;
        }
        int width = this.f6207v.getWidth();
        float f8 = width / 2;
        float q8 = f8 + (q(Math.min(1.0f, Math.abs(i8) / width)) * f8);
        int abs2 = Math.abs(i9);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(q8 / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i8) / i10) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    private int l(View view, int i8, int i9, int i10, int i11) {
        float f8;
        float f9;
        float f10;
        float f11;
        int h8 = h(i10, (int) this.f6199n, (int) this.f6198m);
        int h9 = h(i11, (int) this.f6199n, (int) this.f6198m);
        int abs = Math.abs(i8);
        int abs2 = Math.abs(i9);
        int abs3 = Math.abs(h8);
        int abs4 = Math.abs(h9);
        int i12 = abs3 + abs4;
        int i13 = abs + abs2;
        if (h8 != 0) {
            f8 = abs3;
            f9 = i12;
        } else {
            f8 = abs;
            f9 = i13;
        }
        float f12 = f8 / f9;
        if (h9 != 0) {
            f10 = abs4;
            f11 = i12;
        } else {
            f10 = abs2;
            f11 = i13;
        }
        return (int) ((k(i8, h8, this.f6204s.d(view)) * f12) + (k(i9, h9, this.f6204s.e(view)) * (f10 / f11)));
    }

    public static ViewDragHelper n(@NonNull ViewGroup viewGroup, float f8, @NonNull Callback callback) {
        ViewDragHelper o8 = o(viewGroup, callback);
        o8.f6187b = (int) (o8.f6187b * (1.0f / f8));
        return o8;
    }

    public static ViewDragHelper o(@NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    private void p(float f8, float f9) {
        this.f6206u = true;
        this.f6204s.l(this.f6205t, f8, f9);
        this.f6206u = false;
        if (this.f6186a == 1) {
            K(0);
        }
    }

    private float q(float f8) {
        return (float) Math.sin((f8 - 0.5f) * 0.47123894f);
    }

    private void r(int i8, int i9, int i10, int i11) {
        int left = this.f6205t.getLeft();
        int top = this.f6205t.getTop();
        if (i10 != 0) {
            i8 = this.f6204s.a(this.f6205t, i8, i10);
            ViewCompat.c0(this.f6205t, i8 - left);
        }
        int i12 = i8;
        if (i11 != 0) {
            i9 = this.f6204s.b(this.f6205t, i9, i11);
            ViewCompat.d0(this.f6205t, i9 - top);
        }
        int i13 = i9;
        if (i10 != 0 || i11 != 0) {
            this.f6204s.k(this.f6205t, i12, i13, i12 - left, i13 - top);
        }
    }

    private void s(int i8) {
        float[] fArr = this.f6189d;
        if (fArr == null || fArr.length <= i8) {
            int i9 = i8 + 1;
            float[] fArr2 = new float[i9];
            float[] fArr3 = new float[i9];
            float[] fArr4 = new float[i9];
            float[] fArr5 = new float[i9];
            int[] iArr = new int[i9];
            int[] iArr2 = new int[i9];
            int[] iArr3 = new int[i9];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f6190e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f6191f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f6192g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f6193h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f6194i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f6195j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f6189d = fArr2;
            this.f6190e = fArr3;
            this.f6191f = fArr4;
            this.f6192g = fArr5;
            this.f6193h = iArr;
            this.f6194i = iArr2;
            this.f6195j = iArr3;
        }
    }

    private boolean u(int i8, int i9, int i10, int i11) {
        int left = this.f6205t.getLeft();
        int top = this.f6205t.getTop();
        int i12 = i8 - left;
        int i13 = i9 - top;
        if (i12 == 0 && i13 == 0) {
            this.f6203r.abortAnimation();
            K(0);
            return false;
        }
        this.f6203r.startScroll(left, top, i12, i13, l(this.f6205t, i12, i13, i10, i11));
        K(2);
        return true;
    }

    private int y(int i8, int i9) {
        int i10;
        if (i8 < this.f6207v.getLeft() + this.f6200o) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        if (i9 < this.f6207v.getTop() + this.f6200o) {
            i10 |= 4;
        }
        if (i8 > this.f6207v.getRight() - this.f6200o) {
            i10 |= 2;
        }
        if (i9 > this.f6207v.getBottom() - this.f6200o) {
            return i10 | 8;
        }
        return i10;
    }

    public int A() {
        return this.f6186a;
    }

    public boolean B(int i8, int i9) {
        return E(this.f6205t, i8, i9);
    }

    public boolean C(int i8) {
        if (((1 << i8) & this.f6196k) != 0) {
            return true;
        }
        return false;
    }

    public boolean E(View view, int i8, int i9) {
        if (view == null || i8 < view.getLeft() || i8 >= view.getRight() || i9 < view.getTop() || i9 >= view.getBottom()) {
            return false;
        }
        return true;
    }

    public void F(@NonNull MotionEvent motionEvent) {
        int i8;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f6197l == null) {
            this.f6197l = VelocityTracker.obtain();
        }
        this.f6197l.addMovement(motionEvent);
        int i9 = 0;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                int pointerId = motionEvent.getPointerId(actionIndex);
                                if (this.f6186a == 1 && pointerId == this.f6188c) {
                                    int pointerCount = motionEvent.getPointerCount();
                                    while (true) {
                                        if (i9 < pointerCount) {
                                            int pointerId2 = motionEvent.getPointerId(i9);
                                            if (pointerId2 != this.f6188c) {
                                                View t7 = t((int) motionEvent.getX(i9), (int) motionEvent.getY(i9));
                                                View view = this.f6205t;
                                                if (t7 == view && P(view, pointerId2)) {
                                                    i8 = this.f6188c;
                                                    break;
                                                }
                                            }
                                            i9++;
                                        } else {
                                            i8 = -1;
                                            break;
                                        }
                                    }
                                    if (i8 == -1) {
                                        G();
                                    }
                                }
                                j(pointerId);
                                return;
                            }
                            return;
                        }
                        int pointerId3 = motionEvent.getPointerId(actionIndex);
                        float x7 = motionEvent.getX(actionIndex);
                        float y7 = motionEvent.getY(actionIndex);
                        I(x7, y7, pointerId3);
                        if (this.f6186a == 0) {
                            P(t((int) x7, (int) y7), pointerId3);
                            int i10 = this.f6193h[pointerId3];
                            int i11 = this.f6202q;
                            if ((i10 & i11) != 0) {
                                this.f6204s.h(i10 & i11, pointerId3);
                                return;
                            }
                            return;
                        } else if (B((int) x7, (int) y7)) {
                            P(this.f6205t, pointerId3);
                            return;
                        } else {
                            return;
                        }
                    }
                    if (this.f6186a == 1) {
                        p(0.0f, 0.0f);
                    }
                    a();
                    return;
                } else if (this.f6186a == 1) {
                    if (D(this.f6188c)) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.f6188c);
                        float x8 = motionEvent.getX(findPointerIndex);
                        float y8 = motionEvent.getY(findPointerIndex);
                        float[] fArr = this.f6191f;
                        int i12 = this.f6188c;
                        int i13 = (int) (x8 - fArr[i12]);
                        int i14 = (int) (y8 - this.f6192g[i12]);
                        r(this.f6205t.getLeft() + i13, this.f6205t.getTop() + i14, i13, i14);
                        J(motionEvent);
                        return;
                    }
                    return;
                } else {
                    int pointerCount2 = motionEvent.getPointerCount();
                    while (i9 < pointerCount2) {
                        int pointerId4 = motionEvent.getPointerId(i9);
                        if (D(pointerId4)) {
                            float x9 = motionEvent.getX(i9);
                            float y9 = motionEvent.getY(i9);
                            float f8 = x9 - this.f6189d[pointerId4];
                            float f9 = y9 - this.f6190e[pointerId4];
                            H(f8, f9, pointerId4);
                            if (this.f6186a != 1) {
                                View t8 = t((int) x9, (int) y9);
                                if (f(t8, f8, f9) && P(t8, pointerId4)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        i9++;
                    }
                    J(motionEvent);
                    return;
                }
            }
            if (this.f6186a == 1) {
                G();
            }
            a();
            return;
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        int pointerId5 = motionEvent.getPointerId(0);
        View t9 = t((int) x10, (int) y10);
        I(x10, y10, pointerId5);
        P(t9, pointerId5);
        int i15 = this.f6193h[pointerId5];
        int i16 = this.f6202q;
        if ((i15 & i16) != 0) {
            this.f6204s.h(i15 & i16, pointerId5);
        }
    }

    void K(int i8) {
        this.f6207v.removeCallbacks(this.f6208w);
        if (this.f6186a != i8) {
            this.f6186a = i8;
            this.f6204s.j(i8);
            if (this.f6186a == 0) {
                this.f6205t = null;
            }
        }
    }

    public void L(int i8) {
        this.f6200o = i8;
    }

    public boolean M(int i8, int i9) {
        if (this.f6206u) {
            return u(i8, i9, (int) this.f6197l.getXVelocity(this.f6188c), (int) this.f6197l.getYVelocity(this.f6188c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00dd, code lost:
        if (r12 != r11) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean N(@androidx.annotation.NonNull android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ViewDragHelper.N(android.view.MotionEvent):boolean");
    }

    public boolean O(@NonNull View view, int i8, int i9) {
        this.f6205t = view;
        this.f6188c = -1;
        boolean u7 = u(i8, i9, 0, 0);
        if (!u7 && this.f6186a == 0 && this.f6205t != null) {
            this.f6205t = null;
        }
        return u7;
    }

    boolean P(View view, int i8) {
        if (view == this.f6205t && this.f6188c == i8) {
            return true;
        }
        if (view != null && this.f6204s.m(view, i8)) {
            this.f6188c = i8;
            b(view, i8);
            return true;
        }
        return false;
    }

    public void a() {
        this.f6188c = -1;
        i();
        VelocityTracker velocityTracker = this.f6197l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f6197l = null;
        }
    }

    public void b(@NonNull View view, int i8) {
        if (view.getParent() == this.f6207v) {
            this.f6205t = view;
            this.f6188c = i8;
            this.f6204s.i(view, i8);
            K(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f6207v + ")");
    }

    public boolean d(int i8) {
        int length = this.f6189d.length;
        for (int i9 = 0; i9 < length; i9++) {
            if (e(i8, i9)) {
                return true;
            }
        }
        return false;
    }

    public boolean e(int i8, int i9) {
        boolean z7;
        boolean z8;
        if (!C(i9)) {
            return false;
        }
        if ((i8 & 1) == 1) {
            z7 = true;
        } else {
            z7 = false;
        }
        if ((i8 & 2) == 2) {
            z8 = true;
        } else {
            z8 = false;
        }
        float f8 = this.f6191f[i9] - this.f6189d[i9];
        float f9 = this.f6192g[i9] - this.f6190e[i9];
        if (z7 && z8) {
            int i10 = this.f6187b;
            if ((f8 * f8) + (f9 * f9) <= i10 * i10) {
                return false;
            }
            return true;
        } else if (z7) {
            if (Math.abs(f8) <= this.f6187b) {
                return false;
            }
            return true;
        } else if (!z8 || Math.abs(f9) <= this.f6187b) {
            return false;
        } else {
            return true;
        }
    }

    public boolean m(boolean z7) {
        if (this.f6186a == 2) {
            boolean computeScrollOffset = this.f6203r.computeScrollOffset();
            int currX = this.f6203r.getCurrX();
            int currY = this.f6203r.getCurrY();
            int left = currX - this.f6205t.getLeft();
            int top = currY - this.f6205t.getTop();
            if (left != 0) {
                ViewCompat.c0(this.f6205t, left);
            }
            if (top != 0) {
                ViewCompat.d0(this.f6205t, top);
            }
            if (left != 0 || top != 0) {
                this.f6204s.k(this.f6205t, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f6203r.getFinalX() && currY == this.f6203r.getFinalY()) {
                this.f6203r.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z7) {
                    this.f6207v.post(this.f6208w);
                } else {
                    K(0);
                }
            }
        }
        if (this.f6186a != 2) {
            return false;
        }
        return true;
    }

    public View t(int i8, int i9) {
        for (int childCount = this.f6207v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f6207v.getChildAt(this.f6204s.c(childCount));
            if (i8 >= childAt.getLeft() && i8 < childAt.getRight() && i9 >= childAt.getTop() && i9 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public View v() {
        return this.f6205t;
    }

    public int w() {
        return this.f6201p;
    }

    public int x() {
        return this.f6200o;
    }

    public int z() {
        return this.f6187b;
    }
}
