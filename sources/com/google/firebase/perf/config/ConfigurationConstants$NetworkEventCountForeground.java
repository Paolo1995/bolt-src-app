package com.google.firebase.perf.config;

/* loaded from: classes3.dex */
public final class ConfigurationConstants$NetworkEventCountForeground extends ConfigurationFlag<Long> {

    /* renamed from: a  reason: collision with root package name */
    private static ConfigurationConstants$NetworkEventCountForeground f16662a;

    private ConfigurationConstants$NetworkEventCountForeground() {
    }

    public static synchronized ConfigurationConstants$NetworkEventCountForeground e() {
        ConfigurationConstants$NetworkEventCountForeground configurationConstants$NetworkEventCountForeground;
        synchronized (ConfigurationConstants$NetworkEventCountForeground.class) {
            if (f16662a == null) {
                f16662a = new ConfigurationConstants$NetworkEventCountForeground();
            }
            configurationConstants$NetworkEventCountForeground = f16662a;
        }
        return configurationConstants$NetworkEventCountForeground;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String a() {
        return "com.google.firebase.perf.NetworkEventCountForeground";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String c() {
        return "fpr_rl_network_event_count_fg";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long d() {
        return 700L;
    }
}
