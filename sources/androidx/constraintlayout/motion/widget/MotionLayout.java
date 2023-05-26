package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.core.view.NestedScrollingParent3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    public static boolean C0;
    private boolean A0;
    ArrayList<Integer> B0;
    Interpolator E;
    Interpolator F;
    float G;
    private int H;
    int I;
    private int J;
    private boolean K;
    HashMap<View, MotionController> L;
    private long M;
    private float N;
    float O;
    float P;
    private long Q;
    float R;
    private boolean S;
    boolean T;
    private TransitionListener U;
    int V;
    private boolean W;

    /* renamed from: a0  reason: collision with root package name */
    private StopLogic f4856a0;

    /* renamed from: b0  reason: collision with root package name */
    private DesignTool f4857b0;

    /* renamed from: c0  reason: collision with root package name */
    boolean f4858c0;

    /* renamed from: d0  reason: collision with root package name */
    float f4859d0;

    /* renamed from: e0  reason: collision with root package name */
    float f4860e0;

    /* renamed from: f0  reason: collision with root package name */
    long f4861f0;

    /* renamed from: g0  reason: collision with root package name */
    float f4862g0;

    /* renamed from: h0  reason: collision with root package name */
    private boolean f4863h0;

    /* renamed from: i0  reason: collision with root package name */
    private ArrayList<MotionHelper> f4864i0;

    /* renamed from: j0  reason: collision with root package name */
    private ArrayList<MotionHelper> f4865j0;

    /* renamed from: k0  reason: collision with root package name */
    private ArrayList<MotionHelper> f4866k0;

    /* renamed from: l0  reason: collision with root package name */
    private CopyOnWriteArrayList<TransitionListener> f4867l0;

    /* renamed from: m0  reason: collision with root package name */
    private int f4868m0;

    /* renamed from: n0  reason: collision with root package name */
    private float f4869n0;

    /* renamed from: o0  reason: collision with root package name */
    boolean f4870o0;

    /* renamed from: p0  reason: collision with root package name */
    protected boolean f4871p0;

    /* renamed from: q0  reason: collision with root package name */
    float f4872q0;

    /* renamed from: r0  reason: collision with root package name */
    private KeyCache f4873r0;

    /* renamed from: s0  reason: collision with root package name */
    private boolean f4874s0;

    /* renamed from: t0  reason: collision with root package name */
    private StateCache f4875t0;

    /* renamed from: u0  reason: collision with root package name */
    private Runnable f4876u0;

    /* renamed from: v0  reason: collision with root package name */
    private int[] f4877v0;

    /* renamed from: w0  reason: collision with root package name */
    int f4878w0;

    /* renamed from: x0  reason: collision with root package name */
    private int f4879x0;

    /* renamed from: y0  reason: collision with root package name */
    private boolean f4880y0;

    /* renamed from: z0  reason: collision with root package name */
    TransitionState f4881z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$5  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4883a;

        static {
            int[] iArr = new int[TransitionState.values().length];
            f4883a = iArr;
            try {
                iArr[TransitionState.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4883a[TransitionState.SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4883a[TransitionState.MOVING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4883a[TransitionState.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class StateCache {

        /* renamed from: a  reason: collision with root package name */
        float f4884a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        float f4885b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        int f4886c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f4887d = -1;

        /* renamed from: e  reason: collision with root package name */
        final String f4888e = "motion.progress";

        /* renamed from: f  reason: collision with root package name */
        final String f4889f = "motion.velocity";

        /* renamed from: g  reason: collision with root package name */
        final String f4890g = "motion.StartState";

        /* renamed from: h  reason: collision with root package name */
        final String f4891h = "motion.EndState";

        StateCache() {
        }

        void a() {
            int i8 = this.f4886c;
            if (i8 != -1 || this.f4887d != -1) {
                if (i8 == -1) {
                    MotionLayout.this.P(this.f4887d);
                } else {
                    int i9 = this.f4887d;
                    if (i9 == -1) {
                        MotionLayout.this.M(i8, -1, -1);
                    } else {
                        MotionLayout.this.N(i8, i9);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (Float.isNaN(this.f4885b)) {
                if (Float.isNaN(this.f4884a)) {
                    return;
                }
                MotionLayout.this.setProgress(this.f4884a);
                return;
            }
            MotionLayout.this.L(this.f4884a, this.f4885b);
            this.f4884a = Float.NaN;
            this.f4885b = Float.NaN;
            this.f4886c = -1;
            this.f4887d = -1;
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f4884a);
            bundle.putFloat("motion.velocity", this.f4885b);
            bundle.putInt("motion.StartState", this.f4886c);
            bundle.putInt("motion.EndState", this.f4887d);
            return bundle;
        }

        public void c() {
            this.f4887d = MotionLayout.this.J;
            this.f4886c = MotionLayout.this.H;
            this.f4885b = MotionLayout.this.getVelocity();
            this.f4884a = MotionLayout.this.getProgress();
        }

        public void d(int i8) {
            this.f4887d = i8;
        }

        public void e(float f8) {
            this.f4884a = f8;
        }

        public void f(int i8) {
            this.f4886c = i8;
        }

        public void g(Bundle bundle) {
            this.f4884a = bundle.getFloat("motion.progress");
            this.f4885b = bundle.getFloat("motion.velocity");
            this.f4886c = bundle.getInt("motion.StartState");
            this.f4887d = bundle.getInt("motion.EndState");
        }

        public void h(float f8) {
            this.f4885b = f8;
        }
    }

    /* loaded from: classes.dex */
    public interface TransitionListener {
        void a(MotionLayout motionLayout, int i8, int i9, float f8);

        void b(MotionLayout motionLayout, int i8);

        void c(MotionLayout motionLayout, int i8, int i9);

        void d(MotionLayout motionLayout, int i8, boolean z7, float f8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    private void G() {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if ((this.U != null || ((copyOnWriteArrayList = this.f4867l0) != null && !copyOnWriteArrayList.isEmpty())) && this.f4869n0 != this.O) {
            if (this.f4868m0 != -1) {
                TransitionListener transitionListener = this.U;
                if (transitionListener != null) {
                    transitionListener.c(this, this.H, this.J);
                }
                CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList2 = this.f4867l0;
                if (copyOnWriteArrayList2 != null) {
                    Iterator<TransitionListener> it = copyOnWriteArrayList2.iterator();
                    while (it.hasNext()) {
                        it.next().c(this, this.H, this.J);
                    }
                }
                this.f4870o0 = true;
            }
            this.f4868m0 = -1;
            float f8 = this.O;
            this.f4869n0 = f8;
            TransitionListener transitionListener2 = this.U;
            if (transitionListener2 != null) {
                transitionListener2.a(this, this.H, this.J, f8);
            }
            CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList3 = this.f4867l0;
            if (copyOnWriteArrayList3 != null) {
                Iterator<TransitionListener> it2 = copyOnWriteArrayList3.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this, this.H, this.J, this.O);
                }
            }
            this.f4870o0 = true;
        }
    }

    private void K() {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if (this.U == null && ((copyOnWriteArrayList = this.f4867l0) == null || copyOnWriteArrayList.isEmpty())) {
            return;
        }
        this.f4870o0 = false;
        Iterator<Integer> it = this.B0.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            TransitionListener transitionListener = this.U;
            if (transitionListener != null) {
                transitionListener.b(this, next.intValue());
            }
            CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList2 = this.f4867l0;
            if (copyOnWriteArrayList2 != null) {
                Iterator<TransitionListener> it2 = copyOnWriteArrayList2.iterator();
                while (it2.hasNext()) {
                    it2.next().b(this, next.intValue());
                }
            }
        }
        this.B0.clear();
    }

    void E(float f8) {
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0174  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void F(boolean r24) {
        /*
            Method dump skipped, instructions count: 607
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.F(boolean):void");
    }

    protected void H() {
        int i8;
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if ((this.U != null || ((copyOnWriteArrayList = this.f4867l0) != null && !copyOnWriteArrayList.isEmpty())) && this.f4868m0 == -1) {
            this.f4868m0 = this.I;
            if (!this.B0.isEmpty()) {
                ArrayList<Integer> arrayList = this.B0;
                i8 = arrayList.get(arrayList.size() - 1).intValue();
            } else {
                i8 = -1;
            }
            int i9 = this.I;
            if (i8 != i9 && i9 != -1) {
                this.B0.add(Integer.valueOf(i9));
            }
        }
        K();
        Runnable runnable = this.f4876u0;
        if (runnable != null) {
            runnable.run();
        }
        int[] iArr = this.f4877v0;
        if (iArr != null && this.f4878w0 > 0) {
            P(iArr[0]);
            int[] iArr2 = this.f4877v0;
            System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
            this.f4878w0--;
        }
    }

    public void I(int i8, boolean z7, float f8) {
        TransitionListener transitionListener = this.U;
        if (transitionListener != null) {
            transitionListener.d(this, i8, z7, f8);
        }
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.f4867l0;
        if (copyOnWriteArrayList != null) {
            Iterator<TransitionListener> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().d(this, i8, z7, f8);
            }
        }
    }

    void J() {
    }

    public void L(float f8, float f9) {
        if (!isAttachedToWindow()) {
            if (this.f4875t0 == null) {
                this.f4875t0 = new StateCache();
            }
            this.f4875t0.e(f8);
            this.f4875t0.h(f9);
            return;
        }
        setProgress(f8);
        setState(TransitionState.MOVING);
        this.G = f9;
        float f10 = 1.0f;
        int i8 = (f9 > 0.0f ? 1 : (f9 == 0.0f ? 0 : -1));
        if (i8 != 0) {
            if (i8 <= 0) {
                f10 = 0.0f;
            }
            E(f10);
        } else if (f8 != 0.0f && f8 != 1.0f) {
            if (f8 <= 0.5f) {
                f10 = 0.0f;
            }
            E(f10);
        }
    }

    public void M(int i8, int i9, int i10) {
        setState(TransitionState.SETUP);
        this.I = i8;
        this.H = -1;
        this.J = -1;
        ConstraintLayoutStates constraintLayoutStates = this.f4982p;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.d(i8, i9, i10);
        }
    }

    public void N(int i8, int i9) {
        if (!isAttachedToWindow()) {
            if (this.f4875t0 == null) {
                this.f4875t0 = new StateCache();
            }
            this.f4875t0.f(i8);
            this.f4875t0.d(i9);
        }
    }

    public void O() {
        E(1.0f);
        this.f4876u0 = null;
    }

    public void P(int i8) {
        if (!isAttachedToWindow()) {
            if (this.f4875t0 == null) {
                this.f4875t0 = new StateCache();
            }
            this.f4875t0.d(i8);
            return;
        }
        Q(i8, -1, -1);
    }

    public void Q(int i8, int i9, int i10) {
        R(i8, i9, i10, -1);
    }

    public void R(int i8, int i9, int i10, int i11) {
        int i12 = this.I;
        if (i12 == i8) {
            return;
        }
        if (this.H == i8) {
            E(0.0f);
            if (i11 > 0) {
                this.N = i11 / 1000.0f;
            }
        } else if (this.J == i8) {
            E(1.0f);
            if (i11 > 0) {
                this.N = i11 / 1000.0f;
            }
        } else {
            this.J = i8;
            if (i12 != -1) {
                N(i12, i8);
                E(1.0f);
                this.P = 0.0f;
                O();
                if (i11 > 0) {
                    this.N = i11 / 1000.0f;
                    return;
                }
                return;
            }
            this.W = false;
            this.R = 1.0f;
            this.O = 0.0f;
            this.P = 0.0f;
            this.Q = getNanoTime();
            this.M = getNanoTime();
            this.S = false;
            this.E = null;
            if (i11 == -1) {
                throw null;
            }
            this.H = -1;
            throw null;
        }
    }

    public void S(int i8, View... viewArr) {
        Log.e("MotionLayout", " no motionScene");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        ArrayList<MotionHelper> arrayList = this.f4866k0;
        if (arrayList != null) {
            Iterator<MotionHelper> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().x(canvas);
            }
        }
        F(false);
        super.dispatchDraw(canvas);
    }

    public int[] getConstraintSetIds() {
        return null;
    }

    public int getCurrentState() {
        return this.I;
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        return null;
    }

    public DesignTool getDesignTool() {
        if (this.f4857b0 == null) {
            this.f4857b0 = new DesignTool(this);
        }
        return this.f4857b0;
    }

    public int getEndState() {
        return this.J;
    }

    protected long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.P;
    }

    public MotionScene getScene() {
        return null;
    }

    public int getStartState() {
        return this.H;
    }

    public float getTargetPosition() {
        return this.R;
    }

    public Bundle getTransitionState() {
        if (this.f4875t0 == null) {
            this.f4875t0 = new StateCache();
        }
        this.f4875t0.c();
        return this.f4875t0.b();
    }

    public long getTransitionTimeMs() {
        return this.N * 1000.0f;
    }

    public float getVelocity() {
        return this.G;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void i(@NonNull View view, @NonNull View view2, int i8, int i9) {
        this.f4861f0 = getNanoTime();
        this.f4862g0 = 0.0f;
        this.f4859d0 = 0.0f;
        this.f4860e0 = 0.0f;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void j(@NonNull View view, int i8) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void k(@NonNull View view, int i8, int i9, @NonNull int[] iArr, int i10) {
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void m(@NonNull View view, int i8, int i9, int i10, int i11, int i12, int[] iArr) {
        if (this.f4858c0 || i8 != 0 || i9 != 0) {
            iArr[0] = iArr[0] + i10;
            iArr[1] = iArr[1] + i11;
        }
        this.f4858c0 = false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void n(@NonNull View view, int i8, int i9, int i10, int i11, int i12) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean o(@NonNull View view, @NonNull View view2, int i8, int i9) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            this.f4879x0 = display.getRotation();
        }
        J();
        StateCache stateCache = this.f4875t0;
        if (stateCache != null) {
            if (this.f4880y0) {
                post(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        MotionLayout.this.f4875t0.a();
                    }
                });
            } else {
                stateCache.a();
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        this.f4874s0 = true;
        try {
            super.onLayout(z7, i8, i9, i10, i11);
        } finally {
            this.f4874s0 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(@NonNull View view, float f8, float f9, boolean z7) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(@NonNull View view, float f8, float f9) {
        return false;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i8) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.f4867l0 == null) {
                this.f4867l0 = new CopyOnWriteArrayList<>();
            }
            this.f4867l0.add(motionHelper);
            if (motionHelper.w()) {
                if (this.f4864i0 == null) {
                    this.f4864i0 = new ArrayList<>();
                }
                this.f4864i0.add(motionHelper);
            }
            if (motionHelper.v()) {
                if (this.f4865j0 == null) {
                    this.f4865j0 = new ArrayList<>();
                }
                this.f4865j0.add(motionHelper);
            }
            if (motionHelper.u()) {
                if (this.f4866k0 == null) {
                    this.f4866k0 = new ArrayList<>();
                }
                this.f4866k0.add(motionHelper);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.f4864i0;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.f4865j0;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.f4871p0) {
            int i8 = this.I;
        }
        super.requestLayout();
    }

    public void setDebugMode(int i8) {
        this.V = i8;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z7) {
        this.f4880y0 = z7;
    }

    public void setInteractionEnabled(boolean z7) {
        this.K = z7;
    }

    public void setInterpolatedProgress(float f8) {
        setProgress(f8);
    }

    public void setOnHide(float f8) {
        ArrayList<MotionHelper> arrayList = this.f4865j0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i8 = 0; i8 < size; i8++) {
                this.f4865j0.get(i8).setProgress(f8);
            }
        }
    }

    public void setOnShow(float f8) {
        ArrayList<MotionHelper> arrayList = this.f4864i0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i8 = 0; i8 < size; i8++) {
                this.f4864i0.get(i8).setProgress(f8);
            }
        }
    }

    public void setProgress(float f8) {
        int i8 = (f8 > 0.0f ? 1 : (f8 == 0.0f ? 0 : -1));
        if (i8 < 0 || f8 > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.f4875t0 == null) {
                this.f4875t0 = new StateCache();
            }
            this.f4875t0.e(f8);
        } else if (i8 <= 0) {
            if (this.P == 1.0f && this.I == this.J) {
                setState(TransitionState.MOVING);
            }
            this.I = this.H;
            if (this.P == 0.0f) {
                setState(TransitionState.FINISHED);
            }
        } else if (f8 >= 1.0f) {
            if (this.P == 0.0f && this.I == this.H) {
                setState(TransitionState.MOVING);
            }
            this.I = this.J;
            if (this.P == 1.0f) {
                setState(TransitionState.FINISHED);
            }
        } else {
            this.I = -1;
            setState(TransitionState.MOVING);
        }
    }

    public void setScene(MotionScene motionScene) {
        r();
        throw null;
    }

    void setStartState(int i8) {
        if (!isAttachedToWindow()) {
            if (this.f4875t0 == null) {
                this.f4875t0 = new StateCache();
            }
            this.f4875t0.f(i8);
            this.f4875t0.d(i8);
            return;
        }
        this.I = i8;
    }

    void setState(TransitionState transitionState) {
        TransitionState transitionState2 = TransitionState.FINISHED;
        if (transitionState == transitionState2 && this.I == -1) {
            return;
        }
        TransitionState transitionState3 = this.f4881z0;
        this.f4881z0 = transitionState;
        TransitionState transitionState4 = TransitionState.MOVING;
        if (transitionState3 == transitionState4 && transitionState == transitionState4) {
            G();
        }
        int i8 = AnonymousClass5.f4883a[transitionState3.ordinal()];
        if (i8 != 1 && i8 != 2) {
            if (i8 == 3 && transitionState == transitionState2) {
                H();
                return;
            }
            return;
        }
        if (transitionState == transitionState4) {
            G();
        }
        if (transitionState == transitionState2) {
            H();
        }
    }

    public void setTransition(int i8) {
    }

    protected void setTransition(MotionScene.Transition transition) {
        throw null;
    }

    public void setTransitionDuration(int i8) {
        Log.e("MotionLayout", "MotionScene not defined");
    }

    public void setTransitionListener(TransitionListener transitionListener) {
        this.U = transitionListener;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.f4875t0 == null) {
            this.f4875t0 = new StateCache();
        }
        this.f4875t0.g(bundle);
        if (isAttachedToWindow()) {
            this.f4875t0.a();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void t(int i8) {
        this.f4982p = null;
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return Debug.a(context, this.H) + "->" + Debug.a(context, this.J) + " (pos:" + this.P + " Dpos/Dt:" + this.G;
    }
}
