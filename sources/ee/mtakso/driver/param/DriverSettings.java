package ee.mtakso.driver.param;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ee.mtakso.driver.navigation.navigators.Navigator;
import ee.mtakso.driver.param.field.BooleanSettingsField;
import ee.mtakso.driver.param.field.IntSettingsField;
import ee.mtakso.driver.param.field.LongSettingsField;
import ee.mtakso.driver.param.field.StringSettingsField;
import ee.mtakso.driver.ui.screens.navigator_chooser.NavigationOption;
import eu.bolt.driver.core.field.ObservableField;
import eu.bolt.driver.core.field.SimpleField;
import eu.bolt.driver.core.field.io.BooleanReadWrite;
import eu.bolt.driver.core.field.io.EnumStateSetReadWrite;
import eu.bolt.driver.core.field.io.IntReadWrite;
import eu.bolt.driver.core.field.io.JsonReadWrite;
import eu.bolt.driver.core.field.io.LongReadWrite;
import eu.bolt.driver.core.field.io.ReadWrite;
import eu.bolt.driver.core.field.io.StringReadWrite;
import eu.bolt.driver.core.field.io.StringSetReadWrite;
import eu.bolt.driver.core.storage.BoltPrefsStorage;
import eu.bolt.driver.core.theme.AppThemeMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: DriverSettings.kt */
/* loaded from: classes3.dex */
public final class DriverSettings {

    /* renamed from: a0  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f23163a0 = {Reflection.d(new MutablePropertyReference1Impl(DriverSettings.class, "quickAccessPromoShown", "getQuickAccessPromoShown()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverSettings.class, "language", "getLanguage()Ljava/lang/String;", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverSettings.class, "voipPromoShown", "getVoipPromoShown()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverSettings.class, "autoAcceptancePromoShown", "getAutoAcceptancePromoShown()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverSettings.class, "lowStorageWarningPromoShown", "getLowStorageWarningPromoShown()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverSettings.class, "clevertapNotifiedInboxMessageIds", "getClevertapNotifiedInboxMessageIds()Ljava/util/Set;", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverSettings.class, "driverScoreShown", "getDriverScoreShown()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverSettings.class, "standardDriverPricingShown", "getStandardDriverPricingShown()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverSettings.class, "standardDriverPricingAccepted", "getStandardDriverPricingAccepted()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverSettings.class, "driverScoreDroppedShown", "getDriverScoreDroppedShown()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverSettings.class, "devAppThemeMode", "getDevAppThemeMode()Leu/bolt/driver/core/theme/AppThemeMode;", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverSettings.class, "appThemeMode", "getAppThemeMode()Leu/bolt/driver/core/theme/AppThemeMode;", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverSettings.class, "visibleSurgeCategoryId", "getVisibleSurgeCategoryId()Ljava/lang/String;", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverSettings.class, "visibleSurgeCategoryIdSet", "getVisibleSurgeCategoryIdSet()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverSettings.class, "notificationPermissionCounter", "getNotificationPermissionCounter()I", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverSettings.class, "tripAudioNewLabelCounter", "getTripAudioNewLabelCounter()I", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverSettings.class, "tripAudioNewLabelEnabled", "getTripAudioNewLabelEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverSettings.class, "activeIncidentId", "getActiveIncidentId()J", 0)), Reflection.d(new MutablePropertyReference1Impl(DriverSettings.class, "heatmapId", "getHeatmapId()Ljava/lang/String;", 0))};
    private final BooleanSettingsField A;
    private final BooleanSettingsField B;
    private final BooleanSettingsField C;
    private final ObservableField<Navigator.Type> D;
    private final SimpleField E;
    private final SimpleField F;
    private final SimpleField G;
    private final SimpleField H;
    private final SimpleField I;
    private final BooleanSettingsField J;
    private final BooleanSettingsField K;
    private final BooleanSettingsField L;
    private final BooleanSettingsField M;
    private final SimpleField N;
    private final SimpleField O;
    private final SimpleField P;
    private final SimpleField Q;
    private final SimpleField<AppThemeMode> R;
    private final SimpleField S;
    private final SimpleField T;
    private final SimpleField U;
    private final SimpleField V;
    private final SimpleField W;
    private final SimpleField X;
    private final SimpleField Y;
    private ObservableField<NavigationOption> Z;

    /* renamed from: a  reason: collision with root package name */
    private final BoltPrefsStorage f23164a;

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f23165b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverSettings$navigatorRW$1 f23166c;

