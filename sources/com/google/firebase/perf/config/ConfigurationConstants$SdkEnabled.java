package com.google.firebase.perf.config;

/* loaded from: classes3.dex */
public final class ConfigurationConstants$SdkEnabled extends ConfigurationFlag<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    private static ConfigurationConstants$SdkEnabled f16666a;

    protected ConfigurationConstants$SdkEnabled() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized ConfigurationConstants$SdkEnabled e() {
        ConfigurationConstants$SdkEnabled configurationConstants$SdkEnabled;
        synchronized (ConfigurationConstants$SdkEnabled.class) {
            if (f16666a == null) {
                f16666a = new ConfigurationConstants$SdkEnabled();
            }
            configurationConstants$SdkEnabled = f16666a;
        }
        return configurationConstants$SdkEnabled;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String a() {
        return "com.google.firebase.perf.SdkEnabled";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String c() {
        return "fpr_enabled";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Boolean d() {
        return Boolean.TRUE;
    }
}
