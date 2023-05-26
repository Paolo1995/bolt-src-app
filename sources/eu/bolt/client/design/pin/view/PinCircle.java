package eu.bolt.client.design.pin.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.client.design.pin.view.PinCircle;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.verification.sdk.internal.a5;
import eu.bolt.verification.sdk.internal.c5;
import eu.bolt.verification.sdk.internal.uq;
import eu.bolt.verification.sdk.internal.v9;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class PinCircle extends FrameLayout {

    /* renamed from: p  reason: collision with root package name */
    public static final a f40128p = new a(null);

    /* renamed from: q  reason: collision with root package name */
    private static final PathInterpolator f40129q = new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);

    /* renamed from: f  reason: collision with root package name */
    private final a5 f40130f;

    /* renamed from: g  reason: collision with root package name */
    private Integer f40131g;

    /* renamed from: h  reason: collision with root package name */
    private int f40132h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f40133i;

    /* renamed from: j  reason: collision with root package name */
    private c5 f40134j;

    /* renamed from: k  reason: collision with root package name */
    private Function0<Unit> f40135k;

    /* renamed from: l  reason: collision with root package name */
    private v9 f40136l;

    /* renamed from: m  reason: collision with root package name */
    private v9 f40137m;

    /* renamed from: n  reason: collision with root package name */
    private final float f40138n;

    /* renamed from: o  reason: collision with root package name */
    private final b f40139o;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends AnimatorListenerAdapter {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(PinCircle this$0) {
            Intrinsics.f(this$0, "this$0");
            Function0 function0 = this$0.f40135k;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.f(animation, "animation");
            if (PinCircle.this.f40138n < 0.001f) {
                return;
            }
            final PinCircle pinCircle = PinCircle.this;
            pinCircle.post(new Runnable() { // from class: s6.a
                @Override // java.lang.Runnable
                public final void run() {
                    PinCircle.b.b(PinCircle.this);
                }
            });
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.f(animation, "animation");
            PinCircle.this.getBinding().f41957h.setText((CharSequence) null);
            DesignTextView designTextView = PinCircle.this.getBinding().f41957h;
            Intrinsics.e(designTextView, "binding.value");
            designTextView.setVisibility(8);
            DesignTextView designTextView2 = PinCircle.this.getBinding().f41956g;
            Intrinsics.e(designTextView2, "binding.suffix");
            designTextView2.setVisibility(8);
            View view = PinCircle.this.getBinding().f41953d;
            Intrinsics.e(view, "binding.dot");
            view.setVisibility(8);
            DesignImageView designImageView = PinCircle.this.getBinding().f41955f;
            Intrinsics.e(designImageView, "binding.icon");
            designImageView.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            LottieComposition G;
            Intrinsics.f(animation, "animation");
            DesignImageView designImageView = PinCircle.this.getBinding().f41952c;
            Intrinsics.e(designImageView, "binding.customLoader");
            designImageView.setVisibility(0);
            PinCircle.this.getBinding().f41952c.setRepeatCount(-1);
            Drawable drawable = PinCircle.this.getBinding().f41952c.getDrawable();
            LottieDrawable lottieDrawable = drawable instanceof LottieDrawable ? (LottieDrawable) drawable : null;
            if (lottieDrawable != null && (G = lottieDrawable.G()) != null) {
                PinCircle.this.getBinding().f41952c.setMaxFrame((int) G.f());
            }
            PinCircle.this.getBinding().f41952c.z();
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.f(animation, "animation");
            PinCircle.this.getBinding().f41957h.setText((CharSequence) null);
            DesignTextView designTextView = PinCircle.this.getBinding().f41957h;
            Intrinsics.e(designTextView, "binding.value");
            designTextView.setVisibility(8);
            DesignTextView designTextView2 = PinCircle.this.getBinding().f41956g;
            Intrinsics.e(designTextView2, "binding.suffix");
            designTextView2.setVisibility(8);
            DesignImageView designImageView = PinCircle.this.getBinding().f41955f;
            Intrinsics.e(designImageView, "binding.icon");
            designImageView.setVisibility(8);
            DesignImageView designImageView2 = PinCircle.this.getBinding().f41952c;
            Intrinsics.e(designImageView2, "binding.customLoader");
            designImageView2.setVisibility(PinCircle.this.f40131g != null ? 0 : 8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Unit unit;
            Intrinsics.f(animation, "animation");
            View view = PinCircle.this.getBinding().f41953d;
            Intrinsics.e(view, "binding.dot");
            view.setVisibility(PinCircle.this.f40133i ? 0 : 8);
            Integer num = PinCircle.this.f40131g;
            if (num != null) {
                PinCircle pinCircle = PinCircle.this;
                int intValue = num.intValue();
                DesignImageView designImageView = pinCircle.getBinding().f41952c;
                Intrinsics.e(designImageView, "binding.customLoader");
                designImageView.setVisibility(0);
                pinCircle.getBinding().f41952c.setMaxFrame(intValue);
                pinCircle.getBinding().f41952c.setRepeatCount(0);
                pinCircle.getBinding().f41952c.z();
                unit = Unit.f50853a;
            } else {
                unit = null;
            }
            if (unit == null) {
                PinCircle pinCircle2 = PinCircle.this;
                DesignImageView designImageView2 = pinCircle2.getBinding().f41952c;
                Intrinsics.e(designImageView2, "binding.customLoader");
                designImageView2.setVisibility(8);
                pinCircle2.getBinding().f41952c.w();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.f(animation, "animation");
            View view = PinCircle.this.getBinding().f41953d;
            Intrinsics.e(view, "binding.dot");
            view.setVisibility(8);
            DesignImageView designImageView = PinCircle.this.getBinding().f41955f;
            Intrinsics.e(designImageView, "binding.icon");
            designImageView.setVisibility(8);
            DesignImageView designImageView2 = PinCircle.this.getBinding().f41952c;
            Intrinsics.e(designImageView2, "binding.customLoader");
            designImageView2.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.f(animation, "animation");
            DesignTextView designTextView = PinCircle.this.getBinding().f41957h;
            Intrinsics.e(designTextView, "binding.value");
            designTextView.setVisibility(0);
            DesignTextView designTextView2 = PinCircle.this.getBinding().f41956g;
            Intrinsics.e(designTextView2, "binding.suffix");
            designTextView2.setVisibility(0);
        }
    }

    /* loaded from: classes5.dex */
    public static final class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.f(animation, "animation");
            PinCircle.this.getBinding().f41957h.setText((CharSequence) null);
            DesignTextView designTextView = PinCircle.this.getBinding().f41957h;
            Intrinsics.e(designTextView, "binding.value");
            designTextView.setVisibility(8);
            DesignTextView designTextView2 = PinCircle.this.getBinding().f41956g;
            Intrinsics.e(designTextView2, "binding.suffix");
            designTextView2.setVisibility(8);
            View view = PinCircle.this.getBinding().f41953d;
            Intrinsics.e(view, "binding.dot");
            view.setVisibility(8);
            DesignImageView designImageView = PinCircle.this.getBinding().f41952c;
            Intrinsics.e(designImageView, "binding.customLoader");
            designImageView.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.f(animation, "animation");
            DesignImageView designImageView = PinCircle.this.getBinding().f41955f;
            Intrinsics.e(designImageView, "binding.icon");
            designImageView.setVisibility(0);
        }
    }

    /* loaded from: classes5.dex */
    public static final class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.f(animation, "animation");
            DesignImageView designImageView = PinCircle.this.getBinding().f41955f;
            Intrinsics.e(designImageView, "binding.icon");
            designImageView.setVisibility(8);
            DesignImageView designImageView2 = PinCircle.this.getBinding().f41952c;
            Intrinsics.e(designImageView2, "binding.customLoader");
            designImageView2.setVisibility(8);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PinCircle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PinCircle(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        a5 a8 = a5.a(uq.Y(this), this);
        Intrinsics.e(a8, "inflate(inflater(), this)");
        this.f40130f = a8;
        this.f40132h = -1;
        this.f40133i = true;
        this.f40134j = c5.a.f42460a;
        this.f40138n = Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
        this.f40139o = new b();
        setClipToPadding(false);
        setClipChildren(false);
        a8.f41956g.setTextSize(1, 12.0f);
    }

    public /* synthetic */ PinCircle(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    private final AnimatorSet getCustomLoaderStateAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        DesignImageView designImageView = this.f40130f.f41952c;
        Property property = View.SCALE_X;
        float[] fArr = {designImageView.getScaleX(), 1.0f};
        DesignImageView designImageView2 = this.f40130f.f41952c;
        Property property2 = View.SCALE_Y;
        float[] fArr2 = {designImageView2.getScaleY(), 1.0f};
        DesignImageView designImageView3 = this.f40130f.f41952c;
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f40130f.f41957h, View.SCALE_X, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41957h, View.SCALE_Y, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41956g, View.SCALE_X, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41956g, View.SCALE_Y, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41953d, View.SCALE_X, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41953d, View.SCALE_Y, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41953d, View.ALPHA, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41955f, View.SCALE_X, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41955f, View.SCALE_Y, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41955f, View.ALPHA, 1.0f, 0.0f), ObjectAnimator.ofFloat(designImageView, property, fArr), ObjectAnimator.ofFloat(designImageView2, property2, fArr2), ObjectAnimator.ofFloat(designImageView3, View.ALPHA, designImageView3.getAlpha(), 1.0f));
        animatorSet.addListener(new c());
        animatorSet.setDuration(200L);
        animatorSet.setInterpolator(f40129q);
        return animatorSet;
    }

    private final AnimatorSet getDefaultStateAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        DesignImageView designImageView = this.f40130f.f41952c;
        Property property = View.SCALE_X;
        float[] fArr = {designImageView.getScaleX(), 1.0f};
        DesignImageView designImageView2 = this.f40130f.f41952c;
        Property property2 = View.SCALE_Y;
        float[] fArr2 = {designImageView2.getScaleY(), 1.0f};
        DesignImageView designImageView3 = this.f40130f.f41952c;
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f40130f.f41957h, View.SCALE_X, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41957h, View.SCALE_Y, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41956g, View.SCALE_X, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41956g, View.SCALE_Y, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41955f, View.SCALE_X, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41955f, View.SCALE_Y, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41955f, View.ALPHA, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41953d, View.SCALE_X, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.f40130f.f41953d, View.SCALE_Y, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.f40130f.f41953d, View.ALPHA, 0.0f, 1.0f), ObjectAnimator.ofFloat(designImageView, property, fArr), ObjectAnimator.ofFloat(designImageView2, property2, fArr2), ObjectAnimator.ofFloat(designImageView3, View.ALPHA, designImageView3.getAlpha(), 1.0f));
        animatorSet.addListener(new d());
        animatorSet.setDuration(200L);
        animatorSet.setInterpolator(f40129q);
        return animatorSet;
    }

    private final AnimatorSet getEstimatedStateAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f40130f.f41957h, View.SCALE_X, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.f40130f.f41957h, View.SCALE_Y, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.f40130f.f41956g, View.SCALE_X, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.f40130f.f41956g, View.SCALE_Y, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.f40130f.f41953d, View.SCALE_X, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41953d, View.SCALE_Y, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41953d, View.ALPHA, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41955f, View.SCALE_X, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41955f, View.SCALE_Y, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41955f, View.ALPHA, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41952c, View.SCALE_X, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41952c, View.SCALE_Y, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41952c, View.ALPHA, 1.0f, 0.0f));
        animatorSet.addListener(new e());
        animatorSet.setDuration(200L);
        animatorSet.setInterpolator(f40129q);
        return animatorSet;
    }

    private final AnimatorSet getIconStateAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f40130f.f41957h, View.SCALE_X, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41957h, View.SCALE_Y, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41956g, View.SCALE_X, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41956g, View.SCALE_Y, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41953d, View.SCALE_X, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41953d, View.SCALE_Y, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41953d, View.ALPHA, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41952c, View.SCALE_X, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41952c, View.SCALE_Y, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41952c, View.ALPHA, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.f40130f.f41955f, View.SCALE_X, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.f40130f.f41955f, View.SCALE_Y, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.f40130f.f41955f, View.ALPHA, 0.0f, 1.0f));
        animatorSet.addListener(new f());
        animatorSet.setDuration(200L);
        animatorSet.setInterpolator(f40129q);
        return animatorSet;
    }

    private final AnimatorSet getLoadingStateAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f40130f.f41953d, View.SCALE_X, 1.0f, 0.8f), ObjectAnimator.ofFloat(this.f40130f.f41953d, View.SCALE_Y, 1.0f, 0.8f), ObjectAnimator.ofFloat(this.f40130f.f41953d, View.ALPHA, 1.0f, 0.6f));
        animatorSet.setDuration(500L);
        PathInterpolator pathInterpolator = f40129q;
        animatorSet.setInterpolator(pathInterpolator);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(ObjectAnimator.ofFloat(this.f40130f.f41953d, View.SCALE_X, 0.8f, 1.0f), ObjectAnimator.ofFloat(this.f40130f.f41953d, View.SCALE_Y, 0.8f, 1.0f), ObjectAnimator.ofFloat(this.f40130f.f41953d, View.ALPHA, 0.6f, 1.0f));
        animatorSet2.setDuration(500L);
        animatorSet2.setInterpolator(pathInterpolator);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(animatorSet, animatorSet2);
        animatorSet3.addListener(new g());
        return animatorSet3;
    }

    public final a5 getBinding() {
        return this.f40130f;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        DesignTextView designTextView = this.f40130f.f41957h;
        designTextView.setPivotX(designTextView.getMeasuredWidth() / 2.0f);
        DesignTextView designTextView2 = this.f40130f.f41957h;
        designTextView2.setPivotY(designTextView2.getMeasuredHeight());
        DesignTextView designTextView3 = this.f40130f.f41956g;
        designTextView3.setPivotX(designTextView3.getMeasuredWidth() / 2.0f);
        this.f40130f.f41956g.setPivotY(0.0f);
    }

    public final void setBackgroundLoadingListener(v9 v9Var) {
        this.f40136l = v9Var;
    }

    public final void setLoaderLoadingListener(v9 v9Var) {
        this.f40137m = v9Var;
    }

    public final void setOnAnimationFinishedCallback(Function0<Unit> callback) {
        Intrinsics.f(callback, "callback");
        this.f40135k = callback;
    }
}
