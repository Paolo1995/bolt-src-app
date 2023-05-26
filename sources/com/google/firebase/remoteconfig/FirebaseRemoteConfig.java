package com.google.firebase.remoteconfig;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.AbtException;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.DefaultsXmlParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class FirebaseRemoteConfig {

    /* renamed from: l  reason: collision with root package name */
    public static final byte[] f17011l = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    private final Context f17012a;

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseApp f17013b;

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseABTesting f17014c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f17015d;

    /* renamed from: e  reason: collision with root package name */
    private final ConfigCacheClient f17016e;

    /* renamed from: f  reason: collision with root package name */
    private final ConfigCacheClient f17017f;

    /* renamed from: g  reason: collision with root package name */
    private final ConfigCacheClient f17018g;

    /* renamed from: h  reason: collision with root package name */
    private final ConfigFetchHandler f17019h;

    /* renamed from: i  reason: collision with root package name */
    private final ConfigGetParameterHandler f17020i;

    /* renamed from: j  reason: collision with root package name */
    private final ConfigMetadataClient f17021j;

    /* renamed from: k  reason: collision with root package name */
    private final FirebaseInstallationsApi f17022k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseRemoteConfig(Context context, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2, ConfigCacheClient configCacheClient3, ConfigFetchHandler configFetchHandler, ConfigGetParameterHandler configGetParameterHandler, ConfigMetadataClient configMetadataClient) {
        this.f17012a = context;
        this.f17013b = firebaseApp;
        this.f17022k = firebaseInstallationsApi;
        this.f17014c = firebaseABTesting;
        this.f17015d = executor;
        this.f17016e = configCacheClient;
        this.f17017f = configCacheClient2;
        this.f17018g = configCacheClient3;
        this.f17019h = configFetchHandler;
        this.f17020i = configGetParameterHandler;
        this.f17021j = configMetadataClient;
    }

    @NonNull
    public static FirebaseRemoteConfig g() {
        return h(FirebaseApp.k());
    }

    @NonNull
    public static FirebaseRemoteConfig h(@NonNull FirebaseApp firebaseApp) {
        return ((RemoteConfigComponent) firebaseApp.i(RemoteConfigComponent.class)).d();
    }

    private static boolean i(ConfigContainer configContainer, ConfigContainer configContainer2) {
        if (configContainer2 != null && configContainer.e().equals(configContainer2.e())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Task j(FirebaseRemoteConfig firebaseRemoteConfig, Task task, Task task2, Task task3) throws Exception {
        if (task.isSuccessful() && task.getResult() != null) {
            ConfigContainer configContainer = (ConfigContainer) task.getResult();
            if (task2.isSuccessful() && !i(configContainer, (ConfigContainer) task2.getResult())) {
                return Tasks.forResult(Boolean.FALSE);
            }
            return firebaseRemoteConfig.f17017f.i(configContainer).continueWith(firebaseRemoteConfig.f17015d, FirebaseRemoteConfig$$Lambda$10.a(firebaseRemoteConfig));
        }
        return Tasks.forResult(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Void m(FirebaseRemoteConfig firebaseRemoteConfig, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) throws Exception {
        firebaseRemoteConfig.f17021j.i(firebaseRemoteConfigSettings);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(Task<ConfigContainer> task) {
        if (task.isSuccessful()) {
            this.f17016e.b();
            if (task.getResult() != null) {
                u(task.getResult().c());
                return true;
            }
            Log.e("FirebaseRemoteConfig", "Activated configs written to disk are null.");
            return true;
        }
        return false;
    }

    private Task<Void> r(Map<String, String> map) {
        try {
            return this.f17018g.i(ConfigContainer.g().b(map).a()).onSuccessTask(FirebaseRemoteConfig$$Lambda$9.a());
        } catch (JSONException e8) {
            Log.e("FirebaseRemoteConfig", "The provided defaults map could not be processed.", e8);
            return Tasks.forResult(null);
        }
    }

    static List<Map<String, String>> t(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i8 = 0; i8 < jSONArray.length(); i8++) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = jSONArray.getJSONObject(i8);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    @NonNull
    public Task<Boolean> b() {
        Task<ConfigContainer> c8 = this.f17016e.c();
        Task<ConfigContainer> c9 = this.f17017f.c();
        return Tasks.whenAllComplete(c8, c9).continueWithTask(this.f17015d, FirebaseRemoteConfig$$Lambda$4.a(this, c8, c9));
    }

    @NonNull
    public Task<Void> c() {
        return this.f17019h.d().onSuccessTask(FirebaseRemoteConfig$$Lambda$5.a());
    }

    @NonNull
    public Task<Boolean> d() {
        return c().onSuccessTask(this.f17015d, FirebaseRemoteConfig$$Lambda$3.a(this));
    }

    @NonNull
    public Map<String, FirebaseRemoteConfigValue> e() {
        return this.f17020i.c();
    }

    @NonNull
    public FirebaseRemoteConfigInfo f() {
        return this.f17021j.c();
    }

    @NonNull
    public Task<Void> p(@NonNull FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        return Tasks.call(this.f17015d, FirebaseRemoteConfig$$Lambda$7.a(this, firebaseRemoteConfigSettings));
    }

    @NonNull
    public Task<Void> q(int i8) {
        return r(DefaultsXmlParser.a(this.f17012a, i8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        this.f17017f.c();
        this.f17018g.c();
        this.f17016e.c();
    }

    void u(@NonNull JSONArray jSONArray) {
        if (this.f17014c == null) {
            return;
        }
        try {
            this.f17014c.k(t(jSONArray));
        } catch (AbtException e8) {
            Log.w("FirebaseRemoteConfig", "Could not update ABT experiments.", e8);
        } catch (JSONException e9) {
            Log.e("FirebaseRemoteConfig", "Could not parse ABT experiments from the JSON response.", e9);
        }
    }
}
