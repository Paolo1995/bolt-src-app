package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.mixpanel.android.util.MPLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"CommitPrefEdits"})
/* loaded from: classes3.dex */
public class PersistentIdentity {

    /* renamed from: p  reason: collision with root package name */
    private static Integer f19318p = null;

    /* renamed from: q  reason: collision with root package name */
    private static Boolean f19319q = null;

    /* renamed from: r  reason: collision with root package name */
    private static boolean f19320r = true;

    /* renamed from: s  reason: collision with root package name */
    private static final Object f19321s = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final Future<SharedPreferences> f19322a;

    /* renamed from: b  reason: collision with root package name */
    private final Future<SharedPreferences> f19323b;

    /* renamed from: c  reason: collision with root package name */
    private final Future<SharedPreferences> f19324c;

    /* renamed from: d  reason: collision with root package name */
    private final Future<SharedPreferences> f19325d;

    /* renamed from: j  reason: collision with root package name */
    private String f19331j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f19332k;

    /* renamed from: l  reason: collision with root package name */
    private String f19333l;

    /* renamed from: m  reason: collision with root package name */
    private String f19334m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f19335n;

    /* renamed from: o  reason: collision with root package name */
    private Boolean f19336o;

    /* renamed from: g  reason: collision with root package name */
    private Object f19328g = new Object();

    /* renamed from: f  reason: collision with root package name */
    private JSONObject f19327f = null;

    /* renamed from: h  reason: collision with root package name */
    private Map<String, String> f19329h = null;

    /* renamed from: i  reason: collision with root package name */
    private boolean f19330i = false;

