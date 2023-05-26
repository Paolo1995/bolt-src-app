package com.google.firebase.perf.config;

/* loaded from: classes3.dex */
public final class ConfigurationConstants$SdkDisabledVersions extends ConfigurationFlag<String> {

    /* renamed from: a  reason: collision with root package name */
    private static ConfigurationConstants$SdkDisabledVersions f16665a;

    protected ConfigurationConstants$SdkDisabledVersions() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized ConfigurationConstants$SdkDisabledVersions e() {
        ConfigurationConstants$SdkDisabledVersions configurationConstants$SdkDisabledVersions;
        synchronized (ConfigurationConstants$SdkDisabledVersions.class) {
            if (f16665a == null) {
                f16665a = new ConfigurationConstants$SdkDisabledVersions();
            }
            configurationConstants$SdkDisabledVersions = f16665a;
        }
        return configurationConstants$SdkDisabledVersions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String a() {
        return "com.google.firebase.perf.SdkDisabledVersions";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String c() {
        return "fpr_disabled_android_versions";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String d() {
        return "";
    }
}
