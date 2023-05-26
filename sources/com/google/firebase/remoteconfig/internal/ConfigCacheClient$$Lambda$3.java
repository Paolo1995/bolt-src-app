package com.google.firebase.remoteconfig.internal;

import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
final /* synthetic */ class ConfigCacheClient$$Lambda$3 implements Callable {

    /* renamed from: f  reason: collision with root package name */
    private final ConfigStorageClient f17062f;

    private ConfigCacheClient$$Lambda$3(ConfigStorageClient configStorageClient) {
        this.f17062f = configStorageClient;
    }

    public static Callable a(ConfigStorageClient configStorageClient) {
        return new ConfigCacheClient$$Lambda$3(configStorageClient);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return this.f17062f.d();
    }
}
