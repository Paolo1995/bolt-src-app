package ee.mtakso.driver.param;

import ee.mtakso.driver.param.RateMeModel;
import eu.bolt.driver.core.storage.BoltPrefsStorage;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RateMePrefsManager.kt */
/* loaded from: classes3.dex */
public final class RateMePrefsManager {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f23230b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Lazy f23231a;

    /* compiled from: RateMePrefsManager.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public RateMePrefsManager(final DriverProvider prefs) {
        Lazy b8;
        Intrinsics.f(prefs, "prefs");
        b8 = LazyKt__LazyJVMKt.b(new Function0<BoltPrefsStorage>() { // from class: ee.mtakso.driver.param.RateMePrefsManager$prefsStorage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final BoltPrefsStorage invoke() {
                return DriverProvider.this.s();
            }
        });
        this.f23231a = b8;
    }

    private final boolean g() {
        return i().getBoolean("RATE_ME_DISMISSED_IN_LIST", false);
    }

    private final String h(RateMeModel rateMeModel) {
        if (Intrinsics.a(rateMeModel, RateMeModel.Tips.f23229f)) {
            return "RATE_ME_TYPE_TIPS";
        }
        if (Intrinsics.a(rateMeModel, RateMeModel.TenRides.f23228f)) {
            return "RATE_ME_TYPE_TEN_RIDES";
        }
        if (Intrinsics.a(rateMeModel, RateMeModel.HundredRides.f23227f)) {
            return "RATE_ME_TYPE_HUNDRED_RIDES";
        }
        if (Intrinsics.a(rateMeModel, RateMeModel.DriveHome.f23226f)) {
            return "RATE_ME_TYPE_DRIVE_HOME";
        }
        if (Intrinsics.a(rateMeModel, RateMeModel.Campaign.f23225f)) {
            return "RATE_ME_TYPE_CAMPAIGN";
        }
        return null;
    }

    private final BoltPrefsStorage i() {
        return (BoltPrefsStorage) this.f23231a.getValue();
    }

    private final boolean s(RateMeGenericModel rateMeGenericModel) {
        if (l()) {
            return false;
        }
        BoltPrefsStorage i8 = i();
        i8.c("scheduled_rate_type", "RATE_ME_TYPE_GENERIC");
        i8.c("scheduled_rate_title", rateMeGenericModel.d());
        i8.c("scheduled_rate_subtitle", rateMeGenericModel.c());
        i8.c("scheduled_rate_message", rateMeGenericModel.b());
        return true;
    }

    public final void a() {
        i().h("RATE_ME_DISMISSED_IN_LIST", Boolean.TRUE);
    }

    public final void b() {
        i().h("RATE_ME_TYPE_MUTE", Boolean.TRUE);
    }

    public final void c() {
        i().h("RATE_ME_ACTION_TAKEN", Boolean.TRUE);
    }

    public final void d(RateMeModel model) {
        Intrinsics.f(model, "model");
        if (!(model instanceof RateMeGenericModel)) {
            BoltPrefsStorage i8 = i();
            Boolean bool = Boolean.TRUE;
            i8.h("RATE_ME_SHOWN_", bool);
            BoltPrefsStorage i9 = i();
            String h8 = h(model);
            i9.h("RATE_ME_SHOWN_" + h8, bool);
        }
    }

    public final void e() {
        i().h("RATE_ME_TYPE_MUTE", Boolean.FALSE);
    }

    public final void f() {
        BoltPrefsStorage i8 = i();
        i8.c("scheduled_rate_type", "");
        i8.c("scheduled_rate_title", "");
        i8.c("scheduled_rate_subtitle", "");
        i8.c("scheduled_rate_message", "");
    }

    public final RateMeModel j() {
        BoltPrefsStorage i8 = i();
        String string = i8.getString("scheduled_rate_type", null);
        if (string == null) {
            return null;
        }
        switch (string.hashCode()) {
            case -2121367087:
                if (!string.equals("RATE_ME_TYPE_DRIVE_HOME")) {
                    return null;
                }
                return RateMeModel.DriveHome.f23226f;
            case -1671247987:
                if (!string.equals("RATE_ME_TYPE_CAMPAIGN")) {
                    return null;
                }
                return RateMeModel.Campaign.f23225f;
            case -1217090372:
                if (!string.equals("RATE_ME_TYPE_TEN_RIDES")) {
                    return null;
                }
                return RateMeModel.TenRides.f23228f;
            case -604248011:
                if (!string.equals("RATE_ME_TYPE_TIPS")) {
                    return null;
                }
                return RateMeModel.Tips.f23229f;
            case 286096282:
                if (!string.equals("RATE_ME_TYPE_GENERIC")) {
                    return null;
                }
                String str = "";
                String string2 = i8.getString("scheduled_rate_title", "");
                if (string2 != null) {
                    str = string2;
                }
                return new RateMeGenericModel(str, i8.getString("scheduled_rate_subtitle", null), i8.getString("scheduled_rate_message", null), 0, 8, null);
            case 1975284877:
                if (!string.equals("RATE_ME_TYPE_HUNDRED_RIDES")) {
                    return null;
                }
                return RateMeModel.HundredRides.f23227f;
            default:
                return null;
        }
    }

    public final boolean k() {
        if (!l() && q(RateMeModel.TenRides.f23228f) && !g()) {
            return true;
        }
        return false;
    }

    public final boolean l() {
        return i().getBoolean("RATE_ME_ACTION_TAKEN", false);
    }

    public final boolean m() {
        return q(RateMeModel.Campaign.f23225f);
    }

    public final boolean n() {
        return q(RateMeModel.HundredRides.f23227f);
    }

    public final boolean o() {
        return q(RateMeModel.TenRides.f23228f);
    }

    public final boolean p() {
        return i().getBoolean("RATE_ME_TYPE_MUTE", false);
    }

    public final boolean q(RateMeModel model) {
        Intrinsics.f(model, "model");
        if (Intrinsics.a(model, RateMeModel.HundredRides.f23227f)) {
            BoltPrefsStorage i8 = i();
            String h8 = h(model);
            return i8.getBoolean("RATE_ME_SHOWN_" + h8, false);
        } else if (model instanceof RateMeGenericModel) {
            return false;
        } else {
            return i().getBoolean("RATE_ME_SHOWN_", false);
        }
    }

    public final boolean r(RateMeModel model) {
        String str;
        Intrinsics.f(model, "model");
        if (l() || q(model)) {
            return false;
        }
        f();
        if (model instanceof RateMeGenericModel) {
            return s((RateMeGenericModel) model);
        }
        if (Intrinsics.a(model, RateMeModel.Tips.f23229f)) {
            str = "RATE_ME_TYPE_TIPS";
        } else if (Intrinsics.a(model, RateMeModel.TenRides.f23228f)) {
            str = "RATE_ME_TYPE_TEN_RIDES";
        } else if (Intrinsics.a(model, RateMeModel.HundredRides.f23227f)) {
            str = "RATE_ME_TYPE_HUNDRED_RIDES";
        } else if (Intrinsics.a(model, RateMeModel.DriveHome.f23226f)) {
            str = "RATE_ME_TYPE_DRIVE_HOME";
        } else if (Intrinsics.a(model, RateMeModel.Campaign.f23225f)) {
            str = "RATE_ME_TYPE_CAMPAIGN";
        } else {
            str = null;
        }
        if (str != null) {
            i().c("scheduled_rate_type", str);
            return true;
        }
        return true;
    }
}
