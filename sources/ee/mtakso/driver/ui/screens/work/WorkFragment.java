package ee.mtakso.driver.ui.screens.work;

import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.airbnb.lottie.LottieAnimationView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.helper.DateTimeConverter;
import ee.mtakso.driver.network.client.campaign.DriverCampaign;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.network.client.driver.DriverStatusKt;
import ee.mtakso.driver.network.client.driver.PricingData;
import ee.mtakso.driver.network.client.driver.PricingRequiredAction;
import ee.mtakso.driver.network.client.earnings.EarningsScreenType;
import ee.mtakso.driver.network.client.settings.DriverDestination;
import ee.mtakso.driver.network.client.settings.DriverPricing;
import ee.mtakso.driver.network.client.work_time.WorkingTimeInfo;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverReferralCampaignManager;
import ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.PermissionAnalytics;
import ee.mtakso.driver.service.geo.GeoLocationManager;
import ee.mtakso.driver.service.geo.state.GeoLocationIssue;
import ee.mtakso.driver.service.modules.status.GoOnlineIssue;
import ee.mtakso.driver.service.settings.AutoAcceptanceState;
import ee.mtakso.driver.service.settings.CategorySelectionAutoAcceptanceState;
import ee.mtakso.driver.service.settings.CategorySelectionState;
import ee.mtakso.driver.ui.base.mvvm.BaseUiDependencies;
import ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.LiveDataNotification;
import ee.mtakso.driver.ui.common.map.MapPaddingViewModel;
import ee.mtakso.driver.ui.interactor.driver.WorkRadius;
import ee.mtakso.driver.ui.interactor.map.HeatmapStatus;
import ee.mtakso.driver.ui.interactor.modaldialog.FifoModal;
import ee.mtakso.driver.ui.interactor.promodialog.PromoDialog;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.campaigns.v2.ActiveCampaignsFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.circlek.CircleKLoyaltyFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignDetailsFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.details.ReferralCampaignDetailsFragment;
import ee.mtakso.driver.ui.screens.campaigns.v2.optin.OptInCampaignFragment;
import ee.mtakso.driver.ui.screens.car_chooser.CarChooserActivity;
import ee.mtakso.driver.ui.screens.destination.DestinationFragment;
import ee.mtakso.driver.ui.screens.destination.active.state.DriverDestinationActiveStateFragment;
import ee.mtakso.driver.ui.screens.dialogs.ConfirmationWithIconDialog;
import ee.mtakso.driver.ui.screens.dialogs.DynamicModalDialog;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.ui.screens.earnings.v2.EarningsActivity;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.DriverActivityFragment;
import ee.mtakso.driver.ui.screens.home.v3.HomeContainer;
import ee.mtakso.driver.ui.screens.home.v3.delegate.DeeplinkDelegate;
import ee.mtakso.driver.ui.screens.home.v3.delegate.PromoDialogDelegate;
import ee.mtakso.driver.ui.screens.home.v3.footer.appearance.WorkTabAppearance;
import ee.mtakso.driver.ui.screens.home.v3.header.appearance.OfflineButtonsHolder;
import ee.mtakso.driver.ui.screens.home.v3.header.appearance.RightButton;
import ee.mtakso.driver.ui.screens.home.v3.header.appearance.WorkPageAppearance;
import ee.mtakso.driver.ui.screens.home.v3.map.WorkMapFragment;
import ee.mtakso.driver.ui.screens.modal.ModalAction;
import ee.mtakso.driver.ui.screens.modal.ModalDelegate;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper.LowStorageDialogDelegate;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.permission.MicrophonePermissionDialogProvider;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.did_you_get_help.DidYouGetHelpType;
import ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyToolkitBottomSheetFragment;
import ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home.SafetyTooltipState;
import ee.mtakso.driver.ui.screens.safety_toolkit.utils.SafetyFABButtonType;
import ee.mtakso.driver.ui.screens.safety_toolkit.utils.SafetyUIUtils;
import ee.mtakso.driver.ui.screens.score.DriverScoreFragment;
import ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsFragment;
import ee.mtakso.driver.ui.screens.sos.SosDialogFragment;
import ee.mtakso.driver.ui.screens.time_limit.WorkTimeFragment;
import ee.mtakso.driver.ui.screens.work.dashboard.DashboardState;
import ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsDialog;
import ee.mtakso.driver.ui.screens.work.map.MapSettingsFragment;
import ee.mtakso.driver.ui.toolkit.safetytoolkit.SafetyToolkitTooltipDelegate;
import ee.mtakso.driver.ui.toolkit.safetytoolkit.TooltipType;
import ee.mtakso.driver.uicore.components.views.swipe.SwipeButton;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.Utils;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.driver.core.network.client.driver.DriverFeaturesConfig;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment;
import eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback;
import eu.bolt.driver.core.ui.common.snackbar.SnackBarDelegate;
import eu.bolt.driver.core.ui.common.snackbar.SnackBarModel;
import eu.bolt.driver.earnings.network.DriverButtonAction;
import eu.bolt.kalev.Kalev;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes5.dex */
public class WorkFragment extends BazeMvvmFragment<WorkViewModel> {
    private TextView A;
    private SnackBarDelegate A0;
    private ViewGroup B;
    CompositeDisposable B0;
    private TextView C;
    ActivityResultLauncher<Intent> C0;
    private TextView D;
    DefaultDialogCallback D0;
    private TextView E;
    private TextView F;
    private Guideline G;
    private RoundButton H;
    private RoundButton I;
    private ImageView J;
    private ViewGroup K;
    private ViewGroup L;
    private TextView M;
    private ImageView N;
    private RoundButton O;
    private RoundButton P;
    private LottieAnimationView Q;
    private AppCompatImageView R;
    private RoundButton S;
    private MapPaddingViewModel T;
    private ImageView U;
    private MapSettingsStatusController V;
    protected HomeContainer W;
    private Toast X;
    private final DriverProvider Y;
    private final DriverConfig Z;

    /* renamed from: a0  reason: collision with root package name */
    private final DateTimeConverter f33688a0;

    /* renamed from: b0  reason: collision with root package name */
    private final DriverReferralCampaignManager f33689b0;

    /* renamed from: c0  reason: collision with root package name */
    private final ViewModelProvider.Factory f33690c0;

    /* renamed from: d0  reason: collision with root package name */
    private final Features f33691d0;

    /* renamed from: e0  reason: collision with root package name */
    private final DeeplinkDelegate f33692e0;

    /* renamed from: f0  reason: collision with root package name */
    private final GeoLocationManager f33693f0;

    /* renamed from: g0  reason: collision with root package name */
    private final DriverPricingAnalytics f33694g0;

    /* renamed from: h0  reason: collision with root package name */
    private final PermissionAnalytics f33695h0;

    /* renamed from: i0  reason: collision with root package name */
    private final PromoDialogDelegate f33696i0;

    /* renamed from: j0  reason: collision with root package name */
    private final PermissionManager f33697j0;

    /* renamed from: k0  reason: collision with root package name */
    private final HtmlEngine f33698k0;

