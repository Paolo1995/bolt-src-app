package ee.mtakso.driver.uicore.components.views.swipe.states;

import android.animation.Animator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.utils.AlphaAnimatorHelper;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SwipableViewState.kt */
/* loaded from: classes5.dex */
public final class SwipableViewState extends ViewState {

    /* renamed from: f  reason: collision with root package name */
    private final ViewGroup f35703f;

    /* renamed from: g  reason: collision with root package name */
    private final Function0<Unit> f35704g;

    /* renamed from: h  reason: collision with root package name */
    private final ViewDragHelper f35705h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f35706i;

    /* renamed from: j  reason: collision with root package name */
    private final AppCompatImageView f35707j;

    /* renamed from: k  reason: collision with root package name */
    private final View f35708k;

    /* renamed from: l  reason: collision with root package name */
    private int f35709l;

    /* renamed from: m  reason: collision with root package name */
    private final SwipeStrategy f35710m;

    /* renamed from: n  reason: collision with root package name */
    private int f35711n;

    /* compiled from: SwipableViewState.kt */
    /* loaded from: classes5.dex */
    public final class DragCallback extends ViewDragHelper.Callback {
        public DragCallback() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int a(View child, int i8, int i9) {
            Intrinsics.f(child, "child");
            return SwipableViewState.this.f35710m.d(i8, SwipableViewState.this.w());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int b(View child, int i8, int i9) {
            Intrinsics.f(child, "child");
            return child.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int c(int i8) {
            int indexOfChild = SwipableViewState.this.f35703f.indexOfChild(SwipableViewState.this.f35708k);
            if (i8 > indexOfChild) {
                return indexOfChild;
            }
            return i8;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void j(int i8) {
            if (i8 == SwipableViewState.this.f35711n) {
                return;
            }
            if (i8 == 0 && SwipableViewState.this.f35710m.c(SwipableViewState.this.w())) {
                SwipableViewState.this.f35704g.invoke();
            }
            SwipableViewState.this.f35711n = i8;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void k(View changedView, int i8, int i9, int i10, int i11) {
            Intrinsics.f(changedView, "changedView");
            SwipableViewState.this.f35709l = i8;
            SwipableViewState swipableViewState = SwipableViewState.this;
            swipableViewState.v(swipableViewState.f35706i, SwipableViewState.this.f35710m.e(SwipableViewState.this.w()));
            ViewCompat.j0(SwipableViewState.this.f35703f);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void l(View releasedChild, float f8, float f9) {
            Intrinsics.f(releasedChild, "releasedChild");
            super.l(releasedChild, f8, f9);
            if (SwipableViewState.this.f35705h.O(releasedChild, SwipableViewState.this.f35710m.b(f8, SwipableViewState.this.w()), SwipableViewState.this.w().getTop())) {
                SwipableViewState.this.f35705h.m(true);
            }
            ViewCompat.j0(SwipableViewState.this.f35703f);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean m(View child, int i8) {
            Intrinsics.f(child, "child");
            if (child.getId() == R$id.slideIconContainer) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipableViewState(Context context, ViewGroup parent, Function0<Unit> onInteractionListener) {
        super(context, parent, R$layout.content_swipe_button_swipable_state);
        Intrinsics.f(context, "context");
        Intrinsics.f(parent, "parent");
        Intrinsics.f(onInteractionListener, "onInteractionListener");
        this.f35703f = parent;
        this.f35704g = onInteractionListener;
        SwipeStrategy a8 = SwipeStrategy.f35713a.a(b());
        this.f35710m = a8;
        View findViewById = parent.findViewById(R$id.slideIcon);
        Intrinsics.e(findViewById, "parent.findViewById(R.id.slideIcon)");
        AppCompatImageView appCompatImageView = (AppCompatImageView) findViewById;
        this.f35707j = appCompatImageView;
        View findViewById2 = parent.findViewById(R$id.slideText);
        Intrinsics.e(findViewById2, "parent.findViewById(R.id.slideText)");
        this.f35706i = (TextView) findViewById2;
        View findViewById3 = parent.findViewById(R$id.slideIconContainer);
        Intrinsics.e(findViewById3, "parent.findViewById(R.id.slideIconContainer)");
        this.f35708k = findViewById3;
        ViewDragHelper o8 = ViewDragHelper.o(parent, new DragCallback());
        Intrinsics.e(o8, "create(parent, DragCallback())");
        this.f35705h = o8;
        a8.a(appCompatImageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(View view, float f8) {
        view.setAlpha(MathUtils.a(1.0f - (f8 * 2.0f), 0.0f, 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View w() {
        return this.f35708k;
    }

    private final boolean x(int i8) {
        return i8 == 1 || i8 == 2;
    }

    private final boolean y(View view, MotionEvent motionEvent) {
        if (motionEvent.getX() >= view.getLeft() && motionEvent.getX() <= view.getRight() && motionEvent.getY() >= view.getTop() && motionEvent.getY() <= view.getBottom()) {
            return true;
        }
        return false;
    }

    public final void A(int i8) {
        this.f35707j.setColorFilter(i8);
    }

    public final void B(String text) {
        Intrinsics.f(text, "text");
        this.f35706i.setText(text);
    }

    public final void C(int i8) {
        this.f35706i.setTextColor(i8);
    }

    public final void D(float f8) {
        this.f35706i.setTextSize(0, f8);
    }

    @Override // ee.mtakso.driver.uicore.components.views.swipe.states.ViewState
    protected Animator d() {
        this.f35708k.setVisibility(8);
        this.f35706i.setVisibility(8);
        return null;
    }

    @Override // ee.mtakso.driver.uicore.components.views.swipe.states.ViewState
    public void e() {
        if (this.f35705h.m(true)) {
            ViewCompat.j0(this.f35703f);
        }
    }

    @Override // ee.mtakso.driver.uicore.components.views.swipe.states.ViewState
    public boolean f(MotionEvent event) {
        Intrinsics.f(event, "event");
        if (y(w(), event) && this.f35705h.N(event)) {
            return true;
        }
        return false;
    }

    @Override // ee.mtakso.driver.uicore.components.views.swipe.states.ViewState
    public boolean h(MotionEvent event) {
        Intrinsics.f(event, "event");
        if (!y(w(), event) && !x(this.f35711n)) {
            return false;
        }
        this.f35705h.F(event);
        return true;
    }

    @Override // ee.mtakso.driver.uicore.components.views.swipe.states.ViewState
    protected Animator j() {
        this.f35708k.setLeft(0);
        this.f35706i.setAlpha(1.0f);
        return AlphaAnimatorHelper.f35720a.c(this.f35708k, this.f35706i);
    }

    public final void z(float f8) {
        int i8 = (int) f8;
        this.f35707j.getLayoutParams().width = i8;
        this.f35707j.getLayoutParams().height = i8;
    }
}
