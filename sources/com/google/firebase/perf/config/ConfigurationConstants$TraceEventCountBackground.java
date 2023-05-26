package com.google.firebase.perf.config;

/* loaded from: classes3.dex */
public final class ConfigurationConstants$TraceEventCountBackground extends ConfigurationFlag<Long> {

    /* renamed from: a  reason: collision with root package name */
    private static ConfigurationConstants$TraceEventCountBackground f16673a;

    private ConfigurationConstants$TraceEventCountBackground() {
    }

    public static synchronized ConfigurationConstants$TraceEventCountBackground e() {
        ConfigurationConstants$TraceEventCountBackground configurationConstants$TraceEventCountBackground;
        synchronized (ConfigurationConstants$TraceEventCountBackground.class) {
            if (f16673a == null) {
                f16673a = new ConfigurationConstants$TraceEventCountBackground();
            }
            configurationConstants$TraceEventCountBackground = f16673a;
        }
        return configurationConstants$TraceEventCountBackground;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String a() {
        return "com.google.firebase.perf.TraceEventCountBackground";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String c() {
        return "fpr_rl_trace_event_count_bg";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long d() {
        return 30L;
    }
}
