package ee.mtakso.driver.uicore.components.views.swipe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import ee.mtakso.driver.uicore.R$attr;
import ee.mtakso.driver.uicore.R$dimen;
import ee.mtakso.driver.uicore.R$styleable;
import ee.mtakso.driver.uicore.components.views.swipe.SwipeButton;
import ee.mtakso.driver.uicore.components.views.swipe.states.DisclaimerViewState;
import ee.mtakso.driver.uicore.components.views.swipe.states.DoneViewState;
import ee.mtakso.driver.uicore.components.views.swipe.states.LoadingViewState;
import ee.mtakso.driver.uicore.components.views.swipe.states.SwipableViewState;
import ee.mtakso.driver.uicore.components.views.swipe.states.ViewState;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SwipeButton.kt */
/* loaded from: classes5.dex */
public final class SwipeButton extends ConstraintLayout {
    private final HashMap<State, ViewState> E;
    private final Rect F;
    private final RectF G;
    private final Path H;
    private State I;
    private final CornersMode J;
    private float[] K;
    private final Paint L;
    private SwipeButtonStyle M;
    private float N;
    private Function1<? super State, Unit> O;
    private Function1<? super State, ? extends State> P;
    public Map<Integer, View> Q;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SwipeButton.kt */
    /* loaded from: classes5.dex */
    public enum CornersMode {
        ALL,
        TOP,
        TOP_START,
        TOP_END
    }

    /* compiled from: SwipeButton.kt */
    /* loaded from: classes5.dex */
    public enum State {
        SWIPABLE,
        LOADING,
        DONE,
        DISCLAIMER
    }

