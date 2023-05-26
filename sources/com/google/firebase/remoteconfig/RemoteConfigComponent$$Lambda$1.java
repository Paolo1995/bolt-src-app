package com.google.firebase.remoteconfig;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class RemoteConfigComponent$$Lambda$1 implements Callable {

    /* renamed from: f  reason: collision with root package name */
    private final RemoteConfigComponent f17049f;

    private RemoteConfigComponent$$Lambda$1(RemoteConfigComponent remoteConfigComponent) {
        this.f17049f = remoteConfigComponent;
    }

    public static Callable a(RemoteConfigComponent remoteConfigComponent) {
        return new RemoteConfigComponent$$Lambda$1(remoteConfigComponent);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return this.f17049f.d();
    }
}
