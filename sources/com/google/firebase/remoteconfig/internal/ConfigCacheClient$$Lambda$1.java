package com.google.firebase.remoteconfig.internal;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class ConfigCacheClient$$Lambda$1 implements Callable {

    /* renamed from: f  reason: collision with root package name */
    private final ConfigCacheClient f17057f;

    /* renamed from: g  reason: collision with root package name */
    private final ConfigContainer f17058g;

    private ConfigCacheClient$$Lambda$1(ConfigCacheClient configCacheClient, ConfigContainer configContainer) {
        this.f17057f = configCacheClient;
        this.f17058g = configContainer;
    }

    public static Callable a(ConfigCacheClient configCacheClient, ConfigContainer configContainer) {
        return new ConfigCacheClient$$Lambda$1(configCacheClient, configContainer);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        Void e8;
        e8 = this.f17057f.f17055b.e(this.f17058g);
        return e8;
    }
}
