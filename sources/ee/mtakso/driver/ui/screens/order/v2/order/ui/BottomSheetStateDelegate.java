package ee.mtakso.driver.ui.screens.order.v2.order.ui;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.order.PaymentType;
import ee.mtakso.driver.ui.screens.order.v2.order.BottomWidgetStates;
import ee.mtakso.driver.ui.screens.order.v2.order.SwipeButtonOverrideState;
import ee.mtakso.driver.ui.screens.order.v2.order.SwipeButtonState;
import ee.mtakso.driver.uicore.components.views.swipe.SwipeButton;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ImageViewExtKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.ObservableExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomSheetStateDelegate.kt */
/* loaded from: classes3.dex */
public final class BottomSheetStateDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final View f32362a;

    /* renamed from: b  reason: collision with root package name */
    private SwipeButtonState f32363b;

    /* renamed from: c  reason: collision with root package name */
    private SwipeButtonOverrideState f32364c;

    /* renamed from: d  reason: collision with root package name */
    private Disposable f32365d;

    /* renamed from: e  reason: collision with root package name */
    private PaymentType f32366e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f32367f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f32368g;

    /* renamed from: h  reason: collision with root package name */
    public Map<Integer, View> f32369h;

    /* compiled from: BottomSheetStateDelegate.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f32370a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f32371b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f32372c;

        static {
            int[] iArr = new int[PaymentType.values().length];
            try {
                iArr[PaymentType.CASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PaymentType.IN_APP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f32370a = iArr;
            int[] iArr2 = new int[SwipeButtonOverrideState.values().length];
            try {
                iArr2[SwipeButtonOverrideState.CHANGING.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[SwipeButtonOverrideState.CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            f32371b = iArr2;
            int[] iArr3 = new int[SwipeButtonState.values().length];
            try {
                iArr3[SwipeButtonState.DISCLAIMER.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[SwipeButtonState.DRIVING_TO_WAITING_POINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[SwipeButtonState.DRIVING_TO_FINAL_POINT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[SwipeButtonState.STAYING_AT_WAITING_POINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[SwipeButtonState.DRIVING_TO_PICKUP.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[SwipeButtonState.WAITING_FOR_CLIENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            f32372c = iArr3;
        }
    }

    public BottomSheetStateDelegate(View containerView) {
        Intrinsics.f(containerView, "containerView");
        this.f32369h = new LinkedHashMap();
        this.f32362a = containerView;
    }

    private final void e(SwipeButtonState swipeButtonState) {
        switch (WhenMappings.f32372c[swipeButtonState.ordinal()]) {
            case 1:
                int i8 = R.id.active_order_swipe_button;
                ((SwipeButton) c(i8)).setButtonStyle(SwipeButton.SwipeButtonStyle.Secondary);
                String string = f().getContext().getString(R.string.slide_to_waiting_point_disclaimer);
                Intrinsics.e(string, "containerView.context.ge…waiting_point_disclaimer)");
                ((SwipeButton) c(i8)).setDisclaimerText(string);
                ((SwipeButton) c(i8)).K(SwipeButton.State.DISCLAIMER, true);
                return;
            case 2:
                int i9 = R.id.active_order_swipe_button;
                ((SwipeButton) c(i9)).setButtonStyle(SwipeButton.SwipeButtonStyle.Secondary);
                String string2 = f().getContext().getString(R.string.slide_to_waiting_point_lowercase);
                Intrinsics.e(string2, "containerView.context.ge…_waiting_point_lowercase)");
                ((SwipeButton) c(i9)).setSwipeText(string2);
                ((SwipeButton) c(i9)).K(SwipeButton.State.SWIPABLE, true);
                return;
            case 3:
                int i10 = R.id.active_order_swipe_button;
                ((SwipeButton) c(i10)).setButtonStyle(SwipeButton.SwipeButtonStyle.Tertiary);
                String string3 = f().getContext().getString(R.string.slide_to_end_ride_lowercase);
                Intrinsics.e(string3, "containerView.context.ge…de_to_end_ride_lowercase)");
                ((SwipeButton) c(i10)).setSwipeText(string3);
                ((SwipeButton) c(i10)).K(SwipeButton.State.SWIPABLE, true);
                return;
            case 4:
                int i11 = R.id.active_order_swipe_button;
                ((SwipeButton) c(i11)).setButtonStyle(SwipeButton.SwipeButtonStyle.Secondary);
                String string4 = f().getContext().getString(R.string.slide_depart_from_stop_lowercase);
                Intrinsics.e(string4, "containerView.context.ge…part_from_stop_lowercase)");
                ((SwipeButton) c(i11)).setSwipeText(string4);
                ((SwipeButton) c(i11)).K(SwipeButton.State.SWIPABLE, true);
                return;
            case 5:
                int i12 = R.id.active_order_swipe_button;
                ((SwipeButton) c(i12)).setButtonStyle(SwipeButton.SwipeButtonStyle.Primary);
                String string5 = f().getContext().getString(R.string.arrived);
                Intrinsics.e(string5, "containerView.context.getString(R.string.arrived)");
                ((SwipeButton) c(i12)).setSwipeText(string5);
                ((SwipeButton) c(i12)).K(SwipeButton.State.SWIPABLE, true);
                return;
            case 6:
                int i13 = R.id.active_order_swipe_button;
                SwipeButton active_order_swipe_button = (SwipeButton) c(i13);
                Intrinsics.e(active_order_swipe_button, "active_order_swipe_button");
                SwipeButton.L(active_order_swipe_button, SwipeButton.State.SWIPABLE, false, 2, null);
                String string6 = f().getContext().getString(R.string.start_trip_lowercase);
                Intrinsics.e(string6, "containerView.context.ge…ing.start_trip_lowercase)");
                ((SwipeButton) c(i13)).setSwipeText(string6);
                ((SwipeButton) c(i13)).setButtonStyle(SwipeButton.SwipeButtonStyle.Primary);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        c(R.id.active_order_payment_method_bubble).setVisibility(8);
        this.f32368g = false;
    }

    private final void i(PaymentType paymentType) {
        int i8;
        int i9;
        int i10;
        if (WhenMappings.f32370a[paymentType.ordinal()] == 1) {
            i8 = R.string.cash;
            i9 = R.drawable.rounded_corners_green_5dp;
            i10 = R.attr.colorBgPromoHighContrast;
        } else {
            i8 = R.string.inapp;
            i9 = R.drawable.rounded_corners_red_5dp;
            i10 = R.attr.colorBgDangerHighContrast;
        }
        int i11 = R.id.paymentBubbleTypeText;
        ((TextView) c(i11)).setText(i8);
        ((TextView) c(i11)).setBackgroundResource(i9);
        TextView paymentBubbleTypeText = (TextView) c(i11);
        Intrinsics.e(paymentBubbleTypeText, "paymentBubbleTypeText");
        ViewExtKt.b(paymentBubbleTypeText, new Color.Attr(i10));
        AppCompatImageView paymentBubbleTriangle = (AppCompatImageView) c(R.id.paymentBubbleTriangle);
        Intrinsics.e(paymentBubbleTriangle, "paymentBubbleTriangle");
        ImageViewExtKt.a(paymentBubbleTriangle, new Color.Attr(i10));
        int i12 = R.id.active_order_payment_method_bubble;
        c(i12).setVisibility(0);
        c(i12).setAlpha(1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(c(i12), "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(100L);
        ofFloat.start();
        this.f32368g = true;
    }

    private final void j(PaymentType paymentType) {
        int i8;
        if (!DisposableExtKt.b(this.f32365d)) {
            return;
        }
        if (paymentType == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f32370a[paymentType.ordinal()];
        }
        if (i8 != 1 && i8 != 2) {
            g();
        } else {
            i(paymentType);
        }
        this.f32367f = true;
        Observable<Long> timer = Observable.timer(3L, TimeUnit.SECONDS);
        Intrinsics.e(timer, "timer(3, TimeUnit.SECONDS)");
        Observable f8 = ObservableExtKt.f(timer);
        final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.ui.BottomSheetStateDelegate$showPaymentTypeBubbleForTime$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Long l8) {
                BottomSheetStateDelegate.this.g();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l8) {
                b(l8);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.ui.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BottomSheetStateDelegate.k(Function1.this, obj);
            }
        };
        final BottomSheetStateDelegate$showPaymentTypeBubbleForTime$2 bottomSheetStateDelegate$showPaymentTypeBubbleForTime$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.ui.BottomSheetStateDelegate$showPaymentTypeBubbleForTime$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to hide payment method bubble");
            }
        };
        this.f32365d = f8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.order.v2.order.ui.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BottomSheetStateDelegate.l(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void n(SwipeButtonState swipeButtonState, SwipeButtonOverrideState swipeButtonOverrideState) {
        int i8;
        if (this.f32363b == swipeButtonState && this.f32364c == swipeButtonOverrideState) {
            return;
        }
        if (swipeButtonOverrideState == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f32371b[swipeButtonOverrideState.ordinal()];
        }
        if (i8 != -1) {
            if (i8 != 1) {
                if (i8 == 2) {
                    SwipeButton active_order_swipe_button = (SwipeButton) c(R.id.active_order_swipe_button);
                    Intrinsics.e(active_order_swipe_button, "active_order_swipe_button");
                    SwipeButton.L(active_order_swipe_button, SwipeButton.State.DONE, false, 2, null);
                }
            } else {
                SwipeButton active_order_swipe_button2 = (SwipeButton) c(R.id.active_order_swipe_button);
                Intrinsics.e(active_order_swipe_button2, "active_order_swipe_button");
                SwipeButton.L(active_order_swipe_button2, SwipeButton.State.LOADING, false, 2, null);
            }
        } else {
            e(swipeButtonState);
        }
        this.f32364c = swipeButtonOverrideState;
        this.f32363b = swipeButtonState;
    }

    public View c(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f32369h;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View f8 = f();
            if (f8 == null || (findViewById = f8.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    public View f() {
        return this.f32362a;
    }

    public final void h() {
        if (this.f32368g) {
            g();
        } else {
            j(this.f32366e);
        }
    }

    public final void m(BottomWidgetStates bottomSheetState) {
        Intrinsics.f(bottomSheetState, "bottomSheetState");
        PaymentType d8 = bottomSheetState.d();
        this.f32366e = d8;
        if (d8 == null) {
            g();
        } else if (!this.f32367f) {
            j(d8);
        }
        n(bottomSheetState.g(), bottomSheetState.f());
    }
}