    /* renamed from: e  reason: collision with root package name */
    private final SharedPreferences.OnSharedPreferenceChangeListener f19326e = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.mixpanel.android.mpmetrics.PersistentIdentity.1
        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            synchronized (PersistentIdentity.f19321s) {
                PersistentIdentity.this.A();
                boolean unused = PersistentIdentity.f19320r = false;
            }
        }
    };

    public PersistentIdentity(Future<SharedPreferences> future, Future<SharedPreferences> future2, Future<SharedPreferences> future3, Future<SharedPreferences> future4) {
        this.f19323b = future;
        this.f19322a = future2;
        this.f19324c = future3;
        this.f19325d = future4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        this.f19329h = new HashMap();
        try {
            SharedPreferences sharedPreferences = this.f19323b.get();
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(this.f19326e);
            sharedPreferences.registerOnSharedPreferenceChangeListener(this.f19326e);
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                Object value = entry.getValue();
                this.f19329h.put(entry.getKey(), value.toString());
            }
        } catch (InterruptedException e8) {
            MPLog.d("MixpanelAPI.PIdentity", "Cannot load referrer properties from shared preferences.", e8);
        } catch (ExecutionException e9) {
            MPLog.d("MixpanelAPI.PIdentity", "Cannot load referrer properties from shared preferences.", e9.getCause());
        }
    }

    private void B() {
        JSONObject jSONObject;
        try {
            try {
                try {
                    try {
                        String string = this.f19322a.get().getString("super_properties", "{}");
                        MPLog.i("MixpanelAPI.PIdentity", "Loading Super Properties " + string);
                        this.f19327f = new JSONObject(string);
                    } catch (InterruptedException e8) {
                        MPLog.d("MixpanelAPI.PIdentity", "Cannot load superProperties from SharedPreferences.", e8);
                        if (this.f19327f == null) {
                            jSONObject = new JSONObject();
                            this.f19327f = jSONObject;
                        }
                    }
                } catch (JSONException unused) {
                    MPLog.c("MixpanelAPI.PIdentity", "Cannot parse stored superProperties");
                    M();
                    if (this.f19327f == null) {
                        jSONObject = new JSONObject();
                        this.f19327f = jSONObject;
                    }
                }
            } catch (ExecutionException e9) {
                MPLog.d("MixpanelAPI.PIdentity", "Cannot load superProperties from SharedPreferences.", e9.getCause());
                if (this.f19327f == null) {
                    jSONObject = new JSONObject();
                    this.f19327f = jSONObject;
                }
            }
        } catch (Throwable th) {
            if (this.f19327f == null) {
                this.f19327f = new JSONObject();
            }
            throw th;
        }
    }

    private void M() {
        JSONObject jSONObject = this.f19327f;
        if (jSONObject == null) {
            MPLog.c("MixpanelAPI.PIdentity", "storeSuperProperties should not be called with uninitialized superPropertiesCache.");
            return;
        }
        String jSONObject2 = jSONObject.toString();
        MPLog.i("MixpanelAPI.PIdentity", "Storing Super Properties " + jSONObject2);
        try {
            SharedPreferences.Editor edit = this.f19322a.get().edit();
            edit.putString("super_properties", jSONObject2);
            O(edit);
        } catch (InterruptedException e8) {
            MPLog.d("MixpanelAPI.PIdentity", "Cannot store superProperties in shared preferences.", e8);
        } catch (ExecutionException e9) {
            MPLog.d("MixpanelAPI.PIdentity", "Cannot store superProperties in shared preferences.", e9.getCause());
        }
    }

    private static void O(SharedPreferences.Editor editor) {
        editor.apply();
    }

    private void P() {
        try {
            SharedPreferences.Editor edit = this.f19322a.get().edit();
            edit.putString("events_distinct_id", this.f19331j);
            edit.putBoolean("events_user_id_present", this.f19332k);
            edit.putString("people_distinct_id", this.f19333l);
            edit.putString("anonymous_id", this.f19334m);
            edit.putBoolean("had_persisted_distinct_id", this.f19335n);
            O(edit);
        } catch (InterruptedException e8) {
            MPLog.d("MixpanelAPI.PIdentity", "Can't write distinct ids to shared preferences.", e8);
        } catch (ExecutionException e9) {
            MPLog.d("MixpanelAPI.PIdentity", "Can't write distinct ids to shared preferences.", e9.getCause());
        }
    }

    private void Q(String str) {
        try {
            SharedPreferences.Editor edit = this.f19325d.get().edit();
            edit.putBoolean("opt_out_" + str, this.f19336o.booleanValue());
            O(edit);
        } catch (InterruptedException e8) {
            MPLog.d("MixpanelAPI.PIdentity", "Can't write opt-out shared preferences.", e8);
        } catch (ExecutionException e9) {
            MPLog.d("MixpanelAPI.PIdentity", "Can't write opt-out shared preferences.", e9.getCause());
        }
    }

    public static void R(Context context, String str, Map<String, String> map) {
        synchronized (f19321s) {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.clear();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                edit.putString(entry.getKey(), entry.getValue());
            }
            O(edit);
            f19320r = true;
        }
    }

    public static String o(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("people_distinct_id", null);
    }

    private JSONObject r() {
        if (this.f19327f == null) {
            B();
        }
        return this.f19327f;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void y() {
        /*
            r4 = this;
            java.lang.String r0 = "Cannot read distinct ids from sharedPreferences."
            java.lang.String r1 = "MixpanelAPI.PIdentity"
            r2 = 0
            java.util.concurrent.Future<android.content.SharedPreferences> r3 = r4.f19322a     // Catch: java.lang.InterruptedException -> Le java.util.concurrent.ExecutionException -> L13
            java.lang.Object r3 = r3.get()     // Catch: java.lang.InterruptedException -> Le java.util.concurrent.ExecutionException -> L13
            android.content.SharedPreferences r3 = (android.content.SharedPreferences) r3     // Catch: java.lang.InterruptedException -> Le java.util.concurrent.ExecutionException -> L13
            goto L1c
        Le:
            r3 = move-exception
            com.mixpanel.android.util.MPLog.d(r1, r0, r3)
            goto L1b
        L13:
            r3 = move-exception
            java.lang.Throwable r3 = r3.getCause()
            com.mixpanel.android.util.MPLog.d(r1, r0, r3)
        L1b:
            r3 = r2
        L1c:
            if (r3 != 0) goto L1f
            return
        L1f:
            java.lang.String r0 = "events_distinct_id"
            java.lang.String r0 = r3.getString(r0, r2)
            r4.f19331j = r0
            java.lang.String r0 = "events_user_id_present"
            r1 = 0
            boolean r0 = r3.getBoolean(r0, r1)
            r4.f19332k = r0
            java.lang.String r0 = "people_distinct_id"
            java.lang.String r0 = r3.getString(r0, r2)
            r4.f19333l = r0
            java.lang.String r0 = "anonymous_id"
            java.lang.String r0 = r3.getString(r0, r2)
            r4.f19334m = r0
            java.lang.String r0 = "had_persisted_distinct_id"
            boolean r0 = r3.getBoolean(r0, r1)
            r4.f19335n = r0
            java.lang.String r0 = r4.f19331j
            if (r0 != 0) goto L5d
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
            r4.f19334m = r0
            r4.f19331j = r0
            r4.f19332k = r1
            r4.P()
        L5d:
            r0 = 1
            r4.f19330i = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.PersistentIdentity.y():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void z(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r0 = "Cannot read opt out flag from sharedPreferences."
            java.lang.String r1 = "MixpanelAPI.PIdentity"
            java.util.concurrent.Future<android.content.SharedPreferences> r2 = r3.f19325d     // Catch: java.lang.InterruptedException -> Ld java.util.concurrent.ExecutionException -> L12
            java.lang.Object r2 = r2.get()     // Catch: java.lang.InterruptedException -> Ld java.util.concurrent.ExecutionException -> L12
            android.content.SharedPreferences r2 = (android.content.SharedPreferences) r2     // Catch: java.lang.InterruptedException -> Ld java.util.concurrent.ExecutionException -> L12
            goto L1b
        Ld:
            r2 = move-exception
            com.mixpanel.android.util.MPLog.d(r1, r0, r2)
            goto L1a
        L12:
            r2 = move-exception
            java.lang.Throwable r2 = r2.getCause()
            com.mixpanel.android.util.MPLog.d(r1, r0, r2)
        L1a:
            r2 = 0
        L1b:
            if (r2 != 0) goto L1e
            return
        L1e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "opt_out_"
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r0 = 0
            boolean r4 = r2.getBoolean(r4, r0)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r3.f19336o = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.PersistentIdentity.z(java.lang.String):void");
    }

    public void C(JSONObject jSONObject) {
        synchronized (this.f19328g) {
            JSONObject r7 = r();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    r7.put(next, jSONObject.get(next));
                } catch (JSONException e8) {
                    MPLog.d("MixpanelAPI.PIdentity", "Exception registering super property.", e8);
                }
            }
            M();
        }
    }

    public void D(String str) {
        try {
            SharedPreferences.Editor edit = this.f19324c.get().edit();
            edit.remove(str);
            O(edit);
        } catch (InterruptedException e8) {
            e8.printStackTrace();
        } catch (ExecutionException e9) {
            e9.printStackTrace();
        }
    }

    public synchronized void E(Integer num) {
        try {
            SharedPreferences sharedPreferences = this.f19322a.get();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            String string = sharedPreferences.getString("seen_campaign_ids", "");
            edit.putString("seen_campaign_ids", string + num + ",");
            O(edit);
        } catch (InterruptedException e8) {
            MPLog.d("MixpanelAPI.PIdentity", "Can't write campaign id to shared preferences", e8);
        } catch (ExecutionException e9) {
            MPLog.d("MixpanelAPI.PIdentity", "Can't write campaign d to shared preferences", e9.getCause());
        }
    }

    public synchronized void F(String str) {
        if (!this.f19330i) {
            y();
        }
        if (this.f19334m != null) {
            return;
        }
        this.f19334m = str;
        this.f19335n = true;
        P();
    }

    public synchronized void G(String str) {
        if (!this.f19330i) {
            y();
        }
        this.f19331j = str;
        P();
    }

    public synchronized void H(String str) {
        try {
            try {
                SharedPreferences.Editor edit = this.f19325d.get().edit();
                edit.putBoolean("has_launched_" + str, true);
                O(edit);
            } catch (InterruptedException e8) {
                MPLog.d("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel shared preferences.", e8);
            }
        } catch (ExecutionException e9) {
            MPLog.d("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel shared preferences.", e9.getCause());
        }
    }

    public synchronized void I(String str) {
        try {
            try {
                SharedPreferences.Editor edit = this.f19325d.get().edit();
                edit.putBoolean(str, true);
                O(edit);
            } catch (InterruptedException e8) {
                MPLog.d("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel from shared preferences.", e8);
            }
        } catch (ExecutionException e9) {
            MPLog.d("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel shared preferences.", e9.getCause());
        }
    }

    public synchronized void J(boolean z7, String str) {
        this.f19336o = Boolean.valueOf(z7);
        Q(str);
    }

    public synchronized void K(String str) {
        if (!this.f19330i) {
            y();
        }
        this.f19333l = str;
        P();
    }

    public synchronized void L(String str) {
        try {
            try {
                SharedPreferences.Editor edit = this.f19322a.get().edit();
                edit.putString("push_id", str);
                O(edit);
            } catch (InterruptedException e8) {
                MPLog.d("MixpanelAPI.PIdentity", "Can't write push id to shared preferences", e8);
            }
        } catch (ExecutionException e9) {
            MPLog.d("MixpanelAPI.PIdentity", "Can't write push id to shared preferences", e9.getCause());
        }
    }

    public void N(SuperPropertyUpdate superPropertyUpdate) {
        synchronized (this.f19328g) {
            JSONObject r7 = r();
            JSONObject jSONObject = new JSONObject();
            try {
                Iterator<String> keys = r7.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, r7.get(next));
                }
                JSONObject a8 = superPropertyUpdate.a(jSONObject);
                if (a8 == null) {
                    MPLog.k("MixpanelAPI.PIdentity", "An update to Mixpanel's super properties returned null, and will have no effect.");
                    return;
                }
                this.f19327f = a8;
                M();
            } catch (JSONException e8) {
                MPLog.d("MixpanelAPI.PIdentity", "Can't copy from one JSONObject to another", e8);
            }
        }
    }

    public void d(JSONObject jSONObject) {
        synchronized (this.f19328g) {
            JSONObject r7 = r();
            Iterator<String> keys = r7.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    jSONObject.put(next, r7.get(next));
                } catch (JSONException e8) {
                    MPLog.d("MixpanelAPI.PIdentity", "Object read from one JSON Object cannot be written to another", e8);
                }
            }
        }
    }

    public void e(String str, Long l8) {
        try {
            SharedPreferences.Editor edit = this.f19324c.get().edit();
            edit.putLong(str, l8.longValue());
            O(edit);
        } catch (InterruptedException e8) {
            e8.printStackTrace();
        } catch (ExecutionException e9) {
            e9.printStackTrace();
        }
    }

    public synchronized void f() {
        try {
            SharedPreferences.Editor edit = this.f19322a.get().edit();
            edit.clear();
            O(edit);
            B();
            y();
        } catch (InterruptedException e8) {
            throw new RuntimeException(e8.getCause());
        } catch (ExecutionException e9) {
            throw new RuntimeException(e9.getCause());
        }
    }

    public void g() {
        synchronized (f19321s) {
            try {
                try {
                    SharedPreferences.Editor edit = this.f19323b.get().edit();
                    edit.clear();
                    O(edit);
                } catch (InterruptedException e8) {
                    MPLog.d("MixpanelAPI.PIdentity", "Cannot load referrer properties from shared preferences.", e8);
                }
            } catch (ExecutionException e9) {
                MPLog.d("MixpanelAPI.PIdentity", "Cannot load referrer properties from shared preferences.", e9.getCause());
            }
        }
    }

    public void h() {
        try {
            SharedPreferences.Editor edit = this.f19324c.get().edit();
            edit.clear();
            O(edit);
        } catch (InterruptedException e8) {
            e8.printStackTrace();
        } catch (ExecutionException e9) {
            e9.printStackTrace();
        }
    }

    public synchronized String i() {
        if (!this.f19330i) {
            y();
        }
        return this.f19334m;
    }

    public synchronized String j() {
        if (!this.f19330i) {
            y();
        }
        return this.f19331j;
    }

    public synchronized String k() {
        if (!this.f19330i) {
            y();
        }
        if (this.f19332k) {
            return this.f19331j;
        }
        return null;
    }

    public synchronized boolean l() {
        if (!this.f19330i) {
            y();
        }
        return this.f19335n;
    }

    public synchronized boolean m(String str) {
        if (this.f19336o == null) {
            z(str);
        }
        return this.f19336o.booleanValue();
    }

    public synchronized String n() {
        if (!this.f19330i) {
            y();
        }
        return this.f19333l;
    }

    public Map<String, String> p() {
        synchronized (f19321s) {
            if (f19320r || this.f19329h == null) {
                A();
                f19320r = false;
            }
        }
        return this.f19329h;
    }

    public synchronized HashSet<Integer> q() {
        HashSet<Integer> hashSet;
        hashSet = new HashSet<>();
        try {
            StringTokenizer stringTokenizer = new StringTokenizer(this.f19322a.get().getString("seen_campaign_ids", ""), ",");
            while (stringTokenizer.hasMoreTokens()) {
                hashSet.add(Integer.valueOf(stringTokenizer.nextToken()));
            }
        } catch (InterruptedException e8) {
            MPLog.d("MixpanelAPI.PIdentity", "Couldn't read Mixpanel shared preferences.", e8);
        } catch (ExecutionException e9) {
            MPLog.d("MixpanelAPI.PIdentity", "Couldn't read Mixpanel shared preferences.", e9.getCause());
        }
        return hashSet;
    }

    public Map<String, Long> s() {
        HashMap hashMap = new HashMap();
        try {
            for (Map.Entry<String, ?> entry : this.f19324c.get().getAll().entrySet()) {
                hashMap.put(entry.getKey(), Long.valueOf(entry.getValue().toString()));
            }
        } catch (InterruptedException e8) {
            e8.printStackTrace();
        } catch (ExecutionException e9) {
            e9.printStackTrace();
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean t(String str) {
        try {
            return this.f19325d.get().contains("opt_out_" + str);
        } catch (InterruptedException e8) {
            MPLog.d("MixpanelAPI.PIdentity", "Can't read opt-out shared preferences.", e8);
            return false;
        } catch (ExecutionException e9) {
            MPLog.d("MixpanelAPI.PIdentity", "Can't read opt-out shared preferences.", e9.getCause());
            return false;
        }
    }

    public synchronized boolean u(String str) {
        boolean z7;
        z7 = false;
        try {
            z7 = this.f19325d.get().getBoolean(str, false);
        } catch (InterruptedException e8) {
            MPLog.d("MixpanelAPI.PIdentity", "Couldn't read internal Mixpanel from shared preferences.", e8);
        } catch (ExecutionException e9) {
            MPLog.d("MixpanelAPI.PIdentity", "Couldn't read internal Mixpanel shared preferences.", e9.getCause());
        }
        return z7;
    }

    public synchronized boolean v(boolean z7, String str) {
        if (f19319q == null) {
            try {
                boolean z8 = false;
                if (this.f19325d.get().getBoolean("has_launched_" + str, false)) {
                    f19319q = Boolean.FALSE;
                } else {
                    if (!z7) {
                        z8 = true;
                    }
                    Boolean valueOf = Boolean.valueOf(z8);
                    f19319q = valueOf;
                    if (!valueOf.booleanValue()) {
                        H(str);
                    }
                }
            } catch (InterruptedException unused) {
                f19319q = Boolean.FALSE;
            } catch (ExecutionException unused2) {
                f19319q = Boolean.FALSE;
            }
        }
        return f19319q.booleanValue();
    }

    public synchronized boolean w(String str) {
        if (str == null) {
            return false;
        }
        Integer valueOf = Integer.valueOf(str);
        try {
            try {
                if (f19318p == null) {
                    Integer valueOf2 = Integer.valueOf(this.f19325d.get().getInt("latest_version_code", -1));
                    f19318p = valueOf2;
                    if (valueOf2.intValue() == -1) {
                        f19318p = valueOf;
                        SharedPreferences.Editor edit = this.f19325d.get().edit();
                        edit.putInt("latest_version_code", valueOf.intValue());
                        O(edit);
                    }
                }
                if (f19318p.intValue() < valueOf.intValue()) {
                    SharedPreferences.Editor edit2 = this.f19325d.get().edit();
                    edit2.putInt("latest_version_code", valueOf.intValue());
                    O(edit2);
                    return true;
                }
            } catch (ExecutionException e8) {
                MPLog.d("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel shared preferences.", e8.getCause());
            }
        } catch (InterruptedException e9) {
            MPLog.d("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel from shared preferences.", e9);
        }
        return false;
    }

    public synchronized void x() {
        if (!this.f19330i) {
            y();
        }
        this.f19332k = true;
        P();
    }
}