    /* renamed from: d  reason: collision with root package name */
    private final BooleanReadWrite f23167d;

    /* renamed from: e  reason: collision with root package name */
    private final StringReadWrite f23168e;

    /* renamed from: f  reason: collision with root package name */
    private final StringSetReadWrite f23169f;

    /* renamed from: g  reason: collision with root package name */
    private final EnumStateSetReadWrite<AppThemeMode> f23170g;

    /* renamed from: h  reason: collision with root package name */
    private final IntReadWrite f23171h;

    /* renamed from: i  reason: collision with root package name */
    private final LongReadWrite f23172i;

    /* renamed from: j  reason: collision with root package name */
    private final JsonReadWrite<NavigationOption> f23173j;

    /* renamed from: k  reason: collision with root package name */
    private final BooleanSettingsField f23174k;

    /* renamed from: l  reason: collision with root package name */
    private final BooleanSettingsField f23175l;

    /* renamed from: m  reason: collision with root package name */
    private final SimpleField f23176m;

    /* renamed from: n  reason: collision with root package name */
    private final BooleanSettingsField f23177n;

    /* renamed from: o  reason: collision with root package name */
    private final BooleanSettingsField f23178o;

    /* renamed from: p  reason: collision with root package name */
    private final IntSettingsField f23179p;

    /* renamed from: q  reason: collision with root package name */
    private final SimpleField<String> f23180q;

    /* renamed from: r  reason: collision with root package name */
    private final StringSettingsField f23181r;

    /* renamed from: s  reason: collision with root package name */
    private final StringSettingsField f23182s;

    /* renamed from: t  reason: collision with root package name */
    private final IntSettingsField f23183t;

    /* renamed from: u  reason: collision with root package name */
    private final BooleanSettingsField f23184u;

    /* renamed from: v  reason: collision with root package name */
    private final BooleanSettingsField f23185v;

    /* renamed from: w  reason: collision with root package name */
    private final BooleanSettingsField f23186w;

    /* renamed from: x  reason: collision with root package name */
    private final BooleanSettingsField f23187x;

    /* renamed from: y  reason: collision with root package name */
    private final LongSettingsField f23188y;

    /* renamed from: z  reason: collision with root package name */
    private final BooleanSettingsField f23189z;

