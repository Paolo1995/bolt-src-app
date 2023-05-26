package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzha;
import com.google.android.gms.measurement.internal.zzhb;
import com.google.android.gms.measurement.internal.zzhd;
import com.google.android.gms.measurement.internal.zzip;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.1.0 */
/* loaded from: classes.dex */
public final class zzc {

    /* renamed from: a  reason: collision with root package name */
    private static final Set f15438a = new HashSet(Arrays.asList("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"));

    /* renamed from: b  reason: collision with root package name */
    private static final List f15439b = Arrays.asList("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");

    /* renamed from: c  reason: collision with root package name */
    private static final List f15440c = Arrays.asList("auto", "app", "am");

    /* renamed from: d  reason: collision with root package name */
    private static final List f15441d = Arrays.asList("_r", "_dbg");

    /* renamed from: e  reason: collision with root package name */
    private static final List f15442e = Arrays.asList((String[]) ArrayUtils.concat(zzhd.zza, zzhd.zzb));

    /* renamed from: f  reason: collision with root package name */
    private static final List f15443f = Arrays.asList("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");

    public static Bundle a(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        Bundle bundle = new Bundle();
        String str = conditionalUserProperty.f15417a;
        if (str != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.ORIGIN, str);
        }
        String str2 = conditionalUserProperty.f15418b;
        if (str2 != null) {
            bundle.putString("name", str2);
        }
        Object obj = conditionalUserProperty.f15419c;
        if (obj != null) {
            zzha.zzb(bundle, obj);
        }
        String str3 = conditionalUserProperty.f15420d;
        if (str3 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str3);
        }
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, conditionalUserProperty.f15421e);
        String str4 = conditionalUserProperty.f15422f;
        if (str4 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, str4);
        }
        Bundle bundle2 = conditionalUserProperty.f15423g;
        if (bundle2 != null) {
            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, bundle2);
        }
        String str5 = conditionalUserProperty.f15424h;
        if (str5 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, str5);
        }
        Bundle bundle3 = conditionalUserProperty.f15425i;
        if (bundle3 != null) {
            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, bundle3);
        }
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, conditionalUserProperty.f15426j);
        String str6 = conditionalUserProperty.f15427k;
        if (str6 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str6);
        }
        Bundle bundle4 = conditionalUserProperty.f15428l;
        if (bundle4 != null) {
            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle4);
        }
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, conditionalUserProperty.f15429m);
        bundle.putBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, conditionalUserProperty.f15430n);
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, conditionalUserProperty.f15431o);
        return bundle;
    }

    public static AnalyticsConnector.ConditionalUserProperty b(Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
        conditionalUserProperty.f15417a = (String) Preconditions.checkNotNull((String) zzha.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.ORIGIN, String.class, null));
        conditionalUserProperty.f15418b = (String) Preconditions.checkNotNull((String) zzha.zza(bundle, "name", String.class, null));
        conditionalUserProperty.f15419c = zzha.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.VALUE, Object.class, null);
        conditionalUserProperty.f15420d = (String) zzha.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        conditionalUserProperty.f15421e = ((Long) zzha.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L)).longValue();
        conditionalUserProperty.f15422f = (String) zzha.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        conditionalUserProperty.f15423g = (Bundle) zzha.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        conditionalUserProperty.f15424h = (String) zzha.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        conditionalUserProperty.f15425i = (Bundle) zzha.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        conditionalUserProperty.f15426j = ((Long) zzha.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L)).longValue();
        conditionalUserProperty.f15427k = (String) zzha.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        conditionalUserProperty.f15428l = (Bundle) zzha.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        conditionalUserProperty.f15430n = ((Boolean) zzha.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.class, Boolean.FALSE)).booleanValue();
        conditionalUserProperty.f15429m = ((Long) zzha.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.class, 0L)).longValue();
        conditionalUserProperty.f15431o = ((Long) zzha.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.class, 0L)).longValue();
        return conditionalUserProperty;
    }

    public static String c(String str) {
        String zza = zzhb.zza(str);
        if (zza != null) {
            return zza;
        }
        return str;
    }

    public static void d(String str, String str2, Bundle bundle) {
        if ("clx".equals(str) && "_ae".equals(str2)) {
            bundle.putLong("_r", 1L);
        }
    }

    public static boolean e(String str, String str2, Bundle bundle) {
        char c8;
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!i(str) || bundle == null) {
            return false;
        }
        for (String str3 : f15441d) {
            if (bundle.containsKey(str3)) {
                return false;
            }
        }
        int hashCode = str.hashCode();
        if (hashCode != 101200) {
            if (hashCode != 101230) {
                if (hashCode == 3142703 && str.equals(AppMeasurement.FIAM_ORIGIN)) {
                    c8 = 2;
                }
                c8 = 65535;
            } else {
                if (str.equals("fdl")) {
                    c8 = 1;
                }
                c8 = 65535;
            }
        } else {
            if (str.equals(AppMeasurement.FCM_ORIGIN)) {
                c8 = 0;
            }
            c8 = 65535;
        }
        if (c8 != 0) {
            if (c8 != 1) {
                if (c8 != 2) {
                    return false;
                }
                bundle.putString("_cis", "fiam_integration");
                return true;
            }
            bundle.putString("_cis", "fdl_integration");
            return true;
        }
        bundle.putString("_cis", "fcm_integration");
        return true;
    }

    public static boolean f(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        String str;
        if (conditionalUserProperty == null || (str = conditionalUserProperty.f15417a) == null || str.isEmpty()) {
            return false;
        }
        Object obj = conditionalUserProperty.f15419c;
        if ((obj != null && zzip.zza(obj) == null) || !i(str) || !j(str, conditionalUserProperty.f15418b)) {
            return false;
        }
        String str2 = conditionalUserProperty.f15427k;
        if (str2 != null && (!g(str2, conditionalUserProperty.f15428l) || !e(str, conditionalUserProperty.f15427k, conditionalUserProperty.f15428l))) {
            return false;
        }
        String str3 = conditionalUserProperty.f15424h;
        if (str3 != null && (!g(str3, conditionalUserProperty.f15425i) || !e(str, conditionalUserProperty.f15424h, conditionalUserProperty.f15425i))) {
            return false;
        }
        String str4 = conditionalUserProperty.f15422f;
        if (str4 != null) {
            if (!g(str4, conditionalUserProperty.f15423g) || !e(str, conditionalUserProperty.f15422f, conditionalUserProperty.f15423g)) {
                return false;
            }
            return true;
        }
        return true;
    }

    public static boolean g(String str, Bundle bundle) {
        if (f15439b.contains(str)) {
            return false;
        }
        if (bundle != null) {
            for (String str2 : f15441d) {
                if (bundle.containsKey(str2)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static boolean h(String str) {
        if (!f15438a.contains(str)) {
            return true;
        }
        return false;
    }

    public static boolean i(String str) {
        if (!f15440c.contains(str)) {
            return true;
        }
        return false;
    }

    public static boolean j(String str, String str2) {
        if (!"_ce1".equals(str2) && !"_ce2".equals(str2)) {
            if ("_ln".equals(str2)) {
                if (str.equals(AppMeasurement.FCM_ORIGIN) || str.equals(AppMeasurement.FIAM_ORIGIN)) {
                    return true;
                }
                return false;
            } else if (f15442e.contains(str2)) {
                return false;
            } else {
                for (String str3 : f15443f) {
                    if (str2.matches(str3)) {
                        return false;
                    }
                }
                return true;
            }
        } else if (str.equals(AppMeasurement.FCM_ORIGIN) || str.equals("frc")) {
            return true;
        } else {
            return false;
        }
    }
}
