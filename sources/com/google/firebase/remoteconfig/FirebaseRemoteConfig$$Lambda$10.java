package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class FirebaseRemoteConfig$$Lambda$10 implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseRemoteConfig f17023a;

    private FirebaseRemoteConfig$$Lambda$10(FirebaseRemoteConfig firebaseRemoteConfig) {
        this.f17023a = firebaseRemoteConfig;
    }

    public static Continuation a(FirebaseRemoteConfig firebaseRemoteConfig) {
        return new FirebaseRemoteConfig$$Lambda$10(firebaseRemoteConfig);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        boolean o8;
        o8 = this.f17023a.o(task);
        return Boolean.valueOf(o8);
    }
}
