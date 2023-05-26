package com.google.firebase.perf.config;

/* loaded from: classes3.dex */
public final class ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs extends ConfigurationFlag<Long> {

    /* renamed from: a  reason: collision with root package name */
    private static ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs f16667a;

    private ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs() {
    }

    public static synchronized ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs e() {
        ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs configurationConstants$SessionsCpuCaptureFrequencyBackgroundMs;
        synchronized (ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs.class) {
            if (f16667a == null) {
                f16667a = new ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs();
            }
            configurationConstants$SessionsCpuCaptureFrequencyBackgroundMs = f16667a;
        }
        return configurationConstants$SessionsCpuCaptureFrequencyBackgroundMs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String a() {
        return "com.google.firebase.perf.SessionsCpuCaptureFrequencyBackgroundMs";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String b() {
        return "sessions_cpu_capture_frequency_bg_ms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String c() {
        return "fpr_session_gauge_cpu_capture_frequency_bg_ms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long d() {
        return 0L;
    }
}
