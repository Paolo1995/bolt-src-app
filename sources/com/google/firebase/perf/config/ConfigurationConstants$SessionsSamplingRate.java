package com.google.firebase.perf.config;

/* loaded from: classes3.dex */
public final class ConfigurationConstants$SessionsSamplingRate extends ConfigurationFlag<Float> {

    /* renamed from: a  reason: collision with root package name */
    private static ConfigurationConstants$SessionsSamplingRate f16672a;

    private ConfigurationConstants$SessionsSamplingRate() {
    }

    public static synchronized ConfigurationConstants$SessionsSamplingRate e() {
        ConfigurationConstants$SessionsSamplingRate configurationConstants$SessionsSamplingRate;
        synchronized (ConfigurationConstants$SessionsSamplingRate.class) {
            if (f16672a == null) {
                f16672a = new ConfigurationConstants$SessionsSamplingRate();
            }
            configurationConstants$SessionsSamplingRate = f16672a;
        }
        return configurationConstants$SessionsSamplingRate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String a() {
        return "com.google.firebase.perf.SessionSamplingRate";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String b() {
        return "sessions_sampling_percentage";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String c() {
        return "fpr_vc_session_sampling_rate";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Float d() {
        return Float.valueOf(0.01f);
    }
}
