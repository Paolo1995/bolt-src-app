package com.google.firebase.perf.config;

/* loaded from: classes3.dex */
public final class ConfigurationConstants$NetworkEventCountBackground extends ConfigurationFlag<Long> {

    /* renamed from: a  reason: collision with root package name */
    private static ConfigurationConstants$NetworkEventCountBackground f16661a;

    private ConfigurationConstants$NetworkEventCountBackground() {
    }

    public static synchronized ConfigurationConstants$NetworkEventCountBackground e() {
        ConfigurationConstants$NetworkEventCountBackground configurationConstants$NetworkEventCountBackground;
        synchronized (ConfigurationConstants$NetworkEventCountBackground.class) {
            if (f16661a == null) {
                f16661a = new ConfigurationConstants$NetworkEventCountBackground();
            }
            configurationConstants$NetworkEventCountBackground = f16661a;
        }
        return configurationConstants$NetworkEventCountBackground;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String a() {
        return "com.google.firebase.perf.NetworkEventCountBackground";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String c() {
        return "fpr_rl_network_event_count_bg";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long d() {
        return 70L;
    }
}
