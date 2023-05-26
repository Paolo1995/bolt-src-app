package com.google.firebase.remoteconfig.internal;

import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
final /* synthetic */ class ConfigCacheClient$$Lambda$4 implements Executor {

    /* renamed from: f  reason: collision with root package name */
    private static final ConfigCacheClient$$Lambda$4 f17063f = new ConfigCacheClient$$Lambda$4();

    private ConfigCacheClient$$Lambda$4() {
    }

    public static Executor a() {
        return f17063f;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