    /* renamed from: l0  reason: collision with root package name */
    private final ModalDelegate f33699l0;

    /* renamed from: m0  reason: collision with root package name */
    private final MicrophonePermissionDialogProvider f33700m0;

    /* renamed from: n0  reason: collision with root package name */
    private final LowStorageDialogDelegate f33701n0;

    /* renamed from: o  reason: collision with root package name */
    private ViewGroup f33702o;

    /* renamed from: o0  reason: collision with root package name */
    private boolean f33703o0;

    /* renamed from: p  reason: collision with root package name */
    private View f33704p;

    /* renamed from: p0  reason: collision with root package name */
    private boolean f33705p0;

    /* renamed from: q  reason: collision with root package name */
    private TextView f33706q;

    /* renamed from: q0  reason: collision with root package name */
    private WorkPricingDelegate f33707q0;

    /* renamed from: r  reason: collision with root package name */
    private View f33708r;

    /* renamed from: r0  reason: collision with root package name */
    private WorkStatisticsLayoutDelegate f33709r0;

    /* renamed from: s  reason: collision with root package name */
    private View f33710s;

    /* renamed from: s0  reason: collision with root package name */
    private WorkStatisticsInnerLayoutDelegate f33711s0;

    /* renamed from: t  reason: collision with root package name */
    private ViewGroup f33712t;

    /* renamed from: t0  reason: collision with root package name */
    private WorkDashboardInnerLayoutDelegate f33713t0;

    /* renamed from: u  reason: collision with root package name */
    private View f33714u;

    /* renamed from: u0  reason: collision with root package name */
    private WorkFifoQueueDelegate f33715u0;

    /* renamed from: v  reason: collision with root package name */
    private View f33716v;

    /* renamed from: v0  reason: collision with root package name */
    private GoOnlineIssueDialogDelegate f33717v0;

    /* renamed from: w  reason: collision with root package name */
    private View f33718w;

    /* renamed from: w0  reason: collision with root package name */
    private PricingUnavailableDialogDelegate f33719w0;

    /* renamed from: x  reason: collision with root package name */
    protected View f33720x;

    /* renamed from: x0  reason: collision with root package name */
    private WorkPageAppearance f33721x0;

    /* renamed from: y  reason: collision with root package name */
    private SwipeButton f33722y;

    /* renamed from: y0  reason: collision with root package name */
    private SafetyToolkitTooltipDelegate f33723y0;

    /* renamed from: z  reason: collision with root package name */
    private View f33724z;

    /* renamed from: z0  reason: collision with root package name */
    private final Handler f33725z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ee.mtakso.driver.ui.screens.work.WorkFragment$7  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33732a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f33733b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f33734c;

        /* renamed from: d  reason: collision with root package name */
        static final /* synthetic */ int[] f33735d;

        /* renamed from: e  reason: collision with root package name */
        static final /* synthetic */ int[] f33736e;

