package eu.bolt.android.rib.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RibTransitionAnimation.kt */
/* loaded from: classes5.dex */
public abstract class RibTransitionAnimation {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f37330c = new Companion(null);

    /* renamed from: d  reason: collision with root package name */
    private static final LinearInterpolator f37331d = new LinearInterpolator();

    /* renamed from: e  reason: collision with root package name */
    private static final LinearOutSlowInInterpolator f37332e = new LinearOutSlowInInterpolator();

    /* renamed from: f  reason: collision with root package name */
    private static final FastOutLinearInInterpolator f37333f = new FastOutLinearInInterpolator();

    /* renamed from: a  reason: collision with root package name */
    private final long f37334a;

    /* renamed from: b  reason: collision with root package name */
    private final Interpolator f37335b;

    /* compiled from: RibTransitionAnimation.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: RibTransitionAnimation.kt */
    /* loaded from: classes5.dex */
    public static final class Delay extends RibTransitionAnimation {

        /* renamed from: g  reason: collision with root package name */
        public static final Delay f37336g = new Delay();

        private Delay() {
            super(0L, null, 3, null);
        }

        @Override // eu.bolt.android.rib.transition.RibTransitionAnimation
        protected Animator d(View view) {
            Intrinsics.f(view, "view");
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f);
            Intrinsics.e(ofFloat, "ofFloat(1f)");
            return ofFloat;
        }
    }

    /* compiled from: RibTransitionAnimation.kt */
    /* loaded from: classes5.dex */
    public enum Direction {
        LEFT(false, -1.0f),
        RIGHT(false, 1.0f),
        TOP(true, -1.0f),
        BOTTOM(true, 1.0f);
        

        /* renamed from: f  reason: collision with root package name */
        private final boolean f37342f;

        /* renamed from: g  reason: collision with root package name */
        private final float f37343g;

        Direction(boolean z7, float f8) {
            this.f37342f = z7;
            this.f37343g = f8;
        }

        public final float c(int i8) {
            return i8 * this.f37343g;
        }

        public final boolean e() {
            return this.f37342f;
        }
    }

    /* compiled from: RibTransitionAnimation.kt */
    /* loaded from: classes5.dex */
    public static final class FadeIn extends RibTransitionAnimation {

        /* renamed from: g  reason: collision with root package name */
        public static final FadeIn f37344g = new FadeIn();

        private FadeIn() {
            super(0L, RibTransitionAnimation.f37332e, 1, null);
        }

        @Override // eu.bolt.android.rib.transition.RibTransitionAnimation
        protected Animator d(View view) {
            Intrinsics.f(view, "view");
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, 0.0f, 1.0f);
            Intrinsics.e(ofFloat, "ofFloat(view, View.ALPHA, 0f, 1f)");
            return ofFloat;
        }
    }

    /* compiled from: RibTransitionAnimation.kt */
    /* loaded from: classes5.dex */
    public static final class FadeOut extends RibTransitionAnimation {

        /* renamed from: g  reason: collision with root package name */
        public static final FadeOut f37345g = new FadeOut();

        private FadeOut() {
            super(0L, RibTransitionAnimation.f37333f, 1, null);
        }

        @Override // eu.bolt.android.rib.transition.RibTransitionAnimation
        protected Animator d(View view) {
            Intrinsics.f(view, "view");
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, 1.0f, 0.0f);
            Intrinsics.e(ofFloat, "ofFloat(view, View.ALPHA, 1f, 0f)");
            return ofFloat;
        }
    }

    public RibTransitionAnimation() {
        this(0L, null, 3, null);
    }

    public RibTransitionAnimation(long j8, Interpolator animInterpolator) {
        Intrinsics.f(animInterpolator, "animInterpolator");
        this.f37334a = j8;
        this.f37335b = animInterpolator;
    }

    public final Animator c(View target) {
        Intrinsics.f(target, "target");
        Animator d8 = d(target);
        d8.setDuration(this.f37334a);
        d8.setInterpolator(this.f37335b);
        return d8;
    }

    protected abstract Animator d(View view);

    public void e(View view) {
        Intrinsics.f(view, "view");
    }

    /* compiled from: RibTransitionAnimation.kt */
    /* loaded from: classes5.dex */
    public static final class SlideFrom extends RibTransitionAnimation {

        /* renamed from: g  reason: collision with root package name */
        private final Direction f37346g;

        /* renamed from: h  reason: collision with root package name */
        private final long f37347h;

        public SlideFrom() {
            this(null, null, 0L, 0L, 15, null);
        }

        public /* synthetic */ SlideFrom(Direction direction, Interpolator interpolator, long j8, long j9, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? Direction.BOTTOM : direction, (i8 & 2) != 0 ? RibTransitionAnimation.f37332e : interpolator, (i8 & 4) != 0 ? 300L : j8, (i8 & 8) != 0 ? 0L : j9);
        }

        @Override // eu.bolt.android.rib.transition.RibTransitionAnimation
        protected Animator d(View view) {
            ObjectAnimator ofFloat;
            Intrinsics.f(view, "view");
            if (this.f37346g.e()) {
                ofFloat = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, this.f37346g.c(view.getHeight()), 0.0f);
            } else {
                ofFloat = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, this.f37346g.c(view.getWidth()), 0.0f);
            }
            ofFloat.setStartDelay(this.f37347h);
            Intrinsics.e(ofFloat, "if (direction.isVertical…= animDelay\n            }");
            return ofFloat;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SlideFrom(Direction direction, Interpolator interpolator, long j8, long j9) {
            super(j8, interpolator);
            Intrinsics.f(direction, "direction");
            Intrinsics.f(interpolator, "interpolator");
            this.f37346g = direction;
            this.f37347h = j9;
        }
    }

    /* compiled from: RibTransitionAnimation.kt */
    /* loaded from: classes5.dex */
    public static final class SlideTo extends RibTransitionAnimation {

        /* renamed from: g  reason: collision with root package name */
        private final Direction f37348g;

        /* renamed from: h  reason: collision with root package name */
        private final long f37349h;

        public SlideTo() {
            this(null, null, 0L, 0L, 15, null);
        }

        public /* synthetic */ SlideTo(Direction direction, Interpolator interpolator, long j8, long j9, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? Direction.BOTTOM : direction, (i8 & 2) != 0 ? RibTransitionAnimation.f37333f : interpolator, (i8 & 4) != 0 ? 300L : j8, (i8 & 8) != 0 ? 0L : j9);
        }

        @Override // eu.bolt.android.rib.transition.RibTransitionAnimation
        protected Animator d(View view) {
            ObjectAnimator ofFloat;
            Intrinsics.f(view, "view");
            if (this.f37348g.e()) {
                ofFloat = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, this.f37348g.c(view.getHeight()));
            } else {
                ofFloat = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, this.f37348g.c(view.getWidth()));
            }
            ofFloat.setStartDelay(this.f37349h);
            Intrinsics.e(ofFloat, "if (direction.isVertical…= animDelay\n            }");
            return ofFloat;
        }

        @Override // eu.bolt.android.rib.transition.RibTransitionAnimation
        public void e(View view) {
            Intrinsics.f(view, "view");
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SlideTo(Direction direction, Interpolator interpolator, long j8, long j9) {
            super(j8, interpolator);
            Intrinsics.f(direction, "direction");
            Intrinsics.f(interpolator, "interpolator");
            this.f37348g = direction;
            this.f37349h = j9;
        }
    }

    public /* synthetic */ RibTransitionAnimation(long j8, Interpolator interpolator, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? 300L : j8, (i8 & 2) != 0 ? f37331d : interpolator);
    }
}
