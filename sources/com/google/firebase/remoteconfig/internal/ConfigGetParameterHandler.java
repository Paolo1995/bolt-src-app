package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import com.google.android.gms.common.util.BiConsumer;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class ConfigGetParameterHandler {

    /* renamed from: e  reason: collision with root package name */
    public static final Charset f17107e = Charset.forName("UTF-8");

    /* renamed from: f  reason: collision with root package name */
    static final Pattern f17108f = Pattern.compile("^(1|true|t|yes|y|on)$", 2);

    /* renamed from: g  reason: collision with root package name */
    static final Pattern f17109g = Pattern.compile("^(0|false|f|no|n|off|)$", 2);

    /* renamed from: a  reason: collision with root package name */
    private final Set<BiConsumer<String, ConfigContainer>> f17110a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private final Executor f17111b;

    /* renamed from: c  reason: collision with root package name */
    private final ConfigCacheClient f17112c;

    /* renamed from: d  reason: collision with root package name */
    private final ConfigCacheClient f17113d;

    public ConfigGetParameterHandler(Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        this.f17111b = executor;
        this.f17112c = configCacheClient;
        this.f17113d = configCacheClient2;
    }

    private void b(String str, ConfigContainer configContainer) {
        if (configContainer == null) {
            return;
        }
        synchronized (this.f17110a) {
            for (BiConsumer<String, ConfigContainer> biConsumer : this.f17110a) {
                this.f17111b.execute(ConfigGetParameterHandler$$Lambda$1.a(biConsumer, str, configContainer));
            }
        }
    }

    private static ConfigContainer d(ConfigCacheClient configCacheClient) {
        return configCacheClient.d();
    }

    private static Set<String> e(ConfigCacheClient configCacheClient) {
        HashSet hashSet = new HashSet();
        ConfigContainer d8 = d(configCacheClient);
        if (d8 == null) {
            return hashSet;
        }
        Iterator<String> keys = d8.d().keys();
        while (keys.hasNext()) {
            hashSet.add(keys.next());
        }
        return hashSet;
    }

    private static String f(ConfigCacheClient configCacheClient, String str) {
        ConfigContainer d8 = d(configCacheClient);
        if (d8 == null) {
            return null;
        }
        try {
            return d8.d().getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    private static void i(String str, String str2) {
        Log.w("FirebaseRemoteConfig", String.format("No value of type '%s' exists for parameter key '%s'.", str2, str));
    }

    public void a(BiConsumer<String, ConfigContainer> biConsumer) {
        synchronized (this.f17110a) {
            this.f17110a.add(biConsumer);
        }
    }

    public Map<String, FirebaseRemoteConfigValue> c() {
        HashSet<String> hashSet = new HashSet();
        hashSet.addAll(e(this.f17112c));
        hashSet.addAll(e(this.f17113d));
        HashMap hashMap = new HashMap();
        for (String str : hashSet) {
            hashMap.put(str, g(str));
        }
        return hashMap;
    }

    public FirebaseRemoteConfigValue g(String str) {
        String f8 = f(this.f17112c, str);
        if (f8 != null) {
            b(str, d(this.f17112c));
            return new FirebaseRemoteConfigValueImpl(f8, 2);
        }
        String f9 = f(this.f17113d, str);
        if (f9 != null) {
            return new FirebaseRemoteConfigValueImpl(f9, 1);
        }
        i(str, "FirebaseRemoteConfigValue");
        return new FirebaseRemoteConfigValueImpl("", 0);
    }
}
