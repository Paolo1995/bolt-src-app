package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class FirebaseRemoteConfig$$Lambda$3 implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseRemoteConfig f17024a;

    private FirebaseRemoteConfig$$Lambda$3(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.f17024a = firebaseRemoteConfig;
    }

    public static SuccessContinuation a(FirebaseRemoteConfig firebaseRemoteConfig) {
        return new FirebaseRemoteConfig$$Lambda$3(firebaseRemoteConfig);
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public Task then(Object obj) {
        Task b8;
        Void r22 = (Void) obj;
        b8 = this.f17024a.b();
        return b8;
    }
}
