package ee.mtakso.driver.ui.views.quickaccess;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uicore.components.drawables.IndeterminateCircularProgressDrawable;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.TimeUtils;
import eu.bolt.driver.core.ui.translation.TranslatedLayoutInflater;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: QuickAccessDetailsViewDelegate.kt */
/* loaded from: classes5.dex */
public final class QuickAccessDetailsViewDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final Context f34442a;

    /* renamed from: b  reason: collision with root package name */
    private final WindowManager f34443b;

    /* renamed from: c  reason: collision with root package name */
    private final TranslatedLayoutInflater f34444c;

    /* renamed from: d  reason: collision with root package name */
    private QuickAccessMode f34445d;

    /* renamed from: e  reason: collision with root package name */
    private View f34446e;

    /* renamed from: f  reason: collision with root package name */
    private WindowManager.LayoutParams f34447f;

    /* renamed from: g  reason: collision with root package name */
    private HorizontalExpansionPoint f34448g;

    /* renamed from: h  reason: collision with root package name */
    private VerticalExpansionPoint f34449h;

    /* renamed from: i  reason: collision with root package name */
    private Disposable f34450i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f34451j;

    /* renamed from: k  reason: collision with root package name */
    private OnOpenAppClickListener f34452k;

    /* renamed from: l  reason: collision with root package name */
    private OnChangeStateButtonClickListener f34453l;

    /* renamed from: m  reason: collision with root package name */
    private RoundButton f34454m;

    /* renamed from: n  reason: collision with root package name */
    private RoundButton f34455n;

    /* renamed from: o  reason: collision with root package name */
    private Group f34456o;

    /* renamed from: p  reason: collision with root package name */
    private Group f34457p;

    /* compiled from: QuickAccessDetailsViewDelegate.kt */
    /* loaded from: classes5.dex */
    public enum HorizontalExpansionPoint {
        LEFT,
        RIGHT
    }

    /* compiled from: QuickAccessDetailsViewDelegate.kt */
    /* loaded from: classes5.dex */
    public enum VerticalExpansionPoint {
        TOP,
        BOTTOM
    }

    /* compiled from: QuickAccessDetailsViewDelegate.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f34464a;

        static {
            int[] iArr = new int[QuickAccessTimerTarget.values().length];
            try {
                iArr[QuickAccessTimerTarget.TITLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[QuickAccessTimerTarget.SUBTITLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f34464a = iArr;
        }
    }

    public QuickAccessDetailsViewDelegate(Context context, WindowManager windowManager, TranslatedLayoutInflater translatedLayoutInflater) {
        Intrinsics.f(context, "context");
        Intrinsics.f(windowManager, "windowManager");
        Intrinsics.f(translatedLayoutInflater, "translatedLayoutInflater");
        this.f34442a = context;
        this.f34443b = windowManager;
        this.f34444c = translatedLayoutInflater;
        this.f34445d = QuickAccessMode.COLLAPSED;
        this.f34448g = HorizontalExpansionPoint.LEFT;
        this.f34449h = VerticalExpansionPoint.TOP;
    }

    private final void A(boolean z7) {
        if (z7) {
            RoundButton roundButton = this.f34454m;
            if (roundButton != null) {
                roundButton.h();
            }
            RoundButton roundButton2 = this.f34454m;
            if (roundButton2 != null) {
                roundButton2.j();
                return;
            }
            return;
        }
        RoundButton roundButton3 = this.f34454m;
        if (roundButton3 != null) {
            roundButton3.l();
        }
        RoundButton roundButton4 = this.f34454m;
        if (roundButton4 != null) {
            roundButton4.f();
        }
    }

    private final void B(CharSequence charSequence) {
        TextView textView;
        View view = this.f34446e;
        if (view != null) {
            textView = (TextView) view.findViewById(R.id.tvDetails1);
        } else {
            textView = null;
        }
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    private final void G(CharSequence charSequence) {
        TextView textView;
        View view = this.f34446e;
        if (view != null) {
            textView = (TextView) view.findViewById(R.id.tvDetails2);
        } else {
            textView = null;
        }
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    private final void H(CharSequence charSequence) {
        TextView textView;
        View view = this.f34446e;
        if (view != null) {
            textView = (TextView) view.findViewById(R.id.tvTitle);
        } else {
            textView = null;
        }
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    private final void K(final long j8, final TextView textView, final String str, final boolean z7) {
        Disposable disposable = this.f34450i;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Observable<Long> interval = Observable.interval(0L, 1L, TimeUnit.SECONDS);
        final Function1<Long, Long> function1 = new Function1<Long, Long>() { // from class: ee.mtakso.driver.ui.views.quickaccess.QuickAccessDetailsViewDelegate$startTimer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Long invoke(Long it) {
                long longValue;
                Intrinsics.f(it, "it");
                if (z7) {
                    longValue = j8 - it.longValue();
                } else {
                    longValue = j8 + it.longValue();
                }
                return Long.valueOf(longValue);
            }
        };
        Observable observeOn = interval.map(new Function() { // from class: ee.mtakso.driver.ui.views.quickaccess.i
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Long M;
                M = QuickAccessDetailsViewDelegate.M(Function1.this, obj);
                return M;
            }
        }).observeOn(AndroidSchedulers.a());
        final Function1<Long, Unit> function12 = new Function1<Long, Unit>() { // from class: ee.mtakso.driver.ui.views.quickaccess.QuickAccessDetailsViewDelegate$startTimer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(Long it) {
                String a8;
                Intrinsics.e(it, "it");
                if (it.longValue() < 0) {
                    a8 = TimeUtils.a(0L);
                } else {
                    a8 = TimeUtils.a(it.longValue());
                }
                TextView textView2 = textView;
                StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
                String str2 = str;
                if (str2 == null) {
                    str2 = "%s";
                }
                String format = String.format(str2, Arrays.copyOf(new Object[]{a8}, 1));
                Intrinsics.e(format, "format(format, *args)");
                textView2.setText(format);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l8) {
                b(l8);
                return Unit.f50853a;
            }
        };
        this.f34450i = observeOn.subscribe(new Consumer() { // from class: ee.mtakso.driver.ui.views.quickaccess.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                QuickAccessDetailsViewDelegate.N(Function1.this, obj);
            }
        });
    }

    private final void L(QuickAccessTimerState quickAccessTimerState) {
        TextView r7;
        Disposable disposable = this.f34450i;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        int i8 = WhenMappings.f34464a[quickAccessTimerState.b().ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                r7 = p();
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            r7 = r();
        }
        TextView textView = r7;
        if (textView == null) {
            return;
        }
        K(quickAccessTimerState.c(), textView, quickAccessTimerState.a(), quickAccessTimerState.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long M(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Long) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void O(ActionButtonState actionButtonState) {
        RoundButton roundButton = this.f34454m;
        if (roundButton != null) {
            roundButton.setEnabled(true);
            roundButton.setBgColor(actionButtonState.a());
            roundButton.setRippleColor(actionButtonState.b());
            roundButton.setText(actionButtonState.c());
        }
    }

    private final void P(PaidWaitingButtonState paidWaitingButtonState) {
        RoundButton roundButton;
        boolean z7;
        Group group = this.f34456o;
        boolean z8 = true;
        if (group != null) {
            if (paidWaitingButtonState != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            ViewExtKt.e(group, z7, 0, 2, null);
        }
        Group group2 = this.f34457p;
        if (group2 != null) {
            ViewExtKt.e(group2, (paidWaitingButtonState == null || !paidWaitingButtonState.b()) ? false : false, 0, 2, null);
        }
        if (paidWaitingButtonState != null && (roundButton = this.f34455n) != null) {
            roundButton.b(paidWaitingButtonState.a());
            roundButton.setClickable(paidWaitingButtonState.c());
        }
    }

    private final void g() {
        Disposable disposable = this.f34450i;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
    }

    private final void h(final View view, int i8) {
        float measuredWidth;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.0f);
        float f8 = 0.0f;
        if (this.f34448g == HorizontalExpansionPoint.LEFT) {
            measuredWidth = 0.0f;
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        if (this.f34449h != VerticalExpansionPoint.TOP) {
            f8 = view.getMeasuredHeight();
        }
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "pivotX", measuredWidth);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view, "pivotY", f8);
        animatorSet.setDuration(i8);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: ee.mtakso.driver.ui.views.quickaccess.QuickAccessDetailsViewDelegate$collapse$1
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

    static /* synthetic */ void i(QuickAccessDetailsViewDelegate quickAccessDetailsViewDelegate, View view, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 130;
        }
        quickAccessDetailsViewDelegate.h(view, i8);
    }

    private final WindowManager.LayoutParams j(int i8, int i9) {
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

    private final void m(QuickAccessRatingState quickAccessRatingState) {
        TextView textView;
        ImageView imageView;
        TextView textView2;
        boolean z7;
        boolean z8;
        TextView textView3;
        boolean z9;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        boolean z10;
        View view = this.f34446e;
        boolean z11 = true;
        if (view != null && (linearLayout3 = (LinearLayout) view.findViewById(R.id.containerRatingRides)) != null) {
            if (quickAccessRatingState != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            ViewExtKt.e(linearLayout3, z10, 0, 2, null);
        }
        if (quickAccessRatingState == null) {
            return;
        }
        String a8 = quickAccessRatingState.a();
        String b8 = quickAccessRatingState.b();
        if (a8 == null && b8 == null) {
            View view2 = this.f34446e;
            if (view2 != null && (linearLayout2 = (LinearLayout) view2.findViewById(R.id.containerRatingRides)) != null) {
                ViewExtKt.e(linearLayout2, false, 0, 2, null);
                return;
            }
            return;
        }
        View view3 = this.f34446e;
        if (view3 != null && (linearLayout = (LinearLayout) view3.findViewById(R.id.containerRatingRides)) != null) {
            ViewExtKt.e(linearLayout, true, 0, 2, null);
        }
        View view4 = this.f34446e;
        if (view4 != null && (textView3 = (TextView) view4.findViewById(R.id.f169clientRatingSeparator)) != null) {
            if (a8 != null && b8 != null) {
                z9 = true;
            } else {
                z9 = false;
            }
            ViewExtKt.e(textView3, z9, 0, 2, null);
        }
        View view5 = this.f34446e;
        if (view5 != null) {
            textView = (TextView) view5.findViewById(R.id.f167clientRating);
        } else {
            textView = null;
        }
        View view6 = this.f34446e;
        if (view6 != null) {
            imageView = (ImageView) view6.findViewById(R.id.f168clientRatingAsterisk);
        } else {
            imageView = null;
        }
        View view7 = this.f34446e;
        if (view7 != null) {
            textView2 = (TextView) view7.findViewById(R.id.f171clientRidesCount);
        } else {
            textView2 = null;
        }
        if (textView != null) {
            if (a8 != null) {
                z8 = true;
            } else {
                z8 = false;
            }
            ViewExtKt.e(textView, z8, 0, 2, null);
        }
        if (imageView != null) {
            if (a8 != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            ViewExtKt.e(imageView, z7, 0, 2, null);
        }
        if (textView != null) {
            textView.setText(String.valueOf(a8));
        }
        if (textView2 != null) {
            if (b8 == null) {
                z11 = false;
            }
            ViewExtKt.e(textView2, z11, 0, 2, null);
        }
        if (textView2 != null) {
            textView2.setText(b8);
        }
    }

    public static /* synthetic */ void o(QuickAccessDetailsViewDelegate quickAccessDetailsViewDelegate, View view, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 130;
        }
        quickAccessDetailsViewDelegate.n(view, i8);
    }

    private final TextView p() {
        View view = this.f34446e;
        if (view != null) {
            return (TextView) view.findViewById(R.id.tvDetails1);
        }
        return null;
    }

    private final TextView r() {
        View view = this.f34446e;
        if (view != null) {
            return (TextView) view.findViewById(R.id.tvTitle);
        }
        return null;
    }

    private final void u() {
        final RoundButton roundButton;
        Group group;
        Group group2;
        ImageView imageView;
        if (this.f34454m != null) {
            return;
        }
        View view = this.f34446e;
        if (view != null && (imageView = (ImageView) view.findViewById(R.id.btnOpenApp)) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.views.quickaccess.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QuickAccessDetailsViewDelegate.x(QuickAccessDetailsViewDelegate.this, view2);
                }
            });
        }
        View view2 = this.f34446e;
        final RoundButton roundButton2 = null;
        if (view2 != null) {
            roundButton = (RoundButton) view2.findViewById(R.id.buttonPaidWaiting);
        } else {
            roundButton = null;
        }
        if (roundButton == null) {
            return;
        }
        roundButton.b(R.drawable.ic_wait_purple);
        roundButton.setGravity(17);
        roundButton.h();
        roundButton.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.views.quickaccess.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                QuickAccessDetailsViewDelegate.v(QuickAccessDetailsViewDelegate.this, roundButton, roundButton, view3);
            }
        });
        this.f34455n = roundButton;
        View view3 = this.f34446e;
        if (view3 != null) {
            group = (Group) view3.findViewById(R.id.tooltipGroup);
        } else {
            group = null;
        }
        this.f34457p = group;
        View view4 = this.f34446e;
        if (view4 != null) {
            group2 = (Group) view4.findViewById(R.id.buttonPaidWaitingGroup);
        } else {
            group2 = null;
        }
        this.f34456o = group2;
        View view5 = this.f34446e;
        if (view5 != null) {
            roundButton2 = (RoundButton) view5.findViewById(R.id.buttonAction);
        }
        if (roundButton2 == null) {
            return;
        }
        roundButton2.c(z(ContextCompat.getColor(roundButton2.getContext(), R.color.white400)));
        roundButton2.setGravity(17);
        roundButton2.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.views.quickaccess.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view6) {
                QuickAccessDetailsViewDelegate.w(QuickAccessDetailsViewDelegate.this, roundButton2, roundButton, view6);
            }
        });
        this.f34454m = roundButton2;
        A(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(QuickAccessDetailsViewDelegate this$0, RoundButton this_apply, RoundButton paidWaitingButton, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(this_apply, "$this_apply");
        Intrinsics.f(paidWaitingButton, "$paidWaitingButton");
        OnChangeStateButtonClickListener onChangeStateButtonClickListener = this$0.f34453l;
        if (onChangeStateButtonClickListener != null) {
            onChangeStateButtonClickListener.a();
        }
        this_apply.c(this$0.z(ContextCompat.getColor(this_apply.getContext(), R.color.blackSemiProgressBar)));
        paidWaitingButton.setClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(QuickAccessDetailsViewDelegate this$0, RoundButton actionButton, RoundButton paidWaitingButton, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(actionButton, "$actionButton");
        Intrinsics.f(paidWaitingButton, "$paidWaitingButton");
        OnChangeStateButtonClickListener onChangeStateButtonClickListener = this$0.f34453l;
        if (onChangeStateButtonClickListener != null) {
            onChangeStateButtonClickListener.b();
        }
        actionButton.setEnabled(false);
        this$0.A(true);
        paidWaitingButton.setClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(QuickAccessDetailsViewDelegate this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        OnOpenAppClickListener onOpenAppClickListener = this$0.f34452k;
        if (onOpenAppClickListener != null) {
            onOpenAppClickListener.a();
        }
    }

    private final Drawable z(int i8) {
        IndeterminateCircularProgressDrawable indeterminateCircularProgressDrawable = new IndeterminateCircularProgressDrawable();
        indeterminateCircularProgressDrawable.i(i8);
        indeterminateCircularProgressDrawable.start();
        return indeterminateCircularProgressDrawable;
    }

    public final void C(HorizontalExpansionPoint horizontalExpansionPoint) {
        Intrinsics.f(horizontalExpansionPoint, "<set-?>");
        this.f34448g = horizontalExpansionPoint;
    }

    public final void D(QuickAccessMode quickAccessMode) {
        Intrinsics.f(quickAccessMode, "<set-?>");
        this.f34445d = quickAccessMode;
    }

    public final void E(OnChangeStateButtonClickListener onChangeStateButtonClickListener) {
        this.f34453l = onChangeStateButtonClickListener;
    }

    public final void F(OnOpenAppClickListener onOpenAppClickListener) {
        this.f34452k = onOpenAppClickListener;
    }

    public final void I(VerticalExpansionPoint verticalExpansionPoint) {
        Intrinsics.f(verticalExpansionPoint, "<set-?>");
        this.f34449h = verticalExpansionPoint;
    }

    public final boolean J() {
        boolean z7;
        View view;
        View view2 = this.f34446e;
        if (view2 == null) {
            return false;
        }
        if (view2 != null && view2.getVisibility() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7 && (view = this.f34446e) != null) {
            o(this, view, 0, 2, null);
        }
        return true;
    }

    public final void Q(int i8, int i9) {
        WindowManager.LayoutParams layoutParams;
        if (!this.f34451j || (layoutParams = this.f34447f) == null) {
            return;
        }
        layoutParams.x = i8;
        layoutParams.y = i9;
        View view = this.f34446e;
        if (view != null) {
            this.f34443b.updateViewLayout(view, layoutParams);
        }
    }

    @SuppressLint({"InflateParams"})
    public final View f(int i8, int i9) {
        View view = this.f34446e;
        if (view == null) {
            view = this.f34444c.inflate(R.layout.quick_access_details, (ViewGroup) null);
        }
        WindowManager.LayoutParams layoutParams = this.f34447f;
        if (layoutParams == null) {
            layoutParams = j(i8, i9);
        }
        if (view.getWindowToken() == null) {
            this.f34443b.addView(view, layoutParams);
        }
        this.f34451j = true;
        view.setVisibility(8);
        this.f34446e = view;
        this.f34447f = layoutParams;
        u();
        Intrinsics.e(view, "view");
        return view;
    }

    public final void k() {
        boolean z7;
        View view = this.f34446e;
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
                this.f34443b.removeView(view);
            }
        }
        this.f34451j = false;
        Disposable disposable = this.f34450i;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final void l(QuickAccessDetailsState quickAccessDetailsState) {
        A(false);
        if (quickAccessDetailsState == null) {
            return;
        }
        H(quickAccessDetailsState.g());
        B(quickAccessDetailsState.b());
        G(quickAccessDetailsState.e());
        m(quickAccessDetailsState.d());
        O(quickAccessDetailsState.a());
        P(quickAccessDetailsState.c());
        if (quickAccessDetailsState.f() == null) {
            g();
        } else {
            L(quickAccessDetailsState.f());
        }
    }

    public final void n(final View view, int i8) {
        float measuredWidth;
        Intrinsics.f(view, "view");
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "scaleY", 0.0f, 1.0f);
        float f8 = 0.0f;
        if (this.f34448g == HorizontalExpansionPoint.LEFT) {
            measuredWidth = 0.0f;
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        if (this.f34449h != VerticalExpansionPoint.TOP) {
            f8 = view.getMeasuredHeight();
        }
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "pivotX", measuredWidth);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view, "pivotY", f8);
        animatorSet.setDuration(i8);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: ee.mtakso.driver.ui.views.quickaccess.QuickAccessDetailsViewDelegate$expand$1
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

    public final WindowManager.LayoutParams q() {
        return this.f34447f;
    }

    public final View s() {
        return this.f34446e;
    }

    public final boolean t() {
        boolean z7;
        View view;
        View view2 = this.f34446e;
        if (view2 != null && view2.getVisibility() == 8) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7 && (view = this.f34446e) != null) {
            i(this, view, 0, 2, null);
        }
        return true;
    }

    public final boolean y() {
        View view = this.f34446e;
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        return true;
    }
}
