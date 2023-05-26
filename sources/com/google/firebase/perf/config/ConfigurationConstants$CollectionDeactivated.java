package com.google.firebase.perf.config;

/* loaded from: classes3.dex */
public final class ConfigurationConstants$CollectionDeactivated extends ConfigurationFlag<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    private static ConfigurationConstants$CollectionDeactivated f16657a;

    private ConfigurationConstants$CollectionDeactivated() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized ConfigurationConstants$CollectionDeactivated e() {
        ConfigurationConstants$CollectionDeactivated configurationConstants$CollectionDeactivated;
        synchronized (ConfigurationConstants$CollectionDeactivated.class) {
            if (f16657a == null) {
                f16657a = new ConfigurationConstants$CollectionDeactivated();
            }
            configurationConstants$CollectionDeactivated = f16657a;
        }
        return configurationConstants$CollectionDeactivated;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String b() {
        return "firebase_performance_collection_deactivated";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Boolean d() {
        return Boolean.FALSE;
    }
}
