package com.google.firebase.perf.config;

/* loaded from: classes3.dex */
public final class ConfigurationConstants$SessionsMaxDurationMinutes extends ConfigurationFlag<Long> {

    /* renamed from: a  reason: collision with root package name */
    private static ConfigurationConstants$SessionsMaxDurationMinutes f16669a;

    private ConfigurationConstants$SessionsMaxDurationMinutes() {
    }

    public static synchronized ConfigurationConstants$SessionsMaxDurationMinutes e() {
        ConfigurationConstants$SessionsMaxDurationMinutes configurationConstants$SessionsMaxDurationMinutes;
        synchronized (ConfigurationConstants$SessionsMaxDurationMinutes.class) {
            if (f16669a == null) {
                f16669a = new ConfigurationConstants$SessionsMaxDurationMinutes();
            }
            configurationConstants$SessionsMaxDurationMinutes = f16669a;
        }
        return configurationConstants$SessionsMaxDurationMinutes;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String a() {
        return "com.google.firebase.perf.SessionsMaxDurationMinutes";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String b() {
        return "sessions_max_length_minutes";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String c() {
        return "fpr_session_max_duration_min";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long d() {
        return 240L;
    }
}
