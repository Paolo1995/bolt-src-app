package ee.mtakso.driver.features;

import ee.mtakso.driver.features.FeatureStore;
import ee.mtakso.driver.network.client.targeting.TargetingParameters;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Feature.kt */
/* loaded from: classes3.dex */
public final class Feature {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f20881c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Type f20882a;

    /* renamed from: b  reason: collision with root package name */
    private final FeatureStore f20883b;

    /* compiled from: Feature.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<Feature> a(FeatureStore store) {
            Intrinsics.f(store, "store");
            Type[] values = Type.values();
            ArrayList arrayList = new ArrayList(values.length);
            for (Type type : values) {
                arrayList.add(new Feature(type, store));
            }
            return arrayList;
        }
    }

    public Feature(Type type, FeatureStore store) {
        Intrinsics.f(type, "type");
        Intrinsics.f(store, "store");
        this.f20882a = type;
        this.f20883b = store;
    }

    private final Boolean c(TargetingParameters targetingParameters, String str, boolean z7) {
        Boolean bool;
        Object obj = targetingParameters.a().get(str);
        if (obj instanceof Boolean) {
            bool = (Boolean) obj;
        } else {
            bool = null;
        }
        if (bool == null) {
            return Boolean.valueOf(z7);
        }
        return bool;
    }

    private final String d() {
        String e8 = this.f20882a.e();
        return "force_info_" + e8;
    }

    public final void a() {
        this.f20883b.a(this.f20882a.e(), FeatureStore.Result.DISABLED);
    }

    public final void b() {
        this.f20883b.a(this.f20882a.e(), FeatureStore.Result.ENABLED);
    }

    public final Type e() {
        return this.f20882a;
    }

    public final boolean f() {
        if (g()) {
            if (this.f20883b.b(d()) == FeatureStore.Result.ENABLED) {
                return true;
            }
            return false;
        } else if (this.f20883b.b(this.f20882a.e()) == FeatureStore.Result.ENABLED) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean g() {
        if (this.f20883b.b(d()) != FeatureStore.Result.NOT_SET) {
            return true;
        }
        return false;
    }

    public final boolean h() {
        if (this.f20883b.b(this.f20882a.e()) == FeatureStore.Result.NOT_SET) {
            return true;
        }
        return false;
    }

    public final void i() {
        this.f20883b.a(this.f20882a.e(), FeatureStore.Result.NOT_SET);
    }

    public final void j(TargetingParameters targetingParams) {
        boolean booleanValue;
        Intrinsics.f(targetingParams, "targetingParams");
        Boolean c8 = c(targetingParams, this.f20882a.f(), this.f20882a.c());
        if (c8 != null) {
            if (!this.f20882a.h()) {
                if (!c8.booleanValue()) {
                    booleanValue = true;
                } else {
                    booleanValue = false;
                }
            } else {
                booleanValue = c8.booleanValue();
            }
            if (booleanValue) {
                b();
                return;
            } else {
                a();
                return;
            }
        }
        i();
    }

    /* compiled from: Feature.kt */
    /* loaded from: classes3.dex */
    public enum Type {
        YANDEX_MAPS_IN_BROWSER("is_yandex_navigator_through_browser_enabled", "is_yandex_navigator_through_browser_disabled", null, false, false, 20, null),
        MAPS_ME("is_maps_me_enabled", "is_maps_me_enabled", null, false, false, 28, null),
        CALCULATE_CURRENT_PRICE("calculate_current_price_enabled", "calculate_current_price_enabled", null, false, false, 28, null),
        PAID_STOPS("paid_long_stops_enabled", "paid_long_stops_enabled", null, false, false, 28, null),
        LOCATION_MONITORING("is_location_monitoring_enabled", "is_location_monitoring_enabled", null, false, false, 28, null),
        DYNAMIC_STOP_POLLER("dynamic_paid_long_stops_enabled", "dynamic_paid_long_stops_enabled", null, false, false, 28, null),
        BETA_USER("beta_user_android", "beta_user_android", "beta_user_android", false, false, 24, null),
        INMEMORY_LOCATION_STORAGE("inmemory_location_storage", "inmemory_location_storage", null, false, false, 28, null),
        LIVE_UPDATE_TARGETING("is_live_targeting_update_enabled", "is_live_targeting_update_enabled", null, false, false, 28, null),
        MODAL_DIALOGS("is_dynamic_modal_dialogs_enabled", null, null, false, false, 30, null),
        RATE_APP_V2("is_new_rateme_enabled", null, null, false, false, 30, null),
        LOCATION_SINGLE_THREAD_UPLOAD("is_location_single_thread_upload_enabled", null, null, false, false, 30, null),
        CUSTOMER_SUPPORT_WEBVIEW_ORIENTATION_LOCKED("is_customer_support_webview_orientation_locked", "is_customer_support_webview_orientation_locked", null, false, false, 28, null);
        

        /* renamed from: f  reason: collision with root package name */
        private final String f20898f;

        /* renamed from: g  reason: collision with root package name */
        private final String f20899g;

        /* renamed from: h  reason: collision with root package name */
        private final String f20900h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f20901i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f20902j;

        Type(String str, String str2, String str3, boolean z7, boolean z8) {
            this.f20898f = str;
            this.f20899g = str2;
            this.f20900h = str3;
            this.f20901i = z7;
            this.f20902j = z8;
        }

        public final boolean c() {
            return this.f20902j;
        }

        public final String e() {
            return this.f20898f;
        }

        public final String f() {
            return this.f20899g;
        }

        public final boolean h() {
            return this.f20901i;
        }

        /* synthetic */ Type(String str, String str2, String str3, boolean z7, boolean z8, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i8 & 2) != 0 ? str : str2, (i8 & 4) != 0 ? null : str3, (i8 & 8) != 0 ? true : z7, (i8 & 16) != 0 ? false : z8);
        }
    }
}
