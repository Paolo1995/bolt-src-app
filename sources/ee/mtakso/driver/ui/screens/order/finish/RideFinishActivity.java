package ee.mtakso.driver.ui.screens.order.finish;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.network.client.price.PriceReviewReason;
import ee.mtakso.driver.service.connectivity.NetworkConnectionStatus;
import ee.mtakso.driver.ui.base.mvvm.BaseDynamicTranslatedMvvmActivity;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.ObservableLiveData;
import ee.mtakso.driver.ui.common.internet.InternetDialogDelegate;
import ee.mtakso.driver.ui.interactor.warnings.WarningMessage;
import ee.mtakso.driver.ui.screens.order.arrived.DrivePriceViewModel;
import ee.mtakso.driver.ui.screens.order.arrived.PriceScreenState;
import ee.mtakso.driver.ui.screens.order.arrived.fragments.choose_problem_reason.ChoosePriceReviewDialog;
import ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.GivenPriceInfo;
import ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.PriceReviewResult;
import ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.ProblemWithPriceFragment;
import ee.mtakso.driver.ui.screens.order.arrived.raterider.RateRiderDialogFragment;
import ee.mtakso.driver.ui.screens.order.arrived.raterider.RiderRatingInfo;
import ee.mtakso.driver.ui.screens.order.finish.RideFinishActivity;
import ee.mtakso.driver.ui.theme.ThemeActivityExtKt;
import ee.mtakso.driver.ui.views.warnings.WarningLabelDelegate;
import ee.mtakso.driver.uicore.components.views.swipe.SwipeButton;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import eu.bolt.driver.core.theme.AppThemeManager;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RideFinishActivity.kt */
/* loaded from: classes3.dex */
public final class RideFinishActivity extends BaseDynamicTranslatedMvvmActivity<DrivePriceViewModel> {

    /* renamed from: w  reason: collision with root package name */
    private static final Companion f31330w = new Companion(null);
    @Inject

    /* renamed from: o  reason: collision with root package name */
    public AppThemeManager f31331o;

    /* renamed from: r  reason: collision with root package name */
    private final Lazy f31334r;

    /* renamed from: s  reason: collision with root package name */
    private final Function3<DialogFragment, View, Object, Unit> f31335s;

    /* renamed from: t  reason: collision with root package name */
    private final Function1<PriceReviewReason, Unit> f31336t;

    /* renamed from: u  reason: collision with root package name */
    private final Function3<DialogFragment, View, Object, Unit> f31337u;

    /* renamed from: v  reason: collision with root package name */
    public Map<Integer, View> f31338v = new LinkedHashMap();

    /* renamed from: p  reason: collision with root package name */
    private final WarningLabelDelegate f31332p = new WarningLabelDelegate(this);

    /* renamed from: q  reason: collision with root package name */
    private final InternetDialogDelegate f31333q = new InternetDialogDelegate();

