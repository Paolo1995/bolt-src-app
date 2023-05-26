package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import java.util.Map;

/* loaded from: classes.dex */
public class ChangeBounds extends Transition {
    private static final String[] S = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> T = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") { // from class: androidx.transition.ChangeBounds.1

        /* renamed from: a  reason: collision with root package name */
        private Rect f7781a = new Rect();

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f7781a);
            Rect rect = this.f7781a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f7781a);
            this.f7781a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f7781a);
        }
    };
    private static final Property<ViewBounds, PointF> U = new Property<ViewBounds, PointF>(PointF.class, "topLeft") { // from class: androidx.transition.ChangeBounds.2
        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(ViewBounds viewBounds) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(ViewBounds viewBounds, PointF pointF) {
            viewBounds.c(pointF);
        }
    };
    private static final Property<ViewBounds, PointF> V = new Property<ViewBounds, PointF>(PointF.class, "bottomRight") { // from class: androidx.transition.ChangeBounds.3
        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(ViewBounds viewBounds) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(ViewBounds viewBounds, PointF pointF) {
            viewBounds.a(pointF);
        }
    };
    private static final Property<View, PointF> W = new Property<View, PointF>(PointF.class, "bottomRight") { // from class: androidx.transition.ChangeBounds.4
        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(View view, PointF pointF) {
            ViewUtils.f(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    };
    private static final Property<View, PointF> X = new Property<View, PointF>(PointF.class, "topLeft") { // from class: androidx.transition.ChangeBounds.5
        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(View view, PointF pointF) {
            ViewUtils.f(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    };
    private static final Property<View, PointF> Y = new Property<View, PointF>(PointF.class, "position") { // from class: androidx.transition.ChangeBounds.6
        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            ViewUtils.f(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    };
    private static RectEvaluator Z = new RectEvaluator();
    private int[] P = new int[2];
    private boolean Q = false;
    private boolean R = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ViewBounds {

        /* renamed from: a  reason: collision with root package name */
        private int f7800a;

        /* renamed from: b  reason: collision with root package name */
        private int f7801b;

        /* renamed from: c  reason: collision with root package name */
        private int f7802c;

        /* renamed from: d  reason: collision with root package name */
        private int f7803d;

        /* renamed from: e  reason: collision with root package name */
        private View f7804e;

        /* renamed from: f  reason: collision with root package name */
        private int f7805f;

        /* renamed from: g  reason: collision with root package name */
        private int f7806g;

        ViewBounds(View view) {
            this.f7804e = view;
        }

        private void b() {
            ViewUtils.f(this.f7804e, this.f7800a, this.f7801b, this.f7802c, this.f7803d);
            this.f7805f = 0;
            this.f7806g = 0;
        }

        void a(PointF pointF) {
            this.f7802c = Math.round(pointF.x);
            this.f7803d = Math.round(pointF.y);
            int i8 = this.f7806g + 1;
            this.f7806g = i8;
            if (this.f7805f == i8) {
                b();
            }
        }

        void c(PointF pointF) {
            this.f7800a = Math.round(pointF.x);
            this.f7801b = Math.round(pointF.y);
            int i8 = this.f7805f + 1;
            this.f7805f = i8;
            if (i8 == this.f7806g) {
                b();
            }
        }
    }

    private void k0(TransitionValues transitionValues) {
        View view = transitionValues.f7876b;
        if (ViewCompat.W(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            transitionValues.f7875a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            transitionValues.f7875a.put("android:changeBounds:parent", transitionValues.f7876b.getParent());
            if (this.R) {
                transitionValues.f7876b.getLocationInWindow(this.P);
                transitionValues.f7875a.put("android:changeBounds:windowX", Integer.valueOf(this.P[0]));
                transitionValues.f7875a.put("android:changeBounds:windowY", Integer.valueOf(this.P[1]));
            }
            if (this.Q) {
                transitionValues.f7875a.put("android:changeBounds:clip", ViewCompat.w(view));
            }
        }
    }

    private boolean l0(View view, View view2) {
        if (!this.R) {
            return true;
        }
        TransitionValues z7 = z(view, true);
        if (z7 == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == z7.f7876b) {
            return true;
        }
        return false;
    }

    @Override // androidx.transition.Transition
    public String[] L() {
        return S;
    }

    @Override // androidx.transition.Transition
    public void h(@NonNull TransitionValues transitionValues) {
        k0(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void k(@NonNull TransitionValues transitionValues) {
        k0(transitionValues);
    }

    @Override // androidx.transition.Transition
    public Animator o(@NonNull final ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i8;
        final View view;
        ObjectAnimator a8;
        int i9;
        Rect rect;
        Rect rect2;
        ObjectAnimator objectAnimator;
        Animator c8;
        if (transitionValues != null && transitionValues2 != null) {
            Map<String, Object> map = transitionValues.f7875a;
            Map<String, Object> map2 = transitionValues2.f7875a;
            ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
            ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
            if (viewGroup2 != null && viewGroup3 != null) {
                final View view2 = transitionValues2.f7876b;
                if (l0(viewGroup2, viewGroup3)) {
                    Rect rect3 = (Rect) transitionValues.f7875a.get("android:changeBounds:bounds");
                    Rect rect4 = (Rect) transitionValues2.f7875a.get("android:changeBounds:bounds");
                    int i10 = rect3.left;
                    final int i11 = rect4.left;
                    int i12 = rect3.top;
                    final int i13 = rect4.top;
                    int i14 = rect3.right;
                    final int i15 = rect4.right;
                    int i16 = rect3.bottom;
                    final int i17 = rect4.bottom;
                    int i18 = i14 - i10;
                    int i19 = i16 - i12;
                    int i20 = i15 - i11;
                    int i21 = i17 - i13;
                    Rect rect5 = (Rect) transitionValues.f7875a.get("android:changeBounds:clip");
                    final Rect rect6 = (Rect) transitionValues2.f7875a.get("android:changeBounds:clip");
                    if ((i18 != 0 && i19 != 0) || (i20 != 0 && i21 != 0)) {
                        if (i10 == i11 && i12 == i13) {
                            i8 = 0;
                        } else {
                            i8 = 1;
                        }
                        if (i14 != i15 || i16 != i17) {
                            i8++;
                        }
                    } else {
                        i8 = 0;
                    }
                    if ((rect5 != null && !rect5.equals(rect6)) || (rect5 == null && rect6 != null)) {
                        i8++;
                    }
                    if (i8 > 0) {
                        if (!this.Q) {
                            view = view2;
                            ViewUtils.f(view, i10, i12, i14, i16);
                            if (i8 == 2) {
                                if (i18 == i20 && i19 == i21) {
                                    c8 = ObjectAnimatorUtils.a(view, Y, B().a(i10, i12, i11, i13));
                                } else {
                                    ViewBounds viewBounds = new ViewBounds(view);
                                    ObjectAnimator a9 = ObjectAnimatorUtils.a(viewBounds, U, B().a(i10, i12, i11, i13));
                                    ObjectAnimator a10 = ObjectAnimatorUtils.a(viewBounds, V, B().a(i14, i16, i15, i17));
                                    AnimatorSet animatorSet = new AnimatorSet();
                                    animatorSet.playTogether(a9, a10);
                                    animatorSet.addListener(new AnimatorListenerAdapter(viewBounds) { // from class: androidx.transition.ChangeBounds.7

                                        /* renamed from: a  reason: collision with root package name */
                                        final /* synthetic */ ViewBounds f7787a;
                                        private ViewBounds mViewBounds;

                                        {
                                            this.f7787a = viewBounds;
                                            this.mViewBounds = viewBounds;
                                        }
                                    });
                                    c8 = animatorSet;
                                }
                            } else if (i10 == i11 && i12 == i13) {
                                c8 = ObjectAnimatorUtils.a(view, W, B().a(i14, i16, i15, i17));
                            } else {
                                c8 = ObjectAnimatorUtils.a(view, X, B().a(i10, i12, i11, i13));
                            }
                        } else {
                            view = view2;
                            ViewUtils.f(view, i10, i12, Math.max(i18, i20) + i10, Math.max(i19, i21) + i12);
                            if (i10 == i11 && i12 == i13) {
                                a8 = null;
                            } else {
                                a8 = ObjectAnimatorUtils.a(view, Y, B().a(i10, i12, i11, i13));
                            }
                            if (rect5 == null) {
                                i9 = 0;
                                rect = new Rect(0, 0, i18, i19);
                            } else {
                                i9 = 0;
                                rect = rect5;
                            }
                            if (rect6 == null) {
                                rect2 = new Rect(i9, i9, i20, i21);
                            } else {
                                rect2 = rect6;
                            }
                            if (!rect.equals(rect2)) {
                                ViewCompat.z0(view, rect);
                                RectEvaluator rectEvaluator = Z;
                                Object[] objArr = new Object[2];
                                objArr[i9] = rect;
                                objArr[1] = rect2;
                                ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", rectEvaluator, objArr);
                                ofObject.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeBounds.8

                                    /* renamed from: a  reason: collision with root package name */
                                    private boolean f7789a;

                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                    public void onAnimationCancel(Animator animator) {
                                        this.f7789a = true;
                                    }

                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                    public void onAnimationEnd(Animator animator) {
                                        if (!this.f7789a) {
                                            ViewCompat.z0(view, rect6);
                                            ViewUtils.f(view, i11, i13, i15, i17);
                                        }
                                    }
                                });
                                objectAnimator = ofObject;
                            } else {
                                objectAnimator = null;
                            }
                            c8 = TransitionUtils.c(a8, objectAnimator);
                        }
                        if (view.getParent() instanceof ViewGroup) {
                            final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                            ViewGroupUtils.c(viewGroup4, true);
                            a(new TransitionListenerAdapter() { // from class: androidx.transition.ChangeBounds.9

                                /* renamed from: a  reason: collision with root package name */
                                boolean f7797a = false;

                                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                                public void a(@NonNull Transition transition) {
                                    ViewGroupUtils.c(viewGroup4, true);
                                }

                                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                                public void c(@NonNull Transition transition) {
                                    ViewGroupUtils.c(viewGroup4, false);
                                }

                                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                                public void d(@NonNull Transition transition) {
                                    if (!this.f7797a) {
                                        ViewGroupUtils.c(viewGroup4, false);
                                    }
                                    transition.X(this);
                                }

                                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                                public void e(@NonNull Transition transition) {
                                    ViewGroupUtils.c(viewGroup4, false);
                                    this.f7797a = true;
                                }
                            });
                        }
                        return c8;
                    }
                    return null;
                }
                int intValue = ((Integer) transitionValues.f7875a.get("android:changeBounds:windowX")).intValue();
                int intValue2 = ((Integer) transitionValues.f7875a.get("android:changeBounds:windowY")).intValue();
                int intValue3 = ((Integer) transitionValues2.f7875a.get("android:changeBounds:windowX")).intValue();
                int intValue4 = ((Integer) transitionValues2.f7875a.get("android:changeBounds:windowY")).intValue();
                if (intValue == intValue3 && intValue2 == intValue4) {
                    return null;
                }
                viewGroup.getLocationInWindow(this.P);
                Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
                view2.draw(new Canvas(createBitmap));
                final BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
                final float c9 = ViewUtils.c(view2);
                ViewUtils.g(view2, 0.0f);
                ViewUtils.b(viewGroup).a(bitmapDrawable);
                PathMotion B = B();
                int[] iArr = this.P;
                int i22 = iArr[0];
                int i23 = iArr[1];
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, PropertyValuesHolderUtils.a(T, B.a(intValue - i22, intValue2 - i23, intValue3 - i22, intValue4 - i23)));
                ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeBounds.10
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        ViewUtils.b(viewGroup).b(bitmapDrawable);
                        ViewUtils.g(view2, c9);
                    }
                });
                return ofPropertyValuesHolder;
            }
            return null;
        }
        return null;
    }
}
