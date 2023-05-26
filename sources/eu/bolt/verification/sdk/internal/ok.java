package eu.bolt.verification.sdk.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import androidx.core.graphics.ColorUtils;
import eu.bolt.android.rib.transition.RibTransitionAnimation;
import eu.bolt.verification.R$id;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt__RangesKt;

/* loaded from: classes5.dex */
public abstract class ok extends RibTransitionAnimation {

    /* renamed from: g  reason: collision with root package name */
    public static final b f44476g = new b(null);

    /* loaded from: classes5.dex */
    public static final class a extends ok {
        public a() {
            super(null);
        }

        @Override // eu.bolt.verification.sdk.internal.ok
        public ClosedFloatingPointRange<Float> g() {
            ClosedFloatingPointRange<Float> b8;
            b8 = RangesKt__RangesKt.b(0.0f, 1.0f);
            return b8;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends ok {
        public c() {
            super(null);
        }

        @Override // eu.bolt.verification.sdk.internal.ok
        public ClosedFloatingPointRange<Float> g() {
            ClosedFloatingPointRange<Float> b8;
            b8 = RangesKt__RangesKt.b(1.0f, 0.0f);
            return b8;
        }
    }

    private ok() {
        super(0L, null, 3, null);
    }

    public /* synthetic */ ok(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v14, types: [T, android.view.View] */
    /* JADX WARN: Type inference failed for: r0v16, types: [T, android.view.View] */
    public static final void h(Ref$ObjectRef slideContent, View view, Ref$ObjectRef slideProgressView, AccelerateInterpolator progressVisibilityInterpolator, ValueAnimator value) {
        Intrinsics.f(slideContent, "$slideContent");
        Intrinsics.f(view, "$view");
        Intrinsics.f(slideProgressView, "$slideProgressView");
        Intrinsics.f(progressVisibilityInterpolator, "$progressVisibilityInterpolator");
        Intrinsics.f(value, "value");
        if (slideContent.f51016f == 0) {
            slideContent.f51016f = view.findViewById(R$id.M0);
        }
        if (slideProgressView.f51016f == 0) {
            slideProgressView.f51016f = view.findViewById(R$id.f41717a1);
        }
        Object animatedValue = value.getAnimatedValue();
        Intrinsics.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        T t7 = slideContent.f51016f;
        if (t7 == 0 || slideProgressView.f51016f == 0) {
            return;
        }
        Intrinsics.c(t7);
        uq.i((View) t7, (0.100000024f * floatValue) + 0.9f);
        T t8 = slideContent.f51016f;
        Intrinsics.c(t8);
        ((View) t8).setTranslationY(view.getHeight() - (view.getHeight() * floatValue));
        T t9 = slideContent.f51016f;
        Intrinsics.c(t9);
        ((View) t9).setVisibility(0);
        T t10 = slideProgressView.f51016f;
        Intrinsics.c(t10);
        ((View) t10).setAlpha(progressVisibilityInterpolator.getInterpolation(floatValue));
        view.setBackgroundColor(ColorUtils.j(-16777216, (int) (255 * floatValue)));
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [T, android.view.View] */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, android.view.View] */
    @Override // eu.bolt.android.rib.transition.RibTransitionAnimation
    protected Animator d(final View view) {
        Intrinsics.f(view, "view");
        ClosedFloatingPointRange<Float> g8 = g();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(g8.b().floatValue(), g8.d().floatValue());
        final AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(9.0f);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.f51016f = view.findViewById(R$id.M0);
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        ref$ObjectRef2.f51016f = view.findViewById(R$id.f41717a1);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: eu.bolt.verification.sdk.internal.jv
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ok.h(Ref$ObjectRef.this, view, ref$ObjectRef2, accelerateInterpolator, valueAnimator);
            }
        });
        Intrinsics.e(ofFloat, "ofFloat(range.start, ran…}\n            }\n        }");
        return ofFloat;
    }

    public abstract ClosedFloatingPointRange<Float> g();
}
