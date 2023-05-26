package ee.mtakso.driver.ui.views;

import android.animation.ArgbEvaluator;
import android.animation.FloatEvaluator;
import android.animation.IntEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.R$styleable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HorizontalSnapPickerView.kt */
/* loaded from: classes5.dex */
public final class HorizontalSnapPickerView extends ConstraintLayout {
    private final View E;
    private final ImageView F;
    private final TextView G;
    private final TextView H;
    private final HorizontalWheelAdapter I;
    private final LinearSnapRecyclerView J;
    private final ArgbEvaluator K;
    private final IntEvaluator L;
    private final FloatEvaluator M;
    private float N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private Function2<? super Integer, ? super Boolean, Unit> T;
    private int U;
    private CharSequence V;
    private CharSequence W;

    /* renamed from: a0  reason: collision with root package name */
    private int f34326a0;

    /* renamed from: b0  reason: collision with root package name */
    private boolean f34327b0;

    /* renamed from: c0  reason: collision with root package name */
    private boolean f34328c0;

    /* renamed from: d0  reason: collision with root package name */
    public Map<Integer, View> f34329d0;

    /* compiled from: HorizontalSnapPickerView.kt */
    /* loaded from: classes5.dex */
    public static final class HorizontalWheelAdapter extends RecyclerView.Adapter<ViewHolder> {

        /* renamed from: d  reason: collision with root package name */
        private int f34330d;

        /* renamed from: e  reason: collision with root package name */
        private int f34331e = R.drawable.ic_vertical_dash;