    /* JADX WARN: Type inference failed for: r2v4, types: [ee.mtakso.driver.param.DriverSettings$navigatorRW$1, eu.bolt.driver.core.field.io.ReadWrite] */
    public DriverSettings(BoltPrefsStorage driverStorage, DriverConfig driverConfig) {
        Lazy b8;
        Set b9;
        Intrinsics.f(driverStorage, "driverStorage");
        Intrinsics.f(driverConfig, "driverConfig");
        this.f23164a = driverStorage;
        b8 = LazyKt__LazyJVMKt.b(new Function0<Gson>() { // from class: ee.mtakso.driver.param.DriverSettings$gson$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Gson invoke() {
                return new Gson();
            }
        });
        this.f23165b = b8;
        ?? r22 = new ReadWrite<Navigator.Type>() { // from class: ee.mtakso.driver.param.DriverSettings$navigatorRW$1
            @Override // eu.bolt.driver.core.field.io.ReadWrite
            public boolean c(String key) {
                BoltPrefsStorage boltPrefsStorage;
                Intrinsics.f(key, "key");
                boltPrefsStorage = DriverSettings.this.f23164a;
                return boltPrefsStorage.contains(key);
            }

            @Override // eu.bolt.driver.core.field.io.ReadWrite
            /* renamed from: d */
            public Navigator.Type a(String key, Navigator.Type fallback) {
                BoltPrefsStorage boltPrefsStorage;
                Intrinsics.f(key, "key");
                Intrinsics.f(fallback, "fallback");
                Navigator.Type.Companion companion = Navigator.Type.f21237g;
                boltPrefsStorage = DriverSettings.this.f23164a;
                return companion.a(boltPrefsStorage.a("external_navigator", fallback.c()));
            }

            @Override // eu.bolt.driver.core.field.io.ReadWrite
            /* renamed from: e */
            public void b(String key, Navigator.Type value) {
                BoltPrefsStorage boltPrefsStorage;
                Intrinsics.f(key, "key");
                Intrinsics.f(value, "value");
                boltPrefsStorage = DriverSettings.this.f23164a;
                boltPrefsStorage.b("external_navigator", Integer.valueOf(value.c()));
            }
        };
        this.f23166c = r22;
        BooleanReadWrite booleanReadWrite = new BooleanReadWrite(driverStorage);
        this.f23167d = booleanReadWrite;
        StringReadWrite stringReadWrite = new StringReadWrite(driverStorage);
        this.f23168e = stringReadWrite;
        StringSetReadWrite stringSetReadWrite = new StringSetReadWrite(driverStorage);
        this.f23169f = stringSetReadWrite;
        EnumStateSetReadWrite<AppThemeMode> enumStateSetReadWrite = new EnumStateSetReadWrite<>(driverStorage);
        this.f23170g = enumStateSetReadWrite;
        IntReadWrite intReadWrite = new IntReadWrite(driverStorage);
        this.f23171h = intReadWrite;
        LongReadWrite longReadWrite = new LongReadWrite(driverStorage);
        this.f23172i = longReadWrite;
        JsonReadWrite<NavigationOption> jsonReadWrite = new JsonReadWrite<>(driverStorage, NavigationOption.class);
        this.f23173j = jsonReadWrite;
        this.f23174k = new BooleanSettingsField("bolt_head", true, driverStorage);
        this.f23175l = new BooleanSettingsField("is_extended_quick_access_enabled", false, driverStorage);
        Boolean bool = Boolean.FALSE;
        this.f23176m = new SimpleField("is_quick_access_promo_shown", bool, booleanReadWrite);
        this.f23177n = new BooleanSettingsField("is_map_dark_mode_enabled", false, driverStorage);
        this.f23178o = new BooleanSettingsField("is_auto_navigation_enabled", false, driverStorage);
        this.f23179p = new IntSettingsField("customWorkRadius", driverConfig.K(), driverStorage);
        this.f23180q = new SimpleField<>("language", "", stringReadWrite);
        this.f23181r = new StringSettingsField("balance_view_report_mode_key", null, driverStorage);
        this.f23182s = new StringSettingsField("category_region_id", null, driverStorage);
        this.f23183t = new IntSettingsField("category_selection_promotion", 0, driverStorage);
        this.f23184u = new BooleanSettingsField("is_permission_onboarding_completed", false, driverStorage);
        this.f23185v = new BooleanSettingsField("should_auto_select_auto_navigation", false, driverStorage);
        this.f23186w = new BooleanSettingsField("select_external_navigator_prompt", false, driverStorage);
        this.f23187x = new BooleanSettingsField("is_auto_navigation_prompt_showed", false, driverStorage);
        this.f23188y = new LongSettingsField("busy_expires_at", -1L, driverStorage);
        this.f23189z = new BooleanSettingsField("gps_missing_event_sent", false, driverStorage);
        this.A = new BooleanSettingsField("driver_destinations_screen_visited", false, driverStorage);
        this.B = new BooleanSettingsField("earnings_hint_disabled", false, driverStorage);
        this.C = new BooleanSettingsField("driver_destination_used", false, driverStorage);
        this.D = new ObservableField<>("external_navigator", Navigator.Type.NO_NAVIGATION_SELECTED, r22);
        this.E = new SimpleField("is_voip_promo_shown", bool, booleanReadWrite);
        this.F = new SimpleField("is_auto_acceptance_promo_shown", bool, booleanReadWrite);
        this.G = new SimpleField("is_low_storage_warning_promo_shown", bool, booleanReadWrite);
        b9 = SetsKt__SetsKt.b();
        this.H = new SimpleField("clevertap_notified_inbox_message_ids", b9, stringSetReadWrite);
        this.I = new SimpleField("driver_score_shown", bool, booleanReadWrite);
        this.J = new BooleanSettingsField("category_surge_tooltip_shown", false, driverStorage);
        this.K = new BooleanSettingsField("safety_toolkit_tooltip_shown", false, driverStorage);
        this.L = new BooleanSettingsField("trip_audio_tooltip_shown", false, driverStorage);
        this.M = new BooleanSettingsField("trip_audio_safety_toolkit_fab_tapped", false, driverStorage);
        this.N = new SimpleField("standardDriverPricingShown", bool, booleanReadWrite);
        this.O = new SimpleField("standardDriverPricingAccepted", bool, booleanReadWrite);
        this.P = new SimpleField("driverScoreDroppedShown", bool, booleanReadWrite);
        AppThemeMode.Companion companion = AppThemeMode.f40966g;
        this.Q = new SimpleField("dev_app_theme_mode", companion.a(), enumStateSetReadWrite);
        this.R = new SimpleField<>("app_theme_mode", companion.a(), enumStateSetReadWrite);
        this.S = new SimpleField("visible_surge_category_id", "", stringReadWrite);
        this.T = new SimpleField("visible_surge_category_id_set", bool, booleanReadWrite);
        this.U = new SimpleField("notification_permission_counter", 0, intReadWrite);
        this.V = new SimpleField("trip_audio_new_label_counter", 0, intReadWrite);
        this.W = new SimpleField("trip_audio_new_label_enabled", Boolean.TRUE, booleanReadWrite);
        this.X = new SimpleField("active_incident_id", 0L, longReadWrite);
        this.Y = new SimpleField("heatmap_id", "", stringReadWrite);
        this.Z = new ObservableField<>("selected_external_navigator", null, jsonReadWrite);
    }

    private final Gson t() {
        return (Gson) this.f23165b.getValue();
    }

    public final boolean A() {
        return ((Boolean) this.G.a(this, f23163a0[4])).booleanValue();
    }

    public final BooleanSettingsField B() {
        return this.f23177n;
    }

    public final int C() {
        return ((Number) this.U.a(this, f23163a0[14])).intValue();
    }

    public final BooleanSettingsField D() {
        return this.f23184u;
    }

    public final BooleanSettingsField E() {
        return this.f23174k;
    }

    public final BooleanSettingsField F() {
        return this.f23175l;
    }

    public final boolean G() {
        return ((Boolean) this.f23176m.a(this, f23163a0[0])).booleanValue();
    }

    public final BooleanSettingsField H() {
        return this.K;
    }

    public final ObservableField<NavigationOption> I() {
        return this.Z;
    }

    public final BooleanSettingsField J() {
        return this.f23185v;
    }

    public final boolean K() {
        return ((Boolean) this.O.a(this, f23163a0[8])).booleanValue();
    }

    public final int L() {
        return ((Number) this.V.a(this, f23163a0[15])).intValue();
    }

    public final boolean M() {
        return ((Boolean) this.W.a(this, f23163a0[16])).booleanValue();
    }

    public final BooleanSettingsField N() {
        return this.M;
    }

    public final BooleanSettingsField O() {
        return this.L;
    }

    public final String P() {
        return (String) this.S.a(this, f23163a0[12]);
    }

    public final boolean Q() {
        return ((Boolean) this.T.a(this, f23163a0[13])).booleanValue();
    }

    public final boolean R() {
        return ((Boolean) this.E.a(this, f23163a0[2])).booleanValue();
    }

    public final IntSettingsField S() {
        return this.f23179p;
    }

    public final void T() {
        this.f23164a.b("user_tried_to_install_new_navigation_system", null);
    }

    public final void U(List<SosSentEvent> list) {
        this.f23164a.c("sos_sent_event", t().toJson(list));
    }

    public final void V(long j8) {
        this.X.b(this, f23163a0[17], Long.valueOf(j8));
    }

    public final void W(AppThemeMode appThemeMode) {
        Intrinsics.f(appThemeMode, "<set-?>");
        this.R.b(this, f23163a0[11], appThemeMode);
    }

    public final void X(boolean z7) {
        this.F.b(this, f23163a0[3], Boolean.valueOf(z7));
    }

    public final void Y(Set<String> set) {
        Intrinsics.f(set, "<set-?>");
        this.H.b(this, f23163a0[5], set);
    }

    public final void Z(AppThemeMode appThemeMode) {
        Intrinsics.f(appThemeMode, "<set-?>");
        this.Q.b(this, f23163a0[10], appThemeMode);
    }

    public final void a0(boolean z7) {
        this.P.b(this, f23163a0[9], Boolean.valueOf(z7));
    }

    public final long b() {
        return ((Number) this.X.a(this, f23163a0[17])).longValue();
    }

    public final void b0(boolean z7) {
        this.I.b(this, f23163a0[6], Boolean.valueOf(z7));
    }

    public final AppThemeMode c() {
        return this.R.a(this, f23163a0[11]);
    }

    public final void c0(Navigator.Type navigatorType) {
        Intrinsics.f(navigatorType, "navigatorType");
        this.D.c(navigatorType);
    }

    public final SimpleField<AppThemeMode> d() {
        return this.R;
    }

    public final void d0(String str) {
        Intrinsics.f(str, "<set-?>");
        this.Y.b(this, f23163a0[18], str);
    }

    public final boolean e() {
        return ((Boolean) this.F.a(this, f23163a0[3])).booleanValue();
    }

    public final void e0(String str) {
        Intrinsics.f(str, "<set-?>");
        this.f23180q.b(this, f23163a0[1], str);
    }

    public final BooleanSettingsField f() {
        return this.f23178o;
    }

    public final void f0(Navigator.Type type) {
        Intrinsics.f(type, "type");
        this.f23164a.b("user_tried_to_install_new_navigation_system", Integer.valueOf(type.c()));
    }

    public final BooleanSettingsField g() {
        return this.f23187x;
    }

    public final void g0(Navigator.Type navigatorType) {
        Intrinsics.f(navigatorType, "navigatorType");
        this.f23164a.b("last_navigator", Integer.valueOf(navigatorType.c()));
    }

    public final StringSettingsField h() {
        return this.f23181r;
    }

    public final void h0(boolean z7) {
        this.G.b(this, f23163a0[4], Boolean.valueOf(z7));
    }

    public final LongSettingsField i() {
        return this.f23188y;
    }

    public final void i0(int i8) {
        this.U.b(this, f23163a0[14], Integer.valueOf(i8));
    }

    public final IntSettingsField j() {
        return this.f23183t;
    }

    public final void j0(boolean z7) {
        this.f23176m.b(this, f23163a0[0], Boolean.valueOf(z7));
    }

    public final BooleanSettingsField k() {
        return this.J;
    }

    public final void k0(boolean z7) {
        this.O.b(this, f23163a0[8], Boolean.valueOf(z7));
    }

    public final Set<String> l() {
        return (Set) this.H.a(this, f23163a0[5]);
    }

    public final void l0(int i8) {
        this.V.b(this, f23163a0[15], Integer.valueOf(i8));
    }

    public final BooleanSettingsField m() {
        return this.C;
    }

    public final void m0(boolean z7) {
        this.W.b(this, f23163a0[16], Boolean.valueOf(z7));
    }

    public final AppThemeMode n() {
        return (AppThemeMode) this.Q.a(this, f23163a0[10]);
    }

    public final void n0(String str) {
        Intrinsics.f(str, "<set-?>");
        this.S.b(this, f23163a0[12], str);
    }

    public final BooleanSettingsField o() {
        return this.A;
    }

    public final void o0(boolean z7) {
        this.T.b(this, f23163a0[13], Boolean.valueOf(z7));
    }

    public final boolean p() {
        return ((Boolean) this.P.a(this, f23163a0[9])).booleanValue();
    }

    public final void p0(boolean z7) {
        this.E.b(this, f23163a0[2], Boolean.valueOf(z7));
    }

    public final boolean q() {
        return ((Boolean) this.I.a(this, f23163a0[6])).booleanValue();
    }

    public final ObservableField<Navigator.Type> r() {
        return this.D;
    }

    public final BooleanSettingsField s() {
        return this.f23186w;
    }

    public final String u() {
        return (String) this.Y.a(this, f23163a0[18]);
    }

    public final String v() {
        return this.f23180q.a(this, f23163a0[1]);
    }

    public final SimpleField<String> w() {
        return this.f23180q;
    }

    public final StringSettingsField x() {
        return this.f23182s;
    }

    public final Navigator.Type y() {
        if (!this.f23164a.contains("user_tried_to_install_new_navigation_system")) {
            return null;
        }
        return Navigator.Type.f21237g.a(this.f23164a.a("user_tried_to_install_new_navigation_system", Navigator.Type.NO_NAVIGATION_SELECTED.c()));
    }

    public final List<SosSentEvent> z() {
        boolean z7;
        String str = "";
        String string = this.f23164a.getString("sos_sent_event", "");
        if (string != null) {
            str = string;
        }
        if (str.length() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            Object fromJson = t().fromJson(str, new TypeToken<List<? extends SosSentEvent>>() { // from class: ee.mtakso.driver.param.DriverSettings$getLatestSosEvents$type$1
            }.getType());
            Intrinsics.e(fromJson, "gson.fromJson<List<SosSe…Event>>(jsonString, type)");
            return (List) fromJson;
        }
        return new ArrayList();
    }
}
