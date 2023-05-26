package eu.bolt.client.design.button;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import eu.bolt.client.design.image.DesignImageView;
import eu.bolt.client.design.progress.DesignCircleProgressView;
import eu.bolt.client.design.text.DesignNewIndicatorTextView;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.verification.R$dimen;
import eu.bolt.verification.R$drawable;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$styleable;
import eu.bolt.verification.sdk.internal.aa;
import eu.bolt.verification.sdk.internal.f2;
import eu.bolt.verification.sdk.internal.r4;
import eu.bolt.verification.sdk.internal.s4;
import eu.bolt.verification.sdk.internal.t3;
import eu.bolt.verification.sdk.internal.u9;
import eu.bolt.verification.sdk.internal.uq;
import eu.bolt.verification.sdk.internal.vl;
import eu.bolt.verification.sdk.internal.w;
import j$.util.Spliterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class DesignTextFabView extends FrameLayout {

    /* renamed from: n  reason: collision with root package name */
    private static final b f39976n = new b(null);

    /* renamed from: f  reason: collision with root package name */
    private float f39977f;

    /* renamed from: g  reason: collision with root package name */
    private float f39978g;

    /* renamed from: h  reason: collision with root package name */
    private final c f39979h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f39980i;

    /* renamed from: j  reason: collision with root package name */
    private float f39981j;

    /* renamed from: k  reason: collision with root package name */
    private final ConstraintSet f39982k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f39983l;

    /* renamed from: m  reason: collision with root package name */
    private final s4 f39984m;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<TypedArray, Unit> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Context f39985f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ DesignTextFabView f39986g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, DesignTextFabView designTextFabView) {
            super(1);
            this.f39985f = context;
            this.f39986g = designTextFabView;
        }

        public final void b(TypedArray array) {
            Intrinsics.f(array, "array");
            String a8 = vl.a(array, R$styleable.f41740a2, this.f39985f);
            int color = array.getColor(R$styleable.T1, -1);
            int resourceId = array.getResourceId(R$styleable.W1, -1);
            DesignTextFabView designTextFabView = this.f39986g;
            designTextFabView.f39980i = array.getBoolean(R$styleable.Z1, designTextFabView.f39980i);
            DesignTextFabView designTextFabView2 = this.f39986g;
            designTextFabView2.f39981j = array.getDimension(R$styleable.V1, designTextFabView2.f39981j);
            ColorStateList colorStateList = array.getColorStateList(R$styleable.Y1);
            int dimensionPixelSize = array.getDimensionPixelSize(R$styleable.X1, f2.n(this.f39985f, R$dimen.dfab_image_size));
            this.f39986g.setText(a8);
            this.f39986g.getBinding().f44934e.getLayoutParams().height = dimensionPixelSize;
            this.f39986g.getBinding().f44934e.getLayoutParams().width = dimensionPixelSize;
            this.f39986g.setTint(colorStateList);
            DesignTextFabView.d(this.f39986g, resourceId == -1 ? null : new aa.e(resourceId, null, null, 6, null), null, 2, null);
            if (color != -1) {
                this.f39986g.setBackgroundColor(color);
            }
            this.f39986g.setEmptyIndicatorVisible(array.getBoolean(R$styleable.U1, false));
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
    private final class c {

        /* renamed from: a  reason: collision with root package name */
        private boolean f39987a;

        /* renamed from: b  reason: collision with root package name */
        private Animator f39988b;

        /* renamed from: c  reason: collision with root package name */
        private Animator f39989c;

        /* loaded from: classes5.dex */
        public static final class a extends ViewOutlineProvider {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ float f39991a;

            a(float f8) {
                this.f39991a = f8;
            }

            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                Intrinsics.f(view, "view");
                Intrinsics.f(outline, "outline");
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f39991a);
            }
        }

        public c() {
        }

        private final Animator a(float f8, float f9) {
            AnimatorSet animatorSet = new AnimatorSet();
            DesignTextFabView designTextFabView = DesignTextFabView.this;
            FrameLayout frameLayout = designTextFabView.getBinding().f44937h;
            Intrinsics.e(frameLayout, "binding.roundContainer");
            AnimatorSet.Builder play = animatorSet.play(b(f8, frameLayout));
            FrameLayout frameLayout2 = designTextFabView.getBinding().f44937h;
            Intrinsics.e(frameLayout2, "binding.roundContainer");
            AnimatorSet.Builder with = play.with(f(f9, frameLayout2));
            DesignTextView designTextView = designTextFabView.getBinding().f44933d;
            Intrinsics.e(designTextView, "binding.counter");
            AnimatorSet.Builder with2 = with.with(b(f8, designTextView));
            DesignTextView designTextView2 = designTextFabView.getBinding().f44933d;
            Intrinsics.e(designTextView2, "binding.counter");
            AnimatorSet.Builder with3 = with2.with(f(f9, designTextView2));
            View view = designTextFabView.getBinding().f44931b;
            Intrinsics.e(view, "binding.badge");
            AnimatorSet.Builder with4 = with3.with(b(f8, view));
            View view2 = designTextFabView.getBinding().f44931b;
            Intrinsics.e(view2, "binding.badge");
            with4.with(f(f9, view2));
            animatorSet.setInterpolator(w.f45479a.b());
            return animatorSet;
        }

        private final ObjectAnimator b(float f8, View view) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(view, "elevation", f8).setDuration(0L);
            Intrinsics.e(duration, "ofFloat(target, \"elevati…levation).setDuration(0L)");
            return duration;
        }

        private final ObjectAnimator f(float f8, View view) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(view, View.TRANSLATION_Z, f8).setDuration(100L);
            Intrinsics.e(duration, "ofFloat(\n               …_Z_ANIMATION_DURATION_MS)");
            return duration;
        }

        public final void c() {
            g();
            DesignTextFabView.this.getBinding().f44937h.setClipToOutline(true);
        }

        public final void d(float f8) {
            DesignTextFabView.this.getBinding().f44937h.setOutlineProvider(new a(f8));
        }

        public final void e(boolean z7) {
            Animator animator;
            if (this.f39987a == z7) {
                return;
            }
            this.f39987a = z7;
            if (DesignTextFabView.this.isPressed()) {
                Animator animator2 = this.f39989c;
                if (animator2 != null) {
                    animator2.cancel();
                }
                animator = this.f39988b;
                if (animator == null) {
                    return;
                }
            } else {
                Animator animator3 = this.f39988b;
                if (animator3 != null) {
                    animator3.cancel();
                }
                animator = this.f39989c;
                if (animator == null) {
                    return;
                }
            }
            animator.start();
        }

        public final void g() {
            float f8 = DesignTextFabView.this.f39980i ? DesignTextFabView.this.f39981j : 0.0f;
            ViewCompat.A0(DesignTextFabView.this.getBinding().f44937h, f8);
            ViewCompat.A0(DesignTextFabView.this.getBinding().f44933d, f8);
            ViewCompat.A0(DesignTextFabView.this.getBinding().f44931b, f8);
            ViewCompat.A0(DesignTextFabView.this.getBinding().f44935f, f8);
            Animator animator = this.f39988b;
            if (animator != null) {
                animator.cancel();
            }
            Animator animator2 = this.f39989c;
            if (animator2 != null) {
                animator2.cancel();
            }
            Context context = DesignTextFabView.this.getContext();
            Intrinsics.e(context, "context");
            this.f39988b = a(f8, f2.i(context, 4.0f));
            this.f39989c = a(f8, 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class d extends Lambda implements Function0<Unit> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ DesignImageView f39993g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ aa f39994h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(DesignImageView designImageView, aa aaVar) {
            super(0);
            this.f39993g = designImageView;
            this.f39994h = aaVar;
        }

        public final void b() {
            DesignTextFabView.this.g(this.f39993g, ((aa.g) this.f39994h).g(), ((aa.g) this.f39994h).f(), ((aa.g) this.f39994h).c());
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            b();
            return Unit.f50853a;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DesignTextFabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesignTextFabView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        c cVar = new c();
        this.f39979h = cVar;
        this.f39980i = true;
        this.f39981j = f2.i(context, 6.0f);
        this.f39982k = new ConstraintSet();
        s4 a8 = s4.a(uq.Y(this), this);
        Intrinsics.e(a8, "inflate(inflater(), this)");
        this.f39984m = a8;
        int[] DesignTextFabView = R$styleable.S1;
        Intrinsics.e(DesignTextFabView, "DesignTextFabView");
        uq.x(this, attributeSet, DesignTextFabView, new a(context, this));
        cVar.c();
    }

    public /* synthetic */ DesignTextFabView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    public static /* synthetic */ void d(DesignTextFabView designTextFabView, aa aaVar, aa aaVar2, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            aaVar2 = null;
        }
        designTextFabView.h(aaVar, aaVar2);
    }

    private final void f(DesignImageView designImageView, aa aaVar) {
        Drawable a8;
        if (aaVar instanceof aa.b) {
            Context context = designImageView.getContext();
            Intrinsics.e(context, "context");
            a8 = ((aa.b) aaVar).b(context);
        } else if (aaVar instanceof aa.a) {
            Context context2 = designImageView.getContext();
            Intrinsics.e(context2, "context");
            a8 = ((aa.a) aaVar).b(context2);
        } else if (!(aaVar instanceof aa.e)) {
            if (aaVar instanceof aa.g) {
                uq.o(designImageView, false, new d(designImageView, aaVar), 1, null);
                return;
            } else if (!(aaVar instanceof aa.d)) {
                if (aaVar == null) {
                    designImageView.setImageDrawable(null);
                    return;
                }
                t3.c("Unsupported image type for top button " + aaVar, null, 2, null);
                return;
            } else {
                aa.d dVar = (aa.d) aaVar;
                aa.d.a d8 = dVar.d();
                if (d8 instanceof aa.d.a.C0028a) {
                    designImageView.setAnimation(((aa.d.a.C0028a) dVar.d()).a());
                } else if (d8 instanceof aa.d.a.b) {
                    designImageView.setAnimation(((aa.d.a.b) dVar.d()).a());
                }
                designImageView.setRepeatCount(dVar.c() ? -1 : 0);
                if (dVar.e() != null) {
                    DesignImageView designImageView2 = this.f39984m.f44934e;
                    ViewGroup.LayoutParams layoutParams = designImageView2.getLayoutParams();
                    Context context3 = designImageView2.getContext();
                    Intrinsics.e(context3, "context");
                    layoutParams.height = f2.a(context3, dVar.e().a());
                    ViewGroup.LayoutParams layoutParams2 = designImageView2.getLayoutParams();
                    Context context4 = designImageView2.getContext();
                    Intrinsics.e(context4, "context");
                    layoutParams2.width = f2.a(context4, dVar.e().b());
                    designImageView2.requestLayout();
                }
                designImageView.x();
                return;
            }
        } else {
            Context context5 = designImageView.getContext();
            Intrinsics.e(context5, "context");
            a8 = r4.a((aa.e) aaVar, context5);
        }
        designImageView.setImageDrawable(a8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(DesignImageView designImageView, String str, Integer num, Integer num2) {
        if (str != null) {
            u9.d(designImageView, str, (r24 & 2) != 0 ? null : null, (r24 & 4) != 0 ? null : num2, (r24 & 8) != 0 ? null : null, (r24 & 16) != 0 ? null : null, (r24 & 32) != 0 ? null : num, (r24 & 64) != 0 ? null : null, (r24 & 128) != 0 ? null : null, (r24 & Spliterator.NONNULL) != 0 ? null : null, (r24 & 512) == 0 ? null : null, (r24 & Spliterator.IMMUTABLE) != 0 ? false : false, (r24 & 2048) != 0);
            return;
        }
        u9.c(designImageView);
        designImageView.setImageDrawable(null);
    }

    private final void setHidden(boolean z7) {
        float f8 = z7 ? 0.0f : 1.0f;
        this.f39984m.f44937h.setTag(R$id.key_appearance, Float.valueOf(f8));
        FrameLayout frameLayout = this.f39984m.f44937h;
        frameLayout.setAlpha(f8);
        frameLayout.setScaleX(f8);
        frameLayout.setScaleY(f8);
        this.f39984m.f44933d.setAlpha(f8);
        this.f39984m.f44931b.setAlpha(f8);
        this.f39984m.f44935f.setAlpha(f8);
    }

    public final s4 getBinding() {
        return this.f39984m;
    }

    public final float getImageTransitionPercent() {
        return this.f39977f;
    }

    public final String getText() {
        return this.f39984m.f44939j.getText().toString();
    }

    public final void h(aa aaVar, aa aaVar2) {
        int i8;
        DesignImageView designImageView = this.f39984m.f44934e;
        Intrinsics.e(designImageView, "binding.icon");
        f(designImageView, aaVar);
        DesignImageView designImageView2 = this.f39984m.f44938i;
        Intrinsics.e(designImageView2, "binding.secondaryIcon");
        f(designImageView2, aaVar2);
        DesignImageView designImageView3 = this.f39984m.f44934e;
        Intrinsics.e(designImageView3, "binding.icon");
        designImageView3.setVisibility(!this.f39983l && aaVar != null ? 0 : 8);
        DesignImageView designImageView4 = this.f39984m.f44938i;
        Intrinsics.e(designImageView4, "binding.secondaryIcon");
        DesignImageView designImageView5 = this.f39984m.f44934e;
        Intrinsics.e(designImageView5, "binding.icon");
        designImageView4.setVisibility(designImageView5.getVisibility() == 0 ? 0 : 8);
        if (aaVar != null) {
            Context context = getContext();
            Intrinsics.e(context, "context");
            i8 = f2.a(context, 8.0f);
        } else {
            i8 = 0;
        }
        ViewGroup.LayoutParams layoutParams = this.f39984m.f44939j.getLayoutParams();
        Intrinsics.d(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        uq.E((ConstraintLayout.LayoutParams) layoutParams, i8, 0, 0, 0, null, 30, null);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        float measuredHeight = getMeasuredHeight() / 2.0f;
        if (this.f39978g == measuredHeight) {
            return;
        }
        this.f39978g = measuredHeight;
        this.f39979h.d(measuredHeight);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i8) {
        this.f39984m.f44937h.setBackgroundColor(i8);
    }

    public final void setCounter(int i8) {
        DesignTextView designTextView;
        int i9;
        if (i8 <= 0) {
            DesignTextView designTextView2 = this.f39984m.f44933d;
            Intrinsics.e(designTextView2, "binding.counter");
            uq.C(designTextView2, false);
            return;
        }
        if (i8 < 10) {
            DesignTextView designTextView3 = this.f39984m.f44933d;
            Intrinsics.e(designTextView3, "binding.counter");
            uq.C(designTextView3, true);
            this.f39984m.f44933d.setText(String.valueOf(i8));
            designTextView = this.f39984m.f44933d;
            i9 = R$drawable.circle_green_600;
        } else if (i8 < 10) {
            return;
        } else {
            DesignTextView designTextView4 = this.f39984m.f44933d;
            Intrinsics.e(designTextView4, "binding.counter");
            uq.C(designTextView4, true);
            this.f39984m.f44933d.setText("");
            designTextView = this.f39984m.f44933d;
            i9 = R$drawable.bg_fab_counter_overflown;
        }
        designTextView.setBackgroundResource(i9);
    }

    public final void setEmptyIndicatorVisible(boolean z7) {
        View view = this.f39984m.f44931b;
        Intrinsics.e(view, "binding.badge");
        view.setVisibility(z7 ? 0 : 8);
    }

    public final void setImageTransitionPercent(float f8) {
        this.f39977f = f8;
        this.f39984m.f44934e.setAlpha(1.0f - f8);
        this.f39984m.f44938i.setAlpha(f8);
    }

    public final void setInProgress(boolean z7) {
        this.f39983l = z7;
        DesignCircleProgressView designCircleProgressView = this.f39984m.f44936g;
        Intrinsics.e(designCircleProgressView, "binding.progress");
        designCircleProgressView.setVisibility(z7 ? 0 : 8);
        DesignTextView designTextView = this.f39984m.f44939j;
        Intrinsics.e(designTextView, "binding.text");
        boolean z8 = !z7;
        designTextView.setVisibility(z8 ? 0 : 8);
        DesignImageView designImageView = this.f39984m.f44934e;
        Intrinsics.e(designImageView, "binding.icon");
        designImageView.setVisibility(z8 ? 0 : 8);
        DesignImageView designImageView2 = this.f39984m.f44938i;
        Intrinsics.e(designImageView2, "binding.secondaryIcon");
        designImageView2.setVisibility(z8 ? 0 : 8);
    }

    public final void setIndicatorText(String text) {
        Intrinsics.f(text, "text");
        this.f39984m.f44935f.setText(text);
    }

    public final void setIndicatorWithTextVisible(boolean z7) {
        DesignNewIndicatorTextView designNewIndicatorTextView = this.f39984m.f44935f;
        Intrinsics.e(designNewIndicatorTextView, "binding.indicator");
        designNewIndicatorTextView.setVisibility(z7 ? 0 : 8);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        setClickable(onClickListener != null);
    }

    @Override // android.view.View
    public void setPressed(boolean z7) {
        super.setPressed(z7);
        this.f39979h.e(z7);
    }

    public final void setProgressTint(int i8) {
        this.f39984m.f44936g.setProgressDrawableColorInt(i8);
    }

    public final void setShadowEnabled(boolean z7) {
        if (this.f39980i == z7) {
            return;
        }
        this.f39980i = z7;
        this.f39979h.g();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setText(java.lang.String r13) {
        /*
            r12 = this;
            androidx.constraintlayout.widget.ConstraintSet r0 = r12.f39982k
            eu.bolt.verification.sdk.internal.s4 r1 = r12.f39984m
            androidx.constraintlayout.widget.ConstraintLayout r1 = r1.f44932c
            r0.g(r1)
            r0 = 0
            if (r13 == 0) goto L15
            boolean r1 = kotlin.text.StringsKt.y(r13)
            if (r1 == 0) goto L13
            goto L15
        L13:
            r1 = 0
            goto L16
        L15:
            r1 = 1
        L16:
            java.lang.String r2 = "binding.contentContainer"
            java.lang.String r3 = "context"
            r4 = 7
            if (r1 == 0) goto L68
            android.content.Context r13 = r12.getContext()
            kotlin.jvm.internal.Intrinsics.e(r13, r3)
            r0 = 1090519040(0x41000000, float:8.0)
            int r8 = eu.bolt.verification.sdk.internal.f2.a(r13, r0)
            eu.bolt.verification.sdk.internal.s4 r13 = r12.f39984m
            androidx.constraintlayout.widget.ConstraintLayout r5 = r13.f44932c
            kotlin.jvm.internal.Intrinsics.e(r5, r2)
            r7 = 0
            r9 = 0
            r10 = 10
            r11 = 0
            r6 = r8
            eu.bolt.verification.sdk.internal.uq.v(r5, r6, r7, r8, r9, r10, r11)
            androidx.constraintlayout.widget.ConstraintSet r13 = r12.f39982k
            eu.bolt.verification.sdk.internal.s4 r0 = r12.f39984m
            eu.bolt.client.design.image.DesignImageView r0 = r0.f44934e
            int r0 = r0.getId()
            eu.bolt.verification.sdk.internal.s4 r1 = r12.f39984m
            androidx.constraintlayout.widget.ConstraintLayout r1 = r1.f44932c
            int r1 = r1.getId()
            r13.i(r0, r4, r1, r4)
            androidx.constraintlayout.widget.ConstraintSet r13 = r12.f39982k
            eu.bolt.verification.sdk.internal.s4 r0 = r12.f39984m
            eu.bolt.client.design.text.DesignTextView r0 = r0.f44939j
            int r0 = r0.getId()
            r1 = 8
            r13.A(r0, r1)
            eu.bolt.verification.sdk.internal.s4 r13 = r12.f39984m
            eu.bolt.client.design.text.DesignTextView r13 = r13.f44939j
            java.lang.String r0 = ""
            r13.setText(r0)
            goto La6
        L68:
            android.content.Context r1 = r12.getContext()
            kotlin.jvm.internal.Intrinsics.e(r1, r3)
            r3 = 1098907648(0x41800000, float:16.0)
            int r8 = eu.bolt.verification.sdk.internal.f2.a(r1, r3)
            eu.bolt.verification.sdk.internal.s4 r1 = r12.f39984m
            androidx.constraintlayout.widget.ConstraintLayout r5 = r1.f44932c
            kotlin.jvm.internal.Intrinsics.e(r5, r2)
            r7 = 0
            r9 = 0
            r10 = 10
            r11 = 0
            r6 = r8
            eu.bolt.verification.sdk.internal.uq.v(r5, r6, r7, r8, r9, r10, r11)
            eu.bolt.verification.sdk.internal.s4 r1 = r12.f39984m
            eu.bolt.client.design.text.DesignTextView r1 = r1.f44939j
            r1.setText(r13)
            androidx.constraintlayout.widget.ConstraintSet r13 = r12.f39982k
            eu.bolt.verification.sdk.internal.s4 r1 = r12.f39984m
            eu.bolt.client.design.image.DesignImageView r1 = r1.f44934e
            int r1 = r1.getId()
            r13.e(r1, r4)
            androidx.constraintlayout.widget.ConstraintSet r13 = r12.f39982k
            eu.bolt.verification.sdk.internal.s4 r1 = r12.f39984m
            eu.bolt.client.design.text.DesignTextView r1 = r1.f44939j
            int r1 = r1.getId()
            r13.A(r1, r0)
        La6:
            androidx.constraintlayout.widget.ConstraintSet r13 = r12.f39982k
            eu.bolt.verification.sdk.internal.s4 r0 = r12.f39984m
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.f44932c
            r13.c(r0)
            r12.requestLayout()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.client.design.button.DesignTextFabView.setText(java.lang.String):void");
    }

    public final void setTint(int i8) {
        DesignImageView designImageView = this.f39984m.f44934e;
        Intrinsics.e(designImageView, "binding.icon");
        uq.H(designImageView, i8);
        DesignImageView designImageView2 = this.f39984m.f44938i;
        Intrinsics.e(designImageView2, "binding.secondaryIcon");
        uq.H(designImageView2, i8);
    }

    public final void setTint(ColorStateList colorStateList) {
        DesignImageView designImageView = this.f39984m.f44934e;
        Intrinsics.e(designImageView, "binding.icon");
        uq.I(designImageView, colorStateList);
        DesignImageView designImageView2 = this.f39984m.f44938i;
        Intrinsics.e(designImageView2, "binding.secondaryIcon");
        uq.I(designImageView2, colorStateList);
    }
}
