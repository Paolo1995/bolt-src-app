package com.google.firebase.perf.config;

/* loaded from: classes3.dex */
public final class ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs extends ConfigurationFlag<Long> {

    /* renamed from: a  reason: collision with root package name */
    private static ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs f16668a;

    private ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs() {
    }

    public static synchronized ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs e() {
        ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs configurationConstants$SessionsCpuCaptureFrequencyForegroundMs;
        synchronized (ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs.class) {
            if (f16668a == null) {
                f16668a = new ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs();
            }
            configurationConstants$SessionsCpuCaptureFrequencyForegroundMs = f16668a;
        }
        return configurationConstants$SessionsCpuCaptureFrequencyForegroundMs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String a() {
        return "com.google.firebase.perf.SessionsCpuCaptureFrequencyForegroundMs";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String b() {
        return "sessions_cpu_capture_frequency_fg_ms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String c() {
        return "fpr_session_gauge_cpu_capture_frequency_fg_ms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long d() {
        return 100L;
    }
}
