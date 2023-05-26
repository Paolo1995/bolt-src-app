package com.clevertap.android.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.clevertap.android.sdk.inapp.CTInAppNotification;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class InAppFCManager {

    /* renamed from: b  reason: collision with root package name */
    private final CleverTapInstanceConfig f11027b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f11028c;

    /* renamed from: d  reason: collision with root package name */
    private String f11029d;

    /* renamed from: a  reason: collision with root package name */
    private final SimpleDateFormat f11026a = new SimpleDateFormat("ddMMyyyy", Locale.US);

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<String> f11030e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<String, Integer> f11031f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private int f11032g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InAppFCManager(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, String str) {
        this.f11027b = cleverTapInstanceConfig;
        this.f11028c = context;
        this.f11029d = str;
        CTExecutorFactory.a(cleverTapInstanceConfig).c().d("initInAppFCManager", new Callable<Void>() { // from class: com.clevertap.android.sdk.InAppFCManager.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                InAppFCManager inAppFCManager = InAppFCManager.this;
                inAppFCManager.s(inAppFCManager.f11029d);
                return null;
            }
        });
    }

    private String h() {
        return this.f11027b.c();
    }

    private Logger i() {
        return this.f11027b.n();
    }

    private int[] j(String str) {
        String string = StorageHelper.h(this.f11028c, m("counts_per_inapp", this.f11029d)).getString(str, null);
        if (string == null) {
            return new int[]{0, 0};
        }
        try {
            String[] split = string.split(",");
            return split.length != 2 ? new int[]{0, 0} : new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])};
        } catch (Throwable unused) {
            return new int[]{0, 0};
        }
    }

    private String k(CTInAppNotification cTInAppNotification) {
        if (cTInAppNotification.o() != null && !cTInAppNotification.o().isEmpty()) {
            try {
                return cTInAppNotification.o();
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private int l(String str, int i8) {
        if (this.f11027b.t()) {
            int c8 = StorageHelper.c(this.f11028c, v(str), -1000);
            if (c8 == -1000) {
                return StorageHelper.c(this.f11028c, str, i8);
            }
            return c8;
        }
        return StorageHelper.c(this.f11028c, v(str), i8);
    }

    private String m(String str, String str2) {
        return str + ":" + str2;
    }

    private String n(String str, String str2) {
        if (this.f11027b.t()) {
            String i8 = StorageHelper.i(this.f11028c, v(str), str2);
            if (i8 == null) {
                return StorageHelper.i(this.f11028c, str, str2);
            }
            return i8;
        }
        return StorageHelper.i(this.f11028c, v(str), str2);
    }

    private boolean o(CTInAppNotification cTInAppNotification) {
        String k8 = k(cTInAppNotification);
        if (k8 == null) {
            return false;
        }
        if (l(m("istc_inapp", this.f11029d), 0) >= l(m("istmcd_inapp", this.f11029d), 1)) {
            return true;
        }
        try {
            int D = cTInAppNotification.D();
            if (D == -1) {
                return false;
            }
            if (j(k8)[0] < D) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    private boolean p(CTInAppNotification cTInAppNotification) {
        String k8 = k(cTInAppNotification);
        if (k8 == null || cTInAppNotification.E() == -1) {
            return false;
        }
        try {
            if (j(k8)[1] < cTInAppNotification.E()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    private boolean q(CTInAppNotification cTInAppNotification) {
        int i8;
        String k8 = k(cTInAppNotification);
        if (k8 == null) {
            return false;
        }
        if (this.f11030e.contains(k8)) {
            return true;
        }
        try {
            if (cTInAppNotification.t() >= 0) {
                i8 = cTInAppNotification.t();
            } else {
                i8 = 1000;
            }
            Integer num = this.f11031f.get(k8);
            if (num != null) {
                if (num.intValue() >= i8) {
                    return true;
                }
            }
            if (this.f11032g < l(m("imc", this.f11029d), 1)) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    private void r(String str) {
        int[] j8 = j(str);
        j8[0] = j8[0] + 1;
        j8[1] = j8[1] + 1;
        SharedPreferences.Editor edit = StorageHelper.h(this.f11028c, m("counts_per_inapp", this.f11029d)).edit();
        edit.putString(str, j8[0] + "," + j8[1]);
        StorageHelper.l(edit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        Logger i8 = i();
        i8.s(this.f11027b.c() + ":async_deviceID", "InAppFCManager init() called");
        try {
            t(str);
            String format = this.f11026a.format(new Date());
            if (!format.equals(n(m("ict_date", str), "20140428"))) {
                StorageHelper.p(this.f11028c, v(m("ict_date", str)), format);
                StorageHelper.n(this.f11028c, v(m("istc_inapp", str)), 0);
                SharedPreferences h8 = StorageHelper.h(this.f11028c, m("counts_per_inapp", str));
                SharedPreferences.Editor edit = h8.edit();
                Map<String, ?> all = h8.getAll();
                for (String str2 : all.keySet()) {
                    Object obj = all.get(str2);
                    if (!(obj instanceof String)) {
                        edit.remove(str2);
                    } else {
                        String[] split = ((String) obj).split(",");
                        if (split.length != 2) {
                            edit.remove(str2);
                        } else {
                            edit.putString(str2, "0," + split[1]);
                        }
                    }
                }
                StorageHelper.l(edit);
            }
        } catch (Exception e8) {
            Logger i9 = i();
            String h9 = h();
            i9.s(h9, "Failed to init inapp manager " + e8.getLocalizedMessage());
        }
    }

    private void t(String str) {
        if (n(v(m("ict_date", str)), null) == null && n("ict_date", null) != null) {
            Logger.n("Migrating InAppFC Prefs");
            StorageHelper.p(this.f11028c, v(m("ict_date", str)), n("ict_date", "20140428"));
            StorageHelper.n(this.f11028c, v(m("istc_inapp", str)), l(v("istc_inapp"), 0));
            SharedPreferences h8 = StorageHelper.h(this.f11028c, "counts_per_inapp");
            SharedPreferences.Editor edit = h8.edit();
            SharedPreferences.Editor edit2 = StorageHelper.h(this.f11028c, m("counts_per_inapp", str)).edit();
            Map<String, ?> all = h8.getAll();
            for (String str2 : all.keySet()) {
                Object obj = all.get(str2);
                if (!(obj instanceof String)) {
                    edit.remove(str2);
                } else if (((String) obj).split(",").length != 2) {
                    edit.remove(str2);
                } else {
                    edit2.putString(str2, obj.toString());
                }
            }
            StorageHelper.l(edit2);
            edit.clear().apply();
        }
    }

    private String v(String str) {
        return str + ":" + h();
    }

    public void c(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("imp", l(m("istc_inapp", this.f11029d), 0));
            JSONArray jSONArray = new JSONArray();
            Map<String, ?> all = StorageHelper.h(context, m("counts_per_inapp", this.f11029d)).getAll();
            for (String str : all.keySet()) {
                Object obj = all.get(str);
                if (obj instanceof String) {
                    String[] split = ((String) obj).split(",");
                    if (split.length == 2) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(0, str);
                        jSONArray2.put(1, Integer.parseInt(split[0]));
                        jSONArray2.put(2, Integer.parseInt(split[1]));
                        jSONArray.put(jSONArray2);
                    }
                }
            }
            jSONObject.put("tlc", jSONArray);
        } catch (Throwable th) {
            Logger.q("Failed to attach FC to header", th);
        }
    }

    public boolean d(CTInAppNotification cTInAppNotification) {
        if (cTInAppNotification == null) {
            return false;
        }
        if (k(cTInAppNotification) == null || cTInAppNotification.L()) {
            return true;
        }
        if (!q(cTInAppNotification) && !p(cTInAppNotification)) {
            if (!o(cTInAppNotification)) {
                return true;
            }
        }
        return false;
    }

    public void e(String str) {
        this.f11031f.clear();
        this.f11032g = 0;
        this.f11030e.clear();
        this.f11029d = str;
        s(str);
    }

    public void f(CTInAppNotification cTInAppNotification) {
        String o8 = cTInAppNotification.o();
        if (o8 != null) {
            this.f11030e.add(o8.toString());
        }
    }

    public void g(Context context, CTInAppNotification cTInAppNotification) {
        String k8 = k(cTInAppNotification);
        if (k8 == null) {
            return;
        }
        this.f11032g++;
        Integer num = this.f11031f.get(k8);
        if (num == null) {
            num = 1;
        }
        this.f11031f.put(k8, Integer.valueOf(num.intValue() + 1));
        r(k8);
        StorageHelper.n(context, v(m("istc_inapp", this.f11029d)), l(m("istc_inapp", this.f11029d), 0) + 1);
    }

    public void u(Context context, JSONObject jSONObject) {
        try {
            if (!jSONObject.has("inapp_stale")) {
                return;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("inapp_stale");
            SharedPreferences.Editor edit = StorageHelper.h(context, m("counts_per_inapp", this.f11029d)).edit();
            for (int i8 = 0; i8 < jSONArray.length(); i8++) {
                Object obj = jSONArray.get(i8);
                if (obj instanceof Integer) {
                    edit.remove("" + obj);
                    Logger.a("Purged stale in-app - " + obj);
                } else if (obj instanceof String) {
                    edit.remove((String) obj);
                    Logger.a("Purged stale in-app - " + obj);
                }
            }
            StorageHelper.l(edit);
        } catch (Throwable th) {
            Logger.q("Failed to purge out stale targets", th);
        }
    }

    public synchronized void w(Context context, int i8, int i9) {
        StorageHelper.n(context, v(m("istmcd_inapp", this.f11029d)), i8);
        StorageHelper.n(context, v(m("imc", this.f11029d)), i9);
    }
}