        public final int P() {
            return this.f34330d;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: Q */
        public void E(ViewHolder holder, int i8) {
            Intrinsics.f(holder, "holder");
            holder.O().setSize(holder.Q(), holder.P());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: R */
        public ViewHolder G(ViewGroup parent, int i8) {
            Intrinsics.f(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_horizontal_snap_picker_item, parent, false);
            Intrinsics.d(inflate, "null cannot be cast to non-null type android.widget.ImageView");
            ImageView imageView = (ImageView) inflate;
            Drawable drawable = imageView.getDrawable();
            Intrinsics.d(drawable, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            GradientDrawable gradientDrawable = (GradientDrawable) drawable;
            return new ViewHolder(imageView, gradientDrawable, gradientDrawable.getIntrinsicWidth(), gradientDrawable.getIntrinsicHeight());
        }

        public final void S(int i8) {
            if (this.f34330d != i8) {
                this.f34330d = i8;
                w();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int r() {
            return this.f34330d;
        }
    }

    /* compiled from: HorizontalSnapPickerView.kt */
    /* loaded from: classes5.dex */
    private final class ScrollListener extends RecyclerView.OnScrollListener {
        public ScrollListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void a(RecyclerView recyclerView, int i8) {
            Intrinsics.f(recyclerView, "recyclerView");
            if (i8 != 0) {
                if (i8 == 1) {
                    HorizontalSnapPickerView.this.f34327b0 = false;
                    HorizontalSnapPickerView.this.f34328c0 = true;
                    return;
                }
                return;
            }
            View G1 = HorizontalSnapPickerView.this.J.G1();
            if (G1 != null) {
                int h02 = recyclerView.h0(G1);
                Function2<Integer, Boolean, Unit> itemPickedListener = HorizontalSnapPickerView.this.getItemPickedListener();
                if (itemPickedListener != null) {
                    itemPickedListener.s(Integer.valueOf(h02), Boolean.valueOf(HorizontalSnapPickerView.this.f34328c0));
                }
            } else {
                Function2<Integer, Boolean, Unit> itemPickedListener2 = HorizontalSnapPickerView.this.getItemPickedListener();
                if (itemPickedListener2 != null) {
                    itemPickedListener2.s(Integer.valueOf(HorizontalSnapPickerView.this.getPickedPosition()), Boolean.valueOf(HorizontalSnapPickerView.this.f34328c0));
                }
            }
            HorizontalSnapPickerView.this.f34328c0 = false;
            HorizontalSnapPickerView.this.f34327b0 = false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void b(RecyclerView recyclerView, int i8, int i9) {
            Intrinsics.f(recyclerView, "recyclerView");
            HorizontalSnapPickerView.this.R();
        }
    }

    /* compiled from: HorizontalSnapPickerView.kt */
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final ImageView f34333u;

        /* renamed from: v  reason: collision with root package name */
        private final GradientDrawable f34334v;

        /* renamed from: w  reason: collision with root package name */
        private final int f34335w;

        /* renamed from: x  reason: collision with root package name */
        private final int f34336x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ImageView imageView, GradientDrawable drawable, int i8, int i9) {
            super(imageView);
            Intrinsics.f(imageView, "imageView");
            Intrinsics.f(drawable, "drawable");
            this.f34333u = imageView;
            this.f34334v = drawable;
            this.f34335w = i8;
            this.f34336x = i9;
        }

        public final GradientDrawable O() {
            return this.f34334v;
        }

        public final int P() {
            return this.f34336x;
        }

        public final int Q() {
            return this.f34335w;
        }

        public final ImageView R() {
            return this.f34333u;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HorizontalSnapPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalSnapPickerView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f34329d0 = new LinkedHashMap();
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_horizontal_snap_picker, (ViewGroup) this, true);
        this.E = inflate;
        View findViewById = inflate.findViewById(R.id.imageView);
        Intrinsics.e(findViewById, "container.findViewById(R.id.imageView)");
        this.F = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.startHintTextView);
        Intrinsics.e(findViewById2, "container.findViewById(R.id.startHintTextView)");
        TextView textView = (TextView) findViewById2;
        this.G = textView;
        View findViewById3 = inflate.findViewById(R.id.endHintTextView);
        Intrinsics.e(findViewById3, "container.findViewById(R.id.endHintTextView)");
        TextView textView2 = (TextView) findViewById3;
        this.H = textView2;
        HorizontalWheelAdapter horizontalWheelAdapter = new HorizontalWheelAdapter();
        this.I = horizontalWheelAdapter;
        View findViewById4 = findViewById(R.id.recyclerView);
        LinearSnapRecyclerView linearSnapRecyclerView = (LinearSnapRecyclerView) findViewById4;
        linearSnapRecyclerView.l(new ScrollListener());
        linearSnapRecyclerView.setAdapter(horizontalWheelAdapter);
        Intrinsics.e(findViewById4, "findViewById<LinearSnapR…t.adapter = adapter\n    }");
        this.J = linearSnapRecyclerView;
        this.K = new ArgbEvaluator();
        this.L = new IntEvaluator();
        this.M = new FloatEvaluator();
        this.N = 1.67f;
        this.O = ContextCompat.getColor(context, R.color.neutral400);
        this.P = ContextCompat.getColor(context, R.color.purple500);
        this.Q = 2132017742;
        this.R = ContextCompat.getColor(context, R.color.neutral600);
        this.S = ContextCompat.getColor(context, R.color.purple500);
        this.V = textView.getText();
        this.W = textView2.getText();
        this.f34326a0 = this.U;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f19911o1, i8, 0);
        Intrinsics.e(obtainStyledAttributes, "this.context.obtainStyle…,\n            0\n        )");
        this.O = obtainStyledAttributes.getColor(3, this.O);
        setStickPickColor(obtainStyledAttributes.getColor(4, this.P));
        this.N = obtainStyledAttributes.getFloat(5, this.N);
        setHintTextAppearance(obtainStyledAttributes.getResourceId(0, this.Q));
        this.R = obtainStyledAttributes.getColor(1, this.R);
        this.S = obtainStyledAttributes.getColor(2, this.S);
        obtainStyledAttributes.recycle();
    }

    private final float G(View view) {
        return Math.min(view.getRight() - this.J.getWidth(), 0);
    }

    private final float H(View view) {
        return Math.max(view.getLeft(), 0);
    }

    private final float I(View view, float f8) {
        if (view.getWidth() != 0 && this.J.getWidth() != 0) {
            float width = (view.getWidth() * 2) / this.J.getWidth();
            return K(Math.min(f8, width) / width);
        }
        return 1.0f;
    }

    private final boolean J(int i8) {
        if (i8 >= getItemCount() || i8 < 0) {
            return false;
        }
        return true;
    }

    private final float K(float f8) {
        return Math.max(0.0f, Math.min(1.0f, f8));
    }

    private final void L() {
        if (!J(this.f34326a0) || this.J.getScrollState() == 1) {
            return;
        }
        this.J.x1(this.f34326a0);
    }

    private final void N(View view, float f8) {
        float G;
        if (view == null) {
            P(this.H, 0.0f, this.R);
            return;
        }
        if (this.J.getLayoutDirection() == 1) {
            G = H(view);
        } else {
            G = G(view);
        }
        TextView textView = this.H;
        Object evaluate = this.K.evaluate(I(view, f8), Integer.valueOf(this.S), Integer.valueOf(this.R));
        Intrinsics.d(evaluate, "null cannot be cast to non-null type kotlin.Int");
        P(textView, G, ((Integer) evaluate).intValue());
    }

    private final void O(View view, float f8) {
        ViewHolder viewHolder;
        float I = I(view, f8);
        RecyclerView.ViewHolder j02 = this.J.j0(view);
        if (j02 instanceof ViewHolder) {
            viewHolder = (ViewHolder) j02;
        } else {
            viewHolder = null;
        }
        if (viewHolder == null) {
            return;
        }
        Integer height = this.L.evaluate(I, Integer.valueOf((int) (viewHolder.P() * this.N)), Integer.valueOf(viewHolder.P()));
        ImageView R = viewHolder.R();
        Float evaluate = this.M.evaluate(f8, (Number) 1, (Number) Double.valueOf(0.2d));
        Intrinsics.e(evaluate, "floatEvaluator.evaluate(fraction, 1, 0.2)");
        R.setAlpha(evaluate.floatValue());
        GradientDrawable O = viewHolder.O();
        Object evaluate2 = this.K.evaluate(I, Integer.valueOf(this.P), Integer.valueOf(this.O));
        Intrinsics.d(evaluate2, "null cannot be cast to non-null type kotlin.Int");
        O.setColor(((Integer) evaluate2).intValue());
        GradientDrawable O2 = viewHolder.O();
        int Q = viewHolder.Q();
        Intrinsics.e(height, "height");
        O2.setSize(Q, height.intValue());
        viewHolder.R().setTranslationY((viewHolder.P() - height.intValue()) / 2.0f);
    }

    private final void P(TextView textView, float f8, int i8) {
        textView.setTranslationX(f8);
        textView.setTextColor(i8);
    }

    private final void Q(View view, float f8) {
        float H;
        if (view == null) {
            P(this.G, 0.0f, this.R);
            return;
        }
        if (this.J.getLayoutDirection() == 1) {
            H = G(view);
        } else {
            H = H(view);
        }
        TextView textView = this.G;
        Object evaluate = this.K.evaluate(I(view, f8), Integer.valueOf(this.S), Integer.valueOf(this.R));
        Intrinsics.d(evaluate, "null cannot be cast to non-null type kotlin.Int");
        P(textView, H, ((Integer) evaluate).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R() {
        float width = this.J.getWidth() / 2.0f;
        int childCount = this.J.getChildCount();
        float f8 = 1.0f;
        View view = null;
        View view2 = null;
        float f9 = 1.0f;
        float f10 = Float.MAX_VALUE;
        int i8 = -1;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childView = this.J.getChildAt(i9);
            float K = K(Math.abs(((childView.getLeft() + childView.getRight()) / 2.0f) - width) / width);
            int h02 = this.J.h0(childView);
            if (f10 >= K) {
                f10 = K;
                i8 = h02;
            }
            Intrinsics.e(childView, "childView");
            O(childView, K);
            if (h02 == 0) {
                view = childView;
                f8 = K;
            } else if (h02 == getItemCount() - 1) {
                view2 = childView;
                f9 = K;
            }
        }
        Q(view, f8);
        N(view2, f9);
        if (this.U != i8 && !this.f34327b0) {
            this.U = i8;
            performHapticFeedback(4);
            Function2<? super Integer, ? super Boolean, Unit> function2 = this.T;
            if (function2 != null) {
                function2.s(Integer.valueOf(this.U), Boolean.valueOf(this.f34328c0));
            }
        }
    }

    public final void M(int i8) {
        if (J(i8) && this.U != i8) {
            this.f34326a0 = i8;
            if (ViewCompat.W(this.J)) {
                L();
            } else {
                this.f34327b0 = true;
            }
        }
    }

    public final CharSequence getEndHint() {
        return this.W;
    }

    public final int getHintTextAppearance() {
        return this.Q;
    }

    public final int getHintTextColor() {
        return this.R;
    }

    public final int getHintTextPickColor() {
        return this.S;
    }

    public final int getItemCount() {
        return this.I.P();
    }

    public final Function2<Integer, Boolean, Unit> getItemPickedListener() {
        return this.T;
    }

    public final int getPickedPosition() {
        return this.U;
    }

    public final int getScrollState() {
        return this.J.getScrollState();
    }

    public final CharSequence getStartHint() {
        return this.V;
    }

    public final int getStickColor() {
        return this.O;
    }

    public final int getStickPickColor() {
        return this.P;
    }

    public final float getStickPickFactor() {
        return this.N;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        super.onLayout(z7, i8, i9, i10, i11);
        if (z7) {
            this.J.y0();
        }
        R();
        if (this.f34327b0) {
            this.f34327b0 = false;
            L();
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int i8) {
        Intrinsics.f(changedView, "changedView");
        super.onVisibilityChanged(changedView, i8);
        if (i8 == 0) {
            requestLayout();
        }
    }

    public final void setEndHint(CharSequence charSequence) {
        if (!Intrinsics.a(this.W, charSequence)) {
            this.W = charSequence;
            this.H.setText(charSequence);
        }
    }

    public final void setHintTextAppearance(int i8) {
        this.Q = i8;
        TextViewCompat.o(this.G, i8);
        TextViewCompat.o(this.H, i8);
    }

    public final void setHintTextColor(int i8) {
        this.R = i8;
    }

    public final void setHintTextPickColor(int i8) {
        this.S = i8;
    }

    public final void setItemCount(int i8) {
        this.I.S(i8);
    }

    public final void setItemPickedListener(Function2<? super Integer, ? super Boolean, Unit> function2) {
        this.T = function2;
    }

    public final void setStartHint(CharSequence charSequence) {
        if (!Intrinsics.a(this.V, charSequence)) {
            this.V = charSequence;
            this.G.setText(charSequence);
        }
    }

    public final void setStickColor(int i8) {
        this.O = i8;
    }

    public final void setStickPickColor(int i8) {
        this.P = i8;
        DrawableCompat.n(this.F.getDrawable(), i8);
    }

    public final void setStickPickFactor(float f8) {
        this.N = f8;
    }

    public /* synthetic */ HorizontalSnapPickerView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
