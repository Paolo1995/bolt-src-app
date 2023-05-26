package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class ConfigFetchHandler$$Lambda$1 implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    private final ConfigFetchHandler f17086a;

    /* renamed from: b  reason: collision with root package name */
    private final long f17087b;

    private ConfigFetchHandler$$Lambda$1(ConfigFetchHandler configFetchHandler, long j8) {
        this.f17086a = configFetchHandler;
        this.f17087b = j8;
    }

    public static Continuation a(ConfigFetchHandler configFetchHandler, long j8) {
        return new ConfigFetchHandler$$Lambda$1(configFetchHandler, j8);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        Task h8;
        h8 = this.f17086a.h(task, this.f17087b);
        return h8;
    }
}
