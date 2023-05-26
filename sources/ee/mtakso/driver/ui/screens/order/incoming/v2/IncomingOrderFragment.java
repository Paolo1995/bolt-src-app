package ee.mtakso.driver.ui.screens.order.incoming.v2;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.format.DateUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.text.TextUtilsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.chip.ChipGroup;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.order.Label;
import ee.mtakso.driver.network.client.order.LabelSeverity;
import ee.mtakso.driver.network.client.order.OptionalRideInfo;
import ee.mtakso.driver.network.client.order.Order;
import ee.mtakso.driver.network.client.order.OrderKt;
import ee.mtakso.driver.network.client.order.PaymentType;
import ee.mtakso.driver.network.client.order.RejectOrderResponse;
import ee.mtakso.driver.network.client.order.RejectReason;
import ee.mtakso.driver.network.client.order.RejectResponseType;
import ee.mtakso.driver.network.client.settings.AutoOrderAcceptance;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.geo.route.Route;
import ee.mtakso.driver.service.modules.order.SeparatedAddress;
import ee.mtakso.driver.service.modules.order.v2.OrderStateChange;
import ee.mtakso.driver.service.modules.order.v2.OrderStateChangeError;
import ee.mtakso.driver.service.modules.order.v2.OrderStateChangeProgress;
import ee.mtakso.driver.service.modules.order.v2.OrderStateChangeSuccess;
import ee.mtakso.driver.service.modules.order.v2.OrderStateChangeSuccessWithData;
import ee.mtakso.driver.service.modules.order.v2.OrderStateChangeType;
import ee.mtakso.driver.service.modules.order.v2.OrderTracker;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.ObservableLiveData;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.SingleLiveData;
import ee.mtakso.driver.ui.helper.LoadingDialogDelegate;
import ee.mtakso.driver.ui.interactor.order.IncomingOrderData;
import ee.mtakso.driver.ui.interactor.order.IncomingOrderDetails;
import ee.mtakso.driver.ui.interactor.order.incoming.IncomingOrderRoute;
import ee.mtakso.driver.ui.notification.UiNotificationManager;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.order.cancel.TripCancellationBottomSheetFragment;
import ee.mtakso.driver.ui.screens.order.incoming.UserRatingSpan;
import ee.mtakso.driver.ui.screens.order.incoming.v2.map.IncomingOrderMapFragment;
import ee.mtakso.driver.ui.utils.chip.ChipHelper;
import ee.mtakso.driver.uicore.components.views.order_stops_view.ItemType;
import ee.mtakso.driver.uicore.components.views.order_stops_view.OrderStopsView;
import ee.mtakso.driver.uicore.components.views.order_stops_view.Stop;
import ee.mtakso.driver.uicore.utils.AlphaAnimatorHelper;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.SpannableStringBuilderUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.Animators;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.utils.NumberUtils;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment;
import eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback;
import eu.bolt.driver.core.ui.common.dialog.CancellationDialog;
import eu.bolt.kalev.Kalev;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: IncomingOrderFragment.kt */
/* loaded from: classes3.dex */
public final class IncomingOrderFragment extends BazeMvvmFragment<IncomingOrderViewModel> {
    public static final Companion C = new Companion(null);
    private final Lazy A;
    public Map<Integer, View> B;

    /* renamed from: o  reason: collision with root package name */
    private final OrderTracker f31360o;

    /* renamed from: p  reason: collision with root package name */
    private final TrueTimeProvider f31361p;

    /* renamed from: q  reason: collision with root package name */
    private final FragmentFactory f31362q;

    /* renamed from: r  reason: collision with root package name */
    private final IncomingOrderSoundController f31363r;

    /* renamed from: s  reason: collision with root package name */
    private final HtmlEngine f31364s;

    /* renamed from: t  reason: collision with root package name */
    private final UiNotificationManager f31365t;

    /* renamed from: u  reason: collision with root package name */
    private final DriverProvider f31366u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f31367v;

    /* renamed from: w  reason: collision with root package name */
    private ObjectAnimator f31368w;

    /* renamed from: x  reason: collision with root package name */
    private Animator f31369x;

    /* renamed from: y  reason: collision with root package name */
    private final IncomingOrderFragment$cancelDialogCallback$1 f31370y;

    /* renamed from: z  reason: collision with root package name */
    private final Lazy f31371z;

