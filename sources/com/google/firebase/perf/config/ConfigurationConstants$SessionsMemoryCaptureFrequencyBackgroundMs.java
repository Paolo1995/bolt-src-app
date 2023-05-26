package com.google.firebase.perf.config;

/* loaded from: classes3.dex */
public final class ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs extends ConfigurationFlag<Long> {

    /* renamed from: a  reason: collision with root package name */
    private static ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs f16670a;

    private ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs() {
    }

    public static synchronized ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs e() {
        ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs configurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs;
        synchronized (ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs.class) {
            if (f16670a == null) {
                f16670a = new ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs();
            }
            configurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs = f16670a;
        }
        return configurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String a() {
        return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyBackgroundMs";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String b() {
        return "sessions_memory_capture_frequency_bg_ms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String c() {
        return "fpr_session_gauge_memory_capture_frequency_bg_ms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long d() {
        return 0L;
    }
}
