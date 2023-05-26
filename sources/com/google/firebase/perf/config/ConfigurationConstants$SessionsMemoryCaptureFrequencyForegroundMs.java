package com.google.firebase.perf.config;

/* loaded from: classes3.dex */
public final class ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs extends ConfigurationFlag<Long> {

    /* renamed from: a  reason: collision with root package name */
    private static ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs f16671a;

    private ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs() {
    }

    public static synchronized ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs e() {
        ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs;
        synchronized (ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs.class) {
            if (f16671a == null) {
                f16671a = new ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs();
            }
            configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs = f16671a;
        }
        return configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String a() {
        return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyForegroundMs";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String b() {
        return "sessions_memory_capture_frequency_fg_ms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String c() {
        return "fpr_session_gauge_memory_capture_frequency_fg_ms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long d() {
        return 100L;
    }
}
