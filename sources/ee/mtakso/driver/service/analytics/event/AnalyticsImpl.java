package ee.mtakso.driver.service.analytics.event;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.ImagesContract;
import ee.mtakso.driver.features.Feature;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.log.report.ReportManager;
import ee.mtakso.driver.model.CancellationReason;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.settings.SearchCategory;
import ee.mtakso.driver.network.usage.NetworkUsage;
import ee.mtakso.driver.network.usage.NetworkUsageUtils;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.service.analytics.AnalyticScope;
import ee.mtakso.driver.service.analytics.Scopes;
import ee.mtakso.driver.service.analytics.event.facade.AppPerformanceAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.AppStateAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.AppVerificationAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.AudioRecordingAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.AutoAcceptanceAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.BackendModalDialogAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.CampaignAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.ChatAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.DestinationAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.DeviceAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.DriverAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.DriverScoreAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.EarningsAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.EarningsGoalAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.EarningsV2Analytics;
import ee.mtakso.driver.service.analytics.event.facade.HeatmapAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.HistoryAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.LoginType;
import ee.mtakso.driver.service.analytics.event.facade.NetworkErrorAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.NewsAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.OptInCampaignAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.OrderAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.PartnerOffersAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.PermissionAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.ProcessRestorationAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.PushTokenAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.QuickAccessStateAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.RateMeAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SafetyToolkitAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SignUpAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.WebViewAnalytics;
import ee.mtakso.driver.utils.StringUtilsKt;
import eu.bolt.android.code.AppVerificationStatus;
import eu.bolt.driver.core.field.OverridableField;
import eu.bolt.driver.core.theme.AppThemeMode;
import eu.bolt.driver.stories.service.analytic.StoryAnalytics;
import eu.bolt.driver.verification.identity.VerificationAnalytics;
import eu.bolt.driver.verification.identity.VerificationEvent;
import eu.bolt.driver.verification.identity.VerificationScreen;
import eu.bolt.kalev.Kalev;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;
import org.webrtc.PeerConnectionFactory;

/* compiled from: AnalyticsImpl.kt */
/* loaded from: classes3.dex */
public final class AnalyticsImpl implements AppPerformanceAnalytics, AppStateAnalytics, AppVerificationAnalytics, AudioRecordingAnalytics, AutoAcceptanceAnalytics, BackendModalDialogAnalytics, CampaignAnalytics, ChatAnalytics, DestinationAnalytics, DeviceAnalytics, DriverAnalytics, DriverPricingAnalytics, DriverScoreAnalytics, EarningsAnalytics, EarningsGoalAnalytics, EarningsV2Analytics, HeatmapAnalytics, HistoryAnalytics, LoginAnalytics, NetworkErrorAnalytics, NewsAnalytics, OptInCampaignAnalytics, OrderAnalytics, OrderFlowAnalytics, PartnerOffersAnalytics, PayoutAnalytics, PermissionAnalytics, ProcessRestorationAnalytics, PushTokenAnalytics, RateMeAnalytics, ReferralCampaignsAnalytics, SafetyToolkitAnalytics, ScreenAnalytics, SettingsAnalytics, SignUpAnalytics, StoryAnalytics, QuickAccessStateAnalytics, VerificationAnalytics, WebViewAnalytics {

    /* renamed from: h  reason: collision with root package name */
    private static final Companion f23452h = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f23453a;

    /* renamed from: b  reason: collision with root package name */
    private final Features f23454b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverProvider f23455c;

    /* renamed from: d  reason: collision with root package name */
    private final AnalyticsManager f23456d;

    /* renamed from: e  reason: collision with root package name */
    private final PackageManager f23457e;

    /* renamed from: f  reason: collision with root package name */
    private final ReportManager f23458f;

    /* renamed from: g  reason: collision with root package name */
    private final PlatformManager f23459g;

