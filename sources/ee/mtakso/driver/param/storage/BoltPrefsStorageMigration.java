package ee.mtakso.driver.param.storage;

import android.content.Context;
import androidx.work.WorkManager;
import eu.bolt.driver.core.storage.BoltPrefsStorage;
import eu.bolt.driver.core.storage.BoltSharedPrefs;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BoltPrefsStorageMigration.kt */
/* loaded from: classes3.dex */
public final class BoltPrefsStorageMigration {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f23268c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f23269a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Object> f23270b;

    /* compiled from: BoltPrefsStorageMigration.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public BoltPrefsStorageMigration(Context context) {
        Intrinsics.f(context, "context");
        this.f23269a = context;
        this.f23270b = new HashMap<>();
    }

    private final void a(BoltPrefsStorage boltPrefsStorage) {
        Integer num;
        String str;
        String str2;
        Integer num2;
        Boolean bool;
        String str3;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        Boolean bool5;
        Set<String> set;
        Boolean bool6;
        Boolean bool7;
        Boolean bool8;
        String str4;
        Integer num3;
        String str5;
        Boolean bool9;
        Boolean bool10;
        Integer num4;
        Integer num5;
        Long l8;
        Integer num6;
        if (!this.f23270b.isEmpty()) {
            Object obj = this.f23270b.get("user_id");
            Boolean bool11 = null;
            if (obj instanceof Integer) {
                num = (Integer) obj;
            } else {
                num = null;
            }
            boltPrefsStorage.b("user_id", num);
            Object obj2 = this.f23270b.get("username");
            if (obj2 instanceof String) {
                str = (String) obj2;
            } else {
                str = null;
            }
            boltPrefsStorage.c("username", str);
            Object obj3 = this.f23270b.get("language");
            if (obj3 instanceof String) {
                str2 = (String) obj3;
            } else {
                str2 = null;
            }
            boltPrefsStorage.c("language", str2);
            Object obj4 = this.f23270b.get("customWorkRadius");
            if (obj4 instanceof Integer) {
                num2 = (Integer) obj4;
            } else {
                num2 = null;
            }
            boltPrefsStorage.b("customWorkRadius", num2);
            Object obj5 = this.f23270b.get("bolt_head");
            if (obj5 instanceof Boolean) {
                bool = (Boolean) obj5;
            } else {
                bool = null;
            }
            boltPrefsStorage.h("bolt_head", bool);
            Object obj6 = this.f23270b.get("sos_sent_event");
            if (obj6 instanceof String) {
                str3 = (String) obj6;
            } else {
                str3 = null;
            }
            boltPrefsStorage.c("sos_sent_event", str3);
            Object obj7 = this.f23270b.get("earnings_hint_disabled");
            if (obj7 instanceof Boolean) {
                bool2 = (Boolean) obj7;
            } else {
                bool2 = null;
            }
            boltPrefsStorage.h("earnings_hint_disabled", bool2);
            if (!Intrinsics.a(this.f23270b.get("user_tried_to_install_new_navigation_system"), -1)) {
                Object obj8 = this.f23270b.get("user_tried_to_install_new_navigation_system");
                if (obj8 instanceof Integer) {
                    num6 = (Integer) obj8;
                } else {
                    num6 = null;
                }
                boltPrefsStorage.b("user_tried_to_install_new_navigation_system", num6);
            }
            Object obj9 = this.f23270b.get("driver_destination_used");
            if (obj9 instanceof Boolean) {
                bool3 = (Boolean) obj9;
            } else {
                bool3 = null;
            }
            boltPrefsStorage.h("driver_destination_used", bool3);
            Object obj10 = this.f23270b.get("driver_destinations_screen_visited");
            if (obj10 instanceof Boolean) {
                bool4 = (Boolean) obj10;
            } else {
                bool4 = null;
            }
            boltPrefsStorage.h("driver_destinations_screen_visited", bool4);
            Object obj11 = this.f23270b.get("gps_missing_event_sent");
            if (obj11 instanceof Boolean) {
                bool5 = (Boolean) obj11;
            } else {
                bool5 = null;
            }
            boltPrefsStorage.h("gps_missing_event_sent", bool5);
            if (!Intrinsics.a(this.f23270b.get("busy_expires_at"), -1)) {
                Object obj12 = this.f23270b.get("busy_expires_at");
                if (obj12 instanceof Long) {
                    l8 = (Long) obj12;
                } else {
                    l8 = null;
                }
                boltPrefsStorage.g("busy_expires_at", l8);
            }
            Object obj13 = this.f23270b.get("leanplum_notified_messages_ids");
            if (obj13 instanceof Set) {
                set = (Set) obj13;
            } else {
                set = null;
            }
            boltPrefsStorage.d("leanplum_notified_messages_ids", set);
            Object obj14 = this.f23270b.get("is_map_dark_mode_enabled");
            if (obj14 instanceof Boolean) {
                bool6 = (Boolean) obj14;
            } else {
                bool6 = null;
            }
            boltPrefsStorage.h("is_map_dark_mode_enabled", bool6);
            Object obj15 = this.f23270b.get("should_auto_select_auto_navigation");
            if (obj15 instanceof Boolean) {
                bool7 = (Boolean) obj15;
            } else {
                bool7 = null;
            }
            boltPrefsStorage.h("should_auto_select_auto_navigation", bool7);
            Object obj16 = this.f23270b.get("is_permission_onboarding_completed");
            if (obj16 instanceof Boolean) {
                bool8 = (Boolean) obj16;
            } else {
                bool8 = null;
            }
            boltPrefsStorage.h("is_permission_onboarding_completed", bool8);
            Object obj17 = this.f23270b.get("balance_view_report_mode_key");
            if (obj17 instanceof String) {
                str4 = (String) obj17;
            } else {
                str4 = null;
            }
            boltPrefsStorage.c("balance_view_report_mode_key", str4);
            Object obj18 = this.f23270b.get("category_selection_promotion");
            if (obj18 instanceof Integer) {
                num3 = (Integer) obj18;
            } else {
                num3 = null;
            }
            boltPrefsStorage.b("category_selection_promotion", num3);
            Object obj19 = this.f23270b.get("category_region_id");
            if (obj19 instanceof String) {
                str5 = (String) obj19;
            } else {
                str5 = null;
            }
            boltPrefsStorage.c("category_region_id", str5);
            Object obj20 = this.f23270b.get("is_auto_navigation_enabled");
            if (obj20 instanceof Boolean) {
                bool9 = (Boolean) obj20;
            } else {
                bool9 = null;
            }
            boltPrefsStorage.h("is_auto_navigation_enabled", bool9);
            if (!Intrinsics.a(this.f23270b.get("last_navigator"), -1)) {
                Object obj21 = this.f23270b.get("last_navigator");
                if (obj21 instanceof Integer) {
                    num5 = (Integer) obj21;
                } else {
                    num5 = null;
                }
                boltPrefsStorage.b("last_navigator", num5);
            }
            if (!Intrinsics.a(this.f23270b.get("external_navigator"), -1)) {
                Object obj22 = this.f23270b.get("external_navigator");
                if (obj22 instanceof Integer) {
                    num4 = (Integer) obj22;
                } else {
                    num4 = null;
                }
                boltPrefsStorage.b("external_navigator", num4);
            }
            Object obj23 = this.f23270b.get("select_external_navigator_prompt");
            if (obj23 instanceof Boolean) {
                bool10 = (Boolean) obj23;
            } else {
                bool10 = null;
            }
            boltPrefsStorage.h("select_external_navigator_prompt", bool10);
            Object obj24 = this.f23270b.get("is_auto_navigation_prompt_showed");
            if (obj24 instanceof Boolean) {
                bool11 = (Boolean) obj24;
            }
            boltPrefsStorage.h("is_auto_navigation_prompt_showed", bool11);
            this.f23270b.clear();
        }
    }

    private final void b(BoltPrefsStorage boltPrefsStorage) {
        boltPrefsStorage.e("leanplum_notified_messages_ids");
    }

    private final void c(BoltPrefsStorage boltPrefsStorage) {
        Set<String> b8;
        long j8 = boltPrefsStorage.getLong("user_id", -1L);
        if (j8 != -1) {
            Context context = this.f23269a;
            BoltSharedPrefs boltSharedPrefs = new BoltSharedPrefs(context, "eu.bolt-" + j8, 0, null);
            boolean z7 = boltPrefsStorage.getBoolean("session_expired", false);
            String string = boltPrefsStorage.getString("driver_refresh_token", null);
            String string2 = boltPrefsStorage.getString("username", null);
            String string3 = boltPrefsStorage.getString("language", "");
            int a8 = boltPrefsStorage.a("customWorkRadius", 5000);
            boolean z8 = boltPrefsStorage.getBoolean("bolt_head", true);
            String string4 = boltPrefsStorage.getString("sos_sent_event", "");
            boolean z9 = boltPrefsStorage.getBoolean("earnings_hint_disabled", false);
            int a9 = boltPrefsStorage.a("user_tried_to_install_new_navigation_system", -1);
            boolean z10 = boltPrefsStorage.getBoolean("driver_destination_used", false);
            boolean z11 = boltPrefsStorage.getBoolean("driver_destinations_screen_visited", false);
            boolean z12 = boltPrefsStorage.getBoolean("gps_missing_event_sent", false);
            long j9 = boltPrefsStorage.getLong("busy_expires_at", -1L);
            b8 = SetsKt__SetsKt.b();
            Set<String> stringSet = boltPrefsStorage.getStringSet("leanplum_notified_messages_ids", b8);
            boolean z13 = boltPrefsStorage.getBoolean("is_map_dark_mode_enabled", false);
            boolean z14 = boltPrefsStorage.getBoolean("should_auto_select_auto_navigation", false);
            boolean z15 = boltPrefsStorage.getBoolean("is_permission_onboarding_completed", false);
            String string5 = boltPrefsStorage.getString("balance_view_report_mode_key", null);
            int a10 = boltPrefsStorage.a("category_selection_promotion", 0);
            String string6 = boltPrefsStorage.getString("category_region_id", null);
            boolean z16 = boltSharedPrefs.getBoolean("is_auto_navigation_enabled", false);
            int a11 = boltSharedPrefs.a("last_navigator", -1);
            int a12 = boltSharedPrefs.a("external_navigator", -1);
            boolean z17 = boltSharedPrefs.getBoolean("select_external_navigator_prompt", false);
            boolean z18 = boltSharedPrefs.getBoolean("is_auto_navigation_prompt_showed", false);
            boltPrefsStorage.f();
            boltSharedPrefs.f();
            boltPrefsStorage.h("session_expired", Boolean.valueOf(z7));
            boltPrefsStorage.c("last_logged_in_driver_user_name", string2);
            boltPrefsStorage.c("driver_refresh_token", string);
            this.f23270b.put("user_id", Long.valueOf(j8));
            this.f23270b.put("username", string2);
            this.f23270b.put("language", string3);
            this.f23270b.put("customWorkRadius", Integer.valueOf(a8));
            this.f23270b.put("bolt_head", Boolean.valueOf(z8));
            this.f23270b.put("sos_sent_event", string4);
            this.f23270b.put("earnings_hint_disabled", Boolean.valueOf(z9));
            this.f23270b.put("user_tried_to_install_new_navigation_system", Integer.valueOf(a9));
            this.f23270b.put("driver_destination_used", Boolean.valueOf(z10));
            this.f23270b.put("driver_destinations_screen_visited", Boolean.valueOf(z11));
            this.f23270b.put("gps_missing_event_sent", Boolean.valueOf(z12));
            this.f23270b.put("busy_expires_at", Long.valueOf(j9));
            this.f23270b.put("leanplum_notified_messages_ids", stringSet);
            this.f23270b.put("is_map_dark_mode_enabled", Boolean.valueOf(z13));
            this.f23270b.put("should_auto_select_auto_navigation", Boolean.valueOf(z14));
            this.f23270b.put("is_permission_onboarding_completed", Boolean.valueOf(z15));
            this.f23270b.put("balance_view_report_mode_key", string5);
            this.f23270b.put("category_selection_promotion", Integer.valueOf(a10));
            this.f23270b.put("category_region_id", string6);
            this.f23270b.put("is_auto_navigation_enabled", Boolean.valueOf(z16));
            this.f23270b.put("last_navigator", Integer.valueOf(a11));
            this.f23270b.put("external_navigator", Integer.valueOf(a12));
            this.f23270b.put("select_external_navigator_prompt", Boolean.valueOf(z17));
            this.f23270b.put("is_auto_navigation_prompt_showed", Boolean.valueOf(z18));
        }
    }

    private final void f(BoltPrefsStorage boltPrefsStorage, List<String> list) {
        String[] strArr = (String[]) list.toArray(new String[0]);
        boltPrefsStorage.e((String[]) Arrays.copyOf(strArr, strArr.length));
        for (String str : list) {
            boltPrefsStorage.g(str, Long.valueOf(boltPrefsStorage.a(str, 0)));
        }
    }

    public final void d(int i8, int i9, BoltPrefsStorage storage) {
        List<String> n8;
        Intrinsics.f(storage, "storage");
        if (i8 < 1 && i9 < 2) {
            a(storage);
        }
        if (i9 == 2 && i8 == 1) {
            storage.e("is_working_time_info_view_enabled");
            WorkManager.d(this.f23269a).a("leanplum_scheduled_update");
        }
        if (i8 == 2 && i9 == 3) {
            n8 = CollectionsKt__CollectionsKt.n("referrals_campaign_id", "active_incident_id", "company_id", "selected_car_id");
            f(storage, n8);
        }
    }

    public final void e(int i8, int i9, BoltPrefsStorage storage) {
        List<String> n8;
        Intrinsics.f(storage, "storage");
        if (i8 < 1 && i9 < 2) {
            c(storage);
        }
        if (i8 > 0 && i9 < 3) {
            b(storage);
        }
        if (i9 < 4) {
            n8 = CollectionsKt__CollectionsKt.n("user_id", "last_logged_in_driver_id");
            f(storage, n8);
        }
    }
}
