package ee.mtakso.driver.ui.screens.order.v2;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.snackbar.Snackbar;
import com.sinch.android.rtc.internal.InternalErrorCodes;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.network.client.device.DriverAppDisabledReason;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.connectivity.NetworkConnectionStatus;
import ee.mtakso.driver.service.push.PushMessage;
import ee.mtakso.driver.service.voip.noanswer.NoAnswerIncomingCall;
import ee.mtakso.driver.ui.base.mvvm.BaseDynamicTranslatedMvvmActivity;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.common.internet.InternetDialogDelegate;
import ee.mtakso.driver.ui.common.push.PushDialogDelegate;
import ee.mtakso.driver.ui.helper.ErrorHandler;
import ee.mtakso.driver.ui.interactor.warnings.WarningMessage;
import ee.mtakso.driver.ui.notification.UiNotificationManager;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.blocking.DriverAppDisabledFragment;
import ee.mtakso.driver.ui.screens.contact_methods.chat.ChatFragment$ChatParams;
import ee.mtakso.driver.ui.screens.contact_methods.voip.VoipFloatingActivity;
import ee.mtakso.driver.ui.screens.contact_methods.voip.callback.CallBackFragment;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.order.v2.map.BottomOffsetProvider;
import ee.mtakso.driver.ui.screens.order.v2.map.NotificationModel;
import ee.mtakso.driver.ui.screens.order.v2.map.TopNotificationsDelegate;
import ee.mtakso.driver.ui.screens.order.v2.order.BackToBackState;
import ee.mtakso.driver.ui.screens.order.v2.order.BottomBarState;
import ee.mtakso.driver.ui.screens.order.v2.order.BottomWidgetStates;
import ee.mtakso.driver.ui.screens.order.v2.order.ExtraInfo;
import ee.mtakso.driver.ui.screens.order.v2.order.OrderData;
import ee.mtakso.driver.ui.screens.order.v2.order.ScreenState;
import ee.mtakso.driver.ui.screens.order.v2.order.ui.RetryController;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpType;
import ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitBottomSheetFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.utils.SafetyFABButtonType;
import ee.mtakso.driver.ui.screens.safety_toolkit.utils.SafetyUIUtils;
import ee.mtakso.driver.ui.screens.sos.SosDialogFragment;
import ee.mtakso.driver.ui.theme.ThemeActivityExtKt;
import ee.mtakso.driver.ui.views.warnings.WarningLabelDelegate;
import ee.mtakso.driver.uicore.components.views.TopSnackBar;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import ee.mtakso.driver.utils.DialerLauncher;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.bottomsheet.BottomSheetAnimationRequest;
import ee.mtakso.driver.utils.bottomsheet.ComponentBottomSheetBehavior;
import ee.mtakso.driver.utils.bottomsheet.ControllableBottomSheetBehavior;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment;
import eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback;
import eu.bolt.driver.core.ui.common.dialog.OfflineDialog;
import eu.bolt.driver.core.ui.common.snackbar.SnackBarDelegate;
import eu.bolt.driver.core.ui.common.snackbar.SnackBarModel;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActiveRideActivity.kt */
/* loaded from: classes3.dex */
public final class ActiveRideActivity extends BaseDynamicTranslatedMvvmActivity<OrderViewModel> implements BottomOffsetProvider {
    public static final Companion Q = new Companion(null);
    private final Lazy A;
    private final ActiveRideActivity$takeBreakActionCallback$1 B;
    private ControllableBottomSheetBehavior<View> C;
    private ActivityUiDelegate D;
    private ChatUiDelegate E;
    private final WarningLabelDelegate F;
    private final InternetDialogDelegate G;
    private RetryController H;
    private final MutableLiveData<Integer> I;
    private TopSnackBar J;
    private TopSnackBar K;
    private TopSnackBar L;
    private BottomSheetAnimationRequest<View> M;
    private CompositeDisposable N;
    private final Lazy O;
    public Map<Integer, View> P = new LinkedHashMap();
    @Inject

    /* renamed from: o  reason: collision with root package name */
    public DialerLauncher f31858o;
    @Inject

    /* renamed from: p  reason: collision with root package name */
    public DriverProvider f31859p;
    @Inject

    /* renamed from: q  reason: collision with root package name */
    public DriverConfig f31860q;
    @Inject

    /* renamed from: r  reason: collision with root package name */
    public UiNotificationManager f31861r;
    @Inject

    /* renamed from: s  reason: collision with root package name */
    public ErrorHandler f31862s;
    @Inject

    /* renamed from: t  reason: collision with root package name */
    public PushDialogDelegate f31863t;
    @Inject

    /* renamed from: u  reason: collision with root package name */
    public CompositeUrlLauncher f31864u;
    @Inject

    /* renamed from: v  reason: collision with root package name */
    public LanguageManager f31865v;
    @Inject

    /* renamed from: w  reason: collision with root package name */
    public AppThemeManager f31866w;
    @Inject

    /* renamed from: x  reason: collision with root package name */
    public RoutingManager f31867x;
    @Inject

    /* renamed from: y  reason: collision with root package name */
    public HtmlEngine f31868y;

    /* renamed from: z  reason: collision with root package name */
    private final Lazy f31869z;

