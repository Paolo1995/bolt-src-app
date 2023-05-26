package com.clevertap.android.sdk.product_config;

import android.text.TextUtils;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.OnSuccessListener;
import com.clevertap.android.sdk.utils.FileUtils;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ProductConfigSettings {

    /* renamed from: a  reason: collision with root package name */
    private final CleverTapInstanceConfig f11670a;

    /* renamed from: b  reason: collision with root package name */
    private String f11671b;

    /* renamed from: c  reason: collision with root package name */
    private final FileUtils f11672c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, String> f11673d = DesugarCollections.synchronizedMap(new HashMap());

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProductConfigSettings(String str, CleverTapInstanceConfig cleverTapInstanceConfig, FileUtils fileUtils) {
        this.f11671b = str;
        this.f11670a = cleverTapInstanceConfig;
        this.f11672c = fileUtils;
        l();
    }

    private synchronized int j() {
        int i8;
        i8 = 5;
        String str = this.f11673d.get("rc_n");
        try {
            if (!TextUtils.isEmpty(str)) {
                i8 = (int) Double.parseDouble(str);
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            Logger n8 = this.f11670a.n();
            String a8 = ProductConfigUtil.a(this.f11670a);
            n8.s(a8, "GetNoOfCallsInAllowedWindow failed: " + e8.getLocalizedMessage());
        }
        return i8;
    }

    private synchronized int k() {
        int i8;
        i8 = 60;
        String str = this.f11673d.get("rc_w");
        try {
            if (!TextUtils.isEmpty(str)) {
                i8 = (int) Double.parseDouble(str);
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            Logger n8 = this.f11670a.n();
            String a8 = ProductConfigUtil.a(this.f11670a);
            n8.s(a8, "GetWindowIntervalInMinutes failed: " + e8.getLocalizedMessage());
        }
        return i8;
    }

    private synchronized void s(int i8) {
        long j8 = j();
        if (i8 > 0 && j8 != i8) {
            this.f11673d.put("rc_n", String.valueOf(i8));
            v();
        }
    }

    private void t(String str, int i8) {
        str.hashCode();
        if (!str.equals("rc_n")) {
            if (str.equals("rc_w")) {
                u(i8);
                return;
            }
            return;
        }
        s(i8);
    }

    private synchronized void u(int i8) {
        int k8 = k();
        if (i8 > 0 && k8 != i8) {
            this.f11673d.put("rc_w", String.valueOf(i8));
            v();
        }
    }

    private synchronized void v() {
        CTExecutorFactory.a(this.f11670a).a().b(new OnSuccessListener<Boolean>() { // from class: com.clevertap.android.sdk.product_config.ProductConfigSettings.3
            @Override // com.clevertap.android.sdk.task.OnSuccessListener
            /* renamed from: a */
            public void onSuccess(Boolean bool) {
                if (bool.booleanValue()) {
                    Logger n8 = ProductConfigSettings.this.f11670a.n();
                    String a8 = ProductConfigUtil.a(ProductConfigSettings.this.f11670a);
                    n8.s(a8, "Product Config settings: writing Success " + ProductConfigSettings.this.f11673d);
                    return;
                }
                ProductConfigSettings.this.f11670a.n().s(ProductConfigUtil.a(ProductConfigSettings.this.f11670a), "Product Config settings: writing Failed");
            }
        }).d("ProductConfigSettings#updateConfigToFile", new Callable<Boolean>() { // from class: com.clevertap.android.sdk.product_config.ProductConfigSettings.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                try {
                    HashMap hashMap = new HashMap(ProductConfigSettings.this.f11673d);
                    hashMap.remove("fetch_min_interval_seconds");
                    ProductConfigSettings.this.f11672c.c(ProductConfigSettings.this.e(), "config_settings.json", new JSONObject(hashMap));
                    return Boolean.TRUE;
                } catch (Exception e8) {
                    e8.printStackTrace();
                    Logger n8 = ProductConfigSettings.this.f11670a.n();
                    String a8 = ProductConfigUtil.a(ProductConfigSettings.this.f11670a);
                    n8.s(a8, "UpdateConfigToFile failed: " + e8.getLocalizedMessage());
                    return Boolean.FALSE;
                }
            }
        });
    }

    void d(final FileUtils fileUtils) {
        if (fileUtils != null) {
            CTExecutorFactory.a(this.f11670a).a().d("ProductConfigSettings#eraseStoredSettingsFile", new Callable<Void>() { // from class: com.clevertap.android.sdk.product_config.ProductConfigSettings.1
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Void call() {
                    synchronized (this) {
                        try {
                            String f8 = ProductConfigSettings.this.f();
                            fileUtils.a(f8);
                            Logger n8 = ProductConfigSettings.this.f11670a.n();
                            String a8 = ProductConfigUtil.a(ProductConfigSettings.this.f11670a);
                            n8.s(a8, "Deleted settings file" + f8);
                        } catch (Exception e8) {
                            e8.printStackTrace();
                            Logger n9 = ProductConfigSettings.this.f11670a.n();
                            String a9 = ProductConfigUtil.a(ProductConfigSettings.this.f11670a);
                            n9.s(a9, "Error while resetting settings" + e8.getLocalizedMessage());
                        }
                    }
                    return null;
                }
            });
            return;
        }
        throw new IllegalArgumentException("FileUtils can't be null");
    }

    String e() {
        return "Product_Config_" + this.f11670a.c() + "_" + this.f11671b;
    }

    String f() {
        return e() + "/config_settings.json";
    }

    public String g() {
        return this.f11671b;
    }

    JSONObject h(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str);
            } catch (JSONException e8) {
                e8.printStackTrace();
                Logger n8 = this.f11670a.n();
                String a8 = ProductConfigUtil.a(this.f11670a);
                n8.s(a8, "LoadSettings failed: " + e8.getLocalizedMessage());
                return null;
            }
        }
        return null;
    }

    synchronized long i() {
        long j8;
        j8 = 0;
        String str = this.f11673d.get("ts");
        try {
            if (!TextUtils.isEmpty(str)) {
                j8 = (long) Double.parseDouble(str);
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            Logger n8 = this.f11670a.n();
            String a8 = ProductConfigUtil.a(this.f11670a);
            n8.s(a8, "GetLastFetchTimeStampInMillis failed: " + e8.getLocalizedMessage());
        }
        return j8;
    }

    void l() {
        this.f11673d.put("rc_n", String.valueOf(5));
        this.f11673d.put("rc_w", String.valueOf(60));
        this.f11673d.put("ts", String.valueOf(0));
        this.f11673d.put("fetch_min_interval_seconds", String.valueOf(CTProductConfigConstants.f11644a));
        Logger n8 = this.f11670a.n();
        String a8 = ProductConfigUtil.a(this.f11670a);
        n8.s(a8, "Settings loaded with default values: " + this.f11673d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void m(FileUtils fileUtils) {
        if (fileUtils != null) {
            try {
                n(h(fileUtils.b(f())));
            } catch (Exception e8) {
                e8.printStackTrace();
                Logger n8 = this.f11670a.n();
                String a8 = ProductConfigUtil.a(this.f11670a);
                n8.s(a8, "LoadSettings failed while reading file: " + e8.getLocalizedMessage());
            }
        } else {
            throw new IllegalArgumentException("fileutils can't be null");
        }
    }

    synchronized void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                try {
                    String valueOf = String.valueOf(jSONObject.get(next));
                    if (!TextUtils.isEmpty(valueOf)) {
                        this.f11673d.put(next, valueOf);
                    }
                } catch (Exception e8) {
                    e8.printStackTrace();
                    Logger n8 = this.f11670a.n();
                    String a8 = ProductConfigUtil.a(this.f11670a);
                    n8.s(a8, "Failed loading setting for key " + next + " Error: " + e8.getLocalizedMessage());
                }
            }
        }
        Logger n9 = this.f11670a.n();
        String a9 = ProductConfigUtil.a(this.f11670a);
        n9.s(a9, "LoadSettings completed with settings: " + this.f11673d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(FileUtils fileUtils) {
        l();
        d(fileUtils);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(JSONObject jSONObject) {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    if (!TextUtils.isEmpty(next)) {
                        Object obj = jSONObject.get(next);
                        if (obj instanceof Number) {
                            int doubleValue = (int) ((Number) obj).doubleValue();
                            if ("rc_n".equalsIgnoreCase(next) || "rc_w".equalsIgnoreCase(next)) {
                                t(next, doubleValue);
                            }
                        }
                    }
                } catch (Exception e8) {
                    e8.printStackTrace();
                    Logger n8 = this.f11670a.n();
                    String a8 = ProductConfigUtil.a(this.f11670a);
                    n8.s(a8, "Product Config setARPValue failed " + e8.getLocalizedMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(String str) {
        this.f11671b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void r(long j8) {
        long i8 = i();
        if (j8 >= 0 && i8 != j8) {
            this.f11673d.put("ts", String.valueOf(j8));
            v();
        }
    }
}
