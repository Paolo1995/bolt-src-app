package ee.mtakso.driver.ui.screens.home.v3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.snackbar.Snackbar;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.network.client.driver.DriverStatusKt;
import ee.mtakso.driver.network.response.ErrorAction;
import ee.mtakso.driver.param.RateMeModel;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.push.PushMessage;
import ee.mtakso.driver.service.routing.AppRoutingManager;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.common.progress.view.ProgressViewController;
import ee.mtakso.driver.ui.common.progress.view.ProgressViewInflater;
import ee.mtakso.driver.ui.common.push.PushDialogDelegate;
import ee.mtakso.driver.ui.interactor.driver.MakeDriverInactiveStatus;
import ee.mtakso.driver.ui.interactor.driver.SetInactiveConfirmationSignal;
import ee.mtakso.driver.ui.interactor.modaldialog.PromoDialogEvent;
import ee.mtakso.driver.ui.interactor.promodialog.PromoDialog;
import ee.mtakso.driver.ui.interactor.warnings.WarningMessage;
import ee.mtakso.driver.ui.screens.Navigator;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.ToolbarAppearance;
import ee.mtakso.driver.ui.screens.destination.DestinationFragment;
import ee.mtakso.driver.ui.screens.dialogs.ConfirmationDialog;
import ee.mtakso.driver.ui.screens.dialogs.DynamicModalDialog;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeDialogDelegate;
import ee.mtakso.driver.ui.screens.history.list.OrderListFragment;
import ee.mtakso.driver.ui.screens.home.v3.HomeContainer;
import ee.mtakso.driver.ui.screens.home.v3.HomeViewModel;
import ee.mtakso.driver.ui.screens.home.v3.delegate.CancelledOrderDialogDelegate;
import ee.mtakso.driver.ui.screens.home.v3.delegate.CarUnavailableDialogDelegate;
import ee.mtakso.driver.ui.screens.home.v3.delegate.DeeplinkDelegate;
import ee.mtakso.driver.ui.screens.home.v3.delegate.NavigatorChooserDelegate;
import ee.mtakso.driver.ui.screens.home.v3.delegate.OnBoardingDelegate;
import ee.mtakso.driver.ui.screens.home.v3.delegate.PromoDialogDelegate;
import ee.mtakso.driver.ui.screens.home.v3.delegate.TrainingDelegate;
import ee.mtakso.driver.ui.screens.home.v3.delegate.TrainingEvent;
import ee.mtakso.driver.ui.screens.home.v3.delegate.TrainingRetryAction;
import ee.mtakso.driver.ui.screens.home.v3.footer.FooterAppearance;
import ee.mtakso.driver.ui.screens.home.v3.footer.HomeFooterViewController;
import ee.mtakso.driver.ui.screens.home.v3.footer.HomeTab;
import ee.mtakso.driver.ui.screens.home.v3.header.HeaderAppearance;
import ee.mtakso.driver.ui.screens.home.v3.header.HomeHeaderViewController;
import ee.mtakso.driver.ui.screens.inbox.InboxFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper.LowStorageDialogDelegate;
import ee.mtakso.driver.ui.screens.settings.SettingsFragment;
import ee.mtakso.driver.ui.screens.work.GoOfflineIssueDialogDelegate;
import ee.mtakso.driver.ui.screens.work.WorkFragment;
import ee.mtakso.driver.ui.views.animation.WorkingProgressAnimation;
import ee.mtakso.driver.ui.views.warnings.WarningLabelDelegate;
import ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import eu.bolt.driver.core.R$style;
import eu.bolt.driver.core.utils.AssertUtils;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: HomeFragment.kt */
/* loaded from: classes3.dex */
public final class HomeFragment extends BazeMvvmFragment<HomeViewModel> implements HomeContainer, Navigator {
    public static final Companion P = new Companion(null);
    private final Lazy A;
    private final Lazy B;
    private final Lazy C;
    private final Lazy D;
    private final KClass<InboxFragment> E;
    private final KClass<OrderListFragment> F;
    private HomeHeaderViewController G;
    private HomeFooterViewController H;
    private WorkingProgressAnimation I;
    private WarningLabelDelegate J;
    private final ArrayList<HomeTab> K;
    private final int L;
    private final Function3<DialogFragment, View, Object, Unit> M;
    private Navigator N;
    public Map<Integer, View> O;

