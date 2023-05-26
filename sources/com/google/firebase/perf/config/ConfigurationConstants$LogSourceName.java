package com.google.firebase.perf.config;

import com.google.firebase.perf.BuildConfig;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class ConfigurationConstants$LogSourceName extends ConfigurationFlag<String> {

    /* renamed from: a  reason: collision with root package name */
    private static ConfigurationConstants$LogSourceName f16659a;

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Long, String> f16660b = Collections.unmodifiableMap(new HashMap<Long, String>() { // from class: com.google.firebase.perf.config.ConfigurationConstants$LogSourceName.1
        {
            put(461L, "FIREPERF_AUTOPUSH");
            put(462L, "FIREPERF");
            put(675L, "FIREPERF_INTERNAL_LOW");
            put(676L, "FIREPERF_INTERNAL_HIGH");
        }
    });

    private ConfigurationConstants$LogSourceName() {
    }

    public static synchronized ConfigurationConstants$LogSourceName e() {
        ConfigurationConstants$LogSourceName configurationConstants$LogSourceName;
        synchronized (ConfigurationConstants$LogSourceName.class) {
            if (f16659a == null) {
                f16659a = new ConfigurationConstants$LogSourceName();
            }
            configurationConstants$LogSourceName = f16659a;
        }
        return configurationConstants$LogSourceName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String f(long j8) {
        return f16660b.get(Long.valueOf(j8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean g(long j8) {
        return f16660b.containsKey(Long.valueOf(j8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String a() {
        return "com.google.firebase.perf.LogSourceName";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String c() {
        return "fpr_log_source";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String d() {
        return BuildConfig.f16645c;
    }
}
