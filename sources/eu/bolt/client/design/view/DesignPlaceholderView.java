package eu.bolt.client.design.view;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import eu.bolt.client.design.view.DesignPlaceholderView;
import eu.bolt.verification.R$color;
import eu.bolt.verification.R$styleable;
import eu.bolt.verification.sdk.internal.f2;
import eu.bolt.verification.sdk.internal.uq;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class DesignPlaceholderView extends View {

    /* renamed from: h  reason: collision with root package name */
    private static final b f40253h = new b(null);

    /* renamed from: f  reason: collision with root package name */
    private final GradientDrawable f40254f;

    /* renamed from: g  reason: collision with root package name */
    private float f40255g;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<TypedArray, Unit> {
        a() {
            super(1);
        }

        public final void b(TypedArray it) {
            Intrinsics.f(it, "it");
            DesignPlaceholderView.this.f40255g = it.getDimension(R$styleable.D1, -1.0f);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TypedArray typedArray) {
            b(typedArray);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        public static final c f40257a = new c();

        /* renamed from: b  reason: collision with root package name */
        private static final int f40258b = R$color.transparent_100;

        /* renamed from: c  reason: collision with root package name */
        private static final int f40259c = R$color.transparent_300;

        /* renamed from: d  reason: collision with root package name */
        private static final ArrayList<DesignPlaceholderView> f40260d = new ArrayList<>();

        /* renamed from: e  reason: collision with root package name */
        private static final ArgbEvaluator f40261e = new ArgbEvaluator();

        /* renamed from: f  reason: collision with root package name */
        private static ValueAnimator f40262f;

        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(ValueAnimator animator) {
            Intrinsics.f(animator, "animator");
            Object animatedValue = animator.getAnimatedValue();
            Integer num = animatedValue instanceof Integer ? (Integer) animatedValue : null;
            if (num == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            int intValue = num.intValue();
            int size = f40260d.size();
            for (int i8 = 0; i8 < size; i8++) {
                DesignPlaceholderView designPlaceholderView = f40260d.get(i8);
                Intrinsics.e(designPlaceholderView, "animatedViews[i]");
                designPlaceholderView.f40254f.setColor(intValue);
            }
        }

        public final int b() {
            return f40258b;
        }

        public final void d(Context context) {
            Intrinsics.f(context, "context");
            ValueAnimator ofObject = ValueAnimator.ofObject(f40261e, Integer.valueOf(f2.b(context, f40258b)), Integer.valueOf(f2.b(context, f40259c)));
            ofObject.setDuration(800L);
            ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: eu.bolt.client.design.view.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    DesignPlaceholderView.c.c(valueAnimator);
                }
            });
            ofObject.setRepeatMode(2);
            ofObject.setRepeatCount(-1);
            ofObject.start();
            f40262f = ofObject;
        }

        public final void e(DesignPlaceholderView view) {
            Intrinsics.f(view, "view");
            view.f40254f.setCornerRadius(view.getRadius());
            ValueAnimator valueAnimator = f40262f;
            boolean z7 = true;
            if (!((valueAnimator == null || !valueAnimator.isRunning()) ? false : false)) {
                Context context = view.getContext();
                Intrinsics.e(context, "view.context");
                d(context);
            }
            ArrayList<DesignPlaceholderView> arrayList = f40260d;
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
        }

        public final void f(DesignPlaceholderView view) {
            ValueAnimator valueAnimator;
            Intrinsics.f(view, "view");
            ArrayList<DesignPlaceholderView> arrayList = f40260d;
            if (arrayList.remove(view) && arrayList.isEmpty() && (valueAnimator = f40262f) != null) {
                valueAnimator.cancel();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DesignPlaceholderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesignPlaceholderView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        this.f40254f = gradientDrawable;
        this.f40255g = -1.0f;
        setBackground(gradientDrawable);
        int[] DesignPlaceholderView = R$styleable.C1;
        Intrinsics.e(DesignPlaceholderView, "DesignPlaceholderView");
        uq.x(this, attributeSet, DesignPlaceholderView, new a());
        if (isInEditMode()) {
            gradientDrawable.setColor(f2.b(context, c.f40257a.b()));
        }
    }

    public /* synthetic */ DesignPlaceholderView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getRadius() {
        float f8 = this.f40255g;
        return f8 < 0.0f ? getHeight() / 2.0f : f8;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getHeight() <= 0 || getWidth() <= 0) {
            return;
        }
        c.f40257a.e(this);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c.f40257a.f(this);
    }

    @Override // android.view.View
    protected void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        super.onLayout(z7, i8, i9, i10, i11);
        if (z7) {
            c.f40257a.e(this);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i8) {
        super.setVisibility(i8);
        if (i8 == 0) {
            c.f40257a.e(this);
        } else {
            c.f40257a.f(this);
        }
    }
}
