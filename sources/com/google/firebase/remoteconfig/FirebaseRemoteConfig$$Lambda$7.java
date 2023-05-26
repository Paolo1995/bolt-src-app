package com.google.firebase.remoteconfig;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class FirebaseRemoteConfig$$Lambda$7 implements Callable {

    /* renamed from: f  reason: collision with root package name */
    private final FirebaseRemoteConfig f17029f;

    /* renamed from: g  reason: collision with root package name */
    private final FirebaseRemoteConfigSettings f17030g;

    private FirebaseRemoteConfig$$Lambda$7(FirebaseRemoteConfig firebaseRemoteConfig, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.f17029f = firebaseRemoteConfig;
        this.f17030g = firebaseRemoteConfigSettings;
    }

    public static Callable a(FirebaseRemoteConfig firebaseRemoteConfig, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        return new FirebaseRemoteConfig$$Lambda$7(firebaseRemoteConfig, firebaseRemoteConfigSettings);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return FirebaseRemoteConfig.m(this.f17029f, this.f17030g);
    }
}
