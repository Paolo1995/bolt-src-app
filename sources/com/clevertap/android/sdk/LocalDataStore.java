package com.clevertap.android.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.clevertap.android.sdk.db.DBAdapter;
import com.clevertap.android.sdk.events.EventDetail;
import com.google.android.gms.common.Scopes;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class LocalDataStore {

    /* renamed from: h  reason: collision with root package name */
    private static long f11042h;

    /* renamed from: c  reason: collision with root package name */
    private final CleverTapInstanceConfig f11045c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f11046d;

    /* renamed from: e  reason: collision with root package name */
    private DBAdapter f11047e;

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, Integer> f11043a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Object> f11044b = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private final String f11049g = "local_events";

    /* renamed from: f  reason: collision with root package name */
    private final ExecutorService f11048f = Executors.newFixedThreadPool(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalDataStore(Context context, CleverTapInstanceConfig cleverTapInstanceConfig) {
        this.f11046d = context;
        this.f11045c = cleverTapInstanceConfig;
        z(context);
    }

    private boolean A() {
        return this.f11045c.v();
    }

    @SuppressLint({"CommitPrefEdits"})
    private void B(Context context, JSONObject jSONObject) {
        String str;
        try {
            String string = jSONObject.getString("evtName");
            if (string == null) {
                return;
            }
            if (!this.f11045c.t()) {
                str = "local_events:" + this.f11045c.c();
            } else {
                str = "local_events";
            }
            SharedPreferences h8 = StorageHelper.h(context, str);
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            EventDetail n8 = n(string, x(string, o(currentTimeMillis, currentTimeMillis, 0), str));
            String o8 = o(n8.b(), currentTimeMillis, n8.a() + 1);
            SharedPreferences.Editor edit = h8.edit();
            edit.putString(R(string), o8);
            StorageHelper.l(edit);
        } catch (Throwable th) {
            q().t(p(), "Failed to persist event locally", th);
        }
    }

    private void D() {
        final String c8 = this.f11045c.c();
        E("LocalDataStore#persistLocalProfileAsync", new Runnable() { // from class: com.clevertap.android.sdk.LocalDataStore.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LocalDataStore.this.f11044b) {
                    long M = LocalDataStore.this.f11047e.M(c8, new JSONObject(LocalDataStore.this.f11044b));
                    Logger q8 = LocalDataStore.this.q();
                    String p8 = LocalDataStore.this.p();
                    q8.s(p8, "Persist Local Profile complete with status " + M + " for id " + c8);
                }
            }
        });
    }

    private void E(final String str, final Runnable runnable) {
        boolean z7;
        try {
            if (Thread.currentThread().getId() == f11042h) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                runnable.run();
            } else {
                this.f11048f.submit(new Runnable() { // from class: com.clevertap.android.sdk.LocalDataStore.3
                    @Override // java.lang.Runnable
                    public void run() {
                        long unused = LocalDataStore.f11042h = Thread.currentThread().getId();
                        try {
                            Logger q8 = LocalDataStore.this.q();
                            String p8 = LocalDataStore.this.p();
                            q8.s(p8, "Local Data Store Executor service: Starting task - " + str);
                            runnable.run();
                        } catch (Throwable th) {
                            LocalDataStore.this.q().t(LocalDataStore.this.p(), "Executor service: Failed to complete the scheduled task", th);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            q().t(p(), "Failed to submit task to the executor service", th);
        }
    }

    private boolean F(Object obj) {
        boolean z7;
        boolean z8 = true;
        if (obj == null) {
            return true;
        }
        if ((obj instanceof String) && ((String) obj).trim().length() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (obj instanceof JSONArray) {
            if (((JSONArray) obj).length() > 0) {
                z8 = false;
            }
            return z8;
        }
        return z7;
    }

    private Boolean G(Object obj, Object obj2) {
        return Boolean.valueOf(S(obj).equals(S(obj2)));
    }

    private void I(String str, Boolean bool, boolean z7) {
        if (str == null) {
            return;
        }
        try {
            b(str);
            if (!bool.booleanValue()) {
                W(str);
            }
        } catch (Throwable unused) {
        }
        if (z7) {
            D();
        }
    }

    private void J() {
        synchronized (this.f11043a) {
            this.f11043a.clear();
        }
        synchronized (this.f11044b) {
            this.f11044b.clear();
        }
        this.f11047e.I(y());
    }

    private void L(Context context, int i8) {
        StorageHelper.n(context, R("local_cache_expires_in"), i8);
    }

    private void N(String str, Object obj, Boolean bool, boolean z7) {
        if (str != null && obj != null) {
            try {
                c(str, obj);
                if (!bool.booleanValue()) {
                    W(str);
                }
            } catch (Throwable unused) {
            }
            if (z7) {
                D();
            }
        }
    }

    private void P(JSONObject jSONObject, Boolean bool) {
        if (jSONObject == null) {
            return;
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                N(obj, jSONObject.get(obj), bool, false);
            }
            D();
        } catch (Throwable th) {
            q().t(p(), "Failed to set profile fields", th);
        }
    }

    private Boolean Q(String str, int i8) {
        boolean z7;
        if (i8 <= 0) {
            i8 = (int) (System.currentTimeMillis() / 1000);
        }
        Integer u7 = u(str);
        if (u7 != null && u7.intValue() > i8) {
            z7 = true;
        } else {
            z7 = false;
        }
        return Boolean.valueOf(z7);
    }

    private String R(String str) {
        return str + ":" + this.f11045c.c();
    }

    private String S(Object obj) {
        if (obj == null) {
            return "";
        }
        return obj.toString();
    }

    private JSONObject T(Context context, JSONObject jSONObject) {
        String str;
        LocalDataStore localDataStore = this;
        try {
            if (!localDataStore.f11045c.t()) {
                str = "local_events:" + localDataStore.f11045c.c();
            } else {
                str = "local_events";
            }
            String str2 = str;
            SharedPreferences h8 = StorageHelper.h(context, str2);
            Iterator<String> keys = jSONObject.keys();
            SharedPreferences.Editor edit = h8.edit();
            JSONObject jSONObject2 = null;
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                EventDetail n8 = localDataStore.n(obj, localDataStore.x(obj, localDataStore.o(0, 0, 0), str2));
                JSONArray jSONArray = jSONObject.getJSONArray(obj);
                if (jSONArray != null && jSONArray.length() >= 3) {
                    int i8 = jSONArray.getInt(0);
                    int i9 = jSONArray.getInt(1);
                    int i10 = jSONArray.getInt(2);
                    if (i8 > n8.a()) {
                        edit.putString(localDataStore.R(obj), localDataStore.o(i9, i10, i8));
                        q().s(p(), "Accepted update for event " + obj + " from upstream");
                        if (jSONObject2 == null) {
                            jSONObject2 = new JSONObject();
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("oldValue", n8.a());
                        jSONObject4.put("newValue", i8);
                        jSONObject3.put("count", jSONObject4);
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("oldValue", n8.b());
                        jSONObject5.put("newValue", jSONArray.getInt(1));
                        jSONObject3.put("firstTime", jSONObject5);
                        JSONObject jSONObject6 = new JSONObject();
                        jSONObject6.put("oldValue", n8.c());
                        jSONObject6.put("newValue", jSONArray.getInt(2));
                        jSONObject3.put("lastTime", jSONObject6);
                        jSONObject2.put(obj, jSONObject3);
                    } else {
                        q().s(p(), "Rejected update for event " + obj + " from upstream");
                    }
                } else {
                    q().s(p(), "Corrupted upstream event detail");
                }
                localDataStore = this;
                jSONObject2 = jSONObject2;
            }
            StorageHelper.l(edit);
            return jSONObject2;
        } catch (Throwable th) {
            q().t(p(), "Couldn't sync events from upstream", th);
            return null;
        }
    }

    private JSONObject U(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String obj = keys.next().toString();
                    if (Q(obj, currentTimeMillis).booleanValue()) {
                        q().s(p(), "Rejecting upstream value for key " + obj + " because our local cache prohibits it");
                    } else {
                        Object w7 = w(obj);
                        Object obj2 = jSONObject.get(obj);
                        if (F(obj2)) {
                            obj2 = null;
                        }
                        if (!G(obj2, w7).booleanValue()) {
                            if (obj2 != null) {
                                try {
                                    jSONObject3.put(obj, obj2);
                                } catch (Throwable th) {
                                    q().t(p(), "Failed to set profile updates", th);
                                }
                            } else {
                                I(obj, Boolean.TRUE, true);
                            }
                            JSONObject k8 = k(w7, obj2);
                            if (k8 != null) {
                                jSONObject2.put(obj, k8);
                            }
                        }
                    }
                }
                if (jSONObject3.length() > 0) {
                    P(jSONObject3, Boolean.TRUE);
                }
                return jSONObject2;
            } catch (Throwable th2) {
                q().t(p(), "Failed to sync remote profile", th2);
                return null;
            }
        }
        return jSONObject2;
    }

    private void W(String str) {
        if (str == null) {
            return;
        }
        synchronized (this.f11043a) {
            this.f11043a.put(str, Integer.valueOf(l()));
        }
    }

    private Object a(String str) {
        Object obj;
        if (str == null) {
            return null;
        }
        synchronized (this.f11044b) {
            obj = this.f11044b.get(str);
        }
        return obj;
    }

    private void b(String str) {
        if (str == null) {
            return;
        }
        synchronized (this.f11044b) {
            try {
                this.f11044b.remove(str);
            }
        }
    }

    private void c(String str, Object obj) {
        if (str != null && obj != null) {
            synchronized (this.f11044b) {
                this.f11044b.put(str, obj);
            }
        }
    }

    private JSONObject k(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        if (obj2 == null) {
            try {
                obj2 = -1;
            } catch (Throwable th) {
                q().t(p(), "Failed to create profile changed values object", th);
                return null;
            }
        }
        jSONObject.put("newValue", obj2);
        if (obj != null) {
            jSONObject.put("oldValue", obj);
        }
        return jSONObject;
    }

    private int l() {
        return ((int) (System.currentTimeMillis() / 1000)) + t(0);
    }

    private EventDetail n(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        String[] split = str2.split("\\|");
        return new EventDetail(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), str);
    }

    private String o(int i8, int i9, int i10) {
        return i10 + "|" + i8 + "|" + i9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String p() {
        return this.f11045c.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Logger q() {
        return this.f11045c.n();
    }

    private int s(String str, int i8) {
        if (this.f11045c.t()) {
            int c8 = StorageHelper.c(this.f11046d, R(str), -1000);
            if (c8 == -1000) {
                return StorageHelper.c(this.f11046d, str, i8);
            }
            return c8;
        }
        return StorageHelper.c(this.f11046d, R(str), i8);
    }

    private int t(int i8) {
        return s("local_cache_expires_in", i8);
    }

    private Integer u(String str) {
        Integer num;
        if (str == null) {
            return 0;
        }
        synchronized (this.f11043a) {
            num = this.f11043a.get(str);
        }
        return num;
    }

    private String x(String str, String str2, String str3) {
        if (this.f11045c.t()) {
            String j8 = StorageHelper.j(this.f11046d, str3, R(str), str2);
            if (j8 == null) {
                return StorageHelper.j(this.f11046d, str3, str, str2);
            }
            return j8;
        }
        return StorageHelper.j(this.f11046d, str3, R(str), str2);
    }

    private String y() {
        return this.f11045c.c();
    }

    private void z(final Context context) {
        final String c8 = this.f11045c.c();
        E("LocalDataStore#inflateLocalProfileAsync", new Runnable() { // from class: com.clevertap.android.sdk.LocalDataStore.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject B;
                if (LocalDataStore.this.f11047e == null) {
                    LocalDataStore.this.f11047e = new DBAdapter(context, LocalDataStore.this.f11045c);
                }
                synchronized (LocalDataStore.this.f11044b) {
                    try {
                        B = LocalDataStore.this.f11047e.B(c8);
                    } catch (Throwable unused) {
                    }
                    if (B == null) {
                        return;
                    }
                    Iterator<String> keys = B.keys();
                    while (keys.hasNext()) {
                        try {
                            String next = keys.next();
                            Object obj = B.get(next);
                            if (obj instanceof JSONObject) {
                                LocalDataStore.this.f11044b.put(next, B.getJSONObject(next));
                            } else if (obj instanceof JSONArray) {
                                LocalDataStore.this.f11044b.put(next, B.getJSONArray(next));
                            } else {
                                LocalDataStore.this.f11044b.put(next, obj);
                            }
                        } catch (JSONException unused2) {
                        }
                    }
                    Logger q8 = LocalDataStore.this.q();
                    String p8 = LocalDataStore.this.p();
                    q8.s(p8, "Local Data Store - Inflated local profile " + LocalDataStore.this.f11044b.toString());
                }
            }
        });
    }

    public void C(Context context, JSONObject jSONObject, int i8) {
        if (jSONObject != null && i8 == 4) {
            try {
                B(context, jSONObject);
            } catch (Throwable th) {
                q().t(p(), "Failed to sync with upstream", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(String str) {
        I(str, Boolean.FALSE, true);
    }

    public void K(JSONObject jSONObject) {
        try {
            if (!this.f11045c.v()) {
                jSONObject.put("dsync", false);
                return;
            }
            String string = jSONObject.getString("type");
            if ("event".equals(string) && "App Launched".equals(jSONObject.getString("evtName"))) {
                q().s(p(), "Local cache needs to be updated (triggered by App Launched)");
                jSONObject.put("dsync", true);
            } else if (Scopes.PROFILE.equals(string)) {
                jSONObject.put("dsync", true);
                q().s(p(), "Local cache needs to be updated (profile event)");
            } else {
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (s("local_cache_last_update", currentTimeMillis) + t(1200) < currentTimeMillis) {
                    jSONObject.put("dsync", true);
                    q().s(p(), "Local cache needs to be updated");
                    return;
                }
                jSONObject.put("dsync", false);
                q().s(p(), "Local cache doesn't need to be updated");
            }
        } catch (Throwable th) {
            q().t(p(), "Failed to sync with upstream", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(String str, Object obj) {
        N(str, obj, Boolean.FALSE, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(JSONObject jSONObject) {
        P(jSONObject, Boolean.FALSE);
    }

    public void V(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        boolean z7;
        Object obj;
        try {
            if (!jSONObject.has("evpr")) {
                return;
            }
            JSONObject jSONObject4 = jSONObject.getJSONObject("evpr");
            SyncListener syncListener = null;
            if (jSONObject4.has(Scopes.PROFILE)) {
                JSONObject jSONObject5 = jSONObject4.getJSONObject(Scopes.PROFILE);
                if (jSONObject5.has("_custom")) {
                    JSONObject jSONObject6 = jSONObject5.getJSONObject("_custom");
                    jSONObject5.remove("_custom");
                    Iterator<String> keys = jSONObject6.keys();
                    while (keys.hasNext()) {
                        String obj2 = keys.next().toString();
                        try {
                            try {
                                obj = jSONObject6.getJSONArray(obj2);
                            } catch (JSONException unused) {
                                obj = null;
                            }
                        } catch (Throwable unused2) {
                            obj = jSONObject6.get(obj2);
                        }
                        if (obj != null) {
                            jSONObject5.put(obj2, obj);
                        }
                    }
                }
                jSONObject2 = U(jSONObject5);
            } else {
                jSONObject2 = null;
            }
            if (jSONObject4.has("events")) {
                jSONObject3 = T(context, jSONObject4.getJSONObject("events"));
            } else {
                jSONObject3 = null;
            }
            if (jSONObject4.has("expires_in")) {
                L(context, jSONObject4.getInt("expires_in"));
            }
            StorageHelper.n(context, R("local_cache_last_update"), (int) (System.currentTimeMillis() / 1000));
            boolean z8 = true;
            if (jSONObject2 != null && jSONObject2.length() > 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            Boolean valueOf = Boolean.valueOf(z7);
            if (jSONObject3 == null || jSONObject3.length() <= 0) {
                z8 = false;
            }
            Boolean valueOf2 = Boolean.valueOf(z8);
            if (valueOf.booleanValue() || valueOf2.booleanValue()) {
                JSONObject jSONObject7 = new JSONObject();
                if (valueOf.booleanValue()) {
                    jSONObject7.put(Scopes.PROFILE, jSONObject2);
                }
                if (valueOf2.booleanValue()) {
                    jSONObject7.put("events", jSONObject3);
                }
                try {
                    CleverTapAPI y7 = CleverTapAPI.y(context);
                    if (y7 != null) {
                        syncListener = y7.G();
                    }
                } catch (Throwable unused3) {
                }
                if (syncListener != null) {
                    syncListener.a(jSONObject7);
                }
            }
        } catch (Throwable th) {
            q().t(p(), "Failed to sync with upstream", th);
        }
    }

    public void m() {
        J();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventDetail r(String str) {
        String str2;
        try {
            if (!A()) {
                return null;
            }
            if (!this.f11045c.t()) {
                str2 = "local_events:" + this.f11045c.c();
            } else {
                str2 = "local_events";
            }
            return n(str, x(str, null, str2));
        } catch (Throwable th) {
            q().t(p(), "Failed to retrieve local event detail", th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object v(String str) {
        return w(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object w(String str) {
        return a(str);
    }
}
