package com.google.firebase.perf.config;

/* loaded from: classes3.dex */
public final class ConfigurationConstants$RateLimitSec extends ConfigurationFlag<Long> {

    /* renamed from: a  reason: collision with root package name */
    private static ConfigurationConstants$RateLimitSec f16664a;

    private ConfigurationConstants$RateLimitSec() {
    }

    public static synchronized ConfigurationConstants$RateLimitSec e() {
        ConfigurationConstants$RateLimitSec configurationConstants$RateLimitSec;
        synchronized (ConfigurationConstants$RateLimitSec.class) {
            if (f16664a == null) {
                f16664a = new ConfigurationConstants$RateLimitSec();
            }
            configurationConstants$RateLimitSec = f16664a;
        }
        return configurationConstants$RateLimitSec;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String a() {
        return "com.google.firebase.perf.TimeLimitSec";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String c() {
        return "fpr_rl_time_limit_sec";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long d() {
        return 600L;
    }
}