    /* compiled from: AnalyticsImpl.kt */
    /* loaded from: classes3.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: AnalyticsImpl.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f23460a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f23461b;

        static {
            int[] iArr = new int[OrderState.values().length];
            try {
                iArr[OrderState.ORDER_STATE_DRIVER_ACCEPTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OrderState.ORDER_STATE_DRIVER_ARRIVED_TO_CLIENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OrderState.ORDER_STATE_DRIVING_WITH_CLIENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OrderState.ORDER_STATE_WAITING_ON_STOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f23460a = iArr;
            int[] iArr2 = new int[AppThemeMode.values().length];
            try {
                iArr2[AppThemeMode.LEGACY.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[AppThemeMode.DARK.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[AppThemeMode.LIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[AppThemeMode.DAY_NIGHT_SYSTEM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            f23461b = iArr2;
        }
    }

    @Inject
    public AnalyticsImpl(Context context, Features features, DriverProvider driverProvider, AnalyticsManager manager, PackageManager packageManager, ReportManager reportManager, PlatformManager platformManager) {
        Intrinsics.f(context, "context");
        Intrinsics.f(features, "features");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(manager, "manager");
        Intrinsics.f(packageManager, "packageManager");
        Intrinsics.f(reportManager, "reportManager");
        Intrinsics.f(platformManager, "platformManager");
        this.f23453a = context;
        this.f23454b = features;
        this.f23455c = driverProvider;
        this.f23456d = manager;
        this.f23457e = packageManager;
        this.f23458f = reportManager;
        this.f23459g = platformManager;
    }

    private final String q4(String str, String str2) {
        return "driver_" + str + str2;
    }

    private final String r4(String str, String str2) {
        return str + " using " + str2;
    }

    private final List<Pair<String, Object>> s4() {
        List n02;
        List<Pair<String, Object>> n03;
        n02 = CollectionsKt___CollectionsKt.n0(t4(), u4());
        n03 = CollectionsKt___CollectionsKt.n0(n02, v4());
        return n03;
    }

    private final List<Pair<String, Object>> t4() {
        List<Pair<String, Object>> k8;
        k8 = CollectionsKt__CollectionsKt.k();
        return k8;
    }

    private final List<Pair<String, Object>> u4() {
        List<OverridableField<? extends Object>> list;
        int v7;
        DriverFeatures h8 = this.f23455c.h();
        if (h8 != null) {
            list = h8.a();
        } else {
            list = null;
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.k();
        }
        v7 = CollectionsKt__IterablesKt.v(list, 10);
        ArrayList arrayList = new ArrayList(v7);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            OverridableField overridableField = (OverridableField) it.next();
            arrayList.add(TuplesKt.a(overridableField.b(), overridableField.c()));
        }
        return arrayList;
    }

    private final List<Pair<String, Object>> v4() {
        int v7;
        List<Feature> a8 = this.f23454b.a();
        v7 = CollectionsKt__IterablesKt.v(a8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (Feature feature : a8) {
            arrayList.add(TuplesKt.a(feature.e().f(), Boolean.valueOf(feature.f())));
        }
        return arrayList;
    }

    private final String w4(OrderState orderState) {
        int i8 = WhenMappings.f23460a[orderState.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3 || i8 == 4) {
                    return "Driving with client";
                }
                throw new IllegalArgumentException("Wrong order state: " + orderState);
            }
            return "Waiting for client";
        }
        return "Driving to client";
    }

    private final String x4(OrderState orderState) {
        int i8 = WhenMappings.f23460a[orderState.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3 || i8 == 4) {
                    return "driving_with_client_";
                }
                throw new IllegalArgumentException("Wrong order state: " + orderState);
            }
            return "waiting_for_client_";
        }
        return "driving_to_client_";
    }

    private final String y4(AppThemeMode appThemeMode) {
        int i8 = WhenMappings.f23461b[appThemeMode.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 == 4) {
                        return "systemDefault";
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return "light";
            }
            return "dark";
        }
        return "default";
    }

    private final Event z4(Event event) {
        Iterator<T> it = s4().iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            event.a((String) pair.a(), pair.b());
        }
        event.a("platform", this.f23459g.getType());
        return event;
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void A() {
        this.f23456d.c(z4(new Event("Pause orders dialog shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.BackendModalDialogAnalytics
    public void A0(String str, String str2) {
        if (str == null && str2 == null) {
            return;
        }
        this.f23456d.c(z4(new Event("Modal Dialog Action Tapped", null, Scopes.f23428a.g(), null, 10, null).a("modal_id", str).a("action_id", str2)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverScoreAnalytics
    public void A1(long j8) {
        this.f23456d.c(z4(new Event("Acceptance Rate Tapped", null, Scopes.f23428a.g(), null, 10, null).a("Acceptance Rate", Long.valueOf(j8))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics
    public void A2() {
        this.f23456d.c(z4(new Event("App Theme Screen Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PushTokenAnalytics
    public void A3(String token, PushTokenAnalytics.TokenType type) {
        Intrinsics.f(token, "token");
        Intrinsics.f(type, "type");
        this.f23456d.c(z4(new Event("(ENG) Push token Received", null, Scopes.f23428a.g(), null, 10, null).a("token_hash", Integer.valueOf(token.hashCode())).a("token_type", type.toString())));
    }

    public void A4(String appsflyerId, String str) {
        Map c8;
        Map f8;
        Map m8;
        Intrinsics.f(appsflyerId, "appsflyerId");
        AnalyticsManager analyticsManager = this.f23456d;
        AnalyticScope e8 = Scopes.f23428a.e();
        c8 = MapsKt__MapsJVMKt.c(TuplesKt.a("appsflyer_id", appsflyerId));
        if (str != null) {
            f8 = MapsKt__MapsJVMKt.c(TuplesKt.a("advertising_id", str));
        } else {
            f8 = MapsKt__MapsKt.f();
        }
        m8 = MapsKt__MapsKt.m(c8, f8);
        analyticsManager.c(new Event("driver_went_online", m8, e8, null, 8, null));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.WebViewAnalytics
    public void B(String tag, String url, int i8, String reasonPhrase) {
        Intrinsics.f(tag, "tag");
        Intrinsics.f(url, "url");
        Intrinsics.f(reasonPhrase, "reasonPhrase");
        this.f23456d.c(new Event("Web Page Http Error", null, Scopes.f23428a.d(), null, 10, null).a("tag", tag).a(ImagesContract.URL, StringUtilsKt.b(url, 0, 100)).a("statusCode", Integer.valueOf(i8)).a("reasonPhrase", StringUtilsKt.b(reasonPhrase, 0, 100)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverAnalytics
    public void B0(String session) {
        Intrinsics.f(session, "session");
        this.f23456d.f(new Property("Session ID", session, Scopes.f23428a.d()));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics
    public void B1() {
        this.f23456d.c(new Event("driver_share_invite_code_other", null, Scopes.f23428a.e(), null, 10, null));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void B2(boolean z7) {
        this.f23456d.c(z4(new Event("Confirm Order Tapped", null, Scopes.f23428a.g(), null, 10, null).a("Back To Back Order", Boolean.valueOf(z7))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics
    public void B3() {
        this.f23456d.c(z4(new Event("Pay To Bolt Succeeded", null, Scopes.f23428a.g(), null, 10, null)));
    }

    public void B4(String orderState, String str, String str2, String shardId, boolean z7) {
        Intrinsics.f(orderState, "orderState");
        Intrinsics.f(shardId, "shardId");
        if (str != null) {
            this.f23456d.c(z4(new Event(r4(orderState, str), null, Scopes.f23428a.g(), null, 10, null).a("is_auto_start", Boolean.valueOf(z7)).a("order_shard_id", shardId).a("order_id", str2)));
        }
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics
    public void C() {
        this.f23456d.c(z4(new Event("Login Screen Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics
    public void C0() {
        this.f23456d.c(z4(new Event("Cashout Fee Info Button Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics
    public void C1() {
        this.f23456d.c(z4(new Event("Draw Over Other Apps Provided", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics
    public void C2() {
        this.f23456d.c(z4(new Event("Draw Over Other Apps Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.SafetyToolkitAnalytics
    public void C3(String property) {
        Intrinsics.f(property, "property");
        this.f23456d.c(z4(new Event("Emergency Assist External SOS Button Tapped", null, Scopes.f23428a.g(), null, 10, null).a("provider", property)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void D(boolean z7) {
        this.f23456d.c(z4(new Event("Confirm Next Ride Tapped", null, Scopes.f23428a.g(), null, 10, null).a(PeerConnectionFactory.TRIAL_ENABLED, Boolean.valueOf(z7))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OptInCampaignAnalytics
    public void D0(long j8) {
        this.f23456d.c(z4(new Event("Opt-in Campaign Activate", null, Scopes.f23428a.g(), null, 10, null).a("ID", Long.valueOf(j8))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics
    public void D1() {
        this.f23456d.c(z4(new Event("Timeline shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.WebViewAnalytics
    public void D2(String tag, String messageLevel, String message, int i8, String str) {
        CharSequence charSequence;
        Intrinsics.f(tag, "tag");
        Intrinsics.f(messageLevel, "messageLevel");
        Intrinsics.f(message, "message");
        AnalyticsManager analyticsManager = this.f23456d;
        Event a8 = new Event("Web Page JS Error", null, Scopes.f23428a.d(), null, 10, null).a("tag", tag).a("messageLevel", messageLevel).a("message", StringUtilsKt.b(message, 0, 100)).a("lineNumber", Integer.valueOf(i8));
        if (str != null) {
            charSequence = StringUtilsKt.b(str, 0, 100);
        } else {
            charSequence = null;
        }
        analyticsManager.c(a8.a("sourceId", charSequence));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OptInCampaignAnalytics
    public void D3(long j8) {
        this.f23456d.c(z4(new Event("Opt-in Choice Tapped", null, Scopes.f23428a.g(), null, 10, null).a("ID", Long.valueOf(j8))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.AudioRecordingAnalytics
    public void E(String state) {
        Intrinsics.f(state, "state");
        this.f23456d.c(z4(new Event("Audio Recording Button Tapped", null, Scopes.f23428a.g(), null, 10, null).a("state", state)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.HistoryAnalytics
    public void E0() {
        this.f23456d.c(z4(new Event("Rides Screen Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DestinationAnalytics
    public void E1() {
        this.f23456d.c(z4(new Event("Get Trips Towards Destination Dialog Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics
    public void E2() {
        this.f23456d.c(z4(new Event("Payout History Screen Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void E3() {
        this.f23456d.c(z4(new Event("Another Stop Navigation Confirmed", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void F() {
        this.f23456d.c(z4(new Event("Close Add Stop Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics
    public void F0() {
        this.f23456d.c(z4(new Event("Guide Screen", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics
    public void F1() {
        this.f23456d.c(z4(new Event("Login Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void F2() {
        this.f23456d.c(z4(new Event("Cancel Ride Warning Driver Score Dialog Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // eu.bolt.driver.verification.identity.VerificationAnalytics
    public void F3(VerificationScreen screen) {
        Intrinsics.f(screen, "screen");
        this.f23456d.c(new Event(screen.a(), screen.b(), Scopes.f23428a.g(), null, 8, null));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderAnalytics
    public void G() {
        this.f23456d.c(new Event(q4(x4(OrderState.ORDER_STATE_DRIVING_WITH_CLIENT), "calculate_price"), null, Scopes.f23428a.e(), null, 10, null));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.AudioRecordingAnalytics
    public void G0() {
        this.f23456d.c(z4(new Event("Audio Recording Share Dialog Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics
    public void G1(List<String> list, String str) {
        this.f23456d.c(z4(new Event("Go Online Swiped", null, Scopes.f23428a.g(), null, 10, null).a("Categories Selected", list).a("map_type", str)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void G2(String message) {
        Intrinsics.f(message, "message");
        this.f23456d.c(z4(new Event("Cancel the Next Trip B2B Dialog Shown", null, Scopes.f23428a.g(), null, 10, null).a("status", message)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.EarningsGoalAnalytics
    public void G3() {
        this.f23456d.c(z4(new Event("Driver Goal Opened", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics
    public void H() {
        this.f23456d.c(z4(new Event("Payout History Button Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PermissionAnalytics
    public void H0() {
        this.f23456d.c(z4(new Event("Microphone Access Denied Dialog Cancel Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void H1(boolean z7) {
        this.f23456d.c(z4(new Event("END RIDE HERE tapped", null, Scopes.f23428a.g(), null, 10, null).a("END RIDE HERE tapped", Boolean.valueOf(z7))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.EarningsV2Analytics
    public void H2(String screenType, String currentPeriodKey) {
        Intrinsics.f(screenType, "screenType");
        Intrinsics.f(currentPeriodKey, "currentPeriodKey");
        this.f23456d.c(z4(new Event("Period Mode Selector Tapped", null, Scopes.f23428a.g(), null, 10, null).a("screen", screenType).a("reportPeriod", currentPeriodKey)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.AppStateAnalytics
    public void H3(Map<String, ? extends Object> payload) {
        Intrinsics.f(payload, "payload");
        this.f23456d.c(new Event("driver_did_not_respond", payload, Scopes.f23428a.d(), null, 8, null));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.NetworkErrorAnalytics
    public void I(String host, String path, String message) {
        Intrinsics.f(host, "host");
        Intrinsics.f(path, "path");
        Intrinsics.f(message, "message");
        this.f23456d.c(new Event("error_network_api", null, Scopes.f23428a.d(), null, 10, null).a("host", host).a("path", path).a("kind", message));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PartnerOffersAnalytics
    public void I0(String offerTitle, String type) {
        Intrinsics.f(offerTitle, "offerTitle");
        Intrinsics.f(type, "type");
        this.f23456d.c(z4(new Event("Partner Offer Action Button Tapped", null, Scopes.f23428a.g(), null, 10, null).a("source", offerTitle).a("type", type)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.HeatmapAnalytics
    public void I1(String str) {
        this.f23456d.c(z4(new Event("Heatmap Info Bottomsheet Tapped", null, Scopes.f23428a.g(), null, 10, null).a("map_type", str)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics
    public void I2(long j8) {
        this.f23456d.c(z4(new Event("Referral Campaign Banner Tapped", null, Scopes.f23428a.g(), null, 10, null).a("ID", Long.valueOf(j8))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void I3(boolean z7) {
        this.f23456d.c(z4(new Event("Cancel Ride Tapped", null, Scopes.f23428a.g(), null, 10, null).a("Cancelled", Boolean.valueOf(z7))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void J() {
        this.f23456d.c(z4(new Event("Confirm Price Screen Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics
    public void J0() {
        this.f23456d.c(z4(new Event("Pricing Method Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void J1(String str) {
        this.f23456d.c(z4(new Event("Rate Client Tapped", null, Scopes.f23428a.g(), null, 10, null).a("Problem", str)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void J2(boolean z7, boolean z8) {
        this.f23456d.c(z4(new Event("New Stop Address Selected", null, Scopes.f23428a.g(), null, 10, null).a("Paid Waiting enabled", Boolean.valueOf(z7)).a("Next Stop Nearby", Boolean.valueOf(z8))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.BackendModalDialogAnalytics
    public void J3(String modalId) {
        Intrinsics.f(modalId, "modalId");
        this.f23456d.c(z4(new Event("Modal Dialog Shown", null, Scopes.f23428a.g(), null, 10, null).a("modal_id", modalId)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OptInCampaignAnalytics
    public void K(long j8) {
        this.f23456d.c(z4(new Event("Opt-in Choice Detail Opened", null, Scopes.f23428a.g(), null, 10, null).a("ID", Long.valueOf(j8))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void K0() {
        this.f23456d.c(z4(new Event("Set Price Button Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PushTokenAnalytics
    public void K1(String token, PushTokenAnalytics.TokenType type) {
        Intrinsics.f(token, "token");
        Intrinsics.f(type, "type");
        this.f23456d.c(z4(new Event("(ENG) Push token upload Succeeded", null, Scopes.f23428a.g(), null, 10, null).a("token_hash", Integer.valueOf(token.hashCode())).a("token_type", type.toString())));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.AppStateAnalytics
    public void K2(Map<String, ? extends Object> payload) {
        Intrinsics.f(payload, "payload");
        this.f23456d.c(new Event("order_draw_state_failed", payload, Scopes.f23428a.d(), null, 8, null));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.CampaignAnalytics
    public void K3(long j8) {
        this.f23456d.c(z4(new Event("Campaign Detail Opened", null, Scopes.f23428a.g(), null, 10, null).a("ID", Long.valueOf(j8))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.SignUpAnalytics
    public void L(String registrationToken, String str, String str2) {
        Map i8;
        Map c8;
        Intrinsics.f(registrationToken, "registrationToken");
        AnalyticsManager analyticsManager = this.f23456d;
        i8 = MapsKt__MapsKt.i(TuplesKt.a("source", "driver_portal"), TuplesKt.a("hash", registrationToken), TuplesKt.a("advertising_id", str2), TuplesKt.a("appsflyer_id", str));
        Scopes scopes = Scopes.f23428a;
        analyticsManager.c(new Event("driver_registration_driver_signed_up_via_app", i8, scopes.f(), null, 8, null));
        AnalyticsManager analyticsManager2 = this.f23456d;
        c8 = MapsKt__MapsJVMKt.c(TuplesKt.a("identifier", registrationToken));
        analyticsManager2.c(new Event("registration_first_step_complete", c8, scopes.d(), null, 8, null));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void L0() {
        this.f23456d.c(z4(new Event("Cancel Ride Warning Active Campaigns Dialog Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void L1() {
        this.f23456d.c(z4(new Event("Calculate Price Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics
    public void L2(long j8) {
        this.f23456d.c(z4(new Event("Referral Campaign Active", null, Scopes.f23428a.g(), null, 10, null).a("ID", Long.valueOf(j8))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.WebViewAnalytics
    public void L3(String tag, String url) {
        Intrinsics.f(tag, "tag");
        Intrinsics.f(url, "url");
        this.f23456d.c(new Event("Web Page Visible", null, Scopes.f23428a.d(), null, 10, null).a("tag", tag).a(ImagesContract.URL, StringUtilsKt.b(url, 0, 100)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void M() {
        this.f23456d.c(z4(new Event("Pause orders user tip shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.SafetyToolkitAnalytics
    public void M0() {
        this.f23456d.c(z4(new Event("Safety Kit Button Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.CampaignAnalytics
    public void M1(long j8) {
        this.f23456d.c(z4(new Event("Campaign Tapped", null, Scopes.f23428a.g(), null, 10, null).a("ID", Long.valueOf(j8))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void M2() {
        this.f23456d.c(z4(new Event("Change Destination Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.AudioRecordingAnalytics
    public void M3() {
        this.f23456d.c(z4(new Event("Audio Recording Share Dialog Cancel Button Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics
    public void N() {
        this.f23456d.c(z4(new Event("Invite Code Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverScoreAnalytics
    public void N0(double d8) {
        this.f23456d.d(new Property("Acceptance Rate", String.valueOf(d8), Scopes.f23428a.g()));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverScoreAnalytics
    public void N1(double d8) {
        this.f23456d.d(new Property("Driver Score", String.valueOf(d8), Scopes.f23428a.g()));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void N2() {
        this.f23456d.c(z4(new Event("Price Input Increase Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics
    public void N3() {
        this.f23456d.c(z4(new Event("Bolt Dynamic Price Cancellation Modal Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void O(boolean z7) {
        this.f23456d.c(z4(new Event("NEXT STOP button swiped", null, Scopes.f23428a.g(), null, 10, null).a("Is From Widget", Boolean.valueOf(z7))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics
    public void O0() {
        AnalyticsManager analyticsManager = this.f23456d;
        Scopes scopes = Scopes.f23428a;
        analyticsManager.c(new Event("Sign up", null, scopes.d(), null, 10, null));
        this.f23456d.c(z4(new Event("Start Sign Up Tapped", null, scopes.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.AppVerificationAnalytics
    public void O1(AppVerificationStatus appVerificationStatus) {
        Intrinsics.f(appVerificationStatus, "appVerificationStatus");
        AnalyticsManager analyticsManager = this.f23456d;
        Scopes scopes = Scopes.f23428a;
        analyticsManager.c(new Event("app_verification", null, scopes.d(), null, 10, null).a("Status", appVerificationStatus.name()));
        this.f23456d.c(z4(new Event("App Verification", null, scopes.g(), null, 10, null).a("Status", appVerificationStatus.c())));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics
    public void O2() {
        this.f23456d.c(z4(new Event("Pay To Bolt Button Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.EarningsGoalAnalytics
    public void O3() {
        this.f23456d.c(z4(new Event("Delete Driver Goal Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics
    public void P(long j8) {
        this.f23456d.c(z4(new Event("Referral Campaign Tapped", null, Scopes.f23428a.g(), null, 10, null).a("ID", Long.valueOf(j8))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics
    public void P0() {
        AnalyticsManager analyticsManager = this.f23456d;
        Scopes scopes = Scopes.f23428a;
        analyticsManager.c(new Event("Get passenger app", null, scopes.d(), null, 10, null));
        this.f23456d.c(z4(new Event("Click get client app", null, scopes.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics
    public void P1(BigDecimal bigDecimal) {
        this.f23456d.c(z4(new Event("Custom Price Confirmation Modal Tapped", null, Scopes.f23428a.g(), null, 10, null).a("Distance Rate", bigDecimal)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics
    public void P2() {
        this.f23456d.c(z4(new Event("Pdf receipt button tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.RateMeAnalytics
    public void P3() {
        this.f23456d.c(z4(new Event("Rating Thumbs Up", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics
    public void Q() {
        this.f23456d.c(z4(new Event("Active Early Cashout button shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void Q0() {
        this.f23456d.c(z4(new Event("Pause orders dialog cancel tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics
    public void Q1() {
        this.f23456d.c(z4(new Event("Category Selection Screen Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics
    public void Q2() {
        this.f23456d.c(z4(new Event("Bolt Dynamic Price Reminder Confirmation Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics
    public void Q3() {
        this.f23456d.c(z4(new Event("Home Screen Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DeviceAnalytics
    public void R(String availableInternalMemorySize) {
        Intrinsics.f(availableInternalMemorySize, "availableInternalMemorySize");
        this.f23456d.c(z4(new Event("(ENG) Device Free Space Calculated", null, Scopes.f23428a.g(), null, 10, null).a("freeSpace", availableInternalMemorySize)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics
    public void R0() {
        this.f23456d.c(z4(new Event("Custom Price Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics
    public void R1() {
        this.f23456d.c(z4(new Event("Bolt Dynamic Price Reminder Changing Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.SafetyToolkitAnalytics
    public void R2(String property) {
        Intrinsics.f(property, "property");
        this.f23456d.c(z4(new Event("Emergency Assist External SOS Confirmation Dialog Continue Button Tapped", null, Scopes.f23428a.g(), null, 10, null).a("provider", property)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderAnalytics
    public void R3(OrderHandle currentOrderHandle, OrderHandle b2bOrderHandle, Boolean bool, long j8) {
        Intrinsics.f(currentOrderHandle, "currentOrderHandle");
        Intrinsics.f(b2bOrderHandle, "b2bOrderHandle");
        this.f23456d.c(new Event("unwanted_b2b_order", null, Scopes.f23428a.d(), null, 10, null).a("server_b2b_setting", bool).a("currentOrderId", Long.valueOf(currentOrderHandle.b())).a("b2bOrderId", Long.valueOf(b2bOrderHandle.b())).a("valueUpdatedAt", Long.valueOf(j8)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics
    public void S(BigDecimal bigDecimal) {
        this.f23456d.c(z4(new Event("Custom Price Confirmation Tapped", null, Scopes.f23428a.g(), null, 10, null).a("Distance Rate", bigDecimal)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void S0() {
        this.f23456d.c(z4(new Event("Driving With Client Screen Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void S1() {
        this.f23456d.c(z4(new Event("Confirm Price Screen Back Button Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.AudioRecordingAnalytics
    public void S2() {
        this.f23456d.c(z4(new Event("Retry File Upload Dialog Close Button Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.WebViewAnalytics
    public void S3(String tag, String url, int i8) {
        Intrinsics.f(tag, "tag");
        Intrinsics.f(url, "url");
        this.f23456d.c(new Event("Web Page Ssl Error", null, Scopes.f23428a.d(), null, 10, null).a("tag", tag).a(ImagesContract.URL, StringUtilsKt.b(url, 0, 100)).a("primaryError", Integer.valueOf(i8)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics
    public void T() {
        this.f23456d.c(z4(new Event("Bolt Dynamic Price Confirmation Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.NetworkErrorAnalytics
    public void T0(String host, String path, int i8) {
        Intrinsics.f(host, "host");
        Intrinsics.f(path, "path");
        this.f23456d.c(new Event("error_network_code", null, Scopes.f23428a.d(), null, 10, null).a("host", host).a("path", path).a("kind", Integer.valueOf(i8)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics
    public void T1() {
        this.f23456d.c(z4(new Event("Cashout Request Succeeded", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.SafetyToolkitAnalytics
    public void T2(String property) {
        Intrinsics.f(property, "property");
        this.f23456d.c(z4(new Event("Emergency Assist External SOS Confirmation Dialog Dismissed", null, Scopes.f23428a.g(), null, 10, null).a("provider", property)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics
    public void T3() {
        this.f23456d.c(z4(new Event("Username Auth Start", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.ChatAnalytics
    public void U() {
        this.f23456d.c(z4(new Event("Contact Options - Send A Message Tap", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics
    public void U0() {
        this.f23456d.c(new Event("driver_share_invite_code_sms", null, Scopes.f23428a.e(), null, 10, null));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.NewsAnalytics
    public void U1() {
        this.f23456d.c(z4(new Event("All News Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.ChatAnalytics
    public void U2() {
        this.f23456d.c(z4(new Event("Chat Bubble Tap", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.NewsAnalytics
    public void U3() {
        this.f23456d.c(z4(new Event("News Screen Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.NetworkErrorAnalytics
    public void V(String endPoint, int i8, String errorMessage) {
        Intrinsics.f(endPoint, "endPoint");
        Intrinsics.f(errorMessage, "errorMessage");
        this.f23456d.c(z4(new Event("(ENG) API Error Empty Message Received", null, Scopes.f23428a.g(), null, 10, null).a("endPoint", endPoint).a("code", Integer.valueOf(i8)).a("message", errorMessage)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.RateMeAnalytics
    public void V0(String section, String issue) {
        Intrinsics.f(section, "section");
        Intrinsics.f(issue, "issue");
        this.f23456d.c(z4(new Event("Negative Feedback Sent", null, Scopes.f23428a.g(), null, 10, null).a("Section", section).a("Issue", issue)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics
    public void V1(String fragment) {
        Intrinsics.f(fragment, "fragment");
        this.f23458f.log(fragment);
        this.f23456d.f(new Property("Fragment", fragment, Scopes.f23428a.a()));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics
    public void V2() {
        this.f23456d.c(z4(new Event("Review payment details button tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics
    public void V3(Class<? extends Fragment> fragmentClass) {
        Intrinsics.f(fragmentClass, "fragmentClass");
        Kalev.n(Name.LABEL, fragmentClass.getClass().getSimpleName()).a("onViewCreated");
        ReportManager reportManager = this.f23458f;
        String simpleName = fragmentClass.getClass().getSimpleName();
        Intrinsics.e(simpleName, "fragmentClass.javaClass.simpleName");
        reportManager.log(simpleName);
        AnalyticsManager analyticsManager = this.f23456d;
        String simpleName2 = fragmentClass.getClass().getSimpleName();
        Intrinsics.e(simpleName2, "fragmentClass.javaClass.simpleName");
        analyticsManager.f(new Property("Fragment", simpleName2, Scopes.f23428a.a()));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.BackendModalDialogAnalytics
    public void W(String modalId) {
        Intrinsics.f(modalId, "modalId");
        this.f23456d.c(z4(new Event("Modal Dialog Dismissed", null, Scopes.f23428a.g(), null, 10, null).a("modal_id", modalId)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void W0() {
        this.f23456d.c(z4(new Event("SOS Cancel Button Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OptInCampaignAnalytics
    public void W1(long j8) {
        this.f23456d.c(z4(new Event("Opt-in Campaign Tapped", null, Scopes.f23428a.g(), null, 10, null).a("ID", Long.valueOf(j8))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PushTokenAnalytics
    public void W2(String token, PushTokenAnalytics.TokenType type) {
        Intrinsics.f(token, "token");
        Intrinsics.f(type, "type");
        this.f23456d.c(z4(new Event("(ENG) Push token upload Failed", null, Scopes.f23428a.g(), null, 10, null).a("token_hash", Integer.valueOf(token.hashCode())).a("token_type", type.toString())));
    }

    @Override // eu.bolt.driver.stories.service.analytic.StoryAnalytics
    public void W3(String actionType, String storyId, String slideId) {
        Intrinsics.f(actionType, "actionType");
        Intrinsics.f(storyId, "storyId");
        Intrinsics.f(slideId, "slideId");
        this.f23456d.c(z4(new Event(actionType, null, Scopes.f23428a.g(), null, 10, null).a("Story id", storyId).a("Slide id", slideId)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PermissionAnalytics
    public void X() {
        this.f23456d.c(z4(new Event("Microphone Access Denied Dialog Go To Settings Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void X0() {
        this.f23456d.c(z4(new Event("Decline Order Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void X1() {
        this.f23456d.c(z4(new Event("Price Input Increase Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics
    public void X2() {
        this.f23456d.c(z4(new Event("Pay To Bolt Failed", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.AppStateAnalytics
    public void X3(String state) {
        Intrinsics.f(state, "state");
        this.f23456d.f(new Property("Driver state", state, Scopes.f23428a.a()));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.AudioRecordingAnalytics
    public void Y() {
        this.f23456d.c(z4(new Event("Audio Recording Start Button Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.WebViewAnalytics
    public void Y0(String tag) {
        Intrinsics.f(tag, "tag");
        this.f23456d.c(new Event("Web Page Too Many Redirects", null, Scopes.f23428a.d(), null, 10, null).a("tag", tag));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverScoreAnalytics
    public void Y1() {
        this.f23456d.c(z4(new Event("Driver Score Intro Opened", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics
    public void Y2() {
        this.f23456d.c(z4(new Event("Landing Screen Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.AudioRecordingAnalytics
    public void Y3() {
        this.f23456d.c(z4(new Event("Audio Recording Share To CS Button Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // eu.bolt.driver.stories.service.analytic.StoryAnalytics
    public void Z(String storyId) {
        Intrinsics.f(storyId, "storyId");
        this.f23456d.c(z4(new Event("Story Open", null, Scopes.f23428a.g(), null, 10, null).a("Story id", storyId)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics
    public void Z0(LoginType type) {
        Intrinsics.f(type, "type");
        this.f23456d.c(z4(new Event("Driver Logged In", null, Scopes.f23428a.g(), null, 10, null).a("Login Type", type.c())));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics
    public void Z1() {
        this.f23456d.c(z4(new Event("Referral Screen Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.AutoAcceptanceAnalytics
    public void Z2(String screenName, boolean z7) {
        Intrinsics.f(screenName, "screenName");
        this.f23456d.c(z4(new Event("Auto Acceptance Toggle Tap", null, Scopes.f23428a.g(), null, 10, null).a("screen_name", screenName).a("isEnabled", Boolean.valueOf(z7))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.QuickAccessStateAnalytics
    public void Z3() {
        this.f23456d.c(z4(new Event("Extended QA Enabled", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderAnalytics, ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics
    public void a(boolean z7, OrderAnalytics.EventSource eventSource) {
        String str;
        Map c8;
        Intrinsics.f(eventSource, "eventSource");
        if (z7) {
            str = "navigation_autostart_enabled";
        } else {
            str = "navigation_autostart_disabled";
        }
        String str2 = str;
        AnalyticsManager analyticsManager = this.f23456d;
        AnalyticScope d8 = Scopes.f23428a.d();
        c8 = MapsKt__MapsJVMKt.c(TuplesKt.a("source", eventSource.c()));
        analyticsManager.c(new Event(str2, c8, d8, null, 8, null));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.CampaignAnalytics
    public void a0() {
        this.f23456d.c(z4(new Event("No Campaign Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.WebViewAnalytics
    public void a1(String tag, String url) {
        Intrinsics.f(tag, "tag");
        Intrinsics.f(url, "url");
        this.f23456d.c(new Event("Web Page Load Succeed", null, Scopes.f23428a.d(), null, 10, null).a("tag", tag).a(ImagesContract.URL, StringUtilsKt.b(url, 0, 100)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void a2(boolean z7) {
        this.f23456d.c(z4(new Event("Add New Address Tapped", null, Scopes.f23428a.g(), null, 10, null).a("Paid Waiting enabled", Boolean.valueOf(z7))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void a3() {
        this.f23456d.c(z4(new Event("Problem With Price Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DestinationAnalytics
    public void a4() {
        this.f23456d.c(z4(new Event("Get Trips Towards Destination Pin Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PartnerOffersAnalytics
    public void b(String source) {
        Intrinsics.f(source, "source");
        this.f23456d.c(z4(new Event("Partner Offers Button Tapped", null, Scopes.f23428a.g(), null, 10, null).a("source", source)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void b0(boolean z7) {
        this.f23456d.c(z4(new Event("Arriving Now Swiped", null, Scopes.f23428a.g(), null, 10, null).a("Is From Widget", Boolean.valueOf(z7))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.EarningsGoalAnalytics
    public void b1() {
        this.f23456d.c(z4(new Event("Driver Goal Expenses Opened", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void b2() {
        this.f23456d.c(z4(new Event("Share Ride Info Screen Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.SafetyToolkitAnalytics
    public void b3() {
        this.f23456d.c(z4(new Event("Emergency Assist Was Helpful Dialog Dismissed", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics
    public void b4() {
        this.f23456d.c(z4(new Event("How To Request Cashout Button Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.AudioRecordingAnalytics
    public void c() {
        this.f23456d.c(z4(new Event("Retry File Upload Dialog Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics
    public void c0(BigDecimal bigDecimal) {
        this.f23456d.c(z4(new Event("Increase Custom Price", null, Scopes.f23428a.g(), null, 10, null).a("Distance Rate", bigDecimal)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.CampaignAnalytics
    public void c1() {
        this.f23456d.c(z4(new Event("Previous Campaigns Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void c2() {
        this.f23456d.c(z4(new Event("Cancel Ride Warning Dialog Select Reason Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics
    public void c3() {
        this.f23456d.c(z4(new Event("Cashout Confirmation Screen Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.RateMeAnalytics
    public void c4() {
        this.f23456d.c(z4(new Event("Rating Thumbs Down", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // eu.bolt.driver.stories.service.analytic.StoryAnalytics
    public void d(String storyId, String slideId) {
        Intrinsics.f(storyId, "storyId");
        Intrinsics.f(slideId, "slideId");
        this.f23456d.c(z4(new Event("Tap Slide", null, Scopes.f23428a.g(), null, 10, null).a("Story id", storyId).a("Slide id", slideId)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void d0() {
        this.f23456d.c(z4(new Event("Emergency Confirm Button Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.CampaignAnalytics
    public void d1() {
        this.f23456d.c(z4(new Event("Start Screen With No Campaign Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics
    public void d2(AppThemeMode themeMode) {
        Intrinsics.f(themeMode, "themeMode");
        this.f23456d.c(z4(new Event("App Theme Selected", null, Scopes.f23428a.g(), null, 10, null).a("appTheme", y4(themeMode))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.EarningsGoalAnalytics
    public void d3(String str, BigDecimal bigDecimal, Map<String, ? extends BigDecimal> expenses) {
        Intrinsics.f(expenses, "expenses");
        Event event = new Event("Set Driver Goal Tapped", null, Scopes.f23428a.g(), null, 10, null);
        event.a("Period", str);
        event.a("Target", bigDecimal);
        for (Map.Entry<String, ? extends BigDecimal> entry : expenses.entrySet()) {
            event.a("Expense " + entry.getKey(), entry.getValue());
        }
        this.f23456d.c(z4(event));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderAnalytics
    public void d4(OrderState orderState, String str, String str2, String shardId, boolean z7) {
        Intrinsics.f(orderState, "orderState");
        Intrinsics.f(shardId, "shardId");
        B4(w4(orderState), str, str2, shardId, z7);
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics
    public void e(List<SearchCategory> selection) {
        int v7;
        int v8;
        Intrinsics.f(selection, "selection");
        AnalyticsManager analyticsManager = this.f23456d;
        Event event = new Event("Confirm Category Tapped", null, Scopes.f23428a.g(), null, 10, null);
        ArrayList<SearchCategory> arrayList = new ArrayList();
        for (Object obj : selection) {
            if (((SearchCategory) obj).e()) {
                arrayList.add(obj);
            }
        }
        v7 = CollectionsKt__IterablesKt.v(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(v7);
        for (SearchCategory searchCategory : arrayList) {
            arrayList2.add(searchCategory.d());
        }
        Event a8 = event.a("Categories Selected", arrayList2);
        v8 = CollectionsKt__IterablesKt.v(selection, 10);
        ArrayList arrayList3 = new ArrayList(v8);
        for (SearchCategory searchCategory2 : selection) {
            arrayList3.add(searchCategory2.d());
        }
        analyticsManager.c(z4(a8.a("Categories Available", arrayList3)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.SafetyToolkitAnalytics
    public void e0(String property) {
        Intrinsics.f(property, "property");
        this.f23456d.c(z4(new Event("Emergency Assist Button Tapped", null, Scopes.f23428a.g(), null, 10, null).a("provider", property)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void e1() {
        this.f23456d.c(z4(new Event("Cancel Ride Warning Driver Score and Active Campaigns Dialog Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.CampaignAnalytics
    public void e2() {
        this.f23456d.c(z4(new Event("Map Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.EarningsGoalAnalytics
    public void e3() {
        this.f23456d.c(z4(new Event("Driver Goal Closed", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.EarningsV2Analytics
    public void e4() {
        this.f23456d.c(z4(new Event("Earnings Tab Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.EarningsAnalytics
    public void f() {
        AnalyticsManager analyticsManager = this.f23456d;
        Scopes scopes = Scopes.f23428a;
        analyticsManager.c(z4(new Event("Earnings Screen Shown", null, scopes.g(), null, 10, null)));
        this.f23456d.c(new Event("driver_earnings_view_opened", null, scopes.e(), null, 10, null));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OptInCampaignAnalytics
    public void f0(long j8) {
        this.f23456d.c(z4(new Event("Opt-in Choice Enabled", null, Scopes.f23428a.g(), null, 10, null).a("ID", Long.valueOf(j8))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void f1(OrderState orderState) {
        Intrinsics.f(orderState, "orderState");
        this.f23456d.c(z4(new Event("Menu Tapped", null, Scopes.f23428a.g(), null, 10, null).a("Order State", orderState.name())));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics
    public void f2() {
        this.f23456d.c(new Event("driver_share_invite_code_email", null, Scopes.f23428a.e(), null, 10, null));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.AudioRecordingAnalytics
    public void f3(String state) {
        Intrinsics.f(state, "state");
        this.f23456d.c(z4(new Event("Audio Recording Bottomsheet Shown", null, Scopes.f23428a.g(), null, 10, null).a("state", state)));
    }

    @Override // eu.bolt.driver.chat.service.analytics.ChatAnalytics
    public void f4() {
        this.f23456d.c(z4(new Event("Push For Chat Arrived", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OptInCampaignAnalytics
    public void g(long j8) {
        this.f23456d.c(z4(new Event("Opt-in Choice Declined", null, Scopes.f23428a.g(), null, 10, null).a("ID", Long.valueOf(j8))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.SafetyToolkitAnalytics
    public void g0() {
        this.f23456d.c(z4(new Event("Emergency Assist Call Button Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // eu.bolt.driver.chat.service.analytics.ChatAnalytics
    public void g1() {
        this.f23456d.c(z4(new Event("Push For Chat Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics
    public void g2() {
        this.f23456d.c(z4(new Event("Invite Code Copied", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.AudioRecordingAnalytics
    public void g3() {
        this.f23456d.c(z4(new Event("Audio Recording Available Infoblock Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void g4() {
        this.f23456d.c(z4(new Event("Order Acceptance Screen Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.SafetyToolkitAnalytics
    public void h(String state) {
        Intrinsics.f(state, "state");
        this.f23456d.c(z4(new Event("Emergency Assist Was Helpful Tapped", null, Scopes.f23428a.g(), null, 10, null).a("status", state)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics
    public void h0(long j8) {
        this.f23456d.c(z4(new Event("Referral Campaign Shown", null, Scopes.f23428a.g(), null, 10, null).a("ID", Long.valueOf(j8))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.EarningsGoalAnalytics
    public void h1() {
        this.f23456d.c(z4(new Event("Driver Goal Expenses Closed", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // eu.bolt.driver.verification.identity.VerificationAnalytics
    public void h2(VerificationEvent event) {
        Intrinsics.f(event, "event");
        this.f23456d.c(new Event(event.a(), event.b(), Scopes.f23428a.g(), null, 8, null));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics
    public void h3() {
        this.f23456d.c(z4(new Event("Pricing Method Opened", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.AudioRecordingAnalytics
    public void h4() {
        this.f23456d.c(z4(new Event("Audio Recording Share Dialog Confirm Button Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics
    public void i() {
        this.f23456d.c(z4(new Event("Start Login Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderAnalytics
    public void i0(OrderState orderState) {
        Intrinsics.f(orderState, "orderState");
        this.f23456d.c(new Event(q4(x4(orderState), "menu_opened"), null, Scopes.f23428a.e(), null, 10, null));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.AppStateAnalytics
    public void i1(Map<String, ? extends Object> payload) {
        Intrinsics.f(payload, "payload");
        this.f23456d.c(new Event("driver_in_wrong_state", payload, Scopes.f23428a.d(), null, 8, null));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.AppPerformanceAnalytics
    public void i2(boolean z7) {
        this.f23456d.f(new Property("isLowRamDevice", String.valueOf(z7), Scopes.f23428a.g()));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PartnerOffersAnalytics
    public void i3(String offerTitle, String state) {
        Intrinsics.f(offerTitle, "offerTitle");
        Intrinsics.f(state, "state");
        this.f23456d.c(z4(new Event("Partner Offer Favourite Button Tapped", null, Scopes.f23428a.g(), null, 10, null).a("source", offerTitle).a("state", state)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics
    public void i4() {
        AnalyticsManager analyticsManager = this.f23456d;
        Scopes scopes = Scopes.f23428a;
        analyticsManager.c(new Event("Login using email", null, scopes.d(), null, 10, null));
        this.f23456d.c(z4(new Event("Send Email Tapped", null, scopes.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void j() {
        this.f23456d.c(z4(new Event("Next Stop Button Appeared", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.NetworkErrorAnalytics
    public void j0(String endPoint, int i8, String errorMessage) {
        Intrinsics.f(endPoint, "endPoint");
        Intrinsics.f(errorMessage, "errorMessage");
        this.f23456d.c(z4(new Event("(ENG) API Error Received", null, Scopes.f23428a.g(), null, 10, null).a("endPoint", endPoint).a("code", Integer.valueOf(i8)).a("message", errorMessage)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.ScreenAnalytics
    public void j1(String activity) {
        Intrinsics.f(activity, "activity");
        this.f23458f.log(activity);
        this.f23456d.f(new Property("Activity", activity, Scopes.f23428a.a()));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverScoreAnalytics
    public void j2(long j8, boolean z7) {
        this.f23456d.c(z4(new Event("Driver Score Opened", null, Scopes.f23428a.g(), null, 10, null).a("Driver Score", Long.valueOf(j8)).a("Has additional actions", Boolean.valueOf(z7))));
    }

    @Override // eu.bolt.driver.chat.service.analytics.ChatAnalytics
    public void j3() {
        this.f23456d.c(z4(new Event("Call Button Tap", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics
    public void j4() {
        this.f23456d.c(z4(new Event("Custom Price Reminder Changing Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void k(boolean z7, boolean z8) {
        this.f23456d.c(z4(new Event("End Trip Tapped", null, Scopes.f23428a.g(), null, 10, null).a("Completed", Boolean.valueOf(z7)).a("Is From Widget", Boolean.valueOf(z8))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics
    public void k0() {
        this.f23456d.c(z4(new Event("Detailed Payout Screen Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void k1() {
        this.f23456d.c(z4(new Event("Arriving To Client Screen Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics
    public void k2(BigDecimal bigDecimal) {
        this.f23456d.c(z4(new Event("Custom Price Sliding", null, Scopes.f23428a.g(), null, 10, null).a("Distance Rate", bigDecimal)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.ChatAnalytics
    public void k3() {
        this.f23456d.c(z4(new Event("Chat Bubble Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // eu.bolt.driver.stories.service.analytic.StoryAnalytics
    public void k4(String closeReason, boolean z7, String storyId, String lastSeenSlideId) {
        Intrinsics.f(closeReason, "closeReason");
        Intrinsics.f(storyId, "storyId");
        Intrinsics.f(lastSeenSlideId, "lastSeenSlideId");
        this.f23456d.c(z4(new Event("Story Close", null, Scopes.f23428a.g(), null, 10, null).a("How closed", closeReason).a("Last slide seen", Boolean.valueOf(z7)).a("Story id", storyId).a("Last slide seen id", lastSeenSlideId)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverScoreAnalytics
    public void l(long j8) {
        this.f23456d.c(z4(new Event("Driver Score Tapped", null, Scopes.f23428a.g(), null, 10, null).a("Driver Score", Long.valueOf(j8))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.ChatAnalytics
    public void l0() {
        this.f23456d.c(z4(new Event("Push For Chat Tap", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderAnalytics
    public void l1(OrderState orderState) {
        Intrinsics.f(orderState, "orderState");
        this.f23456d.c(new Event(q4(x4(orderState), "change_destination_from_menu"), null, Scopes.f23428a.e(), null, 10, null));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.NewsAnalytics
    public void l2() {
        this.f23456d.c(z4(new Event("Campaigns Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.WebViewAnalytics
    public void l3(String tag, String url, int i8, String description) {
        Intrinsics.f(tag, "tag");
        Intrinsics.f(url, "url");
        Intrinsics.f(description, "description");
        this.f23456d.c(new Event("Web Page Load Failed", null, Scopes.f23428a.d(), null, 10, null).a("tag", tag).a(ImagesContract.URL, StringUtilsKt.b(url, 0, 100)).a("errorCode", Integer.valueOf(i8)).a("description", StringUtilsKt.b(description, 0, 100)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.HistoryAnalytics
    public void l4(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        this.f23456d.c(z4(new Event("Ride Tapped", null, Scopes.f23428a.g(), null, 10, null).a("orderId", Long.valueOf(orderHandle.b()))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OptInCampaignAnalytics
    public void m(long j8) {
        this.f23456d.c(z4(new Event("Opt-in Campaign Opened", null, Scopes.f23428a.g(), null, 10, null).a("ID", Long.valueOf(j8))));
    }

    @Override // eu.bolt.driver.chat.service.analytics.ChatAnalytics
    public void m0() {
        this.f23456d.c(z4(new Event("Push For Chat Arrived Incomming", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics
    public void m1() {
        AnalyticsManager analyticsManager = this.f23456d;
        Scopes scopes = Scopes.f23428a;
        analyticsManager.c(z4(new Event("Send email", null, scopes.g(), null, 10, null)));
        this.f23456d.c(new Event("Send magic link", null, scopes.d(), null, 10, null));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics
    public void m2(Boolean bool) {
        this.f23456d.f(new Property("beta_user_android", String.valueOf(bool), null, 4, null));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DestinationAnalytics
    public void m3() {
        this.f23456d.c(z4(new Event("Matching Tips Towards Destination Banner", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.EarningsGoalAnalytics
    public void m4() {
        this.f23456d.c(z4(new Event("Delete Driver Goal Expenses Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics
    public void n() {
        this.f23456d.c(z4(new Event("Bolt Dynamic Price Confirmation Modal Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.QuickAccessStateAnalytics
    public void n0() {
        this.f23456d.c(z4(new Event("Main QA Enabled", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics
    public void n1(AppThemeMode themeMode) {
        Intrinsics.f(themeMode, "themeMode");
        this.f23456d.d(new Property("App Theme", y4(themeMode), Scopes.f23428a.g()));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void n2(String message, String status) {
        Intrinsics.f(message, "message");
        Intrinsics.f(status, "status");
        this.f23456d.c(z4(new Event(message, null, Scopes.f23428a.g(), null, 10, null).a("status", status)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.AudioRecordingAnalytics
    public void n3() {
        this.f23456d.c(z4(new Event("Retry File Upload Dialog Try Again Button Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics
    public void n4(boolean z7) {
        this.f23456d.f(new Property("is_auto_navigation_enabled", String.valueOf(z7), Scopes.f23428a.g()));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.EarningsGoalAnalytics
    public void o(Map<String, ? extends BigDecimal> expenses) {
        Intrinsics.f(expenses, "expenses");
        Event event = new Event("Add Expenses Tapped", null, Scopes.f23428a.g(), null, 10, null);
        for (Map.Entry<String, ? extends BigDecimal> entry : expenses.entrySet()) {
            event.a("Expense " + entry.getKey(), entry.getValue());
        }
        this.f23456d.c(z4(event));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PartnerOffersAnalytics
    public void o0(String offerTitle) {
        Intrinsics.f(offerTitle, "offerTitle");
        this.f23456d.c(z4(new Event("Partner Offer Details Screen Shown", null, Scopes.f23428a.g(), null, 10, null).a("source", offerTitle)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics
    public void o1(long j8, String driverCity) {
        Intrinsics.f(driverCity, "driverCity");
        ApplicationInfo applicationInfo = this.f23453a.getPackageManager().getApplicationInfo(this.f23453a.getPackageName(), 128);
        Intrinsics.e(applicationInfo, "context.packageManager.g…ageManager.GET_META_DATA)");
        String funnelApiKey = applicationInfo.metaData.getString("com.google.android.funnel.API_KEY", "null");
        AnalyticsManager analyticsManager = this.f23456d;
        Intrinsics.e(funnelApiKey, "funnelApiKey");
        Scopes scopes = Scopes.f23428a;
        analyticsManager.f(new Property("funnel_api_key", funnelApiKey, scopes.a().c(scopes.d())));
        String installerPackageName = this.f23457e.getInstallerPackageName(this.f23453a.getPackageName());
        if (installerPackageName == null) {
            installerPackageName = "adb";
        }
        this.f23456d.f(new Property("install_source", installerPackageName, scopes.a().c(scopes.d())));
        AnalyticsManager analyticsManager2 = this.f23456d;
        analyticsManager2.e("driver-" + j8);
        this.f23456d.c(new Event("driver_signed_into_app", null, scopes.e(), null, 10, null));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.AppStateAnalytics
    public void o2() {
        this.f23456d.c(new Event("driver_put_offline", null, Scopes.f23428a.d(), null, 10, null));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.EarningsV2Analytics
    public void o3(String screenType, String periodKey) {
        Intrinsics.f(screenType, "screenType");
        Intrinsics.f(periodKey, "periodKey");
        this.f23456d.c(z4(new Event("Period Page Swiped", null, Scopes.f23428a.g(), null, 10, null).a("screen", screenType).a("reportPeriod", periodKey)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics
    public void o4() {
        this.f23456d.c(z4(new Event("Select Pricing Method Opened", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void p() {
        this.f23456d.c(z4(new Event("Set Price Screen Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OptInCampaignAnalytics
    public void p0(long j8) {
        this.f23456d.c(z4(new Event("Opt-in Choice Activated", null, Scopes.f23428a.g(), null, 10, null).a("ID", Long.valueOf(j8))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics
    public void p1() {
        this.f23456d.c(z4(new Event("Driver Logged Out", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // eu.bolt.driver.chat.service.analytics.ChatAnalytics
    public void p2(String id) {
        Intrinsics.f(id, "id");
        this.f23456d.c(z4(new Event("Quick Reply Tap", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OptInCampaignAnalytics
    public void p3() {
        this.f23456d.c(z4(new Event("Opt-in Activation Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.QuickAccessStateAnalytics
    public void p4() {
        this.f23456d.c(z4(new Event("QuickAccess Promo Screen", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics
    public void q() {
        this.f23456d.c(z4(new Event("Confirm Cashout Button Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void q0(boolean z7) {
        this.f23456d.c(z4(new Event("Add Stop Here Tapped", null, Scopes.f23428a.g(), null, 10, null).a("Paid Waiting enabled", Boolean.valueOf(z7))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics
    public void q1(BigDecimal bigDecimal) {
        this.f23456d.c(z4(new Event("Custom Price Reminder Confirmation Tapped", null, Scopes.f23428a.g(), null, 10, null).a("Distance Rate", bigDecimal)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void q2() {
        this.f23456d.c(z4(new Event("Change Destination Succeeded", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.AppStateAnalytics
    public void q3(Map<String, ? extends Object> payload) {
        Intrinsics.f(payload, "payload");
        this.f23456d.c(new Event("order_in_wrong_state", payload, Scopes.f23428a.d(), null, 8, null));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void r() {
        this.f23456d.c(z4(new Event("Cancel Ride Warning Dialog Don’t Cancel Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.NetworkErrorAnalytics
    public void r0(String host, String path, String error) {
        Intrinsics.f(host, "host");
        Intrinsics.f(path, "path");
        Intrinsics.f(error, "error");
        this.f23456d.c(new Event("error_network_transport", null, Scopes.f23428a.d(), null, 10, null).a("host", host).a("path", path).a("kind", error));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.HeatmapAnalytics
    public void r1(String str, String str2, String str3) {
        this.f23456d.c(z4(new Event("Heatmap Setting Menu Tapped", null, Scopes.f23428a.g(), null, 10, null).a("map_type", str).a("category_id", str2).a("category_name", str3)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics
    public void r2(BigDecimal bigDecimal) {
        this.f23456d.c(z4(new Event("Decrease Custom Price", null, Scopes.f23428a.g(), null, 10, null).a("Distance Rate", bigDecimal)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics
    public void r3() {
        this.f23456d.c(z4(new Event("Bolt Dynamic Price Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.HistoryAnalytics
    public void s(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        this.f23456d.c(z4(new Event("Ride Screen Shown", null, Scopes.f23428a.g(), null, 10, null).a("orderId", Long.valueOf(orderHandle.b()))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics
    public void s0() {
        this.f23456d.c(z4(new Event("Referral Share Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics
    public void s1() {
        this.f23456d.c(z4(new Event("Custom Price Cancellation Modal Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics
    public void s2() {
        this.f23456d.c(z4(new Event("Username Auth Success", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OptInCampaignAnalytics
    public void s3(long j8) {
        this.f23456d.c(z4(new Event("Opt-in Campaign Banner Tapped", null, Scopes.f23428a.g(), null, 10, null).a("ID", Long.valueOf(j8))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void t() {
        this.f23456d.c(z4(new Event("Share Ride Button Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.AppPerformanceAnalytics
    public void t0(String driverId, String country, long j8, long j9, NetworkUsage networkUsage) {
        Intrinsics.f(driverId, "driverId");
        Intrinsics.f(country, "country");
        Intrinsics.f(networkUsage, "networkUsage");
        AnalyticsManager analyticsManager = this.f23456d;
        Scopes scopes = Scopes.f23428a;
        Event a8 = new Event("Daily Network Usage", null, scopes.d(), null, 10, null).a("driver_id", driverId).a("country_code", country).a("start_time", Long.valueOf(j8)).a("end_time", Long.valueOf(j9));
        NetworkUsageUtils networkUsageUtils = NetworkUsageUtils.f23028a;
        analyticsManager.c(a8.a("response_size", Float.valueOf(networkUsageUtils.a(networkUsage.getReceivedBytes()))).a("request_size", Float.valueOf(networkUsageUtils.a(networkUsage.getSentBytes()))).a("total_network_consumption_size", Float.valueOf(networkUsageUtils.a(networkUsage.getTotalBytes()))));
        this.f23456d.c(z4(new Event("(ENG) Daily Network Usage", null, scopes.g(), null, 10, null).a("Start Time", Long.valueOf(j8)).a("End Time", Long.valueOf(j9)).a("Response Size", Float.valueOf(networkUsageUtils.a(networkUsage.getReceivedBytes()))).a("Request Size", Float.valueOf(networkUsageUtils.a(networkUsage.getSentBytes()))).a("Total Network Consumption Size", Float.valueOf(networkUsageUtils.a(networkUsage.getTotalBytes())))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OptInCampaignAnalytics
    public void t1(long j8) {
        this.f23456d.c(z4(new Event("Opt-in Campaign Shown", null, Scopes.f23428a.g(), null, 10, null).a("ID", Long.valueOf(j8))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void t2(boolean z7) {
        this.f23456d.c(z4(new Event("Start Trip Swiped", null, Scopes.f23428a.g(), null, 10, null).a("Is From Widget", Boolean.valueOf(z7))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics
    public void t3() {
        this.f23456d.c(z4(new Event("Action Button Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.QuickAccessStateAnalytics
    public void u() {
        this.f23456d.c(z4(new Event("QA From Promo Settings Tap", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics
    public void u0(boolean z7) {
        String str;
        if (z7) {
            str = "map_dark_mode_turned_on";
        } else {
            str = "map_dark_mode_turned_off";
        }
        this.f23456d.c(new Event(str, null, Scopes.f23428a.d(), null, 10, null));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void u1() {
        this.f23456d.c(z4(new Event("SOS Button Pressed", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void u2() {
        this.f23456d.c(z4(new Event("Pause orders button tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PermissionAnalytics
    public void u3(String source) {
        Intrinsics.f(source, "source");
        this.f23456d.c(z4(new Event("Microphone Access Denied Dialog Shown", null, Scopes.f23428a.g(), null, 10, null).a("source", source)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics
    public void v() {
        this.f23456d.c(z4(new Event("Magic Link Login Screen", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.QuickAccessStateAnalytics
    public void v0() {
        this.f23456d.c(z4(new Event("Extended QA Disabled", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.EarningsV2Analytics
    public void v1() {
        this.f23456d.c(z4(new Event("Balance Tab Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.CampaignAnalytics
    public void v2() {
        this.f23456d.c(z4(new Event("Campaign View Opened", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void v3() {
        this.f23456d.c(z4(new Event("Add stop shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void w() {
        this.f23456d.c(z4(new Event("SOS Screen Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics
    public void w0() {
        this.f23456d.c(z4(new Event("Select Pricing Method Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void w1() {
        this.f23456d.c(z4(new Event("Waiting For Client Screen Shown", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.SafetyToolkitAnalytics
    public void w2(String property, long j8) {
        Intrinsics.f(property, "property");
        this.f23456d.c(z4(new Event("Third party safety incident created", null, Scopes.f23428a.g(), null, 10, null).a("provider", property).a("incident_id", Long.valueOf(j8))));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void w3() {
        this.f23456d.c(z4(new Event("Confirm Price Swiped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PushTokenAnalytics
    public void x(String token, PushTokenAnalytics.TokenType type) {
        Intrinsics.f(token, "token");
        Intrinsics.f(type, "type");
        this.f23456d.c(z4(new Event("(ENG) Push token upload Ignored", null, Scopes.f23428a.g(), null, 10, null).a("token_hash", Integer.valueOf(token.hashCode())).a("token_type", type.toString())));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void x0() {
        this.f23456d.c(z4(new Event("Pause orders dialog confirm tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverAnalytics
    public void x1(long j8, String country) {
        Intrinsics.f(country, "country");
        this.f23458f.b(String.valueOf(j8));
        this.f23456d.f(new Property("Country", country, null, 4, null));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.CampaignAnalytics
    public void x2() {
        this.f23456d.c(z4(new Event("View All Campaigns Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverScoreAnalytics
    public void x3() {
        this.f23456d.c(z4(new Event("Driver Score Intro Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.QuickAccessStateAnalytics
    public void y() {
        this.f23456d.c(z4(new Event("Main QA Disabled", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics
    public void y0() {
        this.f23456d.c(z4(new Event("Cashout Request Failed", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics
    public void y1() {
        this.f23456d.c(z4(new Event("Username Auth Fail", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.CampaignAnalytics
    public void y2() {
        this.f23456d.c(z4(new Event("Campaign Earning Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.DriverScoreAnalytics
    public void y3() {
        this.f23456d.c(z4(new Event("Driver Score Action Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.RateMeAnalytics
    public void z() {
        this.f23456d.c(z4(new Event("Open Rating Screen", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics
    public void z0(boolean z7, CancellationReason cancellationReason) {
        boolean z8;
        Intrinsics.f(cancellationReason, "cancellationReason");
        String a8 = cancellationReason.a();
        Event event = new Event("Cancellation Reason Tapped", null, Scopes.f23428a.g(), null, 10, null);
        event.a("Cancellation Reason", a8);
        if (z7) {
            String b8 = cancellationReason.b();
            if (b8 != null && b8.length() != 0) {
                z8 = false;
            } else {
                z8 = true;
            }
            if (!z8) {
                event.a("Cancellation Reason Comment", cancellationReason.b());
            }
        }
        this.f23456d.c(z4(event));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics
    public void z1() {
        this.f23456d.c(z4(new Event("Forgot Password Tapped", null, Scopes.f23428a.g(), null, 10, null)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.HeatmapAnalytics
    public void z2(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f23456d.c(z4(new Event("Heatmap Setting Updated", null, Scopes.f23428a.g(), null, 10, null).a("old_map_type", str).a("new_map_type", str2).a("old_category_id", str3).a("new_category_id", str4).a("old_category_name", str5).a("new_category_name", str6)));
    }

    @Override // ee.mtakso.driver.service.analytics.event.facade.EarningsV2Analytics
    public void z3(String screenType, String selectedPeriodKey) {
        Intrinsics.f(screenType, "screenType");
        Intrinsics.f(selectedPeriodKey, "selectedPeriodKey");
        this.f23456d.c(z4(new Event("Period Type Tapped", null, Scopes.f23428a.g(), null, 10, null).a("screen", screenType).a("selectedReportPeriod", selectedPeriodKey)));
    }
}