    /* compiled from: IncomingOrderFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            if (TextUtilsCompat.a(Locale.getDefault()) != 0) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: IncomingOrderFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31374a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f31375b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f31376c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ int[] f31377d;

        static {
            int[] iArr = new int[OrderStateChangeType.values().length];
            try {
                iArr[OrderStateChangeType.ACCEPT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OrderStateChangeType.CANCEL_CURRENT_ORDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f31374a = iArr;
            int[] iArr2 = new int[IncomingOrderStyle.values().length];
            try {
                iArr2[IncomingOrderStyle.ACTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[IncomingOrderStyle.PRIMARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[IncomingOrderStyle.NEUTRAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            f31375b = iArr2;
            int[] iArr3 = new int[LabelSeverity.values().length];
            try {
                iArr3[LabelSeverity.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[LabelSeverity.HIGH.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[LabelSeverity.MEDIUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            f31376c = iArr3;
            int[] iArr4 = new int[PaymentType.values().length];
            try {
                iArr4[PaymentType.CASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr4[PaymentType.IN_APP.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr4[PaymentType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            f31377d = iArr4;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r8v1, types: [ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderFragment$cancelDialogCallback$1] */
    @Inject
    public IncomingOrderFragment(BaseUiDependencies deps, OrderTracker orderTracker, TrueTimeProvider trueTimeProvider, FragmentFactory fragmentFactory, IncomingOrderSoundController incomingSoundDelegate, HtmlEngine htmlEngine, UiNotificationManager uiNotificationManager, DriverProvider driverProvider) {
        super(deps, R.layout.activity_new_order, null, 4, null);
        Lazy b8;
        Lazy b9;
        Intrinsics.f(deps, "deps");
        Intrinsics.f(orderTracker, "orderTracker");
        Intrinsics.f(trueTimeProvider, "trueTimeProvider");
        Intrinsics.f(fragmentFactory, "fragmentFactory");
        Intrinsics.f(incomingSoundDelegate, "incomingSoundDelegate");
        Intrinsics.f(htmlEngine, "htmlEngine");
        Intrinsics.f(uiNotificationManager, "uiNotificationManager");
        Intrinsics.f(driverProvider, "driverProvider");
        this.B = new LinkedHashMap();
        this.f31360o = orderTracker;
        this.f31361p = trueTimeProvider;
        this.f31362q = fragmentFactory;
        this.f31363r = incomingSoundDelegate;
        this.f31364s = htmlEngine;
        this.f31365t = uiNotificationManager;
        this.f31366u = driverProvider;
        this.f31370y = new DefaultDialogCallback() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderFragment$cancelDialogCallback$1
            @Override // eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback, eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void a(BaseDialogFragment dialog, View view, Object payload) {
                OrderTracker orderTracker2;
                IncomingOrderViewModel M;
                RejectOrderResponse B0;
                List<RejectReason> list;
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(view, "view");
                Intrinsics.f(payload, "payload");
                if (Intrinsics.a(payload, "positive")) {
                    orderTracker2 = IncomingOrderFragment.this.f31360o;
                    orderTracker2.o();
                    IncomingOrderFragment incomingOrderFragment = IncomingOrderFragment.this;
                    M = incomingOrderFragment.M();
                    B0 = incomingOrderFragment.B0(M.R().f());
                    if (B0 != null) {
                        list = B0.b();
                    } else {
                        list = null;
                    }
                    if (list != null) {
                        IncomingOrderFragment.this.O0(list);
                    } else {
                        Kalev.m(new IllegalArgumentException("Reason list is empty"), "Reason list is empty");
                    }
                }
            }
        };
        b8 = LazyKt__LazyJVMKt.b(new Function0<ChipHelper>() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderFragment$chipHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ChipHelper invoke() {
                Context requireContext = IncomingOrderFragment.this.requireContext();
                Intrinsics.e(requireContext, "requireContext()");
                return new ChipHelper(requireContext);
            }
        });
        this.f31371z = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<Typeface>() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderFragment$robotoBoldTypeface$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Typeface invoke() {
                Typeface h8 = ResourcesCompat.h(IncomingOrderFragment.this.requireContext(), R.font.euclid_circular_b_bold);
                if (h8 != null) {
                    return h8;
                }
                throw new IllegalStateException("Required value was null.".toString());
            }
        });
        this.A = b9;
    }

    @SuppressLint({"RtlHardcoded"})
    private final SpannableStringBuilder A0(Order order, String str, String str2, double d8) {
        boolean z7;
        String ratingString = NumberUtils.a(Double.valueOf(d8));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        IncomingOrderStyle a8 = AcceptanceBlockAppearanceExtKt.a(order);
        if (str2.length() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            Color j8 = a8.j();
            Context requireContext = requireContext();
            Intrinsics.e(requireContext, "requireContext()");
            SpannableStringBuilderUtils.a(spannableStringBuilder, "  •  ", new StyleSpan(1), new ForegroundColorSpan(ColorKt.a(j8, requireContext)));
        }
        spannableStringBuilder.append((CharSequence) str);
        if (C.a()) {
            spannableStringBuilder.append((CharSequence) " ");
            Intrinsics.e(ratingString, "ratingString");
            Context requireContext2 = requireContext();
            Intrinsics.e(requireContext2, "requireContext()");
            Color h8 = a8.h();
            Context requireContext3 = requireContext();
            Intrinsics.e(requireContext3, "requireContext()");
            int a9 = ColorKt.a(h8, requireContext3);
            Typeface robotoBoldTypeface = E0();
            Intrinsics.e(robotoBoldTypeface, "robotoBoldTypeface");
            SpannableStringBuilderUtils.a(spannableStringBuilder, ratingString, new UserRatingSpan(requireContext2, R.drawable.ic_new_order_client_rating, a9, robotoBoldTypeface, 3, Dimens.d(8)));
        } else {
            Intrinsics.e(ratingString, "ratingString");
            Context requireContext4 = requireContext();
            Intrinsics.e(requireContext4, "requireContext()");
            Color h9 = a8.h();
            Context requireContext5 = requireContext();
            Intrinsics.e(requireContext5, "requireContext()");
            int a10 = ColorKt.a(h9, requireContext5);
            Typeface robotoBoldTypeface2 = E0();
            Intrinsics.e(robotoBoldTypeface2, "robotoBoldTypeface");
            SpannableStringBuilderUtils.a(spannableStringBuilder, ratingString, new UserRatingSpan(requireContext4, R.drawable.ic_new_order_client_rating, a10, robotoBoldTypeface2, 5, Dimens.d(8)));
            spannableStringBuilder.append((CharSequence) " ");
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RejectOrderResponse B0(OrderStateChange orderStateChange) {
        OrderStateChangeSuccessWithData orderStateChangeSuccessWithData;
        Object obj;
        if (orderStateChange instanceof OrderStateChangeSuccessWithData) {
            orderStateChangeSuccessWithData = (OrderStateChangeSuccessWithData) orderStateChange;
        } else {
            orderStateChangeSuccessWithData = null;
        }
        if (orderStateChangeSuccessWithData != null) {
            obj = orderStateChangeSuccessWithData.b();
        } else {
            obj = null;
        }
        if (!(obj instanceof RejectOrderResponse)) {
            return null;
        }
        return (RejectOrderResponse) obj;
    }

    private final ChipHelper C0() {
        return (ChipHelper) this.f31371z.getValue();
    }

    private final LoadingDialogDelegate D0() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        return new LoadingDialogDelegate(requireActivity);
    }

    private final Typeface E0() {
        return (Typeface) this.A.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K0(String str) {
        int i8 = R.id.new_order_distance_text;
        ((TextView) Z(i8)).setText(str);
        ((TextView) Z(i8)).setVisibility(0);
    }

    private final void L0(List<Label> list) {
        int i8;
        if (list != null) {
            for (Label label : list) {
                String a8 = label.a();
                int i9 = WhenMappings.f31376c[label.b().ordinal()];
                if (i9 != 1) {
                    if (i9 != 2) {
                        if (i9 == 3) {
                            i8 = R.attr.colorBgPromoHighContrast;
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        i8 = R.attr.colorBgDangerHighContrast;
                    }
                } else {
                    i8 = R.attr.dynamicNeutral03;
                }
                if (a8 != null) {
                    ChipHelper C0 = C0();
                    ChipGroup chipGroup = (ChipGroup) Z(R.id.chipGroup);
                    Intrinsics.e(chipGroup, "chipGroup");
                    ChipHelper.f(C0, chipGroup, a8, i8, label.c(), 0.0f, 16, null);
                } else {
                    ChipHelper C02 = C0();
                    ChipGroup chipGroup2 = (ChipGroup) Z(R.id.chipGroup);
                    Intrinsics.e(chipGroup2, "chipGroup");
                    ChipHelper.e(C02, chipGroup2, i8, label.c(), 0.0f, null, 24, null);
                }
            }
        }
    }

    private final void M0(Label label) {
        if (label == null) {
            return;
        }
        int i8 = WhenMappings.f31376c[label.b().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                ChipHelper C0 = C0();
                ChipGroup chipGroup = (ChipGroup) Z(R.id.chipGroup);
                Intrinsics.e(chipGroup, "chipGroup");
                ChipHelper.e(C0, chipGroup, R.attr.colorBgPromoHighContrast, label.c(), 0.0f, null, 24, null);
                LabelSeverity b8 = label.b();
                Kalev.d("Unexpected surge level: " + b8);
                return;
            }
            ChipHelper C02 = C0();
            ChipGroup chipGroup2 = (ChipGroup) Z(R.id.chipGroup);
            Intrinsics.e(chipGroup2, "chipGroup");
            ChipHelper.d(C02, chipGroup2, R.drawable.ic_surge_white, R.attr.colorBgDangerHighContrast, label.c(), 0.0f, 16, null);
            return;
        }
        ChipHelper C03 = C0();
        ChipGroup chipGroup3 = (ChipGroup) Z(R.id.chipGroup);
        Intrinsics.e(chipGroup3, "chipGroup");
        ChipHelper.d(C03, chipGroup3, R.drawable.ic_surge_down, R.attr.dynamicNeutral03, label.c(), 0.0f, 16, null);
    }

    private final void N0(CharSequence charSequence) {
        if (getChildFragmentManager().findFragmentByTag("confirm_cancellation") != null) {
            return;
        }
        CancellationDialog.Companion companion = CancellationDialog.f41073m;
        String string = getString(R.string.cancel_warning_title);
        Intrinsics.e(string, "getString(R.string.cancel_warning_title)");
        String string2 = getString(R.string.cancel_order_warning_confirm);
        Intrinsics.e(string2, "getString(R.string.cancel_order_warning_confirm)");
        String string3 = getString(R.string.cancel_order_warning_dont_cancel);
        Intrinsics.e(string3, "getString(R.string.cance…rder_warning_dont_cancel)");
        FragmentUtils.b(companion.a(string, charSequence, string2, string3, this.f31370y), this, "confirm_cancellation");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O0(List<RejectReason> list) {
        if (getChildFragmentManager().findFragmentByTag("cancellation_reasons") != null) {
            return;
        }
        FragmentFactory fragmentFactory = this.f31362q;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        FragmentUtils.b((TripCancellationBottomSheetFragment) FragmentFactoryUtils.b(fragmentFactory, requireContext, TripCancellationBottomSheetFragment.class, TripCancellationBottomSheetFragment.f31228x.b(new ArrayList<>(list))), this, "cancellation_reasons");
    }

    private final void P0(Order order) {
        String str;
        String str2;
        TextView textView = (TextView) Z(R.id.new_order_client_name);
        String e8 = order.e();
        if (e8 == null) {
            str = "";
        } else {
            str = e8;
        }
        String c8 = order.c();
        if (c8 == null) {
            str2 = "";
        } else {
            str2 = c8;
        }
        textView.setText(A0(order, str, str2, order.f()));
    }

    private final void Q0(Order order) {
        M0(order.G());
        L0(order.u());
        V0(order.r());
    }

    private final void R0(IncomingOrderDetails incomingOrderDetails) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String format = String.format("%d %s", Arrays.copyOf(new Object[]{Integer.valueOf(incomingOrderDetails.a()), getString(R.string.minutes)}, 2));
        Intrinsics.e(format, "format(format, *args)");
        ((TextView) Z(R.id.new_order_eta_text)).setText(format);
    }

    private final void S0(IncomingOrderDetails incomingOrderDetails) {
        if (AcceptanceBlockAppearanceExtKt.a(incomingOrderDetails.b()) == IncomingOrderStyle.NEUTRAL) {
            Animator animator = this.f31369x;
            if (animator != null) {
                animator.cancel();
            }
            ConstraintLayout timeoutLabel = (ConstraintLayout) Z(R.id.timeoutLabel);
            Intrinsics.e(timeoutLabel, "timeoutLabel");
            ViewExtKt.e(timeoutLabel, false, 0, 2, null);
            M().X(incomingOrderDetails);
            return;
        }
        Color c8 = AcceptanceBlockAppearanceExtKt.a(incomingOrderDetails.b()).c();
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        int a8 = ColorKt.a(c8, requireContext);
        Context requireContext2 = requireContext();
        Intrinsics.e(requireContext2, "requireContext()");
        Drawable q02 = q0(a8, ContextUtilsKt.b(requireContext2, R.attr.dynamicNeutral05));
        int i8 = R.id.new_order_accept_progress;
        ((ProgressBar) Z(i8)).setProgressDrawable(q02);
        long I = incomingOrderDetails.b().I() - this.f31361p.a();
        if (I > 0) {
            int i9 = (int) (I * 1000);
            ((ProgressBar) Z(i8)).setMax(i9);
            ((ProgressBar) Z(i8)).setProgress(i9);
            ObjectAnimator ofInt = ObjectAnimator.ofInt((ProgressBar) Z(i8), "progress", 0);
            ofInt.setDuration(i9);
            ofInt.setInterpolator(new DecelerateInterpolator());
            ofInt.start();
            this.f31368w = ofInt;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0008, code lost:
        r13 = kotlin.collections.CollectionsKt___CollectionsKt.f0(r1, " | ", null, null, 0, null, null, 62, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void T0(ee.mtakso.driver.network.client.order.Order r19) {
        /*
            r18 = this;
            r0 = r18
            java.util.List r1 = r19.y()
            if (r1 == 0) goto L4d
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 62
            r9 = 0
            java.lang.String r2 = " | "
            java.lang.String r13 = kotlin.collections.CollectionsKt.f0(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            if (r13 != 0) goto L19
            goto L4d
        L19:
            int r1 = ee.mtakso.driver.R.id.rideTypeChips
            android.view.View r2 = r0.Z(r1)
            com.google.android.material.chip.ChipGroup r2 = (com.google.android.material.chip.ChipGroup) r2
            java.lang.String r3 = "rideTypeChips"
            kotlin.jvm.internal.Intrinsics.e(r2, r3)
            r4 = 3
            r5 = 0
            r6 = 0
            ee.mtakso.driver.uicore.utils.ViewExtKt.e(r2, r6, r6, r4, r5)
            ee.mtakso.driver.ui.utils.chip.ChipHelper r10 = r18.C0()
            android.view.View r1 = r0.Z(r1)
            r11 = r1
            com.google.android.material.chip.ChipGroup r11 = (com.google.android.material.chip.ChipGroup) r11
            kotlin.jvm.internal.Intrinsics.e(r11, r3)
            r12 = 2130969274(0x7f0402ba, float:1.7547225E38)
            r14 = 0
            ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderStyle r1 = ee.mtakso.driver.ui.screens.order.incoming.v2.AcceptanceBlockAppearanceExtKt.a(r19)
            ee.mtakso.driver.uikit.utils.Color r15 = r1.c()
            r16 = 8
            r17 = 0
            ee.mtakso.driver.ui.utils.chip.ChipHelper.e(r10, r11, r12, r13, r14, r15, r16, r17)
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderFragment.T0(ee.mtakso.driver.network.client.order.Order):void");
    }

    private final void U0(boolean z7, boolean z8, boolean z9, boolean z10) {
        if (z9) {
            ((TextView) Z(R.id.new_order_accept_text)).setText(getString(R.string.auto_accept));
        } else if (z7) {
            ((TextView) Z(R.id.new_order_accept_text)).setText(getString(R.string.accept_next_ride_2));
        } else if (z8) {
            ((TextView) Z(R.id.new_order_accept_text)).setText(getString(R.string.pick_up_the_client));
            ((AppCompatTextView) Z(R.id.buttonDecline)).setText(getString(R.string.unable_to_drive));
        } else if (z10) {
            ((AppCompatTextView) Z(R.id.buttonDecline)).setText(getString(R.string.action_cancel));
        }
    }

    private final void V0(PaymentType paymentType) {
        int i8;
        if (paymentType == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f31377d[paymentType.ordinal()];
        }
        if (i8 != 1) {
            if (i8 == 2) {
                ChipHelper C0 = C0();
                ChipGroup chipGroup = (ChipGroup) Z(R.id.chipGroup);
                Intrinsics.e(chipGroup, "chipGroup");
                String string = getString(R.string.inapp);
                Intrinsics.e(string, "getString(R.string.inapp)");
                C0.a(chipGroup, R.drawable.ic_card_active_ride, R.attr.colorBgDangerHighContrast, string, 18.0f);
                return;
            }
            return;
        }
        ChipHelper C02 = C0();
        ChipGroup chipGroup2 = (ChipGroup) Z(R.id.chipGroup);
        Intrinsics.e(chipGroup2, "chipGroup");
        String string2 = getString(R.string.cash);
        Intrinsics.e(string2, "getString(R.string.cash)");
        C02.a(chipGroup2, R.drawable.ic_cash_active_ride, R.attr.colorBgPromoHighContrast, string2, 18.0f);
    }

    private final void W0(Order order) {
        if (order.i() != null) {
            t0(order);
        } else {
            u0(order);
        }
    }

    private final void a0() {
        IncomingOrderDetails incomingOrderDetails;
        Optional<IncomingOrderDetails> b8;
        IncomingOrderData f8 = M().Q().f();
        if (f8 != null && (b8 = f8.b()) != null) {
            incomingOrderDetails = b8.c();
        } else {
            incomingOrderDetails = null;
        }
        if (incomingOrderDetails == null) {
            Kalev.e(new RuntimeException("Order is null"), "Order is null");
        } else {
            this.f31360o.b(incomingOrderDetails.d());
        }
        M().H();
        this.f31363r.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void l0(ee.mtakso.driver.network.client.order.Order r10) {
        /*
            Method dump skipped, instructions count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderFragment.l0(ee.mtakso.driver.network.client.order.Order):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(IncomingOrderFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.a0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(IncomingOrderFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.r0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(IncomingOrderFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.a0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(IncomingOrderFragment this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.M().N();
        this$0.f31360o.o();
    }

    private final Drawable q0(int i8, int i9) {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new ColorDrawable(i9), new ClipDrawable(new ColorDrawable(i8), 3, 1)});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908301);
        return layerDrawable;
    }

    private final void r0() {
        M().N();
        this.f31360o.o();
        this.f31363r.b();
    }

    private final void s0(RejectOrderResponse rejectOrderResponse) {
        CharSequence charSequence;
        String a8 = rejectOrderResponse.a();
        if (a8 != null) {
            charSequence = this.f31364s.a(a8);
        } else {
            charSequence = null;
        }
        if (charSequence != null) {
            N0(charSequence);
        } else if (rejectOrderResponse.b() != null) {
            O0(rejectOrderResponse.b());
        }
    }

    private final void t0(Order order) {
        String a8;
        String i8;
        List<Stop> n8;
        ((TextView) Z(R.id.new_order_address_text)).setVisibility(8);
        ((TextView) Z(R.id.new_order_address_second_text)).setVisibility(8);
        int i9 = R.id.pickupDestinationView;
        ((OrderStopsView) Z(i9)).setVisibility(0);
        SeparatedAddress c8 = OrderKt.c(order);
        if (c8 == null || (a8 = c8.a()) == null || (i8 = order.i()) == null) {
            return;
        }
        IncomingOrderStyle a9 = AcceptanceBlockAppearanceExtKt.a(order);
        ItemType itemType = ItemType.PICK_UP;
        Color f8 = a9.f();
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        ItemType itemType2 = ItemType.FINAL_DESTINATION;
        String w7 = order.w();
        Color f9 = a9.f();
        Context requireContext2 = requireContext();
        Intrinsics.e(requireContext2, "requireContext()");
        n8 = CollectionsKt__CollectionsKt.n(new Stop(itemType, null, a8, null, ColorKt.a(f8, requireContext), R.drawable.ic_route_marker_pickup_12dp_legacy, 0, 8, null), new Stop(itemType2, null, i8, w7, ColorKt.a(f9, requireContext2), R.drawable.stop_destination_12dp, 0));
        ((OrderStopsView) Z(i9)).setItems(n8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0053, code lost:
        if (r0 != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void u0(ee.mtakso.driver.network.client.order.Order r6) {
        /*
            r5 = this;
            int r0 = ee.mtakso.driver.R.id.new_order_address_text
            android.view.View r1 = r5.Z(r0)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r2 = 0
            r1.setVisibility(r2)
            int r1 = ee.mtakso.driver.R.id.new_order_address_second_text
            android.view.View r3 = r5.Z(r1)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r3.setVisibility(r2)
            int r3 = ee.mtakso.driver.R.id.pickupDestinationView
            android.view.View r3 = r5.Z(r3)
            ee.mtakso.driver.uicore.components.views.order_stops_view.OrderStopsView r3 = (ee.mtakso.driver.uicore.components.views.order_stops_view.OrderStopsView) r3
            r4 = 8
            r3.setVisibility(r4)
            java.util.List r6 = r6.H()
            java.lang.Object r6 = kotlin.collections.CollectionsKt.i0(r6)
            ee.mtakso.driver.network.client.order.UpcomingStop r6 = (ee.mtakso.driver.network.client.order.UpcomingStop) r6
            if (r6 == 0) goto L35
            java.lang.String r6 = r6.a()
            goto L36
        L35:
            r6 = 0
        L36:
            ee.mtakso.driver.service.modules.order.SeparatedAddress r6 = ee.mtakso.driver.network.client.order.OrderKt.e(r6)
            if (r6 == 0) goto L65
            android.view.View r0 = r5.Z(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r3 = r6.a()
            r0.setText(r3)
            java.lang.String r0 = r6.b()
            if (r0 == 0) goto L55
            boolean r0 = kotlin.text.StringsKt.y(r0)
            if (r0 == 0) goto L56
        L55:
            r2 = 1
        L56:
            if (r2 != 0) goto L65
            android.view.View r0 = r5.Z(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r6 = r6.b()
            r0.setText(r6)
        L65:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderFragment.u0(ee.mtakso.driver.network.client.order.Order):void");
    }

    private final void v0(OptionalRideInfo optionalRideInfo) {
        if (optionalRideInfo != null) {
            Group layoutOptional = (Group) Z(R.id.layoutOptional);
            Intrinsics.e(layoutOptional, "layoutOptional");
            ViewExtKt.e(layoutOptional, false, 0, 3, null);
            ConstraintLayout declineRootLayout = (ConstraintLayout) Z(R.id.declineRootLayout);
            Intrinsics.e(declineRootLayout, "declineRootLayout");
            ee.mtakso.driver.uikit.utils.ViewExtKt.a(declineRootLayout, new Color.Attr(R.attr.backSecondary));
            ((TextView) Z(R.id.titleOptional)).setText(optionalRideInfo.b());
            ((TextView) Z(R.id.detailsOptional)).setText(optionalRideInfo.a());
            return;
        }
        Group layoutOptional2 = (Group) Z(R.id.layoutOptional);
        Intrinsics.e(layoutOptional2, "layoutOptional");
        ViewExtKt.e(layoutOptional2, false, 0, 2, null);
        ((ConstraintLayout) Z(R.id.declineRootLayout)).setBackground(null);
        M().T().o(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(IncomingOrderData incomingOrderData) {
        Kalev.k("Drawing order: " + incomingOrderData);
        IncomingOrderDetails c8 = incomingOrderData.b().c();
        if (c8 != null && !this.f31367v) {
            this.f31360o.G(c8.c(), c8.d());
            v0(c8.b().p());
            x0(c8);
            this.f31367v = true;
        }
    }

    private final void x0(IncomingOrderDetails incomingOrderDetails) {
        boolean z7;
        boolean z8;
        Order b8 = incomingOrderDetails.b();
        l0(incomingOrderDetails.b());
        R0(incomingOrderDetails);
        T0(b8);
        W0(b8);
        P0(b8);
        Q0(b8);
        boolean d8 = incomingOrderDetails.d();
        Boolean J = incomingOrderDetails.b().J();
        boolean z9 = false;
        if (J != null) {
            z7 = J.booleanValue();
        } else {
            z7 = false;
        }
        if (incomingOrderDetails.b().h() == AutoOrderAcceptance.AUTO) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (AcceptanceBlockAppearanceExtKt.a(incomingOrderDetails.b()) == IncomingOrderStyle.NEUTRAL) {
            z9 = true;
        }
        U0(d8, z7, z8, z9);
        S0(incomingOrderDetails);
        AlphaAnimatorHelper alphaAnimatorHelper = AlphaAnimatorHelper.f35720a;
        ConstraintLayout accept_active_layout = (ConstraintLayout) Z(R.id.accept_active_layout);
        Intrinsics.e(accept_active_layout, "accept_active_layout");
        ConstraintLayout accept_inactive_layout = (ConstraintLayout) Z(R.id.accept_inactive_layout);
        Intrinsics.e(accept_inactive_layout, "accept_inactive_layout");
        AlphaAnimatorHelper.b(alphaAnimatorHelper, accept_active_layout, accept_inactive_layout, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0(OrderStateChange orderStateChange) {
        boolean z7;
        Kalev.k("Drawing order state change: " + orderStateChange);
        if (orderStateChange instanceof OrderStateChangeProgress) {
            I();
            return;
        }
        RejectResponseType rejectResponseType = null;
        if (orderStateChange instanceof OrderStateChangeError) {
            G();
            int i8 = WhenMappings.f31374a[orderStateChange.a().ordinal()];
            if (i8 != 1) {
                if (i8 != 2) {
                    IncomingOrderViewModel M = M();
                    BaseViewModel.A(M, new IllegalArgumentException("Unexpected order state change: " + orderStateChange), null, 2, null);
                    return;
                }
                M().z(((OrderStateChangeError) orderStateChange).b(), "Failed to reject order");
                return;
            }
            NotificationDialog.Companion companion = NotificationDialog.f28313n;
            String string = getString(R.string.order_not_accepted);
            Intrinsics.e(string, "getString(R.string.order_not_accepted)");
            String string2 = getString(R.string.order_not_accepted_network);
            Intrinsics.e(string2, "getString(R.string.order_not_accepted_network)");
            String string3 = getString(R.string.ok_lowercase);
            Intrinsics.e(string3, "getString(R.string.ok_lowercase)");
            NotificationDialog i9 = NotificationDialog.Companion.i(companion, string, string2, string3, null, 8, null);
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.e(requireActivity, "requireActivity()");
            FragmentUtils.c(i9, requireActivity, "acceptance_error");
            return;
        }
        if (orderStateChange instanceof OrderStateChangeSuccess) {
            z7 = true;
        } else {
            z7 = orderStateChange instanceof OrderStateChangeSuccessWithData;
        }
        if (z7) {
            G();
            int i10 = WhenMappings.f31374a[orderStateChange.a().ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    IncomingOrderViewModel M2 = M();
                    BaseViewModel.A(M2, new IllegalArgumentException("Unexpected order state change: " + orderStateChange), null, 2, null);
                    return;
                }
                RejectOrderResponse B0 = B0(orderStateChange);
                if (B0 != null) {
                    rejectResponseType = B0.c();
                }
                if (rejectResponseType == RejectResponseType.REASONS_REQUIRED) {
                    s0(B0);
                    return;
                }
                this.f31363r.b();
                Toast.makeText(requireContext(), requireContext().getText(R.string.ok_lowercase), 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(long j8) {
        boolean z7;
        int i8 = R.id.timeoutLabel;
        ConstraintLayout timeoutLabel = (ConstraintLayout) Z(i8);
        Intrinsics.e(timeoutLabel, "timeoutLabel");
        if (timeoutLabel.getVisibility() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            ConstraintLayout timeoutLabel2 = (ConstraintLayout) Z(i8);
            Intrinsics.e(timeoutLabel2, "timeoutLabel");
            ViewExtKt.e(timeoutLabel2, false, 0, 3, null);
            final ConstraintLayout timeoutLabel3 = (ConstraintLayout) Z(i8);
            Intrinsics.e(timeoutLabel3, "timeoutLabel");
            timeoutLabel3.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderFragment$drawTimeoutLabel$$inlined$doOnPreDraw$1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    Animator animator;
                    timeoutLabel3.getViewTreeObserver().removeOnPreDrawListener(this);
                    IncomingOrderFragment incomingOrderFragment = this;
                    Animators animators = Animators.f36024a;
                    int i9 = R.id.timeoutLabel;
                    ConstraintLayout timeoutLabel4 = (ConstraintLayout) incomingOrderFragment.Z(i9);
                    Intrinsics.e(timeoutLabel4, "timeoutLabel");
                    ConstraintLayout timeoutLabel5 = (ConstraintLayout) this.Z(i9);
                    Intrinsics.e(timeoutLabel5, "timeoutLabel");
                    TextView timeoutLabelText = (TextView) this.Z(R.id.timeoutLabelText);
                    Intrinsics.e(timeoutLabelText, "timeoutLabelText");
                    TextView timeoutLabelTime = (TextView) this.Z(R.id.timeoutLabelTime);
                    Intrinsics.e(timeoutLabelTime, "timeoutLabelTime");
                    incomingOrderFragment.f31369x = animators.b(timeoutLabel4, timeoutLabel5, timeoutLabelText, timeoutLabelTime);
                    animator = this.f31369x;
                    if (animator != null) {
                        animator.start();
                    }
                    return false;
                }
            });
        }
        ((TextView) Z(R.id.timeoutLabelTime)).setText(DateUtils.formatElapsedTime(j8));
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.B.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        D0().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void H(Throwable error) {
        Intrinsics.f(error, "error");
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        NotificationDialog c8 = NotificationDialog.Companion.c(companion, requireContext, error, null, 4, null);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c(c8, requireActivity, "error");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        D0().b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: J0 */
    public IncomingOrderViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (IncomingOrderViewModel) new ViewModelProvider(this, E.d()).a(IncomingOrderViewModel.class);
    }

    public View Z(int i8) {
        View findViewById;
        Map<Integer, View> map = this.B;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.f(context, "context");
        super.onAttach(context);
        this.f31365t.n();
        this.f31363r.a();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BaseDialogFragment.f41026i.a(getChildFragmentManager(), "confirm_cancellation", this.f31370y);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f31363r.b();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        boolean z7;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        OrderTracker orderTracker = this.f31360o;
        if (bundle != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        orderTracker.y(z7);
        ObservableLiveData<IncomingOrderData> Q = M().Q();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<IncomingOrderData, Unit> function1 = new Function1<IncomingOrderData, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(IncomingOrderData it) {
                IncomingOrderFragment incomingOrderFragment = IncomingOrderFragment.this;
                Intrinsics.e(it, "it");
                incomingOrderFragment.w0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IncomingOrderData incomingOrderData) {
                b(incomingOrderData);
                return Unit.f50853a;
            }
        };
        Q.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                IncomingOrderFragment.F0(Function1.this, obj);
            }
        });
        LiveData<OrderStateChange> R = M().R();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<OrderStateChange, Unit> function12 = new Function1<OrderStateChange, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(OrderStateChange it) {
                IncomingOrderFragment incomingOrderFragment = IncomingOrderFragment.this;
                Intrinsics.e(it, "it");
                incomingOrderFragment.y0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OrderStateChange orderStateChange) {
                b(orderStateChange);
                return Unit.f50853a;
            }
        };
        R.i(viewLifecycleOwner2, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                IncomingOrderFragment.G0(Function1.this, obj);
            }
        });
        SingleLiveData<IncomingOrderRoute> S = M().S();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<IncomingOrderRoute, Unit> function13 = new Function1<IncomingOrderRoute, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderFragment$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(IncomingOrderRoute incomingOrderRoute) {
                String str;
                IncomingOrderFragment incomingOrderFragment = IncomingOrderFragment.this;
                Route b8 = incomingOrderRoute.b();
                if (b8 != null) {
                    str = b8.a();
                } else {
                    str = null;
                }
                incomingOrderFragment.K0(str);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IncomingOrderRoute incomingOrderRoute) {
                b(incomingOrderRoute);
                return Unit.f50853a;
            }
        };
        S.i(viewLifecycleOwner3, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                IncomingOrderFragment.H0(Function1.this, obj);
            }
        });
        LiveData<Long> O = M().O();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<Long, Unit> function14 = new Function1<Long, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderFragment$onViewCreated$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Long it) {
                IncomingOrderFragment incomingOrderFragment = IncomingOrderFragment.this;
                Intrinsics.e(it, "it");
                incomingOrderFragment.z0(it.longValue());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l8) {
                b(l8);
                return Unit.f50853a;
            }
        };
        O.i(viewLifecycleOwner4, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                IncomingOrderFragment.I0(Function1.this, obj);
            }
        });
        if (bundle == null) {
            FragmentFactory fragmentFactory = this.f31362q;
            Context requireContext = requireContext();
            Intrinsics.e(requireContext, "requireContext()");
            getChildFragmentManager().beginTransaction().add(R.id.new_order_map, (IncomingOrderMapFragment) FragmentFactoryUtils.c(fragmentFactory, requireContext, IncomingOrderMapFragment.class, null, 4, null)).commit();
        }
        ConstraintLayout new_order_root_layout = (ConstraintLayout) Z(R.id.new_order_root_layout);
        Intrinsics.e(new_order_root_layout, "new_order_root_layout");
        ViewExtKt.c(new_order_root_layout, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderFragment$onViewCreated$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                IncomingOrderViewModel M;
                IncomingOrderFragment incomingOrderFragment = IncomingOrderFragment.this;
                int i8 = R.id.declineRootLayout;
                if (((ConstraintLayout) incomingOrderFragment.Z(i8)) != null) {
                    M = IncomingOrderFragment.this.M();
                    M.T().o(Integer.valueOf(((ConstraintLayout) IncomingOrderFragment.this.Z(i8)).getHeight()));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
    }
}
