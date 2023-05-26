package com.google.firebase.perf.config;

/* loaded from: classes3.dex */
public final class ConfigurationConstants$TraceEventCountForeground extends ConfigurationFlag<Long> {

    /* renamed from: a  reason: collision with root package name */
    private static ConfigurationConstants$TraceEventCountForeground f16674a;

    private ConfigurationConstants$TraceEventCountForeground() {
    }

    public static synchronized ConfigurationConstants$TraceEventCountForeground e() {
        ConfigurationConstants$TraceEventCountForeground configurationConstants$TraceEventCountForeground;
        synchronized (ConfigurationConstants$TraceEventCountForeground.class) {
            if (f16674a == null) {
                f16674a = new ConfigurationConstants$TraceEventCountForeground();
            }
            configurationConstants$TraceEventCountForeground = f16674a;
        }
        return configurationConstants$TraceEventCountForeground;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String a() {
        return "com.google.firebase.perf.TraceEventCountForeground";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String c() {
        return "fpr_rl_trace_event_count_fg";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long d() {
        return 300L;
    }
}