        static {
            int[] iArr = new int[ActiveCampaignTileType.values().length];
            f33736e = iArr;
            try {
                iArr[ActiveCampaignTileType.DRIVER_REFERRAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33736e[ActiveCampaignTileType.OPT_IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33736e[ActiveCampaignTileType.CIRCLE_K.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[AutoAcceptanceState.values().length];
            f33735d = iArr2;
            try {
                iArr2[AutoAcceptanceState.ACTIVATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33735d[AutoAcceptanceState.DEACTIVATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[CategorySelectionState.values().length];
            f33734c = iArr3;
            try {
                iArr3[CategorySelectionState.PROMOTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f33734c[CategorySelectionState.ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr4 = new int[DriverFeaturesConfig.WorkingTimeMode.values().length];
            f33733b = iArr4;
            try {
                iArr4[DriverFeaturesConfig.WorkingTimeMode.ACCUMULATING.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f33733b[DriverFeaturesConfig.WorkingTimeMode.ROLLING.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f33733b[DriverFeaturesConfig.WorkingTimeMode.DISABLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr5 = new int[SafetyFABButtonType.values().length];
            f33732a = iArr5;
            try {
                iArr5[SafetyFABButtonType.ACTIVE_INCIDENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f33732a[SafetyFABButtonType.RECORDING_IN_PROGRESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f33732a[SafetyFABButtonType.RECORDING_PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f33732a[SafetyFABButtonType.DEFAULT_TOOLKIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public enum OvertimeState {
        NONE,
        NEAR_TO_OVERTIME,
        OVERTIME
    }

    @Inject
    public WorkFragment(@NonNull BaseUiDependencies baseUiDependencies, DriverProvider driverProvider, DateTimeConverter dateTimeConverter, DriverReferralCampaignManager driverReferralCampaignManager, Features features, DeeplinkDelegate deeplinkDelegate, GeoLocationManager geoLocationManager, DriverPricingAnalytics driverPricingAnalytics, PromoDialogDelegate promoDialogDelegate, PermissionManager permissionManager, HtmlEngine htmlEngine, ModalDelegate modalDelegate, DriverConfig driverConfig, MicrophonePermissionDialogProvider microphonePermissionDialogProvider, PermissionAnalytics permissionAnalytics, LowStorageDialogDelegate lowStorageDialogDelegate) {
        super(baseUiDependencies, R.layout.fragment_work_container, null);
        this.f33705p0 = false;
        this.f33723y0 = null;
        this.f33725z0 = new Handler(Looper.getMainLooper());
        this.A0 = null;
        this.B0 = new CompositeDisposable();
        this.C0 = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: ee.mtakso.driver.ui.screens.work.j0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                WorkFragment.this.H1((ActivityResult) obj);
            }
        });
        this.D0 = new DefaultDialogCallback() { // from class: ee.mtakso.driver.ui.screens.work.WorkFragment.1
            @Override // eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback, eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void a(@NonNull BaseDialogFragment baseDialogFragment, @NonNull View view, @NonNull Object obj) {
                if (obj == "confirm") {
                    WorkFragment.this.o1().j3();
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", WorkFragment.this.requireContext().getPackageName(), null));
                    WorkFragment.this.requireContext().startActivity(intent);
                    return;
                }
                WorkFragment.this.o1().i3();
            }
        };
        this.Y = driverProvider;
        this.f33688a0 = dateTimeConverter;
        this.f33689b0 = driverReferralCampaignManager;
        this.f33690c0 = baseUiDependencies.d();
        this.f33691d0 = features;
        this.f33692e0 = deeplinkDelegate;
        this.f33693f0 = geoLocationManager;
        this.f33694g0 = driverPricingAnalytics;
        this.f33696i0 = promoDialogDelegate;
        this.f33697j0 = permissionManager;
        this.f33698k0 = htmlEngine;
        this.f33699l0 = modalDelegate;
        this.Z = driverConfig;
        this.f33700m0 = microphonePermissionDialogProvider;
        this.f33695h0 = permissionAnalytics;
        this.f33701n0 = lowStorageDialogDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit A1() {
        B2();
        return Unit.f50853a;
    }

    private void A2(long j8) {
        SimpleActivity.S(requireContext(), CampaignDetailsFragment.class, CampaignDetailsFragment.A.a(j8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit B1() {
        z2();
        return Unit.f50853a;
    }

    private void B2() {
        SimpleActivity.R(requireContext(), ActiveCampaignsFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit C1() {
        D2();
        return Unit.f50853a;
    }

    private void C2() {
        o1().L1();
        o1().g3();
        SimpleActivity.T(requireContext(), DriverScoreFragment.class, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit D1() {
        J2();
        return Unit.f50853a;
    }

    private void D2() {
        if ((!w1() && !u1()) || (!w1() && t1())) {
            h1();
        } else if (o1().v1()) {
            startActivity(EarningsActivity.u0(requireContext(), EarningsScreenType.EARNINGS));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit E1() {
        C2();
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Unit E2(ModalAction modalAction) {
        o1().H2(modalAction);
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit F1(ActiveCampaignTileType activeCampaignTileType, Long l8) {
        int i8 = AnonymousClass7.f33736e[activeCampaignTileType.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    o1().w1();
                }
                Kalev.d("Not recognized tile type click event received from WorkStatisticsLayoutDelegate!");
            } else {
                SimpleActivity.S(requireContext(), OptInCampaignFragment.class, OptInCampaignFragment.f27598v.a(l8.longValue()));
            }
        } else {
            SimpleActivity.R(requireContext(), ReferralCampaignDetailsFragment.class);
        }
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Unit F2() {
        o1().D2();
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit G1(DriverCampaign driverCampaign) {
        A2(driverCampaign.c());
        return Unit.f50853a;
    }

    private void G2() {
        SimpleActivity.T(requireContext(), PricingSettingsFragment.class, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H1(ActivityResult activityResult) {
        if (activityResult.b() == -1 || activityResult.b() == 0) {
            o1().M2(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Unit H2(PricingRequiredAction pricingRequiredAction, PricingData pricingData) {
        if (pricingRequiredAction.b() != null) {
            this.f33692e0.d(pricingRequiredAction.b());
        } else {
            o1().g1(pricingData);
        }
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit I1() {
        M().h3();
        ((DialogFragment) FragmentFactoryUtils.a(Injector.f2().Y1().b(), requireContext(), MapSettingsFragment.class)).show(getParentFragmentManager(), "map_settings");
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Unit I2(PricingRequiredAction pricingRequiredAction) {
        if (pricingRequiredAction.b() != null) {
            this.f33692e0.d(pricingRequiredAction.b());
        }
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J1(View view) {
        G2();
    }

    private void J2() {
        if (!w1()) {
            h1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K1(View view) {
        p1();
    }

    private void K2(String str) {
        SimpleActivity.S(requireContext(), DriverDestinationActiveStateFragment.class, DriverDestinationActiveStateFragment.f28175q.a(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit L1(DynamicModalDialog.ActionModel actionModel) {
        o1().M2(actionModel);
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit M1() {
        p1();
        return Unit.f50853a;
    }

    private void M2() {
        this.f33709r0.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit N1() {
        this.W.a(WorkTimeFragment.class, null);
        return Unit.f50853a;
    }

    private void N2() {
        if (Build.VERSION.SDK_INT >= 33) {
            PermissionManager.PermissionInfo o8 = this.f33697j0.o("android.permission.POST_NOTIFICATIONS");
            if (o8.d() == PermissionManager.PermissionStatus.GRANTED) {
                return;
            }
            PermissionManager.Companion companion = PermissionManager.f40899f;
            boolean a8 = companion.a(o8);
            boolean b8 = companion.b(o8);
            if (!a8 && !b8) {
                this.f33697j0.j("android.permission.POST_NOTIFICATIONS", getContext()).I(new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.a1
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        WorkFragment.p2((PermissionManager.PermissionInfo) obj);
                    }
                }, new Consumer() { // from class: ee.mtakso.driver.ui.screens.work.b1
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        WorkFragment.q2((Throwable) obj);
                    }
                });
                return;
            }
            this.Y.v().i0(this.Y.v().C() + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit O1(RoundButton roundButton, Boolean bool) {
        if (bool.booleanValue()) {
            h3(roundButton);
        } else {
            e1(roundButton);
        }
        return Unit.f50853a;
    }

    private void O2(final DriverDestination driverDestination) {
        o1().e3();
        this.f33724z.setVisibility(0);
        this.A.setText(k1(driverDestination));
        ViewExtKt.c(this.f33724z, new Function0() { // from class: ee.mtakso.driver.ui.screens.work.g1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit r22;
                r22 = WorkFragment.this.r2();
                return r22;
            }
        });
        this.f33724z.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.i1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkFragment.this.s2(driverDestination, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit P1(boolean z7, RoundButton roundButton) {
        o1().k3();
        f3(z7);
        return Unit.f50853a;
    }

    private void P2() {
        this.f33709r0.p(this.f33703o0, t1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Q1(boolean z7, boolean z8, Boolean bool) {
        boolean z9;
        if (bool.booleanValue()) {
            c3(z7, z8);
        } else {
            if (this.Y.m().M() != DriverFeaturesConfig.WorkingTimeMode.DISABLED) {
                z9 = true;
            } else {
                z9 = false;
            }
            a3(z9, z7, z8);
        }
        return Unit.f50853a;
    }

    private void Q2() {
        this.f33709r0.q(t1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R1(View view) {
        o1().G2();
    }

    private void R2() {
        if (!Utils.g(getContext())) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(13);
            layoutParams.bottomMargin = this.f33709r0.i() + Dimens.d(10);
            this.f33702o.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S1(View view) {
        o1().L2();
    }

    private void S2(boolean z7) {
        if (z7) {
            this.f33704p.setVisibility(0);
        } else {
            this.f33704p.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T1(View view) {
        g1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T2 */
    public void o2(boolean z7, SafetyFABButtonType safetyFABButtonType) {
        if (z7) {
            int i8 = AnonymousClass7.f33732a[safetyFABButtonType.ordinal()];
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        if (i8 == 4) {
                            U2(null, Integer.valueOf(ContextUtilsKt.d(this.P.getContext(), R.attr.safetyToolkitIcon)), null, Integer.valueOf(ContextUtilsKt.b(this.P.getContext(), R.attr.backSecondary)), 8);
                            return;
                        }
                        return;
                    }
                    U2(null, Integer.valueOf(ContextUtilsKt.d(this.P.getContext(), R.attr.safetyToolkitAudioRecordingIcon)), null, Integer.valueOf(ContextUtilsKt.b(this.P.getContext(), R.attr.backSecondary)), 8);
                    return;
                }
                U2(null, Integer.valueOf(ContextUtilsKt.d(this.P.getContext(), R.attr.safetyToolkitAudioRecordingIcon)), null, Integer.valueOf(ContextUtilsKt.b(this.P.getContext(), R.attr.backSecondary)), 0);
                return;
            }
            U2(Integer.valueOf((int) R.drawable.ic_emergency_assist_24), null, Integer.valueOf(ContextUtilsKt.d(this.P.getContext(), R.attr.dynamicSafetyCritical)), Integer.valueOf(ContextUtilsKt.b(this.P.getContext(), R.attr.backSafetyCritical)), 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U1(View view) {
        o1().X0();
    }

    private void U2(Integer num, Integer num2, Integer num3, Integer num4, int i8) {
        if (num != null) {
            this.P.b(num.intValue());
        }
        if (num2 != null) {
            this.P.b(num2.intValue());
        }
        this.P.setIconTint(num3);
        this.P.setBgColor(num4.intValue());
        if (u1()) {
            SafetyUIUtils.f32878a.b(this.Q, i8);
        } else {
            SafetyUIUtils.f32878a.b(this.Q, 8);
        }
        this.f33721x0.J(num, num2, num3, num4.intValue(), i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SwipeButton.State V1(SwipeButton.State state) {
        SwipeButton.State state2 = SwipeButton.State.SWIPABLE;
        if (state == state2) {
            o1().J1();
            return state2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W1(View view) {
        o1().d3();
        g3();
    }

    private void W2() {
        this.f33709r0.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X1(Rect rect) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.G.getLayoutParams();
        int i8 = layoutParams.f4994a;
        int i9 = rect.top;
        if (i8 != i9) {
            layoutParams.f4994a = i9;
            this.G.setLayoutParams(layoutParams);
        }
    }

    private void X2() {
        this.f33711s0.I(o1().u1(), o1().v1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y1(WorkRadius workRadius) {
        if (workRadius instanceof WorkRadius.Enabled) {
            this.f33706q.setText(((WorkRadius.Enabled) workRadius).a());
            S2(true);
            return;
        }
        S2(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z1(DashboardState dashboardState) {
        if (dashboardState instanceof DashboardState.Loading) {
            this.f33718w.setVisibility(8);
            this.f33709r0.w();
        } else {
            this.f33709r0.l();
        }
        if (dashboardState instanceof DashboardState.Static) {
            this.f33716v.setVisibility(8);
            this.f33714u.setVisibility(0);
            this.f33718w.setVisibility(8);
            this.f33709r0.s(false);
            this.f33711s0.S((DashboardState.Static) dashboardState);
        }
        if (dashboardState instanceof DashboardState.Dynamic) {
            this.f33716v.setVisibility(0);
            this.f33714u.setVisibility(8);
            this.f33718w.setVisibility(8);
            this.f33709r0.s(false);
            this.f33713t0.j((DashboardState.Dynamic) dashboardState);
        }
        if (dashboardState instanceof DashboardState.FifoQueue) {
            this.f33716v.setVisibility(8);
            this.f33714u.setVisibility(8);
            this.f33718w.setVisibility(0);
            this.f33709r0.s(true);
            this.f33715u0.f((DashboardState.FifoQueue) dashboardState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z2(String str) {
        i3(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a2(LiveDataNotification liveDataNotification) {
        if (liveDataNotification.c()) {
            this.W.l("circle_k_magic_link");
        } else {
            this.W.j("circle_k_magic_link");
        }
        if (liveDataNotification.b() != null) {
            CircleKLoyaltyFragment.e0(requireContext(), (String) liveDataNotification.b());
        } else if (liveDataNotification.a() != null) {
            FragmentUtils.c(NotificationDialog.Q(requireContext(), liveDataNotification.a(), null), requireActivity(), "error");
        }
    }

    private void a3(boolean z7, boolean z8, boolean z9) {
        this.f33709r0.v();
        this.f33707q0.a();
        P2();
        R2();
        if (!z7) {
            h1();
        } else {
            P2();
        }
        this.U.setVisibility(8);
        SafetyTooltipState f8 = o1().u2().f();
        if (f8 != null && u1()) {
            b3(z8, z9, f8);
        }
        Boolean f9 = o1().v2().f();
        if (z8) {
            if (z9) {
                this.f33721x0.L(8);
                if (f9 != null && !f9.booleanValue()) {
                    this.R.setVisibility(0);
                } else {
                    this.R.setVisibility(8);
                }
            }
            o1().q2().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.c1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WorkFragment.this.t2((SafetyFABButtonType) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b2(GeoLocationIssue geoLocationIssue) {
        if (geoLocationIssue == null) {
            return;
        }
        this.f33693f0.C(geoLocationIssue, requireActivity(), null);
    }

    private void b3(boolean z7, boolean z8, SafetyTooltipState safetyTooltipState) {
        if (z7) {
            if (!safetyTooltipState.b()) {
                this.f33725z0.postDelayed(new Runnable() { // from class: ee.mtakso.driver.ui.screens.work.e1
                    @Override // java.lang.Runnable
                    public final void run() {
                        WorkFragment.this.u2();
                    }
                }, 500L);
                o1().l3(safetyTooltipState.a(true, safetyTooltipState.c()));
            } else if (z8 && !safetyTooltipState.c()) {
                this.f33725z0.postDelayed(new Runnable() { // from class: ee.mtakso.driver.ui.screens.work.f1
                    @Override // java.lang.Runnable
                    public final void run() {
                        WorkFragment.this.v2();
                    }
                }, 500L);
                o1().l3(safetyTooltipState.a(safetyTooltipState.b(), true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c2(GoOnlineIssue goOnlineIssue) {
        if (goOnlineIssue == null) {
            return;
        }
        this.f33717v0.e(this, goOnlineIssue);
    }

    private void c3(boolean z7, boolean z8) {
        this.f33709r0.k();
        this.f33707q0.b();
        Q2();
        f1();
        R2();
        m1().f(this.f33709r0.i() + Dimens.d(10));
        this.U.setVisibility(0);
        Boolean f8 = o1().v2().f();
        if (z7) {
            o1().q2().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.d1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WorkFragment.this.w2((SafetyFABButtonType) obj);
                }
            });
            if (z8) {
                this.R.setVisibility(8);
                if (f8 != null && !f8.booleanValue()) {
                    this.f33721x0.L(0);
                } else {
                    this.f33721x0.L(8);
                }
            }
        }
    }

    private void d1() {
        m1().g(Dimens.d(10));
        this.f33724z.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d2(PromoDialog promoDialog) {
        this.f33696i0.A(requireActivity(), promoDialog, this.C0, this.f33701n0);
    }

    private void e1(RoundButton roundButton) {
        Fragment findFragmentByTag = getParentFragmentManager().findFragmentByTag("sosDialog");
        if (findFragmentByTag instanceof SosDialogFragment) {
            ((SosDialogFragment) findFragmentByTag).i0();
        }
        roundButton.setBgColor(ContextUtilsKt.b(requireContext(), R.attr.backSecondary));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e2(Unit unit) {
        CarChooserActivity.u0(requireContext());
    }

    private void e3(Optional<WorkingTimeInfo> optional) {
        WorkingTimeInfo c8 = optional.c();
        if (c8 == null) {
            return;
        }
        OvertimeState l12 = l1(c8);
        OvertimeState overtimeState = OvertimeState.OVERTIME;
        if (l12 == overtimeState && !this.f33705p0) {
            this.f33705p0 = true;
            d3();
        } else if (l12 != overtimeState) {
            this.f33705p0 = false;
        }
    }

    private void f1() {
        this.f33709r0.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f2(Unit unit) {
        Z2(getString(R.string.no_car_selected));
    }

    private void f3(boolean z7) {
        if (getParentFragmentManager().findFragmentByTag("safetyToolkitBottomSheet") == null) {
            ((SafetyToolkitBottomSheetFragment) FragmentFactoryUtils.a(Injector.f2().Y1().b(), requireContext(), SafetyToolkitBottomSheetFragment.class)).show(getParentFragmentManager(), "safetyToolkitBottomSheet");
        }
        if (z7) {
            o1().m3();
        }
    }

    private void g1() {
        this.W.a(WorkTimeFragment.class, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g2(Optional optional) {
        if (optional.d()) {
            d1();
        } else {
            O2((DriverDestination) optional.b());
        }
    }

    private void h1() {
        this.f33709r0.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h2(Optional optional) {
        this.f33707q0.d((DriverPricing) optional.c());
    }

    private void h3(RoundButton roundButton) {
        ((SosDialogFragment) FragmentFactoryUtils.a(Injector.f2().Y1().b(), requireContext(), SosDialogFragment.class)).show(getParentFragmentManager(), "sosDialog");
        roundButton.setBgColor(ContextUtilsKt.b(requireContext(), R.attr.accentRed));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1(FifoModal fifoModal) {
        this.f33699l0.k(this, this.f33712t, fifoModal.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i2(Unit unit) {
        this.f33719w0.a(this);
    }

    private void i3(String str) {
        if (getActivity() == null) {
            return;
        }
        Toast toast = this.X;
        if (toast != null && toast.getView() != null) {
            this.X.cancel();
            this.X = null;
        }
        Toast makeText = Toast.makeText(getActivity(), str, 0);
        this.X = makeText;
        makeText.show();
    }

    private HomeContainer j1() {
        if (getActivity() instanceof HomeContainer) {
            return (HomeContainer) getActivity();
        }
        if (getParentFragment() instanceof HomeContainer) {
            return (HomeContainer) getParentFragment();
        }
        throw new IllegalStateException("Failed to find title bar view");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j2(Unit unit) {
        g3();
    }

    private void j3(Optional<WorkingTimeInfo> optional) {
        OvertimeState l12;
        boolean z7;
        WorkingTimeInfo c8 = optional.c();
        if (c8 != null && u1() && (l12 = l1(c8)) != OvertimeState.NONE && this.Y.m().M() == DriverFeaturesConfig.WorkingTimeMode.ACCUMULATING) {
            String f8 = c8.f();
            String e8 = c8.e();
            if (l12 == OvertimeState.OVERTIME) {
                z7 = true;
            } else {
                z7 = false;
            }
            k3(f8, e8, z7);
        }
    }

    private String k1(DriverDestination driverDestination) {
        String f8 = driverDestination.f();
        f8.hashCode();
        if (!f8.equals("home")) {
            if (!f8.equals("favorite")) {
                return driverDestination.a();
            }
            return getString(R.string.colon_separator, getString(R.string.destination_category_favourite), driverDestination.a());
        }
        return getString(R.string.colon_separator, getString(R.string.destination_category_home), driverDestination.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k2(DriverStatus driverStatus) {
        if (DriverStatusKt.a(driverStatus)) {
            d1();
        }
    }

    private OvertimeState l1(WorkingTimeInfo workingTimeInfo) {
        if (this.Y.m().M() == DriverFeaturesConfig.WorkingTimeMode.DISABLED) {
            return OvertimeState.NONE;
        }
        if (workingTimeInfo == null) {
            return OvertimeState.NONE;
        }
        if (workingTimeInfo.g() <= 0) {
            return OvertimeState.OVERTIME;
        }
        if (workingTimeInfo.g() < TimeUnit.HOURS.toSeconds(2L)) {
            return OvertimeState.NEAR_TO_OVERTIME;
        }
        return OvertimeState.NONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l2(boolean z7, boolean z8, SafetyTooltipState safetyTooltipState) {
        if (u1()) {
            b3(z7, z8, safetyTooltipState);
        }
    }

    private void l3() {
        if (u1()) {
            P2();
        } else {
            Q2();
        }
    }

    private MapPaddingViewModel m1() {
        if (this.T == null) {
            this.T = (MapPaddingViewModel) new ViewModelProvider(requireActivity(), this.f33690c0).a(MapPaddingViewModel.class);
        }
        return this.T;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m2(boolean z7, boolean z8, Boolean bool) {
        if (z7 && z8) {
            if (u1()) {
                this.f33721x0.L(8);
                if (!bool.booleanValue()) {
                    this.R.setVisibility(0);
                    return;
                } else {
                    this.R.setVisibility(8);
                    return;
                }
            }
            this.R.setVisibility(8);
            if (!bool.booleanValue()) {
                this.f33721x0.L(0);
            } else {
                this.f33721x0.L(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m3(Optional<WorkingTimeInfo> optional) {
        V2(optional.c());
        if (!optional.d()) {
            j3(optional);
            e3(optional);
            return;
        }
        q1();
    }

    private RightButton n1(boolean z7) {
        if (z7) {
            return new RightButton(RightButton.SafetyType.SAFETY_TOOLKIT, this.P);
        }
        return new RightButton(RightButton.SafetyType.SOS, this.O);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n2(DidYouGetHelpType didYouGetHelpType) {
        Text.Resource resource;
        DidYouGetHelpFragment didYouGetHelpFragment = (DidYouGetHelpFragment) getParentFragmentManager().findFragmentByTag("DidYouGetHelpFragment");
        if (didYouGetHelpFragment != null) {
            didYouGetHelpFragment.dismissAllowingStateLoss();
        }
        if (didYouGetHelpType == DidYouGetHelpType.NO_HELP_NEEDED) {
            resource = new Text.Resource(R.string.thanks_for_letting_us_know, Collections.emptyList());
        } else {
            resource = new Text.Resource(R.string.request_help_from_bolt, Collections.emptyList());
        }
        Text.Resource resource2 = resource;
        if (didYouGetHelpType != DidYouGetHelpType.INITIAL) {
            this.A0.b(new SnackBarModel(0, resource2, null, null, null, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WorkViewModel o1() {
        return M();
    }

    private void p1() {
        o1().f3();
        DriverDestination o12 = o1().o1();
        if (o12 == null) {
            SimpleActivity.R(requireContext(), DestinationFragment.class);
        } else {
            K2(k1(o12));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p2(PermissionManager.PermissionInfo permissionInfo) throws Exception {
        Kalev.b("Notification permission" + permissionInfo.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q2(Throwable th) throws Exception {
        Kalev.d("Notification permission" + th);
    }

    private void r1() {
        this.f33716v.setVisibility(8);
        this.f33714u.setVisibility(8);
        this.f33718w.setVisibility(8);
        this.f33713t0 = new WorkDashboardInnerLayoutDelegate(this.f33716v, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkFragment.2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public Unit invoke() {
                WorkFragment.this.f33709r0.o();
                return null;
            }
        }, new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkFragment.3
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public Unit invoke(String str) {
                WorkFragment.this.f33692e0.d(str);
                return Unit.f50853a;
            }
        });
        this.f33709r0 = new WorkStatisticsLayoutDelegate(this.f33712t, this.f33713t0, new Function0<Integer>() { // from class: ee.mtakso.driver.ui.screens.work.WorkFragment.4
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public Integer invoke() {
                return Integer.valueOf(WorkFragment.this.f33720x.getHeight());
            }
        });
        this.f33715u0 = new WorkFifoQueueDelegate(this.f33712t, new Function1() { // from class: ee.mtakso.driver.ui.screens.work.x0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit x12;
                x12 = WorkFragment.this.x1((DriverButtonAction) obj);
                return x12;
            }
        }, new Function0() { // from class: ee.mtakso.driver.ui.screens.work.y0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit y12;
                y12 = WorkFragment.this.y1();
                return y12;
            }
        }, new Function0() { // from class: ee.mtakso.driver.ui.screens.work.z0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit z12;
                z12 = WorkFragment.this.z1();
                return z12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit r2() {
        if (this.f33724z != null) {
            m1().g(this.f33724z.getHeight() + Dimens.d(10));
            return null;
        }
        return null;
    }

    private void s1() {
        this.f33716v.setVisibility(8);
        this.f33714u.setVisibility(0);
        this.f33718w.setVisibility(8);
        this.f33711s0 = new WorkStatisticsInnerLayoutDelegate(this.f33714u, this.f33688a0, o1().W0(), o1().P2(), o1().S2(), this.f33689b0, new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.work.WorkFragment.5
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public Unit invoke() {
                WorkFragment.this.f33709r0.o();
                return null;
            }
        });
        this.f33709r0 = new WorkStatisticsLayoutDelegate(this.f33712t, this.f33711s0, new Function0<Integer>() { // from class: ee.mtakso.driver.ui.screens.work.WorkFragment.6
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public Integer invoke() {
                return Integer.valueOf(WorkFragment.this.f33720x.getHeight());
            }
        });
        this.f33711s0.B(new Function2() { // from class: ee.mtakso.driver.ui.screens.work.p0
            @Override // kotlin.jvm.functions.Function2
            public final Object s(Object obj, Object obj2) {
                Unit F1;
                F1 = WorkFragment.this.F1((ActiveCampaignTileType) obj, (Long) obj2);
                return F1;
            }
        });
        this.f33711s0.D(new Function1() { // from class: ee.mtakso.driver.ui.screens.work.q0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit G1;
                G1 = WorkFragment.this.G1((DriverCampaign) obj);
                return G1;
            }
        });
        this.f33711s0.C(new Function0() { // from class: ee.mtakso.driver.ui.screens.work.r0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit A1;
                A1 = WorkFragment.this.A1();
                return A1;
            }
        });
        this.f33711s0.E(new Function0() { // from class: ee.mtakso.driver.ui.screens.work.s0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit B1;
                B1 = WorkFragment.this.B1();
                return B1;
            }
        });
        this.f33711s0.F(new Function0() { // from class: ee.mtakso.driver.ui.screens.work.t0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit C1;
                C1 = WorkFragment.this.C1();
                return C1;
            }
        });
        this.f33711s0.G(new Function0() { // from class: ee.mtakso.driver.ui.screens.work.u0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit D1;
                D1 = WorkFragment.this.D1();
                return D1;
            }
        });
        this.f33711s0.H(new Function0() { // from class: ee.mtakso.driver.ui.screens.work.v0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit E1;
                E1 = WorkFragment.this.E1();
                return E1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s2(DriverDestination driverDestination, View view) {
        K2(k1(driverDestination));
    }

    private boolean t1() {
        if (v1().booleanValue()) {
            return false;
        }
        return this.f33711s0.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t2(SafetyFABButtonType safetyFABButtonType) {
        o2(true, safetyFABButtonType);
    }

    private boolean u1() {
        return o1().t1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u2() {
        this.f33723y0.y(TooltipType.SAFETY_TOOLKIT);
    }

    private Boolean v1() {
        return Boolean.valueOf(o1().s1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v2() {
        this.f33723y0.y(TooltipType.AUDIO_RECORDING);
    }

    private boolean w1() {
        return this.f33709r0.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w2(SafetyFABButtonType safetyFABButtonType) {
        o2(true, safetyFABButtonType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit x1(DriverButtonAction driverButtonAction) {
        o1().I2(driverButtonAction);
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit x2(DialogFragment dialogFragment, View view, Object obj) {
        if (obj.equals("confirm")) {
            this.W.a(WorkTimeFragment.class, null);
        }
        dialogFragment.dismiss();
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit y1() {
        o1().J2();
        return Unit.f50853a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y2(HeatmapStatus heatmapStatus) {
        this.V.b(heatmapStatus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit z1() {
        o1().K2();
        return Unit.f50853a;
    }

    private void z2() {
        if (o1().u1()) {
            o1().c3();
        }
        if (w1()) {
            SimpleActivity.T(requireContext(), DriverActivityFragment.class, null, true);
        } else {
            h1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment
    @NonNull
    /* renamed from: L2 */
    public WorkViewModel Q() {
        return (WorkViewModel) new ViewModelProvider(this, this.f33690c0).a(WorkViewModel.class);
    }

    public void V2(WorkingTimeInfo workingTimeInfo) {
        this.f33721x0.y(workingTimeInfo);
    }

    public void Y2(CategorySelectionAutoAcceptanceState categorySelectionAutoAcceptanceState) {
        int i8 = AnonymousClass7.f33734c[categorySelectionAutoAcceptanceState.b().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                int i9 = AnonymousClass7.f33735d[categorySelectionAutoAcceptanceState.a().ordinal()];
                if (i9 != 1) {
                    if (i9 != 2) {
                        this.H.setVisibility(8);
                        return;
                    }
                    this.H.setVisibility(0);
                    this.H.h();
                    this.H.setImageSize(Dimens.d(24));
                    this.H.b(R.drawable.ic_lightning);
                    RoundButton roundButton = this.H;
                    roundButton.setIconTint(Integer.valueOf(ContextUtilsKt.d(roundButton.getContext(), R.attr.contentSecondary)));
                    RoundButton roundButton2 = this.H;
                    roundButton2.setBgColor(ContextUtilsKt.b(roundButton2.getContext(), R.attr.backSecondary));
                    return;
                }
                this.H.setVisibility(0);
                this.H.h();
                this.H.setImageSize(Dimens.d(24));
                this.H.b(R.drawable.ic_lightning);
                RoundButton roundButton3 = this.H;
                roundButton3.setIconTint(Integer.valueOf(ContextUtilsKt.d(roundButton3.getContext(), R.attr.dynamicWhite)));
                RoundButton roundButton4 = this.H;
                roundButton4.setBgColor(ContextCompat.getColor(roundButton4.getContext(), R.color.dynamicPurple02));
                return;
            }
            this.H.setVisibility(0);
            RoundButton roundButton5 = this.H;
            roundButton5.setBgColor(ContextUtilsKt.b(roundButton5.getContext(), R.attr.backSecondary));
            this.H.b(R.drawable.ic_vehicle_fill);
            this.H.h();
            this.H.setImageSize(Dimens.d(24));
            RoundButton roundButton6 = this.H;
            roundButton6.setIconTint(Integer.valueOf(ContextUtilsKt.d(roundButton6.getContext(), R.attr.contentPrimary)));
            return;
        }
        this.H.setVisibility(0);
        RoundButton roundButton7 = this.H;
        roundButton7.setBgColor(ContextUtilsKt.b(roundButton7.getContext(), R.attr.backSecondary));
        this.H.b(R.drawable.ic_vehicle_fill);
        RoundButton roundButton8 = this.H;
        roundButton8.setIconTint(Integer.valueOf(ContextUtilsKt.d(roundButton8.getContext(), R.attr.contentPrimary)));
        this.H.l();
        this.H.setImageSize(Dimens.d(28));
    }

    public void d3() {
        String string;
        DriverFeaturesConfig.WorkingTimeMode M = this.Y.m().M();
        int i8 = AnonymousClass7.f33733b[M.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                string = getString(R.string.overtime_dialog_message_rolling);
            } else {
                throw new IllegalStateException("Illegal working time mode: " + M);
            }
        } else {
            string = getString(R.string.overtime_dialog_message);
        }
        FragmentUtils.c(ConfirmationWithIconDialog.R(getString(R.string.overtime_dialog_title), string, getString(R.string.read_more), UiKitRoundButtonType.f36161k, getString(R.string.close), new Function3() { // from class: ee.mtakso.driver.ui.screens.work.j1
            @Override // kotlin.jvm.functions.Function3
            public final Object l(Object obj, Object obj2, Object obj3) {
                Unit x22;
                x22 = WorkFragment.this.x2((DialogFragment) obj, (View) obj2, obj3);
                return x22;
            }
        }, R.drawable.ic_clock), requireActivity(), "TAG_CONFIRM_OVERTIME");
    }

    public void g3() {
        if (getChildFragmentManager().findFragmentByTag("category_picker") == null) {
            DispatchSettingsDialog.u0(this.Y.m().l()).show(getChildFragmentManager(), "category_picker");
        }
    }

    public void k3(String str, String str2, boolean z7) {
        this.f33703o0 = true;
        this.C.setText(str);
        this.D.setText(str2);
        this.C.setTextColor(ContextUtilsKt.b(this.H.getContext(), R.attr.contentCritical));
        f1();
        if (z7) {
            this.E.setText(getString(R.string.fatigue_maximum_working_hours_exceeded));
            this.F.setVisibility(8);
        } else {
            this.F.setVisibility(8);
            this.E.setText(getString(R.string.fatigue_you_have_less_than_2h_driving_time_left));
        }
        this.B.setVisibility(0);
        l3();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        getChildFragmentManager().setFragmentFactory(Injector.f2().Y1().b());
        super.onCreate(bundle);
        this.W = j1();
        GoOnlineIssueDialogDelegate goOnlineIssueDialogDelegate = new GoOnlineIssueDialogDelegate(this.f33694g0, this.f33698k0);
        this.f33717v0 = goOnlineIssueDialogDelegate;
        goOnlineIssueDialogDelegate.b(new Function0() { // from class: ee.mtakso.driver.ui.screens.work.f0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit F2;
                F2 = WorkFragment.this.F2();
                return F2;
            }
        });
        this.f33717v0.d(new Function1() { // from class: ee.mtakso.driver.ui.screens.work.g0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit I2;
                I2 = WorkFragment.this.I2((PricingRequiredAction) obj);
                return I2;
            }
        });
        this.f33717v0.c(new Function2() { // from class: ee.mtakso.driver.ui.screens.work.h0
            @Override // kotlin.jvm.functions.Function2
            public final Object s(Object obj, Object obj2) {
                Unit H2;
                H2 = WorkFragment.this.H2((PricingRequiredAction) obj, (PricingData) obj2);
                return H2;
            }
        });
        this.f33717v0.a(this);
        this.f33719w0 = new PricingUnavailableDialogDelegate();
        this.f33699l0.g(this, new Function1() { // from class: ee.mtakso.driver.ui.screens.work.i0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit E2;
                E2 = WorkFragment.this.E2((ModalAction) obj);
                return E2;
            }
        });
        this.f33701n0.d(getChildFragmentManager());
        BaseDialogFragment.J(getParentFragmentManager(), "permission_denied_dialog", this.D0);
        if (getChildFragmentManager().findFragmentByTag("work_map") == null) {
            getChildFragmentManager().beginTransaction().replace(R.id.workMapContainer, (WorkMapFragment) FragmentFactoryUtils.a(getChildFragmentManager().getFragmentFactory(), requireContext(), WorkMapFragment.class), "work_map").commit();
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f33702o = (ViewGroup) onCreateView.findViewById(R.id.bottomControls);
        this.f33704p = onCreateView.findViewById(R.id.radiusController);
        this.f33706q = (TextView) onCreateView.findViewById(R.id.plusMinusContainerTxt);
        this.f33708r = onCreateView.findViewById(R.id.minusBtn);
        this.f33710s = onCreateView.findViewById(R.id.plusBtn);
        this.f33720x = onCreateView.findViewById(R.id.workCoordinator);
        this.f33712t = (ViewGroup) onCreateView.findViewById(R.id.workStatisticsView);
        this.f33714u = onCreateView.findViewById(R.id.f679workStatisticsContentLayout);
        this.f33716v = onCreateView.findViewById(R.id.f201dashboardRecycler);
        this.f33718w = onCreateView.findViewById(R.id.fifoQueueLayout);
        this.f33722y = (SwipeButton) onCreateView.findViewById(R.id.f594startWorkBtn);
        this.f33724z = onCreateView.findViewById(R.id.activeDestinationContainer);
        this.A = (TextView) onCreateView.findViewById(R.id.activeDestinationAddress);
        this.B = (ViewGroup) onCreateView.findViewById(R.id.driver_fatigue_container);
        this.C = (TextView) onCreateView.findViewById(R.id.settingsDrivingTimeLeft);
        this.D = (TextView) onCreateView.findViewById(R.id.until_driving_resets);
        this.E = (TextView) onCreateView.findViewById(R.id.driver_fatigue_title);
        this.F = (TextView) onCreateView.findViewById(R.id.driver_fatigue_subtitle);
        this.H = (RoundButton) onCreateView.findViewById(R.id.categorySelectionButton);
        this.I = (RoundButton) onCreateView.findViewById(R.id.mapSettingsButton);
        this.J = (ImageView) onCreateView.findViewById(R.id.mapSettingsButtonBadge);
        this.G = (Guideline) onCreateView.findViewById(R.id.guidelineTop);
        this.K = (ViewGroup) onCreateView.findViewById(R.id.topButtonsLayout);
        this.L = (ViewGroup) onCreateView.findViewById(R.id.pricingLayout);
        this.M = (TextView) onCreateView.findViewById(R.id.pricingText);
        this.N = (ImageView) onCreateView.findViewById(R.id.pricingImage);
        this.O = (RoundButton) onCreateView.findViewById(R.id.f584sosButton);
        this.S = (RoundButton) onCreateView.findViewById(R.id.destinationButton);
        this.U = (ImageView) onCreateView.findViewById(R.id.f83bottomSheetIndicatorImageView);
        this.P = (RoundButton) onCreateView.findViewById(R.id.f564safetyToolkitButton);
        this.Q = (LottieAnimationView) onCreateView.findViewById(R.id.f44audioInProgressAnimationView);
        this.R = (AppCompatImageView) onCreateView.findViewById(R.id.f409newBadge);
        this.V = new MapSettingsStatusController(this.f33702o, this.I, this.J, new Function0() { // from class: ee.mtakso.driver.ui.screens.work.k0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit I1;
                I1 = WorkFragment.this.I1();
                return I1;
            }
        });
        if (v1().booleanValue()) {
            r1();
        } else {
            s1();
        }
        WorkPricingDelegate workPricingDelegate = new WorkPricingDelegate(this.L, this.M, this.N);
        this.f33707q0 = workPricingDelegate;
        workPricingDelegate.c(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkFragment.this.J1(view);
            }
        });
        this.f33707q0.d(null);
        this.S.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorkFragment.this.K1(view);
            }
        });
        this.f33696i0.r(new Function1() { // from class: ee.mtakso.driver.ui.screens.work.o0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit L1;
                L1 = WorkFragment.this.L1((DynamicModalDialog.ActionModel) obj);
                return L1;
            }
        });
        return onCreateView;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f33723y0.q();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        M2();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        W2();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f33723y0.x();
        if (!this.B0.isDisposed()) {
            this.B0.dispose();
        }
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BazeMvvmFragment, ee.mtakso.driver.ui.base.mvvm.BazeFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        o1().C();
        N2();
        final boolean J = this.Y.q().J();
        final boolean Q = this.Z.Q();
        OfflineButtonsHolder offlineButtonsHolder = new OfflineButtonsHolder(this.S, n1(J));
        this.f33723y0 = new SafetyToolkitTooltipDelegate(this.P, (ViewGroup) view, this.f33697j0, this, this.D0, this.f33700m0, this.f33695h0);
        this.A0 = new SnackBarDelegate(view, null);
        this.f33721x0 = new WorkPageAppearance(offlineButtonsHolder, this.Y, new Function0() { // from class: ee.mtakso.driver.ui.screens.work.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit M1;
                M1 = WorkFragment.this.M1();
                return M1;
            }
        }, new Function0() { // from class: ee.mtakso.driver.ui.screens.work.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit N1;
                N1 = WorkFragment.this.N1();
                return N1;
            }
        }, new Function2() { // from class: ee.mtakso.driver.ui.screens.work.s
            @Override // kotlin.jvm.functions.Function2
            public final Object s(Object obj, Object obj2) {
                Unit O1;
                O1 = WorkFragment.this.O1((RoundButton) obj, (Boolean) obj2);
                return O1;
            }
        }, new Function1() { // from class: ee.mtakso.driver.ui.screens.work.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit P1;
                P1 = WorkFragment.this.P1(Q, (RoundButton) obj);
                return P1;
            }
        }, new Function1() { // from class: ee.mtakso.driver.ui.screens.work.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Q1;
                Q1 = WorkFragment.this.Q1(J, Q, (Boolean) obj);
                return Q1;
            }
        });
        this.f33708r.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WorkFragment.this.R1(view2);
            }
        });
        this.f33710s.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WorkFragment.this.S1(view2);
            }
        });
        this.B.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WorkFragment.this.T1(view2);
            }
        });
        view.findViewById(R.id.activeDestinationCancel).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WorkFragment.this.U1(view2);
            }
        });
        this.W.b(this.f33721x0, new WorkTabAppearance());
        this.f33722y.setOnRequestStateChangeListener(new Function1() { // from class: ee.mtakso.driver.ui.screens.work.e0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SwipeButton.State V1;
                V1 = WorkFragment.this.V1((SwipeButton.State) obj);
                return V1;
            }
        });
        if (!v1().booleanValue()) {
            X2();
        }
        this.H.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WorkFragment.this.W1(view2);
            }
        });
        m1().i().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.a0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkFragment.this.X1((Rect) obj);
            }
        });
        o1().p2().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.l0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkFragment.this.Y1((WorkRadius) obj);
            }
        });
        o1().X1().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.w0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkFragment.this.Z1((DashboardState) obj);
            }
        });
        o1().V1().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.h1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkFragment.this.a2((LiveDataNotification) obj);
            }
        });
        o1().I1().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.k1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkFragment.this.b2((GeoLocationIssue) obj);
            }
        });
        o1().r1().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.l1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkFragment.this.c2((GoOnlineIssue) obj);
            }
        });
        o1().R2().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.m1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkFragment.this.d2((PromoDialog) obj);
            }
        });
        o1().N1().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.n1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkFragment.this.e2((Unit) obj);
            }
        });
        o1().M1().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkFragment.this.f2((Unit) obj);
            }
        });
        o1().j1().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkFragment.this.g2((Optional) obj);
            }
        });
        o1().l1().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkFragment.this.h2((Optional) obj);
            }
        });
        o1().Q2().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkFragment.this.i2((Unit) obj);
            }
        });
        o1().b3().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkFragment.this.Z2((String) obj);
            }
        });
        o1().k1().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkFragment.this.Y2((CategorySelectionAutoAcceptanceState) obj);
            }
        });
        o1().O1().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkFragment.this.j2((Unit) obj);
            }
        });
        o1().m1().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkFragment.this.k2((DriverStatus) obj);
            }
        });
        o1().n3().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkFragment.this.m3((Optional) obj);
            }
        });
        o1().u2().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkFragment.this.l2(J, Q, (SafetyTooltipState) obj);
            }
        });
        o1().v2().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkFragment.this.m2(J, Q, (Boolean) obj);
            }
        });
        o1().a2().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkFragment.this.n2((DidYouGetHelpType) obj);
            }
        });
        o1().q2().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkFragment.this.o2(J, (SafetyFABButtonType) obj);
            }
        });
        o1().n1().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkFragment.this.i1((FifoModal) obj);
            }
        });
        o1().K1().i(getViewLifecycleOwner(), new Observer() { // from class: ee.mtakso.driver.ui.screens.work.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WorkFragment.this.y2((HeatmapStatus) obj);
            }
        });
    }

    public void q1() {
        this.f33703o0 = false;
        this.B.setVisibility(8);
        l3();
    }
}