    /* compiled from: SwipeButton.kt */
    /* loaded from: classes5.dex */
    private final class SwipeButtonOutlineProvider extends ViewOutlineProvider {
        public SwipeButtonOutlineProvider() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (outline != null) {
                RectF rectF = SwipeButton.this.G;
                Rect rect = new Rect();
                rectF.roundOut(rect);
                outline.setRect(rect);
            }
        }
    }

    /* compiled from: SwipeButton.kt */
    /* loaded from: classes5.dex */
    public enum SwipeButtonStyle {
        Primary,
        Secondary,
        Tertiary,
        Online,
        Offline
    }

    /* compiled from: SwipeButton.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35694a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f35695b;

        static {
            int[] iArr = new int[SwipeButtonStyle.values().length];
            try {
                iArr[SwipeButtonStyle.Primary.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SwipeButtonStyle.Secondary.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SwipeButtonStyle.Tertiary.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SwipeButtonStyle.Online.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SwipeButtonStyle.Offline.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f35694a = iArr;
            int[] iArr2 = new int[CornersMode.values().length];
            try {
                iArr2[CornersMode.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[CornersMode.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[CornersMode.TOP_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[CornersMode.TOP_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            f35695b = iArr2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwipeButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeButton(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        HashMap<State, ViewState> h8;
        Intrinsics.f(context, "context");
        this.Q = new LinkedHashMap();
        State state = State.SWIPABLE;
        h8 = MapsKt__MapsKt.h(TuplesKt.a(state, new SwipableViewState(context, this, new Function0<Unit>() { // from class: ee.mtakso.driver.uicore.components.views.swipe.SwipeButton$availableStates$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                SwipeButton.this.M(SwipeButton.State.SWIPABLE);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        })), TuplesKt.a(State.LOADING, new LoadingViewState(context, this)), TuplesKt.a(State.DONE, new DoneViewState(context, this)), TuplesKt.a(State.DISCLAIMER, new DisclaimerViewState(context, this)));
        this.E = h8;
        this.F = new Rect();
        this.G = new RectF();
        this.H = new Path();
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-3355444);
        this.L = paint;
        this.I = state;
        setWillNotDraw(false);
        for (Map.Entry<State, ViewState> entry : h8.entrySet()) {
            entry.getValue().c();
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f34696r3);
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr… R.styleable.SwipeButton)");
        CornersMode P = P(obtainStyledAttributes.getInt(R$styleable.f34701s3, 0));
        this.J = P;
        this.K = Q(P);
        String string = obtainStyledAttributes.getString(R$styleable.f34711u3);
        setSwipeText(string == null ? "" : string);
        setButtonStyle(SwipeButtonStyle.values()[obtainStyledAttributes.getInt(R$styleable.f34706t3, 0)]);
        obtainStyledAttributes.recycle();
        setOutlineProvider(new SwipeButtonOutlineProvider());
        setClipToOutline(true);
        N(this.I).i();
    }

    private final void D(int i8, float f8, int i9, int i10, int i11, int i12, float f9, float f10, float f11, float f12) {
        setBackgroundTintColor(i8);
        setBackgroundCornerRadius(f8);
        setLoadingIndicatorTintColor(i9);
        setSwipeTextColor(i10);
        setDoneIndicatorTintColor(i11);
        setSwipeChevronTint(i12);
        setSwipeTextSize(f9);
        setSwipeChevronSize(f10);
        O(f11, f12);
    }

    private final void E() {
        int i8;
        SwipeButtonStyle swipeButtonStyle = this.M;
        if (swipeButtonStyle == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f35694a[swipeButtonStyle.ordinal()];
        }
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        if (i8 != 5) {
                            H();
                        } else {
                            F();
                        }
                    } else {
                        G();
                    }
                } else {
                    J();
                }
            } else {
                I();
            }
        } else {
            H();
        }
        invalidate();
    }

    private final void F() {
        Color.Attr attr = new Color.Attr(R$attr.f34577g);
        Context context = getContext();
        Intrinsics.e(context, "context");
        int a8 = ColorKt.a(attr, context);
        float dimension = getContext().getResources().getDimension(R$dimen.corner_radius_24dp);
        int i8 = R$attr.f34578h;
        Color.Attr attr2 = new Color.Attr(i8);
        Context context2 = getContext();
        Intrinsics.e(context2, "context");
        int a9 = ColorKt.a(attr2, context2);
        Color.Attr attr3 = new Color.Attr(i8);
        Context context3 = getContext();
        Intrinsics.e(context3, "context");
        int a10 = ColorKt.a(attr3, context3);
        Color.Attr attr4 = new Color.Attr(i8);
        Context context4 = getContext();
        Intrinsics.e(context4, "context");
        int a11 = ColorKt.a(attr4, context4);
        Color.Attr attr5 = new Color.Attr(i8);
        Context context5 = getContext();
        Intrinsics.e(context5, "context");
        int a12 = ColorKt.a(attr5, context5);
        float dimension2 = getContext().getResources().getDimension(R$dimen.uikit_text_size_16sp);
        float dimension3 = getContext().getResources().getDimension(R$dimen.icon_size_14dp);
        Resources resources = getContext().getResources();
        int i9 = R$dimen.icon_size_20dp;
        D(a8, dimension, a9, a10, a11, a12, dimension2, dimension3, resources.getDimension(i9), getContext().getResources().getDimension(i9));
    }

    private final void G() {
        Color.Attr attr = new Color.Attr(R$attr.f34576f);
        Context context = getContext();
        Intrinsics.e(context, "context");
        int a8 = ColorKt.a(attr, context);
        float dimension = getContext().getResources().getDimension(R$dimen.corner_radius_0dp);
        int i8 = R$attr.f34578h;
        Color.Attr attr2 = new Color.Attr(i8);
        Context context2 = getContext();
        Intrinsics.e(context2, "context");
        int a9 = ColorKt.a(attr2, context2);
        Color.Attr attr3 = new Color.Attr(i8);
        Context context3 = getContext();
        Intrinsics.e(context3, "context");
        int a10 = ColorKt.a(attr3, context3);
        Color.Attr attr4 = new Color.Attr(i8);
        Context context4 = getContext();
        Intrinsics.e(context4, "context");
        int a11 = ColorKt.a(attr4, context4);
        Color.Attr attr5 = new Color.Attr(i8);
        Context context5 = getContext();
        Intrinsics.e(context5, "context");
        int a12 = ColorKt.a(attr5, context5);
        float dimension2 = getContext().getResources().getDimension(R$dimen.uikit_text_size_20sp);
        Resources resources = getContext().getResources();
        int i9 = R$dimen.icon_size_20dp;
        D(a8, dimension, a9, a10, a11, a12, dimension2, resources.getDimension(i9), getContext().getResources().getDimension(i9), getContext().getResources().getDimension(i9));
    }

    private final void H() {
        Color.Attr attr = new Color.Attr(R$attr.f34576f);
        Context context = getContext();
        Intrinsics.e(context, "context");
        int a8 = ColorKt.a(attr, context);
        float dimension = getContext().getResources().getDimension(R$dimen.corner_radius_8dp);
        int i8 = R$attr.f34578h;
        Color.Attr attr2 = new Color.Attr(i8);
        Context context2 = getContext();
        Intrinsics.e(context2, "context");
        int a9 = ColorKt.a(attr2, context2);
        Color.Attr attr3 = new Color.Attr(i8);
        Context context3 = getContext();
        Intrinsics.e(context3, "context");
        int a10 = ColorKt.a(attr3, context3);
        Color.Attr attr4 = new Color.Attr(i8);
        Context context4 = getContext();
        Intrinsics.e(context4, "context");
        int a11 = ColorKt.a(attr4, context4);
        Color.Attr attr5 = new Color.Attr(i8);
        Context context5 = getContext();
        Intrinsics.e(context5, "context");
        int a12 = ColorKt.a(attr5, context5);
        float dimension2 = getContext().getResources().getDimension(R$dimen.uikit_text_size_20sp);
        Resources resources = getContext().getResources();
        int i9 = R$dimen.icon_size_20dp;
        D(a8, dimension, a9, a10, a11, a12, dimension2, resources.getDimension(i9), getContext().getResources().getDimension(i9), getContext().getResources().getDimension(i9));
    }

    private final void I() {
        Color.Attr attr = new Color.Attr(R$attr.f34573c);
        Context context = getContext();
        Intrinsics.e(context, "context");
        int a8 = ColorKt.a(attr, context);
        float dimension = getContext().getResources().getDimension(R$dimen.corner_radius_8dp);
        int i8 = R$attr.f34578h;
        Color.Attr attr2 = new Color.Attr(i8);
        Context context2 = getContext();
        Intrinsics.e(context2, "context");
        int a9 = ColorKt.a(attr2, context2);
        Color.Attr attr3 = new Color.Attr(i8);
        Context context3 = getContext();
        Intrinsics.e(context3, "context");
        int a10 = ColorKt.a(attr3, context3);
        Color.Attr attr4 = new Color.Attr(i8);
        Context context4 = getContext();
        Intrinsics.e(context4, "context");
        int a11 = ColorKt.a(attr4, context4);
        Color.Attr attr5 = new Color.Attr(i8);
        Context context5 = getContext();
        Intrinsics.e(context5, "context");
        int a12 = ColorKt.a(attr5, context5);
        float dimension2 = getContext().getResources().getDimension(R$dimen.uikit_text_size_20sp);
        Resources resources = getContext().getResources();
        int i9 = R$dimen.icon_size_20dp;
        D(a8, dimension, a9, a10, a11, a12, dimension2, resources.getDimension(i9), getContext().getResources().getDimension(i9), getContext().getResources().getDimension(i9));
    }

    private final void J() {
        Color.Attr attr = new Color.Attr(R$attr.f34575e);
        Context context = getContext();
        Intrinsics.e(context, "context");
        int a8 = ColorKt.a(attr, context);
        float dimension = getContext().getResources().getDimension(R$dimen.corner_radius_8dp);
        int i8 = R$attr.f34578h;
        Color.Attr attr2 = new Color.Attr(i8);
        Context context2 = getContext();
        Intrinsics.e(context2, "context");
        int a9 = ColorKt.a(attr2, context2);
        Color.Attr attr3 = new Color.Attr(i8);
        Context context3 = getContext();
        Intrinsics.e(context3, "context");
        int a10 = ColorKt.a(attr3, context3);
        Color.Attr attr4 = new Color.Attr(i8);
        Context context4 = getContext();
        Intrinsics.e(context4, "context");
        int a11 = ColorKt.a(attr4, context4);
        Color.Attr attr5 = new Color.Attr(i8);
        Context context5 = getContext();
        Intrinsics.e(context5, "context");
        int a12 = ColorKt.a(attr5, context5);
        float dimension2 = getContext().getResources().getDimension(R$dimen.uikit_text_size_20sp);
        Resources resources = getContext().getResources();
        int i9 = R$dimen.icon_size_20dp;
        D(a8, dimension, a9, a10, a11, a12, dimension2, resources.getDimension(i9), getContext().getResources().getDimension(i9), getContext().getResources().getDimension(i9));
    }

    public static /* synthetic */ void L(SwipeButton swipeButton, State state, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        swipeButton.K(state, z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(State state) {
        State state2;
        Function1<? super State, ? extends State> function1 = this.P;
        if (function1 != null) {
            state2 = function1.invoke(state);
        } else {
            state2 = null;
        }
        if (state2 != null) {
            K(state2, true);
        }
    }

    private final <T extends ViewState> T N(State state) {
        Object g8;
        g8 = MapsKt__MapsKt.g(this.E, state);
        Intrinsics.d(g8, "null cannot be cast to non-null type T of ee.mtakso.driver.uicore.components.views.swipe.SwipeButton.requestState");
        return (T) g8;
    }

    private final CornersMode P(int i8) {
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        return CornersMode.ALL;
                    }
                    return CornersMode.TOP_END;
                }
                return CornersMode.TOP_START;
            }
            return CornersMode.TOP;
        }
        return CornersMode.ALL;
    }

    private final float[] Q(CornersMode cornersMode) {
        int i8 = WhenMappings.f35695b[cornersMode.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 == 4) {
                        if (ViewExtKt.b(this)) {
                            float f8 = this.N;
                            return new float[]{f8, f8, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                        }
                        float f9 = this.N;
                        return new float[]{0.0f, 0.0f, f9, f9, 0.0f, 0.0f, 0.0f, 0.0f};
                    }
                    throw new NoWhenBranchMatchedException();
                } else if (ViewExtKt.b(this)) {
                    float f10 = this.N;
                    return new float[]{0.0f, 0.0f, f10, f10, 0.0f, 0.0f, 0.0f, 0.0f};
                } else {
                    float f11 = this.N;
                    return new float[]{f11, f11, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                }
            }
            float f12 = this.N;
            return new float[]{f12, f12, f12, f12, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        float f13 = this.N;
        return new float[]{f13, f13, f13, f13, f13, f13, f13, f13};
    }

    private final int getBackgroundTintColor() {
        return this.L.getColor();
    }

    private final void setBackgroundCornerRadius(float f8) {
        this.N = f8;
        this.K = Q(this.J);
    }

    private final void setBackgroundTintColor(int i8) {
        this.L.setColor(i8);
    }

    public final void K(State state, boolean z7) {
        Intrinsics.f(state, "state");
        if (!z7 && this.I == state) {
            return;
        }
        N(this.I).c();
        this.I = state;
        N(state).i();
        Function1<? super State, Unit> function1 = this.O;
        if (function1 != null) {
            function1.invoke(this.I);
        }
    }

    public final void O(float f8, float f9) {
        ((LoadingViewState) N(State.LOADING)).k(f8, f9);
    }

    @Override // android.view.View
    public void computeScroll() {
        N(this.I).e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public final SwipeButtonStyle getButtonStyle() {
        return this.M;
    }

    public final State getCurrentState() {
        return this.I;
    }

    public final Function1<State, State> getOnRequestStateChangeListener() {
        return this.P;
    }

    public final Function1<State, Unit> getOnStateChangeListener() {
        return this.O;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawPath(this.H, this.L);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && isEnabled()) {
            return N(this.I).f(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        super.onLayout(z7, i8, i9, i10, i11);
        this.H.reset();
        this.H.addRoundRect(this.G, this.K, Path.Direction.CW);
        invalidateOutline();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i8) {
        super.onRtlPropertiesChanged(i8);
        if (ViewExtKt.b(this)) {
            this.K = Q(this.J);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        this.F.set(getPaddingLeft(), getPaddingTop(), i8 - getPaddingRight(), i9 - getPaddingBottom());
        this.G.set(0.0f, 0.0f, i8, i9);
        for (ViewState viewState : this.E.values()) {
            viewState.g(this.F);
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && isEnabled()) {
            boolean h8 = N(this.I).h(motionEvent);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(h8);
            }
            return h8;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setButtonStyle(SwipeButtonStyle swipeButtonStyle) {
        if (this.M != swipeButtonStyle) {
            this.M = swipeButtonStyle;
            E();
        }
    }

    public final void setDisclaimerText(CharSequence text) {
        Intrinsics.f(text, "text");
        ((DisclaimerViewState) N(State.DISCLAIMER)).k(text);
    }

    public final void setDoneIndicatorTintColor(int i8) {
        ((DoneViewState) N(State.DONE)).k(i8);
    }

    @Override // android.view.View
    public void setEnabled(boolean z7) {
        float f8;
        super.setEnabled(z7);
        if (z7) {
            f8 = 1.0f;
        } else {
            f8 = 0.5f;
        }
        setAlpha(f8);
    }

    public final void setLoadingIndicatorTintColor(int i8) {
        ((LoadingViewState) N(State.LOADING)).l(i8);
    }

    public final void setOnRequestStateChangeListener(Function1<? super State, ? extends State> function1) {
        this.P = function1;
    }

    public final void setOnStateChangeListener(Function1<? super State, Unit> function1) {
        this.O = function1;
    }

    public final void setSwipeChevronSize(float f8) {
        ((SwipableViewState) N(State.SWIPABLE)).z(f8);
    }

    public final void setSwipeChevronTint(int i8) {
        ((SwipableViewState) N(State.SWIPABLE)).A(i8);
    }

    public final void setSwipeText(String text) {
        Intrinsics.f(text, "text");
        ((SwipableViewState) N(State.SWIPABLE)).B(text);
    }

    public final void setSwipeTextColor(int i8) {
        ((SwipableViewState) N(State.SWIPABLE)).C(i8);
    }

    public final void setSwipeTextSize(float f8) {
        ((SwipableViewState) N(State.SWIPABLE)).D(f8);
    }

    public /* synthetic */ SwipeButton(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
