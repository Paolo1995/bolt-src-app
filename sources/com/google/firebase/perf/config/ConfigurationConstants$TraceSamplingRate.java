package com.google.firebase.perf.config;

/* loaded from: classes3.dex */
public final class ConfigurationConstants$TraceSamplingRate extends ConfigurationFlag<Float> {

    /* renamed from: a  reason: collision with root package name */
    private static ConfigurationConstants$TraceSamplingRate f16675a;

    private ConfigurationConstants$TraceSamplingRate() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized ConfigurationConstants$TraceSamplingRate e() {
        ConfigurationConstants$TraceSamplingRate configurationConstants$TraceSamplingRate;
        synchronized (ConfigurationConstants$TraceSamplingRate.class) {
            if (f16675a == null) {
                f16675a = new ConfigurationConstants$TraceSamplingRate();
            }
            configurationConstants$TraceSamplingRate = f16675a;
        }
        return configurationConstants$TraceSamplingRate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String a() {
        return "com.google.firebase.perf.TraceSamplingRate";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String c() {
        return "fpr_vc_trace_sampling_rate";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Float d() {
        return Float.valueOf(1.0f);
    }
}