    /* compiled from: ActiveRideActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ActiveRideActivity.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31870a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f31871b;

        static {
            int[] iArr = new int[BackToBackState.values().length];
            try {
                iArr[BackToBackState.ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f31870a = iArr;
            int[] iArr2 = new int[BottomBarState.values().length];
            try {
                iArr2[BottomBarState.COLLAPSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[BottomBarState.EXPANDED.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            f31871b = iArr2;
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity$takeBreakActionCallback$1] */
    public ActiveRideActivity() {
        Lazy b8;
        Lazy b9;
        Lazy b10;
        b8 = LazyKt__LazyJVMKt.b(new Function0<TopNotificationsDelegate>() { // from class: ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity$topNotificationsDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final TopNotificationsDelegate invoke() {
                ActiveRideActivity activeRideActivity = ActiveRideActivity.this;
                CoordinatorLayout rootCoordinator = (CoordinatorLayout) activeRideActivity.z0(R.id.rootCoordinator);
                Intrinsics.e(rootCoordinator, "rootCoordinator");
                return new TopNotificationsDelegate(activeRideActivity, rootCoordinator);
            }
        });
        this.f31869z = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<SnackBarDelegate>() { // from class: ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity$snackBarDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final SnackBarDelegate invoke() {
                CoordinatorLayout rootCoordinator = (CoordinatorLayout) ActiveRideActivity.this.z0(R.id.rootCoordinator);
                Intrinsics.e(rootCoordinator, "rootCoordinator");
                return new SnackBarDelegate(rootCoordinator, (FrameLayout) ActiveRideActivity.this.z0(R.id.actionSheetContainer));
            }
        });
        this.A = b9;
        this.B = new DefaultDialogCallback() { // from class: ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity$takeBreakActionCallback$1
            @Override // eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback, eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void a(BaseDialogFragment dialog, View view, Object payload) {
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(view, "view");
                Intrinsics.f(payload, "payload");
                if (Intrinsics.a(payload, "positive")) {
                    dialog.dismissAllowingStateLoss();
                    ActiveRideActivity.this.Q().n1();
                    ActiveRideActivity.this.Q().c3();
                } else if (Intrinsics.a(payload, "negative")) {
                    dialog.dismissAllowingStateLoss();
                    ActiveRideActivity.this.Q().b3();
                }
            }
        };
        this.F = new WarningLabelDelegate(this);
        this.G = new InternetDialogDelegate();
        this.I = new MutableLiveData<>();
        this.N = new CompositeDisposable();
        b10 = LazyKt__LazyJVMKt.b(new Function0<OrderViewModel>() { // from class: ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final OrderViewModel invoke() {
                ActiveRideActivity activeRideActivity = ActiveRideActivity.this;
                return (OrderViewModel) new ViewModelProvider(activeRideActivity, activeRideActivity.R()).a(OrderViewModel.class);
            }
        });
        this.O = b10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A1(Integer num, Integer num2, Integer num3, int i8, int i9) {
        if (num != null) {
            ((RoundButton) z0(R.id.safetyToolkitButton)).b(num.intValue());
        }
        if (num2 != null) {
            ((RoundButton) z0(R.id.safetyToolkitButton)).b(num2.intValue());
        }
        int i10 = R.id.safetyToolkitButton;
        ((RoundButton) z0(i10)).setIconTint(num3);
        ((RoundButton) z0(i10)).setBgColor(i8);
        SafetyUIUtils safetyUIUtils = SafetyUIUtils.f32878a;
        LottieAnimationView audioInProgressAnimationView = (LottieAnimationView) z0(R.id.audioInProgressAnimationView);
        Intrinsics.e(audioInProgressAnimationView, "audioInProgressAnimationView");
        safetyUIUtils.b(audioInProgressAnimationView, i9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B1(DriverAppDisabledReason driverAppDisabledReason) {
        DriverAppDisabledFragment.Companion companion = DriverAppDisabledFragment.f27050r;
        if (!companion.a()) {
            Intent g8 = SimpleActivity.f27004l.g(this, DriverAppDisabledFragment.class, companion.b(driverAppDisabledReason), false);
            g8.setFlags(268468224);
            startActivity(g8);
        }
    }

    private final void C1() {
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        String string = getString(R.string.order_cancelled_title);
        Intrinsics.e(string, "getString(R.string.order_cancelled_title)");
        String string2 = getString(R.string.order_cancelled_by_client);
        Intrinsics.e(string2, "getString(R.string.order_cancelled_by_client)");
        String string3 = getString(R.string.ok_lowercase);
        Intrinsics.e(string3, "getString(R.string.ok_lowercase)");
        FragmentUtils.c(NotificationDialog.Companion.i(companion, string, string2, string3, null, 8, null), this, "b2b_order_canceled");
    }

    private final void D1() {
        OfflineDialog.Companion companion = OfflineDialog.f41103m;
        String string = getString(R.string.active_ride_need_break);
        Intrinsics.e(string, "getString(R.string.active_ride_need_break)");
        CharSequence a8 = O0().a(getString(R.string.active_ride_need_break_message_html));
        String string2 = getString(R.string.confirm_lowercase);
        Intrinsics.e(string2, "getString(R.string.confirm_lowercase)");
        String string3 = getString(R.string.action_cancel);
        Intrinsics.e(string3, "getString(R.string.action_cancel)");
        FragmentUtils.c(companion.a(string, a8, string2, string3, this.B), this, "dialog_need_break_confirmation");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E1(Text text) {
        TopNotificationsDelegate T0 = T0();
        String string = getString(R.string.route_updated_title);
        String obj = TextKt.a(text, this).toString();
        Intrinsics.e(string, "getString(R.string.route_updated_title)");
        T0.b(new NotificationModel(string, obj, Integer.valueOf((int) R.drawable.ic_pin), 10000, false, false, Integer.valueOf((int) R.drawable.circle_purple_900), null, 176, null));
    }

    private final void F1() {
        TopSnackBar topSnackBar = this.J;
        boolean z7 = true;
        if (!((topSnackBar == null || !topSnackBar.O()) ? false : false)) {
            TopNotificationsDelegate T0 = T0();
            String string = getString(R.string.no_destination_title);
            String string2 = getString(R.string.no_destination_message);
            Intrinsics.e(string, "getString(R.string.no_destination_title)");
            Intrinsics.e(string2, "getString(R.string.no_destination_message)");
            this.J = T0.b(new NotificationModel(string, string2, Integer.valueOf((int) R.drawable.ic_pin), 0, false, false, Integer.valueOf((int) R.drawable.circle_purple_900), null, 136, null));
        }
    }

    private final void G1(boolean z7) {
        if (getSupportFragmentManager().findFragmentByTag("safetyToolkitBottomSheet") == null) {
            FragmentUtils.c((SafetyToolkitBottomSheetFragment) FragmentFactoryUtils.c(N(), this, SafetyToolkitBottomSheetFragment.class, null, 4, null), this, "safetyToolkitBottomSheet");
        }
        if (z7) {
            Q().S3();
        }
    }

    private final void H1() {
        FragmentUtils.c((SosDialogFragment) FragmentFactoryUtils.c(N(), this, SosDialogFragment.class, null, 4, null), this, "sosDialog");
    }

    private final void I0(Window window) {
        window.addFlags(6815744);
    }

    private final boolean I1(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            H1();
            return true;
        } else if (motionEvent.getAction() == 1) {
            J0();
            return false;
        } else {
            return false;
        }
    }

    private final void J0() {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("sosDialog");
        if (findFragmentByTag instanceof SosDialogFragment) {
            ((SosDialogFragment) findFragmentByTag).i0();
        }
    }

    private final void J1(int i8, boolean z7) {
        BottomSheetAnimationRequest<View> bottomSheetAnimationRequest = this.M;
        boolean z8 = true;
        z8 = (bottomSheetAnimationRequest == null || !bottomSheetAnimationRequest.c()) ? false : false;
        ControllableBottomSheetBehavior<View> controllableBottomSheetBehavior = null;
        if (z8) {
            BottomSheetAnimationRequest<View> bottomSheetAnimationRequest2 = this.M;
            if (bottomSheetAnimationRequest2 != null) {
                bottomSheetAnimationRequest2.a();
            }
            this.M = null;
        }
        if (z7) {
            ControllableBottomSheetBehavior<View> controllableBottomSheetBehavior2 = this.C;
            if (controllableBottomSheetBehavior2 == null) {
                Intrinsics.w("bottomSheetBehavior");
            } else {
                controllableBottomSheetBehavior = controllableBottomSheetBehavior2;
            }
            BottomSheetAnimationRequest<View> bottomSheetAnimationRequest3 = new BottomSheetAnimationRequest<>(controllableBottomSheetBehavior, i8);
            this.M = bottomSheetAnimationRequest3;
            bottomSheetAnimationRequest3.e();
            return;
        }
        ControllableBottomSheetBehavior<View> controllableBottomSheetBehavior3 = this.C;
        if (controllableBottomSheetBehavior3 == null) {
            Intrinsics.w("bottomSheetBehavior");
        } else {
            controllableBottomSheetBehavior = controllableBottomSheetBehavior3;
        }
        controllableBottomSheetBehavior.X(i8);
    }

    private final void K0(ScreenState screenState) {
        ActivityUiDelegate activityUiDelegate = this.D;
        ActivityUiDelegate activityUiDelegate2 = null;
        if (activityUiDelegate == null) {
            Intrinsics.w("uiDelegate");
            activityUiDelegate = null;
        }
        activityUiDelegate.l(screenState);
        ActivityUiDelegate activityUiDelegate3 = this.D;
        if (activityUiDelegate3 == null) {
            Intrinsics.w("uiDelegate");
            activityUiDelegate3 = null;
        }
        activityUiDelegate3.m(screenState.d());
        M1(screenState);
        ChatUiDelegate chatUiDelegate = this.E;
        if (chatUiDelegate == null) {
            Intrinsics.w("chatUiDelegate");
            chatUiDelegate = null;
        }
        chatUiDelegate.m(screenState.c());
        ActivityUiDelegate activityUiDelegate4 = this.D;
        if (activityUiDelegate4 == null) {
            Intrinsics.w("uiDelegate");
        } else {
            activityUiDelegate2 = activityUiDelegate4;
        }
        activityUiDelegate2.e(screenState.e());
    }

    private final void K1(BottomWidgetStates bottomWidgetStates) {
        boolean z7;
        BottomBarState c8;
        int i8;
        if (bottomWidgetStates != null) {
            z7 = bottomWidgetStates.e();
        } else {
            z7 = false;
        }
        if (bottomWidgetStates != null && (c8 = bottomWidgetStates.c()) != null) {
            int i9 = WhenMappings.f31871b[c8.ordinal()];
            if (i9 != 1) {
                if (i9 == 2) {
                    i8 = 3;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                i8 = 4;
            }
            J1(i8, z7);
        }
    }

    private final void L1() {
        FrameLayout actionSheetContainer = (FrameLayout) z0(R.id.actionSheetContainer);
        Intrinsics.e(actionSheetContainer, "actionSheetContainer");
        ViewExtKt.c(actionSheetContainer, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity$updateBottomSheetPeekHeight$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                ControllableBottomSheetBehavior controllableBottomSheetBehavior;
                MutableLiveData mutableLiveData;
                ActiveRideActivity activeRideActivity = ActiveRideActivity.this;
                int i8 = R.id.actionSheetContainer;
                if (((FrameLayout) activeRideActivity.z0(i8)).getHeight() > 0) {
                    int height = (int) (((FrameLayout) ActiveRideActivity.this.z0(i8)).getHeight() * 0.7f);
                    controllableBottomSheetBehavior = ActiveRideActivity.this.C;
                    if (controllableBottomSheetBehavior == null) {
                        Intrinsics.w("bottomSheetBehavior");
                        controllableBottomSheetBehavior = null;
                    }
                    controllableBottomSheetBehavior.V(height);
                    mutableLiveData = ActiveRideActivity.this.I;
                    mutableLiveData.o(Integer.valueOf(height));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
    }

    private final void M1(ScreenState screenState) {
        RoundButton sosButton = (RoundButton) z0(R.id.sosButton);
        Intrinsics.e(sosButton, "sosButton");
        ee.mtakso.driver.uikit.utils.ViewExtKt.d(sosButton, screenState.h(), 0, 2, null);
        RoundButton safetyToolkitButton = (RoundButton) z0(R.id.safetyToolkitButton);
        Intrinsics.e(safetyToolkitButton, "safetyToolkitButton");
        ee.mtakso.driver.uikit.utils.ViewExtKt.d(safetyToolkitButton, screenState.i(), 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SnackBarDelegate S0() {
        return (SnackBarDelegate) this.A.getValue();
    }

    private final TopNotificationsDelegate T0() {
        return (TopNotificationsDelegate) this.f31869z.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0(boolean z7) {
        Unit unit;
        if (z7) {
            TopSnackBar topSnackBar = this.L;
            if (topSnackBar != null) {
                topSnackBar.e0();
                unit = Unit.f50853a;
            } else {
                unit = null;
            }
            if (unit == null) {
                TopNotificationsDelegate T0 = T0();
                String string = getString(R.string.notification_rider_shared_location_title);
                String string2 = getString(R.string.notification_rider_location_enabled_subtitle);
                Intrinsics.e(string, "getString(R.string.notif…er_shared_location_title)");
                Intrinsics.e(string2, "getString(R.string.notif…ocation_enabled_subtitle)");
                this.L = T0.b(new NotificationModel(string, string2, Integer.valueOf((int) R.drawable.ic_rider_location_banner_24dp), InternalErrorCodes.FcmServiceIsNotAvailable, false, false, null, null, 240, null));
                return;
            }
            return;
        }
        TopSnackBar topSnackBar2 = this.L;
        if (topSnackBar2 != null) {
            topSnackBar2.A();
        }
    }

    private final void Y0() {
        TopSnackBar topSnackBar = this.J;
        if (topSnackBar != null) {
            if (!topSnackBar.O()) {
                topSnackBar = null;
            }
            if (topSnackBar != null) {
                topSnackBar.A();
            }
        }
        this.J = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(ActiveRideActivity this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.Q().E3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(ActiveRideActivity this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.Q().B3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(ActiveRideActivity this$0, PushMessage it) {
        Intrinsics.f(this$0, "this$0");
        PushDialogDelegate Q0 = this$0.Q0();
        Intrinsics.e(it, "it");
        Q0.b(it, this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(ActiveRideActivity this$0, Unit unit) {
        Intrinsics.f(this$0, "this$0");
        this$0.C1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(ActiveRideActivity this$0, ChatFragment$ChatParams chatFragment$ChatParams) {
        Intrinsics.f(this$0, "this$0");
        ChatUiDelegate chatUiDelegate = this$0.E;
        if (chatUiDelegate == null) {
            Intrinsics.w("chatUiDelegate");
            chatUiDelegate = null;
        }
        chatUiDelegate.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(final ActiveRideActivity this$0, Boolean it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        if (it.booleanValue()) {
            if (this$0.K == null) {
                TopNotificationsDelegate T0 = this$0.T0();
                String string = this$0.getString(R.string.notification_ride_auto_accepted_title);
                String string2 = this$0.getString(R.string.notification_ride_auto_accepted_desc);
                Intrinsics.e(string, "getString(R.string.notif…ride_auto_accepted_title)");
                Intrinsics.e(string2, "getString(R.string.notif…_ride_auto_accepted_desc)");
                this$0.K = T0.b(new NotificationModel(string, string2, Integer.valueOf((int) R.drawable.ic_lightning), InternalErrorCodes.FcmServiceIsNotAvailable, false, false, Integer.valueOf((int) R.drawable.circle_purple_900), new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity$onCreate$15$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    public final void b() {
                        ActiveRideActivity.this.Q().c1();
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        b();
                        return Unit.f50853a;
                    }
                }, 48, null));
                return;
            }
            return;
        }
        TopSnackBar topSnackBar = this$0.K;
        if (topSnackBar != null) {
            if (!topSnackBar.O()) {
                topSnackBar = null;
            }
            if (topSnackBar != null) {
                topSnackBar.A();
            }
        }
        this$0.K = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(ActiveRideActivity this$0, WarningMessage warningMessage) {
        Intrinsics.f(this$0, "this$0");
        this$0.F.h(warningMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k1(ActiveRideActivity this$0, View view, MotionEvent motionEvent) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(motionEvent, "motionEvent");
        return this$0.I1(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(ActiveRideActivity this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.Q().m3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(ActiveRideActivity this$0, boolean z7, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.Q().N3();
        this$0.G1(z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(ActiveRideActivity this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        ActivityUiDelegate activityUiDelegate = this$0.D;
        ExtraInfo extraInfo = null;
        if (activityUiDelegate == null) {
            Intrinsics.w("uiDelegate");
            activityUiDelegate = null;
        }
        ScreenState f8 = this$0.Q().o3().f();
        if (f8 != null) {
            extraInfo = f8.e();
        }
        if (extraInfo != null) {
            activityUiDelegate.k(extraInfo, false);
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(ActiveRideActivity this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.D1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t1(ActiveRideActivity this$0, BottomWidgetStates bottomWidgetStates) {
        Intrinsics.f(this$0, "this$0");
        this$0.K1(bottomWidgetStates);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u1(ActiveRideActivity this$0, ScreenState it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.K0(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1(ActiveRideActivity this$0, OrderData orderData) {
        Intrinsics.f(this$0, "this$0");
        this$0.x1(orderData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w1(ActiveRideActivity this$0, NetworkConnectionStatus it) {
        Intrinsics.f(this$0, "this$0");
        InternetDialogDelegate internetDialogDelegate = this$0.G;
        Intrinsics.e(it, "it");
        internetDialogDelegate.e(it, this$0);
    }

    private final void x1(final OrderData orderData) {
        boolean z7;
        int b8;
        if (orderData == null) {
            return;
        }
        if (orderData instanceof OrderData.DrivingWithClientData) {
            if (((OrderData.DrivingWithClientData) orderData).d() == null) {
                F1();
            } else {
                Y0();
            }
        }
        int i8 = R.id.stopButton;
        RoundButton stopButton = (RoundButton) z0(i8);
        Intrinsics.e(stopButton, "stopButton");
        if (N0().q().i() && orderData.a().a() != BackToBackState.UNAVAILABLE) {
            z7 = true;
        } else {
            z7 = false;
        }
        ee.mtakso.driver.uikit.utils.ViewExtKt.d(stopButton, z7, 0, 2, null);
        if (orderData.a().a() == BackToBackState.ENABLED) {
            b8 = ContextUtilsKt.b(this, R.attr.contentPrimary);
        } else {
            b8 = ContextUtilsKt.b(this, R.attr.dynamicNeutral04);
        }
        ColorStateList valueOf = ColorStateList.valueOf(b8);
        Intrinsics.e(valueOf, "valueOf(tint)");
        ((RoundButton) z0(i8)).setIconTintList(valueOf);
        ((RoundButton) z0(i8)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.order.v2.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActiveRideActivity.y1(ActiveRideActivity.this, orderData, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y1(ActiveRideActivity this$0, OrderData orderData, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.Q().d3();
        if (WhenMappings.f31870a[orderData.a().a().ordinal()] == 1) {
            this$0.D1();
            this$0.Q().i3();
            return;
        }
        View pauseTooltip = this$0.z0(R.id.pauseTooltip);
        Intrinsics.e(pauseTooltip, "pauseTooltip");
        ee.mtakso.driver.uikit.utils.ViewExtKt.d(pauseTooltip, true, 0, 2, null);
        this$0.Q().j3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z1(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.screens.order.v2.map.BottomOffsetProvider
    public LiveData<Integer> B() {
        return this.I;
    }

    public final AppThemeManager L0() {
        AppThemeManager appThemeManager = this.f31866w;
        if (appThemeManager != null) {
            return appThemeManager;
        }
        Intrinsics.w("appThemeManager");
        return null;
    }

    public final DriverConfig M0() {
        DriverConfig driverConfig = this.f31860q;
        if (driverConfig != null) {
            return driverConfig;
        }
        Intrinsics.w("driverConfig");
        return null;
    }

    public final DriverProvider N0() {
        DriverProvider driverProvider = this.f31859p;
        if (driverProvider != null) {
            return driverProvider;
        }
        Intrinsics.w("driverProvider");
        return null;
    }

    public final HtmlEngine O0() {
        HtmlEngine htmlEngine = this.f31868y;
        if (htmlEngine != null) {
            return htmlEngine;
        }
        Intrinsics.w("htmlEngine");
        return null;
    }

    public final LanguageManager P0() {
        LanguageManager languageManager = this.f31865v;
        if (languageManager != null) {
            return languageManager;
        }
        Intrinsics.w("languageManager");
        return null;
    }

    public final PushDialogDelegate Q0() {
        PushDialogDelegate pushDialogDelegate = this.f31863t;
        if (pushDialogDelegate != null) {
            return pushDialogDelegate;
        }
        Intrinsics.w("pushDialogDelegate");
        return null;
    }

    public final RoutingManager R0() {
        RoutingManager routingManager = this.f31867x;
        if (routingManager != null) {
            return routingManager;
        }
        Intrinsics.w("routingManager");
        return null;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity
    protected void T() {
        Injector.f20166d.b().Y1().k(this);
    }

    public final UiNotificationManager U0() {
        UiNotificationManager uiNotificationManager = this.f31861r;
        if (uiNotificationManager != null) {
            return uiNotificationManager;
        }
        Intrinsics.w("uiNotificationManager");
        return null;
    }

    public final CompositeUrlLauncher V0() {
        CompositeUrlLauncher compositeUrlLauncher = this.f31864u;
        if (compositeUrlLauncher != null) {
            return compositeUrlLauncher;
        }
        Intrinsics.w("urlLauncher");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity
    /* renamed from: W0 */
    public OrderViewModel Q() {
        return (OrderViewModel) this.O.getValue();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity
    protected void X(Throwable error) {
        Intrinsics.f(error, "error");
        FragmentUtils.c(NotificationDialog.Companion.c(NotificationDialog.f28313n, this, error, null, 4, null), this, "error");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z7;
        int i8 = R.id.pauseTooltip;
        View pauseTooltip = z0(i8);
        Intrinsics.e(pauseTooltip, "pauseTooltip");
        if (pauseTooltip.getVisibility() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            View pauseTooltip2 = z0(i8);
            Intrinsics.e(pauseTooltip2, "pauseTooltip");
            ee.mtakso.driver.uikit.utils.ViewExtKt.d(pauseTooltip2, false, 0, 2, null);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ThemeActivityExtKt.a(this, L0().c());
        setContentView(R.layout.activity_active_ride);
        CoordinatorLayout rootCoordinator = (CoordinatorLayout) z0(R.id.rootCoordinator);
        Intrinsics.e(rootCoordinator, "rootCoordinator");
        this.H = new RetryController(rootCoordinator);
        ControllableBottomSheetBehavior.Companion companion = ControllableBottomSheetBehavior.H;
        FrameLayout actionSheetContainer = (FrameLayout) z0(R.id.actionSheetContainer);
        Intrinsics.e(actionSheetContainer, "actionSheetContainer");
        ControllableBottomSheetBehavior<View> a8 = companion.a(actionSheetContainer);
        this.C = a8;
        if (a8 == null) {
            Intrinsics.w("bottomSheetBehavior");
            a8 = null;
        }
        a8.d0(new ComponentBottomSheetBehavior.BottomSheetCallback() { // from class: ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity$onCreate$1
            @Override // ee.mtakso.driver.utils.bottomsheet.ComponentBottomSheetBehavior.BottomSheetCallback
            public void a(View bottomSheet, float f8) {
                Intrinsics.f(bottomSheet, "bottomSheet");
            }

            @Override // ee.mtakso.driver.utils.bottomsheet.ComponentBottomSheetBehavior.BottomSheetCallback
            public void b(View bottomSheet, int i8) {
                int height;
                MutableLiveData mutableLiveData;
                ControllableBottomSheetBehavior controllableBottomSheetBehavior;
                Intrinsics.f(bottomSheet, "bottomSheet");
                ControllableBottomSheetBehavior controllableBottomSheetBehavior2 = null;
                BottomBarState bottomBarState = null;
                if (i8 != 3) {
                    if (i8 == 4) {
                        controllableBottomSheetBehavior = ActiveRideActivity.this.C;
                        if (controllableBottomSheetBehavior == null) {
                            Intrinsics.w("bottomSheetBehavior");
                        } else {
                            controllableBottomSheetBehavior2 = controllableBottomSheetBehavior;
                        }
                        height = controllableBottomSheetBehavior2.P();
                        bottomBarState = BottomBarState.COLLAPSED;
                    } else {
                        height = 0;
                    }
                } else {
                    height = ((FrameLayout) ActiveRideActivity.this.z0(R.id.actionSheetContainer)).getHeight();
                    bottomBarState = BottomBarState.EXPANDED;
                }
                if (bottomBarState != null) {
                    ActiveRideActivity activeRideActivity = ActiveRideActivity.this;
                    activeRideActivity.Q().t3(bottomBarState);
                    if (height > 0) {
                        mutableLiveData = activeRideActivity.I;
                        mutableLiveData.o(Integer.valueOf(height));
                    }
                }
            }
        });
        L1();
        int i8 = R.id.f19826a1;
        ConstraintLayout buttonContainer = (ConstraintLayout) z0(i8);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        UiNotificationManager U0 = U0();
        OrderViewModel Q2 = Q();
        CompositeUrlLauncher V0 = V0();
        LanguageManager P0 = P0();
        boolean r7 = N0().q().r();
        Intrinsics.e(buttonContainer, "buttonContainer");
        Intrinsics.e(supportFragmentManager, "supportFragmentManager");
        this.D = new ActivityUiDelegate(buttonContainer, supportFragmentManager, Q2, V0, P0, U0, r7);
        ConstraintLayout buttonContainer2 = (ConstraintLayout) z0(i8);
        Intrinsics.e(buttonContainer2, "buttonContainer");
        this.E = new ChatUiDelegate(buttonContainer2, Q(), R0());
        ((ImageView) z0(R.id.internalNavigationButton)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.order.v2.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActiveRideActivity.Z0(ActiveRideActivity.this, view);
            }
        });
        ((ImageView) z0(R.id.externalNavigationButton)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.order.v2.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActiveRideActivity.a1(ActiveRideActivity.this, view);
            }
        });
        ((RoundButton) z0(R.id.sosButton)).setOnTouchListener(new View.OnTouchListener() { // from class: ee.mtakso.driver.ui.screens.order.v2.i
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean k12;
                k12 = ActiveRideActivity.k1(ActiveRideActivity.this, view, motionEvent);
                return k12;
            }
        });
        final boolean J = N0().q().J();
        final boolean Q3 = M0().Q();
        ((RoundButton) z0(R.id.safetyToolkitButton)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.order.v2.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActiveRideActivity.q1(ActiveRideActivity.this, Q3, view);
            }
        });
        ((ImageView) z0(R.id.extraInfoButton)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.order.v2.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActiveRideActivity.r1(ActiveRideActivity.this, view);
            }
        });
        ((RoundButton) z0(R.id.stopButton)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.order.v2.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActiveRideActivity.s1(ActiveRideActivity.this, view);
            }
        });
        Q().t2().i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveRideActivity.t1(ActiveRideActivity.this, (BottomWidgetStates) obj);
            }
        });
        Q().o3().i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveRideActivity.u1(ActiveRideActivity.this, (ScreenState) obj);
            }
        });
        Q().E2().i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveRideActivity.v1(ActiveRideActivity.this, (OrderData) obj);
            }
        });
        Q().y1().i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveRideActivity.w1(ActiveRideActivity.this, (NetworkConnectionStatus) obj);
            }
        });
        Q().I2().i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveRideActivity.b1(ActiveRideActivity.this, (PushMessage) obj);
            }
        });
        Q().P2().i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveRideActivity.c1(ActiveRideActivity.this, (Unit) obj);
            }
        });
        Q().D2().i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveRideActivity.d1(ActiveRideActivity.this, (ChatFragment$ChatParams) obj);
            }
        });
        Q().s2().i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveRideActivity.e1(ActiveRideActivity.this, (Boolean) obj);
            }
        });
        LiveData<Optional<NoAnswerIncomingCall>> C2 = Q().C2();
        final Function1<Optional<NoAnswerIncomingCall>, Unit> function1 = new Function1<Optional<NoAnswerIncomingCall>, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity$onCreate$16
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(final Optional<NoAnswerIncomingCall> optional) {
                SnackBarDelegate S0;
                if (!optional.d()) {
                    S0 = ActiveRideActivity.this.S0();
                    Text.Resource resource = new Text.Resource(R.string.voip_no_answer_incoming_call_title, null, 2, null);
                    Text.Resource resource2 = new Text.Resource(R.string.voip_no_answer_incoming_call_back, null, 2, null);
                    final ActiveRideActivity activeRideActivity = ActiveRideActivity.this;
                    Function1<View, Unit> function12 = new Function1<View, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity$onCreate$16.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final void b(View it) {
                            Intrinsics.f(it, "it");
                            VoipFloatingActivity.Companion companion2 = VoipFloatingActivity.f27818p;
                            ActiveRideActivity activeRideActivity2 = ActiveRideActivity.this;
                            CallBackFragment.Companion companion3 = CallBackFragment.C;
                            NoAnswerIncomingCall b8 = optional.b();
                            Intrinsics.e(b8, "call.value");
                            Bundle a9 = companion3.a(b8);
                            Intent intent = new Intent(activeRideActivity2, VoipFloatingActivity.class);
                            intent.putExtra("dialog_class_argument", CallBackFragment.class);
                            if (a9 != null) {
                                intent.putExtra("dialog_extra_params", a9);
                            }
                            intent.addFlags(268500992);
                            activeRideActivity2.startActivity(intent);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(View view) {
                            b(view);
                            return Unit.f50853a;
                        }
                    };
                    final ActiveRideActivity activeRideActivity2 = ActiveRideActivity.this;
                    S0.b(new SnackBarModel(0, resource, resource2, function12, null, new Function1<Snackbar, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity$onCreate$16.2
                        {
                            super(1);
                        }

                        public final void b(Snackbar snackbar) {
                            ActiveRideActivity.this.Q().j1();
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Snackbar snackbar) {
                            b(snackbar);
                            return Unit.f50853a;
                        }
                    }, 16, null));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<NoAnswerIncomingCall> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        C2.i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveRideActivity.f1(Function1.this, obj);
            }
        });
        Q().T2().i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveRideActivity.g1(ActiveRideActivity.this, (WarningMessage) obj);
            }
        });
        LiveData<Unit> y22 = Q().y2();
        final Function1<Unit, Unit> function12 = new Function1<Unit, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity$onCreate$18
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Unit unit) {
                SnackBarDelegate S0;
                S0 = ActiveRideActivity.this.S0();
                S0.b(new SnackBarModel(0, new Text.Resource(R.string.stop_already_added_info, null, 2, null), null, null, null, null, 60, null));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                b(unit);
                return Unit.f50853a;
            }
        };
        y22.i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveRideActivity.h1(Function1.this, obj);
            }
        });
        LiveData<Text> z22 = Q().z2();
        final Function1<Text, Unit> function13 = new Function1<Text, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity$onCreate$19
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Text text) {
                ActiveRideActivity activeRideActivity = ActiveRideActivity.this;
                Intrinsics.e(text, "text");
                activeRideActivity.E1(text);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Text text) {
                b(text);
                return Unit.f50853a;
            }
        };
        z22.i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveRideActivity.i1(Function1.this, obj);
            }
        });
        BaseDialogFragment.f41026i.a(getSupportFragmentManager(), "dialog_need_break_confirmation", this.B);
        LiveData<DidYouGetHelpType> x22 = Q().x2();
        final Function1<DidYouGetHelpType, Unit> function14 = new Function1<DidYouGetHelpType, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity$onCreate$20

            /* compiled from: ActiveRideActivity.kt */
            /* loaded from: classes3.dex */
            public /* synthetic */ class WhenMappings {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f31881a;

                static {
                    int[] iArr = new int[DidYouGetHelpType.values().length];
                    try {
                        iArr[DidYouGetHelpType.NO_HELP_NEEDED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[DidYouGetHelpType.REQUEST_HELP_FROM_BOLT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f31881a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DidYouGetHelpType didYouGetHelpType) {
                DidYouGetHelpFragment didYouGetHelpFragment;
                Text resource;
                SnackBarDelegate S0;
                Fragment findFragmentByTag = ActiveRideActivity.this.getSupportFragmentManager().findFragmentByTag("DidYouGetHelpFragment");
                if (findFragmentByTag instanceof DidYouGetHelpFragment) {
                    didYouGetHelpFragment = (DidYouGetHelpFragment) findFragmentByTag;
                } else {
                    didYouGetHelpFragment = null;
                }
                if (didYouGetHelpFragment != null) {
                    didYouGetHelpFragment.dismissAllowingStateLoss();
                }
                if (didYouGetHelpType != null) {
                    ActiveRideActivity activeRideActivity = ActiveRideActivity.this;
                    int i9 = WhenMappings.f31881a[didYouGetHelpType.ordinal()];
                    if (i9 != 1) {
                        if (i9 != 2) {
                            resource = new Text.Value("");
                        } else {
                            resource = new Text.Resource(R.string.request_help_from_bolt, null, 2, null);
                        }
                    } else {
                        resource = new Text.Resource(R.string.thanks_for_letting_us_know, null, 2, null);
                    }
                    Text text = resource;
                    if (didYouGetHelpType != DidYouGetHelpType.INITIAL) {
                        S0 = activeRideActivity.S0();
                        S0.b(new SnackBarModel(0, text, null, null, null, null, 60, null));
                    }
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DidYouGetHelpType didYouGetHelpType) {
                b(didYouGetHelpType);
                return Unit.f50853a;
            }
        };
        x22.i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveRideActivity.j1(Function1.this, obj);
            }
        });
        LiveData<SafetyFABButtonType> K2 = Q().K2();
        final Function1<SafetyFABButtonType, Unit> function15 = new Function1<SafetyFABButtonType, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity$onCreate$21

            /* compiled from: ActiveRideActivity.kt */
            /* loaded from: classes3.dex */
            public /* synthetic */ class WhenMappings {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f31884a;

                static {
                    int[] iArr = new int[SafetyFABButtonType.values().length];
                    try {
                        iArr[SafetyFABButtonType.ACTIVE_INCIDENT.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[SafetyFABButtonType.RECORDING_IN_PROGRESS.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[SafetyFABButtonType.RECORDING_PAUSED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[SafetyFABButtonType.DEFAULT_TOOLKIT.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    f31884a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(SafetyFABButtonType safetyFABButtonType) {
                int i9;
                if (J) {
                    if (safetyFABButtonType == null) {
                        i9 = -1;
                    } else {
                        i9 = WhenMappings.f31884a[safetyFABButtonType.ordinal()];
                    }
                    if (i9 != 1) {
                        if (i9 != 2) {
                            if (i9 != 3) {
                                if (i9 == 4) {
                                    ActiveRideActivity activeRideActivity = this;
                                    int i10 = R.id.safetyToolkitButton;
                                    Context context = ((RoundButton) activeRideActivity.z0(i10)).getContext();
                                    Intrinsics.e(context, "safetyToolkitButton.context");
                                    Integer valueOf = Integer.valueOf(ContextUtilsKt.d(context, R.attr.safetyToolkitIcon));
                                    Context context2 = ((RoundButton) this.z0(i10)).getContext();
                                    Intrinsics.e(context2, "safetyToolkitButton.context");
                                    activeRideActivity.A1(null, valueOf, null, ContextUtilsKt.b(context2, R.attr.backSecondary), 8);
                                    return;
                                }
                                return;
                            }
                            ActiveRideActivity activeRideActivity2 = this;
                            int i11 = R.id.safetyToolkitButton;
                            Context context3 = ((RoundButton) activeRideActivity2.z0(i11)).getContext();
                            Intrinsics.e(context3, "safetyToolkitButton.context");
                            Integer valueOf2 = Integer.valueOf(ContextUtilsKt.d(context3, R.attr.safetyToolkitAudioRecordingIcon));
                            Context context4 = ((RoundButton) this.z0(i11)).getContext();
                            Intrinsics.e(context4, "safetyToolkitButton.context");
                            activeRideActivity2.A1(null, valueOf2, null, ContextUtilsKt.b(context4, R.attr.backSecondary), 8);
                            return;
                        }
                        ActiveRideActivity activeRideActivity3 = this;
                        int i12 = R.id.safetyToolkitButton;
                        Context context5 = ((RoundButton) activeRideActivity3.z0(i12)).getContext();
                        Intrinsics.e(context5, "safetyToolkitButton.context");
                        Integer valueOf3 = Integer.valueOf(ContextUtilsKt.d(context5, R.attr.safetyToolkitAudioRecordingIcon));
                        Context context6 = ((RoundButton) this.z0(i12)).getContext();
                        Intrinsics.e(context6, "safetyToolkitButton.context");
                        activeRideActivity3.A1(null, valueOf3, null, ContextUtilsKt.b(context6, R.attr.backSecondary), 0);
                        return;
                    }
                    ActiveRideActivity activeRideActivity4 = this;
                    Integer valueOf4 = Integer.valueOf((int) R.drawable.ic_emergency_assist_24);
                    ActiveRideActivity activeRideActivity5 = this;
                    int i13 = R.id.safetyToolkitButton;
                    Context context7 = ((RoundButton) activeRideActivity5.z0(i13)).getContext();
                    Intrinsics.e(context7, "safetyToolkitButton.context");
                    Integer valueOf5 = Integer.valueOf(ContextUtilsKt.d(context7, R.attr.dynamicSafetyCritical));
                    Context context8 = ((RoundButton) this.z0(i13)).getContext();
                    Intrinsics.e(context8, "safetyToolkitButton.context");
                    activeRideActivity4.A1(valueOf4, null, valueOf5, ContextUtilsKt.b(context8, R.attr.backSafetyCritical), 8);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SafetyFABButtonType safetyFABButtonType) {
                b(safetyFABButtonType);
                return Unit.f50853a;
            }
        };
        K2.i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveRideActivity.l1(Function1.this, obj);
            }
        });
        LiveData<Boolean> O2 = Q().O2();
        final Function1<Boolean, Unit> function16 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity$onCreate$22
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(boolean z7) {
                if (J && Q3) {
                    if (!z7) {
                        ((AppCompatImageView) this.z0(R.id.newBadge)).setVisibility(0);
                    } else {
                        ((AppCompatImageView) this.z0(R.id.newBadge)).setVisibility(8);
                    }
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool.booleanValue());
                return Unit.f50853a;
            }
        };
        O2.i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveRideActivity.m1(Function1.this, obj);
            }
        });
        LiveData<Boolean> A1 = Q().A1();
        final Function1<Boolean, Unit> function17 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity$onCreate$23
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Boolean it) {
                RetryController retryController;
                retryController = ActiveRideActivity.this.H;
                if (retryController != null) {
                    View retry_container = ActiveRideActivity.this.z0(R.id.retry_container);
                    Intrinsics.e(retry_container, "retry_container");
                    Intrinsics.e(it, "it");
                    retryController.a(retry_container, it.booleanValue());
                }
                FrameLayout actionSheetContainer2 = (FrameLayout) ActiveRideActivity.this.z0(R.id.actionSheetContainer);
                Intrinsics.e(actionSheetContainer2, "actionSheetContainer");
                ee.mtakso.driver.uikit.utils.ViewExtKt.d(actionSheetContainer2, !it.booleanValue(), 0, 2, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        };
        A1.i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveRideActivity.n1(Function1.this, obj);
            }
        });
        ((RoundButton) z0(R.id.retry_container).findViewById(R.id.O9)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.order.v2.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActiveRideActivity.o1(ActiveRideActivity.this, view);
            }
        });
        LiveEvent<DriverAppDisabledReason> B2 = Q().B2();
        final Function1<DriverAppDisabledReason, Unit> function18 = new Function1<DriverAppDisabledReason, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity$onCreate$25
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverAppDisabledReason it) {
                ActiveRideActivity activeRideActivity = ActiveRideActivity.this;
                Intrinsics.e(it, "it");
                activeRideActivity.B1(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverAppDisabledReason driverAppDisabledReason) {
                b(driverAppDisabledReason);
                return Unit.f50853a;
            }
        };
        B2.i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveRideActivity.p1(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        DisposableExtKt.a(this.N);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ActivityUiDelegate activityUiDelegate = this.D;
        ChatUiDelegate chatUiDelegate = null;
        if (activityUiDelegate == null) {
            Intrinsics.w("uiDelegate");
            activityUiDelegate = null;
        }
        activityUiDelegate.h();
        ChatUiDelegate chatUiDelegate2 = this.E;
        if (chatUiDelegate2 == null) {
            Intrinsics.w("chatUiDelegate");
        } else {
            chatUiDelegate = chatUiDelegate2;
        }
        chatUiDelegate.h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        ActivityUiDelegate activityUiDelegate = this.D;
        if (activityUiDelegate == null) {
            Intrinsics.w("uiDelegate");
            activityUiDelegate = null;
        }
        activityUiDelegate.i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Q().e3();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        Window window = getWindow();
        if (window != null) {
            I0(window);
        }
        LiveData<Boolean> J2 = Q().J2();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity$onStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Boolean it) {
                ActiveRideActivity activeRideActivity = ActiveRideActivity.this;
                Intrinsics.e(it, "it");
                activeRideActivity.X0(it.booleanValue());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        };
        J2.i(this, new Observer() { // from class: ee.mtakso.driver.ui.screens.order.v2.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActiveRideActivity.z1(Function1.this, obj);
            }
        });
    }

    public View z0(int i8) {
        Map<Integer, View> map = this.P;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View findViewById = findViewById(i8);
            if (findViewById != null) {
                map.put(Integer.valueOf(i8), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }
}
