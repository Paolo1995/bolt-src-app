package ee.mtakso.driver.param;

import ee.mtakso.driver.network.client.targeting.TargetingParameters;
import ee.mtakso.driver.network.client.targeting.TargetingParametersKt;
import eu.bolt.driver.core.field.OverridableField;
import eu.bolt.driver.core.field.io.BooleanReadWrite;
import eu.bolt.driver.core.field.io.StringSetReadWrite;
import eu.bolt.driver.core.storage.BoltPrefsStorage;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: DriverFeatures.kt */
/* loaded from: classes3.dex */
public final class DriverFeatures {
    static final /* synthetic */ KProperty<Object>[] S = {Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "appLogMonitoring", "getAppLogMonitoring()Ljava/util/Set;", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "appLogMonitoringInMemory", "getAppLogMonitoringInMemory()Ljava/util/Set;", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "bigQueryEnabled", "getBigQueryEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "dynamicPollingEnabled", "getDynamicPollingEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "onDemandPayoutEnabled", "getOnDemandPayoutEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "newDashboardEnabled", "getNewDashboardEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "behaviourQualityEnabled", "getBehaviourQualityEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "optionalLocationEnabled", "getOptionalLocationEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "gpsSpeedEnabled", "getGpsSpeedEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "apiErrorsToMixpanelEnabled", "getApiErrorsToMixpanelEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "pollingMessagesEnabled", "getPollingMessagesEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "environmentDataEnabled", "getEnvironmentDataEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "boltVerificationEnabled", "getBoltVerificationEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "carApplicationsEnabled", "getCarApplicationsEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "appVerificationEnabled", "getAppVerificationEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "appVerificationBlockedScreenEnabled", "getAppVerificationBlockedScreenEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "tripSharingEnabled", "getTripSharingEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "darkModeEnabled", "getDarkModeEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "surgeMapOtherDriversDependencyEnabled", "getSurgeMapOtherDriversDependencyEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "cancelOrderDriverScoreWarning", "getCancelOrderDriverScoreWarning()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "cancelOrderCampaignsWarning", "getCancelOrderCampaignsWarning()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "b2bImprovementEnabled", "getB2bImprovementEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "multipleDestinationsEnabled", "getMultipleDestinationsEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "earningsV3Enabled", "getEarningsV3Enabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "earningsV3PieChartAnimationEnabled", "getEarningsV3PieChartAnimationEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "gpsSpeedAndBearingAccuracyEnabled", "getGpsSpeedAndBearingAccuracyEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "pollingV2Enabled", "getPollingV2Enabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "vectorTilesBitmapPoolEnabled", "getVectorTilesBitmapPoolEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "vectorTilesSemaphoreEnabled", "getVectorTilesSemaphoreEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "fifoQueueEnabled", "getFifoQueueEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "heatmapV2UiEnabled", "getHeatmapV2UiEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "safetyToolkitEnabled", "getSafetyToolkitEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "balanceV3Enabled", "getBalanceV3Enabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "b2bAcceptanceChangeEnabled", "getB2bAcceptanceChangeEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "waitingTimeHeatmapEnabled", "getWaitingTimeHeatmapEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "tweaksMenuEnabled", "getTweaksMenuEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "dynamicNavigationOptionsEnabled", "getDynamicNavigationOptionsEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "navigationSettingsTbtEnabled", "getNavigationSettingsTbtEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "activeRideMockLocationDetectEnabled", "getActiveRideMockLocationDetectEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "mockLocationDetectEnabledForAllBuild", "getMockLocationDetectEnabledForAllBuild()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "earningsBreakdownEnabled", "getEarningsBreakdownEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverFeatures.class, "earningsHidePieChartNumbers", "getEarningsHidePieChartNumbers()Z", 0))};
    private final OverridableField<Boolean> A;
    private final OverridableField<Boolean> B;
    private final OverridableField<Boolean> C;
    private final OverridableField<Boolean> D;
    private final OverridableField<Boolean> E;
    private final OverridableField<Boolean> F;
    private final OverridableField<Boolean> G;
    private final OverridableField<Boolean> H;
    private final OverridableField<Boolean> I;
    private final OverridableField<Boolean> J;
    private final OverridableField<Boolean> K;
    private final OverridableField<Boolean> L;
    private final OverridableField<Boolean> M;
    private final OverridableField<Boolean> N;
    private final OverridableField<Boolean> O;
    private final OverridableField<Boolean> P;
    private final OverridableField<Boolean> Q;
    private final OverridableField<Boolean> R;

    /* renamed from: a  reason: collision with root package name */
    private final BooleanReadWrite f23114a;

    /* renamed from: b  reason: collision with root package name */
    private final StringSetReadWrite f23115b;

    /* renamed from: c  reason: collision with root package name */
    private final OverridableField<Set<String>> f23116c;

    /* renamed from: d  reason: collision with root package name */
    private final OverridableField<Set<String>> f23117d;

    /* renamed from: e  reason: collision with root package name */
    private final OverridableField<Boolean> f23118e;

    /* renamed from: f  reason: collision with root package name */
    private final OverridableField<Boolean> f23119f;

    /* renamed from: g  reason: collision with root package name */
    private final OverridableField<Boolean> f23120g;

    /* renamed from: h  reason: collision with root package name */
    private final OverridableField<Boolean> f23121h;

    /* renamed from: i  reason: collision with root package name */
    private final OverridableField<Boolean> f23122i;

    /* renamed from: j  reason: collision with root package name */
    private final OverridableField<Boolean> f23123j;

    /* renamed from: k  reason: collision with root package name */
    private final OverridableField<Boolean> f23124k;

    /* renamed from: l  reason: collision with root package name */
    private final OverridableField<Boolean> f23125l;

    /* renamed from: m  reason: collision with root package name */
    private final OverridableField<Boolean> f23126m;

    /* renamed from: n  reason: collision with root package name */
    private final OverridableField<Boolean> f23127n;

    /* renamed from: o  reason: collision with root package name */
    private final OverridableField<Boolean> f23128o;

    /* renamed from: p  reason: collision with root package name */
    private final OverridableField<Boolean> f23129p;

    /* renamed from: q  reason: collision with root package name */
    private final OverridableField<Boolean> f23130q;

    /* renamed from: r  reason: collision with root package name */
    private final OverridableField<Boolean> f23131r;

    /* renamed from: s  reason: collision with root package name */
    private final OverridableField<Boolean> f23132s;

    /* renamed from: t  reason: collision with root package name */
    private final OverridableField<Boolean> f23133t;

    /* renamed from: u  reason: collision with root package name */
    private final OverridableField<Boolean> f23134u;

    /* renamed from: v  reason: collision with root package name */
    private final OverridableField<Boolean> f23135v;

    /* renamed from: w  reason: collision with root package name */
    private final OverridableField<Boolean> f23136w;

    /* renamed from: x  reason: collision with root package name */
    private final OverridableField<Boolean> f23137x;

    /* renamed from: y  reason: collision with root package name */
    private final OverridableField<Boolean> f23138y;

    /* renamed from: z  reason: collision with root package name */
    private final OverridableField<Boolean> f23139z;

    public DriverFeatures(BoltPrefsStorage storage) {
        Set b8;
        Set b9;
        Intrinsics.f(storage, "storage");
        BooleanReadWrite booleanReadWrite = new BooleanReadWrite(storage);
        this.f23114a = booleanReadWrite;
        StringSetReadWrite stringSetReadWrite = new StringSetReadWrite(storage);
        this.f23115b = stringSetReadWrite;
        b8 = SetsKt__SetsKt.b();
        this.f23116c = new OverridableField<>("monitoring_applog", b8, stringSetReadWrite);
        b9 = SetsKt__SetsKt.b();
        this.f23117d = new OverridableField<>("monitoring_applog_in_memory", b9, stringSetReadWrite);
        Boolean bool = Boolean.FALSE;
        this.f23118e = new OverridableField<>("is_big_query_enabled", bool, booleanReadWrite);
        this.f23119f = new OverridableField<>("is_dynamic_polling_enabled", bool, booleanReadWrite);
        this.f23120g = new OverridableField<>("is_on_demand_payouts_enabled", bool, booleanReadWrite);
        this.f23121h = new OverridableField<>("prod_is_grid_home_dashboard_enabled", bool, booleanReadWrite);
        this.f23122i = new OverridableField<>("dev_is_behaviour_quality_on_mobile_enabled", bool, booleanReadWrite);
        this.f23123j = new OverridableField<>("eng_is_optional_location_enabled", bool, booleanReadWrite);
        this.f23124k = new OverridableField<>("eng_is_gps_speed_enabled", bool, booleanReadWrite);
        this.f23125l = new OverridableField<>("eng_is_api_errors_to_mixpanel_enabled", bool, booleanReadWrite);
        this.f23126m = new OverridableField<>("eng_is_polling_messages_enabled", bool, booleanReadWrite);
        this.f23127n = new OverridableField<>("dev_afs_environment_data_enabled", bool, booleanReadWrite);
        Boolean bool2 = Boolean.TRUE;
        this.f23128o = new OverridableField<>("dev_is_bolt_verification_enabled", bool2, booleanReadWrite);
        this.f23129p = new OverridableField<>("prod_is_car_applications_enabled", bool, booleanReadWrite);
        this.f23130q = new OverridableField<>("prod_driver_app_verification_enabled", bool, booleanReadWrite);
        this.f23131r = new OverridableField<>("prod_driver_app_verification_blocked_screen_enabled", bool, booleanReadWrite);
        this.f23132s = new OverridableField<>("prod_is_trip_sharing_enabled", bool, booleanReadWrite);
        this.f23133t = new OverridableField<>("prod_is_dark_mode_enabled", bool, booleanReadWrite);
        this.f23134u = new OverridableField<>("dev_is_surgemap_other_drivers_dependency_enabled", bool, booleanReadWrite);
        this.f23135v = new OverridableField<>("prod_is_cancel_ride_warning_driver_score_enabled", bool, booleanReadWrite);
        this.f23136w = new OverridableField<>("prod_is_cancel_ride_warning_campaigns_enabled", bool, booleanReadWrite);
        this.f23137x = new OverridableField<>("dev_is_b2b_improvement_enabled", bool, booleanReadWrite);
        this.f23138y = new OverridableField<>("prod_is_multiple_destinations_enabled", bool, booleanReadWrite);
        this.f23139z = new OverridableField<>("prod_is_earnings_v3_enabled", bool, booleanReadWrite);
        this.A = new OverridableField<>("eng_is_earnings_v3_pie_chart_animation_enabled", bool, booleanReadWrite);
        this.B = new OverridableField<>("eng_is_gps_speed_and_bearing_accuracy_enabled", bool, booleanReadWrite);
        this.C = new OverridableField<>("eng_polling_v2_enabled", bool, booleanReadWrite);
        this.D = new OverridableField<>("eng_is_vector_tiles_bitmap_pool_enabled", bool, booleanReadWrite);
        this.E = new OverridableField<>("eng_is_vector_tiles_semaphore_enabled", bool, booleanReadWrite);
        this.F = new OverridableField<>("dev_is_fifo_queue_enabled", bool, booleanReadWrite);
        this.G = new OverridableField<>("dev_is_heatmap_v2_ui_enabled", bool, booleanReadWrite);
        this.H = new OverridableField<>("prod_is_safety_toolkit_enabled", bool, booleanReadWrite);
        this.I = new OverridableField<>("prod_is_balance_v3_enabled", bool, booleanReadWrite);
        this.J = new OverridableField<>("dev_is_b2b_acceptance_change_enabled", bool2, booleanReadWrite);
        this.K = new OverridableField<>("dev_is_waiting_time_heatmap_enabled", bool, booleanReadWrite);
        this.L = new OverridableField<>("dev_is_tweaks_menu_enabled", bool, booleanReadWrite);
        this.M = new OverridableField<>("dev_is_dynamic_navigation_options_list_enabled", bool, booleanReadWrite);
        this.N = new OverridableField<>("prod_navigation_settings_tbt", bool, booleanReadWrite);
        this.O = new OverridableField<>("eng_active_ride_mock_location_detect_enabled", bool, booleanReadWrite);
        this.P = new OverridableField<>("eng_mock_location_detect_enabled_all_builds", bool, booleanReadWrite);
        this.Q = new OverridableField<>("prod_is_earnings_breakdown_enabled", bool, booleanReadWrite);
        this.R = new OverridableField<>("prod_is_earnings_hide_pie_chart_numbers_enabled", bool, booleanReadWrite);
    }

    private final void A0(boolean z7) {
        this.f23132s.e(this, S[16], Boolean.valueOf(z7));
    }

    private final void R(boolean z7) {
        this.f23125l.e(this, S[9], Boolean.valueOf(z7));
    }

    private final void S(Set<String> set) {
        this.f23116c.e(this, S[0], set);
    }

    private final void T(Set<String> set) {
        this.f23117d.e(this, S[1], set);
    }

    private final void U(boolean z7) {
        this.f23131r.e(this, S[15], Boolean.valueOf(z7));
    }

    private final void V(boolean z7) {
        this.f23130q.e(this, S[14], Boolean.valueOf(z7));
    }

    private final void Z(boolean z7) {
        this.f23122i.e(this, S[6], Boolean.valueOf(z7));
    }

    private final void a0(boolean z7) {
        this.f23118e.e(this, S[2], Boolean.valueOf(z7));
    }

    private final void b0(boolean z7) {
        this.f23136w.e(this, S[20], Boolean.valueOf(z7));
    }

    private final void c0(boolean z7) {
        this.f23135v.e(this, S[19], Boolean.valueOf(z7));
    }

    private final void d0(boolean z7) {
        this.f23129p.e(this, S[13], Boolean.valueOf(z7));
    }

    private final void e0(boolean z7) {
        this.f23133t.e(this, S[17], Boolean.valueOf(z7));
    }

    private final void g0(boolean z7) {
        this.f23119f.e(this, S[3], Boolean.valueOf(z7));
    }

    private final void l0(boolean z7) {
        this.f23127n.e(this, S[11], Boolean.valueOf(z7));
    }

    private final void o0(boolean z7) {
        this.f23124k.e(this, S[8], Boolean.valueOf(z7));
    }

    private final void t0(boolean z7) {
        this.f23121h.e(this, S[5], Boolean.valueOf(z7));
    }

    private final void u0(boolean z7) {
        this.f23120g.e(this, S[4], Boolean.valueOf(z7));
    }

    private final void v0(boolean z7) {
        this.f23123j.e(this, S[7], Boolean.valueOf(z7));
    }

    private final void w0(boolean z7) {
        this.f23126m.e(this, S[10], Boolean.valueOf(z7));
    }

    private final void z0(boolean z7) {
        this.f23134u.e(this, S[18], Boolean.valueOf(z7));
    }

    public final boolean A() {
        return this.f23124k.d(this, S[8]).booleanValue();
    }

    public final boolean B() {
        return this.G.d(this, S[30]).booleanValue();
    }

    public final void B0(boolean z7) {
        this.L.e(this, S[35], Boolean.valueOf(z7));
    }

    public final boolean C() {
        return this.f23138y.d(this, S[22]).booleanValue();
    }

    public final void C0(boolean z7) {
        this.D.e(this, S[27], Boolean.valueOf(z7));
    }

    public final boolean D() {
        return this.N.d(this, S[37]).booleanValue();
    }

    public final void D0(boolean z7) {
        this.E.e(this, S[28], Boolean.valueOf(z7));
    }

    public final boolean E() {
        return this.f23121h.d(this, S[5]).booleanValue();
    }

    public final void E0(boolean z7) {
        this.K.e(this, S[34], Boolean.valueOf(z7));
    }

    public final boolean F() {
        return this.f23120g.d(this, S[4]).booleanValue();
    }

    public final boolean G() {
        return this.f23123j.d(this, S[7]).booleanValue();
    }

    public final boolean H() {
        return this.f23126m.d(this, S[10]).booleanValue();
    }

    public final boolean I() {
        return this.C.d(this, S[26]).booleanValue();
    }

    public final boolean J() {
        return this.H.d(this, S[31]).booleanValue();
    }

    public final boolean K() {
        return this.f23134u.d(this, S[18]).booleanValue();
    }

    public final boolean L() {
        return this.f23132s.d(this, S[16]).booleanValue();
    }

    public final boolean M() {
        return this.D.d(this, S[27]).booleanValue();
    }

    public final boolean N() {
        return this.E.d(this, S[28]).booleanValue();
    }

    public final boolean O() {
        return this.K.d(this, S[34]).booleanValue();
    }

    public final void P(TargetingParameters config) {
        Intrinsics.f(config, "config");
        S(TargetingParametersKt.d(config, this.f23116c.b()));
        T(TargetingParametersKt.d(config, this.f23117d.b()));
        a0(TargetingParametersKt.b(config, this.f23118e.b(), this.f23118e.a().booleanValue()));
        g0(TargetingParametersKt.b(config, this.f23119f.b(), this.f23119f.a().booleanValue()));
        u0(TargetingParametersKt.b(config, this.f23120g.b(), this.f23120g.a().booleanValue()));
        Z(TargetingParametersKt.b(config, this.f23122i.b(), this.f23122i.a().booleanValue()));
        t0(TargetingParametersKt.b(config, this.f23121h.b(), this.f23121h.a().booleanValue()));
        v0(TargetingParametersKt.b(config, this.f23123j.b(), this.f23123j.a().booleanValue()));
        o0(TargetingParametersKt.b(config, this.f23124k.b(), this.f23124k.a().booleanValue()));
        R(TargetingParametersKt.b(config, this.f23125l.b(), this.f23125l.a().booleanValue()));
        w0(TargetingParametersKt.b(config, this.f23126m.b(), this.f23126m.a().booleanValue()));
        l0(TargetingParametersKt.b(config, this.f23127n.b(), this.f23127n.a().booleanValue()));
        d0(TargetingParametersKt.a(config, this.f23129p));
        V(TargetingParametersKt.b(config, this.f23130q.b(), this.f23130q.a().booleanValue()));
        U(TargetingParametersKt.b(config, this.f23131r.b(), this.f23131r.a().booleanValue()));
        A0(TargetingParametersKt.b(config, this.f23132s.b(), this.f23132s.a().booleanValue()));
        e0(TargetingParametersKt.a(config, this.f23133t));
        z0(TargetingParametersKt.a(config, this.f23134u));
        c0(TargetingParametersKt.a(config, this.f23135v));
        b0(TargetingParametersKt.a(config, this.f23136w));
        X(TargetingParametersKt.a(config, this.f23137x));
        r0(TargetingParametersKt.a(config, this.f23138y));
        j0(TargetingParametersKt.a(config, this.f23139z));
        k0(TargetingParametersKt.a(config, this.A));
        n0(TargetingParametersKt.a(config, this.B));
        x0(TargetingParametersKt.a(config, this.f23126m));
        C0(TargetingParametersKt.a(config, this.D));
        D0(TargetingParametersKt.a(config, this.E));
        m0(TargetingParametersKt.a(config, this.F));
        p0(TargetingParametersKt.a(config, this.G));
        y0(TargetingParametersKt.a(config, this.H));
        Y(TargetingParametersKt.a(config, this.I));
        W(TargetingParametersKt.a(config, this.J));
        E0(TargetingParametersKt.a(config, this.K));
        B0(TargetingParametersKt.a(config, this.L));
        f0(TargetingParametersKt.a(config, this.M));
        s0(TargetingParametersKt.a(config, this.N));
        Q(TargetingParametersKt.a(config, this.O));
        q0(TargetingParametersKt.a(config, this.P));
        h0(TargetingParametersKt.a(config, this.Q));
        i0(TargetingParametersKt.a(config, this.R));
    }

    public final void Q(boolean z7) {
        this.O.e(this, S[38], Boolean.valueOf(z7));
    }

    public final void W(boolean z7) {
        this.J.e(this, S[33], Boolean.valueOf(z7));
    }

    public final void X(boolean z7) {
        this.f23137x.e(this, S[21], Boolean.valueOf(z7));
    }

    public final void Y(boolean z7) {
        this.I.e(this, S[32], Boolean.valueOf(z7));
    }

    public final List<OverridableField<? extends Object>> a() {
        List<OverridableField<? extends Object>> n8;
        n8 = CollectionsKt__CollectionsKt.n(this.f23118e, this.f23116c, this.f23117d, this.f23119f, this.f23120g, this.f23122i, this.f23121h, this.f23123j, this.f23124k, this.f23125l, this.f23126m, this.f23127n, this.f23129p, this.f23132s, this.f23133t, this.f23134u, this.f23135v, this.f23136w, this.f23130q, this.f23131r, this.f23137x, this.f23138y, this.f23139z, this.A, this.B, this.C, this.D, this.E, this.F, this.G, this.H, this.I, this.J, this.K, this.L, this.M, this.N, this.O, this.P, this.Q, this.R);
        return n8;
    }

    public final boolean b() {
        return this.O.d(this, S[38]).booleanValue();
    }

    public final boolean c() {
        return this.f23125l.d(this, S[9]).booleanValue();
    }

    public final Set<String> d() {
        return this.f23116c.d(this, S[0]);
    }

    public final Set<String> e() {
        return this.f23117d.d(this, S[1]);
    }

    public final boolean f() {
        return this.f23131r.d(this, S[15]).booleanValue();
    }

    public final void f0(boolean z7) {
        this.M.e(this, S[36], Boolean.valueOf(z7));
    }

    public final boolean g() {
        return this.f23130q.d(this, S[14]).booleanValue();
    }

    public final boolean h() {
        return this.J.d(this, S[33]).booleanValue();
    }

    public final void h0(boolean z7) {
        this.Q.e(this, S[40], Boolean.valueOf(z7));
    }

    public final boolean i() {
        return this.f23137x.d(this, S[21]).booleanValue();
    }

    public final void i0(boolean z7) {
        this.R.e(this, S[41], Boolean.valueOf(z7));
    }

    public final boolean j() {
        return this.I.d(this, S[32]).booleanValue();
    }

    public final void j0(boolean z7) {
        this.f23139z.e(this, S[23], Boolean.valueOf(z7));
    }

    public final boolean k() {
        return this.f23122i.d(this, S[6]).booleanValue();
    }

    public final void k0(boolean z7) {
        this.A.e(this, S[24], Boolean.valueOf(z7));
    }

    public final boolean l() {
        return this.f23118e.d(this, S[2]).booleanValue();
    }

    public final boolean m() {
        return this.f23128o.d(this, S[12]).booleanValue();
    }

    public final void m0(boolean z7) {
        this.F.e(this, S[29], Boolean.valueOf(z7));
    }

    public final boolean n() {
        return this.f23136w.d(this, S[20]).booleanValue();
    }

    public final void n0(boolean z7) {
        this.B.e(this, S[25], Boolean.valueOf(z7));
    }

    public final boolean o() {
        return this.f23135v.d(this, S[19]).booleanValue();
    }

    public final boolean p() {
        return this.f23129p.d(this, S[13]).booleanValue();
    }

    public final void p0(boolean z7) {
        this.G.e(this, S[30], Boolean.valueOf(z7));
    }

    public final boolean q() {
        return this.f23133t.d(this, S[17]).booleanValue();
    }

    public final void q0(boolean z7) {
        this.P.e(this, S[39], Boolean.valueOf(z7));
    }

    public final boolean r() {
        return this.M.d(this, S[36]).booleanValue();
    }

    public final void r0(boolean z7) {
        this.f23138y.e(this, S[22], Boolean.valueOf(z7));
    }

    public final boolean s() {
        return this.f23119f.d(this, S[3]).booleanValue();
    }

    public final void s0(boolean z7) {
        this.N.e(this, S[37], Boolean.valueOf(z7));
    }

    public final boolean t() {
        return this.Q.d(this, S[40]).booleanValue();
    }

    public final boolean u() {
        return this.R.d(this, S[41]).booleanValue();
    }

    public final boolean v() {
        return this.f23139z.d(this, S[23]).booleanValue();
    }

    public final boolean w() {
        return this.A.d(this, S[24]).booleanValue();
    }

    public final boolean x() {
        return this.f23127n.d(this, S[11]).booleanValue();
    }

    public final void x0(boolean z7) {
        this.C.e(this, S[26], Boolean.valueOf(z7));
    }

    public final boolean y() {
        return this.F.d(this, S[29]).booleanValue();
    }

    public final void y0(boolean z7) {
        this.H.e(this, S[31], Boolean.valueOf(z7));
    }

    public final boolean z() {
        return this.B.d(this, S[25]).booleanValue();
    }
}
