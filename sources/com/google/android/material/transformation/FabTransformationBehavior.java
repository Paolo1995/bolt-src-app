package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.DrawableAlphaProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.animation.Positioning;
import com.google.android.material.circularreveal.CircularRevealCompat;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.math.MathUtils;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c  reason: collision with root package name */
    private final Rect f14534c;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f14535d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f14536e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f14537f;

    /* renamed from: g  reason: collision with root package name */
    private float f14538g;

    /* renamed from: h  reason: collision with root package name */
    private float f14539h;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class FabTransformationSpec {

        /* renamed from: a  reason: collision with root package name */
        public MotionSpec f14551a;

        /* renamed from: b  reason: collision with root package name */
        public Positioning f14552b;
    }

    public FabTransformationBehavior() {
        this.f14534c = new Rect();
        this.f14535d = new RectF();
        this.f14536e = new RectF();
        this.f14537f = new int[2];
    }

    private ViewGroup K(@NonNull View view) {
        View findViewById = view.findViewById(R$id.mtrl_child_content_container);
        if (findViewById != null) {
            return f0(findViewById);
        }
        if (!(view instanceof TransformationChildLayout) && !(view instanceof TransformationChildCard)) {
            return f0(view);
        }
        return f0(((ViewGroup) view).getChildAt(0));
    }

    private void L(@NonNull View view, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull MotionTiming motionTiming, @NonNull MotionTiming motionTiming2, float f8, float f9, float f10, float f11, @NonNull RectF rectF) {
        float S = S(fabTransformationSpec, motionTiming, f8, f10);
        float S2 = S(fabTransformationSpec, motionTiming2, f9, f11);
        Rect rect = this.f14534c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f14535d;
        rectF2.set(rect);
        RectF rectF3 = this.f14536e;
        T(view, rectF3);
        rectF3.offset(S, S2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private void M(@NonNull View view, @NonNull RectF rectF) {
        T(view, rectF);
        rectF.offset(this.f14538g, this.f14539h);
    }

    @NonNull
    private Pair<MotionTiming, MotionTiming> N(float f8, float f9, boolean z7, @NonNull FabTransformationSpec fabTransformationSpec) {
        MotionTiming h8;
        MotionTiming h9;
        int i8;
        if (f8 != 0.0f && f9 != 0.0f) {
            if ((z7 && f9 < 0.0f) || (!z7 && i8 > 0)) {
                h8 = fabTransformationSpec.f14551a.h("translationXCurveUpwards");
                h9 = fabTransformationSpec.f14551a.h("translationYCurveUpwards");
            } else {
                h8 = fabTransformationSpec.f14551a.h("translationXCurveDownwards");
                h9 = fabTransformationSpec.f14551a.h("translationYCurveDownwards");
            }
        } else {
            h8 = fabTransformationSpec.f14551a.h("translationXLinear");
            h9 = fabTransformationSpec.f14551a.h("translationYLinear");
        }
        return new Pair<>(h8, h9);
    }

    private float O(@NonNull View view, @NonNull View view2, @NonNull Positioning positioning) {
        RectF rectF = this.f14535d;
        RectF rectF2 = this.f14536e;
        M(view, rectF);
        T(view2, rectF2);
        rectF2.offset(-Q(view, view2, positioning), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float P(@NonNull View view, @NonNull View view2, @NonNull Positioning positioning) {
        RectF rectF = this.f14535d;
        RectF rectF2 = this.f14536e;
        M(view, rectF);
        T(view2, rectF2);
        rectF2.offset(0.0f, -R(view, view2, positioning));
        return rectF.centerY() - rectF2.top;
    }

    private float Q(@NonNull View view, @NonNull View view2, @NonNull Positioning positioning) {
        float centerX;
        float centerX2;
        float f8;
        RectF rectF = this.f14535d;
        RectF rectF2 = this.f14536e;
        M(view, rectF);
        T(view2, rectF2);
        int i8 = positioning.f12740a & 7;
        if (i8 != 1) {
            if (i8 != 3) {
                if (i8 != 5) {
                    f8 = 0.0f;
                    return f8 + positioning.f12741b;
                }
                centerX = rectF2.right;
                centerX2 = rectF.right;
            } else {
                centerX = rectF2.left;
                centerX2 = rectF.left;
            }
        } else {
            centerX = rectF2.centerX();
            centerX2 = rectF.centerX();
        }
        f8 = centerX - centerX2;
        return f8 + positioning.f12741b;
    }

    private float R(@NonNull View view, @NonNull View view2, @NonNull Positioning positioning) {
        float centerY;
        float centerY2;
        float f8;
        RectF rectF = this.f14535d;
        RectF rectF2 = this.f14536e;
        M(view, rectF);
        T(view2, rectF2);
        int i8 = positioning.f12740a & 112;
        if (i8 != 16) {
            if (i8 != 48) {
                if (i8 != 80) {
                    f8 = 0.0f;
                    return f8 + positioning.f12742c;
                }
                centerY = rectF2.bottom;
                centerY2 = rectF.bottom;
            } else {
                centerY = rectF2.top;
                centerY2 = rectF.top;
            }
        } else {
            centerY = rectF2.centerY();
            centerY2 = rectF.centerY();
        }
        f8 = centerY - centerY2;
        return f8 + positioning.f12742c;
    }

    private float S(@NonNull FabTransformationSpec fabTransformationSpec, @NonNull MotionTiming motionTiming, float f8, float f9) {
        long c8 = motionTiming.c();
        long d8 = motionTiming.d();
        MotionTiming h8 = fabTransformationSpec.f14551a.h("expansion");
        return AnimationUtils.a(f8, f9, motionTiming.e().getInterpolation(((float) (((h8.c() + h8.d()) + 17) - c8)) / ((float) d8)));
    }

    private void T(@NonNull View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        int[] iArr = this.f14537f;
        view.getLocationInWindow(iArr);
        rectF.offsetTo(iArr[0], iArr[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private void U(View view, View view2, boolean z7, boolean z8, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup K;
        ObjectAnimator ofFloat;
        if (!(view2 instanceof ViewGroup)) {
            return;
        }
        if (((view2 instanceof CircularRevealWidget) && CircularRevealHelper.f13237a == 0) || (K = K(view2)) == null) {
            return;
        }
        if (z7) {
            if (!z8) {
                ChildrenAlphaProperty.f12726a.set(K, Float.valueOf(0.0f));
            }
            ofFloat = ObjectAnimator.ofFloat(K, ChildrenAlphaProperty.f12726a, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(K, ChildrenAlphaProperty.f12726a, 0.0f);
        }
        fabTransformationSpec.f14551a.h("contentFade").a(ofFloat);
        list.add(ofFloat);
    }

    private void V(@NonNull View view, View view2, boolean z7, boolean z8, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if (!(view2 instanceof CircularRevealWidget)) {
            return;
        }
        CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
        int d02 = d0(view);
        int i8 = 16777215 & d02;
        if (z7) {
            if (!z8) {
                circularRevealWidget.setCircularRevealScrimColor(d02);
            }
            ofInt = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealWidget.CircularRevealScrimColorProperty.f13241a, i8);
        } else {
            ofInt = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealWidget.CircularRevealScrimColorProperty.f13241a, d02);
        }
        ofInt.setEvaluator(ArgbEvaluatorCompat.b());
        fabTransformationSpec.f14551a.h("color").a(ofInt);
        list.add(ofInt);
    }

    private void W(@NonNull View view, @NonNull View view2, boolean z7, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list) {
        float Q = Q(view, view2, fabTransformationSpec.f14552b);
        float R = R(view, view2, fabTransformationSpec.f14552b);
        Pair<MotionTiming, MotionTiming> N = N(Q, R, z7, fabTransformationSpec);
        MotionTiming motionTiming = (MotionTiming) N.first;
        MotionTiming motionTiming2 = (MotionTiming) N.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z7) {
            Q = this.f14538g;
        }
        fArr[0] = Q;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z7) {
            R = this.f14539h;
        }
        fArr2[0] = R;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, property2, fArr2);
        motionTiming.a(ofFloat);
        motionTiming2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    @TargetApi(21)
    private void X(View view, @NonNull View view2, boolean z7, boolean z8, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        float y7 = ViewCompat.y(view2) - ViewCompat.y(view);
        if (z7) {
            if (!z8) {
                view2.setTranslationZ(-y7);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, -y7);
        }
        fabTransformationSpec.f14551a.h("elevation").a(ofFloat);
        list.add(ofFloat);
    }

    private void Y(@NonNull View view, View view2, boolean z7, boolean z8, @NonNull FabTransformationSpec fabTransformationSpec, float f8, float f9, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        Animator animator;
        if (!(view2 instanceof CircularRevealWidget)) {
            return;
        }
        final CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
        float O = O(view, view2, fabTransformationSpec.f14552b);
        float P = P(view, view2, fabTransformationSpec.f14552b);
        ((FloatingActionButton) view).i(this.f14534c);
        float width = this.f14534c.width() / 2.0f;
        MotionTiming h8 = fabTransformationSpec.f14551a.h("expansion");
        if (z7) {
            if (!z8) {
                circularRevealWidget.setRevealInfo(new CircularRevealWidget.RevealInfo(O, P, width));
            }
            if (z8) {
                width = circularRevealWidget.getRevealInfo().f13244c;
            }
            animator = CircularRevealCompat.a(circularRevealWidget, O, P, MathUtils.b(O, P, 0.0f, 0.0f, f8, f9));
            animator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transformation.FabTransformationBehavior.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    CircularRevealWidget.RevealInfo revealInfo = circularRevealWidget.getRevealInfo();
                    revealInfo.f13244c = Float.MAX_VALUE;
                    circularRevealWidget.setRevealInfo(revealInfo);
                }
            });
            b0(view2, h8.c(), (int) O, (int) P, width, list);
        } else {
            float f10 = circularRevealWidget.getRevealInfo().f13244c;
            Animator a8 = CircularRevealCompat.a(circularRevealWidget, O, P, width);
            int i8 = (int) O;
            int i9 = (int) P;
            b0(view2, h8.c(), i8, i9, f10, list);
            a0(view2, h8.c(), h8.d(), fabTransformationSpec.f14551a.i(), i8, i9, width, list);
            animator = a8;
        }
        h8.a(animator);
        list.add(animator);
        list2.add(CircularRevealCompat.b(circularRevealWidget));
    }

    private void Z(View view, final View view2, boolean z7, boolean z8, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if ((view2 instanceof CircularRevealWidget) && (view instanceof ImageView)) {
            final CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            final Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z7) {
                if (!z8) {
                    drawable.setAlpha(255);
                }
                ofInt = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.f12727b, 0);
            } else {
                ofInt = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.f12727b, 255);
            }
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.transformation.FabTransformationBehavior.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    view2.invalidate();
                }
            });
            fabTransformationSpec.f14551a.h("iconFade").a(ofInt);
            list.add(ofInt);
            list2.add(new AnimatorListenerAdapter() { // from class: com.google.android.material.transformation.FabTransformationBehavior.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    circularRevealWidget.setCircularRevealOverlayDrawable(null);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    circularRevealWidget.setCircularRevealOverlayDrawable(drawable);
                }
            });
        }
    }

    private void a0(View view, long j8, long j9, long j10, int i8, int i9, float f8, @NonNull List<Animator> list) {
        long j11 = j8 + j9;
        if (j11 < j10) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i8, i9, f8, f8);
            createCircularReveal.setStartDelay(j11);
            createCircularReveal.setDuration(j10 - j11);
            list.add(createCircularReveal);
        }
    }

    private void b0(View view, long j8, int i8, int i9, float f8, @NonNull List<Animator> list) {
        if (j8 > 0) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i8, i9, f8, f8);
            createCircularReveal.setStartDelay(0L);
            createCircularReveal.setDuration(j8);
            list.add(createCircularReveal);
        }
    }

    private void c0(@NonNull View view, @NonNull View view2, boolean z7, boolean z8, @NonNull FabTransformationSpec fabTransformationSpec, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2, @NonNull RectF rectF) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        float Q = Q(view, view2, fabTransformationSpec.f14552b);
        float R = R(view, view2, fabTransformationSpec.f14552b);
        Pair<MotionTiming, MotionTiming> N = N(Q, R, z7, fabTransformationSpec);
        MotionTiming motionTiming = (MotionTiming) N.first;
        MotionTiming motionTiming2 = (MotionTiming) N.second;
        if (z7) {
            if (!z8) {
                view2.setTranslationX(-Q);
                view2.setTranslationY(-R);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f);
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f);
            L(view2, fabTransformationSpec, motionTiming, motionTiming2, -Q, -R, 0.0f, 0.0f, rectF);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, -Q);
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, -R);
        }
        motionTiming.a(ofFloat);
        motionTiming2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    private int d0(@NonNull View view) {
        ColorStateList u7 = ViewCompat.u(view);
        if (u7 != null) {
            return u7.getColorForState(view.getDrawableState(), u7.getDefaultColor());
        }
        return 0;
    }

    private ViewGroup f0(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    protected AnimatorSet J(@NonNull final View view, @NonNull final View view2, final boolean z7, boolean z8) {
        FabTransformationSpec e02 = e0(view2.getContext(), z7);
        if (z7) {
            this.f14538g = view.getTranslationX();
            this.f14539h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        X(view, view2, z7, z8, e02, arrayList, arrayList2);
        RectF rectF = this.f14535d;
        c0(view, view2, z7, z8, e02, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        W(view, view2, z7, e02, arrayList);
        Z(view, view2, z7, z8, e02, arrayList, arrayList2);
        Y(view, view2, z7, z8, e02, width, height, arrayList, arrayList2);
        V(view, view2, z7, z8, e02, arrayList, arrayList2);
        U(view, view2, z7, z8, e02, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.a(animatorSet, arrayList);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transformation.FabTransformationBehavior.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!z7) {
                    view2.setVisibility(4);
                    view.setAlpha(1.0f);
                    view.setVisibility(0);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (z7) {
                    view2.setVisibility(0);
                    view.setAlpha(0.0f);
                    view.setVisibility(4);
                }
            }
        });
        int size = arrayList2.size();
        for (int i8 = 0; i8 < size; i8++) {
            animatorSet.addListener(arrayList2.get(i8));
        }
        return animatorSet;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean e(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
        if (view.getVisibility() != 8) {
            if (!(view2 instanceof FloatingActionButton)) {
                return false;
            }
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            if (expandedComponentIdHint != 0 && expandedComponentIdHint != view.getId()) {
                return false;
            }
            return true;
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    protected abstract FabTransformationSpec e0(Context context, boolean z7);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void g(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.f5461h == 0) {
            layoutParams.f5461h = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14534c = new Rect();
        this.f14535d = new RectF();
        this.f14536e = new RectF();
        this.f14537f = new int[2];
    }
}
