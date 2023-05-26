package ee.mtakso.driver.param;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ee.mtakso.driver.param.field.BooleanSettingsField;
import ee.mtakso.driver.param.field.IntSettingsField;
import ee.mtakso.driver.param.field.LongSettingsField;
import ee.mtakso.driver.param.field.StringSettingsField;
import ee.mtakso.driver.prefs.SettingsConfig$Defaults;
import ee.mtakso.driver.service.auth.AppVersionState;
import ee.mtakso.driver.service.version.AppVersionStateMapper;
import eu.bolt.driver.core.field.SimpleField;
import eu.bolt.driver.core.field.io.BooleanReadWrite;
import eu.bolt.driver.core.field.io.EnumStateSetReadWrite;
import eu.bolt.driver.core.field.io.JsonReadWrite;
import eu.bolt.driver.core.network.client.driver.DriverAppConfig;
import eu.bolt.driver.core.network.client.driver.DriverConfiguration;
import eu.bolt.driver.core.network.client.driver.DriverFeaturesConfig;
import eu.bolt.driver.core.network.client.driver.DriverProfileConfig;
import eu.bolt.driver.core.storage.BoltPrefsStorage;
import eu.bolt.kalev.Kalev;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: MutableDriverConfig.kt */
/* loaded from: classes3.dex */
public final class MutableDriverConfig {
    static final /* synthetic */ KProperty<Object>[] V = {Reflection.d(new MutablePropertyReference1Impl(MutableDriverConfig.class, "isBlockedByTraining", "isBlockedByTraining()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(MutableDriverConfig.class, "workingTimeMode", "getWorkingTimeMode()Leu/bolt/driver/core/network/client/driver/DriverFeaturesConfig$WorkingTimeMode;", 0)), Reflection.d(new MutablePropertyReference1Impl(MutableDriverConfig.class, "activityConfig", "getActivityConfig()Leu/bolt/driver/core/network/client/driver/DriverAppConfig$Activity;", 0)), Reflection.d(new MutablePropertyReference1Impl(MutableDriverConfig.class, "behaviourQualityEnabled", "getBehaviourQualityEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(MutableDriverConfig.class, "circleKLoyaltyCampaignStatus", "getCircleKLoyaltyCampaignStatus()Leu/bolt/driver/core/network/client/driver/DriverFeaturesConfig$CircleKLoyaltyCampaignStatus;", 0)), Reflection.d(new MutablePropertyReference1Impl(MutableDriverConfig.class, "scheduledRidesEnabled", "getScheduledRidesEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(MutableDriverConfig.class, "loyaltyPlatformEnabled", "getLoyaltyPlatformEnabled()Z", 0)), Reflection.d(new MutablePropertyReference1Impl(MutableDriverConfig.class, "isTripAudioRecordingEnabled", "isTripAudioRecordingEnabled()Z", 0))};
    private final StringSettingsField A;
    private final StringSettingsField B;
    private final BooleanSettingsField C;
    private final StringSettingsField D;
    private final BooleanSettingsField E;
    private final IntSettingsField F;
    private final IntSettingsField G;
    private final IntSettingsField H;
    private final IntSettingsField I;
    private final StringSettingsField J;
    private final BooleanSettingsField K;
    private final SimpleField L;
    private final SimpleField M;
    private AppVersionState N;
    private final SimpleField O;
    private final SimpleField P;
    private final SimpleField Q;
    private final SimpleField R;
    private final StringSettingsField S;
    private final SimpleField T;
    private final SimpleField U;

    /* renamed from: a  reason: collision with root package name */
    private final BoltPrefsStorage f23194a;

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f23195b;

    /* renamed from: c  reason: collision with root package name */
    private final EnumStateSetReadWrite<DriverFeaturesConfig.WorkingTimeMode> f23196c;

    /* renamed from: d  reason: collision with root package name */
    private final EnumStateSetReadWrite<DriverFeaturesConfig.CircleKLoyaltyCampaignStatus> f23197d;

    /* renamed from: e  reason: collision with root package name */
    private final JsonReadWrite<DriverAppConfig.Activity> f23198e;

    /* renamed from: f  reason: collision with root package name */
    private final BooleanReadWrite f23199f;

    /* renamed from: g  reason: collision with root package name */
    private final LongSettingsField f23200g;

    /* renamed from: h  reason: collision with root package name */
    private final StringSettingsField f23201h;

    /* renamed from: i  reason: collision with root package name */
    private final BooleanSettingsField f23202i;

    /* renamed from: j  reason: collision with root package name */
    private final BooleanSettingsField f23203j;

    /* renamed from: k  reason: collision with root package name */
    private final LongSettingsField f23204k;

    /* renamed from: l  reason: collision with root package name */
    private final StringSettingsField f23205l;

    /* renamed from: m  reason: collision with root package name */
    private final LongSettingsField f23206m;

    /* renamed from: n  reason: collision with root package name */
    private final StringSettingsField f23207n;

    /* renamed from: o  reason: collision with root package name */
    private final StringSettingsField f23208o;

    /* renamed from: p  reason: collision with root package name */
    private final ActiveReferralCampaign f23209p;

    /* renamed from: q  reason: collision with root package name */
    private final IntSettingsField f23210q;

    /* renamed from: r  reason: collision with root package name */
    private final StringSettingsField f23211r;

    /* renamed from: s  reason: collision with root package name */
    private final LongSettingsField f23212s;

    /* renamed from: t  reason: collision with root package name */
    private final StringSettingsField f23213t;

    /* renamed from: u  reason: collision with root package name */
    private final BooleanSettingsField f23214u;

    /* renamed from: v  reason: collision with root package name */
    private final StringSettingsField f23215v;

    /* renamed from: w  reason: collision with root package name */
    private final BooleanSettingsField f23216w;

    /* renamed from: x  reason: collision with root package name */
    private final BooleanSettingsField f23217x;

    /* renamed from: y  reason: collision with root package name */
    private final IntSettingsField f23218y;

    /* renamed from: z  reason: collision with root package name */
    private final StringSettingsField f23219z;

    public MutableDriverConfig(BoltPrefsStorage driverStorage) {
        Lazy b8;
        Intrinsics.f(driverStorage, "driverStorage");
        this.f23194a = driverStorage;
        b8 = LazyKt__LazyJVMKt.b(new Function0<Gson>() { // from class: ee.mtakso.driver.param.MutableDriverConfig$gson$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Gson invoke() {
                return new Gson();
            }
        });
        this.f23195b = b8;
        EnumStateSetReadWrite<DriverFeaturesConfig.WorkingTimeMode> enumStateSetReadWrite = new EnumStateSetReadWrite<>(driverStorage);
        this.f23196c = enumStateSetReadWrite;
        EnumStateSetReadWrite<DriverFeaturesConfig.CircleKLoyaltyCampaignStatus> enumStateSetReadWrite2 = new EnumStateSetReadWrite<>(driverStorage);
        this.f23197d = enumStateSetReadWrite2;
        Type type = new TypeToken<DriverAppConfig.Activity>() { // from class: ee.mtakso.driver.param.MutableDriverConfig$activityConfigAdapter$1
        }.getType();
        Intrinsics.e(type, "object: TypeToken<Driver…Config.Activity>(){}.type");
        JsonReadWrite<DriverAppConfig.Activity> jsonReadWrite = new JsonReadWrite<>(driverStorage, type);
        this.f23198e = jsonReadWrite;
        BooleanReadWrite booleanReadWrite = new BooleanReadWrite(driverStorage);
        this.f23199f = booleanReadWrite;
        this.f23200g = new LongSettingsField("user_id", -1L, driverStorage);
        this.f23201h = new StringSettingsField("name", SettingsConfig$Defaults.f23359b, driverStorage);
        this.f23202i = new BooleanSettingsField("highlight_same_company_drivers", false, driverStorage);
        this.f23203j = new BooleanSettingsField("client_rating_allowed", false, driverStorage);
        this.f23204k = new LongSettingsField("company_id", -1L, driverStorage);
        this.f23205l = new StringSettingsField("country", "", driverStorage);
        this.f23206m = new LongSettingsField("selected_car_id", -1L, driverStorage);
        this.f23207n = new StringSettingsField("selected_car_name", "", driverStorage);
        this.f23208o = new StringSettingsField("referral_code", SettingsConfig$Defaults.f23358a, driverStorage);
        this.f23209p = new ActiveReferralCampaign(driverStorage);
        this.f23210q = new IntSettingsField("defaultWorkRadius", 5000, driverStorage);
        this.f23211r = new StringSettingsField("measurement_system", "metric", driverStorage);
        this.f23212s = new LongSettingsField("route_refresh_interval", -1L, driverStorage);
        this.f23213t = new StringSettingsField("driver_phone_number", "", driverStorage);
        this.f23214u = new BooleanSettingsField("panic_button_enabled", false, driverStorage);
        this.f23215v = new StringSettingsField("emergency_phone_number", "", driverStorage);
        this.f23216w = new BooleanSettingsField("earnings_view_enabled", false, driverStorage);
        this.f23217x = new BooleanSettingsField("is_mock_detection_enabled", true, driverStorage);
        this.f23218y = new IntSettingsField("driver_busy_check_interval", (int) TimeUnit.MINUTES.toSeconds(20L), driverStorage);
        this.f23219z = new StringSettingsField("company_order_url", null, driverStorage);
        this.A = new StringSettingsField("order_shard_id", "", driverStorage);
        this.B = new StringSettingsField("driver_operator_name", "", driverStorage);
        this.C = new BooleanSettingsField("is_waybill_enabled", false, driverStorage);
        this.D = new StringSettingsField("driver_city_name", "", driverStorage);
        this.E = new BooleanSettingsField("driver_destinations_enabled", false, driverStorage);
        this.F = new IntSettingsField("location_tracking_interval", 30, driverStorage);
        this.G = new IntSettingsField("location_tracking_max_size", 1000, driverStorage);
        this.H = new IntSettingsField("location_tracking_min_update_rate", 1, driverStorage);
        this.I = new IntSettingsField("documents_expired_days", -1, driverStorage);
        this.J = new StringSettingsField("driver_root_id", null, driverStorage);
        this.K = new BooleanSettingsField("is_destination_change_enabled", true, driverStorage);
        Boolean bool = Boolean.FALSE;
        this.L = new SimpleField("is_blocked_by_training", bool, booleanReadWrite);
        this.M = new SimpleField("working_time_mode", DriverFeaturesConfig.WorkingTimeMode.DISABLED, enumStateSetReadWrite);
        this.N = AppVersionState.INVALID;
        this.O = new SimpleField("activity_config", null, jsonReadWrite);
        this.P = new SimpleField("is_behaviour_quality_enabled", bool, booleanReadWrite);
        this.Q = new SimpleField("circle_k_loyalty_campaign_status", DriverFeaturesConfig.CircleKLoyaltyCampaignStatus.NOT_AVAILABLE, enumStateSetReadWrite2);
        this.R = new SimpleField("is_scheduled_rides_enabled", bool, booleanReadWrite);
        this.S = new StringSettingsField("driver_analytics_id", null, driverStorage);
        this.T = new SimpleField("is_loyalty_platform_enabled", bool, booleanReadWrite);
        this.U = new SimpleField("is_trip_audio_recording_enabled", bool, booleanReadWrite);
    }

    private final Gson t() {
        return (Gson) this.f23195b.getValue();
    }

    public final BooleanSettingsField A() {
        return this.f23217x;
    }

    public final StringSettingsField B() {
        return this.f23201h;
    }

    public final StringSettingsField C() {
        return this.f23219z;
    }

    public final StringSettingsField D() {
        return this.A;
    }

    public final StringSettingsField E() {
        return this.f23213t;
    }

    public final StringSettingsField F() {
        return this.f23208o;
    }

    public final StringSettingsField G() {
        return this.J;
    }

    public final LongSettingsField H() {
        return this.f23212s;
    }

    public final boolean I() {
        return ((Boolean) this.R.a(this, V[5])).booleanValue();
    }

    public final BooleanSettingsField J() {
        return this.f23214u;
    }

    public final BooleanSettingsField K() {
        return this.C;
    }

    public final IntSettingsField L() {
        return this.f23210q;
    }

    public final List<DriverAppConfig.MaxClientDistance> M() {
        List<DriverAppConfig.MaxClientDistance> k8;
        String string = this.f23194a.getString("list_of_client_distances", null);
        if (string == null) {
            k8 = CollectionsKt__CollectionsKt.k();
            return k8;
        }
        Object fromJson = t().fromJson(string, new TypeToken<List<? extends DriverAppConfig.MaxClientDistance>>() { // from class: ee.mtakso.driver.param.MutableDriverConfig$getWorkingRadiusList$type$1
        }.getType());
        Intrinsics.e(fromJson, "gson.fromJson(distancesJson, type)");
        return (List) fromJson;
    }

    public final DriverFeaturesConfig.WorkingTimeMode N() {
        return (DriverFeaturesConfig.WorkingTimeMode) this.M.a(this, V[1]);
    }

    public final boolean O() {
        return ((Boolean) this.L.a(this, V[0])).booleanValue();
    }

    public final boolean P() {
        return ((Boolean) this.U.a(this, V[7])).booleanValue();
    }

    public final void Q(DriverConfiguration config) {
        int i8;
        Intrinsics.f(config, "config");
        DriverAppConfig a8 = config.a();
        this.f23212s.c(a8.g());
        Z((int) a8.c());
        R(a8.e());
        this.f23211r.b(a8.i());
        this.f23218y.b(a8.d());
        this.N = AppVersionStateMapper.f26098a.a(config.a().b());
        this.f23209p.d(a8.f());
        this.F.b(a8.k().c());
        this.G.b(a8.k().b());
        this.H.b(a8.k().a());
        this.f23219z.b(a8.h().a());
        this.A.b(a8.h().b());
        S(a8.a());
        DriverProfileConfig d8 = config.d();
        this.f23200g.c(d8.i());
        this.f23208o.b(d8.m());
        this.f23213t.b(d8.l());
        this.f23215v.b(d8.h());
        this.f23201h.b(d8.j());
        this.D.b(d8.b());
        this.f23205l.b(d8.d());
        this.B.b(d8.g());
        IntSettingsField intSettingsField = this.I;
        Integer e8 = d8.e();
        if (e8 != null) {
            i8 = e8.intValue();
        } else {
            i8 = -1;
        }
        intSettingsField.b(i8);
        this.f23204k.c(d8.c());
        this.J.b(String.valueOf(d8.k()));
        this.S.b(d8.a());
        this.f23206m.c(config.b().a());
        this.f23207n.b(config.b().b());
        DriverFeaturesConfig c8 = config.c();
        this.f23203j.b(c8.c());
        this.f23214u.b(c8.h());
        this.f23216w.b(c8.e());
        U(c8.l());
        this.f23217x.b(c8.g());
        this.C.b(c8.o());
        this.E.b(c8.m());
        this.K.b(c8.d());
        a0(c8.k());
        T(c8.a());
        V(c8.b());
        X(c8.i());
        W(c8.f());
        Y(c8.n());
    }

    public final void R(List<DriverAppConfig.MaxClientDistance> list) {
        if (list == null) {
            this.f23194a.c("list_of_client_distances", null);
        } else {
            this.f23194a.c("list_of_client_distances", t().toJson(list));
        }
    }

    public final void S(DriverAppConfig.Activity activity) {
        this.O.b(this, V[2], activity);
    }

    public final void T(boolean z7) {
        this.P.b(this, V[3], Boolean.valueOf(z7));
    }

    public final void U(boolean z7) {
        this.L.b(this, V[0], Boolean.valueOf(z7));
    }

    public final void V(DriverFeaturesConfig.CircleKLoyaltyCampaignStatus circleKLoyaltyCampaignStatus) {
        Intrinsics.f(circleKLoyaltyCampaignStatus, "<set-?>");
        this.Q.b(this, V[4], circleKLoyaltyCampaignStatus);
    }

    public final void W(boolean z7) {
        this.T.b(this, V[6], Boolean.valueOf(z7));
    }

    public final void X(boolean z7) {
        this.R.b(this, V[5], Boolean.valueOf(z7));
    }

    public final void Y(boolean z7) {
        this.U.b(this, V[7], Boolean.valueOf(z7));
    }

    public final void Z(int i8) {
        if (i8 < 0) {
            Kalev.d("Radius is null from the backend, falling back to default working radius!");
            this.f23210q.b(5000);
            return;
        }
        this.f23210q.b(i8);
    }

    public final ActiveReferralCampaign a() {
        return this.f23209p;
    }

    public final void a0(DriverFeaturesConfig.WorkingTimeMode workingTimeMode) {
        Intrinsics.f(workingTimeMode, "<set-?>");
        this.M.b(this, V[1], workingTimeMode);
    }

    public final DriverAppConfig.Activity b() {
        return (DriverAppConfig.Activity) this.O.a(this, V[2]);
    }

    public final StringSettingsField c() {
        return this.S;
    }

    public final AppVersionState d() {
        return this.N;
    }

    public final boolean e() {
        return ((Boolean) this.P.a(this, V[3])).booleanValue();
    }

    public final LongSettingsField f() {
        return this.f23206m;
    }

    public final StringSettingsField g() {
        return this.f23207n;
    }

    public final DriverFeaturesConfig.CircleKLoyaltyCampaignStatus h() {
        return (DriverFeaturesConfig.CircleKLoyaltyCampaignStatus) this.Q.a(this, V[4]);
    }

    public final StringSettingsField i() {
        return this.D;
    }

    public final BooleanSettingsField j() {
        return this.f23203j;
    }

    public final LongSettingsField k() {
        return this.f23204k;
    }

    public final StringSettingsField l() {
        return this.f23205l;
    }

    public final BooleanSettingsField m() {
        return this.K;
    }

    public final IntSettingsField n() {
        return this.I;
    }

    public final IntSettingsField o() {
        return this.f23218y;
    }

    public final BooleanSettingsField p() {
        return this.E;
    }

    public final StringSettingsField q() {
        return this.B;
    }

    public final BooleanSettingsField r() {
        return this.f23216w;
    }

    public final StringSettingsField s() {
        return this.f23215v;
    }

    public final LongSettingsField u() {
        return this.f23200g;
    }

    public final IntSettingsField v() {
        return this.F;
    }

    public final IntSettingsField w() {
        return this.G;
    }

    public final IntSettingsField x() {
        return this.H;
    }

    public final boolean y() {
        return ((Boolean) this.T.a(this, V[6])).booleanValue();
    }

    public final StringSettingsField z() {
        return this.f23211r;
    }
}
