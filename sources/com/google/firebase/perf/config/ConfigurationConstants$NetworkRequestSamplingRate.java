package com.google.firebase.perf.config;

/* loaded from: classes3.dex */
public final class ConfigurationConstants$NetworkRequestSamplingRate extends ConfigurationFlag<Float> {

    /* renamed from: a  reason: collision with root package name */
    private static ConfigurationConstants$NetworkRequestSamplingRate f16663a;

    private ConfigurationConstants$NetworkRequestSamplingRate() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized ConfigurationConstants$NetworkRequestSamplingRate e() {
        ConfigurationConstants$NetworkRequestSamplingRate configurationConstants$NetworkRequestSamplingRate;
        synchronized (ConfigurationConstants$NetworkRequestSamplingRate.class) {
            if (f16663a == null) {
                f16663a = new ConfigurationConstants$NetworkRequestSamplingRate();
            }
            configurationConstants$NetworkRequestSamplingRate = f16663a;
        }
        return configurationConstants$NetworkRequestSamplingRate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String a() {
        return "com.google.firebase.perf.NetworkRequestSamplingRate";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String c() {
        return "fpr_vc_network_request_sampling_rate";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Float d() {
        return Float.valueOf(1.0f);
    }
}
