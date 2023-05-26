package ee.mtakso.driver.ui.views.quickaccess;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import eu.bolt.driver.core.ui.translation.TranslatedLayoutInflater;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuickAccessChatViewDelegate.kt */
/* loaded from: classes5.dex */
public final class QuickAccessChatViewDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final WindowManager f34380a;

    /* renamed from: b  reason: collision with root package name */
    private final TranslatedLayoutInflater f34381b;

    /* renamed from: c  reason: collision with root package name */
    private QuickAccessMode f34382c;

    /* renamed from: d  reason: collision with root package name */
    private View f34383d;

    /* renamed from: e  reason: collision with root package name */
    private WindowManager.LayoutParams f34384e;

    /* renamed from: f  reason: collision with root package name */
    private HorizontalExpansionPoint f34385f;

    /* renamed from: g  reason: collision with root package name */
    private VerticalExpansionPoint f34386g;

    /* renamed from: h  reason: collision with root package name */
    private Disposable f34387h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f34388i;

    /* renamed from: j  reason: collision with root package name */
    private OnOpenAppClickListener f34389j;

    /* renamed from: k  reason: collision with root package name */
    private OnChatButtonClickListener f34390k;

    /* renamed from: l  reason: collision with root package name */
    private RoundButton f34391l;

    /* compiled from: QuickAccessChatViewDelegate.kt */
    /* loaded from: classes5.dex */
    public enum HorizontalExpansionPoint {
        LEFT,
        RIGHT
    }

    /* compiled from: QuickAccessChatViewDelegate.kt */
    /* loaded from: classes5.dex */
    public enum VerticalExpansionPoint {
        TOP,
        BOTTOM
    }

    public QuickAccessChatViewDelegate(WindowManager windowManager, TranslatedLayoutInflater translatedLayoutInflater) {
        Intrinsics.f(windowManager, "windowManager");
        Intrinsics.f(translatedLayoutInflater, "translatedLayoutInflater");
        this.f34380a = windowManager;
        this.f34381b = translatedLayoutInflater;
        this.f34382c = QuickAccessMode.COLLAPSED;
        this.f34385f = HorizontalExpansionPoint.LEFT;
        this.f34386g = VerticalExpansionPoint.TOP;
    }

    private final void e(final View view, int i8) {
        float measuredWidth;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.0f);
        float f8 = 0.0f;
        if (this.f34385f == HorizontalExpansionPoint.LEFT) {
            measuredWidth = 0.0f;
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        if (this.f34386g != VerticalExpansionPoint.TOP) {
            f8 = view.getMeasuredHeight();
        }
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "pivotX", measuredWidth);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view, "pivotY", f8);
        animatorSet.setDuration(i8);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: ee.mtakso.driver.ui.views.quickaccess.QuickAccessChatViewDelegate$collapse$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.f(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.f(animation, "animation");
                view.setAlpha(0.0f);
                view.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.f(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.f(animation, "animation");
                view.setAlpha(1.0f);
                view.setVisibility(0);
            }
        });
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5);
        animatorSet.start();
    }

    static /* synthetic */ void f(QuickAccessChatViewDelegate quickAccessChatViewDelegate, View view, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 130;
        }
        quickAccessChatViewDelegate.e(view, i8);
    }

    private final WindowManager.LayoutParams g(int i8, int i9) {
        int i10;
        if (Build.VERSION.SDK_INT >= 26) {
            i10 = 2038;
        } else {
            i10 = 2002;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, i10, 8, -3);
        layoutParams.gravity = 8388659;
        layoutParams.x = i8;
        layoutParams.y = i9;
        return layoutParams;
    }

    public static /* synthetic */ void k(QuickAccessChatViewDelegate quickAccessChatViewDelegate, View view, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 130;
        }
        quickAccessChatViewDelegate.j(view, i8);
    }

    private final void m() {
        final RoundButton roundButton;
        ImageView imageView;
        if (this.f34391l != null) {
            return;
        }
        View view = this.f34383d;
        if (view != null && (imageView = (ImageView) view.findViewById(R.id.btnOpenApp)) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.views.quickaccess.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QuickAccessChatViewDelegate.n(QuickAccessChatViewDelegate.this, view2);
                }
            });
        }
        View view2 = this.f34383d;
        if (view2 != null) {
            roundButton = (RoundButton) view2.findViewById(R.id.buttonAction);
        } else {
            roundButton = null;
        }
        if (roundButton == null) {
            return;
        }
        roundButton.setEnabled(false);
        roundButton.setGravity(17);
        roundButton.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.views.quickaccess.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                QuickAccessChatViewDelegate.o(QuickAccessChatViewDelegate.this, roundButton, view3);
            }
        });
        this.f34391l = roundButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(QuickAccessChatViewDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        OnChatButtonClickListener onChatButtonClickListener = this$0.f34390k;
        if (onChatButtonClickListener != null) {
            onChatButtonClickListener.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(QuickAccessChatViewDelegate this$0, RoundButton this_apply, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(this_apply, "$this_apply");
        OnOpenAppClickListener onOpenAppClickListener = this$0.f34389j;
        if (onOpenAppClickListener != null) {
            onOpenAppClickListener.a();
        }
        this_apply.setEnabled(false);
    }

    private final void p(CharSequence charSequence) {
        TextView textView;
        View view = this.f34383d;
        if (view != null) {
            textView = (TextView) view.findViewById(R.id.tvMessage);
        } else {
            textView = null;
        }
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    private final void t(CharSequence charSequence) {
        TextView textView;
        View view = this.f34383d;
        if (view != null) {
            textView = (TextView) view.findViewById(R.id.tvTitle);
        } else {
            textView = null;
        }
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    private final void v(ActionButtonState actionButtonState) {
        RoundButton roundButton = this.f34391l;
        if (roundButton != null) {
            roundButton.setEnabled(true);
            roundButton.setBgColor(actionButtonState.a());
            roundButton.setRippleColor(actionButtonState.b());
            roundButton.setText(actionButtonState.c());
        }
    }

    @SuppressLint({"InflateParams"})
    public final View c(int i8, int i9) {
        View view = this.f34383d;
        if (view == null) {
            view = this.f34381b.inflate(R.layout.quick_access_chat_details, (ViewGroup) null);
        }
        WindowManager.LayoutParams layoutParams = this.f34384e;
        if (layoutParams == null) {
            layoutParams = g(i8, i9);
        }
        if (view.getWindowToken() == null) {
            this.f34380a.addView(view, layoutParams);
        }
        this.f34388i = true;
        view.setVisibility(8);
        this.f34383d = view;
        this.f34384e = layoutParams;
        m();
        Intrinsics.e(view, "view");
        return view;
    }

    public final void d() {
        View view = this.f34383d;
        if (view != null) {
            view.bringToFront();
        }
    }

    public final void h() {
        boolean z7;
        View view = this.f34383d;
        if (view != null) {
            if (view.getWindowToken() != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                view = null;
            }
            if (view != null) {
                this.f34380a.removeView(view);
            }
        }
        this.f34388i = false;
        Disposable disposable = this.f34387h;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final void i(QuickAccessDetailsState quickAccessDetailsState) {
        if (quickAccessDetailsState == null) {
            return;
        }
        t(quickAccessDetailsState.g());
        p(quickAccessDetailsState.b());
        v(quickAccessDetailsState.a());
    }

    public final void j(final View view, int i8) {
        float measuredWidth;
        Intrinsics.f(view, "view");
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "scaleY", 0.0f, 1.0f);
        float f8 = 0.0f;
        if (this.f34385f == HorizontalExpansionPoint.LEFT) {
            measuredWidth = 0.0f;
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        if (this.f34386g != VerticalExpansionPoint.TOP) {
            f8 = view.getMeasuredHeight();
        }
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "pivotX", measuredWidth);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view, "pivotY", f8);
        animatorSet.setDuration(i8);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: ee.mtakso.driver.ui.views.quickaccess.QuickAccessChatViewDelegate$expand$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.f(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.f(animation, "animation");
                view.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.f(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.f(animation, "animation");
                view.setAlpha(0.0f);
                view.setVisibility(0);
            }
        });
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5);
        animatorSet.start();
    }

    public final boolean l() {
        boolean z7;
        View view;
        View view2 = this.f34383d;
        if (view2 != null && view2.getVisibility() == 8) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7 && (view = this.f34383d) != null) {
            f(this, view, 0, 2, null);
        }
        return true;
    }

    public final void q(QuickAccessMode quickAccessMode) {
        Intrinsics.f(quickAccessMode, "<set-?>");
        this.f34382c = quickAccessMode;
    }

    public final void r(OnChatButtonClickListener onChatButtonClickListener) {
        this.f34390k = onChatButtonClickListener;
    }

    public final void s(OnOpenAppClickListener onOpenAppClickListener) {
        this.f34389j = onOpenAppClickListener;
    }

    public final boolean u() {
        boolean z7;
        View view;
        View view2 = this.f34383d;
        if (view2 == null) {
            return false;
        }
        if (view2 != null && view2.getVisibility() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7 || (view = this.f34383d) == null) {
            return true;
        }
        k(this, view, 0, 2, null);
        return true;
    }

    public final void w(int i8, int i9) {
        WindowManager.LayoutParams layoutParams;
        if (!this.f34388i || (layoutParams = this.f34384e) == null) {
            return;
        }
        layoutParams.x = i8;
        layoutParams.y = i9;
        View view = this.f34383d;
        if (view != null) {
            this.f34380a.updateViewLayout(view, layoutParams);
        }
    }
}