    /* compiled from: RideFinishActivity.kt */
    /* loaded from: classes3.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RideFinishActivity() {
        Lazy b8;
        b8 = LazyKt__LazyJVMKt.b(new Function0<DrivePriceViewModel>() { // from class: ee.mtakso.driver.ui.screens.order.finish.RideFinishActivity$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final DrivePriceViewModel invoke() {
                RideFinishActivity rideFinishActivity = RideFinishActivity.this;
                return (DrivePriceViewModel) new ViewModelProvider(rideFinishActivity, rideFinishActivity.R()).a(DrivePriceViewModel.class);
            }
        });
        this.f31334r = b8;
        this.f31335s = new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.finish.RideFinishActivity$onDialogRateRiderListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public final void b(DialogFragment dialog, View view, Object obj) {
                Intrinsics.f(dialog, "dialog");
                if (obj != null && (obj instanceof RiderRatingInfo)) {
                    SwipeButton swipeButton = (SwipeButton) RideFinishActivity.this.f0(R.id.confirmPriceButton);
                    if (swipeButton != null) {
                        SwipeButton.L(swipeButton, SwipeButton.State.DONE, false, 2, null);
                    }
                    RideFinishActivity.this.Q().A0((RiderRatingInfo) obj);
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                b(dialogFragment, view, obj);
                return Unit.f50853a;
            }
        };
        this.f31336t = new Function1<PriceReviewReason, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.finish.RideFinishActivity$onChoosePriceReviewListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(PriceReviewReason it) {
                Intrinsics.f(it, "it");
                RideFinishActivity.this.Q().x0(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PriceReviewReason priceReviewReason) {
                b(priceReviewReason);
                return Unit.f50853a;
            }
        };
        this.f31337u = new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.finish.RideFinishActivity$onDrivePriceReviewListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public final void b(DialogFragment dialog, View view, Object obj) {
                Intrinsics.f(dialog, "dialog");
                if (obj != null && (obj instanceof PriceReviewResult)) {
                    RideFinishActivity.this.Q().z0((PriceReviewResult) obj);
                }
                dialog.dismiss();
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                b(dialogFragment, view, obj);
                return Unit.f50853a;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0() {
        DialogFragment dialogFragment;
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("rate_rider_tag");
        if (findFragmentByTag instanceof DialogFragment) {
            dialogFragment = (DialogFragment) findFragmentByTag;
        } else {
            dialogFragment = null;
        }
        if (dialogFragment != null) {
            dialogFragment.dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
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
    public static final void s0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(RideFinishActivity this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.Q().E0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0() {
        ChoosePriceReviewDialog choosePriceReviewDialog = (ChoosePriceReviewDialog) FragmentFactoryUtils.c(N(), this, ChoosePriceReviewDialog.class, null, 4, null);
        choosePriceReviewDialog.a0(this.f31336t);
        choosePriceReviewDialog.show(getSupportFragmentManager(), "choose_price_review_reason");
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity
    protected void T() {
        Injector.f20166d.b().Y1().E(this);
    }

    public View f0(int i8) {
        Map<Integer, View> map = this.f31338v;
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

    public final AppThemeManager n0() {
        AppThemeManager appThemeManager = this.f31331o;
        if (appThemeManager != null) {
            return appThemeManager;
        }
        Intrinsics.w("appThemeManager");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity
    /* renamed from: o0 */
    public DrivePriceViewModel Q() {
        return (DrivePriceViewModel) this.f31334r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseMvvmActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ThemeActivityExtKt.a(this, n0().c());
        setContentView(R.layout.activity_ride_finish);
        getSupportFragmentManager().setFragmentFactory(Injector.f20166d.b().Y1().b());
        LiveData<NetworkConnectionStatus> c02 = Q().c0();
        final Function1<NetworkConnectionStatus, Unit> function1 = new Function1<NetworkConnectionStatus, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.finish.RideFinishActivity$onCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(NetworkConnectionStatus it) {
                InternetDialogDelegate internetDialogDelegate;
                internetDialogDelegate = RideFinishActivity.this.f31333q;
                Intrinsics.e(it, "it");
                internetDialogDelegate.e(it, RideFinishActivity.this);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NetworkConnectionStatus networkConnectionStatus) {
                b(networkConnectionStatus);
                return Unit.f50853a;
            }
        };
        c02.i(this, new Observer() { // from class: t4.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RideFinishActivity.p0(Function1.this, obj);
            }
        });
        ObservableLiveData<WarningMessage> e02 = Q().e0();
        final Function1<WarningMessage, Unit> function12 = new Function1<WarningMessage, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.finish.RideFinishActivity$onCreate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(WarningMessage warningMessage) {
                WarningLabelDelegate warningLabelDelegate;
                warningLabelDelegate = RideFinishActivity.this.f31332p;
                warningLabelDelegate.h(warningMessage);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WarningMessage warningMessage) {
                b(warningMessage);
                return Unit.f50853a;
            }
        };
        e02.i(this, new Observer() { // from class: t4.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RideFinishActivity.q0(Function1.this, obj);
            }
        });
        LiveEvent<Unit> u02 = Q().u0();
        final Function1<Unit, Unit> function13 = new Function1<Unit, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.finish.RideFinishActivity$onCreate$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Unit unit) {
                RideFinishActivity.this.v0();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                b(unit);
                return Unit.f50853a;
            }
        };
        u02.i(this, new Observer() { // from class: t4.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RideFinishActivity.r0(Function1.this, obj);
            }
        });
        LiveData<Boolean> d02 = Q().d0();
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.finish.RideFinishActivity$onCreate$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Boolean it) {
                FrameLayout container = (FrameLayout) RideFinishActivity.this.f0(R.id.M2);
                Intrinsics.e(container, "container");
                ViewExtKt.e(container, !it.booleanValue(), 0, 2, null);
                View retryContainer = RideFinishActivity.this.f0(R.id.retryContainer);
                Intrinsics.e(retryContainer, "retryContainer");
                Intrinsics.e(it, "it");
                ViewExtKt.e(retryContainer, it.booleanValue(), 0, 2, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        };
        d02.i(this, new Observer() { // from class: t4.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RideFinishActivity.s0(Function1.this, obj);
            }
        });
        ((RoundButton) f0(R.id.retryContainer).findViewById(R.id.O9)).setOnClickListener(new View.OnClickListener() { // from class: t4.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RideFinishActivity.t0(RideFinishActivity.this, view);
            }
        });
        LiveData<PriceScreenState> n02 = Q().n0();
        final Function1<PriceScreenState, Unit> function15 = new Function1<PriceScreenState, Unit>() { // from class: ee.mtakso.driver.ui.screens.order.finish.RideFinishActivity$onCreate$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(PriceScreenState priceScreenState) {
                boolean a8;
                Function3<? super DialogFragment, ? super View, Object, Unit> function3;
                Function3<? super DialogFragment, ? super View, Object, Unit> function32;
                FragmentManager supportFragmentManager = RideFinishActivity.this.getSupportFragmentManager();
                RideFinishActivity rideFinishActivity = RideFinishActivity.this;
                if (Intrinsics.a(priceScreenState, PriceScreenState.PricePreviewScreen.f31070a)) {
                    a8 = true;
                } else {
                    a8 = Intrinsics.a(priceScreenState, PriceScreenState.Initial.f31069a);
                }
                if (a8) {
                    FragmentFactory fragmentFactory = supportFragmentManager.getFragmentFactory();
                    Intrinsics.e(fragmentFactory, "fragmentFactory");
                    supportFragmentManager.beginTransaction().replace(R.id.container, (PricePreviewFragment) FragmentFactoryUtils.c(fragmentFactory, rideFinishActivity, PricePreviewFragment.class, null, 4, null), "preview_price_tag").addToBackStack("preview_price_tag").commit();
                } else if (priceScreenState instanceof PriceScreenState.ProblemWithPrice) {
                    PriceScreenState.ProblemWithPrice problemWithPrice = (PriceScreenState.ProblemWithPrice) priceScreenState;
                    ProblemWithPriceFragment a9 = ProblemWithPriceFragment.f31147o.a(problemWithPrice.b(), new GivenPriceInfo(problemWithPrice.a().g(), problemWithPrice.a().f(), problemWithPrice.a().i(), problemWithPrice.a().c()), problemWithPrice.a().p());
                    FragmentUtils.c(a9, rideFinishActivity, "price_review_dialog");
                    function32 = rideFinishActivity.f31337u;
                    a9.K(function32);
                } else if (Intrinsics.a(priceScreenState, PriceScreenState.RateRider.f31073a)) {
                    rideFinishActivity.m0();
                    FragmentFactory fragmentFactory2 = supportFragmentManager.getFragmentFactory();
                    Intrinsics.e(fragmentFactory2, "fragmentFactory");
                    RateRiderDialogFragment rateRiderDialogFragment = (RateRiderDialogFragment) FragmentFactoryUtils.c(fragmentFactory2, rideFinishActivity, RateRiderDialogFragment.class, null, 4, null);
                    function3 = rideFinishActivity.f31335s;
                    rateRiderDialogFragment.K(function3);
                    FragmentManager supportFragmentManager2 = rideFinishActivity.getSupportFragmentManager();
                    Intrinsics.e(supportFragmentManager2, "supportFragmentManager");
                    rateRiderDialogFragment.show(supportFragmentManager2, "rate_rider_tag");
                } else if (Intrinsics.a(priceScreenState, PriceScreenState.SetPriceScreen.f31074a)) {
                    FragmentFactory fragmentFactory3 = supportFragmentManager.getFragmentFactory();
                    Intrinsics.e(fragmentFactory3, "fragmentFactory");
                    supportFragmentManager.beginTransaction().replace(R.id.container, (CustomPriceFragment) FragmentFactoryUtils.c(fragmentFactory3, rideFinishActivity, CustomPriceFragment.class, null, 4, null), "custom_price_tag").commit();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PriceScreenState priceScreenState) {
                b(priceScreenState);
                return Unit.f50853a;
            }
        };
        n02.i(this, new Observer() { // from class: t4.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RideFinishActivity.u0(Function1.this, obj);
            }
        });
    }
}
