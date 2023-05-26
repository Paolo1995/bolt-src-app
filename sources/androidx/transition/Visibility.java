package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.transition.Transition;

/* loaded from: classes.dex */
public abstract class Visibility extends Transition {
    private static final String[] Q = {"android:visibility:visibility", "android:visibility:parent"};
    private int P = 3;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class DisappearListener extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* renamed from: a  reason: collision with root package name */
        private final View f7901a;

        /* renamed from: b  reason: collision with root package name */
        private final int f7902b;

        /* renamed from: c  reason: collision with root package name */
        private final ViewGroup f7903c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f7904d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f7905e;

        /* renamed from: f  reason: collision with root package name */
        boolean f7906f = false;

        DisappearListener(View view, int i8, boolean z7) {
            this.f7901a = view;
            this.f7902b = i8;
            this.f7903c = (ViewGroup) view.getParent();
            this.f7904d = z7;
            g(true);
        }

        private void f() {
            if (!this.f7906f) {
                ViewUtils.h(this.f7901a, this.f7902b);
                ViewGroup viewGroup = this.f7903c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        private void g(boolean z7) {
            ViewGroup viewGroup;
            if (this.f7904d && this.f7905e != z7 && (viewGroup = this.f7903c) != null) {
                this.f7905e = z7;
                ViewGroupUtils.c(viewGroup, z7);
            }
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void a(@NonNull Transition transition) {
            g(true);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void b(@NonNull Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void c(@NonNull Transition transition) {
            g(false);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void d(@NonNull Transition transition) {
            f();
            transition.X(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void e(@NonNull Transition transition) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f7906f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            if (!this.f7906f) {
                ViewUtils.h(this.f7901a, this.f7902b);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (!this.f7906f) {
                ViewUtils.h(this.f7901a, 0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class VisibilityInfo {

        /* renamed from: a  reason: collision with root package name */
        boolean f7907a;

        /* renamed from: b  reason: collision with root package name */
        boolean f7908b;

        /* renamed from: c  reason: collision with root package name */
        int f7909c;

        /* renamed from: d  reason: collision with root package name */
        int f7910d;

        /* renamed from: e  reason: collision with root package name */
        ViewGroup f7911e;

        /* renamed from: f  reason: collision with root package name */
        ViewGroup f7912f;

        VisibilityInfo() {
        }
    }

    private void k0(TransitionValues transitionValues) {
        transitionValues.f7875a.put("android:visibility:visibility", Integer.valueOf(transitionValues.f7876b.getVisibility()));
        transitionValues.f7875a.put("android:visibility:parent", transitionValues.f7876b.getParent());
        int[] iArr = new int[2];
        transitionValues.f7876b.getLocationOnScreen(iArr);
        transitionValues.f7875a.put("android:visibility:screenLocation", iArr);
    }

    private VisibilityInfo l0(TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityInfo = new VisibilityInfo();
        visibilityInfo.f7907a = false;
        visibilityInfo.f7908b = false;
        if (transitionValues != null && transitionValues.f7875a.containsKey("android:visibility:visibility")) {
            visibilityInfo.f7909c = ((Integer) transitionValues.f7875a.get("android:visibility:visibility")).intValue();
            visibilityInfo.f7911e = (ViewGroup) transitionValues.f7875a.get("android:visibility:parent");
        } else {
            visibilityInfo.f7909c = -1;
            visibilityInfo.f7911e = null;
        }
        if (transitionValues2 != null && transitionValues2.f7875a.containsKey("android:visibility:visibility")) {
            visibilityInfo.f7910d = ((Integer) transitionValues2.f7875a.get("android:visibility:visibility")).intValue();
            visibilityInfo.f7912f = (ViewGroup) transitionValues2.f7875a.get("android:visibility:parent");
        } else {
            visibilityInfo.f7910d = -1;
            visibilityInfo.f7912f = null;
        }
        if (transitionValues != null && transitionValues2 != null) {
            int i8 = visibilityInfo.f7909c;
            int i9 = visibilityInfo.f7910d;
            if (i8 == i9 && visibilityInfo.f7911e == visibilityInfo.f7912f) {
                return visibilityInfo;
            }
            if (i8 != i9) {
                if (i8 == 0) {
                    visibilityInfo.f7908b = false;
                    visibilityInfo.f7907a = true;
                } else if (i9 == 0) {
                    visibilityInfo.f7908b = true;
                    visibilityInfo.f7907a = true;
                }
            } else if (visibilityInfo.f7912f == null) {
                visibilityInfo.f7908b = false;
                visibilityInfo.f7907a = true;
            } else if (visibilityInfo.f7911e == null) {
                visibilityInfo.f7908b = true;
                visibilityInfo.f7907a = true;
            }
        } else if (transitionValues == null && visibilityInfo.f7910d == 0) {
            visibilityInfo.f7908b = true;
            visibilityInfo.f7907a = true;
        } else if (transitionValues2 == null && visibilityInfo.f7909c == 0) {
            visibilityInfo.f7908b = false;
            visibilityInfo.f7907a = true;
        }
        return visibilityInfo;
    }

    @Override // androidx.transition.Transition
    public String[] L() {
        return Q;
    }

    @Override // androidx.transition.Transition
    public boolean N(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues != null && transitionValues2 != null && transitionValues2.f7875a.containsKey("android:visibility:visibility") != transitionValues.f7875a.containsKey("android:visibility:visibility")) {
            return false;
        }
        VisibilityInfo l02 = l0(transitionValues, transitionValues2);
        if (!l02.f7907a) {
            return false;
        }
        if (l02.f7909c != 0 && l02.f7910d != 0) {
            return false;
        }
        return true;
    }

    @Override // androidx.transition.Transition
    public void h(@NonNull TransitionValues transitionValues) {
        k0(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void k(@NonNull TransitionValues transitionValues) {
        k0(transitionValues);
    }

    public Animator m0(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public Animator n0(ViewGroup viewGroup, TransitionValues transitionValues, int i8, TransitionValues transitionValues2, int i9) {
        if ((this.P & 1) != 1 || transitionValues2 == null) {
            return null;
        }
        if (transitionValues == null) {
            View view = (View) transitionValues2.f7876b.getParent();
            if (l0(z(view, false), M(view, false)).f7907a) {
                return null;
            }
        }
        return m0(viewGroup, transitionValues2.f7876b, transitionValues, transitionValues2);
    }

    @Override // androidx.transition.Transition
    public Animator o(@NonNull ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo l02 = l0(transitionValues, transitionValues2);
        if (l02.f7907a) {
            if (l02.f7911e != null || l02.f7912f != null) {
                if (l02.f7908b) {
                    return n0(viewGroup, transitionValues, l02.f7909c, transitionValues2, l02.f7910d);
                }
                return p0(viewGroup, transitionValues, l02.f7909c, transitionValues2, l02.f7910d);
            }
            return null;
        }
        return null;
    }

    public Animator o0(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0089, code lost:
        if (r17.B != false) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.animation.Animator p0(final android.view.ViewGroup r18, androidx.transition.TransitionValues r19, int r20, androidx.transition.TransitionValues r21, int r22) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.p0(android.view.ViewGroup, androidx.transition.TransitionValues, int, androidx.transition.TransitionValues, int):android.animation.Animator");
    }

    public void q0(int i8) {
        if ((i8 & (-4)) == 0) {
            this.P = i8;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }
}
