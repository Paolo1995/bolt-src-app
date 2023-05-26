package eu.bolt.verification.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.ImageViewCompat;
import eu.bolt.verification.R$id;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jctools.util.Pow2;

/* loaded from: classes5.dex */
public final class uq {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a extends Lambda implements Function1<Integer, View> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ViewGroup f45405f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ViewGroup viewGroup) {
            super(1);
            this.f45405f = viewGroup;
        }

        public final View b(int i8) {
            return this.f45405f.getChildAt(i8);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ View invoke(Integer num) {
            return b(num.intValue());
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ View f45406f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f45407g;

        b(View view, Function0<Unit> function0) {
            this.f45406f = view;
            this.f45407g = function0;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (ViewCompat.V(this.f45406f)) {
                this.f45406f.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                this.f45407g.invoke();
                return;
            }
            ViewTreeObserver W = uq.W(this.f45406f);
            if (W != null) {
                W.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ View f45408f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f45409g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ boolean f45410h;

        c(View view, Function0<Unit> function0, boolean z7) {
            this.f45408f = view;
            this.f45409g = function0;
            this.f45410h = z7;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (ViewCompat.V(this.f45408f)) {
                this.f45408f.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f45409g.invoke();
                return !this.f45410h;
            }
            ViewTreeObserver W = uq.W(this.f45408f);
            if (W != null) {
                W.removeOnPreDrawListener(this);
            }
            return true;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes5.dex */
    static final class d<T> extends Lambda implements Function0<T> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ViewGroup f45411f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f45412g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Function1<T, Unit> f45413h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(ViewGroup viewGroup, int i8, Function1<? super T, Unit> function1) {
            super(0);
            this.f45411f = viewGroup;
            this.f45412g = i8;
            this.f45413h = function1;
        }

        /* JADX WARN: Incorrect return type in method signature: ()TT; */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final View invoke() {
            View l8 = uq.l(this.f45411f, this.f45412g, null, false, 6, null);
            this.f45413h.invoke(l8);
            return l8;
        }
    }

    public static final void B(View view, final Function1<? super WindowInsetsCompat, Unit> function1) {
        Intrinsics.f(view, "<this>");
        if (function1 == null) {
            ViewCompat.G0(view, null);
        } else {
            ViewCompat.G0(view, new OnApplyWindowInsetsListener() { // from class: eu.bolt.verification.sdk.internal.mx
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat a(View view2, WindowInsetsCompat windowInsetsCompat) {
                    WindowInsetsCompat q8;
                    q8 = uq.q(Function1.this, view2, windowInsetsCompat);
                    return q8;
                }
            });
        }
    }

    public static final void C(View view, boolean z7) {
        Intrinsics.f(view, "<this>");
        view.setVisibility(z7 ? 0 : 8);
    }

    public static final void D(ViewGroup.MarginLayoutParams marginLayoutParams, int i8, int i9, int i10, int i11, View view) {
        Intrinsics.f(marginLayoutParams, "<this>");
        boolean z7 = (view == null || (marginLayoutParams.topMargin == i9 && marginLayoutParams.bottomMargin == i11 && K(marginLayoutParams) == i8 && h(marginLayoutParams) == i10)) ? false : true;
        marginLayoutParams.topMargin = i9;
        marginLayoutParams.bottomMargin = i11;
        MarginLayoutParamsCompat.d(marginLayoutParams, i8);
        MarginLayoutParamsCompat.c(marginLayoutParams, i10);
        if (!z7 || view == null) {
            return;
        }
        b0(view);
    }

    public static /* synthetic */ void E(ViewGroup.MarginLayoutParams marginLayoutParams, int i8, int i9, int i10, int i11, View view, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i8 = K(marginLayoutParams);
        }
        if ((i12 & 2) != 0) {
            i9 = marginLayoutParams.topMargin;
        }
        int i13 = i9;
        if ((i12 & 4) != 0) {
            i10 = h(marginLayoutParams);
        }
        int i14 = i10;
        if ((i12 & 8) != 0) {
            i11 = marginLayoutParams.bottomMargin;
        }
        int i15 = i11;
        if ((i12 & 16) != 0) {
            view = null;
        }
        D(marginLayoutParams, i8, i13, i14, i15, view);
    }

    public static final void F(ViewGroup viewGroup, WindowInsetsCompat insets) {
        Intrinsics.f(viewGroup, "<this>");
        Intrinsics.f(insets, "insets");
        for (View view : t(viewGroup)) {
            int i8 = R$id.key_insets;
            if (!Intrinsics.a(view.getTag(i8), insets)) {
                view.setTag(i8, insets);
                ViewCompat.i(view, insets);
            }
        }
    }

    public static final void G(ViewGroup viewGroup, boolean z7) {
        Intrinsics.f(viewGroup, "<this>");
        for (View view : t(viewGroup)) {
            view.setEnabled(z7);
            if (view instanceof ViewGroup) {
                G((ViewGroup) view, z7);
            }
        }
    }

    public static final void H(ImageView imageView, int i8) {
        Intrinsics.f(imageView, "<this>");
        I(imageView, ColorStateList.valueOf(i8));
    }

    public static final void I(ImageView imageView, ColorStateList colorStateList) {
        Intrinsics.f(imageView, "<this>");
        ImageViewCompat.c(imageView, colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(Function0 action, View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        Intrinsics.f(action, "$action");
        action.invoke();
    }

    public static final int K(ViewGroup.MarginLayoutParams marginLayoutParams) {
        Intrinsics.f(marginLayoutParams, "<this>");
        return MarginLayoutParamsCompat.b(marginLayoutParams);
    }

    public static final void L(View view) {
        Intrinsics.f(view, "<this>");
        view.setClickable(true);
        view.setImportantForAccessibility(2);
    }

    public static final void M(View view, int i8) {
        Intrinsics.f(view, "<this>");
        if (view.getLayoutParams().height != i8) {
            view.getLayoutParams().height = i8;
            b0(view);
        }
    }

    public static final void N(View view, int i8, int i9) {
        boolean z7;
        Intrinsics.f(view, "<this>");
        boolean z8 = true;
        if (view.getLayoutParams().height != i9) {
            view.getLayoutParams().height = i9;
            z7 = true;
        } else {
            z7 = false;
        }
        if (view.getLayoutParams().width != i8) {
            view.getLayoutParams().width = i8;
        } else {
            z8 = z7;
        }
        if (z8) {
            b0(view);
        }
    }

    public static final void O(View view, final Function0<Unit> action) {
        Intrinsics.f(view, "<this>");
        Intrinsics.f(action, "action");
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: eu.bolt.verification.sdk.internal.nx
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
                uq.J(Function0.this, view2, i8, i9, i10, i11, i12, i13, i14, i15);
            }
        });
    }

    public static final void P(ViewGroup viewGroup) {
        Intrinsics.f(viewGroup, "<this>");
        ViewCompat.G0(viewGroup, new v5());
    }

    public static final ViewTreeObserver Q(View view) {
        Intrinsics.f(view, "<this>");
        return ViewCompat.V(view) ? view.getViewTreeObserver() : W(view);
    }

    public static final void R(View view, int i8) {
        Intrinsics.f(view, "<this>");
        if (view.getLayoutParams().width != i8) {
            view.getLayoutParams().width = i8;
            b0(view);
        }
    }

    public static final ViewGroup S(View view) {
        Intrinsics.f(view, "<this>");
        Context context = view.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        ViewGroup viewGroup = activity != null ? (ViewGroup) activity.findViewById(16908290) : null;
        if (viewGroup instanceof ViewGroup) {
            return viewGroup;
        }
        return null;
    }

    public static final String T(View view) {
        String str;
        if (view == null) {
            return String.valueOf(view);
        }
        if (view.getId() == -1) {
            return "no-id";
        }
        try {
            str = view.getResources().getResourceName(view.getId());
        } catch (Resources.NotFoundException unused) {
            str = "id-not-found";
        }
        Intrinsics.e(str, "try {\n            this.r… \"id-not-found\"\n        }");
        return str;
    }

    public static final int U(View view) {
        Intrinsics.f(view, "<this>");
        return ViewCompat.I(view);
    }

    public static final int V(View view) {
        Intrinsics.f(view, "<this>");
        return ViewCompat.J(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewTreeObserver W(View view) {
        ViewTreeObserver viewTreeObserver;
        ViewGroup S = S(view);
        if (S == null || (viewTreeObserver = S.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return null;
        }
        return viewTreeObserver;
    }

    public static final boolean X(View view) {
        Intrinsics.f(view, "<this>");
        return view.getVisibility() == 0;
    }

    public static final LayoutInflater Y(View view) {
        Intrinsics.f(view, "<this>");
        LayoutInflater from = LayoutInflater.from(view.getContext());
        Intrinsics.e(from, "from(context)");
        return from;
    }

    public static final boolean Z(View view) {
        Intrinsics.f(view, "<this>");
        return ViewCompat.E(view) == 1;
    }

    public static final ViewGroup.MarginLayoutParams a0(View view) {
        Intrinsics.f(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return (ViewGroup.MarginLayoutParams) layoutParams;
        }
        return null;
    }

    public static final boolean b0(final View view) {
        Intrinsics.f(view, "<this>");
        return view.post(new Runnable() { // from class: eu.bolt.verification.sdk.internal.lx
            @Override // java.lang.Runnable
            public final void run() {
                uq.c0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(View this_postRequestLayout) {
        Intrinsics.f(this_postRequestLayout, "$this_postRequestLayout");
        this_postRequestLayout.requestLayout();
    }

    public static final int d(View view, int i8) {
        Intrinsics.f(view, "<this>");
        Context context = view.getContext();
        Intrinsics.e(context, "context");
        return f2.b(context, i8);
    }

    public static final void d0(View view) {
        Intrinsics.f(view, "<this>");
        ViewCompat.G0(view, new i7());
    }

    public static final int e(View view, int i8, int i9) {
        Intrinsics.f(view, "<this>");
        int size = View.MeasureSpec.getSize(i8);
        int mode = View.MeasureSpec.getMode(i8);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? i9 : size : Math.min(size, i9);
    }

    public static final void e0(View view) {
        Intrinsics.f(view, "<this>");
        M(view, -1);
    }

    public static final int f(View view, int i8, boolean z7) {
        Intrinsics.f(view, "<this>");
        if (z7 || view.getHeight() == 0) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i8, Pow2.MAX_POW2), View.MeasureSpec.makeMeasureSpec(0, 0));
            return view.getMeasuredHeight();
        }
        return view.getHeight();
    }

    public static final void f0(View view) {
        Intrinsics.f(view, "<this>");
        M(view, -2);
        R(view, -2);
    }

    public static /* synthetic */ int g(View view, int i8, boolean z7, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = view.getResources().getDisplayMetrics().widthPixels;
        }
        if ((i9 & 2) != 0) {
            z7 = false;
        }
        return f(view, i8, z7);
    }

    public static final void g0(View view) {
        Intrinsics.f(view, "<this>");
        M(view, -2);
    }

    public static final int h(ViewGroup.MarginLayoutParams marginLayoutParams) {
        Intrinsics.f(marginLayoutParams, "<this>");
        return MarginLayoutParamsCompat.a(marginLayoutParams);
    }

    public static final View i(View view, float f8) {
        Intrinsics.f(view, "<this>");
        view.setScaleX(f8);
        view.setScaleY(f8);
        return view;
    }

    public static final <T extends View> T j(ViewGroup viewGroup, int i8) {
        Intrinsics.f(viewGroup, "<this>");
        T t7 = (T) LayoutInflater.from(viewGroup.getContext()).inflate(i8, viewGroup, false);
        Intrinsics.d(t7, "null cannot be cast to non-null type T of eu.bolt.client.extensions.ViewExtKt.inflateWithoutAttach");
        return t7;
    }

    public static final <T extends View> T k(ViewGroup viewGroup, int i8, T t7, boolean z7) {
        T t8;
        Intrinsics.f(viewGroup, "<this>");
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(i8);
        if (t7 != null) {
            int indexOfChild = viewGroup.indexOfChild(viewStub);
            viewGroup.removeViewAt(indexOfChild);
            viewGroup.addView(t7, indexOfChild, viewStub.getLayoutParams());
            t7.setId(i8);
            t8 = t7;
        } else {
            viewStub.setInflatedId(i8);
            t8 = viewStub.inflate();
        }
        if (z7) {
            t8.setId(ViewCompat.m());
        }
        if (t8 == null) {
            t8 = (T) false;
        }
        if (t8 != null) {
            return t8;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ View l(ViewGroup viewGroup, int i8, View view, boolean z7, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            view = null;
        }
        if ((i9 & 4) != 0) {
            z7 = true;
        }
        return k(viewGroup, i8, view, z7);
    }

    public static final ViewTreeObserver.OnGlobalLayoutListener m(View view, Function0<Unit> action) {
        Intrinsics.f(view, "<this>");
        Intrinsics.f(action, "action");
        b bVar = new b(view, action);
        view.getViewTreeObserver().addOnGlobalLayoutListener(bVar);
        return bVar;
    }

    public static final ViewTreeObserver.OnPreDrawListener n(View view, boolean z7, Function0<Unit> action) {
        Intrinsics.f(view, "<this>");
        Intrinsics.f(action, "action");
        c cVar = new c(view, action, z7);
        view.getViewTreeObserver().addOnPreDrawListener(cVar);
        return cVar;
    }

    public static /* synthetic */ ViewTreeObserver.OnPreDrawListener o(View view, boolean z7, Function0 function0, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = false;
        }
        return n(view, z7, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat q(Function1 function1, View view, WindowInsetsCompat insets) {
        Intrinsics.f(view, "<anonymous parameter 0>");
        Intrinsics.f(insets, "insets");
        function1.invoke(insets);
        return insets;
    }

    public static final String r(ViewParent viewParent) {
        return T(viewParent instanceof View ? (View) viewParent : null);
    }

    public static final <T extends View> Lazy<T> s(ViewGroup viewGroup, int i8, Function1<? super T, Unit> initBlock) {
        Lazy<T> a8;
        Intrinsics.f(viewGroup, "<this>");
        Intrinsics.f(initBlock, "initBlock");
        a8 = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new d(viewGroup, i8, initBlock));
        return a8;
    }

    public static final Sequence<View> t(ViewGroup viewGroup) {
        IntRange o8;
        Sequence O;
        Intrinsics.f(viewGroup, "<this>");
        o8 = RangesKt___RangesKt.o(0, viewGroup.getChildCount());
        O = CollectionsKt___CollectionsKt.O(o8);
        return SequencesKt.v(O, new a(viewGroup));
    }

    public static final void u(View view, int i8, int i9, int i10, int i11) {
        Intrinsics.f(view, "<this>");
        ViewCompat.H0(view, i8, i9, i10, i11);
    }

    public static /* synthetic */ void v(View view, int i8, int i9, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i8 = V(view);
        }
        if ((i12 & 2) != 0) {
            i9 = view.getPaddingTop();
        }
        if ((i12 & 4) != 0) {
            i10 = U(view);
        }
        if ((i12 & 8) != 0) {
            i11 = view.getPaddingBottom();
        }
        u(view, i8, i9, i10, i11);
    }

    public static final void w(View view, AttributeSet attrs, String attributeName, Function1<? super String, Unit> action) {
        int a8;
        Intrinsics.f(view, "<this>");
        Intrinsics.f(attrs, "attrs");
        Intrinsics.f(attributeName, "attributeName");
        Intrinsics.f(action, "action");
        if (view.isInEditMode() || (a8 = z.a(attrs, attributeName)) == 0) {
            return;
        }
        String string = view.getContext().getResources().getString(a8);
        Intrinsics.e(string, "context.resources.getString(resourceEntryName)");
        action.invoke(string);
    }

    public static final void x(View view, AttributeSet attributeSet, int[] styleable, Function1<? super TypedArray, Unit> action) {
        Intrinsics.f(view, "<this>");
        Intrinsics.f(styleable, "styleable");
        Intrinsics.f(action, "action");
        Context context = view.getContext();
        Intrinsics.e(context, "context");
        f2.e(context, attributeSet, styleable, action);
    }

    public static final void y(View view, CoordinatorLayout.Behavior<View> behavior) {
        Unit unit;
        Intrinsics.f(view, "<this>");
        Intrinsics.f(behavior, "behavior");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        CoordinatorLayout.LayoutParams layoutParams2 = layoutParams instanceof CoordinatorLayout.LayoutParams ? (CoordinatorLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.o(behavior);
            unit = Unit.f50853a;
        } else {
            unit = null;
        }
        if (unit == null) {
            t3.c("setCoordinatorBehavior used for layout without CoordinatorLayout params", null, 2, null);
        }
    }

    public static final void z(View view, WindowInsetsCompat insets, boolean z7, boolean z8, boolean z9, boolean z10) {
        Intrinsics.f(view, "<this>");
        Intrinsics.f(insets, "insets");
        int i8 = R$id.key_insets_initial_padding;
        Object tag = view.getTag(i8);
        Rect rect = tag instanceof Rect ? (Rect) tag : null;
        if (rect == null) {
            rect = new Rect(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        }
        view.setPadding(z7 ? rect.left + insets.j() : rect.left, z8 ? rect.top + insets.l() : rect.top, z9 ? rect.right + insets.k() : rect.right, z10 ? rect.bottom + insets.i() : rect.bottom);
        view.setTag(i8, rect);
    }
}