    /* renamed from: o  reason: collision with root package name */
    private final FragmentFactory f29749o;

    /* renamed from: p  reason: collision with root package name */
    private final NavigatorChooserDelegate f29750p;

    /* renamed from: q  reason: collision with root package name */
    private final PushDialogDelegate f29751q;

    /* renamed from: r  reason: collision with root package name */
    private final PromoDialogDelegate f29752r;

    /* renamed from: s  reason: collision with root package name */
    private final TrainingDelegate f29753s;

    /* renamed from: t  reason: collision with root package name */
    private final DeeplinkDelegate f29754t;

    /* renamed from: u  reason: collision with root package name */
    private final OnBoardingDelegate f29755u;

    /* renamed from: v  reason: collision with root package name */
    private final RateMeDialogDelegate f29756v;

    /* renamed from: w  reason: collision with root package name */
    private final AppRoutingManager f29757w;

    /* renamed from: x  reason: collision with root package name */
    private final CarUnavailableDialogDelegate f29758x;

    /* renamed from: y  reason: collision with root package name */
    private final DeeplinkHomeContainerCoordinator f29759y;

    /* renamed from: z  reason: collision with root package name */
    private final LowStorageDialogDelegate f29760z;

    /* compiled from: HomeFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: HomeFragment.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29761a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f29762b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f29763c;

        static {
            int[] iArr = new int[HomeTab.values().length];
            try {
                iArr[HomeTab.WORK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HomeTab.NEWS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HomeTab.HISTORY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HomeTab.SETTINGS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f29761a = iArr;
            int[] iArr2 = new int[SetInactiveConfirmationSignal.values().length];
            try {
                iArr2[SetInactiveConfirmationSignal.GO_OFFLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[SetInactiveConfirmationSignal.GO_OFFLINE_WITH_SURGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            f29762b = iArr2;
            int[] iArr3 = new int[OrderState.values().length];
            try {
                iArr3[OrderState.ORDER_STATE_DRIVER_REJECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[OrderState.ORDER_STATE_DRIVER_DID_NOT_RESPOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[OrderState.ORDER_STATE_CLIENT_DID_NOT_SHOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[OrderState.ORDER_STATE_CLIENT_CANCELLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[OrderState.ORDER_STATE_PAYMENT_BOOKING_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[OrderState.ORDER_STATE_FINISHED.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            f29763c = iArr3;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public HomeFragment(BaseUiDependencies deps, FragmentFactory fragmentFactory, NavigatorChooserDelegate navigatorChooserDelegate, PushDialogDelegate pushDialogDelegate, PromoDialogDelegate promoDialogDelegate, TrainingDelegate trainingDelegate, DeeplinkDelegate deeplinkDelegate, OnBoardingDelegate onBoardingDelegate, RateMeDialogDelegate rateMeDialogDelegate, AppRoutingManager routingManager, CarUnavailableDialogDelegate carUnavailableDialogDelegate, DeeplinkHomeContainerCoordinator deeplinkHomeContainerIntentCoordinator, LowStorageDialogDelegate lowStorageDialogDelegate) {
        super(deps, R.layout.activity_home, null, 4, null);
        Lazy b8;
        Lazy b9;
        Lazy b10;
        Lazy b11;
        Intrinsics.f(deps, "deps");
        Intrinsics.f(fragmentFactory, "fragmentFactory");
        Intrinsics.f(navigatorChooserDelegate, "navigatorChooserDelegate");
        Intrinsics.f(pushDialogDelegate, "pushDialogDelegate");
        Intrinsics.f(promoDialogDelegate, "promoDialogDelegate");
        Intrinsics.f(trainingDelegate, "trainingDelegate");
        Intrinsics.f(deeplinkDelegate, "deeplinkDelegate");
        Intrinsics.f(onBoardingDelegate, "onBoardingDelegate");
        Intrinsics.f(rateMeDialogDelegate, "rateMeDialogDelegate");
        Intrinsics.f(routingManager, "routingManager");
        Intrinsics.f(carUnavailableDialogDelegate, "carUnavailableDialogDelegate");
        Intrinsics.f(deeplinkHomeContainerIntentCoordinator, "deeplinkHomeContainerIntentCoordinator");
        Intrinsics.f(lowStorageDialogDelegate, "lowStorageDialogDelegate");
        this.O = new LinkedHashMap();
        this.f29749o = fragmentFactory;
        this.f29750p = navigatorChooserDelegate;
        this.f29751q = pushDialogDelegate;
        this.f29752r = promoDialogDelegate;
        this.f29753s = trainingDelegate;
        this.f29754t = deeplinkDelegate;
        this.f29755u = onBoardingDelegate;
        this.f29756v = rateMeDialogDelegate;
        this.f29757w = routingManager;
        this.f29758x = carUnavailableDialogDelegate;
        this.f29759y = deeplinkHomeContainerIntentCoordinator;
        this.f29760z = lowStorageDialogDelegate;
        b8 = LazyKt__LazyJVMKt.b(new Function0<Navigator>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeFragment$navigator$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Navigator invoke() {
                FragmentActivity activity = HomeFragment.this.getActivity();
                Intrinsics.d(activity, "null cannot be cast to non-null type ee.mtakso.driver.ui.screens.Navigator");
                return (Navigator) activity;
            }
        });
        this.A = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<ProgressViewController>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeFragment$loadingDialogDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final ProgressViewController invoke() {
                ProgressViewInflater progressViewInflater = ProgressViewInflater.f26390a;
                ConstraintLayout homeActivityContentContainer = (ConstraintLayout) HomeFragment.this.c0(R.id.homeActivityContentContainer);
                Intrinsics.e(homeActivityContentContainer, "homeActivityContentContainer");
                return progressViewInflater.c(homeActivityContentContainer);
            }
        });
        this.B = b9;
        b10 = LazyKt__LazyJVMKt.b(new Function0<CancelledOrderDialogDelegate>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeFragment$cancelledOrderDelegate$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final CancelledOrderDialogDelegate invoke() {
                return new CancelledOrderDialogDelegate();
            }
        });
        this.C = b10;
        b11 = LazyKt__LazyJVMKt.b(new Function0<GoOfflineIssueDialogDelegate>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeFragment$goOfflineIssueDelegate$2

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: HomeFragment.kt */
            /* renamed from: ee.mtakso.driver.ui.screens.home.v3.HomeFragment$goOfflineIssueDelegate$2$1  reason: invalid class name */
            /* loaded from: classes3.dex */
            public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ErrorAction, Unit> {
                AnonymousClass1(Object obj) {
                    super(1, obj, HomeFragment.class, "onGoOfflineErrorAction", "onGoOfflineErrorAction(Lee/mtakso/driver/network/response/ErrorAction;)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ErrorAction errorAction) {
                    j(errorAction);
                    return Unit.f50853a;
                }

                public final void j(ErrorAction p02) {
                    Intrinsics.f(p02, "p0");
                    ((HomeFragment) this.f50989g).n0(p02);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final GoOfflineIssueDialogDelegate invoke() {
                return new GoOfflineIssueDialogDelegate(new AnonymousClass1(HomeFragment.this));
            }
        });
        this.D = b11;
        this.E = Reflection.b(InboxFragment.class);
        this.F = Reflection.b(OrderListFragment.class);
        ArrayList<HomeTab> arrayList = new ArrayList<>();
        arrayList.add(HomeTab.WORK);
        this.K = arrayList;
        this.L = R$style.Theme_Dark;
        this.M = new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeFragment$onDialogConfirmationListener$1

            /* compiled from: HomeFragment.kt */
            /* loaded from: classes3.dex */
            public /* synthetic */ class WhenMappings {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f29769a;

                static {
                    int[] iArr = new int[SetInactiveConfirmationSignal.values().length];
                    try {
                        iArr[SetInactiveConfirmationSignal.GO_OFFLINE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[SetInactiveConfirmationSignal.GO_OFFLINE_WITH_SURGE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f29769a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public final void b(DialogFragment dialog, View view, Object obj) {
                HomeViewModel M;
                Intrinsics.f(dialog, "dialog");
                String tag = dialog.getTag();
                if (tag == null) {
                    tag = "";
                }
                int i8 = WhenMappings.f29769a[SetInactiveConfirmationSignal.valueOf(tag).ordinal()];
                if (i8 != 1) {
                    if (i8 == 2 && Intrinsics.a(obj, "confirm")) {
                        M = HomeFragment.this.M();
                        M.g1();
                    }
                } else if (Intrinsics.a(obj, "confirm")) {
                    SimpleActivity.Companion companion = SimpleActivity.f27004l;
                    Context requireContext = HomeFragment.this.requireContext();
                    Intrinsics.e(requireContext, "requireContext()");
                    SimpleActivity.Companion.m(companion, requireContext, DestinationFragment.class, null, false, 12, null);
                }
                dialog.dismissAllowingStateLoss();
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                b(dialogFragment, view, obj);
                return Unit.f50853a;
            }
        };
    }

    private final void A0() {
        CarUnavailableDialogDelegate carUnavailableDialogDelegate = this.f29758x;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        carUnavailableDialogDelegate.c(requireActivity);
        RestoreableDialogFragment.Companion companion = RestoreableDialogFragment.f34751j;
        RestoreableDialogFragment.Companion.b(companion, getParentFragmentManager(), "GO_OFFLINE", this.M, null, 8, null);
        RestoreableDialogFragment.Companion.b(companion, getParentFragmentManager(), "GO_OFFLINE_WITH_SURGE", this.M, null, 8, null);
        k0().c(this);
        LowStorageDialogDelegate lowStorageDialogDelegate = this.f29760z;
        FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
        Intrinsics.e(supportFragmentManager, "requireActivity().supportFragmentManager");
        lowStorageDialogDelegate.d(supportFragmentManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B0(HomeTab homeTab) {
        Class cls;
        Object i02;
        int i8 = WhenMappings.f29761a[homeTab.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 == 4) {
                        cls = SettingsFragment.class;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    cls = JvmClassMappingKt.a(this.F);
                }
            } else {
                cls = JvmClassMappingKt.a(this.E);
            }
        } else {
            cls = WorkFragment.class;
        }
        i02 = CollectionsKt___CollectionsKt.i0(this.K);
        if (i02 != homeTab) {
            this.K.add(homeTab);
            HomeContainer.DefaultImpls.a(this, cls, null, 2, null);
        }
    }

    private final void C0(OrderDetails orderDetails) {
        j0().b(this, orderDetails);
    }

    private final void D0(HomeViewModel.CarUnavailableDialog carUnavailableDialog) {
        CarUnavailableDialogDelegate carUnavailableDialogDelegate = this.f29758x;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        carUnavailableDialogDelegate.d(carUnavailableDialog, requireActivity);
    }

    private final void E0(SetInactiveConfirmationSignal setInactiveConfirmationSignal) {
        int i8;
        if (setInactiveConfirmationSignal == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f29762b[setInactiveConfirmationSignal.ordinal()];
        }
        if (i8 != 1) {
            if (i8 == 2) {
                H0();
                return;
            }
            return;
        }
        G0();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void F0(ee.mtakso.driver.service.order.details.OrderDetails r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof ee.mtakso.driver.service.order.details.FinishedOrderDetails
            if (r0 == 0) goto L7
            ee.mtakso.driver.service.order.details.FinishedOrderDetails r3 = (ee.mtakso.driver.service.order.details.FinishedOrderDetails) r3
            goto L8
        L7:
            r3 = 0
        L8:
            if (r3 == 0) goto L2c
            java.lang.String r0 = r3.e()
            r1 = 1
            if (r0 == 0) goto L1a
            boolean r0 = kotlin.text.StringsKt.y(r0)
            if (r0 == 0) goto L18
            goto L1a
        L18:
            r0 = 0
            goto L1b
        L1a:
            r0 = 1
        L1b:
            if (r0 != 0) goto L2c
            android.content.Context r0 = r2.requireContext()
            java.lang.String r3 = r3.e()
            android.widget.Toast r3 = android.widget.Toast.makeText(r0, r3, r1)
            r3.show()
        L2c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.home.v3.HomeFragment.F0(ee.mtakso.driver.service.order.details.OrderDetails):void");
    }

    private final void G0() {
        AssertUtils.c(getContext(), "HomeFragment not attached to context");
        if (getContext() == null) {
            return;
        }
        M().p1();
        ConfirmationDialog.Companion companion = ConfirmationDialog.f28256p;
        String string = getString(R.string.confirm_driver_destination_suggestion_title);
        Intrinsics.e(string, "getString(R.string.confi…ination_suggestion_title)");
        String string2 = getString(R.string.confirm_driver_destination_suggestion_message);
        Intrinsics.e(string2, "getString(R.string.confi…ation_suggestion_message)");
        String string3 = getString(R.string.confirm_driver_destination_positive);
        Intrinsics.e(string3, "getString(R.string.confi…ver_destination_positive)");
        ConfirmationDialog b8 = ConfirmationDialog.Companion.b(companion, string, string2, string3, null, UiKitRoundButtonType.f36162l, getString(R.string.confirm_driver_destination_negative), this.M, null, null, 392, null);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c(b8, requireActivity, "GO_OFFLINE");
    }

    private final void H0() {
        AssertUtils.c(getContext(), "HomeFragment not attached to context");
        if (getContext() == null) {
            return;
        }
        ConfirmationDialog.Companion companion = ConfirmationDialog.f28256p;
        String string = getString(R.string.stay_online_higher_rates_title);
        Intrinsics.e(string, "getString(R.string.stay_online_higher_rates_title)");
        String string2 = getString(R.string.stay_online_message);
        Intrinsics.e(string2, "getString(R.string.stay_online_message)");
        String string3 = getString(R.string.stay_online);
        Intrinsics.e(string3, "getString(R.string.stay_online)");
        ConfirmationDialog b8 = ConfirmationDialog.Companion.b(companion, string, string2, string3, null, UiKitRoundButtonType.f36162l, getString(R.string.confirm_driver_destination_negative), this.M, null, null, 392, null);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        FragmentUtils.c(b8, requireActivity, "GO_OFFLINE_WITH_SURGE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I0(MakeDriverInactiveStatus makeDriverInactiveStatus) {
        if (makeDriverInactiveStatus instanceof MakeDriverInactiveStatus.Inactive) {
            E0(((MakeDriverInactiveStatus.Inactive) makeDriverInactiveStatus).a());
        } else if (makeDriverInactiveStatus instanceof MakeDriverInactiveStatus.Failed) {
            k0().d(this, ((MakeDriverInactiveStatus.Failed) makeDriverInactiveStatus).a());
        }
    }

    private final void J0(OrderDetails orderDetails) {
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.a(g8, "Drawing terminated order: " + orderDetails, null, 2, null);
        }
        switch (WhenMappings.f29763c[orderDetails.b().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                C0(orderDetails);
                break;
            case 6:
                F0(orderDetails);
                break;
        }
        M().y0(orderDetails.a());
    }

    private final void h0(String str) {
        if (getChildFragmentManager().getBackStackEntryCount() > 1) {
            if (str == null) {
                getChildFragmentManager().popBackStack();
            } else {
                getChildFragmentManager().popBackStackImmediate(str, 1);
            }
            CollectionsKt__MutableCollectionsKt.K(this.K);
            return;
        }
        this.f29757w.b();
    }

    static /* synthetic */ void i0(HomeFragment homeFragment, String str, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = null;
        }
        homeFragment.h0(str);
    }

    private final CancelledOrderDialogDelegate j0() {
        return (CancelledOrderDialogDelegate) this.C.getValue();
    }

    private final GoOfflineIssueDialogDelegate k0() {
        return (GoOfflineIssueDialogDelegate) this.D.getValue();
    }

    private final ProgressViewController l0() {
        return (ProgressViewController) this.B.getValue();
    }

    private final Navigator m0() {
        return (Navigator) this.A.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(ErrorAction errorAction) {
        if (errorAction.b() == ErrorAction.Type.URL && errorAction.c() != null) {
            DeeplinkDelegate.f(this.f29754t, errorAction.c().a(), null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(HomeFragment this$0, OrderDetails it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.J0(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(HomeFragment this$0, WarningMessage warningMessage) {
        Intrinsics.f(this$0, "this$0");
        WarningLabelDelegate warningLabelDelegate = this$0.J;
        if (warningLabelDelegate != null) {
            warningLabelDelegate.h(warningMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(HomeFragment this$0, DriverStatus it) {
        Intrinsics.f(this$0, "this$0");
        Kalev.d("Driver state updated: " + it);
        HomeHeaderViewController homeHeaderViewController = this$0.G;
        HomeFooterViewController homeFooterViewController = null;
        if (homeHeaderViewController == null) {
            Intrinsics.w("headerController");
            homeHeaderViewController = null;
        }
        Intrinsics.e(it, "it");
        homeHeaderViewController.d(it);
        HomeFooterViewController homeFooterViewController2 = this$0.H;
        if (homeFooterViewController2 == null) {
            Intrinsics.w("footerController");
        } else {
            homeFooterViewController = homeFooterViewController2;
        }
        homeFooterViewController.k(it);
        if (DriverStatusKt.a(it)) {
            NavigatorChooserDelegate navigatorChooserDelegate = this$0.f29750p;
            FragmentActivity requireActivity = this$0.requireActivity();
            Intrinsics.e(requireActivity, "requireActivity()");
            navigatorChooserDelegate.b(requireActivity);
        }
        if (it == DriverStatus.PENDING) {
            this$0.I();
        } else {
            this$0.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(HomeFragment this$0, View view, Unit unit) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(view, "$view");
        if (this$0.I == null && view.getWidth() != 0) {
            this$0.I = new WorkingProgressAnimation(this$0.c0(R.id.startedWorkingProgressBar), view.getWidth(), System.currentTimeMillis());
        }
        WorkingProgressAnimation workingProgressAnimation = this$0.I;
        if (workingProgressAnimation != null) {
            workingProgressAnimation.b(System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(HomeFragment this$0, PushMessage it) {
        Intrinsics.f(this$0, "this$0");
        PushDialogDelegate pushDialogDelegate = this$0.f29751q;
        Intrinsics.e(it, "it");
        FragmentActivity requireActivity = this$0.requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        pushDialogDelegate.b(it, requireActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(HomeFragment this$0, RateMeModel it) {
        Intrinsics.f(this$0, "this$0");
        RateMeDialogDelegate rateMeDialogDelegate = this$0.f29756v;
        Intrinsics.e(it, "it");
        Context requireContext = this$0.requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        FragmentActivity requireActivity = this$0.requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        rateMeDialogDelegate.c(it, requireContext, requireActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(HomeFragment this$0, HomeViewModel.CarUnavailableDialog it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.D0(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(HomeFragment this$0, PromoDialog it) {
        Intrinsics.f(this$0, "this$0");
        PromoDialogDelegate promoDialogDelegate = this$0.f29752r;
        FragmentActivity requireActivity = this$0.requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        Intrinsics.e(it, "it");
        PromoDialogDelegate.B(promoDialogDelegate, requireActivity, it, null, this$0.f29760z, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(HomeFragment this$0, TrainingEvent it) {
        Intrinsics.f(this$0, "this$0");
        TrainingDelegate trainingDelegate = this$0.f29753s;
        Intrinsics.e(it, "it");
        trainingDelegate.d(it, this$0);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void D() {
        this.O.clear();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public Integer F() {
        return Integer.valueOf(this.L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void G() {
        l0().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void H(Throwable error) {
        Intrinsics.f(error, "error");
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        Context requireContext = requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        FragmentUtils.b(NotificationDialog.Companion.c(companion, requireContext, error, null, 4, null), this, "error");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment
    public void I() {
        l0().b();
    }

    @Override // ee.mtakso.driver.ui.screens.home.v3.HomeContainer
    public void a(Class<? extends Fragment> fragmentClass, Bundle bundle) {
        Intrinsics.f(fragmentClass, "fragmentClass");
        Context context = getContext();
        if (context == null) {
            Kalev.e(new NullPointerException("The Fragment must be attached to activity to create a Fragment"), "Error");
            return;
        }
        getChildFragmentManager().beginTransaction().replace(R.id.homeActivityContent, FragmentFactoryUtils.b(this.f29749o, context, fragmentClass, bundle)).addToBackStack(fragmentClass.getSimpleName()).commitAllowingStateLoss();
    }

    @Override // ee.mtakso.driver.ui.screens.home.v3.HomeContainer
    public void b(HeaderAppearance header, FooterAppearance footer) {
        Intrinsics.f(header, "header");
        Intrinsics.f(footer, "footer");
        HomeHeaderViewController homeHeaderViewController = this.G;
        HomeFooterViewController homeFooterViewController = null;
        if (homeHeaderViewController == null) {
            Intrinsics.w("headerController");
            homeHeaderViewController = null;
        }
        homeHeaderViewController.c(header);
        HomeFooterViewController homeFooterViewController2 = this.H;
        if (homeFooterViewController2 == null) {
            Intrinsics.w("footerController");
        } else {
            homeFooterViewController = homeFooterViewController2;
        }
        homeFooterViewController.i(footer);
    }

    @Override // ee.mtakso.driver.ui.screens.Navigator
    public boolean c() {
        i0(this, null, 1, null);
        return true;
    }

    public View c0(int i8) {
        View findViewById;
        Map<Integer, View> map = this.O;
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

    @Override // ee.mtakso.driver.ui.screens.Navigator
    public void d(Class<? extends Fragment> content, Bundle bundle, boolean z7) {
        Intrinsics.f(content, "content");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // ee.mtakso.driver.ui.screens.Navigator
    public Navigator e() {
        return this.N;
    }

    @Override // ee.mtakso.driver.ui.screens.home.v3.HomeContainer
    public void j(String str) {
        l0().a();
    }

    @Override // ee.mtakso.driver.ui.screens.home.v3.HomeContainer
    public void l(String str) {
        l0().b();
    }

    @Override // ee.mtakso.driver.ui.screens.Navigator
    public void n(ToolbarAppearance toolbarAppearance) {
        Intrinsics.f(toolbarAppearance, "toolbarAppearance");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i8, int i9, Intent intent) {
        if (!this.f29753s.b(i8, i9)) {
            super.onActivityResult(i8, i9, intent);
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.f(context, "context");
        super.onAttach(context);
        m0().q(this);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.J = new WarningLabelDelegate(activity);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        A0();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        D();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        m0().q(null);
        this.J = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        OnBoardingDelegate onBoardingDelegate = this.f29755u;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        boolean a8 = onBoardingDelegate.a(requireActivity);
        boolean g8 = this.f29754t.g(true);
        if (!a8 && !g8) {
            M().p0(PromoDialogEvent.HOME_SCREEN);
        }
        M().v0();
        this.f29752r.r(new Function1<DynamicModalDialog.ActionModel, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeFragment$onResume$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DynamicModalDialog.ActionModel it) {
                HomeViewModel M;
                Intrinsics.f(it, "it");
                M = HomeFragment.this.M();
                M.K0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DynamicModalDialog.ActionModel actionModel) {
                b(actionModel);
                return Unit.f50853a;
            }
        });
        this.f29752r.s(new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeFragment$onResume$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                HomeViewModel M;
                M = HomeFragment.this.M();
                M.Y0(TrainingRetryAction.RequestStart.f29927a);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.f(outState, "outState");
        outState.putParcelableArrayList("tab_tracker", this.K);
        super.onSaveInstanceState(outState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f29759y.c(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f29759y.a();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle bundle) {
        ArrayList parcelableArrayList;
        Intrinsics.f(view, "view");
        super.onViewCreated(view, bundle);
        ConstraintLayout homeHeader = (ConstraintLayout) c0(R.id.homeHeader);
        Intrinsics.e(homeHeader, "homeHeader");
        View homeDriverDestinationHint = c0(R.id.homeDriverDestinationHint);
        Intrinsics.e(homeDriverDestinationHint, "homeDriverDestinationHint");
        View homeDriverDestinationHintDismissTouchArea = c0(R.id.homeDriverDestinationHintDismissTouchArea);
        Intrinsics.e(homeDriverDestinationHintDismissTouchArea, "homeDriverDestinationHintDismissTouchArea");
        LinearLayout startedWorkingProgressBarLayout = (LinearLayout) c0(R.id.startedWorkingProgressBarLayout);
        Intrinsics.e(startedWorkingProgressBarLayout, "startedWorkingProgressBarLayout");
        this.G = new HomeHeaderViewController(homeHeader, homeDriverDestinationHint, homeDriverDestinationHintDismissTouchArea, startedWorkingProgressBarLayout, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                HomeViewModel M;
                M = HomeFragment.this.M();
                M.d1(false);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        }, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeFragment$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void b() {
                HomeFragment.this.c();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                b();
                return Unit.f50853a;
            }
        });
        if (bundle != null && (parcelableArrayList = bundle.getParcelableArrayList("tab_tracker")) != null) {
            this.K.clear();
            this.K.addAll(parcelableArrayList);
        }
        View homeViewNavBar = c0(R.id.homeViewNavBar);
        Intrinsics.e(homeViewNavBar, "homeViewNavBar");
        this.H = new HomeFooterViewController(homeViewNavBar, new Function1<HomeTab, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeFragment$onViewCreated$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(HomeTab it) {
                Intrinsics.f(it, "it");
                HomeFragment.this.B0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HomeTab homeTab) {
                b(homeTab);
                return Unit.f50853a;
            }
        });
        M().A0().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.home.v3.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.s0(HomeFragment.this, (DriverStatus) obj);
            }
        });
        M().C0().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.home.v3.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.t0(HomeFragment.this, view, (Unit) obj);
            }
        });
        M().E0().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.home.v3.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.u0(HomeFragment.this, (PushMessage) obj);
            }
        });
        M().F0().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.home.v3.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.v0(HomeFragment.this, (RateMeModel) obj);
            }
        });
        LiveEvent<HomeViewModel.CarUnavailableDialog> z02 = M().z0();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.e(viewLifecycleOwner, "viewLifecycleOwner");
        z02.i(viewLifecycleOwner, new Observer() { // from class: ee.mtakso.driver.ui.screens.home.v3.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.w0(HomeFragment.this, (HomeViewModel.CarUnavailableDialog) obj);
            }
        });
        LiveEvent<PromoDialog> D0 = M().D0();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.e(viewLifecycleOwner2, "viewLifecycleOwner");
        D0.i(viewLifecycleOwner2, new Observer() { // from class: ee.mtakso.driver.ui.screens.home.v3.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.x0(HomeFragment.this, (PromoDialog) obj);
            }
        });
        LiveEvent<TrainingEvent> I0 = M().I0();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.e(viewLifecycleOwner3, "viewLifecycleOwner");
        I0.i(viewLifecycleOwner3, new Observer() { // from class: ee.mtakso.driver.ui.screens.home.v3.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.y0(HomeFragment.this, (TrainingEvent) obj);
            }
        });
        M().H0().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.home.v3.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.o0(HomeFragment.this, (OrderDetails) obj);
            }
        });
        M().J0().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.home.v3.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.p0(HomeFragment.this, (WarningMessage) obj);
            }
        });
        LiveData<MakeDriverInactiveStatus> B0 = M().B0();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<MakeDriverInactiveStatus, Unit> function1 = new Function1<MakeDriverInactiveStatus, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeFragment$onViewCreated$14
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(MakeDriverInactiveStatus makeDriverInactiveStatus) {
                HomeFragment.this.I0(makeDriverInactiveStatus);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MakeDriverInactiveStatus makeDriverInactiveStatus) {
                b(makeDriverInactiveStatus);
                return Unit.f50853a;
            }
        };
        B0.i(viewLifecycleOwner4, new Observer() { // from class: ee.mtakso.driver.ui.screens.home.v3.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.q0(Function1.this, obj);
            }
        });
        LiveData<String> G0 = M().G0();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        final Function1<String, Unit> function12 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeFragment$onViewCreated$15
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String str) {
                Snackbar.v0(HomeFragment.this.requireView(), str, -1).e0();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        G0.i(viewLifecycleOwner5, new Observer() { // from class: ee.mtakso.driver.ui.screens.home.v3.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HomeFragment.r0(Function1.this, obj);
            }
        });
        this.f29753s.e(new Function1<TrainingRetryAction, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v3.HomeFragment$onViewCreated$16
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(TrainingRetryAction it) {
                HomeViewModel M;
                Intrinsics.f(it, "it");
                M = HomeFragment.this.M();
                M.Y0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TrainingRetryAction trainingRetryAction) {
                b(trainingRetryAction);
                return Unit.f50853a;
            }
        });
        if (getChildFragmentManager().getFragments().isEmpty() && bundle == null) {
            HomeContainer.DefaultImpls.a(this, WorkFragment.class, null, 2, null);
        }
        j0().a(this);
        PromoDialogDelegate promoDialogDelegate = this.f29752r;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.e(requireActivity, "requireActivity()");
        promoDialogDelegate.q(requireActivity);
    }

    @Override // ee.mtakso.driver.ui.screens.Navigator
    public void q(Navigator navigator) {
        this.N = navigator;
    }

    @Override // ee.mtakso.driver.ui.screens.Navigator
    public void x(eu.bolt.driver.core.ui.common.activity.ToolbarAppearance toolbarAppearance) {
        Navigator.DefaultImpls.a(this, toolbarAppearance);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    /* renamed from: z0 */
    public HomeViewModel Q() {
        BaseUiDependencies E;
        E = E();
        return (HomeViewModel) new ViewModelProvider(this, E.d()).a(HomeViewModel.class);
    }
}
