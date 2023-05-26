package eu.bolt.verification.sdk.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior;
import eu.bolt.verification.R$styleable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import timber.log.Timber;

/* loaded from: classes5.dex */
public class e4 extends CoordinatorLayout implements q4 {

    /* renamed from: j0  reason: collision with root package name */
    private static final n9 f42715j0 = n9.HIDEABLE_ONLY_VIA_API;

    /* renamed from: k0  reason: collision with root package name */
    private static final ae f42716k0 = ae.HIDDEN;
    private final BehaviorSubject<ae> E;
    private final BehaviorSubject<ae> F;
    private final BehaviorSubject<kh> G;
    private final BehaviorSubject<lh> H;
    private final BehaviorSubject<Integer> I;
    private final BehaviorSubject<Integer> J;
    private final y0 K;
    private final Scheduler L;
    private vd<View> M;
    private int N;
    private vd<DesignBottomSheetBehavior<View>> O;
    private wd P;
    private f7 Q;
    private boolean R;
    private boolean S;
    private ae T;
    private boolean U;
    private n9 V;
    private vd<ColorDrawable> W;

    /* renamed from: a0  reason: collision with root package name */
    private int f42717a0;

    /* renamed from: b0  reason: collision with root package name */
    private BehaviorSubject<Integer> f42718b0;

    /* renamed from: c0  reason: collision with root package name */
    private CompositeDisposable f42719c0;

    /* renamed from: d0  reason: collision with root package name */
    private vd<Function0<Boolean>> f42720d0;

    /* renamed from: e0  reason: collision with root package name */
    private Disposable f42721e0;

    /* renamed from: f0  reason: collision with root package name */
    private int f42722f0;

    /* renamed from: g0  reason: collision with root package name */
    private int f42723g0;

    /* renamed from: h0  reason: collision with root package name */
    private boolean f42724h0;

    /* renamed from: i0  reason: collision with root package name */
    private Runnable f42725i0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f42726a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f42727b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f42728c;

