package eu.bolt.android.maps.core.animation;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import eu.bolt.android.maps.core.Locatable;
import eu.bolt.android.maps.core.animation.PointAnimator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PointAnimator.kt */
/* loaded from: classes5.dex */
public final class PointAnimator {

    /* renamed from: a  reason: collision with root package name */
    private final TypeEvaluator<Locatable> f36950a;

    public PointAnimator(TypeEvaluator<Locatable> evaluator) {
        Intrinsics.f(evaluator, "evaluator");
        this.f36950a = evaluator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function1 onUpdate, ValueAnimator it) {
        Intrinsics.f(onUpdate, "$onUpdate");
        Intrinsics.f(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.d(animatedValue, "null cannot be cast to non-null type eu.bolt.android.maps.core.Locatable");
        onUpdate.invoke((Locatable) animatedValue);
    }

    public final void b(Locatable startPosition, Locatable endPosition, long j8, final Function1<? super Locatable, Unit> onUpdate) {
        Intrinsics.f(startPosition, "startPosition");
        Intrinsics.f(endPosition, "endPosition");
        Intrinsics.f(onUpdate, "onUpdate");
        ValueAnimator ofObject = ValueAnimator.ofObject(this.f36950a, startPosition, endPosition);
        ofObject.setDuration(j8);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: e6.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PointAnimator.c(Function1.this, valueAnimator);
            }
        });
        ofObject.start();
    }
}
