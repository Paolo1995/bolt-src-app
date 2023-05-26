package com.clevertap.android.sdk.featureFlags;

import android.text.TextUtils;
import com.clevertap.android.sdk.BaseAnalyticsManager;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.OnSuccessListener;
import com.clevertap.android.sdk.task.Task;
import com.clevertap.android.sdk.utils.FileUtils;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CTFeatureFlagsController {

    /* renamed from: a  reason: collision with root package name */
    final CleverTapInstanceConfig f11204a;

    /* renamed from: b  reason: collision with root package name */
    String f11205b;

    /* renamed from: d  reason: collision with root package name */
    final BaseAnalyticsManager f11207d;

    /* renamed from: e  reason: collision with root package name */
    final BaseCallbackManager f11208e;

    /* renamed from: f  reason: collision with root package name */
    FileUtils f11209f;

    /* renamed from: c  reason: collision with root package name */
    boolean f11206c = false;

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, Boolean> f11210g = DesugarCollections.synchronizedMap(new HashMap());

    /* JADX INFO: Access modifiers changed from: package-private */
    public CTFeatureFlagsController(String str, CleverTapInstanceConfig cleverTapInstanceConfig, BaseCallbackManager baseCallbackManager, BaseAnalyticsManager baseAnalyticsManager, FileUtils fileUtils) {
        this.f11205b = str;
        this.f11204a = cleverTapInstanceConfig;
        this.f11208e = baseCallbackManager;
        this.f11207d = baseAnalyticsManager;
        this.f11209f = fileUtils;
        l();
    }

    private synchronized void d(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f11209f.c(f(), g(), jSONObject);
                Logger i8 = i();
                String k8 = k();
                i8.s(k8, "Feature flags saved into file-[" + h() + "]" + this.f11210g);
            } catch (Exception e8) {
                e8.printStackTrace();
                Logger i9 = i();
                String k9 = k();
                i9.s(k9, "ArchiveData failed - " + e8.getLocalizedMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Logger i() {
        return this.f11204a.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k() {
        return this.f11204a.c() + "[Feature Flag]";
    }

    private void n() {
        if (this.f11208e.d() != null) {
            CTExecutorFactory.a(this.f11204a).b().d("notifyFeatureFlagUpdate", new Callable<Void>() { // from class: com.clevertap.android.sdk.featureFlags.CTFeatureFlagsController.4
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Void call() {
                    try {
                        if (CTFeatureFlagsController.this.f11208e.d() != null) {
                            CTFeatureFlagsController.this.f11208e.d().a();
                            return null;
                        }
                        return null;
                    } catch (Exception e8) {
                        CTFeatureFlagsController.this.i().s(CTFeatureFlagsController.this.k(), e8.getLocalizedMessage());
                        return null;
                    }
                }
            });
        }
    }

    public void e() {
        CTExecutorFactory.a(this.f11204a).b().d("fetchFeatureFlags", new Callable<Void>() { // from class: com.clevertap.android.sdk.featureFlags.CTFeatureFlagsController.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                try {
                    CTFeatureFlagsController.this.f11207d.a();
                    return null;
                } catch (Exception e8) {
                    CTFeatureFlagsController.this.i().s(CTFeatureFlagsController.this.k(), e8.getLocalizedMessage());
                    return null;
                }
            }
        });
    }

    String f() {
        return "Feature_Flag_" + this.f11204a.c() + "_" + this.f11205b;
    }

    String g() {
        return "ff_cache.json";
    }

    String h() {
        return f() + "/" + g();
    }

    public String j() {
        return this.f11205b;
    }

    void l() {
        if (TextUtils.isEmpty(this.f11205b)) {
            return;
        }
        Task a8 = CTExecutorFactory.a(this.f11204a).a();
        a8.b(new OnSuccessListener<Boolean>() { // from class: com.clevertap.android.sdk.featureFlags.CTFeatureFlagsController.2
            @Override // com.clevertap.android.sdk.task.OnSuccessListener
            /* renamed from: a */
            public void onSuccess(Boolean bool) {
                CTFeatureFlagsController.this.f11206c = bool.booleanValue();
            }
        });
        a8.d("initFeatureFlags", new Callable<Boolean>() { // from class: com.clevertap.android.sdk.featureFlags.CTFeatureFlagsController.3
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() {
                Boolean bool;
                synchronized (this) {
                    CTFeatureFlagsController.this.i().s(CTFeatureFlagsController.this.k(), "Feature flags init is called");
                    String h8 = CTFeatureFlagsController.this.h();
                    try {
                        CTFeatureFlagsController.this.f11210g.clear();
                        String b8 = CTFeatureFlagsController.this.f11209f.b(h8);
                        if (TextUtils.isEmpty(b8)) {
                            Logger i8 = CTFeatureFlagsController.this.i();
                            String k8 = CTFeatureFlagsController.this.k();
                            i8.s(k8, "Feature flags file is empty-" + h8);
                        } else {
                            JSONArray jSONArray = new JSONObject(b8).getJSONArray("kv");
                            if (jSONArray != null && jSONArray.length() > 0) {
                                for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                                    JSONObject jSONObject = (JSONObject) jSONArray.get(i9);
                                    if (jSONObject != null) {
                                        String string = jSONObject.getString("n");
                                        String string2 = jSONObject.getString("v");
                                        if (!TextUtils.isEmpty(string)) {
                                            CTFeatureFlagsController.this.f11210g.put(string, Boolean.valueOf(Boolean.parseBoolean(string2)));
                                        }
                                    }
                                }
                            }
                            Logger i10 = CTFeatureFlagsController.this.i();
                            String k9 = CTFeatureFlagsController.this.k();
                            i10.s(k9, "Feature flags initialized from file " + h8 + " with configs  " + CTFeatureFlagsController.this.f11210g);
                        }
                        bool = Boolean.TRUE;
                    } catch (Exception e8) {
                        e8.printStackTrace();
                        Logger i11 = CTFeatureFlagsController.this.i();
                        String k10 = CTFeatureFlagsController.this.k();
                        i11.s(k10, "UnArchiveData failed file- " + h8 + " " + e8.getLocalizedMessage());
                        return Boolean.FALSE;
                    }
                }
                return bool;
            }
        });
    }

    public boolean m() {
        return this.f11206c;
    }

    public void o(String str) {
        this.f11205b = str;
        l();
    }

    public void p(String str) {
        if (this.f11206c) {
            return;
        }
        this.f11205b = str;
        l();
    }

    public synchronized void q(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray("kv");
        for (int i8 = 0; i8 < jSONArray.length(); i8++) {
            try {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i8);
                this.f11210g.put(jSONObject2.getString("n"), Boolean.valueOf(jSONObject2.getBoolean("v")));
            } catch (JSONException e8) {
                Logger i9 = i();
                String k8 = k();
                i9.s(k8, "Error parsing Feature Flag array " + e8.getLocalizedMessage());
            }
        }
        Logger i10 = i();
        String k9 = k();
        i10.s(k9, "Updating feature flags..." + this.f11210g);
        d(jSONObject);
        n();
    }
}
