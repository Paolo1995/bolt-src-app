package eu.bolt.verification.sdk.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.jakewharton.rxbinding3.view.RxView;
import eu.bolt.verification.R$id;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;

/* loaded from: classes5.dex */
public class b4 extends FrameLayout {

    /* renamed from: p  reason: collision with root package name */
    public static final a f42273p = new a(null);

    /* renamed from: f  reason: collision with root package name */
    private final int f42274f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f42275g;

    /* renamed from: h  reason: collision with root package name */
    private View f42276h;

    /* renamed from: i  reason: collision with root package name */
    private View f42277i;

    /* renamed from: j  reason: collision with root package name */
    private int f42278j;

    /* renamed from: k  reason: collision with root package name */
    private int f42279k;

    /* renamed from: l  reason: collision with root package name */
    private final PublishSubject<Unit> f42280l;

    /* renamed from: m  reason: collision with root package name */
    private int f42281m;

    /* renamed from: n  reason: collision with root package name */
    private int f42282n;

    /* renamed from: o  reason: collision with root package name */
    private final a4 f42283o;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b4 a(View view) {
            Intrinsics.f(view, "view");
            Context context = view.getContext();
            Intrinsics.e(context, "view.context");
            b4 b4Var = new b4(context, null, 0, 6, null);
            b4Var.c(view);
            return b4Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b4(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        int a8 = f2.a(context, 24.0f);
        this.f42274f = a8;
        this.f42275g = new Path();
        this.f42278j = a8;
        PublishSubject<Unit> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<Unit>()");
        this.f42280l = e8;
        this.f42281m = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f42282n = f2.a(context, 4.0f);
        a4 a9 = a4.a(uq.Y(this), this);
        Intrinsics.e(a9, "inflate(inflater(), this)");
        this.f42283o = a9;
        setClickable(true);
        setFocusableInTouchMode(false);
        setBackground(n0.b(context, 0.0f, 0.0f, 0, 14, null));
        setId(R$id.designBottomSheetContent);
        b();
        uq.P(this);
    }

    public /* synthetic */ b4(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void b() {
        final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
        final Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
        setOnTouchListener(new View.OnTouchListener() { // from class: eu.bolt.verification.sdk.internal.te
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean d8;
                d8 = b4.d(b4.this, ref$FloatRef, ref$FloatRef2, view, motionEvent);
                return d8;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(b4 this$0, Ref$FloatRef initialX, Ref$FloatRef initialY, View view, MotionEvent motionEvent) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(initialX, "$initialX");
        Intrinsics.f(initialY, "$initialY");
        boolean z7 = motionEvent.getY() <= ((float) this$0.getTopAreaClickableHeight());
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                initialX.f51013f = 0.0f;
                initialY.f51013f = 0.0f;
                if (z7) {
                    this$0.f42280l.onNext(Unit.f50853a);
                }
                return z7;
            } else if (actionMasked != 2 || Math.hypot(initialX.f51013f - motionEvent.getX(), initialY.f51013f - motionEvent.getY()) > this$0.f42281m) {
                initialX.f51013f = 0.0f;
                initialY.f51013f = 0.0f;
                return false;
            }
        } else if (!z7) {
            return false;
        } else {
            initialX.f51013f = motionEvent.getX();
            initialY.f51013f = motionEvent.getY();
        }
        return true;
    }

    public static final b4 e(View view) {
        return f42273p.a(view);
    }

    private final boolean f() {
        View view = this.f42283o.f41949c;
        Intrinsics.e(view, "binding.dragIndicator");
        if (view.getVisibility() == 0) {
            return true;
        }
        FrameLayout frameLayout = this.f42283o.f41948b;
        Intrinsics.e(frameLayout, "binding.closeButton");
        return frameLayout.getVisibility() == 0;
    }

    private final int getShadowPadding() {
        Drawable background = getBackground();
        Intrinsics.d(background, "null cannot be cast to non-null type com.google.android.material.shape.MaterialShapeDrawable");
        return ((MaterialShapeDrawable) background).D();
    }

    private final int getTopAreaClickableHeight() {
        if (f()) {
            int height = this.f42283o.f41949c.getHeight();
            View view = this.f42283o.f41949c;
            Intrinsics.e(view, "binding.dragIndicator");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            int i8 = height + (marginLayoutParams != null ? marginLayoutParams.topMargin + marginLayoutParams.bottomMargin : 0);
            int height2 = this.f42283o.f41948b.getHeight();
            FrameLayout frameLayout = this.f42283o.f41948b;
            Intrinsics.e(frameLayout, "binding.closeButton");
            ViewGroup.LayoutParams layoutParams2 = frameLayout.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
            return this.f42282n + Math.max(i8, height2 + (marginLayoutParams2 != null ? marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin : 0));
        }
        return 0;
    }

    private final void h() {
        int i8;
        View view = this.f42277i;
        if (view != null) {
            uq.v(view, 0, 0, 0, this.f42279k, 7, null);
            i8 = 0;
        } else {
            i8 = this.f42279k;
        }
        View view2 = this.f42276h;
        ViewGroup.MarginLayoutParams a02 = view2 != null ? uq.a0(view2) : null;
        if (a02 != null) {
            a02.bottomMargin = i8;
        }
        requestLayout();
    }

    private final void i() {
        View view = this.f42276h;
        ViewGroup.MarginLayoutParams a02 = view != null ? uq.a0(view) : null;
        if (a02 == null) {
            return;
        }
        a02.topMargin = this.f42278j;
    }

    public final void c(View view) {
        Intrinsics.f(view, "view");
        this.f42276h = view;
        ViewGroup.LayoutParams a02 = uq.a0(view);
        if (a02 == null) {
            a02 = new FrameLayout.LayoutParams(-1, -2);
        }
        addView(view, 0, a02);
        i();
        h();
    }

    public final Observable<Unit> g() {
        FrameLayout frameLayout = this.f42283o.f41948b;
        Intrinsics.e(frameLayout, "binding.closeButton");
        return RxView.a(frameLayout);
    }

    public final a4 getBinding() {
        return this.f42283o;
    }

    public final int getBottomOffset() {
        return this.f42279k;
    }

    public final int getContentOffset() {
        return this.f42278j + getShadowPadding();
    }

    public final int getDefaultTopContentOffset() {
        return this.f42274f;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.f(canvas, "canvas");
        if (!this.f42275g.isEmpty()) {
            canvas.clipPath(this.f42275g);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        super.onLayout(z7, i8, i9, i10, i11);
        Drawable background = getBackground();
        if (background instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) background).A(getWidth(), getHeight(), this.f42275g);
        }
    }

    public final void setBottomOffset(int i8) {
        if (this.f42279k != i8) {
            this.f42279k = i8;
            h();
        }
    }

    public final void setBottomView(View view) {
        View view2 = this.f42277i;
        if (view2 != null) {
            removeView(view2);
        }
        this.f42277i = view;
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 81;
            Unit unit = Unit.f50853a;
            addView(view, layoutParams);
        }
        h();
    }

    public final void setCloseButtonVisible(boolean z7) {
        FrameLayout frameLayout = this.f42283o.f41948b;
        Intrinsics.e(frameLayout, "binding.closeButton");
        frameLayout.setVisibility(z7 ? 0 : 8);
        i();
    }

    public final void setControlElementsEnabled(boolean z7) {
        this.f42283o.f41948b.setEnabled(z7);
        this.f42283o.f41948b.setAlpha(z7 ? 1.0f : 0.3f);
        this.f42283o.f41949c.setEnabled(z7);
        this.f42283o.f41949c.setAlpha(z7 ? 1.0f : 0.3f);
    }

    public final void setDragIndicatorVisible(boolean z7) {
        View view = this.f42283o.f41949c;
        Intrinsics.e(view, "binding.dragIndicator");
        view.setVisibility(z7 ? 0 : 8);
        i();
    }

    public final void setTopContentOffset(int i8) {
        this.f42278j = i8;
        i();
    }
}
