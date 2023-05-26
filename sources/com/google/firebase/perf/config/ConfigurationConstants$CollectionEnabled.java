package com.google.firebase.perf.config;

/* loaded from: classes3.dex */
public final class ConfigurationConstants$CollectionEnabled extends ConfigurationFlag<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    private static ConfigurationConstants$CollectionEnabled f16658a;

    private ConfigurationConstants$CollectionEnabled() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized ConfigurationConstants$CollectionEnabled d() {
        ConfigurationConstants$CollectionEnabled configurationConstants$CollectionEnabled;
        synchronized (ConfigurationConstants$CollectionEnabled.class) {
            if (f16658a == null) {
                f16658a = new ConfigurationConstants$CollectionEnabled();
            }
            configurationConstants$CollectionEnabled = f16658a;
        }
        return configurationConstants$CollectionEnabled;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String a() {
        return "isEnabled";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String b() {
        return "firebase_performance_collection_enabled";
    }
}