        static {
            int[] iArr = new int[ae.values().length];
            f42728c = iArr;
            try {
                iArr[ae.SETTLING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f42728c[ae.DRAGGING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f42728c[ae.HIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f42728c[ae.PEEK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f42728c[ae.EXPANDED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[wd.values().length];
            f42727b = iArr2;
            try {
                iArr2[wd.COLLAPSE_IF_EXPANDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f42727b[wd.COLLAPSE_OR_HIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f42727b[wd.HIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f42727b[wd.NO.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr3 = new int[f7.values().length];
            f42726a = iArr3;
            try {
                iArr3[f7.ALWAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f42726a[f7.WHEN_EXPANDED.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f42726a[f7.NEVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends DesignBottomSheetBehavior.b {
        private b() {
        }

        private void c() {
            if (e4.this.M.f()) {
                e4.this.o0(((View) e4.this.M.d()).getTop());
            } else {
                t3.a("SlidingView somehow is null");
            }
        }

        private void d(float f8) {
            int measuredHeight = !e4.this.M.f() ? 0 : ((View) e4.this.M.d()).getMeasuredHeight();
            int measuredHeight2 = e4.this.getMeasuredHeight();
            e4.this.G.onNext(new kh(f8, (measuredHeight2 - ((View) e4.this.M.d()).getTop()) / Math.min(measuredHeight2, measuredHeight)));
        }

        @Override // eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.b
        public void a(@NonNull View view, float f8) {
            d(f8);
            c();
        }

        @Override // eu.bolt.client.design.bottomsheet.behavior.DesignBottomSheetBehavior.b
        public void b(@NonNull View view, int i8) {
            if (e4.this.O.f()) {
                e4.this.H0(i8);
            } else {
                t3.a("Behavior somehow is null");
            }
        }
    }

    public e4(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        ae aeVar = f42716k0;
        this.E = BehaviorSubject.f(aeVar);
        this.F = BehaviorSubject.f(aeVar);
        this.G = BehaviorSubject.f(new kh(-1.0f, 0.0f));
        this.H = BehaviorSubject.e();
        this.I = BehaviorSubject.f(0);
        this.J = BehaviorSubject.f(-1);
        this.K = new y0();
        this.L = AndroidSchedulers.a();
        this.M = vd.a();
        this.O = vd.a();
        this.P = wd.NO;
        this.Q = f7.NEVER;
        this.R = true;
        this.S = true;
        this.T = ae.HIDDEN;
        this.U = true;
        this.V = f42715j0;
        this.W = vd.a();
        this.f42718b0 = BehaviorSubject.f(0);
        this.f42719c0 = new CompositeDisposable();
        this.f42720d0 = vd.a();
        this.f42721e0 = Disposables.a();
        this.f42724h0 = true;
        q0(attributeSet);
        N0();
    }

    private ae A0(int i8) {
        switch (i8) {
            case 1:
                return ae.DRAGGING;
            case 2:
                return ae.SETTLING;
            case 3:
                return ae.EXPANDED;
            case 4:
                return ae.PEEK;
            case 5:
                return ae.HIDDEN;
            case 6:
                throw new IllegalStateException("Unsupported state: " + i8);
            default:
                throw new IllegalStateException("Unknown state: " + i8);
        }
    }

    private void C0() {
        n9 n9Var;
        int intValue = this.I.g().intValue();
        setInternalDraggable((intValue == 0 && ((n9Var = this.V) == n9.NON_HIDEABLE || n9Var == n9.HIDEABLE_ONLY_VIA_API)) ? false : true);
        if (intValue == 0 && this.V == n9.NON_HIDEABLE) {
            setPanelStateAnimated(ae.EXPANDED);
        }
    }

    private void D0(DesignBottomSheetBehavior<View> designBottomSheetBehavior) {
        designBottomSheetBehavior.c0(this.R && this.U);
        designBottomSheetBehavior.X(this.S);
    }

    private void E0(DesignBottomSheetBehavior<View> designBottomSheetBehavior, ae aeVar) {
        designBottomSheetBehavior.p0(z0(aeVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(Integer num) {
        C0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(int i8) {
        ae l02 = l0(A0(i8));
        if (this.V != n9.NON_HIDEABLE || l02 != ae.HIDDEN) {
            setPanelStateInternal(l02);
            return;
        }
        Timber.d("Got into HIDDEN mode while NON_HIDEABLE. Rescuing to EXPANDED", new Object[0]);
        setPanelStateAnimated(ae.EXPANDED);
    }

    private void I0(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        CoordinatorLayout.LayoutParams layoutParams2 = layoutParams instanceof CoordinatorLayout.LayoutParams ? (CoordinatorLayout.LayoutParams) layoutParams : layoutParams == null ? new CoordinatorLayout.LayoutParams(-1, -2) : new CoordinatorLayout.LayoutParams(layoutParams);
        DesignBottomSheetBehavior<View> k02 = k0(view);
        this.O = vd.b(k02);
        layoutParams2.o(k02);
        r0(layoutParams2);
        view.setLayoutParams(layoutParams2);
        H0(k02.d0());
    }

    private void J0(DesignBottomSheetBehavior<View> designBottomSheetBehavior) {
        designBottomSheetBehavior.V(this.V);
    }

    private void K0() {
        if (getTargetPanelState() == ae.PEEK) {
            setPanelStateAnimated(this.V == n9.NON_HIDEABLE ? ae.EXPANDED : ae.HIDDEN);
        }
    }

    private void L0(int i8) {
        vd<View> b8 = vd.b(findViewById(i8));
        this.M = b8;
        if (b8.f()) {
            I0(this.M.d());
        }
    }

    private void N0() {
        this.f42719c0.b(a1());
        this.f42719c0.b(b1());
        setClipChildren(false);
    }

    private void O0() {
        if (!this.O.f()) {
            o0(getHeight());
            return;
        }
        this.O.d().m0();
        P0();
        s0(this.O.d());
    }

    private void P0() {
        this.J.onNext(Integer.valueOf(getSlidingViewHeight()));
    }

    private boolean Q0() {
        return !this.f42721e0.isDisposed() && this.W.f() && ((float) this.W.d().getAlpha()) > 0.0f;
    }

    private static int T(int i8) {
        if ((i8 & 7) == 0) {
            i8 |= 8388611;
        }
        return (i8 & 112) == 0 ? i8 | 48 : i8;
    }

    private void U0() {
        O0();
    }

    private void V0() {
        if (this.M.f()) {
            removeView(this.M.d());
        }
        if (this.O.f()) {
            this.O.d().U(null);
        }
        if (ViewCompat.W(this)) {
            o0(getHeight());
        }
        this.M = vd.a();
        this.O = vd.a();
        this.N = 0;
    }

    private ae W0() {
        ae panelState = getPanelState();
        boolean z7 = false;
        boolean z8 = this.V != n9.NON_HIDEABLE && (panelState == ae.EXPANDED || panelState == ae.PEEK);
        if (panelState == ae.EXPANDED && getPeekHeight() > 0 && getPeekHeight() < getSlidingViewHeight()) {
            z7 = true;
        }
        int i8 = a.f42727b[this.P.ordinal()];
        if (i8 == 1) {
            if (z7) {
                return ae.PEEK;
            }
            return null;
        } else if (i8 != 2) {
            if (i8 == 3 && z8) {
                return ae.HIDDEN;
            }
            return null;
        } else if (z7) {
            return ae.PEEK;
        } else {
            if (z8) {
                return ae.HIDDEN;
            }
            return null;
        }
    }

    private void X0() {
        this.f42721e0.dispose();
        ViewCompat.w0(this, null);
        this.f42718b0.onNext(0);
    }

    private void Y0() {
        if (this.f42721e0.isDisposed()) {
            Disposable Z0 = Z0();
            this.f42721e0 = Z0;
            this.f42719c0.b(Z0);
        }
        if (this.W.f()) {
            if (getBackground() != null) {
                Timber.b("You can't use fadeColor and background and the same time. Background will be overwritten.", new Object[0]);
            }
            ViewCompat.w0(this, this.W.d());
        }
        c1();
    }

    private Disposable Z0() {
        return getSlidePositionObservable().subscribe(new Consumer() { // from class: eu.bolt.verification.sdk.internal.gs
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                e4.this.u0((lh) obj);
            }
        }, new cs());
    }

    private Disposable a1() {
        return Observable.combineLatest(this.I.distinctUntilChanged(), this.J.distinctUntilChanged(), new BiFunction() { // from class: eu.bolt.verification.sdk.internal.es
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Integer m02;
                m02 = e4.this.m0((Integer) obj, (Integer) obj2);
                return m02;
            }
        }).distinctUntilChanged().subscribe(new Consumer() { // from class: eu.bolt.verification.sdk.internal.fs
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                e4.this.w0((Integer) obj);
            }
        }, new cs());
    }

    private Disposable b1() {
        return this.I.distinctUntilChanged().subscribe(new Consumer() { // from class: eu.bolt.verification.sdk.internal.ds
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                e4.this.F0((Integer) obj);
            }
        }, new cs());
    }

    private void c1() {
        v0(vd.b(this.H.g()));
    }

    private int getSlidingViewHeight() {
        if (this.M.f() && ViewCompat.W(this.M.d())) {
            return this.M.d().getMeasuredHeight();
        }
        return -1;
    }

    private DesignBottomSheetBehavior<View> k0(View view) {
        ae panelState = getPanelState();
        DesignBottomSheetBehavior<View> designBottomSheetBehavior = new DesignBottomSheetBehavior<>();
        designBottomSheetBehavior.U(new b());
        designBottomSheetBehavior.n0(m0(this.I.g(), this.J.g()).intValue());
        designBottomSheetBehavior.h0(this.f42722f0);
        designBottomSheetBehavior.k0(this.f42723g0);
        D0(designBottomSheetBehavior);
        J0(designBottomSheetBehavior);
        E0(designBottomSheetBehavior, panelState);
        return designBottomSheetBehavior;
    }

    private ae l0(ae aeVar) {
        if (!this.M.f()) {
            t3.a("SlidingView somehow is null");
            return aeVar;
        }
        int measuredHeight = this.M.d().getMeasuredHeight();
        int measuredHeight2 = getMeasuredHeight();
        int min = Math.min(measuredHeight2, measuredHeight);
        int peekHeight = getPeekHeight();
        int top = measuredHeight2 - this.M.d().getTop();
        if (min != 0) {
            return (top == 0 && peekHeight == 0) ? ae.HIDDEN : (top == peekHeight && peekHeight == min) ? ae.EXPANDED : aeVar;
        }
        ae aeVar2 = ae.HIDDEN;
        return (aeVar != aeVar2 || this.V == n9.NON_HIDEABLE) ? ae.EXPANDED : aeVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer m0(Integer num, Integer num2) {
        int intValue = num.intValue();
        if (num2.intValue() != -1 && num2.intValue() <= num.intValue()) {
            Timber.d("PeekHeight=%s > slidingViewHeight=%s. Using slidingViewHeight - 1", num, num2);
            intValue = num2.intValue() - 1;
        }
        int height = getHeight();
        if (height > 0 && intValue >= height) {
            Timber.d("FixedPeekHeight=%s > parentHeight=%s. Using parentHeight - 1", num, num2);
            intValue = height - 1;
        }
        return Integer.valueOf(intValue);
    }

    private void n0() {
        if (!this.M.f() || this.f42725i0 == null) {
            return;
        }
        this.M.d().removeCallbacks(this.f42725i0);
        this.f42725i0 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(int i8) {
        this.H.onNext(new lh(i8, 0));
    }

    private void q0(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.Z);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f41773f0, 0);
        this.f42722f0 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f41787h0, 0);
        this.N = obtainStyledAttributes.getResourceId(R$styleable.f41780g0, 0);
        this.P = wd.values()[obtainStyledAttributes.getInt(R$styleable.f41738a0, wd.NO.ordinal())];
        int color = obtainStyledAttributes.getColor(R$styleable.f41759d0, -1);
        int i8 = obtainStyledAttributes.getInt(R$styleable.f41766e0, f42715j0.a());
        int i9 = obtainStyledAttributes.getInt(R$styleable.f41745b0, f42716k0.a());
        this.Q = f7.values()[obtainStyledAttributes.getInt(R$styleable.f41752c0, f7.NEVER.ordinal())];
        obtainStyledAttributes.recycle();
        this.V = n9.c(i8);
        this.I.onNext(Integer.valueOf(dimensionPixelSize));
        this.f42724h0 = getContext().getResources().getConfiguration().orientation == 1;
        C0();
        if (color != -1) {
            p0(color, this.Q);
        }
        setStateFromAttribute(i9);
        L0(this.N);
    }

    private void r0(CoordinatorLayout.LayoutParams layoutParams) {
        int T = T(layoutParams.f5456c);
        if ((T & 112) != 48) {
            Timber.d("Don't set vertical gravity to BottomSheetPanel child. It will be overwritten to TOP", new Object[0]);
        }
        layoutParams.f5456c = (T & (-81)) | 48;
    }

    private void s0(DesignBottomSheetBehavior<View> designBottomSheetBehavior) {
        if (designBottomSheetBehavior.d0() == designBottomSheetBehavior.g0()) {
            H0(designBottomSheetBehavior.d0());
        }
    }

    private void setInternalDraggable(boolean z7) {
        this.U = z7;
        if (this.O.f()) {
            D0(this.O.d());
        }
    }

    private void setPanelStateInternal(ae aeVar) {
        if (aeVar == ae.HIDDEN || aeVar == ae.PEEK || aeVar == ae.EXPANDED) {
            this.T = aeVar;
        }
        setTargetState(aeVar);
        this.E.onNext(aeVar);
        v0(vd.b(getSlidePosition()));
    }

    private void setStateFromAttribute(int i8) {
        ae c8 = ae.c(i8);
        if (this.V == n9.NON_HIDEABLE && c8 == ae.HIDDEN) {
            Timber.d("You set HIDDEN and NON_HIDEABLE at the same time. Fix: using EXPANDED", new Object[0]);
            c8 = ae.EXPANDED;
        }
        setTargetState(c8);
        setPanelStateInternal(c8);
    }

    private void setTargetState(@NonNull ae aeVar) {
        if (this.F.g() == aeVar || aeVar == ae.SETTLING || aeVar == ae.DRAGGING) {
            return;
        }
        this.F.onNext(aeVar);
        if (this.O.f()) {
            this.O.d().s0(z0(aeVar));
        }
    }

    private void setupCloseButton(b4 b4Var) {
        this.f42719c0.b(b4Var.g().subscribe(new Consumer() { // from class: eu.bolt.verification.sdk.internal.bs
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                e4.this.x0((Unit) obj);
            }
        }, new cs()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(DesignBottomSheetBehavior designBottomSheetBehavior, ae aeVar) {
        E0(designBottomSheetBehavior, aeVar);
        this.f42725i0 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(lh lhVar) {
        v0(vd.b(lhVar));
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0072, code lost:
        if (getPanelState() == eu.bolt.verification.sdk.internal.ae.EXPANDED) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
        if (getPanelState() == eu.bolt.verification.sdk.internal.ae.EXPANDED) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void v0(eu.bolt.verification.sdk.internal.vd<eu.bolt.verification.sdk.internal.lh> r8) {
        /*
            r7 = this;
            eu.bolt.verification.sdk.internal.vd<android.graphics.drawable.ColorDrawable> r0 = r7.W
            boolean r0 = r0.f()
            if (r0 == 0) goto La8
            int r0 = r7.getPeekHeight()
            int r1 = r7.getMeasuredHeight()
            int r2 = r7.getSlidingViewHeight()
            boolean r3 = r8.e()
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            if (r3 == 0) goto L26
            eu.bolt.verification.sdk.internal.ae r8 = r7.getPanelState()
            eu.bolt.verification.sdk.internal.ae r0 = eu.bolt.verification.sdk.internal.ae.EXPANDED
            if (r8 != r0) goto L75
            goto L7c
        L26:
            r3 = -1
            if (r2 == r3) goto L2e
            int r2 = java.lang.Math.min(r1, r2)
            goto L2f
        L2e:
            r2 = r1
        L2f:
            int r2 = r2 - r0
            java.lang.Object r8 = r8.d()
            eu.bolt.verification.sdk.internal.lh r8 = (eu.bolt.verification.sdk.internal.lh) r8
            int r8 = r8.a()
            int r1 = r1 - r8
            float r8 = (float) r1
            eu.bolt.verification.sdk.internal.ae r1 = r7.getPanelState()
            eu.bolt.verification.sdk.internal.ae r3 = eu.bolt.verification.sdk.internal.ae.HIDDEN
            if (r1 == r3) goto L51
            eu.bolt.verification.sdk.internal.ae r1 = r7.getPanelState()
            eu.bolt.verification.sdk.internal.ae r3 = eu.bolt.verification.sdk.internal.ae.SETTLING
            if (r1 != r3) goto L4f
            if (r0 != 0) goto L4f
            goto L51
        L4f:
            r1 = 0
            goto L52
        L51:
            r1 = 1
        L52:
            if (r0 <= 0) goto L61
            eu.bolt.verification.sdk.internal.f7 r3 = r7.Q
            eu.bolt.verification.sdk.internal.f7 r6 = eu.bolt.verification.sdk.internal.f7.ALWAYS
            if (r3 != r6) goto L61
            float r0 = (float) r0
            float r8 = r8 / r0
            float r4 = java.lang.Math.min(r8, r4)
            goto L7c
        L61:
            eu.bolt.verification.sdk.internal.f7 r3 = r7.Q
            eu.bolt.verification.sdk.internal.f7 r6 = eu.bolt.verification.sdk.internal.f7.WHEN_EXPANDED
            if (r3 != r6) goto L6a
            if (r1 == 0) goto L6a
            goto L75
        L6a:
            if (r2 > 0) goto L77
            eu.bolt.verification.sdk.internal.ae r8 = r7.getPanelState()
            eu.bolt.verification.sdk.internal.ae r0 = eu.bolt.verification.sdk.internal.ae.EXPANDED
            if (r8 != r0) goto L75
            goto L7c
        L75:
            r4 = 0
            goto L7c
        L77:
            float r0 = (float) r0
            float r8 = r8 - r0
            float r0 = (float) r2
            float r4 = r8 / r0
        L7c:
            int r8 = r7.f42717a0
            float r8 = (float) r8
            float r4 = r4 * r8
            int r8 = (int) r4
            r0 = 255(0xff, float:3.57E-43)
            int r8 = androidx.core.math.MathUtils.b(r8, r5, r0)
            eu.bolt.verification.sdk.internal.vd<android.graphics.drawable.ColorDrawable> r0 = r7.W
            java.lang.Object r0 = r0.d()
            android.graphics.drawable.ColorDrawable r0 = (android.graphics.drawable.ColorDrawable) r0
            r0.setAlpha(r8)
            io.reactivex.subjects.BehaviorSubject<java.lang.Integer> r8 = r7.f42718b0
            eu.bolt.verification.sdk.internal.vd<android.graphics.drawable.ColorDrawable> r0 = r7.W
            java.lang.Object r0 = r0.d()
            android.graphics.drawable.ColorDrawable r0 = (android.graphics.drawable.ColorDrawable) r0
            int r0 = r0.getColor()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r8.onNext(r0)
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.verification.sdk.internal.e4.v0(eu.bolt.verification.sdk.internal.vd):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(Integer num) {
        if (this.O.f()) {
            if (num.intValue() == 0) {
                K0();
            }
            this.O.d().n0(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(Unit unit) {
        M0();
    }

    private boolean y0(MotionEvent motionEvent) {
        if (this.M.f()) {
            return !C(this.M.d(), (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        return true;
    }

    private int z0(@NonNull ae aeVar) {
        int i8 = a.f42728c[aeVar.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        if (i8 == 5) {
                            return 3;
                        }
                        throw new IllegalStateException("Unknown state: " + aeVar);
                    }
                    return 4;
                }
                return 5;
            }
            return 1;
        }
        return 2;
    }

    public b4 B0(View view) {
        b4 e8 = b4.e(view);
        setSlidingView(e8);
        setupCloseButton(e8);
        return e8;
    }

    public void G0() {
        setPanelStateAnimated(ae.EXPANDED);
    }

    public void M0() {
        setPanelStateAnimated(ae.HIDDEN);
    }

    public boolean R0() {
        return this.R;
    }

    public Observable<ae> S0() {
        return this.E.hide().distinctUntilChanged();
    }

    @NonNull
    public Observable<ae> T0() {
        return S0().observeOn(this.L);
    }

    @Override // eu.bolt.verification.sdk.internal.q4
    public void a(boolean z7, boolean z8) {
        View g8 = this.M.g();
        if (z8 && (g8 instanceof b4)) {
            ((b4) g8).setDragIndicatorVisible(z7);
        }
        if (this.R == z7) {
            return;
        }
        this.R = z7;
        if (this.O.f()) {
            D0(this.O.d());
        }
    }

    public kh getCurrentSlideOffset() {
        return this.G.g();
    }

    public float getCurrentSlidePosition() {
        return getCurrentSlideOffset().a();
    }

    public Observable<kh> getDangerSlideOffsetObservable() {
        return this.G.hide();
    }

    public Observable<lh> getDangerSlidePositionObservable() {
        return this.H.hide();
    }

    public int getFadeColor() {
        return this.f42718b0.g().intValue();
    }

    public n9 getHideMode() {
        return this.V;
    }

    public ae getLastStableState() {
        return this.T;
    }

    @NonNull
    public ae getPanelState() {
        return this.E.g();
    }

    @NonNull
    public Observable<ae> getPanelStateUpdates() {
        return T0().skip(1L);
    }

    public int getPeekHeight() {
        return this.I.g().intValue();
    }

    public Observable<kh> getSlideOffsetObservable() {
        return getDangerSlideOffsetObservable().observeOn(this.L);
    }

    public lh getSlidePosition() {
        return this.H.g();
    }

    public Observable<lh> getSlidePositionObservable() {
        return getDangerSlidePositionObservable().observeOn(this.L);
    }

    public int getSlidingTopPadding() {
        return this.f42722f0;
    }

    public vd<View> getSlidingView() {
        return this.M;
    }

    public ae getTargetPanelState() {
        return this.F.g();
    }

    public Observable<ae> getTargetPanelStateObservable() {
        return this.E;
    }

    public int getVisiblePanelHeight() {
        View g8 = getSlidingView().g();
        if (g8 != null) {
            return Math.max(0, getHeight() - g8.getTop());
        }
        return 0;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i8 = this.N;
        if (i8 != 0) {
            L0(i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        super.onLayout(z7, i8, i9, i10, i11);
        U0();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z7 = motionEvent.getAction() == 0;
        if (y0(motionEvent) && z7) {
            ae W0 = W0();
            if (W0 != null) {
                setPanelStateAnimated(W0);
                return true;
            } else if (Q0()) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void p0(int i8, f7 f7Var) {
        if (this.f42718b0.g().intValue() == i8 && this.Q == f7Var) {
            return;
        }
        ColorDrawable colorDrawable = new ColorDrawable(ColorUtils.j(i8, 255));
        this.W = vd.b(colorDrawable);
        int alpha = Color.alpha(i8);
        this.f42717a0 = alpha;
        if (f7Var == f7.NEVER) {
            alpha = 0;
        }
        colorDrawable.setAlpha(alpha);
        setFadeBackgroundForState(f7Var);
    }

    public void setAllowContinueNestedScroll(boolean z7) {
        if (this.S == z7) {
            return;
        }
        this.S = z7;
        if (this.O.f()) {
            this.O.d().X(this.S);
        }
    }

    public void setBackListener(Function0<Boolean> function0) {
        this.f42720d0 = vd.b(function0);
    }

    public void setBottomOffset(int i8) {
        if (this.M.d() instanceof b4) {
            ((b4) this.M.d()).setBottomOffset(i8);
        }
    }

    public void setCloseOnOutsideClickAction(wd wdVar) {
        this.P = wdVar;
    }

    public void setFadeBackgroundForState(f7 f7Var) {
        this.Q = f7Var;
        int i8 = a.f42726a[f7Var.ordinal()];
        if (i8 == 1 || i8 == 2) {
            Y0();
        } else if (i8 != 3) {
        } else {
            X0();
        }
    }

    public void setHideMode(@NonNull n9 n9Var) {
        if (this.V == n9Var) {
            return;
        }
        this.V = n9Var;
        if (this.O.f()) {
            J0(this.O.d());
        }
        C0();
    }

    public void setPanelHideOffset(int i8) {
        this.f42723g0 = i8;
        if (this.O.f()) {
            this.O.d().k0(i8);
        }
    }

    public void setPanelStateAnimated(@NonNull final ae aeVar) {
        if ((aeVar == ae.PEEK && getPeekHeight() == 0) || this.F.g() == aeVar) {
            return;
        }
        n0();
        setTargetState(aeVar);
        if (!this.O.f()) {
            setPanelStateInternal(aeVar);
            return;
        }
        final DesignBottomSheetBehavior<View> d8 = this.O.d();
        if (!this.M.f() || ViewCompat.W(this.M.d())) {
            E0(d8, aeVar);
            return;
        }
        this.f42725i0 = new Runnable() { // from class: eu.bolt.verification.sdk.internal.as
            @Override // java.lang.Runnable
            public final void run() {
                e4.this.t0(d8, aeVar);
            }
        };
        this.M.d().post(this.f42725i0);
    }

    public void setPanelStateInstant(@NonNull ae aeVar) {
        n0();
        setTargetState(aeVar);
        if (!this.O.f()) {
            setPanelStateInternal(aeVar);
            return;
        }
        this.O.d().q0(z0(aeVar));
        vd<View> slidingView = getSlidingView();
        if (slidingView.f()) {
            this.H.onNext(new lh(slidingView.d().getTop(), 0));
        }
    }

    public void setPeekHeightPx(int i8) {
        if (this.I.g().intValue() == i8) {
            return;
        }
        this.I.onNext(Integer.valueOf(i8));
        O0();
    }

    public void setSlidingTopPadding(int i8) {
        if (this.f42722f0 == i8) {
            return;
        }
        this.f42722f0 = i8;
        if (this.O.f()) {
            this.O.d().h0(this.f42722f0);
        }
    }

    public void setSlidingView(int i8) {
        V0();
        View.inflate(getContext(), i8, this);
        View childAt = getChildAt(getChildCount() - 1);
        this.N = childAt.getId();
        this.M = vd.b(childAt);
        I0(childAt);
    }

    public void setSlidingView(View view) {
        if (this.M.f() && this.M.d() == view) {
            return;
        }
        V0();
        this.N = view.getId();
        this.M = vd.b(view);
        I0(view);
        addView(view, getChildCount(), view.getLayoutParams());
    }
}
