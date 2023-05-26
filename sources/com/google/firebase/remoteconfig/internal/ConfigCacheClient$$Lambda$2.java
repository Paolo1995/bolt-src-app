package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class ConfigCacheClient$$Lambda$2 implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    private final ConfigCacheClient f17059a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17060b;

    /* renamed from: c  reason: collision with root package name */
    private final ConfigContainer f17061c;

    private ConfigCacheClient$$Lambda$2(ConfigCacheClient configCacheClient, boolean z7, ConfigContainer configContainer) {
        this.f17059a = configCacheClient;
        this.f17060b = z7;
        this.f17061c = configContainer;
    }

    public static SuccessContinuation a(ConfigCacheClient configCacheClient, boolean z7, ConfigContainer configContainer) {
        return new ConfigCacheClient$$Lambda$2(configCacheClient, z7, configContainer);
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public Task then(Object obj) {
        return ConfigCacheClient.h(this.f17059a, this.f17060b, this.f17061c, (Void) obj);
    }
}
