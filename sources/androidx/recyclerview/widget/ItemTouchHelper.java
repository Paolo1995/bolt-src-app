package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    private ItemTouchHelperGestureListener A;
    private Rect C;
    private long D;

    /* renamed from: d  reason: collision with root package name */
    float f7068d;

    /* renamed from: e  reason: collision with root package name */
    float f7069e;

    /* renamed from: f  reason: collision with root package name */
    private float f7070f;

    /* renamed from: g  reason: collision with root package name */
    private float f7071g;

    /* renamed from: h  reason: collision with root package name */
    float f7072h;

    /* renamed from: i  reason: collision with root package name */
    float f7073i;

    /* renamed from: j  reason: collision with root package name */
    private float f7074j;

    /* renamed from: k  reason: collision with root package name */
    private float f7075k;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    Callback f7077m;

    /* renamed from: o  reason: collision with root package name */
    int f7079o;

    /* renamed from: q  reason: collision with root package name */
    private int f7081q;

    /* renamed from: r  reason: collision with root package name */
    RecyclerView f7082r;

    /* renamed from: t  reason: collision with root package name */
    VelocityTracker f7084t;

    /* renamed from: u  reason: collision with root package name */
    private List<RecyclerView.ViewHolder> f7085u;

    /* renamed from: v  reason: collision with root package name */
    private List<Integer> f7086v;

    /* renamed from: z  reason: collision with root package name */
    GestureDetectorCompat f7090z;

    /* renamed from: a  reason: collision with root package name */
    final List<View> f7065a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final float[] f7066b = new float[2];

    /* renamed from: c  reason: collision with root package name */
    RecyclerView.ViewHolder f7067c = null;

    /* renamed from: l  reason: collision with root package name */
    int f7076l = -1;

    /* renamed from: n  reason: collision with root package name */
    private int f7078n = 0;

    /* renamed from: p  reason: collision with root package name */
    List<RecoverAnimation> f7080p = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    final Runnable f7083s = new Runnable() { // from class: androidx.recyclerview.widget.ItemTouchHelper.1
        @Override // java.lang.Runnable
        public void run() {
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            if (itemTouchHelper.f7067c != null && itemTouchHelper.E()) {
                ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                RecyclerView.ViewHolder viewHolder = itemTouchHelper2.f7067c;
                if (viewHolder != null) {
                    itemTouchHelper2.z(viewHolder);
                }
                ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                itemTouchHelper3.f7082r.removeCallbacks(itemTouchHelper3.f7083s);
                ViewCompat.k0(ItemTouchHelper.this.f7082r, this);
            }
        }
    };

    /* renamed from: w  reason: collision with root package name */
    private RecyclerView.ChildDrawingOrderCallback f7087w = null;

    /* renamed from: x  reason: collision with root package name */
    View f7088x = null;

    /* renamed from: y  reason: collision with root package name */
    int f7089y = -1;
    private final RecyclerView.OnItemTouchListener B = new RecyclerView.OnItemTouchListener() { // from class: androidx.recyclerview.widget.ItemTouchHelper.2
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void a(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            ItemTouchHelper.this.f7090z.a(motionEvent);
            VelocityTracker velocityTracker = ItemTouchHelper.this.f7084t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.f7076l == -1) {
                return;
            }
            int actionMasked = motionEvent.getActionMasked();
            int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.f7076l);
            if (findPointerIndex >= 0) {
                ItemTouchHelper.this.o(actionMasked, motionEvent, findPointerIndex);
            }
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            RecyclerView.ViewHolder viewHolder = itemTouchHelper.f7067c;
            if (viewHolder == null) {
                return;
            }
            int i8 = 0;
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 6) {
                            int actionIndex = motionEvent.getActionIndex();
                            int pointerId = motionEvent.getPointerId(actionIndex);
                            ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                            if (pointerId == itemTouchHelper2.f7076l) {
                                if (actionIndex == 0) {
                                    i8 = 1;
                                }
                                itemTouchHelper2.f7076l = motionEvent.getPointerId(i8);
                                ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                                itemTouchHelper3.K(motionEvent, itemTouchHelper3.f7079o, actionIndex);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    VelocityTracker velocityTracker2 = itemTouchHelper.f7084t;
                    if (velocityTracker2 != null) {
                        velocityTracker2.clear();
                    }
                } else if (findPointerIndex >= 0) {
                    itemTouchHelper.K(motionEvent, itemTouchHelper.f7079o, findPointerIndex);
                    ItemTouchHelper.this.z(viewHolder);
                    ItemTouchHelper itemTouchHelper4 = ItemTouchHelper.this;
                    itemTouchHelper4.f7082r.removeCallbacks(itemTouchHelper4.f7083s);
                    ItemTouchHelper.this.f7083s.run();
                    ItemTouchHelper.this.f7082r.invalidate();
                    return;
                } else {
                    return;
                }
            }
            ItemTouchHelper.this.F(null, 0);
            ItemTouchHelper.this.f7076l = -1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean c(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            int findPointerIndex;
            RecoverAnimation s7;
            ItemTouchHelper.this.f7090z.a(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                ItemTouchHelper.this.f7076l = motionEvent.getPointerId(0);
                ItemTouchHelper.this.f7068d = motionEvent.getX();
                ItemTouchHelper.this.f7069e = motionEvent.getY();
                ItemTouchHelper.this.A();
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                if (itemTouchHelper.f7067c == null && (s7 = itemTouchHelper.s(motionEvent)) != null) {
                    ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                    itemTouchHelper2.f7068d -= s7.f7113j;
                    itemTouchHelper2.f7069e -= s7.f7114k;
                    itemTouchHelper2.r(s7.f7108e, true);
                    if (ItemTouchHelper.this.f7065a.remove(s7.f7108e.f7332a)) {
                        ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                        itemTouchHelper3.f7077m.c(itemTouchHelper3.f7082r, s7.f7108e);
                    }
                    ItemTouchHelper.this.F(s7.f7108e, s7.f7109f);
                    ItemTouchHelper itemTouchHelper4 = ItemTouchHelper.this;
                    itemTouchHelper4.K(motionEvent, itemTouchHelper4.f7079o, 0);
                }
            } else if (actionMasked != 3 && actionMasked != 1) {
                int i8 = ItemTouchHelper.this.f7076l;
                if (i8 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i8)) >= 0) {
                    ItemTouchHelper.this.o(actionMasked, motionEvent, findPointerIndex);
                }
            } else {
                ItemTouchHelper itemTouchHelper5 = ItemTouchHelper.this;
                itemTouchHelper5.f7076l = -1;
                itemTouchHelper5.F(null, 0);
            }
            VelocityTracker velocityTracker = ItemTouchHelper.this.f7084t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.f7067c != null) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void e(boolean z7) {
            if (!z7) {
                return;
            }
            ItemTouchHelper.this.F(null, 0);
        }
    };

    /* loaded from: classes.dex */
    public static abstract class Callback {

        /* renamed from: b  reason: collision with root package name */
        private static final Interpolator f7099b = new Interpolator() { // from class: androidx.recyclerview.widget.ItemTouchHelper.Callback.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f8) {
                return f8 * f8 * f8 * f8 * f8;
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private static final Interpolator f7100c = new Interpolator() { // from class: androidx.recyclerview.widget.ItemTouchHelper.Callback.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f8) {
                float f9 = f8 - 1.0f;
                return (f9 * f9 * f9 * f9 * f9) + 1.0f;
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private int f7101a = -1;

        public static int e(int i8, int i9) {
            int i10;
            int i11 = i8 & 789516;
            if (i11 == 0) {
                return i8;
            }
            int i12 = i8 & (~i11);
            if (i9 == 0) {
                i10 = i11 << 2;
            } else {
                int i13 = i11 << 1;
                i12 |= (-789517) & i13;
                i10 = (i13 & 789516) << 2;
            }
            return i12 | i10;
        }

        private int i(RecyclerView recyclerView) {
            if (this.f7101a == -1) {
                this.f7101a = recyclerView.getResources().getDimensionPixelSize(R$dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.f7101a;
        }

        public static int s(int i8, int i9) {
            return i9 << (i8 * 8);
        }

        public static int t(int i8, int i9) {
            int s7 = s(0, i9 | i8);
            return s(2, i8) | s(1, i9) | s7;
        }

        public void A(RecyclerView.ViewHolder viewHolder, int i8) {
            if (viewHolder != null) {
                ItemTouchUIUtilImpl.f7121a.b(viewHolder.f7332a);
            }
        }

        public abstract void B(@NonNull RecyclerView.ViewHolder viewHolder, int i8);

        public boolean a(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2) {
            return true;
        }

        public RecyclerView.ViewHolder b(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<RecyclerView.ViewHolder> list, int i8, int i9) {
            int bottom;
            int abs;
            int top;
            int abs2;
            int left;
            int abs3;
            int right;
            int abs4;
            int width = i8 + viewHolder.f7332a.getWidth();
            int height = i9 + viewHolder.f7332a.getHeight();
            int left2 = i8 - viewHolder.f7332a.getLeft();
            int top2 = i9 - viewHolder.f7332a.getTop();
            int size = list.size();
            RecyclerView.ViewHolder viewHolder2 = null;
            int i10 = -1;
            for (int i11 = 0; i11 < size; i11++) {
                RecyclerView.ViewHolder viewHolder3 = list.get(i11);
                if (left2 > 0 && (right = viewHolder3.f7332a.getRight() - width) < 0 && viewHolder3.f7332a.getRight() > viewHolder.f7332a.getRight() && (abs4 = Math.abs(right)) > i10) {
                    viewHolder2 = viewHolder3;
                    i10 = abs4;
                }
                if (left2 < 0 && (left = viewHolder3.f7332a.getLeft() - i8) > 0 && viewHolder3.f7332a.getLeft() < viewHolder.f7332a.getLeft() && (abs3 = Math.abs(left)) > i10) {
                    viewHolder2 = viewHolder3;
                    i10 = abs3;
                }
                if (top2 < 0 && (top = viewHolder3.f7332a.getTop() - i9) > 0 && viewHolder3.f7332a.getTop() < viewHolder.f7332a.getTop() && (abs2 = Math.abs(top)) > i10) {
                    viewHolder2 = viewHolder3;
                    i10 = abs2;
                }
                if (top2 > 0 && (bottom = viewHolder3.f7332a.getBottom() - height) < 0 && viewHolder3.f7332a.getBottom() > viewHolder.f7332a.getBottom() && (abs = Math.abs(bottom)) > i10) {
                    viewHolder2 = viewHolder3;
                    i10 = abs;
                }
            }
            return viewHolder2;
        }

        public void c(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            ItemTouchUIUtilImpl.f7121a.a(viewHolder.f7332a);
        }

        public int d(int i8, int i9) {
            int i10;
            int i11 = i8 & 3158064;
            if (i11 == 0) {
                return i8;
            }
            int i12 = i8 & (~i11);
            if (i9 == 0) {
                i10 = i11 >> 2;
            } else {
                int i13 = i11 >> 1;
                i12 |= (-3158065) & i13;
                i10 = (i13 & 3158064) >> 2;
            }
            return i12 | i10;
        }

        final int f(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return d(k(recyclerView, viewHolder), ViewCompat.E(recyclerView));
        }

        public long g(@NonNull RecyclerView recyclerView, int i8, float f8, float f9) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                if (i8 == 8) {
                    return 200L;
                }
                return 250L;
            } else if (i8 == 8) {
                return itemAnimator.n();
            } else {
                return itemAnimator.o();
            }
        }

        public int h() {
            return 0;
        }

        public float j(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public abstract int k(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder);

        public float l(float f8) {
            return f8;
        }

        public float m(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public float n(float f8) {
            return f8;
        }

        boolean o(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            if ((f(recyclerView, viewHolder) & 16711680) != 0) {
                return true;
            }
            return false;
        }

        public int p(@NonNull RecyclerView recyclerView, int i8, int i9, int i10, long j8) {
            float f8 = 1.0f;
            int signum = (int) (((int) Math.signum(i9)) * i(recyclerView) * f7100c.getInterpolation(Math.min(1.0f, (Math.abs(i9) * 1.0f) / i8)));
            if (j8 <= 2000) {
                f8 = ((float) j8) / 2000.0f;
            }
            int interpolation = (int) (signum * f7099b.getInterpolation(f8));
            if (interpolation == 0) {
                if (i9 > 0) {
                    return 1;
                }
                return -1;
            }
            return interpolation;
        }

        public boolean q() {
            return true;
        }

        public boolean r() {
            return true;
        }

        public void u(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float f8, float f9, int i8, boolean z7) {
            ItemTouchUIUtilImpl.f7121a.c(canvas, recyclerView, viewHolder.f7332a, f8, f9, i8, z7);
        }

        public void v(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f8, float f9, int i8, boolean z7) {
            ItemTouchUIUtilImpl.f7121a.d(canvas, recyclerView, viewHolder.f7332a, f8, f9, i8, z7);
        }

        void w(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i8, float f8, float f9) {
            int size = list.size();
            for (int i9 = 0; i9 < size; i9++) {
                RecoverAnimation recoverAnimation = list.get(i9);
                recoverAnimation.e();
                int save = canvas.save();
                u(canvas, recyclerView, recoverAnimation.f7108e, recoverAnimation.f7113j, recoverAnimation.f7114k, recoverAnimation.f7109f, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                u(canvas, recyclerView, viewHolder, f8, f9, i8, true);
                canvas.restoreToCount(save2);
            }
        }

        void x(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i8, float f8, float f9) {
            int size = list.size();
            boolean z7 = false;
            for (int i9 = 0; i9 < size; i9++) {
                RecoverAnimation recoverAnimation = list.get(i9);
                int save = canvas.save();
                v(canvas, recyclerView, recoverAnimation.f7108e, recoverAnimation.f7113j, recoverAnimation.f7114k, recoverAnimation.f7109f, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                v(canvas, recyclerView, viewHolder, f8, f9, i8, true);
                canvas.restoreToCount(save2);
            }
            for (int i10 = size - 1; i10 >= 0; i10--) {
                RecoverAnimation recoverAnimation2 = list.get(i10);
                boolean z8 = recoverAnimation2.f7116m;
                if (z8 && !recoverAnimation2.f7112i) {
                    list.remove(i10);
                } else if (!z8) {
                    z7 = true;
                }
            }
            if (z7) {
                recyclerView.invalidate();
            }
        }

        public abstract boolean y(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2);

        public void z(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, int i8, @NonNull RecyclerView.ViewHolder viewHolder2, int i9, int i10, int i11) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewDropHandler) {
                ((ViewDropHandler) layoutManager).d(viewHolder.f7332a, viewHolder2.f7332a, i10, i11);
                return;
            }
            if (layoutManager.v()) {
                if (layoutManager.b0(viewHolder2.f7332a) <= recyclerView.getPaddingLeft()) {
                    recyclerView.p1(i9);
                }
                if (layoutManager.e0(viewHolder2.f7332a) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.p1(i9);
                }
            }
            if (layoutManager.w()) {
                if (layoutManager.f0(viewHolder2.f7332a) <= recyclerView.getPaddingTop()) {
                    recyclerView.p1(i9);
                }
                if (layoutManager.Z(viewHolder2.f7332a) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.p1(i9);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: f  reason: collision with root package name */
        private boolean f7102f = true;

        ItemTouchHelperGestureListener() {
        }

        void a() {
            this.f7102f = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View t7;
            RecyclerView.ViewHolder j02;
            if (this.f7102f && (t7 = ItemTouchHelper.this.t(motionEvent)) != null && (j02 = ItemTouchHelper.this.f7082r.j0(t7)) != null) {
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                if (!itemTouchHelper.f7077m.o(itemTouchHelper.f7082r, j02)) {
                    return;
                }
                int pointerId = motionEvent.getPointerId(0);
                int i8 = ItemTouchHelper.this.f7076l;
                if (pointerId == i8) {
                    int findPointerIndex = motionEvent.findPointerIndex(i8);
                    float x7 = motionEvent.getX(findPointerIndex);
                    float y7 = motionEvent.getY(findPointerIndex);
                    ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                    itemTouchHelper2.f7068d = x7;
                    itemTouchHelper2.f7069e = y7;
                    itemTouchHelper2.f7073i = 0.0f;
                    itemTouchHelper2.f7072h = 0.0f;
                    if (itemTouchHelper2.f7077m.r()) {
                        ItemTouchHelper.this.F(j02, 2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class RecoverAnimation implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final float f7104a;

        /* renamed from: b  reason: collision with root package name */
        final float f7105b;

        /* renamed from: c  reason: collision with root package name */
        final float f7106c;

        /* renamed from: d  reason: collision with root package name */
        final float f7107d;

        /* renamed from: e  reason: collision with root package name */
        final RecyclerView.ViewHolder f7108e;

        /* renamed from: f  reason: collision with root package name */
        final int f7109f;

        /* renamed from: g  reason: collision with root package name */
        final ValueAnimator f7110g;

        /* renamed from: h  reason: collision with root package name */
        final int f7111h;

        /* renamed from: i  reason: collision with root package name */
        boolean f7112i;

        /* renamed from: j  reason: collision with root package name */
        float f7113j;

        /* renamed from: k  reason: collision with root package name */
        float f7114k;

        /* renamed from: l  reason: collision with root package name */
        boolean f7115l = false;

        /* renamed from: m  reason: collision with root package name */
        boolean f7116m = false;

        /* renamed from: n  reason: collision with root package name */
        private float f7117n;

        RecoverAnimation(RecyclerView.ViewHolder viewHolder, int i8, int i9, float f8, float f9, float f10, float f11) {
            this.f7109f = i9;
            this.f7111h = i8;
            this.f7108e = viewHolder;
            this.f7104a = f8;
            this.f7105b = f9;
            this.f7106c = f10;
            this.f7107d = f11;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f7110g = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.recyclerview.widget.ItemTouchHelper.RecoverAnimation.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RecoverAnimation.this.c(valueAnimator.getAnimatedFraction());
                }
            });
            ofFloat.setTarget(viewHolder.f7332a);
            ofFloat.addListener(this);
            c(0.0f);
        }

        public void a() {
            this.f7110g.cancel();
        }

        public void b(long j8) {
            this.f7110g.setDuration(j8);
        }

        public void c(float f8) {
            this.f7117n = f8;
        }

        public void d() {
            this.f7108e.I(false);
            this.f7110g.start();
        }

        public void e() {
            float f8 = this.f7104a;
            float f9 = this.f7106c;
            if (f8 == f9) {
                this.f7113j = this.f7108e.f7332a.getTranslationX();
            } else {
                this.f7113j = f8 + (this.f7117n * (f9 - f8));
            }
            float f10 = this.f7105b;
            float f11 = this.f7107d;
            if (f10 == f11) {
                this.f7114k = this.f7108e.f7332a.getTranslationY();
            } else {
                this.f7114k = f10 + (this.f7117n * (f11 - f10));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            c(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f7116m) {
                this.f7108e.I(true);
            }
            this.f7116m = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class SimpleCallback extends Callback {

        /* renamed from: d  reason: collision with root package name */
        private int f7119d;

        /* renamed from: e  reason: collision with root package name */
        private int f7120e;

        public SimpleCallback(int i8, int i9) {
            this.f7119d = i9;
            this.f7120e = i8;
        }

        public int C(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return this.f7120e;
        }

        public int D(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return this.f7119d;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int k(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return Callback.t(C(recyclerView, viewHolder), D(recyclerView, viewHolder));
        }
    }

    /* loaded from: classes.dex */
    public interface ViewDropHandler {
        void d(@NonNull View view, @NonNull View view2, int i8, int i9);
    }

    public ItemTouchHelper(@NonNull Callback callback) {
        this.f7077m = callback;
    }

    private void C() {
        VelocityTracker velocityTracker = this.f7084t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f7084t = null;
        }
    }

    private void G() {
        this.f7081q = ViewConfiguration.get(this.f7082r.getContext()).getScaledTouchSlop();
        this.f7082r.h(this);
        this.f7082r.k(this.B);
        this.f7082r.j(this);
        H();
    }

    private void H() {
        this.A = new ItemTouchHelperGestureListener();
        this.f7090z = new GestureDetectorCompat(this.f7082r.getContext(), this.A);
    }

    private void I() {
        ItemTouchHelperGestureListener itemTouchHelperGestureListener = this.A;
        if (itemTouchHelperGestureListener != null) {
            itemTouchHelperGestureListener.a();
            this.A = null;
        }
        if (this.f7090z != null) {
            this.f7090z = null;
        }
    }

    private int J(RecyclerView.ViewHolder viewHolder) {
        if (this.f7078n == 2) {
            return 0;
        }
        int k8 = this.f7077m.k(this.f7082r, viewHolder);
        int d8 = (this.f7077m.d(k8, ViewCompat.E(this.f7082r)) & 65280) >> 8;
        if (d8 == 0) {
            return 0;
        }
        int i8 = (k8 & 65280) >> 8;
        if (Math.abs(this.f7072h) > Math.abs(this.f7073i)) {
            int n8 = n(viewHolder, d8);
            if (n8 > 0) {
                if ((i8 & n8) == 0) {
                    return Callback.e(n8, ViewCompat.E(this.f7082r));
                }
                return n8;
            }
            int p8 = p(viewHolder, d8);
            if (p8 > 0) {
                return p8;
            }
        } else {
            int p9 = p(viewHolder, d8);
            if (p9 > 0) {
                return p9;
            }
            int n9 = n(viewHolder, d8);
            if (n9 > 0) {
                if ((i8 & n9) == 0) {
                    return Callback.e(n9, ViewCompat.E(this.f7082r));
                }
                return n9;
            }
        }
        return 0;
    }

    private void l() {
    }

    private int n(RecyclerView.ViewHolder viewHolder, int i8) {
        int i9;
        if ((i8 & 12) != 0) {
            int i10 = 8;
            if (this.f7072h > 0.0f) {
                i9 = 8;
            } else {
                i9 = 4;
            }
            VelocityTracker velocityTracker = this.f7084t;
            if (velocityTracker != null && this.f7076l > -1) {
                velocityTracker.computeCurrentVelocity(1000, this.f7077m.n(this.f7071g));
                float xVelocity = this.f7084t.getXVelocity(this.f7076l);
                float yVelocity = this.f7084t.getYVelocity(this.f7076l);
                if (xVelocity <= 0.0f) {
                    i10 = 4;
                }
                float abs = Math.abs(xVelocity);
                if ((i10 & i8) != 0 && i9 == i10 && abs >= this.f7077m.l(this.f7070f) && abs > Math.abs(yVelocity)) {
                    return i10;
                }
            }
            float width = this.f7082r.getWidth() * this.f7077m.m(viewHolder);
            if ((i8 & i9) != 0 && Math.abs(this.f7072h) > width) {
                return i9;
            }
            return 0;
        }
        return 0;
    }

    private int p(RecyclerView.ViewHolder viewHolder, int i8) {
        int i9;
        if ((i8 & 3) != 0) {
            int i10 = 2;
            if (this.f7073i > 0.0f) {
                i9 = 2;
            } else {
                i9 = 1;
            }
            VelocityTracker velocityTracker = this.f7084t;
            if (velocityTracker != null && this.f7076l > -1) {
                velocityTracker.computeCurrentVelocity(1000, this.f7077m.n(this.f7071g));
                float xVelocity = this.f7084t.getXVelocity(this.f7076l);
                float yVelocity = this.f7084t.getYVelocity(this.f7076l);
                if (yVelocity <= 0.0f) {
                    i10 = 1;
                }
                float abs = Math.abs(yVelocity);
                if ((i10 & i8) != 0 && i10 == i9 && abs >= this.f7077m.l(this.f7070f) && abs > Math.abs(xVelocity)) {
                    return i10;
                }
            }
            float height = this.f7082r.getHeight() * this.f7077m.m(viewHolder);
            if ((i8 & i9) != 0 && Math.abs(this.f7073i) > height) {
                return i9;
            }
            return 0;
        }
        return 0;
    }

    private void q() {
        this.f7082r.d1(this);
        this.f7082r.f1(this.B);
        this.f7082r.e1(this);
        for (int size = this.f7080p.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.f7080p.get(0);
            recoverAnimation.a();
            this.f7077m.c(this.f7082r, recoverAnimation.f7108e);
        }
        this.f7080p.clear();
        this.f7088x = null;
        this.f7089y = -1;
        C();
        I();
    }

    private List<RecyclerView.ViewHolder> u(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ViewHolder viewHolder2 = viewHolder;
        List<RecyclerView.ViewHolder> list = this.f7085u;
        if (list == null) {
            this.f7085u = new ArrayList();
            this.f7086v = new ArrayList();
        } else {
            list.clear();
            this.f7086v.clear();
        }
        int h8 = this.f7077m.h();
        int round = Math.round(this.f7074j + this.f7072h) - h8;
        int round2 = Math.round(this.f7075k + this.f7073i) - h8;
        int i8 = h8 * 2;
        int width = viewHolder2.f7332a.getWidth() + round + i8;
        int height = viewHolder2.f7332a.getHeight() + round2 + i8;
        int i9 = (round + width) / 2;
        int i10 = (round2 + height) / 2;
        RecyclerView.LayoutManager layoutManager = this.f7082r.getLayoutManager();
        int U = layoutManager.U();
        int i11 = 0;
        while (i11 < U) {
            View T = layoutManager.T(i11);
            if (T != viewHolder2.f7332a && T.getBottom() >= round2 && T.getTop() <= height && T.getRight() >= round && T.getLeft() <= width) {
                RecyclerView.ViewHolder j02 = this.f7082r.j0(T);
                if (this.f7077m.a(this.f7082r, this.f7067c, j02)) {
                    int abs = Math.abs(i9 - ((T.getLeft() + T.getRight()) / 2));
                    int abs2 = Math.abs(i10 - ((T.getTop() + T.getBottom()) / 2));
                    int i12 = (abs * abs) + (abs2 * abs2);
                    int size = this.f7085u.size();
                    int i13 = 0;
                    for (int i14 = 0; i14 < size && i12 > this.f7086v.get(i14).intValue(); i14++) {
                        i13++;
                    }
                    this.f7085u.add(i13, j02);
                    this.f7086v.add(i13, Integer.valueOf(i12));
                }
            }
            i11++;
            viewHolder2 = viewHolder;
        }
        return this.f7085u;
    }

    private RecyclerView.ViewHolder v(MotionEvent motionEvent) {
        View t7;
        RecyclerView.LayoutManager layoutManager = this.f7082r.getLayoutManager();
        int i8 = this.f7076l;
        if (i8 == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i8);
        float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.f7068d);
        float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.f7069e);
        int i9 = this.f7081q;
        if (abs < i9 && abs2 < i9) {
            return null;
        }
        if (abs > abs2 && layoutManager.v()) {
            return null;
        }
        if ((abs2 > abs && layoutManager.w()) || (t7 = t(motionEvent)) == null) {
            return null;
        }
        return this.f7082r.j0(t7);
    }

    private void w(float[] fArr) {
        if ((this.f7079o & 12) != 0) {
            fArr[0] = (this.f7074j + this.f7072h) - this.f7067c.f7332a.getLeft();
        } else {
            fArr[0] = this.f7067c.f7332a.getTranslationX();
        }
        if ((this.f7079o & 3) != 0) {
            fArr[1] = (this.f7075k + this.f7073i) - this.f7067c.f7332a.getTop();
        } else {
            fArr[1] = this.f7067c.f7332a.getTranslationY();
        }
    }

    private static boolean y(View view, float f8, float f9, float f10, float f11) {
        if (f8 >= f10 && f8 <= f10 + view.getWidth() && f9 >= f11 && f9 <= f11 + view.getHeight()) {
            return true;
        }
        return false;
    }

    void A() {
        VelocityTracker velocityTracker = this.f7084t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.f7084t = VelocityTracker.obtain();
    }

    void B(final RecoverAnimation recoverAnimation, final int i8) {
        this.f7082r.post(new Runnable() { // from class: androidx.recyclerview.widget.ItemTouchHelper.4
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = ItemTouchHelper.this.f7082r;
                if (recyclerView != null && recyclerView.isAttachedToWindow()) {
                    RecoverAnimation recoverAnimation2 = recoverAnimation;
                    if (!recoverAnimation2.f7115l && recoverAnimation2.f7108e.j() != -1) {
                        RecyclerView.ItemAnimator itemAnimator = ItemTouchHelper.this.f7082r.getItemAnimator();
                        if ((itemAnimator == null || !itemAnimator.q(null)) && !ItemTouchHelper.this.x()) {
                            ItemTouchHelper.this.f7077m.B(recoverAnimation.f7108e, i8);
                        } else {
                            ItemTouchHelper.this.f7082r.post(this);
                        }
                    }
                }
            }
        });
    }

    void D(View view) {
        if (view == this.f7088x) {
            this.f7088x = null;
            if (this.f7087w != null) {
                this.f7082r.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c1, code lost:
        if (r1 > 0) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0100 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean E() {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ItemTouchHelper.E():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void F(androidx.recyclerview.widget.RecyclerView.ViewHolder r24, int r25) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ItemTouchHelper.F(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    void K(MotionEvent motionEvent, int i8, int i9) {
        float x7 = motionEvent.getX(i9);
        float y7 = motionEvent.getY(i9);
        float f8 = x7 - this.f7068d;
        this.f7072h = f8;
        this.f7073i = y7 - this.f7069e;
        if ((i8 & 4) == 0) {
            this.f7072h = Math.max(0.0f, f8);
        }
        if ((i8 & 8) == 0) {
            this.f7072h = Math.min(0.0f, this.f7072h);
        }
        if ((i8 & 1) == 0) {
            this.f7073i = Math.max(0.0f, this.f7073i);
        }
        if ((i8 & 2) == 0) {
            this.f7073i = Math.min(0.0f, this.f7073i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void b(@NonNull View view) {
        D(view);
        RecyclerView.ViewHolder j02 = this.f7082r.j0(view);
        if (j02 == null) {
            return;
        }
        RecyclerView.ViewHolder viewHolder = this.f7067c;
        if (viewHolder != null && j02 == viewHolder) {
            F(null, 0);
            return;
        }
        r(j02, false);
        if (this.f7065a.remove(j02.f7332a)) {
            this.f7077m.c(this.f7082r, j02);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void d(@NonNull View view) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.setEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f8;
        float f9;
        this.f7089y = -1;
        if (this.f7067c != null) {
            w(this.f7066b);
            float[] fArr = this.f7066b;
            float f10 = fArr[0];
            f9 = fArr[1];
            f8 = f10;
        } else {
            f8 = 0.0f;
            f9 = 0.0f;
        }
        this.f7077m.w(canvas, recyclerView, this.f7067c, this.f7080p, this.f7078n, f8, f9);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f8;
        float f9;
        if (this.f7067c != null) {
            w(this.f7066b);
            float[] fArr = this.f7066b;
            float f10 = fArr[0];
            f9 = fArr[1];
            f8 = f10;
        } else {
            f8 = 0.0f;
            f9 = 0.0f;
        }
        this.f7077m.x(canvas, recyclerView, this.f7067c, this.f7080p, this.f7078n, f8, f9);
    }

    public void m(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f7082r;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            q();
        }
        this.f7082r = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.f7070f = resources.getDimension(R$dimen.item_touch_helper_swipe_escape_velocity);
            this.f7071g = resources.getDimension(R$dimen.item_touch_helper_swipe_escape_max_velocity);
            G();
        }
    }

    void o(int i8, MotionEvent motionEvent, int i9) {
        RecyclerView.ViewHolder v7;
        int f8;
        if (this.f7067c != null || i8 != 2 || this.f7078n == 2 || !this.f7077m.q() || this.f7082r.getScrollState() == 1 || (v7 = v(motionEvent)) == null || (f8 = (this.f7077m.f(this.f7082r, v7) & 65280) >> 8) == 0) {
            return;
        }
        float x7 = motionEvent.getX(i9);
        float y7 = motionEvent.getY(i9);
        float f9 = x7 - this.f7068d;
        float f10 = y7 - this.f7069e;
        float abs = Math.abs(f9);
        float abs2 = Math.abs(f10);
        int i10 = this.f7081q;
        if (abs < i10 && abs2 < i10) {
            return;
        }
        if (abs > abs2) {
            if (f9 < 0.0f && (f8 & 4) == 0) {
                return;
            }
            if (f9 > 0.0f && (f8 & 8) == 0) {
                return;
            }
        } else if (f10 < 0.0f && (f8 & 1) == 0) {
            return;
        } else {
            if (f10 > 0.0f && (f8 & 2) == 0) {
                return;
            }
        }
        this.f7073i = 0.0f;
        this.f7072h = 0.0f;
        this.f7076l = motionEvent.getPointerId(0);
        F(v7, 1);
    }

    void r(RecyclerView.ViewHolder viewHolder, boolean z7) {
        for (int size = this.f7080p.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.f7080p.get(size);
            if (recoverAnimation.f7108e == viewHolder) {
                recoverAnimation.f7115l |= z7;
                if (!recoverAnimation.f7116m) {
                    recoverAnimation.a();
                }
                this.f7080p.remove(size);
                return;
            }
        }
    }

    RecoverAnimation s(MotionEvent motionEvent) {
        if (this.f7080p.isEmpty()) {
            return null;
        }
        View t7 = t(motionEvent);
        for (int size = this.f7080p.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.f7080p.get(size);
            if (recoverAnimation.f7108e.f7332a == t7) {
                return recoverAnimation;
            }
        }
        return null;
    }

    View t(MotionEvent motionEvent) {
        float x7 = motionEvent.getX();
        float y7 = motionEvent.getY();
        RecyclerView.ViewHolder viewHolder = this.f7067c;
        if (viewHolder != null) {
            View view = viewHolder.f7332a;
            if (y(view, x7, y7, this.f7074j + this.f7072h, this.f7075k + this.f7073i)) {
                return view;
            }
        }
        for (int size = this.f7080p.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.f7080p.get(size);
            View view2 = recoverAnimation.f7108e.f7332a;
            if (y(view2, x7, y7, recoverAnimation.f7113j, recoverAnimation.f7114k)) {
                return view2;
            }
        }
        return this.f7082r.T(x7, y7);
    }

    boolean x() {
        int size = this.f7080p.size();
        for (int i8 = 0; i8 < size; i8++) {
            if (!this.f7080p.get(i8).f7116m) {
                return true;
            }
        }
        return false;
    }

    void z(RecyclerView.ViewHolder viewHolder) {
        if (this.f7082r.isLayoutRequested() || this.f7078n != 2) {
            return;
        }
        float j8 = this.f7077m.j(viewHolder);
        int i8 = (int) (this.f7074j + this.f7072h);
        int i9 = (int) (this.f7075k + this.f7073i);
        if (Math.abs(i9 - viewHolder.f7332a.getTop()) < viewHolder.f7332a.getHeight() * j8 && Math.abs(i8 - viewHolder.f7332a.getLeft()) < viewHolder.f7332a.getWidth() * j8) {
            return;
        }
        List<RecyclerView.ViewHolder> u7 = u(viewHolder);
        if (u7.size() == 0) {
            return;
        }
        RecyclerView.ViewHolder b8 = this.f7077m.b(viewHolder, u7, i8, i9);
        if (b8 == null) {
            this.f7085u.clear();
            this.f7086v.clear();
            return;
        }
        int j9 = b8.j();
        int j10 = viewHolder.j();
        if (this.f7077m.y(this.f7082r, viewHolder, b8)) {
            this.f7077m.z(this.f7082r, viewHolder, j10, b8, j9, i8, i9);
        }
    }
}
