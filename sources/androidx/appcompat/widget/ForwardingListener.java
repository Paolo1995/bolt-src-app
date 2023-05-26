package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ShowableListMenu;

/* loaded from: classes.dex */
public abstract class ForwardingListener implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: f  reason: collision with root package name */
    private final float f1999f;

    /* renamed from: g  reason: collision with root package name */
    private final int f2000g;

    /* renamed from: h  reason: collision with root package name */
    private final int f2001h;

    /* renamed from: i  reason: collision with root package name */
    final View f2002i;

    /* renamed from: j  reason: collision with root package name */
    private Runnable f2003j;

    /* renamed from: k  reason: collision with root package name */
    private Runnable f2004k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2005l;

    /* renamed from: m  reason: collision with root package name */
    private int f2006m;

    /* renamed from: n  reason: collision with root package name */
    private final int[] f2007n = new int[2];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class DisallowIntercept implements Runnable {
        DisallowIntercept() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = ForwardingListener.this.f2002i.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class TriggerLongPress implements Runnable {
        TriggerLongPress() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ForwardingListener.this.e();
        }
    }

    public ForwardingListener(View view) {
        this.f2002i = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1999f = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f2000g = tapTimeout;
        this.f2001h = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void a() {
        Runnable runnable = this.f2004k;
        if (runnable != null) {
            this.f2002i.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f2003j;
        if (runnable2 != null) {
            this.f2002i.removeCallbacks(runnable2);
        }
    }

    private boolean f(MotionEvent motionEvent) {
        DropDownListView dropDownListView;
        boolean z7;
        View view = this.f2002i;
        ShowableListMenu b8 = b();
        if (b8 == null || !b8.c() || (dropDownListView = (DropDownListView) b8.p()) == null || !dropDownListView.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, obtainNoHistory);
        j(dropDownListView, obtainNoHistory);
        boolean e8 = dropDownListView.e(obtainNoHistory, this.f2006m);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1 && actionMasked != 3) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!e8 || !z7) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
        if (r1 != 3) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean g(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f2002i
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L41
            r3 = 1
            if (r1 == r3) goto L3d
            r4 = 2
            if (r1 == r4) goto L1a
            r6 = 3
            if (r1 == r6) goto L3d
            goto L6d
        L1a:
            int r1 = r5.f2006m
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f1999f
            boolean r6 = h(r0, r4, r6, r1)
            if (r6 != 0) goto L6d
            r5.a()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L3d:
            r5.a()
            goto L6d
        L41:
            int r6 = r6.getPointerId(r2)
            r5.f2006m = r6
            java.lang.Runnable r6 = r5.f2003j
            if (r6 != 0) goto L52
            androidx.appcompat.widget.ForwardingListener$DisallowIntercept r6 = new androidx.appcompat.widget.ForwardingListener$DisallowIntercept
            r6.<init>()
            r5.f2003j = r6
        L52:
            java.lang.Runnable r6 = r5.f2003j
            int r1 = r5.f2000g
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f2004k
            if (r6 != 0) goto L65
            androidx.appcompat.widget.ForwardingListener$TriggerLongPress r6 = new androidx.appcompat.widget.ForwardingListener$TriggerLongPress
            r6.<init>()
            r5.f2004k = r6
        L65:
            java.lang.Runnable r6 = r5.f2004k
            int r1 = r5.f2001h
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ForwardingListener.g(android.view.MotionEvent):boolean");
    }

    private static boolean h(View view, float f8, float f9, float f10) {
        float f11 = -f10;
        if (f8 >= f11 && f9 >= f11 && f8 < (view.getRight() - view.getLeft()) + f10 && f9 < (view.getBottom() - view.getTop()) + f10) {
            return true;
        }
        return false;
    }

    private boolean i(View view, MotionEvent motionEvent) {
        int[] iArr = this.f2007n;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(iArr[0], iArr[1]);
        return true;
    }

    private boolean j(View view, MotionEvent motionEvent) {
        int[] iArr = this.f2007n;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(-iArr[0], -iArr[1]);
        return true;
    }

    public abstract ShowableListMenu b();

    protected abstract boolean c();

    protected boolean d() {
        ShowableListMenu b8 = b();
        if (b8 != null && b8.c()) {
            b8.dismiss();
            return true;
        }
        return true;
    }

    void e() {
        a();
        View view = this.f2002i;
        if (!view.isEnabled() || view.isLongClickable() || !c()) {
            return;
        }
        view.getParent().requestDisallowInterceptTouchEvent(true);
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        view.onTouchEvent(obtain);
        obtain.recycle();
        this.f2005l = true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z7;
        boolean z8 = this.f2005l;
        if (z8) {
            if (!f(motionEvent) && d()) {
                z7 = false;
            } else {
                z7 = true;
            }
        } else {
            if (g(motionEvent) && c()) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f2002i.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.f2005l = z7;
        if (z7 || z8) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f2005l = false;
        this.f2006m = -1;
        Runnable runnable = this.f2003j;
        if (runnable != null) {
            this.f2002i.removeCallbacks(runnable);
        }
    }
}
